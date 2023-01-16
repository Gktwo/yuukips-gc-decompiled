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
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap;
import p014it.unimi.dsi.fastutil.objects.Object2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap.class */
public class Object2ByteOpenCustomHashMap<K> extends AbstractObject2ByteMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient byte[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected Hash.Strategy<? super K> strategy;

    /* renamed from: n */
    protected transient int f2559n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2560f;
    protected transient Object2ByteMap.FastEntrySet<K> entries;
    protected transient ObjectSet<K> keys;
    protected transient ByteCollection values;

    public Object2ByteOpenCustomHashMap(int expected, float f, Hash.Strategy<? super K> strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2560f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2559n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2559n - 1;
            this.maxFill = HashCommon.maxFill(this.f2559n, f);
            this.key = (K[]) new Object[this.f2559n + 1];
            this.value = new byte[this.f2559n + 1];
        }
    }

    public Object2ByteOpenCustomHashMap(int expected, Hash.Strategy<? super K> strategy) {
        this(expected, 0.75f, strategy);
    }

    public Object2ByteOpenCustomHashMap(Hash.Strategy<? super K> strategy) {
        this(16, 0.75f, strategy);
    }

    public Object2ByteOpenCustomHashMap(Map<? extends K, ? extends Byte> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2ByteOpenCustomHashMap(Map<? extends K, ? extends Byte> m, Hash.Strategy<? super K> strategy) {
        this(m, 0.75f, strategy);
    }

    public Object2ByteOpenCustomHashMap(Object2ByteMap<K> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2ByteOpenCustomHashMap(Object2ByteMap<K> m, Hash.Strategy<? super K> strategy) {
        this((Object2ByteMap) m, 0.75f, (Hash.Strategy) strategy);
    }

    public Object2ByteOpenCustomHashMap(K[] k, byte[] v, float f, Hash.Strategy<? super K> strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Object2ByteOpenCustomHashMap<K>) k[i], v[i]);
        }
    }

    public Object2ByteOpenCustomHashMap(K[] k, byte[] v, Hash.Strategy<? super K> strategy) {
        this(k, v, 0.75f, strategy);
    }

    public Hash.Strategy<? super K> strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2560f);
        if (needed > this.f2559n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2560f)))));
        if (needed > this.f2559n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public byte removeEntry(int pos) {
        byte oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2559n > this.minN && this.size < this.maxFill / 4 && this.f2559n > 16) {
            rehash(this.f2559n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public byte removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2559n] = null;
        byte oldValue = this.value[this.f2559n];
        this.size--;
        if (this.f2559n > this.minN && this.size < this.maxFill / 4 && this.f2559n > 16) {
            rehash(this.f2559n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Byte> m) {
        if (((double) this.f2560f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.f2559n : -(this.f2559n + 1);
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return -(pos + 1);
        }
        if (this.strategy.equals(k, curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return -(pos + 1);
            }
        } while (!this.strategy.equals(k, curr));
        return pos;
    }

    private void insert(int pos, K k, byte v) {
        if (pos == this.f2559n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2560f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
    public byte put(K k, byte v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        byte oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private byte addToValue(int pos, byte incr) {
        byte oldValue = this.value[pos];
        this.value[pos] = (byte) (oldValue + incr);
        return oldValue;
    }

    public byte addTo(K k, byte incr) {
        int pos;
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2559n, incr);
        } else {
            pos = this.f2559n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (byte) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2560f));
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
    public byte removeByte(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
    public byte getByte(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2559n] : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public boolean containsValue(byte v) {
        byte[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2559n] == v) {
            return true;
        }
        int i = this.f2559n;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
    public byte getOrDefault(Object k, byte defaultValue) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2559n] : defaultValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return defaultValue;
        }
        if (this.strategy.equals(k, curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return defaultValue;
            }
        } while (!this.strategy.equals(k, curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public byte putIfAbsent(K k, byte v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public boolean remove(Object k, byte v) {
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr = key[mix];
            if (curr == null) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    K curr2 = key[i];
                    if (curr2 == null) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2559n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public boolean replace(K k, byte oldValue, byte v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public byte replace(K k, byte v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        byte oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public byte computeIfAbsent(K k, ToIntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public byte computeIfAbsent(K key, Object2ByteFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        byte newValue = mappingFunction.getByte(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public byte computeByteIfPresent(K k, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Byte newValue = (Byte) remappingFunction.apply(k, Byte.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, null)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        byte[] bArr = this.value;
        byte byteValue = newValue.byteValue();
        bArr[pos] = byteValue;
        return byteValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public byte computeByte(K k, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Byte newValue = (Byte) remappingFunction.apply(k, pos >= 0 ? Byte.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (this.strategy.equals(k, null)) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return this.defRetValue;
        }
        byte newVal = newValue.byteValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public byte merge(K k, byte v, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
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
        Byte newValue = (Byte) remappingFunction.apply(Byte.valueOf(this.value[pos]), Byte.valueOf(v));
        if (newValue == null) {
            if (this.strategy.equals(k, null)) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        byte[] bArr = this.value;
        byte byteValue = newValue.byteValue();
        bArr[pos] = byteValue;
        return byteValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Object2ByteMap.Entry<K>, Map.Entry<K, Byte>, ObjectBytePair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Object2ByteOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Object2ByteOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.Entry
        public byte getByteValue() {
            return Object2ByteOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBytePair
        public byte rightByte() {
            return Object2ByteOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.Entry
        public byte setValue(byte v) {
            byte oldValue = Object2ByteOpenCustomHashMap.this.value[this.index];
            Object2ByteOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBytePair
        public ObjectBytePair<K> right(byte v) {
            Object2ByteOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getValue() {
            return Byte.valueOf(Object2ByteOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.Entry
        @Deprecated
        public Byte setValue(Byte v) {
            return Byte.valueOf(setValue(v.byteValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Byte> e = (Map.Entry) o;
            return Object2ByteOpenCustomHashMap.this.strategy.equals((Object) Object2ByteOpenCustomHashMap.this.key[this.index], (Object) e.getKey()) && Object2ByteOpenCustomHashMap.this.value[this.index] == e.getValue().byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Object2ByteOpenCustomHashMap.this.strategy.hashCode((Object) Object2ByteOpenCustomHashMap.this.key[this.index]) ^ Object2ByteOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Object2ByteOpenCustomHashMap.this.key[this.index] + "=>" + ((int) Object2ByteOpenCustomHashMap.this.value[this.index]);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2561c;
        boolean mustReturnNullKey;
        ObjectArrayList<K> wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Object2ByteOpenCustomHashMap.this.f2559n;
            this.last = -1;
            this.f2561c = Object2ByteOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Object2ByteOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2561c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2561c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Object2ByteOpenCustomHashMap.this.f2559n;
                this.last = i;
                return i;
            }
            K[] key = Object2ByteOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(Object2ByteOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Object2ByteOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Object2ByteOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Object2ByteOpenCustomHashMap.this.mask;
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
                int i = Object2ByteOpenCustomHashMap.this.f2559n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2561c--;
            }
            K[] key = Object2ByteOpenCustomHashMap.this.key;
            while (this.f2561c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(Object2ByteOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Object2ByteOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Object2ByteOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Object2ByteOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2561c--;
                } else if (key[this.pos] != null) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2561c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            K curr;
            K[] key = Object2ByteOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Object2ByteOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(Object2ByteOpenCustomHashMap.this.strategy.hashCode(curr)) & Object2ByteOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Object2ByteOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Object2ByteOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ObjectArrayList<>(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Object2ByteOpenCustomHashMap.this.value[pos] = Object2ByteOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Object2ByteOpenCustomHashMap.this.f2559n) {
                Object2ByteOpenCustomHashMap.this.containsNullKey = false;
                Object2ByteOpenCustomHashMap.this.key[Object2ByteOpenCustomHashMap.this.f2559n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Object2ByteOpenCustomHashMap.this.removeByte(this.wrapped.set((-this.pos) - 1, null));
                this.last = -1;
                return;
            }
            Object2ByteOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends Object2ByteOpenCustomHashMap<K>.MapIterator implements ObjectIterator<Object2ByteMap.Entry<K>> {
        private Object2ByteOpenCustomHashMap<K>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Object2ByteOpenCustomHashMap<K>.MapEntry next() {
            Object2ByteOpenCustomHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Object2ByteMap.Entry<K>> action, int index) {
            Object2ByteOpenCustomHashMap<K>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Object2ByteOpenCustomHashMap<K>.MapIterator implements ObjectIterator<Object2ByteMap.Entry<K>> {
        private final Object2ByteOpenCustomHashMap<K>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Object2ByteOpenCustomHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Object2ByteMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Object2ByteOpenCustomHashMap<K>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f2562c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Object2ByteOpenCustomHashMap.this.f2559n;
            this.f2562c = 0;
            this.mustReturnNull = Object2ByteOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Object2ByteOpenCustomHashMap.this.f2559n;
            this.f2562c = 0;
            this.mustReturnNull = Object2ByteOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2562c++;
                acceptOnIndex(action, Object2ByteOpenCustomHashMap.this.f2559n);
                return true;
            }
            K[] key = Object2ByteOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    this.f2562c++;
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
                this.f2562c++;
                acceptOnIndex(action, Object2ByteOpenCustomHashMap.this.f2559n);
            }
            K[] key = Object2ByteOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    acceptOnIndex(action, this.pos);
                    this.f2562c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Object2ByteOpenCustomHashMap.this.size - this.f2562c);
            }
            return Math.min((long) (Object2ByteOpenCustomHashMap.this.size - this.f2562c), ((long) ((((double) Object2ByteOpenCustomHashMap.this.realSize()) / ((double) Object2ByteOpenCustomHashMap.this.f2559n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Object2ByteOpenCustomHashMap<K>.MapSpliterator implements ObjectSpliterator<Object2ByteMap.Entry<K>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapSpliterator
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

        final void acceptOnIndex(Consumer<? super Object2ByteMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapSpliterator
        public final Object2ByteOpenCustomHashMap<K>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Object2ByteMap.Entry<K>> implements Object2ByteMap.FastEntrySet<K> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Object2ByteMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.FastEntrySet
        public ObjectIterator<Object2ByteMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2ByteMap.Entry<K>> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            K curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            Object key = e.getKey();
            byte v = ((Byte) e.getValue()).byteValue();
            if (Object2ByteOpenCustomHashMap.this.strategy.equals(key, null)) {
                return Object2ByteOpenCustomHashMap.this.containsNullKey && Object2ByteOpenCustomHashMap.this.value[Object2ByteOpenCustomHashMap.this.f2559n] == v;
            }
            K[] key2 = Object2ByteOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Object2ByteOpenCustomHashMap.this.strategy.hashCode(key)) & Object2ByteOpenCustomHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (Object2ByteOpenCustomHashMap.this.strategy.equals(key, curr2)) {
                return Object2ByteOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Object2ByteOpenCustomHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!Object2ByteOpenCustomHashMap.this.strategy.equals(key, curr));
            return Object2ByteOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            Object key = e.getKey();
            byte v = ((Byte) e.getValue()).byteValue();
            if (!Object2ByteOpenCustomHashMap.this.strategy.equals(key, null)) {
                K[] key2 = Object2ByteOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Object2ByteOpenCustomHashMap.this.strategy.hashCode(key)) & Object2ByteOpenCustomHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!Object2ByteOpenCustomHashMap.this.strategy.equals(curr, key)) {
                    while (true) {
                        int i = (pos + 1) & Object2ByteOpenCustomHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (Object2ByteOpenCustomHashMap.this.strategy.equals(curr2, key) && Object2ByteOpenCustomHashMap.this.value[pos] == v) {
                            Object2ByteOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Object2ByteOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Object2ByteOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Object2ByteOpenCustomHashMap.this.containsNullKey || Object2ByteOpenCustomHashMap.this.value[Object2ByteOpenCustomHashMap.this.f2559n] != v) {
                return false;
            } else {
                Object2ByteOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ByteOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ByteOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2ByteMap.Entry<K>> consumer) {
            if (Object2ByteOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractObject2ByteMap.BasicEntry(Object2ByteOpenCustomHashMap.this.key[Object2ByteOpenCustomHashMap.this.f2559n], Object2ByteOpenCustomHashMap.this.value[Object2ByteOpenCustomHashMap.this.f2559n]));
            }
            int pos = Object2ByteOpenCustomHashMap.this.f2559n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Object2ByteOpenCustomHashMap.this.key[pos] != null) {
                    consumer.accept(new AbstractObject2ByteMap.BasicEntry(Object2ByteOpenCustomHashMap.this.key[pos], Object2ByteOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2ByteMap.Entry<K>> consumer) {
            AbstractObject2ByteMap.BasicEntry<K> entry = new AbstractObject2ByteMap.BasicEntry<>();
            if (Object2ByteOpenCustomHashMap.this.containsNullKey) {
                entry.key = Object2ByteOpenCustomHashMap.this.key[Object2ByteOpenCustomHashMap.this.f2559n];
                entry.value = Object2ByteOpenCustomHashMap.this.value[Object2ByteOpenCustomHashMap.this.f2559n];
                consumer.accept(entry);
            }
            int pos = Object2ByteOpenCustomHashMap.this.f2559n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Object2ByteOpenCustomHashMap.this.key[pos] != null) {
                    entry.key = Object2ByteOpenCustomHashMap.this.key[pos];
                    entry.value = Object2ByteOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
    public Object2ByteMap.FastEntrySet<K> object2ByteEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends Object2ByteOpenCustomHashMap<K>.MapIterator implements ObjectIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapIterator
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
            action.accept((Object) Object2ByteOpenCustomHashMap.this.key[index]);
        }

        @Override // java.util.Iterator
        public K next() {
            return Object2ByteOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Object2ByteOpenCustomHashMap<K>.MapSpliterator implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapSpliterator
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
            action.accept((Object) Object2ByteOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapSpliterator
        public final Object2ByteOpenCustomHashMap<K>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$KeySet.class */
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
            if (Object2ByteOpenCustomHashMap.this.containsNullKey) {
                consumer.accept((Object) Object2ByteOpenCustomHashMap.this.key[Object2ByteOpenCustomHashMap.this.f2559n]);
            }
            int pos = Object2ByteOpenCustomHashMap.this.f2559n;
            while (true) {
                pos--;
                if (pos != 0) {
                    Object obj = (Object) Object2ByteOpenCustomHashMap.this.key[pos];
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
            return Object2ByteOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2ByteOpenCustomHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Object2ByteOpenCustomHashMap.this.size;
            Object2ByteOpenCustomHashMap.this.removeByte(k);
            return Object2ByteOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ByteOpenCustomHashMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
    public ObjectSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends Object2ByteOpenCustomHashMap<K>.MapIterator implements ByteIterator {
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ByteConsumer byteConsumer) {
            forEachRemaining((ValueIterator) byteConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Object2ByteOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Object2ByteOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Object2ByteOpenCustomHashMap<K>.MapSpliterator implements ByteSpliterator {
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
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Object2ByteOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.MapSpliterator
        public final Object2ByteOpenCustomHashMap<K>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
    public Collection<Byte> values() {
        if (this.values == null) {
            this.values = new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2ByteOpenCustomHashMap.1
                @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
                public ByteIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
                public ByteSpliterator spliterator() {
                    return new ValueSpliterator();
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
                public void forEach(ByteConsumer consumer) {
                    if (Object2ByteOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Object2ByteOpenCustomHashMap.this.value[Object2ByteOpenCustomHashMap.this.f2559n]);
                    }
                    int pos = Object2ByteOpenCustomHashMap.this.f2559n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Object2ByteOpenCustomHashMap.this.key[pos] != null) {
                            consumer.accept(Object2ByteOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2ByteOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
                public boolean contains(byte v) {
                    return Object2ByteOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2ByteOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2560f)));
        if (l >= this.f2559n || this.size > HashCommon.maxFill(l, this.f2560f)) {
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
        byte[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        byte[] newValue = new byte[newN + 1];
        int i2 = this.f2559n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == null);
                int mix = HashCommon.mix(this.strategy.hashCode(key[i2])) & mask;
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
                newValue[newN] = value[this.f2559n];
                this.f2559n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2559n, this.f2560f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Object2ByteOpenCustomHashMap<K> clone() {
        try {
            Object2ByteOpenCustomHashMap<K> c = (Object2ByteOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (byte[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, java.lang.Object, java.util.Map
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
                t = this.strategy.hashCode((Object) this.key[i]);
            }
            t ^= this.value[i];
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2559n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        byte[] value = this.value;
        Object2ByteOpenCustomHashMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeObject(key[e]);
                s.writeByte(value[e]);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: K[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v27, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2559n = HashCommon.arraySize(this.size, this.f2560f);
        this.maxFill = HashCommon.maxFill(this.f2559n, this.f2560f);
        this.mask = this.f2559n - 1;
        K[] key = (K[]) new Object[this.f2559n + 1];
        this.key = key;
        byte[] value = new byte[this.f2559n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                Object readObject = s.readObject();
                byte v = s.readByte();
                if (this.strategy.equals(readObject, null)) {
                    pos = this.f2559n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(this.strategy.hashCode(readObject));
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
