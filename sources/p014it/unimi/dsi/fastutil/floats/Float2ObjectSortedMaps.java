package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectSortedMaps.class */
public final class Float2ObjectSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2ObjectSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static <V> ObjectBidirectionalIterator<Float2ObjectMap.Entry<V>> fastIterator(Float2ObjectSortedMap<V> map) {
        ObjectSortedSet<Float2ObjectMap.Entry<V>> entries = map.float2ObjectEntrySet();
        return entries instanceof Float2ObjectSortedMap.FastSortedEntrySet ? ((Float2ObjectSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> ObjectBidirectionalIterable<Float2ObjectMap.Entry<V>> fastIterable(Float2ObjectSortedMap<V> map) {
        ObjectSortedSet<Float2ObjectMap.Entry<V>> entries = map.float2ObjectEntrySet();
        if (!(entries instanceof Float2ObjectSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2ObjectSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2ObjectSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap<V> extends Float2ObjectMaps.EmptyMap<V> implements Float2ObjectSortedMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSortedSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> subMap(float from, float to) {
            return Float2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> headMap(float to) {
            return Float2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> tailMap(float from) {
            return Float2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static <V> Float2ObjectSortedMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectSortedMaps$Singleton.class */
    public static class Singleton<V> extends Float2ObjectMaps.Singleton<V> implements Float2ObjectSortedMap<V>, Serializable, Cloneable {
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
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSortedSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2ObjectMap.BasicEntry(this.key, this.value), Float2ObjectSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return float2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2ObjectSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2ObjectSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static <V> Float2ObjectSortedMap<V> singleton(Float key, V value) {
        return new Singleton(key.floatValue(), value);
    }

    public static <V> Float2ObjectSortedMap<V> singleton(Float key, V value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value, comparator);
    }

    public static <V> Float2ObjectSortedMap<V> singleton(float key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Float2ObjectSortedMap<V> singleton(float key, V value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap<V> extends Float2ObjectMaps.SynchronizedMap<V> implements Float2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ObjectSortedMap<V> sortedMap;

        protected SynchronizedSortedMap(Float2ObjectSortedMap<V> m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2ObjectSortedMap<V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSortedSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2ObjectEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return float2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static <V> Float2ObjectSortedMap<V> synchronize(Float2ObjectSortedMap<V> m) {
        return new SynchronizedSortedMap(m);
    }

    public static <V> Float2ObjectSortedMap<V> synchronize(Float2ObjectSortedMap<V> m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap<V> extends Float2ObjectMaps.UnmodifiableMap<V> implements Float2ObjectSortedMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ObjectSortedMap<? extends V> sortedMap;

        protected UnmodifiableSortedMap(Float2ObjectSortedMap<? extends V> m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSortedSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2ObjectEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, V>> entrySet() {
            return float2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public Float2ObjectSortedMap<V> tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        @Deprecated
        public Float2ObjectSortedMap<V> tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static <V> Float2ObjectSortedMap<V> unmodifiable(Float2ObjectSortedMap<? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }
}
