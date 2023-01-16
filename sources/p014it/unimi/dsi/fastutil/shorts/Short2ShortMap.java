package p014it.unimi.dsi.fastutil.shorts;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortMap.class */
public interface Short2ShortMap extends Short2ShortFunction, Map<Short, Short> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    void defaultReturnValue(short s);

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    short defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortSortedMap
    ObjectSet<Entry> short2ShortEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // java.util.Map
    Set<Short> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // java.util.Map
    Collection<Short> values();

    boolean containsKey(short s);

    boolean containsValue(short s);

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Short>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Short, Short>> entrySet() {
        return short2ShortEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    @Deprecated
    default Short put(Short key, Short value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Short, ? super Short> consumer) {
        ObjectSet<Entry> entrySet = short2ShortEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Short.valueOf(entry.getShortKey()), Short.valueOf(entry.getShortValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    default short getOrDefault(short key, short defaultValue) {
        short v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default short putIfAbsent(short key, short value) {
        short v = get(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(short key, short value) {
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

    default boolean replace(short key, short oldValue, short newValue) {
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

    default short replace(short key, short value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default short computeIfAbsent(short key, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default short computeIfAbsentNullable(short key, IntFunction<? extends Short> mappingFunction) {
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

    default short computeIfAbsent(short key, Short2ShortFunction mappingFunction) {
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
    default short computeIfAbsentPartial(short key, Short2ShortFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default short computeIfPresent(short key, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Short newValue = (Short) remappingFunction.apply(Short.valueOf(key), Short.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        short newVal = newValue.shortValue();
        put(key, newVal);
        return newVal;
    }

    default short compute(short key, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Short newValue = (Short) remappingFunction.apply(Short.valueOf(key), contained ? Short.valueOf(oldValue) : null);
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

    default short merge(short key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
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

    default short mergeShort(short key, short value, ShortBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default short mergeShort(short key, short value, IntBinaryOperator remappingFunction) {
        return mergeShort(key, value, remappingFunction instanceof ShortBinaryOperator ? (ShortBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToShort(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Short putIfAbsent(Short key, Short value) {
        return putIfAbsent((Short2ShortMap) key, value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Short key, Short oldValue, Short newValue) {
        return replace((Short2ShortMap) key, oldValue, newValue);
    }

    @Deprecated
    default Short replace(Short key, Short value) {
        return replace((Short2ShortMap) key, value);
    }

    @Deprecated
    default Short computeIfAbsent(Short key, Function<? super Short, ? extends Short> mappingFunction) {
        return computeIfAbsent((Short2ShortMap) key, (Function<? super Short2ShortMap, ? extends Short>) mappingFunction);
    }

    @Deprecated
    default Short computeIfPresent(Short key, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return computeIfPresent((Short2ShortMap) key, (BiFunction<? super Short2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short compute(Short key, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return compute((Short2ShortMap) key, (BiFunction<? super Short2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short merge(Short key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return merge((Short2ShortMap) key, value, remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortMap$Entry.class */
    public interface Entry extends Map.Entry<Short, Short> {
        short getShortKey();

        short getShortValue();

        short setValue(short s);

        @Override // java.util.Map.Entry
        @Deprecated
        default Short getKey() {
            return Short.valueOf(getShortKey());
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
