package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap;
import p014it.unimi.dsi.fastutil.floats.Float2ByteMap;
import p014it.unimi.dsi.fastutil.floats.Float2ByteMaps;
import p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteSortedMaps.class */
public final class Float2ByteSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2ByteSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static ObjectBidirectionalIterator<Float2ByteMap.Entry> fastIterator(Float2ByteSortedMap map) {
        ObjectSortedSet<Float2ByteMap.Entry> entries = map.float2ByteEntrySet();
        return entries instanceof Float2ByteSortedMap.FastSortedEntrySet ? ((Float2ByteSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Float2ByteMap.Entry> fastIterable(Float2ByteSortedMap map) {
        ObjectSortedSet<Float2ByteMap.Entry> entries = map.float2ByteEntrySet();
        if (!(entries instanceof Float2ByteSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2ByteSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2ByteSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Float2ByteMaps.EmptyMap implements Float2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSortedSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Byte>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap subMap(float from, float to) {
            return Float2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap headMap(float to) {
            return Float2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap tailMap(float from) {
            return Float2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteSortedMaps$Singleton.class */
    public static class Singleton extends Float2ByteMaps.Singleton implements Float2ByteSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, byte value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, byte value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSortedSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2ByteMap.BasicEntry(this.key, this.value), Float2ByteSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Byte>> entrySet() {
            return float2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2ByteSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2ByteSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static Float2ByteSortedMap singleton(Float key, Byte value) {
        return new Singleton(key.floatValue(), value.byteValue());
    }

    public static Float2ByteSortedMap singleton(Float key, Byte value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value.byteValue(), comparator);
    }

    public static Float2ByteSortedMap singleton(float key, byte value) {
        return new Singleton(key, value);
    }

    public static Float2ByteSortedMap singleton(float key, byte value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Float2ByteMaps.SynchronizedMap implements Float2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ByteSortedMap sortedMap;

        protected SynchronizedSortedMap(Float2ByteSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSortedSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2ByteEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Byte>> entrySet() {
            return float2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Float2ByteSortedMap synchronize(Float2ByteSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Float2ByteSortedMap synchronize(Float2ByteSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Float2ByteMaps.UnmodifiableMap implements Float2ByteSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ByteSortedMap sortedMap;

        protected UnmodifiableSortedMap(Float2ByteSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSortedSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2ByteEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Byte>> entrySet() {
            return float2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public Float2ByteSortedMap tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        @Deprecated
        public Float2ByteSortedMap tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Float2ByteSortedMap unmodifiable(Float2ByteSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
