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
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap;
import p014it.unimi.dsi.fastutil.longs.Long2LongMap;
import p014it.unimi.dsi.fastutil.longs.LongHash;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap.class */
public class Long2LongOpenCustomHashMap extends AbstractLong2LongMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient long[] key;
    protected transient long[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected LongHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f2302n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2303f;
    protected transient Long2LongMap.FastEntrySet entries;
    protected transient LongSet keys;
    protected transient LongCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.computeIfPresent(long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long computeIfPresent(long r1, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> r3) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.computeIfPresent(long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.computeIfPresent(long, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.compute(long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long compute(long r1, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> r3) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.compute(long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.compute(long, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.merge(long, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long merge(long r1, long r3, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> r5) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.merge(long, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.merge(long, long, java.util.function.BiFunction):long");
    }

    public Long2LongOpenCustomHashMap(int expected, float f, LongHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2303f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2302n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2302n - 1;
            this.maxFill = HashCommon.maxFill(this.f2302n, f);
            this.key = new long[this.f2302n + 1];
            this.value = new long[this.f2302n + 1];
        }
    }

    public Long2LongOpenCustomHashMap(int expected, LongHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public Long2LongOpenCustomHashMap(LongHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public Long2LongOpenCustomHashMap(Map<? extends Long, ? extends Long> m, float f, LongHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Long2LongOpenCustomHashMap(Map<? extends Long, ? extends Long> m, LongHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Long2LongOpenCustomHashMap(Long2LongMap m, float f, LongHash.Strategy strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Long2LongOpenCustomHashMap(Long2LongMap m, LongHash.Strategy strategy) {
        this(m, 0.75f, strategy);
    }

    public Long2LongOpenCustomHashMap(long[] k, long[] v, float f, LongHash.Strategy strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Long2LongOpenCustomHashMap(long[] k, long[] v, LongHash.Strategy strategy) {
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
        int needed = HashCommon.arraySize(capacity, this.f2303f);
        if (needed > this.f2302n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2303f)))));
        if (needed > this.f2302n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public long removeEntry(int pos) {
        long oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2302n > this.minN && this.size < this.maxFill / 4 && this.f2302n > 16) {
            rehash(this.f2302n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public long removeNullEntry() {
        this.containsNullKey = false;
        long oldValue = this.value[this.f2302n];
        this.size--;
        if (this.f2302n > this.minN && this.size < this.maxFill / 4 && this.f2302n > 16) {
            rehash(this.f2302n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, java.util.Map
    public void putAll(Map<? extends Long, ? extends Long> m) {
        if (((double) this.f2303f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.f2302n : -(this.f2302n + 1);
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

    private void insert(int pos, long k, long v) {
        if (pos == this.f2302n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2303f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    public long put(long k, long v) {
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

    public long addTo(long k, long incr) {
        int pos;
        long curr;
        if (!this.strategy.equals(k, 0)) {
            long[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            long curr2 = key[mix];
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
            return addToValue(this.f2302n, incr);
        } else {
            pos = this.f2302n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2303f));
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    public long remove(long k) {
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    public long get(long k) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2302n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongFunction, p014it.unimi.dsi.fastutil.longs.Long2LongMap
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public boolean containsValue(long v) {
        long[] value = this.value;
        long[] key = this.key;
        if (this.containsNullKey && value[this.f2302n] == v) {
            return true;
        }
        int i = this.f2302n;
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    public long getOrDefault(long k, long defaultValue) {
        int i;
        if (this.strategy.equals(k, 0)) {
            return this.containsNullKey ? this.value[this.f2302n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long putIfAbsent(long k, long v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public boolean remove(long k, long v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2302n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public boolean replace(long k, long oldValue, long v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long replace(long k, long v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        long oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long computeIfAbsent(long k, LongUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        long newValue = mappingFunction.applyAsLong(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long computeIfAbsent(long key, Long2LongFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        long newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public long computeIfAbsentNullable(long k, LongFunction<? extends Long> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Long newValue = (Long) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        long v = newValue.longValue();
        insert((-pos) - 1, k, v);
        return v;
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Long2LongMap.Entry, Map.Entry<Long, Long>, LongLongPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        public long getLongKey() {
            return Long2LongOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongLongPair
        public long leftLong() {
            return Long2LongOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        public long getLongValue() {
            return Long2LongOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongLongPair
        public long rightLong() {
            return Long2LongOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        public long setValue(long v) {
            long oldValue = Long2LongOpenCustomHashMap.this.value[this.index];
            Long2LongOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongLongPair
        public LongLongPair right(long v) {
            Long2LongOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getKey() {
            return Long.valueOf(Long2LongOpenCustomHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getValue() {
            return Long.valueOf(Long2LongOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        @Deprecated
        public Long setValue(Long v) {
            return Long.valueOf(setValue(v.longValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, Long> e = (Map.Entry) o;
            return Long2LongOpenCustomHashMap.this.strategy.equals(Long2LongOpenCustomHashMap.this.key[this.index], e.getKey().longValue()) && Long2LongOpenCustomHashMap.this.value[this.index] == e.getValue().longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Long2LongOpenCustomHashMap.this.strategy.hashCode(Long2LongOpenCustomHashMap.this.key[this.index]) ^ HashCommon.long2int(Long2LongOpenCustomHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Long2LongOpenCustomHashMap.this.key[this.index] + "=>" + Long2LongOpenCustomHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2304c;
        boolean mustReturnNullKey;
        LongArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Long2LongOpenCustomHashMap.this.f2302n;
            this.last = -1;
            this.f2304c = Long2LongOpenCustomHashMap.this.size;
            this.mustReturnNullKey = Long2LongOpenCustomHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2304c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2304c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Long2LongOpenCustomHashMap.this.f2302n;
                this.last = i;
                return i;
            }
            long[] key = Long2LongOpenCustomHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    long k = this.wrapped.getLong((-this.pos) - 1);
                    int mix = HashCommon.mix(Long2LongOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Long2LongOpenCustomHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Long2LongOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Long2LongOpenCustomHashMap.this.mask;
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
                int i = Long2LongOpenCustomHashMap.this.f2302n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2304c--;
            }
            long[] key = Long2LongOpenCustomHashMap.this.key;
            while (this.f2304c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    long k = this.wrapped.getLong((-this.pos) - 1);
                    int mix = HashCommon.mix(Long2LongOpenCustomHashMap.this.strategy.hashCode(k));
                    int i3 = Long2LongOpenCustomHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Long2LongOpenCustomHashMap.this.strategy.equals(k, key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Long2LongOpenCustomHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2304c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2304c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            long curr;
            long[] key = Long2LongOpenCustomHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Long2LongOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(Long2LongOpenCustomHashMap.this.strategy.hashCode(curr)) & Long2LongOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Long2LongOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Long2LongOpenCustomHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new LongArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Long2LongOpenCustomHashMap.this.value[pos] = Long2LongOpenCustomHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Long2LongOpenCustomHashMap.this.f2302n) {
                Long2LongOpenCustomHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Long2LongOpenCustomHashMap.this.remove(this.wrapped.getLong((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Long2LongOpenCustomHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Long2LongMap.Entry>> implements ObjectIterator<Long2LongMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2LongMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Long2LongMap.Entry>> implements ObjectIterator<Long2LongMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2LongMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f2305c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Long2LongOpenCustomHashMap.this.f2302n;
            this.f2305c = 0;
            this.mustReturnNull = Long2LongOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Long2LongOpenCustomHashMap.this.f2302n;
            this.f2305c = 0;
            this.mustReturnNull = Long2LongOpenCustomHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2305c++;
                acceptOnIndex(action, Long2LongOpenCustomHashMap.this.f2302n);
                return true;
            }
            long[] key = Long2LongOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2305c++;
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
                this.f2305c++;
                acceptOnIndex(action, Long2LongOpenCustomHashMap.this.f2302n);
            }
            long[] key = Long2LongOpenCustomHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2305c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Long2LongOpenCustomHashMap.this.size - this.f2305c);
            }
            return Math.min((long) (Long2LongOpenCustomHashMap.this.size - this.f2305c), ((long) ((((double) Long2LongOpenCustomHashMap.this.realSize()) / ((double) Long2LongOpenCustomHashMap.this.f2302n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap r0 = p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.this
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Long2LongMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Long2LongMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Long2LongMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Long2LongMap.Entry> implements Long2LongMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Long2LongMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.FastEntrySet
        public ObjectIterator<Long2LongMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2LongMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            int i;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            long v = ((Long) e.getValue()).longValue();
            if (Long2LongOpenCustomHashMap.this.strategy.equals(k, 0)) {
                return Long2LongOpenCustomHashMap.this.containsNullKey && Long2LongOpenCustomHashMap.this.value[Long2LongOpenCustomHashMap.this.f2302n] == v;
            }
            long[] key = Long2LongOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Long2LongOpenCustomHashMap.this.strategy.hashCode(k)) & Long2LongOpenCustomHashMap.this.mask;
            int pos = mix;
            if (key[mix] == 0) {
                return false;
            }
            if (Long2LongOpenCustomHashMap.this.strategy.equals(k, mix)) {
                return Long2LongOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                i = (pos + 1) & Long2LongOpenCustomHashMap.this.mask;
                pos = i;
                if (key[i] == 0) {
                    return false;
                }
            } while (!Long2LongOpenCustomHashMap.this.strategy.equals(k, i));
            return Long2LongOpenCustomHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            long k = ((Long) e.getKey()).longValue();
            long v = ((Long) e.getValue()).longValue();
            if (!Long2LongOpenCustomHashMap.this.strategy.equals(k, 0)) {
                long[] key = Long2LongOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Long2LongOpenCustomHashMap.this.strategy.hashCode(k)) & Long2LongOpenCustomHashMap.this.mask;
                int pos = mix;
                if (key[mix] == 0) {
                    return false;
                }
                if (!Long2LongOpenCustomHashMap.this.strategy.equals(mix, k)) {
                    while (true) {
                        int i = (pos + 1) & Long2LongOpenCustomHashMap.this.mask;
                        pos = i;
                        if (key[i] == 0) {
                            return false;
                        }
                        if (Long2LongOpenCustomHashMap.this.strategy.equals(i, k) && Long2LongOpenCustomHashMap.this.value[pos] == v) {
                            Long2LongOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Long2LongOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Long2LongOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Long2LongOpenCustomHashMap.this.containsNullKey || Long2LongOpenCustomHashMap.this.value[Long2LongOpenCustomHashMap.this.f2302n] != v) {
                return false;
            } else {
                Long2LongOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Long2LongOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2LongOpenCustomHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Long2LongMap.Entry> consumer) {
            if (Long2LongOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(new AbstractLong2LongMap.BasicEntry(Long2LongOpenCustomHashMap.this.key[Long2LongOpenCustomHashMap.this.f2302n], Long2LongOpenCustomHashMap.this.value[Long2LongOpenCustomHashMap.this.f2302n]));
            }
            int pos = Long2LongOpenCustomHashMap.this.f2302n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Long2LongOpenCustomHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractLong2LongMap.BasicEntry(Long2LongOpenCustomHashMap.this.key[pos], Long2LongOpenCustomHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Long2LongMap.Entry> consumer) {
            AbstractLong2LongMap.BasicEntry entry = new AbstractLong2LongMap.BasicEntry();
            if (Long2LongOpenCustomHashMap.this.containsNullKey) {
                entry.key = Long2LongOpenCustomHashMap.this.key[Long2LongOpenCustomHashMap.this.f2302n];
                entry.value = Long2LongOpenCustomHashMap.this.value[Long2LongOpenCustomHashMap.this.f2302n];
                consumer.accept(entry);
            }
            int pos = Long2LongOpenCustomHashMap.this.f2302n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Long2LongOpenCustomHashMap.this.key[pos] != 0) {
                    entry.key = Long2LongOpenCustomHashMap.this.key[pos];
                    entry.value = Long2LongOpenCustomHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    public Long2LongMap.FastEntrySet long2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$KeyIterator.class */
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
            action.accept(Long2LongOpenCustomHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Long2LongOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$KeySpliterator.class */
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
            action.accept(Long2LongOpenCustomHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$KeySet.class */
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
            if (Long2LongOpenCustomHashMap.this.containsNullKey) {
                consumer.accept(Long2LongOpenCustomHashMap.this.key[Long2LongOpenCustomHashMap.this.f2302n]);
            }
            int pos = Long2LongOpenCustomHashMap.this.f2302n;
            while (true) {
                pos--;
                if (pos != 0) {
                    long k = Long2LongOpenCustomHashMap.this.key[pos];
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
            return Long2LongOpenCustomHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return Long2LongOpenCustomHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            int oldSize = Long2LongOpenCustomHashMap.this.size;
            Long2LongOpenCustomHashMap.this.remove(k);
            return Long2LongOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Long2LongOpenCustomHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public Set<Long> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<LongConsumer> implements LongIterator {
        @Override // java.util.PrimitiveIterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((ValueIterator) longConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Long2LongOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Long2LongOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongOpenCustomHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends MapSpliterator<LongConsumer, ValueSpliterator> implements LongSpliterator {
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
            action.accept(Long2LongOpenCustomHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public Collection<Long> values() {
        if (this.values == null) {
            this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2LongOpenCustomHashMap.1
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
                    if (Long2LongOpenCustomHashMap.this.containsNullKey) {
                        consumer.accept(Long2LongOpenCustomHashMap.this.value[Long2LongOpenCustomHashMap.this.f2302n]);
                    }
                    int pos = Long2LongOpenCustomHashMap.this.f2302n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Long2LongOpenCustomHashMap.this.key[pos] != 0) {
                            consumer.accept(Long2LongOpenCustomHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2LongOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                public boolean contains(long v) {
                    return Long2LongOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2LongOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2303f)));
        if (l >= this.f2302n || this.size > HashCommon.maxFill(l, this.f2303f)) {
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
        long[] value = this.value;
        int mask = newN - 1;
        long[] newKey = new long[newN + 1];
        long[] newValue = new long[newN + 1];
        int i2 = this.f2302n;
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
                newValue[newN] = value[this.f2302n];
                this.f2302n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2302n, this.f2303f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Long2LongOpenCustomHashMap clone() {
        try {
            Long2LongOpenCustomHashMap c = (Long2LongOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (long[]) this.key.clone();
            c.value = (long[]) this.value.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, java.lang.Object, java.util.Map
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
            h += this.strategy.hashCode(this.key[i]) ^ HashCommon.long2int(this.value[i]);
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.long2int(this.value[this.f2302n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        long[] key = this.key;
        long[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeLong(key[e]);
                s.writeLong(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2302n = HashCommon.arraySize(this.size, this.f2303f);
        this.maxFill = HashCommon.maxFill(this.f2302n, this.f2303f);
        this.mask = this.f2302n - 1;
        long[] key = new long[this.f2302n + 1];
        this.key = key;
        long[] value = new long[this.f2302n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                long k = s.readLong();
                long v = s.readLong();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f2302n;
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
