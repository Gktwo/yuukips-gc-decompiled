package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap;
import p014it.unimi.dsi.fastutil.objects.Object2ByteMap;
import p014it.unimi.dsi.fastutil.objects.Object2ByteMaps;
import p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteSortedMaps.class */
public final class Object2ByteSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2ByteSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Object2ByteMap.Entry<K>> fastIterator(Object2ByteSortedMap<K> map) {
        ObjectSortedSet<Object2ByteMap.Entry<K>> entries = map.object2ByteEntrySet();
        return entries instanceof Object2ByteSortedMap.FastSortedEntrySet ? ((Object2ByteSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Object2ByteMap.Entry<K>> fastIterable(Object2ByteSortedMap<K> map) {
        ObjectSortedSet<Object2ByteMap.Entry<K>> entries = map.object2ByteEntrySet();
        if (!(entries instanceof Object2ByteSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2ByteSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2ByteSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Object2ByteMaps.EmptyMap<K> implements Object2ByteSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSortedSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Byte>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> subMap(K from, K to) {
            return Object2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> headMap(K to) {
            return Object2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> tailMap(K from) {
            return Object2ByteSortedMaps.EMPTY_MAP;
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

    public static <K> Object2ByteSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteSortedMaps$Singleton.class */
    public static class Singleton<K> extends Object2ByteMaps.Singleton<K> implements Object2ByteSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, byte value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, byte value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSortedSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2ByteMap.BasicEntry(this.key, this.value), Object2ByteSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Byte>> entrySet() {
            return object2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2ByteSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2ByteSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2ByteSortedMaps.EMPTY_MAP;
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

    public static <K> Object2ByteSortedMap<K> singleton(K key, Byte value) {
        return new Singleton(key, value.byteValue());
    }

    public static <K> Object2ByteSortedMap<K> singleton(K key, Byte value, Comparator<? super K> comparator) {
        return new Singleton(key, value.byteValue(), comparator);
    }

    public static <K> Object2ByteSortedMap<K> singleton(K key, byte value) {
        return new Singleton(key, value);
    }

    public static <K> Object2ByteSortedMap<K> singleton(K key, byte value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Object2ByteMaps.SynchronizedMap<K> implements Object2ByteSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ByteSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Object2ByteSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2ByteSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSortedSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2ByteEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Byte>> entrySet() {
            return object2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2ByteSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2ByteSortedMap<K>) from), this.sync);
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

    public static <K> Object2ByteSortedMap<K> synchronize(Object2ByteSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Object2ByteSortedMap<K> synchronize(Object2ByteSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Object2ByteMaps.UnmodifiableMap<K> implements Object2ByteSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ByteSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Object2ByteSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSortedSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2ByteEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Byte>> entrySet() {
            return object2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2ByteSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap, java.util.SortedMap
        public Object2ByteSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2ByteSortedMap<K>) from));
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

    public static <K> Object2ByteSortedMap<K> unmodifiable(Object2ByteSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
