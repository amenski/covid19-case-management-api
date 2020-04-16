package et.covid19.rest.services;

import java.util.UUID;

import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.ModelCaseList;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.util.exception.EthException;

public interface ICaseService {

	public String registerNewCase(RequestSaveCase newCase) throws EthException;
	
	public ModelCase getModelCase(UUID caseCode) throws EthException;
	
	public boolean updateResult(String code, Integer status) throws EthException;
	
	public ModelCaseList searchCase(Integer confirmedResult, Integer status, String region, String recentTravelTo) throws EthException;
	
	public ModelCaseList getAllCases(Integer page) throws EthException;
}
