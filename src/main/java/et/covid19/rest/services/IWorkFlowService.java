package et.covid19.rest.services;

import et.covid19.rest.util.exception.EthException;

public interface IWorkFlowService {

    public boolean transitionAllowed(Integer startState, Integer endState) throws EthException;
}
