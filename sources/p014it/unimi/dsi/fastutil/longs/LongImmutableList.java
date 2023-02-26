package p014it.unimi.dsi.fastutil.longs;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.longs.LongLists;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.LongImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongImmutableList.class */
public class LongImmutableList extends LongLists.ImmutableListBase implements LongList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final LongImmutableList EMPTY = new LongImmutableList(LongArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final long[] f2378a;

    public LongImmutableList(long[] a) {
        this.f2378a = a;
    }

    public LongImmutableList(Collection<? extends Long> c) {
        this(c.isEmpty() ? LongArrays.EMPTY_ARRAY : LongIterators.unwrap(LongIterators.asLongIterator(c.iterator())));
    }

    public LongImmutableList(LongCollection c) {
        this(c.isEmpty() ? LongArrays.EMPTY_ARRAY : LongIterators.unwrap(c.iterator()));
    }

    public LongImmutableList(LongList l) {
        this(l.isEmpty() ? LongArrays.EMPTY_ARRAY : new long[l.size()]);
        l.getElements(0, this.f2378a, 0, l.size());
    }

    public LongImmutableList(long[] a, int offset, int length) {
        this(length == 0 ? LongArrays.EMPTY_ARRAY : new long[length]);
        System.arraycopy(a, offset, this.f2378a, 0, length);
    }

    public LongImmutableList(LongIterator i) {
        this(i.hasNext() ? LongIterators.unwrap(i) : LongArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static LongImmutableList m648of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static LongImmutableList m647of(long... init) {
        return init.length == 0 ? m648of() : new LongImmutableList(init);
    }

    private static LongImmutableList convertTrustedToImmutableList(LongArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return m648of();
        }
        long[] backingArray = arrayList.elements();
        if (arrayList.size() != backingArray.length) {
            backingArray = Arrays.copyOf(backingArray, arrayList.size());
        }
        return new LongImmutableList(backingArray);
    }

    public static LongImmutableList toList(LongStream stream) {
        return convertTrustedToImmutableList(LongArrayList.toList(stream));
    }

    public static LongImmutableList toListWithExpectedSize(LongStream stream, int expectedSize) {
        return convertTrustedToImmutableList(LongArrayList.toListWithExpectedSize(stream, expectedSize));
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongList
    public long getLong(int index) {
        if (index < this.f2378a.length) {
            return this.f2378a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f2378a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public int indexOf(long k) {
        int size = this.f2378a.length;
        for (int i = 0; i < size; i++) {
            if (k == this.f2378a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public int lastIndexOf(long k) {
        int i = this.f2378a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f2378a[i]);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2378a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f2378a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
    public void getElements(int from, long[] a, int offset, int length) {
        LongArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f2378a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongIterable
    public void forEach(LongConsumer action) {
        for (int i = 0; i < this.f2378a.length; i++) {
            action.accept(this.f2378a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toLongArray() {
        return (long[]) this.f2378a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toArray(long[] a) {
        if (a == null || a.length < size()) {
            a = new long[this.f2378a.length];
        }
        System.arraycopy(this.f2378a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
    public ListIterator<Long> listIterator(final int index) {
        ensureIndex(index);
        return new LongListIterator() { // from class: it.unimi.dsi.fastutil.longs.LongImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < LongImmutableList.this.f2378a.length;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongImmutableList.this.f2378a;
                int i = this.pos;
                this.pos = i + 1;
                return jArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            public long previousLong() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongImmutableList.this.f2378a;
                int i = this.pos - 1;
                this.pos = i;
                return jArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // java.util.PrimitiveIterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                while (this.pos < LongImmutableList.this.f2378a.length) {
                    long[] jArr = LongImmutableList.this.f2378a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
            public void add(long k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
            public void set(long k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = LongImmutableList.this.f2378a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = LongImmutableList.this.f2378a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = LongImmutableList.this.f2378a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongImmutableList$Spliterator.class */
    public final class Spliterator implements LongSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !LongImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(LongImmutableList longImmutableList) {
            this(0, longImmutableList.f2378a.length);
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

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            long[] jArr = LongImmutableList.this.f2378a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(jArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            while (this.pos < this.max) {
                action.accept(LongImmutableList.this.f2378a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends LongLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final LongImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f2379to;

        /* renamed from: a */
        final transient long[] f2380a;

        ImmutableSubList(LongImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f2379to = to;
            this.f2380a = innerList.f2378a;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongList
        public long getLong(int index) {
            ensureRestrictedIndex(index);
            return this.f2380a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public int indexOf(long k) {
            for (int i = this.from; i < this.f2379to; i++) {
                if (k == this.f2380a[i]) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public int lastIndexOf(long k) {
            int i = this.f2379to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (k != this.f2380a[i]);
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2379to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f2379to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList
        public void getElements(int fromSublistIndex, long[] a, int offset, int length) {
            LongArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f2379to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f2380a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer action) {
            for (int i = this.from; i < this.f2379to; i++) {
                action.accept(this.f2380a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toLongArray() {
            return Arrays.copyOfRange(this.f2380a, this.from, this.f2379to);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public long[] toArray(long[] a) {
            if (a == null || a.length < size()) {
                a = new long[size()];
            }
            System.arraycopy(this.f2380a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public ListIterator<Long> listIterator(final int index) {
            ensureIndex(index);
            return new LongListIterator() { // from class: it.unimi.dsi.fastutil.longs.LongImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f2379to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                public long nextLong() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = ImmutableSubList.this.f2380a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return jArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
                public long previousLong() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    long[] jArr = ImmutableSubList.this.f2380a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return jArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // java.util.PrimitiveIterator.OfLong
                public void forEachRemaining(LongConsumer action) {
                    while (this.pos < ImmutableSubList.this.f2379to) {
                        long[] jArr = ImmutableSubList.this.f2380a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(jArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
                public void add(long k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
                public void set(long k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f2379to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f2379to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f2379to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.LongImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends LongSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f2379to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            protected final long get(int i) {
                return ImmutableSubList.this.f2380a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public boolean tryAdvance(LongConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                long[] jArr = ImmutableSubList.this.f2380a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(jArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfLong
            public void forEachRemaining(LongConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    long[] jArr = ImmutableSubList.this.f2380a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(jArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(long[] otherA, int otherAFrom, int otherATo) {
            if (this.f2380a == otherA && this.from == otherAFrom && this.f2379to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f2379to) {
                pos++;
                otherPos++;
                if (this.f2380a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof LongImmutableList) {
                LongImmutableList other = (LongImmutableList) o;
                return contentsEquals(other.f2378a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f2380a, other2.from, other2.f2379to);
            }
        }

        int contentsCompareTo(long[] otherA, int otherAFrom, int otherATo) {
            if (this.f2380a == otherA && this.from == otherAFrom && this.f2379to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f2379to && i < otherATo) {
                int r = Long.compare(this.f2380a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f2379to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList
        public int compareTo(List<? extends Long> l) {
            if (l instanceof LongImmutableList) {
                LongImmutableList other = (LongImmutableList) l;
                return contentsCompareTo(other.f2378a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f2380a, other2.from, other2.f2379to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f2379to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
        public List<Long> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return LongImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, p014it.unimi.dsi.fastutil.longs.LongList, java.util.List
    public List<Long> subList(int from, int to) {
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
    public LongImmutableList clone() {
        return this;
    }

    public boolean equals(LongImmutableList l) {
        if (l == this || this.f2378a == l.f2378a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f2378a, l.f2378a);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof LongImmutableList) {
            return equals((LongImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(LongImmutableList l) {
        if (this.f2378a == l.f2378a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        long[] a1 = this.f2378a;
        long[] a2 = l.f2378a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Long.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongList
    public int compareTo(List<? extends Long> l) {
        if (l instanceof LongImmutableList) {
            return compareTo((LongImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Long>) this);
        }
        return compareTo(l);
    }
}
