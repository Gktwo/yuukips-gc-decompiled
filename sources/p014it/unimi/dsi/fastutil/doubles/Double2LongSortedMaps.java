package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2LongMap;
import p014it.unimi.dsi.fastutil.doubles.Double2LongMap;
import p014it.unimi.dsi.fastutil.doubles.Double2LongMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongSortedMaps.class */
public final class Double2LongSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2LongSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static ObjectBidirectionalIterator<Double2LongMap.Entry> fastIterator(Double2LongSortedMap map) {
        ObjectSortedSet<Double2LongMap.Entry> entries = map.double2LongEntrySet();
        return entries instanceof Double2LongSortedMap.FastSortedEntrySet ? ((Double2LongSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Double2LongMap.Entry> fastIterable(Double2LongSortedMap map) {
        ObjectSortedSet<Double2LongMap.Entry> entries = map.double2LongEntrySet();
        if (!(entries instanceof Double2LongSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2LongSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2LongSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Double2LongMaps.EmptyMap implements Double2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public ObjectSortedSet<Double2LongMap.Entry> double2LongEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Long>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap subMap(double from, double to) {
            return Double2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap headMap(double to) {
            return Double2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap tailMap(double from) {
            return Double2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongSortedMaps$Singleton.class */
    public static class Singleton extends Double2LongMaps.Singleton implements Double2LongSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, long value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, long value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public ObjectSortedSet<Double2LongMap.Entry> double2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2LongMap.BasicEntry(this.key, this.value), Double2LongSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Long>> entrySet() {
            return double2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2LongSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2LongSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static Double2LongSortedMap singleton(Double key, Long value) {
        return new Singleton(key.doubleValue(), value.longValue());
    }

    public static Double2LongSortedMap singleton(Double key, Long value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value.longValue(), comparator);
    }

    public static Double2LongSortedMap singleton(double key, long value) {
        return new Singleton(key, value);
    }

    public static Double2LongSortedMap singleton(double key, long value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Double2LongMaps.SynchronizedMap implements Double2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2LongSortedMap sortedMap;

        protected SynchronizedSortedMap(Double2LongSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public ObjectSortedSet<Double2LongMap.Entry> double2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2LongEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Long>> entrySet() {
            return double2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Double2LongSortedMap synchronize(Double2LongSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Double2LongSortedMap synchronize(Double2LongSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2LongSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2LongSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Double2LongMaps.UnmodifiableMap implements Double2LongSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2LongSortedMap sortedMap;

        protected UnmodifiableSortedMap(Double2LongSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public ObjectSortedSet<Double2LongMap.Entry> double2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2LongEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Long>> entrySet() {
            return double2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2LongMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public Double2LongSortedMap tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongSortedMap
        @Deprecated
        public Double2LongSortedMap tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Double2LongSortedMap unmodifiable(Double2LongSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
