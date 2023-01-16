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
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteMaps.class */
public final class Byte2ByteMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Byte2ByteMaps() {
    }

    public static ObjectIterator<Byte2ByteMap.Entry> fastIterator(Byte2ByteMap map) {
        ObjectSet<Byte2ByteMap.Entry> entries = map.byte2ByteEntrySet();
        return entries instanceof Byte2ByteMap.FastEntrySet ? ((Byte2ByteMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Byte2ByteMap map, Consumer<? super Byte2ByteMap.Entry> consumer) {
        ObjectSet<Byte2ByteMap.Entry> entries = map.byte2ByteEntrySet();
        if (entries instanceof Byte2ByteMap.FastEntrySet) {
            ((Byte2ByteMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Byte2ByteMap.Entry> fastIterable(Byte2ByteMap map) {
        final ObjectSet<Byte2ByteMap.Entry> entries = map.byte2ByteEntrySet();
        return entries instanceof Byte2ByteMap.FastEntrySet ? new ObjectIterable<Byte2ByteMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ByteMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Byte2ByteMap.Entry> iterator() {
                return ((Byte2ByteMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Byte2ByteMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Byte2ByteMap.Entry> consumer) {
                ((Byte2ByteMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteMaps$EmptyMap.class */
    public static class EmptyMap extends Byte2ByteFunctions.EmptyFunction implements Byte2ByteMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean containsValue(byte v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
        public byte getOrDefault(byte key, byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteSortedMap
        public ObjectSet<Byte2ByteMap.Entry> byte2ByteEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        public Set<Byte> keySet() {
            return ByteSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        public Collection<Byte> values() {
            return ByteSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Byte> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Byte2ByteMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteMaps$Singleton.class */
    public static class Singleton extends Byte2ByteFunctions.Singleton implements Byte2ByteMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Byte2ByteMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient ByteCollection values;

        /* access modifiers changed from: protected */
        public Singleton(byte key, byte value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean containsValue(byte v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Byte) ov).byteValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteSortedMap
        public ObjectSet<Byte2ByteMap.Entry> byte2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractByte2ByteMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Byte>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Byte>> entrySet() {
            return byte2ByteEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
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

    public static Byte2ByteMap singleton(byte key, byte value) {
        return new Singleton(key, value);
    }

    public static Byte2ByteMap singleton(Byte key, Byte value) {
        return new Singleton(key.byteValue(), value.byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Byte2ByteFunctions.SynchronizedFunction implements Byte2ByteMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ByteMap map;
        protected transient ObjectSet<Byte2ByteMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient ByteCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2ByteMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2ByteMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean containsValue(byte v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Byte> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteSortedMap
        public ObjectSet<Byte2ByteMap.Entry> byte2ByteEntrySet() {
            ObjectSet<Byte2ByteMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.byte2ByteEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Byte>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Byte>> entrySet() {
            return byte2ByteEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
        public byte getOrDefault(byte key, byte defaultValue) {
            byte orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Byte> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Byte, ? extends Byte> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte putIfAbsent(byte key, byte value) {
            byte putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean remove(byte key, byte value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte replace(byte key, byte value) {
            byte replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean replace(byte key, byte oldValue, byte newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
            byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfAbsentNullable(byte key, IntFunction<? extends Byte> mappingFunction) {
            byte computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfAbsent(byte key, Byte2ByteFunction mappingFunction) {
            byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfPresent(byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            byte computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte compute(byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            byte compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte merge(byte key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            byte merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            Byte orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte replace(Byte key, Byte value) {
            Byte replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public boolean replace(Byte key, Byte oldValue, Byte newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte putIfAbsent(Byte key, Byte value) {
            Byte putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte computeIfAbsent(Byte key, Function<? super Byte, ? extends Byte> mappingFunction) {
            Byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte computeIfPresent(Byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            Byte computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte compute(Byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            Byte compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte merge(Byte key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            Byte merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Byte2ByteMap synchronize(Byte2ByteMap m) {
        return new SynchronizedMap(m);
    }

    public static Byte2ByteMap synchronize(Byte2ByteMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Byte2ByteFunctions.UnmodifiableFunction implements Byte2ByteMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ByteMap map;
        protected transient ObjectSet<Byte2ByteMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient ByteCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Byte2ByteMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean containsValue(byte v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, p014it.unimi.dsi.fastutil.bytes.Byte2ByteSortedMap
        public ObjectSet<Byte2ByteMap.Entry> byte2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.byte2ByteEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Byte>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Byte>> entrySet() {
            return byte2ByteEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
        public byte getOrDefault(byte key, byte defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Byte> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Byte, ? extends Byte> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte putIfAbsent(byte key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean remove(byte key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte replace(byte key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public boolean replace(byte key, byte oldValue, byte newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfAbsentNullable(byte key, IntFunction<? extends Byte> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfAbsent(byte key, Byte2ByteFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte computeIfPresent(byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte compute(byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        public byte merge(byte key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte replace(Byte key, Byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public boolean replace(Byte key, Byte oldValue, Byte newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte putIfAbsent(Byte key, Byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte computeIfAbsent(Byte key, Function<? super Byte, ? extends Byte> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte computeIfPresent(Byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte compute(Byte key, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
        @Deprecated
        public Byte merge(Byte key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Byte2ByteMap unmodifiable(Byte2ByteMap m) {
        return new UnmodifiableMap(m);
    }
}
