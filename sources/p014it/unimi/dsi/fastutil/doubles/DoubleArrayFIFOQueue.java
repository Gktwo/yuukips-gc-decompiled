package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArrayFIFOQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArrayFIFOQueue.class */
public class DoubleArrayFIFOQueue implements DoublePriorityQueue, Serializable {
    private static final long serialVersionUID = 0;
    public static final int INITIAL_CAPACITY = 4;
    protected transient double[] array;
    protected transient int length;
    protected transient int start;
    protected transient int end;

    public DoubleArrayFIFOQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        }
        this.array = new double[Math.max(1, capacity)];
        this.length = this.array.length;
    }

    public DoubleArrayFIFOQueue() {
        this(4);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Double> comparator() {
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public double dequeueDouble() {
        if (this.start == this.end) {
            throw new NoSuchElementException();
        }
        double t = this.array[this.start];
        int i = this.start + 1;
        this.start = i;
        if (i == this.length) {
            this.start = 0;
        }
        reduce();
        return t;
    }

    public double dequeueLastDouble() {
        if (this.start == this.end) {
            throw new NoSuchElementException();
        }
        if (this.end == 0) {
            this.end = this.length;
        }
        double[] dArr = this.array;
        int i = this.end - 1;
        this.end = i;
        double t = dArr[i];
        reduce();
        return t;
    }

    private final void resize(int size, int newLength) {
        double[] newArray = new double[newLength];
        if (this.start < this.end) {
            System.arraycopy(this.array, this.start, newArray, 0, this.end - this.start);
        } else if (size != 0) {
            System.arraycopy(this.array, this.start, newArray, 0, this.length - this.start);
            System.arraycopy(this.array, 0, newArray, this.length - this.start, this.end);
        }
        this.start = 0;
        this.end = size;
        this.array = newArray;
        this.length = newLength;
    }

    private final void expand() {
        resize(this.length, (int) Math.min(2147483639L, 2 * ((long) this.length)));
    }

    private final void reduce() {
        int size = size();
        if (this.length > 4 && size <= this.length / 4) {
            resize(size, this.length / 2);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public void enqueue(double x) {
        double[] dArr = this.array;
        int i = this.end;
        this.end = i + 1;
        dArr[i] = x;
        if (this.end == this.length) {
            this.end = 0;
        }
        if (this.end == this.start) {
            expand();
        }
    }

    public void enqueueFirst(double x) {
        if (this.start == 0) {
            this.start = this.length;
        }
        double[] dArr = this.array;
        int i = this.start - 1;
        this.start = i;
        dArr[i] = x;
        if (this.end == this.start) {
            expand();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public double firstDouble() {
        if (this.start != this.end) {
            return this.array[this.start];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoublePriorityQueue
    public double lastDouble() {
        if (this.start == this.end) {
            throw new NoSuchElementException();
        }
        return this.array[(this.end == 0 ? this.length : this.end) - 1];
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void clear() {
        this.end = 0;
        this.start = 0;
    }

    public void trim() {
        int size = size();
        double[] newArray = new double[size + 1];
        if (this.start <= this.end) {
            System.arraycopy(this.array, this.start, newArray, 0, this.end - this.start);
        } else {
            System.arraycopy(this.array, this.start, newArray, 0, this.length - this.start);
            System.arraycopy(this.array, 0, newArray, this.length - this.start, this.end);
        }
        this.start = 0;
        this.end = size;
        this.length = size + 1;
        this.array = newArray;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public int size() {
        int apparentLength = this.end - this.start;
        return apparentLength >= 0 ? apparentLength : this.length + apparentLength;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        int size = size();
        s.writeInt(size);
        int i = this.start;
        while (true) {
            size--;
            if (size != 0) {
                i++;
                s.writeDouble(this.array[i]);
                if (i == this.length) {
                    i = 0;
                }
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.end = s.readInt();
        int nextPowerOfTwo = HashCommon.nextPowerOfTwo(this.end + 1);
        this.length = nextPowerOfTwo;
        this.array = new double[nextPowerOfTwo];
        for (int i = 0; i < this.end; i++) {
            this.array[i] = s.readDouble();
        }
    }
}
