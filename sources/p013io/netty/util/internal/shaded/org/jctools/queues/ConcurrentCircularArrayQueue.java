package p013io.netty.util.internal.shaded.org.jctools.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil;
import p013io.netty.util.internal.shaded.org.jctools.util.Pow2;
import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/ConcurrentCircularArrayQueue.class */
abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> implements MessagePassingQueue<E>, IndexedQueueSizeUtil.IndexedQueue, QueueProgressIndicators, SupportsIterator {
    protected final long mask;
    protected final E[] buffer;

    /* access modifiers changed from: package-private */
    public ConcurrentCircularArrayQueue(int capacity) {
        int actualCapacity = Pow2.roundToPowerOfTwo(capacity);
        this.mask = (long) (actualCapacity - 1);
        this.buffer = (E[]) UnsafeRefArrayAccess.allocateRefArray(actualCapacity);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
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

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) (this.mask + 1);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new WeakIterator(lvConsumerIndex(), lvProducerIndex(), this.mask, this.buffer);
    }

    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue$WeakIterator */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/ConcurrentCircularArrayQueue$WeakIterator.class */
    private static class WeakIterator<E> implements Iterator<E> {
        private final long pIndex;
        private final long mask;
        private final E[] buffer;
        private long nextIndex;
        private E nextElement = getNext();

        WeakIterator(long cIndex, long pIndex, long mask, E[] buffer) {
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
            while (this.nextIndex < this.pIndex) {
                long j = this.nextIndex;
                this.nextIndex = j + 1;
                E e = (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j, this.mask));
                if (e != null) {
                    return e;
                }
            }
            return null;
        }
    }
}
