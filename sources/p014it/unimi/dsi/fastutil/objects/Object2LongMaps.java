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
import java.util.function.ToLongFunction;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollections;
import p014it.unimi.dsi.fastutil.longs.LongSets;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2LongMap;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunctions;
import p014it.unimi.dsi.fastutil.objects.Object2LongMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2LongMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongMaps.class */
public final class Object2LongMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Object2LongMaps() {
    }

    public static <K> ObjectIterator<Object2LongMap.Entry<K>> fastIterator(Object2LongMap<K> map) {
        ObjectSet<Object2LongMap.Entry<K>> entries = map.object2LongEntrySet();
        return entries instanceof Object2LongMap.FastEntrySet ? ((Object2LongMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Object2LongMap<K> map, Consumer<? super Object2LongMap.Entry<K>> consumer) {
        ObjectSet<Object2LongMap.Entry<K>> entries = map.object2LongEntrySet();
        if (entries instanceof Object2LongMap.FastEntrySet) {
            ((Object2LongMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Object2LongMap.Entry<K>> fastIterable(Object2LongMap<K> map) {
        final ObjectSet<Object2LongMap.Entry<K>> entries = map.object2LongEntrySet();
        return entries instanceof Object2LongMap.FastEntrySet ? new ObjectIterable<Object2LongMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2LongMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Object2LongMap.Entry<K>> iterator() {
                return ((Object2LongMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Object2LongMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Object2LongMap.Entry<K>> consumer) {
                ((Object2LongMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Object2LongFunctions.EmptyFunction<K> implements Object2LongMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean containsValue(long v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Object2LongFunction
        public long getOrDefault(Object key, long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public ObjectSet<K> keySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public Collection<Long> values() {
            return LongSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Long> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Object2LongMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Object2LongMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongMaps$Singleton.class */
    public static class Singleton<K> extends Object2LongFunctions.Singleton<K> implements Object2LongMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Object2LongMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient LongCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, long value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean containsValue(long v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Long) ov).longValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractObject2LongMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Long>> entrySet() {
            return object2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
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
            return (this.key == null ? 0 : this.key.hashCode()) ^ HashCommon.long2int(this.value);
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

    public static <K> Object2LongMap<K> singleton(K key, long value) {
        return new Singleton(key, value);
    }

    public static <K> Object2LongMap<K> singleton(K key, Long value) {
        return new Singleton(key, value.longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Object2LongFunctions.SynchronizedFunction<K> implements Object2LongMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2LongMap<K> map;
        protected transient ObjectSet<Object2LongMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient LongCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Long merge(Object obj, Long l, BiFunction<? super Long, ? super Long, ? extends Long> biFunction) {
            return merge((SynchronizedMap<K>) obj, l, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Long replace(Object obj, Long l) {
            return replace((SynchronizedMap<K>) obj, l);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Long l, Long l2) {
            return replace((SynchronizedMap<K>) obj, l, l2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Long putIfAbsent(Object obj, Long l) {
            return putIfAbsent((SynchronizedMap<K>) obj, l);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2LongMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2LongMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean containsValue(long v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Long> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            ObjectSet<Object2LongMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.object2LongEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Long>> entrySet() {
            return object2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.longs.LongCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2LongFunction
        public long getOrDefault(Object key, long defaultValue) {
            long orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Long> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Long, ? extends Long> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long putIfAbsent(K key, long value) {
            long putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2LongMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean remove(Object key, long value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long replace(K key, long value) {
            long replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2LongMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean replace(K key, long oldValue, long newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2LongMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeIfAbsent(K key, ToLongFunction<? super K> mappingFunction) {
            long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2LongMap<K>) key, (ToLongFunction<? super Object2LongMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeIfAbsent(K key, Object2LongFunction<? super K> mappingFunction) {
            long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2LongMap<K>) key, (Object2LongFunction<? super Object2LongMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeLongIfPresent(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            long computeLongIfPresent;
            synchronized (this.sync) {
                computeLongIfPresent = this.map.computeLongIfPresent(key, remappingFunction);
            }
            return computeLongIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeLong(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            long computeLong;
            synchronized (this.sync) {
                computeLong = this.map.computeLong(key, remappingFunction);
            }
            return computeLong;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long merge(K key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            long merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2LongMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            Long orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public Long replace(K key, Long value) {
            Long replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2LongMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public boolean replace(K key, Long oldValue, Long newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2LongMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public Long putIfAbsent(K key, Long value) {
            Long putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2LongMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Long computeIfAbsent(K key, Function<? super K, ? extends Long> mappingFunction) {
            Long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2LongMap<K>) key, (Function<? super Object2LongMap<K>, ? extends Long>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Long computeIfPresent(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            Long computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Long compute(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            Long compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public Long merge(K key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            Long merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2LongMap<K>) key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Object2LongMap<K> synchronize(Object2LongMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Object2LongMap<K> synchronize(Object2LongMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2LongMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2LongMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Object2LongFunctions.UnmodifiableFunction<K> implements Object2LongMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2LongMap<? extends K> map;
        protected transient ObjectSet<Object2LongMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient LongCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Long merge(Object obj, Long l, BiFunction<? super Long, ? super Long, ? extends Long> biFunction) {
            return merge((UnmodifiableMap<K>) obj, l, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Long replace(Object obj, Long l) {
            return replace((UnmodifiableMap<K>) obj, l);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Long l, Long l2) {
            return replace((UnmodifiableMap<K>) obj, l, l2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Long putIfAbsent(Object obj, Long l) {
            return putIfAbsent((UnmodifiableMap<K>) obj, l);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Object2LongMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean containsValue(long v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, p014it.unimi.dsi.fastutil.objects.Object2LongSortedMap
        public ObjectSet<Object2LongMap.Entry<K>> object2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.object2LongEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Long>> entrySet() {
            return object2LongEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.longs.LongCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2LongFunction
        public long getOrDefault(Object key, long defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Long> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Long, ? extends Long> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long putIfAbsent(K key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean remove(Object key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long replace(K key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public boolean replace(K key, long oldValue, long newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeIfAbsent(K key, ToLongFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeIfAbsent(K key, Object2LongFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeLongIfPresent(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long computeLong(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        public long merge(K key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public Long replace(K key, Long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public boolean replace(K key, Long oldValue, Long newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public Long putIfAbsent(K key, Long value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Long computeIfAbsent(K key, Function<? super K, ? extends Long> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Long computeIfPresent(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Long compute(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
        @Deprecated
        public Long merge(K key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2LongMap<K> unmodifiable(Object2LongMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
