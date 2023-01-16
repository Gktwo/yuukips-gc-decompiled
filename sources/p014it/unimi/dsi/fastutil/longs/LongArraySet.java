package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.longs.LongArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArraySet.class */
public class LongArraySet extends AbstractLongSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient long[] f2395a;
    private int size;

    static /* synthetic */ int access$010(LongArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public LongArraySet(long[] a) {
        this.f2395a = a;
        this.size = a.length;
    }

    public LongArraySet() {
        this.f2395a = LongArrays.EMPTY_ARRAY;
    }

    public LongArraySet(int capacity) {
        this.f2395a = new long[capacity];
    }

    public LongArraySet(LongCollection c) {
        this(c.size());
        addAll(c);
    }

    public LongArraySet(Collection<? extends Long> c) {
        this(c.size());
        addAll(c);
    }

    public LongArraySet(LongSet c) {
        this(c.size());
        int i = 0;
        LongIterator it = c.iterator();
        while (it.hasNext()) {
            this.f2395a[i] = it.next().longValue();
            i++;
        }
        this.size = i;
    }

    public LongArraySet(Set<? extends Long> c) {
        this(c.size());
        int i = 0;
        for (Long x : c) {
            this.f2395a[i] = x.longValue();
            i++;
        }
        this.size = i;
    }

    public LongArraySet(long[] a, int size) {
        this.f2395a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static LongArraySet m668of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static LongArraySet m667of(long e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static LongArraySet m666of(long... a) {
        if (a.length == 2) {
            if (a[0] == a[1]) {
                throw new IllegalArgumentException("Duplicate element: " + a[1]);
            }
        } else if (a.length > 2) {
            LongOpenHashSet.m621of(a);
        }
        return ofUnchecked(a);
    }

    public static LongArraySet ofUnchecked() {
        return new LongArraySet();
    }

    public static LongArraySet ofUnchecked(long... a) {
        return new LongArraySet(a);
    }

    private int findKey(long o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (this.f2395a[i] != o);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongIterator iterator() {
        return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.LongArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < LongArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long[] jArr = LongArraySet.this.f2395a;
                int i = this.next;
                this.next = i + 1;
                return jArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = LongArraySet.access$010(LongArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(LongArraySet.this.f2395a, this.next + 1, LongArraySet.this.f2395a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = LongArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = LongArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArraySet$Spliterator.class */
    public final class Spliterator implements LongSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !LongArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(LongArraySet longArraySet) {
            this(0, longArraySet.size, false);
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
            return this.hasSplit ? this.max : LongArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            long[] jArr = LongArraySet.this.f2395a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(jArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(LongArraySet.this.f2395a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean contains(long k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
    public boolean remove(long k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f2395a[pos + i] = this.f2395a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean add(long k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f2395a.length) {
            long[] b = new long[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f2395a[i];
            }
            this.f2395a = b;
        }
        long[] jArr = this.f2395a;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr[i2] = k;
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toLongArray() {
        return Arrays.copyOf(this.f2395a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public long[] toArray(long[] a) {
        if (a == null || a.length < this.size) {
            a = new long[this.size];
        }
        System.arraycopy(this.f2395a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public LongArraySet clone() {
        try {
            LongArraySet c = (LongArraySet) clone();
            c.f2395a = (long[]) this.f2395a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeLong(this.f2395a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2395a = new long[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f2395a[i] = s.readLong();
        }
    }
}
