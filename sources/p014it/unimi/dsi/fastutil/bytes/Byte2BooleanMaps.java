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
import java.util.function.IntPredicate;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollections;
import p014it.unimi.dsi.fastutil.booleans.BooleanSets;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterable;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectSets;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanMaps.class */
public final class Byte2BooleanMaps {
    public static final EmptyMap EMPTY_MAP = new EmptyMap();

    private Byte2BooleanMaps() {
    }

    public static ObjectIterator<Byte2BooleanMap.Entry> fastIterator(Byte2BooleanMap map) {
        ObjectSet<Byte2BooleanMap.Entry> entries = map.byte2BooleanEntrySet();
        return entries instanceof Byte2BooleanMap.FastEntrySet ? ((Byte2BooleanMap.FastEntrySet) entries).fastIterator() : entries.iterator();
    }

    public static void fastForEach(Byte2BooleanMap map, Consumer<? super Byte2BooleanMap.Entry> consumer) {
        ObjectSet<Byte2BooleanMap.Entry> entries = map.byte2BooleanEntrySet();
        if (entries instanceof Byte2BooleanMap.FastEntrySet) {
            ((Byte2BooleanMap.FastEntrySet) entries).fastForEach(consumer);
        } else {
            entries.forEach(consumer);
        }
    }

    public static ObjectIterable<Byte2BooleanMap.Entry> fastIterable(Byte2BooleanMap map) {
        final ObjectSet<Byte2BooleanMap.Entry> entries = map.byte2BooleanEntrySet();
        return entries instanceof Byte2BooleanMap.FastEntrySet ? new ObjectIterable<Byte2BooleanMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps.1
            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<Byte2BooleanMap.Entry> iterator() {
                return ((Byte2BooleanMap.FastEntrySet) ObjectSet.this).fastIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<Byte2BooleanMap.Entry> spliterator() {
                return ObjectSet.this.spliterator();
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Byte2BooleanMap.Entry> consumer) {
                ((Byte2BooleanMap.FastEntrySet) ObjectSet.this).fastForEach(consumer);
            }
        } : entries;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps$EmptyMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanMaps$EmptyMap.class */
    public static class EmptyMap extends Byte2BooleanFunctions.EmptyFunction implements Byte2BooleanMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean containsValue(boolean v) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object key, Boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.EmptyFunction, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
        public boolean getOrDefault(byte key, boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return false;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            return ObjectSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public Set<Byte> keySet() {
            return ByteSets.EMPTY_SET;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public Collection<Boolean> values() {
            return BooleanSets.EMPTY_SET;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Boolean> consumer) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.EmptyFunction, java.lang.Object
        public Object clone() {
            return Byte2BooleanMaps.EMPTY_MAP;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.EmptyFunction, java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.EmptyFunction, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map)) {
                return false;
            }
            return ((Map) o).isEmpty();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.EmptyFunction, java.lang.Object
        public String toString() {
            return "{}";
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanMaps$Singleton.class */
    public static class Singleton extends Byte2BooleanFunctions.Singleton implements Byte2BooleanMap, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected transient ObjectSet<Byte2BooleanMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient BooleanCollection values;

        /* access modifiers changed from: protected */
        public Singleton(byte key, boolean value) {
            super(key, value);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean containsValue(boolean v) {
            return this.value == v;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return ((Boolean) ov).booleanValue() == this.value;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.singleton(new AbstractByte2BooleanMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Boolean>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Boolean>> entrySet() {
            return byte2BooleanEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.singleton(this.key);
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
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
            return this.key ^ (this.value ? (byte) 1231 : 1237);
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

    public static Byte2BooleanMap singleton(byte key, boolean value) {
        return new Singleton(key, value);
    }

    public static Byte2BooleanMap singleton(Byte key, Boolean value) {
        return new Singleton(key.byteValue(), value.booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps$SynchronizedMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanMaps$SynchronizedMap.class */
    public static class SynchronizedMap extends Byte2BooleanFunctions.SynchronizedFunction implements Byte2BooleanMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2BooleanMap map;
        protected transient ObjectSet<Byte2BooleanMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient BooleanCollection values;

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2BooleanMap m, Object sync) {
            super(m, sync);
            this.map = m;
        }

        /* access modifiers changed from: protected */
        public SynchronizedMap(Byte2BooleanMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean containsValue(boolean v) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(v);
            }
            return containsValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            boolean containsValue;
            synchronized (this.sync) {
                containsValue = this.map.containsValue(ov);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Boolean> m) {
            synchronized (this.sync) {
                this.map.putAll(m);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            ObjectSet<Byte2BooleanMap.Entry> objectSet;
            synchronized (this.sync) {
                if (this.entries == null) {
                    this.entries = ObjectSets.synchronize(this.map.byte2BooleanEntrySet(), this.sync);
                }
                objectSet = this.entries;
            }
            return objectSet;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Boolean>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Boolean>> entrySet() {
            return byte2BooleanEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
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

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v4, types: [it.unimi.dsi.fastutil.booleans.BooleanCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.SynchronizedFunction, java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.map.hashCode();
            }
            return hashCode;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.SynchronizedFunction, java.lang.Object
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
        public boolean getOrDefault(byte key, boolean defaultValue) {
            boolean orDefault;
            synchronized (this.sync) {
                orDefault = this.map.getOrDefault(key, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Boolean> action) {
            synchronized (this.sync) {
                this.map.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Boolean, ? extends Boolean> function) {
            synchronized (this.sync) {
                this.map.replaceAll(function);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean putIfAbsent(byte key, boolean value) {
            boolean putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean remove(byte key, boolean value) {
            boolean remove;
            synchronized (this.sync) {
                remove = this.map.remove(key, value);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean replace(byte key, boolean value) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, value);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean replace(byte key, boolean oldValue, boolean newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfAbsent(byte key, IntPredicate mappingFunction) {
            boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfAbsentNullable(byte key, IntFunction<? extends Boolean> mappingFunction) {
            boolean computeIfAbsentNullable;
            synchronized (this.sync) {
                computeIfAbsentNullable = this.map.computeIfAbsentNullable(key, mappingFunction);
            }
            return computeIfAbsentNullable;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfAbsent(byte key, Byte2BooleanFunction mappingFunction) {
            boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfPresent(byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean compute(byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean compute;
            synchronized (this.sync) {
                compute = this.map.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean merge(byte key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            boolean merge;
            synchronized (this.sync) {
                merge = this.map.merge(key, value, remappingFunction);
            }
            return merge;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.SynchronizedFunction, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
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
        public Boolean replace(Byte key, Boolean value) {
            Boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Byte2BooleanMap) key, (Byte) value);
            }
            return replace;
        }

        @Deprecated
        public boolean replace(Byte key, Boolean oldValue, Boolean newValue) {
            boolean replace;
            synchronized (this.sync) {
                replace = this.map.replace((Byte2BooleanMap) key, oldValue, newValue);
            }
            return replace;
        }

        @Deprecated
        public Boolean putIfAbsent(Byte key, Boolean value) {
            Boolean putIfAbsent;
            synchronized (this.sync) {
                putIfAbsent = this.map.putIfAbsent((Byte2BooleanMap) key, (Byte) value);
            }
            return putIfAbsent;
        }

        @Deprecated
        public Boolean computeIfAbsent(Byte key, Function<? super Byte, ? extends Boolean> mappingFunction) {
            Boolean computeIfAbsent;
            synchronized (this.sync) {
                computeIfAbsent = this.map.computeIfAbsent((Byte2BooleanMap) key, (Function<? super Byte2BooleanMap, ? extends Boolean>) mappingFunction);
            }
            return computeIfAbsent;
        }

        @Deprecated
        public Boolean computeIfPresent(Byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean computeIfPresent;
            synchronized (this.sync) {
                computeIfPresent = this.map.computeIfPresent((Byte2BooleanMap) key, (BiFunction<? super Byte2BooleanMap, ? super Boolean, ? extends Boolean>) remappingFunction);
            }
            return computeIfPresent;
        }

        @Deprecated
        public Boolean compute(Byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean compute;
            synchronized (this.sync) {
                compute = this.map.compute((Byte2BooleanMap) key, (BiFunction<? super Byte2BooleanMap, ? super Boolean, ? extends Boolean>) remappingFunction);
            }
            return compute;
        }

        @Deprecated
        public Boolean merge(Byte key, Boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            Boolean merge;
            synchronized (this.sync) {
                merge = this.map.merge((Byte2BooleanMap) key, (Byte) value, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) remappingFunction);
            }
            return merge;
        }
    }

    public static Byte2BooleanMap synchronize(Byte2BooleanMap m) {
        return new SynchronizedMap(m);
    }

    public static Byte2BooleanMap synchronize(Byte2BooleanMap m, Object sync) {
        return new SynchronizedMap(m, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2BooleanMaps$UnmodifiableMap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2BooleanMaps$UnmodifiableMap.class */
    public static class UnmodifiableMap extends Byte2BooleanFunctions.UnmodifiableFunction implements Byte2BooleanMap, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2BooleanMap map;
        protected transient ObjectSet<Byte2BooleanMap.Entry> entries;
        protected transient ByteSet keys;
        protected transient BooleanCollection values;

        /* access modifiers changed from: protected */
        public UnmodifiableMap(Byte2BooleanMap m) {
            super(m);
            this.map = m;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean containsValue(boolean v) {
            return this.map.containsValue(v);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public boolean containsValue(Object ov) {
            return this.map.containsValue(ov);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends Boolean> m) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanSortedMap
        public ObjectSet<Byte2BooleanMap.Entry> byte2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = ObjectSets.unmodifiable(this.map.byte2BooleanEntrySet());
            }
            return this.entries;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Boolean>>' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        @Deprecated
        public Set<Map.Entry<Byte, Boolean>> entrySet() {
            return byte2BooleanEntrySet();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.bytes.ByteSet] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public Set<Byte> keySet() {
            if (this.keys == null) {
                this.keys = ByteSets.unmodifiable(this.map.keySet());
            }
            return this.keys;
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
        /* JADX WARN: Type inference failed for: r1v2, types: [it.unimi.dsi.fastutil.booleans.BooleanCollection] */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.UnmodifiableFunction, java.lang.Object
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.UnmodifiableFunction, java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return this.map.equals(o);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
        public boolean getOrDefault(byte key, boolean defaultValue) {
            return this.map.getOrDefault(key, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void forEach(BiConsumer<? super Byte, ? super Boolean> action) {
            this.map.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super Byte, ? super Boolean, ? extends Boolean> function) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean putIfAbsent(byte key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean remove(byte key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean replace(byte key, boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean replace(byte key, boolean oldValue, boolean newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfAbsent(byte key, IntPredicate mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfAbsentNullable(byte key, IntFunction<? extends Boolean> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfAbsent(byte key, Byte2BooleanFunction mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean computeIfPresent(byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean compute(byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap
        public boolean merge(byte key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunctions.UnmodifiableFunction, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
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
        public Boolean replace(Byte key, Boolean value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public boolean replace(Byte key, Boolean oldValue, Boolean newValue) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean putIfAbsent(Byte key, Boolean value) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean computeIfAbsent(Byte key, Function<? super Byte, ? extends Boolean> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean computeIfPresent(Byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean compute(Byte key, BiFunction<? super Byte, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public Boolean merge(Byte key, Boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static Byte2BooleanMap unmodifiable(Byte2BooleanMap m) {
        return new UnmodifiableMap(m);
    }
}
