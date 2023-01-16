package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ObjectMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectSortedMaps.class */
public final class Double2ObjectSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Double2ObjectSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Double, ?>> entryComparator(DoubleComparator comparator) {
        return x, y -> {
            return comparator.compare(((Double) x.getKey()).doubleValue(), ((Double) y.getKey()).doubleValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Double2ObjectMap.Entry<V>> fastIterator(Double2ObjectSortedMap<V> map) {
        ObjectSortedSet<Double2ObjectMap.Entry<V>> entries = map.double2ObjectEntrySet();
        return entries instanceof Double2ObjectSortedMap.FastSortedEntrySet ? ((Double2ObjectSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Double2ObjectMap.Entry<V>> fastIterable(Double2ObjectSortedMap<V> map) {
        ObjectSortedSet<Double2ObjectMap.Entry<V>> entries = map.double2ObjectEntrySet();
        if (!(entries instanceof Double2ObjectSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Double2ObjectSortedMap.FastSortedEntrySet fastSortedEntrySet = (Double2ObjectSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Double2ObjectMaps.EmptyMap<V> implements Double2ObjectSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSortedSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public DoubleSortedSet keySet() {
            return DoubleSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> subMap(double from, double to) {
            return Double2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> headMap(double to) {
            return Double2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> tailMap(double from) {
            return Double2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double firstDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double lastDoubleKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static <V> Double2ObjectSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectSortedMaps$Singleton.class */
    public static class Singleton<V> extends Double2ObjectMaps.Singleton<V> implements Double2ObjectSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final DoubleComparator comparator;

        protected Singleton(double key, V value, DoubleComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(double key, V value) {
            this(key, value, null);
        }

        final int compare(double k1, double k2) {
            return this.comparator == null ? Double.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSortedSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractDouble2ObjectMap.BasicEntry(this.key, this.value), Double2ObjectSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, V>> entrySet() {
            return double2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.singleton(this.key, this.comparator);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> subMap(double from, double to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Double2ObjectSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> headMap(double to) {
            return compare(this.key, to) < 0 ? this : Double2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> tailMap(double from) {
            return compare(from, this.key) <= 0 ? this : Double2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double firstDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double lastDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> headMap(Double oto) {
            return headMap(oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> tailMap(Double ofrom) {
            return tailMap(ofrom.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> subMap(Double ofrom, Double oto) {
            return subMap(ofrom.doubleValue(), oto.doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return Double.valueOf(firstDoubleKey());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return Double.valueOf(lastDoubleKey());
        }
    }

    public static <V> Double2ObjectSortedMap<V> singleton(Double key, V value) {
        return new Singleton(key.doubleValue(), value);
    }

    public static <V> Double2ObjectSortedMap<V> singleton(Double key, V value, DoubleComparator comparator) {
        return new Singleton(key.doubleValue(), value, comparator);
    }

    public static <V> Double2ObjectSortedMap<V> singleton(double key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Double2ObjectSortedMap<V> singleton(double key, V value, DoubleComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Double2ObjectMaps.SynchronizedMap<V> implements Double2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ObjectSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Double2ObjectSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Double2ObjectSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            Comparator<? super Double> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSortedSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.double2ObjectEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, V>> entrySet() {
            return double2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> subMap(double from, double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> headMap(double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> tailMap(double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double firstDoubleKey() {
            double firstDoubleKey;
            synchronized (this.sync) {
                firstDoubleKey = this.sortedMap.firstDoubleKey();
            }
            return firstDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double lastDoubleKey() {
            double lastDoubleKey;
            synchronized (this.sync) {
                lastDoubleKey = this.sortedMap.lastDoubleKey();
            }
            return lastDoubleKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            Double firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            Double lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> subMap(Double from, Double to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> headMap(Double to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> tailMap(Double from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Double2ObjectSortedMap<V> synchronize(Double2ObjectSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Double2ObjectSortedMap<V> synchronize(Double2ObjectSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Double2ObjectMaps.UnmodifiableMap<V> implements Double2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ObjectSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Double2ObjectSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Double> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSortedSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.double2ObjectEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Double, V>> entrySet() {
            return double2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public DoubleSortedSet keySet() {
            if (this.keys == null) {
                this.keys = DoubleSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (DoubleSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> subMap(double from, double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> headMap(double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public Double2ObjectSortedMap<V> tailMap(double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double firstDoubleKey() {
            return this.sortedMap.firstDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public double lastDoubleKey() {
            return this.sortedMap.lastDoubleKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Double lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> subMap(Double from, Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> headMap(Double to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        @Deprecated
        public Double2ObjectSortedMap<V> tailMap(Double from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Double2ObjectSortedMap<V> unmodifiable(Double2ObjectSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
