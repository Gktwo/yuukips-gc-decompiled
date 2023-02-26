package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap;
import p014it.unimi.dsi.fastutil.objects.Object2CharMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap.class */
public class Object2CharOpenHashMap<K> extends AbstractObject2CharMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient char[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f2541n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2542f;
    protected transient Object2CharMap.FastEntrySet<K> entries;
    protected transient ObjectSet<K> keys;
    protected transient CharCollection values;

    public Object2CharOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2542f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2541n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2541n - 1;
            this.maxFill = HashCommon.maxFill(this.f2541n, f);
            this.key = (K[]) new Object[this.f2541n + 1];
            this.value = new char[this.f2541n + 1];
        }
    }

    public Object2CharOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Object2CharOpenHashMap() {
        this(16, 0.75f);
    }

    public Object2CharOpenHashMap(Map<? extends K, ? extends Character> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Object2CharOpenHashMap(Map<? extends K, ? extends Character> m) {
        this(m, 0.75f);
    }

    public Object2CharOpenHashMap(Object2CharMap<K> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Object2CharOpenHashMap(Object2CharMap<K> m) {
        this((Object2CharMap) m, 0.75f);
    }

    public Object2CharOpenHashMap(K[] k, char[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Object2CharOpenHashMap<K>) k[i], v[i]);
        }
    }

    public Object2CharOpenHashMap(K[] k, char[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2542f);
        if (needed > this.f2541n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2542f)))));
        if (needed > this.f2541n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public char removeEntry(int pos) {
        char oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2541n > this.minN && this.size < this.maxFill / 4 && this.f2541n > 16) {
            rehash(this.f2541n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public char removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2541n] = null;
        char oldValue = this.value[this.f2541n];
        this.size--;
        if (this.f2541n > this.minN && this.size < this.maxFill / 4 && this.f2541n > 16) {
            rehash(this.f2541n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Character> m) {
        if (((double) this.f2542f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.f2541n : -(this.f2541n + 1);
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return -(pos + 1);
        }
        if (k.equals(curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return -(pos + 1);
            }
        } while (!k.equals(curr));
        return pos;
    }

    private void insert(int pos, K k, char v) {
        if (pos == this.f2541n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2542f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public char put(K k, char v) {
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

    public char addTo(K k, char incr) {
        int pos;
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(k.hashCode()) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (curr2.equals(k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!curr.equals(k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2541n, incr);
        } else {
            pos = this.f2541n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (char) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2542f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        K curr;
        K[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (curr == null) {
                    key[pos] = null;
                    return;
                }
                int slot = HashCommon.mix(curr.hashCode()) & this.mask;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public char removeChar(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (k.equals(curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (!k.equals(curr));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public char getChar(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2541n] : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (k.equals(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (!k.equals(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return false;
        }
        if (k.equals(curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return false;
            }
        } while (!k.equals(curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public boolean containsValue(char v) {
        char[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2541n] == v) {
            return true;
        }
        int i = this.f2541n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != null && value[i] == v) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public char getOrDefault(Object k, char defaultValue) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2541n] : defaultValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(k.hashCode()) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return defaultValue;
        }
        if (k.equals(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return defaultValue;
            }
        } while (!k.equals(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public char putIfAbsent(K k, char v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public boolean remove(Object k, char v) {
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(k.hashCode()) & this.mask;
            int pos = mix;
            K curr = key[mix];
            if (curr == null) {
                return false;
            }
            if (!k.equals(curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    K curr2 = key[i];
                    if (curr2 == null) {
                        return false;
                    }
                    if (k.equals(curr2) && v == this.value[pos]) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || v != this.value[this.f2541n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public boolean replace(K k, char oldValue, char v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public char replace(K k, char v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public char computeIfAbsent(K k, ToIntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public char computeIfAbsent(K key, Object2CharFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        char newValue = mappingFunction.getChar(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public char computeCharIfPresent(K k, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Character newValue = (Character) remappingFunction.apply(k, Character.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == null) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public char computeChar(K k, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Character newValue = (Character) remappingFunction.apply(k, pos >= 0 ? Character.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == null) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public char merge(K k, char v, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
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
            if (k == null) {
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
            Arrays.fill(this.key, (Object) null);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$MapEntry.class */
    public final class MapEntry implements Object2CharMap.Entry<K>, Map.Entry<K, Character>, ObjectCharPair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Object2CharOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Object2CharOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.Entry
        public char getCharValue() {
            return Object2CharOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCharPair
        public char rightChar() {
            return Object2CharOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.Entry
        public char setValue(char v) {
            char oldValue = Object2CharOpenHashMap.this.value[this.index];
            Object2CharOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectCharPair
        public ObjectCharPair<K> right(char v) {
            Object2CharOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getValue() {
            return Character.valueOf(Object2CharOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.Entry
        @Deprecated
        public Character setValue(Character v) {
            return Character.valueOf(setValue(v.charValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Character> e = (Map.Entry) o;
            return Objects.equals(Object2CharOpenHashMap.this.key[this.index], e.getKey()) && Object2CharOpenHashMap.this.value[this.index] == e.getValue().charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (Object2CharOpenHashMap.this.key[this.index] == null ? 0 : Object2CharOpenHashMap.this.key[this.index].hashCode()) ^ Object2CharOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Object2CharOpenHashMap.this.key[this.index] + "=>" + Object2CharOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2543c;
        boolean mustReturnNullKey;
        ObjectArrayList<K> wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Object2CharOpenHashMap.this.f2541n;
            this.last = -1;
            this.f2543c = Object2CharOpenHashMap.this.size;
            this.mustReturnNullKey = Object2CharOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2543c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2543c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Object2CharOpenHashMap.this.f2541n;
                this.last = i;
                return i;
            }
            K[] key = Object2CharOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(k.hashCode());
                    int i3 = Object2CharOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k.equals(key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Object2CharOpenHashMap.this.mask;
                    }
                }
            } while (key[this.pos] == null);
            int i4 = this.pos;
            this.last = i4;
            return i4;
        }

        public void forEachRemaining(ConsumerType action) {
            int p;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Object2CharOpenHashMap.this.f2541n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2543c--;
            }
            K[] key = Object2CharOpenHashMap.this.key;
            while (this.f2543c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(k.hashCode());
                    int i3 = Object2CharOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k.equals(key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Object2CharOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2543c--;
                } else if (key[this.pos] != null) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2543c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            K curr;
            K[] key = Object2CharOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Object2CharOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(curr.hashCode()) & Object2CharOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Object2CharOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Object2CharOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ObjectArrayList<>(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Object2CharOpenHashMap.this.value[pos] = Object2CharOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Object2CharOpenHashMap.this.f2541n) {
                Object2CharOpenHashMap.this.containsNullKey = false;
                Object2CharOpenHashMap.this.key[Object2CharOpenHashMap.this.f2541n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Object2CharOpenHashMap.this.removeChar(this.wrapped.set((-this.pos) - 1, null));
                this.last = -1;
                return;
            }
            Object2CharOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Object2CharOpenHashMap<K>.MapIterator implements ObjectIterator<Object2CharMap.Entry<K>> {
        private Object2CharOpenHashMap<K>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Object2CharOpenHashMap<K>.MapEntry next() {
            Object2CharOpenHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Object2CharMap.Entry<K>> action, int index) {
            Object2CharOpenHashMap<K>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Object2CharOpenHashMap<K>.MapIterator implements ObjectIterator<Object2CharMap.Entry<K>> {
        private final Object2CharOpenHashMap<K>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Object2CharOpenHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Object2CharMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Object2CharOpenHashMap<K>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f2544c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Object2CharOpenHashMap.this.f2541n;
            this.f2544c = 0;
            this.mustReturnNull = Object2CharOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Object2CharOpenHashMap.this.f2541n;
            this.f2544c = 0;
            this.mustReturnNull = Object2CharOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2544c++;
                acceptOnIndex(action, Object2CharOpenHashMap.this.f2541n);
                return true;
            }
            K[] key = Object2CharOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    this.f2544c++;
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
                this.f2544c++;
                acceptOnIndex(action, Object2CharOpenHashMap.this.f2541n);
            }
            K[] key = Object2CharOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    acceptOnIndex(action, this.pos);
                    this.f2544c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Object2CharOpenHashMap.this.size - this.f2544c);
            }
            return Math.min((long) (Object2CharOpenHashMap.this.size - this.f2544c), ((long) ((((double) Object2CharOpenHashMap.this.realSize()) / ((double) Object2CharOpenHashMap.this.f2541n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap r0 = p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.this
                K[] r0 = r0.key
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Object2CharOpenHashMap<K>.MapSpliterator implements ObjectSpliterator<Object2CharMap.Entry<K>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapSpliterator
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

        final void acceptOnIndex(Consumer<? super Object2CharMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapSpliterator
        public final Object2CharOpenHashMap<K>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Object2CharMap.Entry<K>> implements Object2CharMap.FastEntrySet<K> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Object2CharMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.FastEntrySet
        public ObjectIterator<Object2CharMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2CharMap.Entry<K>> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            K curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            Object key = e.getKey();
            char v = ((Character) e.getValue()).charValue();
            if (key == null) {
                return Object2CharOpenHashMap.this.containsNullKey && Object2CharOpenHashMap.this.value[Object2CharOpenHashMap.this.f2541n] == v;
            }
            K[] key2 = Object2CharOpenHashMap.this.key;
            int mix = HashCommon.mix(key.hashCode()) & Object2CharOpenHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (key.equals(curr2)) {
                return Object2CharOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Object2CharOpenHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!key.equals(curr));
            return Object2CharOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            Object key = e.getKey();
            char v = ((Character) e.getValue()).charValue();
            if (key != null) {
                K[] key2 = Object2CharOpenHashMap.this.key;
                int mix = HashCommon.mix(key.hashCode()) & Object2CharOpenHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!curr.equals(key)) {
                    while (true) {
                        int i = (pos + 1) & Object2CharOpenHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (curr2.equals(key) && Object2CharOpenHashMap.this.value[pos] == v) {
                            Object2CharOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Object2CharOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Object2CharOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Object2CharOpenHashMap.this.containsNullKey || Object2CharOpenHashMap.this.value[Object2CharOpenHashMap.this.f2541n] != v) {
                return false;
            } else {
                Object2CharOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2CharOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2CharOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2CharMap.Entry<K>> consumer) {
            if (Object2CharOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractObject2CharMap.BasicEntry(Object2CharOpenHashMap.this.key[Object2CharOpenHashMap.this.f2541n], Object2CharOpenHashMap.this.value[Object2CharOpenHashMap.this.f2541n]));
            }
            int pos = Object2CharOpenHashMap.this.f2541n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Object2CharOpenHashMap.this.key[pos] != null) {
                    consumer.accept(new AbstractObject2CharMap.BasicEntry(Object2CharOpenHashMap.this.key[pos], Object2CharOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2CharMap.Entry<K>> consumer) {
            AbstractObject2CharMap.BasicEntry<K> entry = new AbstractObject2CharMap.BasicEntry<>();
            if (Object2CharOpenHashMap.this.containsNullKey) {
                entry.key = Object2CharOpenHashMap.this.key[Object2CharOpenHashMap.this.f2541n];
                entry.value = Object2CharOpenHashMap.this.value[Object2CharOpenHashMap.this.f2541n];
                consumer.accept(entry);
            }
            int pos = Object2CharOpenHashMap.this.f2541n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Object2CharOpenHashMap.this.key[pos] != null) {
                    entry.key = Object2CharOpenHashMap.this.key[pos];
                    entry.value = Object2CharOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
    public Object2CharMap.FastEntrySet<K> object2CharEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Object2CharOpenHashMap<K>.MapIterator implements ObjectIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((KeyIterator) consumer);
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Object2CharOpenHashMap.this.key[index]);
        }

        @Override // java.util.Iterator
        public K next() {
            return Object2CharOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Object2CharOpenHashMap<K>.MapSpliterator implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapSpliterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((KeySpliterator) consumer);
        }

        @Override // java.util.Spliterator
        public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return tryAdvance((KeySpliterator) consumer);
        }

        KeySpliterator() {
            super();
        }

        KeySpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            super(pos, max, mustReturnNull, hasSplit);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 1 : 65;
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Object2CharOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapSpliterator
        public final Object2CharOpenHashMap<K>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractObjectSet<K> {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new KeySpliterator();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            if (Object2CharOpenHashMap.this.containsNullKey) {
                consumer.accept((Object) Object2CharOpenHashMap.this.key[Object2CharOpenHashMap.this.f2541n]);
            }
            int pos = Object2CharOpenHashMap.this.f2541n;
            while (true) {
                pos--;
                if (pos != 0) {
                    Object obj = (Object) Object2CharOpenHashMap.this.key[pos];
                    if (obj != 0) {
                        consumer.accept(obj);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2CharOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2CharOpenHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Object2CharOpenHashMap.this.size;
            Object2CharOpenHashMap.this.removeChar(k);
            return Object2CharOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2CharOpenHashMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    public ObjectSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Object2CharOpenHashMap<K>.MapIterator implements CharIterator {
        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(CharConsumer charConsumer) {
            forEachRemaining((ValueIterator) charConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Object2CharOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Object2CharOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharOpenHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Object2CharOpenHashMap<K>.MapSpliterator implements CharSpliterator {
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
            action.accept(Object2CharOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.MapSpliterator
        public final Object2CharOpenHashMap<K>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    public Collection<Character> values() {
        if (this.values == null) {
            this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2CharOpenHashMap.1
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
                    if (Object2CharOpenHashMap.this.containsNullKey) {
                        consumer.accept(Object2CharOpenHashMap.this.value[Object2CharOpenHashMap.this.f2541n]);
                    }
                    int pos = Object2CharOpenHashMap.this.f2541n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Object2CharOpenHashMap.this.key[pos] != null) {
                            consumer.accept(Object2CharOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2CharOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                public boolean contains(char v) {
                    return Object2CharOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2CharOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2542f)));
        if (l >= this.f2541n || this.size > HashCommon.maxFill(l, this.f2542f)) {
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
        K[] key = this.key;
        char[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        char[] newValue = new char[newN + 1];
        int i2 = this.f2541n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == null);
                int mix = HashCommon.mix(key[i2].hashCode()) & mask;
                int pos = mix;
                if (newKey[mix] != null) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (newKey[i] != null);
                }
                newKey[pos] = key[i2];
                newValue[pos] = value[i2];
            } else {
                newValue[newN] = value[this.f2541n];
                this.f2541n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2541n, this.f2542f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Object2CharOpenHashMap<K> clone() {
        try {
            Object2CharOpenHashMap<K> c = (Object2CharOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (char[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        int t = 0;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            while (this.key[i] == null) {
                i++;
            }
            if (this != this.key[i]) {
                t = this.key[i].hashCode();
            }
            t ^= this.value[i];
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2541n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        char[] value = this.value;
        Object2CharOpenHashMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeObject(key[e]);
                s.writeChar(value[e]);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: K[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2541n = HashCommon.arraySize(this.size, this.f2542f);
        this.maxFill = HashCommon.maxFill(this.f2541n, this.f2542f);
        this.mask = this.f2541n - 1;
        K[] key = (K[]) new Object[this.f2541n + 1];
        this.key = key;
        char[] value = new char[this.f2541n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                Object readObject = s.readObject();
                char v = s.readChar();
                if (readObject == null) {
                    pos = this.f2541n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(readObject.hashCode());
                    int i2 = this.mask;
                    while (true) {
                        pos = mix & i2;
                        if (key[pos] != 0) {
                            mix = pos + 1;
                            i2 = this.mask;
                        }
                    }
                }
                key[pos] = readObject;
                value[pos] = v;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
