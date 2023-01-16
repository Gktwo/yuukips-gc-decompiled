package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2DoubleSortedMaps.class */
public final class Double2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2DoubleSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static ObjectBidirectionalIterator<Double2DoubleMap.Entry> fastIterator(Double2DoubleSortedMap map) {
        ObjectSortedSet<Double2DoubleMap.Entry> entries = map.double2DoubleEntrySet();
        return entries instanceof Double2DoubleSortedMap.FastSortedEntrySet ? ((Double2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Double2DoubleMap.Entry> fastIterable(Double2DoubleSortedMap map) {
        ObjectSortedSet<Double2DoubleMap.Entry> entries = map.double2DoubleEntrySet();
        if (!(entries instanceof Double2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Double2DoubleMaps.EmptyMap implements Double2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public ObjectSortedSet<Double2DoubleMap.Entry> double2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap subMap(double from, double to) {
            return Double2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap headMap(double to) {
            return Double2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap tailMap(double from) {
            return Double2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2DoubleSortedMaps$Singleton.class */
    public static class Singleton extends Double2DoubleMaps.Singleton implements Double2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, double value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, double value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public ObjectSortedSet<Double2DoubleMap.Entry> double2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2DoubleMap.BasicEntry(this.key, this.value), Double2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Double>> entrySet() {
            return double2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2DoubleSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static Double2DoubleSortedMap singleton(Double key, Double value) {
        return new Singleton(key.doubleValue(), value.doubleValue());
    }

    public static Double2DoubleSortedMap singleton(Double key, Double value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value.doubleValue(), comparator);
    }

    public static Double2DoubleSortedMap singleton(double key, double value) {
        return new Singleton(key, value);
    }

    public static Double2DoubleSortedMap singleton(double key, double value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Double2DoubleMaps.SynchronizedMap implements Double2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2DoubleSortedMap sortedMap;

        protected SynchronizedSortedMap(Double2DoubleSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public ObjectSortedSet<Double2DoubleMap.Entry> double2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Double>> entrySet() {
            return double2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Double2DoubleSortedMap synchronize(Double2DoubleSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Double2DoubleSortedMap synchronize(Double2DoubleSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Double2DoubleMaps.UnmodifiableMap implements Double2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2DoubleSortedMap sortedMap;

        protected UnmodifiableSortedMap(Double2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public ObjectSortedSet<Double2DoubleMap.Entry> double2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Double>> entrySet() {
            return double2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public Double2DoubleSortedMap tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleSortedMap
        @Deprecated
        public Double2DoubleSortedMap tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Double2DoubleSortedMap unmodifiable(Double2DoubleSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
