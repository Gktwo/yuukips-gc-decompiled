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
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap;
import p014it.unimi.dsi.fastutil.shorts.Short2CharMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap.class */
public class Short2CharOpenHashMap extends AbstractShort2CharMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient short[] key;
    protected transient char[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f2888n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2889f;
    protected transient Short2CharMap.FastEntrySet entries;
    protected transient ShortSet keys;
    protected transient CharCollection values;

    public Short2CharOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2889f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2888n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2888n - 1;
            this.maxFill = HashCommon.maxFill(this.f2888n, f);
            this.key = new short[this.f2888n + 1];
            this.value = new char[this.f2888n + 1];
        }
    }

    public Short2CharOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Short2CharOpenHashMap() {
        this(16, 0.75f);
    }

    public Short2CharOpenHashMap(Map<? extends Short, ? extends Character> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2CharOpenHashMap(Map<? extends Short, ? extends Character> m) {
        this(m, 0.75f);
    }

    public Short2CharOpenHashMap(Short2CharMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2CharOpenHashMap(Short2CharMap m) {
        this(m, 0.75f);
    }

    public Short2CharOpenHashMap(short[] k, char[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Short2CharOpenHashMap(short[] k, char[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2889f);
        if (needed > this.f2888n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2889f)))));
        if (needed > this.f2888n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public char removeEntry(int pos) {
        char oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2888n > this.minN && this.size < this.maxFill / 4 && this.f2888n > 16) {
            rehash(this.f2888n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public char removeNullEntry() {
        this.containsNullKey = false;
        char oldValue = this.value[this.f2888n];
        this.size--;
        if (this.f2888n > this.minN && this.size < this.maxFill / 4 && this.f2888n > 16) {
            rehash(this.f2888n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap, java.util.Map
    public void putAll(Map<? extends Short, ? extends Character> m) {
        if (((double) this.f2889f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2888n : -(this.f2888n + 1);
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

    private void insert(int pos, short k, char v) {
        if (pos == this.f2888n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2889f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
    public char put(short k, char v) {
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

    public char addTo(short k, char incr) {
        int pos;
        short curr;
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            short curr2 = key[mix];
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
            return addToValue(this.f2888n, incr);
        } else {
            pos = this.f2888n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (char) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2889f));
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
    public char remove(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
    public char get(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2888n] : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharFunction, p014it.unimi.dsi.fastutil.shorts.Short2CharMap
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public boolean containsValue(char v) {
        char[] value = this.value;
        short[] key = this.key;
        if (this.containsNullKey && value[this.f2888n] == v) {
            return true;
        }
        int i = this.f2888n;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
    public char getOrDefault(short k, char defaultValue) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2888n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char putIfAbsent(short k, char v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public boolean remove(short k, char v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2888n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public boolean replace(short k, char oldValue, char v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char replace(short k, char v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char computeIfAbsent(short k, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char computeIfAbsent(short key, Short2CharFunction mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char computeIfAbsentNullable(short k, IntFunction<? extends Character> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Character newValue = (Character) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        char v = newValue.charValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char computeIfPresent(short k, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Character newValue = (Character) remappingFunction.apply(Short.valueOf(k), Character.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char compute(short k, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Character newValue = (Character) remappingFunction.apply(Short.valueOf(k), pos >= 0 ? Character.valueOf(this.value[pos]) : null);
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
        char newVal = newValue.charValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
    public char merge(short k, char v, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
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
            if (k == 0) {
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
            Arrays.fill(this.key, (short) 0);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$MapEntry.class */
    public final class MapEntry implements Short2CharMap.Entry, Map.Entry<Short, Character>, ShortCharPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.Entry
        public short getShortKey() {
            return Short2CharOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
        public short leftShort() {
            return Short2CharOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.Entry
        public char getCharValue() {
            return Short2CharOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
        public char rightChar() {
            return Short2CharOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.Entry
        public char setValue(char v) {
            char oldValue = Short2CharOpenHashMap.this.value[this.index];
            Short2CharOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
        public ShortCharPair right(char v) {
            Short2CharOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getKey() {
            return Short.valueOf(Short2CharOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getValue() {
            return Character.valueOf(Short2CharOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.Entry
        @Deprecated
        public Character setValue(Character v) {
            return Character.valueOf(setValue(v.charValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Short, Character> e = (Map.Entry) o;
            return Short2CharOpenHashMap.this.key[this.index] == e.getKey().shortValue() && Short2CharOpenHashMap.this.value[this.index] == e.getValue().charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Short2CharOpenHashMap.this.key[this.index] ^ Short2CharOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Short2CharOpenHashMap.this.key[this.index]) + "=>" + Short2CharOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2890c;
        boolean mustReturnNullKey;
        ShortArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Short2CharOpenHashMap.this.f2888n;
            this.last = -1;
            this.f2890c = Short2CharOpenHashMap.this.size;
            this.mustReturnNullKey = Short2CharOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2890c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2890c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Short2CharOpenHashMap.this.f2888n;
                this.last = i;
                return i;
            }
            short[] key = Short2CharOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Short2CharOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k == key[p]) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Short2CharOpenHashMap.this.mask;
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
                int i = Short2CharOpenHashMap.this.f2888n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2890c--;
            }
            short[] key = Short2CharOpenHashMap.this.key;
            while (this.f2890c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Short2CharOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k == key[p]) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Short2CharOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2890c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2890c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            short curr;
            short[] key = Short2CharOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Short2CharOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix((int) curr) & Short2CharOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2CharOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2CharOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ShortArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Short2CharOpenHashMap.this.value[pos] = Short2CharOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Short2CharOpenHashMap.this.f2888n) {
                Short2CharOpenHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Short2CharOpenHashMap.this.remove(this.wrapped.getShort((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Short2CharOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Short2CharMap.Entry>> implements ObjectIterator<Short2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Short2CharMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Short2CharMap.Entry>> implements ObjectIterator<Short2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Short2CharMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f2891c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Short2CharOpenHashMap.this.f2888n;
            this.f2891c = 0;
            this.mustReturnNull = Short2CharOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Short2CharOpenHashMap.this.f2888n;
            this.f2891c = 0;
            this.mustReturnNull = Short2CharOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2891c++;
                acceptOnIndex(action, Short2CharOpenHashMap.this.f2888n);
                return true;
            }
            short[] key = Short2CharOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2891c++;
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
                this.f2891c++;
                acceptOnIndex(action, Short2CharOpenHashMap.this.f2888n);
            }
            short[] key = Short2CharOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2891c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Short2CharOpenHashMap.this.size - this.f2891c);
            }
            return Math.min((long) (Short2CharOpenHashMap.this.size - this.f2891c), ((long) ((((double) Short2CharOpenHashMap.this.realSize()) / ((double) Short2CharOpenHashMap.this.f2888n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap r0 = p014it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Short2CharMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Short2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Short2CharMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Short2CharMap.Entry> implements Short2CharMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Short2CharMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.FastEntrySet
        public ObjectIterator<Short2CharMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2CharMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            short curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            char v = ((Character) e.getValue()).charValue();
            if (k == 0) {
                return Short2CharOpenHashMap.this.containsNullKey && Short2CharOpenHashMap.this.value[Short2CharOpenHashMap.this.f2888n] == v;
            }
            short[] key = Short2CharOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Short2CharOpenHashMap.this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Short2CharOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Short2CharOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Short2CharOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            char v = ((Character) e.getValue()).charValue();
            if (k != 0) {
                short[] key = Short2CharOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Short2CharOpenHashMap.this.mask;
                int pos = mix;
                short curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Short2CharOpenHashMap.this.mask;
                        pos = i;
                        short curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Short2CharOpenHashMap.this.value[pos] == v) {
                            Short2CharOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Short2CharOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Short2CharOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Short2CharOpenHashMap.this.containsNullKey || Short2CharOpenHashMap.this.value[Short2CharOpenHashMap.this.f2888n] != v) {
                return false;
            } else {
                Short2CharOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2CharOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2CharOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2CharMap.Entry> consumer) {
            if (Short2CharOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractShort2CharMap.BasicEntry(Short2CharOpenHashMap.this.key[Short2CharOpenHashMap.this.f2888n], Short2CharOpenHashMap.this.value[Short2CharOpenHashMap.this.f2888n]));
            }
            int pos = Short2CharOpenHashMap.this.f2888n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2CharOpenHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractShort2CharMap.BasicEntry(Short2CharOpenHashMap.this.key[pos], Short2CharOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2CharMap.Entry> consumer) {
            AbstractShort2CharMap.BasicEntry entry = new AbstractShort2CharMap.BasicEntry();
            if (Short2CharOpenHashMap.this.containsNullKey) {
                entry.key = Short2CharOpenHashMap.this.key[Short2CharOpenHashMap.this.f2888n];
                entry.value = Short2CharOpenHashMap.this.value[Short2CharOpenHashMap.this.f2888n];
                consumer.accept(entry);
            }
            int pos = Short2CharOpenHashMap.this.f2888n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2CharOpenHashMap.this.key[pos] != 0) {
                    entry.key = Short2CharOpenHashMap.this.key[pos];
                    entry.value = Short2CharOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharSortedMap
    public Short2CharMap.FastEntrySet short2CharEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$KeyIterator.class */
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
            action.accept(Short2CharOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Short2CharOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$KeySpliterator.class */
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
            action.accept(Short2CharOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$KeySet.class */
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
            if (Short2CharOpenHashMap.this.containsNullKey) {
                consumer.accept(Short2CharOpenHashMap.this.key[Short2CharOpenHashMap.this.f2888n]);
            }
            int pos = Short2CharOpenHashMap.this.f2888n;
            while (true) {
                pos--;
                if (pos != 0) {
                    short k = Short2CharOpenHashMap.this.key[pos];
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
            return Short2CharOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2CharOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldSize = Short2CharOpenHashMap.this.size;
            Short2CharOpenHashMap.this.remove(k);
            return Short2CharOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2CharOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
    public Set<Short> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$ValueIterator.class */
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
            action.accept(Short2CharOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Short2CharOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharOpenHashMap$ValueSpliterator.class */
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
            action.accept(Short2CharOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
    public Collection<Character> values() {
        if (this.values == null) {
            this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.shorts.Short2CharOpenHashMap.1
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
                    if (Short2CharOpenHashMap.this.containsNullKey) {
                        consumer.accept(Short2CharOpenHashMap.this.value[Short2CharOpenHashMap.this.f2888n]);
                    }
                    int pos = Short2CharOpenHashMap.this.f2888n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Short2CharOpenHashMap.this.key[pos] != 0) {
                            consumer.accept(Short2CharOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Short2CharOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                public boolean contains(char v) {
                    return Short2CharOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Short2CharOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2889f)));
        if (l >= this.f2888n || this.size > HashCommon.maxFill(l, this.f2889f)) {
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
        char[] value = this.value;
        int mask = newN - 1;
        short[] newKey = new short[newN + 1];
        char[] newValue = new char[newN + 1];
        int i2 = this.f2888n;
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
                newValue[newN] = value[this.f2888n];
                this.f2888n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2888n, this.f2889f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Short2CharOpenHashMap clone() {
        try {
            Short2CharOpenHashMap c = (Short2CharOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (short[]) this.key.clone();
            c.value = (char[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap, java.lang.Object, java.util.Map
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
            h += this.key[i] ^ this.value[i];
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2888n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        short[] key = this.key;
        char[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeShort(key[e]);
                s.writeChar(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2888n = HashCommon.arraySize(this.size, this.f2889f);
        this.maxFill = HashCommon.maxFill(this.f2888n, this.f2889f);
        this.mask = this.f2888n - 1;
        short[] key = new short[this.f2888n + 1];
        this.key = key;
        char[] value = new char[this.f2888n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                short k = s.readShort();
                char v = s.readChar();
                if (k == 0) {
                    pos = this.f2888n;
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
                value[pos] = v;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
