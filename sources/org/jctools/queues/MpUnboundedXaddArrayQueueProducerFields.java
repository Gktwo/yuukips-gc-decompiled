package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: MpUnboundedXaddArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/MpUnboundedXaddArrayQueueProducerFields.class */
abstract class MpUnboundedXaddArrayQueueProducerFields<E> extends MpUnboundedXaddArrayQueuePad1<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddArrayQueueProducerFields.class, "producerIndex");
    private volatile long producerIndex;

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final long getAndIncrementProducerIndex() {
        return UnsafeAccess.UNSAFE.getAndAddLong(this, P_INDEX_OFFSET, 1);
    }

    final long getAndAddProducerIndex(long delta) {
        return UnsafeAccess.UNSAFE.getAndAddLong(this, P_INDEX_OFFSET, delta);
    }
}
