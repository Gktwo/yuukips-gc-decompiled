package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleSortedMaps.class */
public final class Object2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2DoubleSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Object2DoubleMap.Entry<K>> fastIterator(Object2DoubleSortedMap<K> map) {
        ObjectSortedSet<Object2DoubleMap.Entry<K>> entries = map.object2DoubleEntrySet();
        return entries instanceof Object2DoubleSortedMap.FastSortedEntrySet ? ((Object2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Object2DoubleMap.Entry<K>> fastIterable(Object2DoubleSortedMap<K> map) {
        ObjectSortedSet<Object2DoubleMap.Entry<K>> entries = map.object2DoubleEntrySet();
        if (!(entries instanceof Object2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Object2DoubleMaps.EmptyMap<K> implements Object2DoubleSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap
        public ObjectSortedSet<Object2DoubleMap.Entry<K>> object2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> subMap(K from, K to) {
            return Object2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> headMap(K to) {
            return Object2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> tailMap(K from) {
            return Object2DoubleSortedMaps.EMPTY_MAP;
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

    public static <K> Object2DoubleSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleSortedMaps$Singleton.class */
    public static class Singleton<K> extends Object2DoubleMaps.Singleton<K> implements Object2DoubleSortedMap<K>, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap
        public ObjectSortedSet<Object2DoubleMap.Entry<K>> object2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2DoubleMap.BasicEntry(this.key, this.value), Object2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return object2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2DoubleSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2DoubleSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2DoubleSortedMaps.EMPTY_MAP;
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

    public static <K> Object2DoubleSortedMap<K> singleton(K key, Double value) {
        return new Singleton(key, value.doubleValue());
    }

    public static <K> Object2DoubleSortedMap<K> singleton(K key, Double value, Comparator<? super K> comparator) {
        return new Singleton(key, value.doubleValue(), comparator);
    }

    public static <K> Object2DoubleSortedMap<K> singleton(K key, double value) {
        return new Singleton(key, value);
    }

    public static <K> Object2DoubleSortedMap<K> singleton(K key, double value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Object2DoubleMaps.SynchronizedMap<K> implements Object2DoubleSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2DoubleSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Object2DoubleSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2DoubleSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap
        public ObjectSortedSet<Object2DoubleMap.Entry<K>> object2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return object2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2DoubleSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2DoubleSortedMap<K>) from), this.sync);
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

    public static <K> Object2DoubleSortedMap<K> synchronize(Object2DoubleSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Object2DoubleSortedMap<K> synchronize(Object2DoubleSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Object2DoubleMaps.UnmodifiableMap<K> implements Object2DoubleSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2DoubleSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Object2DoubleSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap
        public ObjectSortedSet<Object2DoubleMap.Entry<K>> object2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Double>> entrySet() {
            return object2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2DoubleMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2DoubleSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap, java.util.SortedMap
        public Object2DoubleSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2DoubleSortedMap<K>) from));
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

    public static <K> Object2DoubleSortedMap<K> unmodifiable(Object2DoubleSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
