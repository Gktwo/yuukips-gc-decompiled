package org.jctools.queues;

import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/LinkedArrayQueueUtil.class */
final class LinkedArrayQueueUtil {
    LinkedArrayQueueUtil() {
    }

    /* access modifiers changed from: package-private */
    public static int length(Object[] buf) {
        return buf.length;
    }

    /* access modifiers changed from: package-private */
    public static long modifiedCalcCircularRefElementOffset(long index, long mask) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((index & mask) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }

    /* access modifiers changed from: package-private */
    public static long nextArrayOffset(Object[] curr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + (((long) (length(curr) - 1)) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
