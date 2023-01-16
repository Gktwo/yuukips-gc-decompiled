package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanMap;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanSortedMaps.class */
public final class Long2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Long2BooleanSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Long, ?>> entryComparator(LongComparator comparator) {
        return x, y -> {
            return comparator.compare(((Long) x.getKey()).longValue(), ((Long) y.getKey()).longValue());
        };
    }

    public static ObjectBidirectionalIterator<Long2BooleanMap.Entry> fastIterator(Long2BooleanSortedMap map) {
        ObjectSortedSet<Long2BooleanMap.Entry> entries = map.long2BooleanEntrySet();
        return entries instanceof Long2BooleanSortedMap.FastSortedEntrySet ? ((Long2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Long2BooleanMap.Entry> fastIterable(Long2BooleanSortedMap map) {
        ObjectSortedSet<Long2BooleanMap.Entry> entries = map.long2BooleanEntrySet();
        if (!(entries instanceof Long2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Long2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Long2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Long2BooleanMaps.EmptyMap implements Long2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public ObjectSortedSet<Long2BooleanMap.Entry> long2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        public LongSortedSet keySet() {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap subMap(long from, long to) {
            return Long2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap headMap(long to) {
            return Long2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap tailMap(long from) {
            return Long2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long firstLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long lastLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanSortedMaps$Singleton.class */
    public static class Singleton extends Long2BooleanMaps.Singleton implements Long2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongComparator comparator;

        protected Singleton(long key, boolean value, LongComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(long key, boolean value) {
            this(key, value, null);
        }

        final int compare(long k1, long k2) {
            return this.comparator == null ? Long.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public ObjectSortedSet<Long2BooleanMap.Entry> long2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractLong2BooleanMap.BasicEntry(this.key, this.value), Long2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Boolean>> entrySet() {
            return long2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.singleton(this.key, this.comparator);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap subMap(long from, long to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Long2BooleanSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap headMap(long to) {
            return compare(this.key, to) < 0 ? this : Long2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap tailMap(long from) {
            return compare(from, this.key) <= 0 ? this : Long2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long firstLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long lastLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    public static Long2BooleanSortedMap singleton(Long key, Boolean value) {
        return new Singleton(key.longValue(), value.booleanValue());
    }

    public static Long2BooleanSortedMap singleton(Long key, Boolean value, LongComparator comparator) {
        return new Singleton(key.longValue(), value.booleanValue(), comparator);
    }

    public static Long2BooleanSortedMap singleton(long key, boolean value) {
        return new Singleton(key, value);
    }

    public static Long2BooleanSortedMap singleton(long key, boolean value, LongComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Long2BooleanMaps.SynchronizedMap implements Long2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2BooleanSortedMap sortedMap;

        protected SynchronizedSortedMap(Long2BooleanSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Long2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            Comparator<? super Long> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public ObjectSortedSet<Long2BooleanMap.Entry> long2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.long2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Boolean>> entrySet() {
            return long2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap subMap(long from, long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap headMap(long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap tailMap(long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long firstLongKey() {
            long firstLongKey;
            synchronized (this.sync) {
                firstLongKey = this.sortedMap.firstLongKey();
            }
            return firstLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long lastLongKey() {
            long lastLongKey;
            synchronized (this.sync) {
                lastLongKey = this.sortedMap.lastLongKey();
            }
            return lastLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            Long firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            Long lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap subMap(Long from, Long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap headMap(Long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap tailMap(Long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Long2BooleanSortedMap synchronize(Long2BooleanSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Long2BooleanSortedMap synchronize(Long2BooleanSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Long2BooleanMaps.UnmodifiableMap implements Long2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2BooleanSortedMap sortedMap;

        protected UnmodifiableSortedMap(Long2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public ObjectSortedSet<Long2BooleanMap.Entry> long2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.long2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Boolean>> entrySet() {
            return long2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap subMap(long from, long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap headMap(long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public Long2BooleanSortedMap tailMap(long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long firstLongKey() {
            return this.sortedMap.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        public long lastLongKey() {
            return this.sortedMap.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap subMap(Long from, Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap headMap(Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanSortedMap
        @Deprecated
        public Long2BooleanSortedMap tailMap(Long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Long2BooleanSortedMap unmodifiable(Long2BooleanSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
