package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collector;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollections;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLinkedOpenHashSet.class */
public class ReferenceLinkedOpenHashSet<K> extends AbstractReferenceSortedSet<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f2801n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2802f;
    private static final Collector<Object, ?, ReferenceLinkedOpenHashSet<Object>> TO_SET_COLLECTOR = Collector.of(ReferenceLinkedOpenHashSet::new, (v0, v1) -> {
        v0.add(v1);
    }, (v0, v1) -> {
        return v0.combine(v1);
    }, new Collector.Characteristics[0]);
    private static final int SPLITERATOR_CHARACTERISTICS = 81;

    public ReferenceLinkedOpenHashSet(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2802f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2801n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2801n - 1;
            this.maxFill = HashCommon.maxFill(this.f2801n, f);
            this.key = (K[]) new Object[this.f2801n + 1];
            this.link = new long[this.f2801n + 1];
        }
    }

    public ReferenceLinkedOpenHashSet(int expected) {
        this(expected, 0.75f);
    }

    public ReferenceLinkedOpenHashSet() {
        this(16, 0.75f);
    }

    public ReferenceLinkedOpenHashSet(Collection<? extends K> c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public ReferenceLinkedOpenHashSet(Collection<? extends K> c) {
        this(c, 0.75f);
    }

    public ReferenceLinkedOpenHashSet(ReferenceCollection<? extends K> c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public ReferenceLinkedOpenHashSet(ReferenceCollection<? extends K> c) {
        this((ReferenceCollection) c, 0.75f);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ReferenceLinkedOpenHashSet(Iterator<? extends K> i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public ReferenceLinkedOpenHashSet(Iterator<? extends K> i) {
        this(i, 0.75f);
    }

    public ReferenceLinkedOpenHashSet(K[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : length, f);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ReferenceLinkedOpenHashSet(K[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public ReferenceLinkedOpenHashSet(K[] a, float f) {
        this(a, 0, a.length, f);
    }

    public ReferenceLinkedOpenHashSet(K[] a) {
        this(a, 0.75f);
    }

    /* renamed from: of */
    public static <K> ReferenceLinkedOpenHashSet<K> m498of() {
        return new ReferenceLinkedOpenHashSet<>();
    }

    /* renamed from: of */
    public static <K> ReferenceLinkedOpenHashSet<K> m497of(K e) {
        ReferenceLinkedOpenHashSet<K> result = new ReferenceLinkedOpenHashSet<>(1, 0.75f);
        result.add(e);
        return result;
    }

    /* renamed from: of */
    public static <K> ReferenceLinkedOpenHashSet<K> m496of(K e0, K e1) {
        ReferenceLinkedOpenHashSet<K> result = new ReferenceLinkedOpenHashSet<>(2, 0.75f);
        result.add(e0);
        if (result.add(e1)) {
            return result;
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    public static <K> ReferenceLinkedOpenHashSet<K> m495of(K e0, K e1, K e2) {
        ReferenceLinkedOpenHashSet<K> result = new ReferenceLinkedOpenHashSet<>(3, 0.75f);
        result.add(e0);
        if (!result.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (result.add(e2)) {
            return result;
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    @SafeVarargs
    /* renamed from: of */
    public static <K> ReferenceLinkedOpenHashSet<K> m494of(K... a) {
        ReferenceLinkedOpenHashSet<K> result = new ReferenceLinkedOpenHashSet<>(a.length, 0.75f);
        for (K element : a) {
            if (!result.add(element)) {
                throw new IllegalArgumentException("Duplicate element " + element);
            }
        }
        return result;
    }

    private ReferenceLinkedOpenHashSet<K> combine(ReferenceLinkedOpenHashSet<? extends K> toAddFrom) {
        addAll(toAddFrom);
        return this;
    }

    public static <K> Collector<K, ?, ReferenceLinkedOpenHashSet<K>> toSet() {
        return (Collector<K, ?, ReferenceLinkedOpenHashSet<K>>) TO_SET_COLLECTOR;
    }

    public static <K> Collector<K, ?, ReferenceLinkedOpenHashSet<K>> toSetWithExpectedSize(int expectedSize) {
        if (expectedSize <= 16) {
            return toSet();
        }
        return Collector.of(new ReferenceCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 16 ? new ReferenceLinkedOpenHashSet() : new ReferenceLinkedOpenHashSet(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, new Collector.Characteristics[0]);
    }

    private int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2802f);
        if (needed > this.f2801n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2802f)))));
        if (needed > this.f2801n) {
            rehash(needed);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends K> c) {
        if (((double) this.f2802f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(K k) {
        int pos;
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (curr2 == k) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (curr != k);
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            pos = this.f2801n;
            this.containsNull = true;
        }
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
        if (i3 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size + 1, this.f2802f));
        return true;
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
            fixPointers(pos, pos);
        }
    }

    private boolean removeEntry(int pos) {
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f2801n <= this.minN || this.size >= this.maxFill / 4 || this.f2801n <= 16) {
            return true;
        }
        rehash(this.f2801n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f2801n] = null;
        this.size--;
        fixPointers(this.f2801n);
        if (this.f2801n <= this.minN || this.size >= this.maxFill / 4 || this.f2801n <= 16) {
            return true;
        }
        rehash(this.f2801n / 2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object k) {
        K curr;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return false;
            }
            if (k == curr2) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == null) {
                    return false;
                }
            } while (k != curr);
            return removeEntry(pos);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object k) {
        K curr;
        if (k == null) {
            return this.containsNull;
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

    public K removeFirst() {
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
        K k = this.key[pos];
        this.size--;
        if (k == null) {
            this.containsNull = false;
            this.key[this.f2801n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2801n > this.minN && this.size < this.maxFill / 4 && this.f2801n > 16) {
            rehash(this.f2801n / 2);
        }
        return k;
    }

    public K removeLast() {
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
        K k = this.key[pos];
        this.size--;
        if (k == null) {
            this.containsNull = false;
            this.key[this.f2801n] = null;
        } else {
            shiftKeys(pos);
        }
        if (this.f2801n > this.minN && this.size < this.maxFill / 4 && this.f2801n > 16) {
            rehash(this.f2801n / 2);
        }
        return k;
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

    public boolean addAndMoveToFirst(K k) {
        int pos;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k));
            int i = this.mask;
            while (true) {
                pos = mix & i;
                if (key[pos] == null) {
                    break;
                } else if (k == key[pos]) {
                    moveIndexToFirst(pos);
                    return false;
                } else {
                    mix = pos + 1;
                    i = this.mask;
                }
            }
        } else if (this.containsNull) {
            moveIndexToFirst(this.f2801n);
            return false;
        } else {
            this.containsNull = true;
            pos = this.f2801n;
        }
        this.key[pos] = k;
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
        if (i3 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size, this.f2802f));
        return true;
    }

    public boolean addAndMoveToLast(K k) {
        int pos;
        if (k != null) {
            K[] key = this.key;
            int mix = HashCommon.mix(System.identityHashCode(k));
            int i = this.mask;
            while (true) {
                pos = mix & i;
                if (key[pos] == null) {
                    break;
                } else if (k == key[pos]) {
                    moveIndexToLast(pos);
                    return false;
                } else {
                    mix = pos + 1;
                    i = this.mask;
                }
            }
        } else if (this.containsNull) {
            moveIndexToLast(this.f2801n);
            return false;
        } else {
            this.containsNull = true;
            pos = this.f2801n;
        }
        this.key[pos] = k;
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
        if (i3 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size, this.f2802f));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, (Object) null);
            this.last = -1;
            this.first = -1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
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

    @Override // java.util.SortedSet
    public K first() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public K last() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
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

    @Override // java.util.SortedSet
    public Comparator<? super K> comparator() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLinkedOpenHashSet$SetIterator.class */
    public final class SetIterator implements ObjectListIterator<K> {
        int prev;
        int next;
        int curr;
        int index;

        SetIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = ReferenceLinkedOpenHashSet.this.first;
            this.index = 0;
        }

        SetIterator(K from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (from == null) {
                if (ReferenceLinkedOpenHashSet.this.containsNull) {
                    this.next = (int) ReferenceLinkedOpenHashSet.this.link[ReferenceLinkedOpenHashSet.this.f2801n];
                    this.prev = ReferenceLinkedOpenHashSet.this.f2801n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this set.");
            } else if (ReferenceLinkedOpenHashSet.this.key[ReferenceLinkedOpenHashSet.this.last] == from) {
                this.prev = ReferenceLinkedOpenHashSet.this.last;
                this.index = ReferenceLinkedOpenHashSet.this.size;
            } else {
                K[] key = ReferenceLinkedOpenHashSet.this.key;
                int mix = HashCommon.mix(System.identityHashCode(from));
                int i = ReferenceLinkedOpenHashSet.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (key[pos] == null) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this set.");
                    } else if (key[pos] == from) {
                        this.next = (int) ReferenceLinkedOpenHashSet.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = ReferenceLinkedOpenHashSet.this.mask;
                    }
                }
            }
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.next != -1;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.prev != -1;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int) ReferenceLinkedOpenHashSet.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                this.index++;
            }
            return ReferenceLinkedOpenHashSet.this.key[this.curr];
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int) (ReferenceLinkedOpenHashSet.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return ReferenceLinkedOpenHashSet.this.key[this.curr];
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            K[] key = ReferenceLinkedOpenHashSet.this.key;
            long[] link = ReferenceLinkedOpenHashSet.this.link;
            while (this.next != -1) {
                this.curr = this.next;
                this.next = (int) link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                action.accept((Object) key[this.curr]);
            }
        }

        private final void ensureIndexKnown() {
            if (this.index < 0) {
                if (this.prev == -1) {
                    this.index = 0;
                } else if (this.next == -1) {
                    this.index = ReferenceLinkedOpenHashSet.this.size;
                } else {
                    int pos = ReferenceLinkedOpenHashSet.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) ReferenceLinkedOpenHashSet.this.link[pos];
                        this.index++;
                    }
                }
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            ensureIndexKnown();
            return this.index;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            ensureIndexKnown();
            return this.index - 1;
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
                this.prev = (int) (ReferenceLinkedOpenHashSet.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) ReferenceLinkedOpenHashSet.this.link[this.curr];
            }
            ReferenceLinkedOpenHashSet.this.size--;
            if (this.prev == -1) {
                ReferenceLinkedOpenHashSet.this.first = this.next;
            } else {
                long[] jArr = ReferenceLinkedOpenHashSet.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((ReferenceLinkedOpenHashSet.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                ReferenceLinkedOpenHashSet.this.last = this.prev;
            } else {
                long[] jArr2 = ReferenceLinkedOpenHashSet.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((ReferenceLinkedOpenHashSet.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == ReferenceLinkedOpenHashSet.this.f2801n) {
                ReferenceLinkedOpenHashSet.this.containsNull = false;
                ReferenceLinkedOpenHashSet.this.key[ReferenceLinkedOpenHashSet.this.f2801n] = null;
                return;
            }
            K[] key = ReferenceLinkedOpenHashSet.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = ReferenceLinkedOpenHashSet.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(System.identityHashCode(curr)) & ReferenceLinkedOpenHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = ReferenceLinkedOpenHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = ReferenceLinkedOpenHashSet.this.mask;
                    }
                }
                key[pos] = curr;
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                ReferenceLinkedOpenHashSet.this.fixPointers(pos, pos);
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceSortedSet
    public ObjectListIterator<K> iterator(K from) {
        return new SetIterator(from);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    public ObjectListIterator<K> iterator() {
        return new SetIterator();
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 81);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        int next = this.first;
        while (next != -1) {
            next = (int) this.link[next];
            action.accept((Object) this.key[next]);
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2802f)));
        if (l >= this.f2801n || this.size > HashCommon.maxFill(l, this.f2802f)) {
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
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
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
        this.f2801n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f2801n, this.f2802f);
        this.key = newKey;
    }

    @Override // java.lang.Object
    public ReferenceLinkedOpenHashSet<K> clone() {
        try {
            ReferenceLinkedOpenHashSet<K> c = (ReferenceLinkedOpenHashSet) clone();
            c.key = (K[]) ((Object[]) this.key.clone());
            c.containsNull = this.containsNull;
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (this.key[i] == null) {
                i++;
            }
            if (this != this.key[i]) {
                h += System.identityHashCode(this.key[i]);
            }
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        ObjectIterator<K> i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeObject(i.next());
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: K[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v29, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v31, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f2801n = HashCommon.arraySize(this.size, this.f2802f);
        this.maxFill = HashCommon.maxFill(this.f2801n, this.f2802f);
        this.mask = this.f2801n - 1;
        K[] key = (K[]) new Object[this.f2801n + 1];
        this.key = key;
        long[] link = new long[this.f2801n + 1];
        this.link = link;
        int prev = -1;
        this.last = -1;
        this.first = -1;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 == 0) {
                break;
            }
            Object readObject = s.readObject();
            if (readObject == null) {
                pos = this.f2801n;
                this.containsNull = true;
            } else {
                int mix = HashCommon.mix(System.identityHashCode(readObject)) & this.mask;
                pos = mix;
                if (key[mix] != 0) {
                    do {
                        i = (pos + 1) & this.mask;
                        pos = i;
                    } while (key[i] != 0);
                }
            }
            key[pos] = readObject;
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
