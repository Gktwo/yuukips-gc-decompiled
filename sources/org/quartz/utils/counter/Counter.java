package org.quartz.utils.counter;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/Counter.class */
public interface Counter {
    long increment();

    long decrement();

    long getAndSet(long j);

    long getValue();

    long increment(long j);

    long decrement(long j);

    void setValue(long j);
}
