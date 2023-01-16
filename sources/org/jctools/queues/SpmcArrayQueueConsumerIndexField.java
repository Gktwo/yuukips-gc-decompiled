package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: SpmcArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/SpmcArrayQueueConsumerIndexField.class */
abstract class SpmcArrayQueueConsumerIndexField<E> extends SpmcArrayQueueL2Pad<E> {
    protected static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(SpmcArrayQueueConsumerIndexField.class, "consumerIndex");
    private volatile long consumerIndex;

    /* access modifiers changed from: package-private */
    public SpmcArrayQueueConsumerIndexField(int capacity) {
        super(capacity);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final boolean casConsumerIndex(long expect, long newValue) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, expect, newValue);
    }
}
