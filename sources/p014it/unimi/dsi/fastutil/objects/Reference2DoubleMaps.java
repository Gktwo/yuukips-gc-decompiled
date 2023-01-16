package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;
import p014it.unimi.dsi.fastutil.doubles.DoubleSets;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleMaps.class */
public final class Reference2DoubleMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Reference2DoubleMaps() {
    }

    public static <K> ObjectIterator<Reference2DoubleMap.Entry<K>> fastIterator(Reference2DoubleMap<K> map) {
        ObjectSet<Reference2DoubleMap.Entry<K>> entries = map.reference2DoubleEntrySet();
        return entries instanceof Reference2DoubleMap.FastEntrySet ? ((Reference2DoubleMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Reference2DoubleMap<K> map, Consumer<? super Reference2DoubleMap.Entry<K>> consumer) {
        ObjectSet<Reference2DoubleMap.Entry<K>> entries = map.reference2DoubleEntrySet();
        if (entries instanceof Reference2DoubleMap.FastEntrySet) {
            ((Reference2DoubleMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Reference2DoubleMap.Entry<K>> fastIterable(Reference2DoubleMap<K> map) {
        final ObjectSet<Reference2DoubleMap.Entry<K>> entries = map.reference2DoubleEntrySet();
        return entries instanceof Reference2DoubleMap.FastEntrySet ? new ObjectIterable<Reference2DoubleMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2DoubleMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Reference2DoubleMap.Entry<K>> iterator() {
                return ((Reference2DoubleMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Reference2DoubleMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Reference2DoubleMap.Entry<K>> consumer) {
                ((Reference2DoubleMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Reference2DoubleFunctions.EmptyFunction<K> implements Reference2DoubleMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean containsValue(double v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
        public double getOrDefault(Object key, double defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Double> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSet<K> keySet() {
            return ReferenceSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public Collection<Double> values() {
            return DoubleSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Double> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Reference2DoubleMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Reference2DoubleMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleMaps$Singleton.class */
    public static class Singleton<K> extends Reference2DoubleFunctions.Singleton<K> implements Reference2DoubleMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Reference2DoubleMap.Entry<K>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient DoubleCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, double value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean containsValue(double v) {
            return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return Double.doubleToLongBits(((Double) ov).doubleValue()) == Double.doubleToLongBits(this.value);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Double> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractReference2DoubleMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Double>> entrySet() {
            return reference2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public Collection<Double> values() {
            if (this.values == null) {
                this.values = DoubleSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return System.identityHashCode(this.key) ^ HashCommon.double2int(this.value);
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

    public static <K> Reference2DoubleMap<K> singleton(K key, double value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2DoubleMap<K> singleton(K key, Double value) {
        return new Singleton(key, value.doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Reference2DoubleFunctions.SynchronizedFunction<K> implements Reference2DoubleMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2DoubleMap<K> map;
        protected transient ObjectSet<Reference2DoubleMap.Entry<K>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient DoubleCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Double merge(Object obj, Double d, BiFunction<? super Double, ? super Double, ? extends Double> biFunction) {
            return merge((SynchronizedMap<K>) obj, d, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Double replace(Object obj, Double d) {
            return replace((SynchronizedMap<K>) obj, d);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Double d, Double d2) {
            return replace((SynchronizedMap<K>) obj, d, d2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Double putIfAbsent(Object obj, Double d) {
            return putIfAbsent((SynchronizedMap<K>) obj, d);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Reference2DoubleMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Reference2DoubleMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean containsValue(double v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Double> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            ObjectSet<Reference2DoubleMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.reference2DoubleEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Double>> entrySet() {
            return reference2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSet<K> keySet() {
            ReferenceSet<K> referenceSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = ReferenceSets.synchronize(this.map.keySet(), this.sync);
                }
                referenceSet = this.keys;
            }
            return referenceSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.doubles.DoubleCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public Collection<Double> values() {
            DoubleCollection doubleCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = DoubleCollections.synchronize(this.map.values(), this.sync);
                }
                doubleCollection = this.values;
            }
            return doubleCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
        public double getOrDefault(Object key, double defaultValue) {
            double orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Double> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Double, ? extends Double> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double putIfAbsent(K key, double value) {
            double putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Reference2DoubleMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean remove(Object key, double value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double replace(K key, double value) {
            double replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2DoubleMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean replace(K key, double oldValue, double newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2DoubleMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
            double computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Reference2DoubleMap<K>) key, (ToDoubleFunction<? super Reference2DoubleMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeIfAbsent(K key, Reference2DoubleFunction<? super K> mappingFunction) {
            double computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Reference2DoubleMap<K>) key, (Reference2DoubleFunction<? super Reference2DoubleMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeDoubleIfPresent(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            double computeDoubleIfPresent;
            synchronized (this.sync) {
                computeDoubleIfPresent = this.map.computeDoubleIfPresent(key, remappingFunction);
            }
            return computeDoubleIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeDouble(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            double computeDouble;
            synchronized (this.sync) {
                computeDouble = this.map.computeDouble(key, remappingFunction);
            }
            return computeDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double merge(K key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            double merge;
            synchronized (this.sync) {
                merge = this.map.merge((Reference2DoubleMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            Double orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public Double replace(K key, Double value) {
            Double replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2DoubleMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public boolean replace(K key, Double oldValue, Double newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2DoubleMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public Double putIfAbsent(K key, Double value) {
            Double putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Reference2DoubleMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Double computeIfAbsent(K key, Function<? super K, ? extends Double> mappingFunction) {
            Double computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Reference2DoubleMap<K>) key, (Function<? super Reference2DoubleMap<K>, ? extends Double>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Double computeIfPresent(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            Double computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Double compute(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            Double compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public Double merge(K key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            Double merge;
            synchronized (this.sync) {
                merge = this.map.merge((Reference2DoubleMap<K>) key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Reference2DoubleMap<K> synchronize(Reference2DoubleMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Reference2DoubleMap<K> synchronize(Reference2DoubleMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Reference2DoubleFunctions.UnmodifiableFunction<K> implements Reference2DoubleMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2DoubleMap<? extends K> map;
        protected transient ObjectSet<Reference2DoubleMap.Entry<K>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient DoubleCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Double merge(Object obj, Double d, BiFunction<? super Double, ? super Double, ? extends Double> biFunction) {
            return merge((UnmodifiableMap<K>) obj, d, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Double replace(Object obj, Double d) {
            return replace((UnmodifiableMap<K>) obj, d);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Double d, Double d2) {
            return replace((UnmodifiableMap<K>) obj, d, d2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Double putIfAbsent(Object obj, Double d) {
            return putIfAbsent((UnmodifiableMap<K>) obj, d);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Reference2DoubleMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean containsValue(double v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Double> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public ObjectSet<Reference2DoubleMap.Entry<K>> reference2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.reference2DoubleEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Double>> entrySet() {
            return reference2DoubleEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public ReferenceSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.doubles.DoubleCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public Collection<Double> values() {
            if (this.values == null) {
                this.values = DoubleCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
        public double getOrDefault(Object key, double defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Double> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Double, ? extends Double> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double putIfAbsent(K key, double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean remove(Object key, double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double replace(K key, double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public boolean replace(K key, double oldValue, double newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeIfAbsent(K key, Reference2DoubleFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeDoubleIfPresent(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double computeDouble(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        public double merge(K key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public Double replace(K key, Double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public boolean replace(K key, Double oldValue, Double newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public Double putIfAbsent(K key, Double value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Double computeIfAbsent(K key, Function<? super K, ? extends Double> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Double computeIfPresent(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Double compute(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
        @Deprecated
        public Double merge(K key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Reference2DoubleMap<K> unmodifiable(Reference2DoubleMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
