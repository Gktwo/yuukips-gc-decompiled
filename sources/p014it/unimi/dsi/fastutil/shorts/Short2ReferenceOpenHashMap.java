package p014it.unimi.dsi.fastutil.shorts;

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
import java.util.function.IntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap.class */
public class Short2ReferenceOpenHashMap<V> extends AbstractShort2ReferenceMap<V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient short[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f2960n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2961f;
    protected transient Short2ReferenceMap.FastEntrySet<V> entries;
    protected transient ShortSet keys;
    protected transient ReferenceCollection<V> values;

    public Short2ReferenceOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2961f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2960n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2960n - 1;
            this.maxFill = HashCommon.maxFill(this.f2960n, f);
            this.key = new short[this.f2960n + 1];
            this.value = (V[]) new Object[this.f2960n + 1];
        }
    }

    public Short2ReferenceOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Short2ReferenceOpenHashMap() {
        this(16, 0.75f);
    }

    public Short2ReferenceOpenHashMap(Map<? extends Short, ? extends V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2ReferenceOpenHashMap(Map<? extends Short, ? extends V> m) {
        this(m, 0.75f);
    }

    public Short2ReferenceOpenHashMap(Short2ReferenceMap<V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2ReferenceOpenHashMap(Short2ReferenceMap<V> m) {
        this((Short2ReferenceMap) m, 0.75f);
    }

    public Short2ReferenceOpenHashMap(short[] k, V[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (short) v[i]);
        }
    }

    public Short2ReferenceOpenHashMap(short[] k, V[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2961f);
        if (needed > this.f2960n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2961f)))));
        if (needed > this.f2960n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public V removeEntry(int pos) {
        V oldValue = this.value[pos];
        this.value[pos] = null;
        this.size--;
        shiftKeys(pos);
        if (this.f2960n > this.minN && this.size < this.maxFill / 4 && this.f2960n > 16) {
            rehash(this.f2960n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.f2960n];
        this.value[this.f2960n] = null;
        this.size--;
        if (this.f2960n > this.minN && this.size < this.maxFill / 4 && this.f2960n > 16) {
            rehash(this.f2960n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap, java.util.Map
    public void putAll(Map<? extends Short, ? extends V> m) {
        if (((double) this.f2961f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2960n : -(this.f2960n + 1);
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

    private void insert(int pos, short k, V v) {
        if (pos == this.f2960n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2961f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction
    public V put(short k, V v) {
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
                    this.value[pos] = null;
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
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction
    public V remove(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction
    public V get(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2960n] : (V) this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        short[] key = this.key;
        if (this.containsNullKey && value[this.f2960n] == v) {
            return true;
        }
        int i = this.f2960n;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction
    public V getOrDefault(short k, V defaultValue) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2960n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public V putIfAbsent(short k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public boolean remove(short k, Object v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2960n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public boolean replace(short k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public V replace(short k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public V computeIfAbsent(short k, IntFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        V newValue = (V) mappingFunction.apply(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public V computeIfAbsent(short key, Short2ReferenceFunction<? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public V computeIfPresent(short k, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(Short.valueOf(k), (Object) this.value[pos]);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public V compute(short k, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(Short.valueOf(k), pos >= 0 ? (Object) this.value[pos] : (Object) null);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap
    public V merge(short k, V v, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
            Arrays.fill(this.key, (short) 0);
            Arrays.fill(this.value, (Object) null);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$MapEntry.class */
    public final class MapEntry implements Short2ReferenceMap.Entry<V>, Map.Entry<Short, V>, ShortReferencePair<V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap.Entry
        public short getShortKey() {
            return Short2ReferenceOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortReferencePair
        public short leftShort() {
            return Short2ReferenceOpenHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Short2ReferenceOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Short2ReferenceOpenHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Short2ReferenceOpenHashMap.this.value[this.index];
            Short2ReferenceOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public ShortReferencePair<V> right(V v) {
            Short2ReferenceOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getKey() {
            return Short.valueOf(Short2ReferenceOpenHashMap.this.key[this.index]);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Short, V> e = (Map.Entry) o;
            return Short2ReferenceOpenHashMap.this.key[this.index] == e.getKey().shortValue() && Short2ReferenceOpenHashMap.this.value[this.index] == e.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Short2ReferenceOpenHashMap.this.key[this.index] ^ (Short2ReferenceOpenHashMap.this.value[this.index] == null ? 0 : System.identityHashCode(Short2ReferenceOpenHashMap.this.value[this.index]));
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Short2ReferenceOpenHashMap.this.key[this.index]) + "=>" + Short2ReferenceOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2962c;
        boolean mustReturnNullKey;
        ShortArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Short2ReferenceOpenHashMap.this.f2960n;
            this.last = -1;
            this.f2962c = Short2ReferenceOpenHashMap.this.size;
            this.mustReturnNullKey = Short2ReferenceOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2962c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2962c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Short2ReferenceOpenHashMap.this.f2960n;
                this.last = i;
                return i;
            }
            short[] key = Short2ReferenceOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Short2ReferenceOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k == key[p]) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Short2ReferenceOpenHashMap.this.mask;
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
                int i = Short2ReferenceOpenHashMap.this.f2960n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2962c--;
            }
            short[] key = Short2ReferenceOpenHashMap.this.key;
            while (this.f2962c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Short2ReferenceOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k == key[p]) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Short2ReferenceOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2962c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2962c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            short curr;
            short[] key = Short2ReferenceOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Short2ReferenceOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        Short2ReferenceOpenHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix((int) curr) & Short2ReferenceOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2ReferenceOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2ReferenceOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ShortArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Short2ReferenceOpenHashMap.this.value[pos] = Short2ReferenceOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Short2ReferenceOpenHashMap.this.f2960n) {
                Short2ReferenceOpenHashMap.this.containsNullKey = false;
                Short2ReferenceOpenHashMap.this.value[Short2ReferenceOpenHashMap.this.f2960n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Short2ReferenceOpenHashMap.this.remove(this.wrapped.getShort((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Short2ReferenceOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Short2ReferenceOpenHashMap<V>.MapIterator implements ObjectIterator<Short2ReferenceMap.Entry<V>> {
        private Short2ReferenceOpenHashMap<V>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Short2ReferenceOpenHashMap<V>.MapEntry next() {
            Short2ReferenceOpenHashMap<V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Short2ReferenceMap.Entry<V>> action, int index) {
            Short2ReferenceOpenHashMap<V>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Short2ReferenceOpenHashMap<V>.MapIterator implements ObjectIterator<Short2ReferenceMap.Entry<V>> {
        private final Short2ReferenceOpenHashMap<V>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Short2ReferenceOpenHashMap<V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Short2ReferenceMap.Entry<V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Short2ReferenceOpenHashMap<V>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f2963c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Short2ReferenceOpenHashMap.this.f2960n;
            this.f2963c = 0;
            this.mustReturnNull = Short2ReferenceOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Short2ReferenceOpenHashMap.this.f2960n;
            this.f2963c = 0;
            this.mustReturnNull = Short2ReferenceOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2963c++;
                acceptOnIndex(action, Short2ReferenceOpenHashMap.this.f2960n);
                return true;
            }
            short[] key = Short2ReferenceOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2963c++;
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
                this.f2963c++;
                acceptOnIndex(action, Short2ReferenceOpenHashMap.this.f2960n);
            }
            short[] key = Short2ReferenceOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2963c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Short2ReferenceOpenHashMap.this.size - this.f2963c);
            }
            return Math.min((long) (Short2ReferenceOpenHashMap.this.size - this.f2963c), ((long) ((((double) Short2ReferenceOpenHashMap.this.realSize()) / ((double) Short2ReferenceOpenHashMap.this.f2960n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap r0 = p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.this
                short[] r0 = r0.key
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
                short r0 = r0[r1]
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Short2ReferenceOpenHashMap<V>.MapSpliterator implements ObjectSpliterator<Short2ReferenceMap.Entry<V>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapSpliterator
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

        final void acceptOnIndex(Consumer<? super Short2ReferenceMap.Entry<V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapSpliterator
        public final Short2ReferenceOpenHashMap<V>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Short2ReferenceMap.Entry<V>> implements Short2ReferenceMap.FastEntrySet<V> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Short2ReferenceMap.Entry<V>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap.FastEntrySet
        public ObjectIterator<Short2ReferenceMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2ReferenceMap.Entry<V>> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            short curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            Object value = e.getValue();
            if (k == 0) {
                return Short2ReferenceOpenHashMap.this.containsNullKey && Short2ReferenceOpenHashMap.this.value[Short2ReferenceOpenHashMap.this.f2960n] == value;
            }
            short[] key = Short2ReferenceOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Short2ReferenceOpenHashMap.this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Short2ReferenceOpenHashMap.this.value[pos] == value;
            }
            do {
                int i = (pos + 1) & Short2ReferenceOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Short2ReferenceOpenHashMap.this.value[pos] == value;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            Object value = e.getValue();
            if (k != 0) {
                short[] key = Short2ReferenceOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Short2ReferenceOpenHashMap.this.mask;
                int pos = mix;
                short curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Short2ReferenceOpenHashMap.this.mask;
                        pos = i;
                        short curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Short2ReferenceOpenHashMap.this.value[pos] == value) {
                            Short2ReferenceOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Short2ReferenceOpenHashMap.this.value[pos] != value) {
                    return false;
                } else {
                    Short2ReferenceOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Short2ReferenceOpenHashMap.this.containsNullKey || Short2ReferenceOpenHashMap.this.value[Short2ReferenceOpenHashMap.this.f2960n] != value) {
                return false;
            } else {
                Short2ReferenceOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2ReferenceOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2ReferenceOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2ReferenceMap.Entry<V>> consumer) {
            if (Short2ReferenceOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractShort2ReferenceMap.BasicEntry(Short2ReferenceOpenHashMap.this.key[Short2ReferenceOpenHashMap.this.f2960n], Short2ReferenceOpenHashMap.this.value[Short2ReferenceOpenHashMap.this.f2960n]));
            }
            int pos = Short2ReferenceOpenHashMap.this.f2960n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2ReferenceOpenHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractShort2ReferenceMap.BasicEntry(Short2ReferenceOpenHashMap.this.key[pos], Short2ReferenceOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2ReferenceMap.Entry<V>> consumer) {
            AbstractShort2ReferenceMap.BasicEntry<V> entry = new AbstractShort2ReferenceMap.BasicEntry<>();
            if (Short2ReferenceOpenHashMap.this.containsNullKey) {
                entry.key = Short2ReferenceOpenHashMap.this.key[Short2ReferenceOpenHashMap.this.f2960n];
                entry.value = Short2ReferenceOpenHashMap.this.value[Short2ReferenceOpenHashMap.this.f2960n];
                consumer.accept(entry);
            }
            int pos = Short2ReferenceOpenHashMap.this.f2960n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2ReferenceOpenHashMap.this.key[pos] != 0) {
                    entry.key = Short2ReferenceOpenHashMap.this.key[pos];
                    entry.value = Short2ReferenceOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
    public Short2ReferenceMap.FastEntrySet<V> short2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Short2ReferenceOpenHashMap<V>.MapIterator implements ShortIterator {
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ShortConsumer shortConsumer) {
            forEachRemaining((KeyIterator) shortConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2ReferenceOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Short2ReferenceOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Short2ReferenceOpenHashMap<V>.MapSpliterator implements ShortSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;

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
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2ReferenceOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapSpliterator
        public final Short2ReferenceOpenHashMap<V>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractShortSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer consumer) {
            if (Short2ReferenceOpenHashMap.this.containsNullKey) {
                consumer.accept(Short2ReferenceOpenHashMap.this.key[Short2ReferenceOpenHashMap.this.f2960n]);
            }
            int pos = Short2ReferenceOpenHashMap.this.f2960n;
            while (true) {
                pos--;
                if (pos != 0) {
                    short k = Short2ReferenceOpenHashMap.this.key[pos];
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
            return Short2ReferenceOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2ReferenceOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldSize = Short2ReferenceOpenHashMap.this.size;
            Short2ReferenceOpenHashMap.this.remove(k);
            return Short2ReferenceOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2ReferenceOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
    public Set<Short> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Short2ReferenceOpenHashMap<V>.MapIterator implements ObjectIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapIterator
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
            action.accept((Object) Short2ReferenceOpenHashMap.this.value[index]);
        }

        @Override // java.util.Iterator
        public V next() {
            return Short2ReferenceOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceOpenHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Short2ReferenceOpenHashMap<V>.MapSpliterator implements ObjectSpliterator<V> {
        private static final int POST_SPLIT_CHARACTERISTICS = 0;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapSpliterator
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
            action.accept((Object) Short2ReferenceOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.MapSpliterator
        public final Short2ReferenceOpenHashMap<V>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ReferenceOpenHashMap.1
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
                    if (Short2ReferenceOpenHashMap.this.containsNullKey) {
                        consumer.accept((Object) Short2ReferenceOpenHashMap.this.value[Short2ReferenceOpenHashMap.this.f2960n]);
                    }
                    int pos = Short2ReferenceOpenHashMap.this.f2960n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Short2ReferenceOpenHashMap.this.key[pos] != 0) {
                            consumer.accept((Object) Short2ReferenceOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Short2ReferenceOpenHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Short2ReferenceOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Short2ReferenceOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2961f)));
        if (l >= this.f2960n || this.size > HashCommon.maxFill(l, this.f2961f)) {
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
        short[] key = this.key;
        V[] value = this.value;
        int mask = newN - 1;
        short[] newKey = new short[newN + 1];
        V[] newValue = (V[]) new Object[newN + 1];
        int i2 = this.f2960n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == 0);
                int mix = HashCommon.mix((int) key[i2]) & mask;
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
                newValue[newN] = value[this.f2960n];
                this.f2960n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2960n, this.f2961f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Short2ReferenceOpenHashMap<V> clone() {
        try {
            Short2ReferenceOpenHashMap<V> c = (Short2ReferenceOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (short[]) this.key.clone();
            c.value = (V[]) ((Object[]) this.value.clone());
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x004f */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2 */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap, java.lang.Object, java.util.Map
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
            short t = this.key[i];
            if (this != this.value[i]) {
                t ^= this.value[i] == null ? 0 : System.identityHashCode(this.value[i]);
            }
            h += t == true ? 1 : 0;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2960n] == null ? 0 : System.identityHashCode(this.value[this.f2960n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        short[] key = this.key;
        V[] value = this.value;
        Short2ReferenceOpenHashMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeShort(key[e]);
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
        this.f2960n = HashCommon.arraySize(this.size, this.f2961f);
        this.maxFill = HashCommon.maxFill(this.f2960n, this.f2961f);
        this.mask = this.f2960n - 1;
        short[] key = new short[this.f2960n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f2960n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                short k = s.readShort();
                Object readObject = s.readObject();
                if (k == 0) {
                    pos = this.f2960n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix((int) k);
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
