package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions;
import p014it.unimi.dsi.fastutil.longs.Long2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollections;
import p014it.unimi.dsi.fastutil.shorts.ShortSets;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMaps.class */
public final class Long2ShortMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Long2ShortMaps() {
    }

    public static ObjectIterator<Long2ShortMap.Entry> fastIterator(Long2ShortMap map) {
        ObjectSet<Long2ShortMap.Entry> entries = map.long2ShortEntrySet();
        return entries instanceof Long2ShortMap.FastEntrySet ? ((Long2ShortMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Long2ShortMap map, Consumer<? super Long2ShortMap.Entry> consumer) {
        ObjectSet<Long2ShortMap.Entry> entries = map.long2ShortEntrySet();
        if (entries instanceof Long2ShortMap.FastEntrySet) {
            ((Long2ShortMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Long2ShortMap.Entry> fastIterable(Long2ShortMap map) {
        final ObjectSet<Long2ShortMap.Entry> entries = map.long2ShortEntrySet();
        return entries instanceof Long2ShortMap.FastEntrySet ? new ObjectIterable<Long2ShortMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2ShortMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Long2ShortMap.Entry> iterator() {
                return ((Long2ShortMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Long2ShortMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Long2ShortMap.Entry> consumer) {
                ((Long2ShortMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMaps$EmptyMap.class */
    public static class EmptyMap extends Long2ShortFunctions.EmptyFunction implements Long2ShortMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean containsValue(short v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
        public short getOrDefault(long key, short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, p014it.unimi.dsi.fastutil.longs.Long2ShortSortedMap
        public ObjectSet<Long2ShortMap.Entry> long2ShortEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        public Set<Long> keySet() {
            return LongSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        public Collection<Short> values() {
            return ShortSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super Short> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Long2ShortMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMaps$Singleton.class */
    public static class Singleton extends Long2ShortFunctions.Singleton implements Long2ShortMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Long2ShortMap.Entry> entries;
        protected transient LongSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public Singleton(long key, short value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean containsValue(short v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Short) ov).shortValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, p014it.unimi.dsi.fastutil.longs.Long2ShortSortedMap
        public ObjectSet<Long2ShortMap.Entry> long2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractLong2ShortMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Long, Short>> entrySet() {
            return long2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        public Set<Long> keySet() {
            if (this.keys == null) {
                this.keys = LongSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
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
            return HashCommon.long2int(this.key) ^ this.value;
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
            return "{" + this.key + "=>" + ((int) this.value) + "}";
        }
    }

    public static Long2ShortMap singleton(long key, short value) {
        return new Singleton(key, value);
    }

    public static Long2ShortMap singleton(Long key, Short value) {
        return new Singleton(key.longValue(), value.shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Long2ShortFunctions.SynchronizedFunction implements Long2ShortMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ShortMap map;
        protected transient ObjectSet<Long2ShortMap.Entry> entries;
        protected transient LongSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Long2ShortMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Long2ShortMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean containsValue(short v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Short> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, p014it.unimi.dsi.fastutil.longs.Long2ShortSortedMap
        public ObjectSet<Long2ShortMap.Entry> long2ShortEntrySet() {
            ObjectSet<Long2ShortMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.long2ShortEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Long, Short>> entrySet() {
            return long2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.longs.LongSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
        public short getOrDefault(long key, short defaultValue) {
            short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super Short> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Long, ? super Short, ? extends Short> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short putIfAbsent(long key, short value) {
            short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean remove(long key, short value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short replace(long key, short value) {
            short replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean replace(long key, short oldValue, short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfAbsent(long key, LongToIntFunction mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfAbsentNullable(long key, LongFunction<? extends Short> mappingFunction) {
            short computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfAbsent(long key, Long2ShortFunction mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfPresent(long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            short computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short compute(long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            short compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short merge(long key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            short merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            Short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short replace(Long key, Short value) {
            Short replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public boolean replace(Long key, Short oldValue, Short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short putIfAbsent(Long key, Short value) {
            Short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short computeIfAbsent(Long key, Function<? super Long, ? extends Short> mappingFunction) {
            Short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short computeIfPresent(Long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            Short computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short compute(Long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            Short compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short merge(Long key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            Short merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Long2ShortMap synchronize(Long2ShortMap m) {
        return new SynchronizedMap(m);
    }

    public static Long2ShortMap synchronize(Long2ShortMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Long2ShortFunctions.UnmodifiableFunction implements Long2ShortMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2ShortMap map;
        protected transient ObjectSet<Long2ShortMap.Entry> entries;
        protected transient LongSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Long2ShortMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean containsValue(short v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, p014it.unimi.dsi.fastutil.longs.Long2ShortSortedMap
        public ObjectSet<Long2ShortMap.Entry> long2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.long2ShortEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Long, Short>> entrySet() {
            return long2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.longs.LongSet] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        public Set<Long> keySet() {
            if (this.keys == null) {
                this.keys = LongSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
        public short getOrDefault(long key, short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Long, ? super Short> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Long, ? super Short, ? extends Short> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short putIfAbsent(long key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean remove(long key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short replace(long key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public boolean replace(long key, short oldValue, short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfAbsent(long key, LongToIntFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfAbsentNullable(long key, LongFunction<? extends Short> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfAbsent(long key, Long2ShortFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short computeIfPresent(long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short compute(long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        public short merge(long key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short replace(Long key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public boolean replace(Long key, Short oldValue, Short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short putIfAbsent(Long key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short computeIfAbsent(Long key, Function<? super Long, ? extends Short> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short computeIfPresent(Long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short compute(Long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
        @Deprecated
        public Short merge(Long key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Long2ShortMap unmodifiable(Long2ShortMap m) {
        return new UnmodifiableMap(m);
    }
}
