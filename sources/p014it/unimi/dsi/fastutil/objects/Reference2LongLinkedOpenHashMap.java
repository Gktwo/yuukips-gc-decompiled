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
import p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap;
import p014it.unimi.dsi.fastutil.objects.Reference2LongMap;
import p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap.class */
public class Reference2LongLinkedOpenHashMap<K> extends AbstractReference2LongSortedMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient long[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2755n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2756f;
    protected transient Reference2LongSortedMap.FastSortedEntrySet<K> entries;
    protected transient ReferenceSortedSet<K> keys;
    protected transient LongCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.computeLongIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap.class
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
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.computeLongIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.computeLongIfPresent(java.lang.Object, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.computeLong(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap.class
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
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.computeLong(K, java.util.function.BiFunction<? super K, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.computeLong(java.lang.Object, java.util.function.BiFunction):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.merge(K, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap.class
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
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.merge(K, long, java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long>):long, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.merge(java.lang.Object, long, java.util.function.BiFunction):long");
    }

    public Reference2LongLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2756f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2755n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2755n - 1;
            this.maxFill = HashCommon.maxFill(this.f2755n, f);
            this.key = (K[]) new Object[this.f2755n + 1];
            this.value = new long[this.f2755n + 1];
            this.link = new long[this.f2755n + 1];
        }
    }

    public Reference2LongLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Reference2LongLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Reference2LongLinkedOpenHashMap(Map<? extends K, ? extends Long> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2LongLinkedOpenHashMap(Map<? extends K, ? extends Long> m) {
        this(m, 0.75f);
    }

    public Reference2LongLinkedOpenHashMap(Reference2LongMap<K> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2LongLinkedOpenHashMap(Reference2LongMap<K> m) {
        this((Reference2LongMap) m, 0.75f);
    }

    public Reference2LongLinkedOpenHashMap(K[] k, long[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Reference2LongLinkedOpenHashMap<K>) k[i], v[i]);
        }
    }

    public Reference2LongLinkedOpenHashMap(K[] k, long[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2756f);
        if (needed > this.f2755n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2756f)))));
        if (needed > this.f2755n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public long removeEntry(int pos) {
        long oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2755n > this.minN && this.size < this.maxFill / 4 && this.f2755n > 16) {
            rehash(this.f2755n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public long removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2755n] = null;
        long oldValue = this.value[this.f2755n];
        this.size--;
        fixPointers(this.f2755n);
        if (this.f2755n > this.minN && this.size < this.maxFill / 4 && this.f2755n > 16) {
            rehash(this.f2755n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Long> m) {
        if (((double) this.f2756f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.f2755n : -(this.f2755n + 1);
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
        if (pos == this.f2755n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2756f));
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
            return addToValue(this.f2755n, incr);
        } else {
            pos = this.f2755n;
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2756f));
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
            fixPointers(pos, pos);
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
        if (pos == this.f2755n) {
            this.containsNullKey = false;
            this.key[this.f2755n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2755n > this.minN && this.size < this.maxFill / 4 && this.f2755n > 16) {
            rehash(this.f2755n / 2);
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
        if (pos == this.f2755n) {
            this.containsNullKey = false;
            this.key[this.f2755n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2755n > this.minN && this.size < this.maxFill / 4 && this.f2755n > 16) {
            rehash(this.f2755n / 2);
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
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return this.defRetValue;
            }
            if (k == curr2) {
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
            } while (k != curr);
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToFirst(this.f2755n);
            return this.value[this.f2755n];
        }
    }

    public long getAndMoveToLast(K k) {
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return this.defRetValue;
            }
            if (k == curr2) {
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
            } while (k != curr);
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToLast(this.f2755n);
            return this.value[this.f2755n];
        }
    }

    public long putAndMoveToFirst(K k, long v) {
        int pos;
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (curr2 == k) {
                    moveIndexToFirst(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (curr != k);
                moveIndexToFirst(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToFirst(this.f2755n);
            return setValue(this.f2755n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2755n;
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
            rehash(HashCommon.arraySize(this.size, this.f2756f));
        }
        return this.defRetValue;
    }

    public long putAndMoveToLast(K k, long v) {
        int pos;
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (curr2 == k) {
                    moveIndexToLast(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (curr != k);
                moveIndexToLast(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToLast(this.f2755n);
            return setValue(this.f2755n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2755n;
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
            rehash(HashCommon.arraySize(this.size, this.f2756f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    public long getLong(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2755n] : this.defRetValue;
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
        if (this.containsNullKey && value[this.f2755n] == v) {
            return true;
        }
        int i = this.f2755n;
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
            return this.containsNullKey ? this.value[this.f2755n] : defaultValue;
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
        } else if (!this.containsNullKey || v != this.value[this.f2755n]) {
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
            this.last = -1;
            this.first = -1;
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Reference2LongMap.Entry<K>, Map.Entry<K, Long>, ReferenceLongPair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Reference2LongLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Reference2LongLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.Entry
        public long getLongValue() {
            return Reference2LongLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceLongPair
        public long rightLong() {
            return Reference2LongLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.Entry
        public long setValue(long v) {
            long oldValue = Reference2LongLinkedOpenHashMap.this.value[this.index];
            Reference2LongLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceLongPair
        public ReferenceLongPair<K> right(long v) {
            Reference2LongLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.Entry, java.util.Map.Entry
        @Deprecated
        public Long getValue() {
            return Long.valueOf(Reference2LongLinkedOpenHashMap.this.value[this.index]);
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
            return Reference2LongLinkedOpenHashMap.this.key[this.index] == e.getKey() && Reference2LongLinkedOpenHashMap.this.value[this.index] == e.getValue().longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(Reference2LongLinkedOpenHashMap.this.key[this.index]) ^ HashCommon.long2int(Reference2LongLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Reference2LongLinkedOpenHashMap.this.key[this.index] + "=>" + Reference2LongLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
    public Reference2LongSortedMap<K> tailMap(K from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
    public Reference2LongSortedMap<K> headMap(K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
    public Reference2LongSortedMap<K> subMap(K from, K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$MapIterator.class */
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
            this.next = Reference2LongLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == null) {
                if (Reference2LongLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Reference2LongLinkedOpenHashMap.this.link[Reference2LongLinkedOpenHashMap.this.f2755n];
                    this.prev = Reference2LongLinkedOpenHashMap.this.f2755n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Reference2LongLinkedOpenHashMap.this.key[Reference2LongLinkedOpenHashMap.this.last] == from) {
                this.prev = Reference2LongLinkedOpenHashMap.this.last;
                this.index = Reference2LongLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix(System.identityHashCode(from));
                int i = Reference2LongLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Reference2LongLinkedOpenHashMap.this.key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Reference2LongLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Reference2LongLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Reference2LongLinkedOpenHashMap.this.mask;
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
                    this.index = Reference2LongLinkedOpenHashMap.this.size;
                } else {
                    int pos = Reference2LongLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Reference2LongLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Reference2LongLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Reference2LongLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Reference2LongLinkedOpenHashMap.this.link[this.curr];
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
                this.prev = (int) (Reference2LongLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Reference2LongLinkedOpenHashMap.this.link[this.curr];
            }
            Reference2LongLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Reference2LongLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Reference2LongLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Reference2LongLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Reference2LongLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Reference2LongLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Reference2LongLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Reference2LongLinkedOpenHashMap.this.f2755n) {
                Reference2LongLinkedOpenHashMap.this.containsNullKey = false;
                Reference2LongLinkedOpenHashMap.this.key[Reference2LongLinkedOpenHashMap.this.f2755n] = null;
                return;
            }
            K[] key = Reference2LongLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Reference2LongLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(System.identityHashCode(curr)) & Reference2LongLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Reference2LongLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Reference2LongLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Reference2LongLinkedOpenHashMap.this.value[pos] = Reference2LongLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Reference2LongLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Reference2LongMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Reference2LongMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Reference2LongLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<Reference2LongMap.Entry<K>> {
        private Reference2LongLinkedOpenHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Reference2LongMap.Entry) ((Reference2LongMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Reference2LongMap.Entry) ((Reference2LongMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Reference2LongMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Reference2LongLinkedOpenHashMap<K>.MapEntry next() {
            Reference2LongLinkedOpenHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Reference2LongLinkedOpenHashMap<K>.MapEntry previous() {
            Reference2LongLinkedOpenHashMap<K>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Reference2LongLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<Reference2LongMap.Entry<K>> {
        final Reference2LongLinkedOpenHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Reference2LongMap.Entry) ((Reference2LongMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Reference2LongMap.Entry) ((Reference2LongMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Reference2LongMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Reference2LongLinkedOpenHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Reference2LongLinkedOpenHashMap<K>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Reference2LongMap.Entry<K>> implements Reference2LongSortedMap.FastSortedEntrySet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Reference2LongMap.Entry) ((Reference2LongMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Reference2LongMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2LongMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2LongLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Reference2LongMap.Entry<K>> comparator() {
            return null;
        }

        public ObjectSortedSet<Reference2LongMap.Entry<K>> subSet(Reference2LongMap.Entry<K> fromElement, Reference2LongMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Reference2LongMap.Entry<K>> headSet(Reference2LongMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Reference2LongMap.Entry<K>> tailSet(Reference2LongMap.Entry<K> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Reference2LongMap.Entry<K> first() {
            if (Reference2LongLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Reference2LongLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Reference2LongMap.Entry<K> last() {
            if (Reference2LongLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Reference2LongLinkedOpenHashMap.this.last);
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
            if (key == null) {
                return Reference2LongLinkedOpenHashMap.this.containsNullKey && Reference2LongLinkedOpenHashMap.this.value[Reference2LongLinkedOpenHashMap.this.f2755n] == v;
            }
            K[] key2 = Reference2LongLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2LongLinkedOpenHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (key == curr2) {
                return Reference2LongLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Reference2LongLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (key != curr);
            return Reference2LongLinkedOpenHashMap.this.value[pos] == v;
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
                K[] key2 = Reference2LongLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2LongLinkedOpenHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (curr != key) {
                    while (true) {
                        int i = (pos + 1) & Reference2LongLinkedOpenHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (curr2 == key && Reference2LongLinkedOpenHashMap.this.value[pos] == v) {
                            Reference2LongLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Reference2LongLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Reference2LongLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Reference2LongLinkedOpenHashMap.this.containsNullKey || Reference2LongLinkedOpenHashMap.this.value[Reference2LongLinkedOpenHashMap.this.f2755n] != v) {
                return false;
            } else {
                Reference2LongLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2LongLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2LongLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Reference2LongMap.Entry<K>> iterator(Reference2LongMap.Entry<K> from) {
            return new EntryIterator(from.getKey());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.objects.Reference2LongMap.FastEntrySet
        public ObjectListIterator<Reference2LongMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap.FastSortedEntrySet
        public ObjectListIterator<Reference2LongMap.Entry<K>> fastIterator(Reference2LongMap.Entry<K> from) {
            return new FastEntryIterator(from.getKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2LongMap.Entry<K>> consumer) {
            int i = Reference2LongLinkedOpenHashMap.this.size;
            int next = Reference2LongLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2LongLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractReference2LongMap.BasicEntry(Reference2LongLinkedOpenHashMap.this.key[next], Reference2LongLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2LongMap.Entry<K>> consumer) {
            AbstractReference2LongMap.BasicEntry<K> entry = new AbstractReference2LongMap.BasicEntry<>();
            int i = Reference2LongLinkedOpenHashMap.this.size;
            int next = Reference2LongLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2LongLinkedOpenHashMap.this.link[next];
                    entry.key = Reference2LongLinkedOpenHashMap.this.key[next];
                    entry.value = Reference2LongLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap
    public Reference2LongSortedMap.FastSortedEntrySet<K> reference2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Reference2LongLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.MapIterator
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
            return Reference2LongLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Reference2LongLinkedOpenHashMap.this.key[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return Reference2LongLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractReferenceSortedSet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet
        public ObjectListIterator<K> iterator(K from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
        public ObjectListIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2LongLinkedOpenHashMap.this), 81);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            int i = Reference2LongLinkedOpenHashMap.this.size;
            int next = Reference2LongLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2LongLinkedOpenHashMap.this.link[next];
                    consumer.accept((Object) Reference2LongLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2LongLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2LongLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Reference2LongLinkedOpenHashMap.this.size;
            Reference2LongLinkedOpenHashMap.this.removeLong(k);
            return Reference2LongLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2LongLinkedOpenHashMap.this.clear();
        }

        @Override // java.util.SortedSet
        public K first() {
            if (Reference2LongLinkedOpenHashMap.this.size != 0) {
                return Reference2LongLinkedOpenHashMap.this.key[Reference2LongLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            if (Reference2LongLinkedOpenHashMap.this.size != 0) {
                return Reference2LongLinkedOpenHashMap.this.key[Reference2LongLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> tailSet(K from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> headSet(K to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet, java.util.SortedSet
        public ReferenceSortedSet<K> subSet(K from, K to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
    public ReferenceSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Reference2LongLinkedOpenHashMap<K>.MapIterator implements LongListIterator {
        @Override // java.util.PrimitiveIterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            forEachRemaining((ValueIterator) longConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return Reference2LongLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(LongConsumer action, int index) {
            action.accept(Reference2LongLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return Reference2LongLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
    public LongCollection values() {
        if (this.values == null) {
            this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.objects.Reference2LongLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongSpliterator spliterator() {
                    return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2LongLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.longs.LongIterable
                public void forEach(LongConsumer consumer) {
                    int i = Reference2LongLinkedOpenHashMap.this.size;
                    int next = Reference2LongLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Reference2LongLinkedOpenHashMap.this.link[next];
                            consumer.accept(Reference2LongLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Reference2LongLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                public boolean contains(long v) {
                    return Reference2LongLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Reference2LongLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2756f)));
        if (l >= this.f2755n || this.size > HashCommon.maxFill(l, this.f2756f)) {
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
            if (key[i] != null) {
                int mix = HashCommon.mix(System.identityHashCode(key[i]));
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
        this.f2755n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2755n, this.f2756f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Reference2LongLinkedOpenHashMap<K> clone() {
        try {
            Reference2LongLinkedOpenHashMap<K> c = (Reference2LongLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (long[]) this.value.clone();
            c.link = (long[]) this.link.clone();
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
            h += HashCommon.long2int(this.value[this.f2755n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        long[] value = this.value;
        Reference2LongLinkedOpenHashMap<K>.EntryIterator i = new EntryIterator();
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
    /* JADX DEBUG: Multi-variable search result rejected for r0v39, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2755n = HashCommon.arraySize(this.size, this.f2756f);
        this.maxFill = HashCommon.maxFill(this.f2755n, this.f2756f);
        this.mask = this.f2755n - 1;
        K[] key = (K[]) new Object[this.f2755n + 1];
        this.key = key;
        long[] value = new long[this.f2755n + 1];
        this.value = value;
        long[] link = new long[this.f2755n + 1];
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
            if (readObject != null) {
                int mix = HashCommon.mix(System.identityHashCode(readObject));
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
                pos = this.f2755n;
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
