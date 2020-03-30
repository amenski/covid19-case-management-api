package et.covid19.rest.services.auth;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import et.covid19.rest.dal.model.User;
import et.covid19.rest.dal.model.security.UserPrincipal;
import et.covid19.rest.dal.repositories.UserRepository;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDetailserviceImpl implements UserDetailsService {
    
	@Autowired
	private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(email);
        if(user==null){
            throw new UsernameNotFoundException("User " + email + " not found");
        }
        return new UserPrincipal(
        		user.getUsername(),
        		user.getPassword(), 
        		user.getEnabled(), 
        		user.getAccountNonExpired(), 
        		true,
        		user.getAccountNonLocked(),
        		user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
					.collect(Collectors.toList()));
    }
}
