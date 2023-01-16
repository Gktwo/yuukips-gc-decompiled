package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2DoubleMap;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleMap;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2DoubleSortedMaps.class */
public final class Long2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Long2DoubleSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Long, ?>> entryComparator(LongComparator comparator) {
        return x, y -> {
            return comparator.compare(((Long) x.getKey()).longValue(), ((Long) y.getKey()).longValue());
        };
    }

    public static ObjectBidirectionalIterator<Long2DoubleMap.Entry> fastIterator(Long2DoubleSortedMap map) {
        ObjectSortedSet<Long2DoubleMap.Entry> entries = map.long2DoubleEntrySet();
        return entries instanceof Long2DoubleSortedMap.FastSortedEntrySet ? ((Long2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Long2DoubleMap.Entry> fastIterable(Long2DoubleSortedMap map) {
        ObjectSortedSet<Long2DoubleMap.Entry> entries = map.long2DoubleEntrySet();
        if (!(entries instanceof Long2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Long2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Long2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Long2DoubleMaps.EmptyMap implements Long2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public ObjectSortedSet<Long2DoubleMap.Entry> long2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        public LongSortedSet keySet() {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap subMap(long from, long to) {
            return Long2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap headMap(long to) {
            return Long2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap tailMap(long from) {
            return Long2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long firstLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long lastLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2DoubleSortedMaps$Singleton.class */
    public static class Singleton extends Long2DoubleMaps.Singleton implements Long2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongComparator comparator;

        protected Singleton(long key, double value, LongComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(long key, double value) {
            this(key, value, null);
        }

        final int compare(long k1, long k2) {
            return this.comparator == null ? Long.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public ObjectSortedSet<Long2DoubleMap.Entry> long2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractLong2DoubleMap.BasicEntry(this.key, this.value), Long2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Double>> entrySet() {
            return long2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.singleton(this.key, this.comparator);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap subMap(long from, long to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Long2DoubleSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap headMap(long to) {
            return compare(this.key, to) < 0 ? this : Long2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap tailMap(long from) {
            return compare(from, this.key) <= 0 ? this : Long2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long firstLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long lastLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    public static Long2DoubleSortedMap singleton(Long key, Double value) {
        return new Singleton(key.longValue(), value.doubleValue());
    }

    public static Long2DoubleSortedMap singleton(Long key, Double value, LongComparator comparator) {
        return new Singleton(key.longValue(), value.doubleValue(), comparator);
    }

    public static Long2DoubleSortedMap singleton(long key, double value) {
        return new Singleton(key, value);
    }

    public static Long2DoubleSortedMap singleton(long key, double value, LongComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Long2DoubleMaps.SynchronizedMap implements Long2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2DoubleSortedMap sortedMap;

        protected SynchronizedSortedMap(Long2DoubleSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Long2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            Comparator<? super Long> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public ObjectSortedSet<Long2DoubleMap.Entry> long2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.long2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Double>> entrySet() {
            return long2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap subMap(long from, long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap headMap(long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap tailMap(long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long firstLongKey() {
            long firstLongKey;
            synchronized (this.sync) {
                firstLongKey = this.sortedMap.firstLongKey();
            }
            return firstLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long lastLongKey() {
            long lastLongKey;
            synchronized (this.sync) {
                lastLongKey = this.sortedMap.lastLongKey();
            }
            return lastLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            Long firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            Long lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap subMap(Long from, Long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap headMap(Long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap tailMap(Long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Long2DoubleSortedMap synchronize(Long2DoubleSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Long2DoubleSortedMap synchronize(Long2DoubleSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Long2DoubleMaps.UnmodifiableMap implements Long2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2DoubleSortedMap sortedMap;

        protected UnmodifiableSortedMap(Long2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public ObjectSortedSet<Long2DoubleMap.Entry> long2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.long2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Double>> entrySet() {
            return long2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2DoubleMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap subMap(long from, long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap headMap(long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public Long2DoubleSortedMap tailMap(long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long firstLongKey() {
            return this.sortedMap.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        public long lastLongKey() {
            return this.sortedMap.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap subMap(Long from, Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap headMap(Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2DoubleSortedMap
        @Deprecated
        public Long2DoubleSortedMap tailMap(Long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Long2DoubleSortedMap unmodifiable(Long2DoubleSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
