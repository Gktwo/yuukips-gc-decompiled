package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: SpscArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/SpscArrayQueueProducerIndexFields.class */
public abstract class SpscArrayQueueProducerIndexFields<E> extends SpscArrayQueueL1Pad<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(SpscArrayQueueProducerIndexFields.class, "producerIndex");
    private volatile long producerIndex;
    protected long producerLimit;

    /* access modifiers changed from: package-private */
    public SpscArrayQueueProducerIndexFields(int capacity) {
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
