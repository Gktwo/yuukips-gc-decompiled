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
import java.util.function.DoubleToIntFunction;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortListIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap.class */
public class Double2ShortLinkedOpenHashMap extends AbstractDouble2ShortSortedMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient double[] key;
    protected transient short[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f1652n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1653f;
    protected transient Double2ShortSortedMap.FastSortedEntrySet entries;
    protected transient DoubleSortedSet keys;
    protected transient ShortCollection values;

    public Double2ShortLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1653f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1652n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1652n - 1;
            this.maxFill = HashCommon.maxFill(this.f1652n, f);
            this.key = new double[this.f1652n + 1];
            this.value = new short[this.f1652n + 1];
            this.link = new long[this.f1652n + 1];
        }
    }

    public Double2ShortLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Double2ShortLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Double2ShortLinkedOpenHashMap(Map<? extends Double, ? extends Short> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Double2ShortLinkedOpenHashMap(Map<? extends Double, ? extends Short> m) {
        this(m, 0.75f);
    }

    public Double2ShortLinkedOpenHashMap(Double2ShortMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Double2ShortLinkedOpenHashMap(Double2ShortMap m) {
        this(m, 0.75f);
    }

    public Double2ShortLinkedOpenHashMap(double[] k, short[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Double2ShortLinkedOpenHashMap(double[] k, short[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1653f);
        if (needed > this.f1652n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1653f)))));
        if (needed > this.f1652n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public short removeEntry(int pos) {
        short oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f1652n > this.minN && this.size < this.maxFill / 4 && this.f1652n > 16) {
            rehash(this.f1652n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public short removeNullEntry() {
        this.containsNullKey = false;
        short oldValue = this.value[this.f1652n];
        this.size--;
        fixPointers(this.f1652n);
        if (this.f1652n > this.minN && this.size < this.maxFill / 4 && this.f1652n > 16) {
            rehash(this.f1652n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap, java.util.Map
    public void putAll(Map<? extends Double, ? extends Short> m) {
        if (((double) this.f1653f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.f1652n : -(this.f1652n + 1);
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

    private void insert(int pos, double k, short v) {
        if (pos == this.f1652n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1653f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction
    public short put(double k, short v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private short addToValue(int pos, short incr) {
        short oldValue = this.value[pos];
        this.value[pos] = (short) (oldValue + incr);
        return oldValue;
    }

    public short addTo(double k, short incr) {
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
            return addToValue(this.f1652n, incr);
        } else {
            pos = this.f1652n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (short) (this.defRetValue + incr);
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1653f));
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction
    public short remove(double k) {
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

    private short setValue(int pos, short v) {
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public short removeFirstShort() {
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
        short v = this.value[pos];
        if (pos == this.f1652n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1652n > this.minN && this.size < this.maxFill / 4 && this.f1652n > 16) {
            rehash(this.f1652n / 2);
        }
        return v;
    }

    public short removeLastShort() {
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
        short v = this.value[pos];
        if (pos == this.f1652n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1652n > this.minN && this.size < this.maxFill / 4 && this.f1652n > 16) {
            rehash(this.f1652n / 2);
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

    public short getAndMoveToFirst(double k) {
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
            moveIndexToFirst(this.f1652n);
            return this.value[this.f1652n];
        }
    }

    public short getAndMoveToLast(double k) {
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
            moveIndexToLast(this.f1652n);
            return this.value[this.f1652n];
        }
    }

    public short putAndMoveToFirst(double k, short v) {
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
            moveIndexToFirst(this.f1652n);
            return setValue(this.f1652n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1652n;
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
            rehash(HashCommon.arraySize(this.size, this.f1653f));
        }
        return this.defRetValue;
    }

    public short putAndMoveToLast(double k, short v) {
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
            moveIndexToLast(this.f1652n);
            return setValue(this.f1652n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1652n;
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
            rehash(HashCommon.arraySize(this.size, this.f1653f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction
    public short get(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1652n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public boolean containsValue(short v) {
        short[] value = this.value;
        double[] key = this.key;
        if (this.containsNullKey && value[this.f1652n] == v) {
            return true;
        }
        int i = this.f1652n;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction
    public short getOrDefault(double k, short defaultValue) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNullKey ? this.value[this.f1652n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short putIfAbsent(double k, short v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public boolean remove(double k, short v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f1652n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public boolean replace(double k, short oldValue, short v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short replace(double k, short v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        short oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short computeIfAbsent(double k, DoubleToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short computeIfAbsent(double key, Double2ShortFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        short newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short computeIfAbsentNullable(double k, DoubleFunction<? extends Short> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Short newValue = (Short) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        short v = newValue.shortValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short computeIfPresent(double k, BiFunction<? super Double, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Short newValue = (Short) remappingFunction.apply(Double.valueOf(k), Short.valueOf(this.value[pos]));
        if (newValue == null) {
            if (Double.doubleToLongBits(k) == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        short[] sArr = this.value;
        short shortValue = newValue.shortValue();
        sArr[pos] = shortValue;
        return shortValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short compute(double k, BiFunction<? super Double, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Short newValue = (Short) remappingFunction.apply(Double.valueOf(k), pos >= 0 ? Short.valueOf(this.value[pos]) : null);
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
        short newVal = newValue.shortValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public short merge(double k, short v, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
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
        Short newValue = (Short) remappingFunction.apply(Short.valueOf(this.value[pos]), Short.valueOf(v));
        if (newValue == null) {
            if (Double.doubleToLongBits(k) == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        short[] sArr = this.value;
        short shortValue = newValue.shortValue();
        sArr[pos] = shortValue;
        return shortValue;
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Double2ShortMap.Entry, Map.Entry<Double, Short>, DoubleShortPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry
        public double getDoubleKey() {
            return Double2ShortLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleShortPair
        public double leftDouble() {
            return Double2ShortLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry
        public short getShortValue() {
            return Double2ShortLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleShortPair
        public short rightShort() {
            return Double2ShortLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry
        public short setValue(short v) {
            short oldValue = Double2ShortLinkedOpenHashMap.this.value[this.index];
            Double2ShortLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleShortPair
        public DoubleShortPair right(short v) {
            Double2ShortLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry, java.util.Map.Entry
        @Deprecated
        public Double getKey() {
            return Double.valueOf(Double2ShortLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry, java.util.Map.Entry
        @Deprecated
        public Short getValue() {
            return Short.valueOf(Double2ShortLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry
        @Deprecated
        public Short setValue(Short v) {
            return Short.valueOf(setValue(v.shortValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Double, Short> e = (Map.Entry) o;
            return Double.doubleToLongBits(Double2ShortLinkedOpenHashMap.this.key[this.index]) == Double.doubleToLongBits(e.getKey().doubleValue()) && Double2ShortLinkedOpenHashMap.this.value[this.index] == e.getValue().shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(Double2ShortLinkedOpenHashMap.this.key[this.index]) ^ Double2ShortLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Double2ShortLinkedOpenHashMap.this.key[this.index] + "=>" + ((int) Double2ShortLinkedOpenHashMap.this.value[this.index]);
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
    public double firstDoubleKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
    public double lastDoubleKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
    public Double2ShortSortedMap tailMap(double from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
    public Double2ShortSortedMap headMap(double to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
    public Double2ShortSortedMap subMap(double from, double to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
    public Comparator<? super Double> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$MapIterator.class */
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
            this.next = Double2ShortLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(double from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (Double.doubleToLongBits(from) == 0) {
                if (Double2ShortLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Double2ShortLinkedOpenHashMap.this.link[Double2ShortLinkedOpenHashMap.this.f1652n];
                    this.prev = Double2ShortLinkedOpenHashMap.this.f1652n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Double.doubleToLongBits(Double2ShortLinkedOpenHashMap.this.key[Double2ShortLinkedOpenHashMap.this.last]) == Double.doubleToLongBits(from)) {
                this.prev = Double2ShortLinkedOpenHashMap.this.last;
                this.index = Double2ShortLinkedOpenHashMap.this.size;
            } else {
                int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(from));
                int i = Double2ShortLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Double.doubleToLongBits(Double2ShortLinkedOpenHashMap.this.key[pos]) == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Double.doubleToLongBits(Double2ShortLinkedOpenHashMap.this.key[pos]) == Double.doubleToLongBits(from)) {
                        this.next = (int) Double2ShortLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Double2ShortLinkedOpenHashMap.this.mask;
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
                    this.index = Double2ShortLinkedOpenHashMap.this.size;
                } else {
                    int pos = Double2ShortLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Double2ShortLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Double2ShortLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Double2ShortLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Double2ShortLinkedOpenHashMap.this.link[this.curr];
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
                this.prev = (int) (Double2ShortLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Double2ShortLinkedOpenHashMap.this.link[this.curr];
            }
            Double2ShortLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Double2ShortLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Double2ShortLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Double2ShortLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Double2ShortLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Double2ShortLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Double2ShortLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Double2ShortLinkedOpenHashMap.this.f1652n) {
                Double2ShortLinkedOpenHashMap.this.containsNullKey = false;
                return;
            }
            double[] key = Double2ShortLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Double2ShortLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (Double.doubleToLongBits(curr) == 0) {
                        key[pos] = 0.0d;
                        return;
                    }
                    int slot = ((int) HashCommon.mix(Double.doubleToRawLongBits(curr))) & Double2ShortLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Double2ShortLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Double2ShortLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Double2ShortLinkedOpenHashMap.this.value[pos] = Double2ShortLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Double2ShortLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Double2ShortMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Double2ShortMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Double2ShortMap.Entry>> implements ObjectListIterator<Double2ShortMap.Entry> {
        private MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Double2ShortMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Double2ShortMap.Entry) obj);
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
        public final void acceptOnIndex(Consumer<? super Double2ShortMap.Entry> action, int index) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends MapIterator<Consumer<? super Double2ShortMap.Entry>> implements ObjectListIterator<Double2ShortMap.Entry> {
        final MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Double2ShortMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Double2ShortMap.Entry) obj);
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
        public final void acceptOnIndex(Consumer<? super Double2ShortMap.Entry> action, int index) {
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Double2ShortMap.Entry> implements Double2ShortSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Double2ShortMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2ShortMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2ShortLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Double2ShortMap.Entry> comparator() {
            return null;
        }

        public ObjectSortedSet<Double2ShortMap.Entry> subSet(Double2ShortMap.Entry fromElement, Double2ShortMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Double2ShortMap.Entry> headSet(Double2ShortMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Double2ShortMap.Entry> tailSet(Double2ShortMap.Entry fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Double2ShortMap.Entry first() {
            if (Double2ShortLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Double2ShortLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Double2ShortMap.Entry last() {
            if (Double2ShortLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Double2ShortLinkedOpenHashMap.this.last);
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
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            short v = ((Short) e.getValue()).shortValue();
            if (Double.doubleToLongBits(k) == 0) {
                return Double2ShortLinkedOpenHashMap.this.containsNullKey && Double2ShortLinkedOpenHashMap.this.value[Double2ShortLinkedOpenHashMap.this.f1652n] == v;
            }
            double[] key = Double2ShortLinkedOpenHashMap.this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & Double2ShortLinkedOpenHashMap.this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
                return Double2ShortLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Double2ShortLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
            return Double2ShortLinkedOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Double) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                return false;
            }
            double k = ((Double) e.getKey()).doubleValue();
            short v = ((Short) e.getValue()).shortValue();
            if (Double.doubleToLongBits(k) != 0) {
                double[] key = Double2ShortLinkedOpenHashMap.this.key;
                int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & Double2ShortLinkedOpenHashMap.this.mask;
                int pos = mix;
                double curr = key[mix];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
                if (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k)) {
                    while (true) {
                        int i = (pos + 1) & Double2ShortLinkedOpenHashMap.this.mask;
                        pos = i;
                        double curr2 = key[i];
                        if (Double.doubleToLongBits(curr2) == 0) {
                            return false;
                        }
                        if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k) && Double2ShortLinkedOpenHashMap.this.value[pos] == v) {
                            Double2ShortLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Double2ShortLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Double2ShortLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Double2ShortLinkedOpenHashMap.this.containsNullKey || Double2ShortLinkedOpenHashMap.this.value[Double2ShortLinkedOpenHashMap.this.f1652n] != v) {
                return false;
            } else {
                Double2ShortLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2ShortLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2ShortLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Double2ShortMap.Entry> iterator(Double2ShortMap.Entry from) {
            return new EntryIterator(from.getDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.FastEntrySet
        public ObjectListIterator<Double2ShortMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap.FastSortedEntrySet
        public ObjectListIterator<Double2ShortMap.Entry> fastIterator(Double2ShortMap.Entry from) {
            return new FastEntryIterator(from.getDoubleKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Double2ShortMap.Entry> consumer) {
            int i = Double2ShortLinkedOpenHashMap.this.size;
            int next = Double2ShortLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2ShortLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractDouble2ShortMap.BasicEntry(Double2ShortLinkedOpenHashMap.this.key[next], Double2ShortLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.FastEntrySet
        public void fastForEach(Consumer<? super Double2ShortMap.Entry> consumer) {
            AbstractDouble2ShortMap.BasicEntry entry = new AbstractDouble2ShortMap.BasicEntry();
            int i = Double2ShortLinkedOpenHashMap.this.size;
            int next = Double2ShortLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2ShortLinkedOpenHashMap.this.link[next];
                    entry.key = Double2ShortLinkedOpenHashMap.this.key[next];
                    entry.value = Double2ShortLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
    public Double2ShortSortedMap.FastSortedEntrySet double2ShortEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$KeyIterator.class */
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
            return Double2ShortLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(DoubleConsumer action, int index) {
            action.accept(Double2ShortLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return Double2ShortLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$KeySet.class */
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
            return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2ShortLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public void forEach(DoubleConsumer consumer) {
            int i = Double2ShortLinkedOpenHashMap.this.size;
            int next = Double2ShortLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Double2ShortLinkedOpenHashMap.this.link[next];
                    consumer.accept(Double2ShortLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Double2ShortLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return Double2ShortLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            int oldSize = Double2ShortLinkedOpenHashMap.this.size;
            Double2ShortLinkedOpenHashMap.this.remove(k);
            return Double2ShortLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Double2ShortLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            if (Double2ShortLinkedOpenHashMap.this.size != 0) {
                return Double2ShortLinkedOpenHashMap.this.key[Double2ShortLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            if (Double2ShortLinkedOpenHashMap.this.size != 0) {
                return Double2ShortLinkedOpenHashMap.this.key[Double2ShortLinkedOpenHashMap.this.last];
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortSortedMap, p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
    public DoubleSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<ShortConsumer> implements ShortListIterator {
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ShortConsumer shortConsumer) {
            forEachRemaining((ValueIterator) shortConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return Double2ShortLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ShortConsumer action, int index) {
            action.accept(Double2ShortLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return Double2ShortLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortSortedMap, p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
    public ShortCollection values() {
        if (this.values == null) {
            this.values = new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.doubles.Double2ShortLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public ShortIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public ShortSpliterator spliterator() {
                    return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(Double2ShortLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public void forEach(ShortConsumer consumer) {
                    int i = Double2ShortLinkedOpenHashMap.this.size;
                    int next = Double2ShortLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Double2ShortLinkedOpenHashMap.this.link[next];
                            consumer.accept(Double2ShortLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Double2ShortLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
                public boolean contains(short v) {
                    return Double2ShortLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Double2ShortLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1653f)));
        if (l >= this.f1652n || this.size > HashCommon.maxFill(l, this.f1653f)) {
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
        short[] value = this.value;
        int mask = newN - 1;
        double[] newKey = new double[newN + 1];
        short[] newValue = new short[newN + 1];
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
        this.f1652n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f1652n, this.f1653f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Double2ShortLinkedOpenHashMap clone() {
        try {
            Double2ShortLinkedOpenHashMap c = (Double2ShortLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (double[]) this.key.clone();
            c.value = (short[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap, java.lang.Object, java.util.Map
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
            h += HashCommon.double2int(this.key[i]) ^ this.value[i];
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1652n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        double[] key = this.key;
        short[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeDouble(key[e]);
                s.writeShort(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1652n = HashCommon.arraySize(this.size, this.f1653f);
        this.maxFill = HashCommon.maxFill(this.f1652n, this.f1653f);
        this.mask = this.f1652n - 1;
        double[] key = new double[this.f1652n + 1];
        this.key = key;
        short[] value = new short[this.f1652n + 1];
        this.value = value;
        long[] link = new long[this.f1652n + 1];
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
            short v = s.readShort();
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
                pos = this.f1652n;
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
