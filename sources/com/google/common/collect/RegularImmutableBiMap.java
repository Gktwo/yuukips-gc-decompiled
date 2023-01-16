package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableBiMap.class */
public class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    static final double MAX_LOAD_FACTOR = 1.2d;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    private final transient ImmutableMapEntry<K, V>[] valueTable;
    @VisibleForTesting
    final transient Map.Entry<K, V>[] entries;
    private final transient int mask;
    private final transient int hashCode;
    @RetainedWith
    @LazyInit
    private transient ImmutableBiMap<V, K> inverse;

    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... entries) {
        return fromEntryArray(entries.length, entries);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableBiMap<K, V> fromEntryArray(int n, Map.Entry<K, V>[] entryArray) {
        Map.Entry<K, V>[] entries;
        Preconditions.checkPositionIndex(n, entryArray.length);
        int tableSize = Hashing.closedTableSize(n, MAX_LOAD_FACTOR);
        int mask = tableSize - 1;
        ImmutableMapEntry<K, V>[] keyTable = ImmutableMapEntry.createEntryArray(tableSize);
        ImmutableMapEntry<K, V>[] valueTable = ImmutableMapEntry.createEntryArray(tableSize);
        if (n == entryArray.length) {
            entries = entryArray;
        } else {
            entries = ImmutableMapEntry.createEntryArray(n);
        }
        int hashCode = 0;
        for (int i = 0; i < n; i++) {
            Map.Entry<K, V> entry = entryArray[i];
            K key = entry.getKey();
            V value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            int keyHash = key.hashCode();
            int valueHash = value.hashCode();
            int keyBucket = Hashing.smear(keyHash) & mask;
            int valueBucket = Hashing.smear(valueHash) & mask;
            ImmutableMapEntry<K, V> nextInKeyBucket = keyTable[keyBucket];
            int keyBucketLength = RegularImmutableMap.checkNoConflictInKeyBucket(key, entry, nextInKeyBucket);
            ImmutableMapEntry<K, V> nextInValueBucket = valueTable[valueBucket];
            int valueBucketLength = checkNoConflictInValueBucket(value, entry, nextInValueBucket);
            if (keyBucketLength > 8 || valueBucketLength > 8) {
                return JdkBackedImmutableBiMap.create(n, entryArray);
            }
            ImmutableMapEntry<K, V> newEntry = (nextInValueBucket == null && nextInKeyBucket == null) ? RegularImmutableMap.makeImmutable(entry, key, value) : new ImmutableMapEntry.NonTerminalImmutableBiMapEntry<>(key, value, nextInKeyBucket, nextInValueBucket);
            keyTable[keyBucket] = newEntry;
            valueTable[valueBucket] = newEntry;
            entries[i] = newEntry;
            hashCode += keyHash ^ valueHash;
        }
        return new RegularImmutableBiMap(keyTable, valueTable, entries, mask, hashCode);
    }

    private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] keyTable, ImmutableMapEntry<K, V>[] valueTable, Map.Entry<K, V>[] entries, int mask, int hashCode) {
        this.keyTable = keyTable;
        this.valueTable = valueTable;
        this.entries = entries;
        this.mask = mask;
        this.hashCode = hashCode;
    }

    @CanIgnoreReturnValue
    private static int checkNoConflictInValueBucket(Object value, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> valueBucketHead) {
        int bucketSize = 0;
        while (valueBucketHead != null) {
            checkNoConflict(!value.equals(valueBucketHead.getValue()), "value", entry, valueBucketHead);
            bucketSize++;
            valueBucketHead = valueBucketHead.getNextInValueBucket();
        }
        return bucketSize;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object key) {
        if (this.keyTable == null) {
            return null;
        }
        return (V) RegularImmutableMap.get(key, this.keyTable, this.mask);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.m1396of() : new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: K, ? super K */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: V, ? super V */
    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Preconditions.checkNotNull(action);
        Map.Entry<K, V>[] entryArr = this.entries;
        for (Map.Entry<K, V> entry : entryArr) {
            action.accept((K) entry.getKey(), (V) entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.lang.Object
    public int hashCode() {
        return this.hashCode;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        if (isEmpty()) {
            return ImmutableBiMap.m1446of();
        }
        ImmutableBiMap<V, K> result = this.inverse;
        if (result != null) {
            return result;
        }
        Inverse inverse = new Inverse();
        this.inverse = inverse;
        return inverse;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableBiMap$Inverse.class */
    public final class Inverse extends ImmutableBiMap<V, K> {
        private Inverse() {
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
        public ImmutableBiMap<K, V> inverse() {
            return RegularImmutableBiMap.this;
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super V, ? super K> action) {
            Preconditions.checkNotNull(action);
            RegularImmutableBiMap.this.forEach(k, v -> {
                action.accept(v, k);
            });
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object value) {
            if (value == null || RegularImmutableBiMap.this.valueTable == null) {
                return null;
            }
            for (ImmutableMapEntry<K, V> entry = RegularImmutableBiMap.this.valueTable[Hashing.smear(value.hashCode()) & RegularImmutableBiMap.this.mask]; entry != null; entry = entry.getNextInValueBucket()) {
                if (value.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<V> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        /* access modifiers changed from: package-private */
        /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableBiMap$Inverse$InverseEntrySet.class */
        public final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            InverseEntrySet() {
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            ImmutableMap<V, K> map() {
                return Inverse.this;
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet
            boolean isHashCodeFast() {
                return true;
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }

            /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.google.common.collect.UnmodifiableIterator<java.util.Map$Entry<K, V>>, com.google.common.collect.UnmodifiableIterator<java.util.Map$Entry<V, K>> */
            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
            public UnmodifiableIterator<Map.Entry<V, K>> iterator() {
                return (UnmodifiableIterator<Map.Entry<K, V>>) asList().iterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<V, K>> action) {
                asList().forEach(action);
            }

            @Override // com.google.common.collect.ImmutableSet
            ImmutableList<Map.Entry<V, K>> createAsList() {
                return new ImmutableAsList<Map.Entry<V, K>>() { // from class: com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.1
                    @Override // java.util.List
                    public Map.Entry<V, K> get(int index) {
                        Map.Entry<K, V> entry = RegularImmutableBiMap.this.entries[index];
                        return Maps.immutableEntry(entry.getValue(), entry.getKey());
                    }

                    @Override // com.google.common.collect.ImmutableAsList
                    ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }
                };
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableBiMap$InverseSerializedForm.class */
    private static class InverseSerializedForm<K, V> implements Serializable {
        private final ImmutableBiMap<K, V> forward;
        private static final long serialVersionUID = 1;

        InverseSerializedForm(ImmutableBiMap<K, V> forward) {
            this.forward = forward;
        }

        Object readResolve() {
            return this.forward.inverse();
        }
    }
}
