package org.jctools.queues;

import org.jctools.queues.MpUnboundedXaddChunk;
import org.jctools.util.UnsafeAccess;

/* compiled from: MpUnboundedXaddArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/MpUnboundedXaddArrayQueueProducerChunk.class */
public abstract class MpUnboundedXaddArrayQueueProducerChunk<R extends MpUnboundedXaddChunk<R, E>, E> extends MpUnboundedXaddArrayQueuePad2<E> {
    private static final long P_CHUNK_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddArrayQueueProducerChunk.class, "producerChunk");
    private static final long P_CHUNK_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddArrayQueueProducerChunk.class, "producerChunkIndex");
    private volatile R producerChunk;
    private volatile long producerChunkIndex;

    final long lvProducerChunkIndex() {
        return this.producerChunkIndex;
    }

    final boolean casProducerChunkIndex(long expected, long value) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_CHUNK_INDEX_OFFSET, expected, value);
    }

    final void soProducerChunkIndex(long value) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_CHUNK_INDEX_OFFSET, value);
    }

    final R lvProducerChunk() {
        return this.producerChunk;
    }

    final void soProducerChunk(R chunk) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, P_CHUNK_OFFSET, chunk);
    }
}
