package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.chars.CharPriorityQueues */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharPriorityQueues.class */
public final class CharPriorityQueues {
    private CharPriorityQueues() {
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharPriorityQueues$SynchronizedPriorityQueue */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharPriorityQueues$SynchronizedPriorityQueue.class */
    public static class SynchronizedPriorityQueue implements CharPriorityQueue {

        /* renamed from: q */
        protected final CharPriorityQueue f1491q;
        protected final Object sync;

        protected SynchronizedPriorityQueue(CharPriorityQueue q, Object sync) {
            this.f1491q = q;
            this.sync = sync;
        }

        protected SynchronizedPriorityQueue(CharPriorityQueue q) {
            this.f1491q = q;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
        public void enqueue(char x) {
            synchronized (this.sync) {
                this.f1491q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
        public char dequeueChar() {
            char dequeueChar;
            synchronized (this.sync) {
                dequeueChar = this.f1491q.dequeueChar();
            }
            return dequeueChar;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
        public char firstChar() {
            char firstChar;
            synchronized (this.sync) {
                firstChar = this.f1491q.firstChar();
            }
            return firstChar;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
        public char lastChar() {
            char lastChar;
            synchronized (this.sync) {
                lastChar = this.f1491q.lastChar();
            }
            return lastChar;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.f1491q.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.f1491q.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void clear() {
            synchronized (this.sync) {
                this.f1491q.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.PriorityQueue
        public void changed() {
            synchronized (this.sync) {
                this.f1491q.changed();
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        public Comparator<? super Character> comparator() {
            Comparator<? super Character> comparator;
            synchronized (this.sync) {
                comparator = this.f1491q.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
        @Deprecated
        public void enqueue(Character x) {
            synchronized (this.sync) {
                this.f1491q.enqueue(x);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Character dequeue() {
            Character dequeue;
            synchronized (this.sync) {
                dequeue = this.f1491q.dequeue();
            }
            return dequeue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Character first() {
            Character first;
            synchronized (this.sync) {
                first = this.f1491q.first();
            }
            return first;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
        @Deprecated
        public Character last() {
            Character last;
            synchronized (this.sync) {
                last = this.f1491q.last();
            }
            return last;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.f1491q.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.f1491q.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static CharPriorityQueue synchronize(CharPriorityQueue q) {
        return new SynchronizedPriorityQueue(q);
    }

    public static CharPriorityQueue synchronize(CharPriorityQueue q, Object sync) {
        return new SynchronizedPriorityQueue(q, sync);
    }
}
