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
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap.class */
public class Object2ObjectLinkedOpenCustomHashMap<K, V> extends AbstractObject2ObjectSortedMap<K, V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected Hash.Strategy<? super K> strategy;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2603n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2604f;
    protected transient Object2ObjectSortedMap.FastSortedEntrySet<K, V> entries;
    protected transient ObjectSortedSet<K> keys;
    protected transient ObjectCollection<V> values;

    public Object2ObjectLinkedOpenCustomHashMap(int expected, float f, Hash.Strategy<? super K> strategy) {
        this.first = -1;
        this.last = -1;
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2604f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2603n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2603n - 1;
            this.maxFill = HashCommon.maxFill(this.f2603n, f);
            this.key = (K[]) new Object[this.f2603n + 1];
            this.value = (V[]) new Object[this.f2603n + 1];
            this.link = new long[this.f2603n + 1];
        }
    }

    public Object2ObjectLinkedOpenCustomHashMap(int expected, Hash.Strategy<? super K> strategy) {
        this(expected, 0.75f, strategy);
    }

    public Object2ObjectLinkedOpenCustomHashMap(Hash.Strategy<? super K> strategy) {
        this(16, 0.75f, strategy);
    }

    public Object2ObjectLinkedOpenCustomHashMap(Map<? extends K, ? extends V> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2ObjectLinkedOpenCustomHashMap(Map<? extends K, ? extends V> m, Hash.Strategy<? super K> strategy) {
        this(m, 0.75f, strategy);
    }

    public Object2ObjectLinkedOpenCustomHashMap(Object2ObjectMap<K, V> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2ObjectLinkedOpenCustomHashMap(Object2ObjectMap<K, V> m, Hash.Strategy<? super K> strategy) {
        this((Object2ObjectMap) m, 0.75f, (Hash.Strategy) strategy);
    }

    public Object2ObjectLinkedOpenCustomHashMap(K[] k, V[] v, float f, Hash.Strategy<? super K> strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Object2ObjectLinkedOpenCustomHashMap(K[] k, V[] v, Hash.Strategy<? super K> strategy) {
        this(k, v, 0.75f, strategy);
    }

    public Hash.Strategy<? super K> strategy() {
        return this.strategy;
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2604f);
        if (needed > this.f2603n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2604f)))));
        if (needed > this.f2603n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public V removeEntry(int pos) {
        V oldValue = this.value[pos];
        this.value[pos] = null;
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2603n > this.minN && this.size < this.maxFill / 4 && this.f2603n > 16) {
            rehash(this.f2603n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2603n] = null;
        V oldValue = this.value[this.f2603n];
        this.value[this.f2603n] = null;
        this.size--;
        fixPointers(this.f2603n);
        if (this.f2603n > this.minN && this.size < this.maxFill / 4 && this.f2603n > 16) {
            rehash(this.f2603n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        if (((double) this.f2604f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.f2603n : -(this.f2603n + 1);
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

    private void insert(int pos, K k, V v) {
        if (pos == this.f2603n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2604f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    public V put(K k, V v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
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
                    this.value[pos] = null;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    public V remove(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return (V) this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return (V) this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return removeEntry(pos);
    }

    private V setValue(int pos, V v) {
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public V removeFirst() {
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
        V v = this.value[pos];
        if (pos == this.f2603n) {
            this.containsNullKey = false;
            this.key[this.f2603n] = null;
            this.value[this.f2603n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2603n > this.minN && this.size < this.maxFill / 4 && this.f2603n > 16) {
            rehash(this.f2603n / 2);
        }
        return v;
    }

    public V removeLast() {
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
        V v = this.value[pos];
        if (pos == this.f2603n) {
            this.containsNullKey = false;
            this.key[this.f2603n] = null;
            this.value[this.f2603n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2603n > this.minN && this.size < this.maxFill / 4 && this.f2603n > 16) {
            rehash(this.f2603n / 2);
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

    public V getAndMoveToFirst(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return (V) this.defRetValue;
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
                    return (V) this.defRetValue;
                }
            } while (!this.strategy.equals(k, curr));
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToFirst(this.f2603n);
            return this.value[this.f2603n];
        }
    }

    public V getAndMoveToLast(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return (V) this.defRetValue;
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
                    return (V) this.defRetValue;
                }
            } while (!this.strategy.equals(k, curr));
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToLast(this.f2603n);
            return this.value[this.f2603n];
        }
    }

    public V putAndMoveToFirst(K k, V v) {
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
            moveIndexToFirst(this.f2603n);
            return setValue(this.f2603n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2603n;
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
            rehash(HashCommon.arraySize(this.size, this.f2604f));
        }
        return (V) this.defRetValue;
    }

    public V putAndMoveToLast(K k, V v) {
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
            moveIndexToLast(this.f2603n);
            return setValue(this.f2603n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2603n;
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
            rehash(HashCommon.arraySize(this.size, this.f2604f));
        }
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    public V get(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2603n] : (V) this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return (V) this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return (V) this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap, p014it.unimi.dsi.fastutil.Function
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && Objects.equals(value[this.f2603n], v)) {
            return true;
        }
        int i = this.f2603n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != null && Objects.equals(value[i], v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    public V getOrDefault(Object k, V defaultValue) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2603n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public boolean remove(Object k, Object v) {
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr = key[mix];
            if (curr == null) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || !Objects.equals(v, this.value[pos])) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    K curr2 = key[i];
                    if (curr2 == null) {
                        return false;
                    }
                    if (this.strategy.equals(k, curr2) && Objects.equals(v, this.value[pos])) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || !Objects.equals(v, this.value[this.f2603n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public boolean replace(K k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || !Objects.equals(oldValue, this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public V replace(K k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap
    public V computeIfAbsent(K key, Object2ObjectFunction<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return (V) this.defRetValue;
        }
        V newValue = (V) mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(k, (Object) this.value[pos]);
            if (newValue == null) {
                if (this.strategy.equals(k, null)) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
                return (V) this.defRetValue;
            }
            this.value[pos] = newValue;
            return newValue;
        }
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public V compute(K k, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(k, pos >= 0 ? (Object) this.value[pos] : (Object) null);
        if (newValue == null) {
            if (pos >= 0) {
                if (this.strategy.equals(k, null)) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return (V) this.defRetValue;
        } else if (pos < 0) {
            insert((-pos) - 1, k, newValue);
            return newValue;
        } else {
            this.value[pos] = newValue;
            return newValue;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(v);
        int pos = find(k);
        if (pos < 0 || this.value[pos] == null) {
            if (pos < 0) {
                insert((-pos) - 1, k, v);
            } else {
                this.value[pos] = v;
            }
            return v;
        }
        V newValue = (V) remappingFunction.apply((Object) this.value[pos], v);
        if (newValue == null) {
            if (this.strategy.equals(k, null)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return (V) this.defRetValue;
        }
        this.value[pos] = newValue;
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, (Object) null);
            Arrays.fill(this.value, (Object) null);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Object2ObjectMap.Entry<K, V>, Map.Entry<K, V>, Pair<K, V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Object2ObjectLinkedOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Object2ObjectLinkedOpenCustomHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Object2ObjectLinkedOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Object2ObjectLinkedOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Object2ObjectLinkedOpenCustomHashMap.this.value[this.index];
            Object2ObjectLinkedOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public Pair<K, V> right(V v) {
            Object2ObjectLinkedOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> e = (Map.Entry) o;
            return Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2ObjectLinkedOpenCustomHashMap.this.key[this.index], (Object) e.getKey()) && Objects.equals(Object2ObjectLinkedOpenCustomHashMap.this.value[this.index], e.getValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Object2ObjectLinkedOpenCustomHashMap.this.strategy.hashCode((Object) Object2ObjectLinkedOpenCustomHashMap.this.key[this.index]) ^ (Object2ObjectLinkedOpenCustomHashMap.this.value[this.index] == null ? 0 : Object2ObjectLinkedOpenCustomHashMap.this.value[this.index].hashCode());
        }

        @Override // java.lang.Object
        public String toString() {
            return Object2ObjectLinkedOpenCustomHashMap.this.key[this.index] + "=>" + Object2ObjectLinkedOpenCustomHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap, java.util.SortedMap
    public Object2ObjectSortedMap<K, V> tailMap(K from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap, java.util.SortedMap
    public Object2ObjectSortedMap<K, V> headMap(K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap, java.util.SortedMap
    public Object2ObjectSortedMap<K, V> subMap(K from, K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$MapIterator.class */
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
            this.next = Object2ObjectLinkedOpenCustomHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals(from, null)) {
                if (Object2ObjectLinkedOpenCustomHashMap.this.containsNullKey) {
                    this.next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[Object2ObjectLinkedOpenCustomHashMap.this.f2603n];
                    this.prev = Object2ObjectLinkedOpenCustomHashMap.this.f2603n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2ObjectLinkedOpenCustomHashMap.this.key[Object2ObjectLinkedOpenCustomHashMap.this.last], from)) {
                this.prev = Object2ObjectLinkedOpenCustomHashMap.this.last;
                this.index = Object2ObjectLinkedOpenCustomHashMap.this.size;
            } else {
                int mix = HashCommon.mix(Object2ObjectLinkedOpenCustomHashMap.this.strategy.hashCode(from));
                int i = Object2ObjectLinkedOpenCustomHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Object2ObjectLinkedOpenCustomHashMap.this.key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2ObjectLinkedOpenCustomHashMap.this.key[pos], from)) {
                        this.next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Object2ObjectLinkedOpenCustomHashMap.this.mask;
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
                    this.index = Object2ObjectLinkedOpenCustomHashMap.this.size;
                } else {
                    int pos = Object2ObjectLinkedOpenCustomHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[pos];
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
            this.next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[this.curr];
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
            this.prev = (int) (Object2ObjectLinkedOpenCustomHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0198, code lost:
            r0[r14] = r0;
            r11.this$0.value[r14] = r11.this$0.value[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x01b5, code lost:
            if (r11.next != r14) goto L_0x01bd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01b8, code lost:
            r11.next = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01c2, code lost:
            if (r11.prev != r14) goto L_0x01ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x01c5, code lost:
            r11.prev = r14;
         */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void remove() {
            /*
            // Method dump skipped, instructions count: 471
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap.MapIterator.remove():void");
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

        public void set(Object2ObjectMap.Entry<K, V> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Object2ObjectMap.Entry<K, V> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends Object2ObjectLinkedOpenCustomHashMap<K, V>.MapIterator implements ObjectListIterator<Object2ObjectMap.Entry<K, V>> {
        private Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2ObjectMap.Entry) ((Object2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2ObjectMap.Entry) ((Object2ObjectMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Object2ObjectMap.Entry<K, V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry next() {
            Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry previous() {
            Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Object2ObjectLinkedOpenCustomHashMap<K, V>.MapIterator implements ObjectListIterator<Object2ObjectMap.Entry<K, V>> {
        final Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2ObjectMap.Entry) ((Object2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2ObjectMap.Entry) ((Object2ObjectMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Object2ObjectMap.Entry<K, V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2ObjectLinkedOpenCustomHashMap<K, V>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Object2ObjectMap.Entry<K, V>> implements Object2ObjectSortedMap.FastSortedEntrySet<K, V> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Object2ObjectMap.Entry) ((Object2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2ObjectMap.Entry<K, V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ObjectLinkedOpenCustomHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Object2ObjectMap.Entry<K, V>> comparator() {
            return null;
        }

        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> subSet(Object2ObjectMap.Entry<K, V> fromElement, Object2ObjectMap.Entry<K, V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> headSet(Object2ObjectMap.Entry<K, V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> tailSet(Object2ObjectMap.Entry<K, V> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Object2ObjectMap.Entry<K, V> first() {
            if (Object2ObjectLinkedOpenCustomHashMap.this.size != 0) {
                return new MapEntry(Object2ObjectLinkedOpenCustomHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Object2ObjectMap.Entry<K, V> last() {
            if (Object2ObjectLinkedOpenCustomHashMap.this.size != 0) {
                return new MapEntry(Object2ObjectLinkedOpenCustomHashMap.this.last);
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
            Object key = e.getKey();
            Object value = e.getValue();
            if (Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals(key, null)) {
                return Object2ObjectLinkedOpenCustomHashMap.this.containsNullKey && Objects.equals(Object2ObjectLinkedOpenCustomHashMap.this.value[Object2ObjectLinkedOpenCustomHashMap.this.f2603n], value);
            }
            K[] key2 = Object2ObjectLinkedOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Object2ObjectLinkedOpenCustomHashMap.this.strategy.hashCode(key)) & Object2ObjectLinkedOpenCustomHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals(key, curr2)) {
                return Objects.equals(Object2ObjectLinkedOpenCustomHashMap.this.value[pos], value);
            }
            do {
                int i = (pos + 1) & Object2ObjectLinkedOpenCustomHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals(key, curr));
            return Objects.equals(Object2ObjectLinkedOpenCustomHashMap.this.value[pos], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            Object key = e.getKey();
            Object value = e.getValue();
            if (!Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals(key, null)) {
                K[] key2 = Object2ObjectLinkedOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Object2ObjectLinkedOpenCustomHashMap.this.strategy.hashCode(key)) & Object2ObjectLinkedOpenCustomHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals(curr, key)) {
                    while (true) {
                        int i = (pos + 1) & Object2ObjectLinkedOpenCustomHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (Object2ObjectLinkedOpenCustomHashMap.this.strategy.equals(curr2, key) && Objects.equals(Object2ObjectLinkedOpenCustomHashMap.this.value[pos], value)) {
                            Object2ObjectLinkedOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (!Objects.equals(Object2ObjectLinkedOpenCustomHashMap.this.value[pos], value)) {
                    return false;
                } else {
                    Object2ObjectLinkedOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Object2ObjectLinkedOpenCustomHashMap.this.containsNullKey || !Objects.equals(Object2ObjectLinkedOpenCustomHashMap.this.value[Object2ObjectLinkedOpenCustomHashMap.this.f2603n], value)) {
                return false;
            } else {
                Object2ObjectLinkedOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ObjectLinkedOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ObjectLinkedOpenCustomHashMap.this.clear();
        }

        public ObjectListIterator<Object2ObjectMap.Entry<K, V>> iterator(Object2ObjectMap.Entry<K, V> from) {
            return new EntryIterator(from.getKey());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.objects.Object2ObjectMap.FastEntrySet
        public ObjectListIterator<Object2ObjectMap.Entry<K, V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap.FastSortedEntrySet
        public ObjectListIterator<Object2ObjectMap.Entry<K, V>> fastIterator(Object2ObjectMap.Entry<K, V> from) {
            return new FastEntryIterator(from.getKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2ObjectMap.Entry<K, V>> consumer) {
            int i = Object2ObjectLinkedOpenCustomHashMap.this.size;
            int next = Object2ObjectLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[next];
                    consumer.accept(new AbstractObject2ObjectMap.BasicEntry(Object2ObjectLinkedOpenCustomHashMap.this.key[next], Object2ObjectLinkedOpenCustomHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2ObjectMap.Entry<K, V>> consumer) {
            AbstractObject2ObjectMap.BasicEntry<K, V> entry = new AbstractObject2ObjectMap.BasicEntry<>();
            int i = Object2ObjectLinkedOpenCustomHashMap.this.size;
            int next = Object2ObjectLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[next];
                    entry.key = Object2ObjectLinkedOpenCustomHashMap.this.key[next];
                    entry.value = Object2ObjectLinkedOpenCustomHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, p014it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap
    public Object2ObjectSortedMap.FastSortedEntrySet<K, V> object2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends Object2ObjectLinkedOpenCustomHashMap<K, V>.MapIterator implements ObjectListIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap.MapIterator
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
            return Object2ObjectLinkedOpenCustomHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Object2ObjectLinkedOpenCustomHashMap.this.key[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return Object2ObjectLinkedOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$KeySet.class */
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
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ObjectLinkedOpenCustomHashMap.this), 81);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            int i = Object2ObjectLinkedOpenCustomHashMap.this.size;
            int next = Object2ObjectLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[next];
                    consumer.accept((Object) Object2ObjectLinkedOpenCustomHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ObjectLinkedOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2ObjectLinkedOpenCustomHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Object2ObjectLinkedOpenCustomHashMap.this.size;
            Object2ObjectLinkedOpenCustomHashMap.this.remove(k);
            return Object2ObjectLinkedOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ObjectLinkedOpenCustomHashMap.this.clear();
        }

        @Override // java.util.SortedSet
        public K first() {
            if (Object2ObjectLinkedOpenCustomHashMap.this.size != 0) {
                return Object2ObjectLinkedOpenCustomHashMap.this.key[Object2ObjectLinkedOpenCustomHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            if (Object2ObjectLinkedOpenCustomHashMap.this.size != 0) {
                return Object2ObjectLinkedOpenCustomHashMap.this.key[Object2ObjectLinkedOpenCustomHashMap.this.last];
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap, p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends Object2ObjectLinkedOpenCustomHashMap<K, V>.MapIterator implements ObjectListIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((ValueIterator) consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public V previous() {
            return Object2ObjectLinkedOpenCustomHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super V> action, int index) {
            action.accept((Object) Object2ObjectLinkedOpenCustomHashMap.this.value[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public V next() {
            return Object2ObjectLinkedOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap, p014it.unimi.dsi.fastutil.objects.Object2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 80;

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ObjectLinkedOpenCustomHashMap.this), 80);
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    int i = Object2ObjectLinkedOpenCustomHashMap.this.size;
                    int next = Object2ObjectLinkedOpenCustomHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Object2ObjectLinkedOpenCustomHashMap.this.link[next];
                            consumer.accept((Object) Object2ObjectLinkedOpenCustomHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2ObjectLinkedOpenCustomHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Object2ObjectLinkedOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2ObjectLinkedOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2604f)));
        if (l >= this.f2603n || this.size > HashCommon.maxFill(l, this.f2604f)) {
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
        V[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        V[] newValue = (V[]) new Object[newN + 1];
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
        this.f2603n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2603n, this.f2604f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Object2ObjectLinkedOpenCustomHashMap<K, V> clone() {
        try {
            Object2ObjectLinkedOpenCustomHashMap<K, V> c = (Object2ObjectLinkedOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (V[]) ((Object[]) this.value.clone());
            c.link = (long[]) this.link.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ObjectMap, java.lang.Object, java.util.Map
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
            if (this != this.value[i]) {
                t ^= this.value[i] == null ? 0 : this.value[i].hashCode();
            }
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2603n] == null ? 0 : this.value[this.f2603n].hashCode();
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        V[] value = this.value;
        Object2ObjectLinkedOpenCustomHashMap<K, V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeObject(key[e]);
                s.writeObject(value[e]);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: K[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: V[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v42, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2603n = HashCommon.arraySize(this.size, this.f2604f);
        this.maxFill = HashCommon.maxFill(this.f2603n, this.f2604f);
        this.mask = this.f2603n - 1;
        K[] key = (K[]) new Object[this.f2603n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f2603n + 1];
        this.value = value;
        long[] link = new long[this.f2603n + 1];
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
            Object readObject2 = s.readObject();
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
                pos = this.f2603n;
                this.containsNullKey = true;
            }
            key[pos] = readObject;
            value[pos] = readObject2;
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
