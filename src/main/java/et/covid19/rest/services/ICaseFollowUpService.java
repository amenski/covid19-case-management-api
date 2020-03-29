package et.covid19.rest.services;

import javax.validation.Valid;

import et.covid19.rest.swagger.model.ModelPuiFollowUpList;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.util.exception.EthException;

public interface ICaseFollowUpService {

	public boolean addCaseFollowUpQuestionnier(@Valid RequestSaveFollowUp body) throws EthException;
	
	public ModelPuiFollowUpList getFollowUpData(String caseCode) throws EthException;
}
