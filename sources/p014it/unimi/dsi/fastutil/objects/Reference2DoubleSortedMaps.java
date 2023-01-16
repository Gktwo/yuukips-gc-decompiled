package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleSortedMaps.class */
public final class Reference2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2DoubleSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Reference2DoubleMap.Entry<K>> fastIterator(Reference2DoubleSortedMap<K> map) {
        ObjectSortedSet<Reference2DoubleMap.Entry<K>> entries = map.reference2DoubleEntrySet();
        return entries instanceof Reference2DoubleSortedMap.FastSortedEntrySet ? ((Reference2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Reference2DoubleMap.Entry<K>> fastIterable(Reference2DoubleSortedMap<K> map) {
        ObjectSortedSet<Reference2DoubleMap.Entry<K>> entries = map.reference2DoubleEntrySet();
        if (!(entries instanceof Reference2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Reference2DoubleMaps.EmptyMap<K> implements Reference2DoubleSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSortedSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> subMap(K from, K to) {
            return Reference2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> headMap(K to) {
            return Reference2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> tailMap(K from) {
            return Reference2DoubleSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2DoubleSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleSortedMaps$Singleton.class */
    public static class Singleton<K> extends Reference2DoubleMaps.Singleton<K> implements Reference2DoubleSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, double value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, double value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSortedSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2DoubleMap.BasicEntry(this.key, this.value), Reference2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return reference2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2DoubleSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2DoubleSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2DoubleSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2DoubleSortedMap<K> singleton(K key, Double value) {
        return new Singleton(key, value.doubleValue());
    }

    public static <K> Reference2DoubleSortedMap<K> singleton(K key, Double value, Comparator<? super K> comparator) {
        return new Singleton(key, value.doubleValue(), comparator);
    }

    public static <K> Reference2DoubleSortedMap<K> singleton(K key, double value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2DoubleSortedMap<K> singleton(K key, double value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Reference2DoubleMaps.SynchronizedMap<K> implements Reference2DoubleSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2DoubleSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Reference2DoubleSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2DoubleSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSortedSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return reference2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2DoubleSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2DoubleSortedMap<K>) from), this.sync);
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

    public static <K> Reference2DoubleSortedMap<K> synchronize(Reference2DoubleSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Reference2DoubleSortedMap<K> synchronize(Reference2DoubleSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Reference2DoubleMaps.UnmodifiableMap<K> implements Reference2DoubleSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2DoubleSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Reference2DoubleSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSortedSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return reference2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2DoubleSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleSortedMap, java.util.SortedMap
        public Reference2DoubleSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2DoubleSortedMap<K>) from));
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

    public static <K> Reference2DoubleSortedMap<K> unmodifiable(Reference2DoubleSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
