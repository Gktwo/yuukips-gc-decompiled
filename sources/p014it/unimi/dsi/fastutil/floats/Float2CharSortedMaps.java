package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap;
import p014it.unimi.dsi.fastutil.floats.Float2CharMap;
import p014it.unimi.dsi.fastutil.floats.Float2CharMaps;
import p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2CharSortedMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharSortedMaps.class */
public final class Float2CharSortedMaps {
    public static final EmptySortedMap EMPTY_MAP = new EmptySortedMap();

    private Float2CharSortedMaps() {
    }

    public static Comparator<? super Map.Entry<Float, ?>> entryComparator(FloatComparator comparator) {
        return x, y -> {
            return comparator.compare(((Float) x.getKey()).floatValue(), ((Float) y.getKey()).floatValue());
        };
    }

    public static ObjectBidirectionalIterator<Float2CharMap.Entry> fastIterator(Float2CharSortedMap map) {
        ObjectSortedSet<Float2CharMap.Entry> entries = map.float2CharEntrySet();
        return entries instanceof Float2CharSortedMap.FastSortedEntrySet ? ((Float2CharSortedMap.FastSortedEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static ObjectBidirectionalIterable<Float2CharMap.Entry> fastIterable(Float2CharSortedMap map) {
        ObjectSortedSet<Float2CharMap.Entry> entries = map.float2CharEntrySet();
        if (!(entries instanceof Float2CharSortedMap.FastSortedEntrySet)) {
            return entries;
        }
        Float2CharSortedMap.FastSortedEntrySet fastSortedEntrySet = (Float2CharSortedMap.FastSortedEntrySet) entries;
        Objects.requireNonNull(fastSortedEntrySet);
        return this::fastIterator;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharSortedMaps$EmptySortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharSortedMaps$EmptySortedMap.class */
    public static class EmptySortedMap extends Float2CharMaps.EmptyMap implements Float2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySortedMap() {
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSortedSet<Float2CharMap.Entry> float2CharEntrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Character>> entrySet() {
            return ObjectSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.EmptyMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public FloatSortedSet keySet() {
            return FloatSortedSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap subMap(float from, float to) {
            return Float2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap headMap(float to) {
            return Float2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap tailMap(float from) {
            return Float2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float firstFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float lastFloatKey() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharSortedMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharSortedMaps$Singleton.class */
    public static class Singleton extends Float2CharMaps.Singleton implements Float2CharSortedMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final FloatComparator comparator;

        protected Singleton(float key, char value, FloatComparator comparator) {
            super(key, value);
            this.comparator = comparator;
        }

        protected Singleton(float key, char value) {
            this(key, value, null);
        }

        final int compare(float k1, float k2) {
            return this.comparator == null ? Float.compare(k1, k2) : this.comparator.compare(k1, k2);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSortedSet<Float2CharMap.Entry> float2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.singleton(new AbstractFloat2CharMap.BasicEntry(this.key, this.value), Float2CharSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Character>> entrySet() {
            return float2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.Singleton, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.singleton(this.key, this.comparator);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap subMap(float from, float to) {
            return (compare(from, this.key) > 0 || compare(this.key, to) >= 0) ? Float2CharSortedMaps.EMPTY_MAP : this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap headMap(float to) {
            return compare(this.key, to) < 0 ? this : Float2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap tailMap(float from) {
            return compare(from, this.key) <= 0 ? this : Float2CharSortedMaps.EMPTY_MAP;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float firstFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float lastFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap headMap(Float oto) {
            return headMap(oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap tailMap(Float ofrom) {
            return tailMap(ofrom.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap subMap(Float ofrom, Float oto) {
            return subMap(ofrom.floatValue(), oto.floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return Float.valueOf(firstFloatKey());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return Float.valueOf(lastFloatKey());
        }
    }

    public static Float2CharSortedMap singleton(Float key, Character value) {
        return new Singleton(key.floatValue(), value.charValue());
    }

    public static Float2CharSortedMap singleton(Float key, Character value, FloatComparator comparator) {
        return new Singleton(key.floatValue(), value.charValue(), comparator);
    }

    public static Float2CharSortedMap singleton(float key, char value) {
        return new Singleton(key, value);
    }

    public static Float2CharSortedMap singleton(float key, char value, FloatComparator comparator) {
        return new Singleton(key, value, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharSortedMaps$SynchronizedSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharSortedMaps$SynchronizedSortedMap.class */
    public static class SynchronizedSortedMap extends Float2CharMaps.SynchronizedMap implements Float2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2CharSortedMap sortedMap;

        protected SynchronizedSortedMap(Float2CharSortedMap m, Object sync) {
            super(m, sync);
            this.sortedMap = m;
        }

        protected SynchronizedSortedMap(Float2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            Comparator<? super Float> comparator;
            synchronized (this.sync) {
                comparator = this.sortedMap.comparator();
            }
            return comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSortedSet<Float2CharMap.Entry> float2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.synchronize(this.sortedMap.float2CharEntrySet(), this.sync);
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Character>> entrySet() {
            return float2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.SynchronizedMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.synchronize(this.sortedMap.keySet(), this.sync);
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap subMap(float from, float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap headMap(float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap tailMap(float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float firstFloatKey() {
            float firstFloatKey;
            synchronized (this.sync) {
                firstFloatKey = this.sortedMap.firstFloatKey();
            }
            return firstFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float lastFloatKey() {
            float lastFloatKey;
            synchronized (this.sync) {
                lastFloatKey = this.sortedMap.lastFloatKey();
            }
            return lastFloatKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            Float firstKey;
            synchronized (this.sync) {
                firstKey = this.sortedMap.firstKey();
            }
            return firstKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            Float lastKey;
            synchronized (this.sync) {
                lastKey = this.sortedMap.lastKey();
            }
            return lastKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap subMap(Float from, Float to) {
            return new SynchronizedSortedMap(this.sortedMap.subMap(from, to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap headMap(Float to) {
            return new SynchronizedSortedMap(this.sortedMap.headMap(to), this.sync);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap tailMap(Float from) {
            return new SynchronizedSortedMap(this.sortedMap.tailMap(from), this.sync);
        }
    }

    public static Float2CharSortedMap synchronize(Float2CharSortedMap m) {
        return new SynchronizedSortedMap(m);
    }

    public static Float2CharSortedMap synchronize(Float2CharSortedMap m, Object sync) {
        return new SynchronizedSortedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharSortedMaps$UnmodifiableSortedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharSortedMaps$UnmodifiableSortedMap.class */
    public static class UnmodifiableSortedMap extends Float2CharMaps.UnmodifiableMap implements Float2CharSortedMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2CharSortedMap sortedMap;

        protected UnmodifiableSortedMap(Float2CharSortedMap m) {
            super(m);
            this.sortedMap = m;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return this.sortedMap.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSortedSet<Float2CharMap.Entry> float2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSortedSets.unmodifiable(this.sortedMap.float2CharEntrySet());
            }
            return (ObjectSortedSet) this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public ObjectSortedSet<Map.Entry<Float, Character>> entrySet() {
            return float2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMaps.UnmodifiableMap, p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = FloatSortedSets.unmodifiable(this.sortedMap.keySet());
            }
            return (FloatSortedSet) this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap subMap(float from, float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap headMap(float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public Float2CharSortedMap tailMap(float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float firstFloatKey() {
            return this.sortedMap.firstFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public float lastFloatKey() {
            return this.sortedMap.lastFloatKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float firstKey() {
            return this.sortedMap.firstKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap, java.util.SortedMap
        @Deprecated
        public Float lastKey() {
            return this.sortedMap.lastKey();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap subMap(Float from, Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.subMap(from, to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap headMap(Float to) {
            return new UnmodifiableSortedMap(this.sortedMap.headMap(to));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        @Deprecated
        public Float2CharSortedMap tailMap(Float from) {
            return new UnmodifiableSortedMap(this.sortedMap.tailMap(from));
        }
    }

    public static Float2CharSortedMap unmodifiable(Float2CharSortedMap m) {
        return new UnmodifiableSortedMap(m);
    }
}
