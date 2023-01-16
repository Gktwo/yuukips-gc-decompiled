package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: SpmcAtomicArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpmcAtomicArrayQueueConsumerIndexField.class */
abstract class SpmcAtomicArrayQueueConsumerIndexField<E> extends SpmcAtomicArrayQueueL2Pad<E> {
    private static final AtomicLongFieldUpdater<SpmcAtomicArrayQueueConsumerIndexField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(SpmcAtomicArrayQueueConsumerIndexField.class, "consumerIndex");
    private volatile long consumerIndex;

    /* access modifiers changed from: package-private */
    public SpmcAtomicArrayQueueConsumerIndexField(int capacity) {
        super(capacity);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final boolean casConsumerIndex(long expect, long newValue) {
        return C_INDEX_UPDATER.compareAndSet(this, expect, newValue);
    }
}
