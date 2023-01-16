package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2IntMap;
import p014it.unimi.dsi.fastutil.objects.Reference2IntMap;
import p014it.unimi.dsi.fastutil.objects.Reference2IntMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntSortedMaps.class */
public final class Reference2IntSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2IntSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Reference2IntMap.Entry<K>> fastIterator(Reference2IntSortedMap<K> map) {
        ObjectSortedSet<Reference2IntMap.Entry<K>> entries = map.reference2IntEntrySet();
        return entries instanceof Reference2IntSortedMap.FastSortedEntrySet ? ((Reference2IntSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Reference2IntMap.Entry<K>> fastIterable(Reference2IntSortedMap<K> map) {
        ObjectSortedSet<Reference2IntMap.Entry<K>> entries = map.reference2IntEntrySet();
        if (!(entries instanceof Reference2IntSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2IntSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2IntSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Reference2IntMaps.EmptyMap<K> implements Reference2IntSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap
        public ObjectSortedSet<Reference2IntMap.Entry<K>> reference2IntEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> subMap(K from, K to) {
            return Reference2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> headMap(K to) {
            return Reference2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> tailMap(K from) {
            return Reference2IntSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2IntSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntSortedMaps$Singleton.class */
    public static class Singleton<K> extends Reference2IntMaps.Singleton<K> implements Reference2IntSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, int value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, int value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2IntMap
        public ObjectSortedSet<Reference2IntMap.Entry<K>> reference2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2IntMap.BasicEntry(this.key, this.value), Reference2IntSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
            return reference2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2IntSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2IntSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2IntSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2IntSortedMap<K> singleton(K key, Integer value) {
        return new Singleton(key, value.intValue());
    }

    public static <K> Reference2IntSortedMap<K> singleton(K key, Integer value, Comparator<? super K> comparator) {
        return new Singleton(key, value.intValue(), comparator);
    }

    public static <K> Reference2IntSortedMap<K> singleton(K key, int value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2IntSortedMap<K> singleton(K key, int value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Reference2IntMaps.SynchronizedMap<K> implements Reference2IntSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2IntSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Reference2IntSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2IntSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap
        public ObjectSortedSet<Reference2IntMap.Entry<K>> reference2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2IntEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
            return reference2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2IntSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2IntSortedMap<K>) from), this.sync);
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

    public static <K> Reference2IntSortedMap<K> synchronize(Reference2IntSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Reference2IntSortedMap<K> synchronize(Reference2IntSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Reference2IntMaps.UnmodifiableMap<K> implements Reference2IntSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2IntSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Reference2IntSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap
        public ObjectSortedSet<Reference2IntMap.Entry<K>> reference2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2IntEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
            return reference2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2IntMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2IntSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntSortedMap, java.util.SortedMap
        public Reference2IntSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2IntSortedMap<K>) from));
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

    public static <K> Reference2IntSortedMap<K> unmodifiable(Reference2IntSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
