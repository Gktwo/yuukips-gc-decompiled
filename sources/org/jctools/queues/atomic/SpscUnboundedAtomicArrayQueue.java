package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.Pow2;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpscUnboundedAtomicArrayQueue.class */
public class SpscUnboundedAtomicArrayQueue<E> extends BaseSpscLinkedAtomicArrayQueue<E> {
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return peek();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return offer(obj);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        fill(supplier, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier, int i) {
        return fill(supplier, i);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return drain(consumer, i);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return drain(consumer);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return relaxedPeek();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return relaxedPoll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return relaxedOffer(obj);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return currentConsumerIndex();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return currentProducerIndex();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public SpscUnboundedAtomicArrayQueue(int chunkSize) {
        int chunkCapacity = Math.max(Pow2.roundToPowerOfTwo(chunkSize), 16);
        long mask = (long) (chunkCapacity - 1);
        AtomicReferenceArray<E> buffer = AtomicQueueUtil.allocateRefArray(chunkCapacity + 1);
        this.producerBuffer = buffer;
        this.producerMask = mask;
        this.consumerBuffer = buffer;
        this.consumerMask = mask;
        this.producerBufferLimit = mask - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: org.jctools.queues.atomic.SpscUnboundedAtomicArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue
    final boolean offerColdPath(AtomicReferenceArray<E> buffer, long mask, long pIndex, int offset, E v, MessagePassingQueue.Supplier<? extends E> s) {
        long pBufferLimit = pIndex + ((mask + 1) / 4);
        if (null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(pBufferLimit, mask))) {
            this.producerBufferLimit = pBufferLimit - 1;
            writeToQueue(buffer, v == null ? s.get() : v, pIndex, offset);
            return true;
        } else if (null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex + 1, mask))) {
            writeToQueue(buffer, v == null ? s.get() : v, pIndex, offset);
            return true;
        } else {
            AtomicReferenceArray<E> newBuffer = AtomicQueueUtil.allocateRefArray((int) (mask + 2));
            this.producerBuffer = newBuffer;
            this.producerBufferLimit = (pIndex + mask) - 1;
            linkOldToNew(pIndex, buffer, offset, newBuffer, offset, v == null ? s.get() : v);
            return true;
        }
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return fill(s, (int) this.producerMask);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }
}
