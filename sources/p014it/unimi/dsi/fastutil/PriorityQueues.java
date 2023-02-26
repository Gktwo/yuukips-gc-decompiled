package p014it.unimi.dsi.fastutil;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.PriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/PriorityQueues.class */
public class PriorityQueues {
    public static final EmptyPriorityQueue EMPTY_QUEUE = new EmptyPriorityQueue();

    private PriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.PriorityQueues$EmptyPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/PriorityQueues$EmptyPriorityQueue.class */
    public static class EmptyPriorityQueue implements PriorityQueue, Serializable {
        private static final long serialVersionUID = 0;

        protected EmptyPriorityQueue() {
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void enqueue(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public Object dequeue() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public Object first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public Object last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<?> comparator() {
            return null;
        }

        @Override // java.lang.Object
        public Object clone() {
            return PriorityQueues.EMPTY_QUEUE;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof PriorityQueue) && ((PriorityQueue) o).isEmpty();
        }

        private Object readResolve() {
            return PriorityQueues.EMPTY_QUEUE;
        }
    }

    public static <K> PriorityQueue<K> emptyQueue() {
        return EMPTY_QUEUE;
    }

    /* renamed from: it.unimi.dsi.fastutil.PriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/PriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue<K> implements PriorityQueue<K>, Serializable {
        public static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: q */
        protected final PriorityQueue<K> f1003q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(PriorityQueue<K> q, Object sync) {
            this.f1003q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(PriorityQueue<K> q) {
            this.f1003q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void enqueue(K x) {
            synchronized (this.sync) {
                this.f1003q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public K dequeue() {
            K dequeue;
            synchronized (this.sync) {
                dequeue = this.f1003q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public K first() {
            K first;
            synchronized (this.sync) {
                first = this.f1003q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public K last() {
            K last;
            synchronized (this.sync) {
                last = this.f1003q.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f1003q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f1003q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f1003q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f1003q.changed();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.f1003q.comparator();
            }
            return comparator;
        }

        @Override // java.lang.Object
        public String toString() {
            String obj;
            synchronized (this.sync) {
                obj = this.f1003q.toString();
            }
            return obj;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f1003q.hashCode();
            }
            return hashCode;
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f1003q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static <K> PriorityQueue<K> synchronize(PriorityQueue<K> q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static <K> PriorityQueue<K> synchronize(PriorityQueue<K> q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
