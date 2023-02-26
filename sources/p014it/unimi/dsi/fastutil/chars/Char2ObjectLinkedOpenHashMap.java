package p014it.unimi.dsi.fastutil.chars;

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
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap.class */
public class Char2ObjectLinkedOpenHashMap<V> extends AbstractChar2ObjectSortedMap<V> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient char[] key;
    protected transient V[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f1401n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1402f;
    protected transient Char2ObjectSortedMap.FastSortedEntrySet<V> entries;
    protected transient CharSortedSet keys;
    protected transient ObjectCollection<V> values;

    public Char2ObjectLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1402f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1401n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1401n - 1;
            this.maxFill = HashCommon.maxFill(this.f1401n, f);
            this.key = new char[this.f1401n + 1];
            this.value = (V[]) new Object[this.f1401n + 1];
            this.link = new long[this.f1401n + 1];
        }
    }

    public Char2ObjectLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Char2ObjectLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Char2ObjectLinkedOpenHashMap(Map<? extends Character, ? extends V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Char2ObjectLinkedOpenHashMap(Map<? extends Character, ? extends V> m) {
        this(m, 0.75f);
    }

    public Char2ObjectLinkedOpenHashMap(Char2ObjectMap<V> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Char2ObjectLinkedOpenHashMap(Char2ObjectMap<V> m) {
        this((Char2ObjectMap) m, 0.75f);
    }

    public Char2ObjectLinkedOpenHashMap(char[] k, V[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (char) v[i]);
        }
    }

    public Char2ObjectLinkedOpenHashMap(char[] k, V[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1402f);
        if (needed > this.f1401n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1402f)))));
        if (needed > this.f1401n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public V removeEntry(int pos) {
        V oldValue = this.value[pos];
        this.value[pos] = null;
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f1401n > this.minN && this.size < this.maxFill / 4 && this.f1401n > 16) {
            rehash(this.f1401n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.f1401n];
        this.value[this.f1401n] = null;
        this.size--;
        fixPointers(this.f1401n);
        if (this.f1401n > this.minN && this.size < this.maxFill / 4 && this.f1401n > 16) {
            rehash(this.f1401n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.util.Map
    public void putAll(Map<? extends Character, ? extends V> m) {
        if (((double) this.f1402f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? this.f1401n : -(this.f1401n + 1);
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    private void insert(int pos, char k, V v) {
        if (pos == this.f1401n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f1402f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V put(char k, V v) {
        int pos = find(k);
        if (pos < 0) {
            insert((-pos) - 1, k, v);
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    protected final void shiftKeys(int pos) {
        char curr;
        char[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (curr == 0) {
                    key[pos] = 0;
                    this.value[pos] = null;
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V remove(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? removeNullEntry() : (V) this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (k == curr2) {
            return removeEntry(pos);
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (k != curr);
        return removeEntry(pos);
    }

    private V setValue(int pos, V v) {
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    public V removeFirst() {
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
        V v = this.value[pos];
        if (pos == this.f1401n) {
            this.containsNullKey = false;
            this.value[this.f1401n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f1401n > this.minN && this.size < this.maxFill / 4 && this.f1401n > 16) {
            rehash(this.f1401n / 2);
        }
        return v;
    }

    public V removeLast() {
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
        V v = this.value[pos];
        if (pos == this.f1401n) {
            this.containsNullKey = false;
            this.value[this.f1401n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f1401n > this.minN && this.size < this.maxFill / 4 && this.f1401n > 16) {
            rehash(this.f1401n / 2);
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

    public V getAndMoveToFirst(char k) {
        char curr;
        if (k != 0) {
            char[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            char curr2 = key[mix];
            if (curr2 == 0) {
                return (V) this.defRetValue;
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
                    return (V) this.defRetValue;
                }
            } while (k != curr);
            moveIndexToFirst(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToFirst(this.f1401n);
            return this.value[this.f1401n];
        }
    }

    public V getAndMoveToLast(char k) {
        char curr;
        if (k != 0) {
            char[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            char curr2 = key[mix];
            if (curr2 == 0) {
                return (V) this.defRetValue;
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
                    return (V) this.defRetValue;
                }
            } while (k != curr);
            moveIndexToLast(pos);
            return this.value[pos];
        } else if (!this.containsNullKey) {
            return (V) this.defRetValue;
        } else {
            moveIndexToLast(this.f1401n);
            return this.value[this.f1401n];
        }
    }

    public V putAndMoveToFirst(char k, V v) {
        int pos;
        char curr;
        if (k != 0) {
            char[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            char curr2 = key[mix];
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
            moveIndexToFirst(this.f1401n);
            return setValue(this.f1401n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1401n;
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
            rehash(HashCommon.arraySize(this.size, this.f1402f));
        }
        return (V) this.defRetValue;
    }

    public V putAndMoveToLast(char k, V v) {
        int pos;
        char curr;
        if (k != 0) {
            char[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            pos = mix;
            char curr2 = key[mix];
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
            moveIndexToLast(this.f1401n);
            return setValue(this.f1401n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f1401n;
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
            rehash(HashCommon.arraySize(this.size, this.f1402f));
        }
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V get(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1401n] : (V) this.defRetValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
        if (curr2 == 0) {
            return (V) this.defRetValue;
        }
        if (k == curr2) {
            return this.value[pos];
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return (V) this.defRetValue;
            }
        } while (k != curr);
        return this.value[pos];
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public boolean containsKey(char k) {
        char curr;
        if (k == 0) {
            return this.containsNullKey;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.util.Map
    public boolean containsValue(Object v) {
        V[] value = this.value;
        char[] key = this.key;
        if (this.containsNullKey && Objects.equals(value[this.f1401n], v)) {
            return true;
        }
        int i = this.f1401n;
        while (true) {
            i--;
            if (i == 0) {
                return false;
            }
            if (key[i] != 0 && Objects.equals(value[i], v)) {
                return true;
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V getOrDefault(char k, V defaultValue) {
        char curr;
        if (k == 0) {
            return this.containsNullKey ? this.value[this.f1401n] : defaultValue;
        }
        char[] key = this.key;
        int mix = HashCommon.mix((int) k) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V putIfAbsent(char k, V v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public boolean remove(char k, Object v) {
        if (k != 0) {
            char[] key = this.key;
            int mix = HashCommon.mix((int) k) & this.mask;
            int pos = mix;
            char curr = key[mix];
            if (curr == 0) {
                return false;
            }
            if (k != curr || !Objects.equals(v, this.value[pos])) {
                while (true) {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    char curr2 = key[i];
                    if (curr2 == 0) {
                        return false;
                    }
                    if (k == curr2 && Objects.equals(v, this.value[pos])) {
                        removeEntry(pos);
                        return true;
                    }
                }
            } else {
                removeEntry(pos);
                return true;
            }
        } else if (!this.containsNullKey || !Objects.equals(v, this.value[this.f1401n])) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public boolean replace(char k, V oldValue, V v) {
        int pos = find(k);
        if (pos < 0 || !Objects.equals(oldValue, this.value[pos])) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V replace(char k, V v) {
        int pos = find(k);
        if (pos < 0) {
            return (V) this.defRetValue;
        }
        V oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V computeIfAbsent(char k, IntFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        V newValue = (V) mappingFunction.apply(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V computeIfAbsent(char key, Char2ObjectFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return (V) this.defRetValue;
        }
        V newValue = (V) mappingFunction.get(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V computeIfPresent(char k, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos >= 0 && this.value[pos] != null) {
            V newValue = (V) remappingFunction.apply(Character.valueOf(k), (Object) this.value[pos]);
            if (newValue == null) {
                if (k == 0) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
                return (V) this.defRetValue;
            }
            this.value[pos] = newValue;
            return newValue;
        }
        return (V) this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V compute(char k, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        V newValue = (V) remappingFunction.apply(Character.valueOf(k), pos >= 0 ? (Object) this.value[pos] : (Object) null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == 0) {
                    removeNullEntry();
                } else {
                    removeEntry(pos);
                }
            }
            return (V) this.defRetValue;
        } else if (pos < 0) {
            insert((-pos) - 1, k, newValue);
            return newValue;
        } else {
            this.value[pos] = newValue;
            return newValue;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
    public V merge(char k, V v, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(v);
        int pos = find(k);
        if (pos < 0 || this.value[pos] == null) {
            if (pos < 0) {
                insert((-pos) - 1, k, v);
            } else {
                this.value[pos] = v;
            }
            return v;
        }
        V newValue = (V) remappingFunction.apply((Object) this.value[pos], v);
        if (newValue == null) {
            if (k == 0) {
                removeNullEntry();
            } else {
                removeEntry(pos);
            }
            return (V) this.defRetValue;
        }
        this.value[pos] = newValue;
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNullKey = false;
            Arrays.fill(this.key, (char) 0);
            Arrays.fill(this.value, (Object) null);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Char2ObjectMap.Entry<V>, Map.Entry<Character, V>, CharObjectPair<V> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.Entry
        public char getCharKey() {
            return Char2ObjectLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharObjectPair
        public char leftChar() {
            return Char2ObjectLinkedOpenHashMap.this.key[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return Char2ObjectLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public V right() {
            return Char2ObjectLinkedOpenHashMap.this.value[this.index];
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V oldValue = Char2ObjectLinkedOpenHashMap.this.value[this.index];
            Char2ObjectLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public CharObjectPair<V> right(V v) {
            Char2ObjectLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.Entry, java.util.Map.Entry
        @Deprecated
        public Character getKey() {
            return Character.valueOf(Char2ObjectLinkedOpenHashMap.this.key[this.index]);
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Character, V> e = (Map.Entry) o;
            return Char2ObjectLinkedOpenHashMap.this.key[this.index] == e.getKey().charValue() && Objects.equals(Char2ObjectLinkedOpenHashMap.this.value[this.index], e.getValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return Char2ObjectLinkedOpenHashMap.this.key[this.index] ^ (Char2ObjectLinkedOpenHashMap.this.value[this.index] == null ? 0 : Char2ObjectLinkedOpenHashMap.this.value[this.index].hashCode());
        }

        @Override // java.lang.Object
        public String toString() {
            return Char2ObjectLinkedOpenHashMap.this.key[this.index] + "=>" + Char2ObjectLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    public char firstCharKey() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    public char lastCharKey() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    public Char2ObjectSortedMap<V> tailMap(char from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    public Char2ObjectSortedMap<V> headMap(char to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    public Char2ObjectSortedMap<V> subMap(char from, char to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap, java.util.SortedMap
    public Comparator<? super Character> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$MapIterator.class */
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
            this.next = Char2ObjectLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(char from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == 0) {
                if (Char2ObjectLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Char2ObjectLinkedOpenHashMap.this.link[Char2ObjectLinkedOpenHashMap.this.f1401n];
                    this.prev = Char2ObjectLinkedOpenHashMap.this.f1401n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Char2ObjectLinkedOpenHashMap.this.key[Char2ObjectLinkedOpenHashMap.this.last] == from) {
                this.prev = Char2ObjectLinkedOpenHashMap.this.last;
                this.index = Char2ObjectLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix((int) from);
                int i = Char2ObjectLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Char2ObjectLinkedOpenHashMap.this.key[pos] == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Char2ObjectLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Char2ObjectLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Char2ObjectLinkedOpenHashMap.this.mask;
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
                    this.index = Char2ObjectLinkedOpenHashMap.this.size;
                } else {
                    int pos = Char2ObjectLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Char2ObjectLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Char2ObjectLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Char2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Char2ObjectLinkedOpenHashMap.this.link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                acceptOnIndex(action, this.curr);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            char curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (Char2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Char2ObjectLinkedOpenHashMap.this.link[this.curr];
            }
            Char2ObjectLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Char2ObjectLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Char2ObjectLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Char2ObjectLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Char2ObjectLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Char2ObjectLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Char2ObjectLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Char2ObjectLinkedOpenHashMap.this.f1401n) {
                Char2ObjectLinkedOpenHashMap.this.containsNullKey = false;
                Char2ObjectLinkedOpenHashMap.this.value[Char2ObjectLinkedOpenHashMap.this.f1401n] = null;
                return;
            }
            char[] key = Char2ObjectLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Char2ObjectLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        Char2ObjectLinkedOpenHashMap.this.value[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix((int) curr) & Char2ObjectLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Char2ObjectLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Char2ObjectLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Char2ObjectLinkedOpenHashMap.this.value[pos] = Char2ObjectLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Char2ObjectLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Char2ObjectMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Char2ObjectMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Char2ObjectLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<Char2ObjectMap.Entry<V>> {
        private Char2ObjectLinkedOpenHashMap<V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Char2ObjectMap.Entry) ((Char2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Char2ObjectMap.Entry) ((Char2ObjectMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((EntryIterator) consumer);
        }

        public EntryIterator() {
            super();
        }

        public EntryIterator(char from) {
            super(from);
        }

        final void acceptOnIndex(Consumer<? super Char2ObjectMap.Entry<V>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Char2ObjectLinkedOpenHashMap<V>.MapEntry next() {
            Char2ObjectLinkedOpenHashMap<V>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Char2ObjectLinkedOpenHashMap<V>.MapEntry previous() {
            Char2ObjectLinkedOpenHashMap<V>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Char2ObjectLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<Char2ObjectMap.Entry<V>> {
        final Char2ObjectLinkedOpenHashMap<V>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Char2ObjectMap.Entry) ((Char2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Char2ObjectMap.Entry) ((Char2ObjectMap.Entry) obj));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((FastEntryIterator) consumer);
        }

        public FastEntryIterator() {
            super();
            this.entry = new MapEntry();
        }

        public FastEntryIterator(char from) {
            super(from);
            this.entry = new MapEntry();
        }

        final void acceptOnIndex(Consumer<? super Char2ObjectMap.Entry<V>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Char2ObjectLinkedOpenHashMap<V>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Char2ObjectLinkedOpenHashMap<V>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Char2ObjectMap.Entry<V>> implements Char2ObjectSortedMap.FastSortedEntrySet<V> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Char2ObjectMap.Entry) ((Char2ObjectMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Char2ObjectMap.Entry<V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2ObjectMap.Entry<V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Char2ObjectLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Char2ObjectMap.Entry<V>> comparator() {
            return null;
        }

        public ObjectSortedSet<Char2ObjectMap.Entry<V>> subSet(Char2ObjectMap.Entry<V> fromElement, Char2ObjectMap.Entry<V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Char2ObjectMap.Entry<V>> headSet(Char2ObjectMap.Entry<V> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Char2ObjectMap.Entry<V>> tailSet(Char2ObjectMap.Entry<V> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Char2ObjectMap.Entry<V> first() {
            if (Char2ObjectLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Char2ObjectLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Char2ObjectMap.Entry<V> last() {
            if (Char2ObjectLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Char2ObjectLinkedOpenHashMap.this.last);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            char curr;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            Object value = e.getValue();
            if (k == 0) {
                return Char2ObjectLinkedOpenHashMap.this.containsNullKey && Objects.equals(Char2ObjectLinkedOpenHashMap.this.value[Char2ObjectLinkedOpenHashMap.this.f1401n], value);
            }
            char[] key = Char2ObjectLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix((int) k) & Char2ObjectLinkedOpenHashMap.this.mask;
            int pos = mix;
            char curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (k == curr2) {
                return Objects.equals(Char2ObjectLinkedOpenHashMap.this.value[pos], value);
            }
            do {
                int i = (pos + 1) & Char2ObjectLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (k != curr);
            return Objects.equals(Char2ObjectLinkedOpenHashMap.this.value[pos], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getKey() == null || !(e.getKey() instanceof Character)) {
                return false;
            }
            char k = ((Character) e.getKey()).charValue();
            Object value = e.getValue();
            if (k != 0) {
                char[] key = Char2ObjectLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix((int) k) & Char2ObjectLinkedOpenHashMap.this.mask;
                int pos = mix;
                char curr = key[mix];
                if (curr == 0) {
                    return false;
                }
                if (curr != k) {
                    while (true) {
                        int i = (pos + 1) & Char2ObjectLinkedOpenHashMap.this.mask;
                        pos = i;
                        char curr2 = key[i];
                        if (curr2 == 0) {
                            return false;
                        }
                        if (curr2 == k && Objects.equals(Char2ObjectLinkedOpenHashMap.this.value[pos], value)) {
                            Char2ObjectLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (!Objects.equals(Char2ObjectLinkedOpenHashMap.this.value[pos], value)) {
                    return false;
                } else {
                    Char2ObjectLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Char2ObjectLinkedOpenHashMap.this.containsNullKey || !Objects.equals(Char2ObjectLinkedOpenHashMap.this.value[Char2ObjectLinkedOpenHashMap.this.f1401n], value)) {
                return false;
            } else {
                Char2ObjectLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2ObjectLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2ObjectLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Char2ObjectMap.Entry<V>> iterator(Char2ObjectMap.Entry<V> from) {
            return new EntryIterator(from.getCharKey());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.FastEntrySet
        public ObjectListIterator<Char2ObjectMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap.FastSortedEntrySet
        public ObjectListIterator<Char2ObjectMap.Entry<V>> fastIterator(Char2ObjectMap.Entry<V> from) {
            return new FastEntryIterator(from.getCharKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Char2ObjectMap.Entry<V>> consumer) {
            int i = Char2ObjectLinkedOpenHashMap.this.size;
            int next = Char2ObjectLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Char2ObjectLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractChar2ObjectMap.BasicEntry(Char2ObjectLinkedOpenHashMap.this.key[next], Char2ObjectLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.FastEntrySet
        public void fastForEach(Consumer<? super Char2ObjectMap.Entry<V>> consumer) {
            AbstractChar2ObjectMap.BasicEntry<V> entry = new AbstractChar2ObjectMap.BasicEntry<>();
            int i = Char2ObjectLinkedOpenHashMap.this.size;
            int next = Char2ObjectLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Char2ObjectLinkedOpenHashMap.this.link[next];
                    entry.key = Char2ObjectLinkedOpenHashMap.this.key[next];
                    entry.value = Char2ObjectLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    public Char2ObjectSortedMap.FastSortedEntrySet<V> char2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Char2ObjectLinkedOpenHashMap<V>.MapIterator implements CharListIterator {
        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(CharConsumer charConsumer) {
            forEachRemaining((KeyIterator) charConsumer);
        }

        public KeyIterator(char k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return Char2ObjectLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(CharConsumer action, int index) {
            action.accept(Char2ObjectLinkedOpenHashMap.this.key[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return Char2ObjectLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$KeySet.class */
    public final class KeySet extends AbstractCharSortedSet {
        private static final int SPLITERATOR_CHARACTERISTICS = 337;

        private KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharListIterator iterator(char from) {
            return new KeyIterator(from);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharListIterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(Char2ObjectLinkedOpenHashMap.this), 337);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
        public void forEach(CharConsumer consumer) {
            int i = Char2ObjectLinkedOpenHashMap.this.size;
            int next = Char2ObjectLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Char2ObjectLinkedOpenHashMap.this.link[next];
                    consumer.accept(Char2ObjectLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Char2ObjectLinkedOpenHashMap.this.size;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean contains(char k) {
            return Char2ObjectLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
        public boolean remove(char k) {
            int oldSize = Char2ObjectLinkedOpenHashMap.this.size;
            Char2ObjectLinkedOpenHashMap.this.remove(k);
            return Char2ObjectLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Char2ObjectLinkedOpenHashMap.this.clear();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char firstChar() {
            if (Char2ObjectLinkedOpenHashMap.this.size != 0) {
                return Char2ObjectLinkedOpenHashMap.this.key[Char2ObjectLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public char lastChar() {
            if (Char2ObjectLinkedOpenHashMap.this.size != 0) {
                return Char2ObjectLinkedOpenHashMap.this.key[Char2ObjectLinkedOpenHashMap.this.last];
            }
            throw new NoSuchElementException();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet, java.util.SortedSet
        public Comparator<? super Character> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet tailSet(char from) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet headSet(char to) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharSortedSet subSet(char from, char to) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectSortedMap, p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    public CharSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Char2ObjectLinkedOpenHashMap<V>.MapIterator implements ObjectListIterator<V> {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
            forEachRemaining((ValueIterator) consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public V previous() {
            return Char2ObjectLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super V> action, int index) {
            action.accept((Object) Char2ObjectLinkedOpenHashMap.this.value[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public V next() {
            return Char2ObjectLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectSortedMap, p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.chars.Char2ObjectLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 80;

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
                public ObjectSpliterator<V> spliterator() {
                    return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Char2ObjectLinkedOpenHashMap.this), 80);
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super V> consumer) {
                    int i = Char2ObjectLinkedOpenHashMap.this.size;
                    int next = Char2ObjectLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Char2ObjectLinkedOpenHashMap.this.link[next];
                            consumer.accept((Object) Char2ObjectLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Char2ObjectLinkedOpenHashMap.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object v) {
                    return Char2ObjectLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Char2ObjectLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1402f)));
        if (l >= this.f1401n || this.size > HashCommon.maxFill(l, this.f1402f)) {
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
        char[] key = this.key;
        V[] value = this.value;
        int mask = newN - 1;
        char[] newKey = new char[newN + 1];
        V[] newValue = (V[]) new Object[newN + 1];
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
        this.f1401n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f1401n, this.f1402f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Char2ObjectLinkedOpenHashMap<V> clone() {
        try {
            Char2ObjectLinkedOpenHashMap<V> c = (Char2ObjectLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (char[]) this.key.clone();
            c.value = (V[]) ((Object[]) this.value.clone());
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x004f */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: char[] */
    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2 */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap, java.lang.Object, java.util.Map
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
            char t = this.key[i];
            if (this != this.value[i]) {
                t ^= this.value[i] == null ? 0 : this.value[i].hashCode();
            }
            h += t == true ? 1 : 0;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f1401n] == null ? 0 : this.value[this.f1401n].hashCode();
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        char[] key = this.key;
        V[] value = this.value;
        Char2ObjectLinkedOpenHashMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeChar(key[e]);
                s.writeObject(value[e]);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: V[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        s.defaultReadObject();
        this.f1401n = HashCommon.arraySize(this.size, this.f1402f);
        this.maxFill = HashCommon.maxFill(this.f1401n, this.f1402f);
        this.mask = this.f1401n - 1;
        char[] key = new char[this.f1401n + 1];
        this.key = key;
        V[] value = (V[]) new Object[this.f1401n + 1];
        this.value = value;
        long[] link = new long[this.f1401n + 1];
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
            char k = s.readChar();
            Object readObject = s.readObject();
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
                pos = this.f1401n;
                this.containsNullKey = true;
            }
            key[pos] = k;
            value[pos] = readObject;
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
