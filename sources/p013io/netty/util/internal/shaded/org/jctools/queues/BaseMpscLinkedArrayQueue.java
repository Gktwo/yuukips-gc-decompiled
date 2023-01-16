package p013io.netty.util.internal.shaded.org.jctools.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import p013io.netty.util.internal.shaded.org.jctools.util.Pow2;
import p013io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/BaseMpscLinkedArrayQueue.class */
public abstract class BaseMpscLinkedArrayQueue<E> extends BaseMpscLinkedArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
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

    protected abstract int getNextBufferSize(E[] eArr);

    protected abstract long getCurrentBufferCapacity(long j);

    static {
        $assertionsDisabled = !BaseMpscLinkedArrayQueue.class.desiredAssertionStatus();
        JUMP = new Object();
        BUFFER_CONSUMED = new Object();
    }

    public BaseMpscLinkedArrayQueue(int initialCapacity) {
        RangeUtil.checkGreaterThanOrEqual(initialCapacity, 2, "initialCapacity");
        int p2capacity = Pow2.roundToPowerOfTwo(initialCapacity);
        long mask = (long) ((p2capacity - 1) << 1);
        Object[] allocateRefArray = UnsafeRefArrayAccess.allocateRefArray(p2capacity + 1);
        this.producerBuffer = allocateRefArray;
        this.producerMask = mask;
        this.consumerBuffer = allocateRefArray;
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

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
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
                Object[] objArr = this.producerBuffer;
                if (producerLimit <= pIndex) {
                    switch (offerSlowPath(mask, pIndex, producerLimit)) {
                        case 2:
                            return false;
                        case 3:
                            resize(mask, objArr, pIndex, e, null);
                            return true;
                    }
                }
                if (casProducerIndex(pIndex, pIndex + 2)) {
                    UnsafeRefArrayAccess.soRefElement(objArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, mask), e);
                    return true;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue<E> */
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
            java.lang.Object[] r0 = r0.consumerBuffer
            r7 = r0
            r0 = r6
            long r0 = r0.lpConsumerIndex()
            r8 = r0
            r0 = r6
            long r0 = r0.consumerMask
            r10 = r0
            r0 = r8
            r1 = r10
            long r0 = p013io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(r0, r1)
            r12 = r0
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r1)
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L_0x0040
            r0 = r8
            r1 = r6
            long r1 = r1.lvProducerIndex()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003e
        L_0x002e:
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r1)
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L_0x002e
            goto L_0x0040
        L_0x003e:
            r0 = 0
            return r0
        L_0x0040:
            r0 = r14
            java.lang.Object r1 = p013io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.JUMP
            if (r0 != r1) goto L_0x0059
            r0 = r6
            r1 = r7
            r2 = r10
            java.lang.Object[] r0 = r0.nextBuffer(r1, r2)
            r15 = r0
            r0 = r6
            r1 = r15
            r2 = r8
            java.lang.Object r0 = r0.newBufferPoll(r1, r2)
            return r0
        L_0x0059:
            r0 = r7
            r1 = r12
            r2 = 0
            p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soRefElement(r0, r1, r2)
            r0 = r6
            r1 = r8
            r2 = 2
            long r1 = r1 + r2
            r0.soConsumerIndex(r1)
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.poll():java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue<E> */
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
            java.lang.Object[] r0 = r0.consumerBuffer
            r7 = r0
            r0 = r6
            long r0 = r0.lpConsumerIndex()
            r8 = r0
            r0 = r6
            long r0 = r0.consumerMask
            r10 = r0
            r0 = r8
            r1 = r10
            long r0 = p013io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(r0, r1)
            r12 = r0
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r1)
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L_0x003b
            r0 = r8
            r1 = r6
            long r1 = r1.lvProducerIndex()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003b
        L_0x002e:
            r0 = r7
            r1 = r12
            java.lang.Object r0 = p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r1)
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L_0x002e
        L_0x003b:
            r0 = r14
            java.lang.Object r1 = p013io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.JUMP
            if (r0 != r1) goto L_0x0050
            r0 = r6
            r1 = r6
            r2 = r7
            r3 = r10
            java.lang.Object[] r1 = r1.nextBuffer(r2, r3)
            r2 = r8
            java.lang.Object r0 = r0.newBufferPeek(r1, r2)
            return r0
        L_0x0050:
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.peek():java.lang.Object");
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

    private E[] nextBuffer(E[] buffer, long mask) {
        long offset = nextArrayOffset(mask);
        E[] nextBuffer = (E[]) ((Object[]) UnsafeRefArrayAccess.lvRefElement(buffer, offset));
        this.consumerBuffer = nextBuffer;
        this.consumerMask = (long) ((LinkedArrayQueueUtil.length(nextBuffer) - 2) << 1);
        UnsafeRefArrayAccess.soRefElement(buffer, offset, BUFFER_CONSUMED);
        return nextBuffer;
    }

    private static long nextArrayOffset(long mask) {
        return LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(mask + 2, LongCompanionObject.MAX_VALUE);
    }

    private E newBufferPoll(E[] nextBuffer, long index) {
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(index, this.consumerMask);
        E n = (E) UnsafeRefArrayAccess.lvRefElement(nextBuffer, offset);
        if (n == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        UnsafeRefArrayAccess.soRefElement(nextBuffer, offset, null);
        soConsumerIndex(index + 2);
        return n;
    }

    private E newBufferPeek(E[] nextBuffer, long index) {
        E n = (E) UnsafeRefArrayAccess.lvRefElement(nextBuffer, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(index, this.consumerMask));
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

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        Object[] objArr = this.consumerBuffer;
        long index = lpConsumerIndex();
        long mask = this.consumerMask;
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(index, mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (e == null) {
            return null;
        }
        if (e == JUMP) {
            return (E) newBufferPoll(nextBuffer(objArr, mask), index);
        }
        UnsafeRefArrayAccess.soRefElement(objArr, offset, null);
        soConsumerIndex(index + 2);
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        Object[] objArr = this.consumerBuffer;
        long index = lpConsumerIndex();
        long mask = this.consumerMask;
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(index, mask));
        if (e == JUMP) {
            return (E) newBufferPeek(nextBuffer(objArr, mask), index);
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

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
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
                    Object[] objArr = this.producerBuffer;
                    long batchIndex = Math.min(producerLimit, pIndex + (2 * ((long) limit)));
                    if (pIndex >= producerLimit) {
                        switch (offerSlowPath(mask, pIndex, producerLimit)) {
                            case 2:
                                return 0;
                            case 3:
                                resize(mask, objArr, pIndex, null, s);
                                return 1;
                        }
                    }
                    if (casProducerIndex(pIndex, batchIndex)) {
                        int claimedSlots = (int) ((batchIndex - pIndex) / 2);
                        for (int i = 0; i < claimedSlots; i++) {
                            UnsafeRefArrayAccess.soRefElement(objArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(pIndex + (2 * ((long) i)), mask), s.get());
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
    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue$WeakIterator */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/BaseMpscLinkedArrayQueue$WeakIterator.class */
    public static class WeakIterator<E> implements Iterator<E> {
        private final long pIndex;
        private long nextIndex;
        private E nextElement = getNext();
        private E[] currentBuffer;
        private int mask;

        WeakIterator(E[] currentBuffer, long cIndex, long pIndex) {
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

        private void setBuffer(E[] buffer) {
            this.currentBuffer = buffer;
            this.mask = LinkedArrayQueueUtil.length(buffer) - 2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue$WeakIterator<E> */
        /* JADX WARN: Multi-variable type inference failed */
        private E getNext() {
            while (this.nextIndex < this.pIndex) {
                long index = this.nextIndex;
                this.nextIndex = index + 1;
                E e = (E) UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(index, (long) this.mask));
                if (e != null) {
                    if (e != BaseMpscLinkedArrayQueue.JUMP) {
                        return e;
                    }
                    Object nextBuffer = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcRefElementOffset((long) (this.mask + 1)));
                    if (nextBuffer == BaseMpscLinkedArrayQueue.BUFFER_CONSUMED || nextBuffer == null) {
                        return null;
                    }
                    setBuffer((Object[]) nextBuffer);
                    E e2 = (E) UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(index, (long) this.mask));
                    if (e2 != null) {
                        return e2;
                    }
                }
            }
            return null;
        }
    }

    private void resize(long oldMask, E[] oldBuffer, long pIndex, E e, MessagePassingQueue.Supplier<E> s) {
        if ($assertionsDisabled || ((e != null && s == null) || e == null || s != null)) {
            int newBufferLength = getNextBufferSize(oldBuffer);
            try {
                Object[] allocateRefArray = UnsafeRefArrayAccess.allocateRefArray(newBufferLength);
                this.producerBuffer = allocateRefArray;
                int newMask = (newBufferLength - 2) << 1;
                this.producerMask = (long) newMask;
                long offsetInOld = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, oldMask);
                UnsafeRefArrayAccess.soRefElement(allocateRefArray, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, (long) newMask), e == null ? s.get() : e);
                UnsafeRefArrayAccess.soRefElement(oldBuffer, nextArrayOffset(oldMask), allocateRefArray);
                long availableInQueue = availableInQueue(pIndex, lvConsumerIndex());
                RangeUtil.checkPositive(availableInQueue, "availableInQueue");
                soProducerLimit(pIndex + Math.min((long) newMask, availableInQueue));
                soProducerIndex(pIndex + 2);
                UnsafeRefArrayAccess.soRefElement(oldBuffer, offsetInOld, JUMP);
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
