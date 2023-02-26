package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap.class */
public class Reference2ReferenceOpenCustomHashMap<K, V> extends AbstractReference2ReferenceMap<K, V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected Hash.Strategy<? super K> strategy;

    /* renamed from: n */
    protected transient int f2777n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2778f;
    protected transient Reference2ReferenceMap.FastEntrySet<K, V> entries;
    protected transient ReferenceSet<K> keys;
    protected transient ReferenceCollection<V> values;

    public Reference2ReferenceOpenCustomHashMap(int expected, float f, Hash.Strategy<? super K> strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2778f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2777n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2777n - 1;
            this.maxFill = HashCommon.maxFill(this.f2777n, f);
            this.key = (K[]) new Object[this.f2777n + 1];
            this.value = (V[]) new Object[this.f2777n + 1];
        }
    }

    public Reference2ReferenceOpenCustomHashMap(int expected, Hash.Strategy<? super K> strategy) {
        this(expected, 0.75f, strategy);
    }

    public Reference2ReferenceOpenCustomHashMap(Hash.Strategy<? super K> strategy) {
        this(16, 0.75f, strategy);
    }

    public Reference2ReferenceOpenCustomHashMap(Map<? extends K, ? extends V> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Reference2ReferenceOpenCustomHashMap(Map<? extends K, ? extends V> m, Hash.Strategy<? super K> strategy) {
        this(m, 0.75f, strategy);
    }

    public Reference2ReferenceOpenCustomHashMap(Reference2ReferenceMap<K, V> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Reference2ReferenceOpenCustomHashMap(Reference2ReferenceMap<K, V> m, Hash.Strategy<? super K> strategy) {
        this((Reference2ReferenceMap) m, 0.75f, (Hash.Strategy) strategy);
    }

    public Reference2ReferenceOpenCustomHashMap(K[] k, V[] v, float f, Hash.Strategy<? super K> strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Reference2ReferenceOpenCustomHashMap(K[] k, V[] v, Hash.Strategy<? super K> strategy) {
        this(k, v, 0.75f, strategy);
    }

    public Hash.Strategy<? super K> strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2778f);
        if (needed > this.f2777n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2778f)))));
        if (needed > this.f2777n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public V removeEntry(int pos) {
        V oldValue = this.value[pos];
        this.value[pos] = null;
        this.size--;
        shiftKeys(pos);
        if (this.f2777n > this.minN && this.size < this.maxFill / 4 && this.f2777n > 16) {
            rehash(this.f2777n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2777n] = null;
        V oldValue = this.value[this.f2777n];
        this.value[this.f2777n] = null;
        this.size--;
        if (this.f2777n > this.minN && this.size < this.maxFill / 4 && this.f2777n > 16) {
            rehash(this.f2777n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        if (((double) this.f2778f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.f2777n : -(this.f2777n + 1);
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
        if (pos == this.f2777n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2778f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
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
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V get(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2777n] : (V) this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, p014it.unimi.dsi.fastutil.Function
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2777n] == v) {
            return true;
        }
        int i = this.f2777n;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V getOrDefault(Object k, V defaultValue) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2777n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public boolean remove(Object k, Object v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2777n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public boolean replace(K k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public V replace(K k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
    public V computeIfAbsent(K key, Reference2ReferenceFunction<? super K, ? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
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
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Reference2ReferenceMap.Entry<K, V>, Map.Entry<K, V>, ReferenceReferencePair<K, V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Reference2ReferenceOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Reference2ReferenceOpenCustomHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Reference2ReferenceOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Reference2ReferenceOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Reference2ReferenceOpenCustomHashMap.this.value[this.index];
            Reference2ReferenceOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public ReferenceReferencePair<K, V> right(V v) {
            Reference2ReferenceOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> e = (Map.Entry) o;
            return Reference2ReferenceOpenCustomHashMap.this.strategy.equals((Object) Reference2ReferenceOpenCustomHashMap.this.key[this.index], (Object) e.getKey()) && Reference2ReferenceOpenCustomHashMap.this.value[this.index] == e.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Reference2ReferenceOpenCustomHashMap.this.strategy.hashCode((Object) Reference2ReferenceOpenCustomHashMap.this.key[this.index]) ^ (Reference2ReferenceOpenCustomHashMap.this.value[this.index] == null ? 0 : System.identityHashCode(Reference2ReferenceOpenCustomHashMap.this.value[this.index]));
        }

        @Override // java.lang.Object
        public String toString() {
            return Reference2ReferenceOpenCustomHashMap.this.key[this.index] + "=>" + Reference2ReferenceOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2779c;
        boolean mustReturnNullKey;
        ReferenceArrayList<K> wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Reference2ReferenceOpenCustomHashMap.this.f2777n;
            this.last = -1;
            this.f2779c = Reference2ReferenceOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Reference2ReferenceOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2779c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2779c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Reference2ReferenceOpenCustomHashMap.this.f2777n;
                this.last = i;
                return i;
            }
            K[] key = Reference2ReferenceOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(Reference2ReferenceOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Reference2ReferenceOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Reference2ReferenceOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Reference2ReferenceOpenCustomHashMap.this.mask;
                    }
                }
            } while (key[this.pos] == null);
            int i4 = this.pos;
            this.last = i4;
            return i4;
        }

        public void forEachRemaining(ConsumerType action) {
            int p;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Reference2ReferenceOpenCustomHashMap.this.f2777n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2779c--;
            }
            K[] key = Reference2ReferenceOpenCustomHashMap.this.key;
            while (this.f2779c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(Reference2ReferenceOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Reference2ReferenceOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Reference2ReferenceOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Reference2ReferenceOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2779c--;
                } else if (key[this.pos] != null) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2779c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            K curr;
            K[] key = Reference2ReferenceOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Reference2ReferenceOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        Reference2ReferenceOpenCustomHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(Reference2ReferenceOpenCustomHashMap.this.strategy.hashCode(curr)) & Reference2ReferenceOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Reference2ReferenceOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Reference2ReferenceOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ReferenceArrayList<>(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Reference2ReferenceOpenCustomHashMap.this.value[pos] = Reference2ReferenceOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Reference2ReferenceOpenCustomHashMap.this.f2777n) {
                Reference2ReferenceOpenCustomHashMap.this.containsNullKey = false;
                Reference2ReferenceOpenCustomHashMap.this.key[Reference2ReferenceOpenCustomHashMap.this.f2777n] = null;
                Reference2ReferenceOpenCustomHashMap.this.value[Reference2ReferenceOpenCustomHashMap.this.f2777n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Reference2ReferenceOpenCustomHashMap.this.remove(this.wrapped.set((-this.pos) - 1, null));
                this.last = -1;
                return;
            }
            Reference2ReferenceOpenCustomHashMap.this.size--;
            this.last = -1;
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
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends Reference2ReferenceOpenCustomHashMap<K, V>.MapIterator implements ObjectIterator<Reference2ReferenceMap.Entry<K, V>> {
        private Reference2ReferenceOpenCustomHashMap<K, V>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Reference2ReferenceOpenCustomHashMap<K, V>.MapEntry next() {
            Reference2ReferenceOpenCustomHashMap<K, V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Reference2ReferenceMap.Entry<K, V>> action, int index) {
            Reference2ReferenceOpenCustomHashMap<K, V>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Reference2ReferenceOpenCustomHashMap<K, V>.MapIterator implements ObjectIterator<Reference2ReferenceMap.Entry<K, V>> {
        private final Reference2ReferenceOpenCustomHashMap<K, V>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Reference2ReferenceOpenCustomHashMap<K, V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Reference2ReferenceMap.Entry<K, V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Reference2ReferenceOpenCustomHashMap<K, V>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f2780c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Reference2ReferenceOpenCustomHashMap.this.f2777n;
            this.f2780c = 0;
            this.mustReturnNull = Reference2ReferenceOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Reference2ReferenceOpenCustomHashMap.this.f2777n;
            this.f2780c = 0;
            this.mustReturnNull = Reference2ReferenceOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2780c++;
                acceptOnIndex(action, Reference2ReferenceOpenCustomHashMap.this.f2777n);
                return true;
            }
            K[] key = Reference2ReferenceOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    this.f2780c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    acceptOnIndex(action, i);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        public void forEachRemaining(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2780c++;
                acceptOnIndex(action, Reference2ReferenceOpenCustomHashMap.this.f2777n);
            }
            K[] key = Reference2ReferenceOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    acceptOnIndex(action, this.pos);
                    this.f2780c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Reference2ReferenceOpenCustomHashMap.this.size - this.f2780c);
            }
            return Math.min((long) (Reference2ReferenceOpenCustomHashMap.this.size - this.f2780c), ((long) ((((double) Reference2ReferenceOpenCustomHashMap.this.realSize()) / ((double) Reference2ReferenceOpenCustomHashMap.this.f2777n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public SplitType trySplit() {
            int retLen;
            if (this.pos >= this.max - 1 || (retLen = (this.max - this.pos) >> 1) <= 1) {
                return null;
            }
            int myNewPos = this.pos + retLen;
            SplitType split = makeForSplit(this.pos, myNewPos, this.mustReturnNull);
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
                it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.this
                K[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0076
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0076
                r0 = r11
                r1 = r6
                r2 = r1
                int r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                int r3 = r3 + r4
                r2.pos = r3
                r0 = r0[r1]
                r1 = 0
                if (r0 == r1) goto L_0x0048
                r0 = r9
                r1 = 1
                long r0 = r0 + r1
                r9 = r0
                r0 = r7
                r1 = 1
                long r0 = r0 - r1
                r7 = r0
                goto L_0x0048
            L_0x0076:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Reference2ReferenceOpenCustomHashMap<K, V>.MapSpliterator implements ObjectSpliterator<Reference2ReferenceMap.Entry<K, V>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapSpliterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntrySpliterator) consumer);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return tryAdvance((EntrySpliterator) consumer);
        }

        EntrySpliterator() {
            super();
        }

        EntrySpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            super(pos, max, mustReturnNull, hasSplit);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 1 : 65;
        }

        final void acceptOnIndex(Consumer<? super Reference2ReferenceMap.Entry<K, V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapSpliterator
        public final Reference2ReferenceOpenCustomHashMap<K, V>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Reference2ReferenceMap.Entry<K, V>> implements Reference2ReferenceMap.FastEntrySet<K, V> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Reference2ReferenceMap.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap.FastEntrySet
        public ObjectIterator<Reference2ReferenceMap.Entry<K, V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2ReferenceMap.Entry<K, V>> spliterator() {
            return new EntrySpliterator();
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
            if (Reference2ReferenceOpenCustomHashMap.this.strategy.equals(key, null)) {
                return Reference2ReferenceOpenCustomHashMap.this.containsNullKey && Reference2ReferenceOpenCustomHashMap.this.value[Reference2ReferenceOpenCustomHashMap.this.f2777n] == value;
            }
            K[] key2 = Reference2ReferenceOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Reference2ReferenceOpenCustomHashMap.this.strategy.hashCode(key)) & Reference2ReferenceOpenCustomHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (Reference2ReferenceOpenCustomHashMap.this.strategy.equals(key, curr2)) {
                return Reference2ReferenceOpenCustomHashMap.this.value[pos] == value;
            }
            do {
                int i = (pos + 1) & Reference2ReferenceOpenCustomHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!Reference2ReferenceOpenCustomHashMap.this.strategy.equals(key, curr));
            return Reference2ReferenceOpenCustomHashMap.this.value[pos] == value;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            Object key = e.getKey();
            Object value = e.getValue();
            if (!Reference2ReferenceOpenCustomHashMap.this.strategy.equals(key, null)) {
                K[] key2 = Reference2ReferenceOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Reference2ReferenceOpenCustomHashMap.this.strategy.hashCode(key)) & Reference2ReferenceOpenCustomHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!Reference2ReferenceOpenCustomHashMap.this.strategy.equals(curr, key)) {
                    while (true) {
                        int i = (pos + 1) & Reference2ReferenceOpenCustomHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (Reference2ReferenceOpenCustomHashMap.this.strategy.equals(curr2, key) && Reference2ReferenceOpenCustomHashMap.this.value[pos] == value) {
                            Reference2ReferenceOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Reference2ReferenceOpenCustomHashMap.this.value[pos] != value) {
                    return false;
                } else {
                    Reference2ReferenceOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Reference2ReferenceOpenCustomHashMap.this.containsNullKey || Reference2ReferenceOpenCustomHashMap.this.value[Reference2ReferenceOpenCustomHashMap.this.f2777n] != value) {
                return false;
            } else {
                Reference2ReferenceOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2ReferenceOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2ReferenceOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2ReferenceMap.Entry<K, V>> consumer) {
            if (Reference2ReferenceOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractReference2ReferenceMap.BasicEntry(Reference2ReferenceOpenCustomHashMap.this.key[Reference2ReferenceOpenCustomHashMap.this.f2777n], Reference2ReferenceOpenCustomHashMap.this.value[Reference2ReferenceOpenCustomHashMap.this.f2777n]));
            }
            int pos = Reference2ReferenceOpenCustomHashMap.this.f2777n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Reference2ReferenceOpenCustomHashMap.this.key[pos] != null) {
                    consumer.accept(new AbstractReference2ReferenceMap.BasicEntry(Reference2ReferenceOpenCustomHashMap.this.key[pos], Reference2ReferenceOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2ReferenceMap.Entry<K, V>> consumer) {
            AbstractReference2ReferenceMap.BasicEntry<K, V> entry = new AbstractReference2ReferenceMap.BasicEntry<>();
            if (Reference2ReferenceOpenCustomHashMap.this.containsNullKey) {
                entry.key = Reference2ReferenceOpenCustomHashMap.this.key[Reference2ReferenceOpenCustomHashMap.this.f2777n];
                entry.value = Reference2ReferenceOpenCustomHashMap.this.value[Reference2ReferenceOpenCustomHashMap.this.f2777n];
                consumer.accept(entry);
            }
            int pos = Reference2ReferenceOpenCustomHashMap.this.f2777n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Reference2ReferenceOpenCustomHashMap.this.key[pos] != null) {
                    entry.key = Reference2ReferenceOpenCustomHashMap.this.key[pos];
                    entry.value = Reference2ReferenceOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
    public Reference2ReferenceMap.FastEntrySet<K, V> reference2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends Reference2ReferenceOpenCustomHashMap<K, V>.MapIterator implements ObjectIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((KeyIterator) consumer);
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Reference2ReferenceOpenCustomHashMap.this.key[index]);
        }

        @Override // java.util.Iterator
        public K next() {
            return Reference2ReferenceOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Reference2ReferenceOpenCustomHashMap<K, V>.MapSpliterator implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapSpliterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((KeySpliterator) consumer);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return tryAdvance((KeySpliterator) consumer);
        }

        KeySpliterator() {
            super();
        }

        KeySpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            super(pos, max, mustReturnNull, hasSplit);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 1 : 65;
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Reference2ReferenceOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapSpliterator
        public final Reference2ReferenceOpenCustomHashMap<K, V>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$KeySet.class */
    public final class KeySet extends AbstractReferenceSet<K> {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new KeySpliterator();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            if (Reference2ReferenceOpenCustomHashMap.this.containsNullKey) {
                consumer.accept((Object) Reference2ReferenceOpenCustomHashMap.this.key[Reference2ReferenceOpenCustomHashMap.this.f2777n]);
            }
            int pos = Reference2ReferenceOpenCustomHashMap.this.f2777n;
            while (true) {
                pos--;
                if (pos != 0) {
                    Object obj = (Object) Reference2ReferenceOpenCustomHashMap.this.key[pos];
                    if (obj != 0) {
                        consumer.accept(obj);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2ReferenceOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2ReferenceOpenCustomHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Reference2ReferenceOpenCustomHashMap.this.size;
            Reference2ReferenceOpenCustomHashMap.this.remove(k);
            return Reference2ReferenceOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2ReferenceOpenCustomHashMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public ReferenceSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends Reference2ReferenceOpenCustomHashMap<K, V>.MapIterator implements ObjectIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((ValueIterator) consumer);
        }

        public ValueIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super V> action, int index) {
            action.accept((Object) Reference2ReferenceOpenCustomHashMap.this.value[index]);
        }

        @Override // java.util.Iterator
        public V next() {
            return Reference2ReferenceOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Reference2ReferenceOpenCustomHashMap<K, V>.MapSpliterator implements ObjectSpliterator<V> {
        private static final int POST_SPLIT_CHARACTERISTICS = 0;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapSpliterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((ValueSpliterator) consumer);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return tryAdvance((ValueSpliterator) consumer);
        }

        ValueSpliterator() {
            super();
        }

        ValueSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            super(pos, max, mustReturnNull, hasSplit);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 0 : 64;
        }

        final void acceptOnIndex(Consumer<? super V> action, int index) {
            action.accept((Object) Reference2ReferenceOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.MapSpliterator
        public final Reference2ReferenceOpenCustomHashMap<K, V>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenCustomHashMap.1
                @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return new ValueSpliterator();
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    if (Reference2ReferenceOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept((Object) Reference2ReferenceOpenCustomHashMap.this.value[Reference2ReferenceOpenCustomHashMap.this.f2777n]);
                    }
                    int pos = Reference2ReferenceOpenCustomHashMap.this.f2777n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Reference2ReferenceOpenCustomHashMap.this.key[pos] != null) {
                            consumer.accept((Object) Reference2ReferenceOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Reference2ReferenceOpenCustomHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Reference2ReferenceOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Reference2ReferenceOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2778f)));
        if (l >= this.f2777n || this.size > HashCommon.maxFill(l, this.f2778f)) {
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
        K[] key = this.key;
        V[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        V[] newValue = (V[]) new Object[newN + 1];
        int i2 = this.f2777n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == null);
                int mix = HashCommon.mix(this.strategy.hashCode(key[i2])) & mask;
                int pos = mix;
                if (newKey[mix] != null) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (newKey[i] != null);
                }
                newKey[pos] = key[i2];
                newValue[pos] = value[i2];
            } else {
                newValue[newN] = value[this.f2777n];
                this.f2777n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2777n, this.f2778f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Reference2ReferenceOpenCustomHashMap<K, V> clone() {
        try {
            Reference2ReferenceOpenCustomHashMap<K, V> c = (Reference2ReferenceOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (V[]) ((Object[]) this.value.clone());
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap, java.lang.Object, java.util.Map
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
                t ^= this.value[i] == null ? 0 : System.identityHashCode(this.value[i]);
            }
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2777n] == null ? 0 : System.identityHashCode(this.value[this.f2777n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        V[] value = this.value;
        Reference2ReferenceOpenCustomHashMap<K, V>.EntryIterator i = new EntryIterator();
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
    /* JADX DEBUG: Multi-variable search result rejected for r0v27, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2777n = HashCommon.arraySize(this.size, this.f2778f);
        this.maxFill = HashCommon.maxFill(this.f2777n, this.f2778f);
        this.mask = this.f2777n - 1;
        K[] key = (K[]) new Object[this.f2777n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f2777n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                Object readObject = s.readObject();
                Object readObject2 = s.readObject();
                if (this.strategy.equals(readObject, null)) {
                    pos = this.f2777n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(this.strategy.hashCode(readObject));
                    int i2 = this.mask;
                    while (true) {
                        pos = mix & i2;
                        if (key[pos] != 0) {
                            mix = pos + 1;
                            i2 = this.mask;
                        }
                    }
                }
                key[pos] = readObject;
                value[pos] = readObject2;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
