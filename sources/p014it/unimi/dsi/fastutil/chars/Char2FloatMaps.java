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
import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2FloatMap;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions;
import p014it.unimi.dsi.fastutil.chars.Char2FloatMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollections;
import p014it.unimi.dsi.fastutil.floats.FloatSets;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMaps.class */
public final class Char2FloatMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Char2FloatMaps() {
    }

    public static ObjectIterator<Char2FloatMap.Entry> fastIterator(Char2FloatMap map) {
        ObjectSet<Char2FloatMap.Entry> entries = map.char2FloatEntrySet();
        return entries instanceof Char2FloatMap.FastEntrySet ? ((Char2FloatMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Char2FloatMap map, Consumer<? super Char2FloatMap.Entry> consumer) {
        ObjectSet<Char2FloatMap.Entry> entries = map.char2FloatEntrySet();
        if (entries instanceof Char2FloatMap.FastEntrySet) {
            ((Char2FloatMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Char2FloatMap.Entry> fastIterable(Char2FloatMap map) {
        final ObjectSet<Char2FloatMap.Entry> entries = map.char2FloatEntrySet();
        return entries instanceof Char2FloatMap.FastEntrySet ? new ObjectIterable<Char2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.chars.Char2FloatMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Char2FloatMap.Entry> iterator() {
                return ((Char2FloatMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Char2FloatMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Char2FloatMap.Entry> consumer) {
                ((Char2FloatMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMaps$EmptyMap.class */
    public static class EmptyMap extends Char2FloatFunctions.EmptyFunction implements Char2FloatMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean containsValue(float v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
        public float getOrDefault(char key, float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public Set<Character> keySet() {
            return CharSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public Collection<Float> values() {
            return FloatSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super Float> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Char2FloatMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMaps$Singleton.class */
    public static class Singleton extends Char2FloatFunctions.Singleton implements Char2FloatMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Char2FloatMap.Entry> entries;
        protected transient CharSet keys;
        protected transient FloatCollection values;

        /* access modifiers changed from: protected */
        public Singleton(char key, float value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean containsValue(float v) {
            return Float.floatToIntBits(this.value) == Float.floatToIntBits(v);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return Float.floatToIntBits(((Float) ov).floatValue()) == Float.floatToIntBits(this.value);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractChar2FloatMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Float>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Character, Float>> entrySet() {
            return char2FloatEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public Set<Character> keySet() {
            if (this.keys == null) {
                this.keys = CharSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public Collection<Float> values() {
            if (this.values == null) {
                this.values = FloatSets.singleton(this.value);
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.lang.Object, java.util.Map
        public int hashCode() {
            return this.key ^ HashCommon.float2int(this.value);
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

    public static Char2FloatMap singleton(char key, float value) {
        return new Singleton(key, value);
    }

    public static Char2FloatMap singleton(Character key, Float value) {
        return new Singleton(key.charValue(), value.floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Char2FloatFunctions.SynchronizedFunction implements Char2FloatMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2FloatMap map;
        protected transient ObjectSet<Char2FloatMap.Entry> entries;
        protected transient CharSet keys;
        protected transient FloatCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Char2FloatMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Char2FloatMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean containsValue(float v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Float> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            ObjectSet<Char2FloatMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.char2FloatEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Float>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Character, Float>> entrySet() {
            return char2FloatEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.chars.CharSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.floats.FloatCollection] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public Collection<Float> values() {
            FloatCollection floatCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = FloatCollections.synchronize(this.map.values(), this.sync);
                }
                floatCollection = this.values;
            }
            return floatCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
        public float getOrDefault(char key, float defaultValue) {
            float orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super Float> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Character, ? super Float, ? extends Float> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float putIfAbsent(char key, float value) {
            float putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean remove(char key, float value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float replace(char key, float value) {
            float replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean replace(char key, float oldValue, float newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfAbsent(char key, IntToDoubleFunction mappingFunction) {
            float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfAbsentNullable(char key, IntFunction<? extends Float> mappingFunction) {
            float computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfAbsent(char key, Char2FloatFunction mappingFunction) {
            float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfPresent(char key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            float computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float compute(char key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            float compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float merge(char key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            float merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            Float orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float replace(Character key, Float value) {
            Float replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public boolean replace(Character key, Float oldValue, Float newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float putIfAbsent(Character key, Float value) {
            Float putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float computeIfAbsent(Character key, Function<? super Character, ? extends Float> mappingFunction) {
            Float computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float computeIfPresent(Character key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            Float computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float compute(Character key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            Float compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float merge(Character key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            Float merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Char2FloatMap synchronize(Char2FloatMap m) {
        return new SynchronizedMap(m);
    }

    public static Char2FloatMap synchronize(Char2FloatMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Char2FloatFunctions.UnmodifiableFunction implements Char2FloatMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2FloatMap map;
        protected transient ObjectSet<Char2FloatMap.Entry> entries;
        protected transient CharSet keys;
        protected transient FloatCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Char2FloatMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean containsValue(float v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends Float> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
        public ObjectSet<Char2FloatMap.Entry> char2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.char2FloatEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Float>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Character, Float>> entrySet() {
            return char2FloatEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.chars.CharSet] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public Set<Character> keySet() {
            if (this.keys == null) {
                this.keys = CharSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.floats.FloatCollection] */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public Collection<Float> values() {
            if (this.values == null) {
                this.values = FloatCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
        public float getOrDefault(char key, float defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        public void forEach(BiConsumer<? super Character, ? super Float> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Character, ? super Float, ? extends Float> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float putIfAbsent(char key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean remove(char key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float replace(char key, float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public boolean replace(char key, float oldValue, float newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfAbsent(char key, IntToDoubleFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfAbsentNullable(char key, IntFunction<? extends Float> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfAbsent(char key, Char2FloatFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float computeIfPresent(char key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float compute(char key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        public float merge(char key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float replace(Character key, Float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public boolean replace(Character key, Float oldValue, Float newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float putIfAbsent(Character key, Float value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float computeIfAbsent(Character key, Function<? super Character, ? extends Float> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float computeIfPresent(Character key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float compute(Character key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
        @Deprecated
        public Float merge(Character key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Char2FloatMap unmodifiable(Char2FloatMap m) {
        return new UnmodifiableMap(m);
    }
}
