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
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatMap;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatConsumer;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatListIterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap.class */
public class Double2FloatLinkedOpenHashMap extends AbstractDouble2FloatSortedMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient double[] key;
    protected transient float[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f1592n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1593f;
    protected transient Double2FloatSortedMap.FastSortedEntrySet entries;
    protected transient DoubleSortedSet keys;
    protected transient FloatCollection values;

    public Double2FloatLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1593f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1592n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1592n - 1;
            this.maxFill = HashCommon.maxFill(this.f1592n, f);
            this.key = new double[this.f1592n + 1];
            this.value = new float[this.f1592n + 1];
            this.link = new long[this.f1592n + 1];
        }
    }

    public Double2FloatLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Double2FloatLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Double2FloatLinkedOpenHashMap(Map<? extends Double, ? extends Float> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Double2FloatLinkedOpenHashMap(Map<? extends Double, ? extends Float> m) {
        this(m, 0.75f);
    }

    public Double2FloatLinkedOpenHashMap(Double2FloatMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Double2FloatLinkedOpenHashMap(Double2FloatMap m) {
        this(m, 0.75f);
    }

    public Double2FloatLinkedOpenHashMap(double[] k, float[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Double2FloatLinkedOpenHashMap(double[] k, float[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1593f);
        if (needed > this.f1592n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1593f)))));
        if (needed > this.f1592n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public float removeEntry(int pos) {
        float oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f1592n > this.minN && this.size < this.maxFill / 4 && this.f1592n > 16) {
            rehash(this.f1592n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public float removeNullEntry() {
        this.containsNullKey = false;
        float oldValue = this.value[this.f1592n];
        this.size--;
        fixPointers(this.f1592n);
        if (this.f1592n > this.minN && this.size < this.maxFill / 4 && this.f1592n > 16) {
            rehash(this.f1592n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, java.util.Map
    public void putAll(Map<? extends Double, ? extends Float> m) {
        if (((double) this.f1593f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.f1592n : -(this.f1592n + 1);
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

    private void insert(int pos, double k, float v) {
        if (pos == this.f1592n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1593f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float put(double k, float v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        float oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private float addToValue(int pos, float incr) {
        float oldValue = this.value[pos];
        this.value[pos] = oldValue + incr;
        return oldValue;
    }

    public float addTo(double k, float incr) {
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
            return addToValue(this.f1592n, incr);
        } else {
            pos = this.f1592n;
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1593f));
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float remove(double k) {
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

    private float setValue(int pos, float v) {
        float oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public float removeFirstFloat() {
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
        float v = this.value[pos];
        if (pos == this.f1592n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1592n > this.minN && this.size < this.maxFill / 4 && this.f1592n > 16) {
            rehash(this.f1592n / 2);
        }
        return v;
    }

    public float removeLastFloat() {
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
        float v = this.value[pos];
        if (pos == this.f1592n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1592n > this.minN && this.size < this.maxFill / 4 && this.f1592n > 16) {
            rehash(this.f1592n / 2);
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

    public float getAndMoveToFirst(double k) {
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
            moveIndexToFirst(this.f1592n);
            return this.value[this.f1592n];
        }
    }

    public float getAndMoveToLast(double k) {
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
            moveIndexToLast(this.f1592n);
            return this.value[this.f1592n];
        }
    }

    public float putAndMoveToFirst(double k, float v) {
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
            moveIndexToFirst(this.f1592n);
            return setValue(this.f1592n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1592n;
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
            rehash(HashCommon.arraySize(this.size, this.f1593f));
        }
        return this.defRetValue;
    }

    public float putAndMoveToLast(double k, float v) {
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
            moveIndexToLast(this.f1592n);
            return setValue(this.f1592n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1592n;
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
            rehash(HashCommon.arraySize(this.size, this.f1593f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float get(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1592n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public boolean containsValue(float v) {
        float[] value = this.value;
        double[] key = this.key;
        if (this.containsNullKey && Float.floatToIntBits(value[this.f1592n]) == Float.floatToIntBits(v)) {
            return true;
        }
        int i = this.f1592n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (Double.doubleToLongBits(key[i]) != 0 && Float.floatToIntBits(value[i]) == Float.floatToIntBits(v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float getOrDefault(double k, float defaultValue) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1592n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float putIfAbsent(double k, float v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public boolean remove(double k, float v) {
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            int pos = mix;
            double curr = key[mix];
            if (Double.doubleToLongBits(curr) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr) && Float.floatToIntBits(v) == Float.floatToIntBits(this.value[pos])) {
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
                if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2) && Float.floatToIntBits(v) == Float.floatToIntBits(this.value[pos])) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || Float.floatToIntBits(v) != Float.floatToIntBits(this.value[this.f1592n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public boolean replace(double k, float oldValue, float v) {
        int pos = find(k);
        if (pos < 0 || Float.floatToIntBits(oldValue) != Float.floatToIntBits(this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float replace(double k, float v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        float oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float computeIfAbsent(double k, DoubleUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        float newValue = SafeMath.safeDoubleToFloat(mappingFunction.applyAsDouble(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float computeIfAbsent(double key, Double2FloatFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        float newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float computeIfAbsentNullable(double k, DoubleFunction<? extends Float> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Float newValue = (Float) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        float v = newValue.floatValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float computeIfPresent(double k, BiFunction<? super Double, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Float newValue = (Float) remappingFunction.apply(Double.valueOf(k), Float.valueOf(this.value[pos]));
        if (newValue == null) {
            if (Double.doubleToLongBits(k) == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        float[] fArr = this.value;
        float floatValue = newValue.floatValue();
        fArr[pos] = floatValue;
        return floatValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float compute(double k, BiFunction<? super Double, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Float newValue = (Float) remappingFunction.apply(Double.valueOf(k), pos >= 0 ? Float.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (Double.doubleToLongBits(k) == 0) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return this.defRetValue;
        }
        float newVal = newValue.floatValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
    public float merge(double k, float v, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
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
        Float newValue = (Float) remappingFunction.apply(Float.valueOf(this.value[pos]), Float.valueOf(v));
        if (newValue == null) {
            if (Double.doubleToLongBits(k) == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        float[] fArr = this.value;
        float floatValue = newValue.floatValue();
        fArr[pos] = floatValue;
        return floatValue;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Double2FloatMap.Entry, Map.Entry<Double, Float>, DoubleFloatPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.Entry
        public double getDoubleKey() {
            return Double2FloatLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleFloatPair
        public double leftDouble() {
            return Double2FloatLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.Entry
        public float getFloatValue() {
            return Double2FloatLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleFloatPair
        public float rightFloat() {
            return Double2FloatLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.Entry
        public float setValue(float v) {
            float oldValue = Double2FloatLinkedOpenHashMap.this.value[this.index];
            Double2FloatLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleFloatPair
        public DoubleFloatPair right(float v) {
            Double2FloatLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.Entry, java.util.Map.Entry
        @Deprecated
        public Double getKey() {
            return Double.valueOf(Double2FloatLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.Entry, java.util.Map.Entry
        @Deprecated
        public Float getValue() {
            return Float.valueOf(Double2FloatLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.Entry
        @Deprecated
        public Float setValue(Float v) {
            return Float.valueOf(setValue(v.floatValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Double, Float> e = (Map.Entry) o;
            return Double.doubleToLongBits(Double2FloatLinkedOpenHashMap.this.key[this.index]) == Double.doubleToLongBits(e.getKey().doubleValue()) && Float.floatToIntBits(Double2FloatLinkedOpenHashMap.this.value[this.index]) == Float.floatToIntBits(e.getValue().floatValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(Double2FloatLinkedOpenHashMap.this.key[this.index]) ^ HashCommon.float2int(Double2FloatLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // java.lang.Object
        public String toString() {
            return Double2FloatLinkedOpenHashMap.this.key[this.index] + "=>" + Double2FloatLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap
    public double firstDoubleKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap
    public double lastDoubleKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap
    public Double2FloatSortedMap tailMap(double from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap
    public Double2FloatSortedMap headMap(double to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap
    public Double2FloatSortedMap subMap(double from, double to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap, java.util.SortedMap
    public Comparator<? super Double> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$MapIterator.class */
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
            this.next = Double2FloatLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(double from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (Double.doubleToLongBits(from) == 0) {
                if (Double2FloatLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Double2FloatLinkedOpenHashMap.this.link[Double2FloatLinkedOpenHashMap.this.f1592n];
                    this.prev = Double2FloatLinkedOpenHashMap.this.f1592n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Double.doubleToLongBits(Double2FloatLinkedOpenHashMap.this.key[Double2FloatLinkedOpenHashMap.this.last]) == Double.doubleToLongBits(from)) {
                this.prev = Double2FloatLinkedOpenHashMap.this.last;
                this.index = Double2FloatLinkedOpenHashMap.this.size;
            } else {
                int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(from));
                int i = Double2FloatLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Double.doubleToLongBits(Double2FloatLinkedOpenHashMap.this.key[pos]) == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Double.doubleToLongBits(Double2FloatLinkedOpenHashMap.this.key[pos]) == Double.doubleToLongBits(from)) {
                        this.next = (int) Double2FloatLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Double2FloatLinkedOpenHashMap.this.mask;
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
                    this.index = Double2FloatLinkedOpenHashMap.this.size;
                } else {
                    int pos = Double2FloatLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Double2FloatLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Double2FloatLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Double2FloatLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Double2FloatLinkedOpenHashMap.this.link[this.curr];
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
                this.prev = (int) (Double2FloatLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Double2FloatLinkedOpenHashMap.this.link[this.curr];
            }
            Double2FloatLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Double2FloatLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Double2FloatLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Double2FloatLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Double2FloatLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Double2FloatLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Double2FloatLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Double2FloatLinkedOpenHashMap.this.f1592n) {
                Double2FloatLinkedOpenHashMap.this.containsNullKey = false;
                return;
            }
            double[] key = Double2FloatLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Double2FloatLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (Double.doubleToLongBits(curr) == 0) {
                        key[pos] = 0.0d;
                        return;
                    }
                    int slot = ((int) HashCommon.mix(Double.doubleToRawLongBits(curr))) & Double2FloatLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Double2FloatLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Double2FloatLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Double2FloatLinkedOpenHashMap.this.value[pos] = Double2FloatLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Double2FloatLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Double2FloatMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Double2FloatMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Double2FloatMap.Entry>> implements ObjectListIterator<Double2FloatMap.Entry> {
        private MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Double2FloatMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Double2FloatMap.Entry) obj);
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
        public final void acceptOnIndex(Consumer<? super Double2FloatMap.Entry> action, int index) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends MapIterator<Consumer<? super Double2FloatMap.Entry>> implements ObjectListIterator<Double2FloatMap.Entry> {
        final MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Double2FloatMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Double2FloatMap.Entry) obj);
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
        public final void acceptOnIndex(Consumer<? super Double2FloatMap.Entry> action, int index) {
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Double2FloatMap.Entry> implements Double2FloatSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Double2FloatMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2FloatMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2FloatLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Double2FloatMap.Entry> comparator() {
            return null;
        }

        public ObjectSortedSet<Double2FloatMap.Entry> subSet(Double2FloatMap.Entry fromElement, Double2FloatMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Double2FloatMap.Entry> headSet(Double2FloatMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Double2FloatMap.Entry> tailSet(Double2FloatMap.Entry fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Double2FloatMap.Entry first() {
            if (Double2FloatLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Double2FloatLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Double2FloatMap.Entry last() {
            if (Double2FloatLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Double2FloatLinkedOpenHashMap.this.last);
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
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            float v = ((Float) e.getValue()).floatValue();
            if (Double.doubleToLongBits(k) == 0) {
                return Double2FloatLinkedOpenHashMap.this.containsNullKey && Float.floatToIntBits(Double2FloatLinkedOpenHashMap.this.value[Double2FloatLinkedOpenHashMap.this.f1592n]) == Float.floatToIntBits(v);
            }
            double[] key = Double2FloatLinkedOpenHashMap.this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & Double2FloatLinkedOpenHashMap.this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
                return Float.floatToIntBits(Double2FloatLinkedOpenHashMap.this.value[pos]) == Float.floatToIntBits(v);
            }
            do {
                int i = (pos + 1) & Double2FloatLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
            return Float.floatToIntBits(Double2FloatLinkedOpenHashMap.this.value[pos]) == Float.floatToIntBits(v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            float v = ((Float) e.getValue()).floatValue();
            if (Double.doubleToLongBits(k) != 0) {
                double[] key = Double2FloatLinkedOpenHashMap.this.key;
                int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & Double2FloatLinkedOpenHashMap.this.mask;
                int pos = mix;
                double curr = key[mix];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
                if (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k)) {
                    while (true) {
                        int i = (pos + 1) & Double2FloatLinkedOpenHashMap.this.mask;
                        pos = i;
                        double curr2 = key[i];
                        if (Double.doubleToLongBits(curr2) == 0) {
                            return false;
                        }
                        if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k) && Float.floatToIntBits(Double2FloatLinkedOpenHashMap.this.value[pos]) == Float.floatToIntBits(v)) {
                            Double2FloatLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Float.floatToIntBits(Double2FloatLinkedOpenHashMap.this.value[pos]) != Float.floatToIntBits(v)) {
                    return false;
                } else {
                    Double2FloatLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Double2FloatLinkedOpenHashMap.this.containsNullKey || Float.floatToIntBits(Double2FloatLinkedOpenHashMap.this.value[Double2FloatLinkedOpenHashMap.this.f1592n]) != Float.floatToIntBits(v)) {
                return false;
            } else {
                Double2FloatLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2FloatLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2FloatLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Double2FloatMap.Entry> iterator(Double2FloatMap.Entry from) {
            return new EntryIterator(from.getDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.FastEntrySet
        public ObjectListIterator<Double2FloatMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap.FastSortedEntrySet
        public ObjectListIterator<Double2FloatMap.Entry> fastIterator(Double2FloatMap.Entry from) {
            return new FastEntryIterator(from.getDoubleKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Double2FloatMap.Entry> consumer) {
            int i = Double2FloatLinkedOpenHashMap.this.size;
            int next = Double2FloatLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2FloatLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractDouble2FloatMap.BasicEntry(Double2FloatLinkedOpenHashMap.this.key[next], Double2FloatLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap.FastEntrySet
        public void fastForEach(Consumer<? super Double2FloatMap.Entry> consumer) {
            AbstractDouble2FloatMap.BasicEntry entry = new AbstractDouble2FloatMap.BasicEntry();
            int i = Double2FloatLinkedOpenHashMap.this.size;
            int next = Double2FloatLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2FloatLinkedOpenHashMap.this.link[next];
                    entry.key = Double2FloatLinkedOpenHashMap.this.key[next];
                    entry.value = Double2FloatLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatSortedMap
    public Double2FloatSortedMap.FastSortedEntrySet double2FloatEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$KeyIterator.class */
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
            return Double2FloatLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(DoubleConsumer action, int index) {
            action.accept(Double2FloatLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return Double2FloatLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$KeySet.class */
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
            return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2FloatLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer consumer) {
            int i = Double2FloatLinkedOpenHashMap.this.size;
            int next = Double2FloatLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2FloatLinkedOpenHashMap.this.link[next];
                    consumer.accept(Double2FloatLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2FloatLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double2FloatLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            int oldSize = Double2FloatLinkedOpenHashMap.this.size;
            Double2FloatLinkedOpenHashMap.this.remove(k);
            return Double2FloatLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2FloatLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            if (Double2FloatLinkedOpenHashMap.this.size != 0) {
                return Double2FloatLinkedOpenHashMap.this.key[Double2FloatLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            if (Double2FloatLinkedOpenHashMap.this.size != 0) {
                return Double2FloatLinkedOpenHashMap.this.key[Double2FloatLinkedOpenHashMap.this.last];
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatSortedMap, p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, java.util.Map
    public DoubleSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<FloatConsumer> implements FloatListIterator {
        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(FloatConsumer floatConsumer) {
            forEachRemaining((ValueIterator) floatConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return Double2FloatLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(FloatConsumer action, int index) {
            action.accept(Double2FloatLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return Double2FloatLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatSortedMap, p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, p014it.unimi.dsi.fastutil.doubles.Double2FloatMap, java.util.Map
    public FloatCollection values() {
        if (this.values == null) {
            this.values = new AbstractFloatCollection() { // from class: it.unimi.dsi.fastutil.doubles.Double2FloatLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
                public FloatIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
                public FloatSpliterator spliterator() {
                    return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2FloatLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.floats.FloatIterable
                public void forEach(FloatConsumer consumer) {
                    int i = Double2FloatLinkedOpenHashMap.this.size;
                    int next = Double2FloatLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Double2FloatLinkedOpenHashMap.this.link[next];
                            consumer.accept(Double2FloatLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Double2FloatLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
                public boolean contains(float v) {
                    return Double2FloatLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Double2FloatLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1593f)));
        if (l >= this.f1592n || this.size > HashCommon.maxFill(l, this.f1593f)) {
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
        float[] value = this.value;
        int mask = newN - 1;
        double[] newKey = new double[newN + 1];
        float[] newValue = new float[newN + 1];
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
        this.f1592n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f1592n, this.f1593f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Double2FloatLinkedOpenHashMap clone() {
        try {
            Double2FloatLinkedOpenHashMap c = (Double2FloatLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (double[]) this.key.clone();
            c.value = (float[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatMap, java.lang.Object, java.util.Map
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
            h += HashCommon.double2int(this.key[i]) ^ HashCommon.float2int(this.value[i]);
            i++;
        }
        if (this.containsNullKey) {
            h += HashCommon.float2int(this.value[this.f1592n]);
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        double[] key = this.key;
        float[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeDouble(key[e]);
                s.writeFloat(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1592n = HashCommon.arraySize(this.size, this.f1593f);
        this.maxFill = HashCommon.maxFill(this.f1592n, this.f1593f);
        this.mask = this.f1592n - 1;
        double[] key = new double[this.f1592n + 1];
        this.key = key;
        float[] value = new float[this.f1592n + 1];
        this.value = value;
        long[] link = new long[this.f1592n + 1];
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
            float v = s.readFloat();
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
                pos = this.f1592n;
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
