package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayPriorityQueue.class */
public class ByteArrayPriorityQueue implements BytePriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient byte[] array;
    protected int size;

    /* renamed from: c */
    protected ByteComparator f1220c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public ByteArrayPriorityQueue(int capacity, ByteComparator c) {
        this.array = ByteArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new byte[capacity];
        }
        this.f1220c = c;
    }

    public ByteArrayPriorityQueue(int capacity) {
        this(capacity, (ByteComparator) null);
    }

    public ByteArrayPriorityQueue(ByteComparator c) {
        this(0, c);
    }

    public ByteArrayPriorityQueue() {
        this(0, (ByteComparator) null);
    }

    public ByteArrayPriorityQueue(byte[] a, int size, ByteComparator c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public ByteArrayPriorityQueue(byte[] a, ByteComparator c) {
        this(a, a.length, c);
    }

    public ByteArrayPriorityQueue(byte[] a, int size) {
        this(a, size, null);
    }

    public ByteArrayPriorityQueue(byte[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        byte first = this.array[firstIndex];
        if (this.f1220c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f1220c.compare(this.array[i], first) < 0) {
                    firstIndex = i;
                    first = this.array[i];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.array[i] < first) {
                    firstIndex = i;
                    first = this.array[i];
                }
            }
        }
        this.firstIndex = firstIndex;
        return firstIndex;
    }

    private void ensureNonEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
    public void enqueue(byte x) {
        if (this.size == this.array.length) {
            this.array = ByteArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f1220c == null) {
            if (x < this.array[this.firstIndex]) {
                this.firstIndex = this.size;
            }
        } else if (this.f1220c.compare(x, this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        byte[] bArr = this.array;
        int i = this.size;
        this.size = i + 1;
        bArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
    public byte dequeueByte() {
        ensureNonEmpty();
        int first = findFirst();
        byte result = this.array[first];
        byte[] bArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, bArr, first, i - first);
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue
    public byte firstByte() {
        ensureNonEmpty();
        return this.array[findFirst()];
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        ensureNonEmpty();
        this.firstIndexValid = false;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void clear() {
        this.size = 0;
        this.firstIndexValid = false;
    }

    public void trim() {
        this.array = ByteArrays.trim(this.array, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.BytePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Byte> comparator() {
        return this.f1220c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeByte(this.array[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = new byte[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readByte();
        }
    }
}
