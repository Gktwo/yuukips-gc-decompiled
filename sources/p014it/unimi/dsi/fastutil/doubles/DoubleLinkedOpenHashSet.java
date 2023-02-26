package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLinkedOpenHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLinkedOpenHashSet.class */
public class DoubleLinkedOpenHashSet extends AbstractDoubleSortedSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient double[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f1698n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1699f;
    private static final int SPLITERATOR_CHARACTERISTICS = 337;

    public DoubleLinkedOpenHashSet(int expected, float f) {
        this.first = -1;
        this.last = -1;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1699f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1698n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1698n - 1;
            this.maxFill = HashCommon.maxFill(this.f1698n, f);
            this.key = new double[this.f1698n + 1];
            this.link = new long[this.f1698n + 1];
        }
    }

    public DoubleLinkedOpenHashSet(int expected) {
        this(expected, 0.75f);
    }

    public DoubleLinkedOpenHashSet() {
        this(16, 0.75f);
    }

    public DoubleLinkedOpenHashSet(Collection<? extends Double> c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public DoubleLinkedOpenHashSet(Collection<? extends Double> c) {
        this(c, 0.75f);
    }

    public DoubleLinkedOpenHashSet(DoubleCollection c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public DoubleLinkedOpenHashSet(DoubleCollection c) {
        this(c, 0.75f);
    }

    public DoubleLinkedOpenHashSet(DoubleIterator i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.nextDouble());
        }
    }

    public DoubleLinkedOpenHashSet(DoubleIterator i) {
        this(i, 0.75f);
    }

    public DoubleLinkedOpenHashSet(Iterator<?> i, float f) {
        this(DoubleIterators.asDoubleIterator(i), f);
    }

    public DoubleLinkedOpenHashSet(Iterator<?> i) {
        this(DoubleIterators.asDoubleIterator(i));
    }

    public DoubleLinkedOpenHashSet(double[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : length, f);
        DoubleArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public DoubleLinkedOpenHashSet(double[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public DoubleLinkedOpenHashSet(double[] a, float f) {
        this(a, 0, a.length, f);
    }

    public DoubleLinkedOpenHashSet(double[] a) {
        this(a, 0.75f);
    }

    /* renamed from: of */
    public static DoubleLinkedOpenHashSet m894of() {
        return new DoubleLinkedOpenHashSet();
    }

    /* renamed from: of */
    public static DoubleLinkedOpenHashSet m893of(double e) {
        DoubleLinkedOpenHashSet result = new DoubleLinkedOpenHashSet(1, 0.75f);
        result.add(e);
        return result;
    }

    /* renamed from: of */
    public static DoubleLinkedOpenHashSet m892of(double e0, double e1) {
        DoubleLinkedOpenHashSet result = new DoubleLinkedOpenHashSet(2, 0.75f);
        result.add(e0);
        if (result.add(e1)) {
            return result;
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    public static DoubleLinkedOpenHashSet m891of(double e0, double e1, double e2) {
        DoubleLinkedOpenHashSet result = new DoubleLinkedOpenHashSet(3, 0.75f);
        result.add(e0);
        if (!result.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (result.add(e2)) {
            return result;
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    public static DoubleLinkedOpenHashSet m890of(double... a) {
        DoubleLinkedOpenHashSet result = new DoubleLinkedOpenHashSet(a.length, 0.75f);
        for (double element : a) {
            if (!result.add(element)) {
                throw new IllegalArgumentException("Duplicate element " + element);
            }
        }
        return result;
    }

    public static DoubleLinkedOpenHashSet toSet(DoubleStream stream) {
        return (DoubleLinkedOpenHashSet) stream.collect(DoubleLinkedOpenHashSet::new, (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    public static DoubleLinkedOpenHashSet toSetWithExpectedSize(DoubleStream stream, int expectedSize) {
        if (expectedSize <= 16) {
            return toSet(stream);
        }
        return (DoubleLinkedOpenHashSet) stream.collect(new DoubleCollections.SizeDecreasingSupplier(expectedSize, size -> {
            return size <= 16 ? new DoubleLinkedOpenHashSet() : new DoubleLinkedOpenHashSet(size);
        }), (v0, v1) -> {
            v0.add(v1);
        }, (v0, v1) -> {
            v0.addAll(v1);
        });
    }

    private int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1699f);
        if (needed > this.f1698n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1699f)))));
        if (needed > this.f1698n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean addAll(DoubleCollection c) {
        if (((double) this.f1699f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Double> c) {
        if (((double) this.f1699f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean add(double k) {
        int pos;
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) != 0) {
                if (Double.doubleToLongBits(curr2) == Double.doubleToLongBits(k)) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (Double.doubleToLongBits(curr) != 0) {
                    }
                } while (Double.doubleToLongBits(curr) != Double.doubleToLongBits(k));
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            pos = this.f1698n;
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
        rehash(HashCommon.arraySize(this.size + 1, this.f1699f));
        return true;
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
            fixPointers(pos, pos);
        }
    }

    private boolean removeEntry(int pos) {
        this.size--;
        fixPointers(pos);
        shiftKeys(pos);
        if (this.f1698n <= this.minN || this.size >= this.maxFill / 4 || this.f1698n <= 16) {
            return true;
        }
        rehash(this.f1698n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f1698n] = 0.0d;
        this.size--;
        fixPointers(this.f1698n);
        if (this.f1698n <= this.minN || this.size >= this.maxFill / 4 || this.f1698n <= 16) {
            return true;
        }
        rehash(this.f1698n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
    public boolean remove(double k) {
        double curr;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
            int pos = mix;
            double curr2 = key[mix];
            if (Double.doubleToLongBits(curr2) == 0) {
                return false;
            }
            if (Double.doubleToLongBits(k) == Double.doubleToLongBits(curr2)) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (Double.doubleToLongBits(curr) == 0) {
                    return false;
                }
            } while (Double.doubleToLongBits(k) != Double.doubleToLongBits(curr));
            return removeEntry(pos);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean contains(double k) {
        double curr;
        if (Double.doubleToLongBits(k) == 0) {
            return this.containsNull;
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
        double k = this.key[pos];
        this.size--;
        if (Double.doubleToLongBits(k) == 0) {
            this.containsNull = false;
            this.key[this.f1698n] = 0.0d;
        } else {
            shiftKeys(pos);
        }
        if (this.f1698n > this.minN && this.size < this.maxFill / 4 && this.f1698n > 16) {
            rehash(this.f1698n / 2);
        }
        return k;
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
        double k = this.key[pos];
        this.size--;
        if (Double.doubleToLongBits(k) == 0) {
            this.containsNull = false;
            this.key[this.f1698n] = 0.0d;
        } else {
            shiftKeys(pos);
        }
        if (this.f1698n > this.minN && this.size < this.maxFill / 4 && this.f1698n > 16) {
            rehash(this.f1698n / 2);
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

    public boolean addAndMoveToFirst(double k) {
        int pos;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(k));
            int i = this.mask;
            while (true) {
                pos = mix & i;
                if (Double.doubleToLongBits(key[pos]) == 0) {
                    break;
                } else if (Double.doubleToLongBits(k) == Double.doubleToLongBits(key[pos])) {
                    moveIndexToFirst(pos);
                    return false;
                } else {
                    mix = pos + 1;
                    i = this.mask;
                }
            }
        } else if (this.containsNull) {
            moveIndexToFirst(this.f1698n);
            return false;
        } else {
            this.containsNull = true;
            pos = this.f1698n;
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
        rehash(HashCommon.arraySize(this.size, this.f1699f));
        return true;
    }

    public boolean addAndMoveToLast(double k) {
        int pos;
        if (Double.doubleToLongBits(k) != 0) {
            double[] key = this.key;
            int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(k));
            int i = this.mask;
            while (true) {
                pos = mix & i;
                if (Double.doubleToLongBits(key[pos]) == 0) {
                    break;
                } else if (Double.doubleToLongBits(k) == Double.doubleToLongBits(key[pos])) {
                    moveIndexToLast(pos);
                    return false;
                } else {
                    mix = pos + 1;
                    i = this.mask;
                }
            }
        } else if (this.containsNull) {
            moveIndexToLast(this.f1698n);
            return false;
        } else {
            this.containsNull = true;
            pos = this.f1698n;
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
        rehash(HashCommon.arraySize(this.size, this.f1699f));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, 0.0d);
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

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public double firstDouble() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public double lastDouble() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
    public Comparator<? super Double> comparator() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLinkedOpenHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLinkedOpenHashSet$SetIterator.class */
    public final class SetIterator implements DoubleListIterator {
        int prev;
        int next;
        int curr;
        int index;

        SetIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = DoubleLinkedOpenHashSet.this.first;
            this.index = 0;
        }

        SetIterator(double from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (Double.doubleToLongBits(from) == 0) {
                if (DoubleLinkedOpenHashSet.this.containsNull) {
                    this.next = (int) DoubleLinkedOpenHashSet.this.link[DoubleLinkedOpenHashSet.this.f1698n];
                    this.prev = DoubleLinkedOpenHashSet.this.f1698n;
                    return;
                }
                throw new NoSuchElementException("The key " + from + " does not belong to this set.");
            } else if (Double.doubleToLongBits(DoubleLinkedOpenHashSet.this.key[DoubleLinkedOpenHashSet.this.last]) == Double.doubleToLongBits(from)) {
                this.prev = DoubleLinkedOpenHashSet.this.last;
                this.index = DoubleLinkedOpenHashSet.this.size;
            } else {
                double[] key = DoubleLinkedOpenHashSet.this.key;
                int mix = (int) HashCommon.mix(Double.doubleToRawLongBits(from));
                int i = DoubleLinkedOpenHashSet.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (Double.doubleToLongBits(key[pos]) == 0) {
                        throw new NoSuchElementException("The key " + from + " does not belong to this set.");
                    } else if (Double.doubleToLongBits(key[pos]) == Double.doubleToLongBits(from)) {
                        this.next = (int) DoubleLinkedOpenHashSet.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = DoubleLinkedOpenHashSet.this.mask;
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int) DoubleLinkedOpenHashSet.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                this.index++;
            }
            return DoubleLinkedOpenHashSet.this.key[this.curr];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int) (DoubleLinkedOpenHashSet.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return DoubleLinkedOpenHashSet.this.key[this.curr];
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            double[] key = DoubleLinkedOpenHashSet.this.key;
            long[] link = DoubleLinkedOpenHashSet.this.link;
            while (this.next != -1) {
                this.curr = this.next;
                this.next = (int) link[this.curr];
                this.prev = this.curr;
                if (this.index >= 0) {
                    this.index++;
                }
                action.accept(key[this.curr]);
            }
        }

        private final void ensureIndexKnown() {
            if (this.index < 0) {
                if (this.prev == -1) {
                    this.index = 0;
                } else if (this.next == -1) {
                    this.index = DoubleLinkedOpenHashSet.this.size;
                } else {
                    int pos = DoubleLinkedOpenHashSet.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) DoubleLinkedOpenHashSet.this.link[pos];
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            double curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (DoubleLinkedOpenHashSet.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) DoubleLinkedOpenHashSet.this.link[this.curr];
            }
            DoubleLinkedOpenHashSet.this.size--;
            if (this.prev == -1) {
                DoubleLinkedOpenHashSet.this.first = this.next;
            } else {
                long[] jArr = DoubleLinkedOpenHashSet.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((DoubleLinkedOpenHashSet.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                DoubleLinkedOpenHashSet.this.last = this.prev;
            } else {
                long[] jArr2 = DoubleLinkedOpenHashSet.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((DoubleLinkedOpenHashSet.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == DoubleLinkedOpenHashSet.this.f1698n) {
                DoubleLinkedOpenHashSet.this.containsNull = false;
                DoubleLinkedOpenHashSet.this.key[DoubleLinkedOpenHashSet.this.f1698n] = 0.0d;
                return;
            }
            double[] key = DoubleLinkedOpenHashSet.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = DoubleLinkedOpenHashSet.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (Double.doubleToLongBits(curr) == 0) {
                        key[pos] = 0.0d;
                        return;
                    }
                    int slot = ((int) HashCommon.mix(Double.doubleToRawLongBits(curr))) & DoubleLinkedOpenHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = DoubleLinkedOpenHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = DoubleLinkedOpenHashSet.this.mask;
                    }
                }
                key[pos] = curr;
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                DoubleLinkedOpenHashSet.this.fixPointers(pos, pos);
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public DoubleListIterator iterator(double from) {
        return new SetIterator(from);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSortedSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleListIterator iterator() {
        return new SetIterator();
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleSpliterator spliterator() {
        return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 337);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public void forEach(DoubleConsumer action) {
        int next = this.first;
        while (next != -1) {
            next = (int) this.link[next];
            action.accept(this.key[next]);
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1699f)));
        if (l >= this.f1698n || this.size > HashCommon.maxFill(l, this.f1699f)) {
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
        int mask = newN - 1;
        double[] newKey = new double[newN + 1];
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
        this.f1698n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f1698n, this.f1699f);
        this.key = newKey;
    }

    @Override // java.lang.Object
    public DoubleLinkedOpenHashSet clone() {
        try {
            DoubleLinkedOpenHashSet c = (DoubleLinkedOpenHashSet) clone();
            c.key = (double[]) this.key.clone();
            c.containsNull = this.containsNull;
            c.link = (long[]) this.link.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (Double.doubleToLongBits(this.key[i]) == 0) {
                i++;
            }
            h += HashCommon.double2int(this.key[i]);
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        DoubleIterator i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeDouble(i.nextDouble());
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f1698n = HashCommon.arraySize(this.size, this.f1699f);
        this.maxFill = HashCommon.maxFill(this.f1698n, this.f1699f);
        this.mask = this.f1698n - 1;
        double[] key = new double[this.f1698n + 1];
        this.key = key;
        long[] link = new long[this.f1698n + 1];
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
            double k = s.readDouble();
            if (Double.doubleToLongBits(k) == 0) {
                pos = this.f1698n;
                this.containsNull = true;
            } else {
                int mix = ((int) HashCommon.mix(Double.doubleToRawLongBits(k))) & this.mask;
                pos = mix;
                if (Double.doubleToLongBits(key[mix]) != 0) {
                    do {
                        i = (pos + 1) & this.mask;
                        pos = i;
                    } while (Double.doubleToLongBits(key[i]) != 0);
                }
            }
            key[pos] = k;
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
