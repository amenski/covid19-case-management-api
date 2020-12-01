package et.covid19.rest.services.workflow;

import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.util.exception.EthException;

public interface IWorkFlowService {

    public boolean executeTransition(PuiInfo info, Integer toState) throws EthException;
}
