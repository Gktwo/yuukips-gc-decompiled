package p014it.unimi.dsi.fastutil.chars;

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
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import p014it.unimi.dsi.fastutil.chars.CharHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap.class */
public class Char2ObjectOpenCustomHashMap<V> extends AbstractChar2ObjectMap<V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient char[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected CharHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f1403n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1404f;
    protected transient Char2ObjectMap.FastEntrySet<V> entries;
    protected transient CharSet keys;
    protected transient ObjectCollection<V> values;

    public Char2ObjectOpenCustomHashMap(int expected, float f, CharHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1404f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1403n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1403n - 1;
            this.maxFill = HashCommon.maxFill(this.f1403n, f);
            this.key = new char[this.f1403n + 1];
            this.value = (V[]) new Object[this.f1403n + 1];
        }
    }

    public Char2ObjectOpenCustomHashMap(int expected, CharHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Char2ObjectOpenCustomHashMap(CharHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Char2ObjectOpenCustomHashMap(Map<? extends Character, ? extends V> m, float f, CharHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Char2ObjectOpenCustomHashMap(Map<? extends Character, ? extends V> m, CharHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Char2ObjectOpenCustomHashMap(Char2ObjectMap<V> m, float f, CharHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Char2ObjectOpenCustomHashMap(Char2ObjectMap<V> m, CharHash.Strategy strategy) {
        this((Char2ObjectMap) m, 0.75f, strategy);
    }

    public Char2ObjectOpenCustomHashMap(char[] k, V[] v, float f, CharHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (char) v[i]);
        }
    }

    public Char2ObjectOpenCustomHashMap(char[] k, V[] v, CharHash.Strategy strategy) {
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
        int needed = HashCommon.arraySize(capacity, this.f1404f);
        if (needed > this.f1403n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1404f)))));
        if (needed > this.f1403n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public V removeEntry(int pos) {
        V oldValue = this.value[pos];
        this.value[pos] = null;
        this.size--;
        shiftKeys(pos);
        if (this.f1403n > this.minN && this.size < this.maxFill / 4 && this.f1403n > 16) {
            rehash(this.f1403n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.f1403n];
        this.value[this.f1403n] = null;
        this.size--;
        if (this.f1403n > this.minN && this.size < this.maxFill / 4 && this.f1403n > 16) {
            rehash(this.f1403n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.util.Map
    public void putAll(Map<? extends Character, ? extends V> m) {
        if (((double) this.f1404f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.f1403n : -(this.f1403n + 1);
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

    private void insert(int pos, char k, V v) {
        if (pos == this.f1403n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1404f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V put(char k, V v) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V remove(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V get(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f1403n] : (V) this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        char[] key = this.key;
        if (this.containsNullKey && Objects.equals(value[this.f1403n], v)) {
            return true;
        }
        int i = this.f1403n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != 0 && Objects.equals(value[i], v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V getOrDefault(char k, V defaultValue) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f1403n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V putIfAbsent(char k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public boolean remove(char k, Object v) {
        if (!this.strategy.equals(k, 0)) {
            char[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            char curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || !Objects.equals(v, this.value[pos])) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    char curr2 = key[i];
                    if (curr2 == 0) {
                        return false;
                    }
                    if (this.strategy.equals(k, curr2) && Objects.equals(v, this.value[pos])) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || !Objects.equals(v, this.value[this.f1403n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public boolean replace(char k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || !Objects.equals(oldValue, this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V replace(char k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V computeIfAbsent(char k, IntFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        V newValue = (V) mappingFunction.apply(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V computeIfAbsent(char key, Char2ObjectFunction<? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V computeIfPresent(char k, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(Character.valueOf(k), (Object) this.value[pos]);
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V compute(char k, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(Character.valueOf(k), pos >= 0 ? (Object) this.value[pos] : (Object) null);
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V merge(char k, V v, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
            Arrays.fill(this.key, (char) 0);
            Arrays.fill(this.value, (Object) null);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Char2ObjectMap.Entry<V>, Map.Entry<Character, V>, CharObjectPair<V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.Entry
        public char getCharKey() {
            return Char2ObjectOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharObjectPair
        public char leftChar() {
            return Char2ObjectOpenCustomHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Char2ObjectOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Char2ObjectOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Char2ObjectOpenCustomHashMap.this.value[this.index];
            Char2ObjectOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public CharObjectPair<V> right(V v) {
            Char2ObjectOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getKey() {
            return Character.valueOf(Char2ObjectOpenCustomHashMap.this.key[this.index]);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Character, V> e = (Map.Entry) o;
            return Char2ObjectOpenCustomHashMap.this.strategy.equals(Char2ObjectOpenCustomHashMap.this.key[this.index], e.getKey().charValue()) && Objects.equals(Char2ObjectOpenCustomHashMap.this.value[this.index], e.getValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Char2ObjectOpenCustomHashMap.this.strategy.hashCode(Char2ObjectOpenCustomHashMap.this.key[this.index]) ^ (Char2ObjectOpenCustomHashMap.this.value[this.index] == null ? 0 : Char2ObjectOpenCustomHashMap.this.value[this.index].hashCode());
        }

        @Override // java.lang.Object
        public String toString() {
            return Char2ObjectOpenCustomHashMap.this.key[this.index] + "=>" + Char2ObjectOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1405c;
        boolean mustReturnNullKey;
        CharArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Char2ObjectOpenCustomHashMap.this.f1403n;
            this.last = -1;
            this.f1405c = Char2ObjectOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Char2ObjectOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1405c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1405c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Char2ObjectOpenCustomHashMap.this.f1403n;
                this.last = i;
                return i;
            }
            char[] key = Char2ObjectOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    char k = this.wrapped.getChar((-this.pos) - 1);
                    int mix = HashCommon.mix(Char2ObjectOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Char2ObjectOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Char2ObjectOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Char2ObjectOpenCustomHashMap.this.mask;
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
                int i = Char2ObjectOpenCustomHashMap.this.f1403n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1405c--;
            }
            char[] key = Char2ObjectOpenCustomHashMap.this.key;
            while (this.f1405c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    char k = this.wrapped.getChar((-this.pos) - 1);
                    int mix = HashCommon.mix(Char2ObjectOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Char2ObjectOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Char2ObjectOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Char2ObjectOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1405c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1405c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            char curr;
            char[] key = Char2ObjectOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Char2ObjectOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        Char2ObjectOpenCustomHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(Char2ObjectOpenCustomHashMap.this.strategy.hashCode(curr)) & Char2ObjectOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Char2ObjectOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Char2ObjectOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new CharArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Char2ObjectOpenCustomHashMap.this.value[pos] = Char2ObjectOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Char2ObjectOpenCustomHashMap.this.f1403n) {
                Char2ObjectOpenCustomHashMap.this.containsNullKey = false;
                Char2ObjectOpenCustomHashMap.this.value[Char2ObjectOpenCustomHashMap.this.f1403n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Char2ObjectOpenCustomHashMap.this.remove(this.wrapped.getChar((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Char2ObjectOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends Char2ObjectOpenCustomHashMap<V>.MapIterator implements ObjectIterator<Char2ObjectMap.Entry<V>> {
        private Char2ObjectOpenCustomHashMap<V>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Char2ObjectOpenCustomHashMap<V>.MapEntry next() {
            Char2ObjectOpenCustomHashMap<V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Char2ObjectMap.Entry<V>> action, int index) {
            Char2ObjectOpenCustomHashMap<V>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Char2ObjectOpenCustomHashMap<V>.MapIterator implements ObjectIterator<Char2ObjectMap.Entry<V>> {
        private final Char2ObjectOpenCustomHashMap<V>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Char2ObjectOpenCustomHashMap<V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Char2ObjectMap.Entry<V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Char2ObjectOpenCustomHashMap<V>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f1406c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Char2ObjectOpenCustomHashMap.this.f1403n;
            this.f1406c = 0;
            this.mustReturnNull = Char2ObjectOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Char2ObjectOpenCustomHashMap.this.f1403n;
            this.f1406c = 0;
            this.mustReturnNull = Char2ObjectOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1406c++;
                acceptOnIndex(action, Char2ObjectOpenCustomHashMap.this.f1403n);
                return true;
            }
            char[] key = Char2ObjectOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f1406c++;
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
                this.f1406c++;
                acceptOnIndex(action, Char2ObjectOpenCustomHashMap.this.f1403n);
            }
            char[] key = Char2ObjectOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1406c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Char2ObjectOpenCustomHashMap.this.size - this.f1406c);
            }
            return Math.min((long) (Char2ObjectOpenCustomHashMap.this.size - this.f1406c), ((long) ((((double) Char2ObjectOpenCustomHashMap.this.realSize()) / ((double) Char2ObjectOpenCustomHashMap.this.f1403n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Char2ObjectOpenCustomHashMap<V>.MapSpliterator implements ObjectSpliterator<Char2ObjectMap.Entry<V>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapSpliterator
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

        final void acceptOnIndex(Consumer<? super Char2ObjectMap.Entry<V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapSpliterator
        public final Char2ObjectOpenCustomHashMap<V>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Char2ObjectMap.Entry<V>> implements Char2ObjectMap.FastEntrySet<V> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Char2ObjectMap.Entry<V>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.FastEntrySet
        public ObjectIterator<Char2ObjectMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2ObjectMap.Entry<V>> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            char curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            Object value = e.getValue();
            if (Char2ObjectOpenCustomHashMap.this.strategy.equals(k, 0)) {
                return Char2ObjectOpenCustomHashMap.this.containsNullKey && Objects.equals(Char2ObjectOpenCustomHashMap.this.value[Char2ObjectOpenCustomHashMap.this.f1403n], value);
            }
            char[] key = Char2ObjectOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Char2ObjectOpenCustomHashMap.this.strategy.hashCode(k)) & Char2ObjectOpenCustomHashMap.this.mask;
            int pos = mix;
            char curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (Char2ObjectOpenCustomHashMap.this.strategy.equals(k, curr2)) {
                return Objects.equals(Char2ObjectOpenCustomHashMap.this.value[pos], value);
            }
            do {
                int i = (pos + 1) & Char2ObjectOpenCustomHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (!Char2ObjectOpenCustomHashMap.this.strategy.equals(k, curr));
            return Objects.equals(Char2ObjectOpenCustomHashMap.this.value[pos], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            Object value = e.getValue();
            if (!Char2ObjectOpenCustomHashMap.this.strategy.equals(k, 0)) {
                char[] key = Char2ObjectOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Char2ObjectOpenCustomHashMap.this.strategy.hashCode(k)) & Char2ObjectOpenCustomHashMap.this.mask;
                int pos = mix;
                char curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (!Char2ObjectOpenCustomHashMap.this.strategy.equals(curr, k)) {
                    while (true) {
                        int i = (pos + 1) & Char2ObjectOpenCustomHashMap.this.mask;
                        pos = i;
                        char curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (Char2ObjectOpenCustomHashMap.this.strategy.equals(curr2, k) && Objects.equals(Char2ObjectOpenCustomHashMap.this.value[pos], value)) {
                            Char2ObjectOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (!Objects.equals(Char2ObjectOpenCustomHashMap.this.value[pos], value)) {
                    return false;
                } else {
                    Char2ObjectOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Char2ObjectOpenCustomHashMap.this.containsNullKey || !Objects.equals(Char2ObjectOpenCustomHashMap.this.value[Char2ObjectOpenCustomHashMap.this.f1403n], value)) {
                return false;
            } else {
                Char2ObjectOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2ObjectOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2ObjectOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Char2ObjectMap.Entry<V>> consumer) {
            if (Char2ObjectOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractChar2ObjectMap.BasicEntry(Char2ObjectOpenCustomHashMap.this.key[Char2ObjectOpenCustomHashMap.this.f1403n], Char2ObjectOpenCustomHashMap.this.value[Char2ObjectOpenCustomHashMap.this.f1403n]));
            }
            int pos = Char2ObjectOpenCustomHashMap.this.f1403n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Char2ObjectOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractChar2ObjectMap.BasicEntry(Char2ObjectOpenCustomHashMap.this.key[pos], Char2ObjectOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.FastEntrySet
        public void fastForEach(Consumer<? super Char2ObjectMap.Entry<V>> consumer) {
            AbstractChar2ObjectMap.BasicEntry<V> entry = new AbstractChar2ObjectMap.BasicEntry<>();
            if (Char2ObjectOpenCustomHashMap.this.containsNullKey) {
                entry.key = Char2ObjectOpenCustomHashMap.this.key[Char2ObjectOpenCustomHashMap.this.f1403n];
                entry.value = Char2ObjectOpenCustomHashMap.this.value[Char2ObjectOpenCustomHashMap.this.f1403n];
                consumer.accept(entry);
            }
            int pos = Char2ObjectOpenCustomHashMap.this.f1403n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Char2ObjectOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Char2ObjectOpenCustomHashMap.this.key[pos];
                    entry.value = Char2ObjectOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    public Char2ObjectMap.FastEntrySet<V> char2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends Char2ObjectOpenCustomHashMap<V>.MapIterator implements CharIterator {
        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(CharConsumer charConsumer) {
            forEachRemaining((KeyIterator) charConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Char2ObjectOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Char2ObjectOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Char2ObjectOpenCustomHashMap<V>.MapSpliterator implements CharSpliterator {
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
            action.accept(Char2ObjectOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapSpliterator
        public final Char2ObjectOpenCustomHashMap<V>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$KeySet.class */
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
            if (Char2ObjectOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Char2ObjectOpenCustomHashMap.this.key[Char2ObjectOpenCustomHashMap.this.f1403n]);
            }
            int pos = Char2ObjectOpenCustomHashMap.this.f1403n;
            while (true) {
                pos--;
                if (pos != 0) {
                    char k = Char2ObjectOpenCustomHashMap.this.key[pos];
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
            return Char2ObjectOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return Char2ObjectOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            int oldSize = Char2ObjectOpenCustomHashMap.this.size;
            Char2ObjectOpenCustomHashMap.this.remove(k);
            return Char2ObjectOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2ObjectOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    public Set<Character> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends Char2ObjectOpenCustomHashMap<V>.MapIterator implements ObjectIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapIterator
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
            action.accept((Object) Char2ObjectOpenCustomHashMap.this.value[index]);
        }

        @Override // java.util.Iterator
        public V next() {
            return Char2ObjectOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Char2ObjectOpenCustomHashMap<V>.MapSpliterator implements ObjectSpliterator<V> {
        private static final int POST_SPLIT_CHARACTERISTICS = 0;

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapSpliterator
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
            action.accept((Object) Char2ObjectOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.MapSpliterator
        public final Char2ObjectOpenCustomHashMap<V>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.chars.Char2ObjectOpenCustomHashMap.1
                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return new ValueSpliterator();
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    if (Char2ObjectOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept((Object) Char2ObjectOpenCustomHashMap.this.value[Char2ObjectOpenCustomHashMap.this.f1403n]);
                    }
                    int pos = Char2ObjectOpenCustomHashMap.this.f1403n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Char2ObjectOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept((Object) Char2ObjectOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Char2ObjectOpenCustomHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Char2ObjectOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Char2ObjectOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1404f)));
        if (l >= this.f1403n || this.size > HashCommon.maxFill(l, this.f1404f)) {
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
        V[] value = this.value;
        int mask = newN - 1;
        char[] newKey = new char[newN + 1];
        V[] newValue = (V[]) new Object[newN + 1];
        int i2 = this.f1403n;
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
                newValue[newN] = value[this.f1403n];
                this.f1403n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1403n, this.f1404f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Char2ObjectOpenCustomHashMap<V> clone() {
        try {
            Char2ObjectOpenCustomHashMap<V> c = (Char2ObjectOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (char[]) this.key.clone();
            c.value = (V[]) ((Object[]) this.value.clone());
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.lang.Object, java.util.Map
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
                t ^= this.value[i] == null ? 0 : this.value[i].hashCode();
            }
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1403n] == null ? 0 : this.value[this.f1403n].hashCode();
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        char[] key = this.key;
        V[] value = this.value;
        Char2ObjectOpenCustomHashMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeChar(key[e]);
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
        this.f1403n = HashCommon.arraySize(this.size, this.f1404f);
        this.maxFill = HashCommon.maxFill(this.f1403n, this.f1404f);
        this.mask = this.f1403n - 1;
        char[] key = new char[this.f1403n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f1403n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                char k = s.readChar();
                Object readObject = s.readObject();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f1403n;
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
