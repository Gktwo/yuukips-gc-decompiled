package org.jctools.counters;

import org.jctools.util.UnsafeAccess;

/* loaded from: grasscutter.jar:org/jctools/counters/FixedSizeStripedLongCounterV6.class */
class FixedSizeStripedLongCounterV6 extends FixedSizeStripedLongCounter {
    public FixedSizeStripedLongCounterV6(int stripesCount) {
        super(stripesCount);
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected void inc(long[] cells, long offset, long delta) {
        long v;
        do {
            v = UnsafeAccess.UNSAFE.getLongVolatile(cells, offset);
        } while (!UnsafeAccess.UNSAFE.compareAndSwapLong(cells, offset, v, v + delta));
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected long getAndReset(long[] cells, long offset) {
        long v;
        do {
            v = UnsafeAccess.UNSAFE.getLongVolatile(cells, offset);
        } while (!UnsafeAccess.UNSAFE.compareAndSwapLong(cells, offset, v, 0));
        return v;
    }
}
