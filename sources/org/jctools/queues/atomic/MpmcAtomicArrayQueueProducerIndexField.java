package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: MpmcAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/MpmcAtomicArrayQueueProducerIndexField.class */
public abstract class MpmcAtomicArrayQueueProducerIndexField<E> extends MpmcAtomicArrayQueueL1Pad<E> {
    private static final AtomicLongFieldUpdater<MpmcAtomicArrayQueueProducerIndexField> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpmcAtomicArrayQueueProducerIndexField.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: package-private */
    public MpmcAtomicArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final boolean casProducerIndex(long expect, long newValue) {
        return P_INDEX_UPDATER.compareAndSet(this, expect, newValue);
    }
}
