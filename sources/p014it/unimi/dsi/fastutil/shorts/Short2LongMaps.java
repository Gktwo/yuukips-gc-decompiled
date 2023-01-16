package p014it.unimi.dsi.fastutil.shorts;

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
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.longs.LongCollections;
import p014it.unimi.dsi.fastutil.longs.LongSets;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2LongMap;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions;
import p014it.unimi.dsi.fastutil.shorts.Short2LongMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongMaps.class */
public final class Short2LongMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Short2LongMaps() {
    }

    public static ObjectIterator<Short2LongMap.Entry> fastIterator(Short2LongMap map) {
        ObjectSet<Short2LongMap.Entry> entries = map.short2LongEntrySet();
        return entries instanceof Short2LongMap.FastEntrySet ? ((Short2LongMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Short2LongMap map, Consumer<? super Short2LongMap.Entry> consumer) {
        ObjectSet<Short2LongMap.Entry> entries = map.short2LongEntrySet();
        if (entries instanceof Short2LongMap.FastEntrySet) {
            ((Short2LongMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Short2LongMap.Entry> fastIterable(Short2LongMap map) {
        final ObjectSet<Short2LongMap.Entry> entries = map.short2LongEntrySet();
        return entries instanceof Short2LongMap.FastEntrySet ? new ObjectIterable<Short2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.shorts.Short2LongMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Short2LongMap.Entry> iterator() {
                return ((Short2LongMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Short2LongMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Short2LongMap.Entry> consumer) {
                ((Short2LongMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongMaps$EmptyMap.class */
    public static class EmptyMap extends Short2LongFunctions.EmptyFunction implements Short2LongMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean containsValue(long v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
        public long getOrDefault(short key, long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSet<Short2LongMap.Entry> short2LongEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public Set<Short> keySet() {
            return ShortSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public Collection<Long> values() {
            return LongSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super Long> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Short2LongMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongMaps$Singleton.class */
    public static class Singleton extends Short2LongFunctions.Singleton implements Short2LongMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Short2LongMap.Entry> entries;
        protected transient ShortSet keys;
        protected transient LongCollection values;

        /* access modifiers changed from: protected */
        public Singleton(short key, long value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean containsValue(long v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Long) ov).longValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSet<Short2LongMap.Entry> short2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractShort2LongMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Long>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Short, Long>> entrySet() {
            return short2LongEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public Set<Short> keySet() {
            if (this.keys == null) {
                this.keys = ShortSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
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
            return this.key ^ HashCommon.long2int(this.value);
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
            return "{" + ((int) this.key) + "=>" + this.value + "}";
        }
    }

    public static Short2LongMap singleton(short key, long value) {
        return new Singleton(key, value);
    }

    public static Short2LongMap singleton(Short key, Long value) {
        return new Singleton(key.shortValue(), value.longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Short2LongFunctions.SynchronizedFunction implements Short2LongMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2LongMap map;
        protected transient ObjectSet<Short2LongMap.Entry> entries;
        protected transient ShortSet keys;
        protected transient LongCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Short2LongMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Short2LongMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean containsValue(long v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Long> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSet<Short2LongMap.Entry> short2LongEntrySet() {
            ObjectSet<Short2LongMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.short2LongEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Long>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Short, Long>> entrySet() {
            return short2LongEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.shorts.ShortSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.longs.LongCollection] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
        public long getOrDefault(short key, long defaultValue) {
            long orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super Long> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Short, ? super Long, ? extends Long> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long putIfAbsent(short key, long value) {
            long putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean remove(short key, long value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long replace(short key, long value) {
            long replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean replace(short key, long oldValue, long newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfAbsent(short key, IntToLongFunction mappingFunction) {
            long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfAbsentNullable(short key, IntFunction<? extends Long> mappingFunction) {
            long computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfAbsent(short key, Short2LongFunction mappingFunction) {
            long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfPresent(short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            long computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long compute(short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            long compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long merge(short key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            long merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            Long orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long replace(Short key, Long value) {
            Long replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public boolean replace(Short key, Long oldValue, Long newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long putIfAbsent(Short key, Long value) {
            Long putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long computeIfAbsent(Short key, Function<? super Short, ? extends Long> mappingFunction) {
            Long computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long computeIfPresent(Short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            Long computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long compute(Short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            Long compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long merge(Short key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            Long merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Short2LongMap synchronize(Short2LongMap m) {
        return new SynchronizedMap(m);
    }

    public static Short2LongMap synchronize(Short2LongMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2LongMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2LongMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Short2LongFunctions.UnmodifiableFunction implements Short2LongMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2LongMap map;
        protected transient ObjectSet<Short2LongMap.Entry> entries;
        protected transient ShortSet keys;
        protected transient LongCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Short2LongMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean containsValue(long v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Long> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, p014it.unimi.dsi.fastutil.shorts.Short2LongSortedMap
        public ObjectSet<Short2LongMap.Entry> short2LongEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.short2LongEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Long>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Short, Long>> entrySet() {
            return short2LongEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.shorts.ShortSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public Set<Short> keySet() {
            if (this.keys == null) {
                this.keys = ShortSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.longs.LongCollection] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
        public long getOrDefault(short key, long defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super Long> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Short, ? super Long, ? extends Long> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long putIfAbsent(short key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean remove(short key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long replace(short key, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public boolean replace(short key, long oldValue, long newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfAbsent(short key, IntToLongFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfAbsentNullable(short key, IntFunction<? extends Long> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfAbsent(short key, Short2LongFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long computeIfPresent(short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long compute(short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        public long merge(short key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.shorts.Short2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long replace(Short key, Long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public boolean replace(Short key, Long oldValue, Long newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long putIfAbsent(Short key, Long value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long computeIfAbsent(Short key, Function<? super Short, ? extends Long> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long computeIfPresent(Short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long compute(Short key, BiFunction<? super Short, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2LongMap
        @Deprecated
        public Long merge(Short key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Short2LongMap unmodifiable(Short2LongMap m) {
        return new UnmodifiableMap(m);
    }
}
