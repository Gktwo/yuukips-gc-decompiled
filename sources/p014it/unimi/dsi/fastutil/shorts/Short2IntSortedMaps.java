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
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap;
import p014it.unimi.dsi.fastutil.shorts.Short2IntMap;
import p014it.unimi.dsi.fastutil.shorts.Short2IntMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntSortedMaps.class */
public final class Short2IntSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2IntSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static ObjectBidirectionalIterator<Short2IntMap.Entry> fastIterator(Short2IntSortedMap map) {
        ObjectSortedSet<Short2IntMap.Entry> entries = map.short2IntEntrySet();
        return entries instanceof Short2IntSortedMap.FastSortedEntrySet ? ((Short2IntSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Short2IntMap.Entry> fastIterable(Short2IntSortedMap map) {
        ObjectSortedSet<Short2IntMap.Entry> entries = map.short2IntEntrySet();
        if (!(entries instanceof Short2IntSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2IntSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2IntSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Short2IntMaps.EmptyMap implements Short2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public ObjectSortedSet<Short2IntMap.Entry> short2IntEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Integer>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap subMap(short from, short to) {
            return Short2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap headMap(short to) {
            return Short2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap tailMap(short from) {
            return Short2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntSortedMaps$Singleton.class */
    public static class Singleton extends Short2IntMaps.Singleton implements Short2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortComparator comparator;

        protected Singleton(short key, int value, ShortComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(short key, int value) {
            this(key, value, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public ObjectSortedSet<Short2IntMap.Entry> short2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2IntMap.BasicEntry(this.key, this.value), Short2IntSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Integer>> entrySet() {
            return short2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2IntSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static Short2IntSortedMap singleton(Short key, Integer value) {
        return new Singleton(key.shortValue(), value.intValue());
    }

    public static Short2IntSortedMap singleton(Short key, Integer value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value.intValue(), comparator);
    }

    public static Short2IntSortedMap singleton(short key, int value) {
        return new Singleton(key, value);
    }

    public static Short2IntSortedMap singleton(short key, int value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Short2IntMaps.SynchronizedMap implements Short2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2IntSortedMap sortedMap;

        protected SynchronizedSortedMap(Short2IntSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public ObjectSortedSet<Short2IntMap.Entry> short2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2IntEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Integer>> entrySet() {
            return short2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Short2IntSortedMap synchronize(Short2IntSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Short2IntSortedMap synchronize(Short2IntSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Short2IntMaps.UnmodifiableMap implements Short2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2IntSortedMap sortedMap;

        protected UnmodifiableSortedMap(Short2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public ObjectSortedSet<Short2IntMap.Entry> short2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2IntEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Integer>> entrySet() {
            return short2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public Short2IntSortedMap tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntSortedMap
        @Deprecated
        public Short2IntSortedMap tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Short2IntSortedMap unmodifiable(Short2IntSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
