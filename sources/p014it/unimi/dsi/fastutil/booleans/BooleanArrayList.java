package p014it.unimi.dsi.fastutil.booleans;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterators;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrayList.class */
public class BooleanArrayList extends AbstractBooleanList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient boolean[] f1046a;
    protected int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !BooleanArrayList.class.desiredAssertionStatus();
    }

    private static final boolean[] copyArraySafe(boolean[] a, int length) {
        return length == 0 ? BooleanArrays.EMPTY_ARRAY : Arrays.copyOf(a, length);
    }

    private static final boolean[] copyArrayFromSafe(BooleanArrayList l) {
        return copyArraySafe(l.f1046a, l.size);
    }

    protected BooleanArrayList(boolean[] a, boolean wrapped) {
        this.f1046a = a;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f1046a = BooleanArrays.EMPTY_ARRAY;
        } else {
            this.f1046a = new boolean[capacity];
        }
    }

    public BooleanArrayList(int capacity) {
        initArrayFromCapacity(capacity);
    }

    public BooleanArrayList() {
        this.f1046a = BooleanArrays.DEFAULT_EMPTY_ARRAY;
    }

    public BooleanArrayList(Collection<? extends Boolean> c) {
        if (c instanceof BooleanArrayList) {
            this.f1046a = copyArrayFromSafe((BooleanArrayList) c);
            this.size = this.f1046a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof BooleanList) {
            boolean[] zArr = this.f1046a;
            int size = c.size();
            this.size = size;
            ((BooleanList) c).getElements(0, zArr, 0, size);
            return;
        }
        this.size = BooleanIterators.unwrap(BooleanIterators.asBooleanIterator(c.iterator()), this.f1046a);
    }

    public BooleanArrayList(BooleanCollection c) {
        if (c instanceof BooleanArrayList) {
            this.f1046a = copyArrayFromSafe((BooleanArrayList) c);
            this.size = this.f1046a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof BooleanList) {
            boolean[] zArr = this.f1046a;
            int size = c.size();
            this.size = size;
            ((BooleanList) c).getElements(0, zArr, 0, size);
            return;
        }
        this.size = BooleanIterators.unwrap(c.iterator(), this.f1046a);
    }

    public BooleanArrayList(BooleanList l) {
        if (l instanceof BooleanArrayList) {
            this.f1046a = copyArrayFromSafe((BooleanArrayList) l);
            this.size = this.f1046a.length;
            return;
        }
        initArrayFromCapacity(l.size());
        boolean[] zArr = this.f1046a;
        int size = l.size();
        this.size = size;
        l.getElements(0, zArr, 0, size);
    }

    public BooleanArrayList(boolean[] a) {
        this(a, 0, a.length);
    }

    public BooleanArrayList(boolean[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f1046a, 0, length);
        this.size = length;
    }

    public BooleanArrayList(Iterator<? extends Boolean> i) {
        this();
        while (i.hasNext()) {
            add(((Boolean) i.next()).booleanValue());
        }
    }

    public BooleanArrayList(BooleanIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextBoolean());
        }
    }

    public boolean[] elements() {
        return this.f1046a;
    }

    public static BooleanArrayList wrap(boolean[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        BooleanArrayList l = new BooleanArrayList(a, true);
        l.size = length;
        return l;
    }

    public static BooleanArrayList wrap(boolean[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static BooleanArrayList m1169of() {
        return new BooleanArrayList();
    }

    /* renamed from: of */
    public static BooleanArrayList m1168of(boolean... init) {
        return wrap(init);
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f1046a.length) {
            return;
        }
        if (this.f1046a != BooleanArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            this.f1046a = BooleanArrays.ensureCapacity(this.f1046a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1046a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f1046a.length) {
            if (this.f1046a != BooleanArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f1046a.length) + ((long) (this.f1046a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f1046a = BooleanArrays.forceCapacity(this.f1046a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1046a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void add(int index, boolean k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f1046a, index, this.f1046a, index + 1, this.size - index);
        }
        this.f1046a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f1046a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean add(boolean k) {
        grow(this.size + 1);
        boolean[] zArr = this.f1046a;
        int i = this.size;
        this.size = i + 1;
        zArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f1046a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean getBoolean(int index) {
        if (index < this.size) {
            return this.f1046a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public int indexOf(boolean k) {
        for (int i = 0; i < this.size; i++) {
            if (k == this.f1046a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public int lastIndexOf(boolean k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f1046a[i]);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean removeBoolean(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        boolean old = this.f1046a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f1046a, index + 1, this.f1046a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= this.f1046a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean rem(boolean k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeBoolean(index);
        if ($assertionsDisabled || this.size <= this.f1046a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean set(int index, boolean k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        boolean old = this.f1046a[index];
        this.f1046a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f1046a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void size(int size) {
        if (size > this.f1046a.length) {
            this.f1046a = BooleanArrays.forceCapacity(this.f1046a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f1046a, this.size, size, false);
        }
        this.size = size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void trim() {
        trim(0);
    }

    public void trim(int n) {
        if (n < this.f1046a.length && this.size != this.f1046a.length) {
            boolean[] t = new boolean[Math.max(n, this.size)];
            System.arraycopy(this.f1046a, 0, t, 0, this.size);
            this.f1046a = t;
            if (!$assertionsDisabled && this.size > this.f1046a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrayList$SubList.class */
    public class SubList extends AbstractBooleanList.BooleanRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(int from, int to) {
            super(BooleanArrayList.this, from, to);
        }

        private boolean[] getParentArray() {
            return BooleanArrayList.this.f1046a;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.BooleanSubList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean getBoolean(int i) {
            ensureRestrictedIndex(i);
            return BooleanArrayList.this.f1046a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends BooleanIterators.AbstractIndexBasedListIterator {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final boolean get(int i) {
                return BooleanArrayList.this.f1046a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator
            protected final void add(int i, boolean k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator
            protected final void set(int i, boolean k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.removeBoolean(i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f1044to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public boolean nextBoolean() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                boolean[] zArr = BooleanArrayList.this.f1046a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return zArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
            public boolean previousBoolean() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                boolean[] zArr = BooleanArrayList.this.f1046a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return zArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public void forEachRemaining(BooleanConsumer action) {
                int max = SubList.this.f1044to - SubList.this.from;
                while (this.pos < max) {
                    boolean[] zArr = BooleanArrayList.this.f1046a;
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept(zArr[i + i2]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.BooleanSubList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends BooleanSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f1044to;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            protected final boolean get(int i) {
                return BooleanArrayList.this.f1046a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(BooleanConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                boolean[] zArr = BooleanArrayList.this.f1046a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(zArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(BooleanConsumer action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    boolean[] zArr = BooleanArrayList.this.f1046a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(zArr[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList.BooleanSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(boolean[] otherA, int otherAFrom, int otherATo) {
            if (BooleanArrayList.this.f1046a == otherA && this.from == otherAFrom && this.f1044to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1044to) {
                pos++;
                otherPos++;
                if (BooleanArrayList.this.f1046a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof BooleanArrayList) {
                BooleanArrayList other = (BooleanArrayList) o;
                return contentsEquals(other.f1046a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f1044to);
            }
        }

        int contentsCompareTo(boolean[] otherA, int otherAFrom, int otherATo) {
            if (BooleanArrayList.this.f1046a == otherA && this.from == otherAFrom && this.f1044to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1044to && i < otherATo) {
                int r = Boolean.compare(BooleanArrayList.this.f1046a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1044to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList
        public int compareTo(List<? extends Boolean> l) {
            if (l instanceof BooleanArrayList) {
                BooleanArrayList other = (BooleanArrayList) l;
                return contentsCompareTo(other.f1046a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f1044to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
    public List<Boolean> subList(int from, int to) {
        if (from == 0 && to == size()) {
            return this;
        }
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return new SubList(from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void getElements(int from, boolean[] a, int offset, int length) {
        BooleanArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1046a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f1046a, to, this.f1046a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void addElements(int index, boolean[] a, int offset, int length) {
        ensureIndex(index);
        BooleanArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f1046a, index, this.f1046a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f1046a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void setElements(int index, boolean[] a, int offset, int length) {
        ensureIndex(index);
        BooleanArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f1046a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
    public void forEach(BooleanConsumer action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.f1046a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean addAll(int index, BooleanCollection c) {
        if (c instanceof BooleanList) {
            return addAll(index, (BooleanList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1046a, index, this.f1046a, index + n, this.size - index);
        BooleanIterator i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f1046a[index] = i.nextBoolean();
        }
        if ($assertionsDisabled || this.size <= this.f1046a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean addAll(int index, BooleanList l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1046a, index, this.f1046a, index + n, this.size - index);
        l.getElements(0, this.f1046a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f1046a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean removeAll(BooleanCollection c) {
        boolean[] a = this.f1046a;
        int j = 0;
        for (int i = 0; i < this.size; i++) {
            if (!c.contains(a[i])) {
                j++;
                a[j] = a[i];
            }
        }
        boolean modified = this.size != j;
        this.size = j;
        return modified;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toArray(boolean[] a) {
        if (a == null || a.length < this.size) {
            a = Arrays.copyOf(a, this.size);
        }
        System.arraycopy(this.f1046a, 0, a, 0, this.size);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
    public ListIterator<Boolean> listIterator(final int index) {
        ensureIndex(index);
        return new BooleanListIterator() { // from class: it.unimi.dsi.fastutil.booleans.BooleanArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < BooleanArrayList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public boolean nextBoolean() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                boolean[] zArr = BooleanArrayList.this.f1046a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return zArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
            public boolean previousBoolean() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                boolean[] zArr = BooleanArrayList.this.f1046a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
                return zArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
            public void add(boolean k) {
                BooleanArrayList booleanArrayList = BooleanArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                booleanArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
            public void set(boolean k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                BooleanArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                BooleanArrayList.this.removeBoolean(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public void forEachRemaining(BooleanConsumer action) {
                while (this.pos < BooleanArrayList.this.size) {
                    boolean[] zArr = BooleanArrayList.this.f1046a;
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept(zArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = BooleanArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = BooleanArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = BooleanArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrayList$Spliterator.class */
    public final class Spliterator implements BooleanSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !BooleanArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(BooleanArrayList booleanArrayList) {
            this(0, booleanArrayList.size, false);
        }

        private Spliterator(int pos, int max, boolean hasSplit) {
            this.hasSplit = false;
            if ($assertionsDisabled || pos <= max) {
                this.pos = pos;
                this.max = max;
                this.hasSplit = hasSplit;
                return;
            }
            throw new AssertionError("pos " + pos + " must be <= max " + max);
        }

        private int getWorkingMax() {
            return this.hasSplit ? this.max : BooleanArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            boolean[] zArr = BooleanArrayList.this.f1046a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(zArr[i]);
            return true;
        }

        public void forEachRemaining(BooleanConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(BooleanArrayList.this.f1046a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int max = getWorkingMax();
            if (this.pos >= max) {
                return 0;
            }
            int remaining = max - this.pos;
            if (n < ((long) remaining)) {
                this.pos = SafeMath.safeLongToInt(((long) this.pos) + n);
                return n;
            }
            long n2 = (long) remaining;
            this.pos = max;
            return n2;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            int max = getWorkingMax();
            int retLen = (max - this.pos) >> 1;
            if (retLen <= 1) {
                return null;
            }
            this.max = max;
            int myNewPos = this.pos + retLen;
            int oldPos = this.pos;
            this.pos = myNewPos;
            this.hasSplit = true;
            return new Spliterator(oldPos, myNewPos, true);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void sort(BooleanComparator comp) {
        if (comp == null) {
            BooleanArrays.stableSort(this.f1046a, 0, this.size);
        } else {
            BooleanArrays.stableSort(this.f1046a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void unstableSort(BooleanComparator comp) {
        if (comp == null) {
            BooleanArrays.unstableSort(this.f1046a, 0, this.size);
        } else {
            BooleanArrays.unstableSort(this.f1046a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public BooleanArrayList clone() {
        BooleanArrayList cloned;
        if (getClass() == BooleanArrayList.class) {
            cloned = new BooleanArrayList(copyArraySafe(this.f1046a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (BooleanArrayList) clone();
                cloned.f1046a = copyArraySafe(this.f1046a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(BooleanArrayList l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        boolean[] a1 = this.f1046a;
        boolean[] a2 = l.f1046a;
        if (a1 == a2 && s == l.size()) {
            return true;
        }
        do {
            s--;
            if (s == 0) {
                return true;
            }
        } while (a1[s] == a2[s]);
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof BooleanArrayList) {
            return equals((BooleanArrayList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(BooleanArrayList l) {
        int s1 = size();
        int s2 = l.size();
        boolean[] a1 = this.f1046a;
        boolean[] a2 = l.f1046a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Boolean.compare(a1[i], a2[i]);
            if (r != 0) {
                return r;
            }
            i++;
        }
        if (i < s2) {
            return -1;
        }
        return i < s1 ? 1 : 0;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList
    public int compareTo(List<? extends Boolean> l) {
        if (l instanceof BooleanArrayList) {
            return compareTo((BooleanArrayList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List<? extends Boolean>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeBoolean(this.f1046a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1046a = new boolean[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1046a[i] = s.readBoolean();
        }
    }
}
