package org.jctools.queues;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* loaded from: grasscutter.jar:org/jctools/queues/MpscGrowableArrayQueue.class */
public class MpscGrowableArrayQueue<E> extends MpscChunkedArrayQueue<E> {
    public MpscGrowableArrayQueue(int maxCapacity) {
        super(Math.max(2, Pow2.roundToPowerOfTwo(maxCapacity / 8)), maxCapacity);
    }

    public MpscGrowableArrayQueue(int initialCapacity, int maxCapacity) {
        super(initialCapacity, maxCapacity);
    }

    @Override // org.jctools.queues.MpscChunkedArrayQueue, org.jctools.queues.BaseMpscLinkedArrayQueue
    protected int getNextBufferSize(E[] buffer) {
        RangeUtil.checkLessThanOrEqual(LinkedArrayQueueUtil.length(buffer), this.maxQueueCapacity / 2, "buffer.length");
        return (2 * (LinkedArrayQueueUtil.length(buffer) - 1)) + 1;
    }

    @Override // org.jctools.queues.MpscChunkedArrayQueue, org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long getCurrentBufferCapacity(long mask) {
        return mask + 2 == this.maxQueueCapacity ? this.maxQueueCapacity : mask;
    }
}
