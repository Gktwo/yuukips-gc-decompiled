package p014it.unimi.dsi.fastutil.bytes;

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
import p014it.unimi.dsi.fastutil.bytes.ByteLists;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteImmutableList.class */
public class ByteImmutableList extends ByteLists.ImmutableListBase implements ByteList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final ByteImmutableList EMPTY = new ByteImmutableList(ByteArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final byte[] f1276a;

    public ByteImmutableList(byte[] a) {
        this.f1276a = a;
    }

    public ByteImmutableList(Collection<? extends Byte> c) {
        this(c.isEmpty() ? ByteArrays.EMPTY_ARRAY : ByteIterators.unwrap(ByteIterators.asByteIterator(c.iterator())));
    }

    public ByteImmutableList(ByteCollection c) {
        this(c.isEmpty() ? ByteArrays.EMPTY_ARRAY : ByteIterators.unwrap(c.iterator()));
    }

    public ByteImmutableList(ByteList l) {
        this(l.isEmpty() ? ByteArrays.EMPTY_ARRAY : new byte[l.size()]);
        l.getElements(0, this.f1276a, 0, l.size());
    }

    public ByteImmutableList(byte[] a, int offset, int length) {
        this(length == 0 ? ByteArrays.EMPTY_ARRAY : new byte[length]);
        System.arraycopy(a, offset, this.f1276a, 0, length);
    }

    public ByteImmutableList(ByteIterator i) {
        this(i.hasNext() ? ByteIterators.unwrap(i) : ByteArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static ByteImmutableList m1069of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static ByteImmutableList m1068of(byte... init) {
        return init.length == 0 ? m1069of() : new ByteImmutableList(init);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public byte getByte(int index) {
        if (index < this.f1276a.length) {
            return this.f1276a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f1276a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public int indexOf(byte k) {
        int size = this.f1276a.length;
        for (int i = 0; i < size; i++) {
            if (k == this.f1276a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public int lastIndexOf(byte k) {
        int i = this.f1276a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f1276a[i]);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1276a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f1276a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public void getElements(int from, byte[] a, int offset, int length) {
        ByteArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1276a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteIterable
    public void forEach(ByteConsumer action) {
        for (int i = 0; i < this.f1276a.length; i++) {
            action.accept(this.f1276a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toByteArray() {
        return (byte[]) this.f1276a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toArray(byte[] a) {
        if (a == null || a.length < size()) {
            a = new byte[this.f1276a.length];
        }
        System.arraycopy(this.f1276a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
    public ListIterator<Byte> listIterator(final int index) {
        ensureIndex(index);
        return new ByteListIterator() { // from class: it.unimi.dsi.fastutil.bytes.ByteImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < ByteImmutableList.this.f1276a.length;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public byte nextByte() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                byte[] bArr = ByteImmutableList.this.f1276a;
                int i = this.pos;
                this.pos = i + 1;
                return bArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
            public byte previousByte() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                byte[] bArr = ByteImmutableList.this.f1276a;
                int i = this.pos - 1;
                this.pos = i;
                return bArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public void forEachRemaining(ByteConsumer action) {
                while (this.pos < ByteImmutableList.this.f1276a.length) {
                    byte[] bArr = ByteImmutableList.this.f1276a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
            public void add(byte k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
            public void set(byte k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ByteImmutableList.this.f1276a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ByteImmutableList.this.f1276a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = ByteImmutableList.this.f1276a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteImmutableList$Spliterator.class */
    public final class Spliterator implements ByteSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ByteImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(ByteImmutableList byteImmutableList) {
            this(0, byteImmutableList.f1276a.length);
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

        public boolean tryAdvance(ByteConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            byte[] bArr = ByteImmutableList.this.f1276a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(bArr[i]);
            return true;
        }

        public void forEachRemaining(ByteConsumer action) {
            while (this.pos < this.max) {
                action.accept(ByteImmutableList.this.f1276a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ByteSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public ByteSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends ByteLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final ByteImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f1277to;

        /* renamed from: a */
        final transient byte[] f1278a;

        ImmutableSubList(ByteImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f1277to = to;
            this.f1278a = innerList.f1276a;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte getByte(int index) {
            ensureRestrictedIndex(index);
            return this.f1278a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public int indexOf(byte k) {
            for (int i = this.from; i < this.f1277to; i++) {
                if (k == this.f1278a[i]) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public int lastIndexOf(byte k) {
            int i = this.f1277to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (k != this.f1278a[i]);
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1277to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f1277to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public void getElements(int fromSublistIndex, byte[] a, int offset, int length) {
            ByteArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f1277to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f1278a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer action) {
            for (int i = this.from; i < this.f1277to; i++) {
                action.accept(this.f1278a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toByteArray() {
            return Arrays.copyOfRange(this.f1278a, this.from, this.f1277to);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public byte[] toArray(byte[] a) {
            if (a == null || a.length < size()) {
                a = new byte[size()];
            }
            System.arraycopy(this.f1278a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator(final int index) {
            ensureIndex(index);
            return new ByteListIterator() { // from class: it.unimi.dsi.fastutil.bytes.ByteImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f1277to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public byte nextByte() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = ImmutableSubList.this.f1278a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return bArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
                public byte previousByte() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    byte[] bArr = ImmutableSubList.this.f1278a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return bArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                public void forEachRemaining(ByteConsumer action) {
                    while (this.pos < ImmutableSubList.this.f1277to) {
                        byte[] bArr = ImmutableSubList.this.f1278a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(bArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
                public void add(byte k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
                public void set(byte k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1277to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1277to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f1277to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.ByteImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ByteSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f1277to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            protected final byte get(int i) {
                return ImmutableSubList.this.f1278a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(ByteConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                byte[] bArr = ImmutableSubList.this.f1278a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(bArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    byte[] bArr = ImmutableSubList.this.f1278a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(byte[] otherA, int otherAFrom, int otherATo) {
            if (this.f1278a == otherA && this.from == otherAFrom && this.f1277to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1277to) {
                pos++;
                otherPos++;
                if (this.f1278a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof ByteImmutableList) {
                ByteImmutableList other = (ByteImmutableList) o;
                return contentsEquals(other.f1276a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f1278a, other2.from, other2.f1277to);
            }
        }

        int contentsCompareTo(byte[] otherA, int otherAFrom, int otherATo) {
            if (this.f1278a == otherA && this.from == otherAFrom && this.f1277to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1277to && i < otherATo) {
                int r = Byte.compare(this.f1278a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1277to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList
        public int compareTo(List<? extends Byte> l) {
            if (l instanceof ByteImmutableList) {
                ByteImmutableList other = (ByteImmutableList) l;
                return contentsCompareTo(other.f1276a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f1278a, other2.from, other2.f1277to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f1277to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public List<Byte> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return ByteImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
    public List<Byte> subList(int from, int to) {
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
    public ByteImmutableList clone() {
        return this;
    }

    public boolean equals(ByteImmutableList l) {
        if (l == this || this.f1276a == l.f1276a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f1276a, l.f1276a);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof ByteImmutableList) {
            return equals((ByteImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ByteImmutableList l) {
        if (this.f1276a == l.f1276a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        byte[] a1 = this.f1276a;
        byte[] a2 = l.f1276a;
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Byte.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList
    public int compareTo(List<? extends Byte> l) {
        if (l instanceof ByteImmutableList) {
            return compareTo((ByteImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Byte>) this);
        }
        return compareTo(l);
    }
}
