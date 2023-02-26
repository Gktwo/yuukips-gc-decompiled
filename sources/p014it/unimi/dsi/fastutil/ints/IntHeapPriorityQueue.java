package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.ints.IntHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntHeapPriorityQueue.class */
public class IntHeapPriorityQueue implements IntPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient int[] heap;
    protected int size;

    /* renamed from: c */
    protected IntComparator f2134c;

    public IntHeapPriorityQueue(int capacity, IntComparator c) {
        this.heap = IntArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new int[capacity];
        }
        this.f2134c = c;
    }

    public IntHeapPriorityQueue(int capacity) {
        this(capacity, (IntComparator) null);
    }

    public IntHeapPriorityQueue(IntComparator c) {
        this(0, c);
    }

    public IntHeapPriorityQueue() {
        this(0, (IntComparator) null);
    }

    public IntHeapPriorityQueue(int[] a, int size, IntComparator c) {
        this(c);
        this.heap = a;
        this.size = size;
        IntHeaps.makeHeap(a, size, c);
    }

    public IntHeapPriorityQueue(int[] a, IntComparator c) {
        this(a, a.length, c);
    }

    public IntHeapPriorityQueue(int[] a, int size) {
        this(a, size, null);
    }

    public IntHeapPriorityQueue(int[] a) {
        this(a, a.length);
    }

    public IntHeapPriorityQueue(IntCollection collection, IntComparator c) {
        this(collection.toIntArray(), c);
    }

    public IntHeapPriorityQueue(IntCollection collection) {
        this(collection, (IntComparator) null);
    }

    public IntHeapPriorityQueue(Collection<? extends Integer> collection, IntComparator c) {
        this(collection.size(), c);
        Iterator<? extends Integer> iterator = collection.iterator();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            this.heap[i] = ((Integer) iterator.next()).intValue();
        }
    }

    public IntHeapPriorityQueue(Collection<? extends Integer> collection) {
        this(collection, (IntComparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
    public void enqueue(int x) {
        if (this.size == this.heap.length) {
            this.heap = IntArrays.grow(this.heap, this.size + 1);
        }
        int[] iArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        iArr[i] = x;
        IntHeaps.upHeap(this.heap, this.size, this.size - 1, this.f2134c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
    public int dequeueInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int result = this.heap[0];
        int[] iArr = this.heap;
        int[] iArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        iArr[0] = iArr2[i];
        if (this.size != 0) {
            IntHeaps.downHeap(this.heap, this.size, 0, this.f2134c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
    public int firstInt() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        IntHeaps.downHeap(this.heap, this.size, 0, this.f2134c);
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
        this.heap = IntArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Integer> comparator() {
        return this.f2134c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeInt(this.heap[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = new int[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readInt();
        }
    }
}
