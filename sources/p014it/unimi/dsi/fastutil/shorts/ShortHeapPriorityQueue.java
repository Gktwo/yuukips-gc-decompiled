package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortHeapPriorityQueue.class */
public class ShortHeapPriorityQueue implements ShortPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient short[] heap;
    protected int size;

    /* renamed from: c */
    protected ShortComparator f3042c;

    public ShortHeapPriorityQueue(int capacity, ShortComparator c) {
        this.heap = ShortArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new short[capacity];
        }
        this.f3042c = c;
    }

    public ShortHeapPriorityQueue(int capacity) {
        this(capacity, (ShortComparator) null);
    }

    public ShortHeapPriorityQueue(ShortComparator c) {
        this(0, c);
    }

    public ShortHeapPriorityQueue() {
        this(0, (ShortComparator) null);
    }

    public ShortHeapPriorityQueue(short[] a, int size, ShortComparator c) {
        this(c);
        this.heap = a;
        this.size = size;
        ShortHeaps.makeHeap(a, size, c);
    }

    public ShortHeapPriorityQueue(short[] a, ShortComparator c) {
        this(a, a.length, c);
    }

    public ShortHeapPriorityQueue(short[] a, int size) {
        this(a, size, null);
    }

    public ShortHeapPriorityQueue(short[] a) {
        this(a, a.length);
    }

    public ShortHeapPriorityQueue(ShortCollection collection, ShortComparator c) {
        this(collection.toShortArray(), c);
    }

    public ShortHeapPriorityQueue(ShortCollection collection) {
        this(collection, (ShortComparator) null);
    }

    public ShortHeapPriorityQueue(Collection<? extends Short> collection, ShortComparator c) {
        this(collection.size(), c);
        Iterator<? extends Short> iterator = collection.iterator();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            this.heap[i] = ((Short) iterator.next()).shortValue();
        }
    }

    public ShortHeapPriorityQueue(Collection<? extends Short> collection) {
        this(collection, (ShortComparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
    public void enqueue(short x) {
        if (this.size == this.heap.length) {
            this.heap = ShortArrays.grow(this.heap, this.size + 1);
        }
        short[] sArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        sArr[i] = x;
        ShortHeaps.upHeap(this.heap, this.size, this.size - 1, this.f3042c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
    public short dequeueShort() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        short result = this.heap[0];
        short[] sArr = this.heap;
        short[] sArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        sArr[0] = sArr2[i];
        if (this.size != 0) {
            ShortHeaps.downHeap(this.heap, this.size, 0, this.f3042c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
    public short firstShort() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        ShortHeaps.downHeap(this.heap, this.size, 0, this.f3042c);
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
        this.heap = ShortArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Short> comparator() {
        return this.f3042c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeShort(this.heap[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = new short[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readShort();
        }
    }
}
