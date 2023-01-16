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
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteCollections;
import p014it.unimi.dsi.fastutil.bytes.ByteSets;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ByteMap;
import p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions;
import p014it.unimi.dsi.fastutil.objects.Object2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteMaps.class */
public final class Object2ByteMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Object2ByteMaps() {
    }

    public static <K> ObjectIterator<Object2ByteMap.Entry<K>> fastIterator(Object2ByteMap<K> map) {
        ObjectSet<Object2ByteMap.Entry<K>> entries = map.object2ByteEntrySet();
        return entries instanceof Object2ByteMap.FastEntrySet ? ((Object2ByteMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Object2ByteMap<K> map, Consumer<? super Object2ByteMap.Entry<K>> consumer) {
        ObjectSet<Object2ByteMap.Entry<K>> entries = map.object2ByteEntrySet();
        if (entries instanceof Object2ByteMap.FastEntrySet) {
            ((Object2ByteMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Object2ByteMap.Entry<K>> fastIterable(Object2ByteMap<K> map) {
        final ObjectSet<Object2ByteMap.Entry<K>> entries = map.object2ByteEntrySet();
        return entries instanceof Object2ByteMap.FastEntrySet ? new ObjectIterable<Object2ByteMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2ByteMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Object2ByteMap.Entry<K>> iterator() {
                return ((Object2ByteMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Object2ByteMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Object2ByteMap.Entry<K>> consumer) {
                ((Object2ByteMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Object2ByteFunctions.EmptyFunction<K> implements Object2ByteMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean containsValue(byte v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
        public byte getOrDefault(Object key, byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public ObjectSet<K> keySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public Collection<Byte> values() {
            return ByteSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Byte> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Object2ByteMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Object2ByteMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteMaps$Singleton.class */
    public static class Singleton<K> extends Object2ByteFunctions.Singleton<K> implements Object2ByteMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Object2ByteMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient ByteCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, byte value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean containsValue(byte v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Byte) ov).byteValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractObject2ByteMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Byte>> entrySet() {
            return object2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
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

    public static <K> Object2ByteMap<K> singleton(K key, byte value) {
        return new Singleton(key, value);
    }

    public static <K> Object2ByteMap<K> singleton(K key, Byte value) {
        return new Singleton(key, value.byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Object2ByteFunctions.SynchronizedFunction<K> implements Object2ByteMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ByteMap<K> map;
        protected transient ObjectSet<Object2ByteMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient ByteCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Byte merge(Object obj, Byte b, BiFunction<? super Byte, ? super Byte, ? extends Byte> biFunction) {
            return merge((SynchronizedMap<K>) obj, b, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Byte replace(Object obj, Byte b) {
            return replace((SynchronizedMap<K>) obj, b);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Byte b, Byte b2) {
            return replace((SynchronizedMap<K>) obj, b, b2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Byte putIfAbsent(Object obj, Byte b) {
            return putIfAbsent((SynchronizedMap<K>) obj, b);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2ByteMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2ByteMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean containsValue(byte v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Byte> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            ObjectSet<Object2ByteMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.object2ByteEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Byte>> entrySet() {
            return object2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
        public byte getOrDefault(Object key, byte defaultValue) {
            byte orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Byte> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Byte, ? extends Byte> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte putIfAbsent(K key, byte value) {
            byte putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2ByteMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean remove(Object key, byte value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte replace(K key, byte value) {
            byte replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ByteMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean replace(K key, byte oldValue, byte newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ByteMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2ByteMap<K>) key, (ToIntFunction<? super Object2ByteMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeIfAbsent(K key, Object2ByteFunction<? super K> mappingFunction) {
            byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2ByteMap<K>) key, (Object2ByteFunction<? super Object2ByteMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeByteIfPresent(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            byte computeByteIfPresent;
            synchronized (this.sync) {
                computeByteIfPresent = this.map.computeByteIfPresent(key, remappingFunction);
            }
            return computeByteIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeByte(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            byte computeByte;
            synchronized (this.sync) {
                computeByte = this.map.computeByte(key, remappingFunction);
            }
            return computeByte;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte merge(K key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            byte merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2ByteMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            Byte orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public Byte replace(K key, Byte value) {
            Byte replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ByteMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public boolean replace(K key, Byte oldValue, Byte newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2ByteMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public Byte putIfAbsent(K key, Byte value) {
            Byte putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2ByteMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Byte computeIfAbsent(K key, Function<? super K, ? extends Byte> mappingFunction) {
            Byte computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2ByteMap<K>) key, (Function<? super Object2ByteMap<K>, ? extends Byte>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Byte computeIfPresent(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            Byte computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Byte compute(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            Byte compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public Byte merge(K key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            Byte merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2ByteMap<K>) key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Object2ByteMap<K> synchronize(Object2ByteMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Object2ByteMap<K> synchronize(Object2ByteMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Object2ByteFunctions.UnmodifiableFunction<K> implements Object2ByteMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ByteMap<? extends K> map;
        protected transient ObjectSet<Object2ByteMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient ByteCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Byte merge(Object obj, Byte b, BiFunction<? super Byte, ? super Byte, ? extends Byte> biFunction) {
            return merge((UnmodifiableMap<K>) obj, b, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Byte replace(Object obj, Byte b) {
            return replace((UnmodifiableMap<K>) obj, b);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Byte b, Byte b2) {
            return replace((UnmodifiableMap<K>) obj, b, b2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Byte putIfAbsent(Object obj, Byte b) {
            return putIfAbsent((UnmodifiableMap<K>) obj, b);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Object2ByteMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean containsValue(byte v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Byte> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, p014it.unimi.dsi.fastutil.objects.Object2ByteSortedMap
        public ObjectSet<Object2ByteMap.Entry<K>> object2ByteEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.object2ByteEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Byte>> entrySet() {
            return object2ByteEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
        public byte getOrDefault(Object key, byte defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Byte> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Byte, ? extends Byte> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte putIfAbsent(K key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean remove(Object key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte replace(K key, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public boolean replace(K key, byte oldValue, byte newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeIfAbsent(K key, Object2ByteFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeByteIfPresent(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte computeByte(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        public byte merge(K key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public Byte replace(K key, Byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public boolean replace(K key, Byte oldValue, Byte newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public Byte putIfAbsent(K key, Byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Byte computeIfAbsent(K key, Function<? super K, ? extends Byte> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Byte computeIfPresent(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Byte compute(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ByteMap
        @Deprecated
        public Byte merge(K key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2ByteMap<K> unmodifiable(Object2ByteMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
