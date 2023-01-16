package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: BaseSpscLinkedAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/BaseSpscLinkedAtomicArrayQueueProducerFields.class */
public abstract class BaseSpscLinkedAtomicArrayQueueProducerFields<E> extends BaseSpscLinkedAtomicArrayQueueL2Pad<E> {
    private static final AtomicLongFieldUpdater<BaseSpscLinkedAtomicArrayQueueProducerFields> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseSpscLinkedAtomicArrayQueueProducerFields.class, "producerIndex");
    private volatile long producerIndex;

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final void soProducerIndex(long newValue) {
        P_INDEX_UPDATER.lazySet(this, newValue);
    }

    final long lpProducerIndex() {
        return this.producerIndex;
    }
}
