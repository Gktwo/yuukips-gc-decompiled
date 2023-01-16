package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: BaseSpscLinkedAtomicArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/BaseSpscLinkedAtomicArrayQueueProducerColdFields.class */
abstract class BaseSpscLinkedAtomicArrayQueueProducerColdFields<E> extends BaseSpscLinkedAtomicArrayQueueProducerFields<E> {
    protected long producerBufferLimit;
    protected long producerMask;
    protected AtomicReferenceArray<E> producerBuffer;
}
