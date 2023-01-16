package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceSortedMaps.class */
public final class Float2ReferenceSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2ReferenceSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Float2ReferenceMap.Entry<V>> fastIterator(Float2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Float2ReferenceMap.Entry<V>> entries = map.float2ReferenceEntrySet();
        return entries instanceof Float2ReferenceSortedMap.FastSortedEntrySet ? ((Float2ReferenceSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Float2ReferenceMap.Entry<V>> fastIterable(Float2ReferenceSortedMap<V> map) {
        ObjectSortedSet<Float2ReferenceMap.Entry<V>> entries = map.float2ReferenceEntrySet();
        if (!(entries instanceof Float2ReferenceSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2ReferenceSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2ReferenceSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Float2ReferenceMaps.EmptyMap<V> implements Float2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSortedSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> subMap(float from, float to) {
            return Float2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> headMap(float to) {
            return Float2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> tailMap(float from) {
            return Float2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static <V> Float2ReferenceSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceSortedMaps$Singleton.class */
    public static class Singleton<V> extends Float2ReferenceMaps.Singleton<V> implements Float2ReferenceSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, V value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, V value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSortedSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2ReferenceMap.BasicEntry(this.key, this.value), Float2ReferenceSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return float2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2ReferenceSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2ReferenceSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static <V> Float2ReferenceSortedMap<V> singleton(Float key, V value) {
        return new Singleton(key.floatValue(), value);
    }

    public static <V> Float2ReferenceSortedMap<V> singleton(Float key, V value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value, comparator);
    }

    public static <V> Float2ReferenceSortedMap<V> singleton(float key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Float2ReferenceSortedMap<V> singleton(float key, V value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Float2ReferenceMaps.SynchronizedMap<V> implements Float2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ReferenceSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Float2ReferenceSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2ReferenceSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSortedSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2ReferenceEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return float2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Float2ReferenceSortedMap<V> synchronize(Float2ReferenceSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Float2ReferenceSortedMap<V> synchronize(Float2ReferenceSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Float2ReferenceMaps.UnmodifiableMap<V> implements Float2ReferenceSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ReferenceSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Float2ReferenceSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSortedSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2ReferenceEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return float2ReferenceEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public Float2ReferenceSortedMap<V> tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        @Deprecated
        public Float2ReferenceSortedMap<V> tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Float2ReferenceSortedMap<V> unmodifiable(Float2ReferenceSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
