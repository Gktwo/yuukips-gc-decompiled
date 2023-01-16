package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: MpscBlockingConsumerArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/MpscBlockingConsumerArrayQueueProducerFields.class */
public abstract class MpscBlockingConsumerArrayQueueProducerFields<E> extends MpscBlockingConsumerArrayQueuePad2<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscBlockingConsumerArrayQueueProducerFields.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: package-private */
    public MpscBlockingConsumerArrayQueueProducerFields(long mask, E[] buffer) {
        super(mask, buffer);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final void soProducerIndex(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, newValue);
    }

    final boolean casProducerIndex(long expect, long newValue) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, expect, newValue);
    }
}
