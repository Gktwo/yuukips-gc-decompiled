package p014it.unimi.dsi.fastutil.ints;

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
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteListIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap;
import p014it.unimi.dsi.fastutil.ints.Int2ByteMap;
import p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap.class */
public class Int2ByteLinkedOpenHashMap extends AbstractInt2ByteSortedMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient int[] key;
    protected transient byte[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f1998n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1999f;
    protected transient Int2ByteSortedMap.FastSortedEntrySet entries;
    protected transient IntSortedSet keys;
    protected transient ByteCollection values;

    public Int2ByteLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1999f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1998n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1998n - 1;
            this.maxFill = HashCommon.maxFill(this.f1998n, f);
            this.key = new int[this.f1998n + 1];
            this.value = new byte[this.f1998n + 1];
            this.link = new long[this.f1998n + 1];
        }
    }

    public Int2ByteLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Int2ByteLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Int2ByteLinkedOpenHashMap(Map<? extends Integer, ? extends Byte> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2ByteLinkedOpenHashMap(Map<? extends Integer, ? extends Byte> m) {
        this(m, 0.75f);
    }

    public Int2ByteLinkedOpenHashMap(Int2ByteMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2ByteLinkedOpenHashMap(Int2ByteMap m) {
        this(m, 0.75f);
    }

    public Int2ByteLinkedOpenHashMap(int[] k, byte[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Int2ByteLinkedOpenHashMap(int[] k, byte[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1999f);
        if (needed > this.f1998n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1999f)))));
        if (needed > this.f1998n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public byte removeEntry(int pos) {
        byte oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f1998n > this.minN && this.size < this.maxFill / 4 && this.f1998n > 16) {
            rehash(this.f1998n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public byte removeNullEntry() {
        this.containsNullKey = false;
        byte oldValue = this.value[this.f1998n];
        this.size--;
        fixPointers(this.f1998n);
        if (this.f1998n > this.minN && this.size < this.maxFill / 4 && this.f1998n > 16) {
            rehash(this.f1998n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap, java.util.Map
    public void putAll(Map<? extends Integer, ? extends Byte> m) {
        if (((double) this.f1999f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.f1998n : -(this.f1998n + 1);
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    private void insert(int pos, int k, byte v) {
        if (pos == this.f1998n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1999f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    public byte put(int k, byte v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        byte oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private byte addToValue(int pos, byte incr) {
        byte oldValue = this.value[pos];
        this.value[pos] = (byte) (oldValue + incr);
        return oldValue;
    }

    public byte addTo(int k, byte incr) {
        int pos;
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            pos = mix;
            int curr2 = key[mix];
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
            return addToValue(this.f1998n, incr);
        } else {
            pos = this.f1998n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (byte) (this.defRetValue + incr);
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1999f));
        }
        return this.defRetValue;
    }

    protected final void shiftKeys(int pos) {
        int curr;
        int[] key = this.key;
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
                int slot = HashCommon.mix(curr) & this.mask;
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    public byte remove(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    private byte setValue(int pos, byte v) {
        byte oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public byte removeFirstByte() {
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
        byte v = this.value[pos];
        if (pos == this.f1998n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1998n > this.minN && this.size < this.maxFill / 4 && this.f1998n > 16) {
            rehash(this.f1998n / 2);
        }
        return v;
    }

    public byte removeLastByte() {
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
        byte v = this.value[pos];
        if (pos == this.f1998n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1998n > this.minN && this.size < this.maxFill / 4 && this.f1998n > 16) {
            rehash(this.f1998n / 2);
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

    public byte getAndMoveToFirst(int k) {
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
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
                if (curr == 0) {
                    return this.defRetValue;
                }
            } while (k != curr);
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToFirst(this.f1998n);
            return this.value[this.f1998n];
        }
    }

    public byte getAndMoveToLast(int k) {
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
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
                if (curr == 0) {
                    return this.defRetValue;
                }
            } while (k != curr);
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return this.defRetValue;
        } else {
            moveIndexToLast(this.f1998n);
            return this.value[this.f1998n];
        }
    }

    public byte putAndMoveToFirst(int k, byte v) {
        int pos;
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            pos = mix;
            int curr2 = key[mix];
            if (curr2 != 0) {
                if (curr2 == k) {
                    moveIndexToFirst(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (curr != k);
                moveIndexToFirst(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToFirst(this.f1998n);
            return setValue(this.f1998n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1998n;
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
            rehash(HashCommon.arraySize(this.size, this.f1999f));
        }
        return this.defRetValue;
    }

    public byte putAndMoveToLast(int k, byte v) {
        int pos;
        int curr;
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            pos = mix;
            int curr2 = key[mix];
            if (curr2 != 0) {
                if (curr2 == k) {
                    moveIndexToLast(pos);
                    return setValue(pos, v);
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (curr != k);
                moveIndexToLast(pos);
                return setValue(pos, v);
            }
        } else if (this.containsNullKey) {
            moveIndexToLast(this.f1998n);
            return setValue(this.f1998n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1998n;
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
            rehash(HashCommon.arraySize(this.size, this.f1999f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    public byte get(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1998n] : this.defRetValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap, p014it.unimi.dsi.fastutil.ints.Int2ByteFunction, p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public boolean containsKey(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap, p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public boolean containsValue(byte v) {
        byte[] value = this.value;
        int[] key = this.key;
        if (this.containsNullKey && value[this.f1998n] == v) {
            return true;
        }
        int i = this.f1998n;
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    public byte getOrDefault(int k, byte defaultValue) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1998n] : defaultValue;
        }
        int[] key = this.key;
        int mix = HashCommon.mix(k) & this.mask;
        int pos = mix;
        int curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte putIfAbsent(int k, byte v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public boolean remove(int k, byte v) {
        if (k != 0) {
            int[] key = this.key;
            int mix = HashCommon.mix(k) & this.mask;
            int pos = mix;
            int curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (k == curr && v == this.value[pos]) {
                removeEntry(pos);
                return true;
            }
            while (true) {
                int i = (pos + 1) & this.mask;
                pos = i;
                int curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f1998n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public boolean replace(int k, byte oldValue, byte v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte replace(int k, byte v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        byte oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte computeIfAbsent(int k, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte computeIfAbsent(int key, Int2ByteFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        byte newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte computeIfAbsentNullable(int k, IntFunction<? extends Byte> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Byte newValue = (Byte) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        byte v = newValue.byteValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte computeIfPresent(int k, BiFunction<? super Integer, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Byte newValue = (Byte) remappingFunction.apply(Integer.valueOf(k), Byte.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        byte[] bArr = this.value;
        byte byteValue = newValue.byteValue();
        bArr[pos] = byteValue;
        return byteValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte compute(int k, BiFunction<? super Integer, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Byte newValue = (Byte) remappingFunction.apply(Integer.valueOf(k), pos >= 0 ? Byte.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == 0) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return this.defRetValue;
        }
        byte newVal = newValue.byteValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap
    public byte merge(int k, byte v, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
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
        Byte newValue = (Byte) remappingFunction.apply(Byte.valueOf(this.value[pos]), Byte.valueOf(v));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        byte[] bArr = this.value;
        byte byteValue = newValue.byteValue();
        bArr[pos] = byteValue;
        return byteValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, 0);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Int2ByteMap.Entry, Map.Entry<Integer, Byte>, IntBytePair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.Entry
        public int getIntKey() {
            return Int2ByteLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBytePair
        public int leftInt() {
            return Int2ByteLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.Entry
        public byte getByteValue() {
            return Int2ByteLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBytePair
        public byte rightByte() {
            return Int2ByteLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.Entry
        public byte setValue(byte v) {
            byte oldValue = Int2ByteLinkedOpenHashMap.this.value[this.index];
            Int2ByteLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBytePair
        public IntBytePair right(byte v) {
            Int2ByteLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Integer getKey() {
            return Integer.valueOf(Int2ByteLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getValue() {
            return Byte.valueOf(Int2ByteLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.Entry
        @Deprecated
        public Byte setValue(Byte v) {
            return Byte.valueOf(setValue(v.byteValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Integer, Byte> e = (Map.Entry) o;
            return Int2ByteLinkedOpenHashMap.this.key[this.index] == e.getKey().intValue() && Int2ByteLinkedOpenHashMap.this.value[this.index] == e.getValue().byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Int2ByteLinkedOpenHashMap.this.key[this.index] ^ Int2ByteLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Int2ByteLinkedOpenHashMap.this.key[this.index] + "=>" + ((int) Int2ByteLinkedOpenHashMap.this.value[this.index]);
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap
    public int firstIntKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap
    public int lastIntKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap
    public Int2ByteSortedMap tailMap(int from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap
    public Int2ByteSortedMap headMap(int to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap
    public Int2ByteSortedMap subMap(int from, int to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap, java.util.SortedMap
    public Comparator<? super Integer> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$MapIterator.class */
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
            this.next = Int2ByteLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(int from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == 0) {
                if (Int2ByteLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Int2ByteLinkedOpenHashMap.this.link[Int2ByteLinkedOpenHashMap.this.f1998n];
                    this.prev = Int2ByteLinkedOpenHashMap.this.f1998n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Int2ByteLinkedOpenHashMap.this.key[Int2ByteLinkedOpenHashMap.this.last] == from) {
                this.prev = Int2ByteLinkedOpenHashMap.this.last;
                this.index = Int2ByteLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix(from);
                int i = Int2ByteLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Int2ByteLinkedOpenHashMap.this.key[pos] == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Int2ByteLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Int2ByteLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Int2ByteLinkedOpenHashMap.this.mask;
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
                    this.index = Int2ByteLinkedOpenHashMap.this.size;
                } else {
                    int pos = Int2ByteLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Int2ByteLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Int2ByteLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Int2ByteLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Int2ByteLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0162, code lost:
            r0[r14] = r0;
            r11.this$0.value[r14] = r11.this$0.value[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x017f, code lost:
            if (r11.next != r14) goto L_0x0187;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0182, code lost:
            r11.next = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x018c, code lost:
            if (r11.prev != r14) goto L_0x0194;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x018f, code lost:
            r11.prev = r14;
         */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void remove() {
            /*
            // Method dump skipped, instructions count: 417
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap.MapIterator.remove():void");
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

        public void set(Int2ByteMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Int2ByteMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Int2ByteMap.Entry>> implements ObjectListIterator<Int2ByteMap.Entry> {
        private MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Int2ByteMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Int2ByteMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(int from) {
            super(from);
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Int2ByteMap.Entry> action, int index) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends MapIterator<Consumer<? super Int2ByteMap.Entry>> implements ObjectListIterator<Int2ByteMap.Entry> {
        final MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Int2ByteMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Int2ByteMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(int from) {
            super(from);
            this.entry = new MapEntry();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Int2ByteMap.Entry> action, int index) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Int2ByteMap.Entry> implements Int2ByteSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Int2ByteMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2ByteMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2ByteLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Int2ByteMap.Entry> comparator() {
            return null;
        }

        public ObjectSortedSet<Int2ByteMap.Entry> subSet(Int2ByteMap.Entry fromElement, Int2ByteMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Int2ByteMap.Entry> headSet(Int2ByteMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Int2ByteMap.Entry> tailSet(Int2ByteMap.Entry fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Int2ByteMap.Entry first() {
            if (Int2ByteLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Int2ByteLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Int2ByteMap.Entry last() {
            if (Int2ByteLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Int2ByteLinkedOpenHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            int curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            byte v = ((Byte) e.getValue()).byteValue();
            if (k == 0) {
                return Int2ByteLinkedOpenHashMap.this.containsNullKey && Int2ByteLinkedOpenHashMap.this.value[Int2ByteLinkedOpenHashMap.this.f1998n] == v;
            }
            int[] key = Int2ByteLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix(k) & Int2ByteLinkedOpenHashMap.this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Int2ByteLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Int2ByteLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Int2ByteLinkedOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Byte)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            byte v = ((Byte) e.getValue()).byteValue();
            if (k != 0) {
                int[] key = Int2ByteLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix(k) & Int2ByteLinkedOpenHashMap.this.mask;
                int pos = mix;
                int curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Int2ByteLinkedOpenHashMap.this.mask;
                        pos = i;
                        int curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Int2ByteLinkedOpenHashMap.this.value[pos] == v) {
                            Int2ByteLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Int2ByteLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Int2ByteLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Int2ByteLinkedOpenHashMap.this.containsNullKey || Int2ByteLinkedOpenHashMap.this.value[Int2ByteLinkedOpenHashMap.this.f1998n] != v) {
                return false;
            } else {
                Int2ByteLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ByteLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ByteLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Int2ByteMap.Entry> iterator(Int2ByteMap.Entry from) {
            return new EntryIterator(from.getIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.ints.Int2ByteMap.FastEntrySet
        public ObjectListIterator<Int2ByteMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap.FastSortedEntrySet
        public ObjectListIterator<Int2ByteMap.Entry> fastIterator(Int2ByteMap.Entry from) {
            return new FastEntryIterator(from.getIntKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2ByteMap.Entry> consumer) {
            int i = Int2ByteLinkedOpenHashMap.this.size;
            int next = Int2ByteLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2ByteLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractInt2ByteMap.BasicEntry(Int2ByteLinkedOpenHashMap.this.key[next], Int2ByteLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2ByteMap.Entry> consumer) {
            AbstractInt2ByteMap.BasicEntry entry = new AbstractInt2ByteMap.BasicEntry();
            int i = Int2ByteLinkedOpenHashMap.this.size;
            int next = Int2ByteLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2ByteLinkedOpenHashMap.this.link[next];
                    entry.key = Int2ByteLinkedOpenHashMap.this.key[next];
                    entry.value = Int2ByteLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteMap, p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap
    public Int2ByteSortedMap.FastSortedEntrySet int2ByteEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<IntConsumer> implements IntListIterator {
        @Override // java.util.PrimitiveIterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            forEachRemaining((KeyIterator) intConsumer);
        }

        public KeyIterator(int k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return Int2ByteLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(IntConsumer action, int index) {
            action.accept(Int2ByteLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return Int2ByteLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractIntSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntListIterator iterator(int from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntListIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntSpliterator spliterator() {
            return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2ByteLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer consumer) {
            int i = Int2ByteLinkedOpenHashMap.this.size;
            int next = Int2ByteLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2ByteLinkedOpenHashMap.this.link[next];
                    consumer.accept(Int2ByteLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2ByteLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2ByteLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldSize = Int2ByteLinkedOpenHashMap.this.size;
            Int2ByteLinkedOpenHashMap.this.remove(k);
            return Int2ByteLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2ByteLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            if (Int2ByteLinkedOpenHashMap.this.size != 0) {
                return Int2ByteLinkedOpenHashMap.this.key[Int2ByteLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            if (Int2ByteLinkedOpenHashMap.this.size != 0) {
                return Int2ByteLinkedOpenHashMap.this.key[Int2ByteLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet, java.util.SortedSet
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet tailSet(int from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet headSet(int to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntSortedSet subSet(int from, int to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap, p014it.unimi.dsi.fastutil.ints.Int2ByteMap, java.util.Map
    public IntSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<ByteConsumer> implements ByteListIterator {
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ByteConsumer byteConsumer) {
            forEachRemaining((ValueIterator) byteConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return Int2ByteLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Int2ByteLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Int2ByteLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap, p014it.unimi.dsi.fastutil.ints.Int2ByteMap, java.util.Map
    public ByteCollection values() {
        if (this.values == null) {
            this.values = new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.ints.Int2ByteLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
                public ByteIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
                public ByteSpliterator spliterator() {
                    return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2ByteLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
                public void forEach(ByteConsumer consumer) {
                    int i = Int2ByteLinkedOpenHashMap.this.size;
                    int next = Int2ByteLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Int2ByteLinkedOpenHashMap.this.link[next];
                            consumer.accept(Int2ByteLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Int2ByteLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
                public boolean contains(byte v) {
                    return Int2ByteLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Int2ByteLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1999f)));
        if (l >= this.f1998n || this.size > HashCommon.maxFill(l, this.f1999f)) {
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
        int[] key = this.key;
        byte[] value = this.value;
        int mask = newN - 1;
        int[] newKey = new int[newN + 1];
        byte[] newValue = new byte[newN + 1];
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
            if (key[i] != 0) {
                int mix = HashCommon.mix(key[i]);
                while (true) {
                    pos = mix & mask;
                    if (newKey[pos] == 0) {
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
        this.f1998n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f1998n, this.f1999f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Int2ByteLinkedOpenHashMap clone() {
        try {
            Int2ByteLinkedOpenHashMap c = (Int2ByteLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (int[]) this.key.clone();
            c.value = (byte[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2ByteMap, java.lang.Object, java.util.Map
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
            h += this.key[i] ^ this.value[i];
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1998n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int[] key = this.key;
        byte[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeInt(key[e]);
                s.writeByte(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1998n = HashCommon.arraySize(this.size, this.f1999f);
        this.maxFill = HashCommon.maxFill(this.f1998n, this.f1999f);
        this.mask = this.f1998n - 1;
        int[] key = new int[this.f1998n + 1];
        this.key = key;
        byte[] value = new byte[this.f1998n + 1];
        this.value = value;
        long[] link = new long[this.f1998n + 1];
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
            int k = s.readInt();
            byte v = s.readByte();
            if (k != 0) {
                int mix = HashCommon.mix(k);
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
                pos = this.f1998n;
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
