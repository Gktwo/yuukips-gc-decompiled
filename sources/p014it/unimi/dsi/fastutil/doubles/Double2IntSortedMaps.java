package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap;
import p014it.unimi.dsi.fastutil.doubles.Double2IntMap;
import p014it.unimi.dsi.fastutil.doubles.Double2IntMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntSortedMaps.class */
public final class Double2IntSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2IntSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static ObjectBidirectionalIterator<Double2IntMap.Entry> fastIterator(Double2IntSortedMap map) {
        ObjectSortedSet<Double2IntMap.Entry> entries = map.double2IntEntrySet();
        return entries instanceof Double2IntSortedMap.FastSortedEntrySet ? ((Double2IntSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Double2IntMap.Entry> fastIterable(Double2IntSortedMap map) {
        ObjectSortedSet<Double2IntMap.Entry> entries = map.double2IntEntrySet();
        if (!(entries instanceof Double2IntSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2IntSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2IntSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Double2IntMaps.EmptyMap implements Double2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public ObjectSortedSet<Double2IntMap.Entry> double2IntEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Integer>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap subMap(double from, double to) {
            return Double2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap headMap(double to) {
            return Double2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap tailMap(double from) {
            return Double2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntSortedMaps$Singleton.class */
    public static class Singleton extends Double2IntMaps.Singleton implements Double2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, int value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, int value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public ObjectSortedSet<Double2IntMap.Entry> double2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2IntMap.BasicEntry(this.key, this.value), Double2IntSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Integer>> entrySet() {
            return double2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2IntSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static Double2IntSortedMap singleton(Double key, Integer value) {
        return new Singleton(key.doubleValue(), value.intValue());
    }

    public static Double2IntSortedMap singleton(Double key, Integer value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value.intValue(), comparator);
    }

    public static Double2IntSortedMap singleton(double key, int value) {
        return new Singleton(key, value);
    }

    public static Double2IntSortedMap singleton(double key, int value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Double2IntMaps.SynchronizedMap implements Double2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2IntSortedMap sortedMap;

        protected SynchronizedSortedMap(Double2IntSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public ObjectSortedSet<Double2IntMap.Entry> double2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2IntEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Integer>> entrySet() {
            return double2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Double2IntSortedMap synchronize(Double2IntSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Double2IntSortedMap synchronize(Double2IntSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2IntSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2IntSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Double2IntMaps.UnmodifiableMap implements Double2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2IntSortedMap sortedMap;

        protected UnmodifiableSortedMap(Double2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public ObjectSortedSet<Double2IntMap.Entry> double2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2IntEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Integer>> entrySet() {
            return double2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public Double2IntSortedMap tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntSortedMap
        @Deprecated
        public Double2IntSortedMap tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Double2IntSortedMap unmodifiable(Double2IntSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
