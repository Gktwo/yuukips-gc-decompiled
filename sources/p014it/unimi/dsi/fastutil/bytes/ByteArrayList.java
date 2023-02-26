package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteList;
import p014it.unimi.dsi.fastutil.bytes.ByteIterators;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayList.class */
public class ByteArrayList extends AbstractByteList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient byte[] f1219a;
    protected int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ByteArrayList.class.desiredAssertionStatus();
    }

    private static final byte[] copyArraySafe(byte[] a, int length) {
        return length == 0 ? ByteArrays.EMPTY_ARRAY : Arrays.copyOf(a, length);
    }

    private static final byte[] copyArrayFromSafe(ByteArrayList l) {
        return copyArraySafe(l.f1219a, l.size);
    }

    protected ByteArrayList(byte[] a, boolean wrapped) {
        this.f1219a = a;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f1219a = ByteArrays.EMPTY_ARRAY;
        } else {
            this.f1219a = new byte[capacity];
        }
    }

    public ByteArrayList(int capacity) {
        initArrayFromCapacity(capacity);
    }

    public ByteArrayList() {
        this.f1219a = ByteArrays.DEFAULT_EMPTY_ARRAY;
    }

    public ByteArrayList(Collection<? extends Byte> c) {
        if (c instanceof ByteArrayList) {
            this.f1219a = copyArrayFromSafe((ByteArrayList) c);
            this.size = this.f1219a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof ByteList) {
            byte[] bArr = this.f1219a;
            int size = c.size();
            this.size = size;
            ((ByteList) c).getElements(0, bArr, 0, size);
            return;
        }
        this.size = ByteIterators.unwrap(ByteIterators.asByteIterator(c.iterator()), this.f1219a);
    }

    public ByteArrayList(ByteCollection c) {
        if (c instanceof ByteArrayList) {
            this.f1219a = copyArrayFromSafe((ByteArrayList) c);
            this.size = this.f1219a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof ByteList) {
            byte[] bArr = this.f1219a;
            int size = c.size();
            this.size = size;
            ((ByteList) c).getElements(0, bArr, 0, size);
            return;
        }
        this.size = ByteIterators.unwrap(c.iterator(), this.f1219a);
    }

    public ByteArrayList(ByteList l) {
        if (l instanceof ByteArrayList) {
            this.f1219a = copyArrayFromSafe((ByteArrayList) l);
            this.size = this.f1219a.length;
            return;
        }
        initArrayFromCapacity(l.size());
        byte[] bArr = this.f1219a;
        int size = l.size();
        this.size = size;
        l.getElements(0, bArr, 0, size);
    }

    public ByteArrayList(byte[] a) {
        this(a, 0, a.length);
    }

    public ByteArrayList(byte[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f1219a, 0, length);
        this.size = length;
    }

    public ByteArrayList(Iterator<? extends Byte> i) {
        this();
        while (i.hasNext()) {
            add(((Byte) i.next()).byteValue());
        }
    }

    public ByteArrayList(ByteIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextByte());
        }
    }

    public byte[] elements() {
        return this.f1219a;
    }

    public static ByteArrayList wrap(byte[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        ByteArrayList l = new ByteArrayList(a, true);
        l.size = length;
        return l;
    }

    public static ByteArrayList wrap(byte[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static ByteArrayList m1093of() {
        return new ByteArrayList();
    }

    /* renamed from: of */
    public static ByteArrayList m1092of(byte... init) {
        return wrap(init);
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f1219a.length) {
            return;
        }
        if (this.f1219a != ByteArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            this.f1219a = ByteArrays.ensureCapacity(this.f1219a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1219a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f1219a.length) {
            if (this.f1219a != ByteArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f1219a.length) + ((long) (this.f1219a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f1219a = ByteArrays.forceCapacity(this.f1219a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1219a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public void add(int index, byte k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f1219a, index, this.f1219a, index + 1, this.size - index);
        }
        this.f1219a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f1219a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean add(byte k) {
        grow(this.size + 1);
        byte[] bArr = this.f1219a;
        int i = this.size;
        this.size = i + 1;
        bArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f1219a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public byte getByte(int index) {
        if (index < this.size) {
            return this.f1219a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public int indexOf(byte k) {
        for (int i = 0; i < this.size; i++) {
            if (k == this.f1219a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public int lastIndexOf(byte k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f1219a[i]);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public byte removeByte(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        byte old = this.f1219a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f1219a, index + 1, this.f1219a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= this.f1219a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean rem(byte k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeByte(index);
        if ($assertionsDisabled || this.size <= this.f1219a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public byte set(int index, byte k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        byte old = this.f1219a[index];
        this.f1219a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f1219a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public void size(int size) {
        if (size > this.f1219a.length) {
            this.f1219a = ByteArrays.forceCapacity(this.f1219a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f1219a, this.size, size, (byte) 0);
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
        if (n < this.f1219a.length && this.size != this.f1219a.length) {
            byte[] t = new byte[Math.max(n, this.size)];
            System.arraycopy(this.f1219a, 0, t, 0, this.size);
            this.f1219a = t;
            if (!$assertionsDisabled && this.size > this.f1219a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayList$SubList.class */
    public class SubList extends AbstractByteList.ByteRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(int from, int to) {
            super(ByteArrayList.this, from, to);
        }

        private byte[] getParentArray() {
            return ByteArrayList.this.f1219a;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList.ByteSubList, p014it.unimi.dsi.fastutil.bytes.ByteList
        public byte getByte(int i) {
            ensureRestrictedIndex(i);
            return ByteArrayList.this.f1219a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends ByteIterators.AbstractIndexBasedListIterator {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final byte get(int i) {
                return ByteArrayList.this.f1219a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator
            protected final void add(int i, byte k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator
            protected final void set(int i, byte k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.removeByte(i);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f1087to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public byte nextByte() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                byte[] bArr = ByteArrayList.this.f1219a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return bArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
            public byte previousByte() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                byte[] bArr = ByteArrayList.this.f1219a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return bArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public void forEachRemaining(ByteConsumer action) {
                int max = SubList.this.f1087to - SubList.this.from;
                while (this.pos < max) {
                    byte[] bArr = ByteArrayList.this.f1219a;
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept(bArr[i + i2]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList.ByteSubList, p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
        public ListIterator<Byte> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends ByteSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f1087to;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            protected final byte get(int i) {
                return ByteArrayList.this.f1219a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(ByteConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                byte[] bArr = ByteArrayList.this.f1219a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(bArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(ByteConsumer action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    byte[] bArr = ByteArrayList.this.f1219a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(bArr[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList.ByteSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(byte[] otherA, int otherAFrom, int otherATo) {
            if (ByteArrayList.this.f1219a == otherA && this.from == otherAFrom && this.f1087to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1087to) {
                pos++;
                otherPos++;
                if (ByteArrayList.this.f1219a[pos] != otherA[otherPos]) {
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
            if (o instanceof ByteArrayList) {
                ByteArrayList other = (ByteArrayList) o;
                return contentsEquals(other.f1219a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f1087to);
            }
        }

        int contentsCompareTo(byte[] otherA, int otherAFrom, int otherATo) {
            if (ByteArrayList.this.f1219a == otherA && this.from == otherAFrom && this.f1087to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1087to && i < otherATo) {
                int r = Byte.compare(ByteArrayList.this.f1219a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1087to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList
        public int compareTo(List<? extends Byte> l) {
            if (l instanceof ByteArrayList) {
                ByteArrayList other = (ByteArrayList) l;
                return contentsCompareTo(other.f1219a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f1087to);
            }
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
        if (from <= to) {
            return new SubList(from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public void getElements(int from, byte[] a, int offset, int length) {
        ByteArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1219a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f1219a, to, this.f1219a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public void addElements(int index, byte[] a, int offset, int length) {
        ensureIndex(index);
        ByteArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f1219a, index, this.f1219a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f1219a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public void setElements(int index, byte[] a, int offset, int length) {
        ensureIndex(index);
        ByteArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f1219a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteIterable
    public void forEach(ByteConsumer action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.f1219a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList
    public boolean addAll(int index, ByteCollection c) {
        if (c instanceof ByteList) {
            return addAll(index, (ByteList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1219a, index, this.f1219a, index + n, this.size - index);
        ByteIterator i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f1219a[index] = i.nextByte();
        }
        if ($assertionsDisabled || this.size <= this.f1219a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public boolean addAll(int index, ByteList l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1219a, index, this.f1219a, index + n, this.size - index);
        l.getElements(0, this.f1219a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f1219a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean removeAll(ByteCollection c) {
        byte[] a = this.f1219a;
        int j = 0;
        for (int i = 0; i < this.size; i++) {
            if (!c.contains(a[i])) {
                j++;
                a[j] = a[i];
            }
        }
        boolean modified = this.size != j;
        this.size = j;
        return modified;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toArray(byte[] a) {
        if (a == null || a.length < this.size) {
            a = Arrays.copyOf(a, this.size);
        }
        System.arraycopy(this.f1219a, 0, a, 0, this.size);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, p014it.unimi.dsi.fastutil.bytes.ByteList, java.util.List
    public ListIterator<Byte> listIterator(final int index) {
        ensureIndex(index);
        return new ByteListIterator() { // from class: it.unimi.dsi.fastutil.bytes.ByteArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < ByteArrayList.this.size;
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
                byte[] bArr = ByteArrayList.this.f1219a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return bArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
            public byte previousByte() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                byte[] bArr = ByteArrayList.this.f1219a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
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

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
            public void add(byte k) {
                ByteArrayList byteArrayList = ByteArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                byteArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
            public void set(byte k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ByteArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ByteArrayList.this.removeByte(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public void forEachRemaining(ByteConsumer action) {
                while (this.pos < ByteArrayList.this.size) {
                    byte[] bArr = ByteArrayList.this.f1219a;
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept(bArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ByteArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ByteArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = ByteArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArrayList$Spliterator.class */
    public final class Spliterator implements ByteSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ByteArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(ByteArrayList byteArrayList) {
            this(0, byteArrayList.size, false);
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
            return this.hasSplit ? this.max : ByteArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(ByteConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            byte[] bArr = ByteArrayList.this.f1219a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(bArr[i]);
            return true;
        }

        public void forEachRemaining(ByteConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(ByteArrayList.this.f1219a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ByteSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public ByteSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public void sort(ByteComparator comp) {
        if (comp == null) {
            ByteArrays.stableSort(this.f1219a, 0, this.size);
        } else {
            ByteArrays.stableSort(this.f1219a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteList
    public void unstableSort(ByteComparator comp) {
        if (comp == null) {
            ByteArrays.unstableSort(this.f1219a, 0, this.size);
        } else {
            ByteArrays.unstableSort(this.f1219a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public ByteArrayList clone() {
        ByteArrayList cloned;
        if (getClass() == ByteArrayList.class) {
            cloned = new ByteArrayList(copyArraySafe(this.f1219a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (ByteArrayList) clone();
                cloned.f1219a = copyArraySafe(this.f1219a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(ByteArrayList l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        byte[] a1 = this.f1219a;
        byte[] a2 = l.f1219a;
        if (a1 == a2 && s == l.size()) {
            return true;
        }
        do {
            s--;
            if (s == 0) {
                return true;
            }
        } while (a1[s] == a2[s]);
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof ByteArrayList) {
            return equals((ByteArrayList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(ByteArrayList l) {
        int s1 = size();
        int s2 = l.size();
        byte[] a1 = this.f1219a;
        byte[] a2 = l.f1219a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
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
        if (l instanceof ByteArrayList) {
            return compareTo((ByteArrayList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List<? extends Byte>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeByte(this.f1219a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1219a = new byte[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1219a[i] = s.readByte();
        }
    }
}
