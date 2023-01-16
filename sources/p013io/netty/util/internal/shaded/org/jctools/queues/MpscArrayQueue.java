package p013io.netty.util.internal.shaded.org.jctools.queues;

import java.util.Iterator;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MpscArrayQueue.class */
public class MpscArrayQueue<E> extends MpscArrayQueueL3Pad<E> {
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return currentConsumerIndex();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return currentProducerIndex();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return capacity();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return size();
    }

    public MpscArrayQueue(int capacity) {
        super(capacity);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    public boolean offerIfBelowThreshold(E e, int threshold) {
        long pIndex;
        if (null == e) {
            throw new NullPointerException();
        }
        long mask = this.mask;
        long capacity = mask + 1;
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
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex, mask), e);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v5 */
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
            long r0 = r0.mask
            r10 = r0
            r0 = r8
            long r0 = r0.lvProducerLimit()
            r12 = r0
        L_0x0018:
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r14 = r0
            r0 = r14
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0044
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r16 = r0
            r0 = r16
            r1 = r10
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 + r1
            r12 = r0
            r0 = r14
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x003e
            r0 = 0
            return r0
        L_0x003e:
            r0 = r8
            r1 = r12
            r0.soProducerLimit(r1)
        L_0x0044:
            r0 = r8
            r1 = r14
            r2 = r14
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casProducerIndex(r1, r2)
            if (r0 == 0) goto L_0x0018
            r0 = r14
            r1 = r10
            long r0 = p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.calcCircularRefElementOffset(r0, r1)
            r16 = r0
            r0 = r8
            java.lang.Object[] r0 = r0.buffer
            r1 = r16
            r2 = r9
            p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soRefElement(r0, r1, r2)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue.offer(java.lang.Object):boolean");
    }

    public final int failFastOffer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        long mask = this.mask;
        long capacity = mask + 1;
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
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex, mask), e);
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long cIndex = lpConsumerIndex();
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, this.mask);
        Object[] objArr = this.buffer;
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (null != e) {
            UnsafeRefArrayAccess.spRefElement(objArr, offset, null);
            soConsumerIndex(cIndex + 1);
            return e;
        } else if (cIndex == lvProducerIndex()) {
            return null;
        } else {
            do {
                e = UnsafeRefArrayAccess.lvRefElement(objArr, offset);
            } while (e == null);
            UnsafeRefArrayAccess.spRefElement(objArr, offset, null);
            soConsumerIndex(cIndex + 1);
            return e;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        Object[] objArr = this.buffer;
        long cIndex = lpConsumerIndex();
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, this.mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (null != e) {
            return e;
        }
        if (cIndex == lvProducerIndex()) {
            return null;
        }
        do {
            e = UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        } while (e == null);
        return e;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        Object[] objArr = this.buffer;
        long cIndex = lpConsumerIndex();
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, this.mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (null == e) {
            return null;
        }
        UnsafeRefArrayAccess.spRefElement(objArr, offset, null);
        soConsumerIndex(cIndex + 1);
        return e;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex(), this.mask));
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
            Object[] objArr = this.buffer;
            long mask = this.mask;
            long cIndex = lpConsumerIndex();
            for (int i = 0; i < limit; i++) {
                long index = cIndex + ((long) i);
                long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(index, mask);
                Object lvRefElement = UnsafeRefArrayAccess.lvRefElement(objArr, offset);
                if (null == lvRefElement) {
                    return i;
                }
                UnsafeRefArrayAccess.spRefElement(objArr, offset, null);
                soConsumerIndex(index + 1);
                c.accept(lvRefElement);
            }
            return limit;
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
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
            long mask = this.mask;
            long capacity = mask + 1;
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
            Object[] objArr = this.buffer;
            for (int i = 0; i < actualLimit; i++) {
                UnsafeRefArrayAccess.soRefElement(objArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex + ((long) i), mask), s.get());
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
}
