package p014it.unimi.dsi.fastutil.objects;

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
import java.util.function.LongConsumer;
import java.util.function.ToLongFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongListIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap;
import p014it.unimi.dsi.fastutil.objects.Object2LongMap;
import p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap.class */
public class Object2LongLinkedOpenCustomHashMap<K> extends AbstractObject2LongSortedMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient long[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected Hash.Strategy<? super K> strategy;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2589n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2590f;
    protected transient Object2LongSortedMap.FastSortedEntrySet<K> entries;
    protected transient ObjectSortedSet<K> keys;
    protected transient LongCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.computeLongIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public long computeLongIfPresent(K r1, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.computeLongIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.computeLongIfPresent(java.lang.Object, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.computeLong(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public long computeLong(K r1, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.computeLong(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.computeLong(java.lang.Object, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.merge(K, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public long merge(K r1, long r2, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> r4) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.merge(K, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.merge(java.lang.Object, long, java.util.function.BiFunction):long");
    }

    public Object2LongLinkedOpenCustomHashMap(int expected, float f, Hash.Strategy<? super K> strategy) {
        this.first = -1;
        this.last = -1;
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2590f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2589n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2589n - 1;
            this.maxFill = HashCommon.maxFill(this.f2589n, f);
            this.key = (K[]) new Object[this.f2589n + 1];
            this.value = new long[this.f2589n + 1];
            this.link = new long[this.f2589n + 1];
        }
    }

    public Object2LongLinkedOpenCustomHashMap(int expected, Hash.Strategy<? super K> strategy) {
        this(expected, 0.75f, strategy);
    }

    public Object2LongLinkedOpenCustomHashMap(Hash.Strategy<? super K> strategy) {
        this(16, 0.75f, strategy);
    }

    public Object2LongLinkedOpenCustomHashMap(Map<? extends K, ? extends Long> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2LongLinkedOpenCustomHashMap(Map<? extends K, ? extends Long> m, Hash.Strategy<? super K> strategy) {
        this(m, 0.75f, strategy);
    }

    public Object2LongLinkedOpenCustomHashMap(Object2LongMap<K> m, float f, Hash.Strategy<? super K> strategy) {
        this(m.size(), f, strategy);
        putAll(m);
    }

    public Object2LongLinkedOpenCustomHashMap(Object2LongMap<K> m, Hash.Strategy<? super K> strategy) {
        this((Object2LongMap) m, 0.75f, (Hash.Strategy) strategy);
    }

    public Object2LongLinkedOpenCustomHashMap(K[] k, long[] v, float f, Hash.Strategy<? super K> strategy) {
        this(k.length, f, strategy);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Object2LongLinkedOpenCustomHashMap<K>) k[i], v[i]);
        }
    }

    public Object2LongLinkedOpenCustomHashMap(K[] k, long[] v, Hash.Strategy<? super K> strategy) {
        this(k, v, 0.75f, strategy);
    }

    public Hash.Strategy<? super K> strategy() {
        return this.strategy;
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2590f);
        if (needed > this.f2589n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2590f)))));
        if (needed > this.f2589n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public long removeEntry(int pos) {
        long oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2589n > this.minN && this.size < this.maxFill / 4 && this.f2589n > 16) {
            rehash(this.f2589n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public long removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2589n] = null;
        long oldValue = this.value[this.f2589n];
        this.size--;
        fixPointers(this.f2589n);
        if (this.f2589n > this.minN && this.size < this.maxFill / 4 && this.f2589n > 16) {
            rehash(this.f2589n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Long> m) {
        if (((double) this.f2590f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.f2589n : -(this.f2589n + 1);
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

    private void insert(int pos, K k, long v) {
        if (pos == this.f2589n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2590f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunction
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
            return addToValue(this.f2589n, incr);
        } else {
            pos = this.f2589n;
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2590f));
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
            fixPointers(pos, pos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunction
    public long removeLong(Object k) {
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
        if (pos == this.f2589n) {
            this.containsNullKey = false;
            this.key[this.f2589n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2589n > this.minN && this.size < this.maxFill / 4 && this.f2589n > 16) {
            rehash(this.f2589n / 2);
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
        if (pos == this.f2589n) {
            this.containsNullKey = false;
            this.key[this.f2589n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2589n > this.minN && this.size < this.maxFill / 4 && this.f2589n > 16) {
            rehash(this.f2589n / 2);
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

    public long getAndMoveToFirst(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return this.defRetValue;
            }
            if (this.strategy.equals(k, curr2)) {
                moveIndexToFirst(pos);
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
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToFirst(this.f2589n);
            return this.value[this.f2589n];
        }
    }

    public long getAndMoveToLast(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return this.defRetValue;
            }
            if (this.strategy.equals(k, curr2)) {
                moveIndexToLast(pos);
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
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToLast(this.f2589n);
            return this.value[this.f2589n];
        }
    }

    public long putAndMoveToFirst(K k, long v) {
        int pos;
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    moveIndexToFirst(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                moveIndexToFirst(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToFirst(this.f2589n);
            return setValue(this.f2589n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2589n;
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
            rehash(HashCommon.arraySize(this.size, this.f2590f));
        }
        return this.defRetValue;
    }

    public long putAndMoveToLast(K k, long v) {
        int pos;
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    moveIndexToLast(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                moveIndexToLast(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToLast(this.f2589n);
            return setValue(this.f2589n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2589n;
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
            rehash(HashCommon.arraySize(this.size, this.f2590f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunction
    public long getLong(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2589n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap, p014it.unimi.dsi.fastutil.Function
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public boolean containsValue(long v) {
        long[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2589n] == v) {
            return true;
        }
        int i = this.f2589n;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunction
    public long getOrDefault(Object k, long defaultValue) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNullKey ? this.value[this.f2589n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public long putIfAbsent(K k, long v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public boolean remove(Object k, long v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2589n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public boolean replace(K k, long oldValue, long v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public long replace(K k, long v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        long oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public long computeIfAbsent(K key, Object2LongFunction<? super K> mappingFunction) {
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
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$MapEntry.class */
    public final class MapEntry implements Object2LongMap.Entry<K>, Map.Entry<K, Long>, ObjectLongPair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Object2LongLinkedOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Object2LongLinkedOpenCustomHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.Entry
        public long getLongValue() {
            return Object2LongLinkedOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectLongPair
        public long rightLong() {
            return Object2LongLinkedOpenCustomHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.Entry
        public long setValue(long v) {
            long oldValue = Object2LongLinkedOpenCustomHashMap.this.value[this.index];
            Object2LongLinkedOpenCustomHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectLongPair
        public ObjectLongPair<K> right(long v) {
            Object2LongLinkedOpenCustomHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getValue() {
            return Long.valueOf(Object2LongLinkedOpenCustomHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.Entry
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
            return Object2LongLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2LongLinkedOpenCustomHashMap.this.key[this.index], (Object) e.getKey()) && Object2LongLinkedOpenCustomHashMap.this.value[this.index] == e.getValue().longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Object2LongLinkedOpenCustomHashMap.this.strategy.hashCode((Object) Object2LongLinkedOpenCustomHashMap.this.key[this.index]) ^ HashCommon.long2int(Object2LongLinkedOpenCustomHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Object2LongLinkedOpenCustomHashMap.this.key[this.index] + "=>" + Object2LongLinkedOpenCustomHashMap.this.value[this.index];
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

    @Override // java.util.SortedMap
    public K firstKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
    public Object2LongSortedMap<K> tailMap(K from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
    public Object2LongSortedMap<K> headMap(K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
    public Object2LongSortedMap<K> subMap(K from, K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$MapIterator.class */
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
            this.next = Object2LongLinkedOpenCustomHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (Object2LongLinkedOpenCustomHashMap.this.strategy.equals(from, null)) {
                if (Object2LongLinkedOpenCustomHashMap.this.containsNullKey) {
                    this.next = (int) Object2LongLinkedOpenCustomHashMap.this.link[Object2LongLinkedOpenCustomHashMap.this.f2589n];
                    this.prev = Object2LongLinkedOpenCustomHashMap.this.f2589n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Object2LongLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2LongLinkedOpenCustomHashMap.this.key[Object2LongLinkedOpenCustomHashMap.this.last], from)) {
                this.prev = Object2LongLinkedOpenCustomHashMap.this.last;
                this.index = Object2LongLinkedOpenCustomHashMap.this.size;
            } else {
                int mix = HashCommon.mix(Object2LongLinkedOpenCustomHashMap.this.strategy.hashCode(from));
                int i = Object2LongLinkedOpenCustomHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Object2LongLinkedOpenCustomHashMap.this.key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Object2LongLinkedOpenCustomHashMap.this.strategy.equals((Object) Object2LongLinkedOpenCustomHashMap.this.key[pos], from)) {
                        this.next = (int) Object2LongLinkedOpenCustomHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Object2LongLinkedOpenCustomHashMap.this.mask;
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
                    this.index = Object2LongLinkedOpenCustomHashMap.this.size;
                } else {
                    int pos = Object2LongLinkedOpenCustomHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Object2LongLinkedOpenCustomHashMap.this.link[pos];
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
            this.next = (int) Object2LongLinkedOpenCustomHashMap.this.link[this.curr];
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
            this.prev = (int) (Object2LongLinkedOpenCustomHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Object2LongLinkedOpenCustomHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            K curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (Object2LongLinkedOpenCustomHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Object2LongLinkedOpenCustomHashMap.this.link[this.curr];
            }
            Object2LongLinkedOpenCustomHashMap.this.size--;
            if (this.prev == -1) {
                Object2LongLinkedOpenCustomHashMap.this.first = this.next;
            } else {
                long[] jArr = Object2LongLinkedOpenCustomHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Object2LongLinkedOpenCustomHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Object2LongLinkedOpenCustomHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Object2LongLinkedOpenCustomHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Object2LongLinkedOpenCustomHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Object2LongLinkedOpenCustomHashMap.this.f2589n) {
                Object2LongLinkedOpenCustomHashMap.this.containsNullKey = false;
                Object2LongLinkedOpenCustomHashMap.this.key[Object2LongLinkedOpenCustomHashMap.this.f2589n] = null;
                return;
            }
            K[] key = Object2LongLinkedOpenCustomHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Object2LongLinkedOpenCustomHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(Object2LongLinkedOpenCustomHashMap.this.strategy.hashCode(curr)) & Object2LongLinkedOpenCustomHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Object2LongLinkedOpenCustomHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Object2LongLinkedOpenCustomHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Object2LongLinkedOpenCustomHashMap.this.value[pos] = Object2LongLinkedOpenCustomHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Object2LongLinkedOpenCustomHashMap.this.fixPointers(pos, pos);
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

        public void set(Object2LongMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Object2LongMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$EntryIterator.class */
    public final class EntryIterator extends Object2LongLinkedOpenCustomHashMap<K>.MapIterator implements ObjectListIterator<Object2LongMap.Entry<K>> {
        private Object2LongLinkedOpenCustomHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2LongMap.Entry) ((Object2LongMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2LongMap.Entry) ((Object2LongMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(K from) {
            super(from);
        }

        final void acceptOnIndex(Consumer<? super Object2LongMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2LongLinkedOpenCustomHashMap<K>.MapEntry next() {
            Object2LongLinkedOpenCustomHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2LongLinkedOpenCustomHashMap<K>.MapEntry previous() {
            Object2LongLinkedOpenCustomHashMap<K>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Object2LongLinkedOpenCustomHashMap<K>.MapIterator implements ObjectListIterator<Object2LongMap.Entry<K>> {
        final Object2LongLinkedOpenCustomHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2LongMap.Entry) ((Object2LongMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2LongMap.Entry) ((Object2LongMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(K from) {
            super(from);
            this.entry = new MapEntry();
        }

        final void acceptOnIndex(Consumer<? super Object2LongMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2LongLinkedOpenCustomHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2LongLinkedOpenCustomHashMap<K>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Object2LongMap.Entry<K>> implements Object2LongSortedMap.FastSortedEntrySet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Object2LongMap.Entry) ((Object2LongMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Object2LongMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2LongMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2LongLinkedOpenCustomHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Object2LongMap.Entry<K>> comparator() {
            return null;
        }

        public ObjectSortedSet<Object2LongMap.Entry<K>> subSet(Object2LongMap.Entry<K> fromElement, Object2LongMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2LongMap.Entry<K>> headSet(Object2LongMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Object2LongMap.Entry<K>> tailSet(Object2LongMap.Entry<K> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Object2LongMap.Entry<K> first() {
            if (Object2LongLinkedOpenCustomHashMap.this.size != 0) {
                return new MapEntry(Object2LongLinkedOpenCustomHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Object2LongMap.Entry<K> last() {
            if (Object2LongLinkedOpenCustomHashMap.this.size != 0) {
                return new MapEntry(Object2LongLinkedOpenCustomHashMap.this.last);
            }
            throw new NoSuchElementException();
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
            if (Object2LongLinkedOpenCustomHashMap.this.strategy.equals(key, null)) {
                return Object2LongLinkedOpenCustomHashMap.this.containsNullKey && Object2LongLinkedOpenCustomHashMap.this.value[Object2LongLinkedOpenCustomHashMap.this.f2589n] == v;
            }
            K[] key2 = Object2LongLinkedOpenCustomHashMap.this.key;
            int mix = HashCommon.mix(Object2LongLinkedOpenCustomHashMap.this.strategy.hashCode(key)) & Object2LongLinkedOpenCustomHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (Object2LongLinkedOpenCustomHashMap.this.strategy.equals(key, curr2)) {
                return Object2LongLinkedOpenCustomHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Object2LongLinkedOpenCustomHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (!Object2LongLinkedOpenCustomHashMap.this.strategy.equals(key, curr));
            return Object2LongLinkedOpenCustomHashMap.this.value[pos] == v;
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
            if (!Object2LongLinkedOpenCustomHashMap.this.strategy.equals(key, null)) {
                K[] key2 = Object2LongLinkedOpenCustomHashMap.this.key;
                int mix = HashCommon.mix(Object2LongLinkedOpenCustomHashMap.this.strategy.hashCode(key)) & Object2LongLinkedOpenCustomHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (!Object2LongLinkedOpenCustomHashMap.this.strategy.equals(curr, key)) {
                    while (true) {
                        int i = (pos + 1) & Object2LongLinkedOpenCustomHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (Object2LongLinkedOpenCustomHashMap.this.strategy.equals(curr2, key) && Object2LongLinkedOpenCustomHashMap.this.value[pos] == v) {
                            Object2LongLinkedOpenCustomHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Object2LongLinkedOpenCustomHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Object2LongLinkedOpenCustomHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Object2LongLinkedOpenCustomHashMap.this.containsNullKey || Object2LongLinkedOpenCustomHashMap.this.value[Object2LongLinkedOpenCustomHashMap.this.f2589n] != v) {
                return false;
            } else {
                Object2LongLinkedOpenCustomHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2LongLinkedOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2LongLinkedOpenCustomHashMap.this.clear();
        }

        public ObjectListIterator<Object2LongMap.Entry<K>> iterator(Object2LongMap.Entry<K> from) {
            return new EntryIterator(from.getKey());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.objects.Object2LongMap.FastEntrySet
        public ObjectListIterator<Object2LongMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap.FastSortedEntrySet
        public ObjectListIterator<Object2LongMap.Entry<K>> fastIterator(Object2LongMap.Entry<K> from) {
            return new FastEntryIterator(from.getKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Object2LongMap.Entry<K>> consumer) {
            int i = Object2LongLinkedOpenCustomHashMap.this.size;
            int next = Object2LongLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2LongLinkedOpenCustomHashMap.this.link[next];
                    consumer.accept(new AbstractObject2LongMap.BasicEntry(Object2LongLinkedOpenCustomHashMap.this.key[next], Object2LongLinkedOpenCustomHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Object2LongMap.Entry<K>> consumer) {
            AbstractObject2LongMap.BasicEntry<K> entry = new AbstractObject2LongMap.BasicEntry<>();
            int i = Object2LongLinkedOpenCustomHashMap.this.size;
            int next = Object2LongLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2LongLinkedOpenCustomHashMap.this.link[next];
                    entry.key = Object2LongLinkedOpenCustomHashMap.this.key[next];
                    entry.value = Object2LongLinkedOpenCustomHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
    public Object2LongSortedMap.FastSortedEntrySet<K> object2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$KeyIterator.class */
    public final class KeyIterator extends Object2LongLinkedOpenCustomHashMap<K>.MapIterator implements ObjectListIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((KeyIterator) consumer);
        }

        public KeyIterator(K k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return Object2LongLinkedOpenCustomHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Object2LongLinkedOpenCustomHashMap.this.key[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return Object2LongLinkedOpenCustomHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$KeySet.class */
    public final class KeySet extends AbstractObjectSortedSet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectListIterator<K> iterator(K from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectListIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2LongLinkedOpenCustomHashMap.this), 81);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            int i = Object2LongLinkedOpenCustomHashMap.this.size;
            int next = Object2LongLinkedOpenCustomHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Object2LongLinkedOpenCustomHashMap.this.link[next];
                    consumer.accept((Object) Object2LongLinkedOpenCustomHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Object2LongLinkedOpenCustomHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Object2LongLinkedOpenCustomHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Object2LongLinkedOpenCustomHashMap.this.size;
            Object2LongLinkedOpenCustomHashMap.this.removeLong(k);
            return Object2LongLinkedOpenCustomHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Object2LongLinkedOpenCustomHashMap.this.clear();
        }

        @Override // java.util.SortedSet
        public K first() {
            if (Object2LongLinkedOpenCustomHashMap.this.size != 0) {
                return Object2LongLinkedOpenCustomHashMap.this.key[Object2LongLinkedOpenCustomHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            if (Object2LongLinkedOpenCustomHashMap.this.size != 0) {
                return Object2LongLinkedOpenCustomHashMap.this.key[Object2LongLinkedOpenCustomHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2LongSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongLinkedOpenCustomHashMap$ValueIterator.class */
    public final class ValueIterator extends Object2LongLinkedOpenCustomHashMap<K>.MapIterator implements LongListIterator {
        @Override // java.util.PrimitiveIterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((ValueIterator) longConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return Object2LongLinkedOpenCustomHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Object2LongLinkedOpenCustomHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Object2LongLinkedOpenCustomHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2LongSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
    public LongCollection values() {
        if (this.values == null) {
            this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongSpliterator spliterator() {
                    return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(Object2LongLinkedOpenCustomHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
                public void forEach(LongConsumer consumer) {
                    int i = Object2LongLinkedOpenCustomHashMap.this.size;
                    int next = Object2LongLinkedOpenCustomHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Object2LongLinkedOpenCustomHashMap.this.link[next];
                            consumer.accept(Object2LongLinkedOpenCustomHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2LongLinkedOpenCustomHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                public boolean contains(long v) {
                    return Object2LongLinkedOpenCustomHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2LongLinkedOpenCustomHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2590f)));
        if (l >= this.f2589n || this.size > HashCommon.maxFill(l, this.f2590f)) {
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
        K[] key = this.key;
        long[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
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
            if (!this.strategy.equals(key[i], null)) {
                int mix = HashCommon.mix(this.strategy.hashCode(key[i]));
                while (true) {
                    pos = mix & mask;
                    if (newKey[pos] == null) {
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
        this.f2589n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2589n, this.f2590f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Object2LongLinkedOpenCustomHashMap<K> clone() {
        try {
            Object2LongLinkedOpenCustomHashMap<K> c = (Object2LongLinkedOpenCustomHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (long[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap, java.lang.Object, java.util.Map
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
            t ^= HashCommon.long2int(this.value[i]);
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.long2int(this.value[this.f2589n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        long[] value = this.value;
        Object2LongLinkedOpenCustomHashMap<K>.EntryIterator i = new EntryIterator();
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
    /* JADX DEBUG: Multi-variable search result rejected for r0v42, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2589n = HashCommon.arraySize(this.size, this.f2590f);
        this.maxFill = HashCommon.maxFill(this.f2589n, this.f2590f);
        this.mask = this.f2589n - 1;
        K[] key = (K[]) new Object[this.f2589n + 1];
        this.key = key;
        long[] value = new long[this.f2589n + 1];
        this.value = value;
        long[] link = new long[this.f2589n + 1];
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
            Object readObject = s.readObject();
            long v = s.readLong();
            if (!this.strategy.equals(readObject, null)) {
                int mix = HashCommon.mix(this.strategy.hashCode(readObject));
                int i2 = this.mask;
                while (true) {
                    pos = mix & i2;
                    if (key[pos] == 0) {
                        break;
                    }
                    mix = pos + 1;
                    i2 = this.mask;
                }
            } else {
                pos = this.f2589n;
                this.containsNullKey = true;
            }
            key[pos] = readObject;
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
