package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleHeapPriorityQueue.class */
public class DoubleHeapPriorityQueue implements DoublePriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient double[] heap;
    protected int size;

    /* renamed from: c */
    protected DoubleComparator f1684c;

    public DoubleHeapPriorityQueue(int capacity, DoubleComparator c) {
        this.heap = DoubleArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new double[capacity];
        }
        this.f1684c = c;
    }

    public DoubleHeapPriorityQueue(int capacity) {
        this(capacity, (DoubleComparator) null);
    }

    public DoubleHeapPriorityQueue(DoubleComparator c) {
        this(0, c);
    }

    public DoubleHeapPriorityQueue() {
        this(0, (DoubleComparator) null);
    }

    public DoubleHeapPriorityQueue(double[] a, int size, DoubleComparator c) {
        this(c);
        this.heap = a;
        this.size = size;
        DoubleHeaps.makeHeap(a, size, c);
    }

    public DoubleHeapPriorityQueue(double[] a, DoubleComparator c) {
        this(a, a.length, c);
    }

    public DoubleHeapPriorityQueue(double[] a, int size) {
        this(a, size, null);
    }

    public DoubleHeapPriorityQueue(double[] a) {
        this(a, a.length);
    }

    public DoubleHeapPriorityQueue(DoubleCollection collection, DoubleComparator c) {
        this(collection.toDoubleArray(), c);
    }

    public DoubleHeapPriorityQueue(DoubleCollection collection) {
        this(collection, (DoubleComparator) null);
    }

    public DoubleHeapPriorityQueue(Collection<? extends Double> collection, DoubleComparator c) {
        this(collection.size(), c);
        Iterator<? extends Double> iterator = collection.iterator();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            this.heap[i] = ((Double) iterator.next()).doubleValue();
        }
    }

    public DoubleHeapPriorityQueue(Collection<? extends Double> collection) {
        this(collection, (DoubleComparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public void enqueue(double x) {
        if (this.size == this.heap.length) {
            this.heap = DoubleArrays.grow(this.heap, this.size + 1);
        }
        double[] dArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        dArr[i] = x;
        DoubleHeaps.upHeap(this.heap, this.size, this.size - 1, this.f1684c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public double dequeueDouble() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        double result = this.heap[0];
        double[] dArr = this.heap;
        double[] dArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        dArr[0] = dArr2[i];
        if (this.size != 0) {
            DoubleHeaps.downHeap(this.heap, this.size, 0, this.f1684c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public double firstDouble() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        DoubleHeaps.downHeap(this.heap, this.size, 0, this.f1684c);
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
        this.heap = DoubleArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Double> comparator() {
        return this.f1684c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeDouble(this.heap[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = new double[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readDouble();
        }
    }
}
