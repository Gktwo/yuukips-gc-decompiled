package p014it.unimi.dsi.fastutil.chars;

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
import java.util.function.IntPredicate;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollections;
import p014it.unimi.dsi.fastutil.booleans.BooleanSets;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2BooleanMap;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMaps.class */
public final class Char2BooleanMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Char2BooleanMaps() {
    }

    public static ObjectIterator<Char2BooleanMap.Entry> fastIterator(Char2BooleanMap map) {
        ObjectSet<Char2BooleanMap.Entry> entries = map.char2BooleanEntrySet();
        return entries instanceof Char2BooleanMap.FastEntrySet ? ((Char2BooleanMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Char2BooleanMap map, Consumer<? super Char2BooleanMap.Entry> consumer) {
        ObjectSet<Char2BooleanMap.Entry> entries = map.char2BooleanEntrySet();
        if (entries instanceof Char2BooleanMap.FastEntrySet) {
            ((Char2BooleanMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Char2BooleanMap.Entry> fastIterable(Char2BooleanMap map) {
        final ObjectSet<Char2BooleanMap.Entry> entries = map.char2BooleanEntrySet();
        return entries instanceof Char2BooleanMap.FastEntrySet ? new ObjectIterable<Char2BooleanMap.Entry>() { // from class: it.unimi.dsi.fastutil.chars.Char2BooleanMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Char2BooleanMap.Entry> iterator() {
                return ((Char2BooleanMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Char2BooleanMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Char2BooleanMap.Entry> consumer) {
                ((Char2BooleanMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMaps$EmptyMap.class */
    public static class EmptyMap extends Char2BooleanFunctions.EmptyFunction implements Char2BooleanMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean containsValue(boolean v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object key, Boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
        public boolean getOrDefault(char key, boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public Set<Character> keySet() {
            return CharSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public Collection<Boolean> values() {
            return BooleanSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super Boolean> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Char2BooleanMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMaps$Singleton.class */
    public static class Singleton extends Char2BooleanFunctions.Singleton implements Char2BooleanMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Char2BooleanMap.Entry> entries;
        protected transient CharSet keys;
        protected transient BooleanCollection values;

        /* access modifiers changed from: protected */
        public Singleton(char key, boolean value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean containsValue(boolean v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Boolean) ov).booleanValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractChar2BooleanMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Boolean>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Character, Boolean>> entrySet() {
            return char2BooleanEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public Set<Character> keySet() {
            if (this.keys == null) {
                this.keys = CharSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
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
            return this.key ^ (this.value ? (char) 1231 : 1237);
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

    public static Char2BooleanMap singleton(char key, boolean value) {
        return new Singleton(key, value);
    }

    public static Char2BooleanMap singleton(Character key, Boolean value) {
        return new Singleton(key.charValue(), value.booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Char2BooleanFunctions.SynchronizedFunction implements Char2BooleanMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2BooleanMap map;
        protected transient ObjectSet<Char2BooleanMap.Entry> entries;
        protected transient CharSet keys;
        protected transient BooleanCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Char2BooleanMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Char2BooleanMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean containsValue(boolean v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Boolean> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            ObjectSet<Char2BooleanMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.char2BooleanEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Boolean>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Character, Boolean>> entrySet() {
            return char2BooleanEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.chars.CharSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.booleans.BooleanCollection] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
        public boolean getOrDefault(char key, boolean defaultValue) {
            boolean orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super Boolean> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Character, ? super Boolean, ? extends Boolean> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean putIfAbsent(char key, boolean value) {
            boolean putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean remove(char key, boolean value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean replace(char key, boolean value) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean replace(char key, boolean oldValue, boolean newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfAbsent(char key, IntPredicate mappingFunction) {
            boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfAbsentNullable(char key, IntFunction<? extends Boolean> mappingFunction) {
            boolean computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfAbsent(char key, Char2BooleanFunction mappingFunction) {
            boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfPresent(char key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean compute(char key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean merge(char key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
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
        public Boolean replace(Character key, Boolean value) {
            Boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Char2BooleanMap) key, (Character) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Character key, Boolean oldValue, Boolean newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Char2BooleanMap) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public Boolean putIfAbsent(Character key, Boolean value) {
            Boolean putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Char2BooleanMap) key, (Character) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public Boolean computeIfAbsent(Character key, Function<? super Character, ? extends Boolean> mappingFunction) {
            Boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Char2BooleanMap) key, (Function<? super Char2BooleanMap, ? extends Boolean>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public Boolean computeIfPresent(Character key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Char2BooleanMap) key, (BiFunction<? super Char2BooleanMap, ? super Boolean, ? extends Boolean>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public Boolean compute(Character key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean compute;
            synchronized (this.sync) {
                compute = this.map.compute((Char2BooleanMap) key, (BiFunction<? super Char2BooleanMap, ? super Boolean, ? extends Boolean>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public Boolean merge(Character key, Boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean merge;
            synchronized (this.sync) {
                merge = this.map.merge((Char2BooleanMap) key, (Character) value, (BiFunction<? super Character, ? super Character, ? extends Character>) remappingFunction);
            }
            return merge;
        }
    }

    public static Char2BooleanMap synchronize(Char2BooleanMap m) {
        return new SynchronizedMap(m);
    }

    public static Char2BooleanMap synchronize(Char2BooleanMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Char2BooleanFunctions.UnmodifiableFunction implements Char2BooleanMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2BooleanMap map;
        protected transient ObjectSet<Char2BooleanMap.Entry> entries;
        protected transient CharSet keys;
        protected transient BooleanCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Char2BooleanMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean containsValue(boolean v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
        public ObjectSet<Char2BooleanMap.Entry> char2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.char2BooleanEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Boolean>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Character, Boolean>> entrySet() {
            return char2BooleanEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.chars.CharSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public Set<Character> keySet() {
            if (this.keys == null) {
                this.keys = CharSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.booleans.BooleanCollection] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
        public boolean getOrDefault(char key, boolean defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super Boolean> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Character, ? super Boolean, ? extends Boolean> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean putIfAbsent(char key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean remove(char key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean replace(char key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean replace(char key, boolean oldValue, boolean newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfAbsent(char key, IntPredicate mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfAbsentNullable(char key, IntFunction<? extends Boolean> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfAbsent(char key, Char2BooleanFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean computeIfPresent(char key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean compute(char key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap
        public boolean merge(char key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
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
        public Boolean replace(Character key, Boolean value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Character key, Boolean oldValue, Boolean newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean putIfAbsent(Character key, Boolean value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean computeIfAbsent(Character key, Function<? super Character, ? extends Boolean> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean computeIfPresent(Character key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean compute(Character key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean merge(Character key, Boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Char2BooleanMap unmodifiable(Char2BooleanMap m) {
        return new UnmodifiableMap(m);
    }
}
