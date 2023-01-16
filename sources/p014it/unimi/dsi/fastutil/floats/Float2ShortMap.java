package p014it.unimi.dsi.fastutil.floats;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;
import p014it.unimi.dsi.fastutil.shorts.ShortBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortMap.class */
public interface Float2ShortMap extends Float2ShortFunction, Map<Float, Short> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    void defaultReturnValue(short s);

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    short defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortSortedMap
    ObjectSet<Entry> float2ShortEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // java.util.Map
    Set<Float> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // java.util.Map
    Collection<Short> values();

    boolean containsKey(float f);

    boolean containsValue(short s);

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Short>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Float, Short>> entrySet() {
        return float2ShortEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    @Deprecated
    default Short put(Float key, Short value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Float, ? super Short> consumer) {
        ObjectSet<Entry> entrySet = float2ShortEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Float.valueOf(entry.getFloatKey()), Short.valueOf(entry.getShortValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    default short getOrDefault(float key, short defaultValue) {
        short v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default short putIfAbsent(float key, short value) {
        short v = get(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(float key, short value) {
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

    default boolean replace(float key, short oldValue, short newValue) {
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

    default short replace(float key, short value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default short computeIfAbsent(float key, DoubleToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt((double) key));
        put(key, newValue);
        return newValue;
    }

    default short computeIfAbsentNullable(float key, DoubleFunction<? extends Short> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = get(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Short mappedValue = (Short) mappingFunction.apply((double) key);
        if (mappedValue == null) {
            return drv;
        }
        short newValue = mappedValue.shortValue();
        put(key, newValue);
        return newValue;
    }

    default short computeIfAbsent(float key, Float2ShortFunction mappingFunction) {
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
    default short computeIfAbsentPartial(float key, Float2ShortFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default short computeIfPresent(float key, BiFunction<? super Float, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Short newValue = (Short) remappingFunction.apply(Float.valueOf(key), Short.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        short newVal = newValue.shortValue();
        put(key, newVal);
        return newVal;
    }

    default short compute(float key, BiFunction<? super Float, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Short newValue = (Short) remappingFunction.apply(Float.valueOf(key), contained ? Short.valueOf(oldValue) : null);
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

    default short merge(float key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
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

    default short mergeShort(float key, short value, ShortBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default short mergeShort(float key, short value, IntBinaryOperator remappingFunction) {
        return mergeShort(key, value, remappingFunction instanceof ShortBinaryOperator ? (ShortBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToShort(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Short putIfAbsent(Float key, Short value) {
        return putIfAbsent((Float2ShortMap) key, (Float) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Float key, Short oldValue, Short newValue) {
        return replace((Float2ShortMap) key, oldValue, newValue);
    }

    @Deprecated
    default Short replace(Float key, Short value) {
        return replace((Float2ShortMap) key, (Float) value);
    }

    @Deprecated
    default Short computeIfAbsent(Float key, Function<? super Float, ? extends Short> mappingFunction) {
        return computeIfAbsent((Float2ShortMap) key, (Function<? super Float2ShortMap, ? extends Short>) mappingFunction);
    }

    @Deprecated
    default Short computeIfPresent(Float key, BiFunction<? super Float, ? super Short, ? extends Short> remappingFunction) {
        return computeIfPresent((Float2ShortMap) key, (BiFunction<? super Float2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short compute(Float key, BiFunction<? super Float, ? super Short, ? extends Short> remappingFunction) {
        return compute((Float2ShortMap) key, (BiFunction<? super Float2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short merge(Float key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return merge((Float2ShortMap) key, (Float) value, (BiFunction<? super Float, ? super Float, ? extends Float>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ShortMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ShortMap$Entry.class */
    public interface Entry extends Map.Entry<Float, Short> {
        float getFloatKey();

        short getShortValue();

        short setValue(short s);

        @Override // java.util.Map.Entry
        @Deprecated
        default Float getKey() {
            return Float.valueOf(getFloatKey());
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
