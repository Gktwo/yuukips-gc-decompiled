package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleOpenHashSet.class */
public class DoubleOpenHashSet extends AbstractDoubleSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient double[] key;
    protected transient int mask;
    protected transient boolean containsNull;

    /* renamed from: n */
    protected transient int f1709n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1710f;

    public DoubleOpenHashSet(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1710f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1709n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1709n - 1;
            this.maxFill = HashCommon.maxFill(this.f1709n, f);
            this.key = new double[this.f1709n + 1];
        }
    }

    public DoubleOpenHashSet(int expected) {
        this(expected, 0.75f);
    }

    public DoubleOpenHashSet() {
        this(16, 0.75f);
    }

    public DoubleOpenHashSet(Collection<? extends Double> c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public DoubleOpenHashSet(Collection<? extends Double> c) {
        this(c, 0.75f);
    }

    public DoubleOpenHashSet(DoubleCollection c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public DoubleOpenHashSet(DoubleCollection c) {
        this(c, 0.75f);
    }

    public DoubleOpenHashSet(DoubleIterator i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.nextDouble());
        }
    }

    public DoubleOpenHashSet(DoubleIterator i) {
        this(i, 0.75f);
    }

    public DoubleOpenHashSet(Iterator<?> i, float f) {
        this(DoubleIterators.asDoubleIterator(i), f);
    }

    public DoubleOpenHashSet(Iterator<?> i) {
        this(DoubleIterators.asDoubleIterator(i));
    }

    public DoubleOpenHashSet(double[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : length, f);
        DoubleArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public DoubleOpenHashSet(double[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public DoubleOpenHashSet(double[] a, float f) {
        this(a, 0, a.length, f);
    }

    public DoubleOpenHashSet(double[] a) {
        this(a, 0.75f);
    }

    /* renamed from: of */
    public static DoubleOpenHashSet m878of() {
        return new DoubleOpenHashSet();
    }

    /* renamed from: of */
    public static DoubleOpenHashSet m877of(double e) {
        DoubleOpenHashSet result = new DoubleOpenHashSet(1, 0.75f);
        result.add(e);
        return result;
    }

    /* renamed from: of */
    public static DoubleOpenHashSet m876of(double e0, double e1) {
        DoubleOpenHashSet result = new DoubleOpenHashSet(2, 0.75f);
        result.add(e0);
        if (result.add(e1)) {
            return result;
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    public static DoubleOpenHashSet m875of(double e0, double e1, double e2) {
        DoubleOpenHashSet result = new DoubleOpenHashSet(3, 0.75f);
        result.add(e0);
        if (!result.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (result.add(e2)) {
            return result;
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    public static DoubleOpenHashSet m874of(double... a) {
        DoubleOpenHashSet result = new DoubleOpenHashSet(a.length, 0.75f);
        for (double element : a) {
            if (!result.add(element)) {
                throw new IllegalArgumentException("Duplicate element " + element);
            }
        }
        return result;
    }

    public static DoubleOpenHashSet toSet(DoubleStream stream) {
        return (DoubleOpenHashSet) stream.collect(DoubleOpenHashSet::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static DoubleOpenHashSet toSetWithExpectedSize(DoubleStream stream, int expectedSize) {
        if (expectedSize <= 16) {
            return toSet(stream);
        }
        return (DoubleOpenHashSet) stream.collect(new DoubleCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 16 ? new DoubleOpenHashSet() : new DoubleOpenHashSet(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1710f);
        if (needed > this.f1709n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1710f)))));
        if (needed > this.f1709n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean addAll(DoubleCollection c) {
        if (((double) this.f1710f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Double> c) {
        if (((double) this.f1710f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) != 0) {
                if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Double.doubleToLongBits(curr) != 0) {
                    }
                } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            this.containsNull = true;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size + 1, this.f1710f));
        return true;
    }

    protected final void shiftKeys(int pos) {
        double curr;
        double[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (Double.doubleToLongBits(curr) == 0) {
                    key[pos] = 0.0d;
                    return;
                }
                int slot = ((int) HashCommon.mix(Double.doubleToRawLongBits(curr))) & this.mask;
                if (pos > pos) {
                    if (pos >= slot && slot > pos) {
                        break;
                    }
                    i = pos + 1;
                    i2 = this.mask;
                } else if (pos < slot && slot <= pos) {
                    i = pos + 1;
                    i2 = this.mask;
                }
            }
            key[pos] = curr;
        }
    }

    private boolean removeEntry(int pos) {
        this.size--;
        shiftKeys(pos);
        if (this.f1709n <= this.minN || this.size >= this.maxFill / 4 || this.f1709n <= 16) {
            return true;
        }
        rehash(this.f1709n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f1709n] = 0.0d;
        this.size--;
        if (this.f1709n <= this.minN || this.size >= this.maxFill / 4 || this.f1709n <= 16) {
            return true;
        }
        rehash(this.f1709n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
    public boolean remove(double k) {
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
            return removeEntry(pos);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean contains(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNull;
        }
        double[] key = this.key;
        int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
        int pos = mix;
        double curr2 = key[mix];
        if (Double.doubleToLongBits(curr2) == 0) {
            return false;
        }
        if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Double.doubleToLongBits(curr) == 0) {
                return false;
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, 0.0d);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleOpenHashSet$SetIterator.class */
    public final class SetIterator implements DoubleIterator {
        int pos;
        int last;

        /* renamed from: c */
        int f1711c;
        boolean mustReturnNull;
        DoubleArrayList wrapped;

        private SetIterator() {
            this.pos = DoubleOpenHashSet.this.f1709n;
            this.last = -1;
            this.f1711c = DoubleOpenHashSet.this.size;
            this.mustReturnNull = DoubleOpenHashSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1711c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1711c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = DoubleOpenHashSet.this.f1709n;
                return DoubleOpenHashSet.this.key[DoubleOpenHashSet.this.f1709n];
            }
            double[] key = DoubleOpenHashSet.this.key;
            do {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    return this.wrapped.getDouble((-this.pos) - 1);
                }
            } while (Double.doubleToLongBits(key[this.pos]) == 0);
            int i2 = this.pos;
            this.last = i2;
            return key[i2];
        }

        private final void shiftKeys(int pos) {
            double curr;
            double[] key = DoubleOpenHashSet.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = DoubleOpenHashSet.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (Double.doubleToLongBits(curr) == 0) {
                        key[pos] = 0.0d;
                        return;
                    }
                    int slot = ((int) HashCommon.mix(Double.doubleToRawLongBits(curr))) & DoubleOpenHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = DoubleOpenHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = DoubleOpenHashSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new DoubleArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == DoubleOpenHashSet.this.f1709n) {
                DoubleOpenHashSet.this.containsNull = false;
                DoubleOpenHashSet.this.key[DoubleOpenHashSet.this.f1709n] = 0.0d;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                DoubleOpenHashSet.this.remove(this.wrapped.getDouble((-this.pos) - 1));
                this.last = -1;
                return;
            }
            DoubleOpenHashSet.this.size--;
            this.last = -1;
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            double[] key = DoubleOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = DoubleOpenHashSet.this.f1709n;
                action.accept(key[DoubleOpenHashSet.this.f1709n]);
                this.f1711c--;
            }
            while (this.f1711c != 0) {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept(this.wrapped.getDouble((-this.pos) - 1));
                    this.f1711c--;
                } else if (Double.doubleToLongBits(key[this.pos]) != 0) {
                    int i2 = this.pos;
                    this.last = i2;
                    action.accept(key[i2]);
                    this.f1711c--;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleOpenHashSet$SetSpliterator.class */
    public final class SetSpliterator implements DoubleSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        int pos;
        int max;

        /* renamed from: c */
        int f1712c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = DoubleOpenHashSet.this.f1709n;
            this.f1712c = 0;
            this.mustReturnNull = DoubleOpenHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = DoubleOpenHashSet.this.f1709n;
            this.f1712c = 0;
            this.mustReturnNull = DoubleOpenHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        @Override // java.util.Spliterator.OfDouble
        public boolean tryAdvance(DoubleConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1712c++;
                action.accept(DoubleOpenHashSet.this.key[DoubleOpenHashSet.this.f1709n]);
                return true;
            }
            double[] key = DoubleOpenHashSet.this.key;
            while (this.pos < this.max) {
                if (Double.doubleToLongBits(key[this.pos]) != 0) {
                    this.f1712c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(key[i]);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            double[] key = DoubleOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(key[DoubleOpenHashSet.this.f1709n]);
                this.f1712c++;
            }
            while (this.pos < this.max) {
                if (Double.doubleToLongBits(key[this.pos]) != 0) {
                    action.accept(key[this.pos]);
                    this.f1712c++;
                }
                this.pos++;
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 257 : 321;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (DoubleOpenHashSet.this.size - this.f1712c);
            }
            return Math.min((long) (DoubleOpenHashSet.this.size - this.f1712c), ((long) ((((double) DoubleOpenHashSet.this.realSize()) / ((double) DoubleOpenHashSet.this.f1709n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public SetSpliterator trySplit() {
            int retLen;
            if (this.pos >= this.max - 1 || (retLen = (this.max - this.pos) >> 1) <= 1) {
                return null;
            }
            int myNewPos = this.pos + retLen;
            SetSpliterator split = new SetSpliterator(this.pos, myNewPos, this.mustReturnNull, true);
            this.pos = myNewPos;
            this.mustReturnNull = false;
            this.hasSplit = true;
            return split;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0048 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0048 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2, types: [long] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r0v20, types: [long] */
        /* JADX WARN: Type inference failed for: r0v22, types: [long] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r0v25, types: [long] */
        /* JADX WARN: Type inference failed for: r0v27, types: [long] */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long skip(long r7) {
            /*
                r6 = this;
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0021
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r1 = r0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = r2
                r3.<init>()
                java.lang.String r3 = "Argument must be nonnegative: "
                java.lang.StringBuilder r2 = r2.append(r3)
                r3 = r7
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r0
            L_0x0021:
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0029
                r0 = 0
                return r0
            L_0x0029:
                r0 = 0
                r9 = r0
                r0 = r6
                boolean r0 = r0.mustReturnNull
                if (r0 == 0) goto L_0x003f
                r0 = r6
                r1 = 0
                r0.mustReturnNull = r1
                r0 = r9
                r1 = 1
                long r0 = r0 + r1
                r9 = r0
                r0 = r7
                r1 = 1
                long r0 = r0 - r1
                r7 = r0
            L_0x003f:
                r0 = r6
                it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet r0 = p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet.this
                double[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x007a
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x007a
                r0 = r11
                r1 = r6
                r2 = r1
                int r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                int r3 = r3 + r4
                r2.pos = r3
                r0 = r0[r1]
                long r0 = java.lang.Double.doubleToLongBits(r0)
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0048
                r0 = r9
                r1 = 1
                long r0 = r0 + r1
                r9 = r0
                r0 = r7
                r1 = 1
                long r0 = r0 - r1
                r7 = r0
                goto L_0x0048
            L_0x007a:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleSpliterator spliterator() {
        return new SetSpliterator();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public void forEach(DoubleConsumer action) {
        if (this.containsNull) {
            action.accept(this.key[this.f1709n]);
        }
        double[] key = this.key;
        int pos = this.f1709n;
        while (true) {
            pos--;
            if (pos == 0) {
                return;
            }
            if (Double.doubleToLongBits(key[pos]) != 0) {
                action.accept(key[pos]);
            }
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1710f)));
        if (l >= this.f1709n || this.size > HashCommon.maxFill(l, this.f1710f)) {
            return true;
        }
        try {
            rehash(l);
            return true;
        } catch (OutOfMemoryError e) {
            return false;
        }
    }

    protected void rehash(int newN) {
        int i;
        double[] key = this.key;
        int mask = newN - 1;
        double[] newKey = new double[newN + 1];
        int i2 = this.f1709n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (Double.doubleToLongBits(key[i2]) == 0);
                int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(key[i2]))) & mask;
                int pos = mix;
                if (Double.doubleToLongBits(newKey[mix]) != 0) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (Double.doubleToLongBits(newKey[i]) != 0);
                }
                newKey[pos] = key[i2];
            } else {
                this.f1709n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1709n, this.f1710f);
                this.key = newKey;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public DoubleOpenHashSet clone() {
        try {
            DoubleOpenHashSet c = (DoubleOpenHashSet) clone();
            c.key = (double[]) this.key.clone();
            c.containsNull = this.containsNull;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (Double.doubleToLongBits(this.key[i]) == 0) {
                i++;
            }
            h += HashCommon.double2int(this.key[i]);
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        DoubleIterator i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeDouble(i.nextDouble());
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f1709n = HashCommon.arraySize(this.size, this.f1710f);
        this.maxFill = HashCommon.maxFill(this.f1709n, this.f1710f);
        this.mask = this.f1709n - 1;
        double[] key = new double[this.f1709n + 1];
        this.key = key;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 != 0) {
                double k = s.readDouble();
                if (Double.doubleToLongBits(k) == 0) {
                    pos = this.f1709n;
                    this.containsNull = true;
                } else {
                    int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
                    pos = mix;
                    if (Double.doubleToLongBits(key[mix]) != 0) {
                        do {
                            i = (pos + 1) & this.mask;
                            pos = i;
                        } while (Double.doubleToLongBits(key[i]) != 0);
                    }
                }
                key[pos] = k;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
