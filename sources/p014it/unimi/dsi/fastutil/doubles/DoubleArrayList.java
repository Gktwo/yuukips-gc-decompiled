package p014it.unimi.dsi.fastutil.doubles;

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
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterators;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArrayList.class */
public class DoubleArrayList extends AbstractDoubleList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient double[] f1665a;
    protected int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DoubleArrayList.class.desiredAssertionStatus();
    }

    private static final double[] copyArraySafe(double[] a, int length) {
        return length == 0 ? DoubleArrays.EMPTY_ARRAY : Arrays.copyOf(a, length);
    }

    private static final double[] copyArrayFromSafe(DoubleArrayList l) {
        return copyArraySafe(l.f1665a, l.size);
    }

    protected DoubleArrayList(double[] a, boolean wrapped) {
        this.f1665a = a;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f1665a = DoubleArrays.EMPTY_ARRAY;
        } else {
            this.f1665a = new double[capacity];
        }
    }

    public DoubleArrayList(int capacity) {
        initArrayFromCapacity(capacity);
    }

    public DoubleArrayList() {
        this.f1665a = DoubleArrays.DEFAULT_EMPTY_ARRAY;
    }

    public DoubleArrayList(Collection<? extends Double> c) {
        if (c instanceof DoubleArrayList) {
            this.f1665a = copyArrayFromSafe((DoubleArrayList) c);
            this.size = this.f1665a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof DoubleList) {
            double[] dArr = this.f1665a;
            int size = c.size();
            this.size = size;
            ((DoubleList) c).getElements(0, dArr, 0, size);
            return;
        }
        this.size = DoubleIterators.unwrap(DoubleIterators.asDoubleIterator(c.iterator()), this.f1665a);
    }

    public DoubleArrayList(DoubleCollection c) {
        if (c instanceof DoubleArrayList) {
            this.f1665a = copyArrayFromSafe((DoubleArrayList) c);
            this.size = this.f1665a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof DoubleList) {
            double[] dArr = this.f1665a;
            int size = c.size();
            this.size = size;
            ((DoubleList) c).getElements(0, dArr, 0, size);
            return;
        }
        this.size = DoubleIterators.unwrap(c.iterator(), this.f1665a);
    }

    public DoubleArrayList(DoubleList l) {
        if (l instanceof DoubleArrayList) {
            this.f1665a = copyArrayFromSafe((DoubleArrayList) l);
            this.size = this.f1665a.length;
            return;
        }
        initArrayFromCapacity(l.size());
        double[] dArr = this.f1665a;
        int size = l.size();
        this.size = size;
        l.getElements(0, dArr, 0, size);
    }

    public DoubleArrayList(double[] a) {
        this(a, 0, a.length);
    }

    public DoubleArrayList(double[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f1665a, 0, length);
        this.size = length;
    }

    public DoubleArrayList(Iterator<? extends Double> i) {
        this();
        while (i.hasNext()) {
            add(((Double) i.next()).doubleValue());
        }
    }

    public DoubleArrayList(DoubleIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextDouble());
        }
    }

    public double[] elements() {
        return this.f1665a;
    }

    public static DoubleArrayList wrap(double[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        DoubleArrayList l = new DoubleArrayList(a, true);
        l.size = length;
        return l;
    }

    public static DoubleArrayList wrap(double[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static DoubleArrayList m923of() {
        return new DoubleArrayList();
    }

    /* renamed from: of */
    public static DoubleArrayList m922of(double... init) {
        return wrap(init);
    }

    public static DoubleArrayList toList(DoubleStream stream) {
        return (DoubleArrayList) stream.collect(DoubleArrayList::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static DoubleArrayList toListWithExpectedSize(DoubleStream stream, int expectedSize) {
        if (expectedSize <= 10) {
            return toList(stream);
        }
        return (DoubleArrayList) stream.collect(new DoubleCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 10 ? new DoubleArrayList() : new DoubleArrayList(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f1665a.length) {
            return;
        }
        if (this.f1665a != DoubleArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            this.f1665a = DoubleArrays.ensureCapacity(this.f1665a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1665a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f1665a.length) {
            if (this.f1665a != DoubleArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f1665a.length) + ((long) (this.f1665a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f1665a = DoubleArrays.forceCapacity(this.f1665a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1665a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void add(int index, double k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f1665a, index, this.f1665a, index + 1, this.size - index);
        }
        this.f1665a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f1665a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        grow(this.size + 1);
        double[] dArr = this.f1665a;
        int i = this.size;
        this.size = i + 1;
        dArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f1665a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public double getDouble(int index) {
        if (index < this.size) {
            return this.f1665a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public int indexOf(double k) {
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(this.f1665a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public int lastIndexOf(double k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(this.f1665a[i]));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public double removeDouble(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        double old = this.f1665a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f1665a, index + 1, this.f1665a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= this.f1665a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean rem(double k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeDouble(index);
        if ($assertionsDisabled || this.size <= this.f1665a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public double set(int index, double k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        double old = this.f1665a[index];
        this.f1665a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f1665a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void size(int size) {
        if (size > this.f1665a.length) {
            this.f1665a = DoubleArrays.forceCapacity(this.f1665a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f1665a, this.size, size, 0.0d);
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
        if (n < this.f1665a.length && this.size != this.f1665a.length) {
            double[] t = new double[Math.max(n, this.size)];
            System.arraycopy(this.f1665a, 0, t, 0, this.size);
            this.f1665a = t;
            if (!$assertionsDisabled && this.size > this.f1665a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArrayList$SubList.class */
    public class SubList extends AbstractDoubleList.DoubleRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(int from, int to) {
            super(DoubleArrayList.this, from, to);
        }

        private double[] getParentArray() {
            return DoubleArrayList.this.f1665a;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.DoubleSubList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double getDouble(int i) {
            ensureRestrictedIndex(i);
            return DoubleArrayList.this.f1665a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends DoubleIterators.AbstractIndexBasedListIterator {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final double get(int i) {
                return DoubleArrayList.this.f1665a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator
            protected final void add(int i, double k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator
            protected final void set(int i, double k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.removeDouble(i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f1541to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
            public double nextDouble() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                double[] dArr = DoubleArrayList.this.f1665a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return dArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
            public double previousDouble() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                double[] dArr = DoubleArrayList.this.f1665a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return dArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterators.AbstractIndexBasedIterator, java.util.PrimitiveIterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = SubList.this.f1541to - SubList.this.from;
                while (this.pos < max) {
                    double[] dArr = DoubleArrayList.this.f1665a;
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept(dArr[i + i2]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.DoubleSubList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends DoubleSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f1541to;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            protected final double get(int i) {
                return DoubleArrayList.this.f1665a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public boolean tryAdvance(DoubleConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                double[] dArr = DoubleArrayList.this.f1665a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(dArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    double[] dArr = DoubleArrayList.this.f1665a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList.DoubleSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(double[] otherA, int otherAFrom, int otherATo) {
            if (DoubleArrayList.this.f1665a == otherA && this.from == otherAFrom && this.f1541to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1541to) {
                pos++;
                otherPos++;
                if (DoubleArrayList.this.f1665a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof DoubleArrayList) {
                DoubleArrayList other = (DoubleArrayList) o;
                return contentsEquals(other.f1665a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f1541to);
            }
        }

        int contentsCompareTo(double[] otherA, int otherAFrom, int otherATo) {
            if (DoubleArrayList.this.f1665a == otherA && this.from == otherAFrom && this.f1541to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1541to && i < otherATo) {
                int r = Double.compare(DoubleArrayList.this.f1665a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1541to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList
        public int compareTo(List<? extends Double> l) {
            if (l instanceof DoubleArrayList) {
                DoubleArrayList other = (DoubleArrayList) l;
                return contentsCompareTo(other.f1665a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f1541to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
    public List<Double> subList(int from, int to) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void getElements(int from, double[] a, int offset, int length) {
        DoubleArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1665a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f1665a, to, this.f1665a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void addElements(int index, double[] a, int offset, int length) {
        ensureIndex(index);
        DoubleArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f1665a, index, this.f1665a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f1665a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void setElements(int index, double[] a, int offset, int length) {
        ensureIndex(index);
        DoubleArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f1665a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public void forEach(DoubleConsumer action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.f1665a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public boolean addAll(int index, DoubleCollection c) {
        if (c instanceof DoubleList) {
            return addAll(index, (DoubleList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1665a, index, this.f1665a, index + n, this.size - index);
        DoubleIterator i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f1665a[index] = i.nextDouble();
        }
        if ($assertionsDisabled || this.size <= this.f1665a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public boolean addAll(int index, DoubleList l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1665a, index, this.f1665a, index + n, this.size - index);
        l.getElements(0, this.f1665a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f1665a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean removeAll(DoubleCollection c) {
        double[] a = this.f1665a;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toArray(double[] a) {
        if (a == null || a.length < this.size) {
            a = Arrays.copyOf(a, this.size);
        }
        System.arraycopy(this.f1665a, 0, a, 0, this.size);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
    public ListIterator<Double> listIterator(final int index) {
        ensureIndex(index);
        return new DoubleListIterator() { // from class: it.unimi.dsi.fastutil.doubles.DoubleArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < DoubleArrayList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
            public double nextDouble() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                double[] dArr = DoubleArrayList.this.f1665a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return dArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
            public double previousDouble() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                double[] dArr = DoubleArrayList.this.f1665a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
                return dArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
            public void add(double k) {
                DoubleArrayList doubleArrayList = DoubleArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                doubleArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
            public void set(double k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                DoubleArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                DoubleArrayList.this.removeDouble(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                while (this.pos < DoubleArrayList.this.size) {
                    double[] dArr = DoubleArrayList.this.f1665a;
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept(dArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = DoubleArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = DoubleArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = DoubleArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArrayList$Spliterator.class */
    public final class Spliterator implements DoubleSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !DoubleArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(DoubleArrayList doubleArrayList) {
            this(0, doubleArrayList.size, false);
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
            return this.hasSplit ? this.max : DoubleArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        @Override // java.util.Spliterator.OfDouble
        public boolean tryAdvance(DoubleConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            double[] dArr = DoubleArrayList.this.f1665a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(dArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(DoubleArrayList.this.f1665a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public DoubleSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void sort(DoubleComparator comp) {
        if (comp == null) {
            DoubleArrays.stableSort(this.f1665a, 0, this.size);
        } else {
            DoubleArrays.stableSort(this.f1665a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void unstableSort(DoubleComparator comp) {
        if (comp == null) {
            DoubleArrays.unstableSort(this.f1665a, 0, this.size);
        } else {
            DoubleArrays.unstableSort(this.f1665a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public DoubleArrayList clone() {
        DoubleArrayList cloned;
        if (getClass() == DoubleArrayList.class) {
            cloned = new DoubleArrayList(copyArraySafe(this.f1665a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (DoubleArrayList) clone();
                cloned.f1665a = copyArraySafe(this.f1665a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(DoubleArrayList l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        double[] a1 = this.f1665a;
        double[] a2 = l.f1665a;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof DoubleArrayList) {
            return equals((DoubleArrayList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(DoubleArrayList l) {
        int s1 = size();
        int s2 = l.size();
        double[] a1 = this.f1665a;
        double[] a2 = l.f1665a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Double.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList
    public int compareTo(List<? extends Double> l) {
        if (l instanceof DoubleArrayList) {
            return compareTo((DoubleArrayList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List<? extends Double>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeDouble(this.f1665a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1665a = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1665a[i] = s.readDouble();
        }
    }
}
