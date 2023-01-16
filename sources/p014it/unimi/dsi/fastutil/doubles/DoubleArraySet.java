package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArraySet.class */
public class DoubleArraySet extends AbstractDoubleSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient double[] f1703a;
    private int size;

    static /* synthetic */ int access$010(DoubleArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public DoubleArraySet(double[] a) {
        this.f1703a = a;
        this.size = a.length;
    }

    public DoubleArraySet() {
        this.f1703a = DoubleArrays.EMPTY_ARRAY;
    }

    public DoubleArraySet(int capacity) {
        this.f1703a = new double[capacity];
    }

    public DoubleArraySet(DoubleCollection c) {
        this(c.size());
        addAll(c);
    }

    public DoubleArraySet(Collection<? extends Double> c) {
        this(c.size());
        addAll(c);
    }

    public DoubleArraySet(DoubleSet c) {
        this(c.size());
        int i = 0;
        DoubleIterator it = c.iterator();
        while (it.hasNext()) {
            this.f1703a[i] = it.next().doubleValue();
            i++;
        }
        this.size = i;
    }

    public DoubleArraySet(Set<? extends Double> c) {
        this(c.size());
        int i = 0;
        for (Double x : c) {
            this.f1703a[i] = x.doubleValue();
            i++;
        }
        this.size = i;
    }

    public DoubleArraySet(double[] a, int size) {
        this.f1703a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static DoubleArraySet m921of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static DoubleArraySet m920of(double e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static DoubleArraySet m919of(double... a) {
        if (a.length == 2) {
            if (Double.doubleToLongBits(a[0]) == Double.doubleToLongBits(a[1])) {
                throw new IllegalArgumentException("Duplicate element: " + a[1]);
            }
        } else if (a.length > 2) {
            DoubleOpenHashSet.m874of(a);
        }
        return ofUnchecked(a);
    }

    public static DoubleArraySet ofUnchecked() {
        return new DoubleArraySet();
    }

    public static DoubleArraySet ofUnchecked(double... a) {
        return new DoubleArraySet(a);
    }

    private int findKey(double o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Double.doubleToLongBits(this.f1703a[i]) != Double.doubleToLongBits(o));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleIterator iterator() {
        return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.DoubleArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < DoubleArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
            public double nextDouble() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                double[] dArr = DoubleArraySet.this.f1703a;
                int i = this.next;
                this.next = i + 1;
                return dArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = DoubleArraySet.access$010(DoubleArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(DoubleArraySet.this.f1703a, this.next + 1, DoubleArraySet.this.f1703a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = DoubleArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = DoubleArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleArraySet$Spliterator.class */
    public final class Spliterator implements DoubleSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !DoubleArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(DoubleArraySet doubleArraySet) {
            this(0, doubleArraySet.size, false);
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
            return this.hasSplit ? this.max : DoubleArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        @Override // java.util.Spliterator.OfDouble
        public boolean tryAdvance(DoubleConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            double[] dArr = DoubleArraySet.this.f1703a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(dArr[i]);
            return true;
        }

        @Override // java.util.Spliterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(DoubleArraySet.this.f1703a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public DoubleSpliterator trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean contains(double k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
    public boolean remove(double k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f1703a[pos + i] = this.f1703a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f1703a.length) {
            double[] b = new double[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f1703a[i];
            }
            this.f1703a = b;
        }
        double[] dArr = this.f1703a;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr[i2] = k;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toDoubleArray() {
        return Arrays.copyOf(this.f1703a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public double[] toArray(double[] a) {
        if (a == null || a.length < this.size) {
            a = new double[this.size];
        }
        System.arraycopy(this.f1703a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public DoubleArraySet clone() {
        try {
            DoubleArraySet c = (DoubleArraySet) clone();
            c.f1703a = (double[]) this.f1703a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeDouble(this.f1703a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1703a = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1703a[i] = s.readDouble();
        }
    }
}
