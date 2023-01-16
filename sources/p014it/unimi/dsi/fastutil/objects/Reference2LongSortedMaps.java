package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2LongMap;
import p014it.unimi.dsi.fastutil.objects.Reference2LongMap;
import p014it.unimi.dsi.fastutil.objects.Reference2LongMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongSortedMaps.class */
public final class Reference2LongSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2LongSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Reference2LongMap.Entry<K>> fastIterator(Reference2LongSortedMap<K> map) {
        ObjectSortedSet<Reference2LongMap.Entry<K>> entries = map.reference2LongEntrySet();
        return entries instanceof Reference2LongSortedMap.FastSortedEntrySet ? ((Reference2LongSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Reference2LongMap.Entry<K>> fastIterable(Reference2LongSortedMap<K> map) {
        ObjectSortedSet<Reference2LongMap.Entry<K>> entries = map.reference2LongEntrySet();
        if (!(entries instanceof Reference2LongSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2LongSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2LongSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Reference2LongMaps.EmptyMap<K> implements Reference2LongSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap
        public ObjectSortedSet<Reference2LongMap.Entry<K>> reference2LongEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> subMap(K from, K to) {
            return Reference2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> headMap(K to) {
            return Reference2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> tailMap(K from) {
            return Reference2LongSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2LongSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongSortedMaps$Singleton.class */
    public static class Singleton<K> extends Reference2LongMaps.Singleton<K> implements Reference2LongSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, long value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, long value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2LongMap
        public ObjectSortedSet<Reference2LongMap.Entry<K>> reference2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2LongMap.BasicEntry(this.key, this.value), Reference2LongSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return reference2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2LongSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2LongSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2LongSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2LongSortedMap<K> singleton(K key, Long value) {
        return new Singleton(key, value.longValue());
    }

    public static <K> Reference2LongSortedMap<K> singleton(K key, Long value, Comparator<? super K> comparator) {
        return new Singleton(key, value.longValue(), comparator);
    }

    public static <K> Reference2LongSortedMap<K> singleton(K key, long value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2LongSortedMap<K> singleton(K key, long value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Reference2LongMaps.SynchronizedMap<K> implements Reference2LongSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2LongSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Reference2LongSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2LongSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap
        public ObjectSortedSet<Reference2LongMap.Entry<K>> reference2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2LongEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return reference2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2LongSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2LongSortedMap<K>) from), this.sync);
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

    public static <K> Reference2LongSortedMap<K> synchronize(Reference2LongSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Reference2LongSortedMap<K> synchronize(Reference2LongSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Reference2LongMaps.UnmodifiableMap<K> implements Reference2LongSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2LongSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Reference2LongSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap
        public ObjectSortedSet<Reference2LongMap.Entry<K>> reference2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2LongEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return reference2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2LongMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2LongSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongSortedMap, java.util.SortedMap
        public Reference2LongSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2LongSortedMap<K>) from));
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

    public static <K> Reference2LongSortedMap<K> unmodifiable(Reference2LongSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
