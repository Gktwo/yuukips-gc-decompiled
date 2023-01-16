package p014it.unimi.dsi.fastutil.chars;

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
import p014it.unimi.dsi.fastutil.chars.CharLists;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.CharImmutableList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharImmutableList.class */
public class CharImmutableList extends CharLists.ImmutableListBase implements CharList, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 0;
    static final CharImmutableList EMPTY = new CharImmutableList(CharArrays.EMPTY_ARRAY);

    /* renamed from: a */
    private final char[] f1503a;

    public CharImmutableList(char[] a) {
        this.f1503a = a;
    }

    public CharImmutableList(Collection<? extends Character> c) {
        this(c.isEmpty() ? CharArrays.EMPTY_ARRAY : CharIterators.unwrap(CharIterators.asCharIterator(c.iterator())));
    }

    public CharImmutableList(CharCollection c) {
        this(c.isEmpty() ? CharArrays.EMPTY_ARRAY : CharIterators.unwrap(c.iterator()));
    }

    public CharImmutableList(CharList l) {
        this(l.isEmpty() ? CharArrays.EMPTY_ARRAY : new char[l.size()]);
        l.getElements(0, this.f1503a, 0, l.size());
    }

    public CharImmutableList(char[] a, int offset, int length) {
        this(length == 0 ? CharArrays.EMPTY_ARRAY : new char[length]);
        System.arraycopy(a, offset, this.f1503a, 0, length);
    }

    public CharImmutableList(CharIterator i) {
        this(i.hasNext() ? CharIterators.unwrap(i) : CharArrays.EMPTY_ARRAY);
    }

    /* renamed from: of */
    public static CharImmutableList m984of() {
        return EMPTY;
    }

    /* renamed from: of */
    public static CharImmutableList m983of(char... init) {
        return init.length == 0 ? m984of() : new CharImmutableList(init);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public char getChar(int index) {
        if (index < this.f1503a.length) {
            return this.f1503a[index];
        }
        throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + this.f1503a.length + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public int indexOf(char k) {
        int size = this.f1503a.length;
        for (int i = 0; i < size; i++) {
            if (k == this.f1503a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public int lastIndexOf(char k) {
        int i = this.f1503a.length;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (k != this.f1503a[i]);
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1503a.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    public boolean isEmpty() {
        return this.f1503a.length == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
    public void getElements(int from, char[] a, int offset, int length) {
        CharArrays.ensureOffsetLength(a, offset, length);
        System.arraycopy(this.f1503a, from, a, offset, length);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharIterable
    public void forEach(CharConsumer action) {
        for (int i = 0; i < this.f1503a.length; i++) {
            action.accept(this.f1503a[i]);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toCharArray() {
        return (char[]) this.f1503a.clone();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toArray(char[] a) {
        if (a == null || a.length < size()) {
            a = new char[this.f1503a.length];
        }
        System.arraycopy(this.f1503a, 0, a, 0, a.length);
        return a;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
    public ListIterator<Character> listIterator(final int index) {
        ensureIndex(index);
        return new CharListIterator() { // from class: it.unimi.dsi.fastutil.chars.CharImmutableList.1
            int pos;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.pos = index;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.pos < CharImmutableList.this.f1503a.length;
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
                char[] cArr = CharImmutableList.this.f1503a;
                int i = this.pos;
                this.pos = i + 1;
                return cArr[i];
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
            public char previousChar() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                char[] cArr = CharImmutableList.this.f1503a;
                int i = this.pos - 1;
                this.pos = i;
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

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
            public void forEachRemaining(CharConsumer action) {
                while (this.pos < CharImmutableList.this.f1503a.length) {
                    char[] cArr = CharImmutableList.this.f1503a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
            public void add(char k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
            public void set(char k) {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = CharImmutableList.this.f1503a.length - this.pos;
                if (n < remaining) {
                    this.pos -= n;
                } else {
                    n = remaining;
                    this.pos = 0;
                }
                return n;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = CharImmutableList.this.f1503a.length - this.pos;
                if (n < remaining) {
                    this.pos += n;
                } else {
                    n = remaining;
                    this.pos = CharImmutableList.this.f1503a.length;
                }
                return n;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharImmutableList$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharImmutableList$Spliterator.class */
    public final class Spliterator implements CharSpliterator {
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !CharImmutableList.class.desiredAssertionStatus();
        }

        public Spliterator(CharImmutableList charImmutableList) {
            this(0, charImmutableList.f1503a.length);
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

        public boolean tryAdvance(CharConsumer action) {
            if (this.pos >= this.max) {
                return false;
            }
            char[] cArr = CharImmutableList.this.f1503a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(cArr[i]);
            return true;
        }

        public void forEachRemaining(CharConsumer action) {
            while (this.pos < this.max) {
                action.accept(CharImmutableList.this.f1503a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public CharSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public CharSpliterator spliterator() {
        return new Spliterator(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharImmutableList$ImmutableSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharImmutableList$ImmutableSubList.class */
    public static final class ImmutableSubList extends CharLists.ImmutableListBase implements RandomAccess, Serializable {
        private static final long serialVersionUID = 7054639518438982401L;
        final CharImmutableList innerList;
        final int from;

        /* renamed from: to */
        final int f1504to;

        /* renamed from: a */
        final transient char[] f1505a;

        ImmutableSubList(CharImmutableList innerList, int from, int to) {
            this.innerList = innerList;
            this.from = from;
            this.f1504to = to;
            this.f1505a = innerList.f1503a;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char getChar(int index) {
            ensureRestrictedIndex(index);
            return this.f1505a[index + this.from];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public int indexOf(char k) {
            for (int i = this.from; i < this.f1504to; i++) {
                if (k == this.f1505a[i]) {
                    return i - this.from;
                }
            }
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public int lastIndexOf(char k) {
            int i = this.f1504to;
            do {
                i--;
                if (i == this.from) {
                    return -1;
                }
            } while (k != this.f1505a[i]);
            return i - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1504to - this.from;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
        public boolean isEmpty() {
            return this.f1504to <= this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void getElements(int fromSublistIndex, char[] a, int offset, int length) {
            CharArrays.ensureOffsetLength(a, offset, length);
            ensureRestrictedIndex(fromSublistIndex);
            if (this.from + length > this.f1504to) {
                throw new IndexOutOfBoundsException("Final index " + (this.from + length) + " (startingIndex: " + this.from + " + length: " + length + ") is greater then list length " + size());
            }
            System.arraycopy(this.f1505a, fromSublistIndex + this.from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer action) {
            for (int i = this.from; i < this.f1504to; i++) {
                action.accept(this.f1505a[i]);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public char[] toCharArray() {
            return Arrays.copyOfRange(this.f1505a, this.from, this.f1504to);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public char[] toArray(char[] a) {
            if (a == null || a.length < size()) {
                a = new char[size()];
            }
            System.arraycopy(this.f1505a, this.from, a, 0, size());
            return a;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator(final int index) {
            ensureIndex(index);
            return new CharListIterator() { // from class: it.unimi.dsi.fastutil.chars.CharImmutableList.ImmutableSubList.1
                int pos;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.pos = index;
                }

                @Override // java.util.Iterator, java.util.ListIterator
                public boolean hasNext() {
                    return this.pos < ImmutableSubList.this.f1504to;
                }

                @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
                public boolean hasPrevious() {
                    return this.pos > ImmutableSubList.this.from;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public char nextChar() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = ImmutableSubList.this.f1505a;
                    int i = this.pos;
                    this.pos = i + 1;
                    return cArr[i + ImmutableSubList.this.from];
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
                public char previousChar() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    char[] cArr = ImmutableSubList.this.f1505a;
                    int i = this.pos - 1;
                    this.pos = i;
                    return cArr[i + ImmutableSubList.this.from];
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.pos;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.pos - 1;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                public void forEachRemaining(CharConsumer action) {
                    while (this.pos < ImmutableSubList.this.f1504to) {
                        char[] cArr = ImmutableSubList.this.f1505a;
                        int i = this.pos;
                        this.pos = i + 1;
                        action.accept(cArr[i + ImmutableSubList.this.from]);
                    }
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
                public void add(char k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
                public void set(char k) {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator, java.util.Iterator, java.util.ListIterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
                public int back(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1504to - this.pos;
                    if (n < remaining) {
                        this.pos -= n;
                    } else {
                        n = remaining;
                        this.pos = 0;
                    }
                    return n;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    int remaining = ImmutableSubList.this.f1504to - this.pos;
                    if (n < remaining) {
                        this.pos += n;
                    } else {
                        n = remaining;
                        this.pos = ImmutableSubList.this.f1504to;
                    }
                    return n;
                }
            };
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.CharImmutableList$ImmutableSubList$SubListSpliterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharImmutableList$ImmutableSubList$SubListSpliterator.class */
        public final class SubListSpliterator extends CharSpliterators.EarlyBindingSizeIndexBasedSpliterator {
            SubListSpliterator() {
                super(ImmutableSubList.this.from, ImmutableSubList.this.f1504to);
            }

            private SubListSpliterator(int pos, int maxPos) {
                super(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            protected final char get(int i) {
                return ImmutableSubList.this.f1505a[i];
            }

            /* access modifiers changed from: protected */
            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public final SubListSpliterator makeForSplit(int pos, int maxPos) {
                return new SubListSpliterator(pos, maxPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public boolean tryAdvance(CharConsumer action) {
                if (this.pos >= this.maxPos) {
                    return false;
                }
                char[] cArr = ImmutableSubList.this.f1505a;
                int i = this.pos;
                this.pos = i + 1;
                action.accept(cArr[i]);
                return true;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
            public void forEachRemaining(CharConsumer action) {
                int max = this.maxPos;
                while (this.pos < max) {
                    char[] cArr = ImmutableSubList.this.f1505a;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(cArr[i]);
                }
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator, java.util.Spliterator
            public int characteristics() {
                return 17744;
            }
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new SubListSpliterator();
        }

        boolean contentsEquals(char[] otherA, int otherAFrom, int otherATo) {
            if (this.f1505a == otherA && this.from == otherAFrom && this.f1504to == otherATo) {
                return true;
            }
            if (otherATo - otherAFrom != size()) {
                return false;
            }
            int pos = this.from;
            int otherPos = otherAFrom;
            while (pos < this.f1504to) {
                pos++;
                otherPos++;
                if (this.f1505a[pos] != otherA[otherPos]) {
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
            if (o instanceof CharImmutableList) {
                CharImmutableList other = (CharImmutableList) o;
                return contentsEquals(other.f1503a, 0, other.size());
            } else if (!(o instanceof ImmutableSubList)) {
                return equals(o);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) o;
                return contentsEquals(other2.f1505a, other2.from, other2.f1504to);
            }
        }

        int contentsCompareTo(char[] otherA, int otherAFrom, int otherATo) {
            if (this.f1505a == otherA && this.from == otherAFrom && this.f1504to == otherATo) {
                return 0;
            }
            int i = this.from;
            int j = otherAFrom;
            while (i < this.f1504to && i < otherATo) {
                int r = Character.compare(this.f1505a[i], otherA[j]);
                if (r != 0) {
                    return r;
                }
                i++;
                j++;
            }
            if (i < otherATo) {
                return -1;
            }
            return i < this.f1504to ? 1 : 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList
        public int compareTo(List<? extends Character> l) {
            if (l instanceof CharImmutableList) {
                CharImmutableList other = (CharImmutableList) l;
                return contentsCompareTo(other.f1503a, 0, other.size());
            } else if (!(l instanceof ImmutableSubList)) {
                return compareTo(l);
            } else {
                ImmutableSubList other2 = (ImmutableSubList) l;
                return contentsCompareTo(other2.f1505a, other2.from, other2.f1504to);
            }
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return this.innerList.subList(this.from, this.f1504to);
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                throw ((InvalidObjectException) new InvalidObjectException(ex.getMessage()).initCause(ex));
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from == to) {
                return CharImmutableList.EMPTY;
            }
            if (from <= to) {
                return new ImmutableSubList(this.innerList, from + this.from, to + this.from);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
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
        if (from == to) {
            return EMPTY;
        }
        if (from <= to) {
            return new ImmutableSubList(this, from, to);
        }
        throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // java.lang.Object
    public CharImmutableList clone() {
        return this;
    }

    public boolean equals(CharImmutableList l) {
        if (l == this || this.f1503a == l.f1503a) {
            return true;
        }
        if (size() != l.size()) {
            return false;
        }
        return Arrays.equals(this.f1503a, l.f1503a);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.Collection, java.lang.Object, java.util.List
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }
        if (o instanceof CharImmutableList) {
            return equals((CharImmutableList) o);
        }
        if (o instanceof ImmutableSubList) {
            return ((ImmutableSubList) o).equals(this);
        }
        return equals(o);
    }

    public int compareTo(CharImmutableList l) {
        if (this.f1503a == l.f1503a) {
            return 0;
        }
        int s1 = size();
        int s2 = l.size();
        char[] a1 = this.f1503a;
        char[] a2 = l.f1503a;
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
        if (l instanceof CharImmutableList) {
            return compareTo((CharImmutableList) l);
        }
        if (l instanceof ImmutableSubList) {
            return -((ImmutableSubList) l).compareTo((List<? extends Character>) this);
        }
        return compareTo(l);
    }
}
