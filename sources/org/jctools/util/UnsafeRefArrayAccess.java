package org.jctools.util;

/* loaded from: grasscutter.jar:org/jctools/util/UnsafeRefArrayAccess.class */
public final class UnsafeRefArrayAccess {
    public static final long REF_ARRAY_BASE = 0;
    public static final int REF_ELEMENT_SHIFT = 0;

    public static <E> void spRefElement(E[] buffer, long offset, E e) {
        UnsafeAccess.UNSAFE.putObject(buffer, offset, e);
    }

    public static <E> void soRefElement(E[] buffer, long offset, E e) {
        UnsafeAccess.UNSAFE.putOrderedObject(buffer, offset, e);
    }

    public static <E> E lpRefElement(E[] buffer, long offset) {
        return (E) UnsafeAccess.UNSAFE.getObject(buffer, offset);
    }

    public static <E> E lvRefElement(E[] buffer, long offset) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(buffer, offset);
    }

    public static long calcRefElementOffset(long index) {
        return REF_ARRAY_BASE + (index << REF_ELEMENT_SHIFT);
    }

    public static long calcCircularRefElementOffset(long index, long mask) {
        return REF_ARRAY_BASE + ((index & mask) << REF_ELEMENT_SHIFT);
    }

    public static <E> E[] allocateRefArray(int capacity) {
        return (E[]) new Object[capacity];
    }
}
