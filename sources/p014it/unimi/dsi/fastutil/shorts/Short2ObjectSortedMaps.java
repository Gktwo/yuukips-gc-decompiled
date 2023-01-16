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
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectSortedMaps.class */
public final class Short2ObjectSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Short2ObjectSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Short, ?>> entryComparator(ShortComparator comparator) {
        return x, y -> {
            return comparator.compare(((Short) x.getKey()).shortValue(), ((Short) y.getKey()).shortValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> fastIterator(Short2ObjectSortedMap<V> map) {
        ObjectSortedSet<Short2ObjectMap.Entry<V>> entries = map.short2ObjectEntrySet();
        return entries instanceof Short2ObjectSortedMap.FastSortedEntrySet ? ((Short2ObjectSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Short2ObjectMap.Entry<V>> fastIterable(Short2ObjectSortedMap<V> map) {
        ObjectSortedSet<Short2ObjectMap.Entry<V>> entries = map.short2ObjectEntrySet();
        if (!(entries instanceof Short2ObjectSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Short2ObjectSortedMap.FastSortedEntrySet fastSortedEntrySet = (Short2ObjectSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Short2ObjectMaps.EmptyMap<V> implements Short2ObjectSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSortedSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public ShortSortedSet keySet() {
            return ShortSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> subMap(short from, short to) {
            return Short2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> headMap(short to) {
            return Short2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> tailMap(short from) {
            return Short2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short firstShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short lastShortKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static <V> Short2ObjectSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectSortedMaps$Singleton.class */
    public static class Singleton<V> extends Short2ObjectMaps.Singleton<V> implements Short2ObjectSortedMap<V>, Serializable, Cloneable {
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
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSortedSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractShort2ObjectMap.BasicEntry(this.key, this.value), Short2ObjectSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return short2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.singleton(this.key, this.comparator);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> subMap(short from, short to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Short2ObjectSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> headMap(short to) {
            return compare(this.key, to) < 0 ? this : Short2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> tailMap(short from) {
            return compare(from, this.key) <= 0 ? this : Short2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short firstShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short lastShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> headMap(Short oto) {
            return headMap(oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> tailMap(Short ofrom) {
            return tailMap(ofrom.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> subMap(Short ofrom, Short oto) {
            return subMap(ofrom.shortValue(), oto.shortValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return Short.valueOf(firstShortKey());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return Short.valueOf(lastShortKey());
        }
    }

    public static <V> Short2ObjectSortedMap<V> singleton(Short key, V value) {
        return new Singleton(key.shortValue(), value);
    }

    public static <V> Short2ObjectSortedMap<V> singleton(Short key, V value, ShortComparator comparator) {
        return new Singleton(key.shortValue(), value, comparator);
    }

    public static <V> Short2ObjectSortedMap<V> singleton(short key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Short2ObjectSortedMap<V> singleton(short key, V value, ShortComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Short2ObjectMaps.SynchronizedMap<V> implements Short2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ObjectSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Short2ObjectSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Short2ObjectSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            Comparator<? super Short> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSortedSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.short2ObjectEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return short2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> subMap(short from, short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> headMap(short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> tailMap(short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short firstShortKey() {
            short firstShortKey;
            synchronized (this.sync) {
                firstShortKey = this.sortedMap.firstShortKey();
            }
            return firstShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short lastShortKey() {
            short lastShortKey;
            synchronized (this.sync) {
                lastShortKey = this.sortedMap.lastShortKey();
            }
            return lastShortKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            Short firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            Short lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> subMap(Short from, Short to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> headMap(Short to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> tailMap(Short from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Short2ObjectSortedMap<V> synchronize(Short2ObjectSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Short2ObjectSortedMap<V> synchronize(Short2ObjectSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Short2ObjectMaps.UnmodifiableMap<V> implements Short2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ObjectSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Short2ObjectSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSortedSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.short2ObjectEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Short, V>> entrySet() {
            return short2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = ShortSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (ShortSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> subMap(short from, short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> headMap(short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> tailMap(short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short firstShortKey() {
            return this.sortedMap.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short lastShortKey() {
            return this.sortedMap.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Short lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> subMap(Short from, Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> headMap(Short to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        @Deprecated
        public Short2ObjectSortedMap<V> tailMap(Short from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Short2ObjectSortedMap<V> unmodifiable(Short2ObjectSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
