package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArraySet.class */
public class ShortArraySet extends AbstractShortSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient short[] f3025a;
    private int size;

    static /* synthetic */ int access$010(ShortArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public ShortArraySet(short[] a) {
        this.f3025a = a;
        this.size = a.length;
    }

    public ShortArraySet() {
        this.f3025a = ShortArrays.EMPTY_ARRAY;
    }

    public ShortArraySet(int capacity) {
        this.f3025a = new short[capacity];
    }

    public ShortArraySet(ShortCollection c) {
        this(c.size());
        addAll(c);
    }

    public ShortArraySet(Collection<? extends Short> c) {
        this(c.size());
        addAll(c);
    }

    public ShortArraySet(ShortSet c) {
        this(c.size());
        int i = 0;
        ShortIterator it = c.iterator();
        while (it.hasNext()) {
            this.f3025a[i] = it.next().shortValue();
            i++;
        }
        this.size = i;
    }

    public ShortArraySet(Set<? extends Short> c) {
        this(c.size());
        int i = 0;
        for (Short x : c) {
            this.f3025a[i] = x.shortValue();
            i++;
        }
        this.size = i;
    }

    public ShortArraySet(short[] a, int size) {
        this.f3025a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static ShortArraySet m443of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static ShortArraySet m442of(short e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static ShortArraySet m441of(short... a) {
        if (a.length == 2) {
            if (a[0] == a[1]) {
                throw new IllegalArgumentException("Duplicate element: " + ((int) a[1]));
            }
        } else if (a.length > 2) {
            ShortOpenHashSet.m398of(a);
        }
        return ofUnchecked(a);
    }

    public static ShortArraySet ofUnchecked() {
        return new ShortArraySet();
    }

    public static ShortArraySet ofUnchecked(short... a) {
        return new ShortArraySet(a);
    }

    private int findKey(short o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (this.f3025a[i] != o);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortIterator iterator() {
        return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.ShortArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < ShortArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                short[] sArr = ShortArraySet.this.f3025a;
                int i = this.next;
                this.next = i + 1;
                return sArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = ShortArraySet.access$010(ShortArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(ShortArraySet.this.f3025a, this.next + 1, ShortArraySet.this.f3025a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ShortArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = ShortArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArraySet$Spliterator.class */
    public final class Spliterator implements ShortSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ShortArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(ShortArraySet shortArraySet) {
            this(0, shortArraySet.size, false);
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
            return this.hasSplit ? this.max : ShortArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(ShortConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            short[] sArr = ShortArraySet.this.f3025a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(sArr[i]);
            return true;
        }

        public void forEachRemaining(ShortConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(ShortArraySet.this.f3025a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean contains(short k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
    public boolean remove(short k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f3025a[pos + i] = this.f3025a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean add(short k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f3025a.length) {
            short[] b = new short[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f3025a[i];
            }
            this.f3025a = b;
        }
        short[] sArr = this.f3025a;
        int i2 = this.size;
        this.size = i2 + 1;
        sArr[i2] = k;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toShortArray() {
        return Arrays.copyOf(this.f3025a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public short[] toArray(short[] a) {
        if (a == null || a.length < this.size) {
            a = new short[this.size];
        }
        System.arraycopy(this.f3025a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public ShortArraySet clone() {
        try {
            ShortArraySet c = (ShortArraySet) clone();
            c.f3025a = (short[]) this.f3025a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeShort(this.f3025a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f3025a = new short[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f3025a[i] = s.readShort();
        }
    }
}
