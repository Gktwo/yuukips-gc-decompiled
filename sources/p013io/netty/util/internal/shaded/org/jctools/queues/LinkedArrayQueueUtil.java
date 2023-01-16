package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/LinkedArrayQueueUtil.class */
public final class LinkedArrayQueueUtil {
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

    static long nextArrayOffset(Object[] curr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + (((long) (length(curr) - 1)) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
