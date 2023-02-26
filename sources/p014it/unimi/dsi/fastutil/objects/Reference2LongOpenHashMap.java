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
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ToLongFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap;
import p014it.unimi.dsi.fastutil.objects.Reference2LongMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap.class */
public class Reference2LongOpenHashMap<K> extends AbstractReference2LongMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient long[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f2761n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2762f;
    protected transient Reference2LongMap.FastEntrySet<K> entries;
    protected transient ReferenceSet<K> keys;
    protected transient LongCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.computeLongIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public long computeLongIfPresent(K r1, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.computeLongIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.computeLongIfPresent(java.lang.Object, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.computeLong(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public long computeLong(K r1, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.computeLong(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.computeLong(java.lang.Object, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.merge(K, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public long merge(K r1, long r2, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> r4) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.merge(K, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.merge(java.lang.Object, long, java.util.function.BiFunction):long");
    }

    public Reference2LongOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2762f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2761n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2761n - 1;
            this.maxFill = HashCommon.maxFill(this.f2761n, f);
            this.key = (K[]) new Object[this.f2761n + 1];
            this.value = new long[this.f2761n + 1];
        }
    }

    public Reference2LongOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Reference2LongOpenHashMap() {
        this(16, 0.75f);
    }

    public Reference2LongOpenHashMap(Map<? extends K, ? extends Long> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2LongOpenHashMap(Map<? extends K, ? extends Long> m) {
        this(m, 0.75f);
    }

    public Reference2LongOpenHashMap(Reference2LongMap<K> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2LongOpenHashMap(Reference2LongMap<K> m) {
        this((Reference2LongMap) m, 0.75f);
    }

    public Reference2LongOpenHashMap(K[] k, long[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Reference2LongOpenHashMap<K>) k[i], v[i]);
        }
    }

    public Reference2LongOpenHashMap(K[] k, long[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2762f);
        if (needed > this.f2761n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2762f)))));
        if (needed > this.f2761n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public long removeEntry(int pos) {
        long oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2761n > this.minN && this.size < this.maxFill / 4 && this.f2761n > 16) {
            rehash(this.f2761n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public long removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2761n] = null;
        long oldValue = this.value[this.f2761n];
        this.size--;
        if (this.f2761n > this.minN && this.size < this.maxFill / 4 && this.f2761n > 16) {
            rehash(this.f2761n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Long> m) {
        if (((double) this.f2762f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.f2761n : -(this.f2761n + 1);
        }
        K[] key = this.key;
        int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return -(pos + 1);
        }
        if (k == curr2) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return -(pos + 1);
            }
        } while (k != curr);
        return pos;
    }

    private void insert(int pos, K k, long v) {
        if (pos == this.f2761n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2762f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    public long put(K k, long v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        long oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private long addToValue(int pos, long incr) {
        long oldValue = this.value[pos];
        this.value[pos] = oldValue + incr;
        return oldValue;
    }

    public long addTo(K k, long incr) {
        int pos;
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (curr2 == k) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (curr != k);
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f2761n, incr);
        } else {
            pos = this.f2761n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2762f));
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
                int slot = HashCommon.mix(System.identityHashCode(curr)) & this.mask;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    public long removeLong(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (k == curr2) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (k != curr);
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    public long getLong(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2761n] : this.defRetValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return this.defRetValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return this.defRetValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return false;
        }
        if (k == curr2) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return false;
            }
        } while (k != curr);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public boolean containsValue(long v) {
        long[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2761n] == v) {
            return true;
        }
        int i = this.f2761n;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    public long getOrDefault(Object k, long defaultValue) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2761n] : defaultValue;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return defaultValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return defaultValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public long putIfAbsent(K k, long v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public boolean remove(Object k, long v) {
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            int pos = mix;
            K curr = key[mix];
            if (curr == null) {
                return false;
            }
            if (k == curr && v == this.value[pos]) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                K curr2 = key[i];
                if (curr2 == null) {
                    return false;
                }
                if (k == curr2 && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f2761n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public boolean replace(K k, long oldValue, long v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public long replace(K k, long v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        long oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public long computeIfAbsent(K k, ToLongFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        long newValue = mappingFunction.applyAsLong(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public long computeIfAbsent(K key, Reference2LongFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        long newValue = mappingFunction.getLong(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$MapEntry.class */
    public final class MapEntry implements Reference2LongMap.Entry<K>, Map.Entry<K, Long>, ReferenceLongPair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Reference2LongOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Reference2LongOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.Entry
        public long getLongValue() {
            return Reference2LongOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceLongPair
        public long rightLong() {
            return Reference2LongOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.Entry
        public long setValue(long v) {
            long oldValue = Reference2LongOpenHashMap.this.value[this.index];
            Reference2LongOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceLongPair
        public ReferenceLongPair<K> right(long v) {
            Reference2LongOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getValue() {
            return Long.valueOf(Reference2LongOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.Entry
        @Deprecated
        public Long setValue(Long v) {
            return Long.valueOf(setValue(v.longValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Long> e = (Map.Entry) o;
            return Reference2LongOpenHashMap.this.key[this.index] == e.getKey() && Reference2LongOpenHashMap.this.value[this.index] == e.getValue().longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(Reference2LongOpenHashMap.this.key[this.index]) ^ HashCommon.long2int(Reference2LongOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Reference2LongOpenHashMap.this.key[this.index] + "=>" + Reference2LongOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2763c;
        boolean mustReturnNullKey;
        ReferenceArrayList<K> wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Reference2LongOpenHashMap.this.f2761n;
            this.last = -1;
            this.f2763c = Reference2LongOpenHashMap.this.size;
            this.mustReturnNullKey = Reference2LongOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2763c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2763c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Reference2LongOpenHashMap.this.f2761n;
                this.last = i;
                return i;
            }
            K[] key = Reference2LongOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(System.identityHashCode(k));
                    int i3 = Reference2LongOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k == key[p]) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Reference2LongOpenHashMap.this.mask;
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
                int i = Reference2LongOpenHashMap.this.f2761n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2763c--;
            }
            K[] key = Reference2LongOpenHashMap.this.key;
            while (this.f2763c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    K k = this.wrapped.get((-this.pos) - 1);
                    int mix = HashCommon.mix(System.identityHashCode(k));
                    int i3 = Reference2LongOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k == key[p]) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Reference2LongOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2763c--;
                } else if (key[this.pos] != null) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2763c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            K curr;
            K[] key = Reference2LongOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Reference2LongOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(System.identityHashCode(curr)) & Reference2LongOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Reference2LongOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Reference2LongOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ReferenceArrayList<>(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Reference2LongOpenHashMap.this.value[pos] = Reference2LongOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Reference2LongOpenHashMap.this.f2761n) {
                Reference2LongOpenHashMap.this.containsNullKey = false;
                Reference2LongOpenHashMap.this.key[Reference2LongOpenHashMap.this.f2761n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Reference2LongOpenHashMap.this.removeLong(this.wrapped.set((-this.pos) - 1, null));
                this.last = -1;
                return;
            }
            Reference2LongOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Reference2LongOpenHashMap<K>.MapIterator implements ObjectIterator<Reference2LongMap.Entry<K>> {
        private Reference2LongOpenHashMap<K>.MapEntry entry;

        private EntryIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Reference2LongOpenHashMap<K>.MapEntry next() {
            Reference2LongOpenHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        final void acceptOnIndex(Consumer<? super Reference2LongMap.Entry<K>> action, int index) {
            Reference2LongOpenHashMap<K>.MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends Reference2LongOpenHashMap<K>.MapIterator implements ObjectIterator<Reference2LongMap.Entry<K>> {
        private final Reference2LongOpenHashMap<K>.MapEntry entry;

        private FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        @Override // java.util.Iterator
        public Reference2LongOpenHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        final void acceptOnIndex(Consumer<? super Reference2LongMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends Reference2LongOpenHashMap<K>.MapSpliterator> {
        int pos;
        int max;

        /* renamed from: c */
        int f2764c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Reference2LongOpenHashMap.this.f2761n;
            this.f2764c = 0;
            this.mustReturnNull = Reference2LongOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Reference2LongOpenHashMap.this.f2761n;
            this.f2764c = 0;
            this.mustReturnNull = Reference2LongOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2764c++;
                acceptOnIndex(action, Reference2LongOpenHashMap.this.f2761n);
                return true;
            }
            K[] key = Reference2LongOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    this.f2764c++;
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
                this.f2764c++;
                acceptOnIndex(action, Reference2LongOpenHashMap.this.f2761n);
            }
            K[] key = Reference2LongOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    acceptOnIndex(action, this.pos);
                    this.f2764c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Reference2LongOpenHashMap.this.size - this.f2764c);
            }
            return Math.min((long) (Reference2LongOpenHashMap.this.size - this.f2764c), ((long) ((((double) Reference2LongOpenHashMap.this.realSize()) / ((double) Reference2LongOpenHashMap.this.f2761n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap r0 = p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.this
                K[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0076
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0076
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
                if (r0 == r1) goto L_0x0048
                r0 = r9
                r1 = 1
                long r0 = r0 + r1
                r9 = r0
                r0 = r7
                r1 = 1
                long r0 = r0 - r1
                r7 = r0
                goto L_0x0048
            L_0x0076:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends Reference2LongOpenHashMap<K>.MapSpliterator implements ObjectSpliterator<Reference2LongMap.Entry<K>> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapSpliterator
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

        final void acceptOnIndex(Consumer<? super Reference2LongMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapSpliterator
        public final Reference2LongOpenHashMap<K>.EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Reference2LongMap.Entry<K>> implements Reference2LongMap.FastEntrySet<K> {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Reference2LongMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.FastEntrySet
        public ObjectIterator<Reference2LongMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2LongMap.Entry<K>> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            K curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            Object key = e.getKey();
            long v = ((Long) e.getValue()).longValue();
            if (key == null) {
                return Reference2LongOpenHashMap.this.containsNullKey && Reference2LongOpenHashMap.this.value[Reference2LongOpenHashMap.this.f2761n] == v;
            }
            K[] key2 = Reference2LongOpenHashMap.this.key;
            int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2LongOpenHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (key == curr2) {
                return Reference2LongOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Reference2LongOpenHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (key != curr);
            return Reference2LongOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            Object key = e.getKey();
            long v = ((Long) e.getValue()).longValue();
            if (key != null) {
                K[] key2 = Reference2LongOpenHashMap.this.key;
                int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2LongOpenHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (curr != key) {
                    while (true) {
                        int i = (pos + 1) & Reference2LongOpenHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (curr2 == key && Reference2LongOpenHashMap.this.value[pos] == v) {
                            Reference2LongOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Reference2LongOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Reference2LongOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Reference2LongOpenHashMap.this.containsNullKey || Reference2LongOpenHashMap.this.value[Reference2LongOpenHashMap.this.f2761n] != v) {
                return false;
            } else {
                Reference2LongOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2LongOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2LongOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2LongMap.Entry<K>> consumer) {
            if (Reference2LongOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractReference2LongMap.BasicEntry(Reference2LongOpenHashMap.this.key[Reference2LongOpenHashMap.this.f2761n], Reference2LongOpenHashMap.this.value[Reference2LongOpenHashMap.this.f2761n]));
            }
            int pos = Reference2LongOpenHashMap.this.f2761n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Reference2LongOpenHashMap.this.key[pos] != null) {
                    consumer.accept(new AbstractReference2LongMap.BasicEntry(Reference2LongOpenHashMap.this.key[pos], Reference2LongOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2LongMap.Entry<K>> consumer) {
            AbstractReference2LongMap.BasicEntry<K> entry = new AbstractReference2LongMap.BasicEntry<>();
            if (Reference2LongOpenHashMap.this.containsNullKey) {
                entry.key = Reference2LongOpenHashMap.this.key[Reference2LongOpenHashMap.this.f2761n];
                entry.value = Reference2LongOpenHashMap.this.value[Reference2LongOpenHashMap.this.f2761n];
                consumer.accept(entry);
            }
            int pos = Reference2LongOpenHashMap.this.f2761n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Reference2LongOpenHashMap.this.key[pos] != null) {
                    entry.key = Reference2LongOpenHashMap.this.key[pos];
                    entry.value = Reference2LongOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public Reference2LongMap.FastEntrySet<K> reference2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Reference2LongOpenHashMap<K>.MapIterator implements ObjectIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapIterator
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
            action.accept((Object) Reference2LongOpenHashMap.this.key[index]);
        }

        @Override // java.util.Iterator
        public K next() {
            return Reference2LongOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends Reference2LongOpenHashMap<K>.MapSpliterator implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapSpliterator
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
            action.accept((Object) Reference2LongOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapSpliterator
        public final Reference2LongOpenHashMap<K>.KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractReferenceSet<K> {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return new KeySpliterator();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            if (Reference2LongOpenHashMap.this.containsNullKey) {
                consumer.accept((Object) Reference2LongOpenHashMap.this.key[Reference2LongOpenHashMap.this.f2761n]);
            }
            int pos = Reference2LongOpenHashMap.this.f2761n;
            while (true) {
                pos--;
                if (pos != 0) {
                    Object obj = (Object) Reference2LongOpenHashMap.this.key[pos];
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
            return Reference2LongOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2LongOpenHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Reference2LongOpenHashMap.this.size;
            Reference2LongOpenHashMap.this.removeLong(k);
            return Reference2LongOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2LongOpenHashMap.this.clear();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
    public ReferenceSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Reference2LongOpenHashMap<K>.MapIterator implements LongIterator {
        @Override // java.util.PrimitiveIterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((ValueIterator) longConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Reference2LongOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Reference2LongOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongOpenHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends Reference2LongOpenHashMap<K>.MapSpliterator implements LongSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 256;

        @Override // java.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((ValueSpliterator) longConsumer);
        }

        @Override // java.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
            return tryAdvance((ValueSpliterator) longConsumer);
        }

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
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Reference2LongOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.MapSpliterator
        public final Reference2LongOpenHashMap<K>.ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
    public Collection<Long> values() {
        if (this.values == null) {
            this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.objects.Reference2LongOpenHashMap.1
                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongSpliterator spliterator() {
                    return new ValueSpliterator();
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
                public void forEach(LongConsumer consumer) {
                    if (Reference2LongOpenHashMap.this.containsNullKey) {
                        consumer.accept(Reference2LongOpenHashMap.this.value[Reference2LongOpenHashMap.this.f2761n]);
                    }
                    int pos = Reference2LongOpenHashMap.this.f2761n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Reference2LongOpenHashMap.this.key[pos] != null) {
                            consumer.accept(Reference2LongOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Reference2LongOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                public boolean contains(long v) {
                    return Reference2LongOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Reference2LongOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2762f)));
        if (l >= this.f2761n || this.size > HashCommon.maxFill(l, this.f2762f)) {
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
        long[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        long[] newValue = new long[newN + 1];
        int i2 = this.f2761n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == null);
                int mix = HashCommon.mix(System.identityHashCode(key[i2])) & mask;
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
                newValue[newN] = value[this.f2761n];
                this.f2761n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2761n, this.f2762f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Reference2LongOpenHashMap<K> clone() {
        try {
            Reference2LongOpenHashMap<K> c = (Reference2LongOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (long[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, java.lang.Object, java.util.Map
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
                t = System.identityHashCode(this.key[i]);
            }
            t ^= HashCommon.long2int(this.value[i]);
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.long2int(this.value[this.f2761n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        long[] value = this.value;
        Reference2LongOpenHashMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeObject(key[e]);
                s.writeLong(value[e]);
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
        this.f2761n = HashCommon.arraySize(this.size, this.f2762f);
        this.maxFill = HashCommon.maxFill(this.f2761n, this.f2762f);
        this.mask = this.f2761n - 1;
        K[] key = (K[]) new Object[this.f2761n + 1];
        this.key = key;
        long[] value = new long[this.f2761n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                Object readObject = s.readObject();
                long v = s.readLong();
                if (readObject == null) {
                    pos = this.f2761n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(System.identityHashCode(readObject));
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
