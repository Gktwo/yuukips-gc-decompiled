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
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollections;
import p014it.unimi.dsi.fastutil.doubles.DoubleSets;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleMaps.class */
public final class Float2DoubleMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Float2DoubleMaps() {
    }

    public static ObjectIterator<Float2DoubleMap.Entry> fastIterator(Float2DoubleMap map) {
        ObjectSet<Float2DoubleMap.Entry> entries = map.float2DoubleEntrySet();
        return entries instanceof Float2DoubleMap.FastEntrySet ? ((Float2DoubleMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Float2DoubleMap map, Consumer<? super Float2DoubleMap.Entry> consumer) {
        ObjectSet<Float2DoubleMap.Entry> entries = map.float2DoubleEntrySet();
        if (entries instanceof Float2DoubleMap.FastEntrySet) {
            ((Float2DoubleMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Float2DoubleMap.Entry> fastIterable(Float2DoubleMap map) {
        final ObjectSet<Float2DoubleMap.Entry> entries = map.float2DoubleEntrySet();
        return entries instanceof Float2DoubleMap.FastEntrySet ? new ObjectIterable<Float2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2DoubleMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Float2DoubleMap.Entry> iterator() {
                return ((Float2DoubleMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Float2DoubleMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Float2DoubleMap.Entry> consumer) {
                ((Float2DoubleMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleMaps$EmptyMap.class */
    public static class EmptyMap extends Float2DoubleFunctions.EmptyFunction implements Float2DoubleMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsValue(double v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float key, double defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Double> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public Set<Float> keySet() {
            return FloatSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public Collection<Double> values() {
            return DoubleSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Double> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Float2DoubleMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleMaps$Singleton.class */
    public static class Singleton extends Float2DoubleFunctions.Singleton implements Float2DoubleMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Float2DoubleMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient DoubleCollection values;

        /* access modifiers changed from: protected */
        public Singleton(float key, double value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsValue(double v) {
            return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return Double.doubleToLongBits(((Double) ov).doubleValue()) == Double.doubleToLongBits(this.value);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Double> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractFloat2DoubleMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Double>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Double>> entrySet() {
            return float2DoubleEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
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
            return HashCommon.float2int(this.key) ^ HashCommon.double2int(this.value);
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

    public static Float2DoubleMap singleton(float key, double value) {
        return new Singleton(key, value);
    }

    public static Float2DoubleMap singleton(Float key, Double value) {
        return new Singleton(key.floatValue(), value.doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Float2DoubleFunctions.SynchronizedFunction implements Float2DoubleMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2DoubleMap map;
        protected transient ObjectSet<Float2DoubleMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient DoubleCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2DoubleMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2DoubleMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsValue(double v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Double> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            ObjectSet<Float2DoubleMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.float2DoubleEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Double>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Double>> entrySet() {
            return float2DoubleEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.doubles.DoubleCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float key, double defaultValue) {
            double orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Double> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Double, ? extends Double> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double putIfAbsent(float key, double value) {
            double putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean remove(float key, double value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double replace(float key, double value) {
            double replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean replace(float key, double oldValue, double newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfAbsent(float key, DoubleUnaryOperator mappingFunction) {
            double computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfAbsentNullable(float key, DoubleFunction<? extends Double> mappingFunction) {
            double computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfAbsent(float key, Float2DoubleFunction mappingFunction) {
            double computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfPresent(float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            double computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double compute(float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            double compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double merge(float key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            double merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            Double orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double replace(Float key, Double value) {
            Double replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public boolean replace(Float key, Double oldValue, Double newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double putIfAbsent(Float key, Double value) {
            Double putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double computeIfAbsent(Float key, Function<? super Float, ? extends Double> mappingFunction) {
            Double computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double computeIfPresent(Float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            Double computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double compute(Float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            Double compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double merge(Float key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            Double merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Float2DoubleMap synchronize(Float2DoubleMap m) {
        return new SynchronizedMap(m);
    }

    public static Float2DoubleMap synchronize(Float2DoubleMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Float2DoubleFunctions.UnmodifiableFunction implements Float2DoubleMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2DoubleMap map;
        protected transient ObjectSet<Float2DoubleMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient DoubleCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Float2DoubleMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsValue(double v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Double> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, p014it.unimi.dsi.fastutil.floats.Float2DoubleSortedMap
        public ObjectSet<Float2DoubleMap.Entry> float2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.float2DoubleEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Double>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Double>> entrySet() {
            return float2DoubleEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.doubles.DoubleCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float key, double defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Double> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Double, ? extends Double> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double putIfAbsent(float key, double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean remove(float key, double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double replace(float key, double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean replace(float key, double oldValue, double newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfAbsent(float key, DoubleUnaryOperator mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfAbsentNullable(float key, DoubleFunction<? extends Double> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfAbsent(float key, Float2DoubleFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double computeIfPresent(float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double compute(float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public double merge(float key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double replace(Float key, Double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public boolean replace(Float key, Double oldValue, Double newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double putIfAbsent(Float key, Double value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double computeIfAbsent(Float key, Function<? super Float, ? extends Double> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double computeIfPresent(Float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double compute(Float key, BiFunction<? super Float, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        @Deprecated
        public Double merge(Float key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Float2DoubleMap unmodifiable(Float2DoubleMap m) {
        return new UnmodifiableMap(m);
    }
}
