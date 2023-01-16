package p014it.unimi.dsi.fastutil.chars;

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

/* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMap.class */
public interface Char2FloatMap extends Char2FloatFunction, Map<Character, Float> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    void defaultReturnValue(float f);

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    float defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatSortedMap
    ObjectSet<Entry> char2FloatEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // java.util.Map
    Set<Character> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // java.util.Map
    Collection<Float> values();

    boolean containsKey(char c);

    boolean containsValue(float f);

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Float>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Character, Float>> entrySet() {
        return char2FloatEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    @Deprecated
    default Float put(Character key, Float value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Character, ? super Float> consumer) {
        ObjectSet<Entry> entrySet = char2FloatEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Character.valueOf(entry.getCharKey()), Float.valueOf(entry.getFloatValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    default float getOrDefault(char key, float defaultValue) {
        float v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    @Deprecated
    default Float getOrDefault(Object key, Float defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default float putIfAbsent(char key, float value) {
        float v = get(key);
        float drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(char key, float value) {
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

    default boolean replace(char key, float oldValue, float newValue) {
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

    default float replace(char key, float value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default float computeIfAbsent(char key, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        float v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        float newValue = SafeMath.safeDoubleToFloat(mappingFunction.applyAsDouble(key));
        put(key, newValue);
        return newValue;
    }

    default float computeIfAbsentNullable(char key, IntFunction<? extends Float> mappingFunction) {
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

    default float computeIfAbsent(char key, Char2FloatFunction mappingFunction) {
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
    default float computeIfAbsentPartial(char key, Char2FloatFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default float computeIfPresent(char key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Float newValue = (Float) remappingFunction.apply(Character.valueOf(key), Float.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        float newVal = newValue.floatValue();
        put(key, newVal);
        return newVal;
    }

    default float compute(char key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Float newValue = (Float) remappingFunction.apply(Character.valueOf(key), contained ? Float.valueOf(oldValue) : null);
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

    default float merge(char key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
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

    default float mergeFloat(char key, float value, FloatBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = get(key);
        float newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default float mergeFloat(char key, float value, DoubleBinaryOperator remappingFunction) {
        return mergeFloat(key, value, remappingFunction instanceof FloatBinaryOperator ? (FloatBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeDoubleToFloat(remappingFunction.applyAsDouble((double) x, (double) y));
        });
    }

    @Deprecated
    default Float putIfAbsent(Character key, Float value) {
        return putIfAbsent((Char2FloatMap) key, (Character) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Character key, Float oldValue, Float newValue) {
        return replace((Char2FloatMap) key, oldValue, newValue);
    }

    @Deprecated
    default Float replace(Character key, Float value) {
        return replace((Char2FloatMap) key, (Character) value);
    }

    @Deprecated
    default Float computeIfAbsent(Character key, Function<? super Character, ? extends Float> mappingFunction) {
        return computeIfAbsent((Char2FloatMap) key, (Function<? super Char2FloatMap, ? extends Float>) mappingFunction);
    }

    @Deprecated
    default Float computeIfPresent(Character key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
        return computeIfPresent((Char2FloatMap) key, (BiFunction<? super Char2FloatMap, ? super Float, ? extends Float>) remappingFunction);
    }

    @Deprecated
    default Float compute(Character key, BiFunction<? super Character, ? super Float, ? extends Float> remappingFunction) {
        return compute((Char2FloatMap) key, (BiFunction<? super Char2FloatMap, ? super Float, ? extends Float>) remappingFunction);
    }

    @Deprecated
    default Float merge(Character key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
        return merge((Char2FloatMap) key, (Character) value, (BiFunction<? super Character, ? super Character, ? extends Character>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatMap$Entry.class */
    public interface Entry extends Map.Entry<Character, Float> {
        char getCharKey();

        float getFloatValue();

        float setValue(float f);

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getKey() {
            return Character.valueOf(getCharKey());
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
