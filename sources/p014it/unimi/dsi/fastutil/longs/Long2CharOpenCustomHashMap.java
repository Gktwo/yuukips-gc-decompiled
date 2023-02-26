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
import java.util.function.LongToIntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap;
import p014it.unimi.dsi.fastutil.longs.Long2CharMap;
import p014it.unimi.dsi.fastutil.longs.LongHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap.class */
public class Long2CharOpenCustomHashMap extends AbstractLong2CharMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient long[] key;
    protected transient char[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected LongHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f2254n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2255f;
    protected transient Long2CharMap.FastEntrySet entries;
    protected transient LongSet keys;
    protected transient CharCollection values;

    public Long2CharOpenCustomHashMap(int expected, float f, LongHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2255f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2254n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2254n - 1;
            this.maxFill = HashCommon.maxFill(this.f2254n, f);
            this.key = new long[this.f2254n + 1];
            this.value = new char[this.f2254n + 1];
        }
    }

    public Long2CharOpenCustomHashMap(int expected, LongHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Long2CharOpenCustomHashMap(LongHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Long2CharOpenCustomHashMap(Map<? extends Long, ? extends Character> m, float f, LongHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Long2CharOpenCustomHashMap(Map<? extends Long, ? extends Character> m, LongHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Long2CharOpenCustomHashMap(Long2CharMap m, float f, LongHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Long2CharOpenCustomHashMap(Long2CharMap m, LongHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Long2CharOpenCustomHashMap(long[] k, char[] v, float f, LongHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Long2CharOpenCustomHashMap(long[] k, char[] v, LongHash.Strategy strategy) {
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
        int needed = HashCommon.arraySize(capacity, this.f2255f);
        if (needed > this.f2254n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2255f)))));
        if (needed > this.f2254n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public char removeEntry(int pos) {
        char oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2254n > this.minN && this.size < this.maxFill / 4 && this.f2254n > 16) {
            rehash(this.f2254n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public char removeNullEntry() {
        this.containsNullKey = false;
        char oldValue = this.value[this.f2254n];
        this.size--;
        if (this.f2254n > this.minN && this.size < this.maxFill / 4 && this.f2254n > 16) {
            rehash(this.f2254n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, java.util.Map
    public void putAll(Map<? extends Long, ? extends Character> m) {
        if (((double) this.f2255f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.f2254n : -(this.f2254n + 1);
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

    private void insert(int pos, long k, char v) {
        if (pos == this.f2254n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2255f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public char put(long k, char v) {
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

    public char addTo(long k, char incr) {
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
            return addToValue(this.f2254n, incr);
        } else {
            pos = this.f2254n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (char) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2255f));
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public char remove(long k) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public char get(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2254n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public boolean containsValue(char v) {
        char[] value = this.value;
        long[] key = this.key;
        if (this.containsNullKey && value[this.f2254n] == v) {
            return true;
        }
        int i = this.f2254n;
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public char getOrDefault(long k, char defaultValue) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2254n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char putIfAbsent(long k, char v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public boolean remove(long k, char v) {
        if (!this.strategy.equals(k, 0)) {
            long[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            if (key[mix] == 0) {
                return false;
            }
            if (!this.strategy.equals(k, mix) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    if (key[i] == 0) {
                        return false;
                    }
                    if (this.strategy.equals(k, i) && v == this.value[pos]) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || v != this.value[this.f2254n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public boolean replace(long k, char oldValue, char v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char replace(long k, char v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char computeIfAbsent(long k, LongToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char computeIfAbsent(long key, Long2CharFunction mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char computeIfAbsentNullable(long k, LongFunction<? extends Character> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char computeIfPresent(long k, BiFunction<? super Long, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Character newValue = (Character) remappingFunction.apply(Long.valueOf(k), Character.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, 0)) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char compute(long k, BiFunction<? super Long, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Character newValue = (Character) remappingFunction.apply(Long.valueOf(k), pos >= 0 ? Character.valueOf(this.value[pos]) : null);
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
        char newVal = newValue.charValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public char merge(long k, char v, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
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
            if (this.strategy.equals(k, 0)) {
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
            Arrays.fill(this.key, 0L);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Long2CharMap.Entry, Map.Entry<Long, Character>, LongCharPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.Entry
        public long getLongKey() {
            return Long2CharOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
        public long leftLong() {
            return Long2CharOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.Entry
        public char getCharValue() {
            return Long2CharOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
        public char rightChar() {
            return Long2CharOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.Entry
        public char setValue(char v) {
            char oldValue = Long2CharOpenCustomHashMap.this.value[this.index];
            Long2CharOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
        public LongCharPair right(char v) {
            Long2CharOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getKey() {
            return Long.valueOf(Long2CharOpenCustomHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getValue() {
            return Character.valueOf(Long2CharOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.Entry
        @Deprecated
        public Character setValue(Character v) {
            return Character.valueOf(setValue(v.charValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, Character> e = (Map.Entry) o;
            return Long2CharOpenCustomHashMap.this.strategy.equals(Long2CharOpenCustomHashMap.this.key[this.index], e.getKey().longValue()) && Long2CharOpenCustomHashMap.this.value[this.index] == e.getValue().charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Long2CharOpenCustomHashMap.this.strategy.hashCode(Long2CharOpenCustomHashMap.this.key[this.index]) ^ Long2CharOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Long2CharOpenCustomHashMap.this.key[this.index] + "=>" + Long2CharOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2256c;
        boolean mustReturnNullKey;
        LongArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Long2CharOpenCustomHashMap.this.f2254n;
            this.last = -1;
            this.f2256c = Long2CharOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Long2CharOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2256c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2256c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Long2CharOpenCustomHashMap.this.f2254n;
                this.last = i;
                return i;
            }
            long[] key = Long2CharOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    long k = this.wrapped.getLong((-this.pos) - 1);
                    int mix = HashCommon.mix(Long2CharOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Long2CharOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Long2CharOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Long2CharOpenCustomHashMap.this.mask;
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
                int i = Long2CharOpenCustomHashMap.this.f2254n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2256c--;
            }
            long[] key = Long2CharOpenCustomHashMap.this.key;
            while (this.f2256c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    long k = this.wrapped.getLong((-this.pos) - 1);
                    int mix = HashCommon.mix(Long2CharOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Long2CharOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Long2CharOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Long2CharOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2256c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2256c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            long curr;
            long[] key = Long2CharOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Long2CharOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(Long2CharOpenCustomHashMap.this.strategy.hashCode(curr)) & Long2CharOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Long2CharOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Long2CharOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new LongArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Long2CharOpenCustomHashMap.this.value[pos] = Long2CharOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Long2CharOpenCustomHashMap.this.f2254n) {
                Long2CharOpenCustomHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Long2CharOpenCustomHashMap.this.remove(this.wrapped.getLong((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Long2CharOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Long2CharMap.Entry>> implements ObjectIterator<Long2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2CharMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Long2CharMap.Entry>> implements ObjectIterator<Long2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2CharMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f2257c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Long2CharOpenCustomHashMap.this.f2254n;
            this.f2257c = 0;
            this.mustReturnNull = Long2CharOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Long2CharOpenCustomHashMap.this.f2254n;
            this.f2257c = 0;
            this.mustReturnNull = Long2CharOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2257c++;
                acceptOnIndex(action, Long2CharOpenCustomHashMap.this.f2254n);
                return true;
            }
            long[] key = Long2CharOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2257c++;
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
                this.f2257c++;
                acceptOnIndex(action, Long2CharOpenCustomHashMap.this.f2254n);
            }
            long[] key = Long2CharOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2257c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Long2CharOpenCustomHashMap.this.size - this.f2257c);
            }
            return Math.min((long) (Long2CharOpenCustomHashMap.this.size - this.f2257c), ((long) ((((double) Long2CharOpenCustomHashMap.this.realSize()) / ((double) Long2CharOpenCustomHashMap.this.f2254n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Long2CharMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Long2CharMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2CharMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Long2CharMap.Entry> implements Long2CharMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Long2CharMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.FastEntrySet
        public ObjectIterator<Long2CharMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2CharMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            int i;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            char v = ((Character) e.getValue()).charValue();
            if (Long2CharOpenCustomHashMap.this.strategy.equals(k, 0)) {
                return Long2CharOpenCustomHashMap.this.containsNullKey && Long2CharOpenCustomHashMap.this.value[Long2CharOpenCustomHashMap.this.f2254n] == v;
            }
            long[] key = Long2CharOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Long2CharOpenCustomHashMap.this.strategy.hashCode(k)) & Long2CharOpenCustomHashMap.this.mask;
            int pos = mix;
            if (key[mix] == 0) {
                return false;
            }
            if (Long2CharOpenCustomHashMap.this.strategy.equals(k, mix)) {
                return Long2CharOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                i = (pos + 1) & Long2CharOpenCustomHashMap.this.mask;
                pos = i;
                if (key[i] == 0) {
                    return false;
                }
            } while (!Long2CharOpenCustomHashMap.this.strategy.equals(k, i));
            return Long2CharOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            char v = ((Character) e.getValue()).charValue();
            if (!Long2CharOpenCustomHashMap.this.strategy.equals(k, 0)) {
                long[] key = Long2CharOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Long2CharOpenCustomHashMap.this.strategy.hashCode(k)) & Long2CharOpenCustomHashMap.this.mask;
                int pos = mix;
                if (key[mix] == 0) {
                    return false;
                }
                if (!Long2CharOpenCustomHashMap.this.strategy.equals(mix, k)) {
                    while (true) {
                        int i = (pos + 1) & Long2CharOpenCustomHashMap.this.mask;
                        pos = i;
                        if (key[i] == 0) {
                            return false;
                        }
                        if (Long2CharOpenCustomHashMap.this.strategy.equals(i, k) && Long2CharOpenCustomHashMap.this.value[pos] == v) {
                            Long2CharOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Long2CharOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Long2CharOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Long2CharOpenCustomHashMap.this.containsNullKey || Long2CharOpenCustomHashMap.this.value[Long2CharOpenCustomHashMap.this.f2254n] != v) {
                return false;
            } else {
                Long2CharOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2CharOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2CharOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Long2CharMap.Entry> consumer) {
            if (Long2CharOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractLong2CharMap.BasicEntry(Long2CharOpenCustomHashMap.this.key[Long2CharOpenCustomHashMap.this.f2254n], Long2CharOpenCustomHashMap.this.value[Long2CharOpenCustomHashMap.this.f2254n]));
            }
            int pos = Long2CharOpenCustomHashMap.this.f2254n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Long2CharOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractLong2CharMap.BasicEntry(Long2CharOpenCustomHashMap.this.key[pos], Long2CharOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Long2CharMap.Entry> consumer) {
            AbstractLong2CharMap.BasicEntry entry = new AbstractLong2CharMap.BasicEntry();
            if (Long2CharOpenCustomHashMap.this.containsNullKey) {
                entry.key = Long2CharOpenCustomHashMap.this.key[Long2CharOpenCustomHashMap.this.f2254n];
                entry.value = Long2CharOpenCustomHashMap.this.value[Long2CharOpenCustomHashMap.this.f2254n];
                consumer.accept(entry);
            }
            int pos = Long2CharOpenCustomHashMap.this.f2254n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Long2CharOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Long2CharOpenCustomHashMap.this.key[pos];
                    entry.value = Long2CharOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
    public Long2CharMap.FastEntrySet long2CharEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$KeyIterator.class */
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
            action.accept(Long2CharOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Long2CharOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$KeySpliterator.class */
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
            action.accept(Long2CharOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$KeySet.class */
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
            if (Long2CharOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Long2CharOpenCustomHashMap.this.key[Long2CharOpenCustomHashMap.this.f2254n]);
            }
            int pos = Long2CharOpenCustomHashMap.this.f2254n;
            while (true) {
                pos--;
                if (pos != 0) {
                    long k = Long2CharOpenCustomHashMap.this.key[pos];
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
            return Long2CharOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return Long2CharOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            int oldSize = Long2CharOpenCustomHashMap.this.size;
            Long2CharOpenCustomHashMap.this.remove(k);
            return Long2CharOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2CharOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
    public Set<Long> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$ValueIterator.class */
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
            action.accept(Long2CharOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Long2CharOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharOpenCustomHashMap$ValueSpliterator.class */
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
            action.accept(Long2CharOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
    public Collection<Character> values() {
        if (this.values == null) {
            this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2CharOpenCustomHashMap.1
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
                    if (Long2CharOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Long2CharOpenCustomHashMap.this.value[Long2CharOpenCustomHashMap.this.f2254n]);
                    }
                    int pos = Long2CharOpenCustomHashMap.this.f2254n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Long2CharOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept(Long2CharOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2CharOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                public boolean contains(char v) {
                    return Long2CharOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2CharOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2255f)));
        if (l >= this.f2254n || this.size > HashCommon.maxFill(l, this.f2255f)) {
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
        char[] value = this.value;
        int mask = newN - 1;
        long[] newKey = new long[newN + 1];
        char[] newValue = new char[newN + 1];
        int i2 = this.f2254n;
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
                newValue[newN] = value[this.f2254n];
                this.f2254n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2254n, this.f2255f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Long2CharOpenCustomHashMap clone() {
        try {
            Long2CharOpenCustomHashMap c = (Long2CharOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (long[]) this.key.clone();
            c.value = (char[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, java.lang.Object, java.util.Map
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
            h += this.value[this.f2254n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        long[] key = this.key;
        char[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeLong(key[e]);
                s.writeChar(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2254n = HashCommon.arraySize(this.size, this.f2255f);
        this.maxFill = HashCommon.maxFill(this.f2254n, this.f2255f);
        this.mask = this.f2254n - 1;
        long[] key = new long[this.f2254n + 1];
        this.key = key;
        char[] value = new char[this.f2254n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                long k = s.readLong();
                char v = s.readChar();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f2254n;
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
