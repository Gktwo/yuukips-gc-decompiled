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
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollections;
import p014it.unimi.dsi.fastutil.chars.CharSets;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2CharMap;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions;
import p014it.unimi.dsi.fastutil.shorts.Short2CharMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharMaps.class */
public final class Short2CharMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Short2CharMaps() {
    }

    public static ObjectIterator<Short2CharMap.Entry> fastIterator(Short2CharMap map) {
        ObjectSet<Short2CharMap.Entry> entries = map.short2CharEntrySet();
        return entries instanceof Short2CharMap.FastEntrySet ? ((Short2CharMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Short2CharMap map, Consumer<? super Short2CharMap.Entry> consumer) {
        ObjectSet<Short2CharMap.Entry> entries = map.short2CharEntrySet();
        if (entries instanceof Short2CharMap.FastEntrySet) {
            ((Short2CharMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Short2CharMap.Entry> fastIterable(Short2CharMap map) {
        final ObjectSet<Short2CharMap.Entry> entries = map.short2CharEntrySet();
        return entries instanceof Short2CharMap.FastEntrySet ? new ObjectIterable<Short2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.shorts.Short2CharMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Short2CharMap.Entry> iterator() {
                return ((Short2CharMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Short2CharMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Short2CharMap.Entry> consumer) {
                ((Short2CharMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharMaps$EmptyMap.class */
    public static class EmptyMap extends Short2CharFunctions.EmptyFunction implements Short2CharMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean containsValue(char v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
        public char getOrDefault(short key, char defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharSortedMap
        public ObjectSet<Short2CharMap.Entry> short2CharEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        public Set<Short> keySet() {
            return ShortSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        public Collection<Character> values() {
            return CharSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super Character> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Short2CharMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharMaps$Singleton.class */
    public static class Singleton extends Short2CharFunctions.Singleton implements Short2CharMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Short2CharMap.Entry> entries;
        protected transient ShortSet keys;
        protected transient CharCollection values;

        /* access modifiers changed from: protected */
        public Singleton(short key, char value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean containsValue(char v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Character) ov).charValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharSortedMap
        public ObjectSet<Short2CharMap.Entry> short2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractShort2CharMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Character>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Short, Character>> entrySet() {
            return short2CharEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        public Set<Short> keySet() {
            if (this.keys == null) {
                this.keys = ShortSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
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
            return "{" + ((int) this.key) + "=>" + this.value + "}";
        }
    }

    public static Short2CharMap singleton(short key, char value) {
        return new Singleton(key, value);
    }

    public static Short2CharMap singleton(Short key, Character value) {
        return new Singleton(key.shortValue(), value.charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Short2CharFunctions.SynchronizedFunction implements Short2CharMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2CharMap map;
        protected transient ObjectSet<Short2CharMap.Entry> entries;
        protected transient ShortSet keys;
        protected transient CharCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Short2CharMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Short2CharMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean containsValue(char v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Character> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharSortedMap
        public ObjectSet<Short2CharMap.Entry> short2CharEntrySet() {
            ObjectSet<Short2CharMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.short2CharEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Character>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Short, Character>> entrySet() {
            return short2CharEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.shorts.ShortSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.chars.CharCollection] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
        public char getOrDefault(short key, char defaultValue) {
            char orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super Character> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Short, ? super Character, ? extends Character> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char putIfAbsent(short key, char value) {
            char putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean remove(short key, char value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char replace(short key, char value) {
            char replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean replace(short key, char oldValue, char newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfAbsent(short key, IntUnaryOperator mappingFunction) {
            char computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfAbsentNullable(short key, IntFunction<? extends Character> mappingFunction) {
            char computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfAbsent(short key, Short2CharFunction mappingFunction) {
            char computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfPresent(short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            char computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char compute(short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            char compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char merge(short key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            char merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            Character orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character replace(Short key, Character value) {
            Character replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public boolean replace(Short key, Character oldValue, Character newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character putIfAbsent(Short key, Character value) {
            Character putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character computeIfAbsent(Short key, Function<? super Short, ? extends Character> mappingFunction) {
            Character computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character computeIfPresent(Short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            Character computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character compute(Short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            Character compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character merge(Short key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            Character merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Short2CharMap synchronize(Short2CharMap m) {
        return new SynchronizedMap(m);
    }

    public static Short2CharMap synchronize(Short2CharMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Short2CharFunctions.UnmodifiableFunction implements Short2CharMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2CharMap map;
        protected transient ObjectSet<Short2CharMap.Entry> entries;
        protected transient ShortSet keys;
        protected transient CharCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Short2CharMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean containsValue(char v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, p014it.unimi.dsi.fastutil.shorts.Short2CharSortedMap
        public ObjectSet<Short2CharMap.Entry> short2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.short2CharEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Character>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Short, Character>> entrySet() {
            return short2CharEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.shorts.ShortSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        public Set<Short> keySet() {
            if (this.keys == null) {
                this.keys = ShortSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.chars.CharCollection] */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
        public char getOrDefault(short key, char defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        public void forEach(BiConsumer<? super Short, ? super Character> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Short, ? super Character, ? extends Character> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char putIfAbsent(short key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean remove(short key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char replace(short key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public boolean replace(short key, char oldValue, char newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfAbsent(short key, IntUnaryOperator mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfAbsentNullable(short key, IntFunction<? extends Character> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfAbsent(short key, Short2CharFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char computeIfPresent(short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char compute(short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        public char merge(short key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.shorts.Short2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character replace(Short key, Character value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public boolean replace(Short key, Character oldValue, Character newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character putIfAbsent(Short key, Character value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character computeIfAbsent(Short key, Function<? super Short, ? extends Character> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character computeIfPresent(Short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character compute(Short key, BiFunction<? super Short, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap
        @Deprecated
        public Character merge(Short key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Short2CharMap unmodifiable(Short2CharMap m) {
        return new UnmodifiableMap(m);
    }
}
