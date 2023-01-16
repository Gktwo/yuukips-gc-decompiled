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
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteSortedMaps.class */
public final class Short2ByteSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2ByteSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static ObjectBidirectionalIterator<Short2ByteMap.Entry> fastIterator(Short2ByteSortedMap map) {
        ObjectSortedSet<Short2ByteMap.Entry> entries = map.short2ByteEntrySet();
        return entries instanceof Short2ByteSortedMap.FastSortedEntrySet ? ((Short2ByteSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Short2ByteMap.Entry> fastIterable(Short2ByteSortedMap map) {
        ObjectSortedSet<Short2ByteMap.Entry> entries = map.short2ByteEntrySet();
        if (!(entries instanceof Short2ByteSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2ByteSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2ByteSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Short2ByteMaps.EmptyMap implements Short2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public ObjectSortedSet<Short2ByteMap.Entry> short2ByteEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Byte>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap subMap(short from, short to) {
            return Short2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap headMap(short to) {
            return Short2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap tailMap(short from) {
            return Short2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteSortedMaps$Singleton.class */
    public static class Singleton extends Short2ByteMaps.Singleton implements Short2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortComparator comparator;

        protected Singleton(short key, byte value, ShortComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(short key, byte value) {
            this(key, value, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public ObjectSortedSet<Short2ByteMap.Entry> short2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2ByteMap.BasicEntry(this.key, this.value), Short2ByteSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Byte>> entrySet() {
            return short2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2ByteSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static Short2ByteSortedMap singleton(Short key, Byte value) {
        return new Singleton(key.shortValue(), value.byteValue());
    }

    public static Short2ByteSortedMap singleton(Short key, Byte value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value.byteValue(), comparator);
    }

    public static Short2ByteSortedMap singleton(short key, byte value) {
        return new Singleton(key, value);
    }

    public static Short2ByteSortedMap singleton(short key, byte value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Short2ByteMaps.SynchronizedMap implements Short2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ByteSortedMap sortedMap;

        protected SynchronizedSortedMap(Short2ByteSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public ObjectSortedSet<Short2ByteMap.Entry> short2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2ByteEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Byte>> entrySet() {
            return short2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Short2ByteSortedMap synchronize(Short2ByteSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Short2ByteSortedMap synchronize(Short2ByteSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Short2ByteMaps.UnmodifiableMap implements Short2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ByteSortedMap sortedMap;

        protected UnmodifiableSortedMap(Short2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public ObjectSortedSet<Short2ByteMap.Entry> short2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2ByteEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Byte>> entrySet() {
            return short2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public Short2ByteSortedMap tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteSortedMap
        @Deprecated
        public Short2ByteSortedMap tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Short2ByteSortedMap unmodifiable(Short2ByteSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
