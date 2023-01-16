package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ByteMap;
import p014it.unimi.dsi.fastutil.longs.Long2ByteMap;
import p014it.unimi.dsi.fastutil.longs.Long2ByteMaps;
import p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteSortedMaps.class */
public final class Long2ByteSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Long2ByteSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Long, ?>> entryComparator(LongComparator comparator) {
        return x, y -> {
            return comparator.compare(((Long) x.getKey()).longValue(), ((Long) y.getKey()).longValue());
        };
    }

    public static ObjectBidirectionalIterator<Long2ByteMap.Entry> fastIterator(Long2ByteSortedMap map) {
        ObjectSortedSet<Long2ByteMap.Entry> entries = map.long2ByteEntrySet();
        return entries instanceof Long2ByteSortedMap.FastSortedEntrySet ? ((Long2ByteSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Long2ByteMap.Entry> fastIterable(Long2ByteSortedMap map) {
        ObjectSortedSet<Long2ByteMap.Entry> entries = map.long2ByteEntrySet();
        if (!(entries instanceof Long2ByteSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Long2ByteSortedMap.FastSortedEntrySet fastSortedEntrySet = (Long2ByteSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Long2ByteMaps.EmptyMap implements Long2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public ObjectSortedSet<Long2ByteMap.Entry> long2ByteEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Byte>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        public LongSortedSet keySet() {
            return LongSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap subMap(long from, long to) {
            return Long2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap headMap(long to) {
            return Long2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap tailMap(long from) {
            return Long2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long firstLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long lastLongKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteSortedMaps$Singleton.class */
    public static class Singleton extends Long2ByteMaps.Singleton implements Long2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongComparator comparator;

        protected Singleton(long key, byte value, LongComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(long key, byte value) {
            this(key, value, null);
        }

        final int compare(long k1, long k2) {
            return this.comparator == null ? Long.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public ObjectSortedSet<Long2ByteMap.Entry> long2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractLong2ByteMap.BasicEntry(this.key, this.value), Long2ByteSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Byte>> entrySet() {
            return long2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.singleton(this.key, this.comparator);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap subMap(long from, long to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Long2ByteSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap headMap(long to) {
            return compare(this.key, to) < 0 ? this : Long2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap tailMap(long from) {
            return compare(from, this.key) <= 0 ? this : Long2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long firstLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long lastLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap headMap(Long oto) {
            return headMap(oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap tailMap(Long ofrom) {
            return tailMap(ofrom.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap subMap(Long ofrom, Long oto) {
            return subMap(ofrom.longValue(), oto.longValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return Long.valueOf(firstLongKey());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return Long.valueOf(lastLongKey());
        }
    }

    public static Long2ByteSortedMap singleton(Long key, Byte value) {
        return new Singleton(key.longValue(), value.byteValue());
    }

    public static Long2ByteSortedMap singleton(Long key, Byte value, LongComparator comparator) {
        return new Singleton(key.longValue(), value.byteValue(), comparator);
    }

    public static Long2ByteSortedMap singleton(long key, byte value) {
        return new Singleton(key, value);
    }

    public static Long2ByteSortedMap singleton(long key, byte value, LongComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Long2ByteMaps.SynchronizedMap implements Long2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ByteSortedMap sortedMap;

        protected SynchronizedSortedMap(Long2ByteSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Long2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            Comparator<? super Long> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public ObjectSortedSet<Long2ByteMap.Entry> long2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.long2ByteEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Byte>> entrySet() {
            return long2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap subMap(long from, long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap headMap(long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap tailMap(long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long firstLongKey() {
            long firstLongKey;
            synchronized (this.sync) {
                firstLongKey = this.sortedMap.firstLongKey();
            }
            return firstLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long lastLongKey() {
            long lastLongKey;
            synchronized (this.sync) {
                lastLongKey = this.sortedMap.lastLongKey();
            }
            return lastLongKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            Long firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            Long lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap subMap(Long from, Long to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap headMap(Long to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap tailMap(Long from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Long2ByteSortedMap synchronize(Long2ByteSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Long2ByteSortedMap synchronize(Long2ByteSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Long2ByteMaps.UnmodifiableMap implements Long2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ByteSortedMap sortedMap;

        protected UnmodifiableSortedMap(Long2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public ObjectSortedSet<Long2ByteMap.Entry> long2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.long2ByteEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Long, Byte>> entrySet() {
            return long2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.longs.Long2ByteMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = LongSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (LongSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap subMap(long from, long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap headMap(long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public Long2ByteSortedMap tailMap(long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long firstLongKey() {
            return this.sortedMap.firstLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        public long lastLongKey() {
            return this.sortedMap.lastLongKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Long lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap subMap(Long from, Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap headMap(Long to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
        @Deprecated
        public Long2ByteSortedMap tailMap(Long from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Long2ByteSortedMap unmodifiable(Long2ByteSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
