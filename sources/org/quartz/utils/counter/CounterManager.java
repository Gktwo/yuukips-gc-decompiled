package org.quartz.utils.counter;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/CounterManager.class */
public interface CounterManager {
    Counter createCounter(CounterConfig counterConfig);

    void shutdown(boolean z);

    void shutdownCounter(Counter counter);
}
