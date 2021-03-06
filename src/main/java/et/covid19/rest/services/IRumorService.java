package et.covid19.rest.services;

import et.covid19.rest.swagger.model.ModelRumor;
import et.covid19.rest.swagger.model.ModelRumorList;
import et.covid19.rest.swagger.model.RequestSaveRumor;
import et.covid19.rest.util.exception.EthException;

public interface IRumorService {

    public boolean registerRumor(RequestSaveRumor rumor) throws EthException;

    public ModelRumorList getAllRumorReports() throws EthException;
    
    public ModelRumor getRumorReport(Integer id) throws EthException;
    
    public boolean updateRumorReportStatus(Integer id, Integer statusId) throws EthException;
}
