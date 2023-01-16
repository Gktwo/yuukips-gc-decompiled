package p014it.unimi.dsi.fastutil.doubles;

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
import p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ObjectMap;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMaps.class */
public final class Double2ObjectMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Double2ObjectMaps() {
    }

    public static <V> ObjectIterator<Double2ObjectMap.Entry<V>> fastIterator(Double2ObjectMap<V> map) {
        ObjectSet<Double2ObjectMap.Entry<V>> entries = map.double2ObjectEntrySet();
        return entries instanceof Double2ObjectMap.FastEntrySet ? ((Double2ObjectMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> void fastForEach(Double2ObjectMap<V> map, Consumer<? super Double2ObjectMap.Entry<V>> consumer) {
        ObjectSet<Double2ObjectMap.Entry<V>> entries = map.double2ObjectEntrySet();
        if (entries instanceof Double2ObjectMap.FastEntrySet) {
            ((Double2ObjectMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <V> ObjectIterable<Double2ObjectMap.Entry<V>> fastIterable(Double2ObjectMap<V> map) {
        final ObjectSet<Double2ObjectMap.Entry<V>> entries = map.double2ObjectEntrySet();
        return entries instanceof Double2ObjectMap.FastEntrySet ? new ObjectIterable<Double2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.doubles.Double2ObjectMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Double2ObjectMap.Entry<V>> iterator() {
                return ((Double2ObjectMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Double2ObjectMap.Entry<V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Double2ObjectMap.Entry<V>> consumer) {
                ((Double2ObjectMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMaps$EmptyMap.class */
    public static class EmptyMap<V> extends Double2ObjectFunctions.EmptyFunction<V> implements Double2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Double, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public Set<Double> keySet() {
            return DoubleSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Double, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Double2ObjectMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <V> Double2ObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMaps$Singleton.class */
    public static class Singleton<V> extends Double2ObjectFunctions.Singleton<V> implements Double2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Double2ObjectMap.Entry<V>> entries;
        protected transient DoubleSet keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(double key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return Objects.equals(this.value, v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Double, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractDouble2ObjectMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Double, V>> entrySet() {
            return double2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public Set<Double> keySet() {
            if (this.keys == null) {
                this.keys = DoubleSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
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
            return HashCommon.double2int(this.key) ^ (this.value == null ? 0 : this.value.hashCode());
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

    public static <V> Double2ObjectMap<V> singleton(double key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Double2ObjectMap<V> singleton(Double key, V value) {
        return new Singleton(key.doubleValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMaps$SynchronizedMap.class */
    public static class SynchronizedMap<V> extends Double2ObjectFunctions.SynchronizedFunction<V> implements Double2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ObjectMap<V> map;
        protected transient ObjectSet<Double2ObjectMap.Entry<V>> entries;
        protected transient DoubleSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Double d, Object obj, BiFunction biFunction) {
            return merge(d, (Double) obj, (BiFunction<? super Double, ? super Double, ? extends Double>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Double d, Object obj) {
            return replace(d, (Double) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Double d, Object obj) {
            return putIfAbsent(d, (Double) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Double2ObjectMap<V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Double2ObjectMap<V> m) {
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
        public void putAll(Map<? extends Double, ? extends V> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            ObjectSet<Double2ObjectMap.Entry<V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.double2ObjectEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Double, V>> entrySet() {
            return double2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.doubles.DoubleSet] */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public Set<Double> keySet() {
            DoubleSet doubleSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = DoubleSets.synchronize(this.map.keySet(), this.sync);
                }
                doubleSet = this.keys;
            }
            return doubleSet;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, (double) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Double, ? super V> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Double, ? super V, ? extends V> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V putIfAbsent(double key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, (double) value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean remove(double key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V replace(double key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, (double) value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean replace(double key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V computeIfAbsent(double key, DoubleFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V computeIfAbsent(double key, Double2ObjectFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, (Double2ObjectFunction) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V computeIfPresent(double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V compute(double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V merge(double key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, (double) value, (BiFunction<? super double, ? super double, ? extends double>) remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Double key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace((Double2ObjectMap<V>) key, (Double) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Double key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Double2ObjectMap<V>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public V putIfAbsent(Double key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Double2ObjectMap<V>) key, (Double) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public V computeIfAbsent(Double key, Function<? super Double, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Double2ObjectMap<V>) key, (Function<? super Double2ObjectMap<V>, ? extends V>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public V computeIfPresent(Double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Double2ObjectMap<V>) key, (BiFunction<? super Double2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public V compute(Double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute((Double2ObjectMap<V>) key, (BiFunction<? super Double2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public V merge(Double key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge((Double2ObjectMap<V>) key, (Double) value, (BiFunction<? super Double, ? super Double, ? extends Double>) remappingFunction);
            }
            return merge;
        }
    }

    public static <V> Double2ObjectMap<V> synchronize(Double2ObjectMap<V> m) {
        return new SynchronizedMap(m);
    }

    public static <V> Double2ObjectMap<V> synchronize(Double2ObjectMap<V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<V> extends Double2ObjectFunctions.UnmodifiableFunction<V> implements Double2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ObjectMap<? extends V> map;
        protected transient ObjectSet<Double2ObjectMap.Entry<V>> entries;
        protected transient DoubleSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Double d, Object obj, BiFunction biFunction) {
            return merge(d, (Double) obj, (BiFunction<? super Double, ? super Double, ? extends Double>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Double d, Object obj) {
            return replace(d, (Double) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Double d, Object obj) {
            return putIfAbsent(d, (Double) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Double2ObjectMap<? extends V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.map.containsValue(v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Double, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
        public ObjectSet<Double2ObjectMap.Entry<V>> double2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.double2ObjectEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Double, V>> entrySet() {
            return double2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.doubles.DoubleSet] */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public Set<Double> keySet() {
            if (this.keys == null) {
                this.keys = DoubleSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double key, V defaultValue) {
            return (V) this.map.getOrDefault(key, (double) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Double, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Double, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V putIfAbsent(double key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean remove(double key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V replace(double key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean replace(double key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V computeIfAbsent(double key, DoubleFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V computeIfAbsent(double key, Double2ObjectFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V computeIfPresent(double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V compute(double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public V merge(double key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Double key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Double key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V putIfAbsent(Double key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfAbsent(Double key, Function<? super Double, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfPresent(Double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V compute(Double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V merge(Double key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Double2ObjectMap<V> unmodifiable(Double2ObjectMap<? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
