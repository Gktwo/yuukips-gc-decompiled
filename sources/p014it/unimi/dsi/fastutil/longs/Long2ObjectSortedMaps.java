package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ObjectMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectSortedMaps.class */
public final class Long2ObjectSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Long2ObjectSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Long, ?>> entryComparator(LongComparator comparator) {
        return x, y -> {
            return comparator.compare(((Long) x.getKey()).longValue(), ((Long) y.getKey()).longValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Long2ObjectMap.Entry<V>> fastIterator(Long2ObjectSortedMap<V> map) {
        ObjectSortedSet<Long2ObjectMap.Entry<V>> entries = map.long2ObjectEntrySet();
        return entries instanceof Long2ObjectSortedMap.FastSortedEntrySet ? ((Long2ObjectSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Long2ObjectMap.Entry<V>> fastIterable(Long2ObjectSortedMap<V> map) {
        ObjectSortedSet<Long2ObjectMap.Entry<V>> entries = map.long2ObjectEntrySet();
        if (!(entries instanceof Long2ObjectSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Long2ObjectSortedMap.FastSortedEntrySet fastSortedEntrySet = (Long2ObjectSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Long2ObjectMaps.EmptyMap<V> implements Long2ObjectSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public ObjectSortedSet<Long2ObjectMap.Entry<V>> long2ObjectEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        public LongSortedSet keySet() {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> subMap(long from, long to) {
            return Long2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> headMap(long to) {
            return Long2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> tailMap(long from) {
            return Long2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long firstLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long lastLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    public static <V> Long2ObjectSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectSortedMaps$Singleton.class */
    public static class Singleton<V> extends Long2ObjectMaps.Singleton<V> implements Long2ObjectSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongComparator comparator;

        protected Singleton(long key, V value, LongComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(long key, V value) {
            this(key, value, null);
        }

        final int compare(long k1, long k2) {
            return this.comparator == null ? Long.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public ObjectSortedSet<Long2ObjectMap.Entry<V>> long2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractLong2ObjectMap.BasicEntry(this.key, this.value), Long2ObjectSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, V>> entrySet() {
            return long2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.singleton(this.key, this.comparator);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> subMap(long from, long to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Long2ObjectSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> headMap(long to) {
            return compare(this.key, to) < 0 ? this : Long2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> tailMap(long from) {
            return compare(from, this.key) <= 0 ? this : Long2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long firstLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long lastLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    public static <V> Long2ObjectSortedMap<V> singleton(Long key, V value) {
        return new Singleton(key.longValue(), value);
    }

    public static <V> Long2ObjectSortedMap<V> singleton(Long key, V value, LongComparator comparator) {
        return new Singleton(key.longValue(), value, comparator);
    }

    public static <V> Long2ObjectSortedMap<V> singleton(long key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Long2ObjectSortedMap<V> singleton(long key, V value, LongComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Long2ObjectMaps.SynchronizedMap<V> implements Long2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ObjectSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Long2ObjectSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Long2ObjectSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            Comparator<? super Long> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public ObjectSortedSet<Long2ObjectMap.Entry<V>> long2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.long2ObjectEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, V>> entrySet() {
            return long2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> subMap(long from, long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> headMap(long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> tailMap(long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long firstLongKey() {
            long firstLongKey;
            synchronized (this.sync) {
                firstLongKey = this.sortedMap.firstLongKey();
            }
            return firstLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long lastLongKey() {
            long lastLongKey;
            synchronized (this.sync) {
                lastLongKey = this.sortedMap.lastLongKey();
            }
            return lastLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            Long firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            Long lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> subMap(Long from, Long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> headMap(Long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> tailMap(Long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Long2ObjectSortedMap<V> synchronize(Long2ObjectSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Long2ObjectSortedMap<V> synchronize(Long2ObjectSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Long2ObjectMaps.UnmodifiableMap<V> implements Long2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ObjectSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Long2ObjectSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public ObjectSortedSet<Long2ObjectMap.Entry<V>> long2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.long2ObjectEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, V>> entrySet() {
            return long2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2ObjectMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> subMap(long from, long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> headMap(long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public Long2ObjectSortedMap<V> tailMap(long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long firstLongKey() {
            return this.sortedMap.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        public long lastLongKey() {
            return this.sortedMap.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> subMap(Long from, Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> headMap(Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectSortedMap
        @Deprecated
        public Long2ObjectSortedMap<V> tailMap(Long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Long2ObjectSortedMap<V> unmodifiable(Long2ObjectSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
