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
import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntCollections;
import p014it.unimi.dsi.fastutil.ints.IntSets;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunctions;
import p014it.unimi.dsi.fastutil.objects.Object2IntMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2IntMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntMaps.class */
public final class Object2IntMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Object2IntMaps() {
    }

    public static <K> ObjectIterator<Object2IntMap.Entry<K>> fastIterator(Object2IntMap<K> map) {
        ObjectSet<Object2IntMap.Entry<K>> entries = map.object2IntEntrySet();
        return entries instanceof Object2IntMap.FastEntrySet ? ((Object2IntMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Object2IntMap<K> map, Consumer<? super Object2IntMap.Entry<K>> consumer) {
        ObjectSet<Object2IntMap.Entry<K>> entries = map.object2IntEntrySet();
        if (entries instanceof Object2IntMap.FastEntrySet) {
            ((Object2IntMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Object2IntMap.Entry<K>> fastIterable(Object2IntMap<K> map) {
        final ObjectSet<Object2IntMap.Entry<K>> entries = map.object2IntEntrySet();
        return entries instanceof Object2IntMap.FastEntrySet ? new ObjectIterable<Object2IntMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2IntMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Object2IntMap.Entry<K>> iterator() {
                return ((Object2IntMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Object2IntMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Object2IntMap.Entry<K>> consumer) {
                ((Object2IntMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Object2IntFunctions.EmptyFunction<K> implements Object2IntMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean containsValue(int v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object key, int defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Integer> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap
        public ObjectSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public ObjectSet<K> keySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public Collection<Integer> values() {
            return IntSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Integer> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Object2IntMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Object2IntMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntMaps$Singleton.class */
    public static class Singleton<K> extends Object2IntFunctions.Singleton<K> implements Object2IntMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Object2IntMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient IntCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, int value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean containsValue(int v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Integer) ov).intValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Integer> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap
        public ObjectSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractObject2IntMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Integer>> entrySet() {
            return object2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public Collection<Integer> values() {
            if (this.values == null) {
                this.values = IntSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ this.value;
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

    public static <K> Object2IntMap<K> singleton(K key, int value) {
        return new Singleton(key, value);
    }

    public static <K> Object2IntMap<K> singleton(K key, Integer value) {
        return new Singleton(key, value.intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Object2IntFunctions.SynchronizedFunction<K> implements Object2IntMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2IntMap<K> map;
        protected transient ObjectSet<Object2IntMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient IntCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Integer merge(Object obj, Integer num, BiFunction<? super Integer, ? super Integer, ? extends Integer> biFunction) {
            return merge((SynchronizedMap<K>) obj, num, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Integer replace(Object obj, Integer num) {
            return replace((SynchronizedMap<K>) obj, num);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Integer num, Integer num2) {
            return replace((SynchronizedMap<K>) obj, num, num2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Integer putIfAbsent(Object obj, Integer num) {
            return putIfAbsent((SynchronizedMap<K>) obj, num);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2IntMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2IntMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean containsValue(int v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Integer> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap
        public ObjectSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
            ObjectSet<Object2IntMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.object2IntEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Integer>> entrySet() {
            return object2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public ObjectSet<K> keySet() {
            ObjectSet<K> objectSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = ObjectSets.synchronize(this.map.keySet(), this.sync);
                }
                objectSet = this.keys;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.ints.IntCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public Collection<Integer> values() {
            IntCollection intCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = IntCollections.synchronize(this.map.values(), this.sync);
                }
                intCollection = this.values;
            }
            return intCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object key, int defaultValue) {
            int orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Integer> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Integer, ? extends Integer> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int putIfAbsent(K key, int value) {
            int putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2IntMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean remove(Object key, int value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int replace(K key, int value) {
            int replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2IntMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean replace(K key, int oldValue, int newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2IntMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            int computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2IntMap<K>) key, (ToIntFunction<? super Object2IntMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeIfAbsent(K key, Object2IntFunction<? super K> mappingFunction) {
            int computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2IntMap<K>) key, (Object2IntFunction<? super Object2IntMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeIntIfPresent(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            int computeIntIfPresent;
            synchronized (this.sync) {
                computeIntIfPresent = this.map.computeIntIfPresent(key, remappingFunction);
            }
            return computeIntIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeInt(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            int computeInt;
            synchronized (this.sync) {
                computeInt = this.map.computeInt(key, remappingFunction);
            }
            return computeInt;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int merge(K key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            int merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2IntMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            Integer orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public Integer replace(K key, Integer value) {
            Integer replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2IntMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public boolean replace(K key, Integer oldValue, Integer newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2IntMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public Integer putIfAbsent(K key, Integer value) {
            Integer putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2IntMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Integer computeIfAbsent(K key, Function<? super K, ? extends Integer> mappingFunction) {
            Integer computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2IntMap<K>) key, (Function<? super Object2IntMap<K>, ? extends Integer>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Integer computeIfPresent(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            Integer computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Integer compute(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            Integer compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public Integer merge(K key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            Integer merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2IntMap<K>) key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Object2IntMap<K> synchronize(Object2IntMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Object2IntMap<K> synchronize(Object2IntMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Object2IntFunctions.UnmodifiableFunction<K> implements Object2IntMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2IntMap<? extends K> map;
        protected transient ObjectSet<Object2IntMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient IntCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Integer merge(Object obj, Integer num, BiFunction<? super Integer, ? super Integer, ? extends Integer> biFunction) {
            return merge((UnmodifiableMap<K>) obj, num, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Integer replace(Object obj, Integer num) {
            return replace((UnmodifiableMap<K>) obj, num);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Integer num, Integer num2) {
            return replace((UnmodifiableMap<K>) obj, num, num2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Integer putIfAbsent(Object obj, Integer num) {
            return putIfAbsent((UnmodifiableMap<K>) obj, num);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Object2IntMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean containsValue(int v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Integer> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap
        public ObjectSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.object2IntEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Integer>> entrySet() {
            return object2IntEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.ints.IntCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public Collection<Integer> values() {
            if (this.values == null) {
                this.values = IntCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object key, int defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Integer> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Integer, ? extends Integer> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int putIfAbsent(K key, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean remove(Object key, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int replace(K key, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean replace(K key, int oldValue, int newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeIfAbsent(K key, Object2IntFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeIntIfPresent(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int computeInt(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public int merge(K key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public Integer replace(K key, Integer value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public boolean replace(K key, Integer oldValue, Integer newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public Integer putIfAbsent(K key, Integer value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Integer computeIfAbsent(K key, Function<? super K, ? extends Integer> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Integer computeIfPresent(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Integer compute(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap
        @Deprecated
        public Integer merge(K key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2IntMap<K> unmodifiable(Object2IntMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
