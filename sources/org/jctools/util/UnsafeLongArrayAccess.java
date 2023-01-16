package org.jctools.util;

/* loaded from: grasscutter.jar:org/jctools/util/UnsafeLongArrayAccess.class */
public final class UnsafeLongArrayAccess {
    public static final long LONG_ARRAY_BASE = 0;
    public static final int LONG_ELEMENT_SHIFT = 0;

    public static void spLongElement(long[] buffer, long offset, long e) {
        UnsafeAccess.UNSAFE.putLong(buffer, offset, e);
    }

    public static void soLongElement(long[] buffer, long offset, long e) {
        UnsafeAccess.UNSAFE.putOrderedLong(buffer, offset, e);
    }

    public static long lpLongElement(long[] buffer, long offset) {
        return UnsafeAccess.UNSAFE.getLong(buffer, offset);
    }

    public static long lvLongElement(long[] buffer, long offset) {
        return UnsafeAccess.UNSAFE.getLongVolatile(buffer, offset);
    }

    public static long calcLongElementOffset(long index) {
        return LONG_ARRAY_BASE + (index << LONG_ELEMENT_SHIFT);
    }

    public static long calcCircularLongElementOffset(long index, long mask) {
        return LONG_ARRAY_BASE + ((index & mask) << LONG_ELEMENT_SHIFT);
    }

    public static long[] allocateLongArray(int capacity) {
        return new long[capacity];
    }
}
