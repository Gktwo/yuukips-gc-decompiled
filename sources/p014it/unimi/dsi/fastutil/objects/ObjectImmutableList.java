package p014it.unimi.dsi.fastutil.objects;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.stream.Collector;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;
import p014it.unimi.dsi.fastutil.objects.ObjectLists;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectImmutableList.class */
public class ObjectImmutableList<K> extends ObjectLists.ImmutableListBase<K> implements ObjectList<K>, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final K[] f2703a;
    static final ObjectImmutableList EMPTY = new ObjectImmutableList(ObjectArrays.EMPTY_ARRAY);
    private static final Collector<Object, ?, ObjectImmutableList<Object>> TO_LIST_COLLECTOR = Collector.of(ObjectArrayList::new, (v0, v1) -> {
        v0.add(v1);
    }, (v0, v1) -> {
        return v0.combine(v1);
    }, ObjectImmutableList::convertTrustedToImmutableList, new Collector.Characteristics[0]);

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) ((List) obj));
    }

    private static final <K> K[] emptyArray() {
        return (K[]) ObjectArrays.EMPTY_ARRAY;
    }

    public ObjectImmutableList(K[] a) {
        this.f2703a = a;
    }

    public ObjectImmutableList(Collection<? extends K> c) {
        this(c.isEmpty() ? emptyArray() : ObjectIterators.unwrap(c.iterator()));
    }

    public ObjectImmutableList(ObjectCollection<? extends K> c) {
        this(c.isEmpty() ? emptyArray() : ObjectIterators.unwrap(c.iterator()));
    }

    public ObjectImmutableList(ObjectList<? extends K> l) {
        this(l.isEmpty() ? emptyArray() : new Object[l.size()]);
        l.getElements(0, this.f2703a, 0, l.size());
    }

    public ObjectImmutableList(K[] a, int offset, int length) {
        this(length == 0 ? emptyArray() : new Object[length]);
        System.arraycopy(a, offset, this.f2703a, 0, length);
    }

    public ObjectImmutableList(ObjectIterator<? extends K> i) {
        this(i.hasNext() ? ObjectIterators.unwrap(i) : emptyArray());
    }

    /* renamed from: of */
    public static <K> ObjectImmutableList<K> m563of() {
        return EMPTY;
    }

    @SafeVarargs
    /* renamed from: of */
    public static <K> ObjectImmutableList<K> m562of(K... init) {
        return init.length == 0 ? m563of() : new ObjectImmutableList<>(init);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object[]] */
    private static <K> ObjectImmutableList<K> convertTrustedToImmutableList(ObjectArrayList<K> arrayList) {
        if (arrayList.isEmpty()) {
            return m563of();
        }
        K[] backingArray = arrayList.elements();
        if (arrayList.size() != backingArray.length) {
            backingArray = Arrays.copyOf(backingArray, arrayList.size());
        }
        return new ObjectImmutableList<>(backingArray);
    }

    public static <K> Collector<K, ?, ObjectImmutableList<K>> toList() {
        return (Collector<K, ?, ObjectImmutableList<K>>) TO_LIST_COLLECTOR;
    }

    public static <K> Collector<K, ?, ObjectImmutableList<K>> toListWithExpectedSize(int expectedSize) {
        if (expectedSize <= 10) {
            return toList();
        }
        return Collector.of(new ObjectCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 10 ? new ObjectArrayList() : new ObjectArrayList(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, ObjectImmutableList::convertTrustedToImmutableList, new Collector.Characteristics[0]);
    }

    @Override // java.util.List
    public K get(int index) {
        if (index < this.f2703a.length) {
            return this.f2703a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f2703a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public int indexOf(Object k) {
        int size = this.f2703a.length;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(k, this.f2703a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
    public int lastIndexOf(Object k) {
        int i = this.f2703a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (!Objects.equals(k, this.f2703a[i]));
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2703a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f2703a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList
    public void getElements(int from, Object[] a, int offset, int length) {
        ObjectArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f2703a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        for (int i = 0; i < this.f2703a.length; i++) {
            action.accept((Object) this.f2703a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        if (this.f2703a.getClass().equals(Object[].class)) {
            return (Object[]) this.f2703a.clone();
        }
        return Arrays.copyOf(this.f2703a, this.f2703a.length, Object[].class);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <K> K[] toArray(K[] a) {
        if (a == null) {
            a = (K[]) new Object[size()];
        } else if (a.length < size()) {
            a = (K[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), size()));
        }
        System.arraycopy(this.f2703a, 0, a, 0, size());
        if (a.length > size()) {
            a[size()] = null;
        }
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectListIterator<K> listIterator(final int index) {
        ensureIndex(index);
        return new ObjectListIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.ObjectImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < ObjectImmutableList.this.f2703a.length;
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
                Object[] objArr = ObjectImmutableList.this.f2703a;
                int i = this.pos;
                this.pos = i + 1;
                return (K) objArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = ObjectImmutableList.this.f2703a;
                int i = this.pos - 1;
                this.pos = i;
                return (K) objArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super K> action) {
                while (this.pos < ObjectImmutableList.this.f2703a.length) {
                    Object[] objArr = ObjectImmutableList.this.f2703a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(objArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void add(K k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
            public void set(K k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ObjectImmutableList.this.f2703a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ObjectImmutableList.this.f2703a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = ObjectImmutableList.this.f2703a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectImmutableList$Spliterator.class */
    public final class Spliterator implements ObjectSpliterator<K> {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ObjectImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(ObjectImmutableList objectImmutableList) {
            this(0, objectImmutableList.f2703a.length);
        }

        private Spliterator(int pos, int max) {
            if ($assertionsDisabled || pos <= max) {
                this.pos = pos;
                this.max = max;
                return;
            }
            throw new AssertionError("pos " + pos + " must be <= max " + max);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 17488;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (this.max - this.pos);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.pos >= this.max) {
                return false;
            }
            Object[] objArr = ObjectImmutableList.this.f2703a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(objArr[i]);
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            while (this.pos < this.max) {
                action.accept(ObjectImmutableList.this.f2703a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.pos >= this.max) {
                return 0;
            } else {
                int remaining = this.max - this.pos;
                if (n < ((long) remaining)) {
                    this.pos = SafeMath.safeLongToInt(((long) this.pos) + n);
                    return n;
                }
                long n2 = (long) remaining;
                this.pos = this.max;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            int retLen = (this.max - this.pos) >> 1;
            if (retLen <= 1) {
                return null;
            }
            int myNewPos = this.pos + retLen;
            int oldPos = this.pos;
            this.pos = myNewPos;
            return new Spliterator(oldPos, myNewPos);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList<K> extends ObjectLists.ImmutableListBase<K> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final ObjectImmutableList<K> innerList;
        final int from;

        /* renamed from: to */
        final int f2704to;

        /* renamed from: a */
        final transient K[] f2705a;

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((List) ((List) obj));
        }

        ImmutableSubList(ObjectImmutableList<K> innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f2704to = to;
            this.f2705a = (K[]) ((ObjectImmutableList) innerList).f2703a;
        }

        @Override // java.util.List
        public K get(int index) {
            ensureRestrictedIndex(index);
            return this.f2705a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
        public int indexOf(Object k) {
            for (int i = this.from; i < this.f2704to; i++) {
                if (Objects.equals(k, this.f2705a[i])) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.List
        public int lastIndexOf(Object k) {
            int i = this.f2704to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (!Objects.equals(k, this.f2705a[i]));
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2704to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f2704to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList
        public void getElements(int fromSublistIndex, Object[] a, int offset, int length) {
            ObjectArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f2704to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f2705a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            for (int i = this.from; i < this.f2704to; i++) {
                action.accept((Object) this.f2705a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return Arrays.copyOfRange(this.f2705a, this.from, this.f2704to, Object[].class);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object[]] */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public <K> K[] toArray(K[] a) {
            int size = size();
            if (a == null) {
                a = new Object[size];
            } else if (a.length < size) {
                a = (K[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), size));
            }
            System.arraycopy(this.f2705a, this.from, a, 0, size);
            if (a.length > size) {
                a[size] = null;
            }
            return a;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
        public ObjectListIterator<K> listIterator(final int index) {
            ensureIndex(index);
            return new ObjectListIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.ObjectImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f2704to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public K next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    K[] kArr = ImmutableSubList.this.f2705a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return kArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public K previous() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    K[] kArr = ImmutableSubList.this.f2705a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return kArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super K> action) {
                    while (this.pos < ImmutableSubList.this.f2704to) {
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept((Object) ImmutableSubList.this.f2705a[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
                public void add(K k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
                public void set(K k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f2704to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f2704to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f2704to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ObjectImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<K> {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f2704to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            protected final K get(int i) {
                return ImmutableSubList.this.f2705a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            public final ImmutableSubList<K>.SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public boolean tryAdvance(Consumer<? super K> action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                int i = this.pos;
                this.pos = i + 1;
                action.accept((Object) ImmutableSubList.this.f2705a[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept((Object) ImmutableSubList.this.f2705a[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17488;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(K[] otherA, int otherAFrom, int otherATo) {
            if (this.f2705a == otherA && this.from == otherAFrom && this.f2704to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f2704to) {
                pos++;
                otherPos++;
                if (!Objects.equals(this.f2705a[pos], otherA[otherPos])) {
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectImmutableList$ImmutableSubList<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof ObjectImmutableList) {
                ObjectImmutableList<K> other = (ObjectImmutableList) o;
                return contentsEquals(((ObjectImmutableList) other).f2703a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList<K> other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f2705a, other2.from, other2.f2704to);
            }
        }

        int contentsCompareTo(K[] otherA, int otherAFrom, int otherATo) {
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f2704to && i < otherATo) {
                int r = ((Comparable) this.f2705a[i]).compareTo(otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f2704to ? 1 : 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectImmutableList$ImmutableSubList<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList
        public int compareTo(List<? extends K> l) {
            if (l instanceof ObjectImmutableList) {
                ObjectImmutableList<K> other = (ObjectImmutableList) l;
                return contentsCompareTo(((ObjectImmutableList) other).f2703a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo((List) l);
            } else {
                ImmutableSubList<K> other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f2705a, other2.from, other2.f2704to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f2704to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
        public ObjectList<K> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return ObjectImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, p014it.unimi.dsi.fastutil.objects.ObjectList, java.util.List
    public ObjectList<K> subList(int from, int to) {
        if (from == 0 && to == size()) {
            return this;
        }
        ensureIndex(from);
        ensureIndex(to);
        if (from == to) {
            return EMPTY;
        }
        if (from <= to) {
            return new ImmutableSubList(this, from, to);
        }
        throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // java.lang.Object
    public ObjectImmutableList<K> clone() {
        return this;
    }

    public boolean equals(ObjectImmutableList<K> l) {
        if (l == this || this.f2703a == l.f2703a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f2703a, l.f2703a);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof ObjectImmutableList) {
            return equals((ObjectImmutableList) ((ObjectImmutableList) o));
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ObjectImmutableList<? extends K> l) {
        int s1 = size();
        int s2 = l.size();
        K[] a1 = this.f2703a;
        Object[] objArr = l.f2703a;
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
        if (l instanceof ObjectImmutableList) {
            return compareTo((ObjectImmutableList) ((ObjectImmutableList) l));
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List) this);
        }
        return compareTo((List) l);
    }
}
