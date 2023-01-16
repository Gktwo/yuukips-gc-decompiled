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
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollections;
import p014it.unimi.dsi.fastutil.chars.CharSets;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunctions;
import p014it.unimi.dsi.fastutil.objects.Object2CharMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2CharMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharMaps.class */
public final class Object2CharMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Object2CharMaps() {
    }

    public static <K> ObjectIterator<Object2CharMap.Entry<K>> fastIterator(Object2CharMap<K> map) {
        ObjectSet<Object2CharMap.Entry<K>> entries = map.object2CharEntrySet();
        return entries instanceof Object2CharMap.FastEntrySet ? ((Object2CharMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <K> void fastForEach(Object2CharMap<K> map, Consumer<? super Object2CharMap.Entry<K>> consumer) {
        ObjectSet<Object2CharMap.Entry<K>> entries = map.object2CharEntrySet();
        if (entries instanceof Object2CharMap.FastEntrySet) {
            ((Object2CharMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <K> ObjectIterable<Object2CharMap.Entry<K>> fastIterable(Object2CharMap<K> map) {
        final ObjectSet<Object2CharMap.Entry<K>> entries = map.object2CharEntrySet();
        return entries instanceof Object2CharMap.FastEntrySet ? new ObjectIterable<Object2CharMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2CharMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Object2CharMap.Entry<K>> iterator() {
                return ((Object2CharMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Object2CharMap.Entry<K>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Object2CharMap.Entry<K>> consumer) {
                ((Object2CharMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharMaps$EmptyMap.class */
    public static class EmptyMap<K> extends Object2CharFunctions.EmptyFunction<K> implements Object2CharMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean containsValue(char v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        public char getOrDefault(Object key, char defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSet<K> keySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public Collection<Character> values() {
            return CharSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Character> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Object2CharMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <K> Object2CharMap<K> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharMaps$Singleton.class */
    public static class Singleton<K> extends Object2CharFunctions.Singleton<K> implements Object2CharMap<K>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Object2CharMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient CharCollection values;

        /* access modifiers changed from: protected */
        public Singleton(K key, char value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean containsValue(char v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Character) ov).charValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractObject2CharMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Character>> entrySet() {
            return object2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public Collection<Character> values() {
            if (this.values == null) {
                this.values = CharSets.singleton(this.value);
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
            return "{" + this.key + "=>" + this.value + "}";
        }
    }

    public static <K> Object2CharMap<K> singleton(K key, char value) {
        return new Singleton(key, value);
    }

    public static <K> Object2CharMap<K> singleton(K key, Character value) {
        return new Singleton(key, value.charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharMaps$SynchronizedMap.class */
    public static class SynchronizedMap<K> extends Object2CharFunctions.SynchronizedFunction<K> implements Object2CharMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2CharMap<K> map;
        protected transient ObjectSet<Object2CharMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient CharCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Character merge(Object obj, Character ch, BiFunction<? super Character, ? super Character, ? extends Character> biFunction) {
            return merge((SynchronizedMap<K>) obj, ch, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Character replace(Object obj, Character ch) {
            return replace((SynchronizedMap<K>) obj, ch);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Character ch, Character ch2) {
            return replace((SynchronizedMap<K>) obj, ch, ch2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Character putIfAbsent(Object obj, Character ch) {
            return putIfAbsent((SynchronizedMap<K>) obj, ch);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2CharMap<K> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Object2CharMap<K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean containsValue(char v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Character> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            ObjectSet<Object2CharMap.Entry<K>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.object2CharEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Character>> entrySet() {
            return object2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.chars.CharCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public Collection<Character> values() {
            CharCollection charCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = CharCollections.synchronize(this.map.values(), this.sync);
                }
                charCollection = this.values;
            }
            return charCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        public char getOrDefault(Object key, char defaultValue) {
            char orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Character> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Character, ? extends Character> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char putIfAbsent(K key, char value) {
            char putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2CharMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean remove(Object key, char value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char replace(K key, char value) {
            char replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2CharMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean replace(K key, char oldValue, char newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2CharMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            char computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2CharMap<K>) key, (ToIntFunction<? super Object2CharMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeIfAbsent(K key, Object2CharFunction<? super K> mappingFunction) {
            char computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2CharMap<K>) key, (Object2CharFunction<? super Object2CharMap<K>>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeCharIfPresent(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            char computeCharIfPresent;
            synchronized (this.sync) {
                computeCharIfPresent = this.map.computeCharIfPresent(key, remappingFunction);
            }
            return computeCharIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeChar(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            char computeChar;
            synchronized (this.sync) {
                computeChar = this.map.computeChar(key, remappingFunction);
            }
            return computeChar;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char merge(K key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            char merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2CharMap<K>) key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            Character orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public Character replace(K key, Character value) {
            Character replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2CharMap<K>) key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public boolean replace(K key, Character oldValue, Character newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Object2CharMap<K>) key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public Character putIfAbsent(K key, Character value) {
            Character putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Object2CharMap<K>) key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map
        public Character computeIfAbsent(K key, Function<? super K, ? extends Character> mappingFunction) {
            Character computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Object2CharMap<K>) key, (Function<? super Object2CharMap<K>, ? extends Character>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public Character computeIfPresent(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            Character computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public Character compute(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            Character compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public Character merge(K key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            Character merge;
            synchronized (this.sync) {
                merge = this.map.merge((Object2CharMap<K>) key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static <K> Object2CharMap<K> synchronize(Object2CharMap<K> m) {
        return new SynchronizedMap(m);
    }

    public static <K> Object2CharMap<K> synchronize(Object2CharMap<K> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<K> extends Object2CharFunctions.UnmodifiableFunction<K> implements Object2CharMap<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2CharMap<? extends K> map;
        protected transient ObjectSet<Object2CharMap.Entry<K>> entries;
        protected transient ObjectSet<K> keys;
        protected transient CharCollection values;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Character merge(Object obj, Character ch, BiFunction<? super Character, ? super Character, ? extends Character> biFunction) {
            return merge((UnmodifiableMap<K>) obj, ch, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Character replace(Object obj, Character ch) {
            return replace((UnmodifiableMap<K>) obj, ch);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ boolean replace(Object obj, Character ch, Character ch2) {
            return replace((UnmodifiableMap<K>) obj, ch, ch2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Character putIfAbsent(Object obj, Character ch) {
            return putIfAbsent((UnmodifiableMap<K>) obj, ch);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Object2CharMap<? extends K> m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean containsValue(char v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.object2CharEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<K, Character>> entrySet() {
            return object2CharEntrySet();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.chars.CharCollection] */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public Collection<Character> values() {
            if (this.values == null) {
                this.values = CharCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        public char getOrDefault(Object key, char defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public void forEach(BiConsumer<? super K, ? super Character> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super Character, ? extends Character> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char putIfAbsent(K key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean remove(Object key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char replace(K key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean replace(K key, char oldValue, char newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeIfAbsent(K key, Object2CharFunction<? super K> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeCharIfPresent(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char computeChar(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public char merge(K key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public Character replace(K key, Character value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public boolean replace(K key, Character oldValue, Character newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public Character putIfAbsent(K key, Character value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Character computeIfAbsent(K key, Function<? super K, ? extends Character> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Character computeIfPresent(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Character compute(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap
        @Deprecated
        public Character merge(K key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2CharMap<K> unmodifiable(Object2CharMap<? extends K> m) {
        return new UnmodifiableMap(m);
    }
}
