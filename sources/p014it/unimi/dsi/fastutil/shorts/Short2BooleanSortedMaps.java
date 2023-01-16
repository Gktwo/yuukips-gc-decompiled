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
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanSortedMaps.class */
public final class Short2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2BooleanSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static ObjectBidirectionalIterator<Short2BooleanMap.Entry> fastIterator(Short2BooleanSortedMap map) {
        ObjectSortedSet<Short2BooleanMap.Entry> entries = map.short2BooleanEntrySet();
        return entries instanceof Short2BooleanSortedMap.FastSortedEntrySet ? ((Short2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Short2BooleanMap.Entry> fastIterable(Short2BooleanSortedMap map) {
        ObjectSortedSet<Short2BooleanMap.Entry> entries = map.short2BooleanEntrySet();
        if (!(entries instanceof Short2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Short2BooleanMaps.EmptyMap implements Short2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public ObjectSortedSet<Short2BooleanMap.Entry> short2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap subMap(short from, short to) {
            return Short2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap headMap(short to) {
            return Short2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap tailMap(short from) {
            return Short2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanSortedMaps$Singleton.class */
    public static class Singleton extends Short2BooleanMaps.Singleton implements Short2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortComparator comparator;

        protected Singleton(short key, boolean value, ShortComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(short key, boolean value) {
            this(key, value, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public ObjectSortedSet<Short2BooleanMap.Entry> short2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2BooleanMap.BasicEntry(this.key, this.value), Short2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Boolean>> entrySet() {
            return short2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2BooleanSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static Short2BooleanSortedMap singleton(Short key, Boolean value) {
        return new Singleton(key.shortValue(), value.booleanValue());
    }

    public static Short2BooleanSortedMap singleton(Short key, Boolean value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value.booleanValue(), comparator);
    }

    public static Short2BooleanSortedMap singleton(short key, boolean value) {
        return new Singleton(key, value);
    }

    public static Short2BooleanSortedMap singleton(short key, boolean value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Short2BooleanMaps.SynchronizedMap implements Short2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2BooleanSortedMap sortedMap;

        protected SynchronizedSortedMap(Short2BooleanSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public ObjectSortedSet<Short2BooleanMap.Entry> short2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Boolean>> entrySet() {
            return short2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Short2BooleanSortedMap synchronize(Short2BooleanSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Short2BooleanSortedMap synchronize(Short2BooleanSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Short2BooleanMaps.UnmodifiableMap implements Short2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2BooleanSortedMap sortedMap;

        protected UnmodifiableSortedMap(Short2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public ObjectSortedSet<Short2BooleanMap.Entry> short2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, Boolean>> entrySet() {
            return short2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public Short2BooleanSortedMap tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanSortedMap
        @Deprecated
        public Short2BooleanSortedMap tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Short2BooleanSortedMap unmodifiable(Short2BooleanSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
