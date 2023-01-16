package p014it.unimi.dsi.fastutil.longs;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2IntMap.class */
public interface Long2IntMap extends Long2IntFunction, Map<Long, Integer> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction
    void defaultReturnValue(int i);

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction
    int defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntSortedMap
    ObjectSet<Entry> long2IntEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // java.util.Map
    Set<Long> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // java.util.Map
    Collection<Integer> values();

    boolean containsKey(long j);

    boolean containsValue(int i);

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2IntMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2IntMap$FastEntrySet.class */
    public interface FastEntrySet extends ObjectSet<Entry> {
        ObjectIterator<Entry> fastIterator();

        default void fastForEach(Consumer<? super Entry> consumer) {
            forEach(consumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    default void clear() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Integer>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Long, Integer>> entrySet() {
        return long2IntEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction
    @Deprecated
    default Integer put(Long key, Integer value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        return containsKey(key);
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
    default void forEach(BiConsumer<? super Long, ? super Integer> consumer) {
        ObjectSet<Entry> entrySet = long2IntEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Long.valueOf(entry.getLongKey()), Integer.valueOf(entry.getIntValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction
    default int getOrDefault(long key, int defaultValue) {
        int v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction
    @Deprecated
    default Integer getOrDefault(Object key, Integer defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default int putIfAbsent(long key, int value) {
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(long key, int value) {
        int curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(long key, int oldValue, int newValue) {
        int curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default int replace(long key, int value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default int computeIfAbsent(long key, LongToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        int newValue = mappingFunction.applyAsInt(key);
        put(key, newValue);
        return newValue;
    }

    default int computeIfAbsentNullable(long key, LongFunction<? extends Integer> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Integer mappedValue = (Integer) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        int newValue = mappedValue.intValue();
        put(key, newValue);
        return newValue;
    }

    default int computeIfAbsent(long key, Long2IntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        int newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default int computeIfAbsentPartial(long key, Long2IntFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default int computeIfPresent(long key, BiFunction<? super Long, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Integer newValue = (Integer) remappingFunction.apply(Long.valueOf(key), Integer.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        int newVal = newValue.intValue();
        put(key, newVal);
        return newVal;
    }

    default int compute(long key, BiFunction<? super Long, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Integer newValue = (Integer) remappingFunction.apply(Long.valueOf(key), contained ? Integer.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        int newVal = newValue.intValue();
        put(key, newVal);
        return newVal;
    }

    default int merge(long key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        int newValue;
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Integer mergedValue = (Integer) remappingFunction.apply(Integer.valueOf(oldValue), Integer.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.intValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default int mergeInt(long key, int value, IntBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.applyAsInt(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default int mergeInt(long key, int value, p014it.unimi.dsi.fastutil.ints.IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (IntBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Integer putIfAbsent(Long key, Integer value) {
        return putIfAbsent((Long2IntMap) key, (Long) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Long key, Integer oldValue, Integer newValue) {
        return replace((Long2IntMap) key, oldValue, newValue);
    }

    @Deprecated
    default Integer replace(Long key, Integer value) {
        return replace((Long2IntMap) key, (Long) value);
    }

    @Deprecated
    default Integer computeIfAbsent(Long key, Function<? super Long, ? extends Integer> mappingFunction) {
        return computeIfAbsent((Long2IntMap) key, (Function<? super Long2IntMap, ? extends Integer>) mappingFunction);
    }

    @Deprecated
    default Integer computeIfPresent(Long key, BiFunction<? super Long, ? super Integer, ? extends Integer> remappingFunction) {
        return computeIfPresent((Long2IntMap) key, (BiFunction<? super Long2IntMap, ? super Integer, ? extends Integer>) remappingFunction);
    }

    @Deprecated
    default Integer compute(Long key, BiFunction<? super Long, ? super Integer, ? extends Integer> remappingFunction) {
        return compute((Long2IntMap) key, (BiFunction<? super Long2IntMap, ? super Integer, ? extends Integer>) remappingFunction);
    }

    @Deprecated
    default Integer merge(Long key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        return merge((Long2IntMap) key, (Long) value, (BiFunction<? super Long, ? super Long, ? extends Long>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2IntMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2IntMap$Entry.class */
    public interface Entry extends Map.Entry<Long, Integer> {
        long getLongKey();

        int getIntValue();

        int setValue(int i);

        @Override // java.util.Map.Entry
        @Deprecated
        default Long getKey() {
            return Long.valueOf(getLongKey());
        }

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
