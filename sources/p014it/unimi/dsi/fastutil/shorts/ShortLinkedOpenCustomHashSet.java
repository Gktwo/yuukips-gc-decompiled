package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.shorts.ShortHash;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortLinkedOpenCustomHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLinkedOpenCustomHashSet.class */
public class ShortLinkedOpenCustomHashSet extends AbstractShortSortedSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient short[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected ShortHash.Strategy strategy;
    protected transient int first;
    protected transient int last;
    protected transient long[] link;

    /* renamed from: n */
    protected transient int f3019n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f3020f;
    private static final int SPLITERATOR_CHARACTERISTICS = 337;

    public ShortLinkedOpenCustomHashSet(int expected, float f, ShortHash.Strategy strategy) {
        this.first = -1;
        this.last = -1;
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f3020f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f3019n = arraySize;
            this.minN = arraySize;
            this.mask = this.f3019n - 1;
            this.maxFill = HashCommon.maxFill(this.f3019n, f);
            this.key = new short[this.f3019n + 1];
            this.link = new long[this.f3019n + 1];
        }
    }

    public ShortLinkedOpenCustomHashSet(int expected, ShortHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(ShortHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(Collection<? extends Short> c, float f, ShortHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public ShortLinkedOpenCustomHashSet(Collection<? extends Short> c, ShortHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(ShortCollection c, float f, ShortHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public ShortLinkedOpenCustomHashSet(ShortCollection c, ShortHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(ShortIterator i, float f, ShortHash.Strategy strategy) {
        this(16, f, strategy);
        while (i.hasNext()) {
            add(i.nextShort());
        }
    }

    public ShortLinkedOpenCustomHashSet(ShortIterator i, ShortHash.Strategy strategy) {
        this(i, 0.75f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(Iterator<?> i, float f, ShortHash.Strategy strategy) {
        this(ShortIterators.asShortIterator(i), f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(Iterator<?> i, ShortHash.Strategy strategy) {
        this(ShortIterators.asShortIterator(i), strategy);
    }

    public ShortLinkedOpenCustomHashSet(short[] a, int offset, int length, float f, ShortHash.Strategy strategy) {
        this(length < 0 ? 0 : length, f, strategy);
        ShortArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ShortLinkedOpenCustomHashSet(short[] a, int offset, int length, ShortHash.Strategy strategy) {
        this(a, offset, length, 0.75f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(short[] a, float f, ShortHash.Strategy strategy) {
        this(a, 0, a.length, f, strategy);
    }

    public ShortLinkedOpenCustomHashSet(short[] a, ShortHash.Strategy strategy) {
        this(a, 0.75f, strategy);
    }

    public ShortHash.Strategy strategy() {
        return this.strategy;
    }

    private int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f3020f);
        if (needed > this.f3019n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f3020f)))));
        if (needed > this.f3019n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean addAll(ShortCollection c) {
        if (((double) this.f3020f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Short> c) {
        if (((double) this.f3020f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean add(short k) {
        int pos;
        short curr;
        if (!this.strategy.equals(k, 0)) {
            short[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            pos = mix;
            short curr2 = key[mix];
            if (curr2 != 0) {
                if (this.strategy.equals(curr2, k)) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (!this.strategy.equals(curr, k));
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            pos = this.f3019n;
            this.containsNull = true;
            this.key[this.f3019n] = k;
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
        rehash(HashCommon.arraySize(this.size + 1, this.f3020f));
        return true;
    }

    protected final void shiftKeys(int pos) {
        short curr;
        short[] key = this.key;
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
                int slot = HashCommon.mix(this.strategy.hashCode(curr)) & this.mask;
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
        if (this.f3019n <= this.minN || this.size >= this.maxFill / 4 || this.f3019n <= 16) {
            return true;
        }
        rehash(this.f3019n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f3019n] = 0;
        this.size--;
        fixPointers(this.f3019n);
        if (this.f3019n <= this.minN || this.size >= this.maxFill / 4 || this.f3019n <= 16) {
            return true;
        }
        rehash(this.f3019n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
    public boolean remove(short k) {
        short curr;
        if (!this.strategy.equals(k, 0)) {
            short[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            short curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (this.strategy.equals(k, curr2)) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (!this.strategy.equals(k, curr));
            return removeEntry(pos);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean contains(short k) {
        short curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNull;
        }
        short[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        short curr2 = key[mix];
        if (curr2 == 0) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
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
        short k = this.key[pos];
        this.size--;
        if (this.strategy.equals(k, 0)) {
            this.containsNull = false;
            this.key[this.f3019n] = 0;
        } else {
            shiftKeys(pos);
        }
        if (this.f3019n > this.minN && this.size < this.maxFill / 4 && this.f3019n > 16) {
            rehash(this.f3019n / 2);
        }
        return k;
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
        short k = this.key[pos];
        this.size--;
        if (this.strategy.equals(k, 0)) {
            this.containsNull = false;
            this.key[this.f3019n] = 0;
        } else {
            shiftKeys(pos);
        }
        if (this.f3019n > this.minN && this.size < this.maxFill / 4 && this.f3019n > 16) {
            rehash(this.f3019n / 2);
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

    public boolean addAndMoveToFirst(short k) {
        int pos;
        if (!this.strategy.equals(k, 0)) {
            short[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k));
            int i = this.mask;
            while (true) {
                pos = mix & i;
                if (key[pos] == 0) {
                    break;
                } else if (this.strategy.equals(k, key[pos])) {
                    moveIndexToFirst(pos);
                    return false;
                } else {
                    mix = pos + 1;
                    i = this.mask;
                }
            }
        } else if (this.containsNull) {
            moveIndexToFirst(this.f3019n);
            return false;
        } else {
            this.containsNull = true;
            pos = this.f3019n;
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
        rehash(HashCommon.arraySize(this.size, this.f3020f));
        return true;
    }

    public boolean addAndMoveToLast(short k) {
        int pos;
        if (!this.strategy.equals(k, 0)) {
            short[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k));
            int i = this.mask;
            while (true) {
                pos = mix & i;
                if (key[pos] == 0) {
                    break;
                } else if (this.strategy.equals(k, key[pos])) {
                    moveIndexToLast(pos);
                    return false;
                } else {
                    mix = pos + 1;
                    i = this.mask;
                }
            }
        } else if (this.containsNull) {
            moveIndexToLast(this.f3019n);
            return false;
        } else {
            this.containsNull = true;
            pos = this.f3019n;
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
        rehash(HashCommon.arraySize(this.size, this.f3020f));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, (short) 0);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public short firstShort() {
        if (this.size != 0) {
            return this.key[this.first];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public short lastShort() {
        if (this.size != 0) {
            return this.key[this.last];
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortSortedSet tailSet(short from) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortSortedSet headSet(short to) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortSortedSet subSet(short from, short to) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
    public Comparator<? super Short> comparator() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortLinkedOpenCustomHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLinkedOpenCustomHashSet$SetIterator.class */
    public final class SetIterator implements ShortListIterator {
        int prev;
        int next;
        int curr;
        int index;

        SetIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = ShortLinkedOpenCustomHashSet.this.first;
            this.index = 0;
        }

        SetIterator(short from) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (ShortLinkedOpenCustomHashSet.this.strategy.equals(from, 0)) {
                if (ShortLinkedOpenCustomHashSet.this.containsNull) {
                    this.next = (int) ShortLinkedOpenCustomHashSet.this.link[ShortLinkedOpenCustomHashSet.this.f3019n];
                    this.prev = ShortLinkedOpenCustomHashSet.this.f3019n;
                    return;
                }
                throw new NoSuchElementException("The key " + ((int) from) + " does not belong to this set.");
            } else if (ShortLinkedOpenCustomHashSet.this.strategy.equals(ShortLinkedOpenCustomHashSet.this.key[ShortLinkedOpenCustomHashSet.this.last], from)) {
                this.prev = ShortLinkedOpenCustomHashSet.this.last;
                this.index = ShortLinkedOpenCustomHashSet.this.size;
            } else {
                short[] key = ShortLinkedOpenCustomHashSet.this.key;
                int mix = HashCommon.mix(ShortLinkedOpenCustomHashSet.this.strategy.hashCode(from));
                int i = ShortLinkedOpenCustomHashSet.this.mask;
                while (true) {
                    int pos = mix & i;
                    if (key[pos] == 0) {
                        throw new NoSuchElementException("The key " + ((int) from) + " does not belong to this set.");
                    } else if (ShortLinkedOpenCustomHashSet.this.strategy.equals(key[pos], from)) {
                        this.next = (int) ShortLinkedOpenCustomHashSet.this.link[pos];
                        this.prev = pos;
                        return;
                    } else {
                        mix = pos + 1;
                        i = ShortLinkedOpenCustomHashSet.this.mask;
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int) ShortLinkedOpenCustomHashSet.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                this.index++;
            }
            return ShortLinkedOpenCustomHashSet.this.key[this.curr];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int) (ShortLinkedOpenCustomHashSet.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                this.index--;
            }
            return ShortLinkedOpenCustomHashSet.this.key[this.curr];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            short[] key = ShortLinkedOpenCustomHashSet.this.key;
            long[] link = ShortLinkedOpenCustomHashSet.this.link;
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
                    this.index = ShortLinkedOpenCustomHashSet.this.size;
                } else {
                    int pos = ShortLinkedOpenCustomHashSet.this.first;
                    this.index = 1;
                    while (pos != this.prev) {
                        pos = (int) ShortLinkedOpenCustomHashSet.this.link[pos];
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            short curr;
            ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
                this.prev = (int) (ShortLinkedOpenCustomHashSet.this.link[this.curr] >>> 32);
            } else {
                this.next = (int) ShortLinkedOpenCustomHashSet.this.link[this.curr];
            }
            ShortLinkedOpenCustomHashSet.this.size--;
            if (this.prev == -1) {
                ShortLinkedOpenCustomHashSet.this.first = this.next;
            } else {
                long[] jArr = ShortLinkedOpenCustomHashSet.this.link;
                int i = this.prev;
                jArr[i] = jArr[i] ^ ((ShortLinkedOpenCustomHashSet.this.link[this.prev] ^ (((long) this.next) & 4294967295L)) & 4294967295L);
            }
            if (this.next == -1) {
                ShortLinkedOpenCustomHashSet.this.last = this.prev;
            } else {
                long[] jArr2 = ShortLinkedOpenCustomHashSet.this.link;
                int i2 = this.next;
                jArr2[i2] = jArr2[i2] ^ ((ShortLinkedOpenCustomHashSet.this.link[this.next] ^ ((((long) this.prev) & 4294967295L) << 32)) & -4294967296L);
            }
            int pos = this.curr;
            this.curr = -1;
            if (pos == ShortLinkedOpenCustomHashSet.this.f3019n) {
                ShortLinkedOpenCustomHashSet.this.containsNull = false;
                ShortLinkedOpenCustomHashSet.this.key[ShortLinkedOpenCustomHashSet.this.f3019n] = 0;
                return;
            }
            short[] key = ShortLinkedOpenCustomHashSet.this.key;
            while (true) {
                int i3 = pos + 1;
                int i4 = ShortLinkedOpenCustomHashSet.this.mask;
                while (true) {
                    pos = i3 & i4;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(ShortLinkedOpenCustomHashSet.this.strategy.hashCode(curr)) & ShortLinkedOpenCustomHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = ShortLinkedOpenCustomHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i3 = pos + 1;
                        i4 = ShortLinkedOpenCustomHashSet.this.mask;
                    }
                }
                key[pos] = curr;
                if (this.next == pos) {
                    this.next = pos;
                }
                if (this.prev == pos) {
                    this.prev = pos;
                }
                ShortLinkedOpenCustomHashSet.this.fixPointers(pos, pos);
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortListIterator iterator(short from) {
        return new SetIterator(from);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortListIterator iterator() {
        return new SetIterator();
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortSpliterator spliterator() {
        return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 337);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public void forEach(ShortConsumer action) {
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
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f3020f)));
        if (l >= this.f3019n || this.size > HashCommon.maxFill(l, this.f3020f)) {
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
        short[] key = this.key;
        int mask = newN - 1;
        short[] newKey = new short[newN + 1];
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
            if (!this.strategy.equals(key[i], 0)) {
                int mix = HashCommon.mix(this.strategy.hashCode(key[i]));
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
        this.f3019n = newN;
        this.mask = mask;
        this.maxFill = HashCommon.maxFill(this.f3019n, this.f3020f);
        this.key = newKey;
    }

    @Override // java.lang.Object
    public ShortLinkedOpenCustomHashSet clone() {
        try {
            ShortLinkedOpenCustomHashSet c = (ShortLinkedOpenCustomHashSet) clone();
            c.key = (short[]) this.key.clone();
            c.containsNull = this.containsNull;
            c.link = (long[]) this.link.clone();
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (this.key[i] == 0) {
                i++;
            }
            h += this.strategy.hashCode(this.key[i]);
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        ShortIterator i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeShort(i.nextShort());
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f3019n = HashCommon.arraySize(this.size, this.f3020f);
        this.maxFill = HashCommon.maxFill(this.f3019n, this.f3020f);
        this.mask = this.f3019n - 1;
        short[] key = new short[this.f3019n + 1];
        this.key = key;
        long[] link = new long[this.f3019n + 1];
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
            short k = s.readShort();
            if (this.strategy.equals(k, 0)) {
                pos = this.f3019n;
                this.containsNull = true;
            } else {
                int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
                pos = mix;
                if (key[mix] != 0) {
                    do {
                        i = (pos + 1) & this.mask;
                        pos = i;
                    } while (key[i] != 0);
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
