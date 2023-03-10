package org.jctools.counters;

import org.jctools.util.UnsafeAccess;

/* loaded from: grasscutter.jar:org/jctools/counters/CountersFactory.class */
public final class CountersFactory {
    private CountersFactory() {
    }

    public static FixedSizeStripedLongCounter createFixedSizeStripedCounter(int stripesCount) {
        if (UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG) {
            return new FixedSizeStripedLongCounterV8(stripesCount);
        }
        return new FixedSizeStripedLongCounterV6(stripesCount);
    }

    public static FixedSizeStripedLongCounter createFixedSizeStripedCounterV6(int stripesCount) {
        return new FixedSizeStripedLongCounterV6(stripesCount);
    }

    public static FixedSizeStripedLongCounter createFixedSizeStripedCounterV8(int stripesCount) {
        return new FixedSizeStripedLongCounterV8(stripesCount);
    }
}
