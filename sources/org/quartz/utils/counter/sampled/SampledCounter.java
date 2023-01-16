package org.quartz.utils.counter.sampled;

import org.quartz.utils.counter.Counter;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/sampled/SampledCounter.class */
public interface SampledCounter extends Counter {
    void shutdown();

    TimeStampedCounterValue getMostRecentSample();

    TimeStampedCounterValue[] getAllSampleValues();

    long getAndReset();
}
