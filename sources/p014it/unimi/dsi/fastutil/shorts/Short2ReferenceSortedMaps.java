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
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ReferenceMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceSortedMaps.class */
public final class Short2ReferenceSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2ReferenceSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Short2ReferenceMap.Entry<V>> fastIterator(Short2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Short2ReferenceMap.Entry<V>> entries = map.short2ReferenceEntrySet();
        return entries instanceof Short2ReferenceSortedMap.FastSortedEntrySet ? ((Short2ReferenceSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Short2ReferenceMap.Entry<V>> fastIterable(Short2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Short2ReferenceMap.Entry<V>> entries = map.short2ReferenceEntrySet();
        if (!(entries instanceof Short2ReferenceSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2ReferenceSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2ReferenceSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Short2ReferenceMaps.EmptyMap<V> implements Short2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public ObjectSortedSet<Short2ReferenceMap.Entry<V>> short2ReferenceEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> subMap(short from, short to) {
            return Short2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> headMap(short to) {
            return Short2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> tailMap(short from) {
            return Short2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static <V> Short2ReferenceSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceSortedMaps$Singleton.class */
    public static class Singleton<V> extends Short2ReferenceMaps.Singleton<V> implements Short2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ShortComparator comparator;

        protected Singleton(short key, V value, ShortComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(short key, V value) {
            this(key, value, null);
        }

        final int compare(short k1, short k2) {
            return this.comparator == null ? Short.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public ObjectSortedSet<Short2ReferenceMap.Entry<V>> short2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2ReferenceMap.BasicEntry(this.key, this.value), Short2ReferenceSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return short2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2ReferenceSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static <V> Short2ReferenceSortedMap<V> singleton(Short key, V value) {
        return new Singleton(key.shortValue(), value);
    }

    public static <V> Short2ReferenceSortedMap<V> singleton(Short key, V value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value, comparator);
    }

    public static <V> Short2ReferenceSortedMap<V> singleton(short key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Short2ReferenceSortedMap<V> singleton(short key, V value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Short2ReferenceMaps.SynchronizedMap<V> implements Short2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ReferenceSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Short2ReferenceSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2ReferenceSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public ObjectSortedSet<Short2ReferenceMap.Entry<V>> short2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2ReferenceEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return short2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Short2ReferenceSortedMap<V> synchronize(Short2ReferenceSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Short2ReferenceSortedMap<V> synchronize(Short2ReferenceSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ReferenceSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Short2ReferenceMaps.UnmodifiableMap<V> implements Short2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ReferenceSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Short2ReferenceSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public ObjectSortedSet<Short2ReferenceMap.Entry<V>> short2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2ReferenceEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return short2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ReferenceMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public Short2ReferenceSortedMap<V> tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ReferenceSortedMap
        @Deprecated
        public Short2ReferenceSortedMap<V> tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Short2ReferenceSortedMap<V> unmodifiable(Short2ReferenceSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
