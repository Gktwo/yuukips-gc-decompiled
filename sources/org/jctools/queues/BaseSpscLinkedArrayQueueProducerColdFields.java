package org.jctools.queues;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/BaseSpscLinkedArrayQueueProducerColdFields.class */
abstract class BaseSpscLinkedArrayQueueProducerColdFields<E> extends BaseSpscLinkedArrayQueueProducerFields<E> {
    protected long producerBufferLimit;
    protected long producerMask;
    protected E[] producerBuffer;
}
