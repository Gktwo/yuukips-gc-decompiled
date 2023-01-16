package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollections;
import p014it.unimi.dsi.fastutil.bytes.ByteSets;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions;
import p014it.unimi.dsi.fastutil.floats.Float2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMaps.class */
public final class Float2ByteMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Float2ByteMaps() {
    }

    public static ObjectIterator<Float2ByteMap.Entry> fastIterator(Float2ByteMap map) {
        ObjectSet<Float2ByteMap.Entry> entries = map.float2ByteEntrySet();
        return entries instanceof Float2ByteMap.FastEntrySet ? ((Float2ByteMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Float2ByteMap map, Consumer<? super Float2ByteMap.Entry> consumer) {
        ObjectSet<Float2ByteMap.Entry> entries = map.float2ByteEntrySet();
        if (entries instanceof Float2ByteMap.FastEntrySet) {
            ((Float2ByteMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Float2ByteMap.Entry> fastIterable(Float2ByteMap map) {
        final ObjectSet<Float2ByteMap.Entry> entries = map.float2ByteEntrySet();
        return entries instanceof Float2ByteMap.FastEntrySet ? new ObjectIterable<Float2ByteMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2ByteMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Float2ByteMap.Entry> iterator() {
                return ((Float2ByteMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Float2ByteMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Float2ByteMap.Entry> consumer) {
                ((Float2ByteMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMaps$EmptyMap.class */
    public static class EmptyMap extends Float2ByteFunctions.EmptyFunction implements Float2ByteMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsValue(byte v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float key, byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Set<Float> keySet() {
            return FloatSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Collection<Byte> values() {
            return ByteSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Byte> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Float2ByteMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMaps$Singleton.class */
    public static class Singleton extends Float2ByteFunctions.Singleton implements Float2ByteMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Float2ByteMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient ByteCollection values;

        /* access modifiers changed from: protected */
        public Singleton(float key, byte value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsValue(byte v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Byte) ov).byteValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractFloat2ByteMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Byte>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Byte>> entrySet() {
            return float2ByteEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Collection<Byte> values() {
            if (this.values == null) {
                this.values = ByteSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ this.value;
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

    public static Float2ByteMap singleton(float key, byte value) {
        return new Singleton(key, value);
    }

    public static Float2ByteMap singleton(Float key, Byte value) {
        return new Singleton(key.floatValue(), value.byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Float2ByteFunctions.SynchronizedFunction implements Float2ByteMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ByteMap map;
        protected transient ObjectSet<Float2ByteMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient ByteCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2ByteMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2ByteMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsValue(byte v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Byte> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            ObjectSet<Float2ByteMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.float2ByteEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Byte>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Byte>> entrySet() {
            return float2ByteEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Set<Float> keySet() {
            FloatSet floatSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = FloatSets.synchronize(this.map.keySet(), this.sync);
                }
                floatSet = this.keys;
            }
            return floatSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Collection<Byte> values() {
            ByteCollection byteCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = ByteCollections.synchronize(this.map.values(), this.sync);
                }
                byteCollection = this.values;
            }
            return byteCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float key, byte defaultValue) {
            byte orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Byte> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Byte, ? extends Byte> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte putIfAbsent(float key, byte value) {
            byte putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean remove(float key, byte value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte replace(float key, byte value) {
            byte replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean replace(float key, byte oldValue, byte newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfAbsent(float key, DoubleToIntFunction mappingFunction) {
            byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfAbsentNullable(float key, DoubleFunction<? extends Byte> mappingFunction) {
            byte computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfAbsent(float key, Float2ByteFunction mappingFunction) {
            byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfPresent(float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            byte computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte compute(float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            byte compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte merge(float key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            byte merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            Byte orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte replace(Float key, Byte value) {
            Byte replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public boolean replace(Float key, Byte oldValue, Byte newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte putIfAbsent(Float key, Byte value) {
            Byte putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte computeIfAbsent(Float key, Function<? super Float, ? extends Byte> mappingFunction) {
            Byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte computeIfPresent(Float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            Byte computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte compute(Float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            Byte compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte merge(Float key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            Byte merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Float2ByteMap synchronize(Float2ByteMap m) {
        return new SynchronizedMap(m);
    }

    public static Float2ByteMap synchronize(Float2ByteMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Float2ByteFunctions.UnmodifiableFunction implements Float2ByteMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ByteMap map;
        protected transient ObjectSet<Float2ByteMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient ByteCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Float2ByteMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsValue(byte v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
        public ObjectSet<Float2ByteMap.Entry> float2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.float2ByteEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Byte>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Byte>> entrySet() {
            return float2ByteEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public Collection<Byte> values() {
            if (this.values == null) {
                this.values = ByteCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float key, byte defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Byte> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Byte, ? extends Byte> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte putIfAbsent(float key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean remove(float key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte replace(float key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean replace(float key, byte oldValue, byte newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfAbsent(float key, DoubleToIntFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfAbsentNullable(float key, DoubleFunction<? extends Byte> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfAbsent(float key, Float2ByteFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte computeIfPresent(float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte compute(float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public byte merge(float key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte replace(Float key, Byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public boolean replace(Float key, Byte oldValue, Byte newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte putIfAbsent(Float key, Byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte computeIfAbsent(Float key, Function<? super Float, ? extends Byte> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte computeIfPresent(Float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte compute(Float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        @Deprecated
        public Byte merge(Float key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Float2ByteMap unmodifiable(Float2ByteMap m) {
        return new UnmodifiableMap(m);
    }
}
