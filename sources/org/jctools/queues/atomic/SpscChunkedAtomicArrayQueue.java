package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpscChunkedAtomicArrayQueue.class */
public class SpscChunkedAtomicArrayQueue<E> extends BaseSpscLinkedAtomicArrayQueue<E> {
    private final int maxQueueCapacity;
    private long producerQueueLimit;

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
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return fill(supplier);
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

    public SpscChunkedAtomicArrayQueue(int capacity) {
        this(Math.max(8, Pow2.roundToPowerOfTwo(capacity / 8)), capacity);
    }

    public SpscChunkedAtomicArrayQueue(int chunkSize, int capacity) {
        RangeUtil.checkGreaterThanOrEqual(capacity, 16, "capacity");
        RangeUtil.checkGreaterThanOrEqual(chunkSize, 8, "chunkSize");
        this.maxQueueCapacity = Pow2.roundToPowerOfTwo(capacity);
        int chunkCapacity = Pow2.roundToPowerOfTwo(chunkSize);
        RangeUtil.checkLessThan(chunkCapacity, this.maxQueueCapacity, "chunkCapacity");
        long mask = (long) (chunkCapacity - 1);
        AtomicReferenceArray<E> buffer = AtomicQueueUtil.allocateRefArray(chunkCapacity + 1);
        this.producerBuffer = buffer;
        this.producerMask = mask;
        this.consumerBuffer = buffer;
        this.consumerMask = mask;
        this.producerBufferLimit = mask - 1;
        this.producerQueueLimit = (long) this.maxQueueCapacity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: org.jctools.queues.atomic.SpscChunkedAtomicArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue
    final boolean offerColdPath(AtomicReferenceArray<E> buffer, long mask, long pIndex, int offset, E v, MessagePassingQueue.Supplier<? extends E> s) {
        char c = pIndex + ((mask + 1) / 4);
        char c2 = this.producerQueueLimit;
        if (pIndex >= c2) {
            c2 = this;
            this.producerQueueLimit = lvConsumerIndex() + ((long) this.maxQueueCapacity);
            if (pIndex >= c2) {
                return false;
            }
        }
        if (c - c2 > 0) {
            c = c2;
        }
        if (c > pIndex + 1 && null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(c, mask))) {
            this.producerBufferLimit = c - 1;
            writeToQueue(buffer, v == null ? s.get() : v, pIndex, offset);
            return true;
        } else if (null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex + 1, mask))) {
            writeToQueue(buffer, v == null ? s.get() : v, pIndex, offset);
            return true;
        } else {
            AtomicReferenceArray<E> newBuffer = AtomicQueueUtil.allocateRefArray((int) (mask + 2));
            this.producerBuffer = newBuffer;
            linkOldToNew(pIndex, buffer, offset, newBuffer, offset, v == null ? s.get() : v);
            return true;
        }
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return this.maxQueueCapacity;
    }
}
