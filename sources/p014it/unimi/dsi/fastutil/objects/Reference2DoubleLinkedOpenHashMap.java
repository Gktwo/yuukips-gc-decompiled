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
import java.util.function.DoubleConsumer;
import java.util.function.ToDoubleFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleListIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap.class */
public class Reference2DoubleLinkedOpenHashMap<K> extends AbstractReference2DoubleSortedMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient double[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2725n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2726f;
    protected transient Reference2DoubleSortedMap.FastSortedEntrySet<K> entries;
    protected transient ReferenceSortedSet<K> keys;
    protected transient DoubleCollection values;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.computeDoubleIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public double computeDoubleIfPresent(K r1, java.util.function.BiFunction<? super K, ? super java.lang.Double, ? extends java.lang.Double> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.computeDoubleIfPresent(K, java.util.function.BiFunction<? super K, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.computeDoubleIfPresent(java.lang.Object, java.util.function.BiFunction):double");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.computeDouble(K, java.util.function.BiFunction<? super K, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public double computeDouble(K r1, java.util.function.BiFunction<? super K, ? super java.lang.Double, ? extends java.lang.Double> r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.computeDouble(K, java.util.function.BiFunction<? super K, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.computeDouble(java.lang.Object, java.util.function.BiFunction):double");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.merge(K, double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap.class
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
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public double merge(K r1, double r2, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Double, ? extends java.lang.Double> r4) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.merge(K, double, java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Double, ? extends java.lang.Double>):double, file: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.merge(java.lang.Object, double, java.util.function.BiFunction):double");
    }

    public Reference2DoubleLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2726f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2725n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2725n - 1;
            this.maxFill = HashCommon.maxFill(this.f2725n, f);
            this.key = (K[]) new Object[this.f2725n + 1];
            this.value = new double[this.f2725n + 1];
            this.link = new long[this.f2725n + 1];
        }
    }

    public Reference2DoubleLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Reference2DoubleLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Reference2DoubleLinkedOpenHashMap(Map<? extends K, ? extends Double> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2DoubleLinkedOpenHashMap(Map<? extends K, ? extends Double> m) {
        this(m, 0.75f);
    }

    public Reference2DoubleLinkedOpenHashMap(Reference2DoubleMap<K> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2DoubleLinkedOpenHashMap(Reference2DoubleMap<K> m) {
        this((Reference2DoubleMap) m, 0.75f);
    }

    public Reference2DoubleLinkedOpenHashMap(K[] k, double[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Reference2DoubleLinkedOpenHashMap<K>) k[i], v[i]);
        }
    }

    public Reference2DoubleLinkedOpenHashMap(K[] k, double[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2726f);
        if (needed > this.f2725n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2726f)))));
        if (needed > this.f2725n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public double removeEntry(int pos) {
        double oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2725n > this.minN && this.size < this.maxFill / 4 && this.f2725n > 16) {
            rehash(this.f2725n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public double removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2725n] = null;
        double oldValue = this.value[this.f2725n];
        this.size--;
        fixPointers(this.f2725n);
        if (this.f2725n > this.minN && this.size < this.maxFill / 4 && this.f2725n > 16) {
            rehash(this.f2725n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Double> m) {
        if (((double) this.f2726f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.f2725n : -(this.f2725n + 1);
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

    private void insert(int pos, K k, double v) {
        if (pos == this.f2725n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2726f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
    public double put(K k, double v) {
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

    public double addTo(K k, double incr) {
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
            return addToValue(this.f2725n, incr);
        } else {
            pos = this.f2725n;
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2726f));
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
    public double removeDouble(Object k) {
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

    private double setValue(int pos, double v) {
        double oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public double removeFirstDouble() {
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
        double v = this.value[pos];
        if (pos == this.f2725n) {
            this.containsNullKey = false;
            this.key[this.f2725n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2725n > this.minN && this.size < this.maxFill / 4 && this.f2725n > 16) {
            rehash(this.f2725n / 2);
        }
        return v;
    }

    public double removeLastDouble() {
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
        double v = this.value[pos];
        if (pos == this.f2725n) {
            this.containsNullKey = false;
            this.key[this.f2725n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2725n > this.minN && this.size < this.maxFill / 4 && this.f2725n > 16) {
            rehash(this.f2725n / 2);
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

    public double getAndMoveToFirst(K k) {
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
            moveIndexToFirst(this.f2725n);
            return this.value[this.f2725n];
        }
    }

    public double getAndMoveToLast(K k) {
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
            moveIndexToLast(this.f2725n);
            return this.value[this.f2725n];
        }
    }

    public double putAndMoveToFirst(K k, double v) {
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
            moveIndexToFirst(this.f2725n);
            return setValue(this.f2725n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2725n;
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
            rehash(HashCommon.arraySize(this.size, this.f2726f));
        }
        return this.defRetValue;
    }

    public double putAndMoveToLast(K k, double v) {
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
            moveIndexToLast(this.f2725n);
            return setValue(this.f2725n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2725n;
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
            rehash(HashCommon.arraySize(this.size, this.f2726f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
    public double getDouble(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2725n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, p014it.unimi.dsi.fastutil.Function
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public boolean containsValue(double v) {
        double[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && Double.doubleToLongBits(value[this.f2725n]) == Double.doubleToLongBits(v)) {
            return true;
        }
        int i = this.f2725n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != null && Double.doubleToLongBits(value[i]) == Double.doubleToLongBits(v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
    public double getOrDefault(Object k, double defaultValue) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2725n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public double putIfAbsent(K k, double v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public boolean remove(Object k, double v) {
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            int pos = mix;
            K curr = key[mix];
            if (curr == null) {
                return false;
            }
            if (k == curr && Double.doubleToLongBits(v) == Double.doubleToLongBits(this.value[pos])) {
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
                if (k == curr2 && Double.doubleToLongBits(v) == Double.doubleToLongBits(this.value[pos])) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || Double.doubleToLongBits(v) != Double.doubleToLongBits(this.value[this.f2725n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public boolean replace(K k, double oldValue, double v) {
        int pos = find(k);
        if (pos < 0 || Double.doubleToLongBits(oldValue) != Double.doubleToLongBits(this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public double replace(K k, double v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        double oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public double computeIfAbsent(K k, ToDoubleFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        double newValue = mappingFunction.applyAsDouble(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public double computeIfAbsent(K key, Reference2DoubleFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        double newValue = mappingFunction.getDouble(key);
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Reference2DoubleMap.Entry<K>, Map.Entry<K, Double>, ReferenceDoublePair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Reference2DoubleLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Reference2DoubleLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.Entry
        public double getDoubleValue() {
            return Reference2DoubleLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceDoublePair
        public double rightDouble() {
            return Reference2DoubleLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.Entry
        public double setValue(double v) {
            double oldValue = Reference2DoubleLinkedOpenHashMap.this.value[this.index];
            Reference2DoubleLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceDoublePair
        public ReferenceDoublePair<K> right(double v) {
            Reference2DoubleLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.Entry, java.util.Map.Entry
        @Deprecated
        public Double getValue() {
            return Double.valueOf(Reference2DoubleLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.Entry
        @Deprecated
        public Double setValue(Double v) {
            return Double.valueOf(setValue(v.doubleValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Double> e = (Map.Entry) o;
            return Reference2DoubleLinkedOpenHashMap.this.key[this.index] == e.getKey() && Double.doubleToLongBits(Reference2DoubleLinkedOpenHashMap.this.value[this.index]) == Double.doubleToLongBits(e.getValue().doubleValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(Reference2DoubleLinkedOpenHashMap.this.key[this.index]) ^ HashCommon.double2int(Reference2DoubleLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Reference2DoubleLinkedOpenHashMap.this.key[this.index] + "=>" + Reference2DoubleLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
    public Reference2DoubleSortedMap<K> tailMap(K from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
    public Reference2DoubleSortedMap<K> headMap(K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
    public Reference2DoubleSortedMap<K> subMap(K from, K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$MapIterator.class */
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
            this.next = Reference2DoubleLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == null) {
                if (Reference2DoubleLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Reference2DoubleLinkedOpenHashMap.this.link[Reference2DoubleLinkedOpenHashMap.this.f2725n];
                    this.prev = Reference2DoubleLinkedOpenHashMap.this.f2725n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Reference2DoubleLinkedOpenHashMap.this.key[Reference2DoubleLinkedOpenHashMap.this.last] == from) {
                this.prev = Reference2DoubleLinkedOpenHashMap.this.last;
                this.index = Reference2DoubleLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix(System.identityHashCode(from));
                int i = Reference2DoubleLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Reference2DoubleLinkedOpenHashMap.this.key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Reference2DoubleLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Reference2DoubleLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Reference2DoubleLinkedOpenHashMap.this.mask;
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
                    this.index = Reference2DoubleLinkedOpenHashMap.this.size;
                } else {
                    int pos = Reference2DoubleLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Reference2DoubleLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Reference2DoubleLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Reference2DoubleLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Reference2DoubleLinkedOpenHashMap.this.link[this.curr];
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
                this.prev = (int) (Reference2DoubleLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Reference2DoubleLinkedOpenHashMap.this.link[this.curr];
            }
            Reference2DoubleLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Reference2DoubleLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Reference2DoubleLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Reference2DoubleLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Reference2DoubleLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Reference2DoubleLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Reference2DoubleLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Reference2DoubleLinkedOpenHashMap.this.f2725n) {
                Reference2DoubleLinkedOpenHashMap.this.containsNullKey = false;
                Reference2DoubleLinkedOpenHashMap.this.key[Reference2DoubleLinkedOpenHashMap.this.f2725n] = null;
                return;
            }
            K[] key = Reference2DoubleLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Reference2DoubleLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(System.identityHashCode(curr)) & Reference2DoubleLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Reference2DoubleLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Reference2DoubleLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Reference2DoubleLinkedOpenHashMap.this.value[pos] = Reference2DoubleLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Reference2DoubleLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Reference2DoubleMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Reference2DoubleMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Reference2DoubleLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<Reference2DoubleMap.Entry<K>> {
        private Reference2DoubleLinkedOpenHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Reference2DoubleMap.Entry) ((Reference2DoubleMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Reference2DoubleMap.Entry) ((Reference2DoubleMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Reference2DoubleMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Reference2DoubleLinkedOpenHashMap<K>.MapEntry next() {
            Reference2DoubleLinkedOpenHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Reference2DoubleLinkedOpenHashMap<K>.MapEntry previous() {
            Reference2DoubleLinkedOpenHashMap<K>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Reference2DoubleLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<Reference2DoubleMap.Entry<K>> {
        final Reference2DoubleLinkedOpenHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Reference2DoubleMap.Entry) ((Reference2DoubleMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Reference2DoubleMap.Entry) ((Reference2DoubleMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Reference2DoubleMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Reference2DoubleLinkedOpenHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Reference2DoubleLinkedOpenHashMap<K>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Reference2DoubleMap.Entry<K>> implements Reference2DoubleSortedMap.FastSortedEntrySet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Reference2DoubleMap.Entry) ((Reference2DoubleMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2DoubleMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2DoubleLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Reference2DoubleMap.Entry<K>> comparator() {
            return null;
        }

        public ObjectSortedSet<Reference2DoubleMap.Entry<K>> subSet(Reference2DoubleMap.Entry<K> fromElement, Reference2DoubleMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Reference2DoubleMap.Entry<K>> headSet(Reference2DoubleMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Reference2DoubleMap.Entry<K>> tailSet(Reference2DoubleMap.Entry<K> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Reference2DoubleMap.Entry<K> first() {
            if (Reference2DoubleLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Reference2DoubleLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Reference2DoubleMap.Entry<K> last() {
            if (Reference2DoubleLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Reference2DoubleLinkedOpenHashMap.this.last);
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
            if (e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            Object key = e.getKey();
            double v = ((Double) e.getValue()).doubleValue();
            if (key == null) {
                return Reference2DoubleLinkedOpenHashMap.this.containsNullKey && Double.doubleToLongBits(Reference2DoubleLinkedOpenHashMap.this.value[Reference2DoubleLinkedOpenHashMap.this.f2725n]) == Double.doubleToLongBits(v);
            }
            K[] key2 = Reference2DoubleLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2DoubleLinkedOpenHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (key == curr2) {
                return Double.doubleToLongBits(Reference2DoubleLinkedOpenHashMap.this.value[pos]) == Double.doubleToLongBits(v);
            }
            do {
                int i = (pos + 1) & Reference2DoubleLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (key != curr);
            return Double.doubleToLongBits(Reference2DoubleLinkedOpenHashMap.this.value[pos]) == Double.doubleToLongBits(v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Double)) {
                return false;
            }
            Object key = e.getKey();
            double v = ((Double) e.getValue()).doubleValue();
            if (key != null) {
                K[] key2 = Reference2DoubleLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2DoubleLinkedOpenHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (curr != key) {
                    while (true) {
                        int i = (pos + 1) & Reference2DoubleLinkedOpenHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (curr2 == key && Double.doubleToLongBits(Reference2DoubleLinkedOpenHashMap.this.value[pos]) == Double.doubleToLongBits(v)) {
                            Reference2DoubleLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Double.doubleToLongBits(Reference2DoubleLinkedOpenHashMap.this.value[pos]) != Double.doubleToLongBits(v)) {
                    return false;
                } else {
                    Reference2DoubleLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Reference2DoubleLinkedOpenHashMap.this.containsNullKey || Double.doubleToLongBits(Reference2DoubleLinkedOpenHashMap.this.value[Reference2DoubleLinkedOpenHashMap.this.f2725n]) != Double.doubleToLongBits(v)) {
                return false;
            } else {
                Reference2DoubleLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2DoubleLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2DoubleLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Reference2DoubleMap.Entry<K>> iterator(Reference2DoubleMap.Entry<K> from) {
            return new EntryIterator(from.getKey());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.FastEntrySet
        public ObjectListIterator<Reference2DoubleMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap.FastSortedEntrySet
        public ObjectListIterator<Reference2DoubleMap.Entry<K>> fastIterator(Reference2DoubleMap.Entry<K> from) {
            return new FastEntryIterator(from.getKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2DoubleMap.Entry<K>> consumer) {
            int i = Reference2DoubleLinkedOpenHashMap.this.size;
            int next = Reference2DoubleLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2DoubleLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractReference2DoubleMap.BasicEntry(Reference2DoubleLinkedOpenHashMap.this.key[next], Reference2DoubleLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2DoubleMap.Entry<K>> consumer) {
            AbstractReference2DoubleMap.BasicEntry<K> entry = new AbstractReference2DoubleMap.BasicEntry<>();
            int i = Reference2DoubleLinkedOpenHashMap.this.size;
            int next = Reference2DoubleLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2DoubleLinkedOpenHashMap.this.link[next];
                    entry.key = Reference2DoubleLinkedOpenHashMap.this.key[next];
                    entry.value = Reference2DoubleLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public Reference2DoubleSortedMap.FastSortedEntrySet<K> reference2DoubleEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Reference2DoubleLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.MapIterator
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
            return Reference2DoubleLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Reference2DoubleLinkedOpenHashMap.this.key[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return Reference2DoubleLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$KeySet.class */
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
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2DoubleLinkedOpenHashMap.this), 81);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            int i = Reference2DoubleLinkedOpenHashMap.this.size;
            int next = Reference2DoubleLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2DoubleLinkedOpenHashMap.this.link[next];
                    consumer.accept((Object) Reference2DoubleLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2DoubleLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2DoubleLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Reference2DoubleLinkedOpenHashMap.this.size;
            Reference2DoubleLinkedOpenHashMap.this.removeDouble(k);
            return Reference2DoubleLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2DoubleLinkedOpenHashMap.this.clear();
        }

        @Override // java.util.SortedSet
        public K first() {
            if (Reference2DoubleLinkedOpenHashMap.this.size != 0) {
                return Reference2DoubleLinkedOpenHashMap.this.key[Reference2DoubleLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            if (Reference2DoubleLinkedOpenHashMap.this.size != 0) {
                return Reference2DoubleLinkedOpenHashMap.this.key[Reference2DoubleLinkedOpenHashMap.this.last];
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    public ReferenceSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Reference2DoubleLinkedOpenHashMap<K>.MapIterator implements DoubleListIterator {
        @Override // java.util.PrimitiveIterator.OfDouble
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
            forEachRemaining((ValueIterator) doubleConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return Reference2DoubleLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(DoubleConsumer action, int index) {
            action.accept(Reference2DoubleLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return Reference2DoubleLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    public DoubleCollection values() {
        if (this.values == null) {
            this.values = new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.objects.Reference2DoubleLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public DoubleIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public DoubleSpliterator spliterator() {
                    return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2DoubleLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public void forEach(DoubleConsumer consumer) {
                    int i = Reference2DoubleLinkedOpenHashMap.this.size;
                    int next = Reference2DoubleLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Reference2DoubleLinkedOpenHashMap.this.link[next];
                            consumer.accept(Reference2DoubleLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Reference2DoubleLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
                public boolean contains(double v) {
                    return Reference2DoubleLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Reference2DoubleLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2726f)));
        if (l >= this.f2725n || this.size > HashCommon.maxFill(l, this.f2726f)) {
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
        double[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        double[] newValue = new double[newN + 1];
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
        this.f2725n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2725n, this.f2726f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Reference2DoubleLinkedOpenHashMap<K> clone() {
        try {
            Reference2DoubleLinkedOpenHashMap<K> c = (Reference2DoubleLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (double[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap, java.lang.Object, java.util.Map
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
            t ^= HashCommon.double2int(this.value[i]);
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.double2int(this.value[this.f2725n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        double[] value = this.value;
        Reference2DoubleLinkedOpenHashMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeObject(key[e]);
                s.writeDouble(value[e]);
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
        this.f2725n = HashCommon.arraySize(this.size, this.f2726f);
        this.maxFill = HashCommon.maxFill(this.f2725n, this.f2726f);
        this.mask = this.f2725n - 1;
        K[] key = (K[]) new Object[this.f2725n + 1];
        this.key = key;
        double[] value = new double[this.f2725n + 1];
        this.value = value;
        long[] link = new long[this.f2725n + 1];
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
            double v = s.readDouble();
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
                pos = this.f2725n;
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
