package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.longs.LongHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongHeapPriorityQueue.class */
public class LongHeapPriorityQueue implements LongPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient long[] heap;
    protected int size;

    /* renamed from: c */
    protected LongComparator f2376c;

    public LongHeapPriorityQueue(int capacity, LongComparator c) {
        this.heap = LongArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new long[capacity];
        }
        this.f2376c = c;
    }

    public LongHeapPriorityQueue(int capacity) {
        this(capacity, (LongComparator) null);
    }

    public LongHeapPriorityQueue(LongComparator c) {
        this(0, c);
    }

    public LongHeapPriorityQueue() {
        this(0, (LongComparator) null);
    }

    public LongHeapPriorityQueue(long[] a, int size, LongComparator c) {
        this(c);
        this.heap = a;
        this.size = size;
        LongHeaps.makeHeap(a, size, c);
    }

    public LongHeapPriorityQueue(long[] a, LongComparator c) {
        this(a, a.length, c);
    }

    public LongHeapPriorityQueue(long[] a, int size) {
        this(a, size, null);
    }

    public LongHeapPriorityQueue(long[] a) {
        this(a, a.length);
    }

    public LongHeapPriorityQueue(LongCollection collection, LongComparator c) {
        this(collection.toLongArray(), c);
    }

    public LongHeapPriorityQueue(LongCollection collection) {
        this(collection, (LongComparator) null);
    }

    public LongHeapPriorityQueue(Collection<? extends Long> collection, LongComparator c) {
        this(collection.size(), c);
        Iterator<? extends Long> iterator = collection.iterator();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            this.heap[i] = ((Long) iterator.next()).longValue();
        }
    }

    public LongHeapPriorityQueue(Collection<? extends Long> collection) {
        this(collection, (LongComparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
    public void enqueue(long x) {
        if (this.size == this.heap.length) {
            this.heap = LongArrays.grow(this.heap, this.size + 1);
        }
        long[] jArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = x;
        LongHeaps.upHeap(this.heap, this.size, this.size - 1, this.f2376c);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
    public long dequeueLong() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        long result = this.heap[0];
        long[] jArr = this.heap;
        long[] jArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        jArr[0] = jArr2[i];
        if (this.size != 0) {
            LongHeaps.downHeap(this.heap, this.size, 0, this.f2376c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
    public long firstLong() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        LongHeaps.downHeap(this.heap, this.size, 0, this.f2376c);
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void clear() {
        this.size = 0;
    }

    public void trim() {
        this.heap = LongArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Long> comparator() {
        return this.f2376c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeLong(this.heap[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = new long[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readLong();
        }
    }
}
