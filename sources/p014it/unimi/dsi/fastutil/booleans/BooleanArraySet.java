package p014it.unimi.dsi.fastutil.booleans;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArraySet.class */
public class BooleanArraySet extends AbstractBooleanSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient boolean[] f1011a;
    private int size;

    static /* synthetic */ int access$010(BooleanArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public BooleanArraySet(boolean[] a) {
        this.f1011a = a;
        this.size = a.length;
    }

    public BooleanArraySet() {
        this.f1011a = BooleanArrays.EMPTY_ARRAY;
    }

    public BooleanArraySet(int capacity) {
        this.f1011a = new boolean[capacity];
    }

    public BooleanArraySet(BooleanCollection c) {
        this(c.size());
        addAll(c);
    }

    public BooleanArraySet(Collection<? extends Boolean> c) {
        this(c.size());
        addAll(c);
    }

    public BooleanArraySet(BooleanSet c) {
        this(c.size());
        int i = 0;
        BooleanIterator it = c.iterator();
        while (it.hasNext()) {
            this.f1011a[i] = it.next().booleanValue();
            i++;
        }
        this.size = i;
    }

    public BooleanArraySet(Set<? extends Boolean> c) {
        this(c.size());
        int i = 0;
        for (Boolean x : c) {
            this.f1011a[i] = x.booleanValue();
            i++;
        }
        this.size = i;
    }

    public BooleanArraySet(boolean[] a, int size) {
        this.f1011a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static BooleanArraySet m1167of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static BooleanArraySet m1166of(boolean e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static BooleanArraySet m1165of(boolean... a) {
        if (a.length == 2) {
            if (a[0] == a[1]) {
                throw new IllegalArgumentException("Duplicate element: " + a[1]);
            }
        } else if (a.length > 2) {
            BooleanOpenHashSet.m1127of(a);
        }
        return ofUnchecked(a);
    }

    public static BooleanArraySet ofUnchecked() {
        return new BooleanArraySet();
    }

    public static BooleanArraySet ofUnchecked(boolean... a) {
        return new BooleanArraySet(a);
    }

    private int findKey(boolean o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (this.f1011a[i] != o);
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanSet, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanIterator iterator() {
        return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.booleans.BooleanArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < BooleanArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public boolean nextBoolean() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                boolean[] zArr = BooleanArraySet.this.f1011a;
                int i = this.next;
                this.next = i + 1;
                return zArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = BooleanArraySet.access$010(BooleanArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(BooleanArraySet.this.f1011a, this.next + 1, BooleanArraySet.this.f1011a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = BooleanArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = BooleanArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArraySet$Spliterator.class */
    public final class Spliterator implements BooleanSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !BooleanArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(BooleanArraySet booleanArraySet) {
            this(0, booleanArraySet.size, false);
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
            return this.hasSplit ? this.max : BooleanArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            boolean[] zArr = BooleanArraySet.this.f1011a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(zArr[i]);
            return true;
        }

        public void forEachRemaining(BooleanConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(BooleanArraySet.this.f1011a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean contains(boolean k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanSet, p014it.unimi.dsi.fastutil.booleans.BooleanSet
    public boolean remove(boolean k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f1011a[pos + i] = this.f1011a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean add(boolean k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f1011a.length) {
            boolean[] b = new boolean[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f1011a[i];
            }
            this.f1011a = b;
        }
        boolean[] zArr = this.f1011a;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr[i2] = k;
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

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toBooleanArray() {
        return Arrays.copyOf(this.f1011a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean[] toArray(boolean[] a) {
        if (a == null || a.length < this.size) {
            a = new boolean[this.size];
        }
        System.arraycopy(this.f1011a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public BooleanArraySet clone() {
        try {
            BooleanArraySet c = (BooleanArraySet) clone();
            c.f1011a = (boolean[]) this.f1011a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeBoolean(this.f1011a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1011a = new boolean[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1011a[i] = s.readBoolean();
        }
    }
}
