package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMaps;
import p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatSortedMaps.class */
public final class Int2FloatSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Int2FloatSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(IntComparator comparator) {
        return x, y -> {
            return comparator.compare(((Integer) x.getKey()).intValue(), ((Integer) y.getKey()).intValue());
        };
    }

    public static ObjectBidirectionalIterator<Int2FloatMap.Entry> fastIterator(Int2FloatSortedMap map) {
        ObjectSortedSet<Int2FloatMap.Entry> entries = map.int2FloatEntrySet();
        return entries instanceof Int2FloatSortedMap.FastSortedEntrySet ? ((Int2FloatSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Int2FloatMap.Entry> fastIterable(Int2FloatSortedMap map) {
        ObjectSortedSet<Int2FloatMap.Entry> entries = map.int2FloatEntrySet();
        if (!(entries instanceof Int2FloatSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Int2FloatSortedMap.FastSortedEntrySet fastSortedEntrySet = (Int2FloatSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Int2FloatMaps.EmptyMap implements Int2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public ObjectSortedSet<Int2FloatMap.Entry> int2FloatEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Float>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap subMap(int from, int to) {
            return Int2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap headMap(int to) {
            return Int2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap tailMap(int from) {
            return Int2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int firstIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int lastIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatSortedMaps$Singleton.class */
    public static class Singleton extends Int2FloatMaps.Singleton implements Int2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntComparator comparator;

        protected Singleton(int key, float value, IntComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(int key, float value) {
            this(key, value, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public ObjectSortedSet<Int2FloatMap.Entry> int2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractInt2FloatMap.BasicEntry(this.key, this.value), Int2FloatSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Float>> entrySet() {
            return int2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap subMap(int from, int to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Int2FloatSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap headMap(int to) {
            return compare(this.key, to) < 0 ? this : Int2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap tailMap(int from) {
            return compare(from, this.key) <= 0 ? this : Int2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int firstIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int lastIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static Int2FloatSortedMap singleton(Integer key, Float value) {
        return new Singleton(key.intValue(), value.floatValue());
    }

    public static Int2FloatSortedMap singleton(Integer key, Float value, IntComparator comparator) {
        return new Singleton(key.intValue(), value.floatValue(), comparator);
    }

    public static Int2FloatSortedMap singleton(int key, float value) {
        return new Singleton(key, value);
    }

    public static Int2FloatSortedMap singleton(int key, float value, IntComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Int2FloatMaps.SynchronizedMap implements Int2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2FloatSortedMap sortedMap;

        protected SynchronizedSortedMap(Int2FloatSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Int2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public ObjectSortedSet<Int2FloatMap.Entry> int2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.int2FloatEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Float>> entrySet() {
            return int2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap subMap(int from, int to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap headMap(int to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap tailMap(int from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int firstIntKey() {
            int firstIntKey;
            synchronized (this.sync) {
                firstIntKey = this.sortedMap.firstIntKey();
            }
            return firstIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int lastIntKey() {
            int lastIntKey;
            synchronized (this.sync) {
                lastIntKey = this.sortedMap.lastIntKey();
            }
            return lastIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            Integer firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            Integer lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap subMap(Integer from, Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap headMap(Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap tailMap(Integer from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Int2FloatSortedMap synchronize(Int2FloatSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Int2FloatSortedMap synchronize(Int2FloatSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2FloatSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2FloatSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Int2FloatMaps.UnmodifiableMap implements Int2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2FloatSortedMap sortedMap;

        protected UnmodifiableSortedMap(Int2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public ObjectSortedSet<Int2FloatMap.Entry> int2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.int2FloatEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Float>> entrySet() {
            return int2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2FloatMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap subMap(int from, int to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap headMap(int to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public Int2FloatSortedMap tailMap(int from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int firstIntKey() {
            return this.sortedMap.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        public int lastIntKey() {
            return this.sortedMap.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap subMap(Integer from, Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap headMap(Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatSortedMap
        @Deprecated
        public Int2FloatSortedMap tailMap(Integer from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Int2FloatSortedMap unmodifiable(Int2FloatSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
