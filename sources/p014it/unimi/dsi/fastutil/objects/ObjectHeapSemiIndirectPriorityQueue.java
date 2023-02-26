package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectHeapSemiIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectHeapSemiIndirectPriorityQueue.class */
public class ObjectHeapSemiIndirectPriorityQueue<K> implements IndirectPriorityQueue<K> {
    protected final K[] refArray;
    protected int[] heap;
    protected int size;

    /* renamed from: c */
    protected Comparator<? super K> f2666c;

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray, int capacity, Comparator<? super K> c) {
        this.heap = IntArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new int[capacity];
        }
        this.refArray = refArray;
        this.f2666c = c;
    }

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray, int capacity) {
        this(refArray, capacity, (Comparator) null);
    }

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray, Comparator<? super K> c) {
        this(refArray, refArray.length, c);
    }

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray) {
        this(refArray, refArray.length, (Comparator) null);
    }

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray, int[] a, int size, Comparator<? super K> c) {
        this(refArray, 0, c);
        this.heap = a;
        this.size = size;
        ObjectSemiIndirectHeaps.makeHeap(refArray, a, size, c);
    }

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray, int[] a, Comparator<? super K> c) {
        this(refArray, a, a.length, c);
    }

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray, int[] a, int size) {
        this(refArray, a, size, null);
    }

    public ObjectHeapSemiIndirectPriorityQueue(K[] refArray, int[] a) {
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
        ObjectSemiIndirectHeaps.upHeap(this.refArray, this.heap, this.size, this.size - 1, this.f2666c);
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
            ObjectSemiIndirectHeaps.downHeap(this.refArray, this.heap, this.size, 0, this.f2666c);
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
        ObjectSemiIndirectHeaps.downHeap(this.refArray, this.heap, this.size, 0, this.f2666c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void allChanged() {
        ObjectSemiIndirectHeaps.makeHeap(this.refArray, this.heap, this.size, this.f2666c);
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

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public Comparator<? super K> comparator() {
        return this.f2666c;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int front(int[] a) {
        return this.f2666c == null ? ObjectSemiIndirectHeaps.front(this.refArray, this.heap, this.size, a) : ObjectSemiIndirectHeaps.front(this.refArray, this.heap, this.size, a, this.f2666c);
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
