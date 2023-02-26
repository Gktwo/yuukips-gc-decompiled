package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.ints.IntOpenHashBigSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntOpenHashBigSet.class */
public class IntOpenHashBigSet extends AbstractIntSet implements Serializable, Cloneable, Hash, Size64 {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient int[][] key;
    protected transient long mask;
    protected transient int segmentMask;
    protected transient int baseMask;
    protected transient boolean containsNull;

    /* renamed from: n */
    protected transient long f2156n;
    protected transient long maxFill;
    protected final transient long minN;

    /* renamed from: f */
    protected final float f2157f;
    protected long size;

    private void initMasks() {
        this.mask = this.f2156n - 1;
        this.segmentMask = this.key[0].length - 1;
        this.baseMask = this.key.length - 1;
    }

    public IntOpenHashBigSet(long expected, float f) {
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        } else if (this.f2156n < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2157f = f;
            long bigArraySize = HashCommon.bigArraySize(expected, f);
            this.f2156n = bigArraySize;
            this.minN = bigArraySize;
            this.maxFill = HashCommon.maxFill(this.f2156n, f);
            this.key = IntBigArrays.newBigArray(this.f2156n);
            initMasks();
        }
    }

    public IntOpenHashBigSet(long expected) {
        this(expected, 0.75f);
    }

    public IntOpenHashBigSet() {
        this(16, 0.75f);
    }

    public IntOpenHashBigSet(Collection<? extends Integer> c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public IntOpenHashBigSet(Collection<? extends Integer> c) {
        this(c, 0.75f);
    }

    public IntOpenHashBigSet(IntCollection c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public IntOpenHashBigSet(IntCollection c) {
        this(c, 0.75f);
    }

    public IntOpenHashBigSet(IntIterator i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.nextInt());
        }
    }

    public IntOpenHashBigSet(IntIterator i) {
        this(i, 0.75f);
    }

    public IntOpenHashBigSet(Iterator<?> i, float f) {
        this(IntIterators.asIntIterator(i), f);
    }

    public IntOpenHashBigSet(Iterator<?> i) {
        this(IntIterators.asIntIterator(i));
    }

    public IntOpenHashBigSet(int[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : (long) length, f);
        IntArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public IntOpenHashBigSet(int[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public IntOpenHashBigSet(int[] a, float f) {
        this(a, 0, a.length, f);
    }

    public IntOpenHashBigSet(int[] a) {
        this(a, 0.75f);
    }

    public static IntOpenHashBigSet toBigSet(IntStream stream) {
        return (IntOpenHashBigSet) stream.collect(IntOpenHashBigSet::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static IntOpenHashBigSet toBigSetWithExpectedSize(IntStream stream, long expectedSize) {
        return (IntOpenHashBigSet) stream.collect(() -> {
            return new IntOpenHashBigSet(expectedSize);
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
        long needed = HashCommon.bigArraySize(capacity, this.f2157f);
        if (needed > this.f2156n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Integer> c) {
        long size = Size64.sizeOf(c);
        if (((double) this.f2157f) <= 0.5d) {
            ensureCapacity(size);
        } else {
            ensureCapacity(size64() + size);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean addAll(IntCollection c) {
        long size = Size64.sizeOf(c);
        if (((double) this.f2157f) <= 0.5d) {
            ensureCapacity(size);
        } else {
            ensureCapacity(size64() + size);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean add(int k) {
        int curr;
        if (k != 0) {
            int[][] key = this.key;
            long h = HashCommon.mix((long) k);
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            int[] iArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            int curr2 = iArr[i2];
            if (curr2 != 0) {
                if (curr2 == k) {
                    return false;
                }
                do {
                    int i3 = (displ + 1) & this.segmentMask;
                    displ = i3;
                    int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
                    base = i4;
                    curr = key[i4][displ];
                    if (curr != 0) {
                    }
                } while (curr != k);
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
        rehash(2 * this.f2156n);
        return true;
    }

    protected final void shiftKeys(long pos) {
        int[][] key = this.key;
        while (true) {
            long j = pos + 1;
            long j2 = this.mask;
            while (true) {
                pos = j & j2;
                if (BigArrays.get(key, pos) == 0) {
                    BigArrays.set(key, pos, 0);
                    return;
                }
                long slot = HashCommon.mix((long) BigArrays.get(key, pos)) & this.mask;
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
        if (this.f2156n <= this.minN || this.size >= this.maxFill / 4 || this.f2156n <= 16) {
            return true;
        }
        rehash(this.f2156n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.size--;
        if (this.f2156n <= this.minN || this.size >= this.maxFill / 4 || this.f2156n <= 16) {
            return true;
        }
        rehash(this.f2156n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
    public boolean remove(int k) {
        int curr;
        if (k != 0) {
            int[][] key = this.key;
            long h = HashCommon.mix((long) k);
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            int[] iArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            int curr2 = iArr[i2];
            if (curr2 == 0) {
                return false;
            }
            if (curr2 == k) {
                return removeEntry(base, displ);
            }
            do {
                int i3 = (displ + 1) & this.segmentMask;
                displ = i3;
                int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
                base = i4;
                curr = key[i4][displ];
                if (curr == 0) {
                    return false;
                }
            } while (curr != k);
            return removeEntry(base, displ);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean contains(int k) {
        int curr;
        if (k == 0) {
            return this.containsNull;
        }
        int[][] key = this.key;
        long h = HashCommon.mix((long) k);
        int i = (int) ((h & this.mask) >>> 27);
        int base = i;
        int[] iArr = key[i];
        int i2 = (int) (h & ((long) this.segmentMask));
        int displ = i2;
        int curr2 = iArr[i2];
        if (curr2 == 0) {
            return false;
        }
        if (curr2 == k) {
            return true;
        }
        do {
            int i3 = (displ + 1) & this.segmentMask;
            displ = i3;
            int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
            base = i4;
            curr = key[i4][displ];
            if (curr == 0) {
                return false;
            }
        } while (curr != k);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            BigArrays.fill(this.key, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntOpenHashBigSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntOpenHashBigSet$SetIterator.class */
    public class SetIterator implements IntIterator {
        int base;
        int displ;
        long last;

        /* renamed from: c */
        long f2158c;
        boolean mustReturnNull;
        IntArrayList wrapped;

        private SetIterator() {
            this.base = IntOpenHashBigSet.this.key.length;
            this.last = -1;
            this.f2158c = IntOpenHashBigSet.this.size;
            this.mustReturnNull = IntOpenHashBigSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2158c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            int k;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2158c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = IntOpenHashBigSet.this.f2156n;
                return 0;
            }
            int[][] key = IntOpenHashBigSet.this.key;
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
                    IntArrayList intArrayList = this.wrapped;
                    int i3 = this.base - 1;
                    this.base = i3;
                    return intArrayList.getInt((-i3) - 1);
                }
            } while (k == 0);
            this.last = (((long) this.base) * 134217728) + ((long) this.displ);
            return k;
        }

        private final void shiftKeys(long pos) {
            int curr;
            int[][] key = IntOpenHashBigSet.this.key;
            while (true) {
                long j = pos + 1;
                long j2 = IntOpenHashBigSet.this.mask;
                while (true) {
                    pos = j & j2;
                    curr = BigArrays.get(key, pos);
                    if (curr == 0) {
                        BigArrays.set(key, pos, 0);
                        return;
                    }
                    long slot = HashCommon.mix((long) curr) & IntOpenHashBigSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = IntOpenHashBigSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = IntOpenHashBigSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new IntArrayList();
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
            if (this.last == IntOpenHashBigSet.this.f2156n) {
                IntOpenHashBigSet.this.containsNull = false;
            } else if (this.base >= 0) {
                shiftKeys(this.last);
            } else {
                IntOpenHashBigSet.this.remove(this.wrapped.getInt((-this.base) - 1));
                this.last = -1;
                return;
            }
            IntOpenHashBigSet.this.size--;
            this.last = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntOpenHashBigSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntOpenHashBigSet$SetSpliterator.class */
    public class SetSpliterator implements IntSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        long pos;
        long max;

        /* renamed from: c */
        long f2159c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = IntOpenHashBigSet.this.f2156n;
            this.f2159c = 0;
            this.mustReturnNull = IntOpenHashBigSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(long pos, long max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = IntOpenHashBigSet.this.f2156n;
            this.f2159c = 0;
            this.mustReturnNull = IntOpenHashBigSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        @Override // java.util.Spliterator.OfInt
        public boolean tryAdvance(IntConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2159c++;
                action.accept(0);
                return true;
            }
            int[][] key = IntOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                int gotten = BigArrays.get(key, this.pos);
                if (gotten != 0) {
                    this.f2159c++;
                    this.pos++;
                    action.accept(gotten);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(0);
                this.f2159c++;
            }
            int[][] key = IntOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                int gotten = BigArrays.get(key, this.pos);
                if (gotten != 0) {
                    action.accept(gotten);
                    this.f2159c++;
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
                return IntOpenHashBigSet.this.size - this.f2159c;
            }
            return Math.min(IntOpenHashBigSet.this.size - this.f2159c, ((long) ((((double) IntOpenHashBigSet.this.realSize()) / ((double) IntOpenHashBigSet.this.f2156n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
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
        /* JADX WARN: Type inference failed for: r0v19, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r0v24, types: [long] */
        /* JADX WARN: Type inference failed for: r0v26, types: [long] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator
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
                it.unimi.dsi.fastutil.ints.IntOpenHashBigSet r0 = p014it.unimi.dsi.fastutil.ints.IntOpenHashBigSet.this
                int[][] r0 = r0.key
                r14 = r0
            L_0x0048:
                r0 = r9
                long r0 = r0.pos
                r1 = r9
                long r1 = r1.max
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0078
                r0 = r10
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0078
                r0 = r14
                r1 = r9
                r2 = r1
                long r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                long r3 = r3 + r4
                r2.pos = r3
                int r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
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
            L_0x0078:
                r0 = r12
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntOpenHashBigSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntSpliterator spliterator() {
        return new SetSpliterator();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r0v6, types: [long, int[][]] */
    /* JADX WARN: Type inference failed for: r10v2, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void forEach(java.util.function.IntConsumer r9) {
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
            long r0 = r0.f2156n
            r12 = r0
            r0 = r8
            int[][] r0 = r0.key
            r14 = r0
        L_0x001c:
            r0 = r10
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x003f
            r0 = r14
            r1 = r10
            r2 = r1; r1 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r10 = r2
            int r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r15 = r0
            r0 = r15
            if (r0 == 0) goto L_0x003c
            r0 = r9
            r1 = r15
            r0.accept(r1)
        L_0x003c:
            goto L_0x001c
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntOpenHashBigSet.forEach(java.util.function.IntConsumer):void");
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(long n) {
        long l = HashCommon.bigArraySize(n, this.f2157f);
        if (l >= this.f2156n || this.size > HashCommon.maxFill(l, this.f2157f)) {
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
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void rehash(long r8) {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntOpenHashBigSet.rehash(long):void");
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
    public IntOpenHashBigSet clone() {
        try {
            IntOpenHashBigSet c = (IntOpenHashBigSet) clone();
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
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, java.util.Collection, java.lang.Object, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r7 = this;
            r0 = r7
            int[][] r0 = r0.key
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
            if (r0 == 0) goto L_0x0064
        L_0x001e:
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r1 = r11
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0041
            r0 = r10
            r1 = r11
            r2 = 1
            int r1 = r1 + r2
            r2 = r7
            int r2 = r2.segmentMask
            r1 = r1 & r2
            r2 = r1
            r11 = r2
            if (r1 != 0) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x001e
        L_0x0041:
            r0 = r9
            r1 = r8
            r2 = r10
            r1 = r1[r2]
            r2 = r11
            r1 = r1[r2]
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
            if (r1 != 0) goto L_0x005e
            r1 = 1
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x0012
        L_0x0064:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntOpenHashBigSet.hashCode():int");
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
            it.unimi.dsi.fastutil.ints.IntIterator r0 = r0.iterator()
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
            int r1 = r1.nextInt()
            r0.writeInt(r1)
            goto L_0x000e
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntOpenHashBigSet.writeObject(java.io.ObjectOutputStream):void");
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
        this.f2156n = HashCommon.bigArraySize(this.size, this.f2157f);
        this.maxFill = HashCommon.maxFill(this.f2156n, this.f2157f);
        int[][] key = IntBigArrays.newBigArray(this.f2156n);
        this.key = key;
        initMasks();
        long i2 = this.size;
        while (true) {
            i2--;
            if ((i2 == true ? 1 : 0) != 0) {
                int k = s.readInt();
                if (k == 0) {
                    this.containsNull = true;
                } else {
                    long h = HashCommon.mix((long) k);
                    int i3 = (int) ((h & this.mask) >>> 27);
                    int base = i3;
                    int[] iArr = key[i3];
                    int i4 = (int) (h & ((long) this.segmentMask));
                    int displ = i4;
                    if (iArr[i4] != 0) {
                        do {
                            int i5 = (displ + 1) & this.segmentMask;
                            displ = i5;
                            i = (base + (i5 == 0 ? 1 : 0)) & this.baseMask;
                            base = i;
                        } while (key[i][displ] != 0);
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
