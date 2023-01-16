package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ByteMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteSortedMaps.class */
public final class Double2ByteSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2ByteSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static ObjectBidirectionalIterator<Double2ByteMap.Entry> fastIterator(Double2ByteSortedMap map) {
        ObjectSortedSet<Double2ByteMap.Entry> entries = map.double2ByteEntrySet();
        return entries instanceof Double2ByteSortedMap.FastSortedEntrySet ? ((Double2ByteSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Double2ByteMap.Entry> fastIterable(Double2ByteSortedMap map) {
        ObjectSortedSet<Double2ByteMap.Entry> entries = map.double2ByteEntrySet();
        if (!(entries instanceof Double2ByteSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2ByteSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2ByteSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Double2ByteMaps.EmptyMap implements Double2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public ObjectSortedSet<Double2ByteMap.Entry> double2ByteEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Byte>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap subMap(double from, double to) {
            return Double2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap headMap(double to) {
            return Double2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap tailMap(double from) {
            return Double2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteSortedMaps$Singleton.class */
    public static class Singleton extends Double2ByteMaps.Singleton implements Double2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, byte value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, byte value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public ObjectSortedSet<Double2ByteMap.Entry> double2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2ByteMap.BasicEntry(this.key, this.value), Double2ByteSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Byte>> entrySet() {
            return double2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2ByteSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static Double2ByteSortedMap singleton(Double key, Byte value) {
        return new Singleton(key.doubleValue(), value.byteValue());
    }

    public static Double2ByteSortedMap singleton(Double key, Byte value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value.byteValue(), comparator);
    }

    public static Double2ByteSortedMap singleton(double key, byte value) {
        return new Singleton(key, value);
    }

    public static Double2ByteSortedMap singleton(double key, byte value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Double2ByteMaps.SynchronizedMap implements Double2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ByteSortedMap sortedMap;

        protected SynchronizedSortedMap(Double2ByteSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public ObjectSortedSet<Double2ByteMap.Entry> double2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2ByteEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Byte>> entrySet() {
            return double2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Double2ByteSortedMap synchronize(Double2ByteSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Double2ByteSortedMap synchronize(Double2ByteSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Double2ByteMaps.UnmodifiableMap implements Double2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ByteSortedMap sortedMap;

        protected UnmodifiableSortedMap(Double2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public ObjectSortedSet<Double2ByteMap.Entry> double2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2ByteEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Byte>> entrySet() {
            return double2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ByteMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public Double2ByteSortedMap tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
        @Deprecated
        public Double2ByteSortedMap tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Double2ByteSortedMap unmodifiable(Double2ByteSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
