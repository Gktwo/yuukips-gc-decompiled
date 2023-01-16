package org.jctools.counters;

/* loaded from: grasscutter.jar:org/jctools/counters/Counter.class */
public interface Counter {
    void inc();

    void inc(long j);

    long get();

    long getAndReset();
}
