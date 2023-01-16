package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.LongCompanionObject;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import p013io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import p013io.netty.util.internal.shaded.org.jctools.util.Pow2;
import p013io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/BaseMpscLinkedAtomicArrayQueue.class */
public abstract class BaseMpscLinkedAtomicArrayQueue<E> extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final Object JUMP;
    private static final Object BUFFER_CONSUMED;
    private static final int CONTINUE_TO_P_INDEX_CAS = 0;
    private static final int RETRY = 1;
    private static final int QUEUE_FULL = 2;
    private static final int QUEUE_RESIZE = 3;
    static final /* synthetic */ boolean $assertionsDisabled;

    protected abstract long availableInQueue(long j, long j2);

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public abstract int capacity();

    protected abstract int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray);

    protected abstract long getCurrentBufferCapacity(long j);

    static {
        $assertionsDisabled = !BaseMpscLinkedAtomicArrayQueue.class.desiredAssertionStatus();
        JUMP = new Object();
        BUFFER_CONSUMED = new Object();
    }

    public BaseMpscLinkedAtomicArrayQueue(int initialCapacity) {
        RangeUtil.checkGreaterThanOrEqual(initialCapacity, 2, "initialCapacity");
        int p2capacity = Pow2.roundToPowerOfTwo(initialCapacity);
        long mask = (long) ((p2capacity - 1) << 1);
        AtomicReferenceArray<E> buffer = AtomicQueueUtil.allocateRefArray(p2capacity + 1);
        this.producerBuffer = buffer;
        this.producerMask = mask;
        this.consumerBuffer = buffer;
        this.consumerMask = mask;
        soProducerLimit(mask);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int size() {
        long currentProducerIndex;
        char lvConsumerIndex = lvConsumerIndex();
        do {
            currentProducerIndex = lvProducerIndex();
            lvConsumerIndex = lvConsumerIndex();
        } while (lvConsumerIndex != lvConsumerIndex);
        long size = (currentProducerIndex - lvConsumerIndex) >> 1;
        if (size > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return getClass().getName();
    }

    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        while (true) {
            long producerLimit = lvProducerLimit();
            long pIndex = lvProducerIndex();
            if ((pIndex & 1) != 1) {
                long mask = this.producerMask;
                AtomicReferenceArray<E> buffer = this.producerBuffer;
                if (producerLimit <= pIndex) {
                    switch (offerSlowPath(mask, pIndex, producerLimit)) {
                        case 2:
                            return false;
                        case 3:
                            resize(mask, buffer, pIndex, e, null);
                            return true;
                    }
                }
                if (casProducerIndex(pIndex, pIndex + 2)) {
                    AtomicQueueUtil.soRefElement(buffer, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, mask), e);
                    return true;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059  */
    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E poll() {
        /*
            r6 = this;
            r0 = r6
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.consumerBuffer
            r7 = r0
            r0 = r6
            long r0 = r0.lpConsumerIndex()
            r8 = r0
            r0 = r6
            long r0 = r0.consumerMask
            r10 = r0
            r0 = r8
            r1 = r10
            int r0 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.modifiedCalcCircularRefElementOffset(r0, r1)
            r12 = r0
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r1)
            r13 = r0
            r0 = r13
            if (r0 != 0) goto L_0x0040
            r0 = r8
            r1 = r6
            long r1 = r1.lvProducerIndex()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003e
        L_0x002e:
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r1)
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L_0x002e
            goto L_0x0040
        L_0x003e:
            r0 = 0
            return r0
        L_0x0040:
            r0 = r13
            java.lang.Object r1 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.JUMP
            if (r0 != r1) goto L_0x0059
            r0 = r6
            r1 = r7
            r2 = r10
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.nextBuffer(r1, r2)
            r14 = r0
            r0 = r6
            r1 = r14
            r2 = r8
            java.lang.Object r0 = r0.newBufferPoll(r1, r2)
            return r0
        L_0x0059:
            r0 = r7
            r1 = r12
            r2 = 0
            p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r1, r2)
            r0 = r6
            r1 = r8
            r2 = 2
            long r1 = r1 + r2
            r0.soConsumerIndex(r1)
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.poll():java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E peek() {
        /*
            r6 = this;
            r0 = r6
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.consumerBuffer
            r7 = r0
            r0 = r6
            long r0 = r0.lpConsumerIndex()
            r8 = r0
            r0 = r6
            long r0 = r0.consumerMask
            r10 = r0
            r0 = r8
            r1 = r10
            int r0 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.modifiedCalcCircularRefElementOffset(r0, r1)
            r12 = r0
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r1)
            r13 = r0
            r0 = r13
            if (r0 != 0) goto L_0x003b
            r0 = r8
            r1 = r6
            long r1 = r1.lvProducerIndex()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003b
        L_0x002e:
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r1)
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L_0x002e
        L_0x003b:
            r0 = r13
            java.lang.Object r1 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.JUMP
            if (r0 != r1) goto L_0x0050
            r0 = r6
            r1 = r6
            r2 = r7
            r3 = r10
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r1.nextBuffer(r2, r3)
            r2 = r8
            java.lang.Object r0 = r0.newBufferPeek(r1, r2)
            return r0
        L_0x0050:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.peek():java.lang.Object");
    }

    private int offerSlowPath(long mask, long pIndex, long producerLimit) {
        long cIndex = lvConsumerIndex();
        long bufferCapacity = getCurrentBufferCapacity(mask);
        if (cIndex + bufferCapacity > pIndex) {
            if (!casProducerLimit(producerLimit, cIndex + bufferCapacity)) {
                return 1;
            }
            return 0;
        } else if (availableInQueue(pIndex, cIndex) <= 0) {
            return 2;
        } else {
            if (casProducerIndex(pIndex, pIndex + 1)) {
                return 3;
            }
            return 1;
        }
    }

    private AtomicReferenceArray<E> nextBuffer(AtomicReferenceArray<E> buffer, long mask) {
        int offset = nextArrayOffset(mask);
        AtomicReferenceArray<E> nextBuffer = (AtomicReferenceArray) AtomicQueueUtil.lvRefElement(buffer, offset);
        this.consumerBuffer = nextBuffer;
        this.consumerMask = (long) ((AtomicQueueUtil.length(nextBuffer) - 2) << 1);
        AtomicQueueUtil.soRefElement(buffer, offset, BUFFER_CONSUMED);
        return nextBuffer;
    }

    private static int nextArrayOffset(long mask) {
        return AtomicQueueUtil.modifiedCalcCircularRefElementOffset(mask + 2, LongCompanionObject.MAX_VALUE);
    }

    private E newBufferPoll(AtomicReferenceArray<E> nextBuffer, long index) {
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(index, this.consumerMask);
        E n = (E) AtomicQueueUtil.lvRefElement(nextBuffer, offset);
        if (n == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        AtomicQueueUtil.soRefElement(nextBuffer, offset, null);
        soConsumerIndex(index + 2);
        return n;
    }

    private E newBufferPeek(AtomicReferenceArray<E> nextBuffer, long index) {
        E n = (E) AtomicQueueUtil.lvRefElement(nextBuffer, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(index, this.consumerMask));
        if (null != n) {
            return n;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex() / 2;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex() / 2;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> buffer = this.consumerBuffer;
        long index = lpConsumerIndex();
        long mask = this.consumerMask;
        int offset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(index, mask);
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (e == null) {
            return null;
        }
        if (e == JUMP) {
            return newBufferPoll(nextBuffer(buffer, mask), index);
        }
        AtomicQueueUtil.soRefElement(buffer, offset, null);
        soConsumerIndex(index + 2);
        return e;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        AtomicReferenceArray<E> buffer = this.consumerBuffer;
        long index = lpConsumerIndex();
        long mask = this.consumerMask;
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(index, mask));
        if (e == JUMP) {
            return newBufferPeek(nextBuffer(buffer, mask), index);
        }
        return e;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        char c = 0;
        int capacity = capacity();
        do {
            int filled = fill(s, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (filled == 0) {
                return (int) c;
            }
            c += (long) filled;
        } while (c <= ((long) capacity));
        return (int) c;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s, int limit) {
        if (null == s) {
            throw new IllegalArgumentException("supplier is null");
        } else if (limit < 0) {
            throw new IllegalArgumentException("limit is negative:" + limit);
        } else if (limit == 0) {
            return 0;
        } else {
            while (true) {
                long producerLimit = lvProducerLimit();
                long pIndex = lvProducerIndex();
                if ((pIndex & 1) != 1) {
                    long mask = this.producerMask;
                    AtomicReferenceArray<E> buffer = this.producerBuffer;
                    long batchIndex = Math.min(producerLimit, pIndex + (2 * ((long) limit)));
                    if (pIndex >= producerLimit) {
                        switch (offerSlowPath(mask, pIndex, producerLimit)) {
                            case 2:
                                return 0;
                            case 3:
                                resize(mask, buffer, pIndex, null, s);
                                return 1;
                        }
                    }
                    if (casProducerIndex(pIndex, batchIndex)) {
                        int claimedSlots = (int) ((batchIndex - pIndex) / 2);
                        for (int i = 0; i < claimedSlots; i++) {
                            AtomicQueueUtil.soRefElement(buffer, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex + (2 * ((long) i)), mask), s.get());
                        }
                        return claimedSlots;
                    }
                }
            }
        }
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return drain(c, capacity());
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c, int limit) {
        return MessagePassingQueueUtil.drain(this, c, limit);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, wait, exit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new WeakIterator(this.consumerBuffer, lvConsumerIndex(), lvProducerIndex());
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue$WeakIterator */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/BaseMpscLinkedAtomicArrayQueue$WeakIterator.class */
    public static class WeakIterator<E> implements Iterator<E> {
        private final long pIndex;
        private long nextIndex;
        private E nextElement = getNext();
        private AtomicReferenceArray<E> currentBuffer;
        private int mask;

        WeakIterator(AtomicReferenceArray<E> currentBuffer, long cIndex, long pIndex) {
            this.pIndex = pIndex >> 1;
            this.nextIndex = cIndex >> 1;
            setBuffer(currentBuffer);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextElement != null;
        }

        @Override // java.util.Iterator
        public E next() {
            E e = this.nextElement;
            if (e == null) {
                throw new NoSuchElementException();
            }
            this.nextElement = getNext();
            return e;
        }

        private void setBuffer(AtomicReferenceArray<E> buffer) {
            this.currentBuffer = buffer;
            this.mask = AtomicQueueUtil.length(buffer) - 2;
        }

        private E getNext() {
            while (this.nextIndex < this.pIndex) {
                long index = this.nextIndex;
                this.nextIndex = index + 1;
                E e = (E) AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(index, (long) this.mask));
                if (e != null) {
                    if (e != BaseMpscLinkedAtomicArrayQueue.JUMP) {
                        return e;
                    }
                    Object nextBuffer = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcRefElementOffset((long) (this.mask + 1)));
                    if (nextBuffer == BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED || nextBuffer == null) {
                        return null;
                    }
                    setBuffer((AtomicReferenceArray) nextBuffer);
                    E e2 = (E) AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(index, (long) this.mask));
                    if (e2 != null) {
                        return e2;
                    }
                }
            }
            return null;
        }
    }

    private void resize(long oldMask, AtomicReferenceArray<E> oldBuffer, long pIndex, E e, MessagePassingQueue.Supplier<E> s) {
        if ($assertionsDisabled || ((e != null && s == null) || e == null || s != null)) {
            int newBufferLength = getNextBufferSize(oldBuffer);
            try {
                AtomicReferenceArray<E> newBuffer = AtomicQueueUtil.allocateRefArray(newBufferLength);
                this.producerBuffer = newBuffer;
                int newMask = (newBufferLength - 2) << 1;
                this.producerMask = (long) newMask;
                int offsetInOld = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, oldMask);
                AtomicQueueUtil.soRefElement(newBuffer, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, (long) newMask), e == null ? s.get() : e);
                AtomicQueueUtil.soRefElement(oldBuffer, nextArrayOffset(oldMask), newBuffer);
                long availableInQueue = availableInQueue(pIndex, lvConsumerIndex());
                RangeUtil.checkPositive(availableInQueue, "availableInQueue");
                soProducerLimit(pIndex + Math.min((long) newMask, availableInQueue));
                soProducerIndex(pIndex + 2);
                AtomicQueueUtil.soRefElement(oldBuffer, offsetInOld, JUMP);
            } catch (OutOfMemoryError oom) {
                if ($assertionsDisabled || lvProducerIndex() == pIndex + 1) {
                    soProducerIndex(pIndex);
                    throw oom;
                }
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }
}
