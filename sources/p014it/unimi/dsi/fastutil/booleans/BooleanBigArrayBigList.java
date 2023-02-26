package p014it.unimi.dsi.fastutil.booleans;

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
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList;
import p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators;
import p014it.unimi.dsi.fastutil.booleans.BooleanBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrayBigList.class */
public class BooleanBigArrayBigList extends AbstractBooleanBigList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient boolean[][] f1021a;
    protected long size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !BooleanBigArrayBigList.class.desiredAssertionStatus();
    }

    protected BooleanBigArrayBigList(boolean[][] a, boolean dummy) {
        this.f1021a = a;
    }

    public BooleanBigArrayBigList(long capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f1021a = BooleanBigArrays.EMPTY_BIG_ARRAY;
        } else {
            this.f1021a = BooleanBigArrays.newBigArray(capacity);
        }
    }

    public BooleanBigArrayBigList() {
        this.f1021a = BooleanBigArrays.DEFAULT_EMPTY_BIG_ARRAY;
    }

    public BooleanBigArrayBigList(BooleanCollection c) {
        this(Size64.sizeOf(c));
        if (c instanceof BooleanBigList) {
            boolean[][] zArr = this.f1021a;
            long sizeOf = Size64.sizeOf(c);
            this.size = sizeOf;
            ((BooleanBigList) c).getElements(0, zArr, 0, sizeOf);
            return;
        }
        BooleanIterator i = c.iterator();
        while (i.hasNext()) {
            add(i.nextBoolean());
        }
    }

    public BooleanBigArrayBigList(BooleanBigList l) {
        this(l.size64());
        boolean[][] zArr = this.f1021a;
        long size64 = l.size64();
        this.size = size64;
        l.getElements(0, zArr, 0, size64);
    }

    public BooleanBigArrayBigList(boolean[][] a) {
        this(a, 0, BigArrays.length(a));
    }

    public BooleanBigArrayBigList(boolean[][] a, long offset, long length) {
        this(length);
        BigArrays.copy(a, offset, this.f1021a, 0, length);
        this.size = length;
    }

    public BooleanBigArrayBigList(Iterator<? extends Boolean> i) {
        this();
        while (i.hasNext()) {
            add(((Boolean) i.next()).booleanValue());
        }
    }

    public BooleanBigArrayBigList(BooleanIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextBoolean());
        }
    }

    public boolean[][] elements() {
        return this.f1021a;
    }

    public static BooleanBigArrayBigList wrap(boolean[][] a, long length) {
        if (length > BigArrays.length(a)) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + BigArrays.length(a) + ")");
        }
        BooleanBigArrayBigList l = new BooleanBigArrayBigList(a, false);
        l.size = length;
        return l;
    }

    public static BooleanBigArrayBigList wrap(boolean[][] a) {
        return wrap(a, BigArrays.length(a));
    }

    /* renamed from: of */
    public static BooleanBigArrayBigList m1164of() {
        return new BooleanBigArrayBigList();
    }

    /* renamed from: of */
    public static BooleanBigArrayBigList m1163of(boolean... init) {
        return wrap(BigArrays.wrap(init));
    }

    public void ensureCapacity(long capacity) {
        if (capacity > BigArrays.length(this.f1021a) && this.f1021a != BooleanBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
            this.f1021a = BigArrays.forceCapacity(this.f1021a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f1021a)) {
                throw new AssertionError();
            }
        }
    }

    private void grow(long capacity) {
        long oldLength = BigArrays.length(this.f1021a);
        if (capacity > oldLength) {
            if (this.f1021a != BooleanBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
                capacity = Math.max(oldLength + (oldLength >> 1), capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f1021a = BigArrays.forceCapacity(this.f1021a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f1021a)) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public void add(long index, boolean k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            BigArrays.copy(this.f1021a, index, this.f1021a, index + 1, this.size - index);
        }
        BigArrays.set(this.f1021a, index, k);
        this.size++;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f1021a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean add(boolean k) {
        grow(this.size + 1);
        boolean[][] zArr = this.f1021a;
        long j = this.size;
        this.size = j + 1;
        BigArrays.set(zArr, j, k);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1021a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public boolean getBoolean(long index) {
        if (index < this.size) {
            return BigArrays.get(this.f1021a, index);
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public long indexOf(boolean k) {
        for (long i = 0; i < this.size; i++) {
            if (k == BigArrays.get(this.f1021a, i)) {
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
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(boolean r8) {
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
            if (r0 == 0) goto L_0x001d
            r0 = r8
            r1 = r7
            boolean[][] r1 = r1.f1021a
            r2 = r9
            boolean r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            if (r0 != r1) goto L_0x0005
            r0 = r9
            return r0
        L_0x001d:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.lastIndexOf(boolean):long");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public boolean removeBoolean(long index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        boolean old = BigArrays.get(this.f1021a, index);
        this.size--;
        if (index != this.size) {
            BigArrays.copy(this.f1021a, index + 1, this.f1021a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1021a)) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean rem(boolean k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeBoolean(index);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1021a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public boolean set(long index, boolean k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        boolean old = BigArrays.get(this.f1021a, index);
        BigArrays.set(this.f1021a, index, k);
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean removeAll(BooleanCollection c) {
        boolean[] s = null;
        boolean[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f1021a[ss];
            }
            if (!c.contains(s[sd])) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f1021a[ds];
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

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        boolean[] s = null;
        boolean[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f1021a[ss];
            }
            if (!c.contains(Boolean.valueOf(s[sd]))) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f1021a[ds];
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

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public boolean addAll(long index, BooleanCollection c) {
        if (c instanceof BooleanList) {
            return addAll(index, (BooleanList) c);
        }
        if (c instanceof BooleanBigList) {
            return addAll(index, (BooleanBigList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f1021a, index, this.f1021a, index + ((long) n), this.size - index);
        BooleanIterator i = c.iterator();
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1021a)) {
            while (true) {
                n--;
                if (n == 0) {
                    return true;
                }
                index++;
                BigArrays.set(this.f1021a, index, i.nextBoolean());
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public boolean addAll(long index, BooleanBigList list) {
        ensureIndex(index);
        long n = list.size64();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        BigArrays.copy(this.f1021a, index, this.f1021a, index + n, this.size - index);
        list.getElements(0, this.f1021a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1021a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public boolean addAll(long index, BooleanList list) {
        ensureIndex(index);
        int n = list.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f1021a, index, this.f1021a, index + ((long) n), this.size - index);
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f1021a)) {
            int segment = BigArrays.segment(index);
            int displ = BigArrays.displacement(index);
            int pos = 0;
            while (n > 0) {
                int l = Math.min(this.f1021a[segment].length - displ, n);
                list.getElements(pos, this.f1021a[segment], displ, l);
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

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f1021a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.BigList
    public void size(long size) {
        if (size > BigArrays.length(this.f1021a)) {
            this.f1021a = BigArrays.forceCapacity(this.f1021a, size, this.size);
        }
        if (size > this.size) {
            BigArrays.fill(this.f1021a, this.size, size, false);
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
        long arrayLength = BigArrays.length(this.f1021a);
        if (n < arrayLength && this.size != arrayLength) {
            this.f1021a = BigArrays.trim(this.f1021a, Math.max(n, this.size));
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f1021a)) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrayBigList$SubList.class */
    public class SubList extends AbstractBooleanBigList.BooleanRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(long from, long to) {
            super(BooleanBigArrayBigList.this, from, to);
        }

        private boolean[][] getParentArray() {
            return BooleanBigArrayBigList.this.f1021a;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList.BooleanSubList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public boolean getBoolean(long i) {
            ensureRestrictedIndex(i);
            return BigArrays.get(BooleanBigArrayBigList.this.f1021a, i + this.from);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrayBigList$SubList$SubListIterator.class */
        public final class SubListIterator extends BooleanBigListIterators.AbstractIndexBasedBigListIterator {
            SubListIterator(long index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigIterator
            protected final boolean get(long i) {
                return BigArrays.get(BooleanBigArrayBigList.this.f1021a, SubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, boolean k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, boolean k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                SubList.this.removeBoolean(i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return SubList.this.f1005to - SubList.this.from;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public boolean nextBoolean() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                boolean[][] zArr = BooleanBigArrayBigList.this.f1021a;
                long j = SubList.this.from;
                long j2 = this.pos;
                this.pos = j2 + 1;
                this.lastReturned = j2;
                return BigArrays.get((boolean[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
            public boolean previousBoolean() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                boolean[][] zArr = BooleanBigArrayBigList.this.f1021a;
                long j = SubList.this.from;
                long j2 = this.pos - 1;
                this.pos = j2;
                this.lastReturned = j2;
                return BigArrays.get((boolean[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v7, types: [boolean[][], it.unimi.dsi.fastutil.booleans.BooleanConsumer] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterators.AbstractIndexBasedBigIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(p014it.unimi.dsi.fastutil.booleans.BooleanConsumer r14) {
                /*
                    r13 = this;
                    r0 = r13
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.SubList.this
                    long r0 = r0.f1005to
                    r1 = r13
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.SubList.this
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
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.SubList.this
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r1 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                    boolean[][] r1 = r1.f1021a
                    r2 = r13
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList r2 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.SubList.this
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
                    boolean r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0010
                L_0x0047:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.SubList.SubListIterator.forEachRemaining(it.unimi.dsi.fastutil.booleans.BooleanConsumer):void");
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList.BooleanSubList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Boolean> listIterator(long index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrayBigList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends BooleanBigSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(long pos, long maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final long getMaxPosFromBackingStore() {
                return SubList.this.f1005to;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigSpliterators.AbstractIndexBasedSpliterator
            protected final boolean get(long i) {
                return BigArrays.get(BooleanBigArrayBigList.this.f1021a, i);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(long pos, long maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigSpliterators.AbstractIndexBasedSpliterator
            protected final long computeSplitPoint() {
                return BigArrays.nearestSegmentStart(computeSplitPoint(), this.pos + 1, getMaxPos() - 1);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(BooleanConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                boolean[][] zArr = BooleanBigArrayBigList.this.f1021a;
                long j = this.pos;
                this.pos = j + 1;
                action.accept(BigArrays.get(zArr, j));
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(BooleanConsumer action) {
                long max = getMaxPos();
                while (this.pos < max) {
                    boolean[][] zArr = BooleanBigArrayBigList.this.f1021a;
                    long j = this.pos;
                    this.pos = j + 1;
                    action.accept(BigArrays.get(zArr, j));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList.BooleanSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return new SubListSpliterator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        /* JADX WARN: Type inference failed for: r0v10, types: [long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        boolean contentsEquals(boolean[][] r8, long r9, long r11) {
            /*
                r7 = this;
                r0 = r7
                it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                boolean[][] r0 = r0.f1021a
                r1 = r8
                if (r0 != r1) goto L_0x0020
                r0 = r7
                long r0 = r0.from
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r7
                long r0 = r0.f1005to
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
                long r0 = r0.f1005to
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
                if (r0 < 0) goto L_0x0063
                r0 = r7
                it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                boolean[][] r0 = r0.f1021a
                r1 = r13
                boolean r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r1 = r8
                r2 = r15
                r3 = 1
                long r2 = r2 - r3
                r3 = r2; r3 = r0; 
                r15 = r3
                boolean r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                if (r0 == r1) goto L_0x0038
                r0 = 0
                return r0
            L_0x0063:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.SubList.contentsEquals(boolean[][], long, long):boolean");
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof BigList)) {
                return false;
            }
            if (o instanceof BooleanBigArrayBigList) {
                BooleanBigArrayBigList other = (BooleanBigArrayBigList) o;
                return contentsEquals(other.f1021a, 0, other.size64());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f1005to);
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
        int contentsCompareTo(boolean[][] r6, long r7, long r9) {
            /*
                r5 = this;
                r0 = r5
                it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                boolean[][] r0 = r0.f1021a
                r1 = r6
                if (r0 != r1) goto L_0x0020
                r0 = r5
                long r0 = r0.from
                r1 = r7
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r5
                long r0 = r0.f1005to
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
                long r1 = r1.f1005to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r14
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r5
                it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                boolean[][] r0 = r0.f1021a
                r1 = r14
                boolean r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r11 = r0
                r0 = r6
                r1 = r16
                boolean r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r12 = r0
                r0 = r11
                r1 = r12
                int r0 = java.lang.Boolean.compare(r0, r1)
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
                long r1 = r1.f1005to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x008a
                r0 = 1
                goto L_0x008b
            L_0x008a:
                r0 = 0
            L_0x008b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.SubList.contentsCompareTo(boolean[][], long, long):int");
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList
        public int compareTo(BigList<? extends Boolean> l) {
            if (l instanceof BooleanBigArrayBigList) {
                BooleanBigArrayBigList other = (BooleanBigArrayBigList) l;
                return contentsCompareTo(other.f1021a, 0, other.size64());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f1005to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Boolean> subList(long from, long to) {
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

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public void getElements(long from, boolean[][] a, long offset, long length) {
        BigArrays.copy(this.f1021a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public void getElements(long from, boolean[] a, int offset, int length) {
        BigArrays.copyFromBig(this.f1021a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public void removeElements(long from, long to) {
        BigArrays.ensureFromTo(this.size, from, to);
        BigArrays.copy(this.f1021a, to, this.f1021a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public void addElements(long index, boolean[][] a, long offset, long length) {
        ensureIndex(index);
        BigArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        BigArrays.copy(this.f1021a, index, this.f1021a, index + length, this.size - index);
        BigArrays.copy(a, offset, this.f1021a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public void setElements(long index, boolean[][] a, long offset, long length) {
        BigArrays.copy(a, offset, this.f1021a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
    public void forEach(BooleanConsumer action) {
        for (long i = 0; i < this.size; i++) {
            action.accept(BigArrays.get(this.f1021a, i));
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, p014it.unimi.dsi.fastutil.booleans.BooleanBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Boolean> listIterator(final long index) {
        ensureIndex(index);
        return new BooleanBigListIterator() { // from class: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.1
            long pos;
            long last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.pos < BooleanBigArrayBigList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, boolean[][]] */
            /* JADX WARN: Type inference failed for: r3v1, types: [long, boolean[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean nextBoolean() {
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
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                    boolean[][] r0 = r0.f1021a
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
                    boolean r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.C32171.nextBoolean():boolean");
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, boolean[][]] */
            /* JADX WARN: Type inference failed for: r3v2, types: [long, boolean[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean previousBoolean() {
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
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                    boolean[][] r0 = r0.f1021a
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
                    boolean r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.C32171.previousBoolean():boolean");
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.pos;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterator
            public void add(boolean k) {
                BooleanBigArrayBigList booleanBigArrayBigList = BooleanBigArrayBigList.this;
                long j = this.pos;
                this.pos = j + 1;
                booleanBigArrayBigList.add(j, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterator
            public void set(boolean k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                BooleanBigArrayBigList.this.set(this.last, k);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                BooleanBigArrayBigList.this.removeBoolean(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$1 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v5, types: [long, boolean[][]] */
            /* JADX WARN: Type inference failed for: r4v1, types: [long, boolean[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(p014it.unimi.dsi.fastutil.booleans.BooleanConsumer r12) {
                /*
                    r11 = this;
                L_0x0000:
                    r0 = r11
                    long r0 = r0.pos
                    r1 = r11
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r1 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                    long r1 = r1.size
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0032
                    r0 = r12
                    r1 = r11
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r1 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
                    boolean[][] r1 = r1.f1021a
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
                    boolean r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0000
                L_0x0032:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.C32171.forEachRemaining(it.unimi.dsi.fastutil.booleans.BooleanConsumer):void");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterator
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
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.C32171.back(long):long");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBigListIterator
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
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
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
                    it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList r1 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList.C32171.skip(long):long");
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrayBigList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrayBigList$Spliterator.class */
    public final class Spliterator implements BooleanSpliterator {
        boolean hasSplit;
        long pos;
        long max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !BooleanBigArrayBigList.class.desiredAssertionStatus();
        }

        public Spliterator(BooleanBigArrayBigList booleanBigArrayBigList) {
            this(0, booleanBigArrayBigList.size, false);
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
            return this.hasSplit ? this.max : BooleanBigArrayBigList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getWorkingMax() - this.pos;
        }

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            boolean[][] zArr = BooleanBigArrayBigList.this.f1021a;
            long j = this.pos;
            this.pos = j + 1;
            action.accept(BigArrays.get(zArr, j));
            return true;
        }

        public void forEachRemaining(BooleanConsumer action) {
            long max = getWorkingMax();
            while (this.pos < max) {
                action.accept(BigArrays.get(BooleanBigArrayBigList.this.f1021a, this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // java.lang.Object
    public BooleanBigArrayBigList clone() {
        BooleanBigArrayBigList c;
        if (getClass() == BooleanBigArrayBigList.class) {
            c = new BooleanBigArrayBigList(this.size);
            c.size = this.size;
        } else {
            try {
                c = (BooleanBigArrayBigList) clone();
                c.f1021a = BooleanBigArrays.newBigArray(this.size);
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e);
            }
        }
        BigArrays.copy(this.f1021a, 0, c.f1021a, 0, this.size);
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    public boolean equals(BooleanBigArrayBigList l) {
        if (l == this) {
            return true;
        }
        char size64 = size64();
        if (size64 != l.size64()) {
            return false;
        }
        boolean[][] a1 = this.f1021a;
        boolean[][] a2 = l.f1021a;
        if (a1 == a2) {
            return true;
        }
        do {
            size64--;
            if (size64 == 0) {
                return true;
            }
        } while (BigArrays.get(a1, size64) == BigArrays.get(a2, size64));
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList, java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof BigList)) {
            return false;
        }
        if (o instanceof BooleanBigArrayBigList) {
            return equals((BooleanBigArrayBigList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(BooleanBigArrayBigList l) {
        long s1 = size64();
        long s2 = l.size64();
        boolean[][] a1 = this.f1021a;
        boolean[][] a2 = l.f1021a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (((long) i) < s1 && ((long) i) < s2) {
            int r = Boolean.compare(BigArrays.get(a1, (long) i), BigArrays.get(a2, (long) i));
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

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanBigList
    public int compareTo(BigList<? extends Boolean> l) {
        if (l instanceof BooleanBigArrayBigList) {
            return compareTo((BooleanBigArrayBigList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((BigList<? extends Boolean>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; ((long) i) < this.size; i++) {
            s.writeBoolean(BigArrays.get(this.f1021a, (long) i));
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1021a = BooleanBigArrays.newBigArray(this.size);
        for (int i = 0; ((long) i) < this.size; i++) {
            BigArrays.set(this.f1021a, (long) i, s.readBoolean());
        }
    }
}
