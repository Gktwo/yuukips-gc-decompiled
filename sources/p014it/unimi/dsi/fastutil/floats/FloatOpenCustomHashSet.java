package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.floats.FloatHash;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatOpenCustomHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatOpenCustomHashSet.class */
public class FloatOpenCustomHashSet extends AbstractFloatSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient float[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected FloatHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f1958n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1959f;

    public FloatOpenCustomHashSet(int expected, float f, FloatHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1959f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1958n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1958n - 1;
            this.maxFill = HashCommon.maxFill(this.f1958n, f);
            this.key = new float[this.f1958n + 1];
        }
    }

    public FloatOpenCustomHashSet(int expected, FloatHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public FloatOpenCustomHashSet(FloatHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public FloatOpenCustomHashSet(Collection<? extends Float> c, float f, FloatHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public FloatOpenCustomHashSet(Collection<? extends Float> c, FloatHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public FloatOpenCustomHashSet(FloatCollection c, float f, FloatHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public FloatOpenCustomHashSet(FloatCollection c, FloatHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public FloatOpenCustomHashSet(FloatIterator i, float f, FloatHash.Strategy strategy) {
        this(16, f, strategy);
        while (i.hasNext()) {
            add(i.nextFloat());
        }
    }

    public FloatOpenCustomHashSet(FloatIterator i, FloatHash.Strategy strategy) {
        this(i, 0.75f, strategy);
    }

    public FloatOpenCustomHashSet(Iterator<?> i, float f, FloatHash.Strategy strategy) {
        this(FloatIterators.asFloatIterator(i), f, strategy);
    }

    public FloatOpenCustomHashSet(Iterator<?> i, FloatHash.Strategy strategy) {
        this(FloatIterators.asFloatIterator(i), strategy);
    }

    public FloatOpenCustomHashSet(float[] a, int offset, int length, float f, FloatHash.Strategy strategy) {
        this(length < 0 ? 0 : length, f, strategy);
        FloatArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public FloatOpenCustomHashSet(float[] a, int offset, int length, FloatHash.Strategy strategy) {
        this(a, offset, length, 0.75f, strategy);
    }

    public FloatOpenCustomHashSet(float[] a, float f, FloatHash.Strategy strategy) {
        this(a, 0, a.length, f, strategy);
    }

    public FloatOpenCustomHashSet(float[] a, FloatHash.Strategy strategy) {
        this(a, 0.75f, strategy);
    }

    public FloatHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1959f);
        if (needed > this.f1958n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1959f)))));
        if (needed > this.f1958n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean addAll(FloatCollection c) {
        if (((double) this.f1959f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Float> c) {
        if (((double) this.f1959f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean add(float k) {
        float curr;
        if (!this.strategy.equals(k, 0.0f)) {
            float[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) != 0) {
                if (this.strategy.equals(curr2, k)) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Float.floatToIntBits(curr) != 0) {
                    }
                } while (!this.strategy.equals(curr, k));
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            this.containsNull = true;
            this.key[this.f1958n] = k;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size + 1, this.f1959f));
        return true;
    }

    protected final void shiftKeys(int pos) {
        float curr;
        float[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (Float.floatToIntBits(curr) == 0) {
                    key[pos] = 0.0f;
                    return;
                }
                int slot = HashCommon.mix(this.strategy.hashCode(curr)) & this.mask;
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
        if (this.f1958n <= this.minN || this.size >= this.maxFill / 4 || this.f1958n <= 16) {
            return true;
        }
        rehash(this.f1958n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f1958n] = 0.0f;
        this.size--;
        if (this.f1958n <= this.minN || this.size >= this.maxFill / 4 || this.f1958n <= 16) {
            return true;
        }
        rehash(this.f1958n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
    public boolean remove(float k) {
        float curr;
        if (!this.strategy.equals(k, 0.0f)) {
            float[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) == 0) {
                return false;
            }
            if (this.strategy.equals(k, curr2)) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
            } while (!this.strategy.equals(k, curr));
            return removeEntry(pos);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean contains(float k) {
        float curr;
        if (this.strategy.equals(k, 0.0f)) {
            return this.containsNull;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, 0.0f);
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
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatOpenCustomHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatOpenCustomHashSet$SetIterator.class */
    public final class SetIterator implements FloatIterator {
        int pos;
        int last;

        /* renamed from: c */
        int f1960c;
        boolean mustReturnNull;
        FloatArrayList wrapped;

        private SetIterator() {
            this.pos = FloatOpenCustomHashSet.this.f1958n;
            this.last = -1;
            this.f1960c = FloatOpenCustomHashSet.this.size;
            this.mustReturnNull = FloatOpenCustomHashSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1960c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1960c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = FloatOpenCustomHashSet.this.f1958n;
                return FloatOpenCustomHashSet.this.key[FloatOpenCustomHashSet.this.f1958n];
            }
            float[] key = FloatOpenCustomHashSet.this.key;
            do {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    return this.wrapped.getFloat((-this.pos) - 1);
                }
            } while (Float.floatToIntBits(key[this.pos]) == 0);
            int i2 = this.pos;
            this.last = i2;
            return key[i2];
        }

        private final void shiftKeys(int pos) {
            float curr;
            float[] key = FloatOpenCustomHashSet.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = FloatOpenCustomHashSet.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (Float.floatToIntBits(curr) == 0) {
                        key[pos] = 0.0f;
                        return;
                    }
                    int slot = HashCommon.mix(FloatOpenCustomHashSet.this.strategy.hashCode(curr)) & FloatOpenCustomHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = FloatOpenCustomHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = FloatOpenCustomHashSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new FloatArrayList(2);
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
            if (this.last == FloatOpenCustomHashSet.this.f1958n) {
                FloatOpenCustomHashSet.this.containsNull = false;
                FloatOpenCustomHashSet.this.key[FloatOpenCustomHashSet.this.f1958n] = 0.0f;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                FloatOpenCustomHashSet.this.remove(this.wrapped.getFloat((-this.pos) - 1));
                this.last = -1;
                return;
            }
            FloatOpenCustomHashSet.this.size--;
            this.last = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            float[] key = FloatOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = FloatOpenCustomHashSet.this.f1958n;
                action.accept(key[FloatOpenCustomHashSet.this.f1958n]);
                this.f1960c--;
            }
            while (this.f1960c != 0) {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept(this.wrapped.getFloat((-this.pos) - 1));
                    this.f1960c--;
                } else if (Float.floatToIntBits(key[this.pos]) != 0) {
                    int i2 = this.pos;
                    this.last = i2;
                    action.accept(key[i2]);
                    this.f1960c--;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatOpenCustomHashSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatOpenCustomHashSet$SetSpliterator.class */
    public final class SetSpliterator implements FloatSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        int pos;
        int max;

        /* renamed from: c */
        int f1961c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = FloatOpenCustomHashSet.this.f1958n;
            this.f1961c = 0;
            this.mustReturnNull = FloatOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = FloatOpenCustomHashSet.this.f1958n;
            this.f1961c = 0;
            this.mustReturnNull = FloatOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(FloatConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1961c++;
                action.accept(FloatOpenCustomHashSet.this.key[FloatOpenCustomHashSet.this.f1958n]);
                return true;
            }
            float[] key = FloatOpenCustomHashSet.this.key;
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    this.f1961c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(key[i]);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        public void forEachRemaining(FloatConsumer action) {
            float[] key = FloatOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(key[FloatOpenCustomHashSet.this.f1958n]);
                this.f1961c++;
            }
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    action.accept(key[this.pos]);
                    this.f1961c++;
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
                return (long) (FloatOpenCustomHashSet.this.size - this.f1961c);
            }
            return Math.min((long) (FloatOpenCustomHashSet.this.size - this.f1961c), ((long) ((((double) FloatOpenCustomHashSet.this.realSize()) / ((double) FloatOpenCustomHashSet.this.f1958n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
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
        /* JADX WARN: Type inference failed for: r0v19, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r0v24, types: [long] */
        /* JADX WARN: Type inference failed for: r0v26, types: [long] */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
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
                it.unimi.dsi.fastutil.floats.FloatOpenCustomHashSet r0 = p014it.unimi.dsi.fastutil.floats.FloatOpenCustomHashSet.this
                float[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0078
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0078
                r0 = r11
                r1 = r6
                r2 = r1
                int r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                int r3 = r3 + r4
                r2.pos = r3
                r0 = r0[r1]
                int r0 = java.lang.Float.floatToIntBits(r0)
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
            L_0x0078:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatOpenCustomHashSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatSpliterator spliterator() {
        return new SetSpliterator();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
    public void forEach(FloatConsumer action) {
        if (this.containsNull) {
            action.accept(this.key[this.f1958n]);
        }
        float[] key = this.key;
        int pos = this.f1958n;
        while (true) {
            pos--;
            if (pos == 0) {
                return;
            }
            if (Float.floatToIntBits(key[pos]) != 0) {
                action.accept(key[pos]);
            }
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1959f)));
        if (l >= this.f1958n || this.size > HashCommon.maxFill(l, this.f1959f)) {
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
        float[] key = this.key;
        int mask = newN - 1;
        float[] newKey = new float[newN + 1];
        int i2 = this.f1958n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (Float.floatToIntBits(key[i2]) == 0);
                int mix = HashCommon.mix(this.strategy.hashCode(key[i2])) & mask;
                int pos = mix;
                if (Float.floatToIntBits(newKey[mix]) != 0) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (Float.floatToIntBits(newKey[i]) != 0);
                }
                newKey[pos] = key[i2];
            } else {
                this.f1958n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1958n, this.f1959f);
                this.key = newKey;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public FloatOpenCustomHashSet clone() {
        try {
            FloatOpenCustomHashSet c = (FloatOpenCustomHashSet) clone();
            c.key = (float[]) this.key.clone();
            c.containsNull = this.containsNull;
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (Float.floatToIntBits(this.key[i]) == 0) {
                i++;
            }
            h += this.strategy.hashCode(this.key[i]);
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        FloatIterator i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeFloat(i.nextFloat());
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f1958n = HashCommon.arraySize(this.size, this.f1959f);
        this.maxFill = HashCommon.maxFill(this.f1958n, this.f1959f);
        this.mask = this.f1958n - 1;
        float[] key = new float[this.f1958n + 1];
        this.key = key;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 != 0) {
                float k = s.readFloat();
                if (this.strategy.equals(k, 0.0f)) {
                    pos = this.f1958n;
                    this.containsNull = true;
                } else {
                    int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
                    pos = mix;
                    if (Float.floatToIntBits(key[mix]) != 0) {
                        do {
                            i = (pos + 1) & this.mask;
                            pos = i;
                        } while (Float.floatToIntBits(key[i]) != 0);
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
