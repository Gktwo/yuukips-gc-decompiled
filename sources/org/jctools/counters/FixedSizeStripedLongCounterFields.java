package org.jctools.counters;

import org.jctools.util.PortableJvmInfo;
import org.jctools.util.Pow2;
import org.jctools.util.UnsafeAccess;

/* compiled from: FixedSizeStripedLongCounter.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/counters/FixedSizeStripedLongCounterFields.class */
public abstract class FixedSizeStripedLongCounterFields extends FixedSizeStripedLongCounterPrePad {
    protected static final int CACHE_LINE_IN_LONGS = PortableJvmInfo.CACHE_LINE_SIZE / 8;
    protected static final long COUNTER_ARRAY_BASE = (long) Math.max(UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class), PortableJvmInfo.CACHE_LINE_SIZE - 8);
    protected static final long ELEMENT_SHIFT = (long) Integer.numberOfTrailingZeros(PortableJvmInfo.CACHE_LINE_SIZE);
    protected final long[] cells;
    protected final int mask;

    /* access modifiers changed from: protected */
    public FixedSizeStripedLongCounterFields(int stripesCount) {
        if (stripesCount <= 0) {
            throw new IllegalArgumentException("Expecting a stripesCount that is larger than 0");
        }
        int size = Pow2.roundToPowerOfTwo(stripesCount);
        this.cells = new long[CACHE_LINE_IN_LONGS * size];
        this.mask = size - 1;
    }
}
