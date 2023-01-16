package p014it.unimi.dsi.fastutil.bytes;

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

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatMap.class */
public interface Byte2FloatMap extends Byte2FloatFunction, Map<Byte, Float> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    void defaultReturnValue(float f);

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    float defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatSortedMap
    ObjectSet<Entry> byte2FloatEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // java.util.Map
    Set<Byte> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // java.util.Map
    Collection<Float> values();

    boolean containsKey(byte b);

    boolean containsValue(float f);

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Float>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Byte, Float>> entrySet() {
        return byte2FloatEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    @Deprecated
    default Float put(Byte key, Float value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Byte, ? super Float> consumer) {
        ObjectSet<Entry> entrySet = byte2FloatEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Byte.valueOf(entry.getByteKey()), Float.valueOf(entry.getFloatValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    default float getOrDefault(byte key, float defaultValue) {
        float v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
    @Deprecated
    default Float getOrDefault(Object key, Float defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default float putIfAbsent(byte key, float value) {
        float v = get(key);
        float drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(byte key, float value) {
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

    default boolean replace(byte key, float oldValue, float newValue) {
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

    default float replace(byte key, float value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default float computeIfAbsent(byte key, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        float v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        float newValue = SafeMath.safeDoubleToFloat(mappingFunction.applyAsDouble(key));
        put(key, newValue);
        return newValue;
    }

    default float computeIfAbsentNullable(byte key, IntFunction<? extends Float> mappingFunction) {
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

    default float computeIfAbsent(byte key, Byte2FloatFunction mappingFunction) {
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
    default float computeIfAbsentPartial(byte key, Byte2FloatFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default float computeIfPresent(byte key, BiFunction<? super Byte, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Float newValue = (Float) remappingFunction.apply(Byte.valueOf(key), Float.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        float newVal = newValue.floatValue();
        put(key, newVal);
        return newVal;
    }

    default float compute(byte key, BiFunction<? super Byte, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Float newValue = (Float) remappingFunction.apply(Byte.valueOf(key), contained ? Float.valueOf(oldValue) : null);
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

    default float merge(byte key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
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

    default float mergeFloat(byte key, float value, FloatBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default float mergeFloat(byte key, float value, DoubleBinaryOperator remappingFunction) {
        return mergeFloat(key, value, remappingFunction instanceof FloatBinaryOperator ? (FloatBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeDoubleToFloat(remappingFunction.applyAsDouble((double) x, (double) y));
        });
    }

    @Deprecated
    default Float putIfAbsent(Byte key, Float value) {
        return putIfAbsent((Byte2FloatMap) key, (Byte) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Byte key, Float oldValue, Float newValue) {
        return replace((Byte2FloatMap) key, oldValue, newValue);
    }

    @Deprecated
    default Float replace(Byte key, Float value) {
        return replace((Byte2FloatMap) key, (Byte) value);
    }

    @Deprecated
    default Float computeIfAbsent(Byte key, Function<? super Byte, ? extends Float> mappingFunction) {
        return computeIfAbsent((Byte2FloatMap) key, (Function<? super Byte2FloatMap, ? extends Float>) mappingFunction);
    }

    @Deprecated
    default Float computeIfPresent(Byte key, BiFunction<? super Byte, ? super Float, ? extends Float> remappingFunction) {
        return computeIfPresent((Byte2FloatMap) key, (BiFunction<? super Byte2FloatMap, ? super Float, ? extends Float>) remappingFunction);
    }

    @Deprecated
    default Float compute(Byte key, BiFunction<? super Byte, ? super Float, ? extends Float> remappingFunction) {
        return compute((Byte2FloatMap) key, (BiFunction<? super Byte2FloatMap, ? super Float, ? extends Float>) remappingFunction);
    }

    @Deprecated
    default Float merge(Byte key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
        return merge((Byte2FloatMap) key, (Byte) value, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatMap$Entry.class */
    public interface Entry extends Map.Entry<Byte, Float> {
        byte getByteKey();

        float getFloatValue();

        float setValue(float f);

        @Override // java.util.Map.Entry
        @Deprecated
        default Byte getKey() {
            return Byte.valueOf(getByteKey());
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
