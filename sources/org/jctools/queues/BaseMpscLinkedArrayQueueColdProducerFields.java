package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: BaseMpscLinkedArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/BaseMpscLinkedArrayQueueColdProducerFields.class */
abstract class BaseMpscLinkedArrayQueueColdProducerFields<E> extends BaseMpscLinkedArrayQueuePad3<E> {
    private static final long P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(BaseMpscLinkedArrayQueueColdProducerFields.class, "producerLimit");
    private volatile long producerLimit;
    protected long producerMask;
    protected E[] producerBuffer;

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
