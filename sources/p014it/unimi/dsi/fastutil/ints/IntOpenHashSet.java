package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.ints.IntCollections;

/* renamed from: it.unimi.dsi.fastutil.ints.IntOpenHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntOpenHashSet.class */
public class IntOpenHashSet extends AbstractIntSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient int[] key;
    protected transient int mask;
    protected transient boolean containsNull;

    /* renamed from: n */
    protected transient int f2160n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2161f;

    public IntOpenHashSet(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2161f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2160n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2160n - 1;
            this.maxFill = HashCommon.maxFill(this.f2160n, f);
            this.key = new int[this.f2160n + 1];
        }
    }

    public IntOpenHashSet(int expected) {
        this(expected, 0.75f);
    }

    public IntOpenHashSet() {
        this(16, 0.75f);
    }

    public IntOpenHashSet(Collection<? extends Integer> c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public IntOpenHashSet(Collection<? extends Integer> c) {
        this(c, 0.75f);
    }

    public IntOpenHashSet(IntCollection c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public IntOpenHashSet(IntCollection c) {
        this(c, 0.75f);
    }

    public IntOpenHashSet(IntIterator i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.nextInt());
        }
    }

    public IntOpenHashSet(IntIterator i) {
        this(i, 0.75f);
    }

    public IntOpenHashSet(Iterator<?> i, float f) {
        this(IntIterators.asIntIterator(i), f);
    }

    public IntOpenHashSet(Iterator<?> i) {
        this(IntIterators.asIntIterator(i));
    }

    public IntOpenHashSet(int[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : length, f);
        IntArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public IntOpenHashSet(int[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public IntOpenHashSet(int[] a, float f) {
        this(a, 0, a.length, f);
    }

    public IntOpenHashSet(int[] a) {
        this(a, 0.75f);
    }

    /* renamed from: of */
    public static IntOpenHashSet m710of() {
        return new IntOpenHashSet();
    }

    /* renamed from: of */
    public static IntOpenHashSet m709of(int e) {
        IntOpenHashSet result = new IntOpenHashSet(1, 0.75f);
        result.add(e);
        return result;
    }

    /* renamed from: of */
    public static IntOpenHashSet m708of(int e0, int e1) {
        IntOpenHashSet result = new IntOpenHashSet(2, 0.75f);
        result.add(e0);
        if (result.add(e1)) {
            return result;
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    public static IntOpenHashSet m707of(int e0, int e1, int e2) {
        IntOpenHashSet result = new IntOpenHashSet(3, 0.75f);
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
    public static IntOpenHashSet m706of(int... a) {
        IntOpenHashSet result = new IntOpenHashSet(a.length, 0.75f);
        for (int element : a) {
            if (!result.add(element)) {
                throw new IllegalArgumentException("Duplicate element " + element);
            }
        }
        return result;
    }

    public static IntOpenHashSet toSet(IntStream stream) {
        return (IntOpenHashSet) stream.collect(IntOpenHashSet::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static IntOpenHashSet toSetWithExpectedSize(IntStream stream, int expectedSize) {
        if (expectedSize <= 16) {
            return toSet(stream);
        }
        return (IntOpenHashSet) stream.collect(new IntCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 16 ? new IntOpenHashSet() : new IntOpenHashSet(size);
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
        int needed = HashCommon.arraySize(capacity, this.f2161f);
        if (needed > this.f2160n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2161f)))));
        if (needed > this.f2160n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean addAll(IntCollection c) {
        if (((double) this.f2161f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Integer> c) {
        if (((double) this.f2161f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
    public boolean add(int k) {
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 != 0) {
                if (curr2 == k) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (curr != k);
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
        rehash(HashCommon.arraySize(this.size + 1, this.f2161f));
        return true;
    }

    protected final void shiftKeys(int pos) {
        int curr;
        int[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (curr == 0) {
                    key[pos] = 0;
                    return;
                }
                int slot = HashCommon.mix(curr) & this.mask;
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
        if (this.f2160n <= this.minN || this.size >= this.maxFill / 4 || this.f2160n <= 16) {
            return true;
        }
        rehash(this.f2160n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f2160n] = 0;
        this.size--;
        if (this.f2160n <= this.minN || this.size >= this.maxFill / 4 || this.f2160n <= 16) {
            return true;
        }
        rehash(this.f2160n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
    public boolean remove(int k) {
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return removeEntry(pos);
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
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return false;
        }
        if (k == curr2) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return false;
            }
        } while (k != curr);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, 0);
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
    /* renamed from: it.unimi.dsi.fastutil.ints.IntOpenHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntOpenHashSet$SetIterator.class */
    public final class SetIterator implements IntIterator {
        int pos;
        int last;

        /* renamed from: c */
        int f2162c;
        boolean mustReturnNull;
        IntArrayList wrapped;

        private SetIterator() {
            this.pos = IntOpenHashSet.this.f2160n;
            this.last = -1;
            this.f2162c = IntOpenHashSet.this.size;
            this.mustReturnNull = IntOpenHashSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2162c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2162c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = IntOpenHashSet.this.f2160n;
                return IntOpenHashSet.this.key[IntOpenHashSet.this.f2160n];
            }
            int[] key = IntOpenHashSet.this.key;
            do {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    return this.wrapped.getInt((-this.pos) - 1);
                }
            } while (key[this.pos] == 0);
            int i2 = this.pos;
            this.last = i2;
            return key[i2];
        }

        private final void shiftKeys(int pos) {
            int curr;
            int[] key = IntOpenHashSet.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = IntOpenHashSet.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(curr) & IntOpenHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = IntOpenHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = IntOpenHashSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new IntArrayList(2);
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
            if (this.last == IntOpenHashSet.this.f2160n) {
                IntOpenHashSet.this.containsNull = false;
                IntOpenHashSet.this.key[IntOpenHashSet.this.f2160n] = 0;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                IntOpenHashSet.this.remove(this.wrapped.getInt((-this.pos) - 1));
                this.last = -1;
                return;
            }
            IntOpenHashSet.this.size--;
            this.last = -1;
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            int[] key = IntOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = IntOpenHashSet.this.f2160n;
                action.accept(key[IntOpenHashSet.this.f2160n]);
                this.f2162c--;
            }
            while (this.f2162c != 0) {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept(this.wrapped.getInt((-this.pos) - 1));
                    this.f2162c--;
                } else if (key[this.pos] != 0) {
                    int i2 = this.pos;
                    this.last = i2;
                    action.accept(key[i2]);
                    this.f2162c--;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntOpenHashSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntOpenHashSet$SetSpliterator.class */
    public final class SetSpliterator implements IntSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        int pos;
        int max;

        /* renamed from: c */
        int f2163c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = IntOpenHashSet.this.f2160n;
            this.f2163c = 0;
            this.mustReturnNull = IntOpenHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = IntOpenHashSet.this.f2160n;
            this.f2163c = 0;
            this.mustReturnNull = IntOpenHashSet.this.containsNull;
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
                this.f2163c++;
                action.accept(IntOpenHashSet.this.key[IntOpenHashSet.this.f2160n]);
                return true;
            }
            int[] key = IntOpenHashSet.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2163c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(key[i]);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            int[] key = IntOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(key[IntOpenHashSet.this.f2160n]);
                this.f2163c++;
            }
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    action.accept(key[this.pos]);
                    this.f2163c++;
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
                return (long) (IntOpenHashSet.this.size - this.f2163c);
            }
            return Math.min((long) (IntOpenHashSet.this.size - this.f2163c), ((long) ((((double) IntOpenHashSet.this.realSize()) / ((double) IntOpenHashSet.this.f2160n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
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
        /* JADX WARN: Type inference failed for: r0v18, types: [long] */
        /* JADX WARN: Type inference failed for: r0v20, types: [long] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r0v23, types: [long] */
        /* JADX WARN: Type inference failed for: r0v25, types: [long] */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator
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
                it.unimi.dsi.fastutil.ints.IntOpenHashSet r0 = p014it.unimi.dsi.fastutil.ints.IntOpenHashSet.this
                int[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0075
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0075
                r0 = r11
                r1 = r6
                r2 = r1
                int r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                int r3 = r3 + r4
                r2.pos = r3
                r0 = r0[r1]
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
            L_0x0075:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntOpenHashSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
    public IntSpliterator spliterator() {
        return new SetSpliterator();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
    public void forEach(IntConsumer action) {
        if (this.containsNull) {
            action.accept(this.key[this.f2160n]);
        }
        int[] key = this.key;
        int pos = this.f2160n;
        while (true) {
            pos--;
            if (pos == 0) {
                return;
            }
            if (key[pos] != 0) {
                action.accept(key[pos]);
            }
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2161f)));
        if (l >= this.f2160n || this.size > HashCommon.maxFill(l, this.f2161f)) {
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
        int[] key = this.key;
        int mask = newN - 1;
        int[] newKey = new int[newN + 1];
        int i2 = this.f2160n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == 0);
                int mix = HashCommon.mix(key[i2]) & mask;
                int pos = mix;
                if (newKey[mix] != 0) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (newKey[i] != 0);
                }
                newKey[pos] = key[i2];
            } else {
                this.f2160n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2160n, this.f2161f);
                this.key = newKey;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public IntOpenHashSet clone() {
        try {
            IntOpenHashSet c = (IntOpenHashSet) clone();
            c.key = (int[]) this.key.clone();
            c.containsNull = this.containsNull;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (this.key[i] == 0) {
                i++;
            }
            h += this.key[i];
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        IntIterator i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeInt(i.nextInt());
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f2160n = HashCommon.arraySize(this.size, this.f2161f);
        this.maxFill = HashCommon.maxFill(this.f2160n, this.f2161f);
        this.mask = this.f2160n - 1;
        int[] key = new int[this.f2160n + 1];
        this.key = key;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 != 0) {
                int k = s.readInt();
                if (k == 0) {
                    pos = this.f2160n;
                    this.containsNull = true;
                } else {
                    int mix = HashCommon.mix(k) & this.mask;
                    pos = mix;
                    if (key[mix] != 0) {
                        do {
                            i = (pos + 1) & this.mask;
                            pos = i;
                        } while (key[i] != 0);
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
