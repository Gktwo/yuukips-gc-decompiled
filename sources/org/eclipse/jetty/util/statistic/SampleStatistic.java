package org.eclipse.jetty.util.statistic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/statistic/SampleStatistic.class */
public class SampleStatistic {
    private final LongAccumulator _max = new LongAccumulator(Math::max, 0);
    private final AtomicLong _total = new AtomicLong();
    private final AtomicLong _count = new AtomicLong();
    private final LongAdder _totalVariance100 = new LongAdder();

    public void reset() {
        this._max.reset();
        this._total.set(0);
        this._count.set(0);
        this._totalVariance100.reset();
    }

    public void record(long sample) {
        long total = this._total.addAndGet(sample);
        long count = this._count.incrementAndGet();
        if (count > 1) {
            long delta10 = (sample * 10) - ((total * 10) / count);
            this._totalVariance100.add(delta10 * delta10);
        }
        this._max.accumulate(sample);
    }

    @Deprecated
    public void set(long sample) {
        record(sample);
    }

    public long getMax() {
        return this._max.get();
    }

    public long getTotal() {
        return this._total.get();
    }

    public long getCount() {
        return this._count.get();
    }

    public double getMean() {
        if (getCount() > 0) {
            return ((double) this._total.get()) / ((double) this._count.get());
        }
        return 0.0d;
    }

    public double getVariance() {
        long variance100 = this._totalVariance100.sum();
        long count = getCount();
        if (count > 1) {
            return (((double) variance100) / 100.0d) / ((double) (count - 1));
        }
        return 0.0d;
    }

    public double getStdDev() {
        return Math.sqrt(getVariance());
    }

    public String toString() {
        return String.format("%s@%x{count=%d,mean=%d,total=%d,stddev=%f}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Long.valueOf(getCount()), Long.valueOf(getMax()), Long.valueOf(getTotal()), Double.valueOf(getStdDev()));
    }
}
