package p014it.unimi.dsi.fastutil.shorts;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.floats.FloatBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatMap.class */
public interface Short2FloatMap extends Short2FloatFunction, Map<Short, Float> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction
    void defaultReturnValue(float f);

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction
    float defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatSortedMap
    ObjectSet<Entry> short2FloatEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // java.util.Map
    Set<Short> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // java.util.Map
    Collection<Float> values();

    boolean containsKey(short s);

    boolean containsValue(float f);

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Short, java.lang.Float>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Short, Float>> entrySet() {
        return short2FloatEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction
    @Deprecated
    default Float put(Short key, Float value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Float) value).floatValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Short, ? super Float> consumer) {
        ObjectSet<Entry> entrySet = short2FloatEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Short.valueOf(entry.getShortKey()), Float.valueOf(entry.getFloatValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction
    default float getOrDefault(short key, float defaultValue) {
        float v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction
    @Deprecated
    default Float getOrDefault(Object key, Float defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default float putIfAbsent(short key, float value) {
        float v = get(key);
        float drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(short key, float value) {
        float curValue = get(key);
        if (Float.floatToIntBits(curValue) != Float.floatToIntBits(value)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(short key, float oldValue, float newValue) {
        float curValue = get(key);
        if (Float.floatToIntBits(curValue) != Float.floatToIntBits(oldValue)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default float replace(short key, float value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default float computeIfAbsent(short key, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        float v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        float newValue = SafeMath.safeDoubleToFloat(mappingFunction.applyAsDouble(key));
        put(key, newValue);
        return newValue;
    }

    default float computeIfAbsentNullable(short key, IntFunction<? extends Float> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        float v = get(key);
        float drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Float mappedValue = (Float) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        float newValue = mappedValue.floatValue();
        put(key, newValue);
        return newValue;
    }

    default float computeIfAbsent(short key, Short2FloatFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        float v = get(key);
        float drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        float newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default float computeIfAbsentPartial(short key, Short2FloatFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default float computeIfPresent(short key, BiFunction<? super Short, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Float newValue = (Float) remappingFunction.apply(Short.valueOf(key), Float.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        float newVal = newValue.floatValue();
        put(key, newVal);
        return newVal;
    }

    default float compute(short key, BiFunction<? super Short, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Float newValue = (Float) remappingFunction.apply(Short.valueOf(key), contained ? Float.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        float newVal = newValue.floatValue();
        put(key, newVal);
        return newVal;
    }

    default float merge(short key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
        float newValue;
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Float mergedValue = (Float) remappingFunction.apply(Float.valueOf(oldValue), Float.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.floatValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default float mergeFloat(short key, float value, FloatBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default float mergeFloat(short key, float value, DoubleBinaryOperator remappingFunction) {
        return mergeFloat(key, value, remappingFunction instanceof FloatBinaryOperator ? (FloatBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeDoubleToFloat(remappingFunction.applyAsDouble((double) x, (double) y));
        });
    }

    @Deprecated
    default Float putIfAbsent(Short key, Float value) {
        return putIfAbsent((Short2FloatMap) key, (Short) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Short key, Float oldValue, Float newValue) {
        return replace((Short2FloatMap) key, oldValue, newValue);
    }

    @Deprecated
    default Float replace(Short key, Float value) {
        return replace((Short2FloatMap) key, (Short) value);
    }

    @Deprecated
    default Float computeIfAbsent(Short key, Function<? super Short, ? extends Float> mappingFunction) {
        return computeIfAbsent((Short2FloatMap) key, (Function<? super Short2FloatMap, ? extends Float>) mappingFunction);
    }

    @Deprecated
    default Float computeIfPresent(Short key, BiFunction<? super Short, ? super Float, ? extends Float> remappingFunction) {
        return computeIfPresent((Short2FloatMap) key, (BiFunction<? super Short2FloatMap, ? super Float, ? extends Float>) remappingFunction);
    }

    @Deprecated
    default Float compute(Short key, BiFunction<? super Short, ? super Float, ? extends Float> remappingFunction) {
        return compute((Short2FloatMap) key, (BiFunction<? super Short2FloatMap, ? super Float, ? extends Float>) remappingFunction);
    }

    @Deprecated
    default Float merge(Short key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
        return merge((Short2FloatMap) key, (Short) value, (BiFunction<? super Short, ? super Short, ? extends Short>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatMap$Entry.class */
    public interface Entry extends Map.Entry<Short, Float> {
        short getShortKey();

        float getFloatValue();

        float setValue(float f);

        @Override // java.util.Map.Entry
        @Deprecated
        default Short getKey() {
            return Short.valueOf(getShortKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Float getValue() {
            return Float.valueOf(getFloatValue());
        }

        @Deprecated
        default Float setValue(Float value) {
            return Float.valueOf(setValue(value.floatValue()));
        }
    }
}
