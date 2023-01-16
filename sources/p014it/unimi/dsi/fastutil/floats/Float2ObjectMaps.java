package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectMaps.class */
public final class Float2ObjectMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Float2ObjectMaps() {
    }

    public static <V> ObjectIterator<Float2ObjectMap.Entry<V>> fastIterator(Float2ObjectMap<V> map) {
        ObjectSet<Float2ObjectMap.Entry<V>> entries = map.float2ObjectEntrySet();
        return entries instanceof Float2ObjectMap.FastEntrySet ? ((Float2ObjectMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> void fastForEach(Float2ObjectMap<V> map, Consumer<? super Float2ObjectMap.Entry<V>> consumer) {
        ObjectSet<Float2ObjectMap.Entry<V>> entries = map.float2ObjectEntrySet();
        if (entries instanceof Float2ObjectMap.FastEntrySet) {
            ((Float2ObjectMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <V> ObjectIterable<Float2ObjectMap.Entry<V>> fastIterable(Float2ObjectMap<V> map) {
        final ObjectSet<Float2ObjectMap.Entry<V>> entries = map.float2ObjectEntrySet();
        return entries instanceof Float2ObjectMap.FastEntrySet ? new ObjectIterable<Float2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.floats.Float2ObjectMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Float2ObjectMap.Entry<V>> iterator() {
                return ((Float2ObjectMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Float2ObjectMap.Entry<V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Float2ObjectMap.Entry<V>> consumer) {
                ((Float2ObjectMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectMaps$EmptyMap.class */
    public static class EmptyMap<V> extends Float2ObjectFunctions.EmptyFunction<V> implements Float2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction
        public V getOrDefault(float key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public Set<Float> keySet() {
            return FloatSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Float2ObjectMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <V> Float2ObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectMaps$Singleton.class */
    public static class Singleton<V> extends Float2ObjectFunctions.Singleton<V> implements Float2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Float2ObjectMap.Entry<V>> entries;
        protected transient FloatSet keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(float key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return Objects.equals(this.value, v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractFloat2ObjectMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Float, V>> entrySet() {
            return float2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            if (this.values == null) {
                this.values = ObjectSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ (this.value == null ? 0 : this.value.hashCode());
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

    public static <V> Float2ObjectMap<V> singleton(float key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Float2ObjectMap<V> singleton(Float key, V value) {
        return new Singleton(key.floatValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectMaps$SynchronizedMap.class */
    public static class SynchronizedMap<V> extends Float2ObjectFunctions.SynchronizedFunction<V> implements Float2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ObjectMap<V> map;
        protected transient ObjectSet<Float2ObjectMap.Entry<V>> entries;
        protected transient FloatSet keys;
        protected transient ObjectCollection<V> values;

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
        public SynchronizedMap(Float2ObjectMap<V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2ObjectMap<V> m) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            ObjectSet<Float2ObjectMap.Entry<V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.float2ObjectEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Float, V>> entrySet() {
            return float2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            ObjectCollection<V> objectCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = ObjectCollections.synchronize(this.map.values(), this.sync);
                }
                objectCollection = this.values;
            }
            return objectCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction
        public V getOrDefault(float key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, (float) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V putIfAbsent(float key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, (float) value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public boolean remove(float key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V replace(float key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, (float) value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public boolean replace(float key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V computeIfAbsent(float key, DoubleFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V computeIfAbsent(float key, Float2ObjectFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, (Float2ObjectFunction) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V computeIfPresent(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V compute(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V merge(float key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, (float) value, (BiFunction<? super float, ? super float, ? extends float>) remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
                replace = this.map.replace((Float2ObjectMap<V>) key, (Float) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Float key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Float2ObjectMap<V>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public V putIfAbsent(Float key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Float2ObjectMap<V>) key, (Float) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public V computeIfAbsent(Float key, Function<? super Float, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Float2ObjectMap<V>) key, (Function<? super Float2ObjectMap<V>, ? extends V>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public V computeIfPresent(Float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Float2ObjectMap<V>) key, (BiFunction<? super Float2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public V compute(Float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute((Float2ObjectMap<V>) key, (BiFunction<? super Float2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public V merge(Float key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge((Float2ObjectMap<V>) key, (Float) value, (BiFunction<? super Float, ? super Float, ? extends Float>) remappingFunction);
            }
            return merge;
        }
    }

    public static <V> Float2ObjectMap<V> synchronize(Float2ObjectMap<V> m) {
        return new SynchronizedMap(m);
    }

    public static <V> Float2ObjectMap<V> synchronize(Float2ObjectMap<V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<V> extends Float2ObjectFunctions.UnmodifiableFunction<V> implements Float2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ObjectMap<? extends V> map;
        protected transient ObjectSet<Float2ObjectMap.Entry<V>> entries;
        protected transient FloatSet keys;
        protected transient ObjectCollection<V> values;

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
        public UnmodifiableMap(Float2ObjectMap<? extends V> m) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, p014it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap
        public ObjectSet<Float2ObjectMap.Entry<V>> float2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.float2ObjectEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Float, V>> entrySet() {
            return float2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            if (this.values == null) {
                this.values = ObjectCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction
        public V getOrDefault(float key, V defaultValue) {
            return (V) this.map.getOrDefault(key, (float) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V putIfAbsent(float key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public boolean remove(float key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V replace(float key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public boolean replace(float key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V computeIfAbsent(float key, DoubleFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V computeIfAbsent(float key, Float2ObjectFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V computeIfPresent(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V compute(float key, BiFunction<? super Float, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
        public V merge(float key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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

    public static <V> Float2ObjectMap<V> unmodifiable(Float2ObjectMap<? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
