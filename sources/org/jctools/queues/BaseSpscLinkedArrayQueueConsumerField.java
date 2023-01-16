package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/BaseSpscLinkedArrayQueueConsumerField.class */
abstract class BaseSpscLinkedArrayQueueConsumerField<E> extends BaseSpscLinkedArrayQueueConsumerColdFields<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseSpscLinkedArrayQueueConsumerField.class, "consumerIndex");
    private volatile long consumerIndex;

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, C_INDEX_OFFSET);
    }

    final void soConsumerIndex(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, newValue);
    }
}
