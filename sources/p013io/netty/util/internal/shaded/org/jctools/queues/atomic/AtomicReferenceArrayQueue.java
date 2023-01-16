package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import p013io.netty.util.internal.shaded.org.jctools.queues.SupportsIterator;
import p013io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/AtomicReferenceArrayQueue.class */
abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> implements IndexedQueueSizeUtil.IndexedQueue, QueueProgressIndicators, MessagePassingQueue<E>, SupportsIterator {
    protected final AtomicReferenceArray<E> buffer;
    protected final int mask;

    public AtomicReferenceArrayQueue(int capacity) {
        int actualCapacity = Pow2.roundToPowerOfTwo(capacity);
        this.mask = actualCapacity - 1;
        this.buffer = new AtomicReferenceArray<>(actualCapacity);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return getClass().getName();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void clear() {
        do {
        } while (poll() != null);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int capacity() {
        return this.mask + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new WeakIterator(lvConsumerIndex(), lvProducerIndex(), this.mask, this.buffer);
    }

    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue$WeakIterator */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/AtomicReferenceArrayQueue$WeakIterator.class */
    private static class WeakIterator<E> implements Iterator<E> {
        private final long pIndex;
        private final int mask;
        private final AtomicReferenceArray<E> buffer;
        private long nextIndex;
        private E nextElement = getNext();

        WeakIterator(long cIndex, long pIndex, int mask, AtomicReferenceArray<E> buffer) {
            this.nextIndex = cIndex;
            this.pIndex = pIndex;
            this.mask = mask;
            this.buffer = buffer;
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

        private E getNext() {
            int mask = this.mask;
            AtomicReferenceArray<E> buffer = this.buffer;
            while (this.nextIndex < this.pIndex) {
                long j = this.nextIndex;
                this.nextIndex = j + 1;
                E e = (E) AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(j, (long) mask));
                if (e != null) {
                    return e;
                }
            }
            return null;
        }
    }
}
