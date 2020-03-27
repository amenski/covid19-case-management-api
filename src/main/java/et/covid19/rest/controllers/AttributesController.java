package et.covid19.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.IAttributeService;
import et.covid19.rest.swagger.api.AttributesApi;
import et.covid19.rest.swagger.model.ModelAttributeList;
import et.covid19.rest.swagger.model.ResponseAttributesList;
import et.covid19.rest.util.exception.EthException;

@RestController
public class AttributesController extends AbstractController implements AttributesApi {

	@Autowired
	private IAttributeService attributeService;
	
	@Override
	@EthLoggable
	public ResponseEntity<ResponseAttributesList> getAttributes() {
		Class<ResponseAttributesList> responseClass = ResponseAttributesList.class;
		ResponseAttributesList response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelAttributeList attrList = attributeService.getAttributeList();
			response = fillSuccessResponse(new ResponseAttributesList().returnValue(attrList));
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
