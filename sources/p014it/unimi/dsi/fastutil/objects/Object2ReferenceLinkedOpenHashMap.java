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
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap.class */
public class Object2ReferenceLinkedOpenHashMap<K, V> extends AbstractObject2ReferenceSortedMap<K, V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2619n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2620f;
    protected transient Object2ReferenceSortedMap.FastSortedEntrySet<K, V> entries;
    protected transient ObjectSortedSet<K> keys;
    protected transient ReferenceCollection<V> values;

    public Object2ReferenceLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2620f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2619n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2619n - 1;
            this.maxFill = HashCommon.maxFill(this.f2619n, f);
            this.key = (K[]) new Object[this.f2619n + 1];
            this.value = (V[]) new Object[this.f2619n + 1];
            this.link = new long[this.f2619n + 1];
        }
    }

    public Object2ReferenceLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Object2ReferenceLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Object2ReferenceLinkedOpenHashMap(Map<? extends K, ? extends V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Object2ReferenceLinkedOpenHashMap(Map<? extends K, ? extends V> m) {
        this(m, 0.75f);
    }

    public Object2ReferenceLinkedOpenHashMap(Object2ReferenceMap<K, V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Object2ReferenceLinkedOpenHashMap(Object2ReferenceMap<K, V> m) {
        this((Object2ReferenceMap) m, 0.75f);
    }

    public Object2ReferenceLinkedOpenHashMap(K[] k, V[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Object2ReferenceLinkedOpenHashMap(K[] k, V[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2620f);
        if (needed > this.f2619n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2620f)))));
        if (needed > this.f2619n) {
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
        if (this.f2619n > this.minN && this.size < this.maxFill / 4 && this.f2619n > 16) {
            rehash(this.f2619n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2619n] = null;
        V oldValue = this.value[this.f2619n];
        this.value[this.f2619n] = null;
        this.size--;
        fixPointers(this.f2619n);
        if (this.f2619n > this.minN && this.size < this.maxFill / 4 && this.f2619n > 16) {
            rehash(this.f2619n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        if (((double) this.f2620f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.f2619n : -(this.f2619n + 1);
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return -(pos + 1);
        }
        if (k.equals(curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return -(pos + 1);
            }
        } while (!k.equals(curr));
        return pos;
    }

    private void insert(int pos, K k, V v) {
        if (pos == this.f2619n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2620f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
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
                int slot = HashCommon.mix(curr.hashCode()) & this.mask;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V remove(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return (V) this.defRetValue;
        }
        if (k.equals(curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return (V) this.defRetValue;
            }
        } while (!k.equals(curr));
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
        if (pos == this.f2619n) {
            this.containsNullKey = false;
            this.key[this.f2619n] = null;
            this.value[this.f2619n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2619n > this.minN && this.size < this.maxFill / 4 && this.f2619n > 16) {
            rehash(this.f2619n / 2);
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
        if (pos == this.f2619n) {
            this.containsNullKey = false;
            this.key[this.f2619n] = null;
            this.value[this.f2619n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2619n > this.minN && this.size < this.maxFill / 4 && this.f2619n > 16) {
            rehash(this.f2619n / 2);
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
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(k.hashCode()) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return (V) this.defRetValue;
            }
            if (k.equals(curr2)) {
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
            } while (!k.equals(curr));
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToFirst(this.f2619n);
            return this.value[this.f2619n];
        }
    }

    public V getAndMoveToLast(K k) {
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(k.hashCode()) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return (V) this.defRetValue;
            }
            if (k.equals(curr2)) {
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
            } while (!k.equals(curr));
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToLast(this.f2619n);
            return this.value[this.f2619n];
        }
    }

    public V putAndMoveToFirst(K k, V v) {
        int pos;
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(k.hashCode()) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (curr2.equals(k)) {
                    moveIndexToFirst(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!curr.equals(k));
                moveIndexToFirst(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToFirst(this.f2619n);
            return setValue(this.f2619n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2619n;
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
            rehash(HashCommon.arraySize(this.size, this.f2620f));
        }
        return (V) this.defRetValue;
    }

    public V putAndMoveToLast(K k, V v) {
        int pos;
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(k.hashCode()) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (curr2.equals(k)) {
                    moveIndexToLast(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!curr.equals(k));
                moveIndexToLast(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToLast(this.f2619n);
            return setValue(this.f2619n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2619n;
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
            rehash(HashCommon.arraySize(this.size, this.f2620f));
        }
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V get(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2619n] : (V) this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return (V) this.defRetValue;
        }
        if (k.equals(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return (V) this.defRetValue;
            }
        } while (!k.equals(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return false;
        }
        if (k.equals(curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return false;
            }
        } while (!k.equals(curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2619n] == v) {
            return true;
        }
        int i = this.f2619n;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V getOrDefault(Object k, V defaultValue) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2619n] : defaultValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return defaultValue;
        }
        if (k.equals(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return defaultValue;
            }
        } while (!k.equals(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public boolean remove(Object k, Object v) {
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(k.hashCode()) & this.mask;
            int pos = mix;
            K curr = key[mix];
            if (curr == null) {
                return false;
            }
            if (!k.equals(curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    K curr2 = key[i];
                    if (curr2 == null) {
                        return false;
                    }
                    if (k.equals(curr2) && v == this.value[pos]) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || v != this.value[this.f2619n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public boolean replace(K k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public V replace(K k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap
    public V computeIfAbsent(K key, Object2ReferenceFunction<? super K, ? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(k, (Object) this.value[pos]);
            if (newValue == null) {
                if (k == null) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public V compute(K k, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(k, pos >= 0 ? (Object) this.value[pos] : (Object) null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == null) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
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
            if (k == null) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Object2ReferenceMap.Entry<K, V>, Map.Entry<K, V>, ObjectReferencePair<K, V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Object2ReferenceLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Object2ReferenceLinkedOpenHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Object2ReferenceLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Object2ReferenceLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Object2ReferenceLinkedOpenHashMap.this.value[this.index];
            Object2ReferenceLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public ObjectReferencePair<K, V> right(V v) {
            Object2ReferenceLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> e = (Map.Entry) o;
            return Objects.equals(Object2ReferenceLinkedOpenHashMap.this.key[this.index], e.getKey()) && Object2ReferenceLinkedOpenHashMap.this.value[this.index] == e.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (Object2ReferenceLinkedOpenHashMap.this.key[this.index] == null ? 0 : Object2ReferenceLinkedOpenHashMap.this.key[this.index].hashCode()) ^ (Object2ReferenceLinkedOpenHashMap.this.value[this.index] == null ? 0 : System.identityHashCode(Object2ReferenceLinkedOpenHashMap.this.value[this.index]));
        }

        @Override // java.lang.Object
        public String toString() {
            return Object2ReferenceLinkedOpenHashMap.this.key[this.index] + "=>" + Object2ReferenceLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Object2ReferenceSortedMap<K, V> tailMap(K from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Object2ReferenceSortedMap<K, V> headMap(K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Object2ReferenceSortedMap<K, V> subMap(K from, K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$MapIterator.class */
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
            this.next = Object2ReferenceLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == null) {
                if (Object2ReferenceLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Object2ReferenceLinkedOpenHashMap.this.link[Object2ReferenceLinkedOpenHashMap.this.f2619n];
                    this.prev = Object2ReferenceLinkedOpenHashMap.this.f2619n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Objects.equals(Object2ReferenceLinkedOpenHashMap.this.key[Object2ReferenceLinkedOpenHashMap.this.last], from)) {
                this.prev = Object2ReferenceLinkedOpenHashMap.this.last;
                this.index = Object2ReferenceLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix(from.hashCode());
                int i = Object2ReferenceLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Object2ReferenceLinkedOpenHashMap.this.key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Object2ReferenceLinkedOpenHashMap.this.key[pos].equals(from)) {
                        this.next = (int) Object2ReferenceLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Object2ReferenceLinkedOpenHashMap.this.mask;
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
                    this.index = Object2ReferenceLinkedOpenHashMap.this.size;
                } else {
                    int pos = Object2ReferenceLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Object2ReferenceLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Object2ReferenceLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Object2ReferenceLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Object2ReferenceLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x018f, code lost:
            r0[r14] = r0;
            r11.this$0.value[r14] = r11.this$0.value[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x01ac, code lost:
            if (r11.next != r14) goto L_0x01b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01af, code lost:
            r11.next = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01b9, code lost:
            if (r11.prev != r14) goto L_0x01c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x01bc, code lost:
            r11.prev = r14;
         */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void remove() {
            /*
            // Method dump skipped, instructions count: 462
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap.MapIterator.remove():void");
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

        public void set(Object2ReferenceMap.Entry<K, V> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Object2ReferenceMap.Entry<K, V> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Object2ReferenceLinkedOpenHashMap<K, V>.MapIterator implements ObjectListIterator<Object2ReferenceMap.Entry<K, V>> {
        private Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2ReferenceMap.Entry) ((Object2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2ReferenceMap.Entry) ((Object2ReferenceMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Object2ReferenceMap.Entry<K, V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry next() {
            Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry previous() {
            Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Object2ReferenceLinkedOpenHashMap<K, V>.MapIterator implements ObjectListIterator<Object2ReferenceMap.Entry<K, V>> {
        final Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2ReferenceMap.Entry) ((Object2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2ReferenceMap.Entry) ((Object2ReferenceMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Object2ReferenceMap.Entry<K, V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2ReferenceLinkedOpenHashMap<K, V>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Object2ReferenceMap.Entry<K, V>> implements Object2ReferenceSortedMap.FastSortedEntrySet<K, V> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Object2ReferenceMap.Entry) ((Object2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2ReferenceMap.Entry<K, V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ReferenceLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Object2ReferenceMap.Entry<K, V>> comparator() {
            return null;
        }

        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> subSet(Object2ReferenceMap.Entry<K, V> fromElement, Object2ReferenceMap.Entry<K, V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> headSet(Object2ReferenceMap.Entry<K, V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> tailSet(Object2ReferenceMap.Entry<K, V> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Object2ReferenceMap.Entry<K, V> first() {
            if (Object2ReferenceLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Object2ReferenceLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Object2ReferenceMap.Entry<K, V> last() {
            if (Object2ReferenceLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Object2ReferenceLinkedOpenHashMap.this.last);
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
            if (key == null) {
                return Object2ReferenceLinkedOpenHashMap.this.containsNullKey && Object2ReferenceLinkedOpenHashMap.this.value[Object2ReferenceLinkedOpenHashMap.this.f2619n] == value;
            }
            K[] key2 = Object2ReferenceLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix(key.hashCode()) & Object2ReferenceLinkedOpenHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (key.equals(curr2)) {
                return Object2ReferenceLinkedOpenHashMap.this.value[pos] == value;
            }
            do {
                int i = (pos + 1) & Object2ReferenceLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!key.equals(curr));
            return Object2ReferenceLinkedOpenHashMap.this.value[pos] == value;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            Object key = e.getKey();
            Object value = e.getValue();
            if (key != null) {
                K[] key2 = Object2ReferenceLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix(key.hashCode()) & Object2ReferenceLinkedOpenHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!curr.equals(key)) {
                    while (true) {
                        int i = (pos + 1) & Object2ReferenceLinkedOpenHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (curr2.equals(key) && Object2ReferenceLinkedOpenHashMap.this.value[pos] == value) {
                            Object2ReferenceLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Object2ReferenceLinkedOpenHashMap.this.value[pos] != value) {
                    return false;
                } else {
                    Object2ReferenceLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Object2ReferenceLinkedOpenHashMap.this.containsNullKey || Object2ReferenceLinkedOpenHashMap.this.value[Object2ReferenceLinkedOpenHashMap.this.f2619n] != value) {
                return false;
            } else {
                Object2ReferenceLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ReferenceLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ReferenceLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Object2ReferenceMap.Entry<K, V>> iterator(Object2ReferenceMap.Entry<K, V> from) {
            return new EntryIterator(from.getKey());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap.FastEntrySet
        public ObjectListIterator<Object2ReferenceMap.Entry<K, V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap.FastSortedEntrySet
        public ObjectListIterator<Object2ReferenceMap.Entry<K, V>> fastIterator(Object2ReferenceMap.Entry<K, V> from) {
            return new FastEntryIterator(from.getKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2ReferenceMap.Entry<K, V>> consumer) {
            int i = Object2ReferenceLinkedOpenHashMap.this.size;
            int next = Object2ReferenceLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ReferenceLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractObject2ReferenceMap.BasicEntry(Object2ReferenceLinkedOpenHashMap.this.key[next], Object2ReferenceLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2ReferenceMap.Entry<K, V>> consumer) {
            AbstractObject2ReferenceMap.BasicEntry<K, V> entry = new AbstractObject2ReferenceMap.BasicEntry<>();
            int i = Object2ReferenceLinkedOpenHashMap.this.size;
            int next = Object2ReferenceLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ReferenceLinkedOpenHashMap.this.link[next];
                    entry.key = Object2ReferenceLinkedOpenHashMap.this.key[next];
                    entry.value = Object2ReferenceLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap
    public Object2ReferenceSortedMap.FastSortedEntrySet<K, V> object2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Object2ReferenceLinkedOpenHashMap<K, V>.MapIterator implements ObjectListIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap.MapIterator
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
            return Object2ReferenceLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Object2ReferenceLinkedOpenHashMap.this.key[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return Object2ReferenceLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$KeySet.class */
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
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ReferenceLinkedOpenHashMap.this), 81);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            int i = Object2ReferenceLinkedOpenHashMap.this.size;
            int next = Object2ReferenceLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2ReferenceLinkedOpenHashMap.this.link[next];
                    consumer.accept((Object) Object2ReferenceLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ReferenceLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2ReferenceLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Object2ReferenceLinkedOpenHashMap.this.size;
            Object2ReferenceLinkedOpenHashMap.this.remove(k);
            return Object2ReferenceLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ReferenceLinkedOpenHashMap.this.clear();
        }

        @Override // java.util.SortedSet
        public K first() {
            if (Object2ReferenceLinkedOpenHashMap.this.size != 0) {
                return Object2ReferenceLinkedOpenHashMap.this.key[Object2ReferenceLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            if (Object2ReferenceLinkedOpenHashMap.this.size != 0) {
                return Object2ReferenceLinkedOpenHashMap.this.key[Object2ReferenceLinkedOpenHashMap.this.last];
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Object2ReferenceLinkedOpenHashMap<K, V>.MapIterator implements ObjectListIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((ValueIterator) consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public V previous() {
            return Object2ReferenceLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super V> action, int index) {
            action.accept((Object) Object2ReferenceLinkedOpenHashMap.this.value[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public V next() {
            return Object2ReferenceLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 80;

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2ReferenceLinkedOpenHashMap.this), 80);
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    int i = Object2ReferenceLinkedOpenHashMap.this.size;
                    int next = Object2ReferenceLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Object2ReferenceLinkedOpenHashMap.this.link[next];
                            consumer.accept((Object) Object2ReferenceLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2ReferenceLinkedOpenHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Object2ReferenceLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2ReferenceLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2620f)));
        if (l >= this.f2619n || this.size > HashCommon.maxFill(l, this.f2620f)) {
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
            if (key[i] != null) {
                int mix = HashCommon.mix(key[i].hashCode());
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
        this.f2619n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2619n, this.f2620f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Object2ReferenceLinkedOpenHashMap<K, V> clone() {
        try {
            Object2ReferenceLinkedOpenHashMap<K, V> c = (Object2ReferenceLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (V[]) ((Object[]) this.value.clone());
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.lang.Object, java.util.Map
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
                t = this.key[i].hashCode();
            }
            if (this != this.value[i]) {
                t ^= this.value[i] == null ? 0 : System.identityHashCode(this.value[i]);
            }
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2619n] == null ? 0 : System.identityHashCode(this.value[this.f2619n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        V[] value = this.value;
        Object2ReferenceLinkedOpenHashMap<K, V>.EntryIterator i = new EntryIterator();
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
    /* JADX DEBUG: Multi-variable search result rejected for r0v39, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2619n = HashCommon.arraySize(this.size, this.f2620f);
        this.maxFill = HashCommon.maxFill(this.f2619n, this.f2620f);
        this.mask = this.f2619n - 1;
        K[] key = (K[]) new Object[this.f2619n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f2619n + 1];
        this.value = value;
        long[] link = new long[this.f2619n + 1];
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
            if (readObject != null) {
                int mix = HashCommon.mix(readObject.hashCode());
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
                pos = this.f2619n;
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
