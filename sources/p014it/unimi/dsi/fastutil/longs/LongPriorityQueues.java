package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongPriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongPriorityQueues.class */
public final class LongPriorityQueues {
    private LongPriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongPriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongPriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue implements LongPriorityQueue {

        /* renamed from: q */
        protected final LongPriorityQueue f2442q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(LongPriorityQueue q, Object sync) {
            this.f2442q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(LongPriorityQueue q) {
            this.f2442q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
        public void enqueue(long x) {
            synchronized (this.sync) {
                this.f2442q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
        public long dequeueLong() {
            long dequeueLong;
            synchronized (this.sync) {
                dequeueLong = this.f2442q.dequeueLong();
            }
            return dequeueLong;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
        public long firstLong() {
            long firstLong;
            synchronized (this.sync) {
                firstLong = this.f2442q.firstLong();
            }
            return firstLong;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
        public long lastLong() {
            long lastLong;
            synchronized (this.sync) {
                lastLong = this.f2442q.lastLong();
            }
            return lastLong;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f2442q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f2442q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f2442q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f2442q.changed();
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super Long> comparator() {
            Comparator<? super Long> comparator;
            synchronized (this.sync) {
                comparator = this.f2442q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
        @Deprecated
        public void enqueue(Long x) {
            synchronized (this.sync) {
                this.f2442q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Long dequeue() {
            Long dequeue;
            synchronized (this.sync) {
                dequeue = this.f2442q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Long first() {
            Long first;
            synchronized (this.sync) {
                first = this.f2442q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Long last() {
            Long last;
            synchronized (this.sync) {
                last = this.f2442q.last();
            }
            return last;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f2442q.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f2442q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static LongPriorityQueue synchronize(LongPriorityQueue q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static LongPriorityQueue synchronize(LongPriorityQueue q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
