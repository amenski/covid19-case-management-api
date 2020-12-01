package et.covid19.rest.services.workflow;

public enum WorkFlowEvents {
    TEST_PENDING,
    TEST_PENDING_TO_TEST_POSITIVE, 
    TEST_PENDING_TO_TEST_NEGATIVE, 
    
    NA_TO_STABLE,
    NA_TO_CRITICAL,

    STABLE_TO_CRITICAL,
    STABLE_TO_RECOVERED,
    STABLE_TO_DECEASED,
    
    CRITICAL_TO_STABLE,
    CRITICAL_TO_DECEASED,
    
    TEST_POSITIVE_TO_STABLE,
    TEST_POSITIVE_TO_CRITICAL;
    
    
    public static WorkFlowEvents get(String source, String dest) {
        String event = source + "_TO_" + dest;
        for(WorkFlowEvents ev : WorkFlowEvents.values()) {
            if(ev.name().equals(event))
                return ev;
        }
        return TEST_PENDING;
    }
}
