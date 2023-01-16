package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoublePriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoublePriorityQueues.class */
public final class DoublePriorityQueues {
    private DoublePriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoublePriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoublePriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue implements DoublePriorityQueue {

        /* renamed from: q */
        protected final DoublePriorityQueue f1749q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(DoublePriorityQueue q, Object sync) {
            this.f1749q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(DoublePriorityQueue q) {
            this.f1749q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
        public void enqueue(double x) {
            synchronized (this.sync) {
                this.f1749q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
        public double dequeueDouble() {
            double dequeueDouble;
            synchronized (this.sync) {
                dequeueDouble = this.f1749q.dequeueDouble();
            }
            return dequeueDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
        public double firstDouble() {
            double firstDouble;
            synchronized (this.sync) {
                firstDouble = this.f1749q.firstDouble();
            }
            return firstDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
        public double lastDouble() {
            double lastDouble;
            synchronized (this.sync) {
                lastDouble = this.f1749q.lastDouble();
            }
            return lastDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f1749q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f1749q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f1749q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f1749q.changed();
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.f1749q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
        @Deprecated
        public void enqueue(Double x) {
            synchronized (this.sync) {
                this.f1749q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Double dequeue() {
            Double dequeue;
            synchronized (this.sync) {
                dequeue = this.f1749q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Double first() {
            Double first;
            synchronized (this.sync) {
                first = this.f1749q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Double last() {
            Double last;
            synchronized (this.sync) {
                last = this.f1749q.last();
            }
            return last;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f1749q.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f1749q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static DoublePriorityQueue synchronize(DoublePriorityQueue q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static DoublePriorityQueue synchronize(DoublePriorityQueue q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
