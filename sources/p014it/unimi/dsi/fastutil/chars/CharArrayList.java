package p014it.unimi.dsi.fastutil.chars;

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
import p014it.unimi.dsi.fastutil.chars.AbstractCharList;
import p014it.unimi.dsi.fastutil.chars.CharIterators;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.CharArrayList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayList.class */
public class CharArrayList extends AbstractCharList implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /* renamed from: a */
    protected transient char[] f1482a;
    protected int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !CharArrayList.class.desiredAssertionStatus();
    }

    private static final char[] copyArraySafe(char[] a, int length) {
        return length == 0 ? CharArrays.EMPTY_ARRAY : Arrays.copyOf(a, length);
    }

    private static final char[] copyArrayFromSafe(CharArrayList l) {
        return copyArraySafe(l.f1482a, l.size);
    }

    protected CharArrayList(char[] a, boolean wrapped) {
        this.f1482a = a;
    }

    private void initArrayFromCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Initial capacity (" + capacity + ") is negative");
        } else if (capacity == 0) {
            this.f1482a = CharArrays.EMPTY_ARRAY;
        } else {
            this.f1482a = new char[capacity];
        }
    }

    public CharArrayList(int capacity) {
        initArrayFromCapacity(capacity);
    }

    public CharArrayList() {
        this.f1482a = CharArrays.DEFAULT_EMPTY_ARRAY;
    }

    public CharArrayList(Collection<? extends Character> c) {
        if (c instanceof CharArrayList) {
            this.f1482a = copyArrayFromSafe((CharArrayList) c);
            this.size = this.f1482a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof CharList) {
            char[] cArr = this.f1482a;
            int size = c.size();
            this.size = size;
            ((CharList) c).getElements(0, cArr, 0, size);
            return;
        }
        this.size = CharIterators.unwrap(CharIterators.asCharIterator(c.iterator()), this.f1482a);
    }

    public CharArrayList(CharCollection c) {
        if (c instanceof CharArrayList) {
            this.f1482a = copyArrayFromSafe((CharArrayList) c);
            this.size = this.f1482a.length;
            return;
        }
        initArrayFromCapacity(c.size());
        if (c instanceof CharList) {
            char[] cArr = this.f1482a;
            int size = c.size();
            this.size = size;
            ((CharList) c).getElements(0, cArr, 0, size);
            return;
        }
        this.size = CharIterators.unwrap(c.iterator(), this.f1482a);
    }

    public CharArrayList(CharList l) {
        if (l instanceof CharArrayList) {
            this.f1482a = copyArrayFromSafe((CharArrayList) l);
            this.size = this.f1482a.length;
            return;
        }
        initArrayFromCapacity(l.size());
        char[] cArr = this.f1482a;
        int size = l.size();
        this.size = size;
        l.getElements(0, cArr, 0, size);
    }

    public CharArrayList(char[] a) {
        this(a, 0, a.length);
    }

    public CharArrayList(char[] a, int offset, int length) {
        this(length);
        System.arraycopy(a, offset, this.f1482a, 0, length);
        this.size = length;
    }

    public CharArrayList(Iterator<? extends Character> i) {
        this();
        while (i.hasNext()) {
            add(((Character) i.next()).charValue());
        }
    }

    public CharArrayList(CharIterator i) {
        this();
        while (i.hasNext()) {
            add(i.nextChar());
        }
    }

    public char[] elements() {
        return this.f1482a;
    }

    public static CharArrayList wrap(char[] a, int length) {
        if (length > a.length) {
            throw new IllegalArgumentException("The specified length (" + length + ") is greater than the array size (" + a.length + ")");
        }
        CharArrayList l = new CharArrayList(a, true);
        l.size = length;
        return l;
    }

    public static CharArrayList wrap(char[] a) {
        return wrap(a, a.length);
    }

    /* renamed from: of */
    public static CharArrayList m1008of() {
        return new CharArrayList();
    }

    /* renamed from: of */
    public static CharArrayList m1007of(char... init) {
        return wrap(init);
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= this.f1482a.length) {
            return;
        }
        if (this.f1482a != CharArrays.DEFAULT_EMPTY_ARRAY || capacity > 10) {
            this.f1482a = CharArrays.ensureCapacity(this.f1482a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1482a.length) {
                throw new AssertionError();
            }
        }
    }

    private void grow(int capacity) {
        if (capacity > this.f1482a.length) {
            if (this.f1482a != CharArrays.DEFAULT_EMPTY_ARRAY) {
                capacity = (int) Math.max(Math.min(((long) this.f1482a.length) + ((long) (this.f1482a.length >> 1)), 2147483639L), (long) capacity);
            } else if (capacity < 10) {
                capacity = 10;
            }
            this.f1482a = CharArrays.forceCapacity(this.f1482a, capacity, this.size);
            if (!$assertionsDisabled && this.size > this.f1482a.length) {
                throw new AssertionError();
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public void add(int index, char k) {
        ensureIndex(index);
        grow(this.size + 1);
        if (index != this.size) {
            System.arraycopy(this.f1482a, index, this.f1482a, index + 1, this.size - index);
        }
        this.f1482a[index] = k;
        this.size++;
        if (!$assertionsDisabled && this.size > this.f1482a.length) {
            throw new AssertionError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean add(char k) {
        grow(this.size + 1);
        char[] cArr = this.f1482a;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = k;
        if ($assertionsDisabled || this.size <= this.f1482a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public char getChar(int index) {
        if (index < this.size) {
            return this.f1482a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public int indexOf(char k) {
        for (int i = 0; i < this.size; i++) {
            if (k == this.f1482a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public int lastIndexOf(char k) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f1482a[i]);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public char removeChar(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        char old = this.f1482a[index];
        this.size--;
        if (index != this.size) {
            System.arraycopy(this.f1482a, index + 1, this.f1482a, index, this.size - index);
        }
        if ($assertionsDisabled || this.size <= this.f1482a.length) {
            return old;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean rem(char k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeChar(index);
        if ($assertionsDisabled || this.size <= this.f1482a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public char set(int index, char k) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.size + ")");
        }
        char old = this.f1482a[index];
        this.f1482a[index] = k;
        return old;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
        if (!$assertionsDisabled && this.size > this.f1482a.length) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public void size(int size) {
        if (size > this.f1482a.length) {
            this.f1482a = CharArrays.forceCapacity(this.f1482a, size, this.size);
        }
        if (size > this.size) {
            Arrays.fill(this.f1482a, this.size, size, (char) 0);
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
        if (n < this.f1482a.length && this.size != this.f1482a.length) {
            char[] t = new char[Math.max(n, this.size)];
            System.arraycopy(this.f1482a, 0, t, 0, this.size);
            this.f1482a = t;
            if (!$assertionsDisabled && this.size > this.f1482a.length) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharArrayList$SubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayList$SubList.class */
    public class SubList extends AbstractCharList.CharRandomAccessSubList {
        private static final long serialVersionUID = -3185226345314976296L;

        protected SubList(int from, int to) {
            super(CharArrayList.this, from, to);
        }

        private char[] getParentArray() {
            return CharArrayList.this.f1482a;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList.CharSubList, p014it.unimi.dsi.fastutil.chars.CharList
        public char getChar(int i) {
            ensureRestrictedIndex(i);
            return CharArrayList.this.f1482a[i + this.from];
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.CharArrayList$SubList$SubListIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayList$SubList$SubListIterator.class */
        public final class SubListIterator extends CharIterators.AbstractIndexBasedListIterator {
            SubListIterator(int index) {
                super(0, index);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final char get(int i) {
                return CharArrayList.this.f1482a[SubList.this.from + i];
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator
            protected final void add(int i, char k) {
                SubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator
            protected final void set(int i, char k) {
                SubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                SubList.this.removeChar(i);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return SubList.this.f1350to - SubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.chars.CharIterator
            public char nextChar() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                char[] cArr = CharArrayList.this.f1482a;
                int i = SubList.this.from;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.lastReturned = i2;
                return cArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
            public char previousChar() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                char[] cArr = CharArrayList.this.f1482a;
                int i = SubList.this.from;
                int i2 = this.pos - 1;
                this.pos = i2;
                this.lastReturned = i2;
                return cArr[i + i2];
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator, p014it.unimi.dsi.fastutil.chars.CharIterator
            public void forEachRemaining(CharConsumer action) {
                int max = SubList.this.f1350to - SubList.this.from;
                while (this.pos < max) {
                    char[] cArr = CharArrayList.this.f1482a;
                    int i = SubList.this.from;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    this.lastReturned = i2;
                    action.accept(cArr[i + i2]);
                }
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList.CharSubList, p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator(int index) {
            return new SubListIterator(index);
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.CharArrayList$SubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayList$SubList$SubListSpliterator.class */
        public final class SubListSpliterator extends CharSpliterators.LateBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(SubList.this.from);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.LateBindingSizeIndexBasedSpliterator
            protected final int getMaxPosFromBackingStore() {
                return SubList.this.f1350to;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            protected final char get(int i) {
                return CharArrayList.this.f1482a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(CharConsumer action) {
                if (this.pos >= getMaxPos()) {
                    return false;
                }
                char[] cArr = CharArrayList.this.f1482a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(cArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(CharConsumer action) {
                int max = getMaxPos();
                while (this.pos < max) {
                    char[] cArr = CharArrayList.this.f1482a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList.CharSubList, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(char[] otherA, int otherAFrom, int otherATo) {
            if (CharArrayList.this.f1482a == otherA && this.from == otherAFrom && this.f1350to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1350to) {
                pos++;
                otherPos++;
                if (CharArrayList.this.f1482a[pos] != otherA[otherPos]) {
                    return false;
                }
            }
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.Collection, java.lang.Object, java.util.List
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || !(o instanceof List)) {
                return false;
            }
            if (o instanceof CharArrayList) {
                CharArrayList other = (CharArrayList) o;
                return contentsEquals(other.f1482a, 0, other.size());
            } else if (!(o instanceof SubList)) {
                return equals(o);
            } else {
                SubList other2 = (SubList) o;
                return contentsEquals(other2.getParentArray(), other2.from, other2.f1350to);
            }
        }

        int contentsCompareTo(char[] otherA, int otherAFrom, int otherATo) {
            if (CharArrayList.this.f1482a == otherA && this.from == otherAFrom && this.f1350to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1350to && i < otherATo) {
                int r = Character.compare(CharArrayList.this.f1482a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1350to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList
        public int compareTo(List<? extends Character> l) {
            if (l instanceof CharArrayList) {
                CharArrayList other = (CharArrayList) l;
                return contentsCompareTo(other.f1482a, 0, other.size());
            } else if (!(l instanceof SubList)) {
                return compareTo(l);
            } else {
                SubList other2 = (SubList) l;
                return contentsCompareTo(other2.getParentArray(), other2.from, other2.f1350to);
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
    public List<Character> subList(int from, int to) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public void getElements(int from, char[] a, int offset, int length) {
        CharArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1482a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public void removeElements(int from, int to) {
        p014it.unimi.dsi.fastutil.Arrays.ensureFromTo(this.size, from, to);
        System.arraycopy(this.f1482a, to, this.f1482a, from, this.size - to);
        this.size -= to - from;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public void addElements(int index, char[] a, int offset, int length) {
        ensureIndex(index);
        CharArrays.ensureOffsetLength(a, offset, length);
        grow(this.size + length);
        System.arraycopy(this.f1482a, index, this.f1482a, index + length, this.size - index);
        System.arraycopy(a, offset, this.f1482a, index, length);
        this.size += length;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public void setElements(int index, char[] a, int offset, int length) {
        ensureIndex(index);
        CharArrays.ensureOffsetLength(a, offset, length);
        if (index + length > this.size) {
            throw new IndexOutOfBoundsException("End index (" + (index + length) + ") is greater than list size (" + this.size + ")");
        }
        System.arraycopy(a, offset, this.f1482a, index, length);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharIterable
    public void forEach(CharConsumer action) {
        for (int i = 0; i < this.size; i++) {
            action.accept(this.f1482a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public boolean addAll(int index, CharCollection c) {
        if (c instanceof CharList) {
            return addAll(index, (CharList) c);
        }
        ensureIndex(index);
        int n = c.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1482a, index, this.f1482a, index + n, this.size - index);
        CharIterator i = c.iterator();
        this.size += n;
        while (true) {
            n--;
            if (n == 0) {
                break;
            }
            index++;
            this.f1482a[index] = i.nextChar();
        }
        if ($assertionsDisabled || this.size <= this.f1482a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public boolean addAll(int index, CharList l) {
        ensureIndex(index);
        int n = l.size();
        if (n == 0) {
            return false;
        }
        grow(this.size + n);
        System.arraycopy(this.f1482a, index, this.f1482a, index + n, this.size - index);
        l.getElements(0, this.f1482a, index, n);
        this.size += n;
        if ($assertionsDisabled || this.size <= this.f1482a.length) {
            return true;
        }
        throw new AssertionError();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean removeAll(CharCollection c) {
        char[] a = this.f1482a;
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toArray(char[] a) {
        if (a == null || a.length < this.size) {
            a = Arrays.copyOf(a, this.size);
        }
        System.arraycopy(this.f1482a, 0, a, 0, this.size);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
    public ListIterator<Character> listIterator(final int index) {
        ensureIndex(index);
        return new CharListIterator() { // from class: it.unimi.dsi.fastutil.chars.CharArrayList.1
            int pos;
            int last = -1;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < CharArrayList.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.pos > 0;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
            public char nextChar() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                char[] cArr = CharArrayList.this.f1482a;
                int i = this.pos;
                this.pos = i + 1;
                this.last = i;
                return cArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
            public char previousChar() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                char[] cArr = CharArrayList.this.f1482a;
                int i = this.pos - 1;
                this.pos = i;
                this.last = i;
                return cArr[i];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.pos;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.pos - 1;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
            public void add(char k) {
                CharArrayList charArrayList = CharArrayList.this;
                int i = this.pos;
                this.pos = i + 1;
                charArrayList.add(i, k);
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
            public void set(char k) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                CharArrayList.this.set(this.last, k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                CharArrayList.this.removeChar(this.last);
                if (this.last < this.pos) {
                    this.pos--;
                }
                this.last = -1;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
            public void forEachRemaining(CharConsumer action) {
                while (this.pos < CharArrayList.this.size) {
                    char[] cArr = CharArrayList.this.f1482a;
                    int i = this.pos;
                    this.pos = i + 1;
                    this.last = i;
                    action.accept(cArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = CharArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                this.last = this.pos;
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = CharArrayList.this.size - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = CharArrayList.this.size;
                }
                this.last = this.pos - 1;
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharArrayList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayList$Spliterator.class */
    public final class Spliterator implements CharSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !CharArrayList.class.desiredAssertionStatus();
        }

        public Spliterator(CharArrayList charArrayList) {
            this(0, charArrayList.size, false);
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
            return this.hasSplit ? this.max : CharArrayList.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(CharConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            char[] cArr = CharArrayList.this.f1482a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(cArr[i]);
            return true;
        }

        public void forEachRemaining(CharConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(CharArrayList.this.f1482a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public CharSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public CharSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public void sort(CharComparator comp) {
        if (comp == null) {
            CharArrays.stableSort(this.f1482a, 0, this.size);
        } else {
            CharArrays.stableSort(this.f1482a, 0, this.size, comp);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public void unstableSort(CharComparator comp) {
        if (comp == null) {
            CharArrays.unstableSort(this.f1482a, 0, this.size);
        } else {
            CharArrays.unstableSort(this.f1482a, 0, this.size, comp);
        }
    }

    @Override // java.lang.Object
    public CharArrayList clone() {
        CharArrayList cloned;
        if (getClass() == CharArrayList.class) {
            cloned = new CharArrayList(copyArraySafe(this.f1482a, this.size), false);
            cloned.size = this.size;
        } else {
            try {
                cloned = (CharArrayList) clone();
                cloned.f1482a = copyArraySafe(this.f1482a, this.size);
            } catch (CloneNotSupportedException err) {
                throw new InternalError(err);
            }
        }
        return cloned;
    }

    public boolean equals(CharArrayList l) {
        if (l == this) {
            return true;
        }
        int s = size();
        if (s != l.size()) {
            return false;
        }
        char[] a1 = this.f1482a;
        char[] a2 = l.f1482a;
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof CharArrayList) {
            return equals((CharArrayList) o);
        }
        if (o instanceof SubList) {
            return ((SubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(CharArrayList l) {
        int s1 = size();
        int s2 = l.size();
        char[] a1 = this.f1482a;
        char[] a2 = l.f1482a;
        if (a1 == a2 && s1 == s2) {
            return 0;
        }
        int i = 0;
        while (i < s1 && i < s2) {
            int r = Character.compare(a1[i], a2[i]);
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList
    public int compareTo(List<? extends Character> l) {
        if (l instanceof CharArrayList) {
            return compareTo((CharArrayList) l);
        }
        if (l instanceof SubList) {
            return -((SubList) l).compareTo((List<? extends Character>) this);
        }
        return compareTo(l);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeChar(this.f1482a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1482a = new char[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1482a[i] = s.readChar();
        }
    }
}
