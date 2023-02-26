package p014it.unimi.dsi.fastutil.objects;

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
import java.util.function.Predicate;
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
import p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap.class */
public class Reference2BooleanLinkedOpenHashMap<K> extends AbstractReference2BooleanSortedMap<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient boolean[] value;
    protected transient int mask;
    protected transient boolean containsNullKey;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2695n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2696f;
    protected transient Reference2BooleanSortedMap.FastSortedEntrySet<K> entries;
    protected transient ReferenceSortedSet<K> keys;
    protected transient BooleanCollection values;

    public Reference2BooleanLinkedOpenHashMap(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2696f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2695n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2695n - 1;
            this.maxFill = HashCommon.maxFill(this.f2695n, f);
            this.key = (K[]) new Object[this.f2695n + 1];
            this.value = new boolean[this.f2695n + 1];
            this.link = new long[this.f2695n + 1];
        }
    }

    public Reference2BooleanLinkedOpenHashMap(int expected) {
        this(expected, 0.75f);
    }

    public Reference2BooleanLinkedOpenHashMap() {
        this(16, 0.75f);
    }

    public Reference2BooleanLinkedOpenHashMap(Map<? extends K, ? extends Boolean> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2BooleanLinkedOpenHashMap(Map<? extends K, ? extends Boolean> m) {
        this(m, 0.75f);
    }

    public Reference2BooleanLinkedOpenHashMap(Reference2BooleanMap<K> m, float f) {
        this(m.size(), f);
        putAll(m);
    }

    public Reference2BooleanLinkedOpenHashMap(Reference2BooleanMap<K> m) {
        this((Reference2BooleanMap) m, 0.75f);
    }

    public Reference2BooleanLinkedOpenHashMap(K[] k, boolean[] v, float f) {
        this(k.length, f);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Reference2BooleanLinkedOpenHashMap<K>) k[i], v[i]);
        }
    }

    public Reference2BooleanLinkedOpenHashMap(K[] k, boolean[] v) {
        this(k, v, 0.75f);
    }

    private int realSize() {
        return this.containsNullKey ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2696f);
        if (needed > this.f2695n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2696f)))));
        if (needed > this.f2695n) {
            rehash(needed);
        }
    }

    /* access modifiers changed from: private */
    public boolean removeEntry(int pos) {
        boolean oldValue = this.value[pos];
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2695n > this.minN && this.size < this.maxFill / 4 && this.f2695n > 16) {
            rehash(this.f2695n / 2);
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public boolean removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.f2695n] = null;
        boolean oldValue = this.value[this.f2695n];
        this.size--;
        fixPointers(this.f2695n);
        if (this.f2695n > this.minN && this.size < this.maxFill / 4 && this.f2695n > 16) {
            rehash(this.f2695n / 2);
        }
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Boolean> m) {
        if (((double) this.f2696f) <= 0.5d) {
            ensureCapacity(m.size());
        } else {
            tryCapacity((long) (size() + m.size()));
        }
        putAll(m);
    }

    private int find(K k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.f2695n : -(this.f2695n + 1);
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

    private void insert(int pos, K k, boolean v) {
        if (pos == this.f2695n) {
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
            rehash(HashCommon.arraySize(this.size + 1, this.f2696f));
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction
    public boolean put(K k, boolean v) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction
    public boolean removeBoolean(Object k) {
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
        if (pos == this.f2695n) {
            this.containsNullKey = false;
            this.key[this.f2695n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2695n > this.minN && this.size < this.maxFill / 4 && this.f2695n > 16) {
            rehash(this.f2695n / 2);
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
        if (pos == this.f2695n) {
            this.containsNullKey = false;
            this.key[this.f2695n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2695n > this.minN && this.size < this.maxFill / 4 && this.f2695n > 16) {
            rehash(this.f2695n / 2);
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

    public boolean getAndMoveToFirst(K k) {
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
            moveIndexToFirst(this.f2695n);
            return this.value[this.f2695n];
        }
    }

    public boolean getAndMoveToLast(K k) {
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
            moveIndexToLast(this.f2695n);
            return this.value[this.f2695n];
        }
    }

    public boolean putAndMoveToFirst(K k, boolean v) {
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
            moveIndexToFirst(this.f2695n);
            return setValue(this.f2695n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2695n;
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
            rehash(HashCommon.arraySize(this.size, this.f2696f));
        }
        return this.defRetValue;
    }

    public boolean putAndMoveToLast(K k, boolean v) {
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
            moveIndexToLast(this.f2695n);
            return setValue(this.f2695n, v);
        } else {
            this.containsNullKey = true;
            pos = this.f2695n;
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
            rehash(HashCommon.arraySize(this.size, this.f2696f));
        }
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction
    public boolean getBoolean(Object k) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2695n] : this.defRetValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap, p014it.unimi.dsi.fastutil.Function
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap, p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean containsValue(boolean v) {
        boolean[] value = this.value;
        K[] key = this.key;
        if (this.containsNullKey && value[this.f2695n] == v) {
            return true;
        }
        int i = this.f2695n;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction
    public boolean getOrDefault(Object k, boolean defaultValue) {
        K curr;
        if (k == null) {
            return this.containsNullKey ? this.value[this.f2695n] : defaultValue;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean putIfAbsent(K k, boolean v) {
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        insert((-pos) - 1, k, v);
        return this.defRetValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean remove(Object k, boolean v) {
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
        } else if (!this.containsNullKey || v != this.value[this.f2695n]) {
            return false;
        } else {
            removeNullEntry();
            return true;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean replace(K k, boolean oldValue, boolean v) {
        int pos = find(k);
        if (pos < 0 || oldValue != this.value[pos]) {
            return false;
        }
        this.value[pos] = v;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean replace(K k, boolean v) {
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        boolean oldValue = this.value[pos];
        this.value[pos] = v;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean computeIfAbsent(K k, Predicate<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(k);
        if (pos >= 0) {
            return this.value[pos];
        }
        boolean newValue = mappingFunction.test(k);
        insert((-pos) - 1, k, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean computeIfAbsent(K key, Reference2BooleanFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int pos = find(key);
        if (pos >= 0) {
            return this.value[pos];
        }
        if (!mappingFunction.containsKey(key)) {
            return this.defRetValue;
        }
        boolean newValue = mappingFunction.getBoolean(key);
        insert((-pos) - 1, key, newValue);
        return newValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean computeBooleanIfPresent(K k, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        if (pos < 0) {
            return this.defRetValue;
        }
        Boolean newValue = (Boolean) remappingFunction.apply(k, Boolean.valueOf(this.value[pos]));
        if (newValue == null) {
            if (k == null) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean computeBoolean(K k, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int pos = find(k);
        Boolean newValue = (Boolean) remappingFunction.apply(k, pos >= 0 ? Boolean.valueOf(this.value[pos]) : null);
        if (newValue == null) {
            if (pos >= 0) {
                if (k == null) {
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public boolean merge(K k, boolean v, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
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
            if (k == null) {
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
            Arrays.fill(this.key, (Object) null);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$MapEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$MapEntry.class */
    public final class MapEntry implements Reference2BooleanMap.Entry<K>, Map.Entry<K, Boolean>, ReferenceBooleanPair<K> {
        int index;

        MapEntry(int index) {
            this.index = index;
        }

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return Reference2BooleanLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.Pair
        public K left() {
            return Reference2BooleanLinkedOpenHashMap.this.key[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.Entry
        public boolean getBooleanValue() {
            return Reference2BooleanLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBooleanPair
        public boolean rightBoolean() {
            return Reference2BooleanLinkedOpenHashMap.this.value[this.index];
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.Entry
        public boolean setValue(boolean v) {
            boolean oldValue = Reference2BooleanLinkedOpenHashMap.this.value[this.index];
            Reference2BooleanLinkedOpenHashMap.this.value[this.index] = v;
            return oldValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBooleanPair
        public ReferenceBooleanPair<K> right(boolean v) {
            Reference2BooleanLinkedOpenHashMap.this.value[this.index] = v;
            return this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.Entry, java.util.Map.Entry
        @Deprecated
        public Boolean getValue() {
            return Boolean.valueOf(Reference2BooleanLinkedOpenHashMap.this.value[this.index]);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.Entry
        @Deprecated
        public Boolean setValue(Boolean v) {
            return Boolean.valueOf(setValue(v.booleanValue()));
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Boolean> e = (Map.Entry) o;
            return Reference2BooleanLinkedOpenHashMap.this.key[this.index] == e.getKey() && Reference2BooleanLinkedOpenHashMap.this.value[this.index] == e.getValue().booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(Reference2BooleanLinkedOpenHashMap.this.key[this.index]) ^ (Reference2BooleanLinkedOpenHashMap.this.value[this.index] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }

        @Override // java.lang.Object
        public String toString() {
            return Reference2BooleanLinkedOpenHashMap.this.key[this.index] + "=>" + Reference2BooleanLinkedOpenHashMap.this.value[this.index];
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap, java.util.SortedMap
    public Reference2BooleanSortedMap<K> tailMap(K from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap, java.util.SortedMap
    public Reference2BooleanSortedMap<K> headMap(K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap, java.util.SortedMap
    public Reference2BooleanSortedMap<K> subMap(K from, K to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return null;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$MapIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$MapIterator.class */
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
            this.next = Reference2BooleanLinkedOpenHashMap.this.first;
            this.index = 0;
        }

        private MapIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == null) {
                if (Reference2BooleanLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int) Reference2BooleanLinkedOpenHashMap.this.link[Reference2BooleanLinkedOpenHashMap.this.f2695n];
                    this.prev = Reference2BooleanLinkedOpenHashMap.this.f2695n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this map.");
            } else if (Reference2BooleanLinkedOpenHashMap.this.key[Reference2BooleanLinkedOpenHashMap.this.last] == from) {
                this.prev = Reference2BooleanLinkedOpenHashMap.this.last;
                this.index = Reference2BooleanLinkedOpenHashMap.this.size;
            } else {
                int mix = HashCommon.mix(System.identityHashCode(from));
                int i = Reference2BooleanLinkedOpenHashMap.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Reference2BooleanLinkedOpenHashMap.this.key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this map.");
                    } else if (Reference2BooleanLinkedOpenHashMap.this.key[pos] == from) {
                        this.next = (int) Reference2BooleanLinkedOpenHashMap.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = Reference2BooleanLinkedOpenHashMap.this.mask;
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
                    this.index = Reference2BooleanLinkedOpenHashMap.this.size;
                } else {
                    int pos = Reference2BooleanLinkedOpenHashMap.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) Reference2BooleanLinkedOpenHashMap.this.link[pos];
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
            this.next = (int) Reference2BooleanLinkedOpenHashMap.this.link[this.curr];
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
            this.prev = (int) (Reference2BooleanLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return this.curr;
        }

        public void forEachRemaining(ConsumerType action) {
            while (hasNext()) {
                this.curr = this.next;
                this.next = (int) Reference2BooleanLinkedOpenHashMap.this.link[this.curr];
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
                this.prev = (int) (Reference2BooleanLinkedOpenHashMap.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) Reference2BooleanLinkedOpenHashMap.this.link[this.curr];
            }
            Reference2BooleanLinkedOpenHashMap.this.size--;
            if (this.prev == -1) {
                Reference2BooleanLinkedOpenHashMap.this.first = this.next;
            } else {
                long[] jArr = Reference2BooleanLinkedOpenHashMap.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((Reference2BooleanLinkedOpenHashMap.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                Reference2BooleanLinkedOpenHashMap.this.last = this.prev;
            } else {
                long[] jArr2 = Reference2BooleanLinkedOpenHashMap.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((Reference2BooleanLinkedOpenHashMap.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == Reference2BooleanLinkedOpenHashMap.this.f2695n) {
                Reference2BooleanLinkedOpenHashMap.this.containsNullKey = false;
                Reference2BooleanLinkedOpenHashMap.this.key[Reference2BooleanLinkedOpenHashMap.this.f2695n] = null;
                return;
            }
            K[] key = Reference2BooleanLinkedOpenHashMap.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = Reference2BooleanLinkedOpenHashMap.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(System.identityHashCode(curr)) & Reference2BooleanLinkedOpenHashMap.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Reference2BooleanLinkedOpenHashMap.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = Reference2BooleanLinkedOpenHashMap.this.mask;
                    }
                }
                key[pos] = curr;
                Reference2BooleanLinkedOpenHashMap.this.value[pos] = Reference2BooleanLinkedOpenHashMap.this.value[pos];
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                Reference2BooleanLinkedOpenHashMap.this.fixPointers(pos, pos);
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

        public void set(Reference2BooleanMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Reference2BooleanMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$EntryIterator.class */
    public final class EntryIterator extends Reference2BooleanLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<Reference2BooleanMap.Entry<K>> {
        private Reference2BooleanLinkedOpenHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Reference2BooleanMap.Entry) ((Reference2BooleanMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Reference2BooleanMap.Entry) ((Reference2BooleanMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Reference2BooleanMap.Entry<K>> action, int index) {
            action.accept(new MapEntry(index));
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Reference2BooleanLinkedOpenHashMap<K>.MapEntry next() {
            Reference2BooleanLinkedOpenHashMap<K>.MapEntry mapEntry = new MapEntry(nextEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Reference2BooleanLinkedOpenHashMap<K>.MapEntry previous() {
            Reference2BooleanLinkedOpenHashMap<K>.MapEntry mapEntry = new MapEntry(previousEntry());
            this.entry = mapEntry;
            return mapEntry;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap.MapIterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            remove();
            this.entry.index = -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$FastEntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$FastEntryIterator.class */
    public final class FastEntryIterator extends Reference2BooleanLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<Reference2BooleanMap.Entry<K>> {
        final Reference2BooleanLinkedOpenHashMap<K>.MapEntry entry;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap.MapIterator
        /* bridge */ /* synthetic */ void acceptOnIndex(Object obj, int i) {
            acceptOnIndex((Consumer) ((Consumer) obj), i);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Reference2BooleanMap.Entry) ((Reference2BooleanMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Reference2BooleanMap.Entry) ((Reference2BooleanMap.Entry) obj));
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

        final void acceptOnIndex(Consumer<? super Reference2BooleanMap.Entry<K>> action, int index) {
            this.entry.index = index;
            action.accept(this.entry);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Reference2BooleanLinkedOpenHashMap<K>.MapEntry next() {
            this.entry.index = nextEntry();
            return this.entry;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Reference2BooleanLinkedOpenHashMap<K>.MapEntry previous() {
            this.entry.index = previousEntry();
            return this.entry;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$MapEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$MapEntrySet.class */
    public final class MapEntrySet extends AbstractObjectSortedSet<Reference2BooleanMap.Entry<K>> implements Reference2BooleanSortedMap.FastSortedEntrySet<K> {
        private static final int SPLITERATOR_CHARACTERISTICS = 81;

        private MapEntrySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
            return iterator((Reference2BooleanMap.Entry) ((Reference2BooleanMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<Reference2BooleanMap.Entry<K>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2BooleanMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2BooleanLinkedOpenHashMap.this), 81);
        }

        @Override // java.util.SortedSet
        public Comparator<? super Reference2BooleanMap.Entry<K>> comparator() {
            return null;
        }

        public ObjectSortedSet<Reference2BooleanMap.Entry<K>> subSet(Reference2BooleanMap.Entry<K> fromElement, Reference2BooleanMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Reference2BooleanMap.Entry<K>> headSet(Reference2BooleanMap.Entry<K> toElement) {
            throw new UnsupportedOperationException();
        }

        public ObjectSortedSet<Reference2BooleanMap.Entry<K>> tailSet(Reference2BooleanMap.Entry<K> fromElement) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Reference2BooleanMap.Entry<K> first() {
            if (Reference2BooleanLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Reference2BooleanLinkedOpenHashMap.this.first);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public Reference2BooleanMap.Entry<K> last() {
            if (Reference2BooleanLinkedOpenHashMap.this.size != 0) {
                return new MapEntry(Reference2BooleanLinkedOpenHashMap.this.last);
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
            if (e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            Object key = e.getKey();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            if (key == null) {
                return Reference2BooleanLinkedOpenHashMap.this.containsNullKey && Reference2BooleanLinkedOpenHashMap.this.value[Reference2BooleanLinkedOpenHashMap.this.f2695n] == v;
            }
            K[] key2 = Reference2BooleanLinkedOpenHashMap.this.key;
            int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2BooleanLinkedOpenHashMap.this.mask;
            int pos = mix;
            K curr2 = key2[mix];
            if (curr2 == null) {
                return false;
            }
            if (key == curr2) {
                return Reference2BooleanLinkedOpenHashMap.this.value[pos] == v;
            }
            do {
                int i = (pos + 1) & Reference2BooleanLinkedOpenHashMap.this.mask;
                pos = i;
                curr = key2[i];
                if (curr == null) {
                    return false;
                }
            } while (key != curr);
            return Reference2BooleanLinkedOpenHashMap.this.value[pos] == v;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                return false;
            }
            Object key = e.getKey();
            boolean v = ((Boolean) e.getValue()).booleanValue();
            if (key != null) {
                K[] key2 = Reference2BooleanLinkedOpenHashMap.this.key;
                int mix = HashCommon.mix(System.identityHashCode(key)) & Reference2BooleanLinkedOpenHashMap.this.mask;
                int pos = mix;
                K curr = key2[mix];
                if (curr == null) {
                    return false;
                }
                if (curr != key) {
                    while (true) {
                        int i = (pos + 1) & Reference2BooleanLinkedOpenHashMap.this.mask;
                        pos = i;
                        K curr2 = key2[i];
                        if (curr2 == null) {
                            return false;
                        }
                        if (curr2 == key && Reference2BooleanLinkedOpenHashMap.this.value[pos] == v) {
                            Reference2BooleanLinkedOpenHashMap.this.removeEntry(pos);
                            return true;
                        }
                    }
                } else if (Reference2BooleanLinkedOpenHashMap.this.value[pos] != v) {
                    return false;
                } else {
                    Reference2BooleanLinkedOpenHashMap.this.removeEntry(pos);
                    return true;
                }
            } else if (!Reference2BooleanLinkedOpenHashMap.this.containsNullKey || Reference2BooleanLinkedOpenHashMap.this.value[Reference2BooleanLinkedOpenHashMap.this.f2695n] != v) {
                return false;
            } else {
                Reference2BooleanLinkedOpenHashMap.this.removeNullEntry();
                return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2BooleanLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2BooleanLinkedOpenHashMap.this.clear();
        }

        public ObjectListIterator<Reference2BooleanMap.Entry<K>> iterator(Reference2BooleanMap.Entry<K> from) {
            return new EntryIterator(from.getKey());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap.FastSortedEntrySet, p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.FastEntrySet
        public ObjectListIterator<Reference2BooleanMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanSortedMap.FastSortedEntrySet
        public ObjectListIterator<Reference2BooleanMap.Entry<K>> fastIterator(Reference2BooleanMap.Entry<K> from) {
            return new FastEntryIterator(from.getKey());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Reference2BooleanMap.Entry<K>> consumer) {
            int i = Reference2BooleanLinkedOpenHashMap.this.size;
            int next = Reference2BooleanLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2BooleanLinkedOpenHashMap.this.link[next];
                    consumer.accept(new AbstractReference2BooleanMap.BasicEntry(Reference2BooleanLinkedOpenHashMap.this.key[next], Reference2BooleanLinkedOpenHashMap.this.value[next]));
                } else {
                    return;
                }
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap.FastEntrySet
        public void fastForEach(Consumer<? super Reference2BooleanMap.Entry<K>> consumer) {
            AbstractReference2BooleanMap.BasicEntry<K> entry = new AbstractReference2BooleanMap.BasicEntry<>();
            int i = Reference2BooleanLinkedOpenHashMap.this.size;
            int next = Reference2BooleanLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2BooleanLinkedOpenHashMap.this.link[next];
                    entry.key = Reference2BooleanLinkedOpenHashMap.this.key[next];
                    entry.value = Reference2BooleanLinkedOpenHashMap.this.value[next];
                    consumer.accept(entry);
                } else {
                    return;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap
    public Reference2BooleanSortedMap.FastSortedEntrySet<K> reference2BooleanEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$KeyIterator.class */
    public final class KeyIterator extends Reference2BooleanLinkedOpenHashMap<K>.MapIterator implements ObjectListIterator<K> {
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap.MapIterator
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
            return Reference2BooleanLinkedOpenHashMap.this.key[previousEntry()];
        }

        public KeyIterator() {
            super();
        }

        final void acceptOnIndex(Consumer<? super K> action, int index) {
            action.accept((Object) Reference2BooleanLinkedOpenHashMap.this.key[index]);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return Reference2BooleanLinkedOpenHashMap.this.key[nextEntry()];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$KeySet.class */
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
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2BooleanLinkedOpenHashMap.this), 81);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            int i = Reference2BooleanLinkedOpenHashMap.this.size;
            int next = Reference2BooleanLinkedOpenHashMap.this.first;
            while (true) {
                i--;
                if (i != 0) {
                    next = (int) Reference2BooleanLinkedOpenHashMap.this.link[next];
                    consumer.accept((Object) Reference2BooleanLinkedOpenHashMap.this.key[next]);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Reference2BooleanLinkedOpenHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return Reference2BooleanLinkedOpenHashMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            int oldSize = Reference2BooleanLinkedOpenHashMap.this.size;
            Reference2BooleanLinkedOpenHashMap.this.removeBoolean(k);
            return Reference2BooleanLinkedOpenHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Reference2BooleanLinkedOpenHashMap.this.clear();
        }

        @Override // java.util.SortedSet
        public K first() {
            if (Reference2BooleanLinkedOpenHashMap.this.size != 0) {
                return Reference2BooleanLinkedOpenHashMap.this.key[Reference2BooleanLinkedOpenHashMap.this.first];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            if (Reference2BooleanLinkedOpenHashMap.this.size != 0) {
                return Reference2BooleanLinkedOpenHashMap.this.key[Reference2BooleanLinkedOpenHashMap.this.last];
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap, p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap, java.util.Map
    public ReferenceSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanLinkedOpenHashMap$ValueIterator.class */
    public final class ValueIterator extends Reference2BooleanLinkedOpenHashMap<K>.MapIterator implements BooleanListIterator {
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public /* bridge */ /* synthetic */ void forEachRemaining(BooleanConsumer booleanConsumer) {
            forEachRemaining((ValueIterator) booleanConsumer);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            return Reference2BooleanLinkedOpenHashMap.this.value[previousEntry()];
        }

        public ValueIterator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void acceptOnIndex(BooleanConsumer action, int index) {
            action.accept(Reference2BooleanLinkedOpenHashMap.this.value[index]);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return Reference2BooleanLinkedOpenHashMap.this.value[nextEntry()];
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap, p014it.unimi.dsi.fastutil.objects.Reference2BooleanMap, java.util.Map
    public BooleanCollection values() {
        if (this.values == null) {
            this.values = new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.objects.Reference2BooleanLinkedOpenHashMap.1
                private static final int SPLITERATOR_CHARACTERISTICS = 336;

                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                public BooleanIterator iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                public BooleanSpliterator spliterator() {
                    return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(Reference2BooleanLinkedOpenHashMap.this), 336);
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
                public void forEach(BooleanConsumer consumer) {
                    int i = Reference2BooleanLinkedOpenHashMap.this.size;
                    int next = Reference2BooleanLinkedOpenHashMap.this.first;
                    while (true) {
                        i--;
                        if (i != 0) {
                            next = (int) Reference2BooleanLinkedOpenHashMap.this.link[next];
                            consumer.accept(Reference2BooleanLinkedOpenHashMap.this.value[next]);
                        } else {
                            return;
                        }
                    }
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Reference2BooleanLinkedOpenHashMap.this.size;
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
                public boolean contains(boolean v) {
                    return Reference2BooleanLinkedOpenHashMap.this.containsValue(v);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Reference2BooleanLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2696f)));
        if (l >= this.f2695n || this.size > HashCommon.maxFill(l, this.f2696f)) {
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
        boolean[] value = this.value;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
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
        this.f2695n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2695n, this.f2696f);
        this.key = newKey;
        this.value = newValue;
    }

    @Override // java.lang.Object
    public Reference2BooleanLinkedOpenHashMap<K> clone() {
        try {
            Reference2BooleanLinkedOpenHashMap<K> c = (Reference2BooleanLinkedOpenHashMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.containsNullKey = this.containsNullKey;
            c.key = (K[]) ((Object[]) this.key.clone());
            c.value = (boolean[]) this.value.clone();
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2BooleanMap, java.lang.Object, java.util.Map
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
            t ^= this.value[i] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE;
            h += t;
            i++;
        }
        if (this.containsNullKey) {
            h += this.value[this.f2695n] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE;
        }
        return h;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        K[] key = this.key;
        boolean[] value = this.value;
        Reference2BooleanLinkedOpenHashMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                int e = i.nextEntry();
                s.writeObject(key[e]);
                s.writeBoolean(value[e]);
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
        this.f2695n = HashCommon.arraySize(this.size, this.f2696f);
        this.maxFill = HashCommon.maxFill(this.f2695n, this.f2696f);
        this.mask = this.f2695n - 1;
        K[] key = (K[]) new Object[this.f2695n + 1];
        this.key = key;
        boolean[] value = new boolean[this.f2695n + 1];
        this.value = value;
        long[] link = new long[this.f2695n + 1];
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
            boolean v = s.readBoolean();
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
                pos = this.f2695n;
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
