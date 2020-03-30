package et.covid19.rest.services.impl;

import et.covid19.rest.dal.repositories.UserRepository;
import et.covid19.rest.dal.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class AuthenticationServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User "+email+" not found");
        }
        return user;
    }
}
