package org.quartz.utils.counter.sampled;

import java.util.TimerTask;
import org.quartz.utils.CircularLossyQueue;
import org.quartz.utils.counter.CounterImpl;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/sampled/SampledCounterImpl.class */
public class SampledCounterImpl extends CounterImpl implements SampledCounter {
    private static final long serialVersionUID = -3605369302464131521L;
    private static final int MILLIS_PER_SEC = 1000;
    protected final CircularLossyQueue<TimeStampedCounterValue> history;
    protected final boolean resetOnSample;
    private final TimerTask samplerTask = new TimerTask() { // from class: org.quartz.utils.counter.sampled.SampledCounterImpl.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SampledCounterImpl.this.recordSample();
        }
    };
    private final long intervalMillis;

    public SampledCounterImpl(SampledCounterConfig config) {
        super(config.getInitialValue());
        this.intervalMillis = (long) (config.getIntervalSecs() * 1000);
        this.history = new CircularLossyQueue<>(config.getHistorySize());
        this.resetOnSample = config.isResetOnSample();
        recordSample();
    }

    @Override // org.quartz.utils.counter.sampled.SampledCounter
    public TimeStampedCounterValue getMostRecentSample() {
        return this.history.peek();
    }

    @Override // org.quartz.utils.counter.sampled.SampledCounter
    public TimeStampedCounterValue[] getAllSampleValues() {
        return this.history.toArray(new TimeStampedCounterValue[this.history.depth()]);
    }

    @Override // org.quartz.utils.counter.sampled.SampledCounter
    public void shutdown() {
        if (this.samplerTask != null) {
            this.samplerTask.cancel();
        }
    }

    public TimerTask getTimerTask() {
        return this.samplerTask;
    }

    public long getIntervalMillis() {
        return this.intervalMillis;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    void recordSample() {
        char c;
        if (this.resetOnSample) {
            c = getAndReset();
        } else {
            c = getValue();
        }
        this.history.push(new TimeStampedCounterValue(System.currentTimeMillis(), c));
    }

    @Override // org.quartz.utils.counter.sampled.SampledCounter
    public long getAndReset() {
        return getAndSet(0);
    }
}
