package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMap;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMaps;
import p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatSortedMaps.class */
public final class Object2FloatSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2FloatSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Object2FloatMap.Entry<K>> fastIterator(Object2FloatSortedMap<K> map) {
        ObjectSortedSet<Object2FloatMap.Entry<K>> entries = map.object2FloatEntrySet();
        return entries instanceof Object2FloatSortedMap.FastSortedEntrySet ? ((Object2FloatSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Object2FloatMap.Entry<K>> fastIterable(Object2FloatSortedMap<K> map) {
        ObjectSortedSet<Object2FloatMap.Entry<K>> entries = map.object2FloatEntrySet();
        if (!(entries instanceof Object2FloatSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2FloatSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2FloatSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Object2FloatMaps.EmptyMap<K> implements Object2FloatSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap
        public ObjectSortedSet<Object2FloatMap.Entry<K>> object2FloatEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> subMap(K from, K to) {
            return Object2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> headMap(K to) {
            return Object2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> tailMap(K from) {
            return Object2FloatSortedMaps.EMPTY_MAP;
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

    public static <K> Object2FloatSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatSortedMaps$Singleton.class */
    public static class Singleton<K> extends Object2FloatMaps.Singleton<K> implements Object2FloatSortedMap<K>, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap
        public ObjectSortedSet<Object2FloatMap.Entry<K>> object2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2FloatMap.BasicEntry(this.key, this.value), Object2FloatSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return object2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2FloatSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2FloatSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2FloatSortedMaps.EMPTY_MAP;
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

    public static <K> Object2FloatSortedMap<K> singleton(K key, Float value) {
        return new Singleton(key, value.floatValue());
    }

    public static <K> Object2FloatSortedMap<K> singleton(K key, Float value, Comparator<? super K> comparator) {
        return new Singleton(key, value.floatValue(), comparator);
    }

    public static <K> Object2FloatSortedMap<K> singleton(K key, float value) {
        return new Singleton(key, value);
    }

    public static <K> Object2FloatSortedMap<K> singleton(K key, float value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Object2FloatMaps.SynchronizedMap<K> implements Object2FloatSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2FloatSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Object2FloatSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2FloatSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap
        public ObjectSortedSet<Object2FloatMap.Entry<K>> object2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2FloatEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return object2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2FloatSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2FloatSortedMap<K>) from), this.sync);
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

    public static <K> Object2FloatSortedMap<K> synchronize(Object2FloatSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Object2FloatSortedMap<K> synchronize(Object2FloatSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Object2FloatMaps.UnmodifiableMap<K> implements Object2FloatSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2FloatSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Object2FloatSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap
        public ObjectSortedSet<Object2FloatMap.Entry<K>> object2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2FloatEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Float>> entrySet() {
            return object2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2FloatSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap, java.util.SortedMap
        public Object2FloatSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2FloatSortedMap<K>) from));
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

    public static <K> Object2FloatSortedMap<K> unmodifiable(Object2FloatSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
