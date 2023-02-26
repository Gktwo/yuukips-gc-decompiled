package p014it.unimi.dsi.fastutil.shorts;

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
import p014it.unimi.dsi.fastutil.shorts.AbstractShortList;
import p014it.unimi.dsi.fastutil.shorts.ShortIterators;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayList.class */
public class ShortArrayList extends AbstractShortList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient short[] f2987a;
    protected int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ShortArrayList.class.desiredAssertionStatus();
    }

    private static final short[] copyArraySafe(short[] a, int length) {
        return length == 0 ? ShortArrays.EMPTY_ARRAY : Arrays.copyOf(a, length);
    }

    private static final short[] copyArrayFromSafe(ShortArrayList l) {
        return copyArraySafe(l.f2987a, l.size);
    }

    protected ShortArrayList(short[] a, boolean wrapped) {
        this.f2987a = a;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f2987a = ShortArrays.EMPTY_ARRAY;
        } else {
            this.f2987a = new short[capacity];
        }
    }

    public ShortArrayList(int capacity) {
        initArrayFromCapacity(capacity);
    }

    public ShortArrayList() {
        this.f2987a = ShortArrays.DEFAULT_EMPTY_ARRAY;
    }

    public ShortArrayList(Collection<? extends Short> c) {
        if (c instanceof ShortArrayList) {
            this.f2987a = copyArrayFromSafe((ShortArrayList) c);
            this.size = this.f2987a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof ShortList) {
            short[] sArr = this.f2987a;
            int size = c.size();
            this.size = size;
            ((ShortList) c).getElements(0, sArr, 0, size);
            return;
        }
        this.size = ShortIterators.unwrap(ShortIterators.asShortIterator(c.iterator()), this.f2987a);
    }

    public ShortArrayList(ShortCollection c) {
        if (c instanceof ShortArrayList) {
            this.f2987a = copyArrayFromSafe((ShortArrayList) c);
            this.size = this.f2987a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof ShortList) {
            short[] sArr = this.f2987a;
            int size = c.size();
            this.size = size;
            ((ShortList) c).getElements(0, sArr, 0, size);
            return;
        }
        this.size = ShortIterators.unwrap(c.iterator(), this.f2987a);
    }

    public ShortArrayList(ShortList l) {
        if (l instanceof ShortArrayList) {
            this.f2987a = copyArrayFromSafe((ShortArrayList) l);
            this.size = this.f2987a.length;
            return;
        }
        initArrayFromCapacity(l.size());
        short[] sArr = this.f2987a;
        int size = l.size();
        this.size = size;
        l.getElements(0, sArr, 0, size);
    }

    public ShortArrayList(short[] a) {
        this(a, 0, a.length);
    }

    public ShortArrayList(short[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f2987a, 0, length);
        this.size = length;
    }

    public ShortArrayList(Iterator<? extends Short> i) {
        this();
        while (i.hasNext()) {
            add(((Short) i.next()).shortValue());
        }
    }

    public ShortArrayList(ShortIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextShort());
        }
    }

    public short[] elements() {
        return this.f2987a;
    }

    public static ShortArrayList wrap(short[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        ShortArrayList l = new ShortArrayList(a, true);
        l.size = length;
        return l;
    }

    public static ShortArrayList wrap(short[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static ShortArrayList m445of() {
        return new ShortArrayList();
    }

    /* renamed from: of */
    public static ShortArrayList m444of(short... init) {
        return wrap(init);
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f2987a.length) {
            return;
        }
        if (this.f2987a != ShortArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            this.f2987a = ShortArrays.ensureCapacity(this.f2987a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f2987a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f2987a.length) {
            if (this.f2987a != ShortArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f2987a.length) + ((long) (this.f2987a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f2987a = ShortArrays.forceCapacity(this.f2987a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f2987a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public void add(int index, short k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f2987a, index, this.f2987a, index + 1, this.size - index);
        }
        this.f2987a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f2987a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean add(short k) {
        grow(this.size + 1);
        short[] sArr = this.f2987a;
        int i = this.size;
        this.size = i + 1;
        sArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f2987a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public short getShort(int index) {
        if (index < this.size) {
            return this.f2987a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public int indexOf(short k) {
        for (int i = 0; i < this.size; i++) {
            if (k == this.f2987a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public int lastIndexOf(short k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f2987a[i]);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public short removeShort(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        short old = this.f2987a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f2987a, index + 1, this.f2987a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= this.f2987a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean rem(short k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeShort(index);
        if ($assertionsDisabled || this.size <= this.f2987a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public short set(int index, short k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        short old = this.f2987a[index];
        this.f2987a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f2987a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public void size(int size) {
        if (size > this.f2987a.length) {
            this.f2987a = ShortArrays.forceCapacity(this.f2987a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f2987a, this.size, size, (short) 0);
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
        if (n < this.f2987a.length && this.size != this.f2987a.length) {
            short[] t = new short[Math.max(n, this.size)];
            System.arraycopy(this.f2987a, 0, t, 0, this.size);
            this.f2987a = t;
            if (!$assertionsDisabled && this.size > this.f2987a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayList$SubList.class */
    public class SubList extends AbstractShortList.ShortRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(int from, int to) {
            super(ShortArrayList.this, from, to);
        }

        private short[] getParentArray() {
            return ShortArrayList.this.f2987a;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList.ShortSubList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public short getShort(int i) {
            ensureRestrictedIndex(i);
            return ShortArrayList.this.f2987a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends ShortIterators.AbstractIndexBasedListIterator {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final short get(int i) {
                return ShortArrayList.this.f2987a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator
            protected final void add(int i, short k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator
            protected final void set(int i, short k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.removeShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f2856to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                short[] sArr = ShortArrayList.this.f2987a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return sArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            public short previousShort() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                short[] sArr = ShortArrayList.this.f2987a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return sArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public void forEachRemaining(ShortConsumer action) {
                int max = SubList.this.f2856to - SubList.this.from;
                while (this.pos < max) {
                    short[] sArr = ShortArrayList.this.f2987a;
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept(sArr[i + i2]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList.ShortSubList, p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ShortSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f2856to;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            protected final short get(int i) {
                return ShortArrayList.this.f2987a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(ShortConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                short[] sArr = ShortArrayList.this.f2987a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(sArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ShortConsumer action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    short[] sArr = ShortArrayList.this.f2987a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(sArr[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList.ShortSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(short[] otherA, int otherAFrom, int otherATo) {
            if (ShortArrayList.this.f2987a == otherA && this.from == otherAFrom && this.f2856to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f2856to) {
                pos++;
                otherPos++;
                if (ShortArrayList.this.f2987a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof ShortArrayList) {
                ShortArrayList other = (ShortArrayList) o;
                return contentsEquals(other.f2987a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f2856to);
            }
        }

        int contentsCompareTo(short[] otherA, int otherAFrom, int otherATo) {
            if (ShortArrayList.this.f2987a == otherA && this.from == otherAFrom && this.f2856to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f2856to && i < otherATo) {
                int r = Short.compare(ShortArrayList.this.f2987a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f2856to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList
        public int compareTo(List<? extends Short> l) {
            if (l instanceof ShortArrayList) {
                ShortArrayList other = (ShortArrayList) l;
                return contentsCompareTo(other.f2987a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f2856to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
    public List<Short> subList(int from, int to) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public void getElements(int from, short[] a, int offset, int length) {
        ShortArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f2987a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f2987a, to, this.f2987a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public void addElements(int index, short[] a, int offset, int length) {
        ensureIndex(index);
        ShortArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f2987a, index, this.f2987a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f2987a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public void setElements(int index, short[] a, int offset, int length) {
        ensureIndex(index);
        ShortArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f2987a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public void forEach(ShortConsumer action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.f2987a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public boolean addAll(int index, ShortCollection c) {
        if (c instanceof ShortList) {
            return addAll(index, (ShortList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f2987a, index, this.f2987a, index + n, this.size - index);
        ShortIterator i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f2987a[index] = i.nextShort();
        }
        if ($assertionsDisabled || this.size <= this.f2987a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public boolean addAll(int index, ShortList l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f2987a, index, this.f2987a, index + n, this.size - index);
        l.getElements(0, this.f2987a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f2987a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean removeAll(ShortCollection c) {
        short[] a = this.f2987a;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toArray(short[] a) {
        if (a == null || a.length < this.size) {
            a = Arrays.copyOf(a, this.size);
        }
        System.arraycopy(this.f2987a, 0, a, 0, this.size);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
    public ListIterator<Short> listIterator(final int index) {
        ensureIndex(index);
        return new ShortListIterator() { // from class: it.unimi.dsi.fastutil.shorts.ShortArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < ShortArrayList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                short[] sArr = ShortArrayList.this.f2987a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return sArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            public short previousShort() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                short[] sArr = ShortArrayList.this.f2987a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
                return sArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
            public void add(short k) {
                ShortArrayList shortArrayList = ShortArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                shortArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
            public void set(short k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ShortArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ShortArrayList.this.removeShort(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public void forEachRemaining(ShortConsumer action) {
                while (this.pos < ShortArrayList.this.size) {
                    short[] sArr = ShortArrayList.this.f2987a;
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept(sArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ShortArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ShortArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = ShortArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrayList$Spliterator.class */
    public final class Spliterator implements ShortSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ShortArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(ShortArrayList shortArrayList) {
            this(0, shortArrayList.size, false);
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
            return this.hasSplit ? this.max : ShortArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(ShortConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            short[] sArr = ShortArrayList.this.f2987a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(sArr[i]);
            return true;
        }

        public void forEachRemaining(ShortConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(ShortArrayList.this.f2987a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public void sort(ShortComparator comp) {
        if (comp == null) {
            ShortArrays.stableSort(this.f2987a, 0, this.size);
        } else {
            ShortArrays.stableSort(this.f2987a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public void unstableSort(ShortComparator comp) {
        if (comp == null) {
            ShortArrays.unstableSort(this.f2987a, 0, this.size);
        } else {
            ShortArrays.unstableSort(this.f2987a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public ShortArrayList clone() {
        ShortArrayList cloned;
        if (getClass() == ShortArrayList.class) {
            cloned = new ShortArrayList(copyArraySafe(this.f2987a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (ShortArrayList) clone();
                cloned.f2987a = copyArraySafe(this.f2987a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(ShortArrayList l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        short[] a1 = this.f2987a;
        short[] a2 = l.f2987a;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof ShortArrayList) {
            return equals((ShortArrayList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ShortArrayList l) {
        int s1 = size();
        int s2 = l.size();
        short[] a1 = this.f2987a;
        short[] a2 = l.f2987a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Short.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList
    public int compareTo(List<? extends Short> l) {
        if (l instanceof ShortArrayList) {
            return compareTo((ShortArrayList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List<? extends Short>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeShort(this.f2987a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2987a = new short[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f2987a[i] = s.readShort();
        }
    }
}
