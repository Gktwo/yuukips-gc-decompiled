package org.jctools.counters;

import org.jctools.util.UnsafeAccess;

/* loaded from: grasscutter.jar:org/jctools/counters/FixedSizeStripedLongCounterV8.class */
class FixedSizeStripedLongCounterV8 extends FixedSizeStripedLongCounter {
    public FixedSizeStripedLongCounterV8(int stripesCount) {
        super(stripesCount);
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected void inc(long[] cells, long offset, long delta) {
        UnsafeAccess.UNSAFE.getAndAddLong(cells, offset, delta);
    }

    @Override // org.jctools.counters.FixedSizeStripedLongCounter
    protected long getAndReset(long[] cells, long offset) {
        return UnsafeAccess.UNSAFE.getAndSetLong(cells, offset, 0);
    }
}
