package et.covid19.rest.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.Questionier;
import et.covid19.rest.services.IQuestionnierService;
import et.covid19.rest.swagger.model.ModelQuestionnaire;
import et.covid19.rest.swagger.model.ModelQuestionnaireList;
import et.covid19.rest.swagger.model.RequestSaveQuestionnaire;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.QuestionnierMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuestionnaireServiceImpl extends AbstractService implements IQuestionnierService {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean registerQuestionnier(RequestSaveQuestionnaire question) throws EthException {
		try{
			if(StringUtils.isAnyBlank(question.getQuestion(), question.getOptions()) || Objects.isNull(question.getCategory()))
				throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
			
			//options() => All possible values of the question as json
			// throws exception on invalid json
			objectMapper.readValue(question.getOptions(), Object.class);
			
			validateInputEnumById(EthConstants.CONST_TYPE_QUESTIONNIER_CAT, ImmutableSet.of(question.getCategory().getId()));
			
			Questionier entity = QuestionnierMapper.INSTANCE.modelQuestionnaireToEntityMapper(question);
			entity.setModifiedBy(getCurrentLoggedInUserId());
			questionnierRepository.save(entity);
			return true;
		} catch(IOException | ConstraintViolationException | DataIntegrityViolationException e) { //JsonMappingException => IOException
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
			
			return QuestionnierMapper.INSTANCE.entityToModelQuestionnaireMapper(info);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public ModelQuestionnaireList getAllQuestionnaire() throws EthException {
		try {
			ModelQuestionnaireList list = new ModelQuestionnaireList();
			List<Questionier> questionList = questionnierRepository.findAll();
			questionList.stream().forEach(q -> {
				list.addQuestionsItem(QuestionnierMapper.INSTANCE.entityToModelQuestionnaireMapper(q));
			});
			return list;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
