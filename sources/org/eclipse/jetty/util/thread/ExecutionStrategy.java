package org.eclipse.jetty.util.thread;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ExecutionStrategy.class */
public interface ExecutionStrategy {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ExecutionStrategy$Producer.class */
    public interface Producer {
        Runnable produce();
    }

    void dispatch();

    void produce();
}
