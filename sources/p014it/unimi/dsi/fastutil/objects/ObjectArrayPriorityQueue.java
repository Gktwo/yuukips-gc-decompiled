package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrayPriorityQueue.class */
public class ObjectArrayPriorityQueue<K> implements PriorityQueue<K>, Serializable {
    private static final long serialVersionUID = 1;
    protected transient K[] array;
    protected int size;

    /* renamed from: c */
    protected Comparator<? super K> f2647c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public ObjectArrayPriorityQueue(int capacity, Comparator<? super K> c) {
        this.array = (K[]) ObjectArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = (K[]) new Object[capacity];
        }
        this.f2647c = c;
    }

    public ObjectArrayPriorityQueue(int capacity) {
        this(capacity, (Comparator) null);
    }

    public ObjectArrayPriorityQueue(Comparator<? super K> c) {
        this(0, c);
    }

    public ObjectArrayPriorityQueue() {
        this(0, (Comparator) null);
    }

    public ObjectArrayPriorityQueue(K[] a, int size, Comparator<? super K> c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public ObjectArrayPriorityQueue(K[] a, Comparator<? super K> c) {
        this(a, a.length, c);
    }

    public ObjectArrayPriorityQueue(K[] a, int size) {
        this(a, size, null);
    }

    public ObjectArrayPriorityQueue(K[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        K first = this.array[firstIndex];
        if (this.f2647c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f2647c.compare((Object) this.array[i], first) < 0) {
                    firstIndex = i;
                    first = this.array[i];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (((Comparable) this.array[i]).compareTo(first) < 0) {
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

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void enqueue(K x) {
        if (this.size == this.array.length) {
            this.array = (K[]) ObjectArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f2647c == null) {
            if (((Comparable) x).compareTo(this.array[this.firstIndex]) < 0) {
                this.firstIndex = this.size;
            }
        } else if (this.f2647c.compare(x, (Object) this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        K[] kArr = this.array;
        int i = this.size;
        this.size = i + 1;
        kArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public K dequeue() {
        ensureNonEmpty();
        int first = findFirst();
        K result = this.array[first];
        K[] kArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, kArr, first, i - first);
        this.array[this.size] = null;
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public K first() {
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
        Arrays.fill(this.array, 0, this.size, (Object) null);
        this.size = 0;
        this.firstIndexValid = false;
    }

    public void trim() {
        this.array = (K[]) ObjectArrays.trim(this.array, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super K> comparator() {
        return this.f2647c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeObject(this.array[i]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: K[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = (K[]) new Object[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readObject();
        }
    }
}
