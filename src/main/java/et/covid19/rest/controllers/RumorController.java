package et.covid19.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.services.IRumorService;
import et.covid19.rest.swagger.api.RumorApi;
import et.covid19.rest.swagger.model.ModelRumorList;
import et.covid19.rest.swagger.model.RequestSaveRumor;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseRumorList;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RumorController extends AbstractController implements RumorApi {

    @Autowired
    private IRumorService rumorService;
    
    @Override
    @EthLoggable
    public ResponseEntity<ResponseBase> registerNewRumor(
            @ApiParam(value = ""  )  @Valid @RequestBody RequestSaveRumor rumorData)
    {
        Class<ResponseBase> responseClass = ResponseBase.class;
        ResponseBase response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            rumorService.registerRumor(rumorData);
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
    public ResponseEntity<ResponseRumorList> getAllRumors() {
        Class<ResponseRumorList> responseClass = ResponseRumorList.class;
        ResponseRumorList response = null;
        HttpStatus status = HttpStatus.OK;
        try{
            ModelRumorList list = rumorService.getAllRumorReports();
            response = fillSuccessResponse(new ResponseRumorList().returnValue(list));
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
