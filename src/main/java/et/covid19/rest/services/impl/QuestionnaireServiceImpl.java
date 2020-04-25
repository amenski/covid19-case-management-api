package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableSet;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.model.Questionier;
import et.covid19.rest.services.IQuestionnierService;
import et.covid19.rest.swagger.model.ModelEnumIdValue;
import et.covid19.rest.swagger.model.ModelQuestionnaire;
import et.covid19.rest.swagger.model.ModelQuestionnaireList;
import et.covid19.rest.swagger.model.RequestSaveQuestionnaire;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.QuestionnaireMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuestionnaireServiceImpl extends AbstractService implements IQuestionnierService {
	
	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean registerQuestionnier(RequestSaveQuestionnaire question) throws EthException {
		try{
		    Questionier entity = buildQuestionnaire(null, question);
		    
		    OffsetDateTime now = OffsetDateTime.now();
	        entity.setCreatedDate(now);
	        entity.setModifiedDate(now);
	        
			questionnierRepository.save(entity);
			return true;
		} catch(ConstraintViolationException | DataIntegrityViolationException e) {
			throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public ModelQuestionnaire getQuestionnaire(Integer id) throws EthException {
		try {
			Questionier info = questionnierRepository.findById(id).orElseThrow(EthExceptionEnums.QUESTIONNIER_NOT_FOUND);
			if(info == null)
				throw EthExceptionEnums.QUESTIONNIER_NOT_FOUND.get();
			
			return QuestionnaireMapper.INSTANCE.entityToModelQuestionnaireMapper(info);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public ModelQuestionnaireList getAllQuestionnaire() throws EthException {
		try {
			ModelQuestionnaireList list = new ModelQuestionnaireList();
			List<Questionier> questionList = questionnierRepository.findAll();
			questionList.stream().forEach(q -> {
				list.addQuestionsItem(QuestionnaireMapper.INSTANCE.entityToModelQuestionnaireMapper(q));
			});
			return list;
		} catch (Exception ex) {
			throw ex;
		}
	}

    @Override
    @EthLoggable
    public boolean editQuestionnaire(Integer id, RequestSaveQuestionnaire question) throws EthException {
        try{
            if(id == null || Integer.signum(id) != 1)
                throw EthExceptionEnums.VALIDATION_EXCEPTION.get().message("Invalid Questionnaire id value.");
            
            if(!questionnierRepository.existsById(id))
                throw EthExceptionEnums.QUESTIONNIER_NOT_FOUND.get();
            
            Questionier entity = buildQuestionnaire(id, question);
            entity.setModifiedDate(OffsetDateTime.now());
            
            questionnierRepository.save(entity);
            return true;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }
	
	private List<String> getDistinctQuestionOptions(List<String> options) {
	    if(options == null || options.isEmpty())
	        return new ArrayList<>();
	    
	    return options.stream().map(String::toLowerCase).distinct().collect(Collectors.toList());
	}

    @EthLoggable
	private Questionier buildQuestionnaire(Integer id, RequestSaveQuestionnaire question) throws EthException {
	    
	    if(StringUtils.isBlank(question.getQuestion()))
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get().message("Question string missing.");
        
        List<String> distinctOptions = getDistinctQuestionOptions(question.getOptions());
        if(distinctOptions.isEmpty())
            throw EthExceptionEnums.QUESTION_OPTIONS_EMPTY_EXCEPTION.get();
        
        Integer catId = Optional.ofNullable(question.getCategory()).map(ModelEnumIdValue::getId).orElseThrow(EthExceptionEnums.VALIDATION_EXCEPTION);
        validateInputEnumById(EthConstants.CONST_TYPE_QUESTIONNIER_CAT, ImmutableSet.of(catId));
        
	    Questionier entity = QuestionnaireMapper.INSTANCE.modelQuestionnaireToEntityMapper(question);
	    //update
	    if(id != null) {
	        entity.setId(id);
	    }
        entity.setOptions(distinctOptions);
        entity.setCategory(new ConstantEnum(catId));
        entity.setModifiedBy(getCurrentLoggedInUserId());
        
        return entity;
	}
}
