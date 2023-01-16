package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap;
import p014it.unimi.dsi.fastutil.shorts.Short2LongMap;
import p014it.unimi.dsi.fastutil.shorts.Short2LongMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongSortedMaps.class */
public final class Short2LongSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2LongSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static ObjectBidirectionalIterator<Short2LongMap.Entry> fastIterator(Short2LongSortedMap map) {
        ObjectSortedSet<Short2LongMap.Entry> entries = map.short2LongEntrySet();
        return entries instanceof Short2LongSortedMap.FastSortedEntrySet ? ((Short2LongSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Short2LongMap.Entry> fastIterable(Short2LongSortedMap map) {
        ObjectSortedSet<Short2LongMap.Entry> entries = map.short2LongEntrySet();
        if (!(entries instanceof Short2LongSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2LongSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2LongSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Short2LongMaps.EmptyMap implements Short2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSortedSet<Short2LongMap.Entry> short2LongEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Long>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap subMap(short from, short to) {
            return Short2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap headMap(short to) {
            return Short2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap tailMap(short from) {
            return Short2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongSortedMaps$Singleton.class */
    public static class Singleton extends Short2LongMaps.Singleton implements Short2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortComparator comparator;

        protected Singleton(short key, long value, ShortComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(short key, long value) {
            this(key, value, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSortedSet<Short2LongMap.Entry> short2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2LongMap.BasicEntry(this.key, this.value), Short2LongSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Long>> entrySet() {
            return short2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2LongSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static Short2LongSortedMap singleton(Short key, Long value) {
        return new Singleton(key.shortValue(), value.longValue());
    }

    public static Short2LongSortedMap singleton(Short key, Long value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value.longValue(), comparator);
    }

    public static Short2LongSortedMap singleton(short key, long value) {
        return new Singleton(key, value);
    }

    public static Short2LongSortedMap singleton(short key, long value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Short2LongMaps.SynchronizedMap implements Short2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2LongSortedMap sortedMap;

        protected SynchronizedSortedMap(Short2LongSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSortedSet<Short2LongMap.Entry> short2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2LongEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Long>> entrySet() {
            return short2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Short2LongSortedMap synchronize(Short2LongSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Short2LongSortedMap synchronize(Short2LongSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Short2LongMaps.UnmodifiableMap implements Short2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2LongSortedMap sortedMap;

        protected UnmodifiableSortedMap(Short2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSortedSet<Short2LongMap.Entry> short2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2LongEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Long>> entrySet() {
            return short2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public Short2LongSortedMap tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        @Deprecated
        public Short2LongSortedMap tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Short2LongSortedMap unmodifiable(Short2LongSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
