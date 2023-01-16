package org.jctools.queues;

import org.jctools.queues.MpUnboundedXaddChunk;
import org.jctools.util.UnsafeAccess;

/* compiled from: MpUnboundedXaddArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/MpUnboundedXaddArrayQueueConsumerFields.class */
public abstract class MpUnboundedXaddArrayQueueConsumerFields<R extends MpUnboundedXaddChunk<R, E>, E> extends MpUnboundedXaddArrayQueuePad3<R, E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddArrayQueueConsumerFields.class, "consumerIndex");
    private static final long C_CHUNK_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddArrayQueueConsumerFields.class, "consumerChunk");
    private volatile long consumerIndex;
    private volatile R consumerChunk;

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final boolean casConsumerIndex(long expect, long newValue) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, expect, newValue);
    }

    final R lpConsumerChunk() {
        return (R) ((MpUnboundedXaddChunk) UnsafeAccess.UNSAFE.getObject(this, C_CHUNK_OFFSET));
    }

    final R lvConsumerChunk() {
        return this.consumerChunk;
    }

    final void soConsumerChunk(R newValue) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, C_CHUNK_OFFSET, newValue);
    }

    final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, C_INDEX_OFFSET);
    }

    final void soConsumerIndex(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, newValue);
    }
}
