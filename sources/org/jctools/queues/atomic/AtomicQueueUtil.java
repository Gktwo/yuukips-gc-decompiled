package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/AtomicQueueUtil.class */
final class AtomicQueueUtil {
    AtomicQueueUtil() {
    }

    /* access modifiers changed from: package-private */
    public static <E> E lvRefElement(AtomicReferenceArray<E> buffer, int offset) {
        return buffer.get(offset);
    }

    /* access modifiers changed from: package-private */
    public static <E> E lpRefElement(AtomicReferenceArray<E> buffer, int offset) {
        return buffer.get(offset);
    }

    /* access modifiers changed from: package-private */
    public static <E> void spRefElement(AtomicReferenceArray<E> buffer, int offset, E value) {
        buffer.lazySet(offset, value);
    }

    /* access modifiers changed from: package-private */
    public static void soRefElement(AtomicReferenceArray buffer, int offset, Object value) {
        buffer.lazySet(offset, value);
    }

    static <E> void svRefElement(AtomicReferenceArray<E> buffer, int offset, E value) {
        buffer.set(offset, value);
    }

    /* access modifiers changed from: package-private */
    public static int calcRefElementOffset(long index) {
        return (int) index;
    }

    /* access modifiers changed from: package-private */
    public static int calcCircularRefElementOffset(long index, long mask) {
        return (int) (index & mask);
    }

    /* access modifiers changed from: package-private */
    public static <E> AtomicReferenceArray<E> allocateRefArray(int capacity) {
        return new AtomicReferenceArray<>(capacity);
    }

    static void spLongElement(AtomicLongArray buffer, int offset, long e) {
        buffer.lazySet(offset, e);
    }

    /* access modifiers changed from: package-private */
    public static void soLongElement(AtomicLongArray buffer, int offset, long e) {
        buffer.lazySet(offset, e);
    }

    static long lpLongElement(AtomicLongArray buffer, int offset) {
        return buffer.get(offset);
    }

    /* access modifiers changed from: package-private */
    public static long lvLongElement(AtomicLongArray buffer, int offset) {
        return buffer.get(offset);
    }

    static int calcLongElementOffset(long index) {
        return (int) index;
    }

    /* access modifiers changed from: package-private */
    public static int calcCircularLongElementOffset(long index, int mask) {
        return (int) (index & ((long) mask));
    }

    static AtomicLongArray allocateLongArray(int capacity) {
        return new AtomicLongArray(capacity);
    }

    /* access modifiers changed from: package-private */
    public static int length(AtomicReferenceArray<?> buf) {
        return buf.length();
    }

    /* access modifiers changed from: package-private */
    public static int modifiedCalcCircularRefElementOffset(long index, long mask) {
        return ((int) (index & mask)) >> 1;
    }

    /* access modifiers changed from: package-private */
    public static int nextArrayOffset(AtomicReferenceArray<?> curr) {
        return length(curr) - 1;
    }
}
