package et.covid19.rest.services.workflow;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import et.covid19.rest.annotations.EthLoggable;

@Configuration
@EnableStateMachineFactory
public class WorkFlowStateMachineConfiguration extends StateMachineConfigurerAdapter<WorkFlowStates, WorkFlowEvents> {

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
           .withExternal().source(WorkFlowStates.TEST_PENDING).target(WorkFlowStates.TEST_NEGATIVE).event(WorkFlowEvents.TEST_NEGATIVE)
           .and()
           .withExternal().source(WorkFlowStates.TEST_PENDING).target(WorkFlowStates.TEST_POSITIVE).event(WorkFlowEvents.TEST_POSITIVE)
           .and()
           .withExternal().source(WorkFlowStates.TEST_POSITIVE).target(WorkFlowStates.STABLE).event(WorkFlowEvents.CONDITION_CHANGE)
           .and()
           .withExternal().source(WorkFlowStates.TEST_POSITIVE).target(WorkFlowStates.CRITICAL).event(WorkFlowEvents.CONDITION_CHANGE)
           .and()
           .withExternal().source(WorkFlowStates.STABLE).target(WorkFlowStates.CRITICAL).event(WorkFlowEvents.CONDITION_CHANGE)
           .and()
           .withExternal().source(WorkFlowStates.STABLE).target(WorkFlowStates.RECOVERED).event(WorkFlowEvents.CONDITION_CHANGE)
           .and()
           .withExternal().source(WorkFlowStates.STABLE).target(WorkFlowStates.DECEASED).event(WorkFlowEvents.CONDITION_CHANGE)
           .and()
           .withExternal().source(WorkFlowStates.CRITICAL).target(WorkFlowStates.STABLE).event(WorkFlowEvents.CONDITION_CHANGE)
           .and()
           .withExternal().source(WorkFlowStates.CRITICAL).target(WorkFlowStates.DECEASED).event(WorkFlowEvents.CONDITION_CHANGE);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<WorkFlowStates, WorkFlowEvents> config) throws Exception {
        StateMachineListenerAdapter<WorkFlowStates, WorkFlowEvents> adapter = new StateMachineListenerAdapter<WorkFlowStates, WorkFlowEvents>() {

            @Override
            @EthLoggable
            public void stateChanged(State<WorkFlowStates, WorkFlowEvents> from,
                    State<WorkFlowStates, WorkFlowEvents> to) {
                // TODO Auto-generated method stub
                super.stateChanged(from, to);
            }

            @Override
            @EthLoggable
            public void eventNotAccepted(Message<WorkFlowEvents> event) {
                // TODO Auto-generated method stub
                super.eventNotAccepted(event);
            }

            @Override
            @EthLoggable
            public void stateMachineError(StateMachine<WorkFlowStates, WorkFlowEvents> stateMachine,
                    Exception exception) {
                // TODO Auto-generated method stub
                super.stateMachineError(stateMachine, exception);
            }
            
        };
        
        config.withConfiguration().listener(adapter);
    }

}
