package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ShortMap;
import p014it.unimi.dsi.fastutil.shorts.ShortHash;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap.class */
public class Short2ShortOpenCustomHashMap extends AbstractShort2ShortMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient short[] key;
    protected transient short[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected ShortHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f2968n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2969f;
    protected transient Short2ShortMap.FastEntrySet entries;
    protected transient ShortSet keys;
    protected transient ShortCollection values;

    public Short2ShortOpenCustomHashMap(int expected, float f, ShortHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2969f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2968n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2968n - 1;
            this.maxFill = HashCommon.maxFill(this.f2968n, f);
            this.key = new short[this.f2968n + 1];
            this.value = new short[this.f2968n + 1];
        }
    }

    public Short2ShortOpenCustomHashMap(int expected, ShortHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Short2ShortOpenCustomHashMap(ShortHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Short2ShortOpenCustomHashMap(Map<? extends Short, ? extends Short> m, float f, ShortHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Short2ShortOpenCustomHashMap(Map<? extends Short, ? extends Short> m, ShortHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Short2ShortOpenCustomHashMap(Short2ShortMap m, float f, ShortHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Short2ShortOpenCustomHashMap(Short2ShortMap m, ShortHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Short2ShortOpenCustomHashMap(short[] k, short[] v, float f, ShortHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Short2ShortOpenCustomHashMap(short[] k, short[] v, ShortHash.Strategy strategy) {
        this(k, v, 0.75f, strategy);
    }

    public ShortHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2969f);
        if (needed > this.f2968n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2969f)))));
        if (needed > this.f2968n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public short removeEntry(int pos) {
        short oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2968n > this.minN && this.size < this.maxFill / 4 && this.f2968n > 16) {
            rehash(this.f2968n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public short removeNullEntry() {
        this.containsNullKey = false;
        short oldValue = this.value[this.f2968n];
        this.size--;
        if (this.f2968n > this.minN && this.size < this.maxFill / 4 && this.f2968n > 16) {
            rehash(this.f2968n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap, java.util.Map
    public void putAll(Map<? extends Short, ? extends Short> m) {
        if (((double) this.f2969f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(short k) {
        short curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.f2968n : -(this.f2968n + 1);
        }
        short[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    private void insert(int pos, short k, short v) {
        if (pos == this.f2968n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2969f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    public short put(short k, short v) {
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

    public short addTo(short k, short incr) {
        int pos;
        short curr;
        if (!this.strategy.equals(k, 0)) {
            short[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            short curr2 = key[mix];
            if (curr2 != 0) {
                if (this.strategy.equals(curr2, k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (!this.strategy.equals(curr, k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2968n, incr);
        } else {
            pos = this.f2968n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (short) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2969f));
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    public short remove(short k) {
        short curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
        if (curr2 == 0) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    public short get(short k) {
        short curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2968n] : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
        if (curr2 == 0) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap, p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public boolean containsKey(short k) {
        short curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey;
        }
        short[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public boolean containsValue(short v) {
        short[] value = this.value;
        short[] key = this.key;
        if (this.containsNullKey && value[this.f2968n] == v) {
            return true;
        }
        int i = this.f2968n;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    public short getOrDefault(short k, short defaultValue) {
        short curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2968n] : defaultValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short putIfAbsent(short k, short v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public boolean remove(short k, short v) {
        if (!this.strategy.equals(k, 0)) {
            short[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            short curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    short curr2 = key[i];
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
        } else if (!this.containsNullKey || v != this.value[this.f2968n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public boolean replace(short k, short oldValue, short v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short replace(short k, short v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short computeIfAbsent(short k, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short computeIfAbsent(short key, Short2ShortFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        short newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short computeIfAbsentNullable(short k, IntFunction<? extends Short> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Short newValue = (Short) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        short v = newValue.shortValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short computeIfPresent(short k, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Short newValue = (Short) remappingFunction.apply(Short.valueOf(k), Short.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, 0)) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short compute(short k, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Short newValue = (Short) remappingFunction.apply(Short.valueOf(k), pos >= 0 ? Short.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (this.strategy.equals(k, 0)) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    public short merge(short k, short v, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
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
            if (this.strategy.equals(k, 0)) {
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
            Arrays.fill(this.key, (short) 0);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Short2ShortMap.Entry, Map.Entry<Short, Short>, ShortShortPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry
        public short getShortKey() {
            return Short2ShortOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortShortPair
        public short leftShort() {
            return Short2ShortOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry
        public short getShortValue() {
            return Short2ShortOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortShortPair
        public short rightShort() {
            return Short2ShortOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry
        public short setValue(short v) {
            short oldValue = Short2ShortOpenCustomHashMap.this.value[this.index];
            Short2ShortOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortShortPair
        public ShortShortPair right(short v) {
            Short2ShortOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getKey() {
            return Short.valueOf(Short2ShortOpenCustomHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getValue() {
            return Short.valueOf(Short2ShortOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.Entry
        @Deprecated
        public Short setValue(Short v) {
            return Short.valueOf(setValue(v.shortValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Short, Short> e = (Map.Entry) o;
            return Short2ShortOpenCustomHashMap.this.strategy.equals(Short2ShortOpenCustomHashMap.this.key[this.index], e.getKey().shortValue()) && Short2ShortOpenCustomHashMap.this.value[this.index] == e.getValue().shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Short2ShortOpenCustomHashMap.this.strategy.hashCode(Short2ShortOpenCustomHashMap.this.key[this.index]) ^ Short2ShortOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Short2ShortOpenCustomHashMap.this.key[this.index]) + "=>" + ((int) Short2ShortOpenCustomHashMap.this.value[this.index]);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2970c;
        boolean mustReturnNullKey;
        ShortArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Short2ShortOpenCustomHashMap.this.f2968n;
            this.last = -1;
            this.f2970c = Short2ShortOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Short2ShortOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2970c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2970c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Short2ShortOpenCustomHashMap.this.f2968n;
                this.last = i;
                return i;
            }
            short[] key = Short2ShortOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix(Short2ShortOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Short2ShortOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Short2ShortOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Short2ShortOpenCustomHashMap.this.mask;
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
                int i = Short2ShortOpenCustomHashMap.this.f2968n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2970c--;
            }
            short[] key = Short2ShortOpenCustomHashMap.this.key;
            while (this.f2970c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix(Short2ShortOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Short2ShortOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Short2ShortOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Short2ShortOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2970c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2970c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            short curr;
            short[] key = Short2ShortOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Short2ShortOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(Short2ShortOpenCustomHashMap.this.strategy.hashCode(curr)) & Short2ShortOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2ShortOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2ShortOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ShortArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Short2ShortOpenCustomHashMap.this.value[pos] = Short2ShortOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Short2ShortOpenCustomHashMap.this.f2968n) {
                Short2ShortOpenCustomHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Short2ShortOpenCustomHashMap.this.remove(this.wrapped.getShort((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Short2ShortOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Short2ShortMap.Entry>> implements ObjectIterator<Short2ShortMap.Entry> {
        private MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public MapEntry next() {
            MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Short2ShortMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Short2ShortMap.Entry>> implements ObjectIterator<Short2ShortMap.Entry> {
        private final MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Short2ShortMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f2971c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Short2ShortOpenCustomHashMap.this.f2968n;
            this.f2971c = 0;
            this.mustReturnNull = Short2ShortOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Short2ShortOpenCustomHashMap.this.f2968n;
            this.f2971c = 0;
            this.mustReturnNull = Short2ShortOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2971c++;
                acceptOnIndex(action, Short2ShortOpenCustomHashMap.this.f2968n);
                return true;
            }
            short[] key = Short2ShortOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2971c++;
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
                this.f2971c++;
                acceptOnIndex(action, Short2ShortOpenCustomHashMap.this.f2968n);
            }
            short[] key = Short2ShortOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2971c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Short2ShortOpenCustomHashMap.this.size - this.f2971c);
            }
            return Math.min((long) (Short2ShortOpenCustomHashMap.this.size - this.f2971c), ((long) ((((double) Short2ShortOpenCustomHashMap.this.realSize()) / ((double) Short2ShortOpenCustomHashMap.this.f2968n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Short2ShortMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Short2ShortMap.Entry> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

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

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Short2ShortMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Short2ShortMap.Entry> implements Short2ShortMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Short2ShortMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.FastEntrySet
        public ObjectIterator<Short2ShortMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2ShortMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            short curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            short v = ((Short) e.getValue()).shortValue();
            if (Short2ShortOpenCustomHashMap.this.strategy.equals(k, 0)) {
                return Short2ShortOpenCustomHashMap.this.containsNullKey && Short2ShortOpenCustomHashMap.this.value[Short2ShortOpenCustomHashMap.this.f2968n] == v;
            }
            short[] key = Short2ShortOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Short2ShortOpenCustomHashMap.this.strategy.hashCode(k)) & Short2ShortOpenCustomHashMap.this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (Short2ShortOpenCustomHashMap.this.strategy.equals(k, curr2)) {
                return Short2ShortOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Short2ShortOpenCustomHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (!Short2ShortOpenCustomHashMap.this.strategy.equals(k, curr));
            return Short2ShortOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            short v = ((Short) e.getValue()).shortValue();
            if (!Short2ShortOpenCustomHashMap.this.strategy.equals(k, 0)) {
                short[] key = Short2ShortOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Short2ShortOpenCustomHashMap.this.strategy.hashCode(k)) & Short2ShortOpenCustomHashMap.this.mask;
                int pos = mix;
                short curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (!Short2ShortOpenCustomHashMap.this.strategy.equals(curr, k)) {
                    while (true) {
                        int i = (pos + 1) & Short2ShortOpenCustomHashMap.this.mask;
                        pos = i;
                        short curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (Short2ShortOpenCustomHashMap.this.strategy.equals(curr2, k) && Short2ShortOpenCustomHashMap.this.value[pos] == v) {
                            Short2ShortOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Short2ShortOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Short2ShortOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Short2ShortOpenCustomHashMap.this.containsNullKey || Short2ShortOpenCustomHashMap.this.value[Short2ShortOpenCustomHashMap.this.f2968n] != v) {
                return false;
            } else {
                Short2ShortOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2ShortOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2ShortOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2ShortMap.Entry> consumer) {
            if (Short2ShortOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractShort2ShortMap.BasicEntry(Short2ShortOpenCustomHashMap.this.key[Short2ShortOpenCustomHashMap.this.f2968n], Short2ShortOpenCustomHashMap.this.value[Short2ShortOpenCustomHashMap.this.f2968n]));
            }
            int pos = Short2ShortOpenCustomHashMap.this.f2968n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2ShortOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractShort2ShortMap.BasicEntry(Short2ShortOpenCustomHashMap.this.key[pos], Short2ShortOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2ShortMap.Entry> consumer) {
            AbstractShort2ShortMap.BasicEntry entry = new AbstractShort2ShortMap.BasicEntry();
            if (Short2ShortOpenCustomHashMap.this.containsNullKey) {
                entry.key = Short2ShortOpenCustomHashMap.this.key[Short2ShortOpenCustomHashMap.this.f2968n];
                entry.value = Short2ShortOpenCustomHashMap.this.value[Short2ShortOpenCustomHashMap.this.f2968n];
                consumer.accept(entry);
            }
            int pos = Short2ShortOpenCustomHashMap.this.f2968n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2ShortOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Short2ShortOpenCustomHashMap.this.key[pos];
                    entry.value = Short2ShortOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, p014it.unimi.dsi.fastutil.shorts.Short2ShortSortedMap
    public Short2ShortMap.FastEntrySet short2ShortEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<ShortConsumer> implements ShortIterator {
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ShortConsumer shortConsumer) {
            forEachRemaining((KeyIterator) shortConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2ShortOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Short2ShortOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<ShortConsumer, KeySpliterator> implements ShortSpliterator {
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
            action.accept(Short2ShortOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$KeySet.class */
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
            if (Short2ShortOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Short2ShortOpenCustomHashMap.this.key[Short2ShortOpenCustomHashMap.this.f2968n]);
            }
            int pos = Short2ShortOpenCustomHashMap.this.f2968n;
            while (true) {
                pos--;
                if (pos != 0) {
                    short k = Short2ShortOpenCustomHashMap.this.key[pos];
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
            return Short2ShortOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2ShortOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldSize = Short2ShortOpenCustomHashMap.this.size;
            Short2ShortOpenCustomHashMap.this.remove(k);
            return Short2ShortOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2ShortOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, java.util.Map
    public Set<Short> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<ShortConsumer> implements ShortIterator {
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ShortConsumer shortConsumer) {
            forEachRemaining((ValueIterator) shortConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2ShortOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Short2ShortOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends MapSpliterator<ShortConsumer, ValueSpliterator> implements ShortSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 256;

        ValueSpliterator() {
            super();
        }

        ValueSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            super(pos, max, mustReturnNull, hasSplit);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 256 : 320;
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2ShortOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap, java.util.Map
    public Collection<Short> values() {
        if (this.values == null) {
            this.values = new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.shorts.Short2ShortOpenCustomHashMap.1
                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public ShortIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public ShortSpliterator spliterator() {
                    return new ValueSpliterator();
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public void forEach(ShortConsumer consumer) {
                    if (Short2ShortOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Short2ShortOpenCustomHashMap.this.value[Short2ShortOpenCustomHashMap.this.f2968n]);
                    }
                    int pos = Short2ShortOpenCustomHashMap.this.f2968n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Short2ShortOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept(Short2ShortOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Short2ShortOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
                public boolean contains(short v) {
                    return Short2ShortOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Short2ShortOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2969f)));
        if (l >= this.f2968n || this.size > HashCommon.maxFill(l, this.f2969f)) {
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
        short[] value = this.value;
        int mask = newN - 1;
        short[] newKey = new short[newN + 1];
        short[] newValue = new short[newN + 1];
        int i2 = this.f2968n;
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
                newValue[newN] = value[this.f2968n];
                this.f2968n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2968n, this.f2969f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Short2ShortOpenCustomHashMap clone() {
        try {
            Short2ShortOpenCustomHashMap c = (Short2ShortOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (short[]) this.key.clone();
            c.value = (short[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortMap, java.lang.Object, java.util.Map
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
            h += this.strategy.hashCode(this.key[i]) ^ this.value[i];
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2968n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        short[] key = this.key;
        short[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeShort(key[e]);
                s.writeShort(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2968n = HashCommon.arraySize(this.size, this.f2969f);
        this.maxFill = HashCommon.maxFill(this.f2968n, this.f2969f);
        this.mask = this.f2968n - 1;
        short[] key = new short[this.f2968n + 1];
        this.key = key;
        short[] value = new short[this.f2968n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                short k = s.readShort();
                short v = s.readShort();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f2968n;
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
                value[pos] = v;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
