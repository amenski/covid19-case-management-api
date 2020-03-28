package et.covid19.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.ICaseFollowUpService;
import et.covid19.rest.swagger.api.CaseFollowUpApi;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
public class CaseFollowUpController extends AbstractController implements CaseFollowUpApi {

	@Autowired
	private ICaseFollowUpService caseFollwUpService;
	
	@Override
	@EthLoggable
	public ResponseEntity<ResponseBase> compileFollowUpQuestionnier(
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveFollowUp body) 
	{
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			caseFollwUpService.addCaseFollowUpQuestionnier(body);
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
