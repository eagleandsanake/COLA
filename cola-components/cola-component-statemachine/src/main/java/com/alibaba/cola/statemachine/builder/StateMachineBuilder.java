package com.alibaba.cola.statemachine.builder;

import com.alibaba.cola.statemachine.StateMachine;

/**
 * StateMachineBuilder
 *
 * @author Frank Zhang
 * @date 2020-02-07 5:32 PM
 */
public interface StateMachineBuilder<S, E, C> {
    /**
     * Builder for one transition
     * from 和 to 是不同的state
     * @return External transition builder
     */
    ExternalTransitionBuilder<S, E, C> externalTransition();

    /**
     * Builder for multiple transitions
     * 事件的源有多个
     * @return External transition builder
     */
    ExternalTransitionsBuilder<S, E, C> externalTransitions();
    /**
     * Builder for parallel transitions
     * 去向有多个
     * @return External transition builder
     */
    ExternalParallelTransitionBuilder<S, E, C> externalParallelTransition();

    /**
     * Start to build internal transition
     * from 和 to都是一个state
     * @return Internal transition builder
     */
    InternalTransitionBuilder<S, E, C> internalTransition();

    /**
     * set up fail callback, default do nothing {@code NumbFailCallbackImpl}
     *
     * @param callback
     */
    void setFailCallback(FailCallback<S, E, C> callback);

    StateMachine<S, E, C> build(String machineId);

}
