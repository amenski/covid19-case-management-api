package et.covid19.rest.controllers;

import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.IHealthFacilityService;
import et.covid19.rest.swagger.api.HealthFacilityApi;
import et.covid19.rest.swagger.model.RequestSaveFacility;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.util.exception.EthException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HealthFacilityController extends AbstractController implements HealthFacilityApi {

    final IHealthFacilityService healthFacilityService;

    public HealthFacilityController(IHealthFacilityService healthFacilityService) {
        this.healthFacilityService = healthFacilityService;
    }

    @Override
    public ResponseEntity<ResponseBase> registerNewFacility(@Valid RequestSaveFacility facilityData) {
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
}
