package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanSortedMaps.class */
public final class Double2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2BooleanSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static ObjectBidirectionalIterator<Double2BooleanMap.Entry> fastIterator(Double2BooleanSortedMap map) {
        ObjectSortedSet<Double2BooleanMap.Entry> entries = map.double2BooleanEntrySet();
        return entries instanceof Double2BooleanSortedMap.FastSortedEntrySet ? ((Double2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Double2BooleanMap.Entry> fastIterable(Double2BooleanSortedMap map) {
        ObjectSortedSet<Double2BooleanMap.Entry> entries = map.double2BooleanEntrySet();
        if (!(entries instanceof Double2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Double2BooleanMaps.EmptyMap implements Double2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public ObjectSortedSet<Double2BooleanMap.Entry> double2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap subMap(double from, double to) {
            return Double2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap headMap(double to) {
            return Double2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap tailMap(double from) {
            return Double2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanSortedMaps$Singleton.class */
    public static class Singleton extends Double2BooleanMaps.Singleton implements Double2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, boolean value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, boolean value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public ObjectSortedSet<Double2BooleanMap.Entry> double2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2BooleanMap.BasicEntry(this.key, this.value), Double2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Boolean>> entrySet() {
            return double2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2BooleanSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static Double2BooleanSortedMap singleton(Double key, Boolean value) {
        return new Singleton(key.doubleValue(), value.booleanValue());
    }

    public static Double2BooleanSortedMap singleton(Double key, Boolean value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value.booleanValue(), comparator);
    }

    public static Double2BooleanSortedMap singleton(double key, boolean value) {
        return new Singleton(key, value);
    }

    public static Double2BooleanSortedMap singleton(double key, boolean value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Double2BooleanMaps.SynchronizedMap implements Double2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2BooleanSortedMap sortedMap;

        protected SynchronizedSortedMap(Double2BooleanSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public ObjectSortedSet<Double2BooleanMap.Entry> double2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Boolean>> entrySet() {
            return double2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Double2BooleanSortedMap synchronize(Double2BooleanSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Double2BooleanSortedMap synchronize(Double2BooleanSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Double2BooleanMaps.UnmodifiableMap implements Double2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2BooleanSortedMap sortedMap;

        protected UnmodifiableSortedMap(Double2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public ObjectSortedSet<Double2BooleanMap.Entry> double2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Boolean>> entrySet() {
            return double2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public Double2BooleanSortedMap tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanSortedMap
        @Deprecated
        public Double2BooleanSortedMap tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Double2BooleanSortedMap unmodifiable(Double2BooleanSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
