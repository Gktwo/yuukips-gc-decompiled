package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.stream.Collector;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.BigList;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList;
import p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators;
import p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrayBigList.class */
public class ObjectBigArrayBigList<K> extends AbstractObjectBigList<K> implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353131L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    protected final boolean wrapped;

    /* renamed from: a */
    protected transient K[][] f2658a;
    protected long size;
    private static final Collector<Object, ?, ObjectBigArrayBigList<Object>> TO_LIST_COLLECTOR;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((BigList) ((BigList) obj));
    }

    static {
        $assertionsDisabled = !ObjectBigArrayBigList.class.desiredAssertionStatus();
        TO_LIST_COLLECTOR = Collector.of(ObjectBigArrayBigList::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, new Collector.Characteristics[0]);
    }

    protected ObjectBigArrayBigList(K[][] a, boolean dummy) {
        this.f2658a = a;
        this.wrapped = true;
    }

    public ObjectBigArrayBigList(long capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        }
        if (capacity == 0) {
            this.f2658a = (K[][]) ObjectBigArrays.EMPTY_BIG_ARRAY;
        } else {
            this.f2658a = (K[][]) ObjectBigArrays.newBigArray(capacity);
        }
        this.wrapped = false;
    }

    public ObjectBigArrayBigList() {
        this.f2658a = (K[][]) ObjectBigArrays.DEFAULT_EMPTY_BIG_ARRAY;
        this.wrapped = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectBigArrayBigList(ObjectCollection<? extends K> c) {
        this(Size64.sizeOf(c));
        if (c instanceof ObjectBigList) {
            K[][] kArr = this.f2658a;
            long sizeOf = Size64.sizeOf(c);
            this.size = sizeOf;
            ((ObjectBigList) c).getElements(0, kArr, 0, sizeOf);
            return;
        }
        ObjectIterator<? extends K> i = c.iterator();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectBigArrayBigList(Collection<? extends K> c) {
        this(Size64.sizeOf(c));
        if (c instanceof ObjectBigList) {
            K[][] kArr = this.f2658a;
            long sizeOf = Size64.sizeOf(c);
            this.size = sizeOf;
            ((ObjectBigList) c).getElements(0, kArr, 0, sizeOf);
            return;
        }
        Iterator<? extends K> i = c.iterator();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public ObjectBigArrayBigList(ObjectBigList<? extends K> l) {
        this(l.size64());
        K[][] kArr = this.f2658a;
        long size64 = l.size64();
        this.size = size64;
        l.getElements(0, kArr, 0, size64);
    }

    public ObjectBigArrayBigList(K[][] a) {
        this(a, 0, BigArrays.length(a));
    }

    public ObjectBigArrayBigList(K[][] a, long offset, long length) {
        this(length);
        BigArrays.copy(a, offset, this.f2658a, 0, length);
        this.size = length;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectBigArrayBigList(Iterator<? extends K> i) {
        this();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectBigArrayBigList(ObjectIterator<? extends K> i) {
        this();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public K[][] elements() {
        return this.f2658a;
    }

    public static <K> ObjectBigArrayBigList<K> wrap(K[][] a, long length) {
        if (length > BigArrays.length(a)) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + BigArrays.length(a) + ")");
        }
        ObjectBigArrayBigList<K> l = new ObjectBigArrayBigList<>(a, false);
        l.size = length;
        return l;
    }

    public static <K> ObjectBigArrayBigList<K> wrap(K[][] a) {
        return wrap(a, BigArrays.length(a));
    }

    /* renamed from: of */
    public static <K> ObjectBigArrayBigList<K> m580of() {
        return new ObjectBigArrayBigList<>();
    }

    @SafeVarargs
    /* renamed from: of */
    public static <K> ObjectBigArrayBigList<K> m579of(K... init) {
        return wrap(BigArrays.wrap(init));
    }

    private ObjectBigArrayBigList<K> combine(ObjectBigArrayBigList<? extends K> toAddFrom) {
        addAll((ObjectBigList) toAddFrom);
        return this;
    }

    public static <K> Collector<K, ?, ObjectBigArrayBigList<K>> toBigList() {
        return (Collector<K, ?, ObjectBigArrayBigList<K>>) TO_LIST_COLLECTOR;
    }

    public static <K> Collector<K, ?, ObjectBigArrayBigList<K>> toBigListWithExpectedSize(long expectedSize) {
        return Collector.of(() -> {
            return new ObjectBigArrayBigList(expectedSize);
        }, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, new Collector.Characteristics[0]);
    }

    public void ensureCapacity(long capacity) {
        if (capacity > BigArrays.length(this.f2658a) && this.f2658a != ObjectBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
            if (this.wrapped) {
                this.f2658a = (K[][]) BigArrays.forceCapacity(this.f2658a, capacity, this.size);
            } else if (capacity > BigArrays.length(this.f2658a)) {
                K[][] kArr = (K[][]) ObjectBigArrays.newBigArray(capacity);
                BigArrays.copy(this.f2658a, 0, kArr, 0, this.size);
                this.f2658a = kArr;
            }
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f2658a)) {
                throw new AssertionError();
            }
        }
    }

    private void grow(long capacity) {
        long oldLength = BigArrays.length(this.f2658a);
        if (capacity > oldLength) {
            if (this.f2658a != ObjectBigArrays.DEFAULT_EMPTY_BIG_ARRAY) {
                capacity = Math.max(oldLength + (oldLength >> 1), capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            if (this.wrapped) {
                this.f2658a = (K[][]) BigArrays.forceCapacity(this.f2658a, capacity, this.size);
            } else {
                K[][] kArr = (K[][]) ObjectBigArrays.newBigArray(capacity);
                BigArrays.copy(this.f2658a, 0, kArr, 0, this.size);
                this.f2658a = kArr;
            }
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f2658a)) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public void add(long index, K k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            BigArrays.copy(this.f2658a, index, this.f2658a, index + 1, this.size - index);
        }
        BigArrays.set(this.f2658a, index, k);
        this.size++;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f2658a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, java.util.AbstractCollection, java.util.Collection
    public boolean add(K k) {
        grow(this.size + 1);
        K[][] kArr = this.f2658a;
        long j = this.size;
        this.size = j + 1;
        BigArrays.set(kArr, j, k);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2658a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.BigList
    public K get(long index) {
        if (index < this.size) {
            return (K) BigArrays.get(this.f2658a, index);
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public long indexOf(Object k) {
        for (long i = 0; i < this.size; i++) {
            if (Objects.equals(k, BigArrays.get(this.f2658a, i))) {
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
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.BigList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastIndexOf(java.lang.Object r8) {
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
            if (r0 == 0) goto L_0x0020
            r0 = r8
            r1 = r7
            K[][] r1 = r1.f2658a
            r2 = r9
            java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 == 0) goto L_0x0005
            r0 = r9
            return r0
        L_0x0020:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.lastIndexOf(java.lang.Object):long");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public K remove(long index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        K old = (K) BigArrays.get(this.f2658a, index);
        this.size--;
        if (index != this.size) {
            BigArrays.copy(this.f2658a, index + 1, this.f2658a, index, this.size - index);
        }
        BigArrays.set(this.f2658a, this.size, (Object) null);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2658a)) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object k) {
        long index = indexOf(k);
        if (index == -1) {
            return false;
        }
        remove(index);
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2658a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public K set(long index, K k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        K old = (K) BigArrays.get(this.f2658a, index);
        BigArrays.set(this.f2658a, index, k);
        return old;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        K[] s = null;
        K[] d = null;
        int ss = -1;
        int sd = 134217728;
        int ds = -1;
        int dd = 134217728;
        for (long i = 0; i < this.size; i++) {
            if (sd == 134217728) {
                sd = 0;
                ss++;
                s = this.f2658a[ss];
            }
            if (!c.contains(s[sd])) {
                if (dd == 134217728) {
                    ds++;
                    d = this.f2658a[ds];
                    dd = 0;
                }
                dd++;
                d[dd] = s[sd];
            }
            sd++;
        }
        long j = BigArrays.index(ds, dd);
        BigArrays.fill(this.f2658a, j, this.size, (Object) null);
        boolean modified = this.size != j;
        this.size = j;
        return modified;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public boolean addAll(long index, Collection<? extends K> c) {
        if (c instanceof ObjectList) {
            return addAll(index, (ObjectList) ((ObjectList) c));
        }
        if (c instanceof ObjectBigList) {
            return addAll(index, (ObjectBigList) ((ObjectBigList) c));
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f2658a, index, this.f2658a, index + ((long) n), this.size - index);
        Iterator<? extends K> i = c.iterator();
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2658a)) {
            while (true) {
                n--;
                if (n == 0) {
                    return true;
                }
                index++;
                BigArrays.set(this.f2658a, index, i.next());
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigList
    public boolean addAll(long index, ObjectBigList<? extends K> list) {
        ensureIndex(index);
        long n = list.size64();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        BigArrays.copy(this.f2658a, index, this.f2658a, index + n, this.size - index);
        list.getElements(0, this.f2658a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2658a)) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigList
    public boolean addAll(long index, ObjectList<? extends K> list) {
        ensureIndex(index);
        int n = list.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + ((long) n));
        BigArrays.copy(this.f2658a, index, this.f2658a, index + ((long) n), this.size - index);
        this.size += (long) n;
        if ($assertionsDisabled || this.size <= BigArrays.length(this.f2658a)) {
            int segment = BigArrays.segment(index);
            int displ = BigArrays.displacement(index);
            int pos = 0;
            while (n > 0) {
                int l = Math.min(this.f2658a[segment].length - displ, n);
                list.getElements(pos, this.f2658a[segment], displ, l);
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        BigArrays.fill(this.f2658a, 0, this.size, (Object) null);
        this.size = 0;
        if (!$assertionsDisabled && this.size > BigArrays.length(this.f2658a)) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public void size(long size) {
        if (size > BigArrays.length(this.f2658a)) {
            this.f2658a = (K[][]) BigArrays.forceCapacity(this.f2658a, size, this.size);
        }
        if (size > this.size) {
            BigArrays.fill(this.f2658a, this.size, size, (Object) null);
        } else {
            BigArrays.fill(this.f2658a, size, this.size, (Object) null);
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
        long arrayLength = BigArrays.length(this.f2658a);
        if (n < arrayLength && this.size != arrayLength) {
            this.f2658a = (K[][]) BigArrays.trim(this.f2658a, Math.max(n, this.size));
            if (!$assertionsDisabled && this.size > BigArrays.length(this.f2658a)) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrayBigList$SubList.class */
    public class SubList extends AbstractObjectBigList.ObjectRandomAccessSubList<K> {
        private static final long serialVersionUID = -3185226345314976296L;

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList.ObjectSubList, p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((BigList) ((BigList) obj));
        }

        protected SubList(long from, long to) {
            super(ObjectBigArrayBigList.this, from, to);
        }

        private K[][] getParentArray() {
            return ObjectBigArrayBigList.this.f2658a;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList.ObjectSubList, p014it.unimi.dsi.fastutil.BigList
        public K get(long i) {
            ensureRestrictedIndex(i);
            return (K) BigArrays.get(ObjectBigArrayBigList.this.f2658a, i + this.from);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrayBigList$SubList$SubListIterator.class */
        public final class SubListIterator extends ObjectBigListIterators.AbstractIndexBasedBigListIterator<K> {
            SubListIterator(long index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final K get(long i) {
                return (K) BigArrays.get(ObjectBigArrayBigList.this.f2658a, SubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator
            protected final void add(long i, K k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator
            protected final void set(long i, K k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final void remove(long i) {
                SubList.this.remove(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator
            protected final long getMaxPos() {
                return SubList.this.f2454to - SubList.this.from;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator, java.util.Iterator
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K[][] kArr = ObjectBigArrayBigList.this.f2658a;
                long j = SubList.this.from;
                long j2 = this.pos;
                this.pos = j2 + 1;
                this.lastReturned = j2;
                return (K) BigArrays.get((Object[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                K[][] kArr = ObjectBigArrayBigList.this.f2658a;
                long j = SubList.this.from;
                long j2 = this.pos - 1;
                this.pos = j2;
                this.lastReturned = j2;
                return (K) BigArrays.get((Object[][]) this, j2 + j);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList$SubListIterator */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v7, types: [java.util.function.Consumer, K[][]] */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator, java.util.Iterator
            public void forEachRemaining(Consumer<? super K> action) {
                long max = SubList.this.f2454to - SubList.this.from;
                while (this.pos < max) {
                    long j = SubList.this.from;
                    long j2 = this.pos;
                    this.pos = j2 + 1;
                    this.lastReturned = j2;
                    ObjectBigArrayBigList.this.f2658a.accept(BigArrays.get((Object[][]) this, j2 + j));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList.ObjectSubList, p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
        public ObjectBigListIterator<K> listIterator(long index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrayBigList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ObjectBigSpliterators.LateBindingSizeIndexBasedSpliterator<K> {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(long pos, long maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final long getMaxPosFromBackingStore() {
                return SubList.this.f2454to;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.AbstractIndexBasedSpliterator
            protected final K get(long i) {
                return (K) BigArrays.get(ObjectBigArrayBigList.this.f2658a, i);
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.AbstractIndexBasedSpliterator
            public final ObjectBigArrayBigList<K>.SubList.SubListSpliterator makeForSplit(long pos, long maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.AbstractIndexBasedSpliterator
            protected final long computeSplitPoint() {
                return BigArrays.nearestSegmentStart(computeSplitPoint(), this.pos + 1, getMaxPos() - 1);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public boolean tryAdvance(Consumer<? super K> action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                K[][] kArr = ObjectBigArrayBigList.this.f2658a;
                long j = this.pos;
                this.pos = j + 1;
                action.accept((Object) BigArrays.get(kArr, j));
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                long max = getMaxPos();
                while (this.pos < max) {
                    K[][] kArr = ObjectBigArrayBigList.this.f2658a;
                    long j = this.pos;
                    this.pos = j + 1;
                    action.accept((Object) BigArrays.get(kArr, j));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList.ObjectSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new SubListSpliterator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        /* JADX WARN: Type inference failed for: r0v10, types: [long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        boolean contentsEquals(K[][] r8, long r9, long r11) {
            /*
                r7 = this;
                r0 = r7
                it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
                K[][] r0 = r0.f2658a
                r1 = r8
                if (r0 != r1) goto L_0x0020
                r0 = r7
                long r0 = r0.from
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0020
                r0 = r7
                long r0 = r0.f2454to
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
                long r0 = r0.f2454to
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
                if (r0 < 0) goto L_0x0066
                r0 = r7
                it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
                K[][] r0 = r0.f2658a
                r1 = r13
                java.lang.Object r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r1 = r8
                r2 = r15
                r3 = 1
                long r2 = r2 - r3
                r3 = r2; r3 = r0; 
                r15 = r3
                java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                boolean r0 = java.util.Objects.equals(r0, r1)
                if (r0 != 0) goto L_0x0038
                r0 = 0
                return r0
            L_0x0066:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.SubList.contentsEquals(java.lang.Object[][], long, long):boolean");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, java.util.Collection, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof BigList)) {
                return false;
            }
            if (o instanceof ObjectBigArrayBigList) {
                ObjectBigArrayBigList<K> other = (ObjectBigArrayBigList) o;
                return contentsEquals(other.f2658a, 0, other.size64());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                ObjectBigArrayBigList<K>.SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f2454to);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [long] */
        /* JADX WARN: Type inference failed for: r0v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [long] */
        /* JADX WARN: Type inference failed for: r0v26, types: [long] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        int contentsCompareTo(K[][] r6, long r7, long r9) {
            /*
                r5 = this;
                r0 = r5
                long r0 = r0.from
                r14 = r0
                r0 = r7
                r16 = r0
            L_0x0009:
                r0 = r14
                r1 = r5
                long r1 = r1.f2454to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0055
                r0 = r14
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0055
                r0 = r5
                it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
                K[][] r0 = r0.f2658a
                r1 = r14
                java.lang.Object r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r11 = r0
                r0 = r6
                r1 = r16
                java.lang.Object r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r12 = r0
                r0 = r11
                java.lang.Comparable r0 = (java.lang.Comparable) r0
                r1 = r12
                int r0 = r0.compareTo(r1)
                r1 = r0
                r13 = r1
                if (r0 == 0) goto L_0x0046
                r0 = r13
                return r0
            L_0x0046:
                r0 = r14
                r1 = 1
                long r0 = r0 + r1
                r14 = r0
                r0 = r16
                r1 = 1
                long r0 = r0 + r1
                r16 = r0
                goto L_0x0009
            L_0x0055:
                r0 = r14
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0061
                r0 = -1
                goto L_0x0070
            L_0x0061:
                r0 = r14
                r1 = r5
                long r1 = r1.f2454to
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x006f
                r0 = 1
                goto L_0x0070
            L_0x006f:
                r0 = 0
            L_0x0070:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.SubList.contentsCompareTo(java.lang.Object[][], long, long):int");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$SubList */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList
        public int compareTo(BigList<? extends K> l) {
            if (l instanceof ObjectBigArrayBigList) {
                ObjectBigArrayBigList<K> other = (ObjectBigArrayBigList) l;
                return contentsCompareTo(other.f2658a, 0, other.size64());
            } else if (!(l instanceof SubList)) {
                return compareTo((BigList) l);
            } else {
                ObjectBigArrayBigList<K>.SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f2454to);
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigList<K> subList(long from, long to) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList
    public void getElements(long from, Object[][] a, long offset, long length) {
        BigArrays.copy(this.f2658a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigList
    public void getElements(long from, Object[] a, int offset, int length) {
        BigArrays.copyFromBig(this.f2658a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList
    public void removeElements(long from, long to) {
        BigArrays.ensureFromTo(this.size, from, to);
        BigArrays.copy(this.f2658a, to, this.f2658a, from, this.size - to);
        this.size -= to - from;
        BigArrays.fill(this.f2658a, this.size, (this.size + to) - from, (Object) null);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList
    public void addElements(long index, K[][] a, long offset, long length) {
        ensureIndex(index);
        BigArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        BigArrays.copy(this.f2658a, index, this.f2658a, index + length, this.size - index);
        BigArrays.copy(a, offset, this.f2658a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList
    public void setElements(long index, Object[][] a, long offset, long length) {
        BigArrays.copy(a, offset, this.f2658a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        for (long i = 0; i < this.size; i++) {
            action.accept((Object) BigArrays.get(this.f2658a, i));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, p014it.unimi.dsi.fastutil.objects.ObjectBigList, p014it.unimi.dsi.fastutil.BigList
    public ObjectBigListIterator<K> listIterator(final long index) {
        ensureIndex(index);
        return new ObjectBigListIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.1
            long pos;
            long last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.pos < ObjectBigArrayBigList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, K[][]] */
            /* JADX WARN: Type inference failed for: r3v1, types: [long, java.lang.Object[][]] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // java.util.Iterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public K next() {
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
                    it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
                    K[][] r0 = r0.f2658a
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
                    java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.C48461.next():java.lang.Object");
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [long, K[][]] */
            /* JADX WARN: Type inference failed for: r3v2, types: [long, java.lang.Object[][]] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public K previous() {
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
                    it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
                    K[][] r0 = r0.f2658a
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
                    java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.C48461.previous():java.lang.Object");
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long nextIndex() {
                return this.pos;
            }

            @Override // p014it.unimi.dsi.fastutil.BigListIterator
            public long previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
            public void add(K k) {
                ObjectBigArrayBigList objectBigArrayBigList = ObjectBigArrayBigList.this;
                long j = this.pos;
                this.pos = j + 1;
                objectBigArrayBigList.add(j, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
            public void set(K k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ObjectBigArrayBigList.this.set(this.last, k);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ObjectBigArrayBigList.this.remove(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$1 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v5, types: [long, K[][]] */
            /* JADX WARN: Type inference failed for: r4v1, types: [long, java.lang.Object[][]] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // java.util.Iterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void forEachRemaining(java.util.function.Consumer<? super K> r12) {
                /*
                    r11 = this;
                L_0x0000:
                    r0 = r11
                    long r0 = r0.pos
                    r1 = r11
                    it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r1 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
                    long r1 = r1.size
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0032
                    r0 = r12
                    r1 = r11
                    it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r1 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
                    K[][] r1 = r1.f2658a
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
                    java.lang.Object r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
                    r1.accept(r2)
                    goto L_0x0000
                L_0x0032:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.C48461.forEachRemaining(java.util.function.Consumer):void");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
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
                    it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.C48461.back(long):long");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v5, types: [long] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v4 */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
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
                    it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
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
                    it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList r1 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.this
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
                throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList.C48461.skip(long):long");
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrayBigList$Spliterator.class */
    public final class Spliterator implements ObjectSpliterator<K> {
        boolean hasSplit;
        long pos;
        long max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ObjectBigArrayBigList.class.desiredAssertionStatus();
        }

        public Spliterator(ObjectBigArrayBigList objectBigArrayBigList) {
            this(0, objectBigArrayBigList.size, false);
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
            return this.hasSplit ? this.max : ObjectBigArrayBigList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return ObjectSpliterators.LIST_SPLITERATOR_CHARACTERISTICS;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getWorkingMax() - this.pos;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            K[][] kArr = ObjectBigArrayBigList.this.f2658a;
            long j = this.pos;
            this.pos = j + 1;
            action.accept((Object) BigArrays.get(kArr, j));
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            long max = getWorkingMax();
            while (this.pos < max) {
                action.accept((Object) BigArrays.get(ObjectBigArrayBigList.this.f2658a, this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return new Spliterator(this);
    }

    @Override // java.lang.Object
    public ObjectBigArrayBigList<K> clone() {
        ObjectBigArrayBigList<K> c;
        if (getClass() == ObjectBigArrayBigList.class) {
            c = new ObjectBigArrayBigList<>(this.size);
            c.size = this.size;
        } else {
            try {
                c = (ObjectBigArrayBigList) clone();
                c.f2658a = (K[][]) ObjectBigArrays.newBigArray(this.size);
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e);
            }
        }
        BigArrays.copy(this.f2658a, 0, c.f2658a, 0, this.size);
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    public boolean equals(ObjectBigArrayBigList<K> l) {
        if (l == this) {
            return true;
        }
        char size64 = size64();
        if (size64 != l.size64()) {
            return false;
        }
        K[][] a1 = this.f2658a;
        K[][] a2 = l.f2658a;
        if (a1 == a2) {
            return true;
        }
        do {
            size64--;
            if (size64 == 0) {
                return true;
            }
        } while (Objects.equals(BigArrays.get(a1, size64), BigArrays.get(a2, size64)));
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList, java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof BigList)) {
            return false;
        }
        if (o instanceof ObjectBigArrayBigList) {
            return equals((ObjectBigArrayBigList) ((ObjectBigArrayBigList) o));
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ObjectBigArrayBigList<? extends K> l) {
        long s1 = size64();
        long s2 = l.size64();
        K[][] a1 = this.f2658a;
        Object[][] objArr = l.f2658a;
        int i = 0;
        while (((long) i) < s1 && ((long) i) < s2) {
            int r = ((Comparable) BigArrays.get(a1, (long) i)).compareTo(BigArrays.get(objArr, (long) i));
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectBigList
    public int compareTo(BigList<? extends K> l) {
        if (l instanceof ObjectBigArrayBigList) {
            return compareTo((ObjectBigArrayBigList) ((ObjectBigArrayBigList) l));
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((BigList) this);
        }
        return compareTo((BigList) l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; ((long) i) < this.size; i++) {
            s.writeObject(BigArrays.get(this.f2658a, (long) i));
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2658a = (K[][]) ObjectBigArrays.newBigArray(this.size);
        for (int i = 0; ((long) i) < this.size; i++) {
            BigArrays.set(this.f2658a, (long) i, s.readObject());
        }
    }
}
