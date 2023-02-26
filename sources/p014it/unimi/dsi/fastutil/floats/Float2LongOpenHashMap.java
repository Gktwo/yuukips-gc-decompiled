package p014it.unimi.dsi.fastutil.floats;

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
import java.util.function.DoubleFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.LongConsumer;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap;
import p014it.unimi.dsi.fastutil.floats.Float2LongMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap.class */
public class Float2LongOpenHashMap extends AbstractFloat2LongMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient float[] key;
    protected transient long[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f1843n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1844f;
    protected transient Float2LongMap.FastEntrySet entries;
    protected transient FloatSet keys;
    protected transient LongCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.computeIfPresent(float, java.util.function.BiFunction<? super java.lang.Float, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long computeIfPresent(float r1, java.util.function.BiFunction<? super java.lang.Float, ? super java.lang.Long, ? extends java.lang.Long> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.computeIfPresent(float, java.util.function.BiFunction<? super java.lang.Float, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.computeIfPresent(float, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.compute(float, java.util.function.BiFunction<? super java.lang.Float, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long compute(float r1, java.util.function.BiFunction<? super java.lang.Float, ? super java.lang.Long, ? extends java.lang.Long> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.compute(float, java.util.function.BiFunction<? super java.lang.Float, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.compute(float, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.merge(float, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long merge(float r1, long r2, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> r4) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.merge(float, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.merge(float, long, java.util.function.BiFunction):long");
    }

    public Float2LongOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1844f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1843n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1843n - 1;
            this.maxFill = HashCommon.maxFill(this.f1843n, f);
            this.key = new float[this.f1843n + 1];
            this.value = new long[this.f1843n + 1];
        }
    }

    public Float2LongOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Float2LongOpenHashMap() {
        this(16, 0.75f);
    }

    public Float2LongOpenHashMap(Map<? extends Float, ? extends Long> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Float2LongOpenHashMap(Map<? extends Float, ? extends Long> m) {
        this(m, 0.75f);
    }

    public Float2LongOpenHashMap(Float2LongMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Float2LongOpenHashMap(Float2LongMap m) {
        this(m, 0.75f);
    }

    public Float2LongOpenHashMap(float[] k, long[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Float2LongOpenHashMap(float[] k, long[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1844f);
        if (needed > this.f1843n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1844f)))));
        if (needed > this.f1843n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public long removeEntry(int pos) {
        long oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f1843n > this.minN && this.size < this.maxFill / 4 && this.f1843n > 16) {
            rehash(this.f1843n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public long removeNullEntry() {
        this.containsNullKey = false;
        long oldValue = this.value[this.f1843n];
        this.size--;
        if (this.f1843n > this.minN && this.size < this.maxFill / 4 && this.f1843n > 16) {
            rehash(this.f1843n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap, java.util.Map
    public void putAll(Map<? extends Float, ? extends Long> m) {
        if (((double) this.f1844f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? this.f1843n : -(this.f1843n + 1);
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return -(pos + 1);
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return -(pos + 1);
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return pos;
    }

    private void insert(int pos, float k, long v) {
        if (pos == this.f1843n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1844f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    public long put(float k, long v) {
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

    public long addTo(float k, long incr) {
        int pos;
        float curr;
        if (Float.floatToIntBits(k) != 0) {
            float[] key = this.key;
            int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
            pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) != 0) {
                if (Float.floatToIntBits(curr2) == Float.floatToIntBits(k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Float.floatToIntBits(curr) != 0) {
                    }
                } while (Float.floatToIntBits(curr) != Float.floatToIntBits(k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f1843n, incr);
        } else {
            pos = this.f1843n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1844f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        float curr;
        float[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (Float.floatToIntBits(curr) == 0) {
                    key[pos] = 0.0f;
                    return;
                }
                int slot = HashCommon.mix(HashCommon.float2int(curr)) & this.mask;
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    public long remove(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return removeEntry(pos);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    public long get(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1843n] : this.defRetValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongFunction, p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public boolean containsKey(float k) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return false;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public boolean containsValue(long v) {
        long[] value = this.value;
        float[] key = this.key;
        if (this.containsNullKey && value[this.f1843n] == v) {
            return true;
        }
        int i = this.f1843n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (Float.floatToIntBits(key[i]) != 0 && value[i] == v) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    public long getOrDefault(float k, long defaultValue) {
        float curr;
        if (Float.floatToIntBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1843n] : defaultValue;
        }
        float[] key = this.key;
        int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
        int pos = mix;
        float curr2 = key[mix];
        if (Float.floatToIntBits(curr2) == 0) {
            return defaultValue;
        }
        if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Float.floatToIntBits(curr) == 0) {
                return defaultValue;
            }
        } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long putIfAbsent(float k, long v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public boolean remove(float k, long v) {
        if (Float.floatToIntBits(k) != 0) {
            float[] key = this.key;
            int mix = HashCommon.mix(HashCommon.float2int(k)) & this.mask;
            int pos = mix;
            float curr = key[mix];
            if (Float.floatToIntBits(curr) == 0) {
                return false;
            }
            if (Float.floatToIntBits(k) == Float.floatToIntBits(curr) && v == this.value[pos]) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                float curr2 = key[i];
                if (Float.floatToIntBits(curr2) == 0) {
                    return false;
                }
                if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2) && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f1843n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public boolean replace(float k, long oldValue, long v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long replace(float k, long v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        long oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long computeIfAbsent(float k, DoubleToLongFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        long newValue = mappingFunction.applyAsLong((double) k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long computeIfAbsent(float key, Float2LongFunction mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
    public long computeIfAbsentNullable(float k, DoubleFunction<? extends Long> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Long newValue = (Long) mappingFunction.apply((double) k);
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
            Arrays.fill(this.key, 0.0f);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$MapEntry.class */
    public final class MapEntry implements Float2LongMap.Entry, Map.Entry<Float, Long>, FloatLongPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.Entry
        public float getFloatKey() {
            return Float2LongOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
        public float leftFloat() {
            return Float2LongOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.Entry
        public long getLongValue() {
            return Float2LongOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
        public long rightLong() {
            return Float2LongOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.Entry
        public long setValue(long v) {
            long oldValue = Float2LongOpenHashMap.this.value[this.index];
            Float2LongOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
        public FloatLongPair right(long v) {
            Float2LongOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Float getKey() {
            return Float.valueOf(Float2LongOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getValue() {
            return Long.valueOf(Float2LongOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.Entry
        @Deprecated
        public Long setValue(Long v) {
            return Long.valueOf(setValue(v.longValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Float, Long> e = (Map.Entry) o;
            return Float.floatToIntBits(Float2LongOpenHashMap.this.key[this.index]) == Float.floatToIntBits(e.getKey().floatValue()) && Float2LongOpenHashMap.this.value[this.index] == e.getValue().longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(Float2LongOpenHashMap.this.key[this.index]) ^ HashCommon.long2int(Float2LongOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Float2LongOpenHashMap.this.key[this.index] + "=>" + Float2LongOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f1845c;
        boolean mustReturnNullKey;
        FloatArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Float2LongOpenHashMap.this.f1843n;
            this.last = -1;
            this.f1845c = Float2LongOpenHashMap.this.size;
            this.mustReturnNullKey = Float2LongOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f1845c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1845c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Float2LongOpenHashMap.this.f1843n;
                this.last = i;
                return i;
            }
            float[] key = Float2LongOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    float k = this.wrapped.getFloat((-this.pos) - 1);
                    int mix = HashCommon.mix(HashCommon.float2int(k));
                    int i3 = Float2LongOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (Float.floatToIntBits(k) == Float.floatToIntBits(key[p])) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Float2LongOpenHashMap.this.mask;
                    }
                }
            } while (Float.floatToIntBits(key[this.pos]) == 0);
            int i4 = this.pos;
            this.last = i4;
            return i4;
        }

        public void forEachRemaining(ConsumerType action) {
            int p;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Float2LongOpenHashMap.this.f1843n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f1845c--;
            }
            float[] key = Float2LongOpenHashMap.this.key;
            while (this.f1845c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    float k = this.wrapped.getFloat((-this.pos) - 1);
                    int mix = HashCommon.mix(HashCommon.float2int(k));
                    int i3 = Float2LongOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (Float.floatToIntBits(k) == Float.floatToIntBits(key[p])) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Float2LongOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f1845c--;
                } else if (Float.floatToIntBits(key[this.pos]) != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f1845c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            float curr;
            float[] key = Float2LongOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Float2LongOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (Float.floatToIntBits(curr) == 0) {
                        key[pos] = 0.0f;
                        return;
                    }
                    int slot = HashCommon.mix(HashCommon.float2int(curr)) & Float2LongOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Float2LongOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Float2LongOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new FloatArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Float2LongOpenHashMap.this.value[pos] = Float2LongOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Float2LongOpenHashMap.this.f1843n) {
                Float2LongOpenHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Float2LongOpenHashMap.this.remove(this.wrapped.getFloat((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Float2LongOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Float2LongMap.Entry>> implements ObjectIterator<Float2LongMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2LongMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Float2LongMap.Entry>> implements ObjectIterator<Float2LongMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2LongMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f1846c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Float2LongOpenHashMap.this.f1843n;
            this.f1846c = 0;
            this.mustReturnNull = Float2LongOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Float2LongOpenHashMap.this.f1843n;
            this.f1846c = 0;
            this.mustReturnNull = Float2LongOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1846c++;
                acceptOnIndex(action, Float2LongOpenHashMap.this.f1843n);
                return true;
            }
            float[] key = Float2LongOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    this.f1846c++;
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
                this.f1846c++;
                acceptOnIndex(action, Float2LongOpenHashMap.this.f1843n);
            }
            float[] key = Float2LongOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (Float.floatToIntBits(key[this.pos]) != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f1846c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Float2LongOpenHashMap.this.size - this.f1846c);
            }
            return Math.min((long) (Float2LongOpenHashMap.this.size - this.f1846c), ((long) ((((double) Float2LongOpenHashMap.this.realSize()) / ((double) Float2LongOpenHashMap.this.f1843n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap r0 = p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.this
                float[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0078
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0078
                r0 = r11
                r1 = r6
                r2 = r1
                int r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                int r3 = r3 + r4
                r2.pos = r3
                r0 = r0[r1]
                int r0 = java.lang.Float.floatToIntBits(r0)
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
            L_0x0078:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Float2LongMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Float2LongMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Float2LongMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Float2LongMap.Entry> implements Float2LongMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Float2LongMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.FastEntrySet
        public ObjectIterator<Float2LongMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2LongMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            float curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            long v = ((Long) e.getValue()).longValue();
            if (Float.floatToIntBits(k) == 0) {
                return Float2LongOpenHashMap.this.containsNullKey && Float2LongOpenHashMap.this.value[Float2LongOpenHashMap.this.f1843n] == v;
            }
            float[] key = Float2LongOpenHashMap.this.key;
            int mix = HashCommon.mix(HashCommon.float2int(k)) & Float2LongOpenHashMap.this.mask;
            int pos = mix;
            float curr2 = key[mix];
            if (Float.floatToIntBits(curr2) == 0) {
                return false;
            }
            if (Float.floatToIntBits(k) == Float.floatToIntBits(curr2)) {
                return Float2LongOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Float2LongOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
            } while (Float.floatToIntBits(k) != Float.floatToIntBits(curr));
            return Float2LongOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            float k = ((Float) e.getKey()).floatValue();
            long v = ((Long) e.getValue()).longValue();
            if (Float.floatToIntBits(k) != 0) {
                float[] key = Float2LongOpenHashMap.this.key;
                int mix = HashCommon.mix(HashCommon.float2int(k)) & Float2LongOpenHashMap.this.mask;
                int pos = mix;
                float curr = key[mix];
                if (Float.floatToIntBits(curr) == 0) {
                    return false;
                }
                if (Float.floatToIntBits(curr) != Float.floatToIntBits(k)) {
                    while (true) {
                        int i = (pos + 1) & Float2LongOpenHashMap.this.mask;
                        pos = i;
                        float curr2 = key[i];
                        if (Float.floatToIntBits(curr2) == 0) {
                            return false;
                        }
                        if (Float.floatToIntBits(curr2) == Float.floatToIntBits(k) && Float2LongOpenHashMap.this.value[pos] == v) {
                            Float2LongOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Float2LongOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Float2LongOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Float2LongOpenHashMap.this.containsNullKey || Float2LongOpenHashMap.this.value[Float2LongOpenHashMap.this.f1843n] != v) {
                return false;
            } else {
                Float2LongOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2LongOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2LongOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Float2LongMap.Entry> consumer) {
            if (Float2LongOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractFloat2LongMap.BasicEntry(Float2LongOpenHashMap.this.key[Float2LongOpenHashMap.this.f1843n], Float2LongOpenHashMap.this.value[Float2LongOpenHashMap.this.f1843n]));
            }
            int pos = Float2LongOpenHashMap.this.f1843n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Float.floatToIntBits(Float2LongOpenHashMap.this.key[pos]) != 0) {
                    consumer.accept(new AbstractFloat2LongMap.BasicEntry(Float2LongOpenHashMap.this.key[pos], Float2LongOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Float2LongMap.Entry> consumer) {
            AbstractFloat2LongMap.BasicEntry entry = new AbstractFloat2LongMap.BasicEntry();
            if (Float2LongOpenHashMap.this.containsNullKey) {
                entry.key = Float2LongOpenHashMap.this.key[Float2LongOpenHashMap.this.f1843n];
                entry.value = Float2LongOpenHashMap.this.value[Float2LongOpenHashMap.this.f1843n];
                consumer.accept(entry);
            }
            int pos = Float2LongOpenHashMap.this.f1843n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Float.floatToIntBits(Float2LongOpenHashMap.this.key[pos]) != 0) {
                    entry.key = Float2LongOpenHashMap.this.key[pos];
                    entry.value = Float2LongOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongSortedMap
    public Float2LongMap.FastEntrySet float2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<FloatConsumer> implements FloatIterator {
        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(FloatConsumer floatConsumer) {
            forEachRemaining((KeyIterator) floatConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(FloatConsumer action, int index) {
            action.accept(Float2LongOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return Float2LongOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<FloatConsumer, KeySpliterator> implements FloatSpliterator {
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
        public final void acceptOnIndex(FloatConsumer action, int index) {
            action.accept(Float2LongOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractFloatSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatSpliterator spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
        public void forEach(FloatConsumer consumer) {
            if (Float2LongOpenHashMap.this.containsNullKey) {
                consumer.accept(Float2LongOpenHashMap.this.key[Float2LongOpenHashMap.this.f1843n]);
            }
            int pos = Float2LongOpenHashMap.this.f1843n;
            while (true) {
                pos--;
                if (pos != 0) {
                    float k = Float2LongOpenHashMap.this.key[pos];
                    if (Float.floatToIntBits(k) != 0) {
                        consumer.accept(k);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Float2LongOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return Float2LongOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            int oldSize = Float2LongOpenHashMap.this.size;
            Float2LongOpenHashMap.this.remove(k);
            return Float2LongOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Float2LongOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
    public Set<Float> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$ValueIterator.class */
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
            action.accept(Float2LongOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Float2LongOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongOpenHashMap$ValueSpliterator.class */
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
            action.accept(Float2LongOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
    public Collection<Long> values() {
        if (this.values == null) {
            this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.floats.Float2LongOpenHashMap.1
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
                    if (Float2LongOpenHashMap.this.containsNullKey) {
                        consumer.accept(Float2LongOpenHashMap.this.value[Float2LongOpenHashMap.this.f1843n]);
                    }
                    int pos = Float2LongOpenHashMap.this.f1843n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Float.floatToIntBits(Float2LongOpenHashMap.this.key[pos]) != 0) {
                            consumer.accept(Float2LongOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Float2LongOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                public boolean contains(long v) {
                    return Float2LongOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Float2LongOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1844f)));
        if (l >= this.f1843n || this.size > HashCommon.maxFill(l, this.f1844f)) {
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
        float[] key = this.key;
        long[] value = this.value;
        int mask = newN - 1;
        float[] newKey = new float[newN + 1];
        long[] newValue = new long[newN + 1];
        int i2 = this.f1843n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (Float.floatToIntBits(key[i2]) == 0);
                int mix = HashCommon.mix(HashCommon.float2int(key[i2])) & mask;
                int pos = mix;
                if (Float.floatToIntBits(newKey[mix]) != 0) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (Float.floatToIntBits(newKey[i]) != 0);
                }
                newKey[pos] = key[i2];
                newValue[pos] = value[i2];
            } else {
                newValue[newN] = value[this.f1843n];
                this.f1843n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1843n, this.f1844f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Float2LongOpenHashMap clone() {
        try {
            Float2LongOpenHashMap c = (Float2LongOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (float[]) this.key.clone();
            c.value = (long[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap, java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            while (Float.floatToIntBits(this.key[i]) == 0) {
                i++;
            }
            h += HashCommon.float2int(this.key[i]) ^ HashCommon.long2int(this.value[i]);
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.long2int(this.value[this.f1843n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        float[] key = this.key;
        long[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeFloat(key[e]);
                s.writeLong(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1843n = HashCommon.arraySize(this.size, this.f1844f);
        this.maxFill = HashCommon.maxFill(this.f1843n, this.f1844f);
        this.mask = this.f1843n - 1;
        float[] key = new float[this.f1843n + 1];
        this.key = key;
        long[] value = new long[this.f1843n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                float k = s.readFloat();
                long v = s.readLong();
                if (Float.floatToIntBits(k) == 0) {
                    pos = this.f1843n;
                    this.containsNullKey = true;
                } else {
                    int mix = HashCommon.mix(HashCommon.float2int(k));
                    int i2 = this.mask;
                    while (true) {
                        pos = mix & i2;
                        if (Float.floatToIntBits(key[pos]) != 0) {
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
