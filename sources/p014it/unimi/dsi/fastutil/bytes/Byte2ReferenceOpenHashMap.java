package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap.class */
public class Byte2ReferenceOpenHashMap<V> extends AbstractByte2ReferenceMap<V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient byte[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f1192n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1193f;
    protected transient Byte2ReferenceMap.FastEntrySet<V> entries;
    protected transient ByteSet keys;
    protected transient ReferenceCollection<V> values;

    public Byte2ReferenceOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1193f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1192n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1192n - 1;
            this.maxFill = HashCommon.maxFill(this.f1192n, f);
            this.key = new byte[this.f1192n + 1];
            this.value = (V[]) new Object[this.f1192n + 1];
        }
    }

    public Byte2ReferenceOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Byte2ReferenceOpenHashMap() {
        this(16, 0.75f);
    }

    public Byte2ReferenceOpenHashMap(Map<? extends Byte, ? extends V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Byte2ReferenceOpenHashMap(Map<? extends Byte, ? extends V> m) {
        this(m, 0.75f);
    }

    public Byte2ReferenceOpenHashMap(Byte2ReferenceMap<V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Byte2ReferenceOpenHashMap(Byte2ReferenceMap<V> m) {
        this((Byte2ReferenceMap) m, 0.75f);
    }

    public Byte2ReferenceOpenHashMap(byte[] k, V[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (byte) v[i]);
        }
    }

    public Byte2ReferenceOpenHashMap(byte[] k, V[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1193f);
        if (needed > this.f1192n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1193f)))));
        if (needed > this.f1192n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public V removeEntry(int pos) {
        V oldValue = this.value[pos];
        this.value[pos] = null;
        this.size--;
        shiftKeys(pos);
        if (this.f1192n > this.minN && this.size < this.maxFill / 4 && this.f1192n > 16) {
            rehash(this.f1192n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.f1192n];
        this.value[this.f1192n] = null;
        this.size--;
        if (this.f1192n > this.minN && this.size < this.maxFill / 4 && this.f1192n > 16) {
            rehash(this.f1192n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, java.util.Map
    public void putAll(Map<? extends Byte, ? extends V> m) {
        if (((double) this.f1193f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? this.f1192n : -(this.f1192n + 1);
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    private void insert(int pos, byte k, V v) {
        if (pos == this.f1192n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1193f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction
    public V put(byte k, V v) {
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
                    this.value[pos] = null;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction
    public V remove(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (k == curr2) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (k != curr);
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction
    public V get(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1192n] : (V) this.defRetValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public boolean containsKey(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        byte[] key = this.key;
        if (this.containsNullKey && value[this.f1192n] == v) {
            return true;
        }
        int i = this.f1192n;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction
    public V getOrDefault(byte k, V defaultValue) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1192n] : defaultValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public V putIfAbsent(byte k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public boolean remove(byte k, Object v) {
        if (k != 0) {
            byte[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            byte curr = key[mix];
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
                byte curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f1192n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public boolean replace(byte k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public V replace(byte k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public V computeIfAbsent(byte k, IntFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        V newValue = (V) mappingFunction.apply(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public V computeIfAbsent(byte key, Byte2ReferenceFunction<? extends V> mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public V computeIfPresent(byte k, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(Byte.valueOf(k), (Object) this.value[pos]);
            if (newValue == null) {
                if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public V compute(byte k, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(Byte.valueOf(k), pos >= 0 ? (Object) this.value[pos] : (Object) null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == 0) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap
    public V merge(byte k, V v, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
            if (k == 0) {
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
            Arrays.fill(this.key, (byte) 0);
            Arrays.fill(this.value, (Object) null);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$MapEntry.class */
    public final class MapEntry implements Byte2ReferenceMap.Entry<V>, Map.Entry<Byte, V>, ByteReferencePair<V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap.Entry
        public byte getByteKey() {
            return Byte2ReferenceOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteReferencePair
        public byte leftByte() {
            return Byte2ReferenceOpenHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Byte2ReferenceOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Byte2ReferenceOpenHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Byte2ReferenceOpenHashMap.this.value[this.index];
            Byte2ReferenceOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public ByteReferencePair<V> right(V v) {
            Byte2ReferenceOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getKey() {
            return Byte.valueOf(Byte2ReferenceOpenHashMap.this.key[this.index]);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Byte, V> e = (Map.Entry) o;
            return Byte2ReferenceOpenHashMap.this.key[this.index] == e.getKey().byteValue() && Byte2ReferenceOpenHashMap.this.value[this.index] == e.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Byte2ReferenceOpenHashMap.this.key[this.index] ^ (Byte2ReferenceOpenHashMap.this.value[this.index] == null ? 0 : System.identityHashCode(Byte2ReferenceOpenHashMap.this.value[this.index]));
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Byte2ReferenceOpenHashMap.this.key[this.index]) + "=>" + Byte2ReferenceOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1194c;
        boolean mustReturnNullKey;
        ByteArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Byte2ReferenceOpenHashMap.this.f1192n;
            this.last = -1;
            this.f1194c = Byte2ReferenceOpenHashMap.this.size;
            this.mustReturnNullKey = Byte2ReferenceOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1194c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1194c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Byte2ReferenceOpenHashMap.this.f1192n;
                this.last = i;
                return i;
            }
            byte[] key = Byte2ReferenceOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    byte k = this.wrapped.getByte((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Byte2ReferenceOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k == key[p]) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Byte2ReferenceOpenHashMap.this.mask;
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
                int i = Byte2ReferenceOpenHashMap.this.f1192n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1194c--;
            }
            byte[] key = Byte2ReferenceOpenHashMap.this.key;
            while (this.f1194c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    byte k = this.wrapped.getByte((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Byte2ReferenceOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k == key[p]) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Byte2ReferenceOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1194c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1194c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            byte curr;
            byte[] key = Byte2ReferenceOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Byte2ReferenceOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        Byte2ReferenceOpenHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix((int) curr) & Byte2ReferenceOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Byte2ReferenceOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Byte2ReferenceOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ByteArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Byte2ReferenceOpenHashMap.this.value[pos] = Byte2ReferenceOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Byte2ReferenceOpenHashMap.this.f1192n) {
                Byte2ReferenceOpenHashMap.this.containsNullKey = false;
                Byte2ReferenceOpenHashMap.this.value[Byte2ReferenceOpenHashMap.this.f1192n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Byte2ReferenceOpenHashMap.this.remove(this.wrapped.getByte((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Byte2ReferenceOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Byte2ReferenceOpenHashMap<V>.MapIterator implements ObjectIterator<Byte2ReferenceMap.Entry<V>> {
        private Byte2ReferenceOpenHashMap<V>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Byte2ReferenceOpenHashMap<V>.MapEntry next() {
            Byte2ReferenceOpenHashMap<V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Byte2ReferenceMap.Entry<V>> action, int index) {
            Byte2ReferenceOpenHashMap<V>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Byte2ReferenceOpenHashMap<V>.MapIterator implements ObjectIterator<Byte2ReferenceMap.Entry<V>> {
        private final Byte2ReferenceOpenHashMap<V>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Byte2ReferenceOpenHashMap<V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Byte2ReferenceMap.Entry<V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Byte2ReferenceOpenHashMap<V>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f1195c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Byte2ReferenceOpenHashMap.this.f1192n;
            this.f1195c = 0;
            this.mustReturnNull = Byte2ReferenceOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Byte2ReferenceOpenHashMap.this.f1192n;
            this.f1195c = 0;
            this.mustReturnNull = Byte2ReferenceOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1195c++;
                acceptOnIndex(action, Byte2ReferenceOpenHashMap.this.f1192n);
                return true;
            }
            byte[] key = Byte2ReferenceOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f1195c++;
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
                this.f1195c++;
                acceptOnIndex(action, Byte2ReferenceOpenHashMap.this.f1192n);
            }
            byte[] key = Byte2ReferenceOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1195c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Byte2ReferenceOpenHashMap.this.size - this.f1195c);
            }
            return Math.min((long) (Byte2ReferenceOpenHashMap.this.size - this.f1195c), ((long) ((((double) Byte2ReferenceOpenHashMap.this.realSize()) / ((double) Byte2ReferenceOpenHashMap.this.f1192n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap r0 = p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Byte2ReferenceOpenHashMap<V>.MapSpliterator implements ObjectSpliterator<Byte2ReferenceMap.Entry<V>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapSpliterator
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

        final void acceptOnIndex(Consumer<? super Byte2ReferenceMap.Entry<V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapSpliterator
        public final Byte2ReferenceOpenHashMap<V>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Byte2ReferenceMap.Entry<V>> implements Byte2ReferenceMap.FastEntrySet<V> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Byte2ReferenceMap.Entry<V>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap.FastEntrySet
        public ObjectIterator<Byte2ReferenceMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2ReferenceMap.Entry<V>> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            byte curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            Object value = e.getValue();
            if (k == 0) {
                return Byte2ReferenceOpenHashMap.this.containsNullKey && Byte2ReferenceOpenHashMap.this.value[Byte2ReferenceOpenHashMap.this.f1192n] == value;
            }
            byte[] key = Byte2ReferenceOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Byte2ReferenceOpenHashMap.this.mask;
            int pos = mix;
            byte curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Byte2ReferenceOpenHashMap.this.value[pos] == value;
            }
            do {
                int i = (pos + 1) & Byte2ReferenceOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Byte2ReferenceOpenHashMap.this.value[pos] == value;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            Object value = e.getValue();
            if (k != 0) {
                byte[] key = Byte2ReferenceOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Byte2ReferenceOpenHashMap.this.mask;
                int pos = mix;
                byte curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Byte2ReferenceOpenHashMap.this.mask;
                        pos = i;
                        byte curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Byte2ReferenceOpenHashMap.this.value[pos] == value) {
                            Byte2ReferenceOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Byte2ReferenceOpenHashMap.this.value[pos] != value) {
                    return false;
                } else {
                    Byte2ReferenceOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Byte2ReferenceOpenHashMap.this.containsNullKey || Byte2ReferenceOpenHashMap.this.value[Byte2ReferenceOpenHashMap.this.f1192n] != value) {
                return false;
            } else {
                Byte2ReferenceOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2ReferenceOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2ReferenceOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Byte2ReferenceMap.Entry<V>> consumer) {
            if (Byte2ReferenceOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractByte2ReferenceMap.BasicEntry(Byte2ReferenceOpenHashMap.this.key[Byte2ReferenceOpenHashMap.this.f1192n], Byte2ReferenceOpenHashMap.this.value[Byte2ReferenceOpenHashMap.this.f1192n]));
            }
            int pos = Byte2ReferenceOpenHashMap.this.f1192n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Byte2ReferenceOpenHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractByte2ReferenceMap.BasicEntry(Byte2ReferenceOpenHashMap.this.key[pos], Byte2ReferenceOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap.FastEntrySet
        public void fastForEach(Consumer<? super Byte2ReferenceMap.Entry<V>> consumer) {
            AbstractByte2ReferenceMap.BasicEntry<V> entry = new AbstractByte2ReferenceMap.BasicEntry<>();
            if (Byte2ReferenceOpenHashMap.this.containsNullKey) {
                entry.key = Byte2ReferenceOpenHashMap.this.key[Byte2ReferenceOpenHashMap.this.f1192n];
                entry.value = Byte2ReferenceOpenHashMap.this.value[Byte2ReferenceOpenHashMap.this.f1192n];
                consumer.accept(entry);
            }
            int pos = Byte2ReferenceOpenHashMap.this.f1192n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Byte2ReferenceOpenHashMap.this.key[pos] != 0) {
                    entry.key = Byte2ReferenceOpenHashMap.this.key[pos];
                    entry.value = Byte2ReferenceOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceSortedMap
    public Byte2ReferenceMap.FastEntrySet<V> byte2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Byte2ReferenceOpenHashMap<V>.MapIterator implements ByteIterator {
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ByteConsumer byteConsumer) {
            forEachRemaining((KeyIterator) byteConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Byte2ReferenceOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Byte2ReferenceOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Byte2ReferenceOpenHashMap<V>.MapSpliterator implements ByteSpliterator {
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
            action.accept(Byte2ReferenceOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapSpliterator
        public final Byte2ReferenceOpenHashMap<V>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$KeySet.class */
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
            if (Byte2ReferenceOpenHashMap.this.containsNullKey) {
                consumer.accept(Byte2ReferenceOpenHashMap.this.key[Byte2ReferenceOpenHashMap.this.f1192n]);
            }
            int pos = Byte2ReferenceOpenHashMap.this.f1192n;
            while (true) {
                pos--;
                if (pos != 0) {
                    byte k = Byte2ReferenceOpenHashMap.this.key[pos];
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
            return Byte2ReferenceOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return Byte2ReferenceOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            int oldSize = Byte2ReferenceOpenHashMap.this.size;
            Byte2ReferenceOpenHashMap.this.remove(k);
            return Byte2ReferenceOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2ReferenceOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
    public Set<Byte> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Byte2ReferenceOpenHashMap<V>.MapIterator implements ObjectIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapIterator
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
            action.accept((Object) Byte2ReferenceOpenHashMap.this.value[index]);
        }

        @Override // java.util.Iterator
        public V next() {
            return Byte2ReferenceOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ReferenceOpenHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Byte2ReferenceOpenHashMap<V>.MapSpliterator implements ObjectSpliterator<V> {
        private static final int POST_SPLIT_CHARACTERISTICS = 0;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapSpliterator
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
            action.accept((Object) Byte2ReferenceOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.MapSpliterator
        public final Byte2ReferenceOpenHashMap<V>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ReferenceOpenHashMap.1
                @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return new ValueSpliterator();
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    if (Byte2ReferenceOpenHashMap.this.containsNullKey) {
                        consumer.accept((Object) Byte2ReferenceOpenHashMap.this.value[Byte2ReferenceOpenHashMap.this.f1192n]);
                    }
                    int pos = Byte2ReferenceOpenHashMap.this.f1192n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Byte2ReferenceOpenHashMap.this.key[pos] != 0) {
                            consumer.accept((Object) Byte2ReferenceOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Byte2ReferenceOpenHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Byte2ReferenceOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Byte2ReferenceOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1193f)));
        if (l >= this.f1192n || this.size > HashCommon.maxFill(l, this.f1193f)) {
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
        V[] value = this.value;
        int mask = newN - 1;
        byte[] newKey = new byte[newN + 1];
        V[] newValue = (V[]) new Object[newN + 1];
        int i2 = this.f1192n;
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
                newValue[newN] = value[this.f1192n];
                this.f1192n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1192n, this.f1193f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Byte2ReferenceOpenHashMap<V> clone() {
        try {
            Byte2ReferenceOpenHashMap<V> c = (Byte2ReferenceOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (byte[]) this.key.clone();
            c.value = (V[]) ((Object[]) this.value.clone());
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x004f */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2 */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ReferenceMap, java.lang.Object, java.util.Map
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
            boolean z = this.key[i];
            if (this != this.value[i]) {
                int identityHashCode = this.value[i] == null ? 0 : System.identityHashCode(this.value[i]);
                int t = z ? 1 : 0;
                int t2 = z ? 1 : 0;
                z = t ^ identityHashCode;
            }
            int t3 = z == true ? 1 : 0;
            int t4 = z == true ? 1 : 0;
            int t5 = z == true ? 1 : 0;
            h += t3;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1192n] == null ? 0 : System.identityHashCode(this.value[this.f1192n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        byte[] key = this.key;
        V[] value = this.value;
        Byte2ReferenceOpenHashMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeByte(key[e]);
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
        this.f1192n = HashCommon.arraySize(this.size, this.f1193f);
        this.maxFill = HashCommon.maxFill(this.f1192n, this.f1193f);
        this.mask = this.f1192n - 1;
        byte[] key = new byte[this.f1192n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f1192n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                byte k = s.readByte();
                Object readObject = s.readObject();
                if (k == 0) {
                    pos = this.f1192n;
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
                value[pos] = readObject;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
