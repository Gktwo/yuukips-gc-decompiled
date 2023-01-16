package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortPriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortPriorityQueues.class */
public final class ShortPriorityQueues {
    private ShortPriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortPriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortPriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue implements ShortPriorityQueue {

        /* renamed from: q */
        protected final ShortPriorityQueue f3068q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(ShortPriorityQueue q, Object sync) {
            this.f3068q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(ShortPriorityQueue q) {
            this.f3068q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
        public void enqueue(short x) {
            synchronized (this.sync) {
                this.f3068q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
        public short dequeueShort() {
            short dequeueShort;
            synchronized (this.sync) {
                dequeueShort = this.f3068q.dequeueShort();
            }
            return dequeueShort;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
        public short firstShort() {
            short firstShort;
            synchronized (this.sync) {
                firstShort = this.f3068q.firstShort();
            }
            return firstShort;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
        public short lastShort() {
            short lastShort;
            synchronized (this.sync) {
                lastShort = this.f3068q.lastShort();
            }
            return lastShort;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f3068q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f3068q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f3068q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f3068q.changed();
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.f3068q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
        @Deprecated
        public void enqueue(Short x) {
            synchronized (this.sync) {
                this.f3068q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Short dequeue() {
            Short dequeue;
            synchronized (this.sync) {
                dequeue = this.f3068q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Short first() {
            Short first;
            synchronized (this.sync) {
                first = this.f3068q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Short last() {
            Short last;
            synchronized (this.sync) {
                last = this.f3068q.last();
            }
            return last;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f3068q.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f3068q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static ShortPriorityQueue synchronize(ShortPriorityQueue q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static ShortPriorityQueue synchronize(ShortPriorityQueue q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
