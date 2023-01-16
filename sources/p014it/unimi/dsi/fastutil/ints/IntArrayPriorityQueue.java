package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.ints.IntArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntArrayPriorityQueue.class */
public class IntArrayPriorityQueue implements IntPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient int[] array;
    protected int size;

    /* renamed from: c */
    protected IntComparator f2152c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public IntArrayPriorityQueue(int capacity, IntComparator c) {
        this.array = IntArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new int[capacity];
        }
        this.f2152c = c;
    }

    public IntArrayPriorityQueue(int capacity) {
        this(capacity, (IntComparator) null);
    }

    public IntArrayPriorityQueue(IntComparator c) {
        this(0, c);
    }

    public IntArrayPriorityQueue() {
        this(0, (IntComparator) null);
    }

    public IntArrayPriorityQueue(int[] a, int size, IntComparator c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public IntArrayPriorityQueue(int[] a, IntComparator c) {
        this(a, a.length, c);
    }

    public IntArrayPriorityQueue(int[] a, int size) {
        this(a, size, null);
    }

    public IntArrayPriorityQueue(int[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        int first = this.array[firstIndex];
        if (this.f2152c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f2152c.compare(this.array[i], first) < 0) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
    public void enqueue(int x) {
        if (this.size == this.array.length) {
            this.array = IntArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f2152c == null) {
            if (x < this.array[this.firstIndex]) {
                this.firstIndex = this.size;
            }
        } else if (this.f2152c.compare(x, this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        int[] iArr = this.array;
        int i = this.size;
        this.size = i + 1;
        iArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
    public int dequeueInt() {
        ensureNonEmpty();
        int first = findFirst();
        int result = this.array[first];
        int[] iArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, iArr, first, i - first);
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue
    public int firstInt() {
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
        this.array = IntArrays.trim(this.array, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.IntPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Integer> comparator() {
        return this.f2152c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeInt(this.array[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = new int[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readInt();
        }
    }
}
