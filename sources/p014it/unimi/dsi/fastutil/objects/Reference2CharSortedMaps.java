package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2CharMap;
import p014it.unimi.dsi.fastutil.objects.Reference2CharMap;
import p014it.unimi.dsi.fastutil.objects.Reference2CharMaps;
import p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharSortedMaps.class */
public final class Reference2CharSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Reference2CharSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Reference2CharMap.Entry<K>> fastIterator(Reference2CharSortedMap<K> map) {
        ObjectSortedSet<Reference2CharMap.Entry<K>> entries = map.reference2CharEntrySet();
        return entries instanceof Reference2CharSortedMap.FastSortedEntrySet ? ((Reference2CharSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Reference2CharMap.Entry<K>> fastIterable(Reference2CharSortedMap<K> map) {
        ObjectSortedSet<Reference2CharMap.Entry<K>> entries = map.reference2CharEntrySet();
        if (!(entries instanceof Reference2CharSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Reference2CharSortedMap.FastSortedEntrySet fastSortedEntrySet = (Reference2CharSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Reference2CharMaps.EmptyMap<K> implements Reference2CharSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap
        public ObjectSortedSet<Reference2CharMap.Entry<K>> reference2CharEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            return ReferenceSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> subMap(K from, K to) {
            return Reference2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> headMap(K to) {
            return Reference2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> tailMap(K from) {
            return Reference2CharSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2CharSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharSortedMaps$Singleton.class */
    public static class Singleton<K> extends Reference2CharMaps.Singleton<K> implements Reference2CharSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, char value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, char value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2CharMap
        public ObjectSortedSet<Reference2CharMap.Entry<K>> reference2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractReference2CharMap.BasicEntry(this.key, this.value), Reference2CharSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return reference2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.singleton(this.key, this.comparator);
            }
            return (ReferenceSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Reference2CharSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Reference2CharSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Reference2CharSortedMaps.EMPTY_MAP;
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

    public static <K> Reference2CharSortedMap<K> singleton(K key, Character value) {
        return new Singleton(key, value.charValue());
    }

    public static <K> Reference2CharSortedMap<K> singleton(K key, Character value, Comparator<? super K> comparator) {
        return new Singleton(key, value.charValue(), comparator);
    }

    public static <K> Reference2CharSortedMap<K> singleton(K key, char value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2CharSortedMap<K> singleton(K key, char value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Reference2CharMaps.SynchronizedMap<K> implements Reference2CharSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2CharSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Reference2CharSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Reference2CharSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap
        public ObjectSortedSet<Reference2CharMap.Entry<K>> reference2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.reference2CharEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return reference2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Reference2CharSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Reference2CharSortedMap<K>) from), this.sync);
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

    public static <K> Reference2CharSortedMap<K> synchronize(Reference2CharSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Reference2CharSortedMap<K> synchronize(Reference2CharSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Reference2CharMaps.UnmodifiableMap<K> implements Reference2CharSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2CharSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Reference2CharSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap
        public ObjectSortedSet<Reference2CharMap.Entry<K>> reference2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.reference2CharEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return reference2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Reference2CharMap, java.util.Map
        public ReferenceSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ReferenceSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Reference2CharSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharSortedMap, java.util.SortedMap
        public Reference2CharSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Reference2CharSortedMap<K>) from));
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

    public static <K> Reference2CharSortedMap<K> unmodifiable(Reference2CharSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
