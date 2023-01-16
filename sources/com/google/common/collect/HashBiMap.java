package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap.class */
public final class HashBiMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient BiEntry<K, V> firstInKeyInsertionOrder;
    private transient BiEntry<K, V> lastInKeyInsertionOrder;
    private transient int size;
    private transient int mask;
    private transient int modCount;
    @RetainedWith
    private transient BiMap<V, K> inverse;
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int expectedSize) {
        return new HashBiMap<>(expectedSize);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> bimap = create(map.size());
        bimap.putAll(map);
        return bimap;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$BiEntry.class */
    public static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        final int valueHash;
        BiEntry<K, V> nextInKToVBucket;
        BiEntry<K, V> nextInVToKBucket;
        BiEntry<K, V> nextInKeyInsertionOrder;
        BiEntry<K, V> prevInKeyInsertionOrder;

        BiEntry(K key, int keyHash, V value, int valueHash) {
            super(key, value);
            this.keyHash = keyHash;
            this.valueHash = valueHash;
        }
    }

    private HashBiMap(int expectedSize) {
        init(expectedSize);
    }

    private void init(int expectedSize) {
        CollectPreconditions.checkNonnegative(expectedSize, "expectedSize");
        int tableSize = Hashing.closedTableSize(expectedSize, 1.0d);
        this.hashTableKToV = createTable(tableSize);
        this.hashTableVToK = createTable(tableSize);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = tableSize - 1;
        this.modCount = 0;
    }

    /* access modifiers changed from: private */
    public void delete(BiEntry<K, V> entry) {
        int keyBucket = entry.keyHash & this.mask;
        BiEntry<K, V> prevBucketEntry = null;
        for (BiEntry<K, V> bucketEntry = this.hashTableKToV[keyBucket]; bucketEntry != entry; bucketEntry = bucketEntry.nextInKToVBucket) {
            prevBucketEntry = bucketEntry;
        }
        if (prevBucketEntry == null) {
            this.hashTableKToV[keyBucket] = entry.nextInKToVBucket;
        } else {
            prevBucketEntry.nextInKToVBucket = entry.nextInKToVBucket;
        }
        int valueBucket = entry.valueHash & this.mask;
        BiEntry<K, V> prevBucketEntry2 = null;
        for (BiEntry<K, V> bucketEntry2 = this.hashTableVToK[valueBucket]; bucketEntry2 != entry; bucketEntry2 = bucketEntry2.nextInVToKBucket) {
            prevBucketEntry2 = bucketEntry2;
        }
        if (prevBucketEntry2 == null) {
            this.hashTableVToK[valueBucket] = entry.nextInVToKBucket;
        } else {
            prevBucketEntry2.nextInVToKBucket = entry.nextInVToKBucket;
        }
        if (entry.prevInKeyInsertionOrder == null) {
            this.firstInKeyInsertionOrder = entry.nextInKeyInsertionOrder;
        } else {
            entry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = entry.nextInKeyInsertionOrder;
        }
        if (entry.nextInKeyInsertionOrder == null) {
            this.lastInKeyInsertionOrder = entry.prevInKeyInsertionOrder;
        } else {
            entry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = entry.prevInKeyInsertionOrder;
        }
        this.size--;
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public void insert(BiEntry<K, V> entry, BiEntry<K, V> oldEntryForKey) {
        int keyBucket = entry.keyHash & this.mask;
        entry.nextInKToVBucket = this.hashTableKToV[keyBucket];
        this.hashTableKToV[keyBucket] = entry;
        int valueBucket = entry.valueHash & this.mask;
        entry.nextInVToKBucket = this.hashTableVToK[valueBucket];
        this.hashTableVToK[valueBucket] = entry;
        if (oldEntryForKey == null) {
            entry.prevInKeyInsertionOrder = this.lastInKeyInsertionOrder;
            entry.nextInKeyInsertionOrder = null;
            if (this.lastInKeyInsertionOrder == null) {
                this.firstInKeyInsertionOrder = entry;
            } else {
                this.lastInKeyInsertionOrder.nextInKeyInsertionOrder = entry;
            }
            this.lastInKeyInsertionOrder = entry;
        } else {
            entry.prevInKeyInsertionOrder = oldEntryForKey.prevInKeyInsertionOrder;
            if (entry.prevInKeyInsertionOrder == null) {
                this.firstInKeyInsertionOrder = entry;
            } else {
                entry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = entry;
            }
            entry.nextInKeyInsertionOrder = oldEntryForKey.nextInKeyInsertionOrder;
            if (entry.nextInKeyInsertionOrder == null) {
                this.lastInKeyInsertionOrder = entry;
            } else {
                entry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = entry;
            }
        }
        this.size++;
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public BiEntry<K, V> seekByKey(Object key, int keyHash) {
        for (BiEntry<K, V> entry = this.hashTableKToV[keyHash & this.mask]; entry != null; entry = entry.nextInKToVBucket) {
            if (keyHash == entry.keyHash && Objects.equal(key, entry.key)) {
                return entry;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public BiEntry<K, V> seekByValue(Object value, int valueHash) {
        for (BiEntry<K, V> entry = this.hashTableVToK[valueHash & this.mask]; entry != null; entry = entry.nextInVToKBucket) {
            if (valueHash == entry.valueHash && Objects.equal(value, entry.value)) {
                return entry;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return seekByKey(key, Hashing.smearedHash(key)) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        return seekByValue(value, Hashing.smearedHash(value)) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        return (V) Maps.valueOrNull(seekByKey(key, Hashing.smearedHash(key)));
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(K key, V value) {
        return put(key, value, false);
    }

    private V put(K key, V value, boolean force) {
        int keyHash = Hashing.smearedHash(key);
        int valueHash = Hashing.smearedHash(value);
        BiEntry<K, V> oldEntryForKey = seekByKey(key, keyHash);
        if (oldEntryForKey != null && valueHash == oldEntryForKey.valueHash && Objects.equal(value, oldEntryForKey.value)) {
            return value;
        }
        BiEntry<K, V> oldEntryForValue = seekByValue(value, valueHash);
        if (oldEntryForValue != null) {
            if (force) {
                delete(oldEntryForValue);
            } else {
                throw new IllegalArgumentException("value already present: " + value);
            }
        }
        BiEntry<K, V> newEntry = new BiEntry<>(key, keyHash, value, valueHash);
        if (oldEntryForKey != null) {
            delete(oldEntryForKey);
            insert(newEntry, oldEntryForKey);
            oldEntryForKey.prevInKeyInsertionOrder = null;
            oldEntryForKey.nextInKeyInsertionOrder = null;
            return (V) oldEntryForKey.value;
        }
        insert(newEntry, null);
        rehashIfNecessary();
        return null;
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V forcePut(K key, V value) {
        return put(key, value, true);
    }

    /* access modifiers changed from: private */
    public K putInverse(V value, K key, boolean force) {
        int valueHash = Hashing.smearedHash(value);
        int keyHash = Hashing.smearedHash(key);
        BiEntry<K, V> oldEntryForValue = seekByValue(value, valueHash);
        BiEntry<K, V> oldEntryForKey = seekByKey(key, keyHash);
        if (oldEntryForValue != null && keyHash == oldEntryForValue.keyHash && Objects.equal(key, oldEntryForValue.key)) {
            return key;
        }
        if (oldEntryForKey == null || force) {
            if (oldEntryForValue != null) {
                delete(oldEntryForValue);
            }
            if (oldEntryForKey != null) {
                delete(oldEntryForKey);
            }
            insert(new BiEntry<>(key, keyHash, value, valueHash), oldEntryForKey);
            if (oldEntryForKey != null) {
                oldEntryForKey.prevInKeyInsertionOrder = null;
                oldEntryForKey.nextInKeyInsertionOrder = null;
            }
            if (oldEntryForValue != null) {
                oldEntryForValue.prevInKeyInsertionOrder = null;
                oldEntryForValue.nextInKeyInsertionOrder = null;
            }
            rehashIfNecessary();
            return (K) Maps.keyOrNull(oldEntryForValue);
        }
        throw new IllegalArgumentException("key already present: " + key);
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] oldKToV = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, oldKToV.length, 1.0d)) {
            int newTableSize = oldKToV.length * 2;
            this.hashTableKToV = createTable(newTableSize);
            this.hashTableVToK = createTable(newTableSize);
            this.mask = newTableSize - 1;
            this.size = 0;
            for (BiEntry<K, V> entry = this.firstInKeyInsertionOrder; entry != null; entry = entry.nextInKeyInsertionOrder) {
                insert(entry, entry);
            }
            this.modCount++;
        }
    }

    private BiEntry<K, V>[] createTable(int length) {
        return new BiEntry[length];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object key) {
        BiEntry<K, V> entry = seekByKey(key, Hashing.smearedHash(key));
        if (entry == null) {
            return null;
        }
        delete(entry);
        entry.prevInKeyInsertionOrder = null;
        entry.nextInKeyInsertionOrder = null;
        return (V) entry.value;
    }

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, (Object) null);
        Arrays.fill(this.hashTableVToK, (Object) null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.modCount++;
    }

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$Itr.class */
    abstract class Itr<T> implements Iterator<T> {
        BiEntry<K, V> next;
        BiEntry<K, V> toRemove = null;
        int expectedModCount;
        int remaining;

        abstract T output(BiEntry<K, V> biEntry);

        Itr() {
            this.next = HashBiMap.this.firstInKeyInsertionOrder;
            this.expectedModCount = HashBiMap.this.modCount;
            this.remaining = HashBiMap.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (HashBiMap.this.modCount == this.expectedModCount) {
                return this.next != null && this.remaining > 0;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BiEntry<K, V> entry = this.next;
            this.next = entry.nextInKeyInsertionOrder;
            this.toRemove = entry;
            this.remaining--;
            return output(entry);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (HashBiMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            CollectPreconditions.checkRemove(this.toRemove != null);
            HashBiMap.this.delete(this.toRemove);
            this.expectedModCount = HashBiMap.this.modCount;
            this.toRemove = null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new KeySet();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$KeySet.class */
    private final class KeySet extends Maps.KeySet<K, V> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new HashBiMap<K, V>.Itr() { // from class: com.google.common.collect.HashBiMap.KeySet.1
                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                @Override // com.google.common.collect.HashBiMap.Itr
                K output(BiEntry<K, V> entry) {
                    return (K) entry.key;
                }
            };
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            BiEntry<K, V> entry = HashBiMap.this.seekByKey(o, Hashing.smearedHash(o));
            if (entry == null) {
                return false;
            }
            HashBiMap.this.delete(entry);
            entry.prevInKeyInsertionOrder = null;
            entry.nextInKeyInsertionOrder = null;
            return true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new HashBiMap<K, V>.Itr() { // from class: com.google.common.collect.HashBiMap.1
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.HashBiMap.Itr
            public Map.Entry<K, V> output(BiEntry<K, V> entry) {
                return new MapEntry(entry);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: com.google.common.collect.HashBiMap$1$MapEntry */
            /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$1$MapEntry.class */
            public class MapEntry extends AbstractMapEntry<K, V> {
                BiEntry<K, V> delegate;

                MapEntry(BiEntry<K, V> entry) {
                    this.delegate = entry;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public K getKey() {
                    return (K) this.delegate.key;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V getValue() {
                    return (V) this.delegate.value;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V setValue(V value) {
                    V oldValue = (V) this.delegate.value;
                    int valueHash = Hashing.smearedHash(value);
                    if (valueHash == this.delegate.valueHash && Objects.equal(value, oldValue)) {
                        return value;
                    }
                    Preconditions.checkArgument(HashBiMap.this.seekByValue(value, valueHash) == null, "value already present: %s", value);
                    HashBiMap.this.delete(this.delegate);
                    BiEntry<K, V> newEntry = new BiEntry<>(this.delegate.key, this.delegate.keyHash, value, valueHash);
                    HashBiMap.this.insert(newEntry, this.delegate);
                    this.delegate.prevInKeyInsertionOrder = null;
                    this.delegate.nextInKeyInsertionOrder = null;
                    C02131.this.expectedModCount = HashBiMap.this.modCount;
                    if (C02131.this.toRemove == this.delegate) {
                        C02131.this.toRemove = newEntry;
                    }
                    this.delegate = newEntry;
                    return oldValue;
                }
            }
        };
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Preconditions.checkNotNull(action);
        for (BiEntry<K, V> entry = this.firstInKeyInsertionOrder; entry != null; entry = entry.nextInKeyInsertionOrder) {
            action.accept((Object) entry.key, (Object) entry.value);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.HashBiMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Preconditions.checkNotNull(function);
        BiEntry<K, V> oldFirst = this.firstInKeyInsertionOrder;
        clear();
        for (BiEntry<K, V> entry = oldFirst; entry != null; entry = entry.nextInKeyInsertionOrder) {
            put(entry.key, function.apply((Object) entry.key, (Object) entry.value));
        }
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> result = this.inverse;
        if (result != null) {
            return result;
        }
        Inverse inverse = new Inverse();
        this.inverse = inverse;
        return inverse;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$Inverse.class */
    public final class Inverse extends Maps.IteratorBasedAbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private Inverse() {
        }

        BiMap<K, V> forward() {
            return HashBiMap.this;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return HashBiMap.this.size;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            forward().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object value) {
            return forward().containsValue(value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object value) {
            return (K) Maps.keyOrNull(HashBiMap.this.seekByValue(value, Hashing.smearedHash(value)));
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        public K put(V value, K key) {
            return (K) HashBiMap.this.putInverse(value, key, false);
        }

        @Override // com.google.common.collect.BiMap
        public K forcePut(V value, K key) {
            return (K) HashBiMap.this.putInverse(value, key, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object value) {
            BiEntry<K, V> entry = HashBiMap.this.seekByValue(value, Hashing.smearedHash(value));
            if (entry == null) {
                return null;
            }
            HashBiMap.this.delete(entry);
            entry.prevInKeyInsertionOrder = null;
            entry.nextInKeyInsertionOrder = null;
            return (K) entry.key;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return forward();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new InverseKeySet();
        }

        /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$Inverse$InverseKeySet.class */
        private final class InverseKeySet extends Maps.KeySet<V, K> {
            InverseKeySet() {
                super(Inverse.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object o) {
                BiEntry<K, V> entry = HashBiMap.this.seekByValue(o, Hashing.smearedHash(o));
                if (entry == null) {
                    return false;
                }
                HashBiMap.this.delete(entry);
                return true;
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<V> iterator() {
                return new HashBiMap<K, V>.Itr() { // from class: com.google.common.collect.HashBiMap.Inverse.InverseKeySet.1
                    {
                        HashBiMap hashBiMap = HashBiMap.this;
                    }

                    @Override // com.google.common.collect.HashBiMap.Itr
                    V output(BiEntry<K, V> entry) {
                        return (V) entry.value;
                    }
                };
            }
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return forward().keySet();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<V, K>> entryIterator() {
            return new HashBiMap<K, V>.Itr() { // from class: com.google.common.collect.HashBiMap.Inverse.1
                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                /* access modifiers changed from: package-private */
                @Override // com.google.common.collect.HashBiMap.Itr
                public Map.Entry<V, K> output(BiEntry<K, V> entry) {
                    return new InverseEntry(entry);
                }

                /* access modifiers changed from: package-private */
                /* renamed from: com.google.common.collect.HashBiMap$Inverse$1$InverseEntry */
                /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$Inverse$1$InverseEntry.class */
                public class InverseEntry extends AbstractMapEntry<V, K> {
                    BiEntry<K, V> delegate;

                    InverseEntry(BiEntry<K, V> entry) {
                        this.delegate = entry;
                    }

                    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                    public V getKey() {
                        return (V) this.delegate.value;
                    }

                    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                    public K getValue() {
                        return (K) this.delegate.key;
                    }

                    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                    public K setValue(K key) {
                        K oldKey = (K) this.delegate.key;
                        int keyHash = Hashing.smearedHash(key);
                        if (keyHash == this.delegate.keyHash && Objects.equal(key, oldKey)) {
                            return key;
                        }
                        Preconditions.checkArgument(HashBiMap.this.seekByKey(key, keyHash) == null, "value already present: %s", key);
                        HashBiMap.this.delete(this.delegate);
                        BiEntry<K, V> newEntry = new BiEntry<>(key, keyHash, this.delegate.value, this.delegate.valueHash);
                        this.delegate = newEntry;
                        HashBiMap.this.insert(newEntry, null);
                        C02141.this.expectedModCount = HashBiMap.this.modCount;
                        return oldKey;
                    }
                }
            };
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super V, ? super K> action) {
            Preconditions.checkNotNull(action);
            HashBiMap.this.forEach(k, v -> {
                action.accept(v, k);
            });
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.HashBiMap$Inverse */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> function) {
            Preconditions.checkNotNull(function);
            BiEntry<K, V> oldFirst = HashBiMap.this.firstInKeyInsertionOrder;
            clear();
            for (BiEntry<K, V> entry = oldFirst; entry != null; entry = entry.nextInKeyInsertionOrder) {
                put(entry.value, function.apply((Object) entry.value, (Object) entry.key));
            }
        }

        Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/HashBiMap$InverseSerializedForm.class */
    private static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> bimap) {
            this.bimap = bimap;
        }

        Object readResolve() {
            return this.bimap.inverse();
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        Serialization.writeMap(this, stream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int size = Serialization.readCount(stream);
        init(16);
        Serialization.populateMap(this, stream, size);
    }
}
