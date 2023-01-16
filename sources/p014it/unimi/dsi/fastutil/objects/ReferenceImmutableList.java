package p014it.unimi.dsi.fastutil.objects;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.stream.Collector;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollections;
import p014it.unimi.dsi.fastutil.objects.ReferenceLists;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceImmutableList.class */
public class ReferenceImmutableList<K> extends ReferenceLists.ImmutableListBase<K> implements ReferenceList<K>, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final K[] f2834a;
    static final ReferenceImmutableList EMPTY = new ReferenceImmutableList(ObjectArrays.EMPTY_ARRAY);
    private static final Collector<Object, ?, ReferenceImmutableList<Object>> TO_LIST_COLLECTOR = Collector.of(ReferenceArrayList::new, (v0, v1) -> {
        v0.add(v1);
    }, (v0, v1) -> {
        return v0.combine(v1);
    }, ReferenceImmutableList::convertTrustedToImmutableList, new Collector.Characteristics[0]);

    private static final <K> K[] emptyArray() {
        return (K[]) ObjectArrays.EMPTY_ARRAY;
    }

    public ReferenceImmutableList(K[] a) {
        this.f2834a = a;
    }

    public ReferenceImmutableList(Collection<? extends K> c) {
        this(c.isEmpty() ? emptyArray() : ObjectIterators.unwrap(c.iterator()));
    }

    public ReferenceImmutableList(ReferenceCollection<? extends K> c) {
        this(c.isEmpty() ? emptyArray() : ObjectIterators.unwrap(c.iterator()));
    }

    public ReferenceImmutableList(ReferenceList<? extends K> l) {
        this(l.isEmpty() ? emptyArray() : new Object[l.size()]);
        l.getElements(0, this.f2834a, 0, l.size());
    }

    public ReferenceImmutableList(K[] a, int offset, int length) {
        this(length == 0 ? emptyArray() : new Object[length]);
        System.arraycopy(a, offset, this.f2834a, 0, length);
    }

    public ReferenceImmutableList(ObjectIterator<? extends K> i) {
        this(i.hasNext() ? ObjectIterators.unwrap(i) : emptyArray());
    }

    /* renamed from: of */
    public static <K> ReferenceImmutableList<K> m503of() {
        return EMPTY;
    }

    @SafeVarargs
    /* renamed from: of */
    public static <K> ReferenceImmutableList<K> m502of(K... init) {
        return init.length == 0 ? m503of() : new ReferenceImmutableList<>(init);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object[]] */
    private static <K> ReferenceImmutableList<K> convertTrustedToImmutableList(ReferenceArrayList<K> arrayList) {
        if (arrayList.isEmpty()) {
            return m503of();
        }
        K[] backingArray = arrayList.elements();
        if (arrayList.size() != backingArray.length) {
            backingArray = Arrays.copyOf(backingArray, arrayList.size());
        }
        return new ReferenceImmutableList<>(backingArray);
    }

    public static <K> Collector<K, ?, ReferenceImmutableList<K>> toList() {
        return (Collector<K, ?, ReferenceImmutableList<K>>) TO_LIST_COLLECTOR;
    }

    public static <K> Collector<K, ?, ReferenceImmutableList<K>> toListWithExpectedSize(int expectedSize) {
        if (expectedSize <= 10) {
            return toList();
        }
        return Collector.of(new ReferenceCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 10 ? new ReferenceArrayList() : new ReferenceArrayList(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, ReferenceImmutableList::convertTrustedToImmutableList, new Collector.Characteristics[0]);
    }

    @Override // java.util.List
    public K get(int index) {
        if (index < this.f2834a.length) {
            return this.f2834a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f2834a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
    public int indexOf(Object k) {
        int size = this.f2834a.length;
        for (int i = 0; i < size; i++) {
            if (k == this.f2834a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
    public int lastIndexOf(Object k) {
        int i = this.f2834a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f2834a[i]);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2834a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f2834a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
    public void getElements(int from, Object[] a, int offset, int length) {
        ObjectArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f2834a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        for (int i = 0; i < this.f2834a.length; i++) {
            action.accept((Object) this.f2834a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        if (this.f2834a.getClass().equals(Object[].class)) {
            return (Object[]) this.f2834a.clone();
        }
        return Arrays.copyOf(this.f2834a, this.f2834a.length, Object[].class);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <K> K[] toArray(K[] a) {
        if (a == null) {
            a = (K[]) new Object[size()];
        } else if (a.length < size()) {
            a = (K[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), size()));
        }
        System.arraycopy(this.f2834a, 0, a, 0, size());
        if (a.length > size()) {
            a[size()] = null;
        }
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
    public ObjectListIterator<K> listIterator(final int index) {
        ensureIndex(index);
        return new ObjectListIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.ReferenceImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < ReferenceImmutableList.this.f2834a.length;
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
                Object[] objArr = ReferenceImmutableList.this.f2834a;
                int i = this.pos;
                this.pos = i + 1;
                return (K) objArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = ReferenceImmutableList.this.f2834a;
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
                while (this.pos < ReferenceImmutableList.this.f2834a.length) {
                    Object[] objArr = ReferenceImmutableList.this.f2834a;
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
                int remaining = ReferenceImmutableList.this.f2834a.length - this.pos;
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
                int remaining = ReferenceImmutableList.this.f2834a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = ReferenceImmutableList.this.f2834a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceImmutableList$Spliterator.class */
    public final class Spliterator implements ObjectSpliterator<K> {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ReferenceImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(ReferenceImmutableList referenceImmutableList) {
            this(0, referenceImmutableList.f2834a.length);
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
            Object[] objArr = ReferenceImmutableList.this.f2834a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(objArr[i]);
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            while (this.pos < this.max) {
                action.accept(ReferenceImmutableList.this.f2834a[this.pos]);
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList<K> extends ReferenceLists.ImmutableListBase<K> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final ReferenceImmutableList<K> innerList;
        final int from;

        /* renamed from: to */
        final int f2835to;

        /* renamed from: a */
        final transient K[] f2836a;

        ImmutableSubList(ReferenceImmutableList<K> innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f2835to = to;
            this.f2836a = (K[]) ((ReferenceImmutableList) innerList).f2834a;
        }

        @Override // java.util.List
        public K get(int index) {
            ensureRestrictedIndex(index);
            return this.f2836a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public int indexOf(Object k) {
            for (int i = this.from; i < this.f2835to; i++) {
                if (k == this.f2836a[i]) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.List
        public int lastIndexOf(Object k) {
            int i = this.f2835to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (k != this.f2836a[i]);
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2835to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f2835to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList
        public void getElements(int fromSublistIndex, Object[] a, int offset, int length) {
            ObjectArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f2835to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f2836a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            for (int i = this.from; i < this.f2835to; i++) {
                action.accept((Object) this.f2836a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return Arrays.copyOfRange(this.f2836a, this.from, this.f2835to, Object[].class);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object[]] */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public <K> K[] toArray(K[] a) {
            int size = size();
            if (a == null) {
                a = new Object[size];
            } else if (a.length < size) {
                a = (K[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), size));
            }
            System.arraycopy(this.f2836a, this.from, a, 0, size);
            if (a.length > size) {
                a[size] = null;
            }
            return a;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ObjectListIterator<K> listIterator(final int index) {
            ensureIndex(index);
            return new ObjectListIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.ReferenceImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f2835to;
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
                    K[] kArr = ImmutableSubList.this.f2836a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return kArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public K previous() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    K[] kArr = ImmutableSubList.this.f2836a;
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
                    while (this.pos < ImmutableSubList.this.f2835to) {
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept((Object) ImmutableSubList.this.f2836a[i + ImmutableSubList.this.from]);
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
                    int remaining = ImmutableSubList.this.f2835to - this.pos;
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
                    int remaining = ImmutableSubList.this.f2835to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f2835to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<K> {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f2835to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
            protected final K get(int i) {
                return ImmutableSubList.this.f2836a[i];
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
                action.accept((Object) ImmutableSubList.this.f2836a[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public void forEachRemaining(Consumer<? super K> action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept((Object) ImmutableSubList.this.f2836a[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17488;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(K[] otherA, int otherAFrom, int otherATo) {
            if (this.f2836a == otherA && this.from == otherAFrom && this.f2835to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f2835to) {
                pos++;
                otherPos++;
                if (this.f2836a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceImmutableList$ImmutableSubList<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof ReferenceImmutableList) {
                ReferenceImmutableList<K> other = (ReferenceImmutableList) o;
                return contentsEquals(((ReferenceImmutableList) other).f2834a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList<K> other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f2836a, other2.from, other2.f2835to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f2835to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
        public ReferenceList<K> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return ReferenceImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, p014it.unimi.dsi.fastutil.objects.ReferenceList, java.util.List
    public ReferenceList<K> subList(int from, int to) {
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
    public ReferenceImmutableList<K> clone() {
        return this;
    }

    public boolean equals(ReferenceImmutableList<K> l) {
        if (l == this || this.f2834a == l.f2834a) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        K[] a1 = this.f2834a;
        K[] a2 = l.f2834a;
        do {
            s--;
            if (s == 0) {
                return true;
            }
        } while (a1[s] == a2[s]);
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof ReferenceImmutableList) {
            return equals((ReferenceImmutableList) ((ReferenceImmutableList) o));
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }
}
