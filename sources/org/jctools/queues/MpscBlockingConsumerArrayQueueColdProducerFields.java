package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: MpscBlockingConsumerArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/MpscBlockingConsumerArrayQueueColdProducerFields.class */
abstract class MpscBlockingConsumerArrayQueueColdProducerFields<E> extends MpscBlockingConsumerArrayQueuePad1<E> {
    private static final long P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(MpscBlockingConsumerArrayQueueColdProducerFields.class, "producerLimit");
    private volatile long producerLimit;
    protected final long producerMask;
    protected final E[] producerBuffer;

    /* access modifiers changed from: package-private */
    public MpscBlockingConsumerArrayQueueColdProducerFields(long producerMask, E[] producerBuffer) {
        this.producerMask = producerMask;
        this.producerBuffer = producerBuffer;
    }

    final long lvProducerLimit() {
        return this.producerLimit;
    }

    final boolean casProducerLimit(long expect, long newValue) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_LIMIT_OFFSET, expect, newValue);
    }

    final void soProducerLimit(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, newValue);
    }
}
