package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleMap;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleSortedMaps.class */
public final class Float2DoubleSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2DoubleSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static ObjectBidirectionalIterator<Float2DoubleMap.Entry> fastIterator(Float2DoubleSortedMap map) {
        ObjectSortedSet<Float2DoubleMap.Entry> entries = map.float2DoubleEntrySet();
        return entries instanceof Float2DoubleSortedMap.FastSortedEntrySet ? ((Float2DoubleSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Float2DoubleMap.Entry> fastIterable(Float2DoubleSortedMap map) {
        ObjectSortedSet<Float2DoubleMap.Entry> entries = map.float2DoubleEntrySet();
        if (!(entries instanceof Float2DoubleSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2DoubleSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2DoubleSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Float2DoubleMaps.EmptyMap implements Float2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSortedSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Double>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap subMap(float from, float to) {
            return Float2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap headMap(float to) {
            return Float2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap tailMap(float from) {
            return Float2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleSortedMaps$Singleton.class */
    public static class Singleton extends Float2DoubleMaps.Singleton implements Float2DoubleSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, double value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, double value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSortedSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2DoubleMap.BasicEntry(this.key, this.value), Float2DoubleSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Double>> entrySet() {
            return float2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2DoubleSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2DoubleSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static Float2DoubleSortedMap singleton(Float key, Double value) {
        return new Singleton(key.floatValue(), value.doubleValue());
    }

    public static Float2DoubleSortedMap singleton(Float key, Double value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value.doubleValue(), comparator);
    }

    public static Float2DoubleSortedMap singleton(float key, double value) {
        return new Singleton(key, value);
    }

    public static Float2DoubleSortedMap singleton(float key, double value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Float2DoubleMaps.SynchronizedMap implements Float2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2DoubleSortedMap sortedMap;

        protected SynchronizedSortedMap(Float2DoubleSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSortedSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2DoubleEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Double>> entrySet() {
            return float2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Float2DoubleSortedMap synchronize(Float2DoubleSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Float2DoubleSortedMap synchronize(Float2DoubleSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Float2DoubleMaps.UnmodifiableMap implements Float2DoubleSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2DoubleSortedMap sortedMap;

        protected UnmodifiableSortedMap(Float2DoubleSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSortedSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2DoubleEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Double>> entrySet() {
            return float2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public Float2DoubleSortedMap tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        @Deprecated
        public Float2DoubleSortedMap tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Float2DoubleSortedMap unmodifiable(Float2DoubleSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
