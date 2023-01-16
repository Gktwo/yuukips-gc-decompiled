package p014it.unimi.dsi.fastutil.shorts;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.shorts.ShortLists;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortImmutableList.class */
public class ShortImmutableList extends ShortLists.ImmutableListBase implements ShortList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final ShortImmutableList EMPTY = new ShortImmutableList(ShortArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final short[] f3044a;

    public ShortImmutableList(short[] a) {
        this.f3044a = a;
    }

    public ShortImmutableList(Collection<? extends Short> c) {
        this(c.isEmpty() ? ShortArrays.EMPTY_ARRAY : ShortIterators.unwrap(ShortIterators.asShortIterator(c.iterator())));
    }

    public ShortImmutableList(ShortCollection c) {
        this(c.isEmpty() ? ShortArrays.EMPTY_ARRAY : ShortIterators.unwrap(c.iterator()));
    }

    public ShortImmutableList(ShortList l) {
        this(l.isEmpty() ? ShortArrays.EMPTY_ARRAY : new short[l.size()]);
        l.getElements(0, this.f3044a, 0, l.size());
    }

    public ShortImmutableList(short[] a, int offset, int length) {
        this(length == 0 ? ShortArrays.EMPTY_ARRAY : new short[length]);
        System.arraycopy(a, offset, this.f3044a, 0, length);
    }

    public ShortImmutableList(ShortIterator i) {
        this(i.hasNext() ? ShortIterators.unwrap(i) : ShortArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static ShortImmutableList m423of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static ShortImmutableList m422of(short... init) {
        return init.length == 0 ? m423of() : new ShortImmutableList(init);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
    public short getShort(int index) {
        if (index < this.f3044a.length) {
            return this.f3044a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f3044a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public int indexOf(short k) {
        int size = this.f3044a.length;
        for (int i = 0; i < size; i++) {
            if (k == this.f3044a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public int lastIndexOf(short k) {
        int i = this.f3044a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f3044a[i]);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3044a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f3044a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
    public void getElements(int from, short[] a, int offset, int length) {
        ShortArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f3044a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public void forEach(ShortConsumer action) {
        for (int i = 0; i < this.f3044a.length; i++) {
            action.accept(this.f3044a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toShortArray() {
        return (short[]) this.f3044a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toArray(short[] a) {
        if (a == null || a.length < size()) {
            a = new short[this.f3044a.length];
        }
        System.arraycopy(this.f3044a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
    public ListIterator<Short> listIterator(final int index) {
        ensureIndex(index);
        return new ShortListIterator() { // from class: it.unimi.dsi.fastutil.shorts.ShortImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < ShortImmutableList.this.f3044a.length;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                short[] sArr = ShortImmutableList.this.f3044a;
                int i = this.pos;
                this.pos = i + 1;
                return sArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            public short previousShort() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                short[] sArr = ShortImmutableList.this.f3044a;
                int i = this.pos - 1;
                this.pos = i;
                return sArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public void forEachRemaining(ShortConsumer action) {
                while (this.pos < ShortImmutableList.this.f3044a.length) {
                    short[] sArr = ShortImmutableList.this.f3044a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(sArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
            public void add(short k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
            public void set(short k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ShortImmutableList.this.f3044a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ShortImmutableList.this.f3044a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = ShortImmutableList.this.f3044a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortImmutableList$Spliterator.class */
    public final class Spliterator implements ShortSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ShortImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(ShortImmutableList shortImmutableList) {
            this(0, shortImmutableList.f3044a.length);
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

        public boolean tryAdvance(ShortConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            short[] sArr = ShortImmutableList.this.f3044a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(sArr[i]);
            return true;
        }

        public void forEachRemaining(ShortConsumer action) {
            while (this.pos < this.max) {
                action.accept(ShortImmutableList.this.f3044a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends ShortLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final ShortImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f3045to;

        /* renamed from: a */
        final transient short[] f3046a;

        ImmutableSubList(ShortImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f3045to = to;
            this.f3046a = innerList.f3044a;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortList
        public short getShort(int index) {
            ensureRestrictedIndex(index);
            return this.f3046a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public int indexOf(short k) {
            for (int i = this.from; i < this.f3045to; i++) {
                if (k == this.f3046a[i]) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public int lastIndexOf(short k) {
            int i = this.f3045to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (k != this.f3046a[i]);
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f3045to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f3045to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList
        public void getElements(int fromSublistIndex, short[] a, int offset, int length) {
            ShortArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f3045to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f3046a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer action) {
            for (int i = this.from; i < this.f3045to; i++) {
                action.accept(this.f3046a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toShortArray() {
            return Arrays.copyOfRange(this.f3046a, this.from, this.f3045to);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public short[] toArray(short[] a) {
            if (a == null || a.length < size()) {
                a = new short[size()];
            }
            System.arraycopy(this.f3046a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public ListIterator<Short> listIterator(final int index) {
            ensureIndex(index);
            return new ShortListIterator() { // from class: it.unimi.dsi.fastutil.shorts.ShortImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f3045to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public short nextShort() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = ImmutableSubList.this.f3046a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return sArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
                public short previousShort() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    short[] sArr = ImmutableSubList.this.f3046a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return sArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                public void forEachRemaining(ShortConsumer action) {
                    while (this.pos < ImmutableSubList.this.f3045to) {
                        short[] sArr = ImmutableSubList.this.f3046a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(sArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
                public void add(short k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
                public void set(short k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f3045to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f3045to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f3045to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.ShortImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ShortSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f3045to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            protected final short get(int i) {
                return ImmutableSubList.this.f3046a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(ShortConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                short[] sArr = ImmutableSubList.this.f3046a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(sArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ShortConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    short[] sArr = ImmutableSubList.this.f3046a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(sArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(short[] otherA, int otherAFrom, int otherATo) {
            if (this.f3046a == otherA && this.from == otherAFrom && this.f3045to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f3045to) {
                pos++;
                otherPos++;
                if (this.f3046a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof ShortImmutableList) {
                ShortImmutableList other = (ShortImmutableList) o;
                return contentsEquals(other.f3044a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f3046a, other2.from, other2.f3045to);
            }
        }

        int contentsCompareTo(short[] otherA, int otherAFrom, int otherATo) {
            if (this.f3046a == otherA && this.from == otherAFrom && this.f3045to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f3045to && i < otherATo) {
                int r = Short.compare(this.f3046a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f3045to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList
        public int compareTo(List<? extends Short> l) {
            if (l instanceof ShortImmutableList) {
                ShortImmutableList other = (ShortImmutableList) l;
                return contentsCompareTo(other.f3044a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f3046a, other2.from, other2.f3045to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f3045to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
        public List<Short> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return ShortImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, p014it.unimi.dsi.fastutil.shorts.ShortList, java.util.List
    public List<Short> subList(int from, int to) {
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
    public ShortImmutableList clone() {
        return this;
    }

    public boolean equals(ShortImmutableList l) {
        if (l == this || this.f3044a == l.f3044a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f3044a, l.f3044a);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof ShortImmutableList) {
            return equals((ShortImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ShortImmutableList l) {
        if (this.f3044a == l.f3044a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        short[] a1 = this.f3044a;
        short[] a2 = l.f3044a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Short.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortList
    public int compareTo(List<? extends Short> l) {
        if (l instanceof ShortImmutableList) {
            return compareTo((ShortImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Short>) this);
        }
        return compareTo(l);
    }
}
