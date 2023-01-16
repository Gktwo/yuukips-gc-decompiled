package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2IntMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntMaps;
import p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2IntSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntSortedMaps.class */
public final class Int2IntSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Int2IntSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(IntComparator comparator) {
        return x, y -> {
            return comparator.compare(((Integer) x.getKey()).intValue(), ((Integer) y.getKey()).intValue());
        };
    }

    public static ObjectBidirectionalIterator<Int2IntMap.Entry> fastIterator(Int2IntSortedMap map) {
        ObjectSortedSet<Int2IntMap.Entry> entries = map.int2IntEntrySet();
        return entries instanceof Int2IntSortedMap.FastSortedEntrySet ? ((Int2IntSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Int2IntMap.Entry> fastIterable(Int2IntSortedMap map) {
        ObjectSortedSet<Int2IntMap.Entry> entries = map.int2IntEntrySet();
        if (!(entries instanceof Int2IntSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Int2IntSortedMap.FastSortedEntrySet fastSortedEntrySet = (Int2IntSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2IntSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Int2IntMaps.EmptyMap implements Int2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap subMap(int from, int to) {
            return Int2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap headMap(int to) {
            return Int2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap tailMap(int from) {
            return Int2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int firstIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int lastIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2IntSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntSortedMaps$Singleton.class */
    public static class Singleton extends Int2IntMaps.Singleton implements Int2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntComparator comparator;

        protected Singleton(int key, int value, IntComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(int key, int value) {
            this(key, value, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2IntMap, p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractInt2IntMap.BasicEntry(this.key, this.value), Int2IntSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
            return int2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap subMap(int from, int to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Int2IntSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap headMap(int to) {
            return compare(this.key, to) < 0 ? this : Int2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap tailMap(int from) {
            return compare(from, this.key) <= 0 ? this : Int2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int firstIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int lastIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static Int2IntSortedMap singleton(Integer key, Integer value) {
        return new Singleton(key.intValue(), value.intValue());
    }

    public static Int2IntSortedMap singleton(Integer key, Integer value, IntComparator comparator) {
        return new Singleton(key.intValue(), value.intValue(), comparator);
    }

    public static Int2IntSortedMap singleton(int key, int value) {
        return new Singleton(key, value);
    }

    public static Int2IntSortedMap singleton(int key, int value, IntComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2IntSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Int2IntMaps.SynchronizedMap implements Int2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2IntSortedMap sortedMap;

        protected SynchronizedSortedMap(Int2IntSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Int2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.int2IntEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
            return int2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap subMap(int from, int to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap headMap(int to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap tailMap(int from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int firstIntKey() {
            int firstIntKey;
            synchronized (this.sync) {
                firstIntKey = this.sortedMap.firstIntKey();
            }
            return firstIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int lastIntKey() {
            int lastIntKey;
            synchronized (this.sync) {
                lastIntKey = this.sortedMap.lastIntKey();
            }
            return lastIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            Integer firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            Integer lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap subMap(Integer from, Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap headMap(Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap tailMap(Integer from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Int2IntSortedMap synchronize(Int2IntSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Int2IntSortedMap synchronize(Int2IntSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2IntSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Int2IntMaps.UnmodifiableMap implements Int2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2IntSortedMap sortedMap;

        protected UnmodifiableSortedMap(Int2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.int2IntEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
            return int2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap subMap(int from, int to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap headMap(int to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public Int2IntSortedMap tailMap(int from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int firstIntKey() {
            return this.sortedMap.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        public int lastIntKey() {
            return this.sortedMap.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap subMap(Integer from, Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap headMap(Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntSortedMap
        @Deprecated
        public Int2IntSortedMap tailMap(Integer from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Int2IntSortedMap unmodifiable(Int2IntSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
