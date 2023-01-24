package org.jctools.queues;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* compiled from: MpscCompoundQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/MpscCompoundQueueColdFields.class */
abstract class MpscCompoundQueueColdFields<E> extends MpscCompoundQueueL0Pad<E> {
    protected final int parallelQueues;
    protected final int parallelQueuesMask;
    protected final MpscArrayQueue<E>[] queues;

    /* access modifiers changed from: package-private */
    public MpscCompoundQueueColdFields(int capacity, int queueParallelism) {
        this.parallelQueues = Pow2.isPowerOfTwo(queueParallelism) ? queueParallelism : Pow2.roundToPowerOfTwo(queueParallelism) / 2;
        this.parallelQueuesMask = this.parallelQueues - 1;
        this.queues = new MpscArrayQueue[this.parallelQueues];
        int fullCapacity = Pow2.roundToPowerOfTwo(capacity);
        RangeUtil.checkGreaterThanOrEqual(fullCapacity, this.parallelQueues, "fullCapacity");
        for (int i = 0; i < this.parallelQueues; i++) {
            this.queues[i] = new MpscArrayQueue<>(fullCapacity / this.parallelQueues);
        }
    }
}
