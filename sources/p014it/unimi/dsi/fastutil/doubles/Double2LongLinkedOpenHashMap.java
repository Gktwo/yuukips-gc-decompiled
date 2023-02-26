package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.LongConsumer;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap;
import p014it.unimi.dsi.fastutil.doubles.Double2LongMap;
import p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongListIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap.class */
public class Double2LongLinkedOpenHashMap extends AbstractDouble2LongSortedMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient double[] key;
    protected transient long[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f1616n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1617f;
    protected transient Double2LongSortedMap.FastSortedEntrySet entries;
    protected transient DoubleSortedSet keys;
    protected transient LongCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.computeIfPresent(double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long computeIfPresent(double r1, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Long, ? extends java.lang.Long> r3) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.computeIfPresent(double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.computeIfPresent(double, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.compute(double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long compute(double r1, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Long, ? extends java.lang.Long> r3) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.compute(double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.compute(double, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.merge(double, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long merge(double r1, long r3, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> r5) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.merge(double, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.merge(double, long, java.util.function.BiFunction):long");
    }

    public Double2LongLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1617f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1616n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1616n - 1;
            this.maxFill = HashCommon.maxFill(this.f1616n, f);
            this.key = new double[this.f1616n + 1];
            this.value = new long[this.f1616n + 1];
            this.link = new long[this.f1616n + 1];
        }
    }

    public Double2LongLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Double2LongLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Double2LongLinkedOpenHashMap(Map<? extends Double, ? extends Long> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Double2LongLinkedOpenHashMap(Map<? extends Double, ? extends Long> m) {
        this(m, 0.75f);
    }

    public Double2LongLinkedOpenHashMap(Double2LongMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Double2LongLinkedOpenHashMap(Double2LongMap m) {
        this(m, 0.75f);
    }

    public Double2LongLinkedOpenHashMap(double[] k, long[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Double2LongLinkedOpenHashMap(double[] k, long[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1617f);
        if (needed > this.f1616n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1617f)))));
        if (needed > this.f1616n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public long removeEntry(int pos) {
        long oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f1616n > this.minN && this.size < this.maxFill / 4 && this.f1616n > 16) {
            rehash(this.f1616n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public long removeNullEntry() {
        this.containsNullKey = false;
        long oldValue = this.value[this.f1616n];
        this.size--;
        fixPointers(this.f1616n);
        if (this.f1616n > this.minN && this.size < this.maxFill / 4 && this.f1616n > 16) {
            rehash(this.f1616n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap, java.util.Map
    public void putAll(Map<? extends Double, ? extends Long> m) {
        if (((double) this.f1617f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.f1616n : -(this.f1616n + 1);
        }
        double[] key = this.key;
        int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
        int pos = mix;
        double curr2 = key[mix];
        if (Double.doubleToLongBits(curr2) == 0) {
            return -(pos + 1);
        }
        if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
            return pos;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Double.doubleToLongBits(curr) == 0) {
                return -(pos + 1);
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
        return pos;
    }

    private void insert(int pos, double k, long v) {
        if (pos == this.f1616n) {
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i = this.last;
            jArr[i] = jArr[i] ^ ((this.link[this.last] ^ (((long) pos) & 4294967295L)) & 4294967295L);
            this.link[pos] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = pos;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1617f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongFunction
    public long put(double k, long v) {
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

    public long addTo(double k, long incr) {
        int pos;
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) != 0) {
                if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
                    return addToValue(pos, incr);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Double.doubleToLongBits(curr) != 0) {
                    }
                } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
                return addToValue(pos, incr);
            }
        } else if (this.containsNullKey) {
            return addToValue(this.f1616n, incr);
        } else {
            pos = this.f1616n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = this.defRetValue + incr;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i2 = this.last;
            jArr[i2] = jArr[i2] ^ ((this.link[this.last] ^ (((long) pos) & 4294967295L)) & 4294967295L);
            this.link[pos] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = pos;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f1617f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        double curr;
        double[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (Double.doubleToLongBits(curr) == 0) {
                    key[pos] = 0.0d;
                    return;
                }
                int slot = ((int) HashCommon.mix(Double.doubleToRawLongBits(curr))) & this.mask;
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
            fixPointers(pos, pos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongFunction
    public long remove(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        double[] key = this.key;
        int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
        int pos = mix;
        double curr2 = key[mix];
        if (Double.doubleToLongBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Double.doubleToLongBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
        return removeEntry(pos);
    }

    private long setValue(int pos, long v) {
        long oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public long removeFirstLong() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int pos = this.first;
        this.first = (int) this.link[pos];
        if (0 <= this.first) {
            long[] jArr = this.link;
            int i = this.first;
            jArr[i] = jArr[i] | -4294967296L;
        }
        this.size--;
        long v = this.value[pos];
        if (pos == this.f1616n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1616n > this.minN && this.size < this.maxFill / 4 && this.f1616n > 16) {
            rehash(this.f1616n / 2);
        }
        return v;
    }

    public long removeLastLong() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        int pos = this.last;
        this.last = (int) (this.link[pos] >>> 32);
        if (0 <= this.last) {
            long[] jArr = this.link;
            int i = this.last;
            jArr[i] = jArr[i] | 4294967295L;
        }
        this.size--;
        long v = this.value[pos];
        if (pos == this.f1616n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1616n > this.minN && this.size < this.maxFill / 4 && this.f1616n > 16) {
            rehash(this.f1616n / 2);
        }
        return v;
    }

    private void moveIndexToFirst(int i) {
        if (this.size != 1 && this.first != i) {
            if (this.last == i) {
                this.last = (int) (this.link[i] >>> 32);
                long[] jArr = this.link;
                int i2 = this.last;
                jArr[i2] = jArr[i2] | 4294967295L;
            } else {
                long linki = this.link[i];
                int prev = (int) (linki >>> 32);
                int next = (int) linki;
                long[] jArr2 = this.link;
                jArr2[prev] = jArr2[prev] ^ ((this.link[prev] ^ (linki & 4294967295L)) & 4294967295L);
                long[] jArr3 = this.link;
                jArr3[next] = jArr3[next] ^ ((this.link[next] ^ (linki & -4294967296L)) & -4294967296L);
            }
            long[] jArr4 = this.link;
            int i3 = this.first;
            jArr4[i3] = jArr4[i3] ^ ((this.link[this.first] ^ ((((long) i) & 4294967295L) << 32)) & -4294967296L);
            this.link[i] = -4294967296L | (((long) this.first) & 4294967295L);
            this.first = i;
        }
    }

    private void moveIndexToLast(int i) {
        if (this.size != 1 && this.last != i) {
            if (this.first == i) {
                this.first = (int) this.link[i];
                long[] jArr = this.link;
                int i2 = this.first;
                jArr[i2] = jArr[i2] | -4294967296L;
            } else {
                long linki = this.link[i];
                int prev = (int) (linki >>> 32);
                int next = (int) linki;
                long[] jArr2 = this.link;
                jArr2[prev] = jArr2[prev] ^ ((this.link[prev] ^ (linki & 4294967295L)) & 4294967295L);
                long[] jArr3 = this.link;
                jArr3[next] = jArr3[next] ^ ((this.link[next] ^ (linki & -4294967296L)) & -4294967296L);
            }
            long[] jArr4 = this.link;
            int i3 = this.last;
            jArr4[i3] = jArr4[i3] ^ ((this.link[this.last] ^ (((long) i) & 4294967295L)) & 4294967295L);
            this.link[i] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = i;
        }
    }

    public long getAndMoveToFirst(double k) {
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) == 0) {
                return this.defRetValue;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
                moveIndexToFirst(pos);
                return this.value[pos];
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (Double.doubleToLongBits(curr) == 0) {
                    return this.defRetValue;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToFirst(this.f1616n);
            return this.value[this.f1616n];
        }
    }

    public long getAndMoveToLast(double k) {
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) == 0) {
                return this.defRetValue;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
                moveIndexToLast(pos);
                return this.value[pos];
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (Double.doubleToLongBits(curr) == 0) {
                    return this.defRetValue;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToLast(this.f1616n);
            return this.value[this.f1616n];
        }
    }

    public long putAndMoveToFirst(double k, long v) {
        int pos;
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) != 0) {
                if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
                    moveIndexToFirst(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Double.doubleToLongBits(curr) != 0) {
                    }
                } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
                moveIndexToFirst(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToFirst(this.f1616n);
            return setValue(this.f1616n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1616n;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i2 = this.first;
            jArr[i2] = jArr[i2] ^ ((this.link[this.first] ^ ((((long) pos) & 4294967295L) << 32)) & -4294967296L);
            this.link[pos] = -4294967296L | (((long) this.first) & 4294967295L);
            this.first = pos;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size, this.f1617f));
        }
        return this.defRetValue;
    }

    public long putAndMoveToLast(double k, long v) {
        int pos;
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) != 0) {
                if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
                    moveIndexToLast(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Double.doubleToLongBits(curr) != 0) {
                    }
                } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
                moveIndexToLast(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToLast(this.f1616n);
            return setValue(this.f1616n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1616n;
        }
        this.key[pos] = k;
        this.value[pos] = v;
        if (this.size == 0) {
            this.last = pos;
            this.first = pos;
            this.link[pos] = -1;
        } else {
            long[] jArr = this.link;
            int i2 = this.last;
            jArr[i2] = jArr[i2] ^ ((this.link[this.last] ^ (((long) pos) & 4294967295L)) & 4294967295L);
            this.link[pos] = ((((long) this.last) & 4294967295L) << 32) | 4294967295L;
            this.last = pos;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size, this.f1617f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongFunction
    public long get(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1616n] : this.defRetValue;
        }
        double[] key = this.key;
        int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
        int pos = mix;
        double curr2 = key[mix];
        if (Double.doubleToLongBits(curr2) == 0) {
            return this.defRetValue;
        }
        if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Double.doubleToLongBits(curr) == 0) {
                return this.defRetValue;
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongFunction, p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public boolean containsKey(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey;
        }
        double[] key = this.key;
        int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
        int pos = mix;
        double curr2 = key[mix];
        if (Double.doubleToLongBits(curr2) == 0) {
            return false;
        }
        if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Double.doubleToLongBits(curr) == 0) {
                return false;
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public boolean containsValue(long v) {
        long[] value = this.value;
        double[] key = this.key;
        if (this.containsNullKey && value[this.f1616n] == v) {
            return true;
        }
        int i = this.f1616n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (Double.doubleToLongBits(key[i]) != 0 && value[i] == v) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongFunction
    public long getOrDefault(double k, long defaultValue) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1616n] : defaultValue;
        }
        double[] key = this.key;
        int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
        int pos = mix;
        double curr2 = key[mix];
        if (Double.doubleToLongBits(curr2) == 0) {
            return defaultValue;
        }
        if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (Double.doubleToLongBits(curr) == 0) {
                return defaultValue;
            }
        } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long putIfAbsent(double k, long v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public boolean remove(double k, long v) {
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            int pos = mix;
            double curr = key[mix];
            if (Double.doubleToLongBits(curr) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr) && v == this.value[pos]) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                double curr2 = key[i];
                if (Double.doubleToLongBits(curr2) == 0) {
                    return false;
                }
                if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2) && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f1616n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public boolean replace(double k, long oldValue, long v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long replace(double k, long v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        long oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long computeIfAbsent(double k, DoubleToLongFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        long newValue = mappingFunction.applyAsLong(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long computeIfAbsent(double key, Double2LongFunction mappingFunction) {
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap
    public long computeIfAbsentNullable(double k, DoubleFunction<? extends Long> mappingFunction) {
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
            Arrays.fill(this.key, 0.0d);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Double2LongMap.Entry, Map.Entry<Double, Long>, DoubleLongPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.Entry
        public double getDoubleKey() {
            return Double2LongLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
        public double leftDouble() {
            return Double2LongLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.Entry
        public long getLongValue() {
            return Double2LongLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
        public long rightLong() {
            return Double2LongLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.Entry
        public long setValue(long v) {
            long oldValue = Double2LongLinkedOpenHashMap.this.value[this.index];
            Double2LongLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
        public DoubleLongPair right(long v) {
            Double2LongLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Double getKey() {
            return Double.valueOf(Double2LongLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getValue() {
            return Long.valueOf(Double2LongLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.Entry
        @Deprecated
        public Long setValue(Long v) {
            return Long.valueOf(setValue(v.longValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Double, Long> e = (Map.Entry) o;
            return Double.doubleToLongBits(Double2LongLinkedOpenHashMap.this.key[this.index]) == Double.doubleToLongBits(e.getKey().doubleValue()) && Double2LongLinkedOpenHashMap.this.value[this.index] == e.getValue().longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(Double2LongLinkedOpenHashMap.this.key[this.index]) ^ HashCommon.long2int(Double2LongLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Double2LongLinkedOpenHashMap.this.key[this.index] + "=>" + Double2LongLinkedOpenHashMap.this.value[this.index];
        }
    }

    protected void fixPointers(int i) {
        if (this.size == 0) {
            this.last = -1;
            this.first = -1;
        } else if (this.first == i) {
            this.first = (int) this.link[i];
            if (0 <= this.first) {
                long[] jArr = this.link;
                int i2 = this.first;
                jArr[i2] = jArr[i2] | -4294967296L;
            }
        } else if (this.last == i) {
            this.last = (int) (this.link[i] >>> 32);
            if (0 <= this.last) {
                long[] jArr2 = this.link;
                int i3 = this.last;
                jArr2[i3] = jArr2[i3] | 4294967295L;
            }
        } else {
            long linki = this.link[i];
            int prev = (int) (linki >>> 32);
            int next = (int) linki;
            long[] jArr3 = this.link;
            jArr3[prev] = jArr3[prev] ^ ((this.link[prev] ^ (linki & 4294967295L)) & 4294967295L);
            long[] jArr4 = this.link;
            jArr4[next] = jArr4[next] ^ ((this.link[next] ^ (linki & -4294967296L)) & -4294967296L);
        }
    }

    protected void fixPointers(int s, int d) {
        if (this.size == 1) {
            this.last = d;
            this.first = d;
            this.link[d] = -1;
        } else if (this.first == s) {
            this.first = d;
            long[] jArr = this.link;
            int i = (int) this.link[s];
            jArr[i] = jArr[i] ^ ((this.link[(int) this.link[s]] ^ ((((long) d) & 4294967295L) << 32)) & -4294967296L);
            this.link[d] = this.link[s];
        } else if (this.last == s) {
            this.last = d;
            long[] jArr2 = this.link;
            int i2 = (int) (this.link[s] >>> 32);
            jArr2[i2] = jArr2[i2] ^ ((this.link[(int) (this.link[s] >>> 32)] ^ (((long) d) & 4294967295L)) & 4294967295L);
            this.link[d] = this.link[s];
        } else {
            long links = this.link[s];
            int prev = (int) (links >>> 32);
            int next = (int) links;
            long[] jArr3 = this.link;
            jArr3[prev] = jArr3[prev] ^ ((this.link[prev] ^ (((long) d) & 4294967295L)) & 4294967295L);
            long[] jArr4 = this.link;
            jArr4[next] = jArr4[next] ^ ((this.link[next] ^ ((((long) d) & 4294967295L) << 32)) & -4294967296L);
            this.link[d] = links;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
    public double firstDoubleKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
    public double lastDoubleKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
    public Double2LongSortedMap tailMap(double from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
    public Double2LongSortedMap headMap(double to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
    public Double2LongSortedMap subMap(double from, double to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
    public Comparator<? super Double> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$MapIterator.class */
    private abstract class MapIterator<ConsumerType> {
        int prev;
        int next;
        int curr;
        int index;

        abstract void acceptOnIndex(ConsumerType consumertype, int i);

        protected MapIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = Double2LongLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(double from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (Double.doubleToLongBits(from) == 0) {
                if (Double2LongLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Double2LongLinkedOpenHashMap.this.link[Double2LongLinkedOpenHashMap.this.f1616n];
                    this.prev = Double2LongLinkedOpenHashMap.this.f1616n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Double.doubleToLongBits(Double2LongLinkedOpenHashMap.this.key[Double2LongLinkedOpenHashMap.this.last]) == Double.doubleToLongBits(from)) {
                this.prev = Double2LongLinkedOpenHashMap.this.last;
                this.index = Double2LongLinkedOpenHashMap.this.size;
            } else {
                int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(from));
                int i = Double2LongLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Double.doubleToLongBits(Double2LongLinkedOpenHashMap.this.key[pos]) == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Double.doubleToLongBits(Double2LongLinkedOpenHashMap.this.key[pos]) == Double.doubleToLongBits(from)) {
                        this.next = (int) Double2LongLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Double2LongLinkedOpenHashMap.this.mask;
                    }
                }
            }
        }

        public boolean hasNext() {
            return this.next != -1;
        }

        public boolean hasPrevious() {
            return this.prev != -1;
        }

        private final void ensureIndexKnown() {
            if (this.index < 0) {
                if (this.prev == -1) {
                    this.index = 0;
                } else if (this.next == -1) {
                    this.index = Double2LongLinkedOpenHashMap.this.size;
                } else {
                    int pos = Double2LongLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Double2LongLinkedOpenHashMap.this.link[pos];
                        this.index++;
                    }
                }
            }
        }

        public int nextIndex() {
            ensureIndexKnown();
            return this.index;
        }

        public int previousIndex() {
            ensureIndexKnown();
            return this.index - 1;
        }

        public int nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int) Double2LongLinkedOpenHashMap.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                this.index++;
            }
            return this.curr;
        }

        public int previousEntry() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int) (Double2LongLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Double2LongLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            double curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (Double2LongLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Double2LongLinkedOpenHashMap.this.link[this.curr];
            }
            Double2LongLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Double2LongLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Double2LongLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Double2LongLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Double2LongLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Double2LongLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Double2LongLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Double2LongLinkedOpenHashMap.this.f1616n) {
                Double2LongLinkedOpenHashMap.this.containsNullKey = false;
                return;
            }
            double[] key = Double2LongLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Double2LongLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (Double.doubleToLongBits(curr) == 0) {
                        key[pos] = 0.0d;
                        return;
                    }
                    int slot = ((int) HashCommon.mix(Double.doubleToRawLongBits(curr))) & Double2LongLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Double2LongLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Double2LongLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Double2LongLinkedOpenHashMap.this.value[pos] = Double2LongLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Double2LongLinkedOpenHashMap.this.fixPointers(pos, pos);
            }
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

        public int back(int n) {
            int i = n;
            while (true) {
                i--;
                if (i == 0 || !hasPrevious()) {
                    break;
                }
                previousEntry();
            }
            return (n - i) - 1;
        }

        public void set(Double2LongMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Double2LongMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Double2LongMap.Entry>> implements ObjectListIterator<Double2LongMap.Entry> {
        private MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Double2LongMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Double2LongMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(double from) {
            super(from);
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Double2LongMap.Entry> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public MapEntry next() {
            MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public MapEntry previous() {
            MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends MapIterator<Consumer<? super Double2LongMap.Entry>> implements ObjectListIterator<Double2LongMap.Entry> {
        final MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Double2LongMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Double2LongMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(double from) {
            super(from);
            this.entry = new MapEntry();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Double2LongMap.Entry> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Double2LongMap.Entry> implements Double2LongSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Double2LongMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2LongMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2LongLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Double2LongMap.Entry> comparator() {
            return null;
        }

        public ObjectSortedSet<Double2LongMap.Entry> subSet(Double2LongMap.Entry fromElement, Double2LongMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Double2LongMap.Entry> headSet(Double2LongMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Double2LongMap.Entry> tailSet(Double2LongMap.Entry fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Double2LongMap.Entry first() {
            if (Double2LongLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Double2LongLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Double2LongMap.Entry last() {
            if (Double2LongLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Double2LongLinkedOpenHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            double curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            long v = ((Long) e.getValue()).longValue();
            if (Double.doubleToLongBits(k) == 0) {
                return Double2LongLinkedOpenHashMap.this.containsNullKey && Double2LongLinkedOpenHashMap.this.value[Double2LongLinkedOpenHashMap.this.f1616n] == v;
            }
            double[] key = Double2LongLinkedOpenHashMap.this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & Double2LongLinkedOpenHashMap.this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
                return Double2LongLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Double2LongLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
            return Double2LongLinkedOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            long v = ((Long) e.getValue()).longValue();
            if (Double.doubleToLongBits(k) != 0) {
                double[] key = Double2LongLinkedOpenHashMap.this.key;
                int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & Double2LongLinkedOpenHashMap.this.mask;
                int pos = mix;
                double curr = key[mix];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
                if (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k)) {
                    while (true) {
                        int i = (pos + 1) & Double2LongLinkedOpenHashMap.this.mask;
                        pos = i;
                        double curr2 = key[i];
                        if (Double.doubleToLongBits(curr2) == 0) {
                            return false;
                        }
                        if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k) && Double2LongLinkedOpenHashMap.this.value[pos] == v) {
                            Double2LongLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Double2LongLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Double2LongLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Double2LongLinkedOpenHashMap.this.containsNullKey || Double2LongLinkedOpenHashMap.this.value[Double2LongLinkedOpenHashMap.this.f1616n] != v) {
                return false;
            } else {
                Double2LongLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2LongLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2LongLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Double2LongMap.Entry> iterator(Double2LongMap.Entry from) {
            return new EntryIterator(from.getDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.doubles.Double2LongMap.FastEntrySet
        public ObjectListIterator<Double2LongMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap.FastSortedEntrySet
        public ObjectListIterator<Double2LongMap.Entry> fastIterator(Double2LongMap.Entry from) {
            return new FastEntryIterator(from.getDoubleKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Double2LongMap.Entry> consumer) {
            int i = Double2LongLinkedOpenHashMap.this.size;
            int next = Double2LongLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2LongLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractDouble2LongMap.BasicEntry(Double2LongLinkedOpenHashMap.this.key[next], Double2LongLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Double2LongMap.Entry> consumer) {
            AbstractDouble2LongMap.BasicEntry entry = new AbstractDouble2LongMap.BasicEntry();
            int i = Double2LongLinkedOpenHashMap.this.size;
            int next = Double2LongLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2LongLinkedOpenHashMap.this.link[next];
                    entry.key = Double2LongLinkedOpenHashMap.this.key[next];
                    entry.value = Double2LongLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
    public Double2LongSortedMap.FastSortedEntrySet double2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<DoubleConsumer> implements DoubleListIterator {
        @Override // java.util.PrimitiveIterator.OfDouble
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
            forEachRemaining((KeyIterator) doubleConsumer);
        }

        public KeyIterator(double k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return Double2LongLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(DoubleConsumer action, int index) {
            action.accept(Double2LongLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return Double2LongLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractDoubleSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleListIterator iterator(double from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSortedSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleListIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleSpliterator spliterator() {
            return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2LongLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer consumer) {
            int i = Double2LongLinkedOpenHashMap.this.size;
            int next = Double2LongLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2LongLinkedOpenHashMap.this.link[next];
                    consumer.accept(Double2LongLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2LongLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double2LongLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            int oldSize = Double2LongLinkedOpenHashMap.this.size;
            Double2LongLinkedOpenHashMap.this.remove(k);
            return Double2LongLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2LongLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            if (Double2LongLinkedOpenHashMap.this.size != 0) {
                return Double2LongLinkedOpenHashMap.this.key[Double2LongLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            if (Double2LongLinkedOpenHashMap.this.size != 0) {
                return Double2LongLinkedOpenHashMap.this.key[Double2LongLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double from, double to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongSortedMap, p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
    public DoubleSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<LongConsumer> implements LongListIterator {
        @Override // java.util.PrimitiveIterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((ValueIterator) longConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return Double2LongLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Double2LongLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Double2LongLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongSortedMap, p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
    public LongCollection values() {
        if (this.values == null) {
            this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.doubles.Double2LongLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongSpliterator spliterator() {
                    return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2LongLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
                public void forEach(LongConsumer consumer) {
                    int i = Double2LongLinkedOpenHashMap.this.size;
                    int next = Double2LongLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Double2LongLinkedOpenHashMap.this.link[next];
                            consumer.accept(Double2LongLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Double2LongLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                public boolean contains(long v) {
                    return Double2LongLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Double2LongLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1617f)));
        if (l >= this.f1616n || this.size > HashCommon.maxFill(l, this.f1617f)) {
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
        int pos;
        double[] key = this.key;
        long[] value = this.value;
        int mask = newN - 1;
        double[] newKey = new double[newN + 1];
        long[] newValue = new long[newN + 1];
        int i = this.first;
        int prev = -1;
        int newPrev = -1;
        long[] link = this.link;
        long[] newLink = new long[newN + 1];
        this.first = -1;
        int j = this.size;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            if (Double.doubleToLongBits(key[i]) != 0) {
                int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(key[i]));
                while (true) {
                    pos = mix & mask;
                    if (Double.doubleToLongBits(newKey[pos]) == 0) {
                        break;
                    }
                    mix = pos + 1;
                }
            } else {
                pos = newN;
            }
            newKey[pos] = key[i];
            newValue[pos] = value[i];
            if (prev != -1) {
                newLink[newPrev] = newLink[newPrev] ^ ((newLink[newPrev] ^ (((long) pos) & 4294967295L)) & 4294967295L);
                newLink[pos] = newLink[pos] ^ ((newLink[pos] ^ ((((long) newPrev) & 4294967295L) << 32)) & -4294967296L);
                newPrev = pos;
            } else {
                this.first = pos;
                newPrev = pos;
                newLink[pos] = -1;
            }
            i = (int) link[i];
            prev = i;
        }
        this.link = newLink;
        this.last = newPrev;
        if (newPrev != -1) {
            newLink[newPrev] = newLink[newPrev] | 4294967295L;
        }
        this.f1616n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f1616n, this.f1617f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Double2LongLinkedOpenHashMap clone() {
        try {
            Double2LongLinkedOpenHashMap c = (Double2LongLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (double[]) this.key.clone();
            c.value = (long[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap, java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            while (Double.doubleToLongBits(this.key[i]) == 0) {
                i++;
            }
            h += HashCommon.double2int(this.key[i]) ^ HashCommon.long2int(this.value[i]);
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.long2int(this.value[this.f1616n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        double[] key = this.key;
        long[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeDouble(key[e]);
                s.writeLong(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1616n = HashCommon.arraySize(this.size, this.f1617f);
        this.maxFill = HashCommon.maxFill(this.f1616n, this.f1617f);
        this.mask = this.f1616n - 1;
        double[] key = new double[this.f1616n + 1];
        this.key = key;
        long[] value = new long[this.f1616n + 1];
        this.value = value;
        long[] link = new long[this.f1616n + 1];
        this.link = link;
        int prev = -1;
        this.last = -1;
        this.first = -1;
        int i = this.size;
        while (true) {
            i--;
            if (i == 0) {
                break;
            }
            double k = s.readDouble();
            long v = s.readLong();
            if (Double.doubleToLongBits(k) != 0) {
                int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(k));
                int i2 = this.mask;
                while (true) {
                    pos = mix & i2;
                    if (Double.doubleToLongBits(key[pos]) == 0) {
                        break;
                    }
                    mix = pos + 1;
                    i2 = this.mask;
                }
            } else {
                pos = this.f1616n;
                this.containsNullKey = true;
            }
            key[pos] = k;
            value[pos] = v;
            if (this.first != -1) {
                link[prev] = link[prev] ^ ((link[prev] ^ (((long) pos) & 4294967295L)) & 4294967295L);
                link[pos] = link[pos] ^ ((link[pos] ^ ((((long) prev) & 4294967295L) << 32)) & -4294967296L);
                prev = pos;
            } else {
                this.first = pos;
                prev = pos;
                link[pos] = link[pos] | -4294967296L;
            }
        }
        this.last = prev;
        if (prev != -1) {
            link[prev] = link[prev] | 4294967295L;
        }
    }

    private void checkTable() {
    }
}
