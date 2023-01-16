package org.quartz.utils.counter.sampled;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/sampled/SampledRateCounter.class */
public interface SampledRateCounter extends SampledCounter {
    void increment(long j, long j2);

    void decrement(long j, long j2);

    void setValue(long j, long j2);

    void setNumeratorValue(long j);

    void setDenominatorValue(long j);
}
