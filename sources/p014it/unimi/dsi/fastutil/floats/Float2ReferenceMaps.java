package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceMap;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollections;
import p014it.unimi.dsi.fastutil.objects.ReferenceSets;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceMaps.class */
public final class Float2ReferenceMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Float2ReferenceMaps() {
    }

    public static <V> ObjectIterator<Float2ReferenceMap.Entry<V>> fastIterator(Float2ReferenceMap<V> map) {
        ObjectSet<Float2ReferenceMap.Entry<V>> entries = map.float2ReferenceEntrySet();
        return entries instanceof Float2ReferenceMap.FastEntrySet ? ((Float2ReferenceMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> void fastForEach(Float2ReferenceMap<V> map, Consumer<? super Float2ReferenceMap.Entry<V>> consumer) {
        ObjectSet<Float2ReferenceMap.Entry<V>> entries = map.float2ReferenceEntrySet();
        if (entries instanceof Float2ReferenceMap.FastEntrySet) {
            ((Float2ReferenceMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <V> ObjectIterable<Float2ReferenceMap.Entry<V>> fastIterable(Float2ReferenceMap<V> map) {
        final ObjectSet<Float2ReferenceMap.Entry<V>> entries = map.float2ReferenceEntrySet();
        return entries instanceof Float2ReferenceMap.FastEntrySet ? new ObjectIterable<Float2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.floats.Float2ReferenceMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Float2ReferenceMap.Entry<V>> iterator() {
                return ((Float2ReferenceMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Float2ReferenceMap.Entry<V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Float2ReferenceMap.Entry<V>> consumer) {
                ((Float2ReferenceMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceMaps$EmptyMap.class */
    public static class EmptyMap<V> extends Float2ReferenceFunctions.EmptyFunction<V> implements Float2ReferenceMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public Set<Float> keySet() {
            return FloatSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            return ReferenceSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Float2ReferenceMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <V> Float2ReferenceMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceMaps$Singleton.class */
    public static class Singleton<V> extends Float2ReferenceFunctions.Singleton<V> implements Float2ReferenceMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Float2ReferenceMap.Entry<V>> entries;
        protected transient FloatSet keys;
        protected transient ReferenceCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(float key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.value == v;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractFloat2ReferenceMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Float, V>> entrySet() {
            return float2ReferenceEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            if (this.values == null) {
                this.values = ReferenceSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ (this.value == null ? 0 : System.identityHashCode(this.value));
        }

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

    public static <V> Float2ReferenceMap<V> singleton(float key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Float2ReferenceMap<V> singleton(Float key, V value) {
        return new Singleton(key.floatValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceMaps$SynchronizedMap.class */
    public static class SynchronizedMap<V> extends Float2ReferenceFunctions.SynchronizedFunction<V> implements Float2ReferenceMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ReferenceMap<V> map;
        protected transient ObjectSet<Float2ReferenceMap.Entry<V>> entries;
        protected transient FloatSet keys;
        protected transient ReferenceCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Float f, Object obj, BiFunction biFunction) {
            return merge(f, (Float) obj, (BiFunction<? super Float, ? super Float, ? extends Float>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Float f, Object obj) {
            return replace(f, (Float) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Float f, Object obj) {
            return putIfAbsent(f, (Float) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2ReferenceMap<V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2ReferenceMap<V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends V> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            ObjectSet<Float2ReferenceMap.Entry<V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.float2ReferenceEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Float, V>> entrySet() {
            return float2ReferenceEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            ReferenceCollection<V> referenceCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = ReferenceCollections.synchronize(this.map.values(), this.sync);
                }
                referenceCollection = this.values;
            }
            return referenceCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, (float) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super V> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super V, ? extends V> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V putIfAbsent(float key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, (float) value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean remove(float key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V replace(float key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, (float) value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean replace(float key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V computeIfAbsent(float key, DoubleFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V computeIfAbsent(float key, Float2ReferenceFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, (Float2ReferenceFunction) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V computeIfPresent(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V compute(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V merge(float key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, (float) value, (BiFunction<? super float, ? super float, ? extends float>) remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Deprecated
        public V replace(Float key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace((Float2ReferenceMap<V>) key, (Float) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Float key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Float2ReferenceMap<V>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public V putIfAbsent(Float key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Float2ReferenceMap<V>) key, (Float) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public V computeIfAbsent(Float key, Function<? super Float, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Float2ReferenceMap<V>) key, (Function<? super Float2ReferenceMap<V>, ? extends V>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public V computeIfPresent(Float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Float2ReferenceMap<V>) key, (BiFunction<? super Float2ReferenceMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public V compute(Float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute((Float2ReferenceMap<V>) key, (BiFunction<? super Float2ReferenceMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public V merge(Float key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge((Float2ReferenceMap<V>) key, (Float) value, (BiFunction<? super Float, ? super Float, ? extends Float>) remappingFunction);
            }
            return merge;
        }
    }

    public static <V> Float2ReferenceMap<V> synchronize(Float2ReferenceMap<V> m) {
        return new SynchronizedMap(m);
    }

    public static <V> Float2ReferenceMap<V> synchronize(Float2ReferenceMap<V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<V> extends Float2ReferenceFunctions.UnmodifiableFunction<V> implements Float2ReferenceMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ReferenceMap<? extends V> map;
        protected transient ObjectSet<Float2ReferenceMap.Entry<V>> entries;
        protected transient FloatSet keys;
        protected transient ReferenceCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Float f, Object obj, BiFunction biFunction) {
            return merge(f, (Float) obj, (BiFunction<? super Float, ? super Float, ? extends Float>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Float f, Object obj) {
            return replace(f, (Float) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Float f, Object obj) {
            return putIfAbsent(f, (Float) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Float2ReferenceMap<? extends V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.map.containsValue(v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, p014it.unimi.dsi.fastutil.floats.Float2ReferenceSortedMap
        public ObjectSet<Float2ReferenceMap.Entry<V>> float2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.float2ReferenceEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Float, V>> entrySet() {
            return float2ReferenceEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            if (this.values == null) {
                this.values = ReferenceCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float key, V defaultValue) {
            return (V) this.map.getOrDefault(key, (float) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V putIfAbsent(float key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean remove(float key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V replace(float key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean replace(float key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V computeIfAbsent(float key, DoubleFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V computeIfAbsent(float key, Float2ReferenceFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V computeIfPresent(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V compute(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public V merge(float key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return (V) this.map.getOrDefault(key, defaultValue);
        }

        @Override // java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V replace(Float key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Float key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V putIfAbsent(Float key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfAbsent(Float key, Function<? super Float, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfPresent(Float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V compute(Float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V merge(Float key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Float2ReferenceMap<V> unmodifiable(Float2ReferenceMap<? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
