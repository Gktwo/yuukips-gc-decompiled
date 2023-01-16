package org.jctools.queues;

import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.Pow2;
import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/SpscUnboundedArrayQueue.class */
public class SpscUnboundedArrayQueue<E> extends BaseSpscLinkedArrayQueue<E> {
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return peek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return offer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        fill(supplier, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier, int i) {
        return fill(supplier, i);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return drain(consumer, i);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return drain(consumer);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return relaxedPeek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return relaxedPoll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return relaxedOffer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return currentConsumerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return currentProducerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public SpscUnboundedArrayQueue(int chunkSize) {
        int chunkCapacity = Math.max(Pow2.roundToPowerOfTwo(chunkSize), 16);
        long mask = (long) (chunkCapacity - 1);
        Object[] allocateRefArray = UnsafeRefArrayAccess.allocateRefArray(chunkCapacity + 1);
        this.producerBuffer = allocateRefArray;
        this.producerMask = mask;
        this.consumerBuffer = allocateRefArray;
        this.consumerMask = mask;
        this.producerBufferLimit = mask - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: org.jctools.queues.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue
    final boolean offerColdPath(E[] buffer, long mask, long pIndex, long offset, E v, MessagePassingQueue.Supplier<? extends E> s) {
        long pBufferLimit = pIndex + ((mask + 1) / 4);
        if (null == UnsafeRefArrayAccess.lvRefElement(buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pBufferLimit, mask))) {
            this.producerBufferLimit = pBufferLimit - 1;
            writeToQueue(buffer, v == null ? s.get() : v, pIndex, offset);
            return true;
        } else if (null == UnsafeRefArrayAccess.lvRefElement(buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex + 1, mask))) {
            writeToQueue(buffer, v == null ? s.get() : v, pIndex, offset);
            return true;
        } else {
            Object[] allocateRefArray = UnsafeRefArrayAccess.allocateRefArray((int) (mask + 2));
            this.producerBuffer = allocateRefArray;
            this.producerBufferLimit = (pIndex + mask) - 1;
            linkOldToNew(pIndex, buffer, offset, allocateRefArray, offset, v == null ? s.get() : v);
            return true;
        }
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return fill(s, (int) this.producerMask);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }
}
