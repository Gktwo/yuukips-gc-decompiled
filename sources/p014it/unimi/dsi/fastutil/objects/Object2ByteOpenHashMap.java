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

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap.class */
public class Object2ByteOpenHashMap<K> extends AbstractObject2ByteMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient byte[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f2527n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2528f;
    protected transient Object2ByteMap.FastEntrySet<K> entries;
    protected transient ObjectSet<K> keys;
    protected transient ByteCollection values;

    public Object2ByteOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2528f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2527n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2527n - 1;
            this.maxFill = HashCommon.maxFill(this.f2527n, f);
            this.key = (K[]) new Object[this.f2527n + 1];
            this.value = new byte[this.f2527n + 1];
        }
    }

    public Object2ByteOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Object2ByteOpenHashMap() {
        this(16, 0.75f);
    }

    public Object2ByteOpenHashMap(Map<? extends K, ? extends Byte> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Object2ByteOpenHashMap(Map<? extends K, ? extends Byte> m) {
        this(m, 0.75f);
    }

    public Object2ByteOpenHashMap(Object2ByteMap<K> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Object2ByteOpenHashMap(Object2ByteMap<K> m) {
        this((Object2ByteMap) m, 0.75f);
    }

    public Object2ByteOpenHashMap(K[] k, byte[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Object2ByteOpenHashMap<K>) k[i], v[i]);
        }
    }

    public Object2ByteOpenHashMap(K[] k, byte[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2528f);
        if (needed > this.f2527n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2528f)))));
        if (needed > this.f2527n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public byte removeEntry(int pos) {
        byte oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2527n > this.minN && this.size < this.maxFill / 4 && this.f2527n > 16) {
            rehash(this.f2527n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public byte removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2527n] = null;
        byte oldValue = this.value[this.f2527n];
        this.size--;
        if (this.f2527n > this.minN && this.size < this.maxFill / 4 && this.f2527n > 16) {
            rehash(this.f2527n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Byte> m) {
        if (((double) this.f2528f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.f2527n : -(this.f2527n + 1);
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

    private void insert(int pos, K k, byte v) {
        if (pos == this.f2527n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2528f));
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
            return addToValue(this.f2527n, incr);
        } else {
            pos = this.f2527n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (byte) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2528f));
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
    public byte removeByte(Object k) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
    public byte getByte(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2527n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, p014it.unimi.dsi.fastutil.Function
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap
    public boolean containsValue(byte v) {
        byte[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2527n] == v) {
            return true;
        }
        int i = this.f2527n;
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
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2527n] : defaultValue;
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
        } else if (!this.containsNullKey || v != this.value[this.f2527n]) {
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
            if (k == null) {
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
                if (k == null) {
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
            if (k == null) {
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$MapEntry.class */
    public final class MapEntry implements Object2ByteMap.Entry<K>, Map.Entry<K, Byte>, ObjectBytePair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Object2ByteOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Object2ByteOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.Entry
        public byte getByteValue() {
            return Object2ByteOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBytePair
        public byte rightByte() {
            return Object2ByteOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.Entry
        public byte setValue(byte v) {
            byte oldValue = Object2ByteOpenHashMap.this.value[this.index];
            Object2ByteOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBytePair
        public ObjectBytePair<K> right(byte v) {
            Object2ByteOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getValue() {
            return Byte.valueOf(Object2ByteOpenHashMap.this.value[this.index]);
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
            return Objects.equals(Object2ByteOpenHashMap.this.key[this.index], e.getKey()) && Object2ByteOpenHashMap.this.value[this.index] == e.getValue().byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (Object2ByteOpenHashMap.this.key[this.index] == null ? 0 : Object2ByteOpenHashMap.this.key[this.index].hashCode()) ^ Object2ByteOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Object2ByteOpenHashMap.this.key[this.index] + "=>" + ((int) Object2ByteOpenHashMap.this.value[this.index]);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2529c;
        boolean mustReturnNullKey;
        ObjectArrayList<K> wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Object2ByteOpenHashMap.this.f2527n;
            this.last = -1;
            this.f2529c = Object2ByteOpenHashMap.this.size;
            this.mustReturnNullKey = Object2ByteOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2529c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2529c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Object2ByteOpenHashMap.this.f2527n;
                this.last = i;
                return i;
            }
            K[] key = Object2ByteOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(k.hashCode());
                    int i3 = Object2ByteOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k.equals(key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Object2ByteOpenHashMap.this.mask;
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
                int i = Object2ByteOpenHashMap.this.f2527n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2529c--;
            }
            K[] key = Object2ByteOpenHashMap.this.key;
            while (this.f2529c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(k.hashCode());
                    int i3 = Object2ByteOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k.equals(key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Object2ByteOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2529c--;
                } else if (key[this.pos] != null) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2529c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            K curr;
            K[] key = Object2ByteOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Object2ByteOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(curr.hashCode()) & Object2ByteOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Object2ByteOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Object2ByteOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ObjectArrayList<>(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Object2ByteOpenHashMap.this.value[pos] = Object2ByteOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Object2ByteOpenHashMap.this.f2527n) {
                Object2ByteOpenHashMap.this.containsNullKey = false;
                Object2ByteOpenHashMap.this.key[Object2ByteOpenHashMap.this.f2527n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Object2ByteOpenHashMap.this.removeByte(this.wrapped.set((-this.pos) - 1, null));
                this.last = -1;
                return;
            }
            Object2ByteOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Object2ByteOpenHashMap<K>.MapIterator implements ObjectIterator<Object2ByteMap.Entry<K>> {
        private Object2ByteOpenHashMap<K>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Object2ByteOpenHashMap<K>.MapEntry next() {
            Object2ByteOpenHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Object2ByteMap.Entry<K>> action, int index) {
            Object2ByteOpenHashMap<K>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Object2ByteOpenHashMap<K>.MapIterator implements ObjectIterator<Object2ByteMap.Entry<K>> {
        private final Object2ByteOpenHashMap<K>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Object2ByteOpenHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Object2ByteMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Object2ByteOpenHashMap<K>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f2530c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Object2ByteOpenHashMap.this.f2527n;
            this.f2530c = 0;
            this.mustReturnNull = Object2ByteOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Object2ByteOpenHashMap.this.f2527n;
            this.f2530c = 0;
            this.mustReturnNull = Object2ByteOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2530c++;
                acceptOnIndex(action, Object2ByteOpenHashMap.this.f2527n);
                return true;
            }
            K[] key = Object2ByteOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    this.f2530c++;
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
                this.f2530c++;
                acceptOnIndex(action, Object2ByteOpenHashMap.this.f2527n);
            }
            K[] key = Object2ByteOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    acceptOnIndex(action, this.pos);
                    this.f2530c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Object2ByteOpenHashMap.this.size - this.f2530c);
            }
            return Math.min((long) (Object2ByteOpenHashMap.this.size - this.f2530c), ((long) ((((double) Object2ByteOpenHashMap.this.realSize()) / ((double) Object2ByteOpenHashMap.this.f2527n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap r0 = p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Object2ByteOpenHashMap<K>.MapSpliterator implements ObjectSpliterator<Object2ByteMap.Entry<K>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapSpliterator
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
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapSpliterator
        public final Object2ByteOpenHashMap<K>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$MapEntrySet.class */
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
            if (key == null) {
                return Object2ByteOpenHashMap.this.containsNullKey && Object2ByteOpenHashMap.this.value[Object2ByteOpenHashMap.this.f2527n] == v;
            }
            K[] key2 = Object2ByteOpenHashMap.this.key;
            int mix = HashCommon.mix(key.hashCode()) & Object2ByteOpenHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (key.equals(curr2)) {
                return Object2ByteOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Object2ByteOpenHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!key.equals(curr));
            return Object2ByteOpenHashMap.this.value[pos] == v;
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
            if (key != null) {
                K[] key2 = Object2ByteOpenHashMap.this.key;
                int mix = HashCommon.mix(key.hashCode()) & Object2ByteOpenHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!curr.equals(key)) {
                    while (true) {
                        int i = (pos + 1) & Object2ByteOpenHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (curr2.equals(key) && Object2ByteOpenHashMap.this.value[pos] == v) {
                            Object2ByteOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Object2ByteOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Object2ByteOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Object2ByteOpenHashMap.this.containsNullKey || Object2ByteOpenHashMap.this.value[Object2ByteOpenHashMap.this.f2527n] != v) {
                return false;
            } else {
                Object2ByteOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2ByteOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ByteOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2ByteMap.Entry<K>> consumer) {
            if (Object2ByteOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractObject2ByteMap.BasicEntry(Object2ByteOpenHashMap.this.key[Object2ByteOpenHashMap.this.f2527n], Object2ByteOpenHashMap.this.value[Object2ByteOpenHashMap.this.f2527n]));
            }
            int pos = Object2ByteOpenHashMap.this.f2527n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Object2ByteOpenHashMap.this.key[pos] != null) {
                    consumer.accept(new AbstractObject2ByteMap.BasicEntry(Object2ByteOpenHashMap.this.key[pos], Object2ByteOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2ByteMap.Entry<K>> consumer) {
            AbstractObject2ByteMap.BasicEntry<K> entry = new AbstractObject2ByteMap.BasicEntry<>();
            if (Object2ByteOpenHashMap.this.containsNullKey) {
                entry.key = Object2ByteOpenHashMap.this.key[Object2ByteOpenHashMap.this.f2527n];
                entry.value = Object2ByteOpenHashMap.this.value[Object2ByteOpenHashMap.this.f2527n];
                consumer.accept(entry);
            }
            int pos = Object2ByteOpenHashMap.this.f2527n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Object2ByteOpenHashMap.this.key[pos] != null) {
                    entry.key = Object2ByteOpenHashMap.this.key[pos];
                    entry.value = Object2ByteOpenHashMap.this.value[pos];
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Object2ByteOpenHashMap<K>.MapIterator implements ObjectIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapIterator
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
            action.accept((Object) Object2ByteOpenHashMap.this.key[index]);
        }

        @Override // java.util.Iterator
        public K next() {
            return Object2ByteOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Object2ByteOpenHashMap<K>.MapSpliterator implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapSpliterator
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
            action.accept((Object) Object2ByteOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapSpliterator
        public final Object2ByteOpenHashMap<K>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$KeySet.class */
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
            if (Object2ByteOpenHashMap.this.containsNullKey) {
                consumer.accept((Object) Object2ByteOpenHashMap.this.key[Object2ByteOpenHashMap.this.f2527n]);
            }
            int pos = Object2ByteOpenHashMap.this.f2527n;
            while (true) {
                pos--;
                if (pos != 0) {
                    Object obj = (Object) Object2ByteOpenHashMap.this.key[pos];
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
            return Object2ByteOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2ByteOpenHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Object2ByteOpenHashMap.this.size;
            Object2ByteOpenHashMap.this.removeByte(k);
            return Object2ByteOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2ByteOpenHashMap.this.clear();
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Object2ByteOpenHashMap<K>.MapIterator implements ByteIterator {
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ByteConsumer byteConsumer) {
            forEachRemaining((ValueIterator) byteConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Object2ByteOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Object2ByteOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteOpenHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Object2ByteOpenHashMap<K>.MapSpliterator implements ByteSpliterator {
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
            action.accept(Object2ByteOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.MapSpliterator
        public final Object2ByteOpenHashMap<K>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
    public Collection<Byte> values() {
        if (this.values == null) {
            this.values = new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2ByteOpenHashMap.1
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
                    if (Object2ByteOpenHashMap.this.containsNullKey) {
                        consumer.accept(Object2ByteOpenHashMap.this.value[Object2ByteOpenHashMap.this.f2527n]);
                    }
                    int pos = Object2ByteOpenHashMap.this.f2527n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Object2ByteOpenHashMap.this.key[pos] != null) {
                            consumer.accept(Object2ByteOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2ByteOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
                public boolean contains(byte v) {
                    return Object2ByteOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2ByteOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2528f)));
        if (l >= this.f2527n || this.size > HashCommon.maxFill(l, this.f2528f)) {
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
        int i2 = this.f2527n;
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
                newValue[newN] = value[this.f2527n];
                this.f2527n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2527n, this.f2528f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Object2ByteOpenHashMap<K> clone() {
        try {
            Object2ByteOpenHashMap<K> c = (Object2ByteOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (byte[]) this.value.clone();
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
                t = this.key[i].hashCode();
            }
            t ^= this.value[i];
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2527n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        byte[] value = this.value;
        Object2ByteOpenHashMap<K>.EntryIterator i = new EntryIterator();
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
    /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2527n = HashCommon.arraySize(this.size, this.f2528f);
        this.maxFill = HashCommon.maxFill(this.f2527n, this.f2528f);
        this.mask = this.f2527n - 1;
        K[] key = (K[]) new Object[this.f2527n + 1];
        this.key = key;
        byte[] value = new byte[this.f2527n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                Object readObject = s.readObject();
                byte v = s.readByte();
                if (readObject == null) {
                    pos = this.f2527n;
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
