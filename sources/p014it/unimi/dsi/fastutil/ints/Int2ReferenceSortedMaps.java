package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceMap;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceSortedMaps.class */
public final class Int2ReferenceSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Int2ReferenceSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(IntComparator comparator) {
        return x, y -> {
            return comparator.compare(((Integer) x.getKey()).intValue(), ((Integer) y.getKey()).intValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Int2ReferenceMap.Entry<V>> fastIterator(Int2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Int2ReferenceMap.Entry<V>> entries = map.int2ReferenceEntrySet();
        return entries instanceof Int2ReferenceSortedMap.FastSortedEntrySet ? ((Int2ReferenceSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Int2ReferenceMap.Entry<V>> fastIterable(Int2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Int2ReferenceMap.Entry<V>> entries = map.int2ReferenceEntrySet();
        if (!(entries instanceof Int2ReferenceSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Int2ReferenceSortedMap.FastSortedEntrySet fastSortedEntrySet = (Int2ReferenceSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Int2ReferenceMaps.EmptyMap<V> implements Int2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public ObjectSortedSet<Int2ReferenceMap.Entry<V>> int2ReferenceEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> subMap(int from, int to) {
            return Int2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> headMap(int to) {
            return Int2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> tailMap(int from) {
            return Int2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int firstIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int lastIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static <V> Int2ReferenceSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceSortedMaps$Singleton.class */
    public static class Singleton<V> extends Int2ReferenceMaps.Singleton<V> implements Int2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntComparator comparator;

        protected Singleton(int key, V value, IntComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(int key, V value) {
            this(key, value, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public ObjectSortedSet<Int2ReferenceMap.Entry<V>> int2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractInt2ReferenceMap.BasicEntry(this.key, this.value), Int2ReferenceSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
            return int2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> subMap(int from, int to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Int2ReferenceSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> headMap(int to) {
            return compare(this.key, to) < 0 ? this : Int2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> tailMap(int from) {
            return compare(from, this.key) <= 0 ? this : Int2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int firstIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int lastIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static <V> Int2ReferenceSortedMap<V> singleton(Integer key, V value) {
        return new Singleton(key.intValue(), value);
    }

    public static <V> Int2ReferenceSortedMap<V> singleton(Integer key, V value, IntComparator comparator) {
        return new Singleton(key.intValue(), value, comparator);
    }

    public static <V> Int2ReferenceSortedMap<V> singleton(int key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Int2ReferenceSortedMap<V> singleton(int key, V value, IntComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Int2ReferenceMaps.SynchronizedMap<V> implements Int2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2ReferenceSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Int2ReferenceSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Int2ReferenceSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public ObjectSortedSet<Int2ReferenceMap.Entry<V>> int2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.int2ReferenceEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
            return int2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> subMap(int from, int to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> headMap(int to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> tailMap(int from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int firstIntKey() {
            int firstIntKey;
            synchronized (this.sync) {
                firstIntKey = this.sortedMap.firstIntKey();
            }
            return firstIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int lastIntKey() {
            int lastIntKey;
            synchronized (this.sync) {
                lastIntKey = this.sortedMap.lastIntKey();
            }
            return lastIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            Integer firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            Integer lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> subMap(Integer from, Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> headMap(Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> tailMap(Integer from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Int2ReferenceSortedMap<V> synchronize(Int2ReferenceSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Int2ReferenceSortedMap<V> synchronize(Int2ReferenceSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ReferenceSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Int2ReferenceMaps.UnmodifiableMap<V> implements Int2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2ReferenceSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Int2ReferenceSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public ObjectSortedSet<Int2ReferenceMap.Entry<V>> int2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.int2ReferenceEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
            return int2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2ReferenceMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> subMap(int from, int to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> headMap(int to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public Int2ReferenceSortedMap<V> tailMap(int from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int firstIntKey() {
            return this.sortedMap.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        public int lastIntKey() {
            return this.sortedMap.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> subMap(Integer from, Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> headMap(Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceSortedMap
        @Deprecated
        public Int2ReferenceSortedMap<V> tailMap(Integer from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Int2ReferenceSortedMap<V> unmodifiable(Int2ReferenceSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
