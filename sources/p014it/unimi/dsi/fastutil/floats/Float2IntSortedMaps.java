package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2IntMap;
import p014it.unimi.dsi.fastutil.floats.Float2IntMap;
import p014it.unimi.dsi.fastutil.floats.Float2IntMaps;
import p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2IntSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntSortedMaps.class */
public final class Float2IntSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2IntSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static ObjectBidirectionalIterator<Float2IntMap.Entry> fastIterator(Float2IntSortedMap map) {
        ObjectSortedSet<Float2IntMap.Entry> entries = map.float2IntEntrySet();
        return entries instanceof Float2IntSortedMap.FastSortedEntrySet ? ((Float2IntSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Float2IntMap.Entry> fastIterable(Float2IntSortedMap map) {
        ObjectSortedSet<Float2IntMap.Entry> entries = map.float2IntEntrySet();
        if (!(entries instanceof Float2IntSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2IntSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2IntSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Float2IntMaps.EmptyMap implements Float2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public ObjectSortedSet<Float2IntMap.Entry> float2IntEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Integer>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap subMap(float from, float to) {
            return Float2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap headMap(float to) {
            return Float2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap tailMap(float from) {
            return Float2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntSortedMaps$Singleton.class */
    public static class Singleton extends Float2IntMaps.Singleton implements Float2IntSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, int value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, int value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2IntMap, p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public ObjectSortedSet<Float2IntMap.Entry> float2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2IntMap.BasicEntry(this.key, this.value), Float2IntSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Integer>> entrySet() {
            return float2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2IntSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2IntSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static Float2IntSortedMap singleton(Float key, Integer value) {
        return new Singleton(key.floatValue(), value.intValue());
    }

    public static Float2IntSortedMap singleton(Float key, Integer value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value.intValue(), comparator);
    }

    public static Float2IntSortedMap singleton(float key, int value) {
        return new Singleton(key, value);
    }

    public static Float2IntSortedMap singleton(float key, int value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Float2IntMaps.SynchronizedMap implements Float2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2IntSortedMap sortedMap;

        protected SynchronizedSortedMap(Float2IntSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public ObjectSortedSet<Float2IntMap.Entry> float2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2IntEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Integer>> entrySet() {
            return float2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Float2IntSortedMap synchronize(Float2IntSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Float2IntSortedMap synchronize(Float2IntSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Float2IntMaps.UnmodifiableMap implements Float2IntSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2IntSortedMap sortedMap;

        protected UnmodifiableSortedMap(Float2IntSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public ObjectSortedSet<Float2IntMap.Entry> float2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2IntEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Integer>> entrySet() {
            return float2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2IntMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public Float2IntSortedMap tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntSortedMap
        @Deprecated
        public Float2IntSortedMap tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Float2IntSortedMap unmodifiable(Float2IntSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
