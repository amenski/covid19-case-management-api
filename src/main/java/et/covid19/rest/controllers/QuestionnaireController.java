package et.covid19.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.IQuestionnierService;
import et.covid19.rest.swagger.api.QuestionnaireApi;
import et.covid19.rest.swagger.model.ModelQuestionnaire;
import et.covid19.rest.swagger.model.ModelQuestionnaireList;
import et.covid19.rest.swagger.model.RequestSaveQuestionnaire;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseQuestionnaireList;
import et.covid19.rest.swagger.model.ResponseQuestionnaireSingle;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuestionnaireController extends AbstractController implements QuestionnaireApi {

	@Autowired
	private IQuestionnierService questionnierService;
	
	// -- /v1/questionnaire/{id}"
	@Override
	@EthLoggable
	public ResponseEntity<ResponseQuestionnaireSingle> getQuestionnaire(
			@ApiParam(value = "",required=true) @PathVariable("id") Integer id) 
	{
		Class<ResponseQuestionnaireSingle> responseClass = ResponseQuestionnaireSingle.class;
		ResponseQuestionnaireSingle response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelQuestionnaire quest = questionnierService.getQuestionnaire(id);
			response = fillSuccessResponse(new ResponseQuestionnaireSingle().returnValue(quest));
		} catch(EthException ex) {
			status = ex.getHttpCode();
			response = fillFailResponseEthException(responseClass, ex);
		} catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
	}

	// --/v1/questionnaire
	@Override
	@EthLoggable
	public ResponseEntity<ResponseBase> registerNewQuestionnaire(
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveQuestionnaire qData) {
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			questionnierService.registerQuestionnier(qData);
			response = fillSuccessResponse(new ResponseBase());
		} catch(EthException ex) {
			status = ex.getHttpCode();
			response = fillFailResponseEthException(responseClass, ex);
		} catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
	}

	@Override
	@EthLoggable
	public ResponseEntity<ResponseQuestionnaireList> getAllQuestionnaires() {
		Class<ResponseQuestionnaireList> responseClass = ResponseQuestionnaireList.class;
		ResponseQuestionnaireList response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelQuestionnaireList questList = questionnierService.getAllQuestionnaire();
			response = fillSuccessResponse(new ResponseQuestionnaireList().returnValue(questList));
		} catch(EthException ex) {
			status = ex.getHttpCode();
			response = fillFailResponseEthException(responseClass, ex);
		} catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
	}

}
