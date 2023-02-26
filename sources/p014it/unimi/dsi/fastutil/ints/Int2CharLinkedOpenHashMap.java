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
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharListIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap;
import p014it.unimi.dsi.fastutil.ints.Int2CharMap;
import p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap.class */
public class Int2CharLinkedOpenHashMap extends AbstractInt2CharSortedMap implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient int[] key;
    protected transient char[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2010n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2011f;
    protected transient Int2CharSortedMap.FastSortedEntrySet entries;
    protected transient IntSortedSet keys;
    protected transient CharCollection values;

    public Int2CharLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2011f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2010n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2010n - 1;
            this.maxFill = HashCommon.maxFill(this.f2010n, f);
            this.key = new int[this.f2010n + 1];
            this.value = new char[this.f2010n + 1];
            this.link = new long[this.f2010n + 1];
        }
    }

    public Int2CharLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Int2CharLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Int2CharLinkedOpenHashMap(Map<? extends Integer, ? extends Character> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2CharLinkedOpenHashMap(Map<? extends Integer, ? extends Character> m) {
        this(m, 0.75f);
    }

    public Int2CharLinkedOpenHashMap(Int2CharMap m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Int2CharLinkedOpenHashMap(Int2CharMap m) {
        this(m, 0.75f);
    }

    public Int2CharLinkedOpenHashMap(int[] k, char[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Int2CharLinkedOpenHashMap(int[] k, char[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2011f);
        if (needed > this.f2010n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2011f)))));
        if (needed > this.f2010n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public char removeEntry(int pos) {
        char oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2010n > this.minN && this.size < this.maxFill / 4 && this.f2010n > 16) {
            rehash(this.f2010n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public char removeNullEntry() {
        this.containsNullKey = false;
        char oldValue = this.value[this.f2010n];
        this.size--;
        fixPointers(this.f2010n);
        if (this.f2010n > this.minN && this.size < this.maxFill / 4 && this.f2010n > 16) {
            rehash(this.f2010n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, java.util.Map
    public void putAll(Map<? extends Integer, ? extends Character> m) {
        if (((double) this.f2011f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.f2010n : -(this.f2010n + 1);
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

    private void insert(int pos, int k, char v) {
        if (pos == this.f2010n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2011f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char put(int k, char v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return this.defRetValue;
        }
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    private char addToValue(int pos, char incr) {
        char oldValue = this.value[pos];
        this.value[pos] = (char) (oldValue + incr);
        return oldValue;
    }

    public char addTo(int k, char incr) {
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
            return addToValue(this.f2010n, incr);
        } else {
            pos = this.f2010n;
            this.containsNullKey = true;
        }
        this.key[pos] = k;
        this.value[pos] = (char) (this.defRetValue + incr);
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2011f));
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char remove(int k) {
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

    private char setValue(int pos, char v) {
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public char removeFirstChar() {
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
        char v = this.value[pos];
        if (pos == this.f2010n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f2010n > this.minN && this.size < this.maxFill / 4 && this.f2010n > 16) {
            rehash(this.f2010n / 2);
        }
        return v;
    }

    public char removeLastChar() {
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
        char v = this.value[pos];
        if (pos == this.f2010n) {
            this.containsNullKey = false;
        } else {
            shiftKeys(pos);
        }
        if (this.f2010n > this.minN && this.size < this.maxFill / 4 && this.f2010n > 16) {
            rehash(this.f2010n / 2);
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

    public char getAndMoveToFirst(int k) {
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
            moveIndexToFirst(this.f2010n);
            return this.value[this.f2010n];
        }
    }

    public char getAndMoveToLast(int k) {
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
            moveIndexToLast(this.f2010n);
            return this.value[this.f2010n];
        }
    }

    public char putAndMoveToFirst(int k, char v) {
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
            moveIndexToFirst(this.f2010n);
            return setValue(this.f2010n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2010n;
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
            rehash(HashCommon.arraySize(this.size, this.f2011f));
        }
        return this.defRetValue;
    }

    public char putAndMoveToLast(int k, char v) {
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
            moveIndexToLast(this.f2010n);
            return setValue(this.f2010n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2010n;
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
            rehash(HashCommon.arraySize(this.size, this.f2011f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char get(int k) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2010n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharFunction, p014it.unimi.dsi.fastutil.ints.Int2CharMap
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public boolean containsValue(char v) {
        char[] value = this.value;
        int[] key = this.key;
        if (this.containsNullKey && value[this.f2010n] == v) {
            return true;
        }
        int i = this.f2010n;
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char getOrDefault(int k, char defaultValue) {
        int curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f2010n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char putIfAbsent(int k, char v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public boolean remove(int k, char v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2010n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public boolean replace(int k, char oldValue, char v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char replace(int k, char v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        char oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char computeIfAbsent(int k, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(k));
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char computeIfAbsent(int key, Int2CharFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        char newValue = mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char computeIfAbsentNullable(int k, IntFunction<? extends Character> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        Character newValue = (Character) mappingFunction.apply(k);
        if (newValue == null) {
            return this.defRetValue;
        }
        char v = newValue.charValue();
        insert((-pos) - 1, k, v);
        return v;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char computeIfPresent(int k, BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Character newValue = (Character) remappingFunction.apply(Integer.valueOf(k), Character.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        char[] cArr = this.value;
        char charValue = newValue.charValue();
        cArr[pos] = charValue;
        return charValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char compute(int k, BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Character newValue = (Character) remappingFunction.apply(Integer.valueOf(k), pos >= 0 ? Character.valueOf(this.value[pos]) : null);
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
        char newVal = newValue.charValue();
        if (pos < 0) {
            insert((-pos) - 1, k, newVal);
            return newVal;
        }
        this.value[pos] = newVal;
        return newVal;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public char merge(int k, char v, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
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
        Character newValue = (Character) remappingFunction.apply(Character.valueOf(this.value[pos]), Character.valueOf(v));
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return this.defRetValue;
        }
        char[] cArr = this.value;
        char charValue = newValue.charValue();
        cArr[pos] = charValue;
        return charValue;
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Int2CharMap.Entry, Map.Entry<Integer, Character>, IntCharPair {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry
        public int getIntKey() {
            return Int2CharLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCharPair
        public int leftInt() {
            return Int2CharLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry
        public char getCharValue() {
            return Int2CharLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCharPair
        public char rightChar() {
            return Int2CharLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry
        public char setValue(char v) {
            char oldValue = Int2CharLinkedOpenHashMap.this.value[this.index];
            Int2CharLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntCharPair
        public IntCharPair right(char v) {
            Int2CharLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Integer getKey() {
            return Integer.valueOf(Int2CharLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getValue() {
            return Character.valueOf(Int2CharLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry
        @Deprecated
        public Character setValue(Character v) {
            return Character.valueOf(setValue(v.charValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Integer, Character> e = (Map.Entry) o;
            return Int2CharLinkedOpenHashMap.this.key[this.index] == e.getKey().intValue() && Int2CharLinkedOpenHashMap.this.value[this.index] == e.getValue().charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Int2CharLinkedOpenHashMap.this.key[this.index] ^ Int2CharLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.lang.Object
        public String toString() {
            return Int2CharLinkedOpenHashMap.this.key[this.index] + "=>" + Int2CharLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    public int firstIntKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    public int lastIntKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    public Int2CharSortedMap tailMap(int from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    public Int2CharSortedMap headMap(int to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    public Int2CharSortedMap subMap(int from, int to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
    public Comparator<? super Integer> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$MapIterator.class */
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
            this.next = Int2CharLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(int from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == 0) {
                if (Int2CharLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Int2CharLinkedOpenHashMap.this.link[Int2CharLinkedOpenHashMap.this.f2010n];
                    this.prev = Int2CharLinkedOpenHashMap.this.f2010n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Int2CharLinkedOpenHashMap.this.key[Int2CharLinkedOpenHashMap.this.last] == from) {
                this.prev = Int2CharLinkedOpenHashMap.this.last;
                this.index = Int2CharLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix(from);
                int i = Int2CharLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Int2CharLinkedOpenHashMap.this.key[pos] == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Int2CharLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Int2CharLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Int2CharLinkedOpenHashMap.this.mask;
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
                    this.index = Int2CharLinkedOpenHashMap.this.size;
                } else {
                    int pos = Int2CharLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Int2CharLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Int2CharLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Int2CharLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Int2CharLinkedOpenHashMap.this.link[this.curr];
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap.MapIterator.remove():void");
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

        public void set(Int2CharMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Int2CharMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends MapIterator<Consumer<? super Int2CharMap.Entry>> implements ObjectListIterator<Int2CharMap.Entry> {
        private MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Int2CharMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Int2CharMap.Entry) obj);
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
        public final void acceptOnIndex(Consumer<? super Int2CharMap.Entry> action, int index) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends MapIterator<Consumer<? super Int2CharMap.Entry>> implements ObjectListIterator<Int2CharMap.Entry> {
        final MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Int2CharMap.Entry) obj);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Int2CharMap.Entry) obj);
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
        public final void acceptOnIndex(Consumer<? super Int2CharMap.Entry> action, int index) {
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Int2CharMap.Entry> implements Int2CharSortedMap.FastSortedEntrySet {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Int2CharMap.Entry> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Int2CharMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2CharLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Int2CharMap.Entry> comparator() {
            return null;
        }

        public ObjectSortedSet<Int2CharMap.Entry> subSet(Int2CharMap.Entry fromElement, Int2CharMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Int2CharMap.Entry> headSet(Int2CharMap.Entry toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Int2CharMap.Entry> tailSet(Int2CharMap.Entry fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Int2CharMap.Entry first() {
            if (Int2CharLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Int2CharLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Int2CharMap.Entry last() {
            if (Int2CharLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Int2CharLinkedOpenHashMap.this.last);
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
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            char v = ((Character) e.getValue()).charValue();
            if (k == 0) {
                return Int2CharLinkedOpenHashMap.this.containsNullKey && Int2CharLinkedOpenHashMap.this.value[Int2CharLinkedOpenHashMap.this.f2010n] == v;
            }
            int[] key = Int2CharLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix(k) & Int2CharLinkedOpenHashMap.this.mask;
            int pos = mix;
            int curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Int2CharLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Int2CharLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Int2CharLinkedOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                return false;
            }
            int k = ((Integer) e.getKey()).intValue();
            char v = ((Character) e.getValue()).charValue();
            if (k != 0) {
                int[] key = Int2CharLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix(k) & Int2CharLinkedOpenHashMap.this.mask;
                int pos = mix;
                int curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Int2CharLinkedOpenHashMap.this.mask;
                        pos = i;
                        int curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Int2CharLinkedOpenHashMap.this.value[pos] == v) {
                            Int2CharLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Int2CharLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Int2CharLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Int2CharLinkedOpenHashMap.this.containsNullKey || Int2CharLinkedOpenHashMap.this.value[Int2CharLinkedOpenHashMap.this.f2010n] != v) {
                return false;
            } else {
                Int2CharLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2CharLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2CharLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Int2CharMap.Entry> iterator(Int2CharMap.Entry from) {
            return new EntryIterator(from.getIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.ints.Int2CharMap.FastEntrySet
        public ObjectListIterator<Int2CharMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap.FastSortedEntrySet
        public ObjectListIterator<Int2CharMap.Entry> fastIterator(Int2CharMap.Entry from) {
            return new FastEntryIterator(from.getIntKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Int2CharMap.Entry> consumer) {
            int i = Int2CharLinkedOpenHashMap.this.size;
            int next = Int2CharLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2CharLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractInt2CharMap.BasicEntry(Int2CharLinkedOpenHashMap.this.key[next], Int2CharLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.FastEntrySet
        public void fastForEach(Consumer<? super Int2CharMap.Entry> consumer) {
            AbstractInt2CharMap.BasicEntry entry = new AbstractInt2CharMap.BasicEntry();
            int i = Int2CharLinkedOpenHashMap.this.size;
            int next = Int2CharLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2CharLinkedOpenHashMap.this.link[next];
                    entry.key = Int2CharLinkedOpenHashMap.this.key[next];
                    entry.value = Int2CharLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    public Int2CharSortedMap.FastSortedEntrySet int2CharEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$KeyIterator.class */
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
            return Int2CharLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(IntConsumer action, int index) {
            action.accept(Int2CharLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return Int2CharLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$KeySet.class */
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
            return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2CharLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterable
        public void forEach(IntConsumer consumer) {
            int i = Int2CharLinkedOpenHashMap.this.size;
            int next = Int2CharLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Int2CharLinkedOpenHashMap.this.link[next];
                    consumer.accept(Int2CharLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Int2CharLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
        public boolean contains(int k) {
            return Int2CharLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.IntSet
        public boolean remove(int k) {
            int oldSize = Int2CharLinkedOpenHashMap.this.size;
            Int2CharLinkedOpenHashMap.this.remove(k);
            return Int2CharLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Int2CharLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int firstInt() {
            if (Int2CharLinkedOpenHashMap.this.size != 0) {
                return Int2CharLinkedOpenHashMap.this.key[Int2CharLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public int lastInt() {
            if (Int2CharLinkedOpenHashMap.this.size != 0) {
                return Int2CharLinkedOpenHashMap.this.key[Int2CharLinkedOpenHashMap.this.last];
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public IntSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends MapIterator<CharConsumer> implements CharListIterator {
        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(CharConsumer charConsumer) {
            forEachRemaining((ValueIterator) charConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return Int2CharLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Int2CharLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Int2CharLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public CharCollection values() {
        if (this.values == null) {
            this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.ints.Int2CharLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
                public CharIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
                public CharSpliterator spliterator() {
                    return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(Int2CharLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
                public void forEach(CharConsumer consumer) {
                    int i = Int2CharLinkedOpenHashMap.this.size;
                    int next = Int2CharLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Int2CharLinkedOpenHashMap.this.link[next];
                            consumer.accept(Int2CharLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Int2CharLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                public boolean contains(char v) {
                    return Int2CharLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Int2CharLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2011f)));
        if (l >= this.f2010n || this.size > HashCommon.maxFill(l, this.f2011f)) {
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
        char[] value = this.value;
        int mask = newN - 1;
        int[] newKey = new int[newN + 1];
        char[] newValue = new char[newN + 1];
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
        this.f2010n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2010n, this.f2011f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Int2CharLinkedOpenHashMap clone() {
        try {
            Int2CharLinkedOpenHashMap c = (Int2CharLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (int[]) this.key.clone();
            c.value = (char[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap, java.lang.Object, java.util.Map
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
            h += this.value[this.f2010n];
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int[] key = this.key;
        char[] value = this.value;
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeInt(key[e]);
                s.writeChar(value[e]);
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f2010n = HashCommon.arraySize(this.size, this.f2011f);
        this.maxFill = HashCommon.maxFill(this.f2010n, this.f2011f);
        this.mask = this.f2010n - 1;
        int[] key = new int[this.f2010n + 1];
        this.key = key;
        char[] value = new char[this.f2010n + 1];
        this.value = value;
        long[] link = new long[this.f2010n + 1];
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
            char v = s.readChar();
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
                pos = this.f2010n;
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
