package org.jctools.util;

/* compiled from: PaddedAtomicLong.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/util/PaddedAtomicLongL1Field.class */
public abstract class PaddedAtomicLongL1Field extends PaddedAtomicLongL1Pad {
    private static final long VALUE_OFFSET = UnsafeAccess.fieldOffset(PaddedAtomicLongL1Field.class, "value");
    private volatile long value;

    public void spVal(long v) {
        UnsafeAccess.UNSAFE.putLong(this, VALUE_OFFSET, v);
    }

    public void soVal(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, VALUE_OFFSET, v);
    }

    public void svVal(long v) {
        this.value = v;
    }

    public long lvVal() {
        return this.value;
    }

    public long lpVal() {
        return UnsafeAccess.UNSAFE.getLong(this, VALUE_OFFSET);
    }

    public boolean casVal(long expectedV, long newV) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, VALUE_OFFSET, expectedV, newV);
    }

    public long getAndSetVal(long v) {
        long currV;
        if (UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG) {
            return UnsafeAccess.UNSAFE.getAndSetLong(this, VALUE_OFFSET, v);
        }
        do {
            currV = lvVal();
        } while (!casVal(currV, v));
        return currV;
    }

    public long getAndAddVal(long delta) {
        long currV;
        if (UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG) {
            return UnsafeAccess.UNSAFE.getAndAddLong(this, VALUE_OFFSET, delta);
        }
        do {
            currV = lvVal();
        } while (!casVal(currV, currV + delta));
        return currV;
    }
}
