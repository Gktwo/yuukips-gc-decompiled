package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.stream.Collector;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectList;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;
import p014it.unimi.dsi.fastutil.objects.ObjectIterators;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrayList.class */
public class ObjectArrayList<K> extends AbstractObjectList<K> implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353131L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    protected final boolean wrapped;

    /* renamed from: a */
    protected transient K[] f2682a;
    protected int size;
    private static final Collector<Object, ?, ObjectArrayList<Object>> TO_LIST_COLLECTOR;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) ((List) obj));
    }

    static {
        $assertionsDisabled = !ObjectArrayList.class.desiredAssertionStatus();
        TO_LIST_COLLECTOR = Collector.of(ObjectArrayList::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, new Collector.Characteristics[0]);
    }

    private static final <K> K[] copyArraySafe(K[] a, int length) {
        return length == 0 ? (K[]) ObjectArrays.EMPTY_ARRAY : (K[]) Arrays.copyOf(a, length, Object[].class);
    }

    private static final <K> K[] copyArrayFromSafe(ObjectArrayList<K> l) {
        return (K[]) copyArraySafe(l.f2682a, l.size);
    }

    protected ObjectArrayList(K[] a, boolean wrapped) {
        this.f2682a = a;
        this.wrapped = wrapped;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f2682a = (K[]) ObjectArrays.EMPTY_ARRAY;
        } else {
            this.f2682a = (K[]) new Object[capacity];
        }
    }

    public ObjectArrayList(int capacity) {
        initArrayFromCapacity(capacity);
        this.wrapped = false;
    }

    public ObjectArrayList() {
        this.f2682a = (K[]) ObjectArrays.DEFAULT_EMPTY_ARRAY;
        this.wrapped = false;
    }

    public ObjectArrayList(Collection<? extends K> c) {
        if (c instanceof ObjectArrayList) {
            this.f2682a = (K[]) copyArrayFromSafe((ObjectArrayList) c);
            this.size = this.f2682a.length;
        } else {
            initArrayFromCapacity(c.size());
            if (c instanceof ObjectList) {
                K[] kArr = this.f2682a;
                int size = c.size();
                this.size = size;
                ((ObjectList) c).getElements(0, kArr, 0, size);
            } else {
                this.size = ObjectIterators.unwrap(c.iterator(), this.f2682a);
            }
        }
        this.wrapped = false;
    }

    public ObjectArrayList(ObjectCollection<? extends K> c) {
        if (c instanceof ObjectArrayList) {
            this.f2682a = (K[]) copyArrayFromSafe((ObjectArrayList) c);
            this.size = this.f2682a.length;
        } else {
            initArrayFromCapacity(c.size());
            if (c instanceof ObjectList) {
                K[] kArr = this.f2682a;
                int size = c.size();
                this.size = size;
                ((ObjectList) c).getElements(0, kArr, 0, size);
            } else {
                this.size = ObjectIterators.unwrap(c.iterator(), this.f2682a);
            }
        }
        this.wrapped = false;
    }

    public ObjectArrayList(ObjectList<? extends K> l) {
        if (l instanceof ObjectArrayList) {
            this.f2682a = (K[]) copyArrayFromSafe((ObjectArrayList) l);
            this.size = this.f2682a.length;
        } else {
            initArrayFromCapacity(l.size());
            K[] kArr = this.f2682a;
            int size = l.size();
            this.size = size;
            l.getElements(0, kArr, 0, size);
        }
        this.wrapped = false;
    }

    public ObjectArrayList(K[] a) {
        this(a, 0, a.length);
    }

    public ObjectArrayList(K[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f2682a, 0, length);
        this.size = length;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectArrayList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectArrayList(Iterator<? extends K> i) {
        this();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectArrayList<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectArrayList(ObjectIterator<? extends K> i) {
        this();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public K[] elements() {
        return this.f2682a;
    }

    public static <K> ObjectArrayList<K> wrap(K[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        ObjectArrayList<K> l = new ObjectArrayList<>(a, true);
        l.size = length;
        return l;
    }

    public static <K> ObjectArrayList<K> wrap(K[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static <K> ObjectArrayList<K> m585of() {
        return new ObjectArrayList<>();
    }

    @SafeVarargs
    /* renamed from: of */
    public static <K> ObjectArrayList<K> m584of(K... init) {
        return wrap(init);
    }

    /* access modifiers changed from: package-private */
    public ObjectArrayList<K> combine(ObjectArrayList<? extends K> toAddFrom) {
        addAll((ObjectList) toAddFrom);
        return this;
    }

    public static <K> Collector<K, ?, ObjectArrayList<K>> toList() {
        return (Collector<K, ?, ObjectArrayList<K>>) TO_LIST_COLLECTOR;
    }

    public static <K> Collector<K, ?, ObjectArrayList<K>> toListWithExpectedSize(int expectedSize) {
        if (expectedSize <= 10) {
            return toList();
        }
        return Collector.of(new ObjectCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 10 ? new ObjectArrayList() : new ObjectArrayList(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, new Collector.Characteristics[0]);
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f2682a.length) {
            return;
        }
        if (this.f2682a != ObjectArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            if (this.wrapped) {
                this.f2682a = (K[]) ObjectArrays.ensureCapacity(this.f2682a, capacity, this.size);
            } else if (capacity > this.f2682a.length) {
                K[] kArr = (K[]) new Object[capacity];
                System.arraycopy(this.f2682a, 0, kArr, 0, this.size);
                this.f2682a = kArr;
            }
            if (!$assertionsDisabled && this.size > this.f2682a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f2682a.length) {
            if (this.f2682a != ObjectArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f2682a.length) + ((long) (this.f2682a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            if (this.wrapped) {
                this.f2682a = (K[]) ObjectArrays.forceCapacity(this.f2682a, capacity, this.size);
            } else {
                K[] kArr = (K[]) new Object[capacity];
                System.arraycopy(this.f2682a, 0, kArr, 0, this.size);
                this.f2682a = kArr;
            }
            if (!$assertionsDisabled && this.size > this.f2682a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public void add(int index, K k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f2682a, index, this.f2682a, index + 1, this.size - index);
        }
        this.f2682a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f2682a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(K k) {
        grow(this.size + 1);
        K[] kArr = this.f2682a;
        int i = this.size;
        this.size = i + 1;
        kArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f2682a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // java.util.List
    public K get(int index) {
        if (index < this.size) {
            return this.f2682a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public int indexOf(Object k) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(k, this.f2682a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public int lastIndexOf(Object k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (!Objects.equals(k, this.f2682a[i]));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public K remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        K old = this.f2682a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f2682a, index + 1, this.f2682a, index, this.size - index);
        }
        this.f2682a[this.size] = null;
        if ($assertionsDisabled || this.size <= this.f2682a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        remove(index);
        if ($assertionsDisabled || this.size <= this.f2682a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public K set(int index, K k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        K old = this.f2682a[index];
        this.f2682a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        Arrays.fill(this.f2682a, 0, this.size, (Object) null);
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f2682a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList
    public void size(int size) {
        if (size > this.f2682a.length) {
            this.f2682a = (K[]) ObjectArrays.forceCapacity(this.f2682a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f2682a, this.size, size, (Object) null);
        } else {
            Arrays.fill(this.f2682a, size, this.size, (Object) null);
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
        if (n < this.f2682a.length && this.size != this.f2682a.length) {
            K[] t = (K[]) new Object[Math.max(n, this.size)];
            System.arraycopy(this.f2682a, 0, t, 0, this.size);
            this.f2682a = t;
            if (!$assertionsDisabled && this.size > this.f2682a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrayList$SubList.class */
    public class SubList extends AbstractObjectList.ObjectRandomAccessSubList<K> {
        private static final long serialVersionUID = -3185226345314976296L;

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList.ObjectSubList, p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((List) ((List) obj));
        }

        protected SubList(int from, int to) {
            super(ObjectArrayList.this, from, to);
        }

        private K[] getParentArray() {
            return ObjectArrayList.this.f2682a;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList.ObjectSubList, java.util.List
        public K get(int i) {
            ensureRestrictedIndex(i);
            return ObjectArrayList.this.f2682a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends ObjectIterators.AbstractIndexBasedListIterator<K> {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final K get(int i) {
                return ObjectArrayList.this.f2682a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator
            protected final void add(int i, K k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator
            protected final void set(int i, K k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.remove(i);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f2493to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator, java.util.Iterator, java.util.ListIterator
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K[] kArr = ObjectArrayList.this.f2682a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return kArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                K[] kArr = ObjectArrayList.this.f2682a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return kArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterators.AbstractIndexBasedIterator, java.util.Iterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = SubList.this.f2493to - SubList.this.from;
                while (this.pos < max) {
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept((Object) ObjectArrayList.this.f2682a[i + i2]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList.ObjectSubList, p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
        public ObjectListIterator<K> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ObjectSpliterators.LateBindingSizeIndexBasedSpliterator<K> {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f2493to;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            protected final K get(int i) {
                return ObjectArrayList.this.f2682a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final ObjectArrayList<K>.SubList.SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public boolean tryAdvance(Consumer<? super K> action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                int i = this.pos;
                this.pos = i + 1;
                action.accept((Object) ObjectArrayList.this.f2682a[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept((Object) ObjectArrayList.this.f2682a[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList.ObjectSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(K[] otherA, int otherAFrom, int otherATo) {
            if (ObjectArrayList.this.f2682a == otherA && this.from == otherAFrom && this.f2493to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f2493to) {
                pos++;
                otherPos++;
                if (!Objects.equals(ObjectArrayList.this.f2682a[pos], otherA[otherPos])) {
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectArrayList$SubList */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof ObjectArrayList) {
                ObjectArrayList<K> other = (ObjectArrayList) o;
                return contentsEquals(other.f2682a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                ObjectArrayList<K>.SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f2493to);
            }
        }

        int contentsCompareTo(K[] otherA, int otherAFrom, int otherATo) {
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f2493to && i < otherATo) {
                int r = ((Comparable) ObjectArrayList.this.f2682a[i]).compareTo(otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f2493to ? 1 : 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectArrayList$SubList */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList
        public int compareTo(List<? extends K> l) {
            if (l instanceof ObjectArrayList) {
                ObjectArrayList<K> other = (ObjectArrayList) l;
                return contentsCompareTo(other.f2682a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo((List) l);
            } else {
                ObjectArrayList<K>.SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f2493to);
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectList<K> subList(int from, int to) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList
    public void getElements(int from, Object[] a, int offset, int length) {
        ObjectArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f2682a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f2682a, to, this.f2682a, from, this.size - to);
        this.size -= to - from;
        int i = to - from;
        while (true) {
            i--;
            if (i != 0) {
                this.f2682a[this.size + i] = null;
            } else {
                return;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList
    public void addElements(int index, K[] a, int offset, int length) {
        ensureIndex(index);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f2682a, index, this.f2682a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f2682a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList
    public void setElements(int index, K[] a, int offset, int length) {
        ensureIndex(index);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f2682a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        for (int i = 0; i < this.size; i++) {
            action.accept((Object) this.f2682a[i]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: K[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public boolean addAll(int index, Collection<? extends K> c) {
        if (c instanceof ObjectList) {
            return addAll(index, (ObjectList) ((ObjectList) c));
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f2682a, index, this.f2682a, index + n, this.size - index);
        Iterator<? extends K> i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f2682a[index] = i.next();
        }
        if ($assertionsDisabled || this.size <= this.f2682a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectList
    public boolean addAll(int index, ObjectList<? extends K> l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f2682a, index, this.f2682a, index + n, this.size - index);
        l.getElements(0, this.f2682a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f2682a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> c) {
        Object[] a = this.f2682a;
        int j = 0;
        for (int i = 0; i < this.size; i++) {
            if (!c.contains(a[i])) {
                j++;
                a[j] = a[i];
            }
        }
        Arrays.fill(a, j, this.size, (Object) null);
        boolean modified = this.size != j;
        this.size = j;
        return modified;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return Arrays.copyOf(this.f2682a, size(), Object[].class);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <K> K[] toArray(K[] a) {
        if (a == null) {
            a = (K[]) new Object[size()];
        } else if (a.length < size()) {
            a = (K[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), size()));
        }
        System.arraycopy(this.f2682a, 0, a, 0, size());
        if (a.length > size()) {
            a[size()] = null;
        }
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectListIterator<K> listIterator(final int index) {
        ensureIndex(index);
        return new ObjectListIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.ObjectArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < ObjectArrayList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K[] kArr = ObjectArrayList.this.f2682a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return kArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                K[] kArr = ObjectArrayList.this.f2682a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
                return kArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void add(K k) {
                ObjectArrayList objectArrayList = ObjectArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                objectArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void set(K k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ObjectArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ObjectArrayList.this.remove(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super K> action) {
                while (this.pos < ObjectArrayList.this.size) {
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept((Object) ObjectArrayList.this.f2682a[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ObjectArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ObjectArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = ObjectArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrayList$Spliterator.class */
    public final class Spliterator implements ObjectSpliterator<K> {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ObjectArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(ObjectArrayList objectArrayList) {
            this(0, objectArrayList.size, false);
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
            return this.hasSplit ? this.max : ObjectArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return ObjectSpliterators.LIST_SPLITERATOR_CHARACTERISTICS;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            int i = this.pos;
            this.pos = i + 1;
            action.accept((Object) ObjectArrayList.this.f2682a[i]);
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept((Object) ObjectArrayList.this.f2682a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public void sort(Comparator<? super K> comp) {
        if (comp == null) {
            ObjectArrays.stableSort(this.f2682a, 0, this.size);
        } else {
            ObjectArrays.stableSort(this.f2682a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectList
    public void unstableSort(Comparator<? super K> comp) {
        if (comp == null) {
            ObjectArrays.unstableSort(this.f2682a, 0, this.size);
        } else {
            ObjectArrays.unstableSort(this.f2682a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public ObjectArrayList<K> clone() {
        ObjectArrayList<K> cloned;
        if (getClass() == ObjectArrayList.class) {
            cloned = new ObjectArrayList<>(copyArraySafe(this.f2682a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (ObjectArrayList) clone();
                cloned.f2682a = (K[]) copyArraySafe(this.f2682a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(ObjectArrayList<K> l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        K[] a1 = this.f2682a;
        K[] a2 = l.f2682a;
        if (a1 == a2 && s == l.size()) {
            return true;
        }
        do {
            s--;
            if (s == 0) {
                return true;
            }
        } while (Objects.equals(a1[s], a2[s]));
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof ObjectArrayList) {
            return equals((ObjectArrayList) ((ObjectArrayList) o));
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ObjectArrayList<? extends K> l) {
        int s1 = size();
        int s2 = l.size();
        K[] a1 = this.f2682a;
        Object[] objArr = l.f2682a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = ((Comparable) a1[i]).compareTo(objArr[i]);
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList
    public int compareTo(List<? extends K> l) {
        if (l instanceof ObjectArrayList) {
            return compareTo((ObjectArrayList) ((ObjectArrayList) l));
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List) this);
        }
        return compareTo((List) l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeObject(this.f2682a[i]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: K[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2682a = (K[]) new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f2682a[i] = s.readObject();
        }
    }
}
