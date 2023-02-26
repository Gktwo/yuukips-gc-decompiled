package p014it.unimi.dsi.fastutil.chars;

import emu.grasscutter.net.proto.RetcodeOuterClass;
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
import java.util.function.IntPredicate;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanMap;
import p014it.unimi.dsi.fastutil.chars.CharHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap.class */
public class Char2BooleanOpenCustomHashMap extends AbstractChar2BooleanMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient char[] key;
    protected transient boolean[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected CharHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f1319n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1320f;
    protected transient Char2BooleanMap.FastEntrySet entries;
    protected transient CharSet keys;
    protected transient BooleanCollection values;

    public Char2BooleanOpenCustomHashMap(int expected, float f, CharHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1320f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1319n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1319n - 1;
            this.maxFill = HashCommon.maxFill(this.f1319n, f);
            this.key = new char[this.f1319n + 1];
            this.value = new boolean[this.f1319n + 1];
        }
    }

    public Char2BooleanOpenCustomHashMap(int expected, CharHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Char2BooleanOpenCustomHashMap(CharHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Char2BooleanOpenCustomHashMap(Map<? extends Character, ? extends Boolean> m, float f, CharHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Char2BooleanOpenCustomHashMap(Map<? extends Character, ? extends Boolean> m, CharHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Char2BooleanOpenCustomHashMap(Char2BooleanMap m, float f, CharHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Char2BooleanOpenCustomHashMap(Char2BooleanMap m, CharHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Char2BooleanOpenCustomHashMap(char[] k, boolean[] v, float f, CharHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Char2BooleanOpenCustomHashMap(char[] k, boolean[] v, CharHash.Strategy strategy) {
        this(k, v, 0.75f, strategy);
    }

    public CharHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1320f);
        if (needed > this.f1319n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1320f)))));
        if (needed > this.f1319n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public boolean removeEntry(int pos) {
        boolean oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f1319n > this.minN && this.size < this.maxFill / 4 && this.f1319n > 16) {
            rehash(this.f1319n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public boolean removeNullEntry() {
        this.containsNullKey = false;
        boolean oldValue = this.value[this.f1319n];
        this.size--;
        if (this.f1319n > this.minN && this.size < this.maxFill / 4 && this.f1319n > 16) {
            rehash(this.f1319n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap, java.util.Map
    public void putAll(Map<? extends Character, ? extends Boolean> m) {
        if (((double) this.f1320f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.f1319n : -(this.f1319n + 1);
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    private void insert(int pos, char k, boolean v) {
        if (pos == this.f1319n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1320f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    public boolean put(char k, boolean v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        boolean oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    protected final void shiftKeys(int pos) {
        char curr;
        char[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    public boolean remove(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    public boolean get(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f1319n] : this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean containsKey(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey;
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean containsValue(boolean v) {
        boolean[] value = this.value;
        char[] key = this.key;
        if (this.containsNullKey && value[this.f1319n] == v) {
            return true;
        }
        int i = this.f1319n;
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    public boolean getOrDefault(char k, boolean defaultValue) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f1319n] : defaultValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean putIfAbsent(char k, boolean v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean remove(char k, boolean v) {
        if (!this.strategy.equals(k, 0)) {
            char[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            char curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    char curr2 = key[i];
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
        } else if (!this.containsNullKey || v != this.value[this.f1319n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean replace(char k, boolean oldValue, boolean v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean replace(char k, boolean v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        boolean oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean computeIfAbsent(char k, IntPredicate mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        boolean newValue = mappingFunction.test(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean computeIfAbsent(char key, Char2BooleanFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        boolean newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean computeIfAbsentNullable(char k, IntFunction<? extends Boolean> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Boolean newValue = (Boolean) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        boolean v = newValue.booleanValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean computeIfPresent(char k, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Boolean newValue = (Boolean) remappingFunction.apply(Character.valueOf(k), Boolean.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, 0)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        boolean[] zArr = this.value;
        boolean booleanValue = newValue.booleanValue();
        zArr[pos] = booleanValue;
        return booleanValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean compute(char k, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Boolean newValue = (Boolean) remappingFunction.apply(Character.valueOf(k), pos >= 0 ? Boolean.valueOf(this.value[pos]) : null);
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
        boolean newVal = newValue.booleanValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
    public boolean merge(char k, boolean v, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
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
        Boolean newValue = (Boolean) remappingFunction.apply(Boolean.valueOf(this.value[pos]), Boolean.valueOf(v));
        if (newValue == null) {
            if (this.strategy.equals(k, 0)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        boolean[] zArr = this.value;
        boolean booleanValue = newValue.booleanValue();
        zArr[pos] = booleanValue;
        return booleanValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, (char) 0);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Char2BooleanMap.Entry, Map.Entry<Character, Boolean>, CharBooleanPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.Entry
        public char getCharKey() {
            return Char2BooleanOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
        public char leftChar() {
            return Char2BooleanOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.Entry
        public boolean getBooleanValue() {
            return Char2BooleanOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
        public boolean rightBoolean() {
            return Char2BooleanOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.Entry
        public boolean setValue(boolean v) {
            boolean oldValue = Char2BooleanOpenCustomHashMap.this.value[this.index];
            Char2BooleanOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
        public CharBooleanPair right(boolean v) {
            Char2BooleanOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getKey() {
            return Character.valueOf(Char2BooleanOpenCustomHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.Entry, java.util.Map.Entry
        @Deprecated
        public Boolean getValue() {
            return Boolean.valueOf(Char2BooleanOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.Entry
        @Deprecated
        public Boolean setValue(Boolean v) {
            return Boolean.valueOf(setValue(v.booleanValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Character, Boolean> e = (Map.Entry) o;
            return Char2BooleanOpenCustomHashMap.this.strategy.equals(Char2BooleanOpenCustomHashMap.this.key[this.index], e.getKey().charValue()) && Char2BooleanOpenCustomHashMap.this.value[this.index] == e.getValue().booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Char2BooleanOpenCustomHashMap.this.strategy.hashCode(Char2BooleanOpenCustomHashMap.this.key[this.index]) ^ (Char2BooleanOpenCustomHashMap.this.value[this.index] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }

        @Override // java.lang.Object
        public String toString() {
            return Char2BooleanOpenCustomHashMap.this.key[this.index] + "=>" + Char2BooleanOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1321c;
        boolean mustReturnNullKey;
        CharArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Char2BooleanOpenCustomHashMap.this.f1319n;
            this.last = -1;
            this.f1321c = Char2BooleanOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Char2BooleanOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1321c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1321c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Char2BooleanOpenCustomHashMap.this.f1319n;
                this.last = i;
                return i;
            }
            char[] key = Char2BooleanOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    char k = this.wrapped.getChar((-this.pos) - 1);
                    int mix = HashCommon.mix(Char2BooleanOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Char2BooleanOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Char2BooleanOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Char2BooleanOpenCustomHashMap.this.mask;
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
                int i = Char2BooleanOpenCustomHashMap.this.f1319n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1321c--;
            }
            char[] key = Char2BooleanOpenCustomHashMap.this.key;
            while (this.f1321c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    char k = this.wrapped.getChar((-this.pos) - 1);
                    int mix = HashCommon.mix(Char2BooleanOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Char2BooleanOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Char2BooleanOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Char2BooleanOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1321c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1321c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            char curr;
            char[] key = Char2BooleanOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Char2BooleanOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(Char2BooleanOpenCustomHashMap.this.strategy.hashCode(curr)) & Char2BooleanOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Char2BooleanOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Char2BooleanOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new CharArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Char2BooleanOpenCustomHashMap.this.value[pos] = Char2BooleanOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Char2BooleanOpenCustomHashMap.this.f1319n) {
                Char2BooleanOpenCustomHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Char2BooleanOpenCustomHashMap.this.remove(this.wrapped.getChar((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Char2BooleanOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Char2BooleanMap.Entry>> implements ObjectIterator<Char2BooleanMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Char2BooleanMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Char2BooleanMap.Entry>> implements ObjectIterator<Char2BooleanMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Char2BooleanMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f1322c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Char2BooleanOpenCustomHashMap.this.f1319n;
            this.f1322c = 0;
            this.mustReturnNull = Char2BooleanOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Char2BooleanOpenCustomHashMap.this.f1319n;
            this.f1322c = 0;
            this.mustReturnNull = Char2BooleanOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1322c++;
                acceptOnIndex(action, Char2BooleanOpenCustomHashMap.this.f1319n);
                return true;
            }
            char[] key = Char2BooleanOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f1322c++;
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
                this.f1322c++;
                acceptOnIndex(action, Char2BooleanOpenCustomHashMap.this.f1319n);
            }
            char[] key = Char2BooleanOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1322c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Char2BooleanOpenCustomHashMap.this.size - this.f1322c);
            }
            return Math.min((long) (Char2BooleanOpenCustomHashMap.this.size - this.f1322c), ((long) ((((double) Char2BooleanOpenCustomHashMap.this.realSize()) / ((double) Char2BooleanOpenCustomHashMap.this.f1319n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap.this
                char[] r0 = r0.key
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
                char r0 = r0[r1]
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Char2BooleanMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Char2BooleanMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Char2BooleanMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Char2BooleanMap.Entry> implements Char2BooleanMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Char2BooleanMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.FastEntrySet
        public ObjectIterator<Char2BooleanMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2BooleanMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            char curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            if (Char2BooleanOpenCustomHashMap.this.strategy.equals(k, 0)) {
                return Char2BooleanOpenCustomHashMap.this.containsNullKey && Char2BooleanOpenCustomHashMap.this.value[Char2BooleanOpenCustomHashMap.this.f1319n] == v;
            }
            char[] key = Char2BooleanOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Char2BooleanOpenCustomHashMap.this.strategy.hashCode(k)) & Char2BooleanOpenCustomHashMap.this.mask;
            int pos = mix;
            char curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (Char2BooleanOpenCustomHashMap.this.strategy.equals(k, curr2)) {
                return Char2BooleanOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Char2BooleanOpenCustomHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (!Char2BooleanOpenCustomHashMap.this.strategy.equals(k, curr));
            return Char2BooleanOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            if (!Char2BooleanOpenCustomHashMap.this.strategy.equals(k, 0)) {
                char[] key = Char2BooleanOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Char2BooleanOpenCustomHashMap.this.strategy.hashCode(k)) & Char2BooleanOpenCustomHashMap.this.mask;
                int pos = mix;
                char curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (!Char2BooleanOpenCustomHashMap.this.strategy.equals(curr, k)) {
                    while (true) {
                        int i = (pos + 1) & Char2BooleanOpenCustomHashMap.this.mask;
                        pos = i;
                        char curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (Char2BooleanOpenCustomHashMap.this.strategy.equals(curr2, k) && Char2BooleanOpenCustomHashMap.this.value[pos] == v) {
                            Char2BooleanOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Char2BooleanOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Char2BooleanOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Char2BooleanOpenCustomHashMap.this.containsNullKey || Char2BooleanOpenCustomHashMap.this.value[Char2BooleanOpenCustomHashMap.this.f1319n] != v) {
                return false;
            } else {
                Char2BooleanOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2BooleanOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2BooleanOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Char2BooleanMap.Entry> consumer) {
            if (Char2BooleanOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractChar2BooleanMap.BasicEntry(Char2BooleanOpenCustomHashMap.this.key[Char2BooleanOpenCustomHashMap.this.f1319n], Char2BooleanOpenCustomHashMap.this.value[Char2BooleanOpenCustomHashMap.this.f1319n]));
            }
            int pos = Char2BooleanOpenCustomHashMap.this.f1319n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Char2BooleanOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractChar2BooleanMap.BasicEntry(Char2BooleanOpenCustomHashMap.this.key[pos], Char2BooleanOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.FastEntrySet
        public void fastForEach(Consumer<? super Char2BooleanMap.Entry> consumer) {
            AbstractChar2BooleanMap.BasicEntry entry = new AbstractChar2BooleanMap.BasicEntry();
            if (Char2BooleanOpenCustomHashMap.this.containsNullKey) {
                entry.key = Char2BooleanOpenCustomHashMap.this.key[Char2BooleanOpenCustomHashMap.this.f1319n];
                entry.value = Char2BooleanOpenCustomHashMap.this.value[Char2BooleanOpenCustomHashMap.this.f1319n];
                consumer.accept(entry);
            }
            int pos = Char2BooleanOpenCustomHashMap.this.f1319n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Char2BooleanOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Char2BooleanOpenCustomHashMap.this.key[pos];
                    entry.value = Char2BooleanOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
    public Char2BooleanMap.FastEntrySet char2BooleanEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<CharConsumer> implements CharIterator {
        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(CharConsumer charConsumer) {
            forEachRemaining((KeyIterator) charConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Char2BooleanOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Char2BooleanOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<CharConsumer, KeySpliterator> implements CharSpliterator {
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
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Char2BooleanOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$KeySet.class */
    public final class KeySet extends AbstractCharSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer consumer) {
            if (Char2BooleanOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Char2BooleanOpenCustomHashMap.this.key[Char2BooleanOpenCustomHashMap.this.f1319n]);
            }
            int pos = Char2BooleanOpenCustomHashMap.this.f1319n;
            while (true) {
                pos--;
                if (pos != 0) {
                    char k = Char2BooleanOpenCustomHashMap.this.key[pos];
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
            return Char2BooleanOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return Char2BooleanOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            int oldSize = Char2BooleanOpenCustomHashMap.this.size;
            Char2BooleanOpenCustomHashMap.this.remove(k);
            return Char2BooleanOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2BooleanOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
    public Set<Character> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<BooleanConsumer> implements BooleanIterator {
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(BooleanConsumer booleanConsumer) {
            forEachRemaining((ValueIterator) booleanConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(BooleanConsumer action, int index) {
            action.accept(Char2BooleanOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return Char2BooleanOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends MapSpliterator<BooleanConsumer, ValueSpliterator> implements BooleanSpliterator {
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
        public final void acceptOnIndex(BooleanConsumer action, int index) {
            action.accept(Char2BooleanOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        if (this.values == null) {
            this.values = new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.chars.Char2BooleanOpenCustomHashMap.1
                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                public BooleanIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                public BooleanSpliterator spliterator() {
                    return new ValueSpliterator();
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
                public void forEach(BooleanConsumer consumer) {
                    if (Char2BooleanOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Char2BooleanOpenCustomHashMap.this.value[Char2BooleanOpenCustomHashMap.this.f1319n]);
                    }
                    int pos = Char2BooleanOpenCustomHashMap.this.f1319n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Char2BooleanOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept(Char2BooleanOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Char2BooleanOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
                public boolean contains(boolean v) {
                    return Char2BooleanOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Char2BooleanOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1320f)));
        if (l >= this.f1319n || this.size > HashCommon.maxFill(l, this.f1320f)) {
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
        char[] key = this.key;
        boolean[] value = this.value;
        int mask = newN - 1;
        char[] newKey = new char[newN + 1];
        boolean[] newValue = new boolean[newN + 1];
        int i2 = this.f1319n;
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
                newValue[newN] = value[this.f1319n];
                this.f1319n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1319n, this.f1320f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Char2BooleanOpenCustomHashMap clone() {
        try {
            Char2BooleanOpenCustomHashMap c = (Char2BooleanOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (char[]) this.key.clone();
            c.value = (boolean[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap, java.lang.Object, java.util.Map
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
            h += this.strategy.hashCode(this.key[i]) ^ (this.value[i] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1319n] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE;
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        char[] key = this.key;
        boolean[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeChar(key[e]);
                s.writeBoolean(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1319n = HashCommon.arraySize(this.size, this.f1320f);
        this.maxFill = HashCommon.maxFill(this.f1319n, this.f1320f);
        this.mask = this.f1319n - 1;
        char[] key = new char[this.f1319n + 1];
        this.key = key;
        boolean[] value = new boolean[this.f1319n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                char k = s.readChar();
                boolean v = s.readBoolean();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f1319n;
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
