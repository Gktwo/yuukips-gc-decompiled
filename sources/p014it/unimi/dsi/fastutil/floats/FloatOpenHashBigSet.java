package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatOpenHashBigSet.class */
public class FloatOpenHashBigSet extends AbstractFloatSet implements Serializable, Cloneable, Hash, Size64 {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient float[][] key;
    protected transient long mask;
    protected transient int segmentMask;
    protected transient int baseMask;
    protected transient boolean containsNull;

    /* renamed from: n */
    protected transient long f1962n;
    protected transient long maxFill;
    protected final transient long minN;

    /* renamed from: f */
    protected final float f1963f;
    protected long size;

    private void initMasks() {
        this.mask = this.f1962n - 1;
        this.segmentMask = this.key[0].length - 1;
        this.baseMask = this.key.length - 1;
    }

    public FloatOpenHashBigSet(long expected, float f) {
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        } else if (this.f1962n < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1963f = f;
            long bigArraySize = HashCommon.bigArraySize(expected, f);
            this.f1962n = bigArraySize;
            this.minN = bigArraySize;
            this.maxFill = HashCommon.maxFill(this.f1962n, f);
            this.key = FloatBigArrays.newBigArray(this.f1962n);
            initMasks();
        }
    }

    public FloatOpenHashBigSet(long expected) {
        this(expected, 0.75f);
    }

    public FloatOpenHashBigSet() {
        this(16, 0.75f);
    }

    public FloatOpenHashBigSet(Collection<? extends Float> c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public FloatOpenHashBigSet(Collection<? extends Float> c) {
        this(c, 0.75f);
    }

    public FloatOpenHashBigSet(FloatCollection c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public FloatOpenHashBigSet(FloatCollection c) {
        this(c, 0.75f);
    }

    public FloatOpenHashBigSet(FloatIterator i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.nextFloat());
        }
    }

    public FloatOpenHashBigSet(FloatIterator i) {
        this(i, 0.75f);
    }

    public FloatOpenHashBigSet(Iterator<?> i, float f) {
        this(FloatIterators.asFloatIterator(i), f);
    }

    public FloatOpenHashBigSet(Iterator<?> i) {
        this(FloatIterators.asFloatIterator(i));
    }

    public FloatOpenHashBigSet(float[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : (long) length, f);
        FloatArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public FloatOpenHashBigSet(float[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public FloatOpenHashBigSet(float[] a, float f) {
        this(a, 0, a.length, f);
    }

    public FloatOpenHashBigSet(float[] a) {
        this(a, 0.75f);
    }

    /* access modifiers changed from: private */
    public long realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(long capacity) {
        long needed = HashCommon.bigArraySize(capacity, this.f1963f);
        if (needed > this.f1962n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Float> c) {
        long size = Size64.sizeOf(c);
        if (((double) this.f1963f) <= 0.5d) {
            ensureCapacity(size);
        } else {
            ensureCapacity(size64() + size);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean addAll(FloatCollection c) {
        long size = Size64.sizeOf(c);
        if (((double) this.f1963f) <= 0.5d) {
            ensureCapacity(size);
        } else {
            ensureCapacity(size64() + size);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean add(float k) {
        float curr;
        if (Float.floatToIntBits(k) != 0) {
            float[][] key = this.key;
            long h = HashCommon.mix((long) HashCommon.float2int(k));
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            float[] fArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            float curr2 = fArr[i2];
            if (Float.floatToIntBits(curr2) != 0) {
                if (Float.floatToIntBits(curr2) == Float.floatToIntBits(k)) {
                    return false;
                }
                do {
                    int i3 = (displ + 1) & this.segmentMask;
                    displ = i3;
                    int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
                    base = i4;
                    curr = key[i4][displ];
                    if (Float.floatToIntBits(curr) != 0) {
                    }
                } while (Float.floatToIntBits(curr) != Float.floatToIntBits(k));
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
        rehash(2 * this.f1962n);
        return true;
    }

    protected final void shiftKeys(long pos) {
        float[][] key = this.key;
        while (true) {
            long j = pos + 1;
            long j2 = this.mask;
            while (true) {
                pos = j & j2;
                if (Float.floatToIntBits(BigArrays.get(key, pos)) == 0) {
                    BigArrays.set(key, pos, 0.0f);
                    return;
                }
                long slot = HashCommon.mix((long) HashCommon.float2int(BigArrays.get(key, pos))) & this.mask;
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
        if (this.f1962n <= this.minN || this.size >= this.maxFill / 4 || this.f1962n <= 16) {
            return true;
        }
        rehash(this.f1962n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.size--;
        if (this.f1962n <= this.minN || this.size >= this.maxFill / 4 || this.f1962n <= 16) {
            return true;
        }
        rehash(this.f1962n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
    public boolean remove(float k) {
        float curr;
        if (Float.floatToIntBits(k) != 0) {
            float[][] key = this.key;
            long h = HashCommon.mix((long) HashCommon.float2int(k));
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            float[] fArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            float curr2 = fArr[i2];
            if (Float.floatToIntBits(curr2) == 0) {
                return false;
            }
            if (Float.floatToIntBits(curr2) == Float.floatToIntBits(k)) {
                return removeEntry(base, displ);
            }
            do {
                int i3 = (displ + 1) & this.segmentMask;
                displ = i3;
                int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
                base = i4;
                curr = key[i4][displ];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
            } while (Float.floatToIntBits(curr) != Float.floatToIntBits(k));
            return removeEntry(base, displ);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean contains(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNull;
        }
        float[][] key = this.key;
        long h = HashCommon.mix((long) HashCommon.float2int(k));
        int i = (int) ((h & this.mask) >>> 27);
        int base = i;
        float[] fArr = key[i];
        int i2 = (int) (h & ((long) this.segmentMask));
        int displ = i2;
        float curr2 = fArr[i2];
        if (Float.floatToIntBits(curr2) == 0) {
            return false;
        }
        if (Float.floatToIntBits(curr2) == Float.floatToIntBits(k)) {
            return true;
        }
        do {
            int i3 = (displ + 1) & this.segmentMask;
            displ = i3;
            int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
            base = i4;
            curr = key[i4][displ];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
        } while (Float.floatToIntBits(curr) != Float.floatToIntBits(k));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            BigArrays.fill(this.key, 0.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatOpenHashBigSet$SetIterator.class */
    public class SetIterator implements FloatIterator {
        int base;
        int displ;
        long last;

        /* renamed from: c */
        long f1964c;
        boolean mustReturnNull;
        FloatArrayList wrapped;

        private SetIterator() {
            this.base = FloatOpenHashBigSet.this.key.length;
            this.last = -1;
            this.f1964c = FloatOpenHashBigSet.this.size;
            this.mustReturnNull = FloatOpenHashBigSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1964c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            float k;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1964c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = FloatOpenHashBigSet.this.f1962n;
                return 0.0f;
            }
            float[][] key = FloatOpenHashBigSet.this.key;
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
                    FloatArrayList floatArrayList = this.wrapped;
                    int i3 = this.base - 1;
                    this.base = i3;
                    return floatArrayList.getFloat((-i3) - 1);
                }
            } while (Float.floatToIntBits(k) == 0);
            this.last = (((long) this.base) * 134217728) + ((long) this.displ);
            return k;
        }

        private final void shiftKeys(long pos) {
            float curr;
            float[][] key = FloatOpenHashBigSet.this.key;
            while (true) {
                long j = pos + 1;
                long j2 = FloatOpenHashBigSet.this.mask;
                while (true) {
                    pos = j & j2;
                    curr = BigArrays.get(key, pos);
                    if (Float.floatToIntBits(curr) == 0) {
                        BigArrays.set(key, pos, 0.0f);
                        return;
                    }
                    long slot = HashCommon.mix((long) HashCommon.float2int(curr)) & FloatOpenHashBigSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = FloatOpenHashBigSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = FloatOpenHashBigSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new FloatArrayList();
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
            if (this.last == FloatOpenHashBigSet.this.f1962n) {
                FloatOpenHashBigSet.this.containsNull = false;
            } else if (this.base >= 0) {
                shiftKeys(this.last);
            } else {
                FloatOpenHashBigSet.this.remove(this.wrapped.getFloat((-this.base) - 1));
                this.last = -1;
                return;
            }
            FloatOpenHashBigSet.this.size--;
            this.last = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatOpenHashBigSet$SetSpliterator.class */
    public class SetSpliterator implements FloatSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        long pos;
        long max;

        /* renamed from: c */
        long f1965c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = FloatOpenHashBigSet.this.f1962n;
            this.f1965c = 0;
            this.mustReturnNull = FloatOpenHashBigSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(long pos, long max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = FloatOpenHashBigSet.this.f1962n;
            this.f1965c = 0;
            this.mustReturnNull = FloatOpenHashBigSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(FloatConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1965c++;
                action.accept(0.0f);
                return true;
            }
            float[][] key = FloatOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                float gotten = BigArrays.get(key, this.pos);
                if (Float.floatToIntBits(gotten) != 0) {
                    this.f1965c++;
                    this.pos++;
                    action.accept(gotten);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        public void forEachRemaining(FloatConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(0.0f);
                this.f1965c++;
            }
            float[][] key = FloatOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                float gotten = BigArrays.get(key, this.pos);
                if (Float.floatToIntBits(gotten) != 0) {
                    action.accept(gotten);
                    this.f1965c++;
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
                return FloatOpenHashBigSet.this.size - this.f1965c;
            }
            return Math.min(FloatOpenHashBigSet.this.size - this.f1965c, ((long) ((((double) FloatOpenHashBigSet.this.realSize()) / ((double) FloatOpenHashBigSet.this.f1962n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
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
        /* JADX WARN: Type inference failed for: r0v20, types: [long] */
        /* JADX WARN: Type inference failed for: r0v22, types: [long] */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r0v25, types: [long] */
        /* JADX WARN: Type inference failed for: r0v27, types: [long] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
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
                it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet r0 = p014it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet.this
                float[][] r0 = r0.key
                r14 = r0
            L_0x0048:
                r0 = r9
                long r0 = r0.pos
                r1 = r9
                long r1 = r1.max
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x007b
                r0 = r10
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x007b
                r0 = r14
                r1 = r9
                r2 = r1
                long r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                long r3 = r3 + r4
                r2.pos = r3
                float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                int r0 = java.lang.Float.floatToIntBits(r0)
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
            L_0x007b:
                r0 = r12
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatSpliterator spliterator() {
        return new SetSpliterator();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r0v6, types: [float[][], long] */
    /* JADX WARN: Type inference failed for: r10v2, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void forEach(p014it.unimi.dsi.fastutil.floats.FloatConsumer r9) {
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
            long r0 = r0.f1962n
            r12 = r0
            r0 = r8
            float[][] r0 = r0.key
            r14 = r0
        L_0x001c:
            r0 = r10
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0042
            r0 = r14
            r1 = r10
            r2 = r1; r1 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r10 = r2
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r15 = r0
            r0 = r15
            int r0 = java.lang.Float.floatToIntBits(r0)
            if (r0 == 0) goto L_0x003f
            r0 = r9
            r1 = r15
            r0.accept(r1)
        L_0x003f:
            goto L_0x001c
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet.forEach(it.unimi.dsi.fastutil.floats.FloatConsumer):void");
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(long n) {
        long l = HashCommon.bigArraySize(n, this.f1963f);
        if (l >= this.f1962n || this.size > HashCommon.maxFill(l, this.f1963f)) {
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
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [long] */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void rehash(long r8) {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet.rehash(long):void");
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
    public FloatOpenHashBigSet clone() {
        try {
            FloatOpenHashBigSet c = (FloatOpenHashBigSet) clone();
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
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, java.util.Collection, java.lang.Object, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r7 = this;
            r0 = r7
            float[][] r0 = r0.key
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
            if (r0 == 0) goto L_0x006a
        L_0x001e:
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r1 = r11
            r0 = r0[r1]
            int r0 = java.lang.Float.floatToIntBits(r0)
            if (r0 != 0) goto L_0x0044
            r0 = r10
            r1 = r11
            r2 = 1
            int r1 = r1 + r2
            r2 = r7
            int r2 = r2.segmentMask
            r1 = r1 & r2
            r2 = r1
            r11 = r2
            if (r1 != 0) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x001e
        L_0x0044:
            r0 = r9
            r1 = r8
            r2 = r10
            r1 = r1[r2]
            r2 = r11
            r1 = r1[r2]
            int r1 = p014it.unimi.dsi.fastutil.HashCommon.float2int(r1)
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
            if (r1 != 0) goto L_0x0064
            r1 = 1
            goto L_0x0065
        L_0x0064:
            r1 = 0
        L_0x0065:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x0012
        L_0x006a:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet.hashCode():int");
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
            it.unimi.dsi.fastutil.floats.FloatIterator r0 = r0.iterator()
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
            float r1 = r1.nextFloat()
            r0.writeFloat(r1)
            goto L_0x000e
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatOpenHashBigSet.writeObject(java.io.ObjectOutputStream):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0039 */
    /* JADX DEBUG: Multi-variable search result rejected for r15v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v2, types: [long] */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int i;
        s.defaultReadObject();
        this.f1962n = HashCommon.bigArraySize(this.size, this.f1963f);
        this.maxFill = HashCommon.maxFill(this.f1962n, this.f1963f);
        float[][] key = FloatBigArrays.newBigArray(this.f1962n);
        this.key = key;
        initMasks();
        long i2 = this.size;
        while (true) {
            i2--;
            if ((i2 == true ? 1 : 0) != 0) {
                float k = s.readFloat();
                if (Float.floatToIntBits(k) == 0) {
                    this.containsNull = true;
                } else {
                    long h = HashCommon.mix((long) HashCommon.float2int(k));
                    int i3 = (int) ((h & this.mask) >>> 27);
                    int base = i3;
                    float[] fArr = key[i3];
                    int i4 = (int) (h & ((long) this.segmentMask));
                    int displ = i4;
                    if (Float.floatToIntBits(fArr[i4]) != 0) {
                        do {
                            int i5 = (displ + 1) & this.segmentMask;
                            displ = i5;
                            i = (base + (i5 == 0 ? 1 : 0)) & this.baseMask;
                            base = i;
                        } while (Float.floatToIntBits(key[i][displ]) != 0);
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
