package org.quartz.utils.counter;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/CounterConfig.class */
public class CounterConfig {
    private final long initialValue;

    public CounterConfig(long initialValue) {
        this.initialValue = initialValue;
    }

    public final long getInitialValue() {
        return this.initialValue;
    }

    public Counter createCounter() {
        return new CounterImpl(this.initialValue);
    }
}
