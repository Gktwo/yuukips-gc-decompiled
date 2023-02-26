package p014it.unimi.dsi.fastutil.shorts;

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
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap.class */
public class Short2DoubleOpenHashMap extends AbstractShort2DoubleMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient short[] key;
    protected transient double[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;

    /* renamed from: n */
    protected transient int f2900n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2901f;
    protected transient Short2DoubleMap.FastEntrySet entries;
    protected transient ShortSet keys;
    protected transient DoubleCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.computeIfPresent(short, java.util.function.BiFunction<? super java.lang.Short, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double computeIfPresent(short r1, java.util.function.BiFunction<? super java.lang.Short, ? super java.lang.Double, ? extends java.lang.Double> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.computeIfPresent(short, java.util.function.BiFunction<? super java.lang.Short, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.computeIfPresent(short, java.util.function.BiFunction):double");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.compute(short, java.util.function.BiFunction<? super java.lang.Short, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double compute(short r1, java.util.function.BiFunction<? super java.lang.Short, ? super java.lang.Double, ? extends java.lang.Double> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.compute(short, java.util.function.BiFunction<? super java.lang.Short, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.compute(short, java.util.function.BiFunction):double");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.merge(short, double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double merge(short r1, double r2, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Double, ? extends java.lang.Double> r4) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.merge(short, double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.merge(short, double, java.util.function.BiFunction):double");
    }

    public Short2DoubleOpenHashMap(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2901f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2900n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2900n - 1;
            this.maxFill = HashCommon.maxFill(this.f2900n, f);
            this.key = new short[this.f2900n + 1];
            this.value = new double[this.f2900n + 1];
        }
    }

    public Short2DoubleOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Short2DoubleOpenHashMap() {
        this(16, 0.75f);
    }

    public Short2DoubleOpenHashMap(Map<? extends Short, ? extends Double> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2DoubleOpenHashMap(Map<? extends Short, ? extends Double> m) {
        this(m, 0.75f);
    }

    public Short2DoubleOpenHashMap(Short2DoubleMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Short2DoubleOpenHashMap(Short2DoubleMap m) {
        this(m, 0.75f);
    }

    public Short2DoubleOpenHashMap(short[] k, double[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Short2DoubleOpenHashMap(short[] k, double[] v) {
        this(k, v, 0.75f);
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2901f);
        if (needed > this.f2900n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2901f)))));
        if (needed > this.f2900n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public double removeEntry(int pos) {
        double oldValue = this.value[pos];
        this.size--;
        shiftKeys(pos);
        if (this.f2900n > this.minN && this.size < this.maxFill / 4 && this.f2900n > 16) {
            rehash(this.f2900n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public double removeNullEntry() {
        this.containsNullKey = false;
        double oldValue = this.value[this.f2900n];
        this.size--;
        if (this.f2900n > this.minN && this.size < this.maxFill / 4 && this.f2900n > 16) {
            rehash(this.f2900n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, java.util.Map
    public void putAll(Map<? extends Short, ? extends Double> m) {
        if (((double) this.f2901f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2900n : -(this.f2900n + 1);
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    private void insert(int pos, short k, double v) {
        if (pos == this.f2900n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        int i = this.size;
        this.size = i + 1;
        if (i >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2901f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double put(short k, double v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        double oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private double addToValue(int pos, double incr) {
        double oldValue = this.value[pos];
        this.value[pos] = oldValue + incr;
        return oldValue;
    }

    public double addTo(short k, double incr) {
        int pos;
        short curr;
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            short curr2 = key[mix];
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
            return addToValue(this.f2900n, incr);
        } else {
            pos = this.f2900n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2901f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        short curr;
        short[] key = this.key;
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double remove(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double get(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2900n] : this.defRetValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public boolean containsKey(short k) {
        short curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public boolean containsValue(double v) {
        double[] value = this.value;
        short[] key = this.key;
        if (this.containsNullKey && Double.doubleToLongBits(value[this.f2900n]) == Double.doubleToLongBits(v)) {
            return true;
        }
        int i = this.f2900n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != 0 && Double.doubleToLongBits(value[i]) == Double.doubleToLongBits(v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double getOrDefault(short k, double defaultValue) {
        short curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2900n] : defaultValue;
        }
        short[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double putIfAbsent(short k, double v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public boolean remove(short k, double v) {
        if (k != 0) {
            short[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            short curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (k == curr && Double.doubleToLongBits(v) == Double.doubleToLongBits(this.value[pos])) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                short curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && Double.doubleToLongBits(v) == Double.doubleToLongBits(this.value[pos])) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || Double.doubleToLongBits(v) != Double.doubleToLongBits(this.value[this.f2900n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public boolean replace(short k, double oldValue, double v) {
        int pos = find(k);
        if (pos < 0 || Double.doubleToLongBits(oldValue) != Double.doubleToLongBits(this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double replace(short k, double v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        double oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double computeIfAbsent(short k, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        double newValue = mappingFunction.applyAsDouble(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double computeIfAbsent(short key, Short2DoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        double newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap
    public double computeIfAbsentNullable(short k, IntFunction<? extends Double> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Double newValue = (Double) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        double v = newValue.doubleValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, (short) 0);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$MapEntry.class */
    public final class MapEntry implements Short2DoubleMap.Entry, Map.Entry<Short, Double>, ShortDoublePair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.Entry
        public short getShortKey() {
            return Short2DoubleOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortDoublePair
        public short leftShort() {
            return Short2DoubleOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.Entry
        public double getDoubleValue() {
            return Short2DoubleOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortDoublePair
        public double rightDouble() {
            return Short2DoubleOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.Entry
        public double setValue(double v) {
            double oldValue = Short2DoubleOpenHashMap.this.value[this.index];
            Short2DoubleOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortDoublePair
        public ShortDoublePair right(double v) {
            Short2DoubleOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getKey() {
            return Short.valueOf(Short2DoubleOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.Entry, java.util.Map.Entry
        @Deprecated
        public Double getValue() {
            return Double.valueOf(Short2DoubleOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.Entry
        @Deprecated
        public Double setValue(Double v) {
            return Double.valueOf(setValue(v.doubleValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Short, Double> e = (Map.Entry) o;
            return Short2DoubleOpenHashMap.this.key[this.index] == e.getKey().shortValue() && Double.doubleToLongBits(Short2DoubleOpenHashMap.this.value[this.index]) == Double.doubleToLongBits(e.getValue().doubleValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Short2DoubleOpenHashMap.this.key[this.index] ^ HashCommon.double2int(Short2DoubleOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Short2DoubleOpenHashMap.this.key[this.index]) + "=>" + Short2DoubleOpenHashMap.this.value[this.index];
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int pos;
        int last;

        /* renamed from: c */
        int f2902c;
        boolean mustReturnNullKey;
        ShortArrayList wrapped;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        private MapIterator() {
            this.pos = Short2DoubleOpenHashMap.this.f2900n;
            this.last = -1;
            this.f2902c = Short2DoubleOpenHashMap.this.size;
            this.mustReturnNullKey = Short2DoubleOpenHashMap.this.containsNullKey;
        }

        public boolean hasNext() {
            return this.f2902c != 0;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2902c--;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                int i = Short2DoubleOpenHashMap.this.f2900n;
                this.last = i;
                return i;
            }
            short[] key = Short2DoubleOpenHashMap.this.key;
            do {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Short2DoubleOpenHashMap.this.mask;
                    while (true) {
                        int p = mix & i3;
                        if (k == key[p]) {
                            return p;
                        }
                        mix = p + 1;
                        i3 = Short2DoubleOpenHashMap.this.mask;
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
                int i = Short2DoubleOpenHashMap.this.f2900n;
                this.last = i;
                acceptOnIndex(action, i);
                this.f2902c--;
            }
            short[] key = Short2DoubleOpenHashMap.this.key;
            while (this.f2902c != 0) {
                int i2 = this.pos - 1;
                this.pos = i2;
                if (i2 < 0) {
                    this.last = Integer.MIN_VALUE;
                    short k = this.wrapped.getShort((-this.pos) - 1);
                    int mix = HashCommon.mix((int) k);
                    int i3 = Short2DoubleOpenHashMap.this.mask;
                    while (true) {
                        p = mix & i3;
                        if (k == key[p]) {
                            break;
                        }
                        mix = p + 1;
                        i3 = Short2DoubleOpenHashMap.this.mask;
                    }
                    acceptOnIndex(action, p);
                    this.f2902c--;
                } else if (key[this.pos] != 0) {
                    int i4 = this.pos;
                    this.last = i4;
                    acceptOnIndex(action, i4);
                    this.f2902c--;
                }
            }
        }

        private void shiftKeys(int pos) {
            short curr;
            short[] key = Short2DoubleOpenHashMap.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = Short2DoubleOpenHashMap.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix((int) curr) & Short2DoubleOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2DoubleOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = Short2DoubleOpenHashMap.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ShortArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
                Short2DoubleOpenHashMap.this.value[pos] = Short2DoubleOpenHashMap.this.value[pos];
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Short2DoubleOpenHashMap.this.f2900n) {
                Short2DoubleOpenHashMap.this.containsNullKey = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                Short2DoubleOpenHashMap.this.remove(this.wrapped.getShort((-this.pos) - 1));
                this.last = -1;
                return;
            }
            Short2DoubleOpenHashMap.this.size--;
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Short2DoubleMap.Entry>> implements ObjectIterator<Short2DoubleMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Short2DoubleMap.Entry> action, int index) {
            MapEntry mapEntry = new MapEntry(index);
            this.entry = mapEntry;
            action.accept(mapEntry);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.MapIterator, java.util.Iterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$FastEntryIterator.class */
    private final class FastEntryIterator extends MapIterator<Consumer<? super Short2DoubleMap.Entry>> implements ObjectIterator<Short2DoubleMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Short2DoubleMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$MapSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$MapSpliterator.class */
    private abstract class MapSpliterator<ConsumerType, SplitType extends MapSpliterator<ConsumerType, SplitType>> {
        int pos;
        int max;

        /* renamed from: c */
        int f2903c;
        boolean mustReturnNull;
        boolean hasSplit;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        abstract SplitType makeForSplit(int i, int i2, boolean z);

        MapSpliterator() {
            this.pos = 0;
            this.max = Short2DoubleOpenHashMap.this.f2900n;
            this.f2903c = 0;
            this.mustReturnNull = Short2DoubleOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
        }

        MapSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = Short2DoubleOpenHashMap.this.f2900n;
            this.f2903c = 0;
            this.mustReturnNull = Short2DoubleOpenHashMap.this.containsNullKey;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ConsumerType action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2903c++;
                acceptOnIndex(action, Short2DoubleOpenHashMap.this.f2900n);
                return true;
            }
            short[] key = Short2DoubleOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f2903c++;
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
                this.f2903c++;
                acceptOnIndex(action, Short2DoubleOpenHashMap.this.f2900n);
            }
            short[] key = Short2DoubleOpenHashMap.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    acceptOnIndex(action, this.pos);
                    this.f2903c++;
                }
                this.pos++;
            }
        }

        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (Short2DoubleOpenHashMap.this.size - this.f2903c);
            }
            return Math.min((long) (Short2DoubleOpenHashMap.this.size - this.f2903c), ((long) ((((double) Short2DoubleOpenHashMap.this.realSize()) / ((double) Short2DoubleOpenHashMap.this.f2900n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
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
                it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap r0 = p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.this
                short[] r0 = r0.key
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
                short r0 = r0[r1]
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.MapSpliterator.skip(long):long");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$EntrySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$EntrySpliterator.class */
    public final class EntrySpliterator extends MapSpliterator<Consumer<? super Short2DoubleMap.Entry>, EntrySpliterator> implements ObjectSpliterator<Short2DoubleMap.Entry> {
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
        public final void acceptOnIndex(Consumer<? super Short2DoubleMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.MapSpliterator
        public final EntrySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new EntrySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSet<Short2DoubleMap.Entry> implements Short2DoubleMap.FastEntrySet {
        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectIterator<Short2DoubleMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.FastEntrySet
        public ObjectIterator<Short2DoubleMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2DoubleMap.Entry> spliterator() {
            return new EntrySpliterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            short curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            double v = ((Double) e.getValue()).doubleValue();
            if (k == 0) {
                return Short2DoubleOpenHashMap.this.containsNullKey && Double.doubleToLongBits(Short2DoubleOpenHashMap.this.value[Short2DoubleOpenHashMap.this.f2900n]) == Double.doubleToLongBits(v);
            }
            short[] key = Short2DoubleOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Short2DoubleOpenHashMap.this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Double.doubleToLongBits(Short2DoubleOpenHashMap.this.value[pos]) == Double.doubleToLongBits(v);
            }
            do {
                int i = (pos + 1) & Short2DoubleOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Double.doubleToLongBits(Short2DoubleOpenHashMap.this.value[pos]) == Double.doubleToLongBits(v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Short) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            short k = ((Short) e.getKey()).shortValue();
            double v = ((Double) e.getValue()).doubleValue();
            if (k != 0) {
                short[] key = Short2DoubleOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Short2DoubleOpenHashMap.this.mask;
                int pos = mix;
                short curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Short2DoubleOpenHashMap.this.mask;
                        pos = i;
                        short curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Double.doubleToLongBits(Short2DoubleOpenHashMap.this.value[pos]) == Double.doubleToLongBits(v)) {
                            Short2DoubleOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Double.doubleToLongBits(Short2DoubleOpenHashMap.this.value[pos]) != Double.doubleToLongBits(v)) {
                    return false;
                } else {
                    Short2DoubleOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Short2DoubleOpenHashMap.this.containsNullKey || Double.doubleToLongBits(Short2DoubleOpenHashMap.this.value[Short2DoubleOpenHashMap.this.f2900n]) != Double.doubleToLongBits(v)) {
                return false;
            } else {
                Short2DoubleOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Short2DoubleOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2DoubleOpenHashMap.this.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Short2DoubleMap.Entry> consumer) {
            if (Short2DoubleOpenHashMap.this.containsNullKey) {
                consumer.accept(new AbstractShort2DoubleMap.BasicEntry(Short2DoubleOpenHashMap.this.key[Short2DoubleOpenHashMap.this.f2900n], Short2DoubleOpenHashMap.this.value[Short2DoubleOpenHashMap.this.f2900n]));
            }
            int pos = Short2DoubleOpenHashMap.this.f2900n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2DoubleOpenHashMap.this.key[pos] != 0) {
                    consumer.accept(new AbstractShort2DoubleMap.BasicEntry(Short2DoubleOpenHashMap.this.key[pos], Short2DoubleOpenHashMap.this.value[pos]));
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap.FastEntrySet
        public void fastForEach(Consumer<? super Short2DoubleMap.Entry> consumer) {
            AbstractShort2DoubleMap.BasicEntry entry = new AbstractShort2DoubleMap.BasicEntry();
            if (Short2DoubleOpenHashMap.this.containsNullKey) {
                entry.key = Short2DoubleOpenHashMap.this.key[Short2DoubleOpenHashMap.this.f2900n];
                entry.value = Short2DoubleOpenHashMap.this.value[Short2DoubleOpenHashMap.this.f2900n];
                consumer.accept(entry);
            }
            int pos = Short2DoubleOpenHashMap.this.f2900n;
            while (true) {
                pos--;
                if (pos == 0) {
                    return;
                }
                if (Short2DoubleOpenHashMap.this.key[pos] != 0) {
                    entry.key = Short2DoubleOpenHashMap.this.key[pos];
                    entry.value = Short2DoubleOpenHashMap.this.value[pos];
                    consumer.accept(entry);
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
    public Short2DoubleMap.FastEntrySet short2DoubleEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<ShortConsumer> implements ShortIterator {
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ShortConsumer shortConsumer) {
            forEachRemaining((KeyIterator) shortConsumer);
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2DoubleOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Short2DoubleOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$KeySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$KeySpliterator.class */
    public final class KeySpliterator extends MapSpliterator<ShortConsumer, KeySpliterator> implements ShortSpliterator {
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
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Short2DoubleOpenHashMap.this.key[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.MapSpliterator
        public final KeySpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new KeySpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractShortSet {
        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortSpliterator spliterator() {
            return new KeySpliterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public void forEach(ShortConsumer consumer) {
            if (Short2DoubleOpenHashMap.this.containsNullKey) {
                consumer.accept(Short2DoubleOpenHashMap.this.key[Short2DoubleOpenHashMap.this.f2900n]);
            }
            int pos = Short2DoubleOpenHashMap.this.f2900n;
            while (true) {
                pos--;
                if (pos != 0) {
                    short k = Short2DoubleOpenHashMap.this.key[pos];
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
            return Short2DoubleOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return Short2DoubleOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            int oldSize = Short2DoubleOpenHashMap.this.size;
            Short2DoubleOpenHashMap.this.remove(k);
            return Short2DoubleOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Short2DoubleOpenHashMap.this.clear();
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
    public Set<Short> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<DoubleConsumer> implements DoubleIterator {
        @Override // java.util.PrimitiveIterator.OfDouble
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
            forEachRemaining((ValueIterator) doubleConsumer);
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(DoubleConsumer action, int index) {
            action.accept(Short2DoubleOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return Short2DoubleOpenHashMap.this.value[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap$ValueSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleOpenHashMap$ValueSpliterator.class */
    public final class ValueSpliterator extends MapSpliterator<DoubleConsumer, ValueSpliterator> implements DoubleSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 256;

        @Override // java.util.Spliterator.OfDouble
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
            forEachRemaining((ValueSpliterator) doubleConsumer);
        }

        @Override // java.util.Spliterator.OfDouble
        public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
            return tryAdvance((ValueSpliterator) doubleConsumer);
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
        public final void acceptOnIndex(DoubleConsumer action, int index) {
            action.accept(Short2DoubleOpenHashMap.this.value[index]);
        }

        /* access modifiers changed from: package-private */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.MapSpliterator
        public final ValueSpliterator makeForSplit(int pos, int max, boolean mustReturnNull) {
            return new ValueSpliterator(pos, max, mustReturnNull, true);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
    public Collection<Double> values() {
        if (this.values == null) {
            this.values = new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.shorts.Short2DoubleOpenHashMap.1
                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public DoubleIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public DoubleSpliterator spliterator() {
                    return new ValueSpliterator();
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public void forEach(DoubleConsumer consumer) {
                    if (Short2DoubleOpenHashMap.this.containsNullKey) {
                        consumer.accept(Short2DoubleOpenHashMap.this.value[Short2DoubleOpenHashMap.this.f2900n]);
                    }
                    int pos = Short2DoubleOpenHashMap.this.f2900n;
                    while (true) {
                        pos--;
                        if (pos == 0) {
                            return;
                        }
                        if (Short2DoubleOpenHashMap.this.key[pos] != 0) {
                            consumer.accept(Short2DoubleOpenHashMap.this.value[pos]);
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Short2DoubleOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
                public boolean contains(double v) {
                    return Short2DoubleOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Short2DoubleOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2901f)));
        if (l >= this.f2900n || this.size > HashCommon.maxFill(l, this.f2901f)) {
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
        short[] key = this.key;
        double[] value = this.value;
        int mask = newN - 1;
        short[] newKey = new short[newN + 1];
        double[] newValue = new double[newN + 1];
        int i2 = this.f2900n;
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
                newValue[newN] = value[this.f2900n];
                this.f2900n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2900n, this.f2901f);
                this.key = newKey;
                this.value = newValue;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Short2DoubleOpenHashMap clone() {
        try {
            Short2DoubleOpenHashMap c = (Short2DoubleOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (short[]) this.key.clone();
            c.value = (double[]) this.value.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap, java.lang.Object, java.util.Map
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
            h += this.key[i] ^ HashCommon.double2int(this.value[i]);
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.double2int(this.value[this.f2900n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        short[] key = this.key;
        double[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeShort(key[e]);
                s.writeDouble(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2900n = HashCommon.arraySize(this.size, this.f2901f);
        this.maxFill = HashCommon.maxFill(this.f2900n, this.f2901f);
        this.mask = this.f2900n - 1;
        short[] key = new short[this.f2900n + 1];
        this.key = key;
        double[] value = new double[this.f2900n + 1];
        this.value = value;
        int i = this.size;
        while (true) {
            i--;
            if (i != 0) {
                short k = s.readShort();
                double v = s.readDouble();
                if (k == 0) {
                    pos = this.f2900n;
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
