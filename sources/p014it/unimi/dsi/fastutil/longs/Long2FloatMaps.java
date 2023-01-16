package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollections;
import p014it.unimi.dsi.fastutil.floats.FloatSets;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions;
import p014it.unimi.dsi.fastutil.longs.Long2FloatMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatMaps.class */
public final class Long2FloatMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Long2FloatMaps() {
    }

    public static ObjectIterator<Long2FloatMap.Entry> fastIterator(Long2FloatMap map) {
        ObjectSet<Long2FloatMap.Entry> entries = map.long2FloatEntrySet();
        return entries instanceof Long2FloatMap.FastEntrySet ? ((Long2FloatMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Long2FloatMap map, Consumer<? super Long2FloatMap.Entry> consumer) {
        ObjectSet<Long2FloatMap.Entry> entries = map.long2FloatEntrySet();
        if (entries instanceof Long2FloatMap.FastEntrySet) {
            ((Long2FloatMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Long2FloatMap.Entry> fastIterable(Long2FloatMap map) {
        final ObjectSet<Long2FloatMap.Entry> entries = map.long2FloatEntrySet();
        return entries instanceof Long2FloatMap.FastEntrySet ? new ObjectIterable<Long2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2FloatMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Long2FloatMap.Entry> iterator() {
                return ((Long2FloatMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Long2FloatMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Long2FloatMap.Entry> consumer) {
                ((Long2FloatMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatMaps$EmptyMap.class */
    public static class EmptyMap extends Long2FloatFunctions.EmptyFunction implements Long2FloatMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean containsValue(float v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        public float getOrDefault(long key, float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public ObjectSet<Long2FloatMap.Entry> long2FloatEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Set<Long> keySet() {
            return LongSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Collection<Float> values() {
            return FloatSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super Float> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Long2FloatMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatMaps$Singleton.class */
    public static class Singleton extends Long2FloatFunctions.Singleton implements Long2FloatMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Long2FloatMap.Entry> entries;
        protected transient LongSet keys;
        protected transient FloatCollection values;

        /* access modifiers changed from: protected */
        public Singleton(long key, float value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean containsValue(float v) {
            return Float.floatToIntBits(this.value) == Float.floatToIntBits(v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return Float.floatToIntBits(((Float) ov).floatValue()) == Float.floatToIntBits(this.value);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public ObjectSet<Long2FloatMap.Entry> long2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractLong2FloatMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Float>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Long, Float>> entrySet() {
            return long2FloatEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Set<Long> keySet() {
            if (this.keys == null) {
                this.keys = LongSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Collection<Float> values() {
            if (this.values == null) {
                this.values = FloatSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ HashCommon.float2int(this.value);
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [it.unimi.dsi.fastutil.objects.ObjectSet] */
        @Override // java.lang.Object, java.util.Map
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Map)) {
                return false;
            }
            Map<?, ?> m = (Map) o;
            if (m.size() != 1) {
                return false;
            }
            return m.entrySet().iterator().next().equals(entrySet().iterator().next());
        }

        @Override // java.lang.Object
        public String toString() {
            return "{" + this.key + "=>" + this.value + "}";
        }
    }

    public static Long2FloatMap singleton(long key, float value) {
        return new Singleton(key, value);
    }

    public static Long2FloatMap singleton(Long key, Float value) {
        return new Singleton(key.longValue(), value.floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Long2FloatFunctions.SynchronizedFunction implements Long2FloatMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2FloatMap map;
        protected transient ObjectSet<Long2FloatMap.Entry> entries;
        protected transient LongSet keys;
        protected transient FloatCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Long2FloatMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Long2FloatMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean containsValue(float v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Float> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public ObjectSet<Long2FloatMap.Entry> long2FloatEntrySet() {
            ObjectSet<Long2FloatMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.long2FloatEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Float>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Long, Float>> entrySet() {
            return long2FloatEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.longs.LongSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Set<Long> keySet() {
            LongSet longSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = LongSets.synchronize(this.map.keySet(), this.sync);
                }
                longSet = this.keys;
            }
            return longSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatCollection] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Collection<Float> values() {
            FloatCollection floatCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = FloatCollections.synchronize(this.map.values(), this.sync);
                }
                floatCollection = this.values;
            }
            return floatCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.SynchronizedFunction, java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.map.equals(o);
            }
            return equals;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        public float getOrDefault(long key, float defaultValue) {
            float orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super Float> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Long, ? super Float, ? extends Float> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float putIfAbsent(long key, float value) {
            float putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean remove(long key, float value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float replace(long key, float value) {
            float replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean replace(long key, float oldValue, float newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfAbsent(long key, LongToDoubleFunction mappingFunction) {
            float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfAbsentNullable(long key, LongFunction<? extends Float> mappingFunction) {
            float computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfAbsent(long key, Long2FloatFunction mappingFunction) {
            float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfPresent(long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            float computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float compute(long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            float compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float merge(long key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            float merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            Float orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float replace(Long key, Float value) {
            Float replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public boolean replace(Long key, Float oldValue, Float newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float putIfAbsent(Long key, Float value) {
            Float putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float computeIfAbsent(Long key, Function<? super Long, ? extends Float> mappingFunction) {
            Float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float computeIfPresent(Long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            Float computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float compute(Long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            Float compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float merge(Long key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            Float merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Long2FloatMap synchronize(Long2FloatMap m) {
        return new SynchronizedMap(m);
    }

    public static Long2FloatMap synchronize(Long2FloatMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Long2FloatFunctions.UnmodifiableFunction implements Long2FloatMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2FloatMap map;
        protected transient ObjectSet<Long2FloatMap.Entry> entries;
        protected transient LongSet keys;
        protected transient FloatCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Long2FloatMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean containsValue(float v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public ObjectSet<Long2FloatMap.Entry> long2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.long2FloatEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Float>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Long, Float>> entrySet() {
            return long2FloatEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.longs.LongSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Set<Long> keySet() {
            if (this.keys == null) {
                this.keys = LongSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatCollection] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public Collection<Float> values() {
            if (this.values == null) {
                this.values = FloatCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        public float getOrDefault(long key, float defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super Float> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Long, ? super Float, ? extends Float> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float putIfAbsent(long key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean remove(long key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float replace(long key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean replace(long key, float oldValue, float newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfAbsent(long key, LongToDoubleFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfAbsentNullable(long key, LongFunction<? extends Float> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfAbsent(long key, Long2FloatFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float computeIfPresent(long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float compute(long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public float merge(long key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float replace(Long key, Float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public boolean replace(Long key, Float oldValue, Float newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float putIfAbsent(Long key, Float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float computeIfAbsent(Long key, Function<? super Long, ? extends Float> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float computeIfPresent(Long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float compute(Long key, BiFunction<? super Long, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        @Deprecated
        public Float merge(Long key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Long2FloatMap unmodifiable(Long2FloatMap m) {
        return new UnmodifiableMap(m);
    }
}
