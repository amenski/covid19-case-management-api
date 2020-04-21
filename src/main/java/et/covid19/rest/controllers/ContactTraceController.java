package et.covid19.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.services.IContactTracingService;
import et.covid19.rest.swagger.api.ContactTracingApi;
import et.covid19.rest.swagger.model.ResponseContactTracing;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
public class ContactTraceController extends AbstractController implements ContactTracingApi {

	@Autowired
	private IContactTracingService contactTraceService;
	
	@Override
	@EthLoggable
	@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_HEALTH_OFFICER')")
	public ResponseEntity<ResponseContactTracing> contactTraceByCaseCode(
			@ApiParam(value = "",required=true) @PathVariable("code") String code) {
		Class<ResponseContactTracing> responseClass = ResponseContactTracing.class;
		ResponseContactTracing response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			String json = contactTraceService.traceContactByCode(code);
			response = fillSuccessResponse(new ResponseContactTracing().returnValue(json));
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
