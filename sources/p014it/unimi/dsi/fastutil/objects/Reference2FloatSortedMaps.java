package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2FloatMap;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatMap;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatSortedMaps.class */
public final class Reference2FloatSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2FloatSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Reference2FloatMap.Entry<K>> fastIterator(Reference2FloatSortedMap<K> map) {
        ObjectSortedSet<Reference2FloatMap.Entry<K>> entries = map.reference2FloatEntrySet();
        return entries instanceof Reference2FloatSortedMap.FastSortedEntrySet ? ((Reference2FloatSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Reference2FloatMap.Entry<K>> fastIterable(Reference2FloatSortedMap<K> map) {
        ObjectSortedSet<Reference2FloatMap.Entry<K>> entries = map.reference2FloatEntrySet();
        if (!(entries instanceof Reference2FloatSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2FloatSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2FloatSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Reference2FloatMaps.EmptyMap<K> implements Reference2FloatSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSortedSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> subMap(K from, K to) {
            return Reference2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> headMap(K to) {
            return Reference2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> tailMap(K from) {
            return Reference2FloatSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2FloatSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatSortedMaps$Singleton.class */
    public static class Singleton<K> extends Reference2FloatMaps.Singleton<K> implements Reference2FloatSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, float value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, float value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSortedSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2FloatMap.BasicEntry(this.key, this.value), Reference2FloatSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return reference2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2FloatSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2FloatSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2FloatSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2FloatSortedMap<K> singleton(K key, Float value) {
        return new Singleton(key, value.floatValue());
    }

    public static <K> Reference2FloatSortedMap<K> singleton(K key, Float value, Comparator<? super K> comparator) {
        return new Singleton(key, value.floatValue(), comparator);
    }

    public static <K> Reference2FloatSortedMap<K> singleton(K key, float value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2FloatSortedMap<K> singleton(K key, float value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Reference2FloatMaps.SynchronizedMap<K> implements Reference2FloatSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2FloatSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Reference2FloatSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2FloatSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSortedSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2FloatEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return reference2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2FloatSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2FloatSortedMap<K>) from), this.sync);
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

    public static <K> Reference2FloatSortedMap<K> synchronize(Reference2FloatSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Reference2FloatSortedMap<K> synchronize(Reference2FloatSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Reference2FloatMaps.UnmodifiableMap<K> implements Reference2FloatSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2FloatSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Reference2FloatSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSortedSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2FloatEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return reference2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2FloatSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatSortedMap, java.util.SortedMap
        public Reference2FloatSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2FloatSortedMap<K>) from));
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

    public static <K> Reference2FloatSortedMap<K> unmodifiable(Reference2FloatSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
