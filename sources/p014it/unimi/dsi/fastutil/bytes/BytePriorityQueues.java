package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.bytes.BytePriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/BytePriorityQueues.class */
public final class BytePriorityQueues {
    private BytePriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.BytePriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/BytePriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue implements BytePriorityQueue {

        /* renamed from: q */
        protected final BytePriorityQueue f1264q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(BytePriorityQueue q, Object sync) {
            this.f1264q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(BytePriorityQueue q) {
            this.f1264q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
        public void enqueue(byte x) {
            synchronized (this.sync) {
                this.f1264q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
        public byte dequeueByte() {
            byte dequeueByte;
            synchronized (this.sync) {
                dequeueByte = this.f1264q.dequeueByte();
            }
            return dequeueByte;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
        public byte firstByte() {
            byte firstByte;
            synchronized (this.sync) {
                firstByte = this.f1264q.firstByte();
            }
            return firstByte;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
        public byte lastByte() {
            byte lastByte;
            synchronized (this.sync) {
                lastByte = this.f1264q.lastByte();
            }
            return lastByte;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f1264q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f1264q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f1264q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f1264q.changed();
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super Byte> comparator() {
            Comparator<? super Byte> comparator;
            synchronized (this.sync) {
                comparator = this.f1264q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
        @Deprecated
        public void enqueue(Byte x) {
            synchronized (this.sync) {
                this.f1264q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Byte dequeue() {
            Byte dequeue;
            synchronized (this.sync) {
                dequeue = this.f1264q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Byte first() {
            Byte first;
            synchronized (this.sync) {
                first = this.f1264q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Byte last() {
            Byte last;
            synchronized (this.sync) {
                last = this.f1264q.last();
            }
            return last;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f1264q.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f1264q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static BytePriorityQueue synchronize(BytePriorityQueue q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static BytePriorityQueue synchronize(BytePriorityQueue q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
