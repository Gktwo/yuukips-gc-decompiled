package p014it.unimi.dsi.fastutil.ints;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.ints.IntLists;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.IntImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntImmutableList.class */
public class IntImmutableList extends IntLists.ImmutableListBase implements IntList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final IntImmutableList EMPTY = new IntImmutableList(IntArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final int[] f2136a;

    public IntImmutableList(int[] a) {
        this.f2136a = a;
    }

    public IntImmutableList(Collection<? extends Integer> c) {
        this(c.isEmpty() ? IntArrays.EMPTY_ARRAY : IntIterators.unwrap(IntIterators.asIntIterator(c.iterator())));
    }

    public IntImmutableList(IntCollection c) {
        this(c.isEmpty() ? IntArrays.EMPTY_ARRAY : IntIterators.unwrap(c.iterator()));
    }

    public IntImmutableList(IntList l) {
        this(l.isEmpty() ? IntArrays.EMPTY_ARRAY : new int[l.size()]);
        l.getElements(0, this.f2136a, 0, l.size());
    }

    public IntImmutableList(int[] a, int offset, int length) {
        this(length == 0 ? IntArrays.EMPTY_ARRAY : new int[length]);
        System.arraycopy(a, offset, this.f2136a, 0, length);
    }

    public IntImmutableList(IntIterator i) {
        this(i.hasNext() ? IntIterators.unwrap(i) : IntArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static IntImmutableList m733of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static IntImmutableList m732of(int... init) {
        return init.length == 0 ? m733of() : new IntImmutableList(init);
    }

    private static IntImmutableList convertTrustedToImmutableList(IntArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return m733of();
        }
        int[] backingArray = arrayList.elements();
        if (arrayList.size() != backingArray.length) {
            backingArray = Arrays.copyOf(backingArray, arrayList.size());
        }
        return new IntImmutableList(backingArray);
    }

    public static IntImmutableList toList(IntStream stream) {
        return convertTrustedToImmutableList(IntArrayList.toList(stream));
    }

    public static IntImmutableList toListWithExpectedSize(IntStream stream, int expectedSize) {
        return convertTrustedToImmutableList(IntArrayList.toListWithExpectedSize(stream, expectedSize));
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntList
    public int getInt(int index) {
        if (index < this.f2136a.length) {
            return this.f2136a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f2136a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
    public int indexOf(int k) {
        int size = this.f2136a.length;
        for (int i = 0; i < size; i++) {
            if (k == this.f2136a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
    public int lastIndexOf(int k) {
        int i = this.f2136a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f2136a[i]);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2136a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f2136a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
    public void getElements(int from, int[] a, int offset, int length) {
        IntArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f2136a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntIterable
    public void forEach(IntConsumer action) {
        for (int i = 0; i < this.f2136a.length; i++) {
            action.accept(this.f2136a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public int[] toIntArray() {
        return (int[]) this.f2136a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public int[] toArray(int[] a) {
        if (a == null || a.length < size()) {
            a = new int[this.f2136a.length];
        }
        System.arraycopy(this.f2136a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
    public ListIterator<Integer> listIterator(final int index) {
        ensureIndex(index);
        return new IntListIterator() { // from class: it.unimi.dsi.fastutil.ints.IntImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < IntImmutableList.this.f2136a.length;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int[] iArr = IntImmutableList.this.f2136a;
                int i = this.pos;
                this.pos = i + 1;
                return iArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
            public int previousInt() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                int[] iArr = IntImmutableList.this.f2136a;
                int i = this.pos - 1;
                this.pos = i;
                return iArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                while (this.pos < IntImmutableList.this.f2136a.length) {
                    int[] iArr = IntImmutableList.this.f2136a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
            public void add(int k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
            public void set(int k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = IntImmutableList.this.f2136a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = IntImmutableList.this.f2136a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = IntImmutableList.this.f2136a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntImmutableList$Spliterator.class */
    public final class Spliterator implements IntSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !IntImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(IntImmutableList intImmutableList) {
            this(0, intImmutableList.f2136a.length);
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
            return 17744;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (this.max - this.pos);
        }

        @Override // java.util.Spliterator.OfInt
        public boolean tryAdvance(IntConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            int[] iArr = IntImmutableList.this.f2136a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(iArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            while (this.pos < this.max) {
                action.accept(IntImmutableList.this.f2136a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public IntSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends IntLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final IntImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f2137to;

        /* renamed from: a */
        final transient int[] f2138a;

        ImmutableSubList(IntImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f2137to = to;
            this.f2138a = innerList.f2136a;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntList
        public int getInt(int index) {
            ensureRestrictedIndex(index);
            return this.f2138a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public int indexOf(int k) {
            for (int i = this.from; i < this.f2137to; i++) {
                if (k == this.f2138a[i]) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public int lastIndexOf(int k) {
            int i = this.f2137to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (k != this.f2138a[i]);
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2137to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f2137to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList
        public void getElements(int fromSublistIndex, int[] a, int offset, int length) {
            IntArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f2137to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f2138a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer action) {
            for (int i = this.from; i < this.f2137to; i++) {
                action.accept(this.f2138a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toIntArray() {
            return Arrays.copyOfRange(this.f2138a, this.from, this.f2137to);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public int[] toArray(int[] a) {
            if (a == null || a.length < size()) {
                a = new int[size()];
            }
            System.arraycopy(this.f2138a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public ListIterator<Integer> listIterator(final int index) {
            ensureIndex(index);
            return new IntListIterator() { // from class: it.unimi.dsi.fastutil.ints.IntImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f2137to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                public int nextInt() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = ImmutableSubList.this.f2138a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return iArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
                public int previousInt() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    int[] iArr = ImmutableSubList.this.f2138a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return iArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // java.util.PrimitiveIterator.OfInt
                public void forEachRemaining(IntConsumer action) {
                    while (this.pos < ImmutableSubList.this.f2137to) {
                        int[] iArr = ImmutableSubList.this.f2138a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(iArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
                public void add(int k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
                public void set(int k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f2137to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f2137to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f2137to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.IntImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends IntSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f2137to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            protected final int get(int i) {
                return ImmutableSubList.this.f2138a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public boolean tryAdvance(IntConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                int[] iArr = ImmutableSubList.this.f2138a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(iArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfInt
            public void forEachRemaining(IntConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    int[] iArr = ImmutableSubList.this.f2138a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(iArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(int[] otherA, int otherAFrom, int otherATo) {
            if (this.f2138a == otherA && this.from == otherAFrom && this.f2137to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f2137to) {
                pos++;
                otherPos++;
                if (this.f2138a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof IntImmutableList) {
                IntImmutableList other = (IntImmutableList) o;
                return contentsEquals(other.f2136a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f2138a, other2.from, other2.f2137to);
            }
        }

        int contentsCompareTo(int[] otherA, int otherAFrom, int otherATo) {
            if (this.f2138a == otherA && this.from == otherAFrom && this.f2137to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f2137to && i < otherATo) {
                int r = Integer.compare(this.f2138a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f2137to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList
        public int compareTo(List<? extends Integer> l) {
            if (l instanceof IntImmutableList) {
                IntImmutableList other = (IntImmutableList) l;
                return contentsCompareTo(other.f2136a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f2138a, other2.from, other2.f2137to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f2137to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
        public List<Integer> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return IntImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, p014it.unimi.dsi.fastutil.ints.IntList, java.util.List
    public List<Integer> subList(int from, int to) {
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
    public IntImmutableList clone() {
        return this;
    }

    public boolean equals(IntImmutableList l) {
        if (l == this || this.f2136a == l.f2136a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f2136a, l.f2136a);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof IntImmutableList) {
            return equals((IntImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(IntImmutableList l) {
        if (this.f2136a == l.f2136a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        int[] a1 = this.f2136a;
        int[] a2 = l.f2136a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Integer.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntList
    public int compareTo(List<? extends Integer> l) {
        if (l instanceof IntImmutableList) {
            return compareTo((IntImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Integer>) this);
        }
        return compareTo(l);
    }
}
