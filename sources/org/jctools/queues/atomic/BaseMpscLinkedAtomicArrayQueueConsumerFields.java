package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: BaseMpscLinkedAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/BaseMpscLinkedAtomicArrayQueueConsumerFields.class */
public abstract class BaseMpscLinkedAtomicArrayQueueConsumerFields<E> extends BaseMpscLinkedAtomicArrayQueuePad2<E> {
    private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueConsumerFields> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueConsumerFields.class, "consumerIndex");
    private volatile long consumerIndex;
    protected long consumerMask;
    protected AtomicReferenceArray<E> consumerBuffer;

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final long lpConsumerIndex() {
        return this.consumerIndex;
    }

    final void soConsumerIndex(long newValue) {
        C_INDEX_UPDATER.lazySet(this, newValue);
    }
}
