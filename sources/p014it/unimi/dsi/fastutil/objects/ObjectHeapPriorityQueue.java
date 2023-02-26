package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectHeapPriorityQueue.class */
public class ObjectHeapPriorityQueue<K> implements PriorityQueue<K>, Serializable {
    private static final long serialVersionUID = 1;
    protected transient K[] heap;
    protected int size;

    /* renamed from: c */
    protected Comparator<? super K> f2665c;

    public ObjectHeapPriorityQueue(int capacity, Comparator<? super K> c) {
        this.heap = (K[]) ObjectArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = (K[]) new Object[capacity];
        }
        this.f2665c = c;
    }

    public ObjectHeapPriorityQueue(int capacity) {
        this(capacity, (Comparator) null);
    }

    public ObjectHeapPriorityQueue(Comparator<? super K> c) {
        this(0, c);
    }

    public ObjectHeapPriorityQueue() {
        this(0, (Comparator) null);
    }

    public ObjectHeapPriorityQueue(K[] a, int size, Comparator<? super K> c) {
        this(c);
        this.heap = a;
        this.size = size;
        ObjectHeaps.makeHeap(a, size, c);
    }

    public ObjectHeapPriorityQueue(K[] a, Comparator<? super K> c) {
        this(a, a.length, c);
    }

    public ObjectHeapPriorityQueue(K[] a, int size) {
        this(a, size, null);
    }

    public ObjectHeapPriorityQueue(K[] a) {
        this(a, a.length);
    }

    public ObjectHeapPriorityQueue(Collection<? extends K> collection, Comparator<? super K> c) {
        this(collection.toArray(), c);
    }

    public ObjectHeapPriorityQueue(Collection<? extends K> collection) {
        this(collection, (Comparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void enqueue(K x) {
        if (this.size == this.heap.length) {
            this.heap = (K[]) ObjectArrays.grow(this.heap, this.size + 1);
        }
        K[] kArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        kArr[i] = x;
        ObjectHeaps.upHeap(this.heap, this.size, this.size - 1, this.f2665c);
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public K dequeue() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        K result = this.heap[0];
        K[] kArr = this.heap;
        K[] kArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        kArr[0] = kArr2[i];
        this.heap[this.size] = null;
        if (this.size != 0) {
            ObjectHeaps.downHeap(this.heap, this.size, 0, this.f2665c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public K first() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        ObjectHeaps.downHeap(this.heap, this.size, 0, this.f2665c);
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void clear() {
        Arrays.fill(this.heap, 0, this.size, (Object) null);
        this.size = 0;
    }

    public void trim() {
        this.heap = (K[]) ObjectArrays.trim(this.heap, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super K> comparator() {
        return this.f2665c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeObject(this.heap[i]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: K[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = (K[]) new Object[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readObject();
        }
    }
}
