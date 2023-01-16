package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap;
import p014it.unimi.dsi.fastutil.doubles.Double2CharMap;
import p014it.unimi.dsi.fastutil.doubles.Double2CharMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharSortedMaps.class */
public final class Double2CharSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2CharSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static ObjectBidirectionalIterator<Double2CharMap.Entry> fastIterator(Double2CharSortedMap map) {
        ObjectSortedSet<Double2CharMap.Entry> entries = map.double2CharEntrySet();
        return entries instanceof Double2CharSortedMap.FastSortedEntrySet ? ((Double2CharSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Double2CharMap.Entry> fastIterable(Double2CharSortedMap map) {
        ObjectSortedSet<Double2CharMap.Entry> entries = map.double2CharEntrySet();
        if (!(entries instanceof Double2CharSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2CharSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2CharSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Double2CharMaps.EmptyMap implements Double2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public ObjectSortedSet<Double2CharMap.Entry> double2CharEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Character>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap subMap(double from, double to) {
            return Double2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap headMap(double to) {
            return Double2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap tailMap(double from) {
            return Double2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharSortedMaps$Singleton.class */
    public static class Singleton extends Double2CharMaps.Singleton implements Double2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, char value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, char value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public ObjectSortedSet<Double2CharMap.Entry> double2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2CharMap.BasicEntry(this.key, this.value), Double2CharSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Character>> entrySet() {
            return double2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2CharSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static Double2CharSortedMap singleton(Double key, Character value) {
        return new Singleton(key.doubleValue(), value.charValue());
    }

    public static Double2CharSortedMap singleton(Double key, Character value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value.charValue(), comparator);
    }

    public static Double2CharSortedMap singleton(double key, char value) {
        return new Singleton(key, value);
    }

    public static Double2CharSortedMap singleton(double key, char value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Double2CharMaps.SynchronizedMap implements Double2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2CharSortedMap sortedMap;

        protected SynchronizedSortedMap(Double2CharSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public ObjectSortedSet<Double2CharMap.Entry> double2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2CharEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Character>> entrySet() {
            return double2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Double2CharSortedMap synchronize(Double2CharSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Double2CharSortedMap synchronize(Double2CharSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Double2CharMaps.UnmodifiableMap implements Double2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2CharSortedMap sortedMap;

        protected UnmodifiableSortedMap(Double2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public ObjectSortedSet<Double2CharMap.Entry> double2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2CharEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, Character>> entrySet() {
            return double2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public Double2CharSortedMap tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
        @Deprecated
        public Double2CharSortedMap tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Double2CharSortedMap unmodifiable(Double2CharSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
