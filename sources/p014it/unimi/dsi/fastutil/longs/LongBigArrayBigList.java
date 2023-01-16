package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.longs.AbstractLongBigList;
import p014it.unimi.dsi.fastutil.longs.LongBigListIterators;
import p014it.unimi.dsi.fastutil.longs.LongBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrayBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrayBigList.class */
public class LongBigArrayBigList extends AbstractLongBigList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient long[][] f2405a;
    protected long size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LongBigArrayBigList.class.desiredAssertionStatus();
    }

    protected LongBigArrayBigList(long[][] a, boolean dummy) {
        this.f2405a = a;
    }

    public LongBigArrayBigList(long capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f2405a = LongBigArrays.EMPTY_BIG_ARRAY;
        } else {
            this.f2405a = LongBigArrays.newBigArray(capacity);
        }
    }

    public LongBigArrayBigList() {
        this.f2405a = LongBigArrays.DEFAULT_EMPTY_BIG_ARRAY;
    }

    public LongBigArrayBigList(LongCollection c) {
        this(Size64.sizeOf(c));
        if (c instanceof LongBigList) {
            long[][] jArr = this.f2405a;
            long sizeOf = Size64.sizeOf(c);
            this.size = sizeOf;
            ((LongBigList) c).getElements(0, jArr, 0, sizeOf);
            return;
        }
        LongIterator i = c.iterator();
        while (i.hasNext()) {
            add(i.nextLong());
        }
    }

    public LongBigArrayBigList(LongBigList l) {
        this(l.size64());
        long[][] jArr = this.f2405a;
        long size64 = l.size64();
        this.size = size64;
        l.getElements(0, jArr, 0, size64);
    }

    public LongBigArrayBigList(long[][] a) {
        this(a, 0, BigArrays.length(a));
    }

    public LongBigArrayBigList(long[][] a, long offset, long length) {
        this(length);
        BigArrays.copy(a, offset, this.f2405a, 0L, length);
        this.size = length;
    }

    public LongBigArrayBigList(Iterator<? extends Long> i) {
        this();
        while (i.hasNext()) {
            add(((Long) i.next()).longValue());
        }
    }

    public LongBigArrayBigList(LongIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextLong());
        }
    }

    public long[][] elements() {
        return this.f2405a;
    }

    public static LongBigArrayBigList wrap(long[][] a, long length) {
        if (length > BigArrays.length(a)) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + BigArrays.length(a) + ")");
        }
        LongBigArrayBigList l = new LongBigArrayBigList(a, false);
        l.size = length;
        return l;
    }

    public static LongBigArrayBigList wrap(long[][] a) {
        return wrap(a, BigArrays.length(a));
    }

    /* renamed from: of */
    public static LongBigArrayBigList m665of() {
        return new LongBigArrayBigList();
    }

    /* renamed from: of */
    public static LongBigArrayBigList m664of(long... init) {
        return wrap(BigArrays.wrap(init));
    }

    public static LongBigArrayBigList toBigList(LongStream stream) {
        return (LongBigArrayBigList) stream.collect(LongBigArrayBigList::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static LongBigArrayBigList toBigListWithExpectedSize(LongStream stream, long expectedSize) {
        return (LongBigArrayBigList) stream.collect(() -> {
            return new LongBigArrayBigList(expectedSize);
        }, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public void ensureCapacity(long capacity) {
        if (capacity > BigArrays.length(this.f2405a) && this.f2405a != LongBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
            this.f2405a = BigArrays.forceCapacity(this.f2405a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f2405a)) {
                throw new AssertionError();
            }
        }
    }

    private void grow(long capacity) {
        long oldLength = BigArrays.length(this.f2405a);
        if (capacity > oldLength) {
            if (this.f2405a != LongBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
                capacity = Math.max(oldLength + (oldLength >> 1), capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f2405a = BigArrays.forceCapacity(this.f2405a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f2405a)) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public void add(long index, long k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            BigArrays.copy(this.f2405a, index, this.f2405a, index + 1, this.size - index);
        }
        BigArrays.set(this.f2405a, index, k);
        this.size++;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f2405a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean add(long k) {
        grow(this.size + 1);
        long[][] jArr = this.f2405a;
        long j = this.size;
        this.size = j + 1;
        BigArrays.set(jArr, j, k);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2405a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public long getLong(long index) {
        if (index < this.size) {
            return BigArrays.get(this.f2405a, index);
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public long indexOf(long k) {
        for (long i = 0; i < this.size; i++) {
            if (k == BigArrays.get(this.f2405a, i)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(long r8) {
        /*
            r7 = this;
            r0 = r7
            long r0 = r0.size
            r10 = r0
        L_0x0005:
            r0 = r10
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r10 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x001e
            r0 = r8
            r1 = r7
            long[][] r1 = r1.f2405a
            r2 = r10
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0005
            r0 = r10
            return r0
        L_0x001e:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.lastIndexOf(long):long");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public long removeLong(long index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        long old = BigArrays.get(this.f2405a, index);
        this.size--;
        if (index != this.size) {
            BigArrays.copy(this.f2405a, index + 1, this.f2405a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2405a)) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean rem(long k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeLong(index);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2405a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public long set(long index, long k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        long old = BigArrays.get(this.f2405a, index);
        BigArrays.set(this.f2405a, index, k);
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean removeAll(LongCollection c) {
        long[] s = null;
        long[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f2405a[ss];
            }
            if (!c.contains(s[sd])) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f2405a[ds];
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        long[] s = null;
        long[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f2405a[ss];
            }
            if (!c.contains(Long.valueOf(s[sd]))) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f2405a[ds];
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public boolean addAll(long index, LongCollection c) {
        if (c instanceof LongList) {
            return addAll(index, (LongList) c);
        }
        if (c instanceof LongBigList) {
            return addAll(index, (LongBigList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f2405a, index, this.f2405a, index + ((long) n), this.size - index);
        LongIterator i = c.iterator();
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2405a)) {
            while (true) {
                n--;
                if (n == 0) {
                    return true;
                }
                index++;
                BigArrays.set(this.f2405a, index, i.nextLong());
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public boolean addAll(long index, LongBigList list) {
        ensureIndex(index);
        long n = list.size64();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        BigArrays.copy(this.f2405a, index, this.f2405a, index + n, this.size - index);
        list.getElements(0, this.f2405a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2405a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public boolean addAll(long index, LongList list) {
        ensureIndex(index);
        int n = list.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f2405a, index, this.f2405a, index + ((long) n), this.size - index);
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2405a)) {
            int segment = BigArrays.segment(index);
            int displ = BigArrays.displacement(index);
            int pos = 0;
            while (n > 0) {
                int l = Math.min(this.f2405a[segment].length - displ, n);
                list.getElements(pos, this.f2405a[segment], displ, l);
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f2405a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.BigList
    public void size(long size) {
        if (size > BigArrays.length(this.f2405a)) {
            this.f2405a = BigArrays.forceCapacity(this.f2405a, size, this.size);
        }
        if (size > this.size) {
            BigArrays.fill(this.f2405a, this.size, size, 0L);
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
        long arrayLength = BigArrays.length(this.f2405a);
        if (n < arrayLength && this.size != arrayLength) {
            this.f2405a = BigArrays.trim(this.f2405a, Math.max(n, this.size));
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f2405a)) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrayBigList$SubList.class */
    public class SubList extends AbstractLongBigList.LongRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(long from, long to) {
            super(LongBigArrayBigList.this, from, to);
        }

        private long[][] getParentArray() {
            return LongBigArrayBigList.this.f2405a;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.LongSubList, p014it.unimi.dsi.fastutil.longs.LongBigList
        public long getLong(long i) {
            ensureRestrictedIndex(i);
            return BigArrays.get(LongBigArrayBigList.this.f2405a, i + this.from);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrayBigList$SubList$SubListIterator.class */
        public final class SubListIterator extends LongBigListIterators.AbstractIndexBasedBigListIterator {
            SubListIterator(long index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final long get(long i) {
                return BigArrays.get(LongBigArrayBigList.this.f2405a, SubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, long k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, long k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                SubList.this.removeLong(i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return SubList.this.f2259to - SubList.this.from;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long[][] jArr = LongBigArrayBigList.this.f2405a;
                long j = SubList.this.from;
                long j2 = this.pos;
                this.pos = j2 + 1;
                this.lastReturned = j2;
                return BigArrays.get((long[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            public long previousLong() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                long[][] jArr = LongBigArrayBigList.this.f2405a;
                long j = SubList.this.from;
                long j2 = this.pos - 1;
                this.pos = j2;
                this.lastReturned = j2;
                return BigArrays.get((long[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v7, types: [long[][], java.util.function.LongConsumer] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterators.AbstractIndexBasedBigIterator, java.util.PrimitiveIterator.OfLong
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(java.util.function.LongConsumer r14) {
                /*
                    r13 = this;
                    r0 = r13
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.SubList.this
                    long r0 = r0.f2259to
                    r1 = r13
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.SubList.this
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
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.SubList.this
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r1 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                    long[][] r1 = r1.f2405a
                    r2 = r13
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList r2 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.SubList.this
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
                    long r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0010
                L_0x0047:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.SubList.SubListIterator.forEachRemaining(java.util.function.LongConsumer):void");
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.LongSubList, p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Long> listIterator(long index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrayBigList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends LongBigSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(long pos, long maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final long getMaxPosFromBackingStore() {
                return SubList.this.f2259to;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.AbstractIndexBasedSpliterator
            protected final long get(long i) {
                return BigArrays.get(LongBigArrayBigList.this.f2405a, i);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(long pos, long maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.AbstractIndexBasedSpliterator
            protected final long computeSplitPoint() {
                return BigArrays.nearestSegmentStart(computeSplitPoint(), this.pos + 1, getMaxPos() - 1);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public boolean tryAdvance(LongConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                long[][] jArr = LongBigArrayBigList.this.f2405a;
                long j = this.pos;
                this.pos = j + 1;
                action.accept(BigArrays.get(jArr, j));
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                long max = getMaxPos();
                while (this.pos < max) {
                    long[][] jArr = LongBigArrayBigList.this.f2405a;
                    long j = this.pos;
                    this.pos = j + 1;
                    action.accept(BigArrays.get(jArr, j));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList.LongSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new SubListSpliterator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        /* JADX WARN: Type inference failed for: r0v10, types: [long] */
        /* JADX WARN: Type inference failed for: r0v16, types: [long] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        boolean contentsEquals(long[][] r9, long r10, long r12) {
            /*
                r8 = this;
                r0 = r8
                it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                long[][] r0 = r0.f2405a
                r1 = r9
                if (r0 != r1) goto L_0x0020
                r0 = r8
                long r0 = r0.from
                r1 = r10
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r8
                long r0 = r0.f2259to
                r1 = r12
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = 1
                return r0
            L_0x0020:
                r0 = r12
                r1 = r10
                long r0 = r0 - r1
                r1 = r8
                long r1 = r1.size64()
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x002e
                r0 = 0
                return r0
            L_0x002e:
                r0 = r8
                long r0 = r0.f2259to
                r14 = r0
                r0 = r12
                r16 = r0
            L_0x0038:
                r0 = r14
                r1 = 1
                long r0 = r0 - r1
                r1 = r0; r1 = r0; 
                r14 = r1
                r1 = r8
                long r1 = r1.from
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L_0x0064
                r0 = r8
                it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                long[][] r0 = r0.f2405a
                r1 = r14
                long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r1 = r9
                r2 = r16
                r3 = 1
                long r2 = r2 - r3
                r3 = r2; r3 = r0; 
                r16 = r3
                long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0038
                r0 = 0
                return r0
            L_0x0064:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.SubList.contentsEquals(long[][], long, long):boolean");
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof BigList)) {
                return false;
            }
            if (o instanceof LongBigArrayBigList) {
                LongBigArrayBigList other = (LongBigArrayBigList) o;
                return contentsEquals(other.f2405a, 0, other.size64());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f2259to);
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
        int contentsCompareTo(long[][] r6, long r7, long r9) {
            /*
                r5 = this;
                r0 = r5
                it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                long[][] r0 = r0.f2405a
                r1 = r6
                if (r0 != r1) goto L_0x0020
                r0 = r5
                long r0 = r0.from
                r1 = r7
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r5
                long r0 = r0.f2259to
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = 0
                return r0
            L_0x0020:
                r0 = r5
                long r0 = r0.from
                r16 = r0
                r0 = r7
                r18 = r0
            L_0x0029:
                r0 = r16
                r1 = r5
                long r1 = r1.f2259to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r16
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r5
                it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                long[][] r0 = r0.f2405a
                r1 = r16
                long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r11 = r0
                r0 = r6
                r1 = r18
                long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r13 = r0
                r0 = r11
                r1 = r13
                int r0 = java.lang.Long.compare(r0, r1)
                r1 = r0
                r15 = r1
                if (r0 == 0) goto L_0x0061
                r0 = r15
                return r0
            L_0x0061:
                r0 = r16
                r1 = 1
                long r0 = r0 + r1
                r16 = r0
                r0 = r18
                r1 = 1
                long r0 = r0 + r1
                r18 = r0
                goto L_0x0029
            L_0x0070:
                r0 = r16
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x007c
                r0 = -1
                goto L_0x008b
            L_0x007c:
                r0 = r16
                r1 = r5
                long r1 = r1.f2259to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x008a
                r0 = 1
                goto L_0x008b
            L_0x008a:
                r0 = 0
            L_0x008b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.SubList.contentsCompareTo(long[][], long, long):int");
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList
        public int compareTo(BigList<? extends Long> l) {
            if (l instanceof LongBigArrayBigList) {
                LongBigArrayBigList other = (LongBigArrayBigList) l;
                return contentsCompareTo(other.f2405a, 0, other.size64());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f2259to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Long> subList(long from, long to) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public void getElements(long from, long[][] a, long offset, long length) {
        BigArrays.copy(this.f2405a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public void getElements(long from, long[] a, int offset, int length) {
        BigArrays.copyFromBig(this.f2405a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public void removeElements(long from, long to) {
        BigArrays.ensureFromTo(this.size, from, to);
        BigArrays.copy(this.f2405a, to, this.f2405a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public void addElements(long index, long[][] a, long offset, long length) {
        ensureIndex(index);
        BigArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        BigArrays.copy(this.f2405a, index, this.f2405a, index + length, this.size - index);
        BigArrays.copy(a, offset, this.f2405a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public void setElements(long index, long[][] a, long offset, long length) {
        BigArrays.copy(a, offset, this.f2405a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongIterable
    public void forEach(LongConsumer action) {
        for (long i = 0; i < this.size; i++) {
            action.accept(BigArrays.get(this.f2405a, i));
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Long> listIterator(final long index) {
        ensureIndex(index);
        return new LongBigListIterator() { // from class: it.unimi.dsi.fastutil.longs.LongBigArrayBigList.1
            long pos;
            long last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.pos < LongBigArrayBigList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long[][], long] */
            /* JADX WARN: Type inference failed for: r3v1, types: [long, long[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public long nextLong() {
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
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                    long[][] r0 = r0.f2405a
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
                    long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.C45761.nextLong():long");
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long[][], long] */
            /* JADX WARN: Type inference failed for: r3v2, types: [long, long[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public long previousLong() {
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
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                    long[][] r0 = r0.f2405a
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
                    long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.C45761.previousLong():long");
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.pos;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
            public void add(long k) {
                LongBigArrayBigList longBigArrayBigList = LongBigArrayBigList.this;
                long j = this.pos;
                this.pos = j + 1;
                longBigArrayBigList.add(j, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
            public void set(long k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                LongBigArrayBigList.this.set(this.last, k);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                LongBigArrayBigList.this.removeLong(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$1 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v5, types: [long[][], long] */
            /* JADX WARN: Type inference failed for: r4v1, types: [long, long[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // java.util.PrimitiveIterator.OfLong
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(java.util.function.LongConsumer r12) {
                /*
                    r11 = this;
                L_0x0000:
                    r0 = r11
                    long r0 = r0.pos
                    r1 = r11
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r1 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                    long r1 = r1.size
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0032
                    r0 = r12
                    r1 = r11
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r1 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
                    long[][] r1 = r1.f2405a
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
                    long r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0000
                L_0x0032:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.C45761.forEachRemaining(java.util.function.LongConsumer):void");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
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
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.C45761.back(long):long");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.longs.LongBigListIterator
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
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
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
                    it.unimi.dsi.fastutil.longs.LongBigArrayBigList r1 = p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrayBigList.C45761.skip(long):long");
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrayBigList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrayBigList$Spliterator.class */
    public final class Spliterator implements LongSpliterator {
        boolean hasSplit;
        long pos;
        long max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !LongBigArrayBigList.class.desiredAssertionStatus();
        }

        public Spliterator(LongBigArrayBigList longBigArrayBigList) {
            this(0, longBigArrayBigList.size, false);
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
            return this.hasSplit ? this.max : LongBigArrayBigList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getWorkingMax() - this.pos;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            long[][] jArr = LongBigArrayBigList.this.f2405a;
            long j = this.pos;
            this.pos = j + 1;
            action.accept(BigArrays.get(jArr, j));
            return true;
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            long max = getWorkingMax();
            while (this.pos < max) {
                action.accept(BigArrays.get(LongBigArrayBigList.this.f2405a, this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // java.lang.Object
    public LongBigArrayBigList clone() {
        LongBigArrayBigList c;
        if (getClass() == LongBigArrayBigList.class) {
            c = new LongBigArrayBigList(this.size);
            c.size = this.size;
        } else {
            try {
                c = (LongBigArrayBigList) clone();
                c.f2405a = LongBigArrays.newBigArray(this.size);
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e);
            }
        }
        BigArrays.copy(this.f2405a, 0L, c.f2405a, 0L, this.size);
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    public boolean equals(LongBigArrayBigList l) {
        if (l == this) {
            return true;
        }
        char size64 = size64();
        if (size64 != l.size64()) {
            return false;
        }
        long[][] a1 = this.f2405a;
        long[][] a2 = l.f2405a;
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof BigList)) {
            return false;
        }
        if (o instanceof LongBigArrayBigList) {
            return equals((LongBigArrayBigList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(LongBigArrayBigList l) {
        long s1 = size64();
        long s2 = l.size64();
        long[][] a1 = this.f2405a;
        long[][] a2 = l.f2405a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (((long) i) < s1 && ((long) i) < s2) {
            int r = Long.compare(BigArrays.get(a1, (long) i), BigArrays.get(a2, (long) i));
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList
    public int compareTo(BigList<? extends Long> l) {
        if (l instanceof LongBigArrayBigList) {
            return compareTo((LongBigArrayBigList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((BigList<? extends Long>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; ((long) i) < this.size; i++) {
            s.writeLong(BigArrays.get(this.f2405a, (long) i));
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2405a = LongBigArrays.newBigArray(this.size);
        for (int i = 0; ((long) i) < this.size; i++) {
            BigArrays.set(this.f2405a, (long) i, s.readLong());
        }
    }
}
