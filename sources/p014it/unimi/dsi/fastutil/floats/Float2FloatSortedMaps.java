package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2FloatMap;
import p014it.unimi.dsi.fastutil.floats.Float2FloatMap;
import p014it.unimi.dsi.fastutil.floats.Float2FloatMaps;
import p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatSortedMaps.class */
public final class Float2FloatSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2FloatSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static ObjectBidirectionalIterator<Float2FloatMap.Entry> fastIterator(Float2FloatSortedMap map) {
        ObjectSortedSet<Float2FloatMap.Entry> entries = map.float2FloatEntrySet();
        return entries instanceof Float2FloatSortedMap.FastSortedEntrySet ? ((Float2FloatSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Float2FloatMap.Entry> fastIterable(Float2FloatSortedMap map) {
        ObjectSortedSet<Float2FloatMap.Entry> entries = map.float2FloatEntrySet();
        if (!(entries instanceof Float2FloatSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2FloatSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2FloatSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Float2FloatMaps.EmptyMap implements Float2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public ObjectSortedSet<Float2FloatMap.Entry> float2FloatEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Float>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap subMap(float from, float to) {
            return Float2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap headMap(float to) {
            return Float2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap tailMap(float from) {
            return Float2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatSortedMaps$Singleton.class */
    public static class Singleton extends Float2FloatMaps.Singleton implements Float2FloatSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, float value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, float value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public ObjectSortedSet<Float2FloatMap.Entry> float2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2FloatMap.BasicEntry(this.key, this.value), Float2FloatSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Float>> entrySet() {
            return float2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2FloatSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2FloatSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static Float2FloatSortedMap singleton(Float key, Float value) {
        return new Singleton(key.floatValue(), value.floatValue());
    }

    public static Float2FloatSortedMap singleton(Float key, Float value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value.floatValue(), comparator);
    }

    public static Float2FloatSortedMap singleton(float key, float value) {
        return new Singleton(key, value);
    }

    public static Float2FloatSortedMap singleton(float key, float value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Float2FloatMaps.SynchronizedMap implements Float2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2FloatSortedMap sortedMap;

        protected SynchronizedSortedMap(Float2FloatSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public ObjectSortedSet<Float2FloatMap.Entry> float2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2FloatEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Float>> entrySet() {
            return float2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Float2FloatSortedMap synchronize(Float2FloatSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Float2FloatSortedMap synchronize(Float2FloatSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Float2FloatMaps.UnmodifiableMap implements Float2FloatSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2FloatSortedMap sortedMap;

        protected UnmodifiableSortedMap(Float2FloatSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public ObjectSortedSet<Float2FloatMap.Entry> float2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2FloatEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Float>> entrySet() {
            return float2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2FloatMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public Float2FloatSortedMap tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatSortedMap
        @Deprecated
        public Float2FloatSortedMap tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Float2FloatSortedMap unmodifiable(Float2FloatSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
