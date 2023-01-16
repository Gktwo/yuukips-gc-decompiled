package org.jctools.queues;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/BaseSpscLinkedArrayQueueConsumerColdFields.class */
abstract class BaseSpscLinkedArrayQueueConsumerColdFields<E> extends BaseSpscLinkedArrayQueuePrePad<E> {
    protected long consumerMask;
    protected E[] consumerBuffer;
}
