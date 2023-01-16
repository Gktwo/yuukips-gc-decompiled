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
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.shorts.ShortBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMap.class */
public interface Long2ShortMap extends Long2ShortFunction, Map<Long, Short> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
    void defaultReturnValue(short s);

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
    short defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortSortedMap
    ObjectSet<Entry> long2ShortEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // java.util.Map
    Set<Long> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // java.util.Map
    Collection<Short> values();

    boolean containsKey(long j);

    boolean containsValue(short s);

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Short>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Long, Short>> entrySet() {
        return long2ShortEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
    @Deprecated
    default Short put(Long key, Short value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Short) value).shortValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Long, ? super Short> consumer) {
        ObjectSet<Entry> entrySet = long2ShortEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Long.valueOf(entry.getLongKey()), Short.valueOf(entry.getShortValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
    default short getOrDefault(long key, short defaultValue) {
        short v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction
    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default short putIfAbsent(long key, short value) {
        short v = get(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(long key, short value) {
        short curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(long key, short oldValue, short newValue) {
        short curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default short replace(long key, short value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default short computeIfAbsent(long key, LongToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default short computeIfAbsentNullable(long key, LongFunction<? extends Short> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = get(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Short mappedValue = (Short) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        short newValue = mappedValue.shortValue();
        put(key, newValue);
        return newValue;
    }

    default short computeIfAbsent(long key, Long2ShortFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = get(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        short newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default short computeIfAbsentPartial(long key, Long2ShortFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default short computeIfPresent(long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Short newValue = (Short) remappingFunction.apply(Long.valueOf(key), Short.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        short newVal = newValue.shortValue();
        put(key, newVal);
        return newVal;
    }

    default short compute(long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Short newValue = (Short) remappingFunction.apply(Long.valueOf(key), contained ? Short.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        short newVal = newValue.shortValue();
        put(key, newVal);
        return newVal;
    }

    default short merge(long key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        short newValue;
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Short mergedValue = (Short) remappingFunction.apply(Short.valueOf(oldValue), Short.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.shortValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default short mergeShort(long key, short value, ShortBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default short mergeShort(long key, short value, IntBinaryOperator remappingFunction) {
        return mergeShort(key, value, remappingFunction instanceof ShortBinaryOperator ? (ShortBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToShort(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Short putIfAbsent(Long key, Short value) {
        return putIfAbsent((Long2ShortMap) key, (Long) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Long key, Short oldValue, Short newValue) {
        return replace((Long2ShortMap) key, oldValue, newValue);
    }

    @Deprecated
    default Short replace(Long key, Short value) {
        return replace((Long2ShortMap) key, (Long) value);
    }

    @Deprecated
    default Short computeIfAbsent(Long key, Function<? super Long, ? extends Short> mappingFunction) {
        return computeIfAbsent((Long2ShortMap) key, (Function<? super Long2ShortMap, ? extends Short>) mappingFunction);
    }

    @Deprecated
    default Short computeIfPresent(Long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
        return computeIfPresent((Long2ShortMap) key, (BiFunction<? super Long2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short compute(Long key, BiFunction<? super Long, ? super Short, ? extends Short> remappingFunction) {
        return compute((Long2ShortMap) key, (BiFunction<? super Long2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short merge(Long key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return merge((Long2ShortMap) key, (Long) value, (BiFunction<? super Long, ? super Long, ? extends Long>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ShortMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ShortMap$Entry.class */
    public interface Entry extends Map.Entry<Long, Short> {
        long getLongKey();

        short getShortValue();

        short setValue(short s);

        @Override // java.util.Map.Entry
        @Deprecated
        default Long getKey() {
            return Long.valueOf(getLongKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Short getValue() {
            return Short.valueOf(getShortValue());
        }

        @Deprecated
        default Short setValue(Short value) {
            return Short.valueOf(setValue(value.shortValue()));
        }
    }
}
