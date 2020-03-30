package et.covid19.rest.services.auth;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.config.JwtTokenUtil;
import et.covid19.rest.dal.model.security.UserPrincipal;
import et.covid19.rest.util.EthConstants;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthenticationServiceImpl {
    
	@Autowired
	private JwtTokenUtil tokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@EthLoggable(exclusions = "password")
	public String generateJwtToken(String name, String password) {
		try {
			if(StringUtils.isAnyBlank(name, password)) {
				return null;
			}
			
			UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
			Authentication authentication = authenticationManager.authenticate(upToken);
			
			String token = tokenUtil.generateToken((UserPrincipal) authentication.getPrincipal());
			String bearerToken = EthConstants.TOKEN_PREFIX + token; 
			return bearerToken;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
