package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanMap;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanSortedMaps.class */
public final class Float2BooleanSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2BooleanSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static ObjectBidirectionalIterator<Float2BooleanMap.Entry> fastIterator(Float2BooleanSortedMap map) {
        ObjectSortedSet<Float2BooleanMap.Entry> entries = map.float2BooleanEntrySet();
        return entries instanceof Float2BooleanSortedMap.FastSortedEntrySet ? ((Float2BooleanSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Float2BooleanMap.Entry> fastIterable(Float2BooleanSortedMap map) {
        ObjectSortedSet<Float2BooleanMap.Entry> entries = map.float2BooleanEntrySet();
        if (!(entries instanceof Float2BooleanSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2BooleanSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2BooleanSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Float2BooleanMaps.EmptyMap implements Float2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public ObjectSortedSet<Float2BooleanMap.Entry> float2BooleanEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Boolean>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap subMap(float from, float to) {
            return Float2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap headMap(float to) {
            return Float2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap tailMap(float from) {
            return Float2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanSortedMaps$Singleton.class */
    public static class Singleton extends Float2BooleanMaps.Singleton implements Float2BooleanSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, boolean value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, boolean value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public ObjectSortedSet<Float2BooleanMap.Entry> float2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2BooleanMap.BasicEntry(this.key, this.value), Float2BooleanSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Boolean>> entrySet() {
            return float2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2BooleanSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2BooleanSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static Float2BooleanSortedMap singleton(Float key, Boolean value) {
        return new Singleton(key.floatValue(), value.booleanValue());
    }

    public static Float2BooleanSortedMap singleton(Float key, Boolean value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value.booleanValue(), comparator);
    }

    public static Float2BooleanSortedMap singleton(float key, boolean value) {
        return new Singleton(key, value);
    }

    public static Float2BooleanSortedMap singleton(float key, boolean value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Float2BooleanMaps.SynchronizedMap implements Float2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2BooleanSortedMap sortedMap;

        protected SynchronizedSortedMap(Float2BooleanSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public ObjectSortedSet<Float2BooleanMap.Entry> float2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2BooleanEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Boolean>> entrySet() {
            return float2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Float2BooleanSortedMap synchronize(Float2BooleanSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Float2BooleanSortedMap synchronize(Float2BooleanSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Float2BooleanMaps.UnmodifiableMap implements Float2BooleanSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2BooleanSortedMap sortedMap;

        protected UnmodifiableSortedMap(Float2BooleanSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public ObjectSortedSet<Float2BooleanMap.Entry> float2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2BooleanEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Boolean>> entrySet() {
            return float2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        @Deprecated
        public Float2BooleanSortedMap tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Float2BooleanSortedMap unmodifiable(Float2BooleanSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
