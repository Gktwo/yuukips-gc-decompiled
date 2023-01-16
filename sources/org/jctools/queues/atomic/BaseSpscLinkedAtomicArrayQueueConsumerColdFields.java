package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: BaseSpscLinkedAtomicArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/BaseSpscLinkedAtomicArrayQueueConsumerColdFields.class */
abstract class BaseSpscLinkedAtomicArrayQueueConsumerColdFields<E> extends BaseSpscLinkedAtomicArrayQueuePrePad<E> {
    protected long consumerMask;
    protected AtomicReferenceArray<E> consumerBuffer;
}
