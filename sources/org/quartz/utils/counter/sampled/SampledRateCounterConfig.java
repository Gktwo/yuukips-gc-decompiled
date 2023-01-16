package org.quartz.utils.counter.sampled;

import org.quartz.utils.counter.Counter;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/sampled/SampledRateCounterConfig.class */
public class SampledRateCounterConfig extends SampledCounterConfig {
    private final long initialNumeratorValue;
    private final long initialDenominatorValue;

    public SampledRateCounterConfig(int intervalSecs, int historySize, boolean isResetOnSample) {
        this(intervalSecs, historySize, isResetOnSample, 0, 0);
    }

    public SampledRateCounterConfig(int intervalSecs, int historySize, boolean isResetOnSample, long initialNumeratorValue, long initialDenominatorValue) {
        super(intervalSecs, historySize, isResetOnSample, 0);
        this.initialNumeratorValue = initialNumeratorValue;
        this.initialDenominatorValue = initialDenominatorValue;
    }

    @Override // org.quartz.utils.counter.sampled.SampledCounterConfig, org.quartz.utils.counter.CounterConfig
    public Counter createCounter() {
        SampledRateCounterImpl sampledRateCounter = new SampledRateCounterImpl(this);
        sampledRateCounter.setValue(this.initialNumeratorValue, this.initialDenominatorValue);
        return sampledRateCounter;
    }
}
