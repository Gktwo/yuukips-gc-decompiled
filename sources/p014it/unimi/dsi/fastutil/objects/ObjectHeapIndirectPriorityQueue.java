package p014it.unimi.dsi.fastutil.objects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectHeapIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectHeapIndirectPriorityQueue.class */
public class ObjectHeapIndirectPriorityQueue<K> extends ObjectHeapSemiIndirectPriorityQueue<K> {
    protected final int[] inv;

    public ObjectHeapIndirectPriorityQueue(K[] refArray, int capacity, Comparator<? super K> c) {
        super(refArray, capacity, c);
        if (capacity > 0) {
            this.heap = new int[capacity];
        }
        this.f2702c = c;
        this.inv = new int[refArray.length];
        Arrays.fill(this.inv, -1);
    }

    public ObjectHeapIndirectPriorityQueue(K[] refArray, int capacity) {
        this(refArray, capacity, (Comparator) null);
    }

    public ObjectHeapIndirectPriorityQueue(K[] refArray, Comparator<? super K> c) {
        this(refArray, refArray.length, c);
    }

    public ObjectHeapIndirectPriorityQueue(K[] refArray) {
        this(refArray, refArray.length, (Comparator) null);
    }

    public ObjectHeapIndirectPriorityQueue(K[] refArray, int[] a, int size, Comparator<? super K> c) {
        this(refArray, 0, c);
        this.heap = a;
        this.size = size;
        int i = size;
        while (true) {
            i--;
            if (i == 0) {
                ObjectIndirectHeaps.makeHeap(refArray, a, this.inv, size, c);
                return;
            } else if (this.inv[a[i]] != -1) {
                throw new IllegalArgumentException("Index " + a[i] + " appears twice in the heap");
            } else {
                this.inv[a[i]] = i;
            }
        }
    }

    public ObjectHeapIndirectPriorityQueue(K[] refArray, int[] a, Comparator<? super K> c) {
        this(refArray, a, a.length, c);
    }

    public ObjectHeapIndirectPriorityQueue(K[] refArray, int[] a, int size) {
        this(refArray, a, size, null);
    }

    public ObjectHeapIndirectPriorityQueue(K[] refArray, int[] a) {
        this(refArray, a, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void enqueue(int x) {
        if (this.inv[x] >= 0) {
            throw new IllegalArgumentException("Index " + x + " belongs to the queue");
        }
        if (this.size == this.heap.length) {
            this.heap = IntArrays.grow(this.heap, this.size + 1);
        }
        int[] iArr = this.inv;
        this.heap[this.size] = x;
        int i = this.size;
        this.size = i + 1;
        iArr[x] = i;
        ObjectIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, this.size - 1, this.f2702c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public boolean contains(int index) {
        return this.inv[index] >= 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int dequeue() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int result = this.heap[0];
        int i = this.size - 1;
        this.size = i;
        if (i != 0) {
            int[] iArr = this.inv;
            int[] iArr2 = this.heap;
            int i2 = this.heap[this.size];
            iArr2[0] = i2;
            iArr[i2] = 0;
        }
        this.inv[result] = -1;
        if (this.size != 0) {
            ObjectIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.f2702c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed() {
        ObjectIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.f2702c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed(int index) {
        int pos = this.inv[index];
        if (pos < 0) {
            throw new IllegalArgumentException("Index " + index + " does not belong to the queue");
        }
        ObjectIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, ObjectIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, pos, this.f2702c), this.f2702c);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void allChanged() {
        ObjectIndirectHeaps.makeHeap(this.refArray, this.heap, this.inv, this.size, this.f2702c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public boolean remove(int index) {
        int result = this.inv[index];
        if (result < 0) {
            return false;
        }
        this.inv[index] = -1;
        int i = this.size - 1;
        this.size = i;
        if (result >= i) {
            return true;
        }
        int[] iArr = this.inv;
        int[] iArr2 = this.heap;
        int i2 = this.heap[this.size];
        iArr2[result] = i2;
        iArr[i2] = result;
        ObjectIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, ObjectIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, result, this.f2702c), this.f2702c);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void clear() {
        this.size = 0;
        Arrays.fill(this.inv, -1);
    }
}
