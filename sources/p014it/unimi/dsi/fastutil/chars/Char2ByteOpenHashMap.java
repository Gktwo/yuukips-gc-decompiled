package p014it.unimi.dsi.fastutil.chars;

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
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap;
import p014it.unimi.dsi.fastutil.chars.Char2ByteMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap.class */
public class Char2ByteOpenHashMap extends AbstractChar2ByteMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient char[] key;
    protected transient byte[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f1335n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1336f;
    protected transient Char2ByteMap.FastEntrySet entries;
    protected transient CharSet keys;
    protected transient ByteCollection values;

    public Char2ByteOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1336f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1335n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1335n - 1;
            this.maxFill = HashCommon.maxFill(this.f1335n, f);
            this.key = new char[this.f1335n + 1];
            this.value = new byte[this.f1335n + 1];
        }
    }

    public Char2ByteOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Char2ByteOpenHashMap() {
        this(16, 0.75f);
    }

    public Char2ByteOpenHashMap(Map<? extends Character, ? extends Byte> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Char2ByteOpenHashMap(Map<? extends Character, ? extends Byte> m) {
        this(m, 0.75f);
    }

    public Char2ByteOpenHashMap(Char2ByteMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Char2ByteOpenHashMap(Char2ByteMap m) {
        this(m, 0.75f);
    }

    public Char2ByteOpenHashMap(char[] k, byte[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Char2ByteOpenHashMap(char[] k, byte[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1336f);
        if (needed > this.f1335n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1336f)))));
        if (needed > this.f1335n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public byte removeEntry(int pos) {
        byte oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f1335n > this.minN && this.size < this.maxFill / 4 && this.f1335n > 16) {
            rehash(this.f1335n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public byte removeNullEntry() {
        this.containsNullKey = false;
        byte oldValue = this.value[this.f1335n];
        this.size--;
        if (this.f1335n > this.minN && this.size < this.maxFill / 4 && this.f1335n > 16) {
            rehash(this.f1335n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, java.util.Map
    public void putAll(Map<? extends Character, ? extends Byte> m) {
        if (((double) this.f1336f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? this.f1335n : -(this.f1335n + 1);
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    private void insert(int pos, char k, byte v) {
        if (pos == this.f1335n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1336f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteFunction
    public byte put(char k, byte v) {
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

    public byte addTo(char k, byte incr) {
        int pos;
        char curr;
        if (k != 0) {
            char[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            char curr2 = key[mix];
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
            return addToValue(this.f1335n, incr);
        } else {
            pos = this.f1335n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (byte) (this.defRetValue + incr);
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1336f));
        }
        return this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteFunction
    public byte remove(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteFunction
    public byte get(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1335n] : this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteFunction, p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public boolean containsKey(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public boolean containsValue(byte v) {
        byte[] value = this.value;
        char[] key = this.key;
        if (this.containsNullKey && value[this.f1335n] == v) {
            return true;
        }
        int i = this.f1335n;
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteFunction
    public byte getOrDefault(char k, byte defaultValue) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1335n] : defaultValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte putIfAbsent(char k, byte v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public boolean remove(char k, byte v) {
        if (k != 0) {
            char[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            char curr = key[mix];
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
                char curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f1335n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public boolean replace(char k, byte oldValue, byte v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte replace(char k, byte v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        byte oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte computeIfAbsent(char k, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte computeIfAbsent(char key, Char2ByteFunction mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte computeIfAbsentNullable(char k, IntFunction<? extends Byte> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte computeIfPresent(char k, BiFunction<? super Character, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Byte newValue = (Byte) remappingFunction.apply(Character.valueOf(k), Byte.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte compute(char k, BiFunction<? super Character, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Byte newValue = (Byte) remappingFunction.apply(Character.valueOf(k), pos >= 0 ? Byte.valueOf(this.value[pos]) : null);
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
        byte newVal = newValue.byteValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public byte merge(char k, byte v, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
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
            if (k == 0) {
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
            Arrays.fill(this.key, (char) 0);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$MapEntry.class */
    public final class MapEntry implements Char2ByteMap.Entry, Map.Entry<Character, Byte>, CharBytePair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry
        public char getCharKey() {
            return Char2ByteOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
        public char leftChar() {
            return Char2ByteOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry
        public byte getByteValue() {
            return Char2ByteOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
        public byte rightByte() {
            return Char2ByteOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry
        public byte setValue(byte v) {
            byte oldValue = Char2ByteOpenHashMap.this.value[this.index];
            Char2ByteOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
        public CharBytePair right(byte v) {
            Char2ByteOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getKey() {
            return Character.valueOf(Char2ByteOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getValue() {
            return Byte.valueOf(Char2ByteOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry
        @Deprecated
        public Byte setValue(Byte v) {
            return Byte.valueOf(setValue(v.byteValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Character, Byte> e = (Map.Entry) o;
            return Char2ByteOpenHashMap.this.key[this.index] == e.getKey().charValue() && Char2ByteOpenHashMap.this.value[this.index] == e.getValue().byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Char2ByteOpenHashMap.this.key[this.index] ^ Char2ByteOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Char2ByteOpenHashMap.this.key[this.index] + "=>" + ((int) Char2ByteOpenHashMap.this.value[this.index]);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1337c;
        boolean mustReturnNullKey;
        CharArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Char2ByteOpenHashMap.this.f1335n;
            this.last = -1;
            this.f1337c = Char2ByteOpenHashMap.this.size;
            this.mustReturnNullKey = Char2ByteOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1337c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1337c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Char2ByteOpenHashMap.this.f1335n;
                this.last = i;
                return i;
            }
            char[] key = Char2ByteOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    char k = this.wrapped.getChar((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Char2ByteOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k == key[p]) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Char2ByteOpenHashMap.this.mask;
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
                int i = Char2ByteOpenHashMap.this.f1335n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1337c--;
            }
            char[] key = Char2ByteOpenHashMap.this.key;
            while (this.f1337c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    char k = this.wrapped.getChar((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Char2ByteOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k == key[p]) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Char2ByteOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1337c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1337c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            char curr;
            char[] key = Char2ByteOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Char2ByteOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix((int) curr) & Char2ByteOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Char2ByteOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Char2ByteOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new CharArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Char2ByteOpenHashMap.this.value[pos] = Char2ByteOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Char2ByteOpenHashMap.this.f1335n) {
                Char2ByteOpenHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Char2ByteOpenHashMap.this.remove(this.wrapped.getChar((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Char2ByteOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Char2ByteMap.Entry>> implements ObjectIterator<Char2ByteMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Char2ByteMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Char2ByteMap.Entry>> implements ObjectIterator<Char2ByteMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Char2ByteMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f1338c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Char2ByteOpenHashMap.this.f1335n;
            this.f1338c = 0;
            this.mustReturnNull = Char2ByteOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Char2ByteOpenHashMap.this.f1335n;
            this.f1338c = 0;
            this.mustReturnNull = Char2ByteOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1338c++;
                acceptOnIndex(action, Char2ByteOpenHashMap.this.f1335n);
                return true;
            }
            char[] key = Char2ByteOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f1338c++;
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
                this.f1338c++;
                acceptOnIndex(action, Char2ByteOpenHashMap.this.f1335n);
            }
            char[] key = Char2ByteOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1338c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Char2ByteOpenHashMap.this.size - this.f1338c);
            }
            return Math.min((long) (Char2ByteOpenHashMap.this.size - this.f1338c), ((long) ((((double) Char2ByteOpenHashMap.this.realSize()) / ((double) Char2ByteOpenHashMap.this.f1335n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap r0 = p014it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Char2ByteMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Char2ByteMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Char2ByteMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Char2ByteMap.Entry> implements Char2ByteMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Char2ByteMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.FastEntrySet
        public ObjectIterator<Char2ByteMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2ByteMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            char curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            byte v = ((Byte) e.getValue()).byteValue();
            if (k == 0) {
                return Char2ByteOpenHashMap.this.containsNullKey && Char2ByteOpenHashMap.this.value[Char2ByteOpenHashMap.this.f1335n] == v;
            }
            char[] key = Char2ByteOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Char2ByteOpenHashMap.this.mask;
            int pos = mix;
            char curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Char2ByteOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Char2ByteOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Char2ByteOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            byte v = ((Byte) e.getValue()).byteValue();
            if (k != 0) {
                char[] key = Char2ByteOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Char2ByteOpenHashMap.this.mask;
                int pos = mix;
                char curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Char2ByteOpenHashMap.this.mask;
                        pos = i;
                        char curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Char2ByteOpenHashMap.this.value[pos] == v) {
                            Char2ByteOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Char2ByteOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Char2ByteOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Char2ByteOpenHashMap.this.containsNullKey || Char2ByteOpenHashMap.this.value[Char2ByteOpenHashMap.this.f1335n] != v) {
                return false;
            } else {
                Char2ByteOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2ByteOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2ByteOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Char2ByteMap.Entry> consumer) {
            if (Char2ByteOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractChar2ByteMap.BasicEntry(Char2ByteOpenHashMap.this.key[Char2ByteOpenHashMap.this.f1335n], Char2ByteOpenHashMap.this.value[Char2ByteOpenHashMap.this.f1335n]));
            }
            int pos = Char2ByteOpenHashMap.this.f1335n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Char2ByteOpenHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractChar2ByteMap.BasicEntry(Char2ByteOpenHashMap.this.key[pos], Char2ByteOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.FastEntrySet
        public void fastForEach(Consumer<? super Char2ByteMap.Entry> consumer) {
            AbstractChar2ByteMap.BasicEntry entry = new AbstractChar2ByteMap.BasicEntry();
            if (Char2ByteOpenHashMap.this.containsNullKey) {
                entry.key = Char2ByteOpenHashMap.this.key[Char2ByteOpenHashMap.this.f1335n];
                entry.value = Char2ByteOpenHashMap.this.value[Char2ByteOpenHashMap.this.f1335n];
                consumer.accept(entry);
            }
            int pos = Char2ByteOpenHashMap.this.f1335n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Char2ByteOpenHashMap.this.key[pos] != 0) {
                    entry.key = Char2ByteOpenHashMap.this.key[pos];
                    entry.value = Char2ByteOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteSortedMap
    public Char2ByteMap.FastEntrySet char2ByteEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$KeyIterator.class */
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
            action.accept(Char2ByteOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Char2ByteOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$KeySpliterator.class */
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
            action.accept(Char2ByteOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$KeySet.class */
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
            if (Char2ByteOpenHashMap.this.containsNullKey) {
                consumer.accept(Char2ByteOpenHashMap.this.key[Char2ByteOpenHashMap.this.f1335n]);
            }
            int pos = Char2ByteOpenHashMap.this.f1335n;
            while (true) {
                pos--;
                if (pos != 0) {
                    char k = Char2ByteOpenHashMap.this.key[pos];
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
            return Char2ByteOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return Char2ByteOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            int oldSize = Char2ByteOpenHashMap.this.size;
            Char2ByteOpenHashMap.this.remove(k);
            return Char2ByteOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2ByteOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    public Set<Character> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$ValueIterator.class */
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
            action.accept(Char2ByteOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Char2ByteOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteOpenHashMap$ValueSpliterator.class */
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
            action.accept(Char2ByteOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    public Collection<Byte> values() {
        if (this.values == null) {
            this.values = new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.chars.Char2ByteOpenHashMap.1
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
                    if (Char2ByteOpenHashMap.this.containsNullKey) {
                        consumer.accept(Char2ByteOpenHashMap.this.value[Char2ByteOpenHashMap.this.f1335n]);
                    }
                    int pos = Char2ByteOpenHashMap.this.f1335n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Char2ByteOpenHashMap.this.key[pos] != 0) {
                            consumer.accept(Char2ByteOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Char2ByteOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
                public boolean contains(byte v) {
                    return Char2ByteOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Char2ByteOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1336f)));
        if (l >= this.f1335n || this.size > HashCommon.maxFill(l, this.f1336f)) {
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
        byte[] value = this.value;
        int mask = newN - 1;
        char[] newKey = new char[newN + 1];
        byte[] newValue = new byte[newN + 1];
        int i2 = this.f1335n;
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
                newValue[newN] = value[this.f1335n];
                this.f1335n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1335n, this.f1336f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Char2ByteOpenHashMap clone() {
        try {
            Char2ByteOpenHashMap c = (Char2ByteOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (char[]) this.key.clone();
            c.value = (byte[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap, java.lang.Object, java.util.Map
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
            h += this.value[this.f1335n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        char[] key = this.key;
        byte[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeChar(key[e]);
                s.writeByte(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1335n = HashCommon.arraySize(this.size, this.f1336f);
        this.maxFill = HashCommon.maxFill(this.f1335n, this.f1336f);
        this.mask = this.f1335n - 1;
        char[] key = new char[this.f1335n + 1];
        this.key = key;
        byte[] value = new byte[this.f1335n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                char k = s.readChar();
                byte v = s.readByte();
                if (k == 0) {
                    pos = this.f1335n;
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
