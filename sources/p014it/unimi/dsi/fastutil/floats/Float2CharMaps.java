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
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollections;
import p014it.unimi.dsi.fastutil.chars.CharSets;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunctions;
import p014it.unimi.dsi.fastutil.floats.Float2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2CharMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharMaps.class */
public final class Float2CharMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Float2CharMaps() {
    }

    public static ObjectIterator<Float2CharMap.Entry> fastIterator(Float2CharMap map) {
        ObjectSet<Float2CharMap.Entry> entries = map.float2CharEntrySet();
        return entries instanceof Float2CharMap.FastEntrySet ? ((Float2CharMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Float2CharMap map, Consumer<? super Float2CharMap.Entry> consumer) {
        ObjectSet<Float2CharMap.Entry> entries = map.float2CharEntrySet();
        if (entries instanceof Float2CharMap.FastEntrySet) {
            ((Float2CharMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Float2CharMap.Entry> fastIterable(Float2CharMap map) {
        final ObjectSet<Float2CharMap.Entry> entries = map.float2CharEntrySet();
        return entries instanceof Float2CharMap.FastEntrySet ? new ObjectIterable<Float2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2CharMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Float2CharMap.Entry> iterator() {
                return ((Float2CharMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Float2CharMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Float2CharMap.Entry> consumer) {
                ((Float2CharMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharMaps$EmptyMap.class */
    public static class EmptyMap extends Float2CharFunctions.EmptyFunction implements Float2CharMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean containsValue(char v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.floats.Float2CharFunction
        public char getOrDefault(float key, char defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSet<Float2CharMap.Entry> float2CharEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public Set<Float> keySet() {
            return FloatSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public Collection<Character> values() {
            return CharSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Character> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Float2CharMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharMaps$Singleton.class */
    public static class Singleton extends Float2CharFunctions.Singleton implements Float2CharMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Float2CharMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient CharCollection values;

        /* access modifiers changed from: protected */
        public Singleton(float key, char value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean containsValue(char v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Character) ov).charValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSet<Float2CharMap.Entry> float2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractFloat2CharMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Character>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Character>> entrySet() {
            return float2CharEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
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
            return "{" + this.key + "=>" + this.value + "}";
        }
    }

    public static Float2CharMap singleton(float key, char value) {
        return new Singleton(key, value);
    }

    public static Float2CharMap singleton(Float key, Character value) {
        return new Singleton(key.floatValue(), value.charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Float2CharFunctions.SynchronizedFunction implements Float2CharMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2CharMap map;
        protected transient ObjectSet<Float2CharMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient CharCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2CharMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Float2CharMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean containsValue(char v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Character> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSet<Float2CharMap.Entry> float2CharEntrySet() {
            ObjectSet<Float2CharMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.float2CharEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Character>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Character>> entrySet() {
            return float2CharEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.chars.CharCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2CharFunction
        public char getOrDefault(float key, char defaultValue) {
            char orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Character> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Character, ? extends Character> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char putIfAbsent(float key, char value) {
            char putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean remove(float key, char value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char replace(float key, char value) {
            char replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean replace(float key, char oldValue, char newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfAbsent(float key, DoubleToIntFunction mappingFunction) {
            char computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfAbsentNullable(float key, DoubleFunction<? extends Character> mappingFunction) {
            char computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfAbsent(float key, Float2CharFunction mappingFunction) {
            char computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfPresent(float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            char computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char compute(float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            char compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char merge(float key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            char merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.floats.Float2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            Character orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character replace(Float key, Character value) {
            Character replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public boolean replace(Float key, Character oldValue, Character newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character putIfAbsent(Float key, Character value) {
            Character putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character computeIfAbsent(Float key, Function<? super Float, ? extends Character> mappingFunction) {
            Character computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character computeIfPresent(Float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            Character computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character compute(Float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            Character compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character merge(Float key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            Character merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Float2CharMap synchronize(Float2CharMap m) {
        return new SynchronizedMap(m);
    }

    public static Float2CharMap synchronize(Float2CharMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2CharMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2CharMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Float2CharFunctions.UnmodifiableFunction implements Float2CharMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2CharMap map;
        protected transient ObjectSet<Float2CharMap.Entry> entries;
        protected transient FloatSet keys;
        protected transient CharCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Float2CharMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean containsValue(char v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Float, ? extends Character> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, p014it.unimi.dsi.fastutil.floats.Float2CharSortedMap
        public ObjectSet<Float2CharMap.Entry> float2CharEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.float2CharEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Character>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Float, Character>> entrySet() {
            return float2CharEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatSet] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public Set<Float> keySet() {
            if (this.keys == null) {
                this.keys = FloatSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.chars.CharCollection] */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2CharFunction
        public char getOrDefault(float key, char defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        public void forEach(BiConsumer<? super Float, ? super Character> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Float, ? super Character, ? extends Character> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char putIfAbsent(float key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean remove(float key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char replace(float key, char value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public boolean replace(float key, char oldValue, char newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfAbsent(float key, DoubleToIntFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfAbsentNullable(float key, DoubleFunction<? extends Character> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfAbsent(float key, Float2CharFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char computeIfPresent(float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char compute(float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        public char merge(float key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.floats.Float2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character replace(Float key, Character value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public boolean replace(Float key, Character oldValue, Character newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character putIfAbsent(Float key, Character value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character computeIfAbsent(Float key, Function<? super Float, ? extends Character> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character computeIfPresent(Float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character compute(Float key, BiFunction<? super Float, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
        @Deprecated
        public Character merge(Float key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Float2CharMap unmodifiable(Float2CharMap m) {
        return new UnmodifiableMap(m);
    }
}
