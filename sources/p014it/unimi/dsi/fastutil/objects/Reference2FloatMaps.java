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
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollections;
import p014it.unimi.dsi.fastutil.floats.FloatSets;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2FloatMap;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatMaps.class */
public final class Reference2FloatMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Reference2FloatMaps() {
    }

    public static <K> ObjectIterator<Reference2FloatMap.Entry<K>> fastIterator(Reference2FloatMap<K> map) {
        ObjectSet<Reference2FloatMap.Entry<K>> entries = map.reference2FloatEntrySet();
        return entries instanceof Reference2FloatMap.FastEntrySet ? ((Reference2FloatMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Reference2FloatMap<K> map, Consumer<? super Reference2FloatMap.Entry<K>> consumer) {
        ObjectSet<Reference2FloatMap.Entry<K>> entries = map.reference2FloatEntrySet();
        if (entries instanceof Reference2FloatMap.FastEntrySet) {
            ((Reference2FloatMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Reference2FloatMap.Entry<K>> fastIterable(Reference2FloatMap<K> map) {
        final ObjectSet<Reference2FloatMap.Entry<K>> entries = map.reference2FloatEntrySet();
        return entries instanceof Reference2FloatMap.FastEntrySet ? new ObjectIterable<Reference2FloatMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2FloatMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Reference2FloatMap.Entry<K>> iterator() {
                return ((Reference2FloatMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Reference2FloatMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Reference2FloatMap.Entry<K>> consumer) {
                ((Reference2FloatMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Reference2FloatFunctions.EmptyFunction<K> implements Reference2FloatMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean containsValue(float v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction
        public float getOrDefault(Object key, float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public ReferenceSet<K> keySet() {
            return ReferenceSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public Collection<Float> values() {
            return FloatSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Float> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Reference2FloatMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Reference2FloatMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatMaps$Singleton.class */
    public static class Singleton<K> extends Reference2FloatFunctions.Singleton<K> implements Reference2FloatMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Reference2FloatMap.Entry<K>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient FloatCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, float value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean containsValue(float v) {
            return Float.floatToIntBits(this.value) == Float.floatToIntBits(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return Float.floatToIntBits(((Float) ov).floatValue()) == Float.floatToIntBits(this.value);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractReference2FloatMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Float>> entrySet() {
            return reference2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public ReferenceSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
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
            return System.identityHashCode(this.key) ^ HashCommon.float2int(this.value);
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

    public static <K> Reference2FloatMap<K> singleton(K key, float value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2FloatMap<K> singleton(K key, Float value) {
        return new Singleton(key, value.floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Reference2FloatFunctions.SynchronizedFunction<K> implements Reference2FloatMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2FloatMap<K> map;
        protected transient ObjectSet<Reference2FloatMap.Entry<K>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient FloatCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Float merge(Object obj, Float f, BiFunction<? super Float, ? super Float, ? extends Float> biFunction) {
            return merge((SynchronizedMap<K>) obj, f, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Float replace(Object obj, Float f) {
            return replace((SynchronizedMap<K>) obj, f);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Float f, Float f2) {
            return replace((SynchronizedMap<K>) obj, f, f2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Float putIfAbsent(Object obj, Float f) {
            return putIfAbsent((SynchronizedMap<K>) obj, f);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Reference2FloatMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Reference2FloatMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean containsValue(float v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Float> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            ObjectSet<Reference2FloatMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.reference2FloatEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Float>> entrySet() {
            return reference2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction
        public float getOrDefault(Object key, float defaultValue) {
            float orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Float> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Float, ? extends Float> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float putIfAbsent(K key, float value) {
            float putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Reference2FloatMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean remove(Object key, float value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float replace(K key, float value) {
            float replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2FloatMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean replace(K key, float oldValue, float newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2FloatMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
            float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Reference2FloatMap<K>) key, (ToDoubleFunction<? super Reference2FloatMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeIfAbsent(K key, Reference2FloatFunction<? super K> mappingFunction) {
            float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Reference2FloatMap<K>) key, (Reference2FloatFunction<? super Reference2FloatMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeFloatIfPresent(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            float computeFloatIfPresent;
            synchronized (this.sync) {
                computeFloatIfPresent = this.map.computeFloatIfPresent(key, remappingFunction);
            }
            return computeFloatIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeFloat(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            float computeFloat;
            synchronized (this.sync) {
                computeFloat = this.map.computeFloat(key, remappingFunction);
            }
            return computeFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float merge(K key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            float merge;
            synchronized (this.sync) {
                merge = this.map.merge((Reference2FloatMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            Float orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public Float replace(K key, Float value) {
            Float replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2FloatMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public boolean replace(K key, Float oldValue, Float newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Reference2FloatMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public Float putIfAbsent(K key, Float value) {
            Float putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Reference2FloatMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Float computeIfAbsent(K key, Function<? super K, ? extends Float> mappingFunction) {
            Float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Reference2FloatMap<K>) key, (Function<? super Reference2FloatMap<K>, ? extends Float>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Float computeIfPresent(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            Float computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Float compute(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            Float compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public Float merge(K key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            Float merge;
            synchronized (this.sync) {
                merge = this.map.merge((Reference2FloatMap<K>) key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Reference2FloatMap<K> synchronize(Reference2FloatMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Reference2FloatMap<K> synchronize(Reference2FloatMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Reference2FloatFunctions.UnmodifiableFunction<K> implements Reference2FloatMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2FloatMap<? extends K> map;
        protected transient ObjectSet<Reference2FloatMap.Entry<K>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient FloatCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Float merge(Object obj, Float f, BiFunction<? super Float, ? super Float, ? extends Float> biFunction) {
            return merge((UnmodifiableMap<K>) obj, f, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Float replace(Object obj, Float f) {
            return replace((UnmodifiableMap<K>) obj, f);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Float f, Float f2) {
            return replace((UnmodifiableMap<K>) obj, f, f2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Float putIfAbsent(Object obj, Float f) {
            return putIfAbsent((UnmodifiableMap<K>) obj, f);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Reference2FloatMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean containsValue(float v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public ObjectSet<Reference2FloatMap.Entry<K>> reference2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.reference2FloatEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Float>> entrySet() {
            return reference2FloatEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public ReferenceSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction
        public float getOrDefault(Object key, float defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Float> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Float, ? extends Float> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float putIfAbsent(K key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean remove(Object key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float replace(K key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public boolean replace(K key, float oldValue, float newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeIfAbsent(K key, Reference2FloatFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeFloatIfPresent(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float computeFloat(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        public float merge(K key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public Float replace(K key, Float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public boolean replace(K key, Float oldValue, Float newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public Float putIfAbsent(K key, Float value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Float computeIfAbsent(K key, Function<? super K, ? extends Float> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Float computeIfPresent(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Float compute(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2FloatMap
        @Deprecated
        public Float merge(K key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Reference2FloatMap<K> unmodifiable(Reference2FloatMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
