package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: SpscAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpscAtomicArrayQueueProducerIndexFields.class */
public abstract class SpscAtomicArrayQueueProducerIndexFields<E> extends SpscAtomicArrayQueueL1Pad<E> {
    private static final AtomicLongFieldUpdater<SpscAtomicArrayQueueProducerIndexFields> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(SpscAtomicArrayQueueProducerIndexFields.class, "producerIndex");
    private volatile long producerIndex;
    protected long producerLimit;

    /* access modifiers changed from: package-private */
    public SpscAtomicArrayQueueProducerIndexFields(int capacity) {
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
