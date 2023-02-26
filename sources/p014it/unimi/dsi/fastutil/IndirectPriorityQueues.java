package p014it.unimi.dsi.fastutil;

import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.IndirectPriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/IndirectPriorityQueues.class */
public class IndirectPriorityQueues {
    public static final EmptyIndirectPriorityQueue EMPTY_QUEUE = new EmptyIndirectPriorityQueue();

    private IndirectPriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.IndirectPriorityQueues$EmptyIndirectPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/IndirectPriorityQueues$EmptyIndirectPriorityQueue.class */
    public static class EmptyIndirectPriorityQueue implements IndirectPriorityQueue {
        protected EmptyIndirectPriorityQueue() {
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void enqueue(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int dequeue() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int size() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public boolean contains(int index) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void clear() {
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int first() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int last() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void changed() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void allChanged() {
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public Comparator<?> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void changed(int i) {
            throw new IllegalArgumentException("Index " + i + " is not in the queue");
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public boolean remove(int i) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int front(int[] a) {
            return 0;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.IndirectPriorityQueues$SynchronizedIndirectPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/IndirectPriorityQueues$SynchronizedIndirectPriorityQueue.class */
    public static class SynchronizedIndirectPriorityQueue<K> implements IndirectPriorityQueue<K> {
        public static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: q */
        protected final IndirectPriorityQueue<K> f1002q;
        protected final Object sync;

        protected SynchronizedIndirectPriorityQueue(IndirectPriorityQueue<K> q, Object sync) {
            this.f1002q = q;
            this.sync = sync;
        }

        protected SynchronizedIndirectPriorityQueue(IndirectPriorityQueue<K> q) {
            this.f1002q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void enqueue(int x) {
            synchronized (this.sync) {
                this.f1002q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int dequeue() {
            int dequeue;
            synchronized (this.sync) {
                dequeue = this.f1002q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public boolean contains(int index) {
            boolean contains;
            synchronized (this.sync) {
                contains = this.f1002q.contains(index);
            }
            return contains;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int first() {
            int first;
            synchronized (this.sync) {
                first = this.f1002q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int last() {
            int last;
            synchronized (this.sync) {
                last = this.f1002q.last();
            }
            return last;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f1002q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f1002q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f1002q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f1002q.changed();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void allChanged() {
            synchronized (this.sync) {
                this.f1002q.allChanged();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public void changed(int i) {
            synchronized (this.sync) {
                this.f1002q.changed(i);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public boolean remove(int i) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.f1002q.remove(i);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.f1002q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
        public int front(int[] a) {
            return this.f1002q.front(a);
        }
    }

    public static <K> IndirectPriorityQueue<K> synchronize(IndirectPriorityQueue<K> q) {
        return new SynchronizedIndirectPriorityQueue(q);
    }

    public static <K> IndirectPriorityQueue<K> synchronize(IndirectPriorityQueue<K> q, Object sync) {
        return new SynchronizedIndirectPriorityQueue(q, sync);
    }
}
