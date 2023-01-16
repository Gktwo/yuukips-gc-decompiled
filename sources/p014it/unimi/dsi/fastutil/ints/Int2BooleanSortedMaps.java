package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanSortedMaps.class */
public final class Int2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Int2BooleanSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(IntComparator comparator) {
        return x, y -> {
            return comparator.compare(((Integer) x.getKey()).intValue(), ((Integer) y.getKey()).intValue());
        };
    }

    public static ObjectBidirectionalIterator<Int2BooleanMap.Entry> fastIterator(Int2BooleanSortedMap map) {
        ObjectSortedSet<Int2BooleanMap.Entry> entries = map.int2BooleanEntrySet();
        return entries instanceof Int2BooleanSortedMap.FastSortedEntrySet ? ((Int2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Int2BooleanMap.Entry> fastIterable(Int2BooleanSortedMap map) {
        ObjectSortedSet<Int2BooleanMap.Entry> entries = map.int2BooleanEntrySet();
        if (!(entries instanceof Int2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Int2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Int2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Int2BooleanMaps.EmptyMap implements Int2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public ObjectSortedSet<Int2BooleanMap.Entry> int2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap subMap(int from, int to) {
            return Int2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap headMap(int to) {
            return Int2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap tailMap(int from) {
            return Int2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int firstIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int lastIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanSortedMaps$Singleton.class */
    public static class Singleton extends Int2BooleanMaps.Singleton implements Int2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntComparator comparator;

        protected Singleton(int key, boolean value, IntComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(int key, boolean value) {
            this(key, value, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public ObjectSortedSet<Int2BooleanMap.Entry> int2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractInt2BooleanMap.BasicEntry(this.key, this.value), Int2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Boolean>> entrySet() {
            return int2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap subMap(int from, int to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Int2BooleanSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap headMap(int to) {
            return compare(this.key, to) < 0 ? this : Int2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap tailMap(int from) {
            return compare(from, this.key) <= 0 ? this : Int2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int firstIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int lastIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static Int2BooleanSortedMap singleton(Integer key, Boolean value) {
        return new Singleton(key.intValue(), value.booleanValue());
    }

    public static Int2BooleanSortedMap singleton(Integer key, Boolean value, IntComparator comparator) {
        return new Singleton(key.intValue(), value.booleanValue(), comparator);
    }

    public static Int2BooleanSortedMap singleton(int key, boolean value) {
        return new Singleton(key, value);
    }

    public static Int2BooleanSortedMap singleton(int key, boolean value, IntComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Int2BooleanMaps.SynchronizedMap implements Int2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2BooleanSortedMap sortedMap;

        protected SynchronizedSortedMap(Int2BooleanSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Int2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public ObjectSortedSet<Int2BooleanMap.Entry> int2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.int2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Boolean>> entrySet() {
            return int2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap subMap(int from, int to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap headMap(int to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap tailMap(int from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int firstIntKey() {
            int firstIntKey;
            synchronized (this.sync) {
                firstIntKey = this.sortedMap.firstIntKey();
            }
            return firstIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int lastIntKey() {
            int lastIntKey;
            synchronized (this.sync) {
                lastIntKey = this.sortedMap.lastIntKey();
            }
            return lastIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            Integer firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            Integer lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap subMap(Integer from, Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap headMap(Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap tailMap(Integer from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Int2BooleanSortedMap synchronize(Int2BooleanSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Int2BooleanSortedMap synchronize(Int2BooleanSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Int2BooleanMaps.UnmodifiableMap implements Int2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2BooleanSortedMap sortedMap;

        protected UnmodifiableSortedMap(Int2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public ObjectSortedSet<Int2BooleanMap.Entry> int2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.int2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Boolean>> entrySet() {
            return int2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap subMap(int from, int to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap headMap(int to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public Int2BooleanSortedMap tailMap(int from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int firstIntKey() {
            return this.sortedMap.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        public int lastIntKey() {
            return this.sortedMap.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap subMap(Integer from, Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap headMap(Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
        @Deprecated
        public Int2BooleanSortedMap tailMap(Integer from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Int2BooleanSortedMap unmodifiable(Int2BooleanSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
