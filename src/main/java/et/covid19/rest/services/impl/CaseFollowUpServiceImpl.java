package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableSet;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.PuiFollowUp;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.dal.model.Questionier;
import et.covid19.rest.dal.repositories.CaseFollowUpRepository;
import et.covid19.rest.services.ICaseFollowUpService;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.LogConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.ModelCasePuiInfoMapper;
import et.covid19.rest.util.mappers.PuiCaseFolowUpMapper;

@Service
public class CaseFollowUpServiceImpl extends AbstractService implements ICaseFollowUpService {
	
	@Autowired
	private CaseFollowUpRepository  caseFollowUpRepository;
	
	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean addCaseFollowUpQuestionnier(@Valid RequestSaveFollowUp body) throws EthException {
		try{
			PuiInfo pui = ModelCasePuiInfoMapper.INSTANCE.modelFollowupToPuiInfoMapper(body);
			if(pui == null)
				throw EthExceptionEnums.VALIDATION_EXCEPTION.get().message("PUI information may have errors, please try again.");
			
			if(!caseExists(body.getParentCaseCode()))
				throw EthExceptionEnums.CASE_NOT_FOUND.get().message("Parent case not found.");
				
			//collect questionnaires and validate
			List<PuiFollowUp> questionnierList = new ArrayList<>();
			body.getList().stream().forEach(questionnier -> {
				PuiFollowUp qa = PuiCaseFolowUpMapper.INSTANCE.modelFollowupToEntityMapper(questionnier);
				if(!StringUtils.isAnyBlank(qa.getOptionSelected()) && qa.getQuestionierId() != null) {
					questionnierList.add(qa);
				}
			});
			
			if(body.getList().size() != questionnierList.size())
				throw EthExceptionEnums.INVALID_OPTION_OR_QUESTION_ID.get();
			
			List<Questionier> questioniers = questionnierRepository.findAllById(questionnierList.stream().map(PuiFollowUp::getQuestionierId).collect(Collectors.toList()));
			//List<PuiInfo> puiInfos = puiInfoRepository.findAllByCaseCode(questionnierList.stream().map(PuiFollowUp::getPuiCaseCode).collect(Collectors.toList()));
			
			if(questioniers.isEmpty() || (questioniers.size() < body.getList().size()))
				throw EthExceptionEnums.INVALID_OPTION_OR_QUESTION_ID.get();
			
			String caseCode = saveAndGetCaseCode(pui);
			for(PuiFollowUp followUp : questionnierList) {
				followUp.setPuiCaseCode(caseCode);
			}
			
			caseFollowUpRepository.saveAll(questionnierList);
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

	private String saveAndGetCaseCode(PuiInfo entity) throws EthException {
		OffsetDateTime timeNow = OffsetDateTime.now();
		validateInputEnumById(EthConstants.CONST_TYPE_TEST_RESULT, ImmutableSet.of(entity.getPresumptiveResult(), entity.getConfirmedResult()));
		validateInputEnumById(EthConstants.CONST_TYPE_IDENTIFIED_BY, ImmutableSet.of(entity.getIdentifiedBy()));

		if(entity.getReportingDate() == null) {
			entity.setReportingDate(timeNow);
		}
		entity.setCaseCode(MDC.get(LogConstants.UUID_KEY));
		entity.setModifiedDate(timeNow);
		puiInfoRepository.save(entity);
		
		return entity.getCaseCode();
	}
}
