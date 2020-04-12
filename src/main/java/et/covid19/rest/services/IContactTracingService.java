package et.covid19.rest.services;

import et.covid19.rest.util.exception.EthException;

public interface IContactTracingService {

	public String traceContactByCode(String code) throws EthException;
}
