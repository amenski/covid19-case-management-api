package et.covid19.rest.controllers;

import et.covid19.rest.config.JwtTokenUtil;
import et.covid19.rest.dal.model.User;
import et.covid19.rest.services.impl.AuthenticationServiceImpl;
import et.covid19.rest.swagger.api.AuthenticateApi;
import et.covid19.rest.swagger.model.JwtRequest;
import et.covid19.rest.swagger.model.JwtResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController implements AuthenticateApi {

    final AuthenticationServiceImpl authenticationService;
    private static final Logger logger = LogManager.getLogger(AuthenticationController.class);
    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(AuthenticationServiceImpl authenticationService, JwtTokenUtil jwtTokenUtil) {
        this.authenticationService = authenticationService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public ResponseEntity<JwtResponse> authenticateUser(@Valid JwtRequest jwtRequest) {
        logger.info("Received1 login request: POST "+jwtRequest.getEmail()+", "+jwtRequest.getPassword());
        final UserDetails userDetails = authenticationService
                .loadUserByUsername(jwtRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        logger.info("Token: "+token+ " sent to User: "+jwtRequest.getEmail());
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setJwtToken(token);
        return ResponseEntity.ok(new JwtResponse());
    }
}
