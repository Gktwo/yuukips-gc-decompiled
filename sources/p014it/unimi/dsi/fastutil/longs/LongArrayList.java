package p014it.unimi.dsi.fastutil.longs;

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
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.longs.AbstractLongList;
import p014it.unimi.dsi.fastutil.longs.LongCollections;
import p014it.unimi.dsi.fastutil.longs.LongIterators;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.LongArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayList.class */
public class LongArrayList extends AbstractLongList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient long[] f2393a;
    protected int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LongArrayList.class.desiredAssertionStatus();
    }

    private static final long[] copyArraySafe(long[] a, int length) {
        return length == 0 ? LongArrays.EMPTY_ARRAY : Arrays.copyOf(a, length);
    }

    private static final long[] copyArrayFromSafe(LongArrayList l) {
        return copyArraySafe(l.f2393a, l.size);
    }

    protected LongArrayList(long[] a, boolean wrapped) {
        this.f2393a = a;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f2393a = LongArrays.EMPTY_ARRAY;
        } else {
            this.f2393a = new long[capacity];
        }
    }

    public LongArrayList(int capacity) {
        initArrayFromCapacity(capacity);
    }

    public LongArrayList() {
        this.f2393a = LongArrays.DEFAULT_EMPTY_ARRAY;
    }

    public LongArrayList(Collection<? extends Long> c) {
        if (c instanceof LongArrayList) {
            this.f2393a = copyArrayFromSafe((LongArrayList) c);
            this.size = this.f2393a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof LongList) {
            long[] jArr = this.f2393a;
            int size = c.size();
            this.size = size;
            ((LongList) c).getElements(0, jArr, 0, size);
            return;
        }
        this.size = LongIterators.unwrap(LongIterators.asLongIterator(c.iterator()), this.f2393a);
    }

    public LongArrayList(LongCollection c) {
        if (c instanceof LongArrayList) {
            this.f2393a = copyArrayFromSafe((LongArrayList) c);
            this.size = this.f2393a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof LongList) {
            long[] jArr = this.f2393a;
            int size = c.size();
            this.size = size;
            ((LongList) c).getElements(0, jArr, 0, size);
            return;
        }
        this.size = LongIterators.unwrap(c.iterator(), this.f2393a);
    }

    public LongArrayList(LongList l) {
        if (l instanceof LongArrayList) {
            this.f2393a = copyArrayFromSafe((LongArrayList) l);
            this.size = this.f2393a.length;
            return;
        }
        initArrayFromCapacity(l.size());
        long[] jArr = this.f2393a;
        int size = l.size();
        this.size = size;
        l.getElements(0, jArr, 0, size);
    }

    public LongArrayList(long[] a) {
        this(a, 0, a.length);
    }

    public LongArrayList(long[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f2393a, 0, length);
        this.size = length;
    }

    public LongArrayList(Iterator<? extends Long> i) {
        this();
        while (i.hasNext()) {
            add(((Long) i.next()).longValue());
        }
    }

    public LongArrayList(LongIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextLong());
        }
    }

    public long[] elements() {
        return this.f2393a;
    }

    public static LongArrayList wrap(long[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        LongArrayList l = new LongArrayList(a, true);
        l.size = length;
        return l;
    }

    public static LongArrayList wrap(long[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static LongArrayList m670of() {
        return new LongArrayList();
    }

    /* renamed from: of */
    public static LongArrayList m669of(long... init) {
        return wrap(init);
    }

    public static LongArrayList toList(LongStream stream) {
        return (LongArrayList) stream.collect(LongArrayList::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static LongArrayList toListWithExpectedSize(LongStream stream, int expectedSize) {
        if (expectedSize <= 10) {
            return toList(stream);
        }
        return (LongArrayList) stream.collect(new LongCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 10 ? new LongArrayList() : new LongArrayList(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f2393a.length) {
            return;
        }
        if (this.f2393a != LongArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            this.f2393a = LongArrays.ensureCapacity(this.f2393a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f2393a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f2393a.length) {
            if (this.f2393a != LongArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f2393a.length) + ((long) (this.f2393a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f2393a = LongArrays.forceCapacity(this.f2393a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f2393a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public void add(int index, long k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f2393a, index, this.f2393a, index + 1, this.size - index);
        }
        this.f2393a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f2393a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean add(long k) {
        grow(this.size + 1);
        long[] jArr = this.f2393a;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f2393a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public long getLong(int index) {
        if (index < this.size) {
            return this.f2393a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public int indexOf(long k) {
        for (int i = 0; i < this.size; i++) {
            if (k == this.f2393a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public int lastIndexOf(long k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f2393a[i]);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public long removeLong(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        long old = this.f2393a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f2393a, index + 1, this.f2393a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= this.f2393a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean rem(long k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeLong(index);
        if ($assertionsDisabled || this.size <= this.f2393a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public long set(int index, long k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        long old = this.f2393a[index];
        this.f2393a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f2393a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public void size(int size) {
        if (size > this.f2393a.length) {
            this.f2393a = LongArrays.forceCapacity(this.f2393a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f2393a, this.size, size, 0L);
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
        if (n < this.f2393a.length && this.size != this.f2393a.length) {
            long[] t = new long[Math.max(n, this.size)];
            System.arraycopy(this.f2393a, 0, t, 0, this.size);
            this.f2393a = t;
            if (!$assertionsDisabled && this.size > this.f2393a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayList$SubList.class */
    public class SubList extends AbstractLongList.LongRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(int from, int to) {
            super(LongArrayList.this, from, to);
        }

        private long[] getParentArray() {
            return LongArrayList.this.f2393a;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList.LongSubList, p014it.unimi.dsi.fastutil.longs.LongList
        public long getLong(int i) {
            ensureRestrictedIndex(i);
            return LongArrayList.this.f2393a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.LongArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends LongIterators.AbstractIndexBasedListIterator {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final long get(int i) {
                return LongArrayList.this.f2393a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator
            protected final void add(int i, long k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator
            protected final void set(int i, long k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.removeLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f2262to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongArrayList.this.f2393a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return jArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            public long previousLong() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongArrayList.this.f2393a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return jArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterators.AbstractIndexBasedIterator, java.util.PrimitiveIterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = SubList.this.f2262to - SubList.this.from;
                while (this.pos < max) {
                    long[] jArr = LongArrayList.this.f2393a;
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept(jArr[i + i2]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList.LongSubList, p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.LongArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends LongSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f2262to;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            protected final long get(int i) {
                return LongArrayList.this.f2393a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public boolean tryAdvance(LongConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                long[] jArr = LongArrayList.this.f2393a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(jArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    long[] jArr = LongArrayList.this.f2393a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList.LongSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(long[] otherA, int otherAFrom, int otherATo) {
            if (LongArrayList.this.f2393a == otherA && this.from == otherAFrom && this.f2262to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f2262to) {
                pos++;
                otherPos++;
                if (LongArrayList.this.f2393a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof LongArrayList) {
                LongArrayList other = (LongArrayList) o;
                return contentsEquals(other.f2393a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f2262to);
            }
        }

        int contentsCompareTo(long[] otherA, int otherAFrom, int otherATo) {
            if (LongArrayList.this.f2393a == otherA && this.from == otherAFrom && this.f2262to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f2262to && i < otherATo) {
                int r = Long.compare(LongArrayList.this.f2393a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f2262to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList
        public int compareTo(List<? extends Long> l) {
            if (l instanceof LongArrayList) {
                LongArrayList other = (LongArrayList) l;
                return contentsCompareTo(other.f2393a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f2262to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
    public List<Long> subList(int from, int to) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public void getElements(int from, long[] a, int offset, int length) {
        LongArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f2393a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f2393a, to, this.f2393a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public void addElements(int index, long[] a, int offset, int length) {
        ensureIndex(index);
        LongArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f2393a, index, this.f2393a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f2393a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public void setElements(int index, long[] a, int offset, int length) {
        ensureIndex(index);
        LongArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f2393a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongIterable
    public void forEach(LongConsumer action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.f2393a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public boolean addAll(int index, LongCollection c) {
        if (c instanceof LongList) {
            return addAll(index, (LongList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f2393a, index, this.f2393a, index + n, this.size - index);
        LongIterator i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f2393a[index] = i.nextLong();
        }
        if ($assertionsDisabled || this.size <= this.f2393a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public boolean addAll(int index, LongList l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f2393a, index, this.f2393a, index + n, this.size - index);
        l.getElements(0, this.f2393a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f2393a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean removeAll(LongCollection c) {
        long[] a = this.f2393a;
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toArray(long[] a) {
        if (a == null || a.length < this.size) {
            a = Arrays.copyOf(a, this.size);
        }
        System.arraycopy(this.f2393a, 0, a, 0, this.size);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
    public ListIterator<Long> listIterator(final int index) {
        ensureIndex(index);
        return new LongListIterator() { // from class: it.unimi.dsi.fastutil.longs.LongArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < LongArrayList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongArrayList.this.f2393a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return jArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            public long previousLong() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongArrayList.this.f2393a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
                return jArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
            public void add(long k) {
                LongArrayList longArrayList = LongArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                longArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
            public void set(long k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                LongArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                LongArrayList.this.removeLong(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // java.util.PrimitiveIterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                while (this.pos < LongArrayList.this.size) {
                    long[] jArr = LongArrayList.this.f2393a;
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept(jArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = LongArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = LongArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = LongArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrayList$Spliterator.class */
    public final class Spliterator implements LongSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !LongArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(LongArrayList longArrayList) {
            this(0, longArrayList.size, false);
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
            return this.hasSplit ? this.max : LongArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            long[] jArr = LongArrayList.this.f2393a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(jArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(LongArrayList.this.f2393a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public void sort(LongComparator comp) {
        if (comp == null) {
            LongArrays.stableSort(this.f2393a, 0, this.size);
        } else {
            LongArrays.stableSort(this.f2393a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public void unstableSort(LongComparator comp) {
        if (comp == null) {
            LongArrays.unstableSort(this.f2393a, 0, this.size);
        } else {
            LongArrays.unstableSort(this.f2393a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public LongArrayList clone() {
        LongArrayList cloned;
        if (getClass() == LongArrayList.class) {
            cloned = new LongArrayList(copyArraySafe(this.f2393a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (LongArrayList) clone();
                cloned.f2393a = copyArraySafe(this.f2393a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(LongArrayList l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        long[] a1 = this.f2393a;
        long[] a2 = l.f2393a;
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof LongArrayList) {
            return equals((LongArrayList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(LongArrayList l) {
        int s1 = size();
        int s2 = l.size();
        long[] a1 = this.f2393a;
        long[] a2 = l.f2393a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Long.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList
    public int compareTo(List<? extends Long> l) {
        if (l instanceof LongArrayList) {
            return compareTo((LongArrayList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List<? extends Long>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeLong(this.f2393a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2393a = new long[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f2393a[i] = s.readLong();
        }
    }
}
