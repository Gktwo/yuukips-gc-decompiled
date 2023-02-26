package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.chars.CharHeapPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharHeapPriorityQueue.class */
public class CharHeapPriorityQueue implements CharPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient char[] heap;
    protected int size;

    /* renamed from: c */
    protected CharComparator f1465c;

    public CharHeapPriorityQueue(int capacity, CharComparator c) {
        this.heap = CharArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.heap = new char[capacity];
        }
        this.f1465c = c;
    }

    public CharHeapPriorityQueue(int capacity) {
        this(capacity, (CharComparator) null);
    }

    public CharHeapPriorityQueue(CharComparator c) {
        this(0, c);
    }

    public CharHeapPriorityQueue() {
        this(0, (CharComparator) null);
    }

    public CharHeapPriorityQueue(char[] a, int size, CharComparator c) {
        this(c);
        this.heap = a;
        this.size = size;
        CharHeaps.makeHeap(a, size, c);
    }

    public CharHeapPriorityQueue(char[] a, CharComparator c) {
        this(a, a.length, c);
    }

    public CharHeapPriorityQueue(char[] a, int size) {
        this(a, size, null);
    }

    public CharHeapPriorityQueue(char[] a) {
        this(a, a.length);
    }

    public CharHeapPriorityQueue(CharCollection collection, CharComparator c) {
        this(collection.toCharArray(), c);
    }

    public CharHeapPriorityQueue(CharCollection collection) {
        this(collection, (CharComparator) null);
    }

    public CharHeapPriorityQueue(Collection<? extends Character> collection, CharComparator c) {
        this(collection.size(), c);
        Iterator<? extends Character> iterator = collection.iterator();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            this.heap[i] = ((Character) iterator.next()).charValue();
        }
    }

    public CharHeapPriorityQueue(Collection<? extends Character> collection) {
        this(collection, (CharComparator) null);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
    public void enqueue(char x) {
        if (this.size == this.heap.length) {
            this.heap = CharArrays.grow(this.heap, this.size + 1);
        }
        char[] cArr = this.heap;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = x;
        CharHeaps.upHeap(this.heap, this.size, this.size - 1, this.f1465c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
    public char dequeueChar() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        char result = this.heap[0];
        char[] cArr = this.heap;
        char[] cArr2 = this.heap;
        int i = this.size - 1;
        this.size = i;
        cArr[0] = cArr2[i];
        if (this.size != 0) {
            CharHeaps.downHeap(this.heap, this.size, 0, this.f1465c);
        }
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
    public char firstChar() {
        if (this.size != 0) {
            return this.heap[0];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        CharHeaps.downHeap(this.heap, this.size, 0, this.f1465c);
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
        this.heap = CharArrays.trim(this.heap, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Character> comparator() {
        return this.f1465c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.heap.length);
        for (int i = 0; i < this.size; i++) {
            s.writeChar(this.heap[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.heap = new char[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.heap[i] = s.readChar();
        }
    }
}
