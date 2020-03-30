package et.covid19.rest.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.PuiFollowUp;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.dal.model.Questionier;
import et.covid19.rest.dal.repositories.CaseFollowUpRepository;
import et.covid19.rest.services.ICaseFollowUpService;
import et.covid19.rest.swagger.model.ModelPuiFollowUp;
import et.covid19.rest.swagger.model.ModelPuiFollowUpList;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.PuiCaseFolowUpMapper;
import et.covid19.rest.util.mappers.PuiInfoMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseFollowUpServiceImpl extends AbstractService implements ICaseFollowUpService {
	
	@Autowired
	private CaseFollowUpRepository  caseFollowUpRepository;
	
	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean addCaseFollowUpQuestionnier(@Valid RequestSaveFollowUp body) throws EthException {
		try{
			PuiInfo pui = PuiInfoMapper.INSTANCE.modelFollowupToPuiInfoMapper(body);
			if(pui == null)
				throw EthExceptionEnums.VALIDATION_EXCEPTION.get().message("PUI information may have errors, please try again.");
			
			if(!caseExists(body.getParentCaseCode()))
				throw EthExceptionEnums.CASE_NOT_FOUND.get().message("Parent case not found.");
				
			//collect questionnaires and validate
			PuiInfo newPui = saveAndGetPuiInfo(pui);
			List<PuiFollowUp> questionnierList = new ArrayList<>();
			final String userId = getCurrentLoggedInUserId();
			body.getList().stream().forEach(questionnier -> {
				PuiFollowUp followup = PuiCaseFolowUpMapper.INSTANCE.modelFollowupToEntityMapper(questionnier); //quest mapped here
				Questionier questionier = followup.getQuestionier();
				if(!StringUtils.isAnyBlank(followup.getOptionSelected()) && (Objects.nonNull(questionier) && Objects.nonNull(questionier.getId()))) {
					followup.setPuiInfo(newPui);
					followup.setModifiedBy(userId);
					questionnierList.add(followup);
				}
			});
			
			if(body.getList().size() != questionnierList.size())
				throw EthExceptionEnums.INVALID_OPTION_OR_QUESTION_ID.get();
			
			caseFollowUpRepository.saveAll(questionnierList);
			return true;
		} catch(ConstraintViolationException | DataIntegrityViolationException e) {
			throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public ModelPuiFollowUpList getFollowUpData(String caseCode) throws EthException {
		try {
			ModelPuiFollowUpList modeFollup = new ModelPuiFollowUpList();
			List<PuiFollowUp> followupList = caseFollowUpRepository.findWithPuiCaseCode(caseCode.toString());
			if(followupList == null)
				throw EthExceptionEnums.CASE_NOT_FOUND.get();
			
			followupList.stream().forEach(val -> {
				ModelPuiFollowUp fup = PuiCaseFolowUpMapper.INSTANCE.entityToModelFollowupMapper(val);
				fup.setQuestion(val.getQuestionier().getQuestion());
				modeFollup.getList().add(fup);
			});
			return modeFollup;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
