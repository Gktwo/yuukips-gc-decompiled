package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrayIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrayIndirectPriorityQueue.class */
public class ObjectArrayIndirectPriorityQueue<K> implements IndirectPriorityQueue<K> {
    protected K[] refArray;
    protected int[] array;
    protected int size;

    /* renamed from: c */
    protected Comparator<? super K> f2645c;
    protected int firstIndex;
    protected boolean firstIndexValid;

    public ObjectArrayIndirectPriorityQueue(K[] refArray, int capacity, Comparator<? super K> c) {
        this.array = IntArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new int[capacity];
        }
        this.refArray = refArray;
        this.f2645c = c;
    }

    public ObjectArrayIndirectPriorityQueue(K[] refArray, int capacity) {
        this(refArray, capacity, (Comparator) null);
    }

    public ObjectArrayIndirectPriorityQueue(K[] refArray, Comparator<? super K> c) {
        this(refArray, refArray.length, c);
    }

    public ObjectArrayIndirectPriorityQueue(K[] refArray) {
        this(refArray, refArray.length, (Comparator) null);
    }

    public ObjectArrayIndirectPriorityQueue(K[] refArray, int[] a, int size, Comparator<? super K> c) {
        this(refArray, 0, c);
        this.array = a;
        this.size = size;
    }

    public ObjectArrayIndirectPriorityQueue(K[] refArray, int[] a, Comparator<? super K> c) {
        this(refArray, a, a.length, c);
    }

    public ObjectArrayIndirectPriorityQueue(K[] refArray, int[] a, int size) {
        this(refArray, a, size, null);
    }

    public ObjectArrayIndirectPriorityQueue(K[] refArray, int[] a) {
        this(refArray, a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        K first = this.refArray[this.array[firstIndex]];
        if (this.f2645c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f2645c.compare((Object) this.refArray[this.array[i]], first) < 0) {
                    firstIndex = i;
                    first = this.refArray[this.array[i]];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (((Comparable) this.refArray[this.array[i]]).compareTo(first) < 0) {
                    firstIndex = i;
                    first = this.refArray[this.array[i]];
                }
            }
        }
        this.firstIndex = firstIndex;
        return firstIndex;
    }

    private int findLast() {
        int i = this.size - 1;
        int lastIndex = i;
        K last = this.refArray[this.array[lastIndex]];
        if (this.f2645c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f2645c.compare(last, (Object) this.refArray[this.array[i]]) < 0) {
                    lastIndex = i;
                    last = this.refArray[this.array[i]];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (((Comparable) last).compareTo(this.refArray[this.array[i]]) < 0) {
                    lastIndex = i;
                    last = this.refArray[this.array[i]];
                }
            }
        }
        return lastIndex;
    }

    protected final void ensureNonEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
    }

    protected void ensureElement(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index >= this.refArray.length) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is larger than or equal to reference array size (" + this.refArray.length + ")");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void enqueue(int x) {
        ensureElement(x);
        if (this.size == this.array.length) {
            this.array = IntArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f2645c == null) {
            if (((Comparable) this.refArray[x]).compareTo(this.refArray[this.array[this.firstIndex]]) < 0) {
                this.firstIndex = this.size;
            }
        } else if (this.f2645c.compare((Object) this.refArray[x], (Object) this.refArray[this.array[this.firstIndex]]) < 0) {
            this.firstIndex = this.size;
        }
        int[] iArr = this.array;
        int i = this.size;
        this.size = i + 1;
        iArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int dequeue() {
        ensureNonEmpty();
        int firstIndex = findFirst();
        int result = this.array[firstIndex];
        int i = this.size - 1;
        this.size = i;
        if (i != 0) {
            System.arraycopy(this.array, firstIndex + 1, this.array, firstIndex, this.size - firstIndex);
        }
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int first() {
        ensureNonEmpty();
        return this.array[findFirst()];
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int last() {
        ensureNonEmpty();
        return this.array[findLast()];
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed() {
        ensureNonEmpty();
        this.firstIndexValid = false;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void changed(int index) {
        ensureElement(index);
        if (index == this.firstIndex) {
            this.firstIndexValid = false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void allChanged() {
        this.firstIndexValid = false;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public boolean remove(int index) {
        ensureElement(index);
        int[] a = this.array;
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                break;
            }
        } while (a[i] != index);
        if (i < 0) {
            return false;
        }
        this.firstIndexValid = false;
        int i2 = this.size - 1;
        this.size = i2;
        if (i2 == 0) {
            return true;
        }
        System.arraycopy(a, i + 1, a, i, this.size - i);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int front(int[] a) {
        K top = this.refArray[this.array[findFirst()]];
        int i = this.size;
        int c = 0;
        while (true) {
            i--;
            if (i == 0) {
                return c;
            }
            if (top.equals(this.refArray[this.array[i]])) {
                c++;
                a[c] = this.array[i];
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public void clear() {
        this.size = 0;
        this.firstIndexValid = false;
    }

    public void trim() {
        this.array = IntArrays.trim(this.array, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public Comparator<? super K> comparator() {
        return this.f2645c;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("[");
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                s.append(", ");
            }
            s.append(this.refArray[this.array[i]]);
        }
        s.append("]");
        return s.toString();
    }
}
