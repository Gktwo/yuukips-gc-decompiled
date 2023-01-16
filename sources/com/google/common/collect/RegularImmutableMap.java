package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import p001ch.qos.logback.core.joran.action.Action;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableMap.class */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(ImmutableMap.EMPTY_ENTRY_ARRAY, null, 0);
    @VisibleForTesting
    static final double MAX_LOAD_FACTOR = 1.2d;
    @VisibleForTesting
    static final double HASH_FLOODING_FPP = 0.001d;
    @VisibleForTesting
    static final int MAX_HASH_BUCKET_LENGTH = 8;
    @VisibleForTesting
    final transient Map.Entry<K, V>[] entries;
    private final transient ImmutableMapEntry<K, V>[] table;
    private final transient int mask;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableMap<K, V> fromEntries(Map.Entry<K, V>... entries) {
        return fromEntryArray(entries.length, entries);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableMap<K, V> fromEntryArray(int n, Map.Entry<K, V>[] entryArray) {
        Map.Entry<K, V>[] entries;
        Preconditions.checkPositionIndex(n, entryArray.length);
        if (n == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (n == entryArray.length) {
            entries = entryArray;
        } else {
            entries = ImmutableMapEntry.createEntryArray(n);
        }
        int tableSize = Hashing.closedTableSize(n, MAX_LOAD_FACTOR);
        ImmutableMapEntry<K, V>[] table = ImmutableMapEntry.createEntryArray(tableSize);
        int mask = tableSize - 1;
        for (int entryIndex = 0; entryIndex < n; entryIndex++) {
            Map.Entry<K, V> entry = entryArray[entryIndex];
            K key = entry.getKey();
            V value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            int tableIndex = Hashing.smear(key.hashCode()) & mask;
            ImmutableMapEntry<K, V> existing = table[tableIndex];
            ImmutableMapEntry<K, V> newEntry = existing == null ? makeImmutable(entry, key, value) : new ImmutableMapEntry.NonTerminalImmutableMapEntry<>(key, value, existing);
            table[tableIndex] = newEntry;
            entries[entryIndex] = newEntry;
            if (checkNoConflictInKeyBucket(key, newEntry, existing) > 8) {
                return JdkBackedImmutableMap.create(n, entryArray);
            }
        }
        return new RegularImmutableMap(entries, table, mask);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> entry, K key, V value) {
        return (entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).isReusable() ? (ImmutableMapEntry) entry : new ImmutableMapEntry<>(key, value);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> entry) {
        return makeImmutable(entry, entry.getKey(), entry.getValue());
    }

    private RegularImmutableMap(Map.Entry<K, V>[] entries, ImmutableMapEntry<K, V>[] table, int mask) {
        this.entries = entries;
        this.table = table;
        this.mask = mask;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int checkNoConflictInKeyBucket(Object key, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> keyBucketHead) {
        int bucketSize = 0;
        while (keyBucketHead != null) {
            checkNoConflict(!key.equals(keyBucketHead.getKey()), Action.KEY_ATTRIBUTE, entry, keyBucketHead);
            bucketSize++;
            keyBucketHead = keyBucketHead.getNextInKeyBucket();
        }
        return bucketSize;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object key) {
        return (V) get(key, this.table, this.mask);
    }

    /* access modifiers changed from: package-private */
    public static <V> V get(Object key, ImmutableMapEntry<?, V>[] keyTable, int mask) {
        if (key == null || keyTable == null) {
            return null;
        }
        for (ImmutableMapEntry<?, V> entry = keyTable[Hashing.smear(key.hashCode()) & mask]; entry != null; entry = entry.getNextInKeyBucket()) {
            if (key.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
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

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this);
    }

    @GwtCompatible(emulated = true)
    /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableMap$KeySet.class */
    private static final class KeySet<K, V> extends IndexedImmutableSet<K> {
        private final RegularImmutableMap<K, V> map;

        KeySet(RegularImmutableMap<K, V> map) {
            this.map = map;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        K get(int index) {
            return this.map.entries[index].getKey();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object object) {
            return this.map.containsKey(object);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new SerializedForm(this.map);
        }

        @GwtIncompatible
        /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableMap$KeySet$SerializedForm.class */
        private static class SerializedForm<K> implements Serializable {
            final ImmutableMap<K, ?> map;
            private static final long serialVersionUID = 0;

            SerializedForm(ImmutableMap<K, ?> map) {
                this.map = map;
            }

            Object readResolve() {
                return this.map.keySet();
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @GwtCompatible(emulated = true)
    /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableMap$Values.class */
    private static final class Values<K, V> extends ImmutableList<V> {
        final RegularImmutableMap<K, V> map;

        Values(RegularImmutableMap<K, V> map) {
            this.map = map;
        }

        @Override // java.util.List
        public V get(int index) {
            return this.map.entries[index].getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.map.size();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new SerializedForm(this.map);
        }

        @GwtIncompatible
        /* loaded from: grasscutter.jar:com/google/common/collect/RegularImmutableMap$Values$SerializedForm.class */
        private static class SerializedForm<V> implements Serializable {
            final ImmutableMap<?, V> map;
            private static final long serialVersionUID = 0;

            SerializedForm(ImmutableMap<?, V> map) {
                this.map = map;
            }

            Object readResolve() {
                return this.map.values();
            }
        }
    }
}
