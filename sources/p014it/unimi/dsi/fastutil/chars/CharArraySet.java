package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.chars.CharArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArraySet.class */
public class CharArraySet extends AbstractCharSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient char[] f1484a;
    private int size;

    static /* synthetic */ int access$010(CharArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public CharArraySet(char[] a) {
        this.f1484a = a;
        this.size = a.length;
    }

    public CharArraySet() {
        this.f1484a = CharArrays.EMPTY_ARRAY;
    }

    public CharArraySet(int capacity) {
        this.f1484a = new char[capacity];
    }

    public CharArraySet(CharCollection c) {
        this(c.size());
        addAll(c);
    }

    public CharArraySet(Collection<? extends Character> c) {
        this(c.size());
        addAll(c);
    }

    public CharArraySet(CharSet c) {
        this(c.size());
        int i = 0;
        CharIterator it = c.iterator();
        while (it.hasNext()) {
            this.f1484a[i] = it.next().charValue();
            i++;
        }
        this.size = i;
    }

    public CharArraySet(Set<? extends Character> c) {
        this(c.size());
        int i = 0;
        for (Character x : c) {
            this.f1484a[i] = x.charValue();
            i++;
        }
        this.size = i;
    }

    public CharArraySet(char[] a, int size) {
        this.f1484a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static CharArraySet m1006of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static CharArraySet m1005of(char e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static CharArraySet m1004of(char... a) {
        if (a.length == 2) {
            if (a[0] == a[1]) {
                throw new IllegalArgumentException("Duplicate element: " + a[1]);
            }
        } else if (a.length > 2) {
            CharOpenHashSet.m959of(a);
        }
        return ofUnchecked(a);
    }

    public static CharArraySet ofUnchecked() {
        return new CharArraySet();
    }

    public static CharArraySet ofUnchecked(char... a) {
        return new CharArraySet(a);
    }

    private int findKey(char o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (this.f1484a[i] != o);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public CharIterator iterator() {
        return new CharIterator() { // from class: it.unimi.dsi.fastutil.chars.CharArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < CharArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
            public char nextChar() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                char[] cArr = CharArraySet.this.f1484a;
                int i = this.next;
                this.next = i + 1;
                return cArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = CharArraySet.access$010(CharArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(CharArraySet.this.f1484a, this.next + 1, CharArraySet.this.f1484a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = CharArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = CharArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArraySet$Spliterator.class */
    public final class Spliterator implements CharSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !CharArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(CharArraySet charArraySet) {
            this(0, charArraySet.size, false);
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
            return this.hasSplit ? this.max : CharArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(CharConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            char[] cArr = CharArraySet.this.f1484a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(cArr[i]);
            return true;
        }

        public void forEachRemaining(CharConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(CharArraySet.this.f1484a[this.pos]);
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean contains(char k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
    public boolean remove(char k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f1484a[pos + i] = this.f1484a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean add(char k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f1484a.length) {
            char[] b = new char[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f1484a[i];
            }
            this.f1484a = b;
        }
        char[] cArr = this.f1484a;
        int i2 = this.size;
        this.size = i2 + 1;
        cArr[i2] = k;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toCharArray() {
        return Arrays.copyOf(this.f1484a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toArray(char[] a) {
        if (a == null || a.length < this.size) {
            a = new char[this.size];
        }
        System.arraycopy(this.f1484a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public CharArraySet clone() {
        try {
            CharArraySet c = (CharArraySet) clone();
            c.f1484a = (char[]) this.f1484a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeChar(this.f1484a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1484a = new char[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1484a[i] = s.readChar();
        }
    }
}
