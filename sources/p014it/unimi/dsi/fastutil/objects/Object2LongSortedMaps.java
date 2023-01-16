package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap;
import p014it.unimi.dsi.fastutil.objects.Object2LongMap;
import p014it.unimi.dsi.fastutil.objects.Object2LongMaps;
import p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongSortedMaps.class */
public final class Object2LongSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2LongSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Object2LongMap.Entry<K>> fastIterator(Object2LongSortedMap<K> map) {
        ObjectSortedSet<Object2LongMap.Entry<K>> entries = map.object2LongEntrySet();
        return entries instanceof Object2LongSortedMap.FastSortedEntrySet ? ((Object2LongSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Object2LongMap.Entry<K>> fastIterable(Object2LongSortedMap<K> map) {
        ObjectSortedSet<Object2LongMap.Entry<K>> entries = map.object2LongEntrySet();
        if (!(entries instanceof Object2LongSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2LongSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2LongSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Object2LongMaps.EmptyMap<K> implements Object2LongSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSortedSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> subMap(K from, K to) {
            return Object2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> headMap(K to) {
            return Object2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> tailMap(K from) {
            return Object2LongSortedMaps.EMPTY_MAP;
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

    public static <K> Object2LongSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongSortedMaps$Singleton.class */
    public static class Singleton<K> extends Object2LongMaps.Singleton<K> implements Object2LongSortedMap<K>, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSortedSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2LongMap.BasicEntry(this.key, this.value), Object2LongSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return object2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2LongSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2LongSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2LongSortedMaps.EMPTY_MAP;
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

    public static <K> Object2LongSortedMap<K> singleton(K key, Long value) {
        return new Singleton(key, value.longValue());
    }

    public static <K> Object2LongSortedMap<K> singleton(K key, Long value, Comparator<? super K> comparator) {
        return new Singleton(key, value.longValue(), comparator);
    }

    public static <K> Object2LongSortedMap<K> singleton(K key, long value) {
        return new Singleton(key, value);
    }

    public static <K> Object2LongSortedMap<K> singleton(K key, long value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Object2LongMaps.SynchronizedMap<K> implements Object2LongSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2LongSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Object2LongSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2LongSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSortedSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2LongEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return object2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2LongSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2LongSortedMap<K>) from), this.sync);
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

    public static <K> Object2LongSortedMap<K> synchronize(Object2LongSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Object2LongSortedMap<K> synchronize(Object2LongSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Object2LongMaps.UnmodifiableMap<K> implements Object2LongSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2LongSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Object2LongSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSortedSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2LongEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Long>> entrySet() {
            return object2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2LongSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap, java.util.SortedMap
        public Object2LongSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2LongSortedMap<K>) from));
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

    public static <K> Object2LongSortedMap<K> unmodifiable(Object2LongSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
