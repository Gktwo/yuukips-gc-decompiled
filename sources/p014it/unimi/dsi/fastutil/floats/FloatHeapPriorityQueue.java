package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatHeapPriorityQueue.class */
public class FloatHeapPriorityQueue implements FloatPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient float[] heap;
    protected int size;

    /* renamed from: c */
    protected FloatComparator f1905c;

    public FloatHeapPriorityQueue(int capacity, FloatComparator c) {
        this.heap = FloatArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new float[capacity];
        }
        this.f1905c = c;
    }

    public FloatHeapPriorityQueue(int capacity) {
        this(capacity, (FloatComparator) null);
    }

    public FloatHeapPriorityQueue(FloatComparator c) {
        this(0, c);
    }

    public FloatHeapPriorityQueue() {
        this(0, (FloatComparator) null);
    }

    public FloatHeapPriorityQueue(float[] a, int size, FloatComparator c) {
        this(c);
        this.heap = a;
        this.size = size;
        FloatHeaps.makeHeap(a, size, c);
    }

    public FloatHeapPriorityQueue(float[] a, FloatComparator c) {
        this(a, a.length, c);
    }

    public FloatHeapPriorityQueue(float[] a, int size) {
        this(a, size, null);
    }

    public FloatHeapPriorityQueue(float[] a) {
        this(a, a.length);
    }

    public FloatHeapPriorityQueue(FloatCollection collection, FloatComparator c) {
        this(collection.toFloatArray(), c);
    }

    public FloatHeapPriorityQueue(FloatCollection collection) {
        this(collection, (FloatComparator) null);
    }

    public FloatHeapPriorityQueue(Collection<? extends Float> collection, FloatComparator c) {
        this(collection.size(), c);
        Iterator<? extends Float> iterator = collection.iterator();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            this.heap[i] = ((Float) iterator.next()).floatValue();
        }
    }

    public FloatHeapPriorityQueue(Collection<? extends Float> collection) {
        this(collection, (FloatComparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
    public void enqueue(float x) {
        if (this.size == this.heap.length) {
            this.heap = FloatArrays.grow(this.heap, this.size + 1);
        }
        float[] fArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        fArr[i] = x;
        FloatHeaps.upHeap(this.heap, this.size, this.size - 1, this.f1905c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
    public float dequeueFloat() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        float result = this.heap[0];
        float[] fArr = this.heap;
        float[] fArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        fArr[0] = fArr2[i];
        if (this.size != 0) {
            FloatHeaps.downHeap(this.heap, this.size, 0, this.f1905c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
    public float firstFloat() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        FloatHeaps.downHeap(this.heap, this.size, 0, this.f1905c);
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
        this.heap = FloatArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Float> comparator() {
        return this.f1905c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeFloat(this.heap[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = new float[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readFloat();
        }
    }
}
