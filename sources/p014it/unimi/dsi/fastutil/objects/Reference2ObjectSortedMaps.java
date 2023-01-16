package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectSortedMaps.class */
public final class Reference2ObjectSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2ObjectSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K, V> ObjectBidirectionalIterator<Reference2ObjectMap.Entry<K, V>> fastIterator(Reference2ObjectSortedMap<K, V> map) {
        ObjectSortedSet<Reference2ObjectMap.Entry<K, V>> entries = map.reference2ObjectEntrySet();
        return entries instanceof Reference2ObjectSortedMap.FastSortedEntrySet ? ((Reference2ObjectSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K, V> ObjectBidirectionalIterable<Reference2ObjectMap.Entry<K, V>> fastIterable(Reference2ObjectSortedMap<K, V> map) {
        ObjectSortedSet<Reference2ObjectMap.Entry<K, V>> entries = map.reference2ObjectEntrySet();
        if (!(entries instanceof Reference2ObjectSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2ObjectSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2ObjectSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K, V> extends Reference2ObjectMaps.EmptyMap<K, V> implements Reference2ObjectSortedMap<K, V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSortedSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> subMap(K from, K to) {
            return Reference2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> headMap(K to) {
            return Reference2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> tailMap(K from) {
            return Reference2ObjectSortedMaps.EMPTY_MAP;
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

    public static <K, V> Reference2ObjectSortedMap<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectSortedMaps$Singleton.class */
    public static class Singleton<K, V> extends Reference2ObjectMaps.Singleton<K, V> implements Reference2ObjectSortedMap<K, V>, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSortedSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2ObjectMap.BasicEntry(this.key, this.value), Reference2ObjectSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return reference2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2ObjectSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2ObjectSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2ObjectSortedMaps.EMPTY_MAP;
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

    public static <K, V> Reference2ObjectSortedMap<K, V> singleton(K key, V value) {
        return new Singleton(key, value);
    }

    public static <K, V> Reference2ObjectSortedMap<K, V> singleton(K key, V value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K, V> extends Reference2ObjectMaps.SynchronizedMap<K, V> implements Reference2ObjectSortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ObjectSortedMap<K, V> sortedMap;

        protected SynchronizedSortedMap(Reference2ObjectSortedMap<K, V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2ObjectSortedMap<K, V> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSortedSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2ObjectEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return reference2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2ObjectSortedMap<K, V>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2ObjectSortedMap<K, V>) from), this.sync);
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

    public static <K, V> Reference2ObjectSortedMap<K, V> synchronize(Reference2ObjectSortedMap<K, V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K, V> Reference2ObjectSortedMap<K, V> synchronize(Reference2ObjectSortedMap<K, V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K, V> extends Reference2ObjectMaps.UnmodifiableMap<K, V> implements Reference2ObjectSortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ObjectSortedMap<K, ? extends V> sortedMap;

        protected UnmodifiableSortedMap(Reference2ObjectSortedMap<K, ? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSortedSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2ObjectEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return reference2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2ObjectSortedMap<K, ? extends V>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectSortedMap, java.util.SortedMap
        public Reference2ObjectSortedMap<K, V> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2ObjectSortedMap<K, ? extends V>) from));
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

    public static <K, V> Reference2ObjectSortedMap<K, V> unmodifiable(Reference2ObjectSortedMap<K, ? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
