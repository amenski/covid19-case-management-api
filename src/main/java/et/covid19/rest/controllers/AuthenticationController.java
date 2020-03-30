package et.covid19.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.auth.AuthenticationServiceImpl;
import et.covid19.rest.swagger.api.AuthenticateApi;
import et.covid19.rest.swagger.model.JwtRequest;
import et.covid19.rest.swagger.model.JwtResponse;
import et.covid19.rest.util.exception.EthExceptionEnums;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthenticationController extends AbstractController implements AuthenticateApi {

	@Autowired
	private AuthenticationServiceImpl authenticationService;
	
    @Override
    public ResponseEntity<JwtResponse> authenticateUser(
    		@ApiParam(value = ""  )  @Valid @RequestBody JwtRequest jwtRequest) 
    {
		Class<JwtResponse> responseClass = JwtResponse.class;
		JwtResponse response = null;
		HttpStatus status = HttpStatus.OK;
    	try{
	        final String token = authenticationService.generateJwtToken(jwtRequest.getEmail(), jwtRequest.getPassword());
	        response = fillSuccessResponse(new JwtResponse().jwtToken(token));
    	} catch(AuthenticationException ex){
			status = HttpStatus.UNAUTHORIZED;
			response = fillFailResponseEthException(responseClass, EthExceptionEnums.USERNAME_OR_EMAIL_INCORECT.get());
    	}catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
    }
}
