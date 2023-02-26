package p014it.unimi.dsi.fastutil.chars;

import java.util.Arrays;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.chars.CharHeapIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharHeapIndirectPriorityQueue.class */
public class CharHeapIndirectPriorityQueue extends CharHeapSemiIndirectPriorityQueue {
    protected final int[] inv;

    public CharHeapIndirectPriorityQueue(char[] refArray, int capacity, CharComparator c) {
        super(refArray, capacity, c);
        if (capacity > 0) {
            this.heap = new int[capacity];
        }
        this.f1466c = c;
        this.inv = new int[refArray.length];
        Arrays.fill(this.inv, -1);
    }

    public CharHeapIndirectPriorityQueue(char[] refArray, int capacity) {
        this(refArray, capacity, (CharComparator) null);
    }

    public CharHeapIndirectPriorityQueue(char[] refArray, CharComparator c) {
        this(refArray, refArray.length, c);
    }

    public CharHeapIndirectPriorityQueue(char[] refArray) {
        this(refArray, refArray.length, (CharComparator) null);
    }

    public CharHeapIndirectPriorityQueue(char[] refArray, int[] a, int size, CharComparator c) {
        this(refArray, 0, c);
        this.heap = a;
        this.size = size;
        int i = size;
        while (true) {
            i--;
            if (i == 0) {
                CharIndirectHeaps.makeHeap(refArray, a, this.inv, size, c);
                return;
            } else if (this.inv[a[i]] != -1) {
                throw new IllegalArgumentException("Index " + a[i] + " appears twice in the heap");
            } else {
                this.inv[a[i]] = i;
            }
        }
    }

    public CharHeapIndirectPriorityQueue(char[] refArray, int[] a, CharComparator c) {
        this(refArray, a, a.length, c);
    }

    public CharHeapIndirectPriorityQueue(char[] refArray, int[] a, int size) {
        this(refArray, a, size, null);
    }

    public CharHeapIndirectPriorityQueue(char[] refArray, int[] a) {
        this(refArray, a, a.length);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
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
        CharIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, this.size - 1, this.f1466c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public boolean contains(int index) {
        return this.inv[index] >= 0;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
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
            CharIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.f1466c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed() {
        CharIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, 0, this.f1466c);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed(int index) {
        int pos = this.inv[index];
        if (pos < 0) {
            throw new IllegalArgumentException("Index " + index + " does not belong to the queue");
        }
        CharIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, CharIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, pos, this.f1466c), this.f1466c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void allChanged() {
        CharIndirectHeaps.makeHeap(this.refArray, this.heap, this.inv, this.size, this.f1466c);
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
        CharIndirectHeaps.downHeap(this.refArray, this.heap, this.inv, this.size, CharIndirectHeaps.upHeap(this.refArray, this.heap, this.inv, this.size, result, this.f1466c), this.f1466c);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharHeapSemiIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void clear() {
        this.size = 0;
        Arrays.fill(this.inv, -1);
    }
}
