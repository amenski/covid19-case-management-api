package et.covid19.rest.controllers;

import java.util.UUID;

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
import et.covid19.rest.services.ICaseFollowUpService;
import et.covid19.rest.swagger.api.CaseFollowUpApi;
import et.covid19.rest.swagger.model.ModelPuiFollowUp;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponsePuiFollowUpSingle;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseFollowUpController extends AbstractController implements CaseFollowUpApi {

	@Autowired
	private ICaseFollowUpService caseFollowUpService;
	
	@Override
	@EthLoggable
	public ResponseEntity<ResponseBase> compileFollowUpQuestionnaire(
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveFollowUp body) 
	{
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			caseFollowUpService.addCaseFollowUpQuestionnier(body);
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
	public ResponseEntity<ResponsePuiFollowUpSingle> getCaseFollowUpQuestionnaires(
			@ApiParam(value = "",required=true) @PathVariable("code") UUID code) 
	{
		Class<ResponsePuiFollowUpSingle> responseClass = ResponsePuiFollowUpSingle.class;
		ResponsePuiFollowUpSingle response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelPuiFollowUp quest = caseFollowUpService.getFollowUpData(code.toString());
			response = fillSuccessResponse(new ResponsePuiFollowUpSingle().returnValue(quest));
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
