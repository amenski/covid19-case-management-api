package et.covid19.rest.services.workflow;

import java.time.OffsetDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.services.impl.AbstractService;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;

@Service(value = "newWorkflow")
public class WorkFlowServiceImpl extends AbstractService implements IWorkFlowService {

    private static final String PUI_ID_HEADER = "puiId";

    private final StateMachineFactory<WorkFlowStates, WorkFlowEvents> factory;

    public WorkFlowServiceImpl(StateMachineFactory<WorkFlowStates, WorkFlowEvents> factory) {
        this.factory = factory;
    }

    @Override
    @EthLoggable
    @Transactional(rollbackOn = Exception.class)
    public boolean executeTransition(PuiInfo pui, Integer newState) throws EthException {
        ConstantEnum destinationState = constantsEnumRepository.findById(newState).orElseThrow(EthExceptionEnums.CONSTANT_NOT_FOUND);

        String sourceState = getCurrentStatus(pui);
        logger.info("{} Requesting state update to: [ currentConfirmedResult: {}, currentState: {}, newState: {}]", "executeTransition()", 
                pui.getConfirmedResult().getEnumName(),
                pui.getStatus().getEnumName(),
                destinationState.getEnumName());
        
        StateMachine<WorkFlowStates, WorkFlowEvents> sm = this.build(pui.getId());
        Message<WorkFlowEvents> message = MessageBuilder.withPayload(WorkFlowEvents.get(sourceState, destinationState.getEnumName()))
                .setHeader(PUI_ID_HEADER, pui.getId())
                .build();
        return sm.sendEvent(message);
    }
    
    // == HELPER METHODS ==
    /**
     * Build a statemachine with an Interceptor(for updating operations). 
     * Then reset the machine to the current state of the 'pui'
     * 
     * @param puiId
     * @return StateMachine
     */
    private StateMachine<WorkFlowStates, WorkFlowEvents> build(Long puiId) {
        StateMachine<WorkFlowStates, WorkFlowEvents> machine = this.factory.getStateMachine(String.valueOf(puiId));
        machine.stop();

        machine.getStateMachineAccessor().doWithAllRegions(sma -> {

            sma.addStateMachineInterceptor(buildInterceptorAdater());
            PuiInfo afterChange = getPuiInfo(puiId);
            String currentState = getCurrentStatus(afterChange);

            sma.resetStateMachine(new DefaultStateMachineContext<>(WorkFlowStates.valueOf(currentState), null, null, null));
        });

        machine.start();
        return machine;
    }

    /**
     * Intercept and manage update operations
     * 
     * NOTE: StateMachine Interceptor doesn't have a way to check {@code eventNotAccepted}, 
     * so this will be handled in the {@link WorkFlowStateMachineConfiguration#configure(org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer)}
     * 
     * @return StateMachineInterceptorAdapter
     */
    private StateMachineInterceptorAdapter<WorkFlowStates, WorkFlowEvents> buildInterceptorAdater() {
        return new StateMachineInterceptorAdapter<WorkFlowStates, WorkFlowEvents>() {

            @Override
            public void postStateChange(State<WorkFlowStates, WorkFlowEvents> state, Message<WorkFlowEvents> message,
                    Transition<WorkFlowStates, WorkFlowEvents> transition,
                    StateMachine<WorkFlowStates, WorkFlowEvents> stateMachine) {
                logger.info("{} input parameters: [ message: {}]", "postStateChange()", message);
                Optional.ofNullable(message).ifPresent(msg -> {

                    Optional.ofNullable(Long.class.cast(msg.getHeaders().getOrDefault(PUI_ID_HEADER, -1L)))
                            .ifPresent(id -> {
                                updateOnPostStateChange(id, message);
                            });
                });
            }

            @Override
            public Exception stateMachineError(StateMachine<WorkFlowStates, WorkFlowEvents> stateMachine,
                    Exception exception) {
                logger.info("{} StateMachine encountered error: [ message: {}]", "stateMachineError()", exception.getMessage());
                return super.stateMachineError(stateMachine, exception);
            }

        };
    }
    
    /**
     * Update puiStatus after the machine has completed state transition
     * 
     * @param puiId
     * @param message
     */
    private void updateOnPostStateChange(Long puiId, Message<WorkFlowEvents> message) {
        final String methodName = "updateOnPostStateChange()";
        logger.info("{} input parameters: [ message: {}]", methodName, message);
        try {
            PuiInfo in = getPuiInfo(puiId);

            WorkFlowEvents recieved = message.getPayload();
            switch (recieved) {
            case TEST_PENDING_TO_TEST_NEGATIVE:
                in.setConfirmedResult(new ConstantEnum(1002));
                break;
            case TEST_PENDING_TO_TEST_POSITIVE:
                in.setConfirmedResult(new ConstantEnum(1003));
                if(in.getStatus() == null) {
                    in.setStatus(new ConstantEnum(1064)); //1064 = NA
                }
                break;
            default:
                final String  _to = "_TO_";
                String newState = recieved.name().substring(recieved.name().indexOf(_to) + _to.length());
                logger.info("{} Updating to new state: {} ", methodName, newState);
                ConstantEnum status = constantsEnumRepository.findByEnumName(newState).orElseThrow(EthExceptionEnums.CONSTANT_NOT_FOUND);
                in.setConfirmedResult(new ConstantEnum(1003));
                in.setStatus(status);
                break;
            }
            
            in.setModifiedBy(getCurrentLoggedInUserId());
            in.setModifiedDate(OffsetDateTime.now());
            puiInfoRepository.save(in);
        } catch (EthException e) {
            logger.error("{} Error Message: {} while processing: {}", methodName, e.getMessage(), ReflectionToStringBuilder.toString(message, ToStringStyle.JSON_STYLE));
            throw new RuntimeException(e);
        }
    }
    
    private PuiInfo getPuiInfo(Long id) {
        return puiInfoRepository.findById(id).orElseGet(null);
    }
    
    /**
     * since we have 2 regions 
     * 1) confirmed_result (with -ve & +ve) and 
     * 2) status with 5 possible values, lets identify where the machine should start
     * 
     * @param PuiInfo info
     * @return currentConfirmedResult when confirmedResult is not +ve or else the currentStatus
     */
    private String getCurrentStatus(PuiInfo info) {
        return WorkFlowStates.TEST_POSITIVE.name().equals(info.getConfirmedResult().getEnumName()) 
                ? info.getStatus().getEnumName()
                : info.getConfirmedResult().getEnumName();
    }
}
