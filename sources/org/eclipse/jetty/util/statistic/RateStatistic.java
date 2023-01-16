package org.eclipse.jetty.util.statistic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/statistic/RateStatistic.class */
public class RateStatistic {
    private final Deque<Long> _samples = new ArrayDeque();
    private final long _nanoPeriod;
    private final TimeUnit _units;
    private long _max;
    private long _count;

    public RateStatistic(long period, TimeUnit units) {
        this._nanoPeriod = TimeUnit.NANOSECONDS.convert(period, units);
        this._units = units;
    }

    public long getPeriod() {
        return this._units.convert(this._nanoPeriod, TimeUnit.NANOSECONDS);
    }

    public TimeUnit getUnits() {
        return this._units;
    }

    public void reset() {
        synchronized (this) {
            this._samples.clear();
            this._max = 0;
            this._count = 0;
        }
    }

    private void update() {
        update(System.nanoTime());
    }

    private void update(long now) {
        long expire = now - this._nanoPeriod;
        Long peekFirst = this._samples.peekFirst();
        while (true) {
            Long head = peekFirst;
            if (head != null && head.longValue() < expire) {
                this._samples.removeFirst();
                peekFirst = this._samples.peekFirst();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void age(long period, TimeUnit units) {
        long increment = TimeUnit.NANOSECONDS.convert(period, units);
        synchronized (this) {
            int size = this._samples.size();
            for (int i = 0; i < size; i++) {
                this._samples.addLast(Long.valueOf(this._samples.removeFirst().longValue() - increment));
            }
            update();
        }
    }

    public int record() {
        int rate;
        long now = System.nanoTime();
        synchronized (this) {
            this._count++;
            this._samples.add(Long.valueOf(now));
            update(now);
            rate = this._samples.size();
            if (((long) rate) > this._max) {
                this._max = (long) rate;
            }
        }
        return rate;
    }

    public int getRate() {
        int size;
        synchronized (this) {
            update();
            size = this._samples.size();
        }
        return size;
    }

    public long getMax() {
        long j;
        synchronized (this) {
            j = this._max;
        }
        return j;
    }

    public long getOldest(TimeUnit units) {
        synchronized (this) {
            Long head = this._samples.peekFirst();
            if (head == null) {
                return -1;
            }
            return units.convert(System.nanoTime() - head.longValue(), TimeUnit.NANOSECONDS);
        }
    }

    public long getCount() {
        long j;
        synchronized (this) {
            j = this._count;
        }
        return j;
    }

    public String dump() {
        return dump(TimeUnit.MINUTES);
    }

    public String dump(TimeUnit units) {
        String format;
        long now = System.nanoTime();
        synchronized (this) {
            format = String.format("%s%n%s", toString(now), (String) this._samples.stream().mapToLong(t -> {
                return units.convert(now - t.longValue(), TimeUnit.NANOSECONDS);
            }).mapToObj(Long::toString).collect(Collectors.joining(System.lineSeparator())));
        }
        return format;
    }

    public String toString() {
        return toString(System.nanoTime());
    }

    private String toString(long nanoTime) {
        String format;
        synchronized (this) {
            update(nanoTime);
            format = String.format("%s@%x{count=%d,max=%d,rate=%d per %d %s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Long.valueOf(this._count), Long.valueOf(this._max), Integer.valueOf(this._samples.size()), Long.valueOf(this._units.convert(this._nanoPeriod, TimeUnit.NANOSECONDS)), this._units);
        }
        return format;
    }
}
