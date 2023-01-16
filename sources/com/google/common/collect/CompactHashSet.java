package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/collect/CompactHashSet.class */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    private static final long HASH_MASK = -4294967296L;
    private static final int DEFAULT_SIZE = 3;
    static final int UNSET = -1;
    private transient int[] table;
    private transient long[] entries;
    transient Object[] elements;
    transient float loadFactor;
    transient int modCount;
    private transient int threshold;
    private transient int size;

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> set = createWithExpectedSize(collection.size());
        set.addAll(collection);
        return set;
    }

    public static <E> CompactHashSet<E> create(E... elements) {
        CompactHashSet<E> set = createWithExpectedSize(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int expectedSize) {
        return new CompactHashSet<>(expectedSize);
    }

    /* access modifiers changed from: package-private */
    public CompactHashSet() {
        init(3, DEFAULT_LOAD_FACTOR);
    }

    /* access modifiers changed from: package-private */
    public CompactHashSet(int expectedSize) {
        init(expectedSize, DEFAULT_LOAD_FACTOR);
    }

    /* access modifiers changed from: package-private */
    public void init(int expectedSize, float loadFactor) {
        Preconditions.checkArgument(expectedSize >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(loadFactor > 0.0f, "Illegal load factor");
        int buckets = Hashing.closedTableSize(expectedSize, (double) loadFactor);
        this.table = newTable(buckets);
        this.loadFactor = loadFactor;
        this.elements = new Object[expectedSize];
        this.entries = newEntries(expectedSize);
        this.threshold = Math.max(1, (int) (((float) buckets) * loadFactor));
    }

    private static int[] newTable(int size) {
        int[] array = new int[size];
        Arrays.fill(array, -1);
        return array;
    }

    private static long[] newEntries(int size) {
        long[] array = new long[size];
        Arrays.fill(array, -1L);
        return array;
    }

    /* access modifiers changed from: private */
    public static int getHash(long entry) {
        return (int) (entry >>> 32);
    }

    private static int getNext(long entry) {
        return (int) entry;
    }

    private static long swapNext(long entry, int newNext) {
        return (HASH_MASK & entry) | (NEXT_MASK & ((long) newNext));
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(E object) {
        long entry;
        long[] entries = this.entries;
        Object[] elements = this.elements;
        int hash = Hashing.smearedHash(object);
        int tableIndex = hash & hashTableMask();
        int newEntryIndex = this.size;
        int next = this.table[tableIndex];
        if (next == -1) {
            this.table[tableIndex] = newEntryIndex;
        } else {
            do {
                entry = entries[next];
                if (getHash(entry) == hash && Objects.equal(object, elements[next])) {
                    return false;
                }
                next = getNext(entry);
            } while (next != -1);
            entries[next] = swapNext(entry, newEntryIndex);
        }
        if (newEntryIndex == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int newSize = newEntryIndex + 1;
        resizeMeMaybe(newSize);
        insertEntry(newEntryIndex, object, hash);
        this.size = newSize;
        if (newEntryIndex >= this.threshold) {
            resizeTable(2 * this.table.length);
        }
        this.modCount++;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int entryIndex, E object, int hash) {
        this.entries[entryIndex] = (((long) hash) << 32) | NEXT_MASK;
        this.elements[entryIndex] = object;
    }

    private void resizeMeMaybe(int newSize) {
        int entriesSize = this.entries.length;
        if (newSize > entriesSize) {
            int newCapacity = entriesSize + Math.max(1, entriesSize >>> 1);
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            if (newCapacity != entriesSize) {
                resizeEntries(newCapacity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int newCapacity) {
        this.elements = Arrays.copyOf(this.elements, newCapacity);
        long[] entries = this.entries;
        int oldSize = entries.length;
        long[] entries2 = Arrays.copyOf(entries, newCapacity);
        if (newCapacity > oldSize) {
            Arrays.fill(entries2, oldSize, newCapacity, -1L);
        }
        this.entries = entries2;
    }

    private void resizeTable(int newCapacity) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int newThreshold = 1 + ((int) (((float) newCapacity) * this.loadFactor));
        int[] newTable = newTable(newCapacity);
        long[] entries = this.entries;
        int mask = newTable.length - 1;
        for (int i = 0; i < this.size; i++) {
            int hash = getHash(entries[i]);
            int tableIndex = hash & mask;
            int next = newTable[tableIndex];
            newTable[tableIndex] = i;
            entries[i] = (((long) hash) << 32) | (NEXT_MASK & ((long) next));
        }
        this.threshold = newThreshold;
        this.table = newTable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object object) {
        int hash = Hashing.smearedHash(object);
        int next = this.table[hash & hashTableMask()];
        while (next != -1) {
            long entry = this.entries[next];
            if (getHash(entry) == hash && Objects.equal(object, this.elements[next])) {
                return true;
            }
            next = getNext(entry);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(Object object) {
        return remove(object, Hashing.smearedHash(object));
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean remove(Object object, int hash) {
        int tableIndex = hash & hashTableMask();
        int next = this.table[tableIndex];
        if (next == -1) {
            return false;
        }
        int last = -1;
        do {
            if (getHash(this.entries[next]) != hash || !Objects.equal(object, this.elements[next])) {
                last = next;
                next = getNext(this.entries[next]);
            } else {
                if (last == -1) {
                    this.table[tableIndex] = getNext(this.entries[next]);
                } else {
                    this.entries[last] = swapNext(this.entries[last], getNext(this.entries[next]));
                }
                moveEntry(next);
                this.size--;
                this.modCount++;
                return true;
            }
        } while (next != -1);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void moveEntry(int dstIndex) {
        long entry;
        int srcIndex = size() - 1;
        if (dstIndex < srcIndex) {
            this.elements[dstIndex] = this.elements[srcIndex];
            this.elements[srcIndex] = null;
            long lastEntry = this.entries[srcIndex];
            this.entries[dstIndex] = lastEntry;
            this.entries[srcIndex] = -1;
            int tableIndex = getHash(lastEntry) & hashTableMask();
            int lastNext = this.table[tableIndex];
            if (lastNext == srcIndex) {
                this.table[tableIndex] = dstIndex;
                return;
            }
            do {
                entry = this.entries[lastNext];
                lastNext = getNext(entry);
            } while (lastNext != srcIndex);
            this.entries[lastNext] = swapNext(entry, dstIndex);
            return;
        }
        this.elements[dstIndex] = null;
        this.entries[dstIndex] = -1;
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    int getSuccessor(int entryIndex) {
        if (entryIndex + 1 < this.size) {
            return entryIndex + 1;
        }
        return -1;
    }

    int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: com.google.common.collect.CompactHashSet.1
            int expectedModCount;
            int index;
            int indexToRemove = -1;

            {
                this.expectedModCount = CompactHashSet.this.modCount;
                this.index = CompactHashSet.this.firstEntryIndex();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index >= 0;
            }

            @Override // java.util.Iterator
            public E next() {
                checkForConcurrentModification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.indexToRemove = this.index;
                E result = (E) CompactHashSet.this.elements[this.index];
                this.index = CompactHashSet.this.getSuccessor(this.index);
                return result;
            }

            @Override // java.util.Iterator
            public void remove() {
                checkForConcurrentModification();
                CollectPreconditions.checkRemove(this.indexToRemove >= 0);
                this.expectedModCount++;
                CompactHashSet.this.remove(CompactHashSet.this.elements[this.indexToRemove], CompactHashSet.getHash(CompactHashSet.this.entries[this.indexToRemove]));
                this.index = CompactHashSet.this.adjustAfterRemove(this.index, this.indexToRemove);
                this.indexToRemove = -1;
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.elements, 0, this.size, 17);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Preconditions.checkNotNull(action);
        for (int i = 0; i < this.size; i++) {
            action.accept(this.elements[i]);
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] a) {
        return (T[]) ObjectArrays.toArrayImpl(this.elements, 0, this.size, a);
    }

    public void trimToSize() {
        int size = this.size;
        if (size < this.entries.length) {
            resizeEntries(size);
        }
        int minimumTableSize = Math.max(1, Integer.highestOneBit((int) (((float) size) / this.loadFactor)));
        if (minimumTableSize < 1073741824 && ((double) size) / ((double) minimumTableSize) > ((double) this.loadFactor)) {
            minimumTableSize <<= 1;
        }
        if (minimumTableSize < this.table.length) {
            resizeTable(minimumTableSize);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(this.size);
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            stream.writeObject(it.next());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.CompactHashSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        init(3, DEFAULT_LOAD_FACTOR);
        int i = stream.readInt();
        while (true) {
            i--;
            if (i >= 0) {
                add(stream.readObject());
            } else {
                return;
            }
        }
    }
}
