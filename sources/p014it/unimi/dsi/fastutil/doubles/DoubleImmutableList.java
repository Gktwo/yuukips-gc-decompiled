package p014it.unimi.dsi.fastutil.doubles;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.doubles.DoubleLists;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleImmutableList.class */
public class DoubleImmutableList extends DoubleLists.ImmutableListBase implements DoubleList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final DoubleImmutableList EMPTY = new DoubleImmutableList(DoubleArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final double[] f1686a;

    public DoubleImmutableList(double[] a) {
        this.f1686a = a;
    }

    public DoubleImmutableList(Collection<? extends Double> c) {
        this(c.isEmpty() ? DoubleArrays.EMPTY_ARRAY : DoubleIterators.unwrap(DoubleIterators.asDoubleIterator(c.iterator())));
    }

    public DoubleImmutableList(DoubleCollection c) {
        this(c.isEmpty() ? DoubleArrays.EMPTY_ARRAY : DoubleIterators.unwrap(c.iterator()));
    }

    public DoubleImmutableList(DoubleList l) {
        this(l.isEmpty() ? DoubleArrays.EMPTY_ARRAY : new double[l.size()]);
        l.getElements(0, this.f1686a, 0, l.size());
    }

    public DoubleImmutableList(double[] a, int offset, int length) {
        this(length == 0 ? DoubleArrays.EMPTY_ARRAY : new double[length]);
        System.arraycopy(a, offset, this.f1686a, 0, length);
    }

    public DoubleImmutableList(DoubleIterator i) {
        this(i.hasNext() ? DoubleIterators.unwrap(i) : DoubleArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static DoubleImmutableList m899of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static DoubleImmutableList m898of(double... init) {
        return init.length == 0 ? m899of() : new DoubleImmutableList(init);
    }

    private static DoubleImmutableList convertTrustedToImmutableList(DoubleArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return m899of();
        }
        double[] backingArray = arrayList.elements();
        if (arrayList.size() != backingArray.length) {
            backingArray = Arrays.copyOf(backingArray, arrayList.size());
        }
        return new DoubleImmutableList(backingArray);
    }

    public static DoubleImmutableList toList(DoubleStream stream) {
        return convertTrustedToImmutableList(DoubleArrayList.toList(stream));
    }

    public static DoubleImmutableList toListWithExpectedSize(DoubleStream stream, int expectedSize) {
        return convertTrustedToImmutableList(DoubleArrayList.toListWithExpectedSize(stream, expectedSize));
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
    public double getDouble(int index) {
        if (index < this.f1686a.length) {
            return this.f1686a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f1686a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public int indexOf(double k) {
        int size = this.f1686a.length;
        for (int i = 0; i < size; i++) {
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(this.f1686a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public int lastIndexOf(double k) {
        int i = this.f1686a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(this.f1686a[i]));
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1686a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f1686a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
    public void getElements(int from, double[] a, int offset, int length) {
        DoubleArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1686a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public void forEach(DoubleConsumer action) {
        for (int i = 0; i < this.f1686a.length; i++) {
            action.accept(this.f1686a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toDoubleArray() {
        return (double[]) this.f1686a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toArray(double[] a) {
        if (a == null || a.length < size()) {
            a = new double[this.f1686a.length];
        }
        System.arraycopy(this.f1686a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
    public ListIterator<Double> listIterator(final int index) {
        ensureIndex(index);
        return new DoubleListIterator() { // from class: it.unimi.dsi.fastutil.doubles.DoubleImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < DoubleImmutableList.this.f1686a.length;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
            public double nextDouble() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                double[] dArr = DoubleImmutableList.this.f1686a;
                int i = this.pos;
                this.pos = i + 1;
                return dArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
            public double previousDouble() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                double[] dArr = DoubleImmutableList.this.f1686a;
                int i = this.pos - 1;
                this.pos = i;
                return dArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                while (this.pos < DoubleImmutableList.this.f1686a.length) {
                    double[] dArr = DoubleImmutableList.this.f1686a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
            public void add(double k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
            public void set(double k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = DoubleImmutableList.this.f1686a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = DoubleImmutableList.this.f1686a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = DoubleImmutableList.this.f1686a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleImmutableList$Spliterator.class */
    public final class Spliterator implements DoubleSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !DoubleImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(DoubleImmutableList doubleImmutableList) {
            this(0, doubleImmutableList.f1686a.length);
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

        @Override // java.util.Spliterator.OfDouble
        public boolean tryAdvance(DoubleConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            double[] dArr = DoubleImmutableList.this.f1686a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(dArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            while (this.pos < this.max) {
                action.accept(DoubleImmutableList.this.f1686a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public DoubleSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends DoubleLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final DoubleImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f1687to;

        /* renamed from: a */
        final transient double[] f1688a;

        ImmutableSubList(DoubleImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f1687to = to;
            this.f1688a = innerList.f1686a;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleList
        public double getDouble(int index) {
            ensureRestrictedIndex(index);
            return this.f1688a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int indexOf(double k) {
            for (int i = this.from; i < this.f1687to; i++) {
                if (Double.doubleToLongBits(k) == Double.doubleToLongBits(this.f1688a[i])) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public int lastIndexOf(double k) {
            int i = this.f1687to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(this.f1688a[i]));
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1687to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f1687to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList
        public void getElements(int fromSublistIndex, double[] a, int offset, int length) {
            DoubleArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f1687to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f1688a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer action) {
            for (int i = this.from; i < this.f1687to; i++) {
                action.accept(this.f1688a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.f1688a, this.from, this.f1687to);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public double[] toArray(double[] a) {
            if (a == null || a.length < size()) {
                a = new double[size()];
            }
            System.arraycopy(this.f1688a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public ListIterator<Double> listIterator(final int index) {
            ensureIndex(index);
            return new DoubleListIterator() { // from class: it.unimi.dsi.fastutil.doubles.DoubleImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f1687to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                public double nextDouble() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = ImmutableSubList.this.f1688a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return dArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
                public double previousDouble() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    double[] dArr = ImmutableSubList.this.f1688a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return dArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // java.util.PrimitiveIterator.OfDouble
                public void forEachRemaining(DoubleConsumer action) {
                    while (this.pos < ImmutableSubList.this.f1687to) {
                        double[] dArr = ImmutableSubList.this.f1688a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(dArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
                public void add(double k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
                public void set(double k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1687to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1687to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f1687to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends DoubleSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f1687to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            protected final double get(int i) {
                return ImmutableSubList.this.f1688a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public boolean tryAdvance(DoubleConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                double[] dArr = ImmutableSubList.this.f1688a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(dArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator.OfDouble
            public void forEachRemaining(DoubleConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    double[] dArr = ImmutableSubList.this.f1688a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(dArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(double[] otherA, int otherAFrom, int otherATo) {
            if (this.f1688a == otherA && this.from == otherAFrom && this.f1687to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1687to) {
                pos++;
                otherPos++;
                if (this.f1688a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof DoubleImmutableList) {
                DoubleImmutableList other = (DoubleImmutableList) o;
                return contentsEquals(other.f1686a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f1688a, other2.from, other2.f1687to);
            }
        }

        int contentsCompareTo(double[] otherA, int otherAFrom, int otherATo) {
            if (this.f1688a == otherA && this.from == otherAFrom && this.f1687to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1687to && i < otherATo) {
                int r = Double.compare(this.f1688a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1687to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList
        public int compareTo(List<? extends Double> l) {
            if (l instanceof DoubleImmutableList) {
                DoubleImmutableList other = (DoubleImmutableList) l;
                return contentsCompareTo(other.f1686a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f1688a, other2.from, other2.f1687to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f1687to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
        public List<Double> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return DoubleImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, p014it.unimi.dsi.fastutil.doubles.DoubleList, java.util.List
    public List<Double> subList(int from, int to) {
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
    public DoubleImmutableList clone() {
        return this;
    }

    public boolean equals(DoubleImmutableList l) {
        if (l == this || this.f1686a == l.f1686a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f1686a, l.f1686a);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof DoubleImmutableList) {
            return equals((DoubleImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(DoubleImmutableList l) {
        if (this.f1686a == l.f1686a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        double[] a1 = this.f1686a;
        double[] a2 = l.f1686a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Double.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleList
    public int compareTo(List<? extends Double> l) {
        if (l instanceof DoubleImmutableList) {
            return compareTo((DoubleImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Double>) this);
        }
        return compareTo(l);
    }
}
