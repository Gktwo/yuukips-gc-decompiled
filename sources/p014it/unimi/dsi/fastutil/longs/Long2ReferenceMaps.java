package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongFunction;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollections;
import p014it.unimi.dsi.fastutil.objects.ReferenceSets;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceMaps.class */
public final class Long2ReferenceMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Long2ReferenceMaps() {
    }

    public static <V> ObjectIterator<Long2ReferenceMap.Entry<V>> fastIterator(Long2ReferenceMap<V> map) {
        ObjectSet<Long2ReferenceMap.Entry<V>> entries = map.long2ReferenceEntrySet();
        return entries instanceof Long2ReferenceMap.FastEntrySet ? ((Long2ReferenceMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> void fastForEach(Long2ReferenceMap<V> map, Consumer<? super Long2ReferenceMap.Entry<V>> consumer) {
        ObjectSet<Long2ReferenceMap.Entry<V>> entries = map.long2ReferenceEntrySet();
        if (entries instanceof Long2ReferenceMap.FastEntrySet) {
            ((Long2ReferenceMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <V> ObjectIterable<Long2ReferenceMap.Entry<V>> fastIterable(Long2ReferenceMap<V> map) {
        final ObjectSet<Long2ReferenceMap.Entry<V>> entries = map.long2ReferenceEntrySet();
        return entries instanceof Long2ReferenceMap.FastEntrySet ? new ObjectIterable<Long2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Long2ReferenceMap.Entry<V>> iterator() {
                return ((Long2ReferenceMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Long2ReferenceMap.Entry<V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Long2ReferenceMap.Entry<V>> consumer) {
                ((Long2ReferenceMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceMaps$EmptyMap.class */
    public static class EmptyMap<V> extends Long2ReferenceFunctions.EmptyFunction<V> implements Long2ReferenceMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
        public V getOrDefault(long key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public ObjectSet<Long2ReferenceMap.Entry<V>> long2ReferenceEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public Set<Long> keySet() {
            return LongSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            return ReferenceSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Long2ReferenceMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <V> Long2ReferenceMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceMaps$Singleton.class */
    public static class Singleton<V> extends Long2ReferenceFunctions.Singleton<V> implements Long2ReferenceMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Long2ReferenceMap.Entry<V>> entries;
        protected transient LongSet keys;
        protected transient ReferenceCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(long key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.value == v;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public ObjectSet<Long2ReferenceMap.Entry<V>> long2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractLong2ReferenceMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Long, V>> entrySet() {
            return long2ReferenceEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public Set<Long> keySet() {
            if (this.keys == null) {
                this.keys = LongSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            if (this.values == null) {
                this.values = ReferenceSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ (this.value == null ? 0 : System.identityHashCode(this.value));
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

    public static <V> Long2ReferenceMap<V> singleton(long key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Long2ReferenceMap<V> singleton(Long key, V value) {
        return new Singleton(key.longValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceMaps$SynchronizedMap.class */
    public static class SynchronizedMap<V> extends Long2ReferenceFunctions.SynchronizedFunction<V> implements Long2ReferenceMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ReferenceMap<V> map;
        protected transient ObjectSet<Long2ReferenceMap.Entry<V>> entries;
        protected transient LongSet keys;
        protected transient ReferenceCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Long l, Object obj, BiFunction biFunction) {
            return merge(l, (Long) obj, (BiFunction<? super Long, ? super Long, ? extends Long>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Long l, Object obj) {
            return replace(l, (Long) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Long l, Object obj) {
            return putIfAbsent(l, (Long) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Long2ReferenceMap<V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Long2ReferenceMap<V> m) {
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
        public void putAll(Map<? extends Long, ? extends V> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public ObjectSet<Long2ReferenceMap.Entry<V>> long2ReferenceEntrySet() {
            ObjectSet<Long2ReferenceMap.Entry<V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.long2ReferenceEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Long, V>> entrySet() {
            return long2ReferenceEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.longs.LongSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public Set<Long> keySet() {
            LongSet longSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = LongSets.synchronize(this.map.keySet(), this.sync);
                }
                longSet = this.keys;
            }
            return longSet;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            ReferenceCollection<V> referenceCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = ReferenceCollections.synchronize(this.map.values(), this.sync);
                }
                referenceCollection = this.values;
            }
            return referenceCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
        public V getOrDefault(long key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, (long) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super V> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Long, ? super V, ? extends V> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V putIfAbsent(long key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, (long) value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public boolean remove(long key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V replace(long key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, (long) value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public boolean replace(long key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V computeIfAbsent(long key, LongFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V computeIfAbsent(long key, Long2ReferenceFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, (Long2ReferenceFunction) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V computeIfPresent(long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V compute(long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V merge(long key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, (long) value, (BiFunction<? super long, ? super long, ? extends long>) remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Long key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace((Long2ReferenceMap<V>) key, (Long) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Long key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Long2ReferenceMap<V>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public V putIfAbsent(Long key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Long2ReferenceMap<V>) key, (Long) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public V computeIfAbsent(Long key, Function<? super Long, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Long2ReferenceMap<V>) key, (Function<? super Long2ReferenceMap<V>, ? extends V>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public V computeIfPresent(Long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Long2ReferenceMap<V>) key, (BiFunction<? super Long2ReferenceMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public V compute(Long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute((Long2ReferenceMap<V>) key, (BiFunction<? super Long2ReferenceMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public V merge(Long key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge((Long2ReferenceMap<V>) key, (Long) value, (BiFunction<? super Long, ? super Long, ? extends Long>) remappingFunction);
            }
            return merge;
        }
    }

    public static <V> Long2ReferenceMap<V> synchronize(Long2ReferenceMap<V> m) {
        return new SynchronizedMap(m);
    }

    public static <V> Long2ReferenceMap<V> synchronize(Long2ReferenceMap<V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<V> extends Long2ReferenceFunctions.UnmodifiableFunction<V> implements Long2ReferenceMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ReferenceMap<? extends V> map;
        protected transient ObjectSet<Long2ReferenceMap.Entry<V>> entries;
        protected transient LongSet keys;
        protected transient ReferenceCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Long l, Object obj, BiFunction biFunction) {
            return merge(l, (Long) obj, (BiFunction<? super Long, ? super Long, ? extends Long>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Long l, Object obj) {
            return replace(l, (Long) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Long l, Object obj) {
            return putIfAbsent(l, (Long) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Long2ReferenceMap<? extends V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.map.containsValue(v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public ObjectSet<Long2ReferenceMap.Entry<V>> long2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.long2ReferenceEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Long, V>> entrySet() {
            return long2ReferenceEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.longs.LongSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public Set<Long> keySet() {
            if (this.keys == null) {
                this.keys = LongSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            if (this.values == null) {
                this.values = ReferenceCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
        public V getOrDefault(long key, V defaultValue) {
            return (V) this.map.getOrDefault(key, (long) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Long, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V putIfAbsent(long key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public boolean remove(long key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V replace(long key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public boolean replace(long key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V computeIfAbsent(long key, LongFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V computeIfAbsent(long key, Long2ReferenceFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V computeIfPresent(long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V compute(long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public V merge(long key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Long key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Long key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V putIfAbsent(Long key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfAbsent(Long key, Function<? super Long, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfPresent(Long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V compute(Long key, BiFunction<? super Long, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V merge(Long key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Long2ReferenceMap<V> unmodifiable(Long2ReferenceMap<? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
