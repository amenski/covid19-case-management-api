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
import et.covid19.rest.swagger.api.QuestionnierApi;
import et.covid19.rest.swagger.model.ModelQuestionnier;
import et.covid19.rest.swagger.model.RequestSaveQuestionnier;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseQuestionnierSingle;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuestionnierController extends AbstractController implements QuestionnierApi {

	@Autowired
	private IQuestionnierService questionnierService;
	
	// -- /v1/questionnier/{id}"
	@Override
	@EthLoggable
	public ResponseEntity<ResponseQuestionnierSingle> getQuestionnier(
			@ApiParam(value = "",required=true) @PathVariable("id") Integer id) 
	{
		Class<ResponseQuestionnierSingle> responseClass = ResponseQuestionnierSingle.class;
		ResponseQuestionnierSingle response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelQuestionnier quest = questionnierService.getQuestionnier(id);
			response = fillSuccessResponse(new ResponseQuestionnierSingle().returnValue(quest));
		} catch(EthException ex) {
			status = ex.getHttpCode();
			response = fillFailResponseEthException(responseClass, ex);
		} catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
	}

	// --/v1/questionnier
	@Override
	@EthLoggable
	public ResponseEntity<ResponseBase> registerNewQuestionnier(
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveQuestionnier qData) {
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

}
