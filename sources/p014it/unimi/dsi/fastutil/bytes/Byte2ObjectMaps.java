package p014it.unimi.dsi.fastutil.bytes;

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
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMaps.class */
public final class Byte2ObjectMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Byte2ObjectMaps() {
    }

    public static <V> ObjectIterator<Byte2ObjectMap.Entry<V>> fastIterator(Byte2ObjectMap<V> map) {
        ObjectSet<Byte2ObjectMap.Entry<V>> entries = map.byte2ObjectEntrySet();
        return entries instanceof Byte2ObjectMap.FastEntrySet ? ((Byte2ObjectMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> void fastForEach(Byte2ObjectMap<V> map, Consumer<? super Byte2ObjectMap.Entry<V>> consumer) {
        ObjectSet<Byte2ObjectMap.Entry<V>> entries = map.byte2ObjectEntrySet();
        if (entries instanceof Byte2ObjectMap.FastEntrySet) {
            ((Byte2ObjectMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <V> ObjectIterable<Byte2ObjectMap.Entry<V>> fastIterable(Byte2ObjectMap<V> map) {
        final ObjectSet<Byte2ObjectMap.Entry<V>> entries = map.byte2ObjectEntrySet();
        return entries instanceof Byte2ObjectMap.FastEntrySet ? new ObjectIterable<Byte2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ObjectMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Byte2ObjectMap.Entry<V>> iterator() {
                return ((Byte2ObjectMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Byte2ObjectMap.Entry<V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Byte2ObjectMap.Entry<V>> consumer) {
                ((Byte2ObjectMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMaps$EmptyMap.class */
    public static class EmptyMap<V> extends Byte2ObjectFunctions.EmptyFunction<V> implements Byte2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
        public V getOrDefault(byte key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap
        public ObjectSet<Byte2ObjectMap.Entry<V>> byte2ObjectEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        public Set<Byte> keySet() {
            return ByteSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Byte2ObjectMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <V> Byte2ObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMaps$Singleton.class */
    public static class Singleton<V> extends Byte2ObjectFunctions.Singleton<V> implements Byte2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Byte2ObjectMap.Entry<V>> entries;
        protected transient ByteSet keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(byte key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return Objects.equals(this.value, v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap
        public ObjectSet<Byte2ObjectMap.Entry<V>> byte2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractByte2ObjectMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Byte, V>> entrySet() {
            return byte2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
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

    public static <V> Byte2ObjectMap<V> singleton(byte key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Byte2ObjectMap<V> singleton(Byte key, V value) {
        return new Singleton(key.byteValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMaps$SynchronizedMap.class */
    public static class SynchronizedMap<V> extends Byte2ObjectFunctions.SynchronizedFunction<V> implements Byte2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ObjectMap<V> map;
        protected transient ObjectSet<Byte2ObjectMap.Entry<V>> entries;
        protected transient ByteSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Byte b, Object obj, BiFunction biFunction) {
            return merge(b, (Byte) obj, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Byte b, Object obj) {
            return replace(b, (Byte) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Byte b, Object obj) {
            return putIfAbsent(b, (Byte) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2ObjectMap<V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2ObjectMap<V> m) {
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
        public void putAll(Map<? extends Byte, ? extends V> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap
        public ObjectSet<Byte2ObjectMap.Entry<V>> byte2ObjectEntrySet() {
            ObjectSet<Byte2ObjectMap.Entry<V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.byte2ObjectEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Byte, V>> entrySet() {
            return byte2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
        public V getOrDefault(byte key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, (byte) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super V> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super V, ? extends V> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V putIfAbsent(byte key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, (byte) value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public boolean remove(byte key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V replace(byte key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, (byte) value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public boolean replace(byte key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V computeIfAbsent(byte key, IntFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V computeIfAbsent(byte key, Byte2ObjectFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, (Byte2ObjectFunction) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V computeIfPresent(byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V compute(byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V merge(byte key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, (byte) value, (BiFunction<? super byte, ? super byte, ? extends byte>) remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Byte key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace((Byte2ObjectMap<V>) key, (Byte) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Byte key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Byte2ObjectMap<V>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public V putIfAbsent(Byte key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Byte2ObjectMap<V>) key, (Byte) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public V computeIfAbsent(Byte key, Function<? super Byte, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Byte2ObjectMap<V>) key, (Function<? super Byte2ObjectMap<V>, ? extends V>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public V computeIfPresent(Byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Byte2ObjectMap<V>) key, (BiFunction<? super Byte2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public V compute(Byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute((Byte2ObjectMap<V>) key, (BiFunction<? super Byte2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public V merge(Byte key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge((Byte2ObjectMap<V>) key, (Byte) value, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) remappingFunction);
            }
            return merge;
        }
    }

    public static <V> Byte2ObjectMap<V> synchronize(Byte2ObjectMap<V> m) {
        return new SynchronizedMap(m);
    }

    public static <V> Byte2ObjectMap<V> synchronize(Byte2ObjectMap<V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<V> extends Byte2ObjectFunctions.UnmodifiableFunction<V> implements Byte2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2ObjectMap<? extends V> map;
        protected transient ObjectSet<Byte2ObjectMap.Entry<V>> entries;
        protected transient ByteSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Byte b, Object obj, BiFunction biFunction) {
            return merge(b, (Byte) obj, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Byte b, Object obj) {
            return replace(b, (Byte) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Byte b, Object obj) {
            return putIfAbsent(b, (Byte) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Byte2ObjectMap<? extends V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.map.containsValue(v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap
        public ObjectSet<Byte2ObjectMap.Entry<V>> byte2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.byte2ObjectEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Byte, V>> entrySet() {
            return byte2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
        public V getOrDefault(byte key, V defaultValue) {
            return (V) this.map.getOrDefault(key, (byte) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V putIfAbsent(byte key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public boolean remove(byte key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V replace(byte key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public boolean replace(byte key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V computeIfAbsent(byte key, IntFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V computeIfAbsent(byte key, Byte2ObjectFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V computeIfPresent(byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V compute(byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
        public V merge(byte key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Byte key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Byte key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V putIfAbsent(Byte key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfAbsent(Byte key, Function<? super Byte, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfPresent(Byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V compute(Byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V merge(Byte key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Byte2ObjectMap<V> unmodifiable(Byte2ObjectMap<? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
