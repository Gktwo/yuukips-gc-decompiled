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
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap;
import p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions;
import p014it.unimi.dsi.fastutil.objects.Object2ShortMap;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollections;
import p014it.unimi.dsi.fastutil.shorts.ShortSets;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortMaps.class */
public final class Object2ShortMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Object2ShortMaps() {
    }

    public static <K> ObjectIterator<Object2ShortMap.Entry<K>> fastIterator(Object2ShortMap<K> map) {
        ObjectSet<Object2ShortMap.Entry<K>> entries = map.object2ShortEntrySet();
        return entries instanceof Object2ShortMap.FastEntrySet ? ((Object2ShortMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Object2ShortMap<K> map, Consumer<? super Object2ShortMap.Entry<K>> consumer) {
        ObjectSet<Object2ShortMap.Entry<K>> entries = map.object2ShortEntrySet();
        if (entries instanceof Object2ShortMap.FastEntrySet) {
            ((Object2ShortMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Object2ShortMap.Entry<K>> fastIterable(Object2ShortMap<K> map) {
        final ObjectSet<Object2ShortMap.Entry<K>> entries = map.object2ShortEntrySet();
        return entries instanceof Object2ShortMap.FastEntrySet ? new ObjectIterable<Object2ShortMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2ShortMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Object2ShortMap.Entry<K>> iterator() {
                return ((Object2ShortMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Object2ShortMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Object2ShortMap.Entry<K>> consumer) {
                ((Object2ShortMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Object2ShortFunctions.EmptyFunction<K> implements Object2ShortMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean containsValue(short v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object key, short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public ObjectSet<K> keySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public Collection<Short> values() {
            return ShortSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Short> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Object2ShortMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Object2ShortMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortMaps$Singleton.class */
    public static class Singleton<K> extends Object2ShortFunctions.Singleton<K> implements Object2ShortMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Object2ShortMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, short value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean containsValue(short v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Short) ov).shortValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractObject2ShortMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Short>> entrySet() {
            return object2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public Collection<Short> values() {
            if (this.values == null) {
                this.values = ShortSets.singleton(this.value);
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
            return "{" + this.key + "=>" + ((int) this.value) + "}";
        }
    }

    public static <K> Object2ShortMap<K> singleton(K key, short value) {
        return new Singleton(key, value);
    }

    public static <K> Object2ShortMap<K> singleton(K key, Short value) {
        return new Singleton(key, value.shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Object2ShortFunctions.SynchronizedFunction<K> implements Object2ShortMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ShortMap<K> map;
        protected transient ObjectSet<Object2ShortMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient ShortCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Short merge(Object obj, Short sh, BiFunction<? super Short, ? super Short, ? extends Short> biFunction) {
            return merge((SynchronizedMap<K>) obj, sh, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Short replace(Object obj, Short sh) {
            return replace((SynchronizedMap<K>) obj, sh);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Short sh, Short sh2) {
            return replace((SynchronizedMap<K>) obj, sh, sh2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Short putIfAbsent(Object obj, Short sh) {
            return putIfAbsent((SynchronizedMap<K>) obj, sh);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2ShortMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2ShortMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean containsValue(short v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Short> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            ObjectSet<Object2ShortMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.object2ShortEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Short>> entrySet() {
            return object2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public Collection<Short> values() {
            ShortCollection shortCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = ShortCollections.synchronize(this.map.values(), this.sync);
                }
                shortCollection = this.values;
            }
            return shortCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object key, short defaultValue) {
            short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Short> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Short, ? extends Short> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short putIfAbsent(K key, short value) {
            short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2ShortMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean remove(Object key, short value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short replace(K key, short value) {
            short replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ShortMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean replace(K key, short oldValue, short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ShortMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2ShortMap<K>) key, (ToIntFunction<? super Object2ShortMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeIfAbsent(K key, Object2ShortFunction<? super K> mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2ShortMap<K>) key, (Object2ShortFunction<? super Object2ShortMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeShortIfPresent(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            short computeShortIfPresent;
            synchronized (this.sync) {
                computeShortIfPresent = this.map.computeShortIfPresent(key, remappingFunction);
            }
            return computeShortIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeShort(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            short computeShort;
            synchronized (this.sync) {
                computeShort = this.map.computeShort(key, remappingFunction);
            }
            return computeShort;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short merge(K key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            short merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2ShortMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            Short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public Short replace(K key, Short value) {
            Short replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ShortMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public boolean replace(K key, Short oldValue, Short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ShortMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public Short putIfAbsent(K key, Short value) {
            Short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2ShortMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Short computeIfAbsent(K key, Function<? super K, ? extends Short> mappingFunction) {
            Short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2ShortMap<K>) key, (Function<? super Object2ShortMap<K>, ? extends Short>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Short computeIfPresent(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            Short computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Short compute(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            Short compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public Short merge(K key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            Short merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2ShortMap<K>) key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Object2ShortMap<K> synchronize(Object2ShortMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Object2ShortMap<K> synchronize(Object2ShortMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Object2ShortFunctions.UnmodifiableFunction<K> implements Object2ShortMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ShortMap<? extends K> map;
        protected transient ObjectSet<Object2ShortMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient ShortCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Short merge(Object obj, Short sh, BiFunction<? super Short, ? super Short, ? extends Short> biFunction) {
            return merge((UnmodifiableMap<K>) obj, sh, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Short replace(Object obj, Short sh) {
            return replace((UnmodifiableMap<K>) obj, sh);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Short sh, Short sh2) {
            return replace((UnmodifiableMap<K>) obj, sh, sh2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Short putIfAbsent(Object obj, Short sh) {
            return putIfAbsent((UnmodifiableMap<K>) obj, sh);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Object2ShortMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean containsValue(short v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, p014it.unimi.dsi.fastutil.objects.Object2ShortSortedMap
        public ObjectSet<Object2ShortMap.Entry<K>> object2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.object2ShortEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Short>> entrySet() {
            return object2ShortEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public Collection<Short> values() {
            if (this.values == null) {
                this.values = ShortCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object key, short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Short> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Short, ? extends Short> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short putIfAbsent(K key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean remove(Object key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short replace(K key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public boolean replace(K key, short oldValue, short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeIfAbsent(K key, Object2ShortFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeShortIfPresent(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short computeShort(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        public short merge(K key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public Short replace(K key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public boolean replace(K key, Short oldValue, Short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public Short putIfAbsent(K key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Short computeIfAbsent(K key, Function<? super K, ? extends Short> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Short computeIfPresent(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Short compute(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
        @Deprecated
        public Short merge(K key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2ShortMap<K> unmodifiable(Object2ShortMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
