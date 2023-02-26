package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.ints.IntPriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntPriorityQueues.class */
public final class IntPriorityQueues {
    private IntPriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntPriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntPriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue implements IntPriorityQueue {

        /* renamed from: q */
        protected final IntPriorityQueue f2164q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(IntPriorityQueue q, Object sync) {
            this.f2164q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(IntPriorityQueue q) {
            this.f2164q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
        public void enqueue(int x) {
            synchronized (this.sync) {
                this.f2164q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
        public int dequeueInt() {
            int dequeueInt;
            synchronized (this.sync) {
                dequeueInt = this.f2164q.dequeueInt();
            }
            return dequeueInt;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
        public int firstInt() {
            int firstInt;
            synchronized (this.sync) {
                firstInt = this.f2164q.firstInt();
            }
            return firstInt;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
        public int lastInt() {
            int lastInt;
            synchronized (this.sync) {
                lastInt = this.f2164q.lastInt();
            }
            return lastInt;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f2164q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f2164q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f2164q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f2164q.changed();
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.f2164q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
        @Deprecated
        public void enqueue(Integer x) {
            synchronized (this.sync) {
                this.f2164q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Integer dequeue() {
            Integer dequeue;
            synchronized (this.sync) {
                dequeue = this.f2164q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Integer first() {
            Integer first;
            synchronized (this.sync) {
                first = this.f2164q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Integer last() {
            Integer last;
            synchronized (this.sync) {
                last = this.f2164q.last();
            }
            return last;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f2164q.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f2164q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static IntPriorityQueue synchronize(IntPriorityQueue q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static IntPriorityQueue synchronize(IntPriorityQueue q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
