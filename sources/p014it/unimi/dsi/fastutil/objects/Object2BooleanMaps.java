package p014it.unimi.dsi.fastutil.objects;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollections;
import p014it.unimi.dsi.fastutil.booleans.BooleanSets;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMaps.class */
public final class Object2BooleanMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Object2BooleanMaps() {
    }

    public static <K> ObjectIterator<Object2BooleanMap.Entry<K>> fastIterator(Object2BooleanMap<K> map) {
        ObjectSet<Object2BooleanMap.Entry<K>> entries = map.object2BooleanEntrySet();
        return entries instanceof Object2BooleanMap.FastEntrySet ? ((Object2BooleanMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Object2BooleanMap<K> map, Consumer<? super Object2BooleanMap.Entry<K>> consumer) {
        ObjectSet<Object2BooleanMap.Entry<K>> entries = map.object2BooleanEntrySet();
        if (entries instanceof Object2BooleanMap.FastEntrySet) {
            ((Object2BooleanMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Object2BooleanMap.Entry<K>> fastIterable(Object2BooleanMap<K> map) {
        final ObjectSet<Object2BooleanMap.Entry<K>> entries = map.object2BooleanEntrySet();
        return entries instanceof Object2BooleanMap.FastEntrySet ? new ObjectIterable<Object2BooleanMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2BooleanMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Object2BooleanMap.Entry<K>> iterator() {
                return ((Object2BooleanMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Object2BooleanMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Object2BooleanMap.Entry<K>> consumer) {
                ((Object2BooleanMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Object2BooleanFunctions.EmptyFunction<K> implements Object2BooleanMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean containsValue(boolean v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object key, Boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object key, boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public ObjectSet<K> keySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public Collection<Boolean> values() {
            return BooleanSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Boolean> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Object2BooleanMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Object2BooleanMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMaps$Singleton.class */
    public static class Singleton<K> extends Object2BooleanFunctions.Singleton<K> implements Object2BooleanMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Object2BooleanMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient BooleanCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, boolean value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean containsValue(boolean v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Boolean) ov).booleanValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractObject2BooleanMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Boolean>> entrySet() {
            return object2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public Collection<Boolean> values() {
            if (this.values == null) {
                this.values = BooleanSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
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

    public static <K> Object2BooleanMap<K> singleton(K key, boolean value) {
        return new Singleton(key, value);
    }

    public static <K> Object2BooleanMap<K> singleton(K key, Boolean value) {
        return new Singleton(key, value.booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Object2BooleanFunctions.SynchronizedFunction<K> implements Object2BooleanMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2BooleanMap<K> map;
        protected transient ObjectSet<Object2BooleanMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient BooleanCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean merge(Object obj, Boolean bool, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> biFunction) {
            return merge((SynchronizedMap<K>) obj, bool, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean replace(Object obj, Boolean bool) {
            return replace((SynchronizedMap<K>) obj, bool);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Boolean bool, Boolean bool2) {
            return replace((SynchronizedMap<K>) obj, bool, bool2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean putIfAbsent(Object obj, Boolean bool) {
            return putIfAbsent((SynchronizedMap<K>) obj, bool);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2BooleanMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2BooleanMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean containsValue(boolean v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Boolean> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            ObjectSet<Object2BooleanMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.object2BooleanEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Boolean>> entrySet() {
            return object2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.booleans.BooleanCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public Collection<Boolean> values() {
            BooleanCollection booleanCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = BooleanCollections.synchronize(this.map.values(), this.sync);
                }
                booleanCollection = this.values;
            }
            return booleanCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object key, boolean defaultValue) {
            boolean orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Boolean> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Boolean, ? extends Boolean> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean putIfAbsent(K key, boolean value) {
            boolean putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2BooleanMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean remove(Object key, boolean value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean replace(K key, boolean value) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2BooleanMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean replace(K key, boolean oldValue, boolean newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2BooleanMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeIfAbsent(K key, Predicate<? super K> mappingFunction) {
            boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2BooleanMap<K>) key, (Predicate<? super Object2BooleanMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeIfAbsent(K key, Object2BooleanFunction<? super K> mappingFunction) {
            boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2BooleanMap<K>) key, (Object2BooleanFunction<? super Object2BooleanMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeBooleanIfPresent(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean computeBooleanIfPresent;
            synchronized (this.sync) {
                computeBooleanIfPresent = this.map.computeBooleanIfPresent(key, remappingFunction);
            }
            return computeBooleanIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeBoolean(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean computeBoolean;
            synchronized (this.sync) {
                computeBoolean = this.map.computeBoolean(key, remappingFunction);
            }
            return computeBoolean;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean merge(K key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2BooleanMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object key, Boolean defaultValue) {
            Boolean orDefault;
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
        public Boolean replace(K key, Boolean value) {
            Boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2BooleanMap<K>) key, (K) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(K key, Boolean oldValue, Boolean newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2BooleanMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public Boolean putIfAbsent(K key, Boolean value) {
            Boolean putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2BooleanMap<K>) key, (K) value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Boolean computeIfAbsent(K key, Function<? super K, ? extends Boolean> mappingFunction) {
            Boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2BooleanMap<K>) key, (Function<? super Object2BooleanMap<K>, ? extends Boolean>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Boolean computeIfPresent(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Boolean compute(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public Boolean merge(K key, Boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2BooleanMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Object2BooleanMap<K> synchronize(Object2BooleanMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Object2BooleanMap<K> synchronize(Object2BooleanMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Object2BooleanFunctions.UnmodifiableFunction<K> implements Object2BooleanMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2BooleanMap<? extends K> map;
        protected transient ObjectSet<Object2BooleanMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient BooleanCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean merge(Object obj, Boolean bool, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> biFunction) {
            return merge((UnmodifiableMap<K>) obj, bool, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean replace(Object obj, Boolean bool) {
            return replace((UnmodifiableMap<K>) obj, bool);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Boolean bool, Boolean bool2) {
            return replace((UnmodifiableMap<K>) obj, bool, bool2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean putIfAbsent(Object obj, Boolean bool) {
            return putIfAbsent((UnmodifiableMap<K>) obj, bool);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Object2BooleanMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean containsValue(boolean v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
        public ObjectSet<Object2BooleanMap.Entry<K>> object2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.object2BooleanEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Boolean>> entrySet() {
            return object2BooleanEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.booleans.BooleanCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public Collection<Boolean> values() {
            if (this.values == null) {
                this.values = BooleanCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object key, boolean defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Boolean> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Boolean, ? extends Boolean> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean putIfAbsent(K key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean remove(Object key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean replace(K key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean replace(K key, boolean oldValue, boolean newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeIfAbsent(K key, Predicate<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeIfAbsent(K key, Object2BooleanFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeBooleanIfPresent(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean computeBoolean(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanMap
        public boolean merge(K key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object key, Boolean defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean replace(K key, Boolean value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(K key, Boolean oldValue, Boolean newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean putIfAbsent(K key, Boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Boolean computeIfAbsent(K key, Function<? super K, ? extends Boolean> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Boolean computeIfPresent(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Boolean compute(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean merge(K key, Boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2BooleanMap<K> unmodifiable(Object2BooleanMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
