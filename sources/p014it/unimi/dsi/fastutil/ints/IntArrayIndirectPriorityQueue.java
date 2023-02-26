package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.ints.IntArrayIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntArrayIndirectPriorityQueue.class */
public class IntArrayIndirectPriorityQueue implements IntIndirectPriorityQueue {
    protected int[] refArray;
    protected int[] array;
    protected int size;

    /* renamed from: c */
    protected IntComparator f2114c;
    protected int firstIndex;
    protected boolean firstIndexValid;

    public IntArrayIndirectPriorityQueue(int[] refArray, int capacity, IntComparator c) {
        this.array = IntArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new int[capacity];
        }
        this.refArray = refArray;
        this.f2114c = c;
    }

    public IntArrayIndirectPriorityQueue(int[] refArray, int capacity) {
        this(refArray, capacity, (IntComparator) null);
    }

    public IntArrayIndirectPriorityQueue(int[] refArray, IntComparator c) {
        this(refArray, refArray.length, c);
    }

    public IntArrayIndirectPriorityQueue(int[] refArray) {
        this(refArray, refArray.length, (IntComparator) null);
    }

    public IntArrayIndirectPriorityQueue(int[] refArray, int[] a, int size, IntComparator c) {
        this(refArray, 0, c);
        this.array = a;
        this.size = size;
    }

    public IntArrayIndirectPriorityQueue(int[] refArray, int[] a, IntComparator c) {
        this(refArray, a, a.length, c);
    }

    public IntArrayIndirectPriorityQueue(int[] refArray, int[] a, int size) {
        this(refArray, a, size, null);
    }

    public IntArrayIndirectPriorityQueue(int[] refArray, int[] a) {
        this(refArray, a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        int first = this.refArray[this.array[firstIndex]];
        if (this.f2114c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f2114c.compare(this.refArray[this.array[i]], first) < 0) {
                    firstIndex = i;
                    first = this.refArray[this.array[i]];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.refArray[this.array[i]] < first) {
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
        int last = this.refArray[this.array[lastIndex]];
        if (this.f2114c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f2114c.compare(last, this.refArray[this.array[i]]) < 0) {
                    lastIndex = i;
                    last = this.refArray[this.array[i]];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (last < this.refArray[this.array[i]]) {
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
        } else if (this.f2114c == null) {
            if (this.refArray[x] < this.refArray[this.array[this.firstIndex]]) {
                this.firstIndex = this.size;
            }
        } else if (this.f2114c.compare(this.refArray[x], this.refArray[this.array[this.firstIndex]]) < 0) {
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
        int top = this.refArray[this.array[findFirst()]];
        int i = this.size;
        int c = 0;
        while (true) {
            i--;
            if (i == 0) {
                return c;
            }
            if (top == this.refArray[this.array[i]]) {
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.IntIndirectPriorityQueue, p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    public Comparator<? super Integer> comparator() {
        return this.f2114c;
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
