package et.covid19.rest.services.impl;

import java.util.ArrayList;
import java.util.List;

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
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.PuiCaseFolowUpMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseFollowUpServiceImpl extends AbstractService implements ICaseFollowUpService {
	
	@Autowired
	private CaseFollowUpRepository  caseFollowUpRepository;
	
	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean addCaseFollowUpQuestionnier(String code, @Valid RequestSaveFollowUp body) throws EthException {
		try{
		    if(StringUtils.isBlank(code) || body.getList().isEmpty())
		        return false;
		        
			PuiInfo pui = puiInfoRepository.findByCaseCode(code);
			if(pui == null)
				throw EthExceptionEnums.CASE_NOT_FOUND.get();
			
			//collect questionnaires and validate
			List<PuiFollowUp> followupQuestionnaireList = new ArrayList<>();
			List<Integer> allIds = new ArrayList<>();
			final String userId = getCurrentLoggedInUserId();
			
			for(ModelPuiFollowUp modelFollowUp : body.getList()) {
				PuiFollowUp puiFollowup = PuiCaseFolowUpMapper.INSTANCE.modelFollowupToEntityMapper(modelFollowUp); //question is mapped here, only Qid is set 
				Questionier questionnaire = puiFollowup.getQuestionier();
				if(questionnaire == null || questionnaire.getId() == null) 
				    throw EthExceptionEnums.INVALID_OPTION_OR_QUESTION_ID.get();
				
				if(!StringUtils.isBlank(puiFollowup.getOptionSelected()) && !allIds.contains(questionnaire.getId())) { //skip duplicates checking allIds
					puiFollowup.setPuiInfo(pui);
					puiFollowup.setModifiedBy(userId);
					followupQuestionnaireList.add(puiFollowup);
					allIds.add(questionnaire.getId());
				}
			}
			
			if(body.getList().size() != followupQuestionnaireList.size())
				throw EthExceptionEnums.INVALID_OPTION_OR_QUESTION_ID.get();
			
			caseFollowUpRepository.saveAll(followupQuestionnaireList);
			return true;
		} catch(ConstraintViolationException | DataIntegrityViolationException e) {
			throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public ModelPuiFollowUp getFollowUpData(String caseCode) throws EthException {
		try {
			PuiFollowUp followup = caseFollowUpRepository.findWithPuiCaseCode(caseCode);
			if(followup == null)
				throw EthExceptionEnums.CASE_NOT_FOUND.get();
			
			
			ModelPuiFollowUp fup = PuiCaseFolowUpMapper.INSTANCE.entityToModelFollowupMapper(followup);
			fup.setQuestion(followup.getQuestionier().getQuestion());
			
			return fup;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
