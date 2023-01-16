package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.longs.LongArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayPriorityQueue.class */
public class LongArrayPriorityQueue implements LongPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient long[] array;
    protected int size;

    /* renamed from: c */
    protected LongComparator f2394c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public LongArrayPriorityQueue(int capacity, LongComparator c) {
        this.array = LongArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new long[capacity];
        }
        this.f2394c = c;
    }

    public LongArrayPriorityQueue(int capacity) {
        this(capacity, (LongComparator) null);
    }

    public LongArrayPriorityQueue(LongComparator c) {
        this(0, c);
    }

    public LongArrayPriorityQueue() {
        this(0, (LongComparator) null);
    }

    public LongArrayPriorityQueue(long[] a, int size, LongComparator c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public LongArrayPriorityQueue(long[] a, LongComparator c) {
        this(a, a.length, c);
    }

    public LongArrayPriorityQueue(long[] a, int size) {
        this(a, size, null);
    }

    public LongArrayPriorityQueue(long[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        long first = this.array[firstIndex];
        if (this.f2394c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f2394c.compare(this.array[i], first) < 0) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
    public void enqueue(long x) {
        if (this.size == this.array.length) {
            this.array = LongArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f2394c == null) {
            if (x < this.array[this.firstIndex]) {
                this.firstIndex = this.size;
            }
        } else if (this.f2394c.compare(x, this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        long[] jArr = this.array;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
    public long dequeueLong() {
        ensureNonEmpty();
        int first = findFirst();
        long result = this.array[first];
        long[] jArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, jArr, first, i - first);
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue
    public long firstLong() {
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
        this.array = LongArrays.trim(this.array, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Long> comparator() {
        return this.f2394c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeLong(this.array[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = new long[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readLong();
        }
    }
}
