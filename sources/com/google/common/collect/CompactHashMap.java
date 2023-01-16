package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/collect/CompactHashMap.class */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    private static final long HASH_MASK = -4294967296L;
    static final int DEFAULT_SIZE = 3;
    static final int UNSET = -1;
    private transient int[] table;
    @VisibleForTesting
    transient long[] entries;
    @VisibleForTesting
    transient Object[] keys;
    @VisibleForTesting
    transient Object[] values;
    transient float loadFactor;
    transient int modCount;
    private transient int threshold;
    private transient int size;
    private transient Set<K> keySetView;
    private transient Set<Map.Entry<K, V>> entrySetView;
    private transient Collection<V> valuesView;

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int expectedSize) {
        return new CompactHashMap<>(expectedSize);
    }

    CompactHashMap() {
        init(3, DEFAULT_LOAD_FACTOR);
    }

    CompactHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    /* access modifiers changed from: package-private */
    public CompactHashMap(int expectedSize, float loadFactor) {
        init(expectedSize, loadFactor);
    }

    /* access modifiers changed from: package-private */
    public void init(int expectedSize, float loadFactor) {
        Preconditions.checkArgument(expectedSize >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(loadFactor > 0.0f, "Illegal load factor");
        int buckets = Hashing.closedTableSize(expectedSize, (double) loadFactor);
        this.table = newTable(buckets);
        this.loadFactor = loadFactor;
        this.keys = new Object[expectedSize];
        this.values = new Object[expectedSize];
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

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static int getHash(long entry) {
        return (int) (entry >>> 32);
    }

    private static int getNext(long entry) {
        return (int) entry;
    }

    private static long swapNext(long entry, int newNext) {
        return (HASH_MASK & entry) | (NEXT_MASK & ((long) newNext));
    }

    void accessEntry(int index) {
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K key, V value) {
        long entry;
        long[] entries = this.entries;
        Object[] keys = this.keys;
        Object[] values = this.values;
        int hash = Hashing.smearedHash(key);
        int tableIndex = hash & hashTableMask();
        int newEntryIndex = this.size;
        int next = this.table[tableIndex];
        if (next == -1) {
            this.table[tableIndex] = newEntryIndex;
        } else {
            do {
                entry = entries[next];
                if (getHash(entry) != hash || !Objects.equal(key, keys[next])) {
                    next = getNext(entry);
                } else {
                    V oldValue = (V) values[next];
                    values[next] = value;
                    accessEntry(next);
                    return oldValue;
                }
            } while (next != -1);
            entries[next] = swapNext(entry, newEntryIndex);
        }
        if (newEntryIndex == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int newSize = newEntryIndex + 1;
        resizeMeMaybe(newSize);
        insertEntry(newEntryIndex, key, value, hash);
        this.size = newSize;
        if (newEntryIndex >= this.threshold) {
            resizeTable(2 * this.table.length);
        }
        this.modCount++;
        return null;
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int entryIndex, K key, V value, int hash) {
        this.entries[entryIndex] = (((long) hash) << 32) | NEXT_MASK;
        this.keys[entryIndex] = key;
        this.values[entryIndex] = value;
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
        this.keys = Arrays.copyOf(this.keys, newCapacity);
        this.values = Arrays.copyOf(this.values, newCapacity);
        long[] entries = this.entries;
        int oldCapacity = entries.length;
        long[] entries2 = Arrays.copyOf(entries, newCapacity);
        if (newCapacity > oldCapacity) {
            Arrays.fill(entries2, oldCapacity, newCapacity, -1L);
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

    /* access modifiers changed from: private */
    public int indexOf(Object key) {
        int hash = Hashing.smearedHash(key);
        int next = this.table[hash & hashTableMask()];
        while (next != -1) {
            long entry = this.entries[next];
            if (getHash(entry) == hash && Objects.equal(key, this.keys[next])) {
                return next;
            }
            next = getNext(entry);
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return indexOf(key) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        int index = indexOf(key);
        accessEntry(index);
        if (index == -1) {
            return null;
        }
        return (V) this.values[index];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object key) {
        return remove(key, Hashing.smearedHash(key));
    }

    private V remove(Object key, int hash) {
        int tableIndex = hash & hashTableMask();
        int next = this.table[tableIndex];
        if (next == -1) {
            return null;
        }
        int last = -1;
        do {
            if (getHash(this.entries[next]) != hash || !Objects.equal(key, this.keys[next])) {
                last = next;
                next = getNext(this.entries[next]);
            } else {
                V oldValue = (V) this.values[next];
                if (last == -1) {
                    this.table[tableIndex] = getNext(this.entries[next]);
                } else {
                    this.entries[last] = swapNext(this.entries[last], getNext(this.entries[next]));
                }
                moveLastEntry(next);
                this.size--;
                this.modCount++;
                return oldValue;
            }
        } while (next != -1);
        return null;
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeEntry(int entryIndex) {
        return remove(this.keys[entryIndex], getHash(this.entries[entryIndex]));
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int dstIndex) {
        long entry;
        int srcIndex = size() - 1;
        if (dstIndex < srcIndex) {
            this.keys[dstIndex] = this.keys[srcIndex];
            this.values[dstIndex] = this.values[srcIndex];
            this.keys[srcIndex] = null;
            this.values[srcIndex] = null;
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
        this.keys[dstIndex] = null;
        this.values[dstIndex] = null;
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

    /* loaded from: grasscutter.jar:com/google/common/collect/CompactHashMap$Itr.class */
    private abstract class Itr<T> implements Iterator<T> {
        int expectedModCount;
        int currentIndex;
        int indexToRemove;

        abstract T getOutput(int i);

        private Itr() {
            this.expectedModCount = CompactHashMap.this.modCount;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.indexToRemove = this.currentIndex;
            T result = getOutput(this.currentIndex);
            this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
            return result;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            this.expectedModCount++;
            CompactHashMap.this.removeEntry(this.indexToRemove);
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Preconditions.checkNotNull(function);
        for (int i = 0; i < this.size; i++) {
            this.values[i] = function.apply(this.keys[i], this.values[i]);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        if (this.keySetView != null) {
            return this.keySetView;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    Set<K> createKeySet() {
        return new KeySetView();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/CompactHashMap$KeySetView.class */
    public class KeySetView extends Maps.KeySet<K, V> {
        /* access modifiers changed from: package-private */
        public KeySetView() {
            super(CompactHashMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ObjectArrays.copyAsObjectArray(CompactHashMap.this.keys, 0, CompactHashMap.this.size);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] a) {
            return (T[]) ObjectArrays.toArrayImpl(CompactHashMap.this.keys, 0, CompactHashMap.this.size, a);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            int index = CompactHashMap.this.indexOf(o);
            if (index == -1) {
                return false;
            }
            CompactHashMap.this.removeEntry(index);
            return true;
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public Spliterator<K> spliterator() {
            return Spliterators.spliterator(CompactHashMap.this.keys, 0, CompactHashMap.this.size, 17);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            Preconditions.checkNotNull(action);
            for (int i = 0; i < CompactHashMap.this.size; i++) {
                action.accept(CompactHashMap.this.keys[i]);
            }
        }
    }

    Iterator<K> keySetIterator() {
        return new CompactHashMap<K, V>.Itr() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            K getOutput(int entry) {
                return (K) CompactHashMap.this.keys[entry];
            }
        };
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Preconditions.checkNotNull(action);
        for (int i = 0; i < this.size; i++) {
            action.accept(this.keys[i], this.values[i]);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySetView != null) {
            return this.entrySetView;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/CompactHashMap$EntrySetView.class */
    public class EntrySetView extends Maps.EntrySet<K, V> {
        /* access modifiers changed from: package-private */
        public EntrySetView() {
        }

        @Override // com.google.common.collect.Maps.EntrySet
        Map<K, V> map() {
            return CompactHashMap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return CollectSpliterators.indexed(CompactHashMap.this.size, 17, x$0 -> {
                return new MapEntry(x$0);
            });
        }

        @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            int index = CompactHashMap.this.indexOf(entry.getKey());
            return index != -1 && Objects.equal(CompactHashMap.this.values[index], entry.getValue());
        }

        @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            int index = CompactHashMap.this.indexOf(entry.getKey());
            if (index == -1 || !Objects.equal(CompactHashMap.this.values[index], entry.getValue())) {
                return false;
            }
            CompactHashMap.this.removeEntry(index);
            return true;
        }
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new CompactHashMap<K, V>.Itr() { // from class: com.google.common.collect.CompactHashMap.2
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            public Map.Entry<K, V> getOutput(int entry) {
                return new MapEntry(entry);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/CompactHashMap$MapEntry.class */
    public final class MapEntry extends AbstractMapEntry<K, V> {
        private final K key;
        private int lastKnownIndex;

        MapEntry(int index) {
            this.key = (K) CompactHashMap.this.keys[index];
            this.lastKnownIndex = index;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        private void updateLastKnownIndex() {
            if (this.lastKnownIndex == -1 || this.lastKnownIndex >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[this.lastKnownIndex];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V value) {
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                CompactHashMap.this.put(this.key, value);
                return null;
            }
            V old = (V) CompactHashMap.this.values[this.lastKnownIndex];
            CompactHashMap.this.values[this.lastKnownIndex] = value;
            return old;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equal(value, this.values[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        if (this.valuesView != null) {
            return this.valuesView;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    Collection<V> createValues() {
        return new ValuesView();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/CompactHashMap$ValuesView.class */
    public class ValuesView extends Maps.Values<K, V> {
        /* access modifiers changed from: package-private */
        public ValuesView() {
            super(CompactHashMap.this);
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // com.google.common.collect.Maps.Values, java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            Preconditions.checkNotNull(action);
            for (int i = 0; i < CompactHashMap.this.size; i++) {
                action.accept(CompactHashMap.this.values[i]);
            }
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return Spliterators.spliterator(CompactHashMap.this.values, 0, CompactHashMap.this.size, 16);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ObjectArrays.copyAsObjectArray(CompactHashMap.this.values, 0, CompactHashMap.this.size);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] a) {
            return (T[]) ObjectArrays.toArrayImpl(CompactHashMap.this.values, 0, CompactHashMap.this.size, a);
        }
    }

    Iterator<V> valuesIterator() {
        return new CompactHashMap<K, V>.Itr() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            V getOutput(int entry) {
                return (V) CompactHashMap.this.values[entry];
            }
        };
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

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(this.size);
        for (int i = 0; i < this.size; i++) {
            stream.writeObject(this.keys[i]);
            stream.writeObject(this.values[i]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.CompactHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        init(3, DEFAULT_LOAD_FACTOR);
        int i = stream.readInt();
        while (true) {
            i--;
            if (i >= 0) {
                put(stream.readObject(), stream.readObject());
            } else {
                return;
            }
        }
    }
}
