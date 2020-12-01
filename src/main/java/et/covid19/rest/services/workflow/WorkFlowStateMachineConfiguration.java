package et.covid19.rest.services.workflow;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;

import et.covid19.rest.annotations.EthLoggable;

@Configuration
@EnableStateMachineFactory
public class WorkFlowStateMachineConfiguration extends StateMachineConfigurerAdapter<WorkFlowStates, WorkFlowEvents> {

    protected Logger logger = LoggerFactory.getLogger(WorkFlowStateMachineConfiguration.class);
    
    @Override
    public void configure(StateMachineStateConfigurer<WorkFlowStates, WorkFlowEvents> states) throws Exception {
        states
            .withStates().initial(WorkFlowStates.TEST_PENDING)
            .states(new HashSet<>(Arrays.asList(WorkFlowStates.values())))
            .end(WorkFlowStates.TEST_NEGATIVE)
            .end(WorkFlowStates.RECOVERED)
            .end(WorkFlowStates.DECEASED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<WorkFlowStates, WorkFlowEvents> transitions)
            throws Exception {
        // no CRITICAL => RECOVERED transition
       transitions
           .withExternal().source(WorkFlowStates.TEST_PENDING).target(WorkFlowStates.TEST_NEGATIVE).event(WorkFlowEvents.TEST_PENDING_TO_TEST_NEGATIVE)
           .and()
           .withExternal().source(WorkFlowStates.TEST_PENDING).target(WorkFlowStates.TEST_POSITIVE).event(WorkFlowEvents.TEST_PENDING_TO_TEST_POSITIVE)
           .and()
           .withExternal().source(WorkFlowStates.TEST_POSITIVE).target(WorkFlowStates.STABLE).event(WorkFlowEvents.TEST_POSITIVE_TO_STABLE)
           .and()
           .withExternal().source(WorkFlowStates.TEST_POSITIVE).target(WorkFlowStates.CRITICAL).event(WorkFlowEvents.TEST_POSITIVE_TO_CRITICAL)
           .and()
           .withExternal().source(WorkFlowStates.STABLE).target(WorkFlowStates.CRITICAL).event(WorkFlowEvents.STABLE_TO_CRITICAL)
           .and()
           .withExternal().source(WorkFlowStates.STABLE).target(WorkFlowStates.RECOVERED).event(WorkFlowEvents.STABLE_TO_RECOVERED)
           .and()
           .withExternal().source(WorkFlowStates.STABLE).target(WorkFlowStates.DECEASED).event(WorkFlowEvents.STABLE_TO_DECEASED)
           .and()
           .withExternal().source(WorkFlowStates.CRITICAL).target(WorkFlowStates.STABLE).event(WorkFlowEvents.CRITICAL_TO_STABLE)
           .and()
           .withExternal().source(WorkFlowStates.CRITICAL).target(WorkFlowStates.DECEASED).event(WorkFlowEvents.CRITICAL_TO_DECEASED)
           .and()
           .withExternal().source(WorkFlowStates.NA).target(WorkFlowStates.STABLE).event(WorkFlowEvents.NA_TO_STABLE)
           .and()
           .withExternal().source(WorkFlowStates.NA).target(WorkFlowStates.CRITICAL).event(WorkFlowEvents.NA_TO_CRITICAL);
    }

    /** 
     * Add a listener since {@link WorkFlowServiceImpl#executeTransition(et.covid19.rest.dal.model.PuiInfo, Integer)} 
     * {@code InterceptorAdater} doesn't have {@code eventNotAccepted} method
     */
    @Override
    public void configure(StateMachineConfigurationConfigurer<WorkFlowStates, WorkFlowEvents> config) throws Exception {
        StateMachineListenerAdapter<WorkFlowStates, WorkFlowEvents> listner = new StateMachineListenerAdapter<WorkFlowStates, WorkFlowEvents>() {

            @Override
            @EthLoggable
            public void eventNotAccepted(Message<WorkFlowEvents> event) {
                logger.warn("{} Input parameters: [ event: {}]", "eventNotAccepted()", event);
                super.eventNotAccepted(event);
            }

            @Override
            @EthLoggable
            public void stateMachineError(StateMachine<WorkFlowStates, WorkFlowEvents> stateMachine,
                    Exception exception) {
                logger.info("{} Input parameters: [ event: {}]", "stateMachineError()", exception.getMessage());
                super.stateMachineError(stateMachine, exception);
            }
            
        };
        
        config
            .withConfiguration()
            .listener(listner);
    }

}
