package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2ShortMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortSortedMaps.class */
public final class Reference2ShortSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2ShortSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Reference2ShortMap.Entry<K>> fastIterator(Reference2ShortSortedMap<K> map) {
        ObjectSortedSet<Reference2ShortMap.Entry<K>> entries = map.reference2ShortEntrySet();
        return entries instanceof Reference2ShortSortedMap.FastSortedEntrySet ? ((Reference2ShortSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Reference2ShortMap.Entry<K>> fastIterable(Reference2ShortSortedMap<K> map) {
        ObjectSortedSet<Reference2ShortMap.Entry<K>> entries = map.reference2ShortEntrySet();
        if (!(entries instanceof Reference2ShortSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2ShortSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2ShortSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Reference2ShortMaps.EmptyMap<K> implements Reference2ShortSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap
        public ObjectSortedSet<Reference2ShortMap.Entry<K>> reference2ShortEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> subMap(K from, K to) {
            return Reference2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> headMap(K to) {
            return Reference2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> tailMap(K from) {
            return Reference2ShortSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2ShortSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortSortedMaps$Singleton.class */
    public static class Singleton<K> extends Reference2ShortMaps.Singleton<K> implements Reference2ShortSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, short value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, short value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap
        public ObjectSortedSet<Reference2ShortMap.Entry<K>> reference2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2ShortMap.BasicEntry(this.key, this.value), Reference2ShortSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return reference2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2ShortSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2ShortSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2ShortSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2ShortSortedMap<K> singleton(K key, Short value) {
        return new Singleton(key, value.shortValue());
    }

    public static <K> Reference2ShortSortedMap<K> singleton(K key, Short value, Comparator<? super K> comparator) {
        return new Singleton(key, value.shortValue(), comparator);
    }

    public static <K> Reference2ShortSortedMap<K> singleton(K key, short value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2ShortSortedMap<K> singleton(K key, short value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Reference2ShortMaps.SynchronizedMap<K> implements Reference2ShortSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ShortSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Reference2ShortSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2ShortSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap
        public ObjectSortedSet<Reference2ShortMap.Entry<K>> reference2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2ShortEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return reference2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2ShortSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2ShortSortedMap<K>) from), this.sync);
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

    public static <K> Reference2ShortSortedMap<K> synchronize(Reference2ShortSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Reference2ShortSortedMap<K> synchronize(Reference2ShortSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Reference2ShortMaps.UnmodifiableMap<K> implements Reference2ShortSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ShortSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Reference2ShortSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap
        public ObjectSortedSet<Reference2ShortMap.Entry<K>> reference2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2ShortEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return reference2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2ShortMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2ShortSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortSortedMap, java.util.SortedMap
        public Reference2ShortSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2ShortSortedMap<K>) from));
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

    public static <K> Reference2ShortSortedMap<K> unmodifiable(Reference2ShortSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
