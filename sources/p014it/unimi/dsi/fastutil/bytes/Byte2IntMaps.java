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
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2IntMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntCollections;
import p014it.unimi.dsi.fastutil.ints.IntSets;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMaps.class */
public final class Byte2IntMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Byte2IntMaps() {
    }

    public static ObjectIterator<Byte2IntMap.Entry> fastIterator(Byte2IntMap map) {
        ObjectSet<Byte2IntMap.Entry> entries = map.byte2IntEntrySet();
        return entries instanceof Byte2IntMap.FastEntrySet ? ((Byte2IntMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Byte2IntMap map, Consumer<? super Byte2IntMap.Entry> consumer) {
        ObjectSet<Byte2IntMap.Entry> entries = map.byte2IntEntrySet();
        if (entries instanceof Byte2IntMap.FastEntrySet) {
            ((Byte2IntMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Byte2IntMap.Entry> fastIterable(Byte2IntMap map) {
        final ObjectSet<Byte2IntMap.Entry> entries = map.byte2IntEntrySet();
        return entries instanceof Byte2IntMap.FastEntrySet ? new ObjectIterable<Byte2IntMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2IntMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Byte2IntMap.Entry> iterator() {
                return ((Byte2IntMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Byte2IntMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Byte2IntMap.Entry> consumer) {
                ((Byte2IntMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMaps$EmptyMap.class */
    public static class EmptyMap extends Byte2IntFunctions.EmptyFunction implements Byte2IntMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean containsValue(int v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
        public int getOrDefault(byte key, int defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Integer> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, p014it.unimi.dsi.fastutil.bytes.Byte2IntSortedMap
        public ObjectSet<Byte2IntMap.Entry> byte2IntEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public Set<Byte> keySet() {
            return ByteSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public Collection<Integer> values() {
            return IntSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Integer> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Byte2IntMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMaps$Singleton.class */
    public static class Singleton extends Byte2IntFunctions.Singleton implements Byte2IntMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Byte2IntMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient IntCollection values;

        /* access modifiers changed from: protected */
        public Singleton(byte key, int value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean containsValue(int v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Integer) ov).intValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Integer> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, p014it.unimi.dsi.fastutil.bytes.Byte2IntSortedMap
        public ObjectSet<Byte2IntMap.Entry> byte2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractByte2IntMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Integer>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Integer>> entrySet() {
            return byte2IntEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public Collection<Integer> values() {
            if (this.values == null) {
                this.values = IntSets.singleton(this.value);
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

    public static Byte2IntMap singleton(byte key, int value) {
        return new Singleton(key, value);
    }

    public static Byte2IntMap singleton(Byte key, Integer value) {
        return new Singleton(key.byteValue(), value.intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Byte2IntFunctions.SynchronizedFunction implements Byte2IntMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2IntMap map;
        protected transient ObjectSet<Byte2IntMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient IntCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2IntMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2IntMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean containsValue(int v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Integer> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, p014it.unimi.dsi.fastutil.bytes.Byte2IntSortedMap
        public ObjectSet<Byte2IntMap.Entry> byte2IntEntrySet() {
            ObjectSet<Byte2IntMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.byte2IntEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Integer>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Integer>> entrySet() {
            return byte2IntEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.ints.IntCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public Collection<Integer> values() {
            IntCollection intCollection;
            synchronized (this.sync) {
                if (this.values == null) {
                    this.values = IntCollections.synchronize(this.map.values(), this.sync);
                }
                intCollection = this.values;
            }
            return intCollection;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.sync) {
                isEmpty = this.map.isEmpty();
            }
            return isEmpty;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
        public int getOrDefault(byte key, int defaultValue) {
            int orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Integer> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Integer, ? extends Integer> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int putIfAbsent(byte key, int value) {
            int putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean remove(byte key, int value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int replace(byte key, int value) {
            int replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean replace(byte key, int oldValue, int newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
            int computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfAbsentNullable(byte key, IntFunction<? extends Integer> mappingFunction) {
            int computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfAbsent(byte key, Byte2IntFunction mappingFunction) {
            int computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfPresent(byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            int computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int compute(byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            int compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int merge(byte key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            int merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            Integer orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer replace(Byte key, Integer value) {
            Integer replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public boolean replace(Byte key, Integer oldValue, Integer newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer putIfAbsent(Byte key, Integer value) {
            Integer putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer computeIfAbsent(Byte key, Function<? super Byte, ? extends Integer> mappingFunction) {
            Integer computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer computeIfPresent(Byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            Integer computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer compute(Byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            Integer compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer merge(Byte key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            Integer merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }
    }

    public static Byte2IntMap synchronize(Byte2IntMap m) {
        return new SynchronizedMap(m);
    }

    public static Byte2IntMap synchronize(Byte2IntMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Byte2IntFunctions.UnmodifiableFunction implements Byte2IntMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2IntMap map;
        protected transient ObjectSet<Byte2IntMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient IntCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Byte2IntMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean containsValue(int v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Integer> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, p014it.unimi.dsi.fastutil.bytes.Byte2IntSortedMap
        public ObjectSet<Byte2IntMap.Entry> byte2IntEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.byte2IntEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Integer>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Integer>> entrySet() {
            return byte2IntEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.ints.IntCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public Collection<Integer> values() {
            if (this.values == null) {
                this.values = IntCollections.unmodifiable(this.map.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
        public int getOrDefault(byte key, int defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Integer> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Integer, ? extends Integer> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int putIfAbsent(byte key, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean remove(byte key, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int replace(byte key, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public boolean replace(byte key, int oldValue, int newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfAbsentNullable(byte key, IntFunction<? extends Integer> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfAbsent(byte key, Byte2IntFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int computeIfPresent(byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int compute(byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        public int merge(byte key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap, java.util.Map
        @Deprecated
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer replace(Byte key, Integer value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public boolean replace(Byte key, Integer oldValue, Integer newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer putIfAbsent(Byte key, Integer value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer computeIfAbsent(Byte key, Function<? super Byte, ? extends Integer> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer computeIfPresent(Byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer compute(Byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntMap
        @Deprecated
        public Integer merge(Byte key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Byte2IntMap unmodifiable(Byte2IntMap m) {
        return new UnmodifiableMap(m);
    }
}
