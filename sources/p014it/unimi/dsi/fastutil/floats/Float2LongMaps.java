package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2LongMap;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunctions;
import p014it.unimi.dsi.fastutil.floats.Float2LongMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollections;
import p014it.unimi.dsi.fastutil.longs.LongSets;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMaps.class */
public final class Float2LongMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Float2LongMaps() {
    }

    public static ObjectIterator<Float2LongMap.Entry> fastIterator(Float2LongMap map) {
        ObjectSet<Float2LongMap.Entry> entries = map.float2LongEntrySet();
        return entries instanceof Float2LongMap.FastEntrySet ? ((Float2LongMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Float2LongMap map, Consumer<? super Float2LongMap.Entry> consumer) {
        ObjectSet<Float2LongMap.Entry> entries = map.float2LongEntrySet();
        if (entries instanceof Float2LongMap.FastEntrySet) {
            ((Float2LongMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Float2LongMap.Entry> fastIterable(Float2LongMap map) {
        final ObjectSet<Float2LongMap.Entry> entries = map.float2LongEntrySet();
        return entries instanceof Float2LongMap.FastEntrySet ? new ObjectIterable<Float2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2LongMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Float2LongMap.Entry> iterator() {
                return ((Float2LongMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Float2LongMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Float2LongMap.Entry> consumer) {
                ((Float2LongMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMaps$EmptyMap.class */
    public static class EmptyMap extends Float2LongFunctions.EmptyFunction implements Float2LongMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean containsValue(long v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.floats.Float2LongFunction
        public long getOrDefault(float key, long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongSortedMap
        public ObjectSet<Float2LongMap.Entry> float2LongEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Set<Float> keySet() {
            return FloatSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Collection<Long> values() {
            return LongSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Long> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Float2LongMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMaps$Singleton.class */
    public static class Singleton extends Float2LongFunctions.Singleton implements Float2LongMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Float2LongMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient LongCollection values;

        /* access modifiers changed from: protected */
        public Singleton(float key, long value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean containsValue(long v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Long) ov).longValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongSortedMap
        public ObjectSet<Float2LongMap.Entry> float2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractFloat2LongMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Long>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Long>> entrySet() {
            return float2LongEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Collection<Long> values() {
            if (this.values == null) {
                this.values = LongSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ HashCommon.long2int(this.value);
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

    public static Float2LongMap singleton(float key, long value) {
        return new Singleton(key, value);
    }

    public static Float2LongMap singleton(Float key, Long value) {
        return new Singleton(key.floatValue(), value.longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Float2LongFunctions.SynchronizedFunction implements Float2LongMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2LongMap map;
        protected transient ObjectSet<Float2LongMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient LongCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2LongMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2LongMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean containsValue(long v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Long> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongSortedMap
        public ObjectSet<Float2LongMap.Entry> float2LongEntrySet() {
            ObjectSet<Float2LongMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.float2LongEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Long>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Long>> entrySet() {
            return float2LongEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Set<Float> keySet() {
            FloatSet floatSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = FloatSets.synchronize(this.map.keySet(), this.sync);
                }
                floatSet = this.keys;
            }
            return floatSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.longs.LongCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Collection<Long> values() {
            LongCollection longCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = LongCollections.synchronize(this.map.values(), this.sync);
                }
                longCollection = this.values;
            }
            return longCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2LongFunction
        public long getOrDefault(float key, long defaultValue) {
            long orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Long> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Long, ? extends Long> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long putIfAbsent(float key, long value) {
            long putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean remove(float key, long value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long replace(float key, long value) {
            long replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean replace(float key, long oldValue, long newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfAbsent(float key, DoubleToLongFunction mappingFunction) {
            long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfAbsentNullable(float key, DoubleFunction<? extends Long> mappingFunction) {
            long computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfAbsent(float key, Float2LongFunction mappingFunction) {
            long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfPresent(float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            long computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long compute(float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            long compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long merge(float key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            long merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            Long orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long replace(Float key, Long value) {
            Long replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public boolean replace(Float key, Long oldValue, Long newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long putIfAbsent(Float key, Long value) {
            Long putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long computeIfAbsent(Float key, Function<? super Float, ? extends Long> mappingFunction) {
            Long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long computeIfPresent(Float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            Long computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long compute(Float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            Long compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long merge(Float key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            Long merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Float2LongMap synchronize(Float2LongMap m) {
        return new SynchronizedMap(m);
    }

    public static Float2LongMap synchronize(Float2LongMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Float2LongFunctions.UnmodifiableFunction implements Float2LongMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2LongMap map;
        protected transient ObjectSet<Float2LongMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient LongCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Float2LongMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean containsValue(long v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, p014it.unimi.dsi.fastutil.floats.Float2LongSortedMap
        public ObjectSet<Float2LongMap.Entry> float2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.float2LongEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Long>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Long>> entrySet() {
            return float2LongEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.longs.LongCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public Collection<Long> values() {
            if (this.values == null) {
                this.values = LongCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2LongFunction
        public long getOrDefault(float key, long defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Long> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Long, ? extends Long> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long putIfAbsent(float key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean remove(float key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long replace(float key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public boolean replace(float key, long oldValue, long newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfAbsent(float key, DoubleToLongFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfAbsentNullable(float key, DoubleFunction<? extends Long> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfAbsent(float key, Float2LongFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long computeIfPresent(float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long compute(float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        public long merge(float key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long replace(Float key, Long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public boolean replace(Float key, Long oldValue, Long newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long putIfAbsent(Float key, Long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long computeIfAbsent(Float key, Function<? super Float, ? extends Long> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long computeIfPresent(Float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long compute(Float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
        @Deprecated
        public Long merge(Float key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Float2LongMap unmodifiable(Float2LongMap m) {
        return new UnmodifiableMap(m);
    }
}
