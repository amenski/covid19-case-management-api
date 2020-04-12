package et.covid19.rest.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.IDailyCaseStatus;
import et.covid19.rest.swagger.api.DailyStatusApi;
import et.covid19.rest.swagger.model.ModelDailyCaseStatus;
import et.covid19.rest.swagger.model.ModelDailyCaseStatusList;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseDailyCaseStatus;
import et.covid19.rest.swagger.model.ResponseDailyCaseStatusList;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
public class DailyStatusController extends AbstractController implements DailyStatusApi {

	@Autowired
	private IDailyCaseStatus dailyCaseService;
	
	@Override
	@EthLoggable
	public ResponseEntity<ResponseDailyCaseStatus> getDailyStatus(
			@ApiParam(value = "") @Valid @RequestParam(value = "reportingDate", required = false) LocalDate reportingDate) {
		Class<ResponseDailyCaseStatus> responseClass = ResponseDailyCaseStatus.class;
		ResponseDailyCaseStatus response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelDailyCaseStatus stat = dailyCaseService.getDailyCaseStatus(reportingDate);
			response = fillSuccessResponse(new ResponseDailyCaseStatus().returnValue(stat));
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
	public ResponseEntity<ResponseDailyCaseStatusList> getAllDailyStatus() {
		Class<ResponseDailyCaseStatusList> responseClass = ResponseDailyCaseStatusList.class;
		ResponseDailyCaseStatusList response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			ModelDailyCaseStatusList stat = dailyCaseService.getAllDailyCaseStatus();
			response = fillSuccessResponse(new ResponseDailyCaseStatusList().returnValue(stat));
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
	public ResponseEntity<ResponseBase> addDailyStatus(
			@ApiParam(value = "" ,required=true )  @Valid @RequestBody ModelDailyCaseStatus body) 
	{
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			dailyCaseService.addDailyStatus(body);
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
