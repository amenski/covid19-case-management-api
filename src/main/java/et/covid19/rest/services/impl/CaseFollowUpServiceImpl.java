package et.covid19.rest.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;

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
			
			//collect questionnaires
			List<PuiFollowUp> followupQuestionnaireList = new ArrayList<>();
			Map<Integer, String> questAndOptSelectedMap = new HashMap<>();
			List<Integer> uniqueIds = new ArrayList<>();
			final String userId = getCurrentLoggedInUserId();
			
			for(ModelPuiFollowUp modelFollowUp : body.getList()) {
				PuiFollowUp puiFollowup = PuiCaseFolowUpMapper.INSTANCE.modelFollowupToEntityMapper(modelFollowUp); // map only questionId 
				Integer questionnaireId = Optional.ofNullable(puiFollowup.getQuestionier()).map(Questionier::getId).orElse(null);
				
				if(questionnaireId == null) 
				    throw EthExceptionEnums.INVALID_OPTION_OR_QUESTION_ID.get();
				
				if(!StringUtils.isBlank(puiFollowup.getOptionSelected()) && !uniqueIds.contains(questionnaireId)) { //skip duplicates checking allIds
					puiFollowup.setPuiInfo(pui);
					puiFollowup.setModifiedBy(userId);
					followupQuestionnaireList.add(puiFollowup);
					uniqueIds.add(questionnaireId);
					questAndOptSelectedMap.put(questionnaireId, puiFollowup.getOptionSelected());
				}
			}
			// validate
			if(!validateQuestionsAndSelectedOptions(questAndOptSelectedMap))
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
	public ModelPuiFollowUpList getFollowUpData(String caseCode) throws EthException {
		try {
			List<PuiFollowUp> followupQuestionList = caseFollowUpRepository.findWithPuiCaseCode(caseCode);
			if(followupQuestionList == null || followupQuestionList.isEmpty())
				throw EthExceptionEnums.CASE_NOT_FOUND.get();
			
			ModelPuiFollowUpList flList = new ModelPuiFollowUpList();
			for(PuiFollowUp fl : followupQuestionList) {
    			ModelPuiFollowUp fup = PuiCaseFolowUpMapper.INSTANCE.entityToModelFollowupMapper(fl);
    			flList.addListItem(fup);
			}
			return flList;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private boolean validateQuestionsAndSelectedOptions(Map<Integer, String> questAndOptSelectedMap) {
	    String methodName = "validateSelectedOptions()";
	    if(questAndOptSelectedMap == null || questAndOptSelectedMap.isEmpty())
	        return false;
	    
	    Set<Integer> ids = questAndOptSelectedMap.keySet().stream().collect(Collectors.toSet());
        List<Questionier> questionList = questionnierRepository.findByIds(ids);
	    //non existing questions?
	    if(ids.size() != questionList.size()) {
	        Set<Integer> nonExistingKeys = Sets.difference(ids, questionList.stream().map(Questionier::getId).collect(Collectors.toSet()));
	        logger.error("{} [non existing question ids: {}]", methodName, nonExistingKeys);
	        return false;
	    }
	    //invalid option?
	    for(Questionier question : questionList) {
	        String selected = questAndOptSelectedMap.get(question.getId());
	        boolean anyMatch = question.getOptions().stream().anyMatch(selected::equalsIgnoreCase);
            if(!anyMatch) {
	            logger.info("{} option: [{}] does not exist for question [id: {}].", methodName, selected, question.getId());
                return false;
            }
	    }
	    return true;
	}
}
