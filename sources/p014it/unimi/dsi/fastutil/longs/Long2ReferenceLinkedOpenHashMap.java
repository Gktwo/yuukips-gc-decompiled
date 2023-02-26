package p014it.unimi.dsi.fastutil.longs;

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
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap.class */
public class Long2ReferenceLinkedOpenHashMap<V> extends AbstractLong2ReferenceSortedMap<V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient long[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2324n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2325f;
    protected transient Long2ReferenceSortedMap.FastSortedEntrySet<V> entries;
    protected transient LongSortedSet keys;
    protected transient ReferenceCollection<V> values;

    public Long2ReferenceLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2325f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2324n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2324n - 1;
            this.maxFill = HashCommon.maxFill(this.f2324n, f);
            this.key = new long[this.f2324n + 1];
            this.value = (V[]) new Object[this.f2324n + 1];
            this.link = new long[this.f2324n + 1];
        }
    }

    public Long2ReferenceLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Long2ReferenceLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Long2ReferenceLinkedOpenHashMap(Map<? extends Long, ? extends V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Long2ReferenceLinkedOpenHashMap(Map<? extends Long, ? extends V> m) {
        this(m, 0.75f);
    }

    public Long2ReferenceLinkedOpenHashMap(Long2ReferenceMap<V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Long2ReferenceLinkedOpenHashMap(Long2ReferenceMap<V> m) {
        this((Long2ReferenceMap) m, 0.75f);
    }

    public Long2ReferenceLinkedOpenHashMap(long[] k, V[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (long) v[i]);
        }
    }

    public Long2ReferenceLinkedOpenHashMap(long[] k, V[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2325f);
        if (needed > this.f2324n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2325f)))));
        if (needed > this.f2324n) {
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
        if (this.f2324n > this.minN && this.size < this.maxFill / 4 && this.f2324n > 16) {
            rehash(this.f2324n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.f2324n];
        this.value[this.f2324n] = null;
        this.size--;
        fixPointers(this.f2324n);
        if (this.f2324n > this.minN && this.size < this.maxFill / 4 && this.f2324n > 16) {
            rehash(this.f2324n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
    public void putAll(Map<? extends Long, ? extends V> m) {
        if (((double) this.f2325f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(long k) {
        long curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2324n : -(this.f2324n + 1);
        }
        long[] key = this.key;
        int mix = ((int) HashCommon.mix(k)) & this.mask;
        int pos = mix;
        long curr2 = key[mix];
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

    private void insert(int pos, long k, V v) {
        if (pos == this.f2324n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2325f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V put(long k, V v) {
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
        long curr;
        long[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (curr == 0) {
                    key[pos] = 0;
                    this.value[pos] = null;
                    return;
                }
                int slot = ((int) HashCommon.mix(curr)) & this.mask;
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V remove(long k) {
        long curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        long[] key = this.key;
        int mix = ((int) HashCommon.mix(k)) & this.mask;
        int pos = mix;
        long curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (k == curr2) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (k != curr);
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
        if (pos == this.f2324n) {
            this.containsNullKey = false;
            this.value[this.f2324n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2324n > this.minN && this.size < this.maxFill / 4 && this.f2324n > 16) {
            rehash(this.f2324n / 2);
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
        if (pos == this.f2324n) {
            this.containsNullKey = false;
            this.value[this.f2324n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2324n > this.minN && this.size < this.maxFill / 4 && this.f2324n > 16) {
            rehash(this.f2324n / 2);
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

    public V getAndMoveToFirst(long k) {
        long curr;
        if (k != 0) {
            long[] key = this.key;
            int mix = ((int) HashCommon.mix(k)) & this.mask;
            int pos = mix;
            long curr2 = key[mix];
            if (curr2 == 0) {
                return (V) this.defRetValue;
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
                    return (V) this.defRetValue;
                }
            } while (k != curr);
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToFirst(this.f2324n);
            return this.value[this.f2324n];
        }
    }

    public V getAndMoveToLast(long k) {
        long curr;
        if (k != 0) {
            long[] key = this.key;
            int mix = ((int) HashCommon.mix(k)) & this.mask;
            int pos = mix;
            long curr2 = key[mix];
            if (curr2 == 0) {
                return (V) this.defRetValue;
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
                    return (V) this.defRetValue;
                }
            } while (k != curr);
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToLast(this.f2324n);
            return this.value[this.f2324n];
        }
    }

    public V putAndMoveToFirst(long k, V v) {
        int pos;
        long curr;
        if (k != 0) {
            long[] key = this.key;
            int mix = ((int) HashCommon.mix(k)) & this.mask;
            pos = mix;
            long curr2 = key[mix];
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
            moveIndexToFirst(this.f2324n);
            return setValue(this.f2324n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2324n;
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
            rehash(HashCommon.arraySize(this.size, this.f2325f));
        }
        return (V) this.defRetValue;
    }

    public V putAndMoveToLast(long k, V v) {
        int pos;
        long curr;
        if (k != 0) {
            long[] key = this.key;
            int mix = ((int) HashCommon.mix(k)) & this.mask;
            pos = mix;
            long curr2 = key[mix];
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
            moveIndexToLast(this.f2324n);
            return setValue(this.f2324n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2324n;
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
            rehash(HashCommon.arraySize(this.size, this.f2325f));
        }
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V get(long k) {
        long curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2324n] : (V) this.defRetValue;
        }
        long[] key = this.key;
        int mix = ((int) HashCommon.mix(k)) & this.mask;
        int pos = mix;
        long curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public boolean containsKey(long k) {
        long curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        long[] key = this.key;
        int mix = ((int) HashCommon.mix(k)) & this.mask;
        int pos = mix;
        long curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        long[] key = this.key;
        if (this.containsNullKey && value[this.f2324n] == v) {
            return true;
        }
        int i = this.f2324n;
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V getOrDefault(long k, V defaultValue) {
        long curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2324n] : defaultValue;
        }
        long[] key = this.key;
        int mix = ((int) HashCommon.mix(k)) & this.mask;
        int pos = mix;
        long curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public V putIfAbsent(long k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public boolean remove(long k, Object v) {
        if (k != 0) {
            long[] key = this.key;
            int mix = ((int) HashCommon.mix(k)) & this.mask;
            int pos = mix;
            long curr = key[mix];
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
                long curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f2324n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public boolean replace(long k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public V replace(long k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public V computeIfAbsent(long k, LongFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        V newValue = (V) mappingFunction.apply(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public V computeIfAbsent(long key, Long2ReferenceFunction<? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public V computeIfPresent(long k, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(Long.valueOf(k), (Object) this.value[pos]);
            if (newValue == null) {
                if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public V compute(long k, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(Long.valueOf(k), pos >= 0 ? (Object) this.value[pos] : (Object) null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public V merge(long k, V v, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
            if (k == 0) {
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
            Arrays.fill(this.key, 0L);
            Arrays.fill(this.value, (Object) null);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Long2ReferenceMap.Entry<V>, Map.Entry<Long, V>, LongReferencePair<V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap.Entry
        public long getLongKey() {
            return Long2ReferenceLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongReferencePair
        public long leftLong() {
            return Long2ReferenceLinkedOpenHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Long2ReferenceLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Long2ReferenceLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Long2ReferenceLinkedOpenHashMap.this.value[this.index];
            Long2ReferenceLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public LongReferencePair<V> right(V v) {
            Long2ReferenceLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getKey() {
            return Long.valueOf(Long2ReferenceLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, V> e = (Map.Entry) o;
            return Long2ReferenceLinkedOpenHashMap.this.key[this.index] == e.getKey().longValue() && Long2ReferenceLinkedOpenHashMap.this.value[this.index] == e.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(Long2ReferenceLinkedOpenHashMap.this.key[this.index]) ^ (Long2ReferenceLinkedOpenHashMap.this.value[this.index] == null ? 0 : System.identityHashCode(Long2ReferenceLinkedOpenHashMap.this.value[this.index]));
        }

        @Override // java.lang.Object
        public String toString() {
            return Long2ReferenceLinkedOpenHashMap.this.key[this.index] + "=>" + Long2ReferenceLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public long firstLongKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public long lastLongKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceSortedMap<V> tailMap(long from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceSortedMap<V> headMap(long to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceSortedMap<V> subMap(long from, long to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap, java.util.SortedMap
    public Comparator<? super Long> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$MapIterator.class */
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
            this.next = Long2ReferenceLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(long from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == 0) {
                if (Long2ReferenceLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Long2ReferenceLinkedOpenHashMap.this.link[Long2ReferenceLinkedOpenHashMap.this.f2324n];
                    this.prev = Long2ReferenceLinkedOpenHashMap.this.f2324n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Long2ReferenceLinkedOpenHashMap.this.key[Long2ReferenceLinkedOpenHashMap.this.last] == from) {
                this.prev = Long2ReferenceLinkedOpenHashMap.this.last;
                this.index = Long2ReferenceLinkedOpenHashMap.this.size;
            } else {
                int mix = (int) HashCommon.mix(from);
                int i = Long2ReferenceLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Long2ReferenceLinkedOpenHashMap.this.key[pos] == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Long2ReferenceLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Long2ReferenceLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Long2ReferenceLinkedOpenHashMap.this.mask;
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
                    this.index = Long2ReferenceLinkedOpenHashMap.this.size;
                } else {
                    int pos = Long2ReferenceLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Long2ReferenceLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Long2ReferenceLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Long2ReferenceLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Long2ReferenceLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            long curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (Long2ReferenceLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Long2ReferenceLinkedOpenHashMap.this.link[this.curr];
            }
            Long2ReferenceLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Long2ReferenceLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Long2ReferenceLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Long2ReferenceLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Long2ReferenceLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Long2ReferenceLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Long2ReferenceLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Long2ReferenceLinkedOpenHashMap.this.f2324n) {
                Long2ReferenceLinkedOpenHashMap.this.containsNullKey = false;
                Long2ReferenceLinkedOpenHashMap.this.value[Long2ReferenceLinkedOpenHashMap.this.f2324n] = null;
                return;
            }
            long[] key = Long2ReferenceLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Long2ReferenceLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        Long2ReferenceLinkedOpenHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = ((int) HashCommon.mix(curr)) & Long2ReferenceLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Long2ReferenceLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Long2ReferenceLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Long2ReferenceLinkedOpenHashMap.this.value[pos] = Long2ReferenceLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Long2ReferenceLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Long2ReferenceMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Long2ReferenceMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Long2ReferenceLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<Long2ReferenceMap.Entry<V>> {
        private Long2ReferenceLinkedOpenHashMap<V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(long from) {
            super(from);
        }

        final void acceptOnIndex(Consumer<? super Long2ReferenceMap.Entry<V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Long2ReferenceLinkedOpenHashMap<V>.MapEntry next() {
            Long2ReferenceLinkedOpenHashMap<V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Long2ReferenceLinkedOpenHashMap<V>.MapEntry previous() {
            Long2ReferenceLinkedOpenHashMap<V>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Long2ReferenceLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<Long2ReferenceMap.Entry<V>> {
        final Long2ReferenceLinkedOpenHashMap<V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(long from) {
            super(from);
            this.entry = new MapEntry();
        }

        final void acceptOnIndex(Consumer<? super Long2ReferenceMap.Entry<V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Long2ReferenceLinkedOpenHashMap<V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Long2ReferenceLinkedOpenHashMap<V>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Long2ReferenceMap.Entry<V>> implements Long2ReferenceSortedMap.FastSortedEntrySet<V> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2ReferenceMap.Entry<V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Long2ReferenceLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Long2ReferenceMap.Entry<V>> comparator() {
            return null;
        }

        public ObjectSortedSet<Long2ReferenceMap.Entry<V>> subSet(Long2ReferenceMap.Entry<V> fromElement, Long2ReferenceMap.Entry<V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Long2ReferenceMap.Entry<V>> headSet(Long2ReferenceMap.Entry<V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Long2ReferenceMap.Entry<V>> tailSet(Long2ReferenceMap.Entry<V> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Long2ReferenceMap.Entry<V> first() {
            if (Long2ReferenceLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Long2ReferenceLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Long2ReferenceMap.Entry<V> last() {
            if (Long2ReferenceLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Long2ReferenceLinkedOpenHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            long curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            Object value = e.getValue();
            if (k == 0) {
                return Long2ReferenceLinkedOpenHashMap.this.containsNullKey && Long2ReferenceLinkedOpenHashMap.this.value[Long2ReferenceLinkedOpenHashMap.this.f2324n] == value;
            }
            long[] key = Long2ReferenceLinkedOpenHashMap.this.key;
            int mix = ((int) HashCommon.mix(k)) & Long2ReferenceLinkedOpenHashMap.this.mask;
            int pos = mix;
            long curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Long2ReferenceLinkedOpenHashMap.this.value[pos] == value;
            }
            do {
                int i = (pos + 1) & Long2ReferenceLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Long2ReferenceLinkedOpenHashMap.this.value[pos] == value;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            Object value = e.getValue();
            if (k != 0) {
                long[] key = Long2ReferenceLinkedOpenHashMap.this.key;
                int mix = ((int) HashCommon.mix(k)) & Long2ReferenceLinkedOpenHashMap.this.mask;
                int pos = mix;
                long curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Long2ReferenceLinkedOpenHashMap.this.mask;
                        pos = i;
                        long curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Long2ReferenceLinkedOpenHashMap.this.value[pos] == value) {
                            Long2ReferenceLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Long2ReferenceLinkedOpenHashMap.this.value[pos] != value) {
                    return false;
                } else {
                    Long2ReferenceLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Long2ReferenceLinkedOpenHashMap.this.containsNullKey || Long2ReferenceLinkedOpenHashMap.this.value[Long2ReferenceLinkedOpenHashMap.this.f2324n] != value) {
                return false;
            } else {
                Long2ReferenceLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2ReferenceLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2ReferenceLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Long2ReferenceMap.Entry<V>> iterator(Long2ReferenceMap.Entry<V> from) {
            return new EntryIterator(from.getLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap.FastEntrySet
        public ObjectListIterator<Long2ReferenceMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap.FastSortedEntrySet
        public ObjectListIterator<Long2ReferenceMap.Entry<V>> fastIterator(Long2ReferenceMap.Entry<V> from) {
            return new FastEntryIterator(from.getLongKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Long2ReferenceMap.Entry<V>> consumer) {
            int i = Long2ReferenceLinkedOpenHashMap.this.size;
            int next = Long2ReferenceLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Long2ReferenceLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractLong2ReferenceMap.BasicEntry(Long2ReferenceLinkedOpenHashMap.this.key[next], Long2ReferenceLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Long2ReferenceMap.Entry<V>> consumer) {
            AbstractLong2ReferenceMap.BasicEntry<V> entry = new AbstractLong2ReferenceMap.BasicEntry<>();
            int i = Long2ReferenceLinkedOpenHashMap.this.size;
            int next = Long2ReferenceLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Long2ReferenceLinkedOpenHashMap.this.link[next];
                    entry.key = Long2ReferenceLinkedOpenHashMap.this.key[next];
                    entry.value = Long2ReferenceLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceSortedMap.FastSortedEntrySet<V> long2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Long2ReferenceLinkedOpenHashMap<V>.MapIterator implements LongListIterator {
        @Override // java.util.PrimitiveIterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((KeyIterator) longConsumer);
        }

        public KeyIterator(long k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return Long2ReferenceLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Long2ReferenceLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Long2ReferenceLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractLongSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongListIterator iterator(long from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongListIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(Long2ReferenceLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer consumer) {
            int i = Long2ReferenceLinkedOpenHashMap.this.size;
            int next = Long2ReferenceLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Long2ReferenceLinkedOpenHashMap.this.link[next];
                    consumer.accept(Long2ReferenceLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2ReferenceLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return Long2ReferenceLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            int oldSize = Long2ReferenceLinkedOpenHashMap.this.size;
            Long2ReferenceLinkedOpenHashMap.this.remove(k);
            return Long2ReferenceLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2ReferenceLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            if (Long2ReferenceLinkedOpenHashMap.this.size != 0) {
                return Long2ReferenceLinkedOpenHashMap.this.key[Long2ReferenceLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            if (Long2ReferenceLinkedOpenHashMap.this.size != 0) {
                return Long2ReferenceLinkedOpenHashMap.this.key[Long2ReferenceLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long from, long to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    public LongSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Long2ReferenceLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((ValueIterator) consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public V previous() {
            return Long2ReferenceLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super V> action, int index) {
            action.accept((Object) Long2ReferenceLinkedOpenHashMap.this.value[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public V next() {
            return Long2ReferenceLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 80;

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Long2ReferenceLinkedOpenHashMap.this), 80);
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    int i = Long2ReferenceLinkedOpenHashMap.this.size;
                    int next = Long2ReferenceLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Long2ReferenceLinkedOpenHashMap.this.link[next];
                            consumer.accept((Object) Long2ReferenceLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2ReferenceLinkedOpenHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Long2ReferenceLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2ReferenceLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2325f)));
        if (l >= this.f2324n || this.size > HashCommon.maxFill(l, this.f2325f)) {
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
        long[] key = this.key;
        V[] value = this.value;
        int mask = newN - 1;
        long[] newKey = new long[newN + 1];
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
            if (key[i] != 0) {
                int mix = (int) HashCommon.mix(key[i]);
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
        this.f2324n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2324n, this.f2325f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Long2ReferenceLinkedOpenHashMap<V> clone() {
        try {
            Long2ReferenceLinkedOpenHashMap<V> c = (Long2ReferenceLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (long[]) this.key.clone();
            c.value = (V[]) ((Object[]) this.value.clone());
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.lang.Object, java.util.Map
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
            int t = HashCommon.long2int(this.key[i]);
            if (this != this.value[i]) {
                t ^= this.value[i] == null ? 0 : System.identityHashCode(this.value[i]);
            }
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2324n] == null ? 0 : System.identityHashCode(this.value[this.f2324n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        long[] key = this.key;
        V[] value = this.value;
        Long2ReferenceLinkedOpenHashMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeLong(key[e]);
                s.writeObject(value[e]);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: V[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2324n = HashCommon.arraySize(this.size, this.f2325f);
        this.maxFill = HashCommon.maxFill(this.f2324n, this.f2325f);
        this.mask = this.f2324n - 1;
        long[] key = new long[this.f2324n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f2324n + 1];
        this.value = value;
        long[] link = new long[this.f2324n + 1];
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
            long k = s.readLong();
            Object readObject = s.readObject();
            if (k != 0) {
                int mix = (int) HashCommon.mix(k);
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
                pos = this.f2324n;
                this.containsNullKey = true;
            }
            key[pos] = k;
            value[pos] = readObject;
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
