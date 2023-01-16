package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap;
import p014it.unimi.dsi.fastutil.longs.Long2LongMap;
import p014it.unimi.dsi.fastutil.longs.Long2LongMaps;
import p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2LongSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongSortedMaps.class */
public final class Long2LongSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Long2LongSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Long, ?>> entryComparator(LongComparator comparator) {
        return x, y -> {
            return comparator.compare(((Long) x.getKey()).longValue(), ((Long) y.getKey()).longValue());
        };
    }

    public static ObjectBidirectionalIterator<Long2LongMap.Entry> fastIterator(Long2LongSortedMap map) {
        ObjectSortedSet<Long2LongMap.Entry> entries = map.long2LongEntrySet();
        return entries instanceof Long2LongSortedMap.FastSortedEntrySet ? ((Long2LongSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Long2LongMap.Entry> fastIterable(Long2LongSortedMap map) {
        ObjectSortedSet<Long2LongMap.Entry> entries = map.long2LongEntrySet();
        if (!(entries instanceof Long2LongSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Long2LongSortedMap.FastSortedEntrySet fastSortedEntrySet = (Long2LongSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Long2LongMaps.EmptyMap implements Long2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public ObjectSortedSet<Long2LongMap.Entry> long2LongEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Long>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        public LongSortedSet keySet() {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap subMap(long from, long to) {
            return Long2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap headMap(long to) {
            return Long2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap tailMap(long from) {
            return Long2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long firstLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long lastLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongSortedMaps$Singleton.class */
    public static class Singleton extends Long2LongMaps.Singleton implements Long2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongComparator comparator;

        protected Singleton(long key, long value, LongComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(long key, long value) {
            this(key, value, null);
        }

        final int compare(long k1, long k2) {
            return this.comparator == null ? Long.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public ObjectSortedSet<Long2LongMap.Entry> long2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractLong2LongMap.BasicEntry(this.key, this.value), Long2LongSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Long>> entrySet() {
            return long2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.singleton(this.key, this.comparator);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap subMap(long from, long to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Long2LongSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap headMap(long to) {
            return compare(this.key, to) < 0 ? this : Long2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap tailMap(long from) {
            return compare(from, this.key) <= 0 ? this : Long2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long firstLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long lastLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    public static Long2LongSortedMap singleton(Long key, Long value) {
        return new Singleton(key.longValue(), value.longValue());
    }

    public static Long2LongSortedMap singleton(Long key, Long value, LongComparator comparator) {
        return new Singleton(key.longValue(), value.longValue(), comparator);
    }

    public static Long2LongSortedMap singleton(long key, long value) {
        return new Singleton(key, value);
    }

    public static Long2LongSortedMap singleton(long key, long value, LongComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Long2LongMaps.SynchronizedMap implements Long2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2LongSortedMap sortedMap;

        protected SynchronizedSortedMap(Long2LongSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Long2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            Comparator<? super Long> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public ObjectSortedSet<Long2LongMap.Entry> long2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.long2LongEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Long>> entrySet() {
            return long2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap subMap(long from, long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap headMap(long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap tailMap(long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long firstLongKey() {
            long firstLongKey;
            synchronized (this.sync) {
                firstLongKey = this.sortedMap.firstLongKey();
            }
            return firstLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long lastLongKey() {
            long lastLongKey;
            synchronized (this.sync) {
                lastLongKey = this.sortedMap.lastLongKey();
            }
            return lastLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            Long firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            Long lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap subMap(Long from, Long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap headMap(Long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap tailMap(Long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Long2LongSortedMap synchronize(Long2LongSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Long2LongSortedMap synchronize(Long2LongSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Long2LongMaps.UnmodifiableMap implements Long2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2LongSortedMap sortedMap;

        protected UnmodifiableSortedMap(Long2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public ObjectSortedSet<Long2LongMap.Entry> long2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.long2LongEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Long>> entrySet() {
            return long2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap subMap(long from, long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap headMap(long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap tailMap(long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long firstLongKey() {
            return this.sortedMap.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long lastLongKey() {
            return this.sortedMap.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap subMap(Long from, Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap headMap(Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        @Deprecated
        public Long2LongSortedMap tailMap(Long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Long2LongSortedMap unmodifiable(Long2LongSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
