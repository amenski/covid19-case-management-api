package et.covid19.rest.services;

import java.time.LocalDate;

import et.covid19.rest.swagger.model.ModelDailyCaseStatus;
import et.covid19.rest.swagger.model.ModelDailyCaseStatusList;
import et.covid19.rest.util.exception.EthException;

public interface IDailyCaseStatus {

	public ModelDailyCaseStatus getDailyCaseStatus(LocalDate reportingDate) throws EthException;
	
	public ModelDailyCaseStatusList getAllDailyCaseStatus() throws EthException;
	
	public boolean addDailyStatus(ModelDailyCaseStatus model) throws EthException;
}
