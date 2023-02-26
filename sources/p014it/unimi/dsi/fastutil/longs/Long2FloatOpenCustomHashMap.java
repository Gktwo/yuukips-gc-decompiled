package p014it.unimi.dsi.fastutil.longs;

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
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatConsumer;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap;
import p014it.unimi.dsi.fastutil.longs.Long2FloatMap;
import p014it.unimi.dsi.fastutil.longs.LongHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap.class */
public class Long2FloatOpenCustomHashMap extends AbstractLong2FloatMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient long[] key;
    protected transient float[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected LongHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f2278n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2279f;
    protected transient Long2FloatMap.FastEntrySet entries;
    protected transient LongSet keys;
    protected transient FloatCollection values;

    public Long2FloatOpenCustomHashMap(int expected, float f, LongHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2279f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2278n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2278n - 1;
            this.maxFill = HashCommon.maxFill(this.f2278n, f);
            this.key = new long[this.f2278n + 1];
            this.value = new float[this.f2278n + 1];
        }
    }

    public Long2FloatOpenCustomHashMap(int expected, LongHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Long2FloatOpenCustomHashMap(LongHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Long2FloatOpenCustomHashMap(Map<? extends Long, ? extends Float> m, float f, LongHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Long2FloatOpenCustomHashMap(Map<? extends Long, ? extends Float> m, LongHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Long2FloatOpenCustomHashMap(Long2FloatMap m, float f, LongHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Long2FloatOpenCustomHashMap(Long2FloatMap m, LongHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Long2FloatOpenCustomHashMap(long[] k, float[] v, float f, LongHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Long2FloatOpenCustomHashMap(long[] k, float[] v, LongHash.Strategy strategy) {
        this(k, v, 0.75f, strategy);
    }

    public LongHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2279f);
        if (needed > this.f2278n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2279f)))));
        if (needed > this.f2278n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public float removeEntry(int pos) {
        float oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2278n > this.minN && this.size < this.maxFill / 4 && this.f2278n > 16) {
            rehash(this.f2278n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public float removeNullEntry() {
        this.containsNullKey = false;
        float oldValue = this.value[this.f2278n];
        this.size--;
        if (this.f2278n > this.minN && this.size < this.maxFill / 4 && this.f2278n > 16) {
            rehash(this.f2278n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, java.util.Map
    public void putAll(Map<? extends Long, ? extends Float> m) {
        if (((double) this.f2279f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.f2278n : -(this.f2278n + 1);
        }
        long[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        if (key[mix] == 0) {
            return -(pos + 1);
        }
        if (this.strategy.equals(k, mix)) {
            return pos;
        }
        do {
            i = (pos + 1) & this.mask;
            pos = i;
            if (key[i] == 0) {
                return -(pos + 1);
            }
        } while (!this.strategy.equals(k, i));
        return pos;
    }

    private void insert(int pos, long k, float v) {
        if (pos == this.f2278n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2279f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public float put(long k, float v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        float oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private float addToValue(int pos, float incr) {
        float oldValue = this.value[pos];
        this.value[pos] = oldValue + incr;
        return oldValue;
    }

    public float addTo(long k, float incr) {
        int pos;
        int i;
        if (!this.strategy.equals(k, 0)) {
            long[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            if (key[mix] != 0) {
                if (this.strategy.equals(mix, k)) {
                    return addToValue(pos, incr);
                }
                do {
                    i = (pos + 1) & this.mask;
                    pos = i;
                    if (key[i] != 0) {
                    }
                } while (!this.strategy.equals(i, k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2278n, incr);
        } else {
            pos = this.f2278n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2279f));
        }
        return this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public float remove(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        long[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        if (key[mix] == 0) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, mix)) {
            return removeEntry(pos);
        }
        do {
            i = (pos + 1) & this.mask;
            pos = i;
            if (key[i] == 0) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, i));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public float get(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2278n] : this.defRetValue;
        }
        long[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        if (key[mix] == 0) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, mix)) {
            return this.value[pos];
        }
        do {
            i = (pos + 1) & this.mask;
            pos = i;
            if (key[i] == 0) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, i));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public boolean containsKey(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey;
        }
        long[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        if (key[mix] == 0) {
            return false;
        }
        if (this.strategy.equals(k, mix)) {
            return true;
        }
        do {
            i = (pos + 1) & this.mask;
            pos = i;
            if (key[i] == 0) {
                return false;
            }
        } while (!this.strategy.equals(k, i));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public boolean containsValue(float v) {
        float[] value = this.value;
        long[] key = this.key;
        if (this.containsNullKey && Float.floatToIntBits(value[this.f2278n]) == Float.floatToIntBits(v)) {
            return true;
        }
        int i = this.f2278n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != 0 && Float.floatToIntBits(value[i]) == Float.floatToIntBits(v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public float getOrDefault(long k, float defaultValue) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2278n] : defaultValue;
        }
        long[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        if (key[mix] == 0) {
            return defaultValue;
        }
        if (this.strategy.equals(k, mix)) {
            return this.value[pos];
        }
        do {
            i = (pos + 1) & this.mask;
            pos = i;
            if (key[i] == 0) {
                return defaultValue;
            }
        } while (!this.strategy.equals(k, i));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float putIfAbsent(long k, float v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public boolean remove(long k, float v) {
        if (!this.strategy.equals(k, 0)) {
            long[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            if (key[mix] == 0) {
                return false;
            }
            if (!this.strategy.equals(k, mix) || Float.floatToIntBits(v) != Float.floatToIntBits(this.value[pos])) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    if (key[i] == 0) {
                        return false;
                    }
                    if (this.strategy.equals(k, i) && Float.floatToIntBits(v) == Float.floatToIntBits(this.value[pos])) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || Float.floatToIntBits(v) != Float.floatToIntBits(this.value[this.f2278n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public boolean replace(long k, float oldValue, float v) {
        int pos = find(k);
        if (pos < 0 || Float.floatToIntBits(oldValue) != Float.floatToIntBits(this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float replace(long k, float v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        float oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float computeIfAbsent(long k, LongToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        float newValue = SafeMath.safeDoubleToFloat(mappingFunction.applyAsDouble(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float computeIfAbsent(long key, Long2FloatFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        float newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float computeIfAbsentNullable(long k, LongFunction<? extends Float> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Float newValue = (Float) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        float v = newValue.floatValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float computeIfPresent(long k, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Float newValue = (Float) remappingFunction.apply(Long.valueOf(k), Float.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, 0)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        float[] fArr = this.value;
        float floatValue = newValue.floatValue();
        fArr[pos] = floatValue;
        return floatValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float compute(long k, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Float newValue = (Float) remappingFunction.apply(Long.valueOf(k), pos >= 0 ? Float.valueOf(this.value[pos]) : null);
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
        float newVal = newValue.floatValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public float merge(long k, float v, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
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
        Float newValue = (Float) remappingFunction.apply(Float.valueOf(this.value[pos]), Float.valueOf(v));
        if (newValue == null) {
            if (this.strategy.equals(k, 0)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        float[] fArr = this.value;
        float floatValue = newValue.floatValue();
        fArr[pos] = floatValue;
        return floatValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, 0L);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Long2FloatMap.Entry, Map.Entry<Long, Float>, LongFloatPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry
        public long getLongKey() {
            return Long2FloatOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongFloatPair
        public long leftLong() {
            return Long2FloatOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry
        public float getFloatValue() {
            return Long2FloatOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongFloatPair
        public float rightFloat() {
            return Long2FloatOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry
        public float setValue(float v) {
            float oldValue = Long2FloatOpenCustomHashMap.this.value[this.index];
            Long2FloatOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongFloatPair
        public LongFloatPair right(float v) {
            Long2FloatOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getKey() {
            return Long.valueOf(Long2FloatOpenCustomHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry, java.util.Map.Entry
        @Deprecated
        public Float getValue() {
            return Float.valueOf(Long2FloatOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry
        @Deprecated
        public Float setValue(Float v) {
            return Float.valueOf(setValue(v.floatValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, Float> e = (Map.Entry) o;
            return Long2FloatOpenCustomHashMap.this.strategy.equals(Long2FloatOpenCustomHashMap.this.key[this.index], e.getKey().longValue()) && Float.floatToIntBits(Long2FloatOpenCustomHashMap.this.value[this.index]) == Float.floatToIntBits(e.getValue().floatValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Long2FloatOpenCustomHashMap.this.strategy.hashCode(Long2FloatOpenCustomHashMap.this.key[this.index]) ^ HashCommon.float2int(Long2FloatOpenCustomHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Long2FloatOpenCustomHashMap.this.key[this.index] + "=>" + Long2FloatOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2280c;
        boolean mustReturnNullKey;
        LongArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Long2FloatOpenCustomHashMap.this.f2278n;
            this.last = -1;
            this.f2280c = Long2FloatOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Long2FloatOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2280c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2280c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Long2FloatOpenCustomHashMap.this.f2278n;
                this.last = i;
                return i;
            }
            long[] key = Long2FloatOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    long k = this.wrapped.getLong((-this.pos) - 1);
                    int mix = HashCommon.mix(Long2FloatOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Long2FloatOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Long2FloatOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Long2FloatOpenCustomHashMap.this.mask;
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
                int i = Long2FloatOpenCustomHashMap.this.f2278n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2280c--;
            }
            long[] key = Long2FloatOpenCustomHashMap.this.key;
            while (this.f2280c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    long k = this.wrapped.getLong((-this.pos) - 1);
                    int mix = HashCommon.mix(Long2FloatOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Long2FloatOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Long2FloatOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Long2FloatOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2280c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2280c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            long curr;
            long[] key = Long2FloatOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Long2FloatOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(Long2FloatOpenCustomHashMap.this.strategy.hashCode(curr)) & Long2FloatOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Long2FloatOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Long2FloatOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new LongArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Long2FloatOpenCustomHashMap.this.value[pos] = Long2FloatOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Long2FloatOpenCustomHashMap.this.f2278n) {
                Long2FloatOpenCustomHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Long2FloatOpenCustomHashMap.this.remove(this.wrapped.getLong((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Long2FloatOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Long2FloatMap.Entry>> implements ObjectIterator<Long2FloatMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2FloatMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Long2FloatMap.Entry>> implements ObjectIterator<Long2FloatMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2FloatMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f2281c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Long2FloatOpenCustomHashMap.this.f2278n;
            this.f2281c = 0;
            this.mustReturnNull = Long2FloatOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Long2FloatOpenCustomHashMap.this.f2278n;
            this.f2281c = 0;
            this.mustReturnNull = Long2FloatOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2281c++;
                acceptOnIndex(action, Long2FloatOpenCustomHashMap.this.f2278n);
                return true;
            }
            long[] key = Long2FloatOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2281c++;
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
                this.f2281c++;
                acceptOnIndex(action, Long2FloatOpenCustomHashMap.this.f2278n);
            }
            long[] key = Long2FloatOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2281c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Long2FloatOpenCustomHashMap.this.size - this.f2281c);
            }
            return Math.min((long) (Long2FloatOpenCustomHashMap.this.size - this.f2281c), ((long) ((((double) Long2FloatOpenCustomHashMap.this.realSize()) / ((double) Long2FloatOpenCustomHashMap.this.f2278n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap.this
                long[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0077
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0077
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
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
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
            L_0x0077:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Long2FloatMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Long2FloatMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2FloatMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Long2FloatMap.Entry> implements Long2FloatMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Long2FloatMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.FastEntrySet
        public ObjectIterator<Long2FloatMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2FloatMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            int i;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            float v = ((Float) e.getValue()).floatValue();
            if (Long2FloatOpenCustomHashMap.this.strategy.equals(k, 0)) {
                return Long2FloatOpenCustomHashMap.this.containsNullKey && Float.floatToIntBits(Long2FloatOpenCustomHashMap.this.value[Long2FloatOpenCustomHashMap.this.f2278n]) == Float.floatToIntBits(v);
            }
            long[] key = Long2FloatOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Long2FloatOpenCustomHashMap.this.strategy.hashCode(k)) & Long2FloatOpenCustomHashMap.this.mask;
            int pos = mix;
            if (key[mix] == 0) {
                return false;
            }
            if (Long2FloatOpenCustomHashMap.this.strategy.equals(k, mix)) {
                return Float.floatToIntBits(Long2FloatOpenCustomHashMap.this.value[pos]) == Float.floatToIntBits(v);
            }
            do {
                i = (pos + 1) & Long2FloatOpenCustomHashMap.this.mask;
                pos = i;
                if (key[i] == 0) {
                    return false;
                }
            } while (!Long2FloatOpenCustomHashMap.this.strategy.equals(k, i));
            return Float.floatToIntBits(Long2FloatOpenCustomHashMap.this.value[pos]) == Float.floatToIntBits(v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            float v = ((Float) e.getValue()).floatValue();
            if (!Long2FloatOpenCustomHashMap.this.strategy.equals(k, 0)) {
                long[] key = Long2FloatOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Long2FloatOpenCustomHashMap.this.strategy.hashCode(k)) & Long2FloatOpenCustomHashMap.this.mask;
                int pos = mix;
                if (key[mix] == 0) {
                    return false;
                }
                if (!Long2FloatOpenCustomHashMap.this.strategy.equals(mix, k)) {
                    while (true) {
                        int i = (pos + 1) & Long2FloatOpenCustomHashMap.this.mask;
                        pos = i;
                        if (key[i] == 0) {
                            return false;
                        }
                        if (Long2FloatOpenCustomHashMap.this.strategy.equals(i, k) && Float.floatToIntBits(Long2FloatOpenCustomHashMap.this.value[pos]) == Float.floatToIntBits(v)) {
                            Long2FloatOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Float.floatToIntBits(Long2FloatOpenCustomHashMap.this.value[pos]) != Float.floatToIntBits(v)) {
                    return false;
                } else {
                    Long2FloatOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Long2FloatOpenCustomHashMap.this.containsNullKey || Float.floatToIntBits(Long2FloatOpenCustomHashMap.this.value[Long2FloatOpenCustomHashMap.this.f2278n]) != Float.floatToIntBits(v)) {
                return false;
            } else {
                Long2FloatOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2FloatOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2FloatOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Long2FloatMap.Entry> consumer) {
            if (Long2FloatOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractLong2FloatMap.BasicEntry(Long2FloatOpenCustomHashMap.this.key[Long2FloatOpenCustomHashMap.this.f2278n], Long2FloatOpenCustomHashMap.this.value[Long2FloatOpenCustomHashMap.this.f2278n]));
            }
            int pos = Long2FloatOpenCustomHashMap.this.f2278n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Long2FloatOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractLong2FloatMap.BasicEntry(Long2FloatOpenCustomHashMap.this.key[pos], Long2FloatOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap.FastEntrySet
        public void fastForEach(Consumer<? super Long2FloatMap.Entry> consumer) {
            AbstractLong2FloatMap.BasicEntry entry = new AbstractLong2FloatMap.BasicEntry();
            if (Long2FloatOpenCustomHashMap.this.containsNullKey) {
                entry.key = Long2FloatOpenCustomHashMap.this.key[Long2FloatOpenCustomHashMap.this.f2278n];
                entry.value = Long2FloatOpenCustomHashMap.this.value[Long2FloatOpenCustomHashMap.this.f2278n];
                consumer.accept(entry);
            }
            int pos = Long2FloatOpenCustomHashMap.this.f2278n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Long2FloatOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Long2FloatOpenCustomHashMap.this.key[pos];
                    entry.value = Long2FloatOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
    public Long2FloatMap.FastEntrySet long2FloatEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<LongConsumer> implements LongIterator {
        @Override // java.util.PrimitiveIterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((KeyIterator) longConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Long2FloatOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Long2FloatOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<LongConsumer, KeySpliterator> implements LongSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;

        @Override // java.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((KeySpliterator) longConsumer);
        }

        @Override // java.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
            return tryAdvance((KeySpliterator) longConsumer);
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
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Long2FloatOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$KeySet.class */
    public final class KeySet extends AbstractLongSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongSpliterator spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
        public void forEach(LongConsumer consumer) {
            if (Long2FloatOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Long2FloatOpenCustomHashMap.this.key[Long2FloatOpenCustomHashMap.this.f2278n]);
            }
            int pos = Long2FloatOpenCustomHashMap.this.f2278n;
            while (true) {
                pos--;
                if (pos != 0) {
                    long k = Long2FloatOpenCustomHashMap.this.key[pos];
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
            return Long2FloatOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return Long2FloatOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            int oldSize = Long2FloatOpenCustomHashMap.this.size;
            Long2FloatOpenCustomHashMap.this.remove(k);
            return Long2FloatOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2FloatOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    public Set<Long> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<FloatConsumer> implements FloatIterator {
        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(FloatConsumer floatConsumer) {
            forEachRemaining((ValueIterator) floatConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(FloatConsumer action, int index) {
            action.accept(Long2FloatOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return Long2FloatOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends MapSpliterator<FloatConsumer, ValueSpliterator> implements FloatSpliterator {
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
        public final void acceptOnIndex(FloatConsumer action, int index) {
            action.accept(Long2FloatOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    public Collection<Float> values() {
        if (this.values == null) {
            this.values = new AbstractFloatCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2FloatOpenCustomHashMap.1
                @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
                public FloatIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
                public FloatSpliterator spliterator() {
                    return new ValueSpliterator();
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
                public void forEach(FloatConsumer consumer) {
                    if (Long2FloatOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Long2FloatOpenCustomHashMap.this.value[Long2FloatOpenCustomHashMap.this.f2278n]);
                    }
                    int pos = Long2FloatOpenCustomHashMap.this.f2278n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Long2FloatOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept(Long2FloatOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2FloatOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
                public boolean contains(float v) {
                    return Long2FloatOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2FloatOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2279f)));
        if (l >= this.f2278n || this.size > HashCommon.maxFill(l, this.f2279f)) {
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
        long[] key = this.key;
        float[] value = this.value;
        int mask = newN - 1;
        long[] newKey = new long[newN + 1];
        float[] newValue = new float[newN + 1];
        int i2 = this.f2278n;
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
                newValue[newN] = value[this.f2278n];
                this.f2278n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2278n, this.f2279f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Long2FloatOpenCustomHashMap clone() {
        try {
            Long2FloatOpenCustomHashMap c = (Long2FloatOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (long[]) this.key.clone();
            c.value = (float[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, java.lang.Object, java.util.Map
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
            h += this.strategy.hashCode(this.key[i]) ^ HashCommon.float2int(this.value[i]);
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.float2int(this.value[this.f2278n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        long[] key = this.key;
        float[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeLong(key[e]);
                s.writeFloat(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2278n = HashCommon.arraySize(this.size, this.f2279f);
        this.maxFill = HashCommon.maxFill(this.f2278n, this.f2279f);
        this.mask = this.f2278n - 1;
        long[] key = new long[this.f2278n + 1];
        this.key = key;
        float[] value = new float[this.f2278n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                long k = s.readLong();
                float v = s.readFloat();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f2278n;
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
