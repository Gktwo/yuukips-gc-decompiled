package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteHeapPriorityQueue.class */
public class ByteHeapPriorityQueue implements BytePriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient byte[] heap;
    protected int size;

    /* renamed from: c */
    protected ByteComparator f1274c;

    public ByteHeapPriorityQueue(int capacity, ByteComparator c) {
        this.heap = ByteArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new byte[capacity];
        }
        this.f1274c = c;
    }

    public ByteHeapPriorityQueue(int capacity) {
        this(capacity, (ByteComparator) null);
    }

    public ByteHeapPriorityQueue(ByteComparator c) {
        this(0, c);
    }

    public ByteHeapPriorityQueue() {
        this(0, (ByteComparator) null);
    }

    public ByteHeapPriorityQueue(byte[] a, int size, ByteComparator c) {
        this(c);
        this.heap = a;
        this.size = size;
        ByteHeaps.makeHeap(a, size, c);
    }

    public ByteHeapPriorityQueue(byte[] a, ByteComparator c) {
        this(a, a.length, c);
    }

    public ByteHeapPriorityQueue(byte[] a, int size) {
        this(a, size, null);
    }

    public ByteHeapPriorityQueue(byte[] a) {
        this(a, a.length);
    }

    public ByteHeapPriorityQueue(ByteCollection collection, ByteComparator c) {
        this(collection.toByteArray(), c);
    }

    public ByteHeapPriorityQueue(ByteCollection collection) {
        this(collection, (ByteComparator) null);
    }

    public ByteHeapPriorityQueue(Collection<? extends Byte> collection, ByteComparator c) {
        this(collection.size(), c);
        Iterator<? extends Byte> iterator = collection.iterator();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            this.heap[i] = ((Byte) iterator.next()).byteValue();
        }
    }

    public ByteHeapPriorityQueue(Collection<? extends Byte> collection) {
        this(collection, (ByteComparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
    public void enqueue(byte x) {
        if (this.size == this.heap.length) {
            this.heap = ByteArrays.grow(this.heap, this.size + 1);
        }
        byte[] bArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        bArr[i] = x;
        ByteHeaps.upHeap(this.heap, this.size, this.size - 1, this.f1274c);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
    public byte dequeueByte() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        byte result = this.heap[0];
        byte[] bArr = this.heap;
        byte[] bArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        bArr[0] = bArr2[i];
        if (this.size != 0) {
            ByteHeaps.downHeap(this.heap, this.size, 0, this.f1274c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
    public byte firstByte() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        ByteHeaps.downHeap(this.heap, this.size, 0, this.f1274c);
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
        this.heap = ByteArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Byte> comparator() {
        return this.f1274c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeByte(this.heap[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = new byte[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readByte();
        }
    }
}
