package et.covid19.rest.services;

import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.swagger.model.RequestSaveFacility;
import et.covid19.rest.util.exception.EthException;

public interface IHealthFacilityService {
    boolean registerNewFacility(RequestSaveFacility newCase) throws EthException;
}
