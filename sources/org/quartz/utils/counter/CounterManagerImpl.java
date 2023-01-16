package org.quartz.utils.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import org.quartz.utils.counter.sampled.SampledCounter;
import org.quartz.utils.counter.sampled.SampledCounterImpl;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/CounterManagerImpl.class */
public class CounterManagerImpl implements CounterManager {
    private Timer timer;
    private boolean shutdown;
    private List<Counter> counters = new ArrayList();

    public CounterManagerImpl(Timer timer) {
        if (timer == null) {
            throw new IllegalArgumentException("Timer cannot be null");
        }
        this.timer = timer;
    }

    @Override // org.quartz.utils.counter.CounterManager
    public synchronized void shutdown(boolean killTimer) {
        if (!this.shutdown) {
            try {
                for (Counter counter : this.counters) {
                    if (counter instanceof SampledCounter) {
                        ((SampledCounter) counter).shutdown();
                    }
                }
                if (killTimer) {
                    this.timer.cancel();
                }
            } finally {
                this.shutdown = true;
            }
        }
    }

    @Override // org.quartz.utils.counter.CounterManager
    public synchronized Counter createCounter(CounterConfig config) {
        if (this.shutdown) {
            throw new IllegalStateException("counter manager is shutdown");
        } else if (config == null) {
            throw new NullPointerException("config cannot be null");
        } else {
            Counter counter = config.createCounter();
            if (counter instanceof SampledCounterImpl) {
                SampledCounterImpl sampledCounter = (SampledCounterImpl) counter;
                this.timer.schedule(sampledCounter.getTimerTask(), sampledCounter.getIntervalMillis(), sampledCounter.getIntervalMillis());
            }
            this.counters.add(counter);
            return counter;
        }
    }

    @Override // org.quartz.utils.counter.CounterManager
    public void shutdownCounter(Counter counter) {
        if (counter instanceof SampledCounter) {
            ((SampledCounter) counter).shutdown();
        }
    }
}
