package et.covid19.rest.services;

import et.covid19.rest.swagger.model.ModelAttributeList;
import et.covid19.rest.util.exception.EthException;

public interface IAttributeService {

	public ModelAttributeList getAttributeList() throws EthException;
}
