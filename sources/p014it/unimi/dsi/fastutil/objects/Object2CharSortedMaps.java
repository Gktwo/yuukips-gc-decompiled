package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap;
import p014it.unimi.dsi.fastutil.objects.Object2CharMap;
import p014it.unimi.dsi.fastutil.objects.Object2CharMaps;
import p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharSortedMaps.class */
public final class Object2CharSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Object2CharSortedMaps() {
    }

    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(Comparator<? super K> comparator) {
        return x, y -> {
            return comparator.compare(x.getKey(), y.getKey());
        };
    }

    public static <K> ObjectBidirectionalIterator<Object2CharMap.Entry<K>> fastIterator(Object2CharSortedMap<K> map) {
        ObjectSortedSet<Object2CharMap.Entry<K>> entries = map.object2CharEntrySet();
        return entries instanceof Object2CharSortedMap.FastSortedEntrySet ? ((Object2CharSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> ObjectBidirectionalIterable<Object2CharMap.Entry<K>> fastIterable(Object2CharSortedMap<K> map) {
        ObjectSortedSet<Object2CharMap.Entry<K>> entries = map.object2CharEntrySet();
        if (!(entries instanceof Object2CharSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Object2CharSortedMap.FastSortedEntrySet fastSortedEntrySet = (Object2CharSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<K> extends Object2CharMaps.EmptyMap<K> implements Object2CharSortedMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSortedSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> subMap(K from, K to) {
            return Object2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> headMap(K to) {
            return Object2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> tailMap(K from) {
            return Object2CharSortedMaps.EMPTY_MAP;
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

    public static <K> Object2CharSortedMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharSortedMaps$Singleton.class */
    public static class Singleton<K> extends Object2CharMaps.Singleton<K> implements Object2CharSortedMap<K>, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSortedSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractObject2CharMap.BasicEntry(this.key, this.value), Object2CharSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return object2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.Singleton, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet) this.keys;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> subMap(K from, K to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Object2CharSortedMaps.EMPTY_MAP : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> headMap(K to) {
            return compare(this.key, to) < 0 ? this : Object2CharSortedMaps.EMPTY_MAP;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps$Singleton<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> tailMap(K from) {
            return compare(from, this.key) <= 0 ? this : Object2CharSortedMaps.EMPTY_MAP;
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

    public static <K> Object2CharSortedMap<K> singleton(K key, Character value) {
        return new Singleton(key, value.charValue());
    }

    public static <K> Object2CharSortedMap<K> singleton(K key, Character value, Comparator<? super K> comparator) {
        return new Singleton(key, value.charValue(), comparator);
    }

    public static <K> Object2CharSortedMap<K> singleton(K key, char value) {
        return new Singleton(key, value);
    }

    public static <K> Object2CharSortedMap<K> singleton(K key, char value, Comparator<? super K> comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<K> extends Object2CharMaps.SynchronizedMap<K> implements Object2CharSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2CharSortedMap<K> sortedMap;

        protected SynchronizedSortedMap(Object2CharSortedMap<K> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Object2CharSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSortedSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.object2CharEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return object2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> subMap(K from, K to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap((Object) from, (Object) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> headMap(K to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap((Object2CharSortedMap<K>) to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> tailMap(K from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap((Object2CharSortedMap<K>) from), this.sync);
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

    public static <K> Object2CharSortedMap<K> synchronize(Object2CharSortedMap<K> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <K> Object2CharSortedMap<K> synchronize(Object2CharSortedMap<K> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<K> extends Object2CharMaps.UnmodifiableMap<K> implements Object2CharSortedMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2CharSortedMap<K> sortedMap;

        protected UnmodifiableSortedMap(Object2CharSortedMap<K> m) {
            super(m);
            this.sortedMap = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSortedSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.object2CharEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<K, Character>> entrySet() {
            return object2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ObjectSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> subMap(K from, K to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap((Object) from, (Object) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> headMap(K to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap((Object2CharSortedMap<K>) to));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> tailMap(K from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap((Object2CharSortedMap<K>) from));
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

    public static <K> Object2CharSortedMap<K> unmodifiable(Object2CharSortedMap<K> m) {
        return new UnmodifiableSortedMap(m);
    }
}
