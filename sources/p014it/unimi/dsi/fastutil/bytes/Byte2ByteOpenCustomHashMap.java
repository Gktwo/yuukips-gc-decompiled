package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap;
import p014it.unimi.dsi.fastutil.bytes.ByteHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap.class */
public class Byte2ByteOpenCustomHashMap extends AbstractByte2ByteMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient byte[] key;
    protected transient byte[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected ByteHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f1104n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1105f;
    protected transient Byte2ByteMap.FastEntrySet entries;
    protected transient ByteSet keys;
    protected transient ByteCollection values;

    public Byte2ByteOpenCustomHashMap(int expected, float f, ByteHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1105f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1104n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1104n - 1;
            this.maxFill = HashCommon.maxFill(this.f1104n, f);
            this.key = new byte[this.f1104n + 1];
            this.value = new byte[this.f1104n + 1];
        }
    }

    public Byte2ByteOpenCustomHashMap(int expected, ByteHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Byte2ByteOpenCustomHashMap(ByteHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Byte2ByteOpenCustomHashMap(Map<? extends Byte, ? extends Byte> m, float f, ByteHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Byte2ByteOpenCustomHashMap(Map<? extends Byte, ? extends Byte> m, ByteHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Byte2ByteOpenCustomHashMap(Byte2ByteMap m, float f, ByteHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Byte2ByteOpenCustomHashMap(Byte2ByteMap m, ByteHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Byte2ByteOpenCustomHashMap(byte[] k, byte[] v, float f, ByteHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Byte2ByteOpenCustomHashMap(byte[] k, byte[] v, ByteHash.Strategy strategy) {
        this(k, v, 0.75f, strategy);
    }

    public ByteHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1105f);
        if (needed > this.f1104n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1105f)))));
        if (needed > this.f1104n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public byte removeEntry(int pos) {
        byte oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f1104n > this.minN && this.size < this.maxFill / 4 && this.f1104n > 16) {
            rehash(this.f1104n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public byte removeNullEntry() {
        this.containsNullKey = false;
        byte oldValue = this.value[this.f1104n];
        this.size--;
        if (this.f1104n > this.minN && this.size < this.maxFill / 4 && this.f1104n > 16) {
            rehash(this.f1104n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap, java.util.Map
    public void putAll(Map<? extends Byte, ? extends Byte> m) {
        if (((double) this.f1105f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(byte k) {
        byte curr;
        if (this.strategy.equals(k, (byte) 0)) {
            return this.containsNullKey ? this.f1104n : -(this.f1104n + 1);
        }
        byte[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    private void insert(int pos, byte k, byte v) {
        if (pos == this.f1104n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1105f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
    public byte put(byte k, byte v) {
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

    public byte addTo(byte k, byte incr) {
        int pos;
        byte curr;
        if (!this.strategy.equals(k, (byte) 0)) {
            byte[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            byte curr2 = key[mix];
            if (curr2 != 0) {
                if (this.strategy.equals(curr2, k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (!this.strategy.equals(curr, k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f1104n, incr);
        } else {
            pos = this.f1104n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (byte) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1105f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        byte curr;
        byte[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
    public byte remove(byte k) {
        byte curr;
        if (this.strategy.equals(k, (byte) 0)) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
    public byte get(byte k) {
        byte curr;
        if (this.strategy.equals(k, (byte) 0)) {
            return this.containsNullKey ? this.value[this.f1104n] : this.defRetValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public boolean containsKey(byte k) {
        byte curr;
        if (this.strategy.equals(k, (byte) 0)) {
            return this.containsNullKey;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public boolean containsValue(byte v) {
        byte[] value = this.value;
        byte[] key = this.key;
        if (this.containsNullKey && value[this.f1104n] == v) {
            return true;
        }
        int i = this.f1104n;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
    public byte getOrDefault(byte k, byte defaultValue) {
        byte curr;
        if (this.strategy.equals(k, (byte) 0)) {
            return this.containsNullKey ? this.value[this.f1104n] : defaultValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte putIfAbsent(byte k, byte v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public boolean remove(byte k, byte v) {
        if (!this.strategy.equals(k, (byte) 0)) {
            byte[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            byte curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (!this.strategy.equals(k, curr) || v != this.value[pos]) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    byte curr2 = key[i];
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
        } else if (!this.containsNullKey || v != this.value[this.f1104n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public boolean replace(byte k, byte oldValue, byte v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte replace(byte k, byte v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        byte oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte computeIfAbsent(byte k, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte computeIfAbsent(byte key, Byte2ByteFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        byte newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte computeIfAbsentNullable(byte k, IntFunction<? extends Byte> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Byte newValue = (Byte) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        byte v = newValue.byteValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte computeIfPresent(byte k, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Byte newValue = (Byte) remappingFunction.apply(Byte.valueOf(k), Byte.valueOf(this.value[pos]));
        if (newValue == null) {
            if (this.strategy.equals(k, (byte) 0)) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte compute(byte k, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Byte newValue = (Byte) remappingFunction.apply(Byte.valueOf(k), pos >= 0 ? Byte.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (this.strategy.equals(k, (byte) 0)) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public byte merge(byte k, byte v, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
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
            if (this.strategy.equals(k, (byte) 0)) {
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
            Arrays.fill(this.key, (byte) 0);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Byte2ByteMap.Entry, Map.Entry<Byte, Byte>, ByteBytePair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry
        public byte getByteKey() {
            return Byte2ByteOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBytePair
        public byte leftByte() {
            return Byte2ByteOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry
        public byte getByteValue() {
            return Byte2ByteOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBytePair
        public byte rightByte() {
            return Byte2ByteOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry
        public byte setValue(byte v) {
            byte oldValue = Byte2ByteOpenCustomHashMap.this.value[this.index];
            Byte2ByteOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBytePair
        public ByteBytePair right(byte v) {
            Byte2ByteOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getKey() {
            return Byte.valueOf(Byte2ByteOpenCustomHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getValue() {
            return Byte.valueOf(Byte2ByteOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry
        @Deprecated
        public Byte setValue(Byte v) {
            return Byte.valueOf(setValue(v.byteValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Byte, Byte> e = (Map.Entry) o;
            return Byte2ByteOpenCustomHashMap.this.strategy.equals(Byte2ByteOpenCustomHashMap.this.key[this.index], e.getKey().byteValue()) && Byte2ByteOpenCustomHashMap.this.value[this.index] == e.getValue().byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Byte2ByteOpenCustomHashMap.this.strategy.hashCode(Byte2ByteOpenCustomHashMap.this.key[this.index]) ^ Byte2ByteOpenCustomHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Byte2ByteOpenCustomHashMap.this.key[this.index]) + "=>" + ((int) Byte2ByteOpenCustomHashMap.this.value[this.index]);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1106c;
        boolean mustReturnNullKey;
        ByteArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Byte2ByteOpenCustomHashMap.this.f1104n;
            this.last = -1;
            this.f1106c = Byte2ByteOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Byte2ByteOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1106c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1106c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Byte2ByteOpenCustomHashMap.this.f1104n;
                this.last = i;
                return i;
            }
            byte[] key = Byte2ByteOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    byte k = this.wrapped.getByte((-this.pos) - 1);
                    int mix = HashCommon.mix(Byte2ByteOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Byte2ByteOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Byte2ByteOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Byte2ByteOpenCustomHashMap.this.mask;
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
                int i = Byte2ByteOpenCustomHashMap.this.f1104n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1106c--;
            }
            byte[] key = Byte2ByteOpenCustomHashMap.this.key;
            while (this.f1106c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    byte k = this.wrapped.getByte((-this.pos) - 1);
                    int mix = HashCommon.mix(Byte2ByteOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Byte2ByteOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Byte2ByteOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Byte2ByteOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1106c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1106c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            byte curr;
            byte[] key = Byte2ByteOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Byte2ByteOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(Byte2ByteOpenCustomHashMap.this.strategy.hashCode(curr)) & Byte2ByteOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Byte2ByteOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Byte2ByteOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ByteArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Byte2ByteOpenCustomHashMap.this.value[pos] = Byte2ByteOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Byte2ByteOpenCustomHashMap.this.f1104n) {
                Byte2ByteOpenCustomHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Byte2ByteOpenCustomHashMap.this.remove(this.wrapped.getByte((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Byte2ByteOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Byte2ByteMap.Entry>> implements ObjectIterator<Byte2ByteMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Byte2ByteMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Byte2ByteMap.Entry>> implements ObjectIterator<Byte2ByteMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Byte2ByteMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f1107c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Byte2ByteOpenCustomHashMap.this.f1104n;
            this.f1107c = 0;
            this.mustReturnNull = Byte2ByteOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Byte2ByteOpenCustomHashMap.this.f1104n;
            this.f1107c = 0;
            this.mustReturnNull = Byte2ByteOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1107c++;
                acceptOnIndex(action, Byte2ByteOpenCustomHashMap.this.f1104n);
                return true;
            }
            byte[] key = Byte2ByteOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f1107c++;
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
                this.f1107c++;
                acceptOnIndex(action, Byte2ByteOpenCustomHashMap.this.f1104n);
            }
            byte[] key = Byte2ByteOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1107c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Byte2ByteOpenCustomHashMap.this.size - this.f1107c);
            }
            return Math.min((long) (Byte2ByteOpenCustomHashMap.this.size - this.f1107c), ((long) ((((double) Byte2ByteOpenCustomHashMap.this.realSize()) / ((double) Byte2ByteOpenCustomHashMap.this.f1104n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap.this
                byte[] r0 = r0.key
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Byte2ByteMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Byte2ByteMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Byte2ByteMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Byte2ByteMap.Entry> implements Byte2ByteMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Byte2ByteMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.FastEntrySet
        public ObjectIterator<Byte2ByteMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2ByteMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            byte curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            byte v = ((Byte) e.getValue()).byteValue();
            if (Byte2ByteOpenCustomHashMap.this.strategy.equals(k, (byte) 0)) {
                return Byte2ByteOpenCustomHashMap.this.containsNullKey && Byte2ByteOpenCustomHashMap.this.value[Byte2ByteOpenCustomHashMap.this.f1104n] == v;
            }
            byte[] key = Byte2ByteOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Byte2ByteOpenCustomHashMap.this.strategy.hashCode(k)) & Byte2ByteOpenCustomHashMap.this.mask;
            int pos = mix;
            byte curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (Byte2ByteOpenCustomHashMap.this.strategy.equals(k, curr2)) {
                return Byte2ByteOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Byte2ByteOpenCustomHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (!Byte2ByteOpenCustomHashMap.this.strategy.equals(k, curr));
            return Byte2ByteOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            byte v = ((Byte) e.getValue()).byteValue();
            if (!Byte2ByteOpenCustomHashMap.this.strategy.equals(k, (byte) 0)) {
                byte[] key = Byte2ByteOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Byte2ByteOpenCustomHashMap.this.strategy.hashCode(k)) & Byte2ByteOpenCustomHashMap.this.mask;
                int pos = mix;
                byte curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (!Byte2ByteOpenCustomHashMap.this.strategy.equals(curr, k)) {
                    while (true) {
                        int i = (pos + 1) & Byte2ByteOpenCustomHashMap.this.mask;
                        pos = i;
                        byte curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (Byte2ByteOpenCustomHashMap.this.strategy.equals(curr2, k) && Byte2ByteOpenCustomHashMap.this.value[pos] == v) {
                            Byte2ByteOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Byte2ByteOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Byte2ByteOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Byte2ByteOpenCustomHashMap.this.containsNullKey || Byte2ByteOpenCustomHashMap.this.value[Byte2ByteOpenCustomHashMap.this.f1104n] != v) {
                return false;
            } else {
                Byte2ByteOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2ByteOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2ByteOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Byte2ByteMap.Entry> consumer) {
            if (Byte2ByteOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractByte2ByteMap.BasicEntry(Byte2ByteOpenCustomHashMap.this.key[Byte2ByteOpenCustomHashMap.this.f1104n], Byte2ByteOpenCustomHashMap.this.value[Byte2ByteOpenCustomHashMap.this.f1104n]));
            }
            int pos = Byte2ByteOpenCustomHashMap.this.f1104n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Byte2ByteOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractByte2ByteMap.BasicEntry(Byte2ByteOpenCustomHashMap.this.key[pos], Byte2ByteOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.FastEntrySet
        public void fastForEach(Consumer<? super Byte2ByteMap.Entry> consumer) {
            AbstractByte2ByteMap.BasicEntry entry = new AbstractByte2ByteMap.BasicEntry();
            if (Byte2ByteOpenCustomHashMap.this.containsNullKey) {
                entry.key = Byte2ByteOpenCustomHashMap.this.key[Byte2ByteOpenCustomHashMap.this.f1104n];
                entry.value = Byte2ByteOpenCustomHashMap.this.value[Byte2ByteOpenCustomHashMap.this.f1104n];
                consumer.accept(entry);
            }
            int pos = Byte2ByteOpenCustomHashMap.this.f1104n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Byte2ByteOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Byte2ByteOpenCustomHashMap.this.key[pos];
                    entry.value = Byte2ByteOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteSortedMap
    public Byte2ByteMap.FastEntrySet byte2ByteEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<ByteConsumer> implements ByteIterator {
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ByteConsumer byteConsumer) {
            forEachRemaining((KeyIterator) byteConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Byte2ByteOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Byte2ByteOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<ByteConsumer, KeySpliterator> implements ByteSpliterator {
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
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Byte2ByteOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$KeySet.class */
    public final class KeySet extends AbstractByteSet {
        private KeySet() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Iterator<Byte> iterator() {
            return new KeyIterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public Spliterator<Byte> spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer consumer) {
            if (Byte2ByteOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Byte2ByteOpenCustomHashMap.this.key[Byte2ByteOpenCustomHashMap.this.f1104n]);
            }
            int pos = Byte2ByteOpenCustomHashMap.this.f1104n;
            while (true) {
                pos--;
                if (pos != 0) {
                    byte k = Byte2ByteOpenCustomHashMap.this.key[pos];
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
            return Byte2ByteOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return Byte2ByteOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            int oldSize = Byte2ByteOpenCustomHashMap.this.size;
            Byte2ByteOpenCustomHashMap.this.remove(k);
            return Byte2ByteOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2ByteOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
    public Set<Byte> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<ByteConsumer> implements ByteIterator {
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ByteConsumer byteConsumer) {
            forEachRemaining((ValueIterator) byteConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Byte2ByteOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Byte2ByteOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends MapSpliterator<ByteConsumer, ValueSpliterator> implements ByteSpliterator {
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
            action.accept(Byte2ByteOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
    public Collection<Byte> values() {
        if (this.values == null) {
            this.values = new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ByteOpenCustomHashMap.1
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
                    if (Byte2ByteOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Byte2ByteOpenCustomHashMap.this.value[Byte2ByteOpenCustomHashMap.this.f1104n]);
                    }
                    int pos = Byte2ByteOpenCustomHashMap.this.f1104n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Byte2ByteOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept(Byte2ByteOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Byte2ByteOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
                public boolean contains(byte v) {
                    return Byte2ByteOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Byte2ByteOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1105f)));
        if (l >= this.f1104n || this.size > HashCommon.maxFill(l, this.f1105f)) {
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
        byte[] key = this.key;
        byte[] value = this.value;
        int mask = newN - 1;
        byte[] newKey = new byte[newN + 1];
        byte[] newValue = new byte[newN + 1];
        int i2 = this.f1104n;
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
                newValue[newN] = value[this.f1104n];
                this.f1104n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1104n, this.f1105f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Byte2ByteOpenCustomHashMap clone() {
        try {
            Byte2ByteOpenCustomHashMap c = (Byte2ByteOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (byte[]) this.key.clone();
            c.value = (byte[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap, java.lang.Object, java.util.Map
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
            h += this.value[this.f1104n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        byte[] key = this.key;
        byte[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeByte(key[e]);
                s.writeByte(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1104n = HashCommon.arraySize(this.size, this.f1105f);
        this.maxFill = HashCommon.maxFill(this.f1104n, this.f1105f);
        this.mask = this.f1104n - 1;
        byte[] key = new byte[this.f1104n + 1];
        this.key = key;
        byte[] value = new byte[this.f1104n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                byte k = s.readByte();
                byte v = s.readByte();
                if (this.strategy.equals(k, (byte) 0)) {
                    pos = this.f1104n;
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
