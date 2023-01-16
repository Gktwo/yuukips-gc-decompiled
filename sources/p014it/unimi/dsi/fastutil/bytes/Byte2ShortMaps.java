package p014it.unimi.dsi.fastutil.bytes;

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
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollections;
import p014it.unimi.dsi.fastutil.shorts.ShortSets;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMaps.class */
public final class Byte2ShortMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Byte2ShortMaps() {
    }

    public static ObjectIterator<Byte2ShortMap.Entry> fastIterator(Byte2ShortMap map) {
        ObjectSet<Byte2ShortMap.Entry> entries = map.byte2ShortEntrySet();
        return entries instanceof Byte2ShortMap.FastEntrySet ? ((Byte2ShortMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Byte2ShortMap map, Consumer<? super Byte2ShortMap.Entry> consumer) {
        ObjectSet<Byte2ShortMap.Entry> entries = map.byte2ShortEntrySet();
        if (entries instanceof Byte2ShortMap.FastEntrySet) {
            ((Byte2ShortMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Byte2ShortMap.Entry> fastIterable(Byte2ShortMap map) {
        final ObjectSet<Byte2ShortMap.Entry> entries = map.byte2ShortEntrySet();
        return entries instanceof Byte2ShortMap.FastEntrySet ? new ObjectIterable<Byte2ShortMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ShortMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Byte2ShortMap.Entry> iterator() {
                return ((Byte2ShortMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Byte2ShortMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Byte2ShortMap.Entry> consumer) {
                ((Byte2ShortMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMaps$EmptyMap.class */
    public static class EmptyMap extends Byte2ShortFunctions.EmptyFunction implements Byte2ShortMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean containsValue(short v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        public short getOrDefault(byte key, short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public Set<Byte> keySet() {
            return ByteSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public Collection<Short> values() {
            return ShortSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Short> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Byte2ShortMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMaps$Singleton.class */
    public static class Singleton extends Byte2ShortFunctions.Singleton implements Byte2ShortMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Byte2ShortMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public Singleton(byte key, short value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean containsValue(short v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Short) ov).shortValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractByte2ShortMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Short>> entrySet() {
            return byte2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
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
            return "{" + ((int) this.key) + "=>" + ((int) this.value) + "}";
        }
    }

    public static Byte2ShortMap singleton(byte key, short value) {
        return new Singleton(key, value);
    }

    public static Byte2ShortMap singleton(Byte key, Short value) {
        return new Singleton(key.byteValue(), value.shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Byte2ShortFunctions.SynchronizedFunction implements Byte2ShortMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ShortMap map;
        protected transient ObjectSet<Byte2ShortMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2ShortMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2ShortMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean containsValue(short v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Short> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            ObjectSet<Byte2ShortMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.byte2ShortEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Short>> entrySet() {
            return byte2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public Set<Byte> keySet() {
            ByteSet byteSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = ByteSets.synchronize(this.map.keySet(), this.sync);
                }
                byteSet = this.keys;
            }
            return byteSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        public short getOrDefault(byte key, short defaultValue) {
            short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Short> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Short, ? extends Short> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short putIfAbsent(byte key, short value) {
            short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean remove(byte key, short value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short replace(byte key, short value) {
            short replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean replace(byte key, short oldValue, short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfAbsentNullable(byte key, IntFunction<? extends Short> mappingFunction) {
            short computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfAbsent(byte key, Byte2ShortFunction mappingFunction) {
            short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfPresent(byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            short computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short compute(byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            short compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short merge(byte key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            short merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            Short orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short replace(Byte key, Short value) {
            Short replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public boolean replace(Byte key, Short oldValue, Short newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short putIfAbsent(Byte key, Short value) {
            Short putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short computeIfAbsent(Byte key, Function<? super Byte, ? extends Short> mappingFunction) {
            Short computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short computeIfPresent(Byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            Short computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short compute(Byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            Short compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short merge(Byte key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            Short merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Byte2ShortMap synchronize(Byte2ShortMap m) {
        return new SynchronizedMap(m);
    }

    public static Byte2ShortMap synchronize(Byte2ShortMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Byte2ShortFunctions.UnmodifiableFunction implements Byte2ShortMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ShortMap map;
        protected transient ObjectSet<Byte2ShortMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient ShortCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Byte2ShortMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean containsValue(short v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Short> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.byte2ShortEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Short>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Short>> entrySet() {
            return byte2ShortEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.shorts.ShortCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        public short getOrDefault(byte key, short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Short> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Short, ? extends Short> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short putIfAbsent(byte key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean remove(byte key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short replace(byte key, short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean replace(byte key, short oldValue, short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfAbsentNullable(byte key, IntFunction<? extends Short> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfAbsent(byte key, Byte2ShortFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short computeIfPresent(byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short compute(byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public short merge(byte key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short replace(Byte key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public boolean replace(Byte key, Short oldValue, Short newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short putIfAbsent(Byte key, Short value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short computeIfAbsent(Byte key, Function<? super Byte, ? extends Short> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short computeIfPresent(Byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short compute(Byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        @Deprecated
        public Short merge(Byte key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Byte2ShortMap unmodifiable(Byte2ShortMap m) {
        return new UnmodifiableMap(m);
    }
}
