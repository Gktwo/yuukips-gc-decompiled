package p014it.unimi.dsi.fastutil.bytes;

import emu.grasscutter.net.proto.RetcodeOuterClass;
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
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanListIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap.class */
public class Byte2BooleanLinkedOpenHashMap extends AbstractByte2BooleanSortedMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient byte[] key;
    protected transient boolean[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f1090n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1091f;
    protected transient Byte2BooleanSortedMap.FastSortedEntrySet entries;
    protected transient ByteSortedSet keys;
    protected transient BooleanCollection values;

    public Byte2BooleanLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1091f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1090n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1090n - 1;
            this.maxFill = HashCommon.maxFill(this.f1090n, f);
            this.key = new byte[this.f1090n + 1];
            this.value = new boolean[this.f1090n + 1];
            this.link = new long[this.f1090n + 1];
        }
    }

    public Byte2BooleanLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Byte2BooleanLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Byte2BooleanLinkedOpenHashMap(Map<? extends Byte, ? extends Boolean> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Byte2BooleanLinkedOpenHashMap(Map<? extends Byte, ? extends Boolean> m) {
        this(m, 0.75f);
    }

    public Byte2BooleanLinkedOpenHashMap(Byte2BooleanMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Byte2BooleanLinkedOpenHashMap(Byte2BooleanMap m) {
        this(m, 0.75f);
    }

    public Byte2BooleanLinkedOpenHashMap(byte[] k, boolean[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Byte2BooleanLinkedOpenHashMap(byte[] k, boolean[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1091f);
        if (needed > this.f1090n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1091f)))));
        if (needed > this.f1090n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public boolean removeEntry(int pos) {
        boolean oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f1090n > this.minN && this.size < this.maxFill / 4 && this.f1090n > 16) {
            rehash(this.f1090n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public boolean removeNullEntry() {
        this.containsNullKey = false;
        boolean oldValue = this.value[this.f1090n];
        this.size--;
        fixPointers(this.f1090n);
        if (this.f1090n > this.minN && this.size < this.maxFill / 4 && this.f1090n > 16) {
            rehash(this.f1090n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap, java.util.Map
    public void putAll(Map<? extends Byte, ? extends Boolean> m) {
        if (((double) this.f1091f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? this.f1090n : -(this.f1090n + 1);
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    private void insert(int pos, byte k, boolean v) {
        if (pos == this.f1090n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1091f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
    public boolean put(byte k, boolean v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        boolean oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    protected final void shiftKeys(int pos) {
        byte curr;
        byte[] key = this.key;
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
            fixPointers(pos, pos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
    public boolean remove(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : this.defRetValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    private boolean setValue(int pos, boolean v) {
        boolean oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public boolean removeFirstBoolean() {
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
        boolean v = this.value[pos];
        if (pos == this.f1090n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1090n > this.minN && this.size < this.maxFill / 4 && this.f1090n > 16) {
            rehash(this.f1090n / 2);
        }
        return v;
    }

    public boolean removeLastBoolean() {
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
        boolean v = this.value[pos];
        if (pos == this.f1090n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f1090n > this.minN && this.size < this.maxFill / 4 && this.f1090n > 16) {
            rehash(this.f1090n / 2);
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

    public boolean getAndMoveToFirst(byte k) {
        byte curr;
        if (k != 0) {
            byte[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            byte curr2 = key[mix];
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
            moveIndexToFirst(this.f1090n);
            return this.value[this.f1090n];
        }
    }

    public boolean getAndMoveToLast(byte k) {
        byte curr;
        if (k != 0) {
            byte[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            byte curr2 = key[mix];
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
            moveIndexToLast(this.f1090n);
            return this.value[this.f1090n];
        }
    }

    public boolean putAndMoveToFirst(byte k, boolean v) {
        int pos;
        byte curr;
        if (k != 0) {
            byte[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            byte curr2 = key[mix];
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
            moveIndexToFirst(this.f1090n);
            return setValue(this.f1090n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1090n;
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
            rehash(HashCommon.arraySize(this.size, this.f1091f));
        }
        return this.defRetValue;
    }

    public boolean putAndMoveToLast(byte k, boolean v) {
        int pos;
        byte curr;
        if (k != 0) {
            byte[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            byte curr2 = key[mix];
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
            moveIndexToLast(this.f1090n);
            return setValue(this.f1090n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1090n;
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
            rehash(HashCommon.arraySize(this.size, this.f1091f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
    public boolean get(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1090n] : this.defRetValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean containsKey(byte k) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean containsValue(boolean v) {
        boolean[] value = this.value;
        byte[] key = this.key;
        if (this.containsNullKey && value[this.f1090n] == v) {
            return true;
        }
        int i = this.f1090n;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
    public boolean getOrDefault(byte k, boolean defaultValue) {
        byte curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1090n] : defaultValue;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean putIfAbsent(byte k, boolean v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean remove(byte k, boolean v) {
        if (k != 0) {
            byte[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            byte curr = key[mix];
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
                byte curr2 = key[i];
                if (curr2 == 0) {
                    return false;
                }
                if (k == curr2 && v == this.value[pos]) {
                    removeEntry(pos);
                    return true;
                }
            }
        } else if (!this.containsNullKey || v != this.value[this.f1090n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean replace(byte k, boolean oldValue, boolean v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean replace(byte k, boolean v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        boolean oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean computeIfAbsent(byte k, IntPredicate mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        boolean newValue = mappingFunction.test(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean computeIfAbsent(byte key, Byte2BooleanFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        boolean newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean computeIfAbsentNullable(byte k, IntFunction<? extends Boolean> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Boolean newValue = (Boolean) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        boolean v = newValue.booleanValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean computeIfPresent(byte k, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Boolean newValue = (Boolean) remappingFunction.apply(Byte.valueOf(k), Boolean.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        boolean[] zArr = this.value;
        boolean booleanValue = newValue.booleanValue();
        zArr[pos] = booleanValue;
        return booleanValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean compute(byte k, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Boolean newValue = (Boolean) remappingFunction.apply(Byte.valueOf(k), pos >= 0 ? Boolean.valueOf(this.value[pos]) : null);
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
        boolean newVal = newValue.booleanValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
    public boolean merge(byte k, boolean v, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
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
        Boolean newValue = (Boolean) remappingFunction.apply(Boolean.valueOf(this.value[pos]), Boolean.valueOf(v));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        boolean[] zArr = this.value;
        boolean booleanValue = newValue.booleanValue();
        zArr[pos] = booleanValue;
        return booleanValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, (byte) 0);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Byte2BooleanMap.Entry, Map.Entry<Byte, Boolean>, ByteBooleanPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.Entry
        public byte getByteKey() {
            return Byte2BooleanLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBooleanPair
        public byte leftByte() {
            return Byte2BooleanLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.Entry
        public boolean getBooleanValue() {
            return Byte2BooleanLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBooleanPair
        public boolean rightBoolean() {
            return Byte2BooleanLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.Entry
        public boolean setValue(boolean v) {
            boolean oldValue = Byte2BooleanLinkedOpenHashMap.this.value[this.index];
            Byte2BooleanLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBooleanPair
        public ByteBooleanPair right(boolean v) {
            Byte2BooleanLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.Entry, java.util.Map.Entry
        @Deprecated
        public Byte getKey() {
            return Byte.valueOf(Byte2BooleanLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.Entry, java.util.Map.Entry
        @Deprecated
        public Boolean getValue() {
            return Boolean.valueOf(Byte2BooleanLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.Entry
        @Deprecated
        public Boolean setValue(Boolean v) {
            return Boolean.valueOf(setValue(v.booleanValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Byte, Boolean> e = (Map.Entry) o;
            return Byte2BooleanLinkedOpenHashMap.this.key[this.index] == e.getKey().byteValue() && Byte2BooleanLinkedOpenHashMap.this.value[this.index] == e.getValue().booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Byte2BooleanLinkedOpenHashMap.this.key[this.index] ^ (Byte2BooleanLinkedOpenHashMap.this.value[this.index] ? (byte) 1231 : 1237);
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) Byte2BooleanLinkedOpenHashMap.this.key[this.index]) + "=>" + Byte2BooleanLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
    public byte firstByteKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
    public byte lastByteKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
    public Byte2BooleanSortedMap tailMap(byte from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
    public Byte2BooleanSortedMap headMap(byte to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
    public Byte2BooleanSortedMap subMap(byte from, byte to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap, java.util.SortedMap
    public Comparator<? super Byte> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$MapIterator.class */
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
            this.next = Byte2BooleanLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(byte from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == 0) {
                if (Byte2BooleanLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Byte2BooleanLinkedOpenHashMap.this.link[Byte2BooleanLinkedOpenHashMap.this.f1090n];
                    this.prev = Byte2BooleanLinkedOpenHashMap.this.f1090n;
                    return;
                }
                throw new NoSuchElementException("The key " + ((int) from) + " does not belong to this map.");
            } else if (Byte2BooleanLinkedOpenHashMap.this.key[Byte2BooleanLinkedOpenHashMap.this.last] == from) {
                this.prev = Byte2BooleanLinkedOpenHashMap.this.last;
                this.index = Byte2BooleanLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix((int) from);
                int i = Byte2BooleanLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Byte2BooleanLinkedOpenHashMap.this.key[pos] == 0) {
                        throw new NoSuchElementException("The key " + ((int) from) + " does not belong to this map.");
                    } else if (Byte2BooleanLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Byte2BooleanLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Byte2BooleanLinkedOpenHashMap.this.mask;
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
                    this.index = Byte2BooleanLinkedOpenHashMap.this.size;
                } else {
                    int pos = Byte2BooleanLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Byte2BooleanLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Byte2BooleanLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Byte2BooleanLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Byte2BooleanLinkedOpenHashMap.this.link[this.curr];
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap.MapIterator.remove():void");
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

        public void set(Byte2BooleanMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Byte2BooleanMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Byte2BooleanMap.Entry>> implements ObjectListIterator<Byte2BooleanMap.Entry> {
        private MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Byte2BooleanMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Byte2BooleanMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(byte from) {
            super(from);
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Byte2BooleanMap.Entry> action, int index) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends MapIterator<Consumer<? super Byte2BooleanMap.Entry>> implements ObjectListIterator<Byte2BooleanMap.Entry> {
        final MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Byte2BooleanMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Byte2BooleanMap.Entry) obj);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(byte from) {
            super(from);
            this.entry = new MapEntry();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(Consumer<? super Byte2BooleanMap.Entry> action, int index) {
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Byte2BooleanMap.Entry> implements Byte2BooleanSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Byte2BooleanMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2BooleanMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Byte2BooleanLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Byte2BooleanMap.Entry> comparator() {
            return null;
        }

        public ObjectSortedSet<Byte2BooleanMap.Entry> subSet(Byte2BooleanMap.Entry fromElement, Byte2BooleanMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Byte2BooleanMap.Entry> headSet(Byte2BooleanMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Byte2BooleanMap.Entry> tailSet(Byte2BooleanMap.Entry fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Byte2BooleanMap.Entry first() {
            if (Byte2BooleanLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Byte2BooleanLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Byte2BooleanMap.Entry last() {
            if (Byte2BooleanLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Byte2BooleanLinkedOpenHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            byte curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            if (k == 0) {
                return Byte2BooleanLinkedOpenHashMap.this.containsNullKey && Byte2BooleanLinkedOpenHashMap.this.value[Byte2BooleanLinkedOpenHashMap.this.f1090n] == v;
            }
            byte[] key = Byte2BooleanLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Byte2BooleanLinkedOpenHashMap.this.mask;
            int pos = mix;
            byte curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Byte2BooleanLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Byte2BooleanLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Byte2BooleanLinkedOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            byte k = ((Byte) e.getKey()).byteValue();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            if (k != 0) {
                byte[] key = Byte2BooleanLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Byte2BooleanLinkedOpenHashMap.this.mask;
                int pos = mix;
                byte curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Byte2BooleanLinkedOpenHashMap.this.mask;
                        pos = i;
                        byte curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Byte2BooleanLinkedOpenHashMap.this.value[pos] == v) {
                            Byte2BooleanLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Byte2BooleanLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Byte2BooleanLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Byte2BooleanLinkedOpenHashMap.this.containsNullKey || Byte2BooleanLinkedOpenHashMap.this.value[Byte2BooleanLinkedOpenHashMap.this.f1090n] != v) {
                return false;
            } else {
                Byte2BooleanLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2BooleanLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2BooleanLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Byte2BooleanMap.Entry> iterator(Byte2BooleanMap.Entry from) {
            return new EntryIterator(from.getByteKey());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.FastEntrySet
        public ObjectListIterator<Byte2BooleanMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap.FastSortedEntrySet
        public ObjectListIterator<Byte2BooleanMap.Entry> fastIterator(Byte2BooleanMap.Entry from) {
            return new FastEntryIterator(from.getByteKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Byte2BooleanMap.Entry> consumer) {
            int i = Byte2BooleanLinkedOpenHashMap.this.size;
            int next = Byte2BooleanLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Byte2BooleanLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractByte2BooleanMap.BasicEntry(Byte2BooleanLinkedOpenHashMap.this.key[next], Byte2BooleanLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap.FastEntrySet
        public void fastForEach(Consumer<? super Byte2BooleanMap.Entry> consumer) {
            AbstractByte2BooleanMap.BasicEntry entry = new AbstractByte2BooleanMap.BasicEntry();
            int i = Byte2BooleanLinkedOpenHashMap.this.size;
            int next = Byte2BooleanLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Byte2BooleanLinkedOpenHashMap.this.link[next];
                    entry.key = Byte2BooleanLinkedOpenHashMap.this.key[next];
                    entry.value = Byte2BooleanLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
    public Byte2BooleanSortedMap.FastSortedEntrySet byte2BooleanEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends MapIterator<ByteConsumer> implements ByteListIterator {
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(ByteConsumer byteConsumer) {
            forEachRemaining((KeyIterator) byteConsumer);
        }

        public KeyIterator(byte k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return Byte2BooleanLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(ByteConsumer action, int index) {
            action.accept(Byte2BooleanLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return Byte2BooleanLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractByteSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteListIterator iterator(byte from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteListIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteSpliterator spliterator() {
            return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(Byte2BooleanLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
        public void forEach(ByteConsumer consumer) {
            int i = Byte2BooleanLinkedOpenHashMap.this.size;
            int next = Byte2BooleanLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Byte2BooleanLinkedOpenHashMap.this.link[next];
                    consumer.accept(Byte2BooleanLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Byte2BooleanLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return Byte2BooleanLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            int oldSize = Byte2BooleanLinkedOpenHashMap.this.size;
            Byte2BooleanLinkedOpenHashMap.this.remove(k);
            return Byte2BooleanLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Byte2BooleanLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            if (Byte2BooleanLinkedOpenHashMap.this.size != 0) {
                return Byte2BooleanLinkedOpenHashMap.this.key[Byte2BooleanLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            if (Byte2BooleanLinkedOpenHashMap.this.size != 0) {
                return Byte2BooleanLinkedOpenHashMap.this.key[Byte2BooleanLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanSortedMap, p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public ByteSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<BooleanConsumer> implements BooleanListIterator {
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(BooleanConsumer booleanConsumer) {
            forEachRemaining((ValueIterator) booleanConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            return Byte2BooleanLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(BooleanConsumer action, int index) {
            action.accept(Byte2BooleanLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return Byte2BooleanLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanSortedMap, p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public BooleanCollection values() {
        if (this.values == null) {
            this.values = new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.bytes.Byte2BooleanLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                public BooleanIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                public BooleanSpliterator spliterator() {
                    return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(Byte2BooleanLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
                public void forEach(BooleanConsumer consumer) {
                    int i = Byte2BooleanLinkedOpenHashMap.this.size;
                    int next = Byte2BooleanLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Byte2BooleanLinkedOpenHashMap.this.link[next];
                            consumer.accept(Byte2BooleanLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Byte2BooleanLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
                public boolean contains(boolean v) {
                    return Byte2BooleanLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Byte2BooleanLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1091f)));
        if (l >= this.f1090n || this.size > HashCommon.maxFill(l, this.f1091f)) {
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
        byte[] key = this.key;
        boolean[] value = this.value;
        int mask = newN - 1;
        byte[] newKey = new byte[newN + 1];
        boolean[] newValue = new boolean[newN + 1];
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
                int mix = HashCommon.mix((int) key[i]);
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
        this.f1090n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f1090n, this.f1091f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Byte2BooleanLinkedOpenHashMap clone() {
        try {
            Byte2BooleanLinkedOpenHashMap c = (Byte2BooleanLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (byte[]) this.key.clone();
            c.value = (boolean[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap, java.lang.Object, java.util.Map
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
            h += this.key[i] ^ (this.value[i] ? (byte) 1231 : 1237);
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1090n] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE;
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        byte[] key = this.key;
        boolean[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeByte(key[e]);
                s.writeBoolean(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1090n = HashCommon.arraySize(this.size, this.f1091f);
        this.maxFill = HashCommon.maxFill(this.f1090n, this.f1091f);
        this.mask = this.f1090n - 1;
        byte[] key = new byte[this.f1090n + 1];
        this.key = key;
        boolean[] value = new boolean[this.f1090n + 1];
        this.value = value;
        long[] link = new long[this.f1090n + 1];
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
            byte k = s.readByte();
            boolean v = s.readBoolean();
            if (k != 0) {
                int mix = HashCommon.mix((int) k);
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
                pos = this.f1090n;
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
