package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap;
import p014it.unimi.dsi.fastutil.ints.Int2ShortMap;
import p014it.unimi.dsi.fastutil.ints.Int2ShortMaps;
import p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortSortedMaps.class */
public final class Int2ShortSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Int2ShortSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(IntComparator comparator) {
        return x, y -> {
            return comparator.compare(((Integer) x.getKey()).intValue(), ((Integer) y.getKey()).intValue());
        };
    }

    public static ObjectBidirectionalIterator<Int2ShortMap.Entry> fastIterator(Int2ShortSortedMap map) {
        ObjectSortedSet<Int2ShortMap.Entry> entries = map.int2ShortEntrySet();
        return entries instanceof Int2ShortSortedMap.FastSortedEntrySet ? ((Int2ShortSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Int2ShortMap.Entry> fastIterable(Int2ShortSortedMap map) {
        ObjectSortedSet<Int2ShortMap.Entry> entries = map.int2ShortEntrySet();
        if (!(entries instanceof Int2ShortSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Int2ShortSortedMap.FastSortedEntrySet fastSortedEntrySet = (Int2ShortSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Int2ShortMaps.EmptyMap implements Int2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSortedSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Short>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap subMap(int from, int to) {
            return Int2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap headMap(int to) {
            return Int2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap tailMap(int from) {
            return Int2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int firstIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int lastIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortSortedMaps$Singleton.class */
    public static class Singleton extends Int2ShortMaps.Singleton implements Int2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntComparator comparator;

        protected Singleton(int key, short value, IntComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(int key, short value) {
            this(key, value, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSortedSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractInt2ShortMap.BasicEntry(this.key, this.value), Int2ShortSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Short>> entrySet() {
            return int2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap subMap(int from, int to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Int2ShortSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap headMap(int to) {
            return compare(this.key, to) < 0 ? this : Int2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap tailMap(int from) {
            return compare(from, this.key) <= 0 ? this : Int2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int firstIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int lastIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static Int2ShortSortedMap singleton(Integer key, Short value) {
        return new Singleton(key.intValue(), value.shortValue());
    }

    public static Int2ShortSortedMap singleton(Integer key, Short value, IntComparator comparator) {
        return new Singleton(key.intValue(), value.shortValue(), comparator);
    }

    public static Int2ShortSortedMap singleton(int key, short value) {
        return new Singleton(key, value);
    }

    public static Int2ShortSortedMap singleton(int key, short value, IntComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Int2ShortMaps.SynchronizedMap implements Int2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2ShortSortedMap sortedMap;

        protected SynchronizedSortedMap(Int2ShortSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Int2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSortedSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.int2ShortEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Short>> entrySet() {
            return int2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap subMap(int from, int to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap headMap(int to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap tailMap(int from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int firstIntKey() {
            int firstIntKey;
            synchronized (this.sync) {
                firstIntKey = this.sortedMap.firstIntKey();
            }
            return firstIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int lastIntKey() {
            int lastIntKey;
            synchronized (this.sync) {
                lastIntKey = this.sortedMap.lastIntKey();
            }
            return lastIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            Integer firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            Integer lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap subMap(Integer from, Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap headMap(Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap tailMap(Integer from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Int2ShortSortedMap synchronize(Int2ShortSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Int2ShortSortedMap synchronize(Int2ShortSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Int2ShortMaps.UnmodifiableMap implements Int2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2ShortSortedMap sortedMap;

        protected UnmodifiableSortedMap(Int2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSortedSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.int2ShortEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Short>> entrySet() {
            return int2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap subMap(int from, int to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap headMap(int to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public Int2ShortSortedMap tailMap(int from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int firstIntKey() {
            return this.sortedMap.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public int lastIntKey() {
            return this.sortedMap.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap subMap(Integer from, Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap headMap(Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        @Deprecated
        public Int2ShortSortedMap tailMap(Integer from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Int2ShortSortedMap unmodifiable(Int2ShortSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
