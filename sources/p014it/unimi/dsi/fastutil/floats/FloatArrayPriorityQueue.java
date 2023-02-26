package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrayPriorityQueue.class */
public class FloatArrayPriorityQueue implements FloatPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient float[] array;
    protected int size;

    /* renamed from: c */
    protected FloatComparator f1887c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public FloatArrayPriorityQueue(int capacity, FloatComparator c) {
        this.array = FloatArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new float[capacity];
        }
        this.f1887c = c;
    }

    public FloatArrayPriorityQueue(int capacity) {
        this(capacity, (FloatComparator) null);
    }

    public FloatArrayPriorityQueue(FloatComparator c) {
        this(0, c);
    }

    public FloatArrayPriorityQueue() {
        this(0, (FloatComparator) null);
    }

    public FloatArrayPriorityQueue(float[] a, int size, FloatComparator c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public FloatArrayPriorityQueue(float[] a, FloatComparator c) {
        this(a, a.length, c);
    }

    public FloatArrayPriorityQueue(float[] a, int size) {
        this(a, size, null);
    }

    public FloatArrayPriorityQueue(float[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        float first = this.array[firstIndex];
        if (this.f1887c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f1887c.compare(this.array[i], first) < 0) {
                    firstIndex = i;
                    first = this.array[i];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (Float.compare(this.array[i], first) < 0) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
    public void enqueue(float x) {
        if (this.size == this.array.length) {
            this.array = FloatArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f1887c == null) {
            if (Float.compare(x, this.array[this.firstIndex]) < 0) {
                this.firstIndex = this.size;
            }
        } else if (this.f1887c.compare(x, this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        float[] fArr = this.array;
        int i = this.size;
        this.size = i + 1;
        fArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
    public float dequeueFloat() {
        ensureNonEmpty();
        int first = findFirst();
        float result = this.array[first];
        float[] fArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, fArr, first, i - first);
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue
    public float firstFloat() {
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
        this.array = FloatArrays.trim(this.array, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Float> comparator() {
        return this.f1887c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeFloat(this.array[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = new float[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readFloat();
        }
    }
}
