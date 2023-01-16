package org.eclipse.jetty.util.statistic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/statistic/RateCounter.class */
public class RateCounter {
    private final LongAdder _total = new LongAdder();
    private final AtomicLong _timeStamp = new AtomicLong(System.nanoTime());

    public void add(long l) {
        this._total.add(l);
    }

    public long getRate() {
        long elapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._timeStamp.get());
        if (elapsed == 0) {
            return 0;
        }
        return (this._total.sum() * 1000) / elapsed;
    }

    public void reset() {
        this._timeStamp.getAndSet(System.nanoTime());
        this._total.reset();
    }
}
