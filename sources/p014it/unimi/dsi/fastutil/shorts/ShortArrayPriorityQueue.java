package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayPriorityQueue.class */
public class ShortArrayPriorityQueue implements ShortPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient short[] array;
    protected int size;

    /* renamed from: c */
    protected ShortComparator f3024c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public ShortArrayPriorityQueue(int capacity, ShortComparator c) {
        this.array = ShortArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new short[capacity];
        }
        this.f3024c = c;
    }

    public ShortArrayPriorityQueue(int capacity) {
        this(capacity, (ShortComparator) null);
    }

    public ShortArrayPriorityQueue(ShortComparator c) {
        this(0, c);
    }

    public ShortArrayPriorityQueue() {
        this(0, (ShortComparator) null);
    }

    public ShortArrayPriorityQueue(short[] a, int size, ShortComparator c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public ShortArrayPriorityQueue(short[] a, ShortComparator c) {
        this(a, a.length, c);
    }

    public ShortArrayPriorityQueue(short[] a, int size) {
        this(a, size, null);
    }

    public ShortArrayPriorityQueue(short[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        short first = this.array[firstIndex];
        if (this.f3024c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f3024c.compare(this.array[i], first) < 0) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
    public void enqueue(short x) {
        if (this.size == this.array.length) {
            this.array = ShortArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f3024c == null) {
            if (x < this.array[this.firstIndex]) {
                this.firstIndex = this.size;
            }
        } else if (this.f3024c.compare(x, this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        short[] sArr = this.array;
        int i = this.size;
        this.size = i + 1;
        sArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
    public short dequeueShort() {
        ensureNonEmpty();
        int first = findFirst();
        short result = this.array[first];
        short[] sArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, sArr, first, i - first);
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue
    public short firstShort() {
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
        this.array = ShortArrays.trim(this.array, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Short> comparator() {
        return this.f3024c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeShort(this.array[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = new short[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readShort();
        }
    }
}
