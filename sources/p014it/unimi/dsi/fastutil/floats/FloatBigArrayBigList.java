package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList;
import p014it.unimi.dsi.fastutil.floats.FloatBigListIterators;
import p014it.unimi.dsi.fastutil.floats.FloatBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrayBigList.class */
public class FloatBigArrayBigList extends AbstractFloatBigList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient float[][] f1898a;
    protected long size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !FloatBigArrayBigList.class.desiredAssertionStatus();
    }

    protected FloatBigArrayBigList(float[][] a, boolean dummy) {
        this.f1898a = a;
    }

    public FloatBigArrayBigList(long capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f1898a = FloatBigArrays.EMPTY_BIG_ARRAY;
        } else {
            this.f1898a = FloatBigArrays.newBigArray(capacity);
        }
    }

    public FloatBigArrayBigList() {
        this.f1898a = FloatBigArrays.DEFAULT_EMPTY_BIG_ARRAY;
    }

    public FloatBigArrayBigList(FloatCollection c) {
        this(Size64.sizeOf(c));
        if (c instanceof FloatBigList) {
            float[][] fArr = this.f1898a;
            long sizeOf = Size64.sizeOf(c);
            this.size = sizeOf;
            ((FloatBigList) c).getElements(0, fArr, 0, sizeOf);
            return;
        }
        FloatIterator i = c.iterator();
        while (i.hasNext()) {
            add(i.nextFloat());
        }
    }

    public FloatBigArrayBigList(FloatBigList l) {
        this(l.size64());
        float[][] fArr = this.f1898a;
        long size64 = l.size64();
        this.size = size64;
        l.getElements(0, fArr, 0, size64);
    }

    public FloatBigArrayBigList(float[][] a) {
        this(a, 0, BigArrays.length(a));
    }

    public FloatBigArrayBigList(float[][] a, long offset, long length) {
        this(length);
        BigArrays.copy(a, offset, this.f1898a, 0L, length);
        this.size = length;
    }

    public FloatBigArrayBigList(Iterator<? extends Float> i) {
        this();
        while (i.hasNext()) {
            add(((Float) i.next()).floatValue());
        }
    }

    public FloatBigArrayBigList(FloatIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextFloat());
        }
    }

    public float[][] elements() {
        return this.f1898a;
    }

    public static FloatBigArrayBigList wrap(float[][] a, long length) {
        if (length > BigArrays.length(a)) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + BigArrays.length(a) + ")");
        }
        FloatBigArrayBigList l = new FloatBigArrayBigList(a, false);
        l.size = length;
        return l;
    }

    public static FloatBigArrayBigList wrap(float[][] a) {
        return wrap(a, BigArrays.length(a));
    }

    /* renamed from: of */
    public static FloatBigArrayBigList m834of() {
        return new FloatBigArrayBigList();
    }

    /* renamed from: of */
    public static FloatBigArrayBigList m833of(float... init) {
        return wrap(BigArrays.wrap(init));
    }

    public void ensureCapacity(long capacity) {
        if (capacity > BigArrays.length(this.f1898a) && this.f1898a != FloatBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
            this.f1898a = BigArrays.forceCapacity(this.f1898a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f1898a)) {
                throw new AssertionError();
            }
        }
    }

    private void grow(long capacity) {
        long oldLength = BigArrays.length(this.f1898a);
        if (capacity > oldLength) {
            if (this.f1898a != FloatBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
                capacity = Math.max(oldLength + (oldLength >> 1), capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f1898a = BigArrays.forceCapacity(this.f1898a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f1898a)) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public void add(long index, float k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            BigArrays.copy(this.f1898a, index, this.f1898a, index + 1, this.size - index);
        }
        BigArrays.set(this.f1898a, index, k);
        this.size++;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f1898a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean add(float k) {
        grow(this.size + 1);
        float[][] fArr = this.f1898a;
        long j = this.size;
        this.size = j + 1;
        BigArrays.set(fArr, j, k);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1898a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
    public float getFloat(long index) {
        if (index < this.size) {
            return BigArrays.get(this.f1898a, index);
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public long indexOf(float k) {
        for (long i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(k) == Float.floatToIntBits(BigArrays.get(this.f1898a, i))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(float r8) {
        /*
            r7 = this;
            r0 = r7
            long r0 = r0.size
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0023
            r0 = r8
            int r0 = java.lang.Float.floatToIntBits(r0)
            r1 = r7
            float[][] r1 = r1.f1898a
            r2 = r9
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r1 = java.lang.Float.floatToIntBits(r1)
            if (r0 != r1) goto L_0x0005
            r0 = r9
            return r0
        L_0x0023:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.lastIndexOf(float):long");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public float removeFloat(long index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        float old = BigArrays.get(this.f1898a, index);
        this.size--;
        if (index != this.size) {
            BigArrays.copy(this.f1898a, index + 1, this.f1898a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1898a)) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean rem(float k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeFloat(index);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1898a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public float set(long index, float k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        float old = BigArrays.get(this.f1898a, index);
        BigArrays.set(this.f1898a, index, k);
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean removeAll(FloatCollection c) {
        float[] s = null;
        float[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f1898a[ss];
            }
            if (!c.contains(s[sd])) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f1898a[ds];
                    dd = 0;
                }
                dd++;
                d[dd] = s[sd];
            }
            sd++;
        }
        long j = BigArrays.index(ds, dd);
        boolean modified = this.size != j;
        this.size = j;
        return modified;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        float[] s = null;
        float[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f1898a[ss];
            }
            if (!c.contains(Float.valueOf(s[sd]))) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f1898a[ds];
                    dd = 0;
                }
                dd++;
                d[dd] = s[sd];
            }
            sd++;
        }
        long j = BigArrays.index(ds, dd);
        boolean modified = this.size != j;
        this.size = j;
        return modified;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public boolean addAll(long index, FloatCollection c) {
        if (c instanceof FloatList) {
            return addAll(index, (FloatList) c);
        }
        if (c instanceof FloatBigList) {
            return addAll(index, (FloatBigList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f1898a, index, this.f1898a, index + ((long) n), this.size - index);
        FloatIterator i = c.iterator();
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1898a)) {
            while (true) {
                n--;
                if (n == 0) {
                    return true;
                }
                index++;
                BigArrays.set(this.f1898a, index, i.nextFloat());
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
    public boolean addAll(long index, FloatBigList list) {
        ensureIndex(index);
        long n = list.size64();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        BigArrays.copy(this.f1898a, index, this.f1898a, index + n, this.size - index);
        list.getElements(0, this.f1898a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1898a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
    public boolean addAll(long index, FloatList list) {
        ensureIndex(index);
        int n = list.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f1898a, index, this.f1898a, index + ((long) n), this.size - index);
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1898a)) {
            int segment = BigArrays.segment(index);
            int displ = BigArrays.displacement(index);
            int pos = 0;
            while (n > 0) {
                int l = Math.min(this.f1898a[segment].length - displ, n);
                list.getElements(pos, this.f1898a[segment], displ, l);
                int i = displ + l;
                displ = i;
                if (i == 134217728) {
                    displ = 0;
                    segment++;
                }
                pos += l;
                n -= l;
            }
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f1898a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.BigList
    public void size(long size) {
        if (size > BigArrays.length(this.f1898a)) {
            this.f1898a = BigArrays.forceCapacity(this.f1898a, size, this.size);
        }
        if (size > this.size) {
            BigArrays.fill(this.f1898a, this.size, size, 0.0f);
        }
        this.size = size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.Stack, java.util.List
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void trim() {
        trim(0);
    }

    public void trim(long n) {
        long arrayLength = BigArrays.length(this.f1898a);
        if (n < arrayLength && this.size != arrayLength) {
            this.f1898a = BigArrays.trim(this.f1898a, Math.max(n, this.size));
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f1898a)) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrayBigList$SubList.class */
    public class SubList extends AbstractFloatBigList.FloatRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(long from, long to) {
            super(FloatBigArrayBigList.this, from, to);
        }

        private float[][] getParentArray() {
            return FloatBigArrayBigList.this.f1898a;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList.FloatSubList, p014it.unimi.dsi.fastutil.floats.FloatBigList
        public float getFloat(long i) {
            ensureRestrictedIndex(i);
            return BigArrays.get(FloatBigArrayBigList.this.f1898a, i + this.from);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrayBigList$SubList$SubListIterator.class */
        public final class SubListIterator extends FloatBigListIterators.AbstractIndexBasedBigListIterator {
            SubListIterator(long index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigIterator
            protected final float get(long i) {
                return BigArrays.get(FloatBigArrayBigList.this.f1898a, SubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, float k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, float k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                SubList.this.removeFloat(i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return SubList.this.f1759to - SubList.this.from;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                float[][] fArr = FloatBigArrayBigList.this.f1898a;
                long j = SubList.this.from;
                long j2 = this.pos;
                this.pos = j2 + 1;
                this.lastReturned = j2;
                return BigArrays.get((float[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            public float previousFloat() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                float[][] fArr = FloatBigArrayBigList.this.f1898a;
                long j = SubList.this.from;
                long j2 = this.pos - 1;
                this.pos = j2;
                this.lastReturned = j2;
                return BigArrays.get((float[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v7, types: [it.unimi.dsi.fastutil.floats.FloatConsumer, float[][]] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterators.AbstractIndexBasedBigIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(p014it.unimi.dsi.fastutil.floats.FloatConsumer r14) {
                /*
                    r13 = this;
                    r0 = r13
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.SubList.this
                    long r0 = r0.f1759to
                    r1 = r13
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.SubList.this
                    long r1 = r1.from
                    long r0 = r0 - r1
                    r15 = r0
                L_0x0010:
                    r0 = r13
                    long r0 = r0.pos
                    r1 = r15
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0047
                    r0 = r14
                    r1 = r13
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.SubList.this
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r1 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    float[][] r1 = r1.f1898a
                    r2 = r13
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList r2 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.SubList.this
                    long r2 = r2.from
                    r3 = r13
                    r4 = r13
                    r5 = r4
                    long r5 = r5.pos
                    r6 = r5; r5 = r4; r4 = r6; 
                    r7 = 1
                    long r6 = r6 + r7
                    r5.pos = r6
                    r5 = r3; r6 = r4; r4 = r2; r3 = r6; r2 = r5; 
                    r5.lastReturned = r6
                    long r3 = r3 + r4
                    float r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0010
                L_0x0047:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.SubList.SubListIterator.forEachRemaining(it.unimi.dsi.fastutil.floats.FloatConsumer):void");
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList.FloatSubList, p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Float> listIterator(long index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrayBigList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends FloatBigSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(long pos, long maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final long getMaxPosFromBackingStore() {
                return SubList.this.f1759to;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigSpliterators.AbstractIndexBasedSpliterator
            protected final float get(long i) {
                return BigArrays.get(FloatBigArrayBigList.this.f1898a, i);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(long pos, long maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigSpliterators.AbstractIndexBasedSpliterator
            protected final long computeSplitPoint() {
                return BigArrays.nearestSegmentStart(computeSplitPoint(), this.pos + 1, getMaxPos() - 1);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(FloatConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                float[][] fArr = FloatBigArrayBigList.this.f1898a;
                long j = this.pos;
                this.pos = j + 1;
                action.accept(BigArrays.get(fArr, j));
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                long max = getMaxPos();
                while (this.pos < max) {
                    float[][] fArr = FloatBigArrayBigList.this.f1898a;
                    long j = this.pos;
                    this.pos = j + 1;
                    action.accept(BigArrays.get(fArr, j));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList.FloatSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new SubListSpliterator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        /* JADX WARN: Type inference failed for: r0v10, types: [long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        boolean contentsEquals(float[][] r8, long r9, long r11) {
            /*
                r7 = this;
                r0 = r7
                it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                float[][] r0 = r0.f1898a
                r1 = r8
                if (r0 != r1) goto L_0x0020
                r0 = r7
                long r0 = r0.from
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r7
                long r0 = r0.f1759to
                r1 = r11
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = 1
                return r0
            L_0x0020:
                r0 = r11
                r1 = r9
                long r0 = r0 - r1
                r1 = r7
                long r1 = r1.size64()
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x002e
                r0 = 0
                return r0
            L_0x002e:
                r0 = r7
                long r0 = r0.f1759to
                r13 = r0
                r0 = r11
                r15 = r0
            L_0x0038:
                r0 = r13
                r1 = 1
                long r0 = r0 - r1
                r1 = r0; r1 = r0; 
                r13 = r1
                r1 = r7
                long r1 = r1.from
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L_0x0064
                r0 = r7
                it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                float[][] r0 = r0.f1898a
                r1 = r13
                float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r1 = r8
                r2 = r15
                r3 = 1
                long r2 = r2 - r3
                r3 = r2; r3 = r0; 
                r15 = r3
                float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0038
                r0 = 0
                return r0
            L_0x0064:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.SubList.contentsEquals(float[][], long, long):boolean");
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof BigList)) {
                return false;
            }
            if (o instanceof FloatBigArrayBigList) {
                FloatBigArrayBigList other = (FloatBigArrayBigList) o;
                return contentsEquals(other.f1898a, 0, other.size64());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f1759to);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [long] */
        /* JADX WARN: Type inference failed for: r0v4, types: [long] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [long] */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r0v38 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        int contentsCompareTo(float[][] r6, long r7, long r9) {
            /*
                r5 = this;
                r0 = r5
                it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                float[][] r0 = r0.f1898a
                r1 = r6
                if (r0 != r1) goto L_0x0020
                r0 = r5
                long r0 = r0.from
                r1 = r7
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r5
                long r0 = r0.f1759to
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = 0
                return r0
            L_0x0020:
                r0 = r5
                long r0 = r0.from
                r14 = r0
                r0 = r7
                r16 = r0
            L_0x0029:
                r0 = r14
                r1 = r5
                long r1 = r1.f1759to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r14
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r5
                it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                float[][] r0 = r0.f1898a
                r1 = r14
                float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r11 = r0
                r0 = r6
                r1 = r16
                float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r12 = r0
                r0 = r11
                r1 = r12
                int r0 = java.lang.Float.compare(r0, r1)
                r1 = r0
                r13 = r1
                if (r0 == 0) goto L_0x0061
                r0 = r13
                return r0
            L_0x0061:
                r0 = r14
                r1 = 1
                long r0 = r0 + r1
                r14 = r0
                r0 = r16
                r1 = 1
                long r0 = r0 + r1
                r16 = r0
                goto L_0x0029
            L_0x0070:
                r0 = r14
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x007c
                r0 = -1
                goto L_0x008b
            L_0x007c:
                r0 = r14
                r1 = r5
                long r1 = r1.f1759to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x008a
                r0 = 1
                goto L_0x008b
            L_0x008a:
                r0 = 0
            L_0x008b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.SubList.contentsCompareTo(float[][], long, long):int");
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList
        public int compareTo(BigList<? extends Float> l) {
            if (l instanceof FloatBigArrayBigList) {
                FloatBigArrayBigList other = (FloatBigArrayBigList) l;
                return contentsCompareTo(other.f1898a, 0, other.size64());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f1759to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Float> subList(long from, long to) {
        if (from == 0 && to == size64()) {
            return this;
        }
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return new SubList(from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public void getElements(long from, float[][] a, long offset, long length) {
        BigArrays.copy(this.f1898a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
    public void getElements(long from, float[] a, int offset, int length) {
        BigArrays.copyFromBig(this.f1898a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public void removeElements(long from, long to) {
        BigArrays.ensureFromTo(this.size, from, to);
        BigArrays.copy(this.f1898a, to, this.f1898a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public void addElements(long index, float[][] a, long offset, long length) {
        ensureIndex(index);
        BigArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        BigArrays.copy(this.f1898a, index, this.f1898a, index + length, this.size - index);
        BigArrays.copy(a, offset, this.f1898a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public void setElements(long index, float[][] a, long offset, long length) {
        BigArrays.copy(a, offset, this.f1898a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public void forEach(FloatConsumer action) {
        for (long i = 0; i < this.size; i++) {
            action.accept(BigArrays.get(this.f1898a, i));
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Float> listIterator(final long index) {
        ensureIndex(index);
        return new FloatBigListIterator() { // from class: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.1
            long pos;
            long last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.pos < FloatBigArrayBigList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, float[][]] */
            /* JADX WARN: Type inference failed for: r3v1, types: [long, float[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public float nextFloat() {
                /*
                    r10 = this;
                    r0 = r10
                    boolean r0 = r0.hasNext()
                    if (r0 != 0) goto L_0x000f
                    java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
                    r1 = r0
                    r1.<init>()
                    throw r0
                L_0x000f:
                    r0 = r10
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    float[][] r0 = r0.f1898a
                    r1 = r10
                    r2 = r10
                    r3 = r2
                    long r3 = r3.pos
                    r4 = r3; r3 = r2; r2 = r4; 
                    r5 = 1
                    long r4 = r4 + r5
                    r3.pos = r4
                    r3 = r1; r4 = r2; r2 = r0; r1 = r4; r0 = r3; 
                    r3.last = r4
                    float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.C41151.nextFloat():float");
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, float[][]] */
            /* JADX WARN: Type inference failed for: r3v2, types: [long, float[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public float previousFloat() {
                /*
                    r8 = this;
                    r0 = r8
                    boolean r0 = r0.hasPrevious()
                    if (r0 != 0) goto L_0x000f
                    java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
                    r1 = r0
                    r1.<init>()
                    throw r0
                L_0x000f:
                    r0 = r8
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    float[][] r0 = r0.f1898a
                    r1 = r8
                    r2 = r8
                    r3 = r2
                    long r3 = r3.pos
                    r4 = 1
                    long r3 = r3 - r4
                    r4 = r3; r3 = r2; r2 = r4; 
                    r3.pos = r4
                    r3 = r1; r4 = r2; r2 = r0; r1 = r4; r0 = r3; 
                    r3.last = r4
                    float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.C41151.previousFloat():float");
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.pos;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterator
            public void add(float k) {
                FloatBigArrayBigList floatBigArrayBigList = FloatBigArrayBigList.this;
                long j = this.pos;
                this.pos = j + 1;
                floatBigArrayBigList.add(j, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterator
            public void set(float k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                FloatBigArrayBigList.this.set(this.last, k);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                FloatBigArrayBigList.this.removeFloat(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$1 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v5, types: [long, float[][]] */
            /* JADX WARN: Type inference failed for: r4v1, types: [long, float[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(p014it.unimi.dsi.fastutil.floats.FloatConsumer r12) {
                /*
                    r11 = this;
                L_0x0000:
                    r0 = r11
                    long r0 = r0.pos
                    r1 = r11
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r1 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    long r1 = r1.size
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0032
                    r0 = r12
                    r1 = r11
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r1 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    float[][] r1 = r1.f1898a
                    r2 = r11
                    r3 = r11
                    r4 = r3
                    long r4 = r4.pos
                    r5 = r4; r4 = r3; r3 = r5; 
                    r6 = 1
                    long r5 = r5 + r6
                    r4.pos = r5
                    r4 = r2; r5 = r3; r3 = r1; r2 = r5; r1 = r4; 
                    r4.last = r5
                    float r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0000
                L_0x0032:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.C41151.forEachRemaining(it.unimi.dsi.fastutil.floats.FloatConsumer):void");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public long back(long r7) {
                /*
                    r6 = this;
                    r0 = r7
                    r1 = 0
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0021
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    r1 = r0
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r3 = r2
                    r3.<init>()
                    java.lang.String r3 = "Argument must be nonnegative: "
                    java.lang.StringBuilder r2 = r2.append(r3)
                    r3 = r7
                    java.lang.StringBuilder r2 = r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r1.<init>(r2)
                    throw r0
                L_0x0021:
                    r0 = r6
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    long r0 = r0.size
                    r1 = r6
                    long r1 = r1.pos
                    long r0 = r0 - r1
                    r9 = r0
                    r0 = r7
                    r1 = r9
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0041
                    r0 = r6
                    r1 = r0
                    long r1 = r1.pos
                    r2 = r7
                    long r1 = r1 - r2
                    r0.pos = r1
                    goto L_0x0048
                L_0x0041:
                    r0 = r9
                    r7 = r0
                    r0 = r6
                    r1 = 0
                    r0.pos = r1
                L_0x0048:
                    r0 = r6
                    r1 = r6
                    long r1 = r1.pos
                    r0.last = r1
                    r0 = r7
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.C41151.back(long):long");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatBigListIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public long skip(long r7) {
                /*
                    r6 = this;
                    r0 = r7
                    r1 = 0
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0021
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    r1 = r0
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r3 = r2
                    r3.<init>()
                    java.lang.String r3 = "Argument must be nonnegative: "
                    java.lang.StringBuilder r2 = r2.append(r3)
                    r3 = r7
                    java.lang.StringBuilder r2 = r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r1.<init>(r2)
                    throw r0
                L_0x0021:
                    r0 = r6
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    long r0 = r0.size
                    r1 = r6
                    long r1 = r1.pos
                    long r0 = r0 - r1
                    r9 = r0
                    r0 = r7
                    r1 = r9
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0041
                    r0 = r6
                    r1 = r0
                    long r1 = r1.pos
                    r2 = r7
                    long r1 = r1 + r2
                    r0.pos = r1
                    goto L_0x004e
                L_0x0041:
                    r0 = r9
                    r7 = r0
                    r0 = r6
                    r1 = r6
                    it.unimi.dsi.fastutil.floats.FloatBigArrayBigList r1 = p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.this
                    long r1 = r1.size
                    r0.pos = r1
                L_0x004e:
                    r0 = r6
                    r1 = r6
                    long r1 = r1.pos
                    r2 = 1
                    long r1 = r1 - r2
                    r0.last = r1
                    r0 = r7
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrayBigList.C41151.skip(long):long");
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrayBigList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrayBigList$Spliterator.class */
    public final class Spliterator implements FloatSpliterator {
        boolean hasSplit;
        long pos;
        long max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !FloatBigArrayBigList.class.desiredAssertionStatus();
        }

        public Spliterator(FloatBigArrayBigList floatBigArrayBigList) {
            this(0, floatBigArrayBigList.size, false);
        }

        private Spliterator(long pos, long max, boolean hasSplit) {
            this.hasSplit = false;
            if ($assertionsDisabled || pos <= max) {
                this.pos = pos;
                this.max = max;
                this.hasSplit = hasSplit;
                return;
            }
            throw new AssertionError("pos " + pos + " must be <= max " + max);
        }

        private long getWorkingMax() {
            return this.hasSplit ? this.max : FloatBigArrayBigList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getWorkingMax() - this.pos;
        }

        public boolean tryAdvance(FloatConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            float[][] fArr = FloatBigArrayBigList.this.f1898a;
            long j = this.pos;
            this.pos = j + 1;
            action.accept(BigArrays.get(fArr, j));
            return true;
        }

        public void forEachRemaining(FloatConsumer action) {
            long max = getWorkingMax();
            while (this.pos < max) {
                action.accept(BigArrays.get(FloatBigArrayBigList.this.f1898a, this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            long max = getWorkingMax();
            if (this.pos >= max) {
                return 0;
            }
            long remaining = max - this.pos;
            if (n < remaining) {
                this.pos += n;
                return n;
            }
            this.pos = max;
            return remaining;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            long max = getWorkingMax();
            long retLen = (max - this.pos) >> 1;
            if (retLen <= 1) {
                return null;
            }
            this.max = max;
            long myNewPos = BigArrays.nearestSegmentStart(this.pos + retLen, this.pos + 1, max - 1);
            long oldPos = this.pos;
            this.pos = myNewPos;
            this.hasSplit = true;
            return new Spliterator(oldPos, myNewPos, true);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // java.lang.Object
    public FloatBigArrayBigList clone() {
        FloatBigArrayBigList c;
        if (getClass() == FloatBigArrayBigList.class) {
            c = new FloatBigArrayBigList(this.size);
            c.size = this.size;
        } else {
            try {
                c = (FloatBigArrayBigList) clone();
                c.f1898a = FloatBigArrays.newBigArray(this.size);
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e);
            }
        }
        BigArrays.copy(this.f1898a, 0L, c.f1898a, 0L, this.size);
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    public boolean equals(FloatBigArrayBigList l) {
        if (l == this) {
            return true;
        }
        char size64 = size64();
        if (size64 != l.size64()) {
            return false;
        }
        float[][] a1 = this.f1898a;
        float[][] a2 = l.f1898a;
        if (a1 == a2) {
            return true;
        }
        do {
            size64--;
            if (size64 == 0) {
                return true;
            }
        } while (BigArrays.get(a1, (long) size64) == BigArrays.get(a2, (long) size64));
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof BigList)) {
            return false;
        }
        if (o instanceof FloatBigArrayBigList) {
            return equals((FloatBigArrayBigList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(FloatBigArrayBigList l) {
        long s1 = size64();
        long s2 = l.size64();
        float[][] a1 = this.f1898a;
        float[][] a2 = l.f1898a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (((long) i) < s1 && ((long) i) < s2) {
            int r = Float.compare(BigArrays.get(a1, (long) i), BigArrays.get(a2, (long) i));
            if (r != 0) {
                return r;
            }
            i++;
        }
        if (((long) i) < s2) {
            return -1;
        }
        return ((long) i) < s1 ? 1 : 0;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList
    public int compareTo(BigList<? extends Float> l) {
        if (l instanceof FloatBigArrayBigList) {
            return compareTo((FloatBigArrayBigList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((BigList<? extends Float>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; ((long) i) < this.size; i++) {
            s.writeFloat(BigArrays.get(this.f1898a, (long) i));
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1898a = FloatBigArrays.newBigArray(this.size);
        for (int i = 0; ((long) i) < this.size; i++) {
            BigArrays.set(this.f1898a, (long) i, s.readFloat());
        }
    }
}
