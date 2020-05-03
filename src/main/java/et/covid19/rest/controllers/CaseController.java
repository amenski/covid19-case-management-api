package et.covid19.rest.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.services.ICaseService;
import et.covid19.rest.swagger.api.CaseApi;
import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.ModelCaseList;
import et.covid19.rest.swagger.model.ModelEnumIdValue;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.swagger.model.RequestSearchCase;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseCaseList;
import et.covid19.rest.swagger.model.ResponseCaseSingle;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseController extends AbstractController implements CaseApi {

	@Autowired
	private ICaseService caseService;
	
	// /v1/api/case
	@Override
	@EthLoggable
    @PreAuthorize("hasRole('ROLE_HEALTH_OFFICER')")
	public ResponseEntity<ResponseBase> registerNewCase(
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveCase caseData) {
		
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			String caseCode = caseService.registerNewCase(caseData);
			response = fillSuccessResponse(new ResponseBase().message(caseCode));
		} catch(EthException ex) {
			status = ex.getHttpCode();
			response = fillFailResponseEthException(responseClass, ex);
		} catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
	}

	// /v1/case?code=6220362a-e2ec-4d58-94a8-5764201725d5
	@Override
	@EthLoggable
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_HEALTH_OFFICER')")
	public ResponseEntity<ResponseCaseSingle> getCase(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "code", required = true) String code) 
	{
		Class<ResponseCaseSingle> responseClass = ResponseCaseSingle.class;
		ResponseCaseSingle response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelCase modelCase = caseService.getModelCase(code);
			response = fillSuccessResponse(new ResponseCaseSingle().returnValue(modelCase));
		} catch(EthException ex) {
			status = ex.getHttpCode();
			response = fillFailResponseEthException(responseClass, ex);
		} catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
	}

	// /v1/api/case/{code} - confirmedResult as a body
	@Override
	@EthLoggable
    @PreAuthorize("hasRole('ROLE_HEALTH_OFFICER')")
	public ResponseEntity<ResponseBase> updateResult(
	        @ApiParam(value = "",required=true) @PathVariable("code") String code,
	        @ApiParam(value = ""  )  @Valid @RequestBody ModelEnumIdValue result)
	{
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			caseService.updateResult(code, result.getId());
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
    public ResponseEntity<ResponseCaseList> searchCases(@ApiParam(value = ""  )  @Valid @RequestBody RequestSearchCase criteria) 
    {
        Class<ResponseCaseList> responseClass = ResponseCaseList.class;
        ResponseCaseList response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            ModelCaseList modelCaseList = caseService.searchCase(
                                                criteria.getTestResultId(), 
                                                criteria.getStatusId(), 
                                                criteria.getRegion(), 
                                                criteria.getRecentTravelTo(),
                                                criteria.getPatientName());
            response = fillSuccessResponse(new ResponseCaseList().returnValue(modelCaseList));
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
    public ResponseEntity<ResponseCaseList> getAllCase(
            @ApiParam(value = "") @Valid @RequestParam(value = "page", required = false) Integer page) 
    {
        Class<ResponseCaseList> responseClass = ResponseCaseList.class;
        ResponseCaseList response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            ModelCaseList modelCase = caseService.getAllCases(page);
            response = fillSuccessResponse(new ResponseCaseList().returnValue(modelCase));
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
