package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectMaps.class */
public final class Short2ObjectMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Short2ObjectMaps() {
    }

    public static <V> ObjectIterator<Short2ObjectMap.Entry<V>> fastIterator(Short2ObjectMap<V> map) {
        ObjectSet<Short2ObjectMap.Entry<V>> entries = map.short2ObjectEntrySet();
        return entries instanceof Short2ObjectMap.FastEntrySet ? ((Short2ObjectMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> void fastForEach(Short2ObjectMap<V> map, Consumer<? super Short2ObjectMap.Entry<V>> consumer) {
        ObjectSet<Short2ObjectMap.Entry<V>> entries = map.short2ObjectEntrySet();
        if (entries instanceof Short2ObjectMap.FastEntrySet) {
            ((Short2ObjectMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <V> ObjectIterable<Short2ObjectMap.Entry<V>> fastIterable(Short2ObjectMap<V> map) {
        final ObjectSet<Short2ObjectMap.Entry<V>> entries = map.short2ObjectEntrySet();
        return entries instanceof Short2ObjectMap.FastEntrySet ? new ObjectIterable<Short2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Short2ObjectMap.Entry<V>> iterator() {
                return ((Short2ObjectMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Short2ObjectMap.Entry<V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Short2ObjectMap.Entry<V>> consumer) {
                ((Short2ObjectMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectMaps$EmptyMap.class */
    public static class EmptyMap<V> extends Short2ObjectFunctions.EmptyFunction<V> implements Short2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public Set<Short> keySet() {
            return ShortSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Short2ObjectMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <V> Short2ObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectMaps$Singleton.class */
    public static class Singleton<V> extends Short2ObjectFunctions.Singleton<V> implements Short2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Short2ObjectMap.Entry<V>> entries;
        protected transient ShortSet keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(short key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return Objects.equals(this.value, v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractShort2ObjectMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Short, V>> entrySet() {
            return short2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public Set<Short> keySet() {
            if (this.keys == null) {
                this.keys = ShortSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
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
            return this.key ^ (this.value == null ? 0 : this.value.hashCode());
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
            return "{" + ((int) this.key) + "=>" + this.value + "}";
        }
    }

    public static <V> Short2ObjectMap<V> singleton(short key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Short2ObjectMap<V> singleton(Short key, V value) {
        return new Singleton(key.shortValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectMaps$SynchronizedMap.class */
    public static class SynchronizedMap<V> extends Short2ObjectFunctions.SynchronizedFunction<V> implements Short2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ObjectMap<V> map;
        protected transient ObjectSet<Short2ObjectMap.Entry<V>> entries;
        protected transient ShortSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Short sh, Object obj, BiFunction biFunction) {
            return merge(sh, (Short) obj, (BiFunction<? super Short, ? super Short, ? extends Short>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Short sh, Object obj) {
            return replace(sh, (Short) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Short sh, Object obj) {
            return putIfAbsent(sh, (Short) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Short2ObjectMap<V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Short2ObjectMap<V> m) {
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
        public void putAll(Map<? extends Short, ? extends V> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            ObjectSet<Short2ObjectMap.Entry<V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.short2ObjectEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Short, V>> entrySet() {
            return short2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.shorts.ShortSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public Set<Short> keySet() {
            ShortSet shortSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = ShortSets.synchronize(this.map.keySet(), this.sync);
                }
                shortSet = this.keys;
            }
            return shortSet;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, (short) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super V> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Short, ? super V, ? extends V> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V putIfAbsent(short key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, (short) value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean remove(short key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V replace(short key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, (short) value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean replace(short key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V computeIfAbsent(short key, IntFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V computeIfAbsent(short key, Short2ObjectFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, (Short2ObjectFunction) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V computeIfPresent(short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V compute(short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V merge(short key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, (short) value, (BiFunction<? super short, ? super short, ? extends short>) remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Short key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace((Short2ObjectMap<V>) key, (Short) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Short key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Short2ObjectMap<V>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public V putIfAbsent(Short key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Short2ObjectMap<V>) key, (Short) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public V computeIfAbsent(Short key, Function<? super Short, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Short2ObjectMap<V>) key, (Function<? super Short2ObjectMap<V>, ? extends V>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public V computeIfPresent(Short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Short2ObjectMap<V>) key, (BiFunction<? super Short2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public V compute(Short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute((Short2ObjectMap<V>) key, (BiFunction<? super Short2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public V merge(Short key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge((Short2ObjectMap<V>) key, (Short) value, (BiFunction<? super Short, ? super Short, ? extends Short>) remappingFunction);
            }
            return merge;
        }
    }

    public static <V> Short2ObjectMap<V> synchronize(Short2ObjectMap<V> m) {
        return new SynchronizedMap(m);
    }

    public static <V> Short2ObjectMap<V> synchronize(Short2ObjectMap<V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<V> extends Short2ObjectFunctions.UnmodifiableFunction<V> implements Short2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ObjectMap<? extends V> map;
        protected transient ObjectSet<Short2ObjectMap.Entry<V>> entries;
        protected transient ShortSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Short sh, Object obj, BiFunction biFunction) {
            return merge(sh, (Short) obj, (BiFunction<? super Short, ? super Short, ? extends Short>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Short sh, Object obj) {
            return replace(sh, (Short) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Short sh, Object obj) {
            return putIfAbsent(sh, (Short) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Short2ObjectMap<? extends V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.map.containsValue(v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.short2ObjectEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Short, V>> entrySet() {
            return short2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.shorts.ShortSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public Set<Short> keySet() {
            if (this.keys == null) {
                this.keys = ShortSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short key, V defaultValue) {
            return (V) this.map.getOrDefault(key, (short) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Short, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V putIfAbsent(short key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean remove(short key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V replace(short key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean replace(short key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V computeIfAbsent(short key, IntFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V computeIfAbsent(short key, Short2ObjectFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V computeIfPresent(short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V compute(short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public V merge(short key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Short key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Short key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V putIfAbsent(Short key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfAbsent(Short key, Function<? super Short, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfPresent(Short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V compute(Short key, BiFunction<? super Short, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V merge(Short key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Short2ObjectMap<V> unmodifiable(Short2ObjectMap<? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
