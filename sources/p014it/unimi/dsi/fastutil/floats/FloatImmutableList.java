package p014it.unimi.dsi.fastutil.floats;

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
import p014it.unimi.dsi.fastutil.floats.FloatLists;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatImmutableList.class */
public class FloatImmutableList extends FloatLists.ImmutableListBase implements FloatList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final FloatImmutableList EMPTY = new FloatImmutableList(FloatArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final float[] f1907a;

    public FloatImmutableList(float[] a) {
        this.f1907a = a;
    }

    public FloatImmutableList(Collection<? extends Float> c) {
        this(c.isEmpty() ? FloatArrays.EMPTY_ARRAY : FloatIterators.unwrap(FloatIterators.asFloatIterator(c.iterator())));
    }

    public FloatImmutableList(FloatCollection c) {
        this(c.isEmpty() ? FloatArrays.EMPTY_ARRAY : FloatIterators.unwrap(c.iterator()));
    }

    public FloatImmutableList(FloatList l) {
        this(l.isEmpty() ? FloatArrays.EMPTY_ARRAY : new float[l.size()]);
        l.getElements(0, this.f1907a, 0, l.size());
    }

    public FloatImmutableList(float[] a, int offset, int length) {
        this(length == 0 ? FloatArrays.EMPTY_ARRAY : new float[length]);
        System.arraycopy(a, offset, this.f1907a, 0, length);
    }

    public FloatImmutableList(FloatIterator i) {
        this(i.hasNext() ? FloatIterators.unwrap(i) : FloatArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static FloatImmutableList m815of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static FloatImmutableList m814of(float... init) {
        return init.length == 0 ? m815of() : new FloatImmutableList(init);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatList
    public float getFloat(int index) {
        if (index < this.f1907a.length) {
            return this.f1907a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f1907a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public int indexOf(float k) {
        int size = this.f1907a.length;
        for (int i = 0; i < size; i++) {
            if (Float.floatToIntBits(k) == Float.floatToIntBits(this.f1907a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public int lastIndexOf(float k) {
        int i = this.f1907a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(this.f1907a[i]));
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1907a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f1907a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
    public void getElements(int from, float[] a, int offset, int length) {
        FloatArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1907a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public void forEach(FloatConsumer action) {
        for (int i = 0; i < this.f1907a.length; i++) {
            action.accept(this.f1907a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toFloatArray() {
        return (float[]) this.f1907a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toArray(float[] a) {
        if (a == null || a.length < size()) {
            a = new float[this.f1907a.length];
        }
        System.arraycopy(this.f1907a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
    public ListIterator<Float> listIterator(final int index) {
        ensureIndex(index);
        return new FloatListIterator() { // from class: it.unimi.dsi.fastutil.floats.FloatImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < FloatImmutableList.this.f1907a.length;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                float[] fArr = FloatImmutableList.this.f1907a;
                int i = this.pos;
                this.pos = i + 1;
                return fArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            public float previousFloat() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                float[] fArr = FloatImmutableList.this.f1907a;
                int i = this.pos - 1;
                this.pos = i;
                return fArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public void forEachRemaining(FloatConsumer action) {
                while (this.pos < FloatImmutableList.this.f1907a.length) {
                    float[] fArr = FloatImmutableList.this.f1907a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
            public void add(float k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
            public void set(float k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = FloatImmutableList.this.f1907a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = FloatImmutableList.this.f1907a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = FloatImmutableList.this.f1907a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatImmutableList$Spliterator.class */
    public final class Spliterator implements FloatSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !FloatImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(FloatImmutableList floatImmutableList) {
            this(0, floatImmutableList.f1907a.length);
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

        public boolean tryAdvance(FloatConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            float[] fArr = FloatImmutableList.this.f1907a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(fArr[i]);
            return true;
        }

        public void forEachRemaining(FloatConsumer action) {
            while (this.pos < this.max) {
                action.accept(FloatImmutableList.this.f1907a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends FloatLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final FloatImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f1908to;

        /* renamed from: a */
        final transient float[] f1909a;

        ImmutableSubList(FloatImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f1908to = to;
            this.f1909a = innerList.f1907a;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatList
        public float getFloat(int index) {
            ensureRestrictedIndex(index);
            return this.f1909a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public int indexOf(float k) {
            for (int i = this.from; i < this.f1908to; i++) {
                if (Float.floatToIntBits(k) == Float.floatToIntBits(this.f1909a[i])) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public int lastIndexOf(float k) {
            int i = this.f1908to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (Float.floatToIntBits(k) != Float.floatToIntBits(this.f1909a[i]));
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1908to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f1908to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList
        public void getElements(int fromSublistIndex, float[] a, int offset, int length) {
            FloatArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f1908to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f1909a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer action) {
            for (int i = this.from; i < this.f1908to; i++) {
                action.accept(this.f1909a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public float[] toFloatArray() {
            return Arrays.copyOfRange(this.f1909a, this.from, this.f1908to);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public float[] toArray(float[] a) {
            if (a == null || a.length < size()) {
                a = new float[size()];
            }
            System.arraycopy(this.f1909a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public ListIterator<Float> listIterator(final int index) {
            ensureIndex(index);
            return new FloatListIterator() { // from class: it.unimi.dsi.fastutil.floats.FloatImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f1908to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public float nextFloat() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = ImmutableSubList.this.f1909a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return fArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
                public float previousFloat() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    float[] fArr = ImmutableSubList.this.f1909a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return fArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                public void forEachRemaining(FloatConsumer action) {
                    while (this.pos < ImmutableSubList.this.f1908to) {
                        float[] fArr = ImmutableSubList.this.f1909a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(fArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
                public void add(float k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
                public void set(float k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1908to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1908to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f1908to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.FloatImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends FloatSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f1908to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            protected final float get(int i) {
                return ImmutableSubList.this.f1909a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(FloatConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                float[] fArr = ImmutableSubList.this.f1909a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(fArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(FloatConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    float[] fArr = ImmutableSubList.this.f1909a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(fArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(float[] otherA, int otherAFrom, int otherATo) {
            if (this.f1909a == otherA && this.from == otherAFrom && this.f1908to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1908to) {
                pos++;
                otherPos++;
                if (this.f1909a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof FloatImmutableList) {
                FloatImmutableList other = (FloatImmutableList) o;
                return contentsEquals(other.f1907a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f1909a, other2.from, other2.f1908to);
            }
        }

        int contentsCompareTo(float[] otherA, int otherAFrom, int otherATo) {
            if (this.f1909a == otherA && this.from == otherAFrom && this.f1908to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1908to && i < otherATo) {
                int r = Float.compare(this.f1909a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1908to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList
        public int compareTo(List<? extends Float> l) {
            if (l instanceof FloatImmutableList) {
                FloatImmutableList other = (FloatImmutableList) l;
                return contentsCompareTo(other.f1907a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f1909a, other2.from, other2.f1908to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f1908to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
        public List<Float> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return FloatImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, p014it.unimi.dsi.fastutil.floats.FloatList, java.util.List
    public List<Float> subList(int from, int to) {
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
    public FloatImmutableList clone() {
        return this;
    }

    public boolean equals(FloatImmutableList l) {
        if (l == this || this.f1907a == l.f1907a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f1907a, l.f1907a);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof FloatImmutableList) {
            return equals((FloatImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(FloatImmutableList l) {
        if (this.f1907a == l.f1907a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        float[] a1 = this.f1907a;
        float[] a2 = l.f1907a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Float.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatList
    public int compareTo(List<? extends Float> l) {
        if (l instanceof FloatImmutableList) {
            return compareTo((FloatImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Float>) this);
        }
        return compareTo(l);
    }
}
