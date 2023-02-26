package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap;
import p014it.unimi.dsi.fastutil.ints.IntHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap.class */
public class Int2ReferenceOpenCustomHashMap<V> extends AbstractInt2ReferenceMap<V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient int[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected IntHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f2084n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2085f;
    protected transient Int2ReferenceMap.FastEntrySet<V> entries;
    protected transient IntSet keys;
    protected transient ReferenceCollection<V> values;

    public Int2ReferenceOpenCustomHashMap(int expected, float f, IntHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2085f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2084n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2084n - 1;
            this.maxFill = HashCommon.maxFill(this.f2084n, f);
            this.key = new int[this.f2084n + 1];
            this.value = (V[]) new Object[this.f2084n + 1];
        }
    }

    public Int2ReferenceOpenCustomHashMap(int expected, IntHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Int2ReferenceOpenCustomHashMap(IntHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Int2ReferenceOpenCustomHashMap(Map<? extends Integer, ? extends V> m, float f, IntHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Int2ReferenceOpenCustomHashMap(Map<? extends Integer, ? extends V> m, IntHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Int2ReferenceOpenCustomHashMap(Int2ReferenceMap<V> m, float f, IntHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Int2ReferenceOpenCustomHashMap(Int2ReferenceMap<V> m, IntHash.Strategy strategy) {
        this((Int2ReferenceMap) m, 0.75f, strategy);
    }

    public Int2ReferenceOpenCustomHashMap(int[] k, V[] v, float f, IntHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (int) v[i]);
        }
    }

    public Int2ReferenceOpenCustomHashMap(int[] k, V[] v, IntHash.Strategy strategy) {
        this(k, v, 0.75f, strategy);
    }

    public IntHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2085f);
        if (needed > this.f2084n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2085f)))));
        if (needed > this.f2084n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public V removeEntry(int pos) {
        V oldValue = this.value[pos];
        this.value[pos] = null;
        this.size--;
        shiftKeys(pos);
        if (this.f2084n > this.minN && this.size < this.maxFill / 4 && this.f2084n > 16) {
            rehash(this.f2084n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.f2084n];
        this.value[this.f2084n] = null;
        this.size--;
        if (this.f2084n > this.minN && this.size < this.maxFill / 4 && this.f2084n > 16) {
            rehash(this.f2084n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, java.util.Map
    public void putAll(Map<? extends Integer, ? extends V> m) {
        if (((double) this.f2085f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(int k) {
        int curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.f2084n : -(this.f2084n + 1);
        }
        int[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return -(pos + 1);
        }
        if (this.strategy.equals(k, curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return -(pos + 1);
            }
        } while (!this.strategy.equals(k, curr));
        return pos;
    }

    private void insert(int pos, int k, V v) {
        if (pos == this.f2084n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2085f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public V remove(int k) {
        int curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public V get(int k) {
        int curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2084n] : (V) this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public boolean containsKey(int k) {
        int curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        int[] key = this.key;
        if (this.containsNullKey && value[this.f2084n] == v) {
            return true;
        }
        int i = this.f2084n;
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public V getOrDefault(int k, V defaultValue) {
        int curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2084n] : defaultValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return defaultValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return defaultValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public V putIfAbsent(int k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public boolean remove(int k, Object v) {
        if (!this.strategy.equals(k, 0)) {
            int[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            int curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    int curr2 = key[i];
                    if (curr2 == 0) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2084n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public boolean replace(int k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public V replace(int k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public V computeIfAbsent(int key, Int2ReferenceFunction<? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public V computeIfPresent(int k, BiFunction<? super Integer, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(Integer.valueOf(k), (Object) this.value[pos]);
            if (newValue == null) {
                if (this.strategy.equals(k, 0)) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
    public V compute(int k, BiFunction<? super Integer, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(Integer.valueOf(k), pos >= 0 ? (Object) this.value[pos] : (Object) null);
        if (newValue == null) {
            if (pos >= 0) {
                if (this.strategy.equals(k, 0)) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap
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
            if (this.strategy.equals(k, 0)) {
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
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Int2ReferenceMap.Entry<V>, Map.Entry<Integer, V>, IntReferencePair<V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap.Entry
        public int getIntKey() {
            return Int2ReferenceOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntReferencePair
        public int leftInt() {
            return Int2ReferenceOpenCustomHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Int2ReferenceOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Int2ReferenceOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Int2ReferenceOpenCustomHashMap.this.value[this.index];
            Int2ReferenceOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public IntReferencePair<V> right(V v) {
            Int2ReferenceOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap.Entry, java.util.Map.Entry
        @Deprecated
        public Integer getKey() {
            return Integer.valueOf(Int2ReferenceOpenCustomHashMap.this.key[this.index]);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Integer, V> e = (Map.Entry) o;
            return Int2ReferenceOpenCustomHashMap.this.strategy.equals(Int2ReferenceOpenCustomHashMap.this.key[this.index], e.getKey().intValue()) && Int2ReferenceOpenCustomHashMap.this.value[this.index] == e.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Int2ReferenceOpenCustomHashMap.this.strategy.hashCode(Int2ReferenceOpenCustomHashMap.this.key[this.index]) ^ (Int2ReferenceOpenCustomHashMap.this.value[this.index] == null ? 0 : System.identityHashCode(Int2ReferenceOpenCustomHashMap.this.value[this.index]));
        }

        @Override // java.lang.Object
        public String toString() {
            return Int2ReferenceOpenCustomHashMap.this.key[this.index] + "=>" + Int2ReferenceOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2086c;
        boolean mustReturnNullKey;
        IntArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Int2ReferenceOpenCustomHashMap.this.f2084n;
            this.last = -1;
            this.f2086c = Int2ReferenceOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Int2ReferenceOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2086c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2086c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Int2ReferenceOpenCustomHashMap.this.f2084n;
                this.last = i;
                return i;
            }
            int[] key = Int2ReferenceOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    int k = this.wrapped.getInt((-this.pos) - 1);
                    int mix = HashCommon.mix(Int2ReferenceOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Int2ReferenceOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Int2ReferenceOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Int2ReferenceOpenCustomHashMap.this.mask;
                    }
                }
            } while (key[this.pos] == 0);
            int i4 = this.pos;
            this.last = i4;
            return i4;
        }

        public void forEachRemaining(ConsumerType action) {
            int p;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Int2ReferenceOpenCustomHashMap.this.f2084n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2086c--;
            }
            int[] key = Int2ReferenceOpenCustomHashMap.this.key;
            while (this.f2086c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    int k = this.wrapped.getInt((-this.pos) - 1);
                    int mix = HashCommon.mix(Int2ReferenceOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Int2ReferenceOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Int2ReferenceOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Int2ReferenceOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2086c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2086c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            int curr;
            int[] key = Int2ReferenceOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Int2ReferenceOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        Int2ReferenceOpenCustomHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(Int2ReferenceOpenCustomHashMap.this.strategy.hashCode(curr)) & Int2ReferenceOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Int2ReferenceOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Int2ReferenceOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new IntArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Int2ReferenceOpenCustomHashMap.this.value[pos] = Int2ReferenceOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Int2ReferenceOpenCustomHashMap.this.f2084n) {
                Int2ReferenceOpenCustomHashMap.this.containsNullKey = false;
                Int2ReferenceOpenCustomHashMap.this.value[Int2ReferenceOpenCustomHashMap.this.f2084n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Int2ReferenceOpenCustomHashMap.this.remove(this.wrapped.getInt((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Int2ReferenceOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends Int2ReferenceOpenCustomHashMap<V>.MapIterator implements ObjectIterator<Int2ReferenceMap.Entry<V>> {
        private Int2ReferenceOpenCustomHashMap<V>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Int2ReferenceOpenCustomHashMap<V>.MapEntry next() {
            Int2ReferenceOpenCustomHashMap<V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Int2ReferenceMap.Entry<V>> action, int index) {
            Int2ReferenceOpenCustomHashMap<V>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Int2ReferenceOpenCustomHashMap<V>.MapIterator implements ObjectIterator<Int2ReferenceMap.Entry<V>> {
        private final Int2ReferenceOpenCustomHashMap<V>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Int2ReferenceOpenCustomHashMap<V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Int2ReferenceMap.Entry<V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Int2ReferenceOpenCustomHashMap<V>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f2087c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Int2ReferenceOpenCustomHashMap.this.f2084n;
            this.f2087c = 0;
            this.mustReturnNull = Int2ReferenceOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Int2ReferenceOpenCustomHashMap.this.f2084n;
            this.f2087c = 0;
            this.mustReturnNull = Int2ReferenceOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2087c++;
                acceptOnIndex(action, Int2ReferenceOpenCustomHashMap.this.f2084n);
                return true;
            }
            int[] key = Int2ReferenceOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2087c++;
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
                this.f2087c++;
                acceptOnIndex(action, Int2ReferenceOpenCustomHashMap.this.f2084n);
            }
            int[] key = Int2ReferenceOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2087c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Int2ReferenceOpenCustomHashMap.this.size - this.f2087c);
            }
            return Math.min((long) (Int2ReferenceOpenCustomHashMap.this.size - this.f2087c), ((long) ((((double) Int2ReferenceOpenCustomHashMap.this.realSize()) / ((double) Int2ReferenceOpenCustomHashMap.this.f2084n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Int2ReferenceOpenCustomHashMap<V>.MapSpliterator implements ObjectSpliterator<Int2ReferenceMap.Entry<V>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapSpliterator
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

        final void acceptOnIndex(Consumer<? super Int2ReferenceMap.Entry<V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapSpliterator
        public final Int2ReferenceOpenCustomHashMap<V>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Int2ReferenceMap.Entry<V>> implements Int2ReferenceMap.FastEntrySet<V> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Int2ReferenceMap.Entry<V>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap.FastEntrySet
        public ObjectIterator<Int2ReferenceMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2ReferenceMap.Entry<V>> spliterator() {
            return new EntrySpliterator();
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
            if (Int2ReferenceOpenCustomHashMap.this.strategy.equals(k, 0)) {
                return Int2ReferenceOpenCustomHashMap.this.containsNullKey && Int2ReferenceOpenCustomHashMap.this.value[Int2ReferenceOpenCustomHashMap.this.f2084n] == value;
            }
            int[] key = Int2ReferenceOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Int2ReferenceOpenCustomHashMap.this.strategy.hashCode(k)) & Int2ReferenceOpenCustomHashMap.this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (Int2ReferenceOpenCustomHashMap.this.strategy.equals(k, curr2)) {
                return Int2ReferenceOpenCustomHashMap.this.value[pos] == value;
            }
            do {
                int i = (pos + 1) & Int2ReferenceOpenCustomHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (!Int2ReferenceOpenCustomHashMap.this.strategy.equals(k, curr));
            return Int2ReferenceOpenCustomHashMap.this.value[pos] == value;
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
            if (!Int2ReferenceOpenCustomHashMap.this.strategy.equals(k, 0)) {
                int[] key = Int2ReferenceOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Int2ReferenceOpenCustomHashMap.this.strategy.hashCode(k)) & Int2ReferenceOpenCustomHashMap.this.mask;
                int pos = mix;
                int curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (!Int2ReferenceOpenCustomHashMap.this.strategy.equals(curr, k)) {
                    while (true) {
                        int i = (pos + 1) & Int2ReferenceOpenCustomHashMap.this.mask;
                        pos = i;
                        int curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (Int2ReferenceOpenCustomHashMap.this.strategy.equals(curr2, k) && Int2ReferenceOpenCustomHashMap.this.value[pos] == value) {
                            Int2ReferenceOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Int2ReferenceOpenCustomHashMap.this.value[pos] != value) {
                    return false;
                } else {
                    Int2ReferenceOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Int2ReferenceOpenCustomHashMap.this.containsNullKey || Int2ReferenceOpenCustomHashMap.this.value[Int2ReferenceOpenCustomHashMap.this.f2084n] != value) {
                return false;
            } else {
                Int2ReferenceOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ReferenceOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ReferenceOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2ReferenceMap.Entry<V>> consumer) {
            if (Int2ReferenceOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractInt2ReferenceMap.BasicEntry(Int2ReferenceOpenCustomHashMap.this.key[Int2ReferenceOpenCustomHashMap.this.f2084n], Int2ReferenceOpenCustomHashMap.this.value[Int2ReferenceOpenCustomHashMap.this.f2084n]));
            }
            int pos = Int2ReferenceOpenCustomHashMap.this.f2084n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Int2ReferenceOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractInt2ReferenceMap.BasicEntry(Int2ReferenceOpenCustomHashMap.this.key[pos], Int2ReferenceOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2ReferenceMap.Entry<V>> consumer) {
            AbstractInt2ReferenceMap.BasicEntry<V> entry = new AbstractInt2ReferenceMap.BasicEntry<>();
            if (Int2ReferenceOpenCustomHashMap.this.containsNullKey) {
                entry.key = Int2ReferenceOpenCustomHashMap.this.key[Int2ReferenceOpenCustomHashMap.this.f2084n];
                entry.value = Int2ReferenceOpenCustomHashMap.this.value[Int2ReferenceOpenCustomHashMap.this.f2084n];
                consumer.accept(entry);
            }
            int pos = Int2ReferenceOpenCustomHashMap.this.f2084n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Int2ReferenceOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Int2ReferenceOpenCustomHashMap.this.key[pos];
                    entry.value = Int2ReferenceOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
    public Int2ReferenceMap.FastEntrySet<V> int2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends Int2ReferenceOpenCustomHashMap<V>.MapIterator implements IntIterator {
        @Override // java.util.PrimitiveIterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            forEachRemaining((KeyIterator) intConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(IntConsumer action, int index) {
            action.accept(Int2ReferenceOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return Int2ReferenceOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Int2ReferenceOpenCustomHashMap<V>.MapSpliterator implements IntSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;

        @Override // java.util.Spliterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            forEachRemaining((KeySpliterator) intConsumer);
        }

        @Override // java.util.Spliterator.OfInt
        public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
            return tryAdvance((KeySpliterator) intConsumer);
        }

        KeySpliterator() {
            super();
        }

        KeySpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            super(pos, max, mustReturnNull, hasSplit);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 257 : 321;
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(IntConsumer action, int index) {
            action.accept(Int2ReferenceOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapSpliterator
        public final Int2ReferenceOpenCustomHashMap<V>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$KeySet.class */
    public final class KeySet extends AbstractIntSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer consumer) {
            if (Int2ReferenceOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Int2ReferenceOpenCustomHashMap.this.key[Int2ReferenceOpenCustomHashMap.this.f2084n]);
            }
            int pos = Int2ReferenceOpenCustomHashMap.this.f2084n;
            while (true) {
                pos--;
                if (pos != 0) {
                    int k = Int2ReferenceOpenCustomHashMap.this.key[pos];
                    if (k != 0) {
                        consumer.accept(k);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ReferenceOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2ReferenceOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldSize = Int2ReferenceOpenCustomHashMap.this.size;
            Int2ReferenceOpenCustomHashMap.this.remove(k);
            return Int2ReferenceOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ReferenceOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
    public Set<Integer> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends Int2ReferenceOpenCustomHashMap<V>.MapIterator implements ObjectIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapIterator
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
            action.accept((Object) Int2ReferenceOpenCustomHashMap.this.value[index]);
        }

        @Override // java.util.Iterator
        public V next() {
            return Int2ReferenceOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Int2ReferenceOpenCustomHashMap<V>.MapSpliterator implements ObjectSpliterator<V> {
        private static final int POST_SPLIT_CHARACTERISTICS = 0;

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapSpliterator
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
            action.accept((Object) Int2ReferenceOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.MapSpliterator
        public final Int2ReferenceOpenCustomHashMap<V>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.ints.Int2ReferenceOpenCustomHashMap.1
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
                    if (Int2ReferenceOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept((Object) Int2ReferenceOpenCustomHashMap.this.value[Int2ReferenceOpenCustomHashMap.this.f2084n]);
                    }
                    int pos = Int2ReferenceOpenCustomHashMap.this.f2084n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Int2ReferenceOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept((Object) Int2ReferenceOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Int2ReferenceOpenCustomHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Int2ReferenceOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Int2ReferenceOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2085f)));
        if (l >= this.f2084n || this.size > HashCommon.maxFill(l, this.f2085f)) {
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
        V[] value = this.value;
        int mask = newN - 1;
        int[] newKey = new int[newN + 1];
        V[] newValue = (V[]) new Object[newN + 1];
        int i2 = this.f2084n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == 0);
                int mix = HashCommon.mix(this.strategy.hashCode(key[i2])) & mask;
                int pos = mix;
                if (newKey[mix] != 0) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (newKey[i] != 0);
                }
                newKey[pos] = key[i2];
                newValue[pos] = value[i2];
            } else {
                newValue[newN] = value[this.f2084n];
                this.f2084n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2084n, this.f2085f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Int2ReferenceOpenCustomHashMap<V> clone() {
        try {
            Int2ReferenceOpenCustomHashMap<V> c = (Int2ReferenceOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (int[]) this.key.clone();
            c.value = (V[]) ((Object[]) this.value.clone());
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap, java.lang.Object, java.util.Map
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
            int t = this.strategy.hashCode(this.key[i]);
            if (this != this.value[i]) {
                t ^= this.value[i] == null ? 0 : System.identityHashCode(this.value[i]);
            }
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2084n] == null ? 0 : System.identityHashCode(this.value[this.f2084n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int[] key = this.key;
        V[] value = this.value;
        Int2ReferenceOpenCustomHashMap<V>.EntryIterator i = new EntryIterator();
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
        this.f2084n = HashCommon.arraySize(this.size, this.f2085f);
        this.maxFill = HashCommon.maxFill(this.f2084n, this.f2085f);
        this.mask = this.f2084n - 1;
        int[] key = new int[this.f2084n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f2084n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                int k = s.readInt();
                Object readObject = s.readObject();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f2084n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(this.strategy.hashCode(k));
                    int i2 = this.mask;
                    while (true) {
                        pos = mix & i2;
                        if (key[pos] != 0) {
                            mix = pos + 1;
                            i2 = this.mask;
                        }
                    }
                }
                key[pos] = k;
                value[pos] = readObject;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
