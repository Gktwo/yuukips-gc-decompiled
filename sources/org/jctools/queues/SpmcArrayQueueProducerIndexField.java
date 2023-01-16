package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: SpmcArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/SpmcArrayQueueProducerIndexField.class */
public abstract class SpmcArrayQueueProducerIndexField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(SpmcArrayQueueProducerIndexField.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: package-private */
    public SpmcArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final long lpProducerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, P_INDEX_OFFSET);
    }

    final void soProducerIndex(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, newValue);
    }
}
