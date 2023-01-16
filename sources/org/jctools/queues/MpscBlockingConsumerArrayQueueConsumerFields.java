package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: MpscBlockingConsumerArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/MpscBlockingConsumerArrayQueueConsumerFields.class */
abstract class MpscBlockingConsumerArrayQueueConsumerFields<E> extends MpscBlockingConsumerArrayQueuePad3<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscBlockingConsumerArrayQueueConsumerFields.class, "consumerIndex");
    private static final long BLOCKED_OFFSET = UnsafeAccess.fieldOffset(MpscBlockingConsumerArrayQueueConsumerFields.class, "blocked");
    private volatile long consumerIndex;
    protected final long consumerMask;
    private volatile Thread blocked;
    protected final E[] consumerBuffer;

    /* access modifiers changed from: package-private */
    public MpscBlockingConsumerArrayQueueConsumerFields(long mask, E[] buffer) {
        super(mask, buffer);
        this.consumerMask = mask;
        this.consumerBuffer = buffer;
    }

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

    final Thread lvBlocked() {
        return this.blocked;
    }

    final void soBlocked(Thread thread) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, BLOCKED_OFFSET, thread);
    }
}
