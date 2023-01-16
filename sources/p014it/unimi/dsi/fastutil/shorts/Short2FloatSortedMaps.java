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
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2FloatMap;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatMap;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatSortedMaps.class */
public final class Short2FloatSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2FloatSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static ObjectBidirectionalIterator<Short2FloatMap.Entry> fastIterator(Short2FloatSortedMap map) {
        ObjectSortedSet<Short2FloatMap.Entry> entries = map.short2FloatEntrySet();
        return entries instanceof Short2FloatSortedMap.FastSortedEntrySet ? ((Short2FloatSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Short2FloatMap.Entry> fastIterable(Short2FloatSortedMap map) {
        ObjectSortedSet<Short2FloatMap.Entry> entries = map.short2FloatEntrySet();
        if (!(entries instanceof Short2FloatSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2FloatSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2FloatSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Short2FloatMaps.EmptyMap implements Short2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public ObjectSortedSet<Short2FloatMap.Entry> short2FloatEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Float>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap subMap(short from, short to) {
            return Short2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap headMap(short to) {
            return Short2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap tailMap(short from) {
            return Short2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatSortedMaps$Singleton.class */
    public static class Singleton extends Short2FloatMaps.Singleton implements Short2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortComparator comparator;

        protected Singleton(short key, float value, ShortComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(short key, float value) {
            this(key, value, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public ObjectSortedSet<Short2FloatMap.Entry> short2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2FloatMap.BasicEntry(this.key, this.value), Short2FloatSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Float>> entrySet() {
            return short2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2FloatSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static Short2FloatSortedMap singleton(Short key, Float value) {
        return new Singleton(key.shortValue(), value.floatValue());
    }

    public static Short2FloatSortedMap singleton(Short key, Float value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value.floatValue(), comparator);
    }

    public static Short2FloatSortedMap singleton(short key, float value) {
        return new Singleton(key, value);
    }

    public static Short2FloatSortedMap singleton(short key, float value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Short2FloatMaps.SynchronizedMap implements Short2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2FloatSortedMap sortedMap;

        protected SynchronizedSortedMap(Short2FloatSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public ObjectSortedSet<Short2FloatMap.Entry> short2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2FloatEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Float>> entrySet() {
            return short2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Short2FloatSortedMap synchronize(Short2FloatSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Short2FloatSortedMap synchronize(Short2FloatSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Short2FloatMaps.UnmodifiableMap implements Short2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2FloatSortedMap sortedMap;

        protected UnmodifiableSortedMap(Short2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public ObjectSortedSet<Short2FloatMap.Entry> short2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2FloatEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Float>> entrySet() {
            return short2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2FloatMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public Short2FloatSortedMap tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
        @Deprecated
        public Short2FloatSortedMap tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Short2FloatSortedMap unmodifiable(Short2FloatSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
