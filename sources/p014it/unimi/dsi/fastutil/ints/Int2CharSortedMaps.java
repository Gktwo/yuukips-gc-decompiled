package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2CharMap;
import p014it.unimi.dsi.fastutil.ints.Int2CharMap;
import p014it.unimi.dsi.fastutil.ints.Int2CharMaps;
import p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2CharSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharSortedMaps.class */
public final class Int2CharSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Int2CharSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(IntComparator comparator) {
        return x, y -> {
            return comparator.compare(((Integer) x.getKey()).intValue(), ((Integer) y.getKey()).intValue());
        };
    }

    public static ObjectBidirectionalIterator<Int2CharMap.Entry> fastIterator(Int2CharSortedMap map) {
        ObjectSortedSet<Int2CharMap.Entry> entries = map.int2CharEntrySet();
        return entries instanceof Int2CharSortedMap.FastSortedEntrySet ? ((Int2CharSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Int2CharMap.Entry> fastIterable(Int2CharSortedMap map) {
        ObjectSortedSet<Int2CharMap.Entry> entries = map.int2CharEntrySet();
        if (!(entries instanceof Int2CharSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Int2CharSortedMap.FastSortedEntrySet fastSortedEntrySet = (Int2CharSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Int2CharMaps.EmptyMap implements Int2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public ObjectSortedSet<Int2CharMap.Entry> int2CharEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Character>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap subMap(int from, int to) {
            return Int2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap headMap(int to) {
            return Int2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap tailMap(int from) {
            return Int2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int firstIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int lastIntKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharSortedMaps$Singleton.class */
    public static class Singleton extends Int2CharMaps.Singleton implements Int2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntComparator comparator;

        protected Singleton(int key, char value, IntComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(int key, char value) {
            this(key, value, null);
        }

        final int compare(int k1, int k2) {
            return this.comparator == null ? Integer.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public ObjectSortedSet<Int2CharMap.Entry> int2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractInt2CharMap.BasicEntry(this.key, this.value), Int2CharSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Character>> entrySet() {
            return int2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.Singleton, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap subMap(int from, int to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Int2CharSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap headMap(int to) {
            return compare(this.key, to) < 0 ? this : Int2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap tailMap(int from) {
            return compare(from, this.key) <= 0 ? this : Int2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int firstIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int lastIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap headMap(Integer oto) {
            return headMap(oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap tailMap(Integer ofrom) {
            return tailMap(ofrom.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap subMap(Integer ofrom, Integer oto) {
            return subMap(ofrom.intValue(), oto.intValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return Integer.valueOf(firstIntKey());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return Integer.valueOf(lastIntKey());
        }
    }

    public static Int2CharSortedMap singleton(Integer key, Character value) {
        return new Singleton(key.intValue(), value.charValue());
    }

    public static Int2CharSortedMap singleton(Integer key, Character value, IntComparator comparator) {
        return new Singleton(key.intValue(), value.charValue(), comparator);
    }

    public static Int2CharSortedMap singleton(int key, char value) {
        return new Singleton(key, value);
    }

    public static Int2CharSortedMap singleton(int key, char value, IntComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Int2CharMaps.SynchronizedMap implements Int2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2CharSortedMap sortedMap;

        protected SynchronizedSortedMap(Int2CharSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Int2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            Comparator<? super Integer> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public ObjectSortedSet<Int2CharMap.Entry> int2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.int2CharEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Character>> entrySet() {
            return int2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap subMap(int from, int to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap headMap(int to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap tailMap(int from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int firstIntKey() {
            int firstIntKey;
            synchronized (this.sync) {
                firstIntKey = this.sortedMap.firstIntKey();
            }
            return firstIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int lastIntKey() {
            int lastIntKey;
            synchronized (this.sync) {
                lastIntKey = this.sortedMap.lastIntKey();
            }
            return lastIntKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            Integer firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            Integer lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap subMap(Integer from, Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap headMap(Integer to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap tailMap(Integer from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Int2CharSortedMap synchronize(Int2CharSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Int2CharSortedMap synchronize(Int2CharSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Int2CharMaps.UnmodifiableMap implements Int2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2CharSortedMap sortedMap;

        protected UnmodifiableSortedMap(Int2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public ObjectSortedSet<Int2CharMap.Entry> int2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.int2CharEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Integer, Character>> entrySet() {
            return int2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (IntSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap subMap(int from, int to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap headMap(int to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public Int2CharSortedMap tailMap(int from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int firstIntKey() {
            return this.sortedMap.firstIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        public int lastIntKey() {
            return this.sortedMap.lastIntKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Integer lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap subMap(Integer from, Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap headMap(Integer to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
        @Deprecated
        public Int2CharSortedMap tailMap(Integer from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Int2CharSortedMap unmodifiable(Int2CharSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
