package p014it.unimi.dsi.fastutil.objects;

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
import java.util.function.ToIntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap;
import p014it.unimi.dsi.fastutil.objects.Object2ShortMap;
import p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortListIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap.class */
public class Object2ShortLinkedOpenCustomHashMap<K> extends AbstractObject2ShortSortedMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient short[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected Hash.Strategy<? super K> strategy;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2631n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2632f;
    protected transient Object2ShortSortedMap.FastSortedEntrySet<K> entries;
    protected transient ObjectSortedSet<K> keys;
    protected transient ShortCollection values;

    public Object2ShortLinkedOpenCustomHashMap(int expected, float f, Hash.Strategy<? super K> strategy) {
        this.first = -1;
        this.last = -1;
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2632f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2631n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2631n - 1;
            this.maxFill = HashCommon.maxFill(this.f2631n, f);
            this.key = (K[]) new Object[this.f2631n + 1];
            this.value = new short[this.f2631n + 1];
            this.link = new long[this.f2631n + 1];
        }
    }

    public Object2ShortLinkedOpenCustomHashMap(int expected, Hash.Strategy<? super K> strategy) {
        this(expected, 0.75f, strategy);
    }

    public Object2ShortLinkedOpenCustomHashMap(Hash.Strategy<? super K> strategy) {
        this(16, 0.75f, strategy);
    }

    public Object2ShortLinkedOpenCustomHashMap(Map<? extends K, ? extends Short> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2ShortLinkedOpenCustomHashMap(Map<? extends K, ? extends Short> m, Hash.Strategy<? super K> strategy) {
        this(m, 0.75f, strategy);
    }

    public Object2ShortLinkedOpenCustomHashMap(Object2ShortMap<K> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2ShortLinkedOpenCustomHashMap(Object2ShortMap<K> m, Hash.Strategy<? super K> strategy) {
        this((Object2ShortMap) m, 0.75f, (Hash.Strategy) strategy);
    }

    public Object2ShortLinkedOpenCustomHashMap(K[] k, short[] v, float f, Hash.Strategy<? super K> strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Object2ShortLinkedOpenCustomHashMap<K>) k[i], v[i]);
        }
    }

    public Object2ShortLinkedOpenCustomHashMap(K[] k, short[] v, Hash.Strategy<? super K> strategy) {
        this(k, v, 0.75f, strategy);
    }

    public Hash.Strategy<? super K> strategy() {
        return this.strategy;
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2632f);
        if (needed > this.f2631n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2632f)))));
        if (needed > this.f2631n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public short removeEntry(int pos) {
        short oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2631n > this.minN && this.size < this.maxFill / 4 && this.f2631n > 16) {
            rehash(this.f2631n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public short removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2631n] = null;
        short oldValue = this.value[this.f2631n];
        this.size--;
        fixPointers(this.f2631n);
        if (this.f2631n > this.minN && this.size < this.maxFill / 4 && this.f2631n > 16) {
            rehash(this.f2631n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Short> m) {
        if (((double) this.f2632f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.f2631n : -(this.f2631n + 1);
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return -(pos + 1);
        }
        if (this.strategy.equals(k, curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return -(pos + 1);
            }
        } while (!this.strategy.equals(k, curr));
        return pos;
    }

    private void insert(int pos, K k, short v) {
        if (pos == this.f2631n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2632f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
    public short put(K k, short v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private short addToValue(int pos, short incr) {
        short oldValue = this.value[pos];
        this.value[pos] = (short) (oldValue + incr);
        return oldValue;
    }

    public short addTo(K k, short incr) {
        int pos;
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2631n, incr);
        } else {
            pos = this.f2631n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (short) (this.defRetValue + incr);
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2632f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        K curr;
        K[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (curr == null) {
                    key[pos] = null;
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
            this.value[pos] = this.value[pos];
            fixPointers(pos, pos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
    public short removeShort(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return removeEntry(pos);
    }

    private short setValue(int pos, short v) {
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public short removeFirstShort() {
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
        short v = this.value[pos];
        if (pos == this.f2631n) {
            this.containsNullKey = false;
            this.key[this.f2631n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2631n > this.minN && this.size < this.maxFill / 4 && this.f2631n > 16) {
            rehash(this.f2631n / 2);
        }
        return v;
    }

    public short removeLastShort() {
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
        short v = this.value[pos];
        if (pos == this.f2631n) {
            this.containsNullKey = false;
            this.key[this.f2631n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2631n > this.minN && this.size < this.maxFill / 4 && this.f2631n > 16) {
            rehash(this.f2631n / 2);
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

    public short getAndMoveToFirst(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return this.defRetValue;
            }
            if (this.strategy.equals(k, curr2)) {
                moveIndexToFirst(pos);
                return this.value[pos];
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == null) {
                    return this.defRetValue;
                }
            } while (!this.strategy.equals(k, curr));
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToFirst(this.f2631n);
            return this.value[this.f2631n];
        }
    }

    public short getAndMoveToLast(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return this.defRetValue;
            }
            if (this.strategy.equals(k, curr2)) {
                moveIndexToLast(pos);
                return this.value[pos];
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == null) {
                    return this.defRetValue;
                }
            } while (!this.strategy.equals(k, curr));
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToLast(this.f2631n);
            return this.value[this.f2631n];
        }
    }

    public short putAndMoveToFirst(K k, short v) {
        int pos;
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    moveIndexToFirst(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                moveIndexToFirst(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToFirst(this.f2631n);
            return setValue(this.f2631n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2631n;
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
            rehash(HashCommon.arraySize(this.size, this.f2632f));
        }
        return this.defRetValue;
    }

    public short putAndMoveToLast(K k, short v) {
        int pos;
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    moveIndexToLast(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                moveIndexToLast(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToLast(this.f2631n);
            return setValue(this.f2631n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2631n;
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
            rehash(HashCommon.arraySize(this.size, this.f2632f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
    public short getShort(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2631n] : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public boolean containsValue(short v) {
        short[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2631n] == v) {
            return true;
        }
        int i = this.f2631n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != null && value[i] == v) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
    public short getOrDefault(Object k, short defaultValue) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2631n] : defaultValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return defaultValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return defaultValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public short putIfAbsent(K k, short v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public boolean remove(Object k, short v) {
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr = key[mix];
            if (curr == null) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    K curr2 = key[i];
                    if (curr2 == null) {
                        return false;
                    }
                    if (this.strategy.equals(k, curr2) && v == this.value[pos]) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || v != this.value[this.f2631n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public boolean replace(K k, short oldValue, short v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public short replace(K k, short v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public short computeIfAbsent(K k, ToIntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public short computeIfAbsent(K key, Object2ShortFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        short newValue = mappingFunction.getShort(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public short computeShortIfPresent(K k, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Short newValue = (Short) remappingFunction.apply(k, Short.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, null)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        short[] sArr = this.value;
        short shortValue = newValue.shortValue();
        sArr[pos] = shortValue;
        return shortValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public short computeShort(K k, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Short newValue = (Short) remappingFunction.apply(k, pos >= 0 ? Short.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (this.strategy.equals(k, null)) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return this.defRetValue;
        }
        short newVal = newValue.shortValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public short merge(K k, short v, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
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
        Short newValue = (Short) remappingFunction.apply(Short.valueOf(this.value[pos]), Short.valueOf(v));
        if (newValue == null) {
            if (this.strategy.equals(k, null)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        short[] sArr = this.value;
        short shortValue = newValue.shortValue();
        sArr[pos] = shortValue;
        return shortValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, (Object) null);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Object2ShortMap.Entry<K>, Map.Entry<K, Short>, ObjectShortPair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Object2ShortLinkedOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Object2ShortLinkedOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.Entry
        public short getShortValue() {
            return Object2ShortLinkedOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectShortPair
        public short rightShort() {
            return Object2ShortLinkedOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.Entry
        public short setValue(short v) {
            short oldValue = Object2ShortLinkedOpenCustomHashMap.this.value[this.index];
            Object2ShortLinkedOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectShortPair
        public ObjectShortPair<K> right(short v) {
            Object2ShortLinkedOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getValue() {
            return Short.valueOf(Object2ShortLinkedOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.Entry
        @Deprecated
        public Short setValue(Short v) {
            return Short.valueOf(setValue(v.shortValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Short> e = (Map.Entry) o;
            return Object2ShortLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2ShortLinkedOpenCustomHashMap.this.key[this.index], (Object) e.getKey()) && Object2ShortLinkedOpenCustomHashMap.this.value[this.index] == e.getValue().shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Object2ShortLinkedOpenCustomHashMap.this.strategy.hashCode((Object) Object2ShortLinkedOpenCustomHashMap.this.key[this.index]) ^ Object2ShortLinkedOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Object2ShortLinkedOpenCustomHashMap.this.key[this.index] + "=>" + ((int) Object2ShortLinkedOpenCustomHashMap.this.value[this.index]);
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

    @Override // java.util.SortedMap
    public K firstKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
    public Object2ShortSortedMap<K> tailMap(K from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
    public Object2ShortSortedMap<K> headMap(K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
    public Object2ShortSortedMap<K> subMap(K from, K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$MapIterator.class */
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
            this.next = Object2ShortLinkedOpenCustomHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (Object2ShortLinkedOpenCustomHashMap.this.strategy.equals(from, null)) {
                if (Object2ShortLinkedOpenCustomHashMap.this.containsNullKey) {
                    this.next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[Object2ShortLinkedOpenCustomHashMap.this.f2631n];
                    this.prev = Object2ShortLinkedOpenCustomHashMap.this.f2631n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Object2ShortLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2ShortLinkedOpenCustomHashMap.this.key[Object2ShortLinkedOpenCustomHashMap.this.last], from)) {
                this.prev = Object2ShortLinkedOpenCustomHashMap.this.last;
                this.index = Object2ShortLinkedOpenCustomHashMap.this.size;
            } else {
                int mix = HashCommon.mix(Object2ShortLinkedOpenCustomHashMap.this.strategy.hashCode(from));
                int i = Object2ShortLinkedOpenCustomHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Object2ShortLinkedOpenCustomHashMap.this.key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Object2ShortLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2ShortLinkedOpenCustomHashMap.this.key[pos], from)) {
                        this.next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Object2ShortLinkedOpenCustomHashMap.this.mask;
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
                    this.index = Object2ShortLinkedOpenCustomHashMap.this.size;
                } else {
                    int pos = Object2ShortLinkedOpenCustomHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Object2ShortLinkedOpenCustomHashMap.this.link[pos];
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
            this.next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[this.curr];
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
            this.prev = (int) (Object2ShortLinkedOpenCustomHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            K curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (Object2ShortLinkedOpenCustomHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[this.curr];
            }
            Object2ShortLinkedOpenCustomHashMap.this.size--;
            if (this.prev == -1) {
                Object2ShortLinkedOpenCustomHashMap.this.first = this.next;
            } else {
                long[] jArr = Object2ShortLinkedOpenCustomHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Object2ShortLinkedOpenCustomHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Object2ShortLinkedOpenCustomHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Object2ShortLinkedOpenCustomHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Object2ShortLinkedOpenCustomHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Object2ShortLinkedOpenCustomHashMap.this.f2631n) {
                Object2ShortLinkedOpenCustomHashMap.this.containsNullKey = false;
                Object2ShortLinkedOpenCustomHashMap.this.key[Object2ShortLinkedOpenCustomHashMap.this.f2631n] = null;
                return;
            }
            K[] key = Object2ShortLinkedOpenCustomHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Object2ShortLinkedOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(Object2ShortLinkedOpenCustomHashMap.this.strategy.hashCode(curr)) & Object2ShortLinkedOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Object2ShortLinkedOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Object2ShortLinkedOpenCustomHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Object2ShortLinkedOpenCustomHashMap.this.value[pos] = Object2ShortLinkedOpenCustomHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Object2ShortLinkedOpenCustomHashMap.this.fixPointers(pos, pos);
            }
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

        public void set(Object2ShortMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Object2ShortMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends Object2ShortLinkedOpenCustomHashMap<K>.MapIterator implements ObjectListIterator<Object2ShortMap.Entry<K>> {
        private Object2ShortLinkedOpenCustomHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2ShortMap.Entry) ((Object2ShortMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2ShortMap.Entry) ((Object2ShortMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(K from) {
            super(from);
        }

        final void acceptOnIndex(Consumer<? super Object2ShortMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2ShortLinkedOpenCustomHashMap<K>.MapEntry next() {
            Object2ShortLinkedOpenCustomHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2ShortLinkedOpenCustomHashMap<K>.MapEntry previous() {
            Object2ShortLinkedOpenCustomHashMap<K>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Object2ShortLinkedOpenCustomHashMap<K>.MapIterator implements ObjectListIterator<Object2ShortMap.Entry<K>> {
        final Object2ShortLinkedOpenCustomHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2ShortMap.Entry) ((Object2ShortMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2ShortMap.Entry) ((Object2ShortMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(K from) {
            super(from);
            this.entry = new MapEntry();
        }

        final void acceptOnIndex(Consumer<? super Object2ShortMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2ShortLinkedOpenCustomHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2ShortLinkedOpenCustomHashMap<K>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Object2ShortMap.Entry<K>> implements Object2ShortSortedMap.FastSortedEntrySet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Object2ShortMap.Entry) ((Object2ShortMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Object2ShortMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2ShortMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ShortLinkedOpenCustomHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Object2ShortMap.Entry<K>> comparator() {
            return null;
        }

        public ObjectSortedSet<Object2ShortMap.Entry<K>> subSet(Object2ShortMap.Entry<K> fromElement, Object2ShortMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2ShortMap.Entry<K>> headSet(Object2ShortMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2ShortMap.Entry<K>> tailSet(Object2ShortMap.Entry<K> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Object2ShortMap.Entry<K> first() {
            if (Object2ShortLinkedOpenCustomHashMap.this.size != 0) {
                return new MapEntry(Object2ShortLinkedOpenCustomHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Object2ShortMap.Entry<K> last() {
            if (Object2ShortLinkedOpenCustomHashMap.this.size != 0) {
                return new MapEntry(Object2ShortLinkedOpenCustomHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            K curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            Object key = e.getKey();
            short v = ((Short) e.getValue()).shortValue();
            if (Object2ShortLinkedOpenCustomHashMap.this.strategy.equals(key, null)) {
                return Object2ShortLinkedOpenCustomHashMap.this.containsNullKey && Object2ShortLinkedOpenCustomHashMap.this.value[Object2ShortLinkedOpenCustomHashMap.this.f2631n] == v;
            }
            K[] key2 = Object2ShortLinkedOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Object2ShortLinkedOpenCustomHashMap.this.strategy.hashCode(key)) & Object2ShortLinkedOpenCustomHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (Object2ShortLinkedOpenCustomHashMap.this.strategy.equals(key, curr2)) {
                return Object2ShortLinkedOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Object2ShortLinkedOpenCustomHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!Object2ShortLinkedOpenCustomHashMap.this.strategy.equals(key, curr));
            return Object2ShortLinkedOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            Object key = e.getKey();
            short v = ((Short) e.getValue()).shortValue();
            if (!Object2ShortLinkedOpenCustomHashMap.this.strategy.equals(key, null)) {
                K[] key2 = Object2ShortLinkedOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Object2ShortLinkedOpenCustomHashMap.this.strategy.hashCode(key)) & Object2ShortLinkedOpenCustomHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!Object2ShortLinkedOpenCustomHashMap.this.strategy.equals(curr, key)) {
                    while (true) {
                        int i = (pos + 1) & Object2ShortLinkedOpenCustomHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (Object2ShortLinkedOpenCustomHashMap.this.strategy.equals(curr2, key) && Object2ShortLinkedOpenCustomHashMap.this.value[pos] == v) {
                            Object2ShortLinkedOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Object2ShortLinkedOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Object2ShortLinkedOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Object2ShortLinkedOpenCustomHashMap.this.containsNullKey || Object2ShortLinkedOpenCustomHashMap.this.value[Object2ShortLinkedOpenCustomHashMap.this.f2631n] != v) {
                return false;
            } else {
                Object2ShortLinkedOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ShortLinkedOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ShortLinkedOpenCustomHashMap.this.clear();
        }

        public ObjectListIterator<Object2ShortMap.Entry<K>> iterator(Object2ShortMap.Entry<K> from) {
            return new EntryIterator(from.getKey());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.objects.Object2ShortMap.FastEntrySet
        public ObjectListIterator<Object2ShortMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap.FastSortedEntrySet
        public ObjectListIterator<Object2ShortMap.Entry<K>> fastIterator(Object2ShortMap.Entry<K> from) {
            return new FastEntryIterator(from.getKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2ShortMap.Entry<K>> consumer) {
            int i = Object2ShortLinkedOpenCustomHashMap.this.size;
            int next = Object2ShortLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[next];
                    consumer.accept(new AbstractObject2ShortMap.BasicEntry(Object2ShortLinkedOpenCustomHashMap.this.key[next], Object2ShortLinkedOpenCustomHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2ShortMap.Entry<K>> consumer) {
            AbstractObject2ShortMap.BasicEntry<K> entry = new AbstractObject2ShortMap.BasicEntry<>();
            int i = Object2ShortLinkedOpenCustomHashMap.this.size;
            int next = Object2ShortLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[next];
                    entry.key = Object2ShortLinkedOpenCustomHashMap.this.key[next];
                    entry.value = Object2ShortLinkedOpenCustomHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
    public Object2ShortSortedMap.FastSortedEntrySet<K> object2ShortEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends Object2ShortLinkedOpenCustomHashMap<K>.MapIterator implements ObjectListIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((KeyIterator) consumer);
        }

        public KeyIterator(K k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return Object2ShortLinkedOpenCustomHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Object2ShortLinkedOpenCustomHashMap.this.key[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return Object2ShortLinkedOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$KeySet.class */
    public final class KeySet extends AbstractObjectSortedSet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectListIterator<K> iterator(K from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectListIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ShortLinkedOpenCustomHashMap.this), 81);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            int i = Object2ShortLinkedOpenCustomHashMap.this.size;
            int next = Object2ShortLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[next];
                    consumer.accept((Object) Object2ShortLinkedOpenCustomHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ShortLinkedOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2ShortLinkedOpenCustomHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Object2ShortLinkedOpenCustomHashMap.this.size;
            Object2ShortLinkedOpenCustomHashMap.this.removeShort(k);
            return Object2ShortLinkedOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ShortLinkedOpenCustomHashMap.this.clear();
        }

        @Override // java.util.SortedSet
        public K first() {
            if (Object2ShortLinkedOpenCustomHashMap.this.size != 0) {
                return Object2ShortLinkedOpenCustomHashMap.this.key[Object2ShortLinkedOpenCustomHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            if (Object2ShortLinkedOpenCustomHashMap.this.size != 0) {
                return Object2ShortLinkedOpenCustomHashMap.this.key[Object2ShortLinkedOpenCustomHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortLinkedOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends Object2ShortLinkedOpenCustomHashMap<K>.MapIterator implements ShortListIterator {
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ShortConsumer shortConsumer) {
            forEachRemaining((ValueIterator) shortConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return Object2ShortLinkedOpenCustomHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Object2ShortLinkedOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Object2ShortLinkedOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
    public ShortCollection values() {
        if (this.values == null) {
            this.values = new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2ShortLinkedOpenCustomHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public ShortIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public ShortSpliterator spliterator() {
                    return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ShortLinkedOpenCustomHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public void forEach(ShortConsumer consumer) {
                    int i = Object2ShortLinkedOpenCustomHashMap.this.size;
                    int next = Object2ShortLinkedOpenCustomHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Object2ShortLinkedOpenCustomHashMap.this.link[next];
                            consumer.accept(Object2ShortLinkedOpenCustomHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2ShortLinkedOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
                public boolean contains(short v) {
                    return Object2ShortLinkedOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2ShortLinkedOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2632f)));
        if (l >= this.f2631n || this.size > HashCommon.maxFill(l, this.f2632f)) {
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
        K[] key = this.key;
        short[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        short[] newValue = new short[newN + 1];
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
            if (!this.strategy.equals(key[i], null)) {
                int mix = HashCommon.mix(this.strategy.hashCode(key[i]));
                while (true) {
                    pos = mix & mask;
                    if (newKey[pos] == null) {
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
        this.f2631n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2631n, this.f2632f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Object2ShortLinkedOpenCustomHashMap<K> clone() {
        try {
            Object2ShortLinkedOpenCustomHashMap<K> c = (Object2ShortLinkedOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (short[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap, java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        int t = 0;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            while (this.key[i] == null) {
                i++;
            }
            if (this != this.key[i]) {
                t = this.strategy.hashCode((Object) this.key[i]);
            }
            t ^= this.value[i];
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2631n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        short[] value = this.value;
        Object2ShortLinkedOpenCustomHashMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeObject(key[e]);
                s.writeShort(value[e]);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: K[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v42, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2631n = HashCommon.arraySize(this.size, this.f2632f);
        this.maxFill = HashCommon.maxFill(this.f2631n, this.f2632f);
        this.mask = this.f2631n - 1;
        K[] key = (K[]) new Object[this.f2631n + 1];
        this.key = key;
        short[] value = new short[this.f2631n + 1];
        this.value = value;
        long[] link = new long[this.f2631n + 1];
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
            Object readObject = s.readObject();
            short v = s.readShort();
            if (!this.strategy.equals(readObject, null)) {
                int mix = HashCommon.mix(this.strategy.hashCode(readObject));
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
                pos = this.f2631n;
                this.containsNullKey = true;
            }
            key[pos] = readObject;
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
