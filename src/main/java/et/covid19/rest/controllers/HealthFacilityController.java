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
import et.covid19.rest.services.IHealthFacilityService;
import et.covid19.rest.swagger.api.HealthFacilityApi;
import et.covid19.rest.swagger.model.ModelHealthFacility;
import et.covid19.rest.swagger.model.ModelHealthFacilityList;
import et.covid19.rest.swagger.model.RequestSaveFacility;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseHealthFacilityList;
import et.covid19.rest.swagger.model.ResponseHealthFacilitySingle;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HealthFacilityController extends AbstractController implements HealthFacilityApi {

	@Autowired
    private IHealthFacilityService healthFacilityService;

    @Override
    @EthLoggable
    public ResponseEntity<ResponseBase> registerNewFacility(
    		@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveFacility facilityData) 
    {
        Class<ResponseBase> responseClass = ResponseBase.class;
        ResponseBase response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            healthFacilityService.registerNewFacility(facilityData);
            response = fillSuccessResponse(new ResponseBase());
        } catch(EthException ex) {
            status = ex.getHttpCode();
            response = fillFailResponseEthException(responseClass, ex);
        } catch (Exception ex) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = fillFailResponseGeneric(responseClass);
        }

        return new ResponseEntity<ResponseBase>(response, status);
    }

	@Override
    @EthLoggable
	public ResponseEntity<ResponseHealthFacilitySingle> getHealthFacility(
			@ApiParam(value = "",required=true) @PathVariable("id") Integer id) 
	{
		Class<ResponseHealthFacilitySingle> responseClass = ResponseHealthFacilitySingle.class;
		ResponseHealthFacilitySingle response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            ModelHealthFacility model = healthFacilityService.getHealthFacility(id);
            response = fillSuccessResponse(new ResponseHealthFacilitySingle().returnValue(model));
        } catch(EthException ex) {
            status = ex.getHttpCode();
            response = fillFailResponseEthException(responseClass, ex);
        } catch (Exception ex) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = fillFailResponseGeneric(responseClass);
        }

        return new ResponseEntity<ResponseHealthFacilitySingle>(response, status);
	}

	@Override
    @EthLoggable
	public ResponseEntity<ResponseHealthFacilityList> getAllHealthFacility() {
		Class<ResponseHealthFacilityList> responseClass = ResponseHealthFacilityList.class;
		ResponseHealthFacilityList response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            ModelHealthFacilityList list = healthFacilityService.getAllHealthFacility();
            response = fillSuccessResponse(new ResponseHealthFacilityList().returnValue(list));
        } catch(EthException ex) {
            status = ex.getHttpCode();
            response = fillFailResponseEthException(responseClass, ex);
        } catch (Exception ex) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = fillFailResponseGeneric(responseClass);
        }

        return new ResponseEntity<ResponseHealthFacilityList>(response, status);
	}
}
