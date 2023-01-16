package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/BaseSpscLinkedArrayQueueProducerFields.class */
public abstract class BaseSpscLinkedArrayQueueProducerFields<E> extends BaseSpscLinkedArrayQueueL2Pad<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseSpscLinkedArrayQueueProducerFields.class, "producerIndex");
    private volatile long producerIndex;

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final void soProducerIndex(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, newValue);
    }

    final long lpProducerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, P_INDEX_OFFSET);
    }
}
