package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatHeapSemiIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatHeapSemiIndirectPriorityQueue.class */
public class FloatHeapSemiIndirectPriorityQueue implements FloatIndirectPriorityQueue {
    protected final float[] refArray;
    protected int[] heap;
    protected int size;

    /* renamed from: c */
    protected FloatComparator f1906c;

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray, int capacity, FloatComparator c) {
        this.heap = IntArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new int[capacity];
        }
        this.refArray = refArray;
        this.f1906c = c;
    }

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray, int capacity) {
        this(refArray, capacity, (FloatComparator) null);
    }

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray, FloatComparator c) {
        this(refArray, refArray.length, c);
    }

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray) {
        this(refArray, refArray.length, (FloatComparator) null);
    }

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray, int[] a, int size, FloatComparator c) {
        this(refArray, 0, c);
        this.heap = a;
        this.size = size;
        FloatSemiIndirectHeaps.makeHeap(refArray, a, size, c);
    }

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray, int[] a, FloatComparator c) {
        this(refArray, a, a.length, c);
    }

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray, int[] a, int size) {
        this(refArray, a, size, null);
    }

    public FloatHeapSemiIndirectPriorityQueue(float[] refArray, int[] a) {
        this(refArray, a, a.length);
    }

    protected void ensureElement(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index >= this.refArray.length) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is larger than or equal to reference array size (" + this.refArray.length + ")");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void enqueue(int x) {
        ensureElement(x);
        if (this.size == this.heap.length) {
            this.heap = IntArrays.grow(this.heap, this.size + 1);
        }
        int[] iArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        iArr[i] = x;
        FloatSemiIndirectHeaps.upHeap(this.refArray, this.heap, this.size, this.size - 1, this.f1906c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int dequeue() {
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
            FloatSemiIndirectHeaps.downHeap(this.refArray, this.heap, this.size, 0, this.f1906c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int first() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed() {
        FloatSemiIndirectHeaps.downHeap(this.refArray, this.heap, this.size, 0, this.f1906c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void allChanged() {
        FloatSemiIndirectHeaps.makeHeap(this.refArray, this.heap, this.size, this.f1906c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void clear() {
        this.size = 0;
    }

    public void trim() {
        this.heap = IntArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public Comparator<? super Float> comparator() {
        return this.f1906c;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int front(int[] a) {
        return this.f1906c == null ? FloatSemiIndirectHeaps.front(this.refArray, this.heap, this.size, a) : FloatSemiIndirectHeaps.front(this.refArray, this.heap, this.size, a, this.f1906c);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(this.refArray[this.heap[i]]);
        }
        s.append("]");
        return s.toString();
    }
}
