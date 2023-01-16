package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpscGrowableAtomicArrayQueue.class */
public class SpscGrowableAtomicArrayQueue<E> extends BaseSpscLinkedAtomicArrayQueue<E> {
    private final int maxQueueCapacity;
    private long lookAheadStep;

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

    public SpscGrowableAtomicArrayQueue(int capacity) {
        this(Math.max(8, Pow2.roundToPowerOfTwo(capacity / 8)), capacity);
    }

    public SpscGrowableAtomicArrayQueue(int chunkSize, int capacity) {
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
        adjustLookAheadStep(chunkCapacity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: org.jctools.queues.atomic.SpscGrowableAtomicArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue
    final boolean offerColdPath(AtomicReferenceArray<E> buffer, long mask, long index, int offset, E v, MessagePassingQueue.Supplier<? extends E> s) {
        long lookAheadStep = this.lookAheadStep;
        if (lookAheadStep <= 0) {
            long prevElementsInOtherBuffers = -lookAheadStep;
            long currConsumerIndex = lvConsumerIndex();
            int size = (int) (index - currConsumerIndex);
            int maxCapacity = ((int) mask) + 1;
            if (size == maxCapacity) {
                return false;
            }
            long firstIndexInCurrentBuffer = (this.producerBufferLimit - ((long) maxCapacity)) + prevElementsInOtherBuffers;
            if (currConsumerIndex >= firstIndexInCurrentBuffer) {
                adjustLookAheadStep(maxCapacity);
            } else {
                this.lookAheadStep = (long) ((int) (currConsumerIndex - firstIndexInCurrentBuffer));
            }
            this.producerBufferLimit = currConsumerIndex + ((long) maxCapacity);
            writeToQueue(buffer, v == null ? s.get() : v, index, offset);
            return true;
        } else if (null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(index + lookAheadStep, mask))) {
            this.producerBufferLimit = (index + lookAheadStep) - 1;
            writeToQueue(buffer, v == null ? s.get() : v, index, offset);
            return true;
        } else {
            int maxCapacity2 = this.maxQueueCapacity;
            if (mask + 1 == ((long) maxCapacity2)) {
                if (null != AtomicQueueUtil.lvRefElement(buffer, offset)) {
                    return false;
                }
                writeToQueue(buffer, v == null ? s.get() : v, index, offset);
                return true;
            } else if (null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(index + 1, mask))) {
                writeToQueue(buffer, v == null ? s.get() : v, index, offset);
                return true;
            } else {
                AtomicReferenceArray<E> newBuffer = AtomicQueueUtil.allocateRefArray((int) ((2 * (mask + 1)) + 1));
                this.producerBuffer = newBuffer;
                this.producerMask = (long) (AtomicQueueUtil.length(newBuffer) - 2);
                linkOldToNew(index, buffer, offset, newBuffer, AtomicQueueUtil.calcCircularRefElementOffset(index, this.producerMask), v == null ? s.get() : v);
                int newCapacity = (int) (this.producerMask + 1);
                if (newCapacity == maxCapacity2) {
                    long currConsumerIndex2 = lvConsumerIndex();
                    this.lookAheadStep = -(index - currConsumerIndex2);
                    this.producerBufferLimit = currConsumerIndex2 + ((long) maxCapacity2);
                    return true;
                }
                this.producerBufferLimit = (index + this.producerMask) - 1;
                adjustLookAheadStep(newCapacity);
                return true;
            }
        }
    }

    private void adjustLookAheadStep(int capacity) {
        this.lookAheadStep = (long) Math.min(capacity / 4, SpscAtomicArrayQueue.MAX_LOOK_AHEAD_STEP);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return this.maxQueueCapacity;
    }
}
