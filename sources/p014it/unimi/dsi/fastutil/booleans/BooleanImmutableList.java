package p014it.unimi.dsi.fastutil.booleans;

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
import p014it.unimi.dsi.fastutil.booleans.BooleanLists;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanImmutableList.class */
public class BooleanImmutableList extends BooleanLists.ImmutableListBase implements BooleanList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final BooleanImmutableList EMPTY = new BooleanImmutableList(BooleanArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final boolean[] f1064a;

    public BooleanImmutableList(boolean[] a) {
        this.f1064a = a;
    }

    public BooleanImmutableList(Collection<? extends Boolean> c) {
        this(c.isEmpty() ? BooleanArrays.EMPTY_ARRAY : BooleanIterators.unwrap(BooleanIterators.asBooleanIterator(c.iterator())));
    }

    public BooleanImmutableList(BooleanCollection c) {
        this(c.isEmpty() ? BooleanArrays.EMPTY_ARRAY : BooleanIterators.unwrap(c.iterator()));
    }

    public BooleanImmutableList(BooleanList l) {
        this(l.isEmpty() ? BooleanArrays.EMPTY_ARRAY : new boolean[l.size()]);
        l.getElements(0, this.f1064a, 0, l.size());
    }

    public BooleanImmutableList(boolean[] a, int offset, int length) {
        this(length == 0 ? BooleanArrays.EMPTY_ARRAY : new boolean[length]);
        System.arraycopy(a, offset, this.f1064a, 0, length);
    }

    public BooleanImmutableList(BooleanIterator i) {
        this(i.hasNext() ? BooleanIterators.unwrap(i) : BooleanArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static BooleanImmutableList m1147of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static BooleanImmutableList m1146of(boolean... init) {
        return init.length == 0 ? m1147of() : new BooleanImmutableList(init);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
    public boolean getBoolean(int index) {
        if (index < this.f1064a.length) {
            return this.f1064a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f1064a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public int indexOf(boolean k) {
        int size = this.f1064a.length;
        for (int i = 0; i < size; i++) {
            if (k == this.f1064a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public int lastIndexOf(boolean k) {
        int i = this.f1064a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f1064a[i]);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1064a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f1064a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
    public void getElements(int from, boolean[] a, int offset, int length) {
        BooleanArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1064a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
    public void forEach(BooleanConsumer action) {
        for (int i = 0; i < this.f1064a.length; i++) {
            action.accept(this.f1064a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toBooleanArray() {
        return (boolean[]) this.f1064a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toArray(boolean[] a) {
        if (a == null || a.length < size()) {
            a = new boolean[this.f1064a.length];
        }
        System.arraycopy(this.f1064a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
    public ListIterator<Boolean> listIterator(final int index) {
        ensureIndex(index);
        return new BooleanListIterator() { // from class: it.unimi.dsi.fastutil.booleans.BooleanImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < BooleanImmutableList.this.f1064a.length;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public boolean nextBoolean() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                boolean[] zArr = BooleanImmutableList.this.f1064a;
                int i = this.pos;
                this.pos = i + 1;
                return zArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
            public boolean previousBoolean() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                boolean[] zArr = BooleanImmutableList.this.f1064a;
                int i = this.pos - 1;
                this.pos = i;
                return zArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public void forEachRemaining(BooleanConsumer action) {
                while (this.pos < BooleanImmutableList.this.f1064a.length) {
                    boolean[] zArr = BooleanImmutableList.this.f1064a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(zArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
            public void add(boolean k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
            public void set(boolean k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = BooleanImmutableList.this.f1064a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = BooleanImmutableList.this.f1064a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = BooleanImmutableList.this.f1064a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanImmutableList$Spliterator.class */
    public final class Spliterator implements BooleanSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !BooleanImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(BooleanImmutableList booleanImmutableList) {
            this(0, booleanImmutableList.f1064a.length);
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

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            boolean[] zArr = BooleanImmutableList.this.f1064a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(zArr[i]);
            return true;
        }

        public void forEachRemaining(BooleanConsumer action) {
            while (this.pos < this.max) {
                action.accept(BooleanImmutableList.this.f1064a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends BooleanLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final BooleanImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f1065to;

        /* renamed from: a */
        final transient boolean[] f1066a;

        ImmutableSubList(BooleanImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f1065to = to;
            this.f1066a = innerList.f1064a;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanList
        public boolean getBoolean(int index) {
            ensureRestrictedIndex(index);
            return this.f1066a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int indexOf(boolean k) {
            for (int i = this.from; i < this.f1065to; i++) {
                if (k == this.f1066a[i]) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public int lastIndexOf(boolean k) {
            int i = this.f1065to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (k != this.f1066a[i]);
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1065to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f1065to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList
        public void getElements(int fromSublistIndex, boolean[] a, int offset, int length) {
            BooleanArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f1065to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f1066a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanIterable
        public void forEach(BooleanConsumer action) {
            for (int i = this.from; i < this.f1065to; i++) {
                action.accept(this.f1066a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.f1066a, this.from, this.f1065to);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean[] toArray(boolean[] a) {
            if (a == null || a.length < size()) {
                a = new boolean[size()];
            }
            System.arraycopy(this.f1066a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public ListIterator<Boolean> listIterator(final int index) {
            ensureIndex(index);
            return new BooleanListIterator() { // from class: it.unimi.dsi.fastutil.booleans.BooleanImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f1065to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                public boolean nextBoolean() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    boolean[] zArr = ImmutableSubList.this.f1066a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return zArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
                public boolean previousBoolean() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    boolean[] zArr = ImmutableSubList.this.f1066a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return zArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                public void forEachRemaining(BooleanConsumer action) {
                    while (this.pos < ImmutableSubList.this.f1065to) {
                        boolean[] zArr = ImmutableSubList.this.f1066a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(zArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
                public void add(boolean k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
                public void set(boolean k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1065to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1065to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f1065to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends BooleanSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f1065to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            protected final boolean get(int i) {
                return ImmutableSubList.this.f1066a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(BooleanConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                boolean[] zArr = ImmutableSubList.this.f1066a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(zArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(BooleanConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    boolean[] zArr = ImmutableSubList.this.f1066a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(zArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(boolean[] otherA, int otherAFrom, int otherATo) {
            if (this.f1066a == otherA && this.from == otherAFrom && this.f1065to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1065to) {
                pos++;
                otherPos++;
                if (this.f1066a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof BooleanImmutableList) {
                BooleanImmutableList other = (BooleanImmutableList) o;
                return contentsEquals(other.f1064a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f1066a, other2.from, other2.f1065to);
            }
        }

        int contentsCompareTo(boolean[] otherA, int otherAFrom, int otherATo) {
            if (this.f1066a == otherA && this.from == otherAFrom && this.f1065to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1065to && i < otherATo) {
                int r = Boolean.compare(this.f1066a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1065to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList
        public int compareTo(List<? extends Boolean> l) {
            if (l instanceof BooleanImmutableList) {
                BooleanImmutableList other = (BooleanImmutableList) l;
                return contentsCompareTo(other.f1064a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f1066a, other2.from, other2.f1065to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f1065to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
        public List<Boolean> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return BooleanImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, p014it.unimi.dsi.fastutil.booleans.BooleanList, java.util.List
    public List<Boolean> subList(int from, int to) {
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
    public BooleanImmutableList clone() {
        return this;
    }

    public boolean equals(BooleanImmutableList l) {
        if (l == this || this.f1064a == l.f1064a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f1064a, l.f1064a);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof BooleanImmutableList) {
            return equals((BooleanImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(BooleanImmutableList l) {
        if (this.f1064a == l.f1064a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        boolean[] a1 = this.f1064a;
        boolean[] a2 = l.f1064a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Boolean.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanList
    public int compareTo(List<? extends Boolean> l) {
        if (l instanceof BooleanImmutableList) {
            return compareTo((BooleanImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Boolean>) this);
        }
        return compareTo(l);
    }
}
