package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: MpmcArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/MpmcArrayQueueProducerIndexField.class */
public abstract class MpmcArrayQueueProducerIndexField<E> extends MpmcArrayQueueL1Pad<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpmcArrayQueueProducerIndexField.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: package-private */
    public MpmcArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final boolean casProducerIndex(long expect, long newValue) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, expect, newValue);
    }
}
