package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.ints.IntArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntArraySet.class */
public class IntArraySet extends AbstractIntSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient int[] f2153a;
    private int size;

    static /* synthetic */ int access$010(IntArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public IntArraySet(int[] a) {
        this.f2153a = a;
        this.size = a.length;
    }

    public IntArraySet() {
        this.f2153a = IntArrays.EMPTY_ARRAY;
    }

    public IntArraySet(int capacity) {
        this.f2153a = new int[capacity];
    }

    public IntArraySet(IntCollection c) {
        this(c.size());
        addAll(c);
    }

    public IntArraySet(Collection<? extends Integer> c) {
        this(c.size());
        addAll(c);
    }

    public IntArraySet(IntSet c) {
        this(c.size());
        int i = 0;
        IntIterator it = c.iterator();
        while (it.hasNext()) {
            this.f2153a[i] = it.next().intValue();
            i++;
        }
        this.size = i;
    }

    public IntArraySet(Set<? extends Integer> c) {
        this(c.size());
        int i = 0;
        for (Integer x : c) {
            this.f2153a[i] = x.intValue();
            i++;
        }
        this.size = i;
    }

    public IntArraySet(int[] a, int size) {
        this.f2153a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static IntArraySet m753of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static IntArraySet m752of(int e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static IntArraySet m751of(int... a) {
        if (a.length == 2) {
            if (a[0] == a[1]) {
                throw new IllegalArgumentException("Duplicate element: " + a[1]);
            }
        } else if (a.length > 2) {
            IntOpenHashSet.m706of(a);
        }
        return ofUnchecked(a);
    }

    public static IntArraySet ofUnchecked() {
        return new IntArraySet();
    }

    public static IntArraySet ofUnchecked(int... a) {
        return new IntArraySet(a);
    }

    private int findKey(int o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (this.f2153a[i] != o);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntIterator iterator() {
        return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.IntArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < IntArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int[] iArr = IntArraySet.this.f2153a;
                int i = this.next;
                this.next = i + 1;
                return iArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = IntArraySet.access$010(IntArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(IntArraySet.this.f2153a, this.next + 1, IntArraySet.this.f2153a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = IntArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = IntArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntArraySet$Spliterator.class */
    public final class Spliterator implements IntSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !IntArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(IntArraySet intArraySet) {
            this(0, intArraySet.size, false);
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
            return this.hasSplit ? this.max : IntArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        @Override // java.util.Spliterator.OfInt
        public boolean tryAdvance(IntConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            int[] iArr = IntArraySet.this.f2153a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(iArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(IntArraySet.this.f2153a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public IntSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean contains(int k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
    public boolean remove(int k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f2153a[pos + i] = this.f2153a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean add(int k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f2153a.length) {
            int[] b = new int[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f2153a[i];
            }
            this.f2153a = b;
        }
        int[] iArr = this.f2153a;
        int i2 = this.size;
        this.size = i2 + 1;
        iArr[i2] = k;
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public int[] toIntArray() {
        return Arrays.copyOf(this.f2153a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public int[] toArray(int[] a) {
        if (a == null || a.length < this.size) {
            a = new int[this.size];
        }
        System.arraycopy(this.f2153a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public IntArraySet clone() {
        try {
            IntArraySet c = (IntArraySet) clone();
            c.f2153a = (int[]) this.f2153a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeInt(this.f2153a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2153a = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f2153a[i] = s.readInt();
        }
    }
}
