package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/MpscGrowableAtomicArrayQueue.class */
public class MpscGrowableAtomicArrayQueue<E> extends MpscChunkedAtomicArrayQueue<E> {
    public MpscGrowableAtomicArrayQueue(int maxCapacity) {
        super(Math.max(2, Pow2.roundToPowerOfTwo(maxCapacity / 8)), maxCapacity);
    }

    public MpscGrowableAtomicArrayQueue(int initialCapacity, int maxCapacity) {
        super(initialCapacity, maxCapacity);
    }

    @Override // org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue, org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected int getNextBufferSize(AtomicReferenceArray<E> buffer) {
        RangeUtil.checkLessThanOrEqual(AtomicQueueUtil.length(buffer), this.maxQueueCapacity / 2, "buffer.length");
        return (2 * (AtomicQueueUtil.length(buffer) - 1)) + 1;
    }

    @Override // org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue, org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected long getCurrentBufferCapacity(long mask) {
        return mask + 2 == this.maxQueueCapacity ? this.maxQueueCapacity : mask;
    }
}
