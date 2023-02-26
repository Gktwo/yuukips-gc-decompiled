package p014it.unimi.dsi.fastutil.ints;

import java.util.Arrays;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.ints.IntHeapIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntHeapIndirectPriorityQueue.class */
public class IntHeapIndirectPriorityQueue extends IntHeapSemiIndirectPriorityQueue {
    protected final int[] inv;

    public IntHeapIndirectPriorityQueue(int[] refArray, int capacity, IntComparator c) {
        super(refArray, capacity, c);
        if (capacity > 0) {
            this.heap = new int[capacity];
        }
        this.f2135c = c;
        this.inv = new int[refArray.length];
        Arrays.fill(this.inv, -1);
    }

    public IntHeapIndirectPriorityQueue(int[] refArray, int capacity) {
        this(refArray, capacity, (IntComparator) null);
    }

    public IntHeapIndirectPriorityQueue(int[] refArray, IntComparator c) {
        this(refArray, refArray.length, c);
    }

    public IntHeapIndirectPriorityQueue(int[] refArray) {
        this(refArray, refArray.length, (IntComparator) null);
    }

    public IntHeapIndirectPriorityQueue(int[] refArray, int[] a, int size, IntComparator c) {
        this(refArray, 0, c);
        this.heap = a;
        this.size = size;
        int i = size;
        while (true) {
            i--;
            if (i == 0) {
                IntIndirectHeaps.makeHeap(refArray, a, this.inv, size, c);
                return;
            } else if (this.inv[a[i]] != -1) {
                throw new IllegalArgumentException("Index " + a[i] + " appears twice in the heap");
            } else {
                this.inv[a[i]] = i;
            }
        }
    }

    public IntHeapIndirectPriorityQueue(int[] refArray, int[] a, IntComparator c) {
        this(refArray, a, a.length, c);
    }

    public IntHeapIndirectPriorityQueue(int[] refArray, int[] a, int size) {
        this(refArray, a, size, null);
    }

    public IntHeapIndirectPriorityQueue(int[] refArray, int[] a) {
        this(refArray, a, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
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
        IntIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, this.size - 1, this.f2135c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public boolean contains(int index) {
        return this.inv[index] >= 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
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
            IntIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.f2135c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed() {
        IntIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.f2135c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed(int index) {
        int pos = this.inv[index];
        if (pos < 0) {
            throw new IllegalArgumentException("Index " + index + " does not belong to the queue");
        }
        IntIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, IntIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, pos, this.f2135c), this.f2135c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void allChanged() {
        IntIndirectHeaps.makeHeap(this.refArray, this.heap, this.inv, this.size, this.f2135c);
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
        IntIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, IntIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, result, this.f2135c), this.f2135c);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void clear() {
        this.size = 0;
        Arrays.fill(this.inv, -1);
    }
}
