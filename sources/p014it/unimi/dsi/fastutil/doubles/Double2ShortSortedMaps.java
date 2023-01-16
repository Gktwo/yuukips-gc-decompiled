package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortSortedMaps.class */
public final class Double2ShortSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2ShortSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static ObjectBidirectionalIterator<Double2ShortMap.Entry> fastIterator(Double2ShortSortedMap map) {
        ObjectSortedSet<Double2ShortMap.Entry> entries = map.double2ShortEntrySet();
        return entries instanceof Double2ShortSortedMap.FastSortedEntrySet ? ((Double2ShortSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Double2ShortMap.Entry> fastIterable(Double2ShortSortedMap map) {
        ObjectSortedSet<Double2ShortMap.Entry> entries = map.double2ShortEntrySet();
        if (!(entries instanceof Double2ShortSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2ShortSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2ShortSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Double2ShortMaps.EmptyMap implements Double2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public ObjectSortedSet<Double2ShortMap.Entry> double2ShortEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Short>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap subMap(double from, double to) {
            return Double2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap headMap(double to) {
            return Double2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap tailMap(double from) {
            return Double2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortSortedMaps$Singleton.class */
    public static class Singleton extends Double2ShortMaps.Singleton implements Double2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, short value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, short value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public ObjectSortedSet<Double2ShortMap.Entry> double2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2ShortMap.BasicEntry(this.key, this.value), Double2ShortSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Short>> entrySet() {
            return double2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2ShortSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static Double2ShortSortedMap singleton(Double key, Short value) {
        return new Singleton(key.doubleValue(), value.shortValue());
    }

    public static Double2ShortSortedMap singleton(Double key, Short value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value.shortValue(), comparator);
    }

    public static Double2ShortSortedMap singleton(double key, short value) {
        return new Singleton(key, value);
    }

    public static Double2ShortSortedMap singleton(double key, short value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Double2ShortMaps.SynchronizedMap implements Double2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ShortSortedMap sortedMap;

        protected SynchronizedSortedMap(Double2ShortSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public ObjectSortedSet<Double2ShortMap.Entry> double2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2ShortEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Short>> entrySet() {
            return double2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Double2ShortSortedMap synchronize(Double2ShortSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Double2ShortSortedMap synchronize(Double2ShortSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ShortSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ShortSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Double2ShortMaps.UnmodifiableMap implements Double2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ShortSortedMap sortedMap;

        protected UnmodifiableSortedMap(Double2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public ObjectSortedSet<Double2ShortMap.Entry> double2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2ShortEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Short>> entrySet() {
            return double2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public Double2ShortSortedMap tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortSortedMap
        @Deprecated
        public Double2ShortSortedMap tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Double2ShortSortedMap unmodifiable(Double2ShortSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
