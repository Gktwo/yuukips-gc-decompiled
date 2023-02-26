package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntListIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap;
import p014it.unimi.dsi.fastutil.shorts.Short2IntMap;
import p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap.class */
public class Short2IntLinkedOpenHashMap extends AbstractShort2IntSortedMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient short[] key;
    protected transient int[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2918n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2919f;
    protected transient Short2IntSortedMap.FastSortedEntrySet entries;
    protected transient ShortSortedSet keys;
    protected transient IntCollection values;

    public Short2IntLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2919f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2918n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2918n - 1;
            this.maxFill = HashCommon.maxFill(this.f2918n, f);
            this.key = new short[this.f2918n + 1];
            this.value = new int[this.f2918n + 1];
            this.link = new long[this.f2918n + 1];
        }
    }

    public Short2IntLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Short2IntLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Short2IntLinkedOpenHashMap(Map<? extends Short, ? extends Integer> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2IntLinkedOpenHashMap(Map<? extends Short, ? extends Integer> m) {
        this(m, 0.75f);
    }

    public Short2IntLinkedOpenHashMap(Short2IntMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2IntLinkedOpenHashMap(Short2IntMap m) {
        this(m, 0.75f);
    }

    public Short2IntLinkedOpenHashMap(short[] k, int[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Short2IntLinkedOpenHashMap(short[] k, int[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2919f);
        if (needed > this.f2918n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2919f)))));
        if (needed > this.f2918n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public int removeEntry(int pos) {
        int oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2918n > this.minN && this.size < this.maxFill / 4 && this.f2918n > 16) {
            rehash(this.f2918n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public int removeNullEntry() {
        this.containsNullKey = false;
        int oldValue = this.value[this.f2918n];
        this.size--;
        fixPointers(this.f2918n);
        if (this.f2918n > this.minN && this.size < this.maxFill / 4 && this.f2918n > 16) {
            rehash(this.f2918n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, java.util.Map
    public void putAll(Map<? extends Short, ? extends Integer> m) {
        if (((double) this.f2919f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2918n : -(this.f2918n + 1);
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
        if (curr2 == 0) {
            return -(pos + 1);
        }
        if (k == curr2) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return -(pos + 1);
            }
        } while (k != curr);
        return pos;
    }

    private void insert(int pos, short k, int v) {
        if (pos == this.f2918n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i = this.last;
            jArr[i] = jArr[i] ^ ((this.link[this.last] ^ (((long) pos) & 4294967295L)) & 4294967295L);
            this.link[pos] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = pos;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2919f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
    public int put(short k, int v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        int oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private int addToValue(int pos, int incr) {
        int oldValue = this.value[pos];
        this.value[pos] = oldValue + incr;
        return oldValue;
    }

    public int addTo(short k, int incr) {
        int pos;
        short curr;
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            short curr2 = key[mix];
            if (curr2 != 0) {
                if (curr2 == k) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (curr != k);
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2918n, incr);
        } else {
            pos = this.f2918n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i2 = this.last;
            jArr[i2] = jArr[i2] ^ ((this.link[this.last] ^ (((long) pos) & 4294967295L)) & 4294967295L);
            this.link[pos] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = pos;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2919f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        short curr;
        short[] key = this.key;
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
                int slot = HashCommon.mix((int) curr) & this.mask;
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
            this.value[pos] = this.value[pos];
            fixPointers(pos, pos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
    public int remove(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
        if (curr2 == 0) {
            return this.defRetValue;
        }
        if (k == curr2) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return this.defRetValue;
            }
        } while (k != curr);
        return removeEntry(pos);
    }

    private int setValue(int pos, int v) {
        int oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public int removeFirstInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int pos = this.first;
        this.first = (int) this.link[pos];
        if (0 <= this.first) {
            long[] jArr = this.link;
            int i = this.first;
            jArr[i] = jArr[i] | -4294967296L;
        }
        this.size--;
        int v = this.value[pos];
        if (pos == this.f2918n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f2918n > this.minN && this.size < this.maxFill / 4 && this.f2918n > 16) {
            rehash(this.f2918n / 2);
        }
        return v;
    }

    public int removeLastInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int pos = this.last;
        this.last = (int) (this.link[pos] >>> 32);
        if (0 <= this.last) {
            long[] jArr = this.link;
            int i = this.last;
            jArr[i] = jArr[i] | 4294967295L;
        }
        this.size--;
        int v = this.value[pos];
        if (pos == this.f2918n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f2918n > this.minN && this.size < this.maxFill / 4 && this.f2918n > 16) {
            rehash(this.f2918n / 2);
        }
        return v;
    }

    private void moveIndexToFirst(int i) {
        if (this.size != 1 && this.first != i) {
            if (this.last == i) {
                this.last = (int) (this.link[i] >>> 32);
                long[] jArr = this.link;
                int i2 = this.last;
                jArr[i2] = jArr[i2] | 4294967295L;
            } else {
                long linki = this.link[i];
                int prev = (int) (linki >>> 32);
                int next = (int) linki;
                long[] jArr2 = this.link;
                jArr2[prev] = jArr2[prev] ^ ((this.link[prev] ^ (linki & 4294967295L)) & 4294967295L);
                long[] jArr3 = this.link;
                jArr3[next] = jArr3[next] ^ ((this.link[next] ^ (linki & -4294967296L)) & -4294967296L);
            }
            long[] jArr4 = this.link;
            int i3 = this.first;
            jArr4[i3] = jArr4[i3] ^ ((this.link[this.first] ^ ((((long) i) & 4294967295L) << 32)) & -4294967296L);
            this.link[i] = -4294967296L | (((long) this.first) & 4294967295L);
            this.first = i;
        }
    }

    private void moveIndexToLast(int i) {
        if (this.size != 1 && this.last != i) {
            if (this.first == i) {
                this.first = (int) this.link[i];
                long[] jArr = this.link;
                int i2 = this.first;
                jArr[i2] = jArr[i2] | -4294967296L;
            } else {
                long linki = this.link[i];
                int prev = (int) (linki >>> 32);
                int next = (int) linki;
                long[] jArr2 = this.link;
                jArr2[prev] = jArr2[prev] ^ ((this.link[prev] ^ (linki & 4294967295L)) & 4294967295L);
                long[] jArr3 = this.link;
                jArr3[next] = jArr3[next] ^ ((this.link[next] ^ (linki & -4294967296L)) & -4294967296L);
            }
            long[] jArr4 = this.link;
            int i3 = this.last;
            jArr4[i3] = jArr4[i3] ^ ((this.link[this.last] ^ (((long) i) & 4294967295L)) & 4294967295L);
            this.link[i] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = i;
        }
    }

    public int getAndMoveToFirst(short k) {
        short curr;
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return this.defRetValue;
            }
            if (k == curr2) {
                moveIndexToFirst(pos);
                return this.value[pos];
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return this.defRetValue;
                }
            } while (k != curr);
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToFirst(this.f2918n);
            return this.value[this.f2918n];
        }
    }

    public int getAndMoveToLast(short k) {
        short curr;
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return this.defRetValue;
            }
            if (k == curr2) {
                moveIndexToLast(pos);
                return this.value[pos];
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return this.defRetValue;
                }
            } while (k != curr);
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToLast(this.f2918n);
            return this.value[this.f2918n];
        }
    }

    public int putAndMoveToFirst(short k, int v) {
        int pos;
        short curr;
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            short curr2 = key[mix];
            if (curr2 != 0) {
                if (curr2 == k) {
                    moveIndexToFirst(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (curr != k);
                moveIndexToFirst(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToFirst(this.f2918n);
            return setValue(this.f2918n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2918n;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i2 = this.first;
            jArr[i2] = jArr[i2] ^ ((this.link[this.first] ^ ((((long) pos) & 4294967295L) << 32)) & -4294967296L);
            this.link[pos] = -4294967296L | (((long) this.first) & 4294967295L);
            this.first = pos;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size, this.f2919f));
        }
        return this.defRetValue;
    }

    public int putAndMoveToLast(short k, int v) {
        int pos;
        short curr;
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            short curr2 = key[mix];
            if (curr2 != 0) {
                if (curr2 == k) {
                    moveIndexToLast(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (curr != k);
                moveIndexToLast(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToLast(this.f2918n);
            return setValue(this.f2918n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2918n;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i2 = this.last;
            jArr[i2] = jArr[i2] ^ ((this.link[this.last] ^ (((long) pos) & 4294967295L)) & 4294967295L);
            this.link[pos] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = pos;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size, this.f2919f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
    public int get(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2918n] : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
        if (curr2 == 0) {
            return this.defRetValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return this.defRetValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public boolean containsKey(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public boolean containsValue(int v) {
        int[] value = this.value;
        short[] key = this.key;
        if (this.containsNullKey && value[this.f2918n] == v) {
            return true;
        }
        int i = this.f2918n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != 0 && value[i] == v) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
    public int getOrDefault(short k, int defaultValue) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2918n] : defaultValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
        if (curr2 == 0) {
            return defaultValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return defaultValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int putIfAbsent(short k, int v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public boolean remove(short k, int v) {
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            short curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (k == curr && v == this.value[pos]) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                short curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f2918n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public boolean replace(short k, int oldValue, int v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int replace(short k, int v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        int oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int computeIfAbsent(short k, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        int newValue = mappingFunction.applyAsInt(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int computeIfAbsent(short key, Short2IntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        int newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int computeIfAbsentNullable(short k, IntFunction<? extends Integer> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Integer newValue = (Integer) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        int v = newValue.intValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int computeIfPresent(short k, BiFunction<? super Short, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Integer newValue = (Integer) remappingFunction.apply(Short.valueOf(k), Integer.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        int[] iArr = this.value;
        int intValue = newValue.intValue();
        iArr[pos] = intValue;
        return intValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int compute(short k, BiFunction<? super Short, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Integer newValue = (Integer) remappingFunction.apply(Short.valueOf(k), pos >= 0 ? Integer.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == 0) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return this.defRetValue;
        }
        int newVal = newValue.intValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public int merge(short k, int v, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            if (pos < 0) {
                insert((-pos) - 1, k, v);
            } else {
                this.value[pos] = v;
            }
            return v;
        }
        Integer newValue = (Integer) remappingFunction.apply(Integer.valueOf(this.value[pos]), Integer.valueOf(v));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        int[] iArr = this.value;
        int intValue = newValue.intValue();
        iArr[pos] = intValue;
        return intValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, (short) 0);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Short2IntMap.Entry, Map.Entry<Short, Integer>, ShortIntPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry
        public short getShortKey() {
            return Short2IntLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
        public short leftShort() {
            return Short2IntLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry
        public int getIntValue() {
            return Short2IntLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
        public int rightInt() {
            return Short2IntLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry
        public int setValue(int v) {
            int oldValue = Short2IntLinkedOpenHashMap.this.value[this.index];
            Short2IntLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
        public ShortIntPair right(int v) {
            Short2IntLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getKey() {
            return Short.valueOf(Short2IntLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry, java.util.Map.Entry
        @Deprecated
        public Integer getValue() {
            return Integer.valueOf(Short2IntLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry
        @Deprecated
        public Integer setValue(Integer v) {
            return Integer.valueOf(setValue(v.intValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Short, Integer> e = (Map.Entry) o;
            return Short2IntLinkedOpenHashMap.this.key[this.index] == e.getKey().shortValue() && Short2IntLinkedOpenHashMap.this.value[this.index] == e.getValue().intValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Short2IntLinkedOpenHashMap.this.key[this.index] ^ Short2IntLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Short2IntLinkedOpenHashMap.this.key[this.index]) + "=>" + Short2IntLinkedOpenHashMap.this.value[this.index];
        }
    }

    protected void fixPointers(int i) {
        if (this.size == 0) {
            this.last = -1;
            this.first = -1;
        } else if (this.first == i) {
            this.first = (int) this.link[i];
            if (0 <= this.first) {
                long[] jArr = this.link;
                int i2 = this.first;
                jArr[i2] = jArr[i2] | -4294967296L;
            }
        } else if (this.last == i) {
            this.last = (int) (this.link[i] >>> 32);
            if (0 <= this.last) {
                long[] jArr2 = this.link;
                int i3 = this.last;
                jArr2[i3] = jArr2[i3] | 4294967295L;
            }
        } else {
            long linki = this.link[i];
            int prev = (int) (linki >>> 32);
            int next = (int) linki;
            long[] jArr3 = this.link;
            jArr3[prev] = jArr3[prev] ^ ((this.link[prev] ^ (linki & 4294967295L)) & 4294967295L);
            long[] jArr4 = this.link;
            jArr4[next] = jArr4[next] ^ ((this.link[next] ^ (linki & -4294967296L)) & -4294967296L);
        }
    }

    protected void fixPointers(int s, int d) {
        if (this.size == 1) {
            this.last = d;
            this.first = d;
            this.link[d] = -1;
        } else if (this.first == s) {
            this.first = d;
            long[] jArr = this.link;
            int i = (int) this.link[s];
            jArr[i] = jArr[i] ^ ((this.link[(int) this.link[s]] ^ ((((long) d) & 4294967295L) << 32)) & -4294967296L);
            this.link[d] = this.link[s];
        } else if (this.last == s) {
            this.last = d;
            long[] jArr2 = this.link;
            int i2 = (int) (this.link[s] >>> 32);
            jArr2[i2] = jArr2[i2] ^ ((this.link[(int) (this.link[s] >>> 32)] ^ (((long) d) & 4294967295L)) & 4294967295L);
            this.link[d] = this.link[s];
        } else {
            long links = this.link[s];
            int prev = (int) (links >>> 32);
            int next = (int) links;
            long[] jArr3 = this.link;
            jArr3[prev] = jArr3[prev] ^ ((this.link[prev] ^ (((long) d) & 4294967295L)) & 4294967295L);
            long[] jArr4 = this.link;
            jArr4[next] = jArr4[next] ^ ((this.link[next] ^ ((((long) d) & 4294967295L) << 32)) & -4294967296L);
            this.link[d] = links;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
    public short firstShortKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
    public short lastShortKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
    public Short2IntSortedMap tailMap(short from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
    public Short2IntSortedMap headMap(short to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
    public Short2IntSortedMap subMap(short from, short to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
    public Comparator<? super Short> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int prev;
        int next;
        int curr;
        int index;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        protected MapIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = Short2IntLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(short from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == 0) {
                if (Short2IntLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Short2IntLinkedOpenHashMap.this.link[Short2IntLinkedOpenHashMap.this.f2918n];
                    this.prev = Short2IntLinkedOpenHashMap.this.f2918n;
                    return;
                }
                throw new NoSuchElementException("The key " + ((int) from) + " does not belong to this map.");
            } else if (Short2IntLinkedOpenHashMap.this.key[Short2IntLinkedOpenHashMap.this.last] == from) {
                this.prev = Short2IntLinkedOpenHashMap.this.last;
                this.index = Short2IntLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix((int) from);
                int i = Short2IntLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Short2IntLinkedOpenHashMap.this.key[pos] == 0) {
                        throw new NoSuchElementException("The key " + ((int) from) + " does not belong to this map.");
                    } else if (Short2IntLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Short2IntLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Short2IntLinkedOpenHashMap.this.mask;
                    }
                }
            }
        }

        public boolean hasNext() {
            return this.next != -1;
        }

        public boolean hasPrevious() {
            return this.prev != -1;
        }

        private final void ensureIndexKnown() {
            if (this.index < 0) {
                if (this.prev == -1) {
                    this.index = 0;
                } else if (this.next == -1) {
                    this.index = Short2IntLinkedOpenHashMap.this.size;
                } else {
                    int pos = Short2IntLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Short2IntLinkedOpenHashMap.this.link[pos];
                        this.index++;
                    }
                }
            }
        }

        public int nextIndex() {
            ensureIndexKnown();
            return this.index;
        }

        public int previousIndex() {
            ensureIndexKnown();
            return this.index - 1;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int) Short2IntLinkedOpenHashMap.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                this.index++;
            }
            return this.curr;
        }

        public int previousEntry() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int) (Short2IntLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Short2IntLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0162, code lost:
            r0[r14] = r0;
            r11.this$0.value[r14] = r11.this$0.value[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x017f, code lost:
            if (r11.next != r14) goto L_0x0187;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0182, code lost:
            r11.next = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x018c, code lost:
            if (r11.prev != r14) goto L_0x0194;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x018f, code lost:
            r11.prev = r14;
         */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void remove() {
            /*
            // Method dump skipped, instructions count: 417
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap.MapIterator.remove():void");
        }

        public int skip(int n) {
            int i = n;
            while (true) {
                i--;
                if (i == 0 || !hasNext()) {
                    break;
                }
                nextEntry();
            }
            return (n - i) - 1;
        }

        public int back(int n) {
            int i = n;
            while (true) {
                i--;
                if (i == 0 || !hasPrevious()) {
                    break;
                }
                previousEntry();
            }
            return (n - i) - 1;
        }

        public void set(Short2IntMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Short2IntMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Short2IntMap.Entry>> implements ObjectListIterator<Short2IntMap.Entry> {
        private MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Short2IntMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Short2IntMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(short from) {
            super(from);
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Short2IntMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public MapEntry next() {
            MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public MapEntry previous() {
            MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends MapIterator<Consumer<? super Short2IntMap.Entry>> implements ObjectListIterator<Short2IntMap.Entry> {
        final MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Short2IntMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Short2IntMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(short from) {
            super(from);
            this.entry = new MapEntry();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Short2IntMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Short2IntMap.Entry> implements Short2IntSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Short2IntMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2IntMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Short2IntLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Short2IntMap.Entry> comparator() {
            return null;
        }

        public ObjectSortedSet<Short2IntMap.Entry> subSet(Short2IntMap.Entry fromElement, Short2IntMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Short2IntMap.Entry> headSet(Short2IntMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Short2IntMap.Entry> tailSet(Short2IntMap.Entry fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Short2IntMap.Entry first() {
            if (Short2IntLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Short2IntLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Short2IntMap.Entry last() {
            if (Short2IntLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Short2IntLinkedOpenHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            short curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Integer)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            int v = ((Integer) e.getValue()).intValue();
            if (k == 0) {
                return Short2IntLinkedOpenHashMap.this.containsNullKey && Short2IntLinkedOpenHashMap.this.value[Short2IntLinkedOpenHashMap.this.f2918n] == v;
            }
            short[] key = Short2IntLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Short2IntLinkedOpenHashMap.this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Short2IntLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Short2IntLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Short2IntLinkedOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Integer)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            int v = ((Integer) e.getValue()).intValue();
            if (k != 0) {
                short[] key = Short2IntLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Short2IntLinkedOpenHashMap.this.mask;
                int pos = mix;
                short curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Short2IntLinkedOpenHashMap.this.mask;
                        pos = i;
                        short curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Short2IntLinkedOpenHashMap.this.value[pos] == v) {
                            Short2IntLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Short2IntLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Short2IntLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Short2IntLinkedOpenHashMap.this.containsNullKey || Short2IntLinkedOpenHashMap.this.value[Short2IntLinkedOpenHashMap.this.f2918n] != v) {
                return false;
            } else {
                Short2IntLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2IntLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2IntLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Short2IntMap.Entry> iterator(Short2IntMap.Entry from) {
            return new EntryIterator(from.getShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.shorts.Short2IntMap.FastEntrySet
        public ObjectListIterator<Short2IntMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap.FastSortedEntrySet
        public ObjectListIterator<Short2IntMap.Entry> fastIterator(Short2IntMap.Entry from) {
            return new FastEntryIterator(from.getShortKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2IntMap.Entry> consumer) {
            int i = Short2IntLinkedOpenHashMap.this.size;
            int next = Short2IntLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Short2IntLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractShort2IntMap.BasicEntry(Short2IntLinkedOpenHashMap.this.key[next], Short2IntLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2IntMap.Entry> consumer) {
            AbstractShort2IntMap.BasicEntry entry = new AbstractShort2IntMap.BasicEntry();
            int i = Short2IntLinkedOpenHashMap.this.size;
            int next = Short2IntLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Short2IntLinkedOpenHashMap.this.link[next];
                    entry.key = Short2IntLinkedOpenHashMap.this.key[next];
                    entry.value = Short2IntLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
    public Short2IntSortedMap.FastSortedEntrySet short2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<ShortConsumer> implements ShortListIterator {
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ShortConsumer shortConsumer) {
            forEachRemaining((KeyIterator) shortConsumer);
        }

        public KeyIterator(short k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return Short2IntLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2IntLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Short2IntLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractShortSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortListIterator iterator(short from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortListIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(Short2IntLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer consumer) {
            int i = Short2IntLinkedOpenHashMap.this.size;
            int next = Short2IntLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Short2IntLinkedOpenHashMap.this.link[next];
                    consumer.accept(Short2IntLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2IntLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2IntLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldSize = Short2IntLinkedOpenHashMap.this.size;
            Short2IntLinkedOpenHashMap.this.remove(k);
            return Short2IntLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2IntLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            if (Short2IntLinkedOpenHashMap.this.size != 0) {
                return Short2IntLinkedOpenHashMap.this.key[Short2IntLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            if (Short2IntLinkedOpenHashMap.this.size != 0) {
                return Short2IntLinkedOpenHashMap.this.key[Short2IntLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntSortedMap, p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    public ShortSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<IntConsumer> implements IntListIterator {
        @Override // java.util.PrimitiveIterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            forEachRemaining((ValueIterator) intConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return Short2IntLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(IntConsumer action, int index) {
            action.accept(Short2IntLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return Short2IntLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntSortedMap, p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    public IntCollection values() {
        if (this.values == null) {
            this.values = new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.shorts.Short2IntLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
                public IntIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
                public IntSpliterator spliterator() {
                    return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(Short2IntLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
                public void forEach(IntConsumer consumer) {
                    int i = Short2IntLinkedOpenHashMap.this.size;
                    int next = Short2IntLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Short2IntLinkedOpenHashMap.this.link[next];
                            consumer.accept(Short2IntLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Short2IntLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
                public boolean contains(int v) {
                    return Short2IntLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Short2IntLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2919f)));
        if (l >= this.f2918n || this.size > HashCommon.maxFill(l, this.f2919f)) {
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
        int pos;
        short[] key = this.key;
        int[] value = this.value;
        int mask = newN - 1;
        short[] newKey = new short[newN + 1];
        int[] newValue = new int[newN + 1];
        int i = this.first;
        int prev = -1;
        int newPrev = -1;
        long[] link = this.link;
        long[] newLink = new long[newN + 1];
        this.first = -1;
        int j = this.size;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            if (key[i] != 0) {
                int mix = HashCommon.mix((int) key[i]);
                while (true) {
                    pos = mix & mask;
                    if (newKey[pos] == 0) {
                        break;
                    }
                    mix = pos + 1;
                }
            } else {
                pos = newN;
            }
            newKey[pos] = key[i];
            newValue[pos] = value[i];
            if (prev != -1) {
                newLink[newPrev] = newLink[newPrev] ^ ((newLink[newPrev] ^ (((long) pos) & 4294967295L)) & 4294967295L);
                newLink[pos] = newLink[pos] ^ ((newLink[pos] ^ ((((long) newPrev) & 4294967295L) << 32)) & -4294967296L);
                newPrev = pos;
            } else {
                this.first = pos;
                newPrev = pos;
                newLink[pos] = -1;
            }
            i = (int) link[i];
            prev = i;
        }
        this.link = newLink;
        this.last = newPrev;
        if (newPrev != -1) {
            newLink[newPrev] = newLink[newPrev] | 4294967295L;
        }
        this.f2918n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2918n, this.f2919f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Short2IntLinkedOpenHashMap clone() {
        try {
            Short2IntLinkedOpenHashMap c = (Short2IntLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (short[]) this.key.clone();
            c.value = (int[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap, java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            while (this.key[i] == 0) {
                i++;
            }
            h += this.key[i] ^ this.value[i];
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2918n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        short[] key = this.key;
        int[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeShort(key[e]);
                s.writeInt(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2918n = HashCommon.arraySize(this.size, this.f2919f);
        this.maxFill = HashCommon.maxFill(this.f2918n, this.f2919f);
        this.mask = this.f2918n - 1;
        short[] key = new short[this.f2918n + 1];
        this.key = key;
        int[] value = new int[this.f2918n + 1];
        this.value = value;
        long[] link = new long[this.f2918n + 1];
        this.link = link;
        int prev = -1;
        this.last = -1;
        this.first = -1;
        int i = this.size;
        while (true) {
            i--;
            if (i == 0) {
                break;
            }
            short k = s.readShort();
            int v = s.readInt();
            if (k != 0) {
                int mix = HashCommon.mix((int) k);
                int i2 = this.mask;
                while (true) {
                    pos = mix & i2;
                    if (key[pos] == 0) {
                        break;
                    }
                    mix = pos + 1;
                    i2 = this.mask;
                }
            } else {
                pos = this.f2918n;
                this.containsNullKey = true;
            }
            key[pos] = k;
            value[pos] = v;
            if (this.first != -1) {
                link[prev] = link[prev] ^ ((link[prev] ^ (((long) pos) & 4294967295L)) & 4294967295L);
                link[pos] = link[pos] ^ ((link[pos] ^ ((((long) prev) & 4294967295L) << 32)) & -4294967296L);
                prev = pos;
            } else {
                this.first = pos;
                prev = pos;
                link[pos] = link[pos] | -4294967296L;
            }
        }
        this.last = prev;
        if (prev != -1) {
            link[prev] = link[prev] | 4294967295L;
        }
    }

    private void checkTable() {
    }
}
