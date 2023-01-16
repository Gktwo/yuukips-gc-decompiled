package org.eclipse.jetty.util.component;

import java.util.EventListener;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;

@ManagedObject("Lifecycle Interface for startable components")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/LifeCycle.class */
public interface LifeCycle {
    @ManagedOperation(value = "Starts the instance", impact = "ACTION")
    void start() throws Exception;

    @ManagedOperation(value = "Stops the instance", impact = "ACTION")
    void stop() throws Exception;

    boolean isRunning();

    boolean isStarted();

    boolean isStarting();

    boolean isStopping();

    boolean isStopped();

    boolean isFailed();

    void addLifeCycleListener(Listener listener);

    void removeLifeCycleListener(Listener listener);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/LifeCycle$Listener.class */
    public interface Listener extends EventListener {
        default void lifeCycleStarting(LifeCycle event) {
        }

        default void lifeCycleStarted(LifeCycle event) {
        }

        default void lifeCycleFailure(LifeCycle event, Throwable cause) {
        }

        default void lifeCycleStopping(LifeCycle event) {
        }

        default void lifeCycleStopped(LifeCycle event) {
        }
    }

    static void start(Object object) {
        if (object instanceof LifeCycle) {
            try {
                ((LifeCycle) object).start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void stop(Object object) {
        if (object instanceof LifeCycle) {
            try {
                ((LifeCycle) object).stop();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
