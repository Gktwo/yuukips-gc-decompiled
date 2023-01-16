package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: MpmcAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/MpmcAtomicArrayQueueConsumerIndexField.class */
public abstract class MpmcAtomicArrayQueueConsumerIndexField<E> extends MpmcAtomicArrayQueueL2Pad<E> {
    private static final AtomicLongFieldUpdater<MpmcAtomicArrayQueueConsumerIndexField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpmcAtomicArrayQueueConsumerIndexField.class, "consumerIndex");
    private volatile long consumerIndex;

    /* access modifiers changed from: package-private */
    public MpmcAtomicArrayQueueConsumerIndexField(int capacity) {
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
