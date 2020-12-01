package et.covid19.rest.services.workflow;

public enum WorkFlowStates {
    // may be it is a good idea to consider the testxx and the others separate and
    // join them with Regios but for now better to have a minimalist concept of the
    // states
    TEST_PENDING, 
    TEST_NEGATIVE, 
    TEST_POSITIVE, 
    STABLE, 
    CRITICAL,
    RECOVERED,
    DECEASED,
    NA;

}
