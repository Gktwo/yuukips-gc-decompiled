package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceSortedMaps.class */
public final class Object2ReferenceSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2ReferenceSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K, V> ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> fastIterator(Object2ReferenceSortedMap<K, V> map) {
        ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> entries = map.object2ReferenceEntrySet();
        return entries instanceof Object2ReferenceSortedMap.FastSortedEntrySet ? ((Object2ReferenceSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K, V> ObjectBidirectionalIterable<Object2ReferenceMap.Entry<K, V>> fastIterable(Object2ReferenceSortedMap<K, V> map) {
        ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> entries = map.object2ReferenceEntrySet();
        if (!(entries instanceof Object2ReferenceSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2ReferenceSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2ReferenceSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K, V> extends Object2ReferenceMaps.EmptyMap<K, V> implements Object2ReferenceSortedMap<K, V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap
        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> object2ReferenceEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return Object2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> headMap(K to) {
            return Object2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> tailMap(K from) {
            return Object2ReferenceSortedMaps.EMPTY_MAP;
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

    public static <K, V> Object2ReferenceSortedMap<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceSortedMaps$Singleton.class */
    public static class Singleton<K, V> extends Object2ReferenceMaps.Singleton<K, V> implements Object2ReferenceSortedMap<K, V>, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap
        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> object2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2ReferenceMap.BasicEntry(this.key, this.value), Object2ReferenceSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return object2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2ReferenceSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2ReferenceSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps$Singleton<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2ReferenceSortedMaps.EMPTY_MAP;
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

    public static <K, V> Object2ReferenceSortedMap<K, V> singleton(K key, V value) {
        return new Singleton(key, value);
    }

    public static <K, V> Object2ReferenceSortedMap<K, V> singleton(K key, V value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K, V> extends Object2ReferenceMaps.SynchronizedMap<K, V> implements Object2ReferenceSortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ReferenceSortedMap<K, V> sortedMap;

        protected SynchronizedSortedMap(Object2ReferenceSortedMap<K, V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2ReferenceSortedMap<K, V> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap
        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> object2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2ReferenceEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return object2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2ReferenceSortedMap<K, V>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2ReferenceSortedMap<K, V>) from), this.sync);
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

    public static <K, V> Object2ReferenceSortedMap<K, V> synchronize(Object2ReferenceSortedMap<K, V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K, V> Object2ReferenceSortedMap<K, V> synchronize(Object2ReferenceSortedMap<K, V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K, V> extends Object2ReferenceMaps.UnmodifiableMap<K, V> implements Object2ReferenceSortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ReferenceSortedMap<K, ? extends V> sortedMap;

        protected UnmodifiableSortedMap(Object2ReferenceSortedMap<K, ? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap
        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> object2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2ReferenceEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return object2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2ReferenceSortedMap<K, ? extends V>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2ReferenceSortedMap<K, ? extends V>) from));
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

    public static <K, V> Object2ReferenceSortedMap<K, V> unmodifiable(Object2ReferenceSortedMap<K, ? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
