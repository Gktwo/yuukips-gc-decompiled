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
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap;
import p014it.unimi.dsi.fastutil.floats.Float2CharMap;
import p014it.unimi.dsi.fastutil.floats.FloatHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap.class */
public class Float2CharOpenCustomHashMap extends AbstractFloat2CharMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient float[] key;
    protected transient char[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected FloatHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f1791n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1792f;
    protected transient Float2CharMap.FastEntrySet entries;
    protected transient FloatSet keys;
    protected transient CharCollection values;

    public Float2CharOpenCustomHashMap(int expected, float f, FloatHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1792f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1791n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1791n - 1;
            this.maxFill = HashCommon.maxFill(this.f1791n, f);
            this.key = new float[this.f1791n + 1];
            this.value = new char[this.f1791n + 1];
        }
    }

    public Float2CharOpenCustomHashMap(int expected, FloatHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Float2CharOpenCustomHashMap(FloatHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Float2CharOpenCustomHashMap(Map<? extends Float, ? extends Character> m, float f, FloatHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Float2CharOpenCustomHashMap(Map<? extends Float, ? extends Character> m, FloatHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Float2CharOpenCustomHashMap(Float2CharMap m, float f, FloatHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Float2CharOpenCustomHashMap(Float2CharMap m, FloatHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Float2CharOpenCustomHashMap(float[] k, char[] v, float f, FloatHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Float2CharOpenCustomHashMap(float[] k, char[] v, FloatHash.Strategy strategy) {
        this(k, v, 0.75f, strategy);
    }

    public FloatHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1792f);
        if (needed > this.f1791n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1792f)))));
        if (needed > this.f1791n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public char removeEntry(int pos) {
        char oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f1791n > this.minN && this.size < this.maxFill / 4 && this.f1791n > 16) {
            rehash(this.f1791n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public char removeNullEntry() {
        this.containsNullKey = false;
        char oldValue = this.value[this.f1791n];
        this.size--;
        if (this.f1791n > this.minN && this.size < this.maxFill / 4 && this.f1791n > 16) {
            rehash(this.f1791n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, java.util.Map
    public void putAll(Map<? extends Float, ? extends Character> m) {
        if (((double) this.f1792f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(float k) {
        float curr;
        if (this.strategy.equals(k, 0.0f)) {
            return this.containsNullKey ? this.f1791n : -(this.f1791n + 1);
        }
        float[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return -(pos + 1);
        }
        if (this.strategy.equals(k, curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return -(pos + 1);
            }
        } while (!this.strategy.equals(k, curr));
        return pos;
    }

    private void insert(int pos, float k, char v) {
        if (pos == this.f1791n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1792f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
    public char put(float k, char v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private char addToValue(int pos, char incr) {
        char oldValue = this.value[pos];
        this.value[pos] = (char) (oldValue + incr);
        return oldValue;
    }

    public char addTo(float k, char incr) {
        int pos;
        float curr;
        if (!this.strategy.equals(k, 0.0f)) {
            float[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) != 0) {
                if (this.strategy.equals(curr2, k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Float.floatToIntBits(curr) != 0) {
                    }
                } while (!this.strategy.equals(curr, k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f1791n, incr);
        } else {
            pos = this.f1791n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (char) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1792f));
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
    public char remove(float k) {
        float curr;
        if (this.strategy.equals(k, 0.0f)) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
    public char get(float k) {
        float curr;
        if (this.strategy.equals(k, 0.0f)) {
            return this.containsNullKey ? this.value[this.f1791n] : this.defRetValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharFunction, p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean containsKey(float k) {
        float curr;
        if (this.strategy.equals(k, 0.0f)) {
            return this.containsNullKey;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean containsValue(char v) {
        char[] value = this.value;
        float[] key = this.key;
        if (this.containsNullKey && value[this.f1791n] == v) {
            return true;
        }
        int i = this.f1791n;
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
    public char getOrDefault(float k, char defaultValue) {
        float curr;
        if (this.strategy.equals(k, 0.0f)) {
            return this.containsNullKey ? this.value[this.f1791n] : defaultValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return defaultValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return defaultValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char putIfAbsent(float k, char v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean remove(float k, char v) {
        if (!this.strategy.equals(k, 0.0f)) {
            float[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            float curr = key[mix];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    float curr2 = key[i];
                    if (Float.floatToIntBits(curr2) == 0) {
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
        } else if (!this.containsNullKey || v != this.value[this.f1791n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean replace(float k, char oldValue, char v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char replace(float k, char v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char computeIfAbsent(float k, DoubleToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt((double) k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char computeIfAbsent(float key, Float2CharFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        char newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char computeIfAbsentNullable(float k, DoubleFunction<? extends Character> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Character newValue = (Character) mappingFunction.apply((double) k);
        if (newValue == null) {
            return this.defRetValue;
        }
        char v = newValue.charValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char computeIfPresent(float k, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Character newValue = (Character) remappingFunction.apply(Float.valueOf(k), Character.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, 0.0f)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        char[] cArr = this.value;
        char charValue = newValue.charValue();
        cArr[pos] = charValue;
        return charValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char compute(float k, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Character newValue = (Character) remappingFunction.apply(Float.valueOf(k), pos >= 0 ? Character.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (this.strategy.equals(k, 0.0f)) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return this.defRetValue;
        }
        char newVal = newValue.charValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public char merge(float k, char v, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
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
        Character newValue = (Character) remappingFunction.apply(Character.valueOf(this.value[pos]), Character.valueOf(v));
        if (newValue == null) {
            if (this.strategy.equals(k, 0.0f)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        char[] cArr = this.value;
        char charValue = newValue.charValue();
        cArr[pos] = charValue;
        return charValue;
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Float2CharMap.Entry, Map.Entry<Float, Character>, FloatCharPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry
        public float getFloatKey() {
            return Float2CharOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCharPair
        public float leftFloat() {
            return Float2CharOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry
        public char getCharValue() {
            return Float2CharOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCharPair
        public char rightChar() {
            return Float2CharOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry
        public char setValue(char v) {
            char oldValue = Float2CharOpenCustomHashMap.this.value[this.index];
            Float2CharOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatCharPair
        public FloatCharPair right(char v) {
            Float2CharOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Float getKey() {
            return Float.valueOf(Float2CharOpenCustomHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getValue() {
            return Character.valueOf(Float2CharOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry
        @Deprecated
        public Character setValue(Character v) {
            return Character.valueOf(setValue(v.charValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Float, Character> e = (Map.Entry) o;
            return Float2CharOpenCustomHashMap.this.strategy.equals(Float2CharOpenCustomHashMap.this.key[this.index], e.getKey().floatValue()) && Float2CharOpenCustomHashMap.this.value[this.index] == e.getValue().charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Float2CharOpenCustomHashMap.this.strategy.hashCode(Float2CharOpenCustomHashMap.this.key[this.index]) ^ Float2CharOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Float2CharOpenCustomHashMap.this.key[this.index] + "=>" + Float2CharOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1793c;
        boolean mustReturnNullKey;
        FloatArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Float2CharOpenCustomHashMap.this.f1791n;
            this.last = -1;
            this.f1793c = Float2CharOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Float2CharOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1793c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1793c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Float2CharOpenCustomHashMap.this.f1791n;
                this.last = i;
                return i;
            }
            float[] key = Float2CharOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    float k = this.wrapped.getFloat((-this.pos) - 1);
                    int mix = HashCommon.mix(Float2CharOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Float2CharOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Float2CharOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Float2CharOpenCustomHashMap.this.mask;
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
                int i = Float2CharOpenCustomHashMap.this.f1791n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1793c--;
            }
            float[] key = Float2CharOpenCustomHashMap.this.key;
            while (this.f1793c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    float k = this.wrapped.getFloat((-this.pos) - 1);
                    int mix = HashCommon.mix(Float2CharOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Float2CharOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Float2CharOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Float2CharOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1793c--;
                } else if (Float.floatToIntBits(key[this.pos]) != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1793c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            float curr;
            float[] key = Float2CharOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Float2CharOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (Float.floatToIntBits(curr) == 0) {
                        key[pos] = 0.0f;
                        return;
                    }
                    int slot = HashCommon.mix(Float2CharOpenCustomHashMap.this.strategy.hashCode(curr)) & Float2CharOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Float2CharOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Float2CharOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new FloatArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Float2CharOpenCustomHashMap.this.value[pos] = Float2CharOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Float2CharOpenCustomHashMap.this.f1791n) {
                Float2CharOpenCustomHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Float2CharOpenCustomHashMap.this.remove(this.wrapped.getFloat((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Float2CharOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Float2CharMap.Entry>> implements ObjectIterator<Float2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2CharMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Float2CharMap.Entry>> implements ObjectIterator<Float2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2CharMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f1794c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Float2CharOpenCustomHashMap.this.f1791n;
            this.f1794c = 0;
            this.mustReturnNull = Float2CharOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Float2CharOpenCustomHashMap.this.f1791n;
            this.f1794c = 0;
            this.mustReturnNull = Float2CharOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1794c++;
                acceptOnIndex(action, Float2CharOpenCustomHashMap.this.f1791n);
                return true;
            }
            float[] key = Float2CharOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    this.f1794c++;
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
                this.f1794c++;
                acceptOnIndex(action, Float2CharOpenCustomHashMap.this.f1791n);
            }
            float[] key = Float2CharOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1794c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Float2CharOpenCustomHashMap.this.size - this.f1794c);
            }
            return Math.min((long) (Float2CharOpenCustomHashMap.this.size - this.f1794c), ((long) ((((double) Float2CharOpenCustomHashMap.this.realSize()) / ((double) Float2CharOpenCustomHashMap.this.f1791n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Float2CharMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Float2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2CharMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Float2CharMap.Entry> implements Float2CharMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Float2CharMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.FastEntrySet
        public ObjectIterator<Float2CharMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2CharMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            float curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            char v = ((Character) e.getValue()).charValue();
            if (Float2CharOpenCustomHashMap.this.strategy.equals(k, 0.0f)) {
                return Float2CharOpenCustomHashMap.this.containsNullKey && Float2CharOpenCustomHashMap.this.value[Float2CharOpenCustomHashMap.this.f1791n] == v;
            }
            float[] key = Float2CharOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Float2CharOpenCustomHashMap.this.strategy.hashCode(k)) & Float2CharOpenCustomHashMap.this.mask;
            int pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) == 0) {
                return false;
            }
            if (Float2CharOpenCustomHashMap.this.strategy.equals(k, curr2)) {
                return Float2CharOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Float2CharOpenCustomHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
            } while (!Float2CharOpenCustomHashMap.this.strategy.equals(k, curr));
            return Float2CharOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            char v = ((Character) e.getValue()).charValue();
            if (!Float2CharOpenCustomHashMap.this.strategy.equals(k, 0.0f)) {
                float[] key = Float2CharOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Float2CharOpenCustomHashMap.this.strategy.hashCode(k)) & Float2CharOpenCustomHashMap.this.mask;
                int pos = mix;
                float curr = key[mix];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
                if (!Float2CharOpenCustomHashMap.this.strategy.equals(curr, k)) {
                    while (true) {
                        int i = (pos + 1) & Float2CharOpenCustomHashMap.this.mask;
                        pos = i;
                        float curr2 = key[i];
                        if (Float.floatToIntBits(curr2) == 0) {
                            return false;
                        }
                        if (Float2CharOpenCustomHashMap.this.strategy.equals(curr2, k) && Float2CharOpenCustomHashMap.this.value[pos] == v) {
                            Float2CharOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Float2CharOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Float2CharOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Float2CharOpenCustomHashMap.this.containsNullKey || Float2CharOpenCustomHashMap.this.value[Float2CharOpenCustomHashMap.this.f1791n] != v) {
                return false;
            } else {
                Float2CharOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2CharOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2CharOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Float2CharMap.Entry> consumer) {
            if (Float2CharOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractFloat2CharMap.BasicEntry(Float2CharOpenCustomHashMap.this.key[Float2CharOpenCustomHashMap.this.f1791n], Float2CharOpenCustomHashMap.this.value[Float2CharOpenCustomHashMap.this.f1791n]));
            }
            int pos = Float2CharOpenCustomHashMap.this.f1791n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Float.floatToIntBits(Float2CharOpenCustomHashMap.this.key[pos]) != 0) {
                    consumer.accept(new AbstractFloat2CharMap.BasicEntry(Float2CharOpenCustomHashMap.this.key[pos], Float2CharOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Float2CharMap.Entry> consumer) {
            AbstractFloat2CharMap.BasicEntry entry = new AbstractFloat2CharMap.BasicEntry();
            if (Float2CharOpenCustomHashMap.this.containsNullKey) {
                entry.key = Float2CharOpenCustomHashMap.this.key[Float2CharOpenCustomHashMap.this.f1791n];
                entry.value = Float2CharOpenCustomHashMap.this.value[Float2CharOpenCustomHashMap.this.f1791n];
                consumer.accept(entry);
            }
            int pos = Float2CharOpenCustomHashMap.this.f1791n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Float.floatToIntBits(Float2CharOpenCustomHashMap.this.key[pos]) != 0) {
                    entry.key = Float2CharOpenCustomHashMap.this.key[pos];
                    entry.value = Float2CharOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
    public Float2CharMap.FastEntrySet float2CharEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$KeyIterator.class */
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
            action.accept(Float2CharOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return Float2CharOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$KeySpliterator.class */
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
            action.accept(Float2CharOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$KeySet.class */
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
            if (Float2CharOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Float2CharOpenCustomHashMap.this.key[Float2CharOpenCustomHashMap.this.f1791n]);
            }
            int pos = Float2CharOpenCustomHashMap.this.f1791n;
            while (true) {
                pos--;
                if (pos != 0) {
                    float k = Float2CharOpenCustomHashMap.this.key[pos];
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
            return Float2CharOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float2CharOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            int oldSize = Float2CharOpenCustomHashMap.this.size;
            Float2CharOpenCustomHashMap.this.remove(k);
            return Float2CharOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2CharOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    public Set<Float> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<CharConsumer> implements CharIterator {
        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(CharConsumer charConsumer) {
            forEachRemaining((ValueIterator) charConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Float2CharOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Float2CharOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends MapSpliterator<CharConsumer, ValueSpliterator> implements CharSpliterator {
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
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Float2CharOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    public Collection<Character> values() {
        if (this.values == null) {
            this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.floats.Float2CharOpenCustomHashMap.1
                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
                public CharIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
                public CharSpliterator spliterator() {
                    return new ValueSpliterator();
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
                public void forEach(CharConsumer consumer) {
                    if (Float2CharOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Float2CharOpenCustomHashMap.this.value[Float2CharOpenCustomHashMap.this.f1791n]);
                    }
                    int pos = Float2CharOpenCustomHashMap.this.f1791n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Float.floatToIntBits(Float2CharOpenCustomHashMap.this.key[pos]) != 0) {
                            consumer.accept(Float2CharOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Float2CharOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                public boolean contains(char v) {
                    return Float2CharOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Float2CharOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1792f)));
        if (l >= this.f1791n || this.size > HashCommon.maxFill(l, this.f1792f)) {
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
        char[] value = this.value;
        int mask = newN - 1;
        float[] newKey = new float[newN + 1];
        char[] newValue = new char[newN + 1];
        int i2 = this.f1791n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (Float.floatToIntBits(key[i2]) == 0);
                int mix = HashCommon.mix(this.strategy.hashCode(key[i2])) & mask;
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
                newValue[newN] = value[this.f1791n];
                this.f1791n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1791n, this.f1792f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Float2CharOpenCustomHashMap clone() {
        try {
            Float2CharOpenCustomHashMap c = (Float2CharOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (float[]) this.key.clone();
            c.value = (char[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap, java.lang.Object, java.util.Map
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
            h += this.strategy.hashCode(this.key[i]) ^ this.value[i];
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1791n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        float[] key = this.key;
        char[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeFloat(key[e]);
                s.writeChar(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1791n = HashCommon.arraySize(this.size, this.f1792f);
        this.maxFill = HashCommon.maxFill(this.f1791n, this.f1792f);
        this.mask = this.f1791n - 1;
        float[] key = new float[this.f1791n + 1];
        this.key = key;
        char[] value = new char[this.f1791n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                float k = s.readFloat();
                char v = s.readChar();
                if (this.strategy.equals(k, 0.0f)) {
                    pos = this.f1791n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(this.strategy.hashCode(k));
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
