package p014it.unimi.dsi.fastutil.chars;

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
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ObjectMap;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectCollections;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMaps.class */
public final class Char2ObjectMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Char2ObjectMaps() {
    }

    public static <V> ObjectIterator<Char2ObjectMap.Entry<V>> fastIterator(Char2ObjectMap<V> map) {
        ObjectSet<Char2ObjectMap.Entry<V>> entries = map.char2ObjectEntrySet();
        return entries instanceof Char2ObjectMap.FastEntrySet ? ((Char2ObjectMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static <V> void fastForEach(Char2ObjectMap<V> map, Consumer<? super Char2ObjectMap.Entry<V>> consumer) {
        ObjectSet<Char2ObjectMap.Entry<V>> entries = map.char2ObjectEntrySet();
        if (entries instanceof Char2ObjectMap.FastEntrySet) {
            ((Char2ObjectMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static <V> ObjectIterable<Char2ObjectMap.Entry<V>> fastIterable(Char2ObjectMap<V> map) {
        final ObjectSet<Char2ObjectMap.Entry<V>> entries = map.char2ObjectEntrySet();
        return entries instanceof Char2ObjectMap.FastEntrySet ? new ObjectIterable<Char2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.chars.Char2ObjectMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Char2ObjectMap.Entry<V>> iterator() {
                return ((Char2ObjectMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Char2ObjectMap.Entry<V>> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Char2ObjectMap.Entry<V>> consumer) {
                ((Char2ObjectMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMaps$EmptyMap.class */
    public static class EmptyMap<V> extends Char2ObjectFunctions.EmptyFunction<V> implements Char2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
        public V getOrDefault(char key, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public Set<Character> keySet() {
            return CharSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            return ObjectSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super V> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Char2ObjectMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    public static <V> Char2ObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMaps$Singleton.class */
    public static class Singleton<V> extends Char2ObjectFunctions.Singleton<V> implements Char2ObjectMap<V>, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Char2ObjectMap.Entry<V>> entries;
        protected transient CharSet keys;
        protected transient ObjectCollection<V> values;

        /* access modifiers changed from: protected */
        public Singleton(char key, V value) {
            super(key, value);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return Objects.equals(this.value, v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractChar2ObjectMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Character, V>> entrySet() {
            return char2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public Set<Character> keySet() {
            if (this.keys == null) {
                this.keys = CharSets.singleton(this.key);
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
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
            return "{" + this.key + "=>" + this.value + "}";
        }
    }

    public static <V> Char2ObjectMap<V> singleton(char key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Char2ObjectMap<V> singleton(Character key, V value) {
        return new Singleton(key.charValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMaps$SynchronizedMap.class */
    public static class SynchronizedMap<V> extends Char2ObjectFunctions.SynchronizedFunction<V> implements Char2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ObjectMap<V> map;
        protected transient ObjectSet<Char2ObjectMap.Entry<V>> entries;
        protected transient CharSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Character ch, Object obj, BiFunction biFunction) {
            return merge(ch, (Character) obj, (BiFunction<? super Character, ? super Character, ? extends Character>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Character ch, Object obj) {
            return replace(ch, (Character) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Character ch, Object obj) {
            return putIfAbsent(ch, (Character) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Char2ObjectMap<V> m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Char2ObjectMap<V> m) {
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
        public void putAll(Map<? extends Character, ? extends V> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            ObjectSet<Char2ObjectMap.Entry<V>> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.char2ObjectEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Character, V>> entrySet() {
            return char2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.chars.CharSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public Set<Character> keySet() {
            CharSet charSet;
            synchronized (this.sync) {
                if (this.keys == null) {
                    this.keys = CharSets.synchronize(this.map.keySet(), this.sync);
                }
                charSet = this.keys;
            }
            return charSet;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
        public V getOrDefault(char key, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, (char) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super V> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Character, ? super V, ? extends V> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V putIfAbsent(char key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, (char) value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public boolean remove(char key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V replace(char key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, (char) value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public boolean replace(char key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V computeIfAbsent(char key, IntFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V computeIfAbsent(char key, Char2ObjectFunction<? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, (Char2ObjectFunction) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V computeIfPresent(char key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V compute(char key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V merge(char key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, (char) value, (BiFunction<? super char, ? super char, ? extends char>) remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Character key, V value) {
            V replace;
            synchronized (this.sync) {
                replace = this.map.replace((Char2ObjectMap<V>) key, (Character) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Character key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Char2ObjectMap<V>) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public V putIfAbsent(Character key, V value) {
            V putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Char2ObjectMap<V>) key, (Character) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public V computeIfAbsent(Character key, Function<? super Character, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Char2ObjectMap<V>) key, (Function<? super Char2ObjectMap<V>, ? extends V>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public V computeIfPresent(Character key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Char2ObjectMap<V>) key, (BiFunction<? super Char2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public V compute(Character key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.sync) {
                compute = this.map.compute((Char2ObjectMap<V>) key, (BiFunction<? super Char2ObjectMap<V>, ? super V, ? extends V>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public V merge(Character key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.sync) {
                merge = this.map.merge((Char2ObjectMap<V>) key, (Character) value, (BiFunction<? super Character, ? super Character, ? extends Character>) remappingFunction);
            }
            return merge;
        }
    }

    public static <V> Char2ObjectMap<V> synchronize(Char2ObjectMap<V> m) {
        return new SynchronizedMap(m);
    }

    public static <V> Char2ObjectMap<V> synchronize(Char2ObjectMap<V> m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap<V> extends Char2ObjectFunctions.UnmodifiableFunction<V> implements Char2ObjectMap<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2ObjectMap<? extends V> map;
        protected transient ObjectSet<Char2ObjectMap.Entry<V>> entries;
        protected transient CharSet keys;
        protected transient ObjectCollection<V> values;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object merge(Character ch, Object obj, BiFunction biFunction) {
            return merge(ch, (Character) obj, (BiFunction<? super Character, ? super Character, ? extends Character>) biFunction);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object replace(Character ch, Object obj) {
            return replace(ch, (Character) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        @Deprecated
        public /* bridge */ /* synthetic */ Object putIfAbsent(Character ch, Object obj) {
            return putIfAbsent(ch, (Character) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Char2ObjectMap<? extends V> m) {
            super(m);
            this.map = m;
        }

        @Override // java.util.Map
        public boolean containsValue(Object v) {
            return this.map.containsValue(v);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
        public ObjectSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.char2ObjectEntrySet());
            }
            return this.entries;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        @Deprecated
        public ObjectSet<Map.Entry<Character, V>> entrySet() {
            return char2ObjectEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.chars.CharSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public Set<Character> keySet() {
            if (this.keys == null) {
                this.keys = CharSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
        public V getOrDefault(char key, V defaultValue) {
            return (V) this.map.getOrDefault(key, (char) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super V> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Character, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V putIfAbsent(char key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public boolean remove(char key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V replace(char key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public boolean replace(char key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V computeIfAbsent(char key, IntFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V computeIfAbsent(char key, Char2ObjectFunction<? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V computeIfPresent(char key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V compute(char key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap
        public V merge(char key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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
        public V replace(Character key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Character key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V putIfAbsent(Character key, V value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfAbsent(Character key, Function<? super Character, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V computeIfPresent(Character key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V compute(Character key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public V merge(Character key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Char2ObjectMap<V> unmodifiable(Char2ObjectMap<? extends V> m) {
        return new UnmodifiableMap(m);
    }
}
