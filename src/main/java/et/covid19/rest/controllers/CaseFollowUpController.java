package et.covid19.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.services.ICaseFollowUpService;
import et.covid19.rest.swagger.api.CaseFollowUpApi;
import et.covid19.rest.swagger.model.ModelPuiFollowUpList;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponsePuiFollowUpList;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseFollowUpController extends AbstractController implements CaseFollowUpApi {

	@Autowired
	private ICaseFollowUpService caseFollowUpService;
	
	@Override
	@EthLoggable
    @PreAuthorize("hasRole('ROLE_HEALTH_OFFICER')")
	public ResponseEntity<ResponseBase> compileFollowUpQuestionnaire(
	        @ApiParam(value = "",required=true) @PathVariable("code") String code,
	        @ApiParam(value = "" ,required=true )  @Valid @RequestBody RequestSaveFollowUp body) 
	{
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try {
			caseFollowUpService.addCaseFollowUpQuestionnier(code, body);
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
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_HEALTH_OFFICER')")
	public ResponseEntity<ResponsePuiFollowUpList> getCaseFollowUpQuestionnaires(
			@ApiParam(value = "",required=true) @PathVariable("code") String code) 
	{
		Class<ResponsePuiFollowUpList> responseClass = ResponsePuiFollowUpList.class;
		ResponsePuiFollowUpList response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelPuiFollowUpList list = caseFollowUpService.getFollowUpData(code);
			response = fillSuccessResponse(new ResponsePuiFollowUpList().returnValue(list));
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
