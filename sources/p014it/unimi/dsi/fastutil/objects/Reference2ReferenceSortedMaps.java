package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceSortedMaps.class */
public final class Reference2ReferenceSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2ReferenceSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K, V> ObjectBidirectionalIterator<Reference2ReferenceMap.Entry<K, V>> fastIterator(Reference2ReferenceSortedMap<K, V> map) {
        ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>> entries = map.reference2ReferenceEntrySet();
        return entries instanceof Reference2ReferenceSortedMap.FastSortedEntrySet ? ((Reference2ReferenceSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K, V> ObjectBidirectionalIterable<Reference2ReferenceMap.Entry<K, V>> fastIterable(Reference2ReferenceSortedMap<K, V> map) {
        ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>> entries = map.reference2ReferenceEntrySet();
        if (!(entries instanceof Reference2ReferenceSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2ReferenceSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2ReferenceSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K, V> extends Reference2ReferenceMaps.EmptyMap<K, V> implements Reference2ReferenceSortedMap<K, V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
        public ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>> reference2ReferenceEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return Reference2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> headMap(K to) {
            return Reference2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> tailMap(K from) {
            return Reference2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> Reference2ReferenceSortedMap<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceSortedMaps$Singleton.class */
    public static class Singleton<K, V> extends Reference2ReferenceMaps.Singleton<K, V> implements Reference2ReferenceSortedMap<K, V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, V value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, V value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
        public ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>> reference2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2ReferenceMap.BasicEntry(this.key, this.value), Reference2ReferenceSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return reference2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2ReferenceSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2ReferenceSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return (K) this.key;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return (K) this.key;
        }
    }

    public static <K, V> Reference2ReferenceSortedMap<K, V> singleton(K key, V value) {
        return new Singleton(key, value);
    }

    public static <K, V> Reference2ReferenceSortedMap<K, V> singleton(K key, V value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K, V> extends Reference2ReferenceMaps.SynchronizedMap<K, V> implements Reference2ReferenceSortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ReferenceSortedMap<K, V> sortedMap;

        protected SynchronizedSortedMap(Reference2ReferenceSortedMap<K, V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2ReferenceSortedMap<K, V> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
        public ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>> reference2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2ReferenceEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return reference2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2ReferenceSortedMap<K, V>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2ReferenceSortedMap<K, V>) from), this.sync);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }
    }

    public static <K, V> Reference2ReferenceSortedMap<K, V> synchronize(Reference2ReferenceSortedMap<K, V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K, V> Reference2ReferenceSortedMap<K, V> synchronize(Reference2ReferenceSortedMap<K, V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K, V> extends Reference2ReferenceMaps.UnmodifiableMap<K, V> implements Reference2ReferenceSortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ReferenceSortedMap<K, ? extends V> sortedMap;

        protected UnmodifiableSortedMap(Reference2ReferenceSortedMap<K, ? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap
        public ObjectSortedSet<Reference2ReferenceMap.Entry<K, V>> reference2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2ReferenceEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return reference2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2ReferenceSortedMap<K, ? extends V>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceSortedMap, java.util.SortedMap
        public Reference2ReferenceSortedMap<K, V> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2ReferenceSortedMap<K, ? extends V>) from));
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return this.sortedMap.lastKey();
        }
    }

    public static <K, V> Reference2ReferenceSortedMap<K, V> unmodifiable(Reference2ReferenceSortedMap<K, ? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
