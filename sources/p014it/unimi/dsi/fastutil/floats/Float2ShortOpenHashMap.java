package p014it.unimi.dsi.fastutil.floats;

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
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap;
import p014it.unimi.dsi.fastutil.floats.Float2ShortMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap.class */
public class Float2ShortOpenHashMap extends AbstractFloat2ShortMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient float[] key;
    protected transient short[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f1879n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1880f;
    protected transient Float2ShortMap.FastEntrySet entries;
    protected transient FloatSet keys;
    protected transient ShortCollection values;

    public Float2ShortOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1880f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1879n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1879n - 1;
            this.maxFill = HashCommon.maxFill(this.f1879n, f);
            this.key = new float[this.f1879n + 1];
            this.value = new short[this.f1879n + 1];
        }
    }

    public Float2ShortOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Float2ShortOpenHashMap() {
        this(16, 0.75f);
    }

    public Float2ShortOpenHashMap(Map<? extends Float, ? extends Short> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Float2ShortOpenHashMap(Map<? extends Float, ? extends Short> m) {
        this(m, 0.75f);
    }

    public Float2ShortOpenHashMap(Float2ShortMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Float2ShortOpenHashMap(Float2ShortMap m) {
        this(m, 0.75f);
    }

    public Float2ShortOpenHashMap(float[] k, short[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Float2ShortOpenHashMap(float[] k, short[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1880f);
        if (needed > this.f1879n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1880f)))));
        if (needed > this.f1879n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public short removeEntry(int pos) {
        short oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f1879n > this.minN && this.size < this.maxFill / 4 && this.f1879n > 16) {
            rehash(this.f1879n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public short removeNullEntry() {
        this.containsNullKey = false;
        short oldValue = this.value[this.f1879n];
        this.size--;
        if (this.f1879n > this.minN && this.size < this.maxFill / 4 && this.f1879n > 16) {
            rehash(this.f1879n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, java.util.Map
    public void putAll(Map<? extends Float, ? extends Short> m) {
        if (((double) this.f1880f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? this.f1879n : -(this.f1879n + 1);
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return -(pos + 1);
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return -(pos + 1);
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return pos;
    }

    private void insert(int pos, float k, short v) {
        if (pos == this.f1879n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1880f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    public short put(float k, short v) {
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

    public short addTo(float k, short incr) {
        int pos;
        float curr;
        if (Float.floatToIntBits(k) != 0) {
            float[] key = this.key;
            int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
            pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) != 0) {
                if (Float.floatToIntBits(curr2) == Float.floatToIntBits(k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Float.floatToIntBits(curr) != 0) {
                    }
                } while (Float.floatToIntBits(curr) != Float.floatToIntBits(k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f1879n, incr);
        } else {
            pos = this.f1879n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (short) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1880f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        float curr;
        float[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (Float.floatToIntBits(curr) == 0) {
                    key[pos] = 0.0f;
                    return;
                }
                int slot = HashCommon.mix(HashCommon.float2int(curr)) & this.mask;
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    public short remove(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    public short get(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1879n] : this.defRetValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortFunction, p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public boolean containsKey(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return false;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public boolean containsValue(short v) {
        short[] value = this.value;
        float[] key = this.key;
        if (this.containsNullKey && value[this.f1879n] == v) {
            return true;
        }
        int i = this.f1879n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (Float.floatToIntBits(key[i]) != 0 && value[i] == v) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    public short getOrDefault(float k, short defaultValue) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1879n] : defaultValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return defaultValue;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return defaultValue;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short putIfAbsent(float k, short v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public boolean remove(float k, short v) {
        if (Float.floatToIntBits(k) != 0) {
            float[] key = this.key;
            int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
            int pos = mix;
            float curr = key[mix];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
            if (Float.floatToIntBits(k) == Float.floatToIntBits(curr) && v == this.value[pos]) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                float curr2 = key[i];
                if (Float.floatToIntBits(curr2) == 0) {
                    return false;
                }
                if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2) && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f1879n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public boolean replace(float k, short oldValue, short v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short replace(float k, short v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short computeIfAbsent(float k, DoubleToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt((double) k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short computeIfAbsent(float key, Float2ShortFunction mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short computeIfAbsentNullable(float k, DoubleFunction<? extends Short> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Short newValue = (Short) mappingFunction.apply((double) k);
        if (newValue == null) {
            return this.defRetValue;
        }
        short v = newValue.shortValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short computeIfPresent(float k, BiFunction<? super Float, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Short newValue = (Short) remappingFunction.apply(Float.valueOf(k), Short.valueOf(this.value[pos]));
        if (newValue == null) {
            if (Float.floatToIntBits(k) == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short compute(float k, BiFunction<? super Float, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Short newValue = (Short) remappingFunction.apply(Float.valueOf(k), pos >= 0 ? Short.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (Float.floatToIntBits(k) == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public short merge(float k, short v, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
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
            if (Float.floatToIntBits(k) == 0) {
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
            Arrays.fill(this.key, 0.0f);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$MapEntry.class */
    public final class MapEntry implements Float2ShortMap.Entry, Map.Entry<Float, Short>, FloatShortPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry
        public float getFloatKey() {
            return Float2ShortOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
        public float leftFloat() {
            return Float2ShortOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry
        public short getShortValue() {
            return Float2ShortOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
        public short rightShort() {
            return Float2ShortOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry
        public short setValue(short v) {
            short oldValue = Float2ShortOpenHashMap.this.value[this.index];
            Float2ShortOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
        public FloatShortPair right(short v) {
            Float2ShortOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry, java.util.Map.Entry
        @Deprecated
        public Float getKey() {
            return Float.valueOf(Float2ShortOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getValue() {
            return Short.valueOf(Float2ShortOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry
        @Deprecated
        public Short setValue(Short v) {
            return Short.valueOf(setValue(v.shortValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Float, Short> e = (Map.Entry) o;
            return Float.floatToIntBits(Float2ShortOpenHashMap.this.key[this.index]) == Float.floatToIntBits(e.getKey().floatValue()) && Float2ShortOpenHashMap.this.value[this.index] == e.getValue().shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(Float2ShortOpenHashMap.this.key[this.index]) ^ Float2ShortOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Float2ShortOpenHashMap.this.key[this.index] + "=>" + ((int) Float2ShortOpenHashMap.this.value[this.index]);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1881c;
        boolean mustReturnNullKey;
        FloatArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Float2ShortOpenHashMap.this.f1879n;
            this.last = -1;
            this.f1881c = Float2ShortOpenHashMap.this.size;
            this.mustReturnNullKey = Float2ShortOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1881c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1881c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Float2ShortOpenHashMap.this.f1879n;
                this.last = i;
                return i;
            }
            float[] key = Float2ShortOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    float k = this.wrapped.getFloat((-this.pos) - 1);
                    int mix = HashCommon.mix(HashCommon.float2int(k));
                    int i3 = Float2ShortOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Float.floatToIntBits(k) == Float.floatToIntBits(key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Float2ShortOpenHashMap.this.mask;
                    }
                }
            } while (Float.floatToIntBits(key[this.pos]) == 0);
            int i4 = this.pos;
            this.last = i4;
            return i4;
        }

        public void forEachRemaining(ConsumerType action) {
            int p;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Float2ShortOpenHashMap.this.f1879n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1881c--;
            }
            float[] key = Float2ShortOpenHashMap.this.key;
            while (this.f1881c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    float k = this.wrapped.getFloat((-this.pos) - 1);
                    int mix = HashCommon.mix(HashCommon.float2int(k));
                    int i3 = Float2ShortOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Float.floatToIntBits(k) == Float.floatToIntBits(key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Float2ShortOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1881c--;
                } else if (Float.floatToIntBits(key[this.pos]) != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1881c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            float curr;
            float[] key = Float2ShortOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Float2ShortOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (Float.floatToIntBits(curr) == 0) {
                        key[pos] = 0.0f;
                        return;
                    }
                    int slot = HashCommon.mix(HashCommon.float2int(curr)) & Float2ShortOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Float2ShortOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Float2ShortOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new FloatArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Float2ShortOpenHashMap.this.value[pos] = Float2ShortOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Float2ShortOpenHashMap.this.f1879n) {
                Float2ShortOpenHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Float2ShortOpenHashMap.this.remove(this.wrapped.getFloat((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Float2ShortOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Float2ShortMap.Entry>> implements ObjectIterator<Float2ShortMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2ShortMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Float2ShortMap.Entry>> implements ObjectIterator<Float2ShortMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2ShortMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f1882c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Float2ShortOpenHashMap.this.f1879n;
            this.f1882c = 0;
            this.mustReturnNull = Float2ShortOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Float2ShortOpenHashMap.this.f1879n;
            this.f1882c = 0;
            this.mustReturnNull = Float2ShortOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1882c++;
                acceptOnIndex(action, Float2ShortOpenHashMap.this.f1879n);
                return true;
            }
            float[] key = Float2ShortOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    this.f1882c++;
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
                this.f1882c++;
                acceptOnIndex(action, Float2ShortOpenHashMap.this.f1879n);
            }
            float[] key = Float2ShortOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1882c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Float2ShortOpenHashMap.this.size - this.f1882c);
            }
            return Math.min((long) (Float2ShortOpenHashMap.this.size - this.f1882c), ((long) ((((double) Float2ShortOpenHashMap.this.realSize()) / ((double) Float2ShortOpenHashMap.this.f1879n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
        /* JADX WARN: Type inference failed for: r0v19, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r0v24, types: [long] */
        /* JADX WARN: Type inference failed for: r0v26, types: [long] */
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
                it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap r0 = p014it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap.this
                float[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0078
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0078
                r0 = r11
                r1 = r6
                r2 = r1
                int r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                int r3 = r3 + r4
                r2.pos = r3
                r0 = r0[r1]
                int r0 = java.lang.Float.floatToIntBits(r0)
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
            L_0x0078:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Float2ShortMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Float2ShortMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2ShortMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Float2ShortMap.Entry> implements Float2ShortMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Float2ShortMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.FastEntrySet
        public ObjectIterator<Float2ShortMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2ShortMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            float curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            short v = ((Short) e.getValue()).shortValue();
            if (Float.floatToIntBits(k) == 0) {
                return Float2ShortOpenHashMap.this.containsNullKey && Float2ShortOpenHashMap.this.value[Float2ShortOpenHashMap.this.f1879n] == v;
            }
            float[] key = Float2ShortOpenHashMap.this.key;
            int mix = HashCommon.mix(HashCommon.float2int(k)) & Float2ShortOpenHashMap.this.mask;
            int pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) == 0) {
                return false;
            }
            if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
                return Float2ShortOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Float2ShortOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
            } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
            return Float2ShortOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            short v = ((Short) e.getValue()).shortValue();
            if (Float.floatToIntBits(k) != 0) {
                float[] key = Float2ShortOpenHashMap.this.key;
                int mix = HashCommon.mix(HashCommon.float2int(k)) & Float2ShortOpenHashMap.this.mask;
                int pos = mix;
                float curr = key[mix];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
                if (Float.floatToIntBits(curr) != Float.floatToIntBits(k)) {
                    while (true) {
                        int i = (pos + 1) & Float2ShortOpenHashMap.this.mask;
                        pos = i;
                        float curr2 = key[i];
                        if (Float.floatToIntBits(curr2) == 0) {
                            return false;
                        }
                        if (Float.floatToIntBits(curr2) == Float.floatToIntBits(k) && Float2ShortOpenHashMap.this.value[pos] == v) {
                            Float2ShortOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Float2ShortOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Float2ShortOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Float2ShortOpenHashMap.this.containsNullKey || Float2ShortOpenHashMap.this.value[Float2ShortOpenHashMap.this.f1879n] != v) {
                return false;
            } else {
                Float2ShortOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2ShortOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2ShortOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Float2ShortMap.Entry> consumer) {
            if (Float2ShortOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractFloat2ShortMap.BasicEntry(Float2ShortOpenHashMap.this.key[Float2ShortOpenHashMap.this.f1879n], Float2ShortOpenHashMap.this.value[Float2ShortOpenHashMap.this.f1879n]));
            }
            int pos = Float2ShortOpenHashMap.this.f1879n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Float.floatToIntBits(Float2ShortOpenHashMap.this.key[pos]) != 0) {
                    consumer.accept(new AbstractFloat2ShortMap.BasicEntry(Float2ShortOpenHashMap.this.key[pos], Float2ShortOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.FastEntrySet
        public void fastForEach(Consumer<? super Float2ShortMap.Entry> consumer) {
            AbstractFloat2ShortMap.BasicEntry entry = new AbstractFloat2ShortMap.BasicEntry();
            if (Float2ShortOpenHashMap.this.containsNullKey) {
                entry.key = Float2ShortOpenHashMap.this.key[Float2ShortOpenHashMap.this.f1879n];
                entry.value = Float2ShortOpenHashMap.this.value[Float2ShortOpenHashMap.this.f1879n];
                consumer.accept(entry);
            }
            int pos = Float2ShortOpenHashMap.this.f1879n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Float.floatToIntBits(Float2ShortOpenHashMap.this.key[pos]) != 0) {
                    entry.key = Float2ShortOpenHashMap.this.key[pos];
                    entry.value = Float2ShortOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
    public Float2ShortMap.FastEntrySet float2ShortEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<FloatConsumer> implements FloatIterator {
        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(FloatConsumer floatConsumer) {
            forEachRemaining((KeyIterator) floatConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(FloatConsumer action, int index) {
            action.accept(Float2ShortOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return Float2ShortOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<FloatConsumer, KeySpliterator> implements FloatSpliterator {
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
        public final void acceptOnIndex(FloatConsumer action, int index) {
            action.accept(Float2ShortOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractFloatSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer consumer) {
            if (Float2ShortOpenHashMap.this.containsNullKey) {
                consumer.accept(Float2ShortOpenHashMap.this.key[Float2ShortOpenHashMap.this.f1879n]);
            }
            int pos = Float2ShortOpenHashMap.this.f1879n;
            while (true) {
                pos--;
                if (pos != 0) {
                    float k = Float2ShortOpenHashMap.this.key[pos];
                    if (Float.floatToIntBits(k) != 0) {
                        consumer.accept(k);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2ShortOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float2ShortOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            int oldSize = Float2ShortOpenHashMap.this.size;
            Float2ShortOpenHashMap.this.remove(k);
            return Float2ShortOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2ShortOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    public Set<Float> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$ValueIterator.class */
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
            action.accept(Float2ShortOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Float2ShortOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortOpenHashMap$ValueSpliterator.class */
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
            action.accept(Float2ShortOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    public Collection<Short> values() {
        if (this.values == null) {
            this.values = new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.floats.Float2ShortOpenHashMap.1
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
                    if (Float2ShortOpenHashMap.this.containsNullKey) {
                        consumer.accept(Float2ShortOpenHashMap.this.value[Float2ShortOpenHashMap.this.f1879n]);
                    }
                    int pos = Float2ShortOpenHashMap.this.f1879n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Float.floatToIntBits(Float2ShortOpenHashMap.this.key[pos]) != 0) {
                            consumer.accept(Float2ShortOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Float2ShortOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
                public boolean contains(short v) {
                    return Float2ShortOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Float2ShortOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1880f)));
        if (l >= this.f1879n || this.size > HashCommon.maxFill(l, this.f1880f)) {
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
        float[] key = this.key;
        short[] value = this.value;
        int mask = newN - 1;
        float[] newKey = new float[newN + 1];
        short[] newValue = new short[newN + 1];
        int i2 = this.f1879n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (Float.floatToIntBits(key[i2]) == 0);
                int mix = HashCommon.mix(HashCommon.float2int(key[i2])) & mask;
                int pos = mix;
                if (Float.floatToIntBits(newKey[mix]) != 0) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (Float.floatToIntBits(newKey[i]) != 0);
                }
                newKey[pos] = key[i2];
                newValue[pos] = value[i2];
            } else {
                newValue[newN] = value[this.f1879n];
                this.f1879n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1879n, this.f1880f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Float2ShortOpenHashMap clone() {
        try {
            Float2ShortOpenHashMap c = (Float2ShortOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (float[]) this.key.clone();
            c.value = (short[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap, java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            while (Float.floatToIntBits(this.key[i]) == 0) {
                i++;
            }
            h += HashCommon.float2int(this.key[i]) ^ this.value[i];
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1879n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        float[] key = this.key;
        short[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeFloat(key[e]);
                s.writeShort(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1879n = HashCommon.arraySize(this.size, this.f1880f);
        this.maxFill = HashCommon.maxFill(this.f1879n, this.f1880f);
        this.mask = this.f1879n - 1;
        float[] key = new float[this.f1879n + 1];
        this.key = key;
        short[] value = new short[this.f1879n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                float k = s.readFloat();
                short v = s.readShort();
                if (Float.floatToIntBits(k) == 0) {
                    pos = this.f1879n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(HashCommon.float2int(k));
                    int i2 = this.mask;
                    while (true) {
                        pos = mix & i2;
                        if (Float.floatToIntBits(key[pos]) != 0) {
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
