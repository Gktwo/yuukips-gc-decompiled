package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleOpenHashBigSet.class */
public class DoubleOpenHashBigSet extends AbstractDoubleSet implements Serializable, Cloneable, Hash, Size64 {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient double[][] key;
    protected transient long mask;
    protected transient int segmentMask;
    protected transient int baseMask;
    protected transient boolean containsNull;

    /* renamed from: n */
    protected transient long f1741n;
    protected transient long maxFill;
    protected final transient long minN;

    /* renamed from: f */
    protected final float f1742f;
    protected long size;

    private void initMasks() {
        this.mask = this.f1741n - 1;
        this.segmentMask = this.key[0].length - 1;
        this.baseMask = this.key.length - 1;
    }

    public DoubleOpenHashBigSet(long expected, float f) {
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        } else if (this.f1741n < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1742f = f;
            long bigArraySize = HashCommon.bigArraySize(expected, f);
            this.f1741n = bigArraySize;
            this.minN = bigArraySize;
            this.maxFill = HashCommon.maxFill(this.f1741n, f);
            this.key = DoubleBigArrays.newBigArray(this.f1741n);
            initMasks();
        }
    }

    public DoubleOpenHashBigSet(long expected) {
        this(expected, 0.75f);
    }

    public DoubleOpenHashBigSet() {
        this(16, 0.75f);
    }

    public DoubleOpenHashBigSet(Collection<? extends Double> c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public DoubleOpenHashBigSet(Collection<? extends Double> c) {
        this(c, 0.75f);
    }

    public DoubleOpenHashBigSet(DoubleCollection c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public DoubleOpenHashBigSet(DoubleCollection c) {
        this(c, 0.75f);
    }

    public DoubleOpenHashBigSet(DoubleIterator i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.nextDouble());
        }
    }

    public DoubleOpenHashBigSet(DoubleIterator i) {
        this(i, 0.75f);
    }

    public DoubleOpenHashBigSet(Iterator<?> i, float f) {
        this(DoubleIterators.asDoubleIterator(i), f);
    }

    public DoubleOpenHashBigSet(Iterator<?> i) {
        this(DoubleIterators.asDoubleIterator(i));
    }

    public DoubleOpenHashBigSet(double[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : (long) length, f);
        DoubleArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public DoubleOpenHashBigSet(double[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public DoubleOpenHashBigSet(double[] a, float f) {
        this(a, 0, a.length, f);
    }

    public DoubleOpenHashBigSet(double[] a) {
        this(a, 0.75f);
    }

    public static DoubleOpenHashBigSet toBigSet(DoubleStream stream) {
        return (DoubleOpenHashBigSet) stream.collect(DoubleOpenHashBigSet::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static DoubleOpenHashBigSet toBigSetWithExpectedSize(DoubleStream stream, long expectedSize) {
        return (DoubleOpenHashBigSet) stream.collect(() -> {
            return new DoubleOpenHashBigSet(expectedSize);
        }, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    /* access modifiers changed from: private */
    public long realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(long capacity) {
        long needed = HashCommon.bigArraySize(capacity, this.f1742f);
        if (needed > this.f1741n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Double> c) {
        long size = Size64.sizeOf(c);
        if (((double) this.f1742f) <= 0.5d) {
            ensureCapacity(size);
        } else {
            ensureCapacity(size64() + size);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean addAll(DoubleCollection c) {
        long size = Size64.sizeOf(c);
        if (((double) this.f1742f) <= 0.5d) {
            ensureCapacity(size);
        } else {
            ensureCapacity(size64() + size);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[][] key = this.key;
            long h = HashCommon.mix(Double.doubleToRawLongBits(k));
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            double[] dArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            double curr2 = dArr[i2];
            if (Double.doubleToLongBits(curr2) != 0) {
                if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
                    return false;
                }
                do {
                    int i3 = (displ + 1) & this.segmentMask;
                    displ = i3;
                    int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
                    base = i4;
                    curr = key[i4][displ];
                    if (Double.doubleToLongBits(curr) != 0) {
                    }
                } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
                return false;
            }
            key[base][displ] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            this.containsNull = true;
        }
        long j = this.size;
        this.size = j + 1;
        if (j < this.maxFill) {
            return true;
        }
        rehash(2 * this.f1741n);
        return true;
    }

    protected final void shiftKeys(long pos) {
        double[][] key = this.key;
        while (true) {
            long j = pos + 1;
            long j2 = this.mask;
            while (true) {
                pos = j & j2;
                if (Double.doubleToLongBits(BigArrays.get(key, pos)) == 0) {
                    BigArrays.set(key, pos, 0.0d);
                    return;
                }
                long slot = HashCommon.mix(Double.doubleToRawLongBits(BigArrays.get(key, pos))) & this.mask;
                if (pos > pos) {
                    if (pos >= slot && slot > pos) {
                        break;
                    }
                    j = pos + 1;
                    j2 = this.mask;
                } else if (pos < slot && slot <= pos) {
                    j = pos + 1;
                    j2 = this.mask;
                }
            }
            BigArrays.set(key, pos, BigArrays.get(key, pos));
        }
    }

    private boolean removeEntry(int base, int displ) {
        this.size--;
        shiftKeys((((long) base) * 134217728) + ((long) displ));
        if (this.f1741n <= this.minN || this.size >= this.maxFill / 4 || this.f1741n <= 16) {
            return true;
        }
        rehash(this.f1741n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.size--;
        if (this.f1741n <= this.minN || this.size >= this.maxFill / 4 || this.f1741n <= 16) {
            return true;
        }
        rehash(this.f1741n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
    public boolean remove(double k) {
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[][] key = this.key;
            long h = HashCommon.mix(Double.doubleToRawLongBits(k));
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            double[] dArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            double curr2 = dArr[i2];
            if (Double.doubleToLongBits(curr2) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
                return removeEntry(base, displ);
            }
            do {
                int i3 = (displ + 1) & this.segmentMask;
                displ = i3;
                int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
                base = i4;
                curr = key[i4][displ];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
            } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
            return removeEntry(base, displ);
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
        double[][] key = this.key;
        long h = HashCommon.mix(Double.doubleToRawLongBits(k));
        int i = (int) ((h & this.mask) >>> 27);
        int base = i;
        double[] dArr = key[i];
        int i2 = (int) (h & ((long) this.segmentMask));
        int displ = i2;
        double curr2 = dArr[i2];
        if (Double.doubleToLongBits(curr2) == 0) {
            return false;
        }
        if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
            return true;
        }
        do {
            int i3 = (displ + 1) & this.segmentMask;
            displ = i3;
            int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
            base = i4;
            curr = key[i4][displ];
            if (Double.doubleToLongBits(curr) == 0) {
                return false;
            }
        } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            BigArrays.fill(this.key, 0.0d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleOpenHashBigSet$SetIterator.class */
    public class SetIterator implements DoubleIterator {
        int base;
        int displ;
        long last;

        /* renamed from: c */
        long f1743c;
        boolean mustReturnNull;
        DoubleArrayList wrapped;

        private SetIterator() {
            this.base = DoubleOpenHashBigSet.this.key.length;
            this.last = -1;
            this.f1743c = DoubleOpenHashBigSet.this.size;
            this.mustReturnNull = DoubleOpenHashBigSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1743c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            double k;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1743c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = DoubleOpenHashBigSet.this.f1741n;
                return 0.0d;
            }
            double[][] key = DoubleOpenHashBigSet.this.key;
            do {
                if (this.displ != 0 || this.base > 0) {
                    int i = this.displ;
                    this.displ = i - 1;
                    if (i == 0) {
                        int i2 = this.base - 1;
                        this.base = i2;
                        this.displ = key[i2].length - 1;
                    }
                    k = key[this.base][this.displ];
                } else {
                    this.last = Long.MIN_VALUE;
                    DoubleArrayList doubleArrayList = this.wrapped;
                    int i3 = this.base - 1;
                    this.base = i3;
                    return doubleArrayList.getDouble((-i3) - 1);
                }
            } while (Double.doubleToLongBits(k) == 0);
            this.last = (((long) this.base) * 134217728) + ((long) this.displ);
            return k;
        }

        private final void shiftKeys(long pos) {
            double curr;
            double[][] key = DoubleOpenHashBigSet.this.key;
            while (true) {
                long j = pos + 1;
                long j2 = DoubleOpenHashBigSet.this.mask;
                while (true) {
                    pos = j & j2;
                    curr = BigArrays.get(key, pos);
                    if (Double.doubleToLongBits(curr) == 0) {
                        BigArrays.set(key, pos, 0.0d);
                        return;
                    }
                    long slot = HashCommon.mix(Double.doubleToRawLongBits(curr)) & DoubleOpenHashBigSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = DoubleOpenHashBigSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = DoubleOpenHashBigSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new DoubleArrayList();
                    }
                    this.wrapped.add(BigArrays.get(key, pos));
                }
                BigArrays.set(key, pos, curr);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == DoubleOpenHashBigSet.this.f1741n) {
                DoubleOpenHashBigSet.this.containsNull = false;
            } else if (this.base >= 0) {
                shiftKeys(this.last);
            } else {
                DoubleOpenHashBigSet.this.remove(this.wrapped.getDouble((-this.base) - 1));
                this.last = -1;
                return;
            }
            DoubleOpenHashBigSet.this.size--;
            this.last = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleOpenHashBigSet$SetSpliterator.class */
    public class SetSpliterator implements DoubleSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        long pos;
        long max;

        /* renamed from: c */
        long f1744c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = DoubleOpenHashBigSet.this.f1741n;
            this.f1744c = 0;
            this.mustReturnNull = DoubleOpenHashBigSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(long pos, long max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = DoubleOpenHashBigSet.this.f1741n;
            this.f1744c = 0;
            this.mustReturnNull = DoubleOpenHashBigSet.this.containsNull;
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
                this.f1744c++;
                action.accept(0.0d);
                return true;
            }
            double[][] key = DoubleOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                double gotten = BigArrays.get(key, this.pos);
                if (Double.doubleToLongBits(gotten) != 0) {
                    this.f1744c++;
                    this.pos++;
                    action.accept(gotten);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(0.0d);
                this.f1744c++;
            }
            double[][] key = DoubleOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                double gotten = BigArrays.get(key, this.pos);
                if (Double.doubleToLongBits(gotten) != 0) {
                    action.accept(gotten);
                    this.f1744c++;
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
                return DoubleOpenHashBigSet.this.size - this.f1744c;
            }
            return Math.min(DoubleOpenHashBigSet.this.size - this.f1744c, ((long) ((((double) DoubleOpenHashBigSet.this.realSize()) / ((double) DoubleOpenHashBigSet.this.f1741n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public SetSpliterator trySplit() {
            if (this.pos >= this.max - 1) {
                return null;
            }
            long retLen = (this.max - this.pos) >> 1;
            if (retLen <= 1) {
                return null;
            }
            long myNewPos = BigArrays.nearestSegmentStart(this.pos + retLen, this.pos + 1, this.max - 1);
            SetSpliterator split = new SetSpliterator(this.pos, myNewPos, this.mustReturnNull, true);
            this.pos = myNewPos;
            this.mustReturnNull = false;
            this.hasSplit = true;
            return split;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0048 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0048 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v2, types: [long] */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        /* JADX WARN: Type inference failed for: r0v23, types: [long] */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r0v26, types: [long] */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long skip(long r10) {
            /*
                r9 = this;
                r0 = r10
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
                r3 = r10
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r0
            L_0x0021:
                r0 = r10
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0029
                r0 = 0
                return r0
            L_0x0029:
                r0 = 0
                r12 = r0
                r0 = r9
                boolean r0 = r0.mustReturnNull
                if (r0 == 0) goto L_0x003f
                r0 = r9
                r1 = 0
                r0.mustReturnNull = r1
                r0 = r12
                r1 = 1
                long r0 = r0 + r1
                r12 = r0
                r0 = r10
                r1 = 1
                long r0 = r0 - r1
                r10 = r0
            L_0x003f:
                r0 = r9
                it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet r0 = p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet.this
                double[][] r0 = r0.key
                r14 = r0
            L_0x0048:
                r0 = r9
                long r0 = r0.pos
                r1 = r9
                long r1 = r1.max
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x007d
                r0 = r10
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x007d
                r0 = r14
                r1 = r9
                r2 = r1
                long r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                long r3 = r3 + r4
                r2.pos = r3
                double r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                long r0 = java.lang.Double.doubleToLongBits(r0)
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0048
                r0 = r12
                r1 = 1
                long r0 = r0 + r1
                r12 = r0
                r0 = r10
                r1 = 1
                long r0 = r0 - r1
                r10 = r0
                goto L_0x0048
            L_0x007d:
                r0 = r12
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleSpliterator spliterator() {
        return new SetSpliterator();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r0v6, types: [double[][], long] */
    /* JADX WARN: Type inference failed for: r10v2, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void forEach(java.util.function.DoubleConsumer r9) {
        /*
            r8 = this;
            r0 = r8
            boolean r0 = r0.containsNull
            if (r0 == 0) goto L_0x000e
            r0 = r9
            r1 = 0
            r0.accept(r1)
        L_0x000e:
            r0 = 0
            r10 = r0
            r0 = r8
            long r0 = r0.f1741n
            r12 = r0
            r0 = r8
            double[][] r0 = r0.key
            r14 = r0
        L_0x001c:
            r0 = r10
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            r0 = r14
            r1 = r10
            r2 = r1; r1 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r10 = r2
            double r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r15 = r0
            r0 = r15
            long r0 = java.lang.Double.doubleToLongBits(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0041
            r0 = r9
            r1 = r15
            r0.accept(r1)
        L_0x0041:
            goto L_0x001c
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet.forEach(java.util.function.DoubleConsumer):void");
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(long n) {
        long l = HashCommon.bigArraySize(n, this.f1742f);
        if (l >= this.f1741n || this.size > HashCommon.maxFill(l, this.f1742f)) {
            return true;
        }
        try {
            rehash(l);
            return true;
        } catch (OutOfMemoryError e) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1, types: [long] */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e3  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void rehash(long r8) {
        /*
        // Method dump skipped, instructions count: 265
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet.rehash(long):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, p014it.unimi.dsi.fastutil.Size64
    @Deprecated
    public int size() {
        return (int) Math.min(2147483647L, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.lang.Object
    public DoubleOpenHashBigSet clone() {
        try {
            DoubleOpenHashBigSet c = (DoubleOpenHashBigSet) clone();
            c.key = BigArrays.copy(this.key);
            c.containsNull = this.containsNull;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, java.util.Collection, java.lang.Object, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r7 = this;
            r0 = r7
            double[][] r0 = r0.key
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r7
            long r0 = r0.realSize()
            r12 = r0
        L_0x0012:
            r0 = r12
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r12 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x006c
        L_0x001e:
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r1 = r11
            r0 = r0[r1]
            long r0 = java.lang.Double.doubleToLongBits(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0046
            r0 = r10
            r1 = r11
            r2 = 1
            int r1 = r1 + r2
            r2 = r7
            int r2 = r2.segmentMask
            r1 = r1 & r2
            r2 = r1
            r11 = r2
            if (r1 != 0) goto L_0x0040
            r1 = 1
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x001e
        L_0x0046:
            r0 = r9
            r1 = r8
            r2 = r10
            r1 = r1[r2]
            r2 = r11
            r1 = r1[r2]
            int r1 = p014it.unimi.dsi.fastutil.HashCommon.double2int(r1)
            int r0 = r0 + r1
            r9 = r0
            r0 = r10
            r1 = r11
            r2 = 1
            int r1 = r1 + r2
            r2 = r7
            int r2 = r2.segmentMask
            r1 = r1 & r2
            r2 = r1
            r11 = r2
            if (r1 != 0) goto L_0x0066
            r1 = 1
            goto L_0x0067
        L_0x0066:
            r1 = 0
        L_0x0067:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x0012
        L_0x006c:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet.hashCode():int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [long] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeObject(java.io.ObjectOutputStream r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = r7
            it.unimi.dsi.fastutil.doubles.DoubleIterator r0 = r0.iterator()
            r9 = r0
            r0 = r8
            r0.defaultWriteObject()
            r0 = r7
            long r0 = r0.size
            r10 = r0
        L_0x000e:
            r0 = r10
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r10 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0025
            r0 = r8
            r1 = r9
            double r1 = r1.nextDouble()
            r0.writeDouble(r1)
            goto L_0x000e
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleOpenHashBigSet.writeObject(java.io.ObjectOutputStream):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0039 */
    /* JADX DEBUG: Multi-variable search result rejected for r16v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2, types: [long] */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int i;
        s.defaultReadObject();
        this.f1741n = HashCommon.bigArraySize(this.size, this.f1742f);
        this.maxFill = HashCommon.maxFill(this.f1741n, this.f1742f);
        double[][] key = DoubleBigArrays.newBigArray(this.f1741n);
        this.key = key;
        initMasks();
        long i2 = this.size;
        while (true) {
            i2--;
            if ((i2 == true ? 1 : 0) != 0) {
                double k = s.readDouble();
                if (Double.doubleToLongBits(k) == 0) {
                    this.containsNull = true;
                } else {
                    long h = HashCommon.mix(Double.doubleToRawLongBits(k));
                    int i3 = (int) ((h & this.mask) >>> 27);
                    int base = i3;
                    double[] dArr = key[i3];
                    int i4 = (int) (h & ((long) this.segmentMask));
                    int displ = i4;
                    if (Double.doubleToLongBits(dArr[i4]) != 0) {
                        do {
                            int i5 = (displ + 1) & this.segmentMask;
                            displ = i5;
                            i = (base + (i5 == 0 ? 1 : 0)) & this.baseMask;
                            base = i;
                        } while (Double.doubleToLongBits(key[i][displ]) != 0);
                        key[base][displ] = k;
                    } else {
                        key[base][displ] = k;
                    }
                }
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
