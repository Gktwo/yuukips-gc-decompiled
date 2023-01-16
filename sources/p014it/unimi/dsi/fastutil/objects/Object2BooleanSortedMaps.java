package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanSortedMaps.class */
public final class Object2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2BooleanSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Object2BooleanMap.Entry<K>> fastIterator(Object2BooleanSortedMap<K> map) {
        ObjectSortedSet<Object2BooleanMap.Entry<K>> entries = map.object2BooleanEntrySet();
        return entries instanceof Object2BooleanSortedMap.FastSortedEntrySet ? ((Object2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Object2BooleanMap.Entry<K>> fastIterable(Object2BooleanSortedMap<K> map) {
        ObjectSortedSet<Object2BooleanMap.Entry<K>> entries = map.object2BooleanEntrySet();
        if (!(entries instanceof Object2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Object2BooleanMaps.EmptyMap<K> implements Object2BooleanSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSortedSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> subMap(K from, K to) {
            return Object2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> headMap(K to) {
            return Object2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> tailMap(K from) {
            return Object2BooleanSortedMaps.EMPTY_MAP;
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

    public static <K> Object2BooleanSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanSortedMaps$Singleton.class */
    public static class Singleton<K> extends Object2BooleanMaps.Singleton<K> implements Object2BooleanSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Comparator<? super K> comparator;

        protected Singleton(K key, boolean value, Comparator<? super K> comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(K key, boolean value) {
            this(key, value, null);
        }

        final int compare(K k1, K k2) {
            return this.comparator == null ? ((Comparable) k1).compareTo(k2) : this.comparator.compare(k1, k2);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSortedSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2BooleanMap.BasicEntry(this.key, this.value), Object2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Boolean>> entrySet() {
            return object2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2BooleanSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2BooleanSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2BooleanSortedMaps.EMPTY_MAP;
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

    public static <K> Object2BooleanSortedMap<K> singleton(K key, Boolean value) {
        return new Singleton(key, value.booleanValue());
    }

    public static <K> Object2BooleanSortedMap<K> singleton(K key, Boolean value, Comparator<? super K> comparator) {
        return new Singleton(key, value.booleanValue(), comparator);
    }

    public static <K> Object2BooleanSortedMap<K> singleton(K key, boolean value) {
        return new Singleton(key, value);
    }

    public static <K> Object2BooleanSortedMap<K> singleton(K key, boolean value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Object2BooleanMaps.SynchronizedMap<K> implements Object2BooleanSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2BooleanSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Object2BooleanSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2BooleanSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSortedSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Boolean>> entrySet() {
            return object2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2BooleanSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2BooleanSortedMap<K>) from), this.sync);
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

    public static <K> Object2BooleanSortedMap<K> synchronize(Object2BooleanSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Object2BooleanSortedMap<K> synchronize(Object2BooleanSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Object2BooleanMaps.UnmodifiableMap<K> implements Object2BooleanSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2BooleanSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Object2BooleanSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSortedSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Boolean>> entrySet() {
            return object2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2BooleanSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap, java.util.SortedMap
        public Object2BooleanSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2BooleanSortedMap<K>) from));
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

    public static <K> Object2BooleanSortedMap<K> unmodifiable(Object2BooleanSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
