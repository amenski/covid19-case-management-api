package et.covid19.rest.services;

import java.util.UUID;

import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.util.exception.EthException;

public interface ICaseService {

	public boolean registerNewCase(RequestSaveCase newCase) throws EthException;
	
	public ModelCase getModelCase(UUID case_code) throws EthException;
	
	public boolean updateResult(String code, Integer status) throws EthException;
}
