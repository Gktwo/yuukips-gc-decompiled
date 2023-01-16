package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleSortedMaps.class */
public final class Int2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Int2DoubleSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(IntComparator comparator) {
        return x, y -> {
            return comparator.compare(((Integer) x.getKey()).intValue(), ((Integer) y.getKey()).intValue());
        };
    }

    public static ObjectBidirectionalIterator<Int2DoubleMap.Entry> fastIterator(Int2DoubleSortedMap map) {
        ObjectSortedSet<Int2DoubleMap.Entry> entries = map.int2DoubleEntrySet();
        return entries instanceof Int2DoubleSortedMap.FastSortedEntrySet ? ((Int2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Int2DoubleMap.Entry> fastIterable(Int2DoubleSortedMap map) {
        ObjectSortedSet<Int2DoubleMap.Entry> entries = map.int2DoubleEntrySet();
        if (!(entries instanceof Int2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Int2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Int2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Int2DoubleMaps.EmptyMap implements Int2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap subMap(int from, int to) {
            return Int2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap headMap(int to) {
            return Int2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap tailMap(int from) {
            return Int2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int firstIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int lastIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleSortedMaps$Singleton.class */
    public static class Singleton extends Int2DoubleMaps.Singleton implements Int2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntComparator comparator;

        protected Singleton(int key, double value, IntComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(int key, double value) {
            this(key, value, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractInt2DoubleMap.BasicEntry(this.key, this.value), Int2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Double>> entrySet() {
            return int2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap subMap(int from, int to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Int2DoubleSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap headMap(int to) {
            return compare(this.key, to) < 0 ? this : Int2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap tailMap(int from) {
            return compare(from, this.key) <= 0 ? this : Int2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int firstIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int lastIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static Int2DoubleSortedMap singleton(Integer key, Double value) {
        return new Singleton(key.intValue(), value.doubleValue());
    }

    public static Int2DoubleSortedMap singleton(Integer key, Double value, IntComparator comparator) {
        return new Singleton(key.intValue(), value.doubleValue(), comparator);
    }

    public static Int2DoubleSortedMap singleton(int key, double value) {
        return new Singleton(key, value);
    }

    public static Int2DoubleSortedMap singleton(int key, double value, IntComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Int2DoubleMaps.SynchronizedMap implements Int2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2DoubleSortedMap sortedMap;

        protected SynchronizedSortedMap(Int2DoubleSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Int2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.int2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Double>> entrySet() {
            return int2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap subMap(int from, int to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap headMap(int to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap tailMap(int from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int firstIntKey() {
            int firstIntKey;
            synchronized (this.sync) {
                firstIntKey = this.sortedMap.firstIntKey();
            }
            return firstIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int lastIntKey() {
            int lastIntKey;
            synchronized (this.sync) {
                lastIntKey = this.sortedMap.lastIntKey();
            }
            return lastIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            Integer firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            Integer lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap subMap(Integer from, Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap headMap(Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap tailMap(Integer from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Int2DoubleSortedMap synchronize(Int2DoubleSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Int2DoubleSortedMap synchronize(Int2DoubleSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Int2DoubleMaps.UnmodifiableMap implements Int2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2DoubleSortedMap sortedMap;

        protected UnmodifiableSortedMap(Int2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.int2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Double>> entrySet() {
            return int2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap subMap(int from, int to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap headMap(int to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap tailMap(int from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int firstIntKey() {
            return this.sortedMap.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int lastIntKey() {
            return this.sortedMap.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap subMap(Integer from, Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap headMap(Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        @Deprecated
        public Int2DoubleSortedMap tailMap(Integer from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Int2DoubleSortedMap unmodifiable(Int2DoubleSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
