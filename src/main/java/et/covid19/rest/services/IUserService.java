package et.covid19.rest.services;

import et.covid19.rest.swagger.model.ModelUser;
import et.covid19.rest.util.exception.EthException;

public interface IUserService {

	public boolean registerUser(ModelUser user) throws EthException;
}
