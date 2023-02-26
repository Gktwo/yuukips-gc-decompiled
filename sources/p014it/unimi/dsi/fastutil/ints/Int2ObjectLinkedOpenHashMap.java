package p014it.unimi.dsi.fastutil.ints;

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
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap.class */
public class Int2ObjectLinkedOpenHashMap<V> extends AbstractInt2ObjectSortedMap<V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient int[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2070n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2071f;
    protected transient Int2ObjectSortedMap.FastSortedEntrySet<V> entries;
    protected transient IntSortedSet keys;
    protected transient ObjectCollection<V> values;

    public Int2ObjectLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2071f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2070n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2070n - 1;
            this.maxFill = HashCommon.maxFill(this.f2070n, f);
            this.key = new int[this.f2070n + 1];
            this.value = (V[]) new Object[this.f2070n + 1];
            this.link = new long[this.f2070n + 1];
        }
    }

    public Int2ObjectLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Int2ObjectLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Int2ObjectLinkedOpenHashMap(Map<? extends Integer, ? extends V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2ObjectLinkedOpenHashMap(Map<? extends Integer, ? extends V> m) {
        this(m, 0.75f);
    }

    public Int2ObjectLinkedOpenHashMap(Int2ObjectMap<V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2ObjectLinkedOpenHashMap(Int2ObjectMap<V> m) {
        this((Int2ObjectMap) m, 0.75f);
    }

    public Int2ObjectLinkedOpenHashMap(int[] k, V[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (int) v[i]);
        }
    }

    public Int2ObjectLinkedOpenHashMap(int[] k, V[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2071f);
        if (needed > this.f2070n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2071f)))));
        if (needed > this.f2070n) {
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
        if (this.f2070n > this.minN && this.size < this.maxFill / 4 && this.f2070n > 16) {
            rehash(this.f2070n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.f2070n];
        this.value[this.f2070n] = null;
        this.size--;
        fixPointers(this.f2070n);
        if (this.f2070n > this.minN && this.size < this.maxFill / 4 && this.f2070n > 16) {
            rehash(this.f2070n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, java.util.Map
    public void putAll(Map<? extends Integer, ? extends V> m) {
        if (((double) this.f2071f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2070n : -(this.f2070n + 1);
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    private void insert(int pos, int k, V v) {
        if (pos == this.f2070n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2071f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction
    public V put(int k, V v) {
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
                    this.value[pos] = null;
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
            this.value[pos] = this.value[pos];
            fixPointers(pos, pos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction
    public V remove(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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
        if (pos == this.f2070n) {
            this.containsNullKey = false;
            this.value[this.f2070n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2070n > this.minN && this.size < this.maxFill / 4 && this.f2070n > 16) {
            rehash(this.f2070n / 2);
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
        if (pos == this.f2070n) {
            this.containsNullKey = false;
            this.value[this.f2070n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2070n > this.minN && this.size < this.maxFill / 4 && this.f2070n > 16) {
            rehash(this.f2070n / 2);
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

    public V getAndMoveToFirst(int k) {
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr2 = key[mix];
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
            moveIndexToFirst(this.f2070n);
            return this.value[this.f2070n];
        }
    }

    public V getAndMoveToLast(int k) {
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr2 = key[mix];
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
            moveIndexToLast(this.f2070n);
            return this.value[this.f2070n];
        }
    }

    public V putAndMoveToFirst(int k, V v) {
        int pos;
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            pos = mix;
            int curr2 = key[mix];
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
            moveIndexToFirst(this.f2070n);
            return setValue(this.f2070n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2070n;
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
            rehash(HashCommon.arraySize(this.size, this.f2071f));
        }
        return (V) this.defRetValue;
    }

    public V putAndMoveToLast(int k, V v) {
        int pos;
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            pos = mix;
            int curr2 = key[mix];
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
            moveIndexToLast(this.f2070n);
            return setValue(this.f2070n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2070n;
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
            rehash(HashCommon.arraySize(this.size, this.f2071f));
        }
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction
    public V get(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2070n] : (V) this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public boolean containsKey(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey;
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        int[] key = this.key;
        if (this.containsNullKey && Objects.equals(value[this.f2070n], v)) {
            return true;
        }
        int i = this.f2070n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != 0 && Objects.equals(value[i], v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction
    public V getOrDefault(int k, V defaultValue) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2070n] : defaultValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public V putIfAbsent(int k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public boolean remove(int k, Object v) {
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (k != curr || !Objects.equals(v, this.value[pos])) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    int curr2 = key[i];
                    if (curr2 == 0) {
                        return false;
                    }
                    if (k == curr2 && Objects.equals(v, this.value[pos])) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || !Objects.equals(v, this.value[this.f2070n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public boolean replace(int k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || !Objects.equals(oldValue, this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public V replace(int k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public V computeIfAbsent(int k, IntFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        V newValue = (V) mappingFunction.apply(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public V computeIfAbsent(int key, Int2ObjectFunction<? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public V computeIfPresent(int k, BiFunction<? super Integer, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(Integer.valueOf(k), (Object) this.value[pos]);
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public V compute(int k, BiFunction<? super Integer, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(Integer.valueOf(k), pos >= 0 ? (Object) this.value[pos] : (Object) null);
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap
    public V merge(int k, V v, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
            Arrays.fill(this.key, 0);
            Arrays.fill(this.value, (Object) null);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Int2ObjectMap.Entry<V>, Map.Entry<Integer, V>, IntObjectPair<V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap.Entry
        public int getIntKey() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntObjectPair
        public int leftInt() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Int2ObjectLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Int2ObjectLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Int2ObjectLinkedOpenHashMap.this.value[this.index];
            Int2ObjectLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public IntObjectPair<V> right(V v) {
            Int2ObjectLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap.Entry, java.util.Map.Entry
        @Deprecated
        public Integer getKey() {
            return Integer.valueOf(Int2ObjectLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Integer, V> e = (Map.Entry) o;
            return Int2ObjectLinkedOpenHashMap.this.key[this.index] == e.getKey().intValue() && Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[this.index], e.getValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.index] ^ (Int2ObjectLinkedOpenHashMap.this.value[this.index] == null ? 0 : Int2ObjectLinkedOpenHashMap.this.value[this.index].hashCode());
        }

        @Override // java.lang.Object
        public String toString() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.index] + "=>" + Int2ObjectLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap
    public int firstIntKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap
    public int lastIntKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap
    public Int2ObjectSortedMap<V> tailMap(int from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap
    public Int2ObjectSortedMap<V> headMap(int to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap
    public Int2ObjectSortedMap<V> subMap(int from, int to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap, java.util.SortedMap
    public Comparator<? super Integer> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$MapIterator.class */
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
            this.next = Int2ObjectLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(int from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == 0) {
                if (Int2ObjectLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Int2ObjectLinkedOpenHashMap.this.link[Int2ObjectLinkedOpenHashMap.this.f2070n];
                    this.prev = Int2ObjectLinkedOpenHashMap.this.f2070n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Int2ObjectLinkedOpenHashMap.this.key[Int2ObjectLinkedOpenHashMap.this.last] == from) {
                this.prev = Int2ObjectLinkedOpenHashMap.this.last;
                this.index = Int2ObjectLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix(from);
                int i = Int2ObjectLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Int2ObjectLinkedOpenHashMap.this.key[pos] == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Int2ObjectLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Int2ObjectLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Int2ObjectLinkedOpenHashMap.this.mask;
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
                    this.index = Int2ObjectLinkedOpenHashMap.this.size;
                } else {
                    int pos = Int2ObjectLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Int2ObjectLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Int2ObjectLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Int2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Int2ObjectLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            int curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (Int2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Int2ObjectLinkedOpenHashMap.this.link[this.curr];
            }
            Int2ObjectLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Int2ObjectLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Int2ObjectLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Int2ObjectLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Int2ObjectLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Int2ObjectLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Int2ObjectLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Int2ObjectLinkedOpenHashMap.this.f2070n) {
                Int2ObjectLinkedOpenHashMap.this.containsNullKey = false;
                Int2ObjectLinkedOpenHashMap.this.value[Int2ObjectLinkedOpenHashMap.this.f2070n] = null;
                return;
            }
            int[] key = Int2ObjectLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Int2ObjectLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        Int2ObjectLinkedOpenHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(curr) & Int2ObjectLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Int2ObjectLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Int2ObjectLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Int2ObjectLinkedOpenHashMap.this.value[pos] = Int2ObjectLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Int2ObjectLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Int2ObjectMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Int2ObjectMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Int2ObjectLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<Int2ObjectMap.Entry<V>> {
        private Int2ObjectLinkedOpenHashMap<V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Int2ObjectMap.Entry) ((Int2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Int2ObjectMap.Entry) ((Int2ObjectMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(int from) {
            super(from);
        }

        final void acceptOnIndex(Consumer<? super Int2ObjectMap.Entry<V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Int2ObjectLinkedOpenHashMap<V>.MapEntry next() {
            Int2ObjectLinkedOpenHashMap<V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Int2ObjectLinkedOpenHashMap<V>.MapEntry previous() {
            Int2ObjectLinkedOpenHashMap<V>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Int2ObjectLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<Int2ObjectMap.Entry<V>> {
        final Int2ObjectLinkedOpenHashMap<V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Int2ObjectMap.Entry) ((Int2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Int2ObjectMap.Entry) ((Int2ObjectMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(int from) {
            super(from);
            this.entry = new MapEntry();
        }

        final void acceptOnIndex(Consumer<? super Int2ObjectMap.Entry<V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Int2ObjectLinkedOpenHashMap<V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Int2ObjectLinkedOpenHashMap<V>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Int2ObjectMap.Entry<V>> implements Int2ObjectSortedMap.FastSortedEntrySet<V> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Int2ObjectMap.Entry) ((Int2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2ObjectMap.Entry<V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2ObjectLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Int2ObjectMap.Entry<V>> comparator() {
            return null;
        }

        public ObjectSortedSet<Int2ObjectMap.Entry<V>> subSet(Int2ObjectMap.Entry<V> fromElement, Int2ObjectMap.Entry<V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Int2ObjectMap.Entry<V>> headSet(Int2ObjectMap.Entry<V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Int2ObjectMap.Entry<V>> tailSet(Int2ObjectMap.Entry<V> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Int2ObjectMap.Entry<V> first() {
            if (Int2ObjectLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Int2ObjectLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Int2ObjectMap.Entry<V> last() {
            if (Int2ObjectLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Int2ObjectLinkedOpenHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            int curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            Object value = e.getValue();
            if (k == 0) {
                return Int2ObjectLinkedOpenHashMap.this.containsNullKey && Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[Int2ObjectLinkedOpenHashMap.this.f2070n], value);
            }
            int[] key = Int2ObjectLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix(k) & Int2ObjectLinkedOpenHashMap.this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[pos], value);
            }
            do {
                int i = (pos + 1) & Int2ObjectLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[pos], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            Object value = e.getValue();
            if (k != 0) {
                int[] key = Int2ObjectLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix(k) & Int2ObjectLinkedOpenHashMap.this.mask;
                int pos = mix;
                int curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Int2ObjectLinkedOpenHashMap.this.mask;
                        pos = i;
                        int curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[pos], value)) {
                            Int2ObjectLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (!Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[pos], value)) {
                    return false;
                } else {
                    Int2ObjectLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Int2ObjectLinkedOpenHashMap.this.containsNullKey || !Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[Int2ObjectLinkedOpenHashMap.this.f2070n], value)) {
                return false;
            } else {
                Int2ObjectLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ObjectLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ObjectLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Int2ObjectMap.Entry<V>> iterator(Int2ObjectMap.Entry<V> from) {
            return new EntryIterator(from.getIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap.FastEntrySet
        public ObjectListIterator<Int2ObjectMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap.FastSortedEntrySet
        public ObjectListIterator<Int2ObjectMap.Entry<V>> fastIterator(Int2ObjectMap.Entry<V> from) {
            return new FastEntryIterator(from.getIntKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2ObjectMap.Entry<V>> consumer) {
            int i = Int2ObjectLinkedOpenHashMap.this.size;
            int next = Int2ObjectLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2ObjectLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractInt2ObjectMap.BasicEntry(Int2ObjectLinkedOpenHashMap.this.key[next], Int2ObjectLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2ObjectMap.Entry<V>> consumer) {
            AbstractInt2ObjectMap.BasicEntry<V> entry = new AbstractInt2ObjectMap.BasicEntry<>();
            int i = Int2ObjectLinkedOpenHashMap.this.size;
            int next = Int2ObjectLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2ObjectLinkedOpenHashMap.this.link[next];
                    entry.key = Int2ObjectLinkedOpenHashMap.this.key[next];
                    entry.value = Int2ObjectLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, p014it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap
    public Int2ObjectSortedMap.FastSortedEntrySet<V> int2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Int2ObjectLinkedOpenHashMap<V>.MapIterator implements IntListIterator {
        @Override // java.util.PrimitiveIterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            forEachRemaining((KeyIterator) intConsumer);
        }

        public KeyIterator(int k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return Int2ObjectLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(IntConsumer action, int index) {
            action.accept(Int2ObjectLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return Int2ObjectLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractIntSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntListIterator iterator(int from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntListIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2ObjectLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer consumer) {
            int i = Int2ObjectLinkedOpenHashMap.this.size;
            int next = Int2ObjectLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2ObjectLinkedOpenHashMap.this.link[next];
                    consumer.accept(Int2ObjectLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ObjectLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2ObjectLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldSize = Int2ObjectLinkedOpenHashMap.this.size;
            Int2ObjectLinkedOpenHashMap.this.remove(k);
            return Int2ObjectLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ObjectLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            if (Int2ObjectLinkedOpenHashMap.this.size != 0) {
                return Int2ObjectLinkedOpenHashMap.this.key[Int2ObjectLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            if (Int2ObjectLinkedOpenHashMap.this.size != 0) {
                return Int2ObjectLinkedOpenHashMap.this.key[Int2ObjectLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, java.util.Map
    public IntSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ObjectLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Int2ObjectLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((ValueIterator) consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public V previous() {
            return Int2ObjectLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super V> action, int index) {
            action.accept((Object) Int2ObjectLinkedOpenHashMap.this.value[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public V next() {
            return Int2ObjectLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, p014it.unimi.dsi.fastutil.ints.Int2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 80;

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2ObjectLinkedOpenHashMap.this), 80);
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    int i = Int2ObjectLinkedOpenHashMap.this.size;
                    int next = Int2ObjectLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Int2ObjectLinkedOpenHashMap.this.link[next];
                            consumer.accept((Object) Int2ObjectLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Int2ObjectLinkedOpenHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Int2ObjectLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Int2ObjectLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2071f)));
        if (l >= this.f2070n || this.size > HashCommon.maxFill(l, this.f2071f)) {
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
        int[] key = this.key;
        V[] value = this.value;
        int mask = newN - 1;
        int[] newKey = new int[newN + 1];
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
                int mix = HashCommon.mix(key[i]);
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
        this.f2070n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2070n, this.f2071f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Int2ObjectLinkedOpenHashMap<V> clone() {
        try {
            Int2ObjectLinkedOpenHashMap<V> c = (Int2ObjectLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (int[]) this.key.clone();
            c.value = (V[]) ((Object[]) this.value.clone());
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap, java.lang.Object, java.util.Map
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
            int t = this.key[i];
            if (this != this.value[i]) {
                t ^= this.value[i] == null ? 0 : this.value[i].hashCode();
            }
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2070n] == null ? 0 : this.value[this.f2070n].hashCode();
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int[] key = this.key;
        V[] value = this.value;
        Int2ObjectLinkedOpenHashMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeInt(key[e]);
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
        this.f2070n = HashCommon.arraySize(this.size, this.f2071f);
        this.maxFill = HashCommon.maxFill(this.f2070n, this.f2071f);
        this.mask = this.f2070n - 1;
        int[] key = new int[this.f2070n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f2070n + 1];
        this.value = value;
        long[] link = new long[this.f2070n + 1];
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
            int k = s.readInt();
            Object readObject = s.readObject();
            if (k != 0) {
                int mix = HashCommon.mix(k);
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
                pos = this.f2070n;
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
