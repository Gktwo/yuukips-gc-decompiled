package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: SpmcAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpmcAtomicArrayQueueProducerIndexField.class */
public abstract class SpmcAtomicArrayQueueProducerIndexField<E> extends SpmcAtomicArrayQueueL1Pad<E> {
    private static final AtomicLongFieldUpdater<SpmcAtomicArrayQueueProducerIndexField> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(SpmcAtomicArrayQueueProducerIndexField.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: package-private */
    public SpmcAtomicArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final long lpProducerIndex() {
        return this.producerIndex;
    }

    final void soProducerIndex(long newValue) {
        P_INDEX_UPDATER.lazySet(this, newValue);
    }
}
