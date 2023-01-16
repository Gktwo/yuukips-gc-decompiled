package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.objects.AbstractReference2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectMaps.class */
public final class Reference2ObjectMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Reference2ObjectMaps() {
    }

    public static <K, V> ObjectIterator<Reference2ObjectMap.Entry<K, V>> fastIterator(Reference2ObjectMap<K, V> map) {
        ObjectSet<Reference2ObjectMap.Entry<K, V>> entries = map.reference2ObjectEntrySet();
        return entries instanceof Reference2ObjectMap.FastEntrySet ? ((Reference2ObjectMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K, V> void fastForEach(Reference2ObjectMap<K, V> map, Consumer<? super Reference2ObjectMap.Entry<K, V>> consumer) {
        ObjectSet<Reference2ObjectMap.Entry<K, V>> entries = map.reference2ObjectEntrySet();
        if (entries instanceof Reference2ObjectMap.FastEntrySet) {
            ((Reference2ObjectMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K, V> ObjectIterable<Reference2ObjectMap.Entry<K, V>> fastIterable(Reference2ObjectMap<K, V> map) {
        final ObjectSet<Reference2ObjectMap.Entry<K, V>> entries = map.reference2ObjectEntrySet();
        return entries instanceof Reference2ObjectMap.FastEntrySet ? new ObjectIterable<Reference2ObjectMap.Entry<K, V>>() { // from class: it.unimi.dsi.fastutil.objects.Reference2ObjectMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Reference2ObjectMap.Entry<K, V>> iterator() {
                return ((Reference2ObjectMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Reference2ObjectMap.Entry<K, V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Reference2ObjectMap.Entry<K, V>> consumer) {
                ((Reference2ObjectMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectMaps$EmptyMap.class */
    public static class EmptyMap<K, V> extends Reference2ObjectFunctions.EmptyFunction<K, V> implements Reference2ObjectMap<K, V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ReferenceSet<K> keySet() {
            return ReferenceSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Reference2ObjectMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K, V> Reference2ObjectMap<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectMaps$Singleton.class */
    public static class Singleton<K, V> extends Reference2ObjectFunctions.Singleton<K, V> implements Reference2ObjectMap<K, V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Reference2ObjectMap.Entry<K, V>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(K key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return Objects.equals(this.value, v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractReference2ObjectMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectSet<Map.Entry<K, V>> entrySet() {
            return reference2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ReferenceSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
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
            return System.identityHashCode(this.key) ^ (this.value == null ? 0 : this.value.hashCode());
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

    public static <K, V> Reference2ObjectMap<K, V> singleton(K key, V value) {
        return new Singleton(key, value);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K, V> extends Reference2ObjectFunctions.SynchronizedFunction<K, V> implements Reference2ObjectMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ObjectMap<K, V> map;
        protected transient ObjectSet<Reference2ObjectMap.Entry<K, V>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Reference2ObjectMap<K, V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Reference2ObjectMap<K, V> m) {
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
        public void putAll(Map<? extends K, ? extends V> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            ObjectSet<Reference2ObjectMap.Entry<K, V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.reference2ObjectEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectSet<Map.Entry<K, V>> entrySet() {
            return reference2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V getOrDefault(Object key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V putIfAbsent(K key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V replace(K key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public boolean replace(K key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K, V> Reference2ObjectMap<K, V> synchronize(Reference2ObjectMap<K, V> m) {
        return new SynchronizedMap(m);
    }

    public static <K, V> Reference2ObjectMap<K, V> synchronize(Reference2ObjectMap<K, V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K, V> extends Reference2ObjectFunctions.UnmodifiableFunction<K, V> implements Reference2ObjectMap<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ObjectMap<? extends K, ? extends V> map;
        protected transient ObjectSet<Reference2ObjectMap.Entry<K, V>> entries;
        protected transient ReferenceSet<K> keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Reference2ObjectMap<? extends K, ? extends V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.map.containsValue(v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap
        public ObjectSet<Reference2ObjectMap.Entry<K, V>> reference2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.reference2ObjectEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ObjectSet<Map.Entry<K, V>> entrySet() {
            return reference2ObjectEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public ReferenceSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ReferenceSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V getOrDefault(Object key, V defaultValue) {
            return (V) this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V putIfAbsent(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V replace(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public boolean replace(K key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectMap, java.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K, V> Reference2ObjectMap<K, V> unmodifiable(Reference2ObjectMap<? extends K, ? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
