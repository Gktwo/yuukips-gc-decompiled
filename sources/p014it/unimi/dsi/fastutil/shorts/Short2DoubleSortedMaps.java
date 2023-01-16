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
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleMap;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleSortedMaps.class */
public final class Short2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2DoubleSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static ObjectBidirectionalIterator<Short2DoubleMap.Entry> fastIterator(Short2DoubleSortedMap map) {
        ObjectSortedSet<Short2DoubleMap.Entry> entries = map.short2DoubleEntrySet();
        return entries instanceof Short2DoubleSortedMap.FastSortedEntrySet ? ((Short2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Short2DoubleMap.Entry> fastIterable(Short2DoubleSortedMap map) {
        ObjectSortedSet<Short2DoubleMap.Entry> entries = map.short2DoubleEntrySet();
        if (!(entries instanceof Short2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Short2DoubleMaps.EmptyMap implements Short2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public ObjectSortedSet<Short2DoubleMap.Entry> short2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap subMap(short from, short to) {
            return Short2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap headMap(short to) {
            return Short2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap tailMap(short from) {
            return Short2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleSortedMaps$Singleton.class */
    public static class Singleton extends Short2DoubleMaps.Singleton implements Short2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortComparator comparator;

        protected Singleton(short key, double value, ShortComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(short key, double value) {
            this(key, value, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public ObjectSortedSet<Short2DoubleMap.Entry> short2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2DoubleMap.BasicEntry(this.key, this.value), Short2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Double>> entrySet() {
            return short2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2DoubleSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static Short2DoubleSortedMap singleton(Short key, Double value) {
        return new Singleton(key.shortValue(), value.doubleValue());
    }

    public static Short2DoubleSortedMap singleton(Short key, Double value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value.doubleValue(), comparator);
    }

    public static Short2DoubleSortedMap singleton(short key, double value) {
        return new Singleton(key, value);
    }

    public static Short2DoubleSortedMap singleton(short key, double value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Short2DoubleMaps.SynchronizedMap implements Short2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2DoubleSortedMap sortedMap;

        protected SynchronizedSortedMap(Short2DoubleSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public ObjectSortedSet<Short2DoubleMap.Entry> short2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Double>> entrySet() {
            return short2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Short2DoubleSortedMap synchronize(Short2DoubleSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Short2DoubleSortedMap synchronize(Short2DoubleSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Short2DoubleMaps.UnmodifiableMap implements Short2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2DoubleSortedMap sortedMap;

        protected UnmodifiableSortedMap(Short2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public ObjectSortedSet<Short2DoubleMap.Entry> short2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Double>> entrySet() {
            return short2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2DoubleMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public Short2DoubleSortedMap tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleSortedMap
        @Deprecated
        public Short2DoubleSortedMap tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Short2DoubleSortedMap unmodifiable(Short2DoubleSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
