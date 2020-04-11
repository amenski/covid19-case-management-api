package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.EthUser;
import et.covid19.rest.dal.model.security.Role;
import et.covid19.rest.dal.repositories.RoleRepository;
import et.covid19.rest.dal.repositories.UserRepository;
import et.covid19.rest.services.IUserService;
import et.covid19.rest.swagger.model.ModelUser;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.UserMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean registerUser(ModelUser user) throws EthException {
		try{
			EthUser ethuser = UserMapper.INSTANCE.modelToEntity(user);
			if(StringUtils.isAnyEmpty(
					ethuser.getUsername(), 
					ethuser.getPassword(),
					ethuser.getFirstName(),
					ethuser.getLastName()))
				throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
			ethuser.setPassword(encoder.encode(user.getPassword()));
			ethuser.setAccountNonExpired(true);
			ethuser.setAccountNonLocked(true);
			ethuser.setEnabled(true);
			ethuser.setLastAccess(OffsetDateTime.now());
			
			Role defaultRole = roleRepository.findById(EthConstants.ROLE_USER_ID).orElseThrow(EthExceptionEnums.USER_ROLE_NOT_FOUND);
			ethuser.setRoles(Arrays.asList(defaultRole));
			
			userRepository.save(ethuser);
			return true;
		} catch(ConstraintViolationException | DataIntegrityViolationException e) { 
			throw EthExceptionEnums.USER_EXISTS_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
