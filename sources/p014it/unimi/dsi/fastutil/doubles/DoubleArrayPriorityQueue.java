package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArrayPriorityQueue.class */
public class DoubleArrayPriorityQueue implements DoublePriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient double[] array;
    protected int size;

    /* renamed from: c */
    protected DoubleComparator f1702c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public DoubleArrayPriorityQueue(int capacity, DoubleComparator c) {
        this.array = DoubleArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new double[capacity];
        }
        this.f1702c = c;
    }

    public DoubleArrayPriorityQueue(int capacity) {
        this(capacity, (DoubleComparator) null);
    }

    public DoubleArrayPriorityQueue(DoubleComparator c) {
        this(0, c);
    }

    public DoubleArrayPriorityQueue() {
        this(0, (DoubleComparator) null);
    }

    public DoubleArrayPriorityQueue(double[] a, int size, DoubleComparator c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public DoubleArrayPriorityQueue(double[] a, DoubleComparator c) {
        this(a, a.length, c);
    }

    public DoubleArrayPriorityQueue(double[] a, int size) {
        this(a, size, null);
    }

    public DoubleArrayPriorityQueue(double[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        double first = this.array[firstIndex];
        if (this.f1702c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f1702c.compare(this.array[i], first) < 0) {
                    firstIndex = i;
                    first = this.array[i];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (Double.compare(this.array[i], first) < 0) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public void enqueue(double x) {
        if (this.size == this.array.length) {
            this.array = DoubleArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f1702c == null) {
            if (Double.compare(x, this.array[this.firstIndex]) < 0) {
                this.firstIndex = this.size;
            }
        } else if (this.f1702c.compare(x, this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        double[] dArr = this.array;
        int i = this.size;
        this.size = i + 1;
        dArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public double dequeueDouble() {
        ensureNonEmpty();
        int first = findFirst();
        double result = this.array[first];
        double[] dArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, dArr, first, i - first);
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public double firstDouble() {
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
        this.array = DoubleArrays.trim(this.array, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Double> comparator() {
        return this.f1702c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeDouble(this.array[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = new double[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readDouble();
        }
    }
}
