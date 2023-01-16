package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/MpscAtomicArrayQueue.class */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public MpscAtomicArrayQueue(int capacity) {
        super(capacity);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    public boolean offerIfBelowThreshold(E e, int threshold) {
        long pIndex;
        if (null == e) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long capacity = (long) (mask + 1);
        char lvProducerLimit = lvProducerLimit();
        do {
            pIndex = lvProducerIndex();
            if (capacity - (lvProducerLimit - pIndex) >= ((long) threshold)) {
                long cIndex = lvConsumerIndex();
                if (pIndex - cIndex >= ((long) threshold)) {
                    return false;
                }
                lvProducerLimit = cIndex + capacity;
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(pIndex, pIndex + 1));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex, (long) mask), e);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean offer(E r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r9
            if (r0 != r1) goto L_0x000d
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x000d:
            r0 = r8
            int r0 = r0.mask
            r10 = r0
            r0 = r8
            long r0 = r0.lvProducerLimit()
            r11 = r0
        L_0x0017:
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r13 = r0
            r0 = r13
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0040
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r15 = r0
            r0 = r15
            r1 = r10
            long r1 = (long) r1
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 + r1
            r11 = r0
            r0 = r13
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x003b
            r0 = 0
            return r0
        L_0x003b:
            r0 = r8
            r1 = r11
            r0.soProducerLimit(r1)
        L_0x0040:
            r0 = r8
            r1 = r13
            r2 = r13
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casProducerIndex(r1, r2)
            if (r0 == 0) goto L_0x0017
            r0 = r13
            r1 = r10
            long r1 = (long) r1
            int r0 = p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, r1)
            r15 = r0
            r0 = r8
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r1 = r15
            r2 = r9
            p013io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r1, r2)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue.offer(java.lang.Object):boolean");
    }

    public final int failFastOffer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long capacity = (long) (mask + 1);
        long pIndex = lvProducerIndex();
        if (pIndex >= lvProducerLimit()) {
            long producerLimit = lvConsumerIndex() + capacity;
            if (pIndex >= producerLimit) {
                return 1;
            }
            soProducerLimit(producerLimit);
        }
        if (!casProducerIndex(pIndex, pIndex + 1)) {
            return -1;
        }
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex, (long) mask), e);
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long cIndex = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) this.mask);
        AtomicReferenceArray<E> buffer = this.buffer;
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null != e) {
            AtomicQueueUtil.spRefElement(buffer, offset, null);
            soConsumerIndex(cIndex + 1);
            return e;
        } else if (cIndex == lvProducerIndex()) {
            return null;
        } else {
            do {
                e = AtomicQueueUtil.lvRefElement(buffer, offset);
            } while (e == null);
            AtomicQueueUtil.spRefElement(buffer, offset, null);
            soConsumerIndex(cIndex + 1);
            return e;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> buffer = this.buffer;
        long cIndex = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) this.mask);
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null != e) {
            return e;
        }
        if (cIndex == lvProducerIndex()) {
            return null;
        }
        do {
            e = AtomicQueueUtil.lvRefElement(buffer, offset);
        } while (e == null);
        return e;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> buffer = this.buffer;
        long cIndex = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) this.mask);
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null == e) {
            return null;
        }
        AtomicQueueUtil.spRefElement(buffer, offset, null);
        soConsumerIndex(cIndex + 1);
        return e;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), (long) this.mask));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Consumer<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c, int limit) {
        if (0 == c) {
            throw new IllegalArgumentException("c is null");
        } else if (limit < 0) {
            throw new IllegalArgumentException("limit is negative: " + limit);
        } else if (limit == 0) {
            return 0;
        } else {
            AtomicReferenceArray<E> buffer = this.buffer;
            int mask = this.mask;
            long cIndex = lpConsumerIndex();
            for (int i = 0; i < limit; i++) {
                long index = cIndex + ((long) i);
                int offset = AtomicQueueUtil.calcCircularRefElementOffset(index, (long) mask);
                Object lvRefElement = AtomicQueueUtil.lvRefElement(buffer, offset);
                if (null == lvRefElement) {
                    return i;
                }
                AtomicQueueUtil.spRefElement(buffer, offset, null);
                soConsumerIndex(index + 1);
                c.accept(lvRefElement);
            }
            return limit;
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s, int limit) {
        long pIndex;
        int actualLimit;
        if (null == s) {
            throw new IllegalArgumentException("supplier is null");
        } else if (limit < 0) {
            throw new IllegalArgumentException("limit is negative:" + limit);
        } else if (limit == 0) {
            return 0;
        } else {
            int mask = this.mask;
            long capacity = (long) (mask + 1);
            char lvProducerLimit = lvProducerLimit();
            do {
                pIndex = lvProducerIndex();
                char c = lvProducerLimit - pIndex;
                if (c <= 0) {
                    lvProducerLimit = lvConsumerIndex() + capacity;
                    c = lvProducerLimit - pIndex;
                    if (c <= 0) {
                        return 0;
                    }
                    soProducerLimit(lvProducerLimit);
                }
                actualLimit = Math.min((int) c, limit);
            } while (!casProducerIndex(pIndex, pIndex + ((long) actualLimit)));
            AtomicReferenceArray<E> buffer = this.buffer;
            for (int i = 0; i < actualLimit; i++) {
                AtomicQueueUtil.soRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex + ((long) i), (long) mask), s.get());
            }
            return actualLimit;
        }
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return drain(c, capacity());
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return MessagePassingQueueUtil.fillBounded(this, s);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy w, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, w, exit);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }

    @Deprecated
    public int weakOffer(E e) {
        return failFastOffer(e);
    }
}
