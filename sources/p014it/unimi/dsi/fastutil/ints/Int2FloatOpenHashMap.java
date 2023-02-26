package p014it.unimi.dsi.fastutil.ints;

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
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatConsumer;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap.class */
public class Int2FloatOpenHashMap extends AbstractInt2FloatMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient int[] key;
    protected transient float[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f2040n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2041f;
    protected transient Int2FloatMap.FastEntrySet entries;
    protected transient IntSet keys;
    protected transient FloatCollection values;

    public Int2FloatOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2041f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2040n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2040n - 1;
            this.maxFill = HashCommon.maxFill(this.f2040n, f);
            this.key = new int[this.f2040n + 1];
            this.value = new float[this.f2040n + 1];
        }
    }

    public Int2FloatOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Int2FloatOpenHashMap() {
        this(16, 0.75f);
    }

    public Int2FloatOpenHashMap(Map<? extends Integer, ? extends Float> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2FloatOpenHashMap(Map<? extends Integer, ? extends Float> m) {
        this(m, 0.75f);
    }

    public Int2FloatOpenHashMap(Int2FloatMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2FloatOpenHashMap(Int2FloatMap m) {
        this(m, 0.75f);
    }

    public Int2FloatOpenHashMap(int[] k, float[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Int2FloatOpenHashMap(int[] k, float[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2041f);
        if (needed > this.f2040n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2041f)))));
        if (needed > this.f2040n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public float removeEntry(int pos) {
        float oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2040n > this.minN && this.size < this.maxFill / 4 && this.f2040n > 16) {
            rehash(this.f2040n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public float removeNullEntry() {
        this.containsNullKey = false;
        float oldValue = this.value[this.f2040n];
        this.size--;
        if (this.f2040n > this.minN && this.size < this.maxFill / 4 && this.f2040n > 16) {
            rehash(this.f2040n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, java.util.Map
    public void putAll(Map<? extends Integer, ? extends Float> m) {
        if (((double) this.f2041f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2040n : -(this.f2040n + 1);
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

    private void insert(int pos, int k, float v) {
        if (pos == this.f2040n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2041f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatFunction
    public float put(int k, float v) {
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

    public float addTo(int k, float incr) {
        int pos;
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            pos = mix;
            int curr2 = key[mix];
            if (curr2 != 0) {
                if (curr2 == k) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (curr != k);
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2040n, incr);
        } else {
            pos = this.f2040n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2041f));
        }
        return this.defRetValue;
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
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatFunction
    public float remove(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return this.defRetValue;
        }
        if (k == curr2) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return this.defRetValue;
            }
        } while (k != curr);
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatFunction
    public float get(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2040n] : this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
        if (curr2 == 0) {
            return this.defRetValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return this.defRetValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatFunction, p014it.unimi.dsi.fastutil.ints.Int2FloatMap
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public boolean containsValue(float v) {
        float[] value = this.value;
        int[] key = this.key;
        if (this.containsNullKey && Float.floatToIntBits(value[this.f2040n]) == Float.floatToIntBits(v)) {
            return true;
        }
        int i = this.f2040n;
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatFunction
    public float getOrDefault(int k, float defaultValue) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2040n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float putIfAbsent(int k, float v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public boolean remove(int k, float v) {
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (k == curr && Float.floatToIntBits(v) == Float.floatToIntBits(this.value[pos])) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                int curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && Float.floatToIntBits(v) == Float.floatToIntBits(this.value[pos])) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || Float.floatToIntBits(v) != Float.floatToIntBits(this.value[this.f2040n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public boolean replace(int k, float oldValue, float v) {
        int pos = find(k);
        if (pos < 0 || Float.floatToIntBits(oldValue) != Float.floatToIntBits(this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float replace(int k, float v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        float oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float computeIfAbsent(int k, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        float newValue = SafeMath.safeDoubleToFloat(mappingFunction.applyAsDouble(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float computeIfAbsent(int key, Int2FloatFunction mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float computeIfAbsentNullable(int k, IntFunction<? extends Float> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float computeIfPresent(int k, BiFunction<? super Integer, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Float newValue = (Float) remappingFunction.apply(Integer.valueOf(k), Float.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float compute(int k, BiFunction<? super Integer, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Float newValue = (Float) remappingFunction.apply(Integer.valueOf(k), pos >= 0 ? Float.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap
    public float merge(int k, float v, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
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
            if (k == 0) {
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
            Arrays.fill(this.key, 0);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$MapEntry.class */
    public final class MapEntry implements Int2FloatMap.Entry, Map.Entry<Integer, Float>, IntFloatPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.Entry
        public int getIntKey() {
            return Int2FloatOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntFloatPair
        public int leftInt() {
            return Int2FloatOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.Entry
        public float getFloatValue() {
            return Int2FloatOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntFloatPair
        public float rightFloat() {
            return Int2FloatOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.Entry
        public float setValue(float v) {
            float oldValue = Int2FloatOpenHashMap.this.value[this.index];
            Int2FloatOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntFloatPair
        public IntFloatPair right(float v) {
            Int2FloatOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.Entry, java.util.Map.Entry
        @Deprecated
        public Integer getKey() {
            return Integer.valueOf(Int2FloatOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.Entry, java.util.Map.Entry
        @Deprecated
        public Float getValue() {
            return Float.valueOf(Int2FloatOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.Entry
        @Deprecated
        public Float setValue(Float v) {
            return Float.valueOf(setValue(v.floatValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Integer, Float> e = (Map.Entry) o;
            return Int2FloatOpenHashMap.this.key[this.index] == e.getKey().intValue() && Float.floatToIntBits(Int2FloatOpenHashMap.this.value[this.index]) == Float.floatToIntBits(e.getValue().floatValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Int2FloatOpenHashMap.this.key[this.index] ^ HashCommon.float2int(Int2FloatOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Int2FloatOpenHashMap.this.key[this.index] + "=>" + Int2FloatOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2042c;
        boolean mustReturnNullKey;
        IntArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Int2FloatOpenHashMap.this.f2040n;
            this.last = -1;
            this.f2042c = Int2FloatOpenHashMap.this.size;
            this.mustReturnNullKey = Int2FloatOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2042c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2042c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Int2FloatOpenHashMap.this.f2040n;
                this.last = i;
                return i;
            }
            int[] key = Int2FloatOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    int k = this.wrapped.getInt((-this.pos) - 1);
                    int mix = HashCommon.mix(k);
                    int i3 = Int2FloatOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k == key[p]) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Int2FloatOpenHashMap.this.mask;
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
                int i = Int2FloatOpenHashMap.this.f2040n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2042c--;
            }
            int[] key = Int2FloatOpenHashMap.this.key;
            while (this.f2042c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    int k = this.wrapped.getInt((-this.pos) - 1);
                    int mix = HashCommon.mix(k);
                    int i3 = Int2FloatOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k == key[p]) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Int2FloatOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2042c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2042c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            int curr;
            int[] key = Int2FloatOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Int2FloatOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(curr) & Int2FloatOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Int2FloatOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Int2FloatOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new IntArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Int2FloatOpenHashMap.this.value[pos] = Int2FloatOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Int2FloatOpenHashMap.this.f2040n) {
                Int2FloatOpenHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Int2FloatOpenHashMap.this.remove(this.wrapped.getInt((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Int2FloatOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Int2FloatMap.Entry>> implements ObjectIterator<Int2FloatMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Int2FloatMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Int2FloatMap.Entry>> implements ObjectIterator<Int2FloatMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Int2FloatMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f2043c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Int2FloatOpenHashMap.this.f2040n;
            this.f2043c = 0;
            this.mustReturnNull = Int2FloatOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Int2FloatOpenHashMap.this.f2040n;
            this.f2043c = 0;
            this.mustReturnNull = Int2FloatOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2043c++;
                acceptOnIndex(action, Int2FloatOpenHashMap.this.f2040n);
                return true;
            }
            int[] key = Int2FloatOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2043c++;
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
                this.f2043c++;
                acceptOnIndex(action, Int2FloatOpenHashMap.this.f2040n);
            }
            int[] key = Int2FloatOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2043c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Int2FloatOpenHashMap.this.size - this.f2043c);
            }
            return Math.min((long) (Int2FloatOpenHashMap.this.size - this.f2043c), ((long) ((((double) Int2FloatOpenHashMap.this.realSize()) / ((double) Int2FloatOpenHashMap.this.f2040n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap r0 = p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Int2FloatMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Int2FloatMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Int2FloatMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Int2FloatMap.Entry> implements Int2FloatMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Int2FloatMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.FastEntrySet
        public ObjectIterator<Int2FloatMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2FloatMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            int curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            float v = ((Float) e.getValue()).floatValue();
            if (k == 0) {
                return Int2FloatOpenHashMap.this.containsNullKey && Float.floatToIntBits(Int2FloatOpenHashMap.this.value[Int2FloatOpenHashMap.this.f2040n]) == Float.floatToIntBits(v);
            }
            int[] key = Int2FloatOpenHashMap.this.key;
            int mix = HashCommon.mix(k) & Int2FloatOpenHashMap.this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Float.floatToIntBits(Int2FloatOpenHashMap.this.value[pos]) == Float.floatToIntBits(v);
            }
            do {
                int i = (pos + 1) & Int2FloatOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Float.floatToIntBits(Int2FloatOpenHashMap.this.value[pos]) == Float.floatToIntBits(v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            float v = ((Float) e.getValue()).floatValue();
            if (k != 0) {
                int[] key = Int2FloatOpenHashMap.this.key;
                int mix = HashCommon.mix(k) & Int2FloatOpenHashMap.this.mask;
                int pos = mix;
                int curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Int2FloatOpenHashMap.this.mask;
                        pos = i;
                        int curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Float.floatToIntBits(Int2FloatOpenHashMap.this.value[pos]) == Float.floatToIntBits(v)) {
                            Int2FloatOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Float.floatToIntBits(Int2FloatOpenHashMap.this.value[pos]) != Float.floatToIntBits(v)) {
                    return false;
                } else {
                    Int2FloatOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Int2FloatOpenHashMap.this.containsNullKey || Float.floatToIntBits(Int2FloatOpenHashMap.this.value[Int2FloatOpenHashMap.this.f2040n]) != Float.floatToIntBits(v)) {
                return false;
            } else {
                Int2FloatOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2FloatOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2FloatOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2FloatMap.Entry> consumer) {
            if (Int2FloatOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractInt2FloatMap.BasicEntry(Int2FloatOpenHashMap.this.key[Int2FloatOpenHashMap.this.f2040n], Int2FloatOpenHashMap.this.value[Int2FloatOpenHashMap.this.f2040n]));
            }
            int pos = Int2FloatOpenHashMap.this.f2040n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Int2FloatOpenHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractInt2FloatMap.BasicEntry(Int2FloatOpenHashMap.this.key[pos], Int2FloatOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2FloatMap.Entry> consumer) {
            AbstractInt2FloatMap.BasicEntry entry = new AbstractInt2FloatMap.BasicEntry();
            if (Int2FloatOpenHashMap.this.containsNullKey) {
                entry.key = Int2FloatOpenHashMap.this.key[Int2FloatOpenHashMap.this.f2040n];
                entry.value = Int2FloatOpenHashMap.this.value[Int2FloatOpenHashMap.this.f2040n];
                consumer.accept(entry);
            }
            int pos = Int2FloatOpenHashMap.this.f2040n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Int2FloatOpenHashMap.this.key[pos] != 0) {
                    entry.key = Int2FloatOpenHashMap.this.key[pos];
                    entry.value = Int2FloatOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
    public Int2FloatMap.FastEntrySet int2FloatEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<IntConsumer> implements IntIterator {
        @Override // java.util.PrimitiveIterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            forEachRemaining((KeyIterator) intConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(IntConsumer action, int index) {
            action.accept(Int2FloatOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return Int2FloatOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<IntConsumer, KeySpliterator> implements IntSpliterator {
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
            action.accept(Int2FloatOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$KeySet.class */
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
            if (Int2FloatOpenHashMap.this.containsNullKey) {
                consumer.accept(Int2FloatOpenHashMap.this.key[Int2FloatOpenHashMap.this.f2040n]);
            }
            int pos = Int2FloatOpenHashMap.this.f2040n;
            while (true) {
                pos--;
                if (pos != 0) {
                    int k = Int2FloatOpenHashMap.this.key[pos];
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
            return Int2FloatOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2FloatOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldSize = Int2FloatOpenHashMap.this.size;
            Int2FloatOpenHashMap.this.remove(k);
            return Int2FloatOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2FloatOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
    public Set<Integer> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$ValueIterator.class */
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
            action.accept(Int2FloatOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return Int2FloatOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatOpenHashMap$ValueSpliterator.class */
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
            action.accept(Int2FloatOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
    public Collection<Float> values() {
        if (this.values == null) {
            this.values = new AbstractFloatCollection() { // from class: it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap.1
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
                    if (Int2FloatOpenHashMap.this.containsNullKey) {
                        consumer.accept(Int2FloatOpenHashMap.this.value[Int2FloatOpenHashMap.this.f2040n]);
                    }
                    int pos = Int2FloatOpenHashMap.this.f2040n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Int2FloatOpenHashMap.this.key[pos] != 0) {
                            consumer.accept(Int2FloatOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Int2FloatOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
                public boolean contains(float v) {
                    return Int2FloatOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Int2FloatOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2041f)));
        if (l >= this.f2040n || this.size > HashCommon.maxFill(l, this.f2041f)) {
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
        float[] value = this.value;
        int mask = newN - 1;
        int[] newKey = new int[newN + 1];
        float[] newValue = new float[newN + 1];
        int i2 = this.f2040n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == 0);
                int mix = HashCommon.mix(key[i2]) & mask;
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
                newValue[newN] = value[this.f2040n];
                this.f2040n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2040n, this.f2041f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Int2FloatOpenHashMap clone() {
        try {
            Int2FloatOpenHashMap c = (Int2FloatOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (int[]) this.key.clone();
            c.value = (float[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap, java.lang.Object, java.util.Map
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
            h += this.key[i] ^ HashCommon.float2int(this.value[i]);
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.float2int(this.value[this.f2040n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int[] key = this.key;
        float[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeInt(key[e]);
                s.writeFloat(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2040n = HashCommon.arraySize(this.size, this.f2041f);
        this.maxFill = HashCommon.maxFill(this.f2040n, this.f2041f);
        this.mask = this.f2040n - 1;
        int[] key = new int[this.f2040n + 1];
        this.key = key;
        float[] value = new float[this.f2040n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                int k = s.readInt();
                float v = s.readFloat();
                if (k == 0) {
                    pos = this.f2040n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(k);
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
