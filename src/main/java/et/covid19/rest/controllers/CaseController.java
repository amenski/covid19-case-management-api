package et.covid19.rest.controllers;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.ICaseService;
import et.covid19.rest.swagger.api.CaseApi;
import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseModelCaseSingle;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseController extends AbstractController implements CaseApi {

	@Autowired
	private ICaseService caseService;
	
	@Override
	@EthLoggable
	public ResponseEntity<ResponseBase> registerNewCase(
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveCase caseData) {
		
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			caseService.registerNewCase(caseData);
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
	public ResponseEntity<ResponseModelCaseSingle> getCase(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "code", required = true) UUID code) 
	{
		Class<ResponseModelCaseSingle> responseClass = ResponseModelCaseSingle.class;
		ResponseModelCaseSingle response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelCase modelCase = caseService.getModelCase(code);
			response = fillSuccessResponse(new ResponseModelCaseSingle().returnValue(modelCase));
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
