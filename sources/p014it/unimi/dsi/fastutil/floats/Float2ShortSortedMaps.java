package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap;
import p014it.unimi.dsi.fastutil.floats.Float2ShortMap;
import p014it.unimi.dsi.fastutil.floats.Float2ShortMaps;
import p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortSortedMaps.class */
public final class Float2ShortSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2ShortSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static ObjectBidirectionalIterator<Float2ShortMap.Entry> fastIterator(Float2ShortSortedMap map) {
        ObjectSortedSet<Float2ShortMap.Entry> entries = map.float2ShortEntrySet();
        return entries instanceof Float2ShortSortedMap.FastSortedEntrySet ? ((Float2ShortSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Float2ShortMap.Entry> fastIterable(Float2ShortSortedMap map) {
        ObjectSortedSet<Float2ShortMap.Entry> entries = map.float2ShortEntrySet();
        if (!(entries instanceof Float2ShortSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2ShortSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2ShortSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Float2ShortMaps.EmptyMap implements Float2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public ObjectSortedSet<Float2ShortMap.Entry> float2ShortEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Short>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap subMap(float from, float to) {
            return Float2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap headMap(float to) {
            return Float2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap tailMap(float from) {
            return Float2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortSortedMaps$Singleton.class */
    public static class Singleton extends Float2ShortMaps.Singleton implements Float2ShortSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, short value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, short value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public ObjectSortedSet<Float2ShortMap.Entry> float2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2ShortMap.BasicEntry(this.key, this.value), Float2ShortSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Short>> entrySet() {
            return float2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2ShortSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2ShortSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static Float2ShortSortedMap singleton(Float key, Short value) {
        return new Singleton(key.floatValue(), value.shortValue());
    }

    public static Float2ShortSortedMap singleton(Float key, Short value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value.shortValue(), comparator);
    }

    public static Float2ShortSortedMap singleton(float key, short value) {
        return new Singleton(key, value);
    }

    public static Float2ShortSortedMap singleton(float key, short value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Float2ShortMaps.SynchronizedMap implements Float2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ShortSortedMap sortedMap;

        protected SynchronizedSortedMap(Float2ShortSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public ObjectSortedSet<Float2ShortMap.Entry> float2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2ShortEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Short>> entrySet() {
            return float2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Float2ShortSortedMap synchronize(Float2ShortSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Float2ShortSortedMap synchronize(Float2ShortSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Float2ShortMaps.UnmodifiableMap implements Float2ShortSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ShortSortedMap sortedMap;

        protected UnmodifiableSortedMap(Float2ShortSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public ObjectSortedSet<Float2ShortMap.Entry> float2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2ShortEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Short>> entrySet() {
            return float2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public Float2ShortSortedMap tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
        @Deprecated
        public Float2ShortSortedMap tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Float2ShortSortedMap unmodifiable(Float2ShortSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
