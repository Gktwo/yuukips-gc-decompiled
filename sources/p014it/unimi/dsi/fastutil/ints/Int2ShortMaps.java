package p014it.unimi.dsi.fastutil.ints;

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
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ShortMap;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions;
import p014it.unimi.dsi.fastutil.ints.Int2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollections;
import p014it.unimi.dsi.fastutil.shorts.ShortSets;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortMaps.class */
public final class Int2ShortMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Int2ShortMaps() {
    }

    public static ObjectIterator<Int2ShortMap.Entry> fastIterator(Int2ShortMap map) {
        ObjectSet<Int2ShortMap.Entry> entries = map.int2ShortEntrySet();
        return entries instanceof Int2ShortMap.FastEntrySet ? ((Int2ShortMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Int2ShortMap map, Consumer<? super Int2ShortMap.Entry> consumer) {
        ObjectSet<Int2ShortMap.Entry> entries = map.int2ShortEntrySet();
        if (entries instanceof Int2ShortMap.FastEntrySet) {
            ((Int2ShortMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Int2ShortMap.Entry> fastIterable(Int2ShortMap map) {
        final ObjectSet<Int2ShortMap.Entry> entries = map.int2ShortEntrySet();
        return entries instanceof Int2ShortMap.FastEntrySet ? new ObjectIterable<Int2ShortMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2ShortMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Int2ShortMap.Entry> iterator() {
                return ((Int2ShortMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Int2ShortMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Int2ShortMap.Entry> consumer) {
                ((Int2ShortMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortMaps$EmptyMap.class */
    public static class EmptyMap extends Int2ShortFunctions.EmptyFunction implements Int2ShortMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean containsValue(short v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
        public short getOrDefault(int key, short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public Set<Integer> keySet() {
            return IntSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public Collection<Short> values() {
            return ShortSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Integer, ? super Short> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Int2ShortMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortMaps$Singleton.class */
    public static class Singleton extends Int2ShortFunctions.Singleton implements Int2ShortMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Int2ShortMap.Entry> entries;
        protected transient IntSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public Singleton(int key, short value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean containsValue(short v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Short) ov).shortValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractInt2ShortMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Integer, Short>> entrySet() {
            return int2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public Set<Integer> keySet() {
            if (this.keys == null) {
                this.keys = IntSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
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
            return this.key ^ this.value;
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

    public static Int2ShortMap singleton(int key, short value) {
        return new Singleton(key, value);
    }

    public static Int2ShortMap singleton(Integer key, Short value) {
        return new Singleton(key.intValue(), value.shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Int2ShortFunctions.SynchronizedFunction implements Int2ShortMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2ShortMap map;
        protected transient ObjectSet<Int2ShortMap.Entry> entries;
        protected transient IntSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Int2ShortMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Int2ShortMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean containsValue(short v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ? extends Short> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            ObjectSet<Int2ShortMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.int2ShortEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Integer, Short>> entrySet() {
            return int2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.ints.IntSet] */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public Set<Integer> keySet() {
            IntSet intSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = IntSets.synchronize(this.map.keySet(), this.sync);
                }
                intSet = this.keys;
            }
            return intSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
        public short getOrDefault(int key, short defaultValue) {
            short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Integer, ? super Short> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Integer, ? super Short, ? extends Short> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short putIfAbsent(int key, short value) {
            short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean remove(int key, short value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short replace(int key, short value) {
            short replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean replace(int key, short oldValue, short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfAbsent(int key, IntUnaryOperator mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfAbsentNullable(int key, IntFunction<? extends Short> mappingFunction) {
            short computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfAbsent(int key, Int2ShortFunction mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfPresent(int key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            short computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short compute(int key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            short compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short merge(int key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            short merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            Short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short replace(Integer key, Short value) {
            Short replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public boolean replace(Integer key, Short oldValue, Short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short putIfAbsent(Integer key, Short value) {
            Short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short computeIfAbsent(Integer key, Function<? super Integer, ? extends Short> mappingFunction) {
            Short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short computeIfPresent(Integer key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            Short computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short compute(Integer key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            Short compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short merge(Integer key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            Short merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Int2ShortMap synchronize(Int2ShortMap m) {
        return new SynchronizedMap(m);
    }

    public static Int2ShortMap synchronize(Int2ShortMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ShortMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ShortMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Int2ShortFunctions.UnmodifiableFunction implements Int2ShortMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2ShortMap map;
        protected transient ObjectSet<Int2ShortMap.Entry> entries;
        protected transient IntSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Int2ShortMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean containsValue(short v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, p014it.unimi.dsi.fastutil.ints.Int2ShortSortedMap
        public ObjectSet<Int2ShortMap.Entry> int2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.int2ShortEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Integer, Short>> entrySet() {
            return int2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.ints.IntSet] */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public Set<Integer> keySet() {
            if (this.keys == null) {
                this.keys = IntSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
        public short getOrDefault(int key, short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Integer, ? super Short> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Integer, ? super Short, ? extends Short> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short putIfAbsent(int key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean remove(int key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short replace(int key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public boolean replace(int key, short oldValue, short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfAbsent(int key, IntUnaryOperator mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfAbsentNullable(int key, IntFunction<? extends Short> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfAbsent(int key, Int2ShortFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short computeIfPresent(int key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short compute(int key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        public short merge(int key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short replace(Integer key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public boolean replace(Integer key, Short oldValue, Short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short putIfAbsent(Integer key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short computeIfAbsent(Integer key, Function<? super Integer, ? extends Short> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short computeIfPresent(Integer key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short compute(Integer key, BiFunction<? super Integer, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortMap
        @Deprecated
        public Short merge(Integer key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Int2ShortMap unmodifiable(Int2ShortMap m) {
        return new UnmodifiableMap(m);
    }
}
