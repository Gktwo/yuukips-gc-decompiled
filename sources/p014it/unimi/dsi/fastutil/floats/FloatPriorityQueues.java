package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatPriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatPriorityQueues.class */
public final class FloatPriorityQueues {
    private FloatPriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatPriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatPriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue implements FloatPriorityQueue {

        /* renamed from: q */
        protected final FloatPriorityQueue f1970q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(FloatPriorityQueue q, Object sync) {
            this.f1970q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(FloatPriorityQueue q) {
            this.f1970q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
        public void enqueue(float x) {
            synchronized (this.sync) {
                this.f1970q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
        public float dequeueFloat() {
            float dequeueFloat;
            synchronized (this.sync) {
                dequeueFloat = this.f1970q.dequeueFloat();
            }
            return dequeueFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
        public float firstFloat() {
            float firstFloat;
            synchronized (this.sync) {
                firstFloat = this.f1970q.firstFloat();
            }
            return firstFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
        public float lastFloat() {
            float lastFloat;
            synchronized (this.sync) {
                lastFloat = this.f1970q.lastFloat();
            }
            return lastFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f1970q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f1970q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f1970q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f1970q.changed();
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.f1970q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
        @Deprecated
        public void enqueue(Float x) {
            synchronized (this.sync) {
                this.f1970q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Float dequeue() {
            Float dequeue;
            synchronized (this.sync) {
                dequeue = this.f1970q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Float first() {
            Float first;
            synchronized (this.sync) {
                first = this.f1970q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Float last() {
            Float last;
            synchronized (this.sync) {
                last = this.f1970q.last();
            }
            return last;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f1970q.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f1970q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static FloatPriorityQueue synchronize(FloatPriorityQueue q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static FloatPriorityQueue synchronize(FloatPriorityQueue q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
