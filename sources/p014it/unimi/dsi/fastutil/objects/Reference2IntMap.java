package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntMap.class */
public interface Reference2IntMap<K> extends Reference2IntFunction<K>, Map<K, Integer> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction
    void defaultReturnValue(int i);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction
    int defaultReturnValue();

    ObjectSet<Entry<K>> reference2IntEntrySet();

    @Override // java.util.Map
    ReferenceSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // java.util.Map
    Collection<Integer> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(int i);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Integer put(Object obj, Integer num) {
        return put((Reference2IntMap<K>) obj, num);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Integer merge(Object obj, Integer num, BiFunction<? super Integer, ? super Integer, ? extends Integer> biFunction) {
        return merge((Reference2IntMap<K>) obj, num, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Integer replace(Object obj, Integer num) {
        return replace((Reference2IntMap<K>) obj, num);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default boolean replace(Object obj, Integer num, Integer num2) {
        return replace((Reference2IntMap<K>) obj, num, num2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Integer putIfAbsent(Object obj, Integer num) {
        return putIfAbsent((Reference2IntMap<K>) obj, num);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntMap$FastEntrySet.class */
    public interface FastEntrySet<K> extends ObjectSet<Entry<K>> {
        ObjectIterator<Entry<K>> fastIterator();

        default void fastForEach(Consumer<? super Entry<K>> consumer) {
            forEach(consumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    default void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    default ObjectSet<Map.Entry<K, Integer>> entrySet() {
        return reference2IntEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction
    @Deprecated
    default Integer put(K key, Integer value) {
        return put((Reference2IntMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        return remove(key);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        return containsValue(((Integer) value).intValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super K, ? super Integer> consumer) {
        ObjectSet<Entry<K>> entrySet = reference2IntEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Integer.valueOf(entry.getIntValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction
    default int getOrDefault(Object key, int defaultValue) {
        int v = getInt(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2IntFunction
    @Deprecated
    default Integer getOrDefault(Object key, Integer defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default int putIfAbsent(K key, int value) {
        int v = getInt(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Reference2IntMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, int value) {
        int curValue = getInt(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeInt(key);
        return true;
    }

    default boolean replace(K key, int oldValue, int newValue) {
        int curValue = getInt(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Reference2IntMap<K>) key, newValue);
        return true;
    }

    default int replace(K key, int value) {
        return containsKey(key) ? put((Reference2IntMap<K>) key, value) : defaultReturnValue();
    }

    default int computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = getInt(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        int newValue = mappingFunction.applyAsInt(key);
        put((Reference2IntMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default int computeIntIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2IntMap<K>) key, (ToIntFunction<? super Reference2IntMap<K>>) mappingFunction);
    }

    default int computeIfAbsent(K key, Reference2IntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = getInt(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        int newValue = mappingFunction.getInt(key);
        put((Reference2IntMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default int computeIntIfAbsentPartial(K key, Reference2IntFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2IntMap<K>) key, (Reference2IntFunction<? super Reference2IntMap<K>>) mappingFunction);
    }

    default int computeIntIfPresent(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = getInt(key);
        int drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Integer newValue = (Integer) remappingFunction.apply(key, Integer.valueOf(oldValue));
        if (newValue == null) {
            removeInt(key);
            return drv;
        }
        int newVal = newValue.intValue();
        put((Reference2IntMap<K>) key, newVal);
        return newVal;
    }

    default int computeInt(K key, BiFunction<? super K, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = getInt(key);
        int drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Integer newValue = (Integer) remappingFunction.apply(key, contained ? Integer.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeInt(key);
            }
            return drv;
        }
        int newVal = newValue.intValue();
        put((Reference2IntMap<K>) key, newVal);
        return newVal;
    }

    default int merge(K key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        int newValue;
        Objects.requireNonNull(remappingFunction);
        int oldValue = getInt(key);
        int drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Integer mergedValue = (Integer) remappingFunction.apply(Integer.valueOf(oldValue), Integer.valueOf(value));
            if (mergedValue == null) {
                removeInt(key);
                return drv;
            }
            newValue = mergedValue.intValue();
        } else {
            newValue = value;
        }
        put((Reference2IntMap<K>) key, newValue);
        return newValue;
    }

    default int mergeInt(K key, int value, IntBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = getInt(key);
        int newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.applyAsInt(oldValue, value) : value;
        put((Reference2IntMap<K>) key, newValue);
        return newValue;
    }

    default int mergeInt(K key, int value, p014it.unimi.dsi.fastutil.ints.IntBinaryOperator remappingFunction) {
        return mergeInt((Reference2IntMap<K>) key, value, (IntBinaryOperator) remappingFunction);
    }

    @Deprecated
    default int mergeInt(K key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        return merge((Reference2IntMap<K>) key, value, remappingFunction);
    }

    @Deprecated
    default Integer putIfAbsent(K key, Integer value) {
        return putIfAbsent((Reference2IntMap<K>) key, (K) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(K key, Integer oldValue, Integer newValue) {
        return replace((Reference2IntMap<K>) key, oldValue, newValue);
    }

    @Deprecated
    default Integer replace(K key, Integer value) {
        return replace((Reference2IntMap<K>) key, (K) value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.function.BiFunction<? super java.lang.Integer, ? super java.lang.Integer, ? extends java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    default Integer merge(K key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        return merge((Reference2IntMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2IntMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2IntMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Integer> {
        int getIntValue();

        int setValue(int i);

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getValue() {
            return Integer.valueOf(getIntValue());
        }

        @Deprecated
        default Integer setValue(Integer value) {
            return Integer.valueOf(setValue(value.intValue()));
        }
    }
}
