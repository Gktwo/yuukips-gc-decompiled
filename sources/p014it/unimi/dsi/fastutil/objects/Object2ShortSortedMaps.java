package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap;
import p014it.unimi.dsi.fastutil.objects.Object2ShortMap;
import p014it.unimi.dsi.fastutil.objects.Object2ShortMaps;
import p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortSortedMaps.class */
public final class Object2ShortSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2ShortSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Object2ShortMap.Entry<K>> fastIterator(Object2ShortSortedMap<K> map) {
        ObjectSortedSet<Object2ShortMap.Entry<K>> entries = map.object2ShortEntrySet();
        return entries instanceof Object2ShortSortedMap.FastSortedEntrySet ? ((Object2ShortSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Object2ShortMap.Entry<K>> fastIterable(Object2ShortSortedMap<K> map) {
        ObjectSortedSet<Object2ShortMap.Entry<K>> entries = map.object2ShortEntrySet();
        if (!(entries instanceof Object2ShortSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2ShortSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2ShortSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Object2ShortMaps.EmptyMap<K> implements Object2ShortSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSortedSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> subMap(K from, K to) {
            return Object2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> headMap(K to) {
            return Object2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> tailMap(K from) {
            return Object2ShortSortedMaps.EMPTY_MAP;
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

    public static <K> Object2ShortSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortSortedMaps$Singleton.class */
    public static class Singleton<K> extends Object2ShortMaps.Singleton<K> implements Object2ShortSortedMap<K>, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSortedSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2ShortMap.BasicEntry(this.key, this.value), Object2ShortSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return object2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2ShortSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2ShortSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2ShortSortedMaps.EMPTY_MAP;
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

    public static <K> Object2ShortSortedMap<K> singleton(K key, Short value) {
        return new Singleton(key, value.shortValue());
    }

    public static <K> Object2ShortSortedMap<K> singleton(K key, Short value, Comparator<? super K> comparator) {
        return new Singleton(key, value.shortValue(), comparator);
    }

    public static <K> Object2ShortSortedMap<K> singleton(K key, short value) {
        return new Singleton(key, value);
    }

    public static <K> Object2ShortSortedMap<K> singleton(K key, short value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Object2ShortMaps.SynchronizedMap<K> implements Object2ShortSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ShortSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Object2ShortSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2ShortSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSortedSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2ShortEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return object2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2ShortSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2ShortSortedMap<K>) from), this.sync);
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

    public static <K> Object2ShortSortedMap<K> synchronize(Object2ShortSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Object2ShortSortedMap<K> synchronize(Object2ShortSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Object2ShortMaps.UnmodifiableMap<K> implements Object2ShortSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ShortSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Object2ShortSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSortedSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2ShortEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Short>> entrySet() {
            return object2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2ShortSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap, java.util.SortedMap
        public Object2ShortSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2ShortSortedMap<K>) from));
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

    public static <K> Object2ShortSortedMap<K> unmodifiable(Object2ShortSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
