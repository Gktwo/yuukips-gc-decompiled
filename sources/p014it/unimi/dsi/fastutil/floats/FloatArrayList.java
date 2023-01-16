package p014it.unimi.dsi.fastutil.floats;

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
import p014it.unimi.dsi.fastutil.floats.AbstractFloatList;
import p014it.unimi.dsi.fastutil.floats.FloatIterators;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrayList.class */
public class FloatArrayList extends AbstractFloatList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient float[] f1922a;
    protected int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !FloatArrayList.class.desiredAssertionStatus();
    }

    private static final float[] copyArraySafe(float[] a, int length) {
        return length == 0 ? FloatArrays.EMPTY_ARRAY : Arrays.copyOf(a, length);
    }

    private static final float[] copyArrayFromSafe(FloatArrayList l) {
        return copyArraySafe(l.f1922a, l.size);
    }

    protected FloatArrayList(float[] a, boolean wrapped) {
        this.f1922a = a;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f1922a = FloatArrays.EMPTY_ARRAY;
        } else {
            this.f1922a = new float[capacity];
        }
    }

    public FloatArrayList(int capacity) {
        initArrayFromCapacity(capacity);
    }

    public FloatArrayList() {
        this.f1922a = FloatArrays.DEFAULT_EMPTY_ARRAY;
    }

    public FloatArrayList(Collection<? extends Float> c) {
        if (c instanceof FloatArrayList) {
            this.f1922a = copyArrayFromSafe((FloatArrayList) c);
            this.size = this.f1922a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof FloatList) {
            float[] fArr = this.f1922a;
            int size = c.size();
            this.size = size;
            ((FloatList) c).getElements(0, fArr, 0, size);
            return;
        }
        this.size = FloatIterators.unwrap(FloatIterators.asFloatIterator(c.iterator()), this.f1922a);
    }

    public FloatArrayList(FloatCollection c) {
        if (c instanceof FloatArrayList) {
            this.f1922a = copyArrayFromSafe((FloatArrayList) c);
            this.size = this.f1922a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof FloatList) {
            float[] fArr = this.f1922a;
            int size = c.size();
            this.size = size;
            ((FloatList) c).getElements(0, fArr, 0, size);
            return;
        }
        this.size = FloatIterators.unwrap(c.iterator(), this.f1922a);
    }

    public FloatArrayList(FloatList l) {
        if (l instanceof FloatArrayList) {
            this.f1922a = copyArrayFromSafe((FloatArrayList) l);
            this.size = this.f1922a.length;
            return;
        }
        initArrayFromCapacity(l.size());
        float[] fArr = this.f1922a;
        int size = l.size();
        this.size = size;
        l.getElements(0, fArr, 0, size);
    }

    public FloatArrayList(float[] a) {
        this(a, 0, a.length);
    }

    public FloatArrayList(float[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f1922a, 0, length);
        this.size = length;
    }

    public FloatArrayList(Iterator<? extends Float> i) {
        this();
        while (i.hasNext()) {
            add(((Float) i.next()).floatValue());
        }
    }

    public FloatArrayList(FloatIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextFloat());
        }
    }

    public float[] elements() {
        return this.f1922a;
    }

    public static FloatArrayList wrap(float[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        FloatArrayList l = new FloatArrayList(a, true);
        l.size = length;
        return l;
    }

    public static FloatArrayList wrap(float[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static FloatArrayList m839of() {
        return new FloatArrayList();
    }

    /* renamed from: of */
    public static FloatArrayList m838of(float... init) {
        return wrap(init);
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f1922a.length) {
            return;
        }
        if (this.f1922a != FloatArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            this.f1922a = FloatArrays.ensureCapacity(this.f1922a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1922a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f1922a.length) {
            if (this.f1922a != FloatArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f1922a.length) + ((long) (this.f1922a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f1922a = FloatArrays.forceCapacity(this.f1922a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1922a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public void add(int index, float k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f1922a, index, this.f1922a, index + 1, this.size - index);
        }
        this.f1922a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f1922a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean add(float k) {
        grow(this.size + 1);
        float[] fArr = this.f1922a;
        int i = this.size;
        this.size = i + 1;
        fArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f1922a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public float getFloat(int index) {
        if (index < this.size) {
            return this.f1922a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public int indexOf(float k) {
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(k) == Float.floatToIntBits(this.f1922a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public int lastIndexOf(float k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(this.f1922a[i]));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public float removeFloat(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        float old = this.f1922a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f1922a, index + 1, this.f1922a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= this.f1922a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean rem(float k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeFloat(index);
        if ($assertionsDisabled || this.size <= this.f1922a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public float set(int index, float k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        float old = this.f1922a[index];
        this.f1922a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f1922a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public void size(int size) {
        if (size > this.f1922a.length) {
            this.f1922a = FloatArrays.forceCapacity(this.f1922a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f1922a, this.size, size, 0.0f);
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
        if (n < this.f1922a.length && this.size != this.f1922a.length) {
            float[] t = new float[Math.max(n, this.size)];
            System.arraycopy(this.f1922a, 0, t, 0, this.size);
            this.f1922a = t;
            if (!$assertionsDisabled && this.size > this.f1922a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrayList$SubList.class */
    public class SubList extends AbstractFloatList.FloatRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(int from, int to) {
            super(FloatArrayList.this, from, to);
        }

        private float[] getParentArray() {
            return FloatArrayList.this.f1922a;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList.FloatSubList, p014it.unimi.dsi.fastutil.floats.FloatList
        public float getFloat(int i) {
            ensureRestrictedIndex(i);
            return FloatArrayList.this.f1922a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends FloatIterators.AbstractIndexBasedListIterator {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final float get(int i) {
                return FloatArrayList.this.f1922a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator
            protected final void add(int i, float k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator
            protected final void set(int i, float k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.removeFloat(i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f1798to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                float[] fArr = FloatArrayList.this.f1922a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return fArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            public float previousFloat() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                float[] fArr = FloatArrayList.this.f1922a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return fArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator
            public void forEachRemaining(FloatConsumer action) {
                int max = SubList.this.f1798to - SubList.this.from;
                while (this.pos < max) {
                    float[] fArr = FloatArrayList.this.f1922a;
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept(fArr[i + i2]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList.FloatSubList, p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends FloatSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f1798to;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            protected final float get(int i) {
                return FloatArrayList.this.f1922a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(FloatConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                float[] fArr = FloatArrayList.this.f1922a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(fArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    float[] fArr = FloatArrayList.this.f1922a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList.FloatSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(float[] otherA, int otherAFrom, int otherATo) {
            if (FloatArrayList.this.f1922a == otherA && this.from == otherAFrom && this.f1798to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1798to) {
                pos++;
                otherPos++;
                if (FloatArrayList.this.f1922a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof FloatArrayList) {
                FloatArrayList other = (FloatArrayList) o;
                return contentsEquals(other.f1922a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f1798to);
            }
        }

        int contentsCompareTo(float[] otherA, int otherAFrom, int otherATo) {
            if (FloatArrayList.this.f1922a == otherA && this.from == otherAFrom && this.f1798to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1798to && i < otherATo) {
                int r = Float.compare(FloatArrayList.this.f1922a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1798to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList
        public int compareTo(List<? extends Float> l) {
            if (l instanceof FloatArrayList) {
                FloatArrayList other = (FloatArrayList) l;
                return contentsCompareTo(other.f1922a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f1798to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
    public List<Float> subList(int from, int to) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public void getElements(int from, float[] a, int offset, int length) {
        FloatArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1922a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f1922a, to, this.f1922a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public void addElements(int index, float[] a, int offset, int length) {
        ensureIndex(index);
        FloatArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f1922a, index, this.f1922a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f1922a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public void setElements(int index, float[] a, int offset, int length) {
        ensureIndex(index);
        FloatArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f1922a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public void forEach(FloatConsumer action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.f1922a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public boolean addAll(int index, FloatCollection c) {
        if (c instanceof FloatList) {
            return addAll(index, (FloatList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1922a, index, this.f1922a, index + n, this.size - index);
        FloatIterator i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f1922a[index] = i.nextFloat();
        }
        if ($assertionsDisabled || this.size <= this.f1922a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public boolean addAll(int index, FloatList l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1922a, index, this.f1922a, index + n, this.size - index);
        l.getElements(0, this.f1922a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f1922a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean removeAll(FloatCollection c) {
        float[] a = this.f1922a;
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toArray(float[] a) {
        if (a == null || a.length < this.size) {
            a = Arrays.copyOf(a, this.size);
        }
        System.arraycopy(this.f1922a, 0, a, 0, this.size);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
    public ListIterator<Float> listIterator(final int index) {
        ensureIndex(index);
        return new FloatListIterator() { // from class: it.unimi.dsi.fastutil.floats.FloatArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < FloatArrayList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                float[] fArr = FloatArrayList.this.f1922a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return fArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            public float previousFloat() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                float[] fArr = FloatArrayList.this.f1922a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
                return fArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
            public void add(float k) {
                FloatArrayList floatArrayList = FloatArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                floatArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
            public void set(float k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                FloatArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                FloatArrayList.this.removeFloat(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public void forEachRemaining(FloatConsumer action) {
                while (this.pos < FloatArrayList.this.size) {
                    float[] fArr = FloatArrayList.this.f1922a;
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept(fArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = FloatArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = FloatArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = FloatArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrayList$Spliterator.class */
    public final class Spliterator implements FloatSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !FloatArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(FloatArrayList floatArrayList) {
            this(0, floatArrayList.size, false);
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
            return this.hasSplit ? this.max : FloatArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(FloatConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            float[] fArr = FloatArrayList.this.f1922a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(fArr[i]);
            return true;
        }

        public void forEachRemaining(FloatConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(FloatArrayList.this.f1922a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public void sort(FloatComparator comp) {
        if (comp == null) {
            FloatArrays.stableSort(this.f1922a, 0, this.size);
        } else {
            FloatArrays.stableSort(this.f1922a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public void unstableSort(FloatComparator comp) {
        if (comp == null) {
            FloatArrays.unstableSort(this.f1922a, 0, this.size);
        } else {
            FloatArrays.unstableSort(this.f1922a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public FloatArrayList clone() {
        FloatArrayList cloned;
        if (getClass() == FloatArrayList.class) {
            cloned = new FloatArrayList(copyArraySafe(this.f1922a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (FloatArrayList) clone();
                cloned.f1922a = copyArraySafe(this.f1922a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(FloatArrayList l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        float[] a1 = this.f1922a;
        float[] a2 = l.f1922a;
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof FloatArrayList) {
            return equals((FloatArrayList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(FloatArrayList l) {
        int s1 = size();
        int s2 = l.size();
        float[] a1 = this.f1922a;
        float[] a2 = l.f1922a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Float.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList
    public int compareTo(List<? extends Float> l) {
        if (l instanceof FloatArrayList) {
            return compareTo((FloatArrayList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List<? extends Float>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeFloat(this.f1922a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1922a = new float[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1922a[i] = s.readFloat();
        }
    }
}
