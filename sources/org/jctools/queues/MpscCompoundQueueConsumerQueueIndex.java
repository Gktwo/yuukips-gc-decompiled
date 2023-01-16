package org.jctools.queues;

/* compiled from: MpscCompoundQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/MpscCompoundQueueConsumerQueueIndex.class */
abstract class MpscCompoundQueueConsumerQueueIndex<E> extends MpscCompoundQueueMidPad<E> {
    int consumerQueueIndex;

    /* access modifiers changed from: package-private */
    public MpscCompoundQueueConsumerQueueIndex(int capacity, int queueParallelism) {
        super(capacity, queueParallelism);
    }
}
