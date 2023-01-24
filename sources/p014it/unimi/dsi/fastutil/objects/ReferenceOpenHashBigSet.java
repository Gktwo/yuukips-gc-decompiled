package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collector;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceOpenHashBigSet.class */
public class ReferenceOpenHashBigSet<K> extends AbstractReferenceSet<K> implements Serializable, Cloneable, Hash, Size64 {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[][] key;
    protected transient long mask;
    protected transient int segmentMask;
    protected transient int baseMask;
    protected transient boolean containsNull;

    /* renamed from: n */
    protected transient long f2839n;
    protected transient long maxFill;
    protected final transient long minN;

    /* renamed from: f */
    protected final float f2840f;
    protected long size;
    private static final Collector<Object, ?, ReferenceOpenHashBigSet<Object>> TO_SET_COLLECTOR = Collector.of(ReferenceOpenHashBigSet::new, (v0, v1) -> {
        v0.add(v1);
    }, (v0, v1) -> {
        return v0.combine(v1);
    }, new Collector.Characteristics[0]);

    private void initMasks() {
        this.mask = this.f2839n - 1;
        this.segmentMask = this.key[0].length - 1;
        this.baseMask = this.key.length - 1;
    }

    public ReferenceOpenHashBigSet(long expected, float f) {
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        } else if (this.f2839n < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2840f = f;
            long bigArraySize = HashCommon.bigArraySize(expected, f);
            this.f2839n = bigArraySize;
            this.minN = bigArraySize;
            this.maxFill = HashCommon.maxFill(this.f2839n, f);
            this.key = (K[][]) ObjectBigArrays.newBigArray(this.f2839n);
            initMasks();
        }
    }

    public ReferenceOpenHashBigSet(long expected) {
        this(expected, 0.75f);
    }

    public ReferenceOpenHashBigSet() {
        this(16, 0.75f);
    }

    public ReferenceOpenHashBigSet(Collection<? extends K> c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public ReferenceOpenHashBigSet(Collection<? extends K> c) {
        this(c, 0.75f);
    }

    public ReferenceOpenHashBigSet(ReferenceCollection<? extends K> c, float f) {
        this(Size64.sizeOf(c), f);
        addAll(c);
    }

    public ReferenceOpenHashBigSet(ReferenceCollection<? extends K> c) {
        this((ReferenceCollection) c, 0.75f);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ReferenceOpenHashBigSet(Iterator<? extends K> i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public ReferenceOpenHashBigSet(Iterator<? extends K> i) {
        this(i, 0.75f);
    }

    public ReferenceOpenHashBigSet(K[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : (long) length, f);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ReferenceOpenHashBigSet(K[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public ReferenceOpenHashBigSet(K[] a, float f) {
        this(a, 0, a.length, f);
    }

    public ReferenceOpenHashBigSet(K[] a) {
        this(a, 0.75f);
    }

    private ReferenceOpenHashBigSet<K> combine(ReferenceOpenHashBigSet<? extends K> toAddFrom) {
        addAll(toAddFrom);
        return this;
    }

    public static <K> Collector<K, ?, ReferenceOpenHashBigSet<K>> toBigSet() {
        return (Collector<K, ?, ReferenceOpenHashBigSet<K>>) TO_SET_COLLECTOR;
    }

    public static <K> Collector<K, ?, ReferenceOpenHashBigSet<K>> toBigSetWithExpectedSize(long expectedSize) {
        return Collector.of(() -> {
            return new ReferenceOpenHashBigSet(expectedSize);
        }, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, new Collector.Characteristics[0]);
    }

    /* access modifiers changed from: private */
    public long realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(long capacity) {
        long needed = HashCommon.bigArraySize(capacity, this.f2840f);
        if (needed > this.f2839n) {
            rehash(needed);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends K> c) {
        long size = Size64.sizeOf(c);
        if (((double) this.f2840f) <= 0.5d) {
            ensureCapacity(size);
        } else {
            ensureCapacity(size64() + size);
        }
        return addAll(c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(K k) {
        K curr;
        if (k != null) {
            K[][] key = this.key;
            long h = HashCommon.mix((long) System.identityHashCode(k));
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            K[] kArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            K curr2 = kArr[i2];
            if (curr2 != null) {
                if (curr2 == k) {
                    return false;
                }
                do {
                    int i3 = (displ + 1) & this.segmentMask;
                    displ = i3;
                    int i4 = (base + (i3 == 0 ? 1 : 0)) & this.baseMask;
                    base = i4;
                    curr = key[i4][displ];
                    if (curr != null) {
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
        rehash(2 * this.f2839n);
        return true;
    }

    protected final void shiftKeys(long pos) {
        K[][] key = this.key;
        while (true) {
            long j = pos + 1;
            long j2 = this.mask;
            while (true) {
                pos = j & j2;
                if (BigArrays.get(key, pos) == null) {
                    BigArrays.set(key, pos, (Object) null);
                    return;
                }
                long slot = HashCommon.mix((long) System.identityHashCode(BigArrays.get(key, pos))) & this.mask;
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
        if (this.f2839n <= this.minN || this.size >= this.maxFill / 4 || this.f2839n <= 16) {
            return true;
        }
        rehash(this.f2839n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.size--;
        if (this.f2839n <= this.minN || this.size >= this.maxFill / 4 || this.f2839n <= 16) {
            return true;
        }
        rehash(this.f2839n / 2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object k) {
        K curr;
        if (k != null) {
            K[][] key = this.key;
            long h = HashCommon.mix((long) System.identityHashCode(k));
            int i = (int) ((h & this.mask) >>> 27);
            int base = i;
            K[] kArr = key[i];
            int i2 = (int) (h & ((long) this.segmentMask));
            int displ = i2;
            K curr2 = kArr[i2];
            if (curr2 == null) {
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
                if (curr == null) {
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object k) {
        K curr;
        if (k == null) {
            return this.containsNull;
        }
        K[][] key = this.key;
        long h = HashCommon.mix((long) System.identityHashCode(k));
        int i = (int) ((h & this.mask) >>> 27);
        int base = i;
        K[] kArr = key[i];
        int i2 = (int) (h & ((long) this.segmentMask));
        int displ = i2;
        K curr2 = kArr[i2];
        if (curr2 == null) {
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
            if (curr == null) {
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
            BigArrays.fill(this.key, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceOpenHashBigSet$SetIterator.class */
    public class SetIterator implements ObjectIterator<K> {
        int base;
        int displ;
        long last;

        /* renamed from: c */
        long f2841c;
        boolean mustReturnNull;
        ReferenceArrayList<K> wrapped;

        private SetIterator() {
            this.base = ReferenceOpenHashBigSet.this.key.length;
            this.last = -1;
            this.f2841c = ReferenceOpenHashBigSet.this.size;
            this.mustReturnNull = ReferenceOpenHashBigSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2841c != 0;
        }

        @Override // java.util.Iterator
        public K next() {
            K k;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2841c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ReferenceOpenHashBigSet.this.f2839n;
                return null;
            }
            K[][] key = ReferenceOpenHashBigSet.this.key;
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
                    ReferenceArrayList<K> referenceArrayList = this.wrapped;
                    int i3 = this.base - 1;
                    this.base = i3;
                    return referenceArrayList.get((-i3) - 1);
                }
            } while (k == null);
            this.last = (((long) this.base) * 134217728) + ((long) this.displ);
            return k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: it.unimi.dsi.fastutil.objects.ReferenceArrayList<K> */
        /* JADX WARN: Multi-variable type inference failed */
        private final void shiftKeys(long pos) {
            Object obj;
            K[][] key = ReferenceOpenHashBigSet.this.key;
            while (true) {
                long j = pos + 1;
                long j2 = ReferenceOpenHashBigSet.this.mask;
                while (true) {
                    pos = j & j2;
                    obj = BigArrays.get(key, pos);
                    if (obj == null) {
                        BigArrays.set(key, pos, (Object) null);
                        return;
                    }
                    long slot = HashCommon.mix((long) System.identityHashCode(obj)) & ReferenceOpenHashBigSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = ReferenceOpenHashBigSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        j = pos + 1;
                        j2 = ReferenceOpenHashBigSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ReferenceArrayList<>();
                    }
                    this.wrapped.add(BigArrays.get(key, pos));
                }
                BigArrays.set(key, pos, obj);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == ReferenceOpenHashBigSet.this.f2839n) {
                ReferenceOpenHashBigSet.this.containsNull = false;
            } else if (this.base >= 0) {
                shiftKeys(this.last);
            } else {
                ReferenceOpenHashBigSet.this.remove(this.wrapped.set((-this.base) - 1, null));
                this.last = -1;
                return;
            }
            ReferenceOpenHashBigSet.this.size--;
            this.last = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    public ObjectIterator<K> iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceOpenHashBigSet$SetSpliterator.class */
    public class SetSpliterator implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;
        long pos;
        long max;

        /* renamed from: c */
        long f2842c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = ReferenceOpenHashBigSet.this.f2839n;
            this.f2842c = 0;
            this.mustReturnNull = ReferenceOpenHashBigSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(long pos, long max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = ReferenceOpenHashBigSet.this.f2839n;
            this.f2842c = 0;
            this.mustReturnNull = ReferenceOpenHashBigSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2842c++;
                action.accept(null);
                return true;
            }
            K[][] key = ReferenceOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                Object obj = (Object) BigArrays.get(key, this.pos);
                if (obj != 0) {
                    this.f2842c++;
                    this.pos++;
                    action.accept(obj);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(null);
                this.f2842c++;
            }
            K[][] key = ReferenceOpenHashBigSet.this.key;
            while (this.pos < this.max) {
                Object obj = (Object) BigArrays.get(key, this.pos);
                if (obj != 0) {
                    action.accept(obj);
                    this.f2842c++;
                }
                this.pos++;
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 1 : 65;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (!this.hasSplit) {
                return ReferenceOpenHashBigSet.this.size - this.f2842c;
            }
            return Math.min(ReferenceOpenHashBigSet.this.size - this.f2842c, ((long) ((((double) ReferenceOpenHashBigSet.this.realSize()) / ((double) ReferenceOpenHashBigSet.this.f2839n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ReferenceOpenHashBigSet<K>.SetSpliterator trySplit() {
            if (this.pos >= this.max - 1) {
                return null;
            }
            long retLen = (this.max - this.pos) >> 1;
            if (retLen <= 1) {
                return null;
            }
            long myNewPos = BigArrays.nearestSegmentStart(this.pos + retLen, this.pos + 1, this.max - 1);
            ReferenceOpenHashBigSet<K>.SetSpliterator split = new SetSpliterator(this.pos, myNewPos, this.mustReturnNull, true);
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
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
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
                it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet r0 = p014it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet.this
                K[][] r0 = r0.key
                r14 = r0
            L_0x0048:
                r0 = r9
                long r0 = r0.pos
                r1 = r9
                long r1 = r1.max
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0079
                r0 = r10
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0079
                r0 = r14
                r1 = r9
                r2 = r1
                long r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                long r3 = r3 + r4
                r2.pos = r3
                java.lang.Object r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
                r1 = 0
                if (r0 == r1) goto L_0x0048
                r0 = r12
                r1 = 1
                long r0 = r0 + r1
                r12 = r0
                r0 = r10
                r1 = 1
                long r0 = r0 - r1
                r10 = r0
                goto L_0x0048
            L_0x0079:
                r0 = r12
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return new SetSpliterator();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r0v6, types: [long, java.lang.Object[][], K[][]] */
    /* JADX WARN: Type inference failed for: r10v2, types: [long] */
    @Override // java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        if (this.containsNull) {
            action.accept(null);
        }
        long pos = 0;
        long max = this.f2839n;
        K[][] kArr = this.key;
        while ((pos == true ? 1 : 0) < max) {
            pos++;
            Object obj = (Object) BigArrays.get((Object[][]) kArr, (long) kArr);
            if (obj != 0) {
                action.accept(obj);
            }
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(long n) {
        long l = HashCommon.bigArraySize(n, this.f2840f);
        if (l >= this.f2839n || this.size > HashCommon.maxFill(l, this.f2840f)) {
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
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void rehash(long r8) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet.rehash(long):void");
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
    public ReferenceOpenHashBigSet<K> clone() {
        try {
            ReferenceOpenHashBigSet<K> c = (ReferenceOpenHashBigSet) clone();
            c.key = (K[][]) BigArrays.copy(this.key);
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
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, java.util.Collection, java.lang.Object, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r7 = this;
            r0 = r7
            K[][] r0 = r0.key
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
            if (r0 == 0) goto L_0x0072
        L_0x001e:
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r1 = r11
            r0 = r0[r1]
            r1 = 0
            if (r0 != r1) goto L_0x0042
            r0 = r10
            r1 = r11
            r2 = 1
            int r1 = r1 + r2
            r2 = r7
            int r2 = r2.segmentMask
            r1 = r1 & r2
            r2 = r1
            r11 = r2
            if (r1 != 0) goto L_0x003c
            r1 = 1
            goto L_0x003d
        L_0x003c:
            r1 = 0
        L_0x003d:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x001e
        L_0x0042:
            r0 = r7
            r1 = r8
            r2 = r10
            r1 = r1[r2]
            r2 = r11
            r1 = r1[r2]
            if (r0 == r1) goto L_0x0058
            r0 = r9
            r1 = r8
            r2 = r10
            r1 = r1[r2]
            r2 = r11
            r1 = r1[r2]
            int r1 = java.lang.System.identityHashCode(r1)
            int r0 = r0 + r1
            r9 = r0
        L_0x0058:
            r0 = r10
            r1 = r11
            r2 = 1
            int r1 = r1 + r2
            r2 = r7
            int r2 = r2.segmentMask
            r1 = r1 & r2
            r2 = r1
            r11 = r2
            if (r1 != 0) goto L_0x006c
            r1 = 1
            goto L_0x006d
        L_0x006c:
            r1 = 0
        L_0x006d:
            int r0 = r0 + r1
            r10 = r0
            goto L_0x0012
        L_0x0072:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet.hashCode():int");
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
            it.unimi.dsi.fastutil.objects.ObjectIterator r0 = r0.iterator()
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
            java.lang.Object r1 = r1.next()
            r0.writeObject(r1)
            goto L_0x000e
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet.writeObject(java.io.ObjectOutputStream):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0039 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: K[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r15v1, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v25, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v2, types: [long] */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int i;
        s.defaultReadObject();
        this.f2839n = HashCommon.bigArraySize(this.size, this.f2840f);
        this.maxFill = HashCommon.maxFill(this.f2839n, this.f2840f);
        K[][] key = (K[][]) ObjectBigArrays.newBigArray(this.f2839n);
        this.key = key;
        initMasks();
        long i2 = this.size;
        while (true) {
            i2--;
            if ((i2 == true ? 1 : 0) != 0) {
                Object readObject = s.readObject();
                if (readObject == null) {
                    this.containsNull = true;
                } else {
                    long h = HashCommon.mix((long) System.identityHashCode(readObject));
                    int i3 = (int) ((h & this.mask) >>> 27);
                    int base = i3;
                    Object[] objArr = key[i3];
                    int i4 = (int) (h & ((long) this.segmentMask));
                    int displ = i4;
                    if (objArr[i4] != 0) {
                        do {
                            int i5 = (displ + 1) & this.segmentMask;
                            displ = i5;
                            i = (base + (i5 == 0 ? 1 : 0)) & this.baseMask;
                            base = i;
                        } while (key[i][displ] != 0);
                        key[base][displ] = readObject;
                    } else {
                        key[base][displ] = readObject;
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
