package p014it.unimi.dsi.fastutil.shorts;

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
import p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList;
import p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators;
import p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigArrayBigList.class */
public class ShortBigArrayBigList extends AbstractShortBigList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient short[][] f3035a;
    protected long size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ShortBigArrayBigList.class.desiredAssertionStatus();
    }

    protected ShortBigArrayBigList(short[][] a, boolean dummy) {
        this.f3035a = a;
    }

    public ShortBigArrayBigList(long capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f3035a = ShortBigArrays.EMPTY_BIG_ARRAY;
        } else {
            this.f3035a = ShortBigArrays.newBigArray(capacity);
        }
    }

    public ShortBigArrayBigList() {
        this.f3035a = ShortBigArrays.DEFAULT_EMPTY_BIG_ARRAY;
    }

    public ShortBigArrayBigList(ShortCollection c) {
        this(Size64.sizeOf(c));
        if (c instanceof ShortBigList) {
            short[][] sArr = this.f3035a;
            long sizeOf = Size64.sizeOf(c);
            this.size = sizeOf;
            ((ShortBigList) c).getElements(0, sArr, 0, sizeOf);
            return;
        }
        ShortIterator i = c.iterator();
        while (i.hasNext()) {
            add(i.nextShort());
        }
    }

    public ShortBigArrayBigList(ShortBigList l) {
        this(l.size64());
        short[][] sArr = this.f3035a;
        long size64 = l.size64();
        this.size = size64;
        l.getElements(0, sArr, 0, size64);
    }

    public ShortBigArrayBigList(short[][] a) {
        this(a, 0, BigArrays.length(a));
    }

    public ShortBigArrayBigList(short[][] a, long offset, long length) {
        this(length);
        BigArrays.copy(a, offset, this.f3035a, 0L, length);
        this.size = length;
    }

    public ShortBigArrayBigList(Iterator<? extends Short> i) {
        this();
        while (i.hasNext()) {
            add(((Short) i.next()).shortValue());
        }
    }

    public ShortBigArrayBigList(ShortIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextShort());
        }
    }

    public short[][] elements() {
        return this.f3035a;
    }

    public static ShortBigArrayBigList wrap(short[][] a, long length) {
        if (length > BigArrays.length(a)) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + BigArrays.length(a) + ")");
        }
        ShortBigArrayBigList l = new ShortBigArrayBigList(a, false);
        l.size = length;
        return l;
    }

    public static ShortBigArrayBigList wrap(short[][] a) {
        return wrap(a, BigArrays.length(a));
    }

    /* renamed from: of */
    public static ShortBigArrayBigList m440of() {
        return new ShortBigArrayBigList();
    }

    /* renamed from: of */
    public static ShortBigArrayBigList m439of(short... init) {
        return wrap(BigArrays.wrap(init));
    }

    public void ensureCapacity(long capacity) {
        if (capacity > BigArrays.length(this.f3035a) && this.f3035a != ShortBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
            this.f3035a = BigArrays.forceCapacity(this.f3035a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f3035a)) {
                throw new AssertionError();
            }
        }
    }

    private void grow(long capacity) {
        long oldLength = BigArrays.length(this.f3035a);
        if (capacity > oldLength) {
            if (this.f3035a != ShortBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
                capacity = Math.max(oldLength + (oldLength >> 1), capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f3035a = BigArrays.forceCapacity(this.f3035a, capacity, this.size);
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f3035a)) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void add(long index, short k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            BigArrays.copy(this.f3035a, index, this.f3035a, index + 1, this.size - index);
        }
        BigArrays.set(this.f3035a, index, k);
        this.size++;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f3035a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean add(short k) {
        grow(this.size + 1);
        short[][] sArr = this.f3035a;
        long j = this.size;
        this.size = j + 1;
        BigArrays.set(sArr, j, k);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f3035a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public short getShort(long index) {
        if (index < this.size) {
            return BigArrays.get(this.f3035a, index);
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public long indexOf(short k) {
        for (long i = 0; i < this.size; i++) {
            if (k == BigArrays.get(this.f3035a, i)) {
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
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(short r8) {
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
            short[][] r1 = r1.f3035a
            r2 = r9
            short r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            if (r0 != r1) goto L_0x0005
            r0 = r9
            return r0
        L_0x001d:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.lastIndexOf(short):long");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public short removeShort(long index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        short old = BigArrays.get(this.f3035a, index);
        this.size--;
        if (index != this.size) {
            BigArrays.copy(this.f3035a, index + 1, this.f3035a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f3035a)) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean rem(short k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeShort(index);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f3035a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public short set(long index, short k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        short old = BigArrays.get(this.f3035a, index);
        BigArrays.set(this.f3035a, index, k);
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean removeAll(ShortCollection c) {
        short[] s = null;
        short[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f3035a[ss];
            }
            if (!c.contains(s[sd])) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f3035a[ds];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        short[] s = null;
        short[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f3035a[ss];
            }
            if (!c.contains(Short.valueOf(s[sd]))) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f3035a[ds];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public boolean addAll(long index, ShortCollection c) {
        if (c instanceof ShortList) {
            return addAll(index, (ShortList) c);
        }
        if (c instanceof ShortBigList) {
            return addAll(index, (ShortBigList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f3035a, index, this.f3035a, index + ((long) n), this.size - index);
        ShortIterator i = c.iterator();
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f3035a)) {
            while (true) {
                n--;
                if (n == 0) {
                    return true;
                }
                index++;
                BigArrays.set(this.f3035a, index, i.nextShort());
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public boolean addAll(long index, ShortBigList list) {
        ensureIndex(index);
        long n = list.size64();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        BigArrays.copy(this.f3035a, index, this.f3035a, index + n, this.size - index);
        list.getElements(0, this.f3035a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f3035a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public boolean addAll(long index, ShortList list) {
        ensureIndex(index);
        int n = list.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f3035a, index, this.f3035a, index + ((long) n), this.size - index);
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f3035a)) {
            int segment = BigArrays.segment(index);
            int displ = BigArrays.displacement(index);
            int pos = 0;
            while (n > 0) {
                int l = Math.min(this.f3035a[segment].length - displ, n);
                list.getElements(pos, this.f3035a[segment], displ, l);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f3035a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.BigList
    public void size(long size) {
        if (size > BigArrays.length(this.f3035a)) {
            this.f3035a = BigArrays.forceCapacity(this.f3035a, size, this.size);
        }
        if (size > this.size) {
            BigArrays.fill(this.f3035a, this.size, size, (short) 0);
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
        long arrayLength = BigArrays.length(this.f3035a);
        if (n < arrayLength && this.size != arrayLength) {
            this.f3035a = BigArrays.trim(this.f3035a, Math.max(n, this.size));
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f3035a)) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigArrayBigList$SubList.class */
    public class SubList extends AbstractShortBigList.ShortRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(long from, long to) {
            super(ShortBigArrayBigList.this, from, to);
        }

        private short[][] getParentArray() {
            return ShortBigArrayBigList.this.f3035a;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.ShortSubList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
        public short getShort(long i) {
            ensureRestrictedIndex(i);
            return BigArrays.get(ShortBigArrayBigList.this.f3035a, i + this.from);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigArrayBigList$SubList$SubListIterator.class */
        public final class SubListIterator extends ShortBigListIterators.AbstractIndexBasedBigListIterator {
            SubListIterator(long index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final short get(long i) {
                return BigArrays.get(ShortBigArrayBigList.this.f3035a, SubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, short k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, short k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                SubList.this.removeShort(i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return SubList.this.f2889to - SubList.this.from;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                short[][] sArr = ShortBigArrayBigList.this.f3035a;
                long j = SubList.this.from;
                long j2 = this.pos;
                this.pos = j2 + 1;
                this.lastReturned = j2;
                return BigArrays.get((short[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            public short previousShort() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                short[][] sArr = ShortBigArrayBigList.this.f3035a;
                long j = SubList.this.from;
                long j2 = this.pos - 1;
                this.pos = j2;
                this.lastReturned = j2;
                return BigArrays.get((short[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v7, types: [short[][], it.unimi.dsi.fastutil.shorts.ShortConsumer] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(p014it.unimi.dsi.fastutil.shorts.ShortConsumer r14) {
                /*
                    r13 = this;
                    r0 = r13
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.SubList.this
                    long r0 = r0.f2889to
                    r1 = r13
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.SubList.this
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
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList r1 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.SubList.this
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r1 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                    short[][] r1 = r1.f3035a
                    r2 = r13
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList r2 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.SubList.this
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
                    short r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0010
                L_0x0047:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.SubList.SubListIterator.forEachRemaining(it.unimi.dsi.fastutil.shorts.ShortConsumer):void");
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.ShortSubList, p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
        public BigListIterator<Short> listIterator(long index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigArrayBigList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ShortBigSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(long pos, long maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final long getMaxPosFromBackingStore() {
                return SubList.this.f2889to;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.AbstractIndexBasedSpliterator
            protected final short get(long i) {
                return BigArrays.get(ShortBigArrayBigList.this.f3035a, i);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(long pos, long maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.AbstractIndexBasedSpliterator
            protected final long computeSplitPoint() {
                return BigArrays.nearestSegmentStart(computeSplitPoint(), this.pos + 1, getMaxPos() - 1);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(ShortConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                short[][] sArr = ShortBigArrayBigList.this.f3035a;
                long j = this.pos;
                this.pos = j + 1;
                action.accept(BigArrays.get(sArr, j));
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ShortConsumer action) {
                long max = getMaxPos();
                while (this.pos < max) {
                    short[][] sArr = ShortBigArrayBigList.this.f3035a;
                    long j = this.pos;
                    this.pos = j + 1;
                    action.accept(BigArrays.get(sArr, j));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList.ShortSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new SubListSpliterator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        /* JADX WARN: Type inference failed for: r0v10, types: [long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        boolean contentsEquals(short[][] r8, long r9, long r11) {
            /*
                r7 = this;
                r0 = r7
                it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                short[][] r0 = r0.f3035a
                r1 = r8
                if (r0 != r1) goto L_0x0020
                r0 = r7
                long r0 = r0.from
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r7
                long r0 = r0.f2889to
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
                long r0 = r0.f2889to
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
                it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                short[][] r0 = r0.f3035a
                r1 = r13
                short r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r1 = r8
                r2 = r15
                r3 = 1
                long r2 = r2 - r3
                r3 = r2; r3 = r0; 
                r15 = r3
                short r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                if (r0 == r1) goto L_0x0038
                r0 = 0
                return r0
            L_0x0063:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.SubList.contentsEquals(short[][], long, long):boolean");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof BigList)) {
                return false;
            }
            if (o instanceof ShortBigArrayBigList) {
                ShortBigArrayBigList other = (ShortBigArrayBigList) o;
                return contentsEquals(other.f3035a, 0, other.size64());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f2889to);
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
        int contentsCompareTo(short[][] r6, long r7, long r9) {
            /*
                r5 = this;
                r0 = r5
                it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                short[][] r0 = r0.f3035a
                r1 = r6
                if (r0 != r1) goto L_0x0020
                r0 = r5
                long r0 = r0.from
                r1 = r7
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r5
                long r0 = r0.f2889to
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
                long r1 = r1.f2889to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r14
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r0 = r5
                it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                short[][] r0 = r0.f3035a
                r1 = r14
                short r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r11 = r0
                r0 = r6
                r1 = r16
                short r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r12 = r0
                r0 = r11
                r1 = r12
                int r0 = java.lang.Short.compare(r0, r1)
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
                long r1 = r1.f2889to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x008a
                r0 = 1
                goto L_0x008b
            L_0x008a:
                r0 = 0
            L_0x008b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.SubList.contentsCompareTo(short[][], long, long):int");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList
        public int compareTo(BigList<? extends Short> l) {
            if (l instanceof ShortBigArrayBigList) {
                ShortBigArrayBigList other = (ShortBigArrayBigList) l;
                return contentsCompareTo(other.f3035a, 0, other.size64());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f2889to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    public BigList<Short> subList(long from, long to) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void getElements(long from, short[][] a, long offset, long length) {
        BigArrays.copy(this.f3035a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void getElements(long from, short[] a, int offset, int length) {
        BigArrays.copyFromBig(this.f3035a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void removeElements(long from, long to) {
        BigArrays.ensureFromTo(this.size, from, to);
        BigArrays.copy(this.f3035a, to, this.f3035a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void addElements(long index, short[][] a, long offset, long length) {
        ensureIndex(index);
        BigArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        BigArrays.copy(this.f3035a, index, this.f3035a, index + length, this.size - index);
        BigArrays.copy(a, offset, this.f3035a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void setElements(long index, short[][] a, long offset, long length) {
        BigArrays.copy(a, offset, this.f3035a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public void forEach(ShortConsumer action) {
        for (long i = 0; i < this.size; i++) {
            action.accept(BigArrays.get(this.f3035a, i));
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortBigListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList, p014it.unimi.dsi.fastutil.BigList
    public BigListIterator<Short> listIterator(final long index) {
        ensureIndex(index);
        return new ShortBigListIterator() { // from class: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.1
            long pos;
            long last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.pos < ShortBigArrayBigList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, short[][]] */
            /* JADX WARN: Type inference failed for: r3v1, types: [long, short[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public short nextShort() {
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
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                    short[][] r0 = r0.f3035a
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
                    short r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.C51751.nextShort():short");
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, short[][]] */
            /* JADX WARN: Type inference failed for: r3v2, types: [long, short[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public short previousShort() {
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
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                    short[][] r0 = r0.f3035a
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
                    short r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.C51751.previousShort():short");
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.pos;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
            public void add(short k) {
                ShortBigArrayBigList shortBigArrayBigList = ShortBigArrayBigList.this;
                long j = this.pos;
                this.pos = j + 1;
                shortBigArrayBigList.add(j, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
            public void set(short k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ShortBigArrayBigList.this.set(this.last, k);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ShortBigArrayBigList.this.removeShort(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$1 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v5, types: [long, short[][]] */
            /* JADX WARN: Type inference failed for: r4v1, types: [long, short[][]] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(p014it.unimi.dsi.fastutil.shorts.ShortConsumer r12) {
                /*
                    r11 = this;
                L_0x0000:
                    r0 = r11
                    long r0 = r0.pos
                    r1 = r11
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r1 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                    long r1 = r1.size
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0032
                    r0 = r12
                    r1 = r11
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r1 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
                    short[][] r1 = r1.f3035a
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
                    short r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0000
                L_0x0032:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.C51751.forEachRemaining(it.unimi.dsi.fastutil.shorts.ShortConsumer):void");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
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
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.C51751.back(long):long");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
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
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
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
                    it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList r1 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList.C51751.skip(long):long");
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigArrayBigList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigArrayBigList$Spliterator.class */
    public final class Spliterator implements ShortSpliterator {
        boolean hasSplit;
        long pos;
        long max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ShortBigArrayBigList.class.desiredAssertionStatus();
        }

        public Spliterator(ShortBigArrayBigList shortBigArrayBigList) {
            this(0, shortBigArrayBigList.size, false);
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
            return this.hasSplit ? this.max : ShortBigArrayBigList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getWorkingMax() - this.pos;
        }

        public boolean tryAdvance(ShortConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            short[][] sArr = ShortBigArrayBigList.this.f3035a;
            long j = this.pos;
            this.pos = j + 1;
            action.accept(BigArrays.get(sArr, j));
            return true;
        }

        public void forEachRemaining(ShortConsumer action) {
            long max = getWorkingMax();
            while (this.pos < max) {
                action.accept(BigArrays.get(ShortBigArrayBigList.this.f3035a, this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // java.lang.Object
    public ShortBigArrayBigList clone() {
        ShortBigArrayBigList c;
        if (getClass() == ShortBigArrayBigList.class) {
            c = new ShortBigArrayBigList(this.size);
            c.size = this.size;
        } else {
            try {
                c = (ShortBigArrayBigList) clone();
                c.f3035a = ShortBigArrays.newBigArray(this.size);
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e);
            }
        }
        BigArrays.copy(this.f3035a, 0L, c.f3035a, 0L, this.size);
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    public boolean equals(ShortBigArrayBigList l) {
        if (l == this) {
            return true;
        }
        char size64 = size64();
        if (size64 != l.size64()) {
            return false;
        }
        short[][] a1 = this.f3035a;
        short[][] a2 = l.f3035a;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof BigList)) {
            return false;
        }
        if (o instanceof ShortBigArrayBigList) {
            return equals((ShortBigArrayBigList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ShortBigArrayBigList l) {
        long s1 = size64();
        long s2 = l.size64();
        short[][] a1 = this.f3035a;
        short[][] a2 = l.f3035a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (((long) i) < s1 && ((long) i) < s2) {
            int r = Short.compare(BigArrays.get(a1, (long) i), BigArrays.get(a2, (long) i));
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList
    public int compareTo(BigList<? extends Short> l) {
        if (l instanceof ShortBigArrayBigList) {
            return compareTo((ShortBigArrayBigList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((BigList<? extends Short>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; ((long) i) < this.size; i++) {
            s.writeShort(BigArrays.get(this.f3035a, (long) i));
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f3035a = ShortBigArrays.newBigArray(this.size);
        for (int i = 0; ((long) i) < this.size; i++) {
            BigArrays.set(this.f3035a, (long) i, s.readShort());
        }
    }
}
