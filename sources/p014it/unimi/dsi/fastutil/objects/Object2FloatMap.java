package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.ToDoubleFunction;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.floats.FloatBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatMap.class */
public interface Object2FloatMap<K> extends Object2FloatFunction<K>, Map<K, Float> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
    void defaultReturnValue(float f);

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
    float defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatSortedMap
    ObjectSet<Entry<K>> object2FloatEntrySet();

    @Override // java.util.Map
    ObjectSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // java.util.Map
    Collection<Float> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(float f);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Float put(Object obj, Float f) {
        return put((Object2FloatMap<K>) obj, f);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Float merge(Object obj, Float f, BiFunction<? super Float, ? super Float, ? extends Float> biFunction) {
        return merge((Object2FloatMap<K>) obj, f, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Float replace(Object obj, Float f) {
        return replace((Object2FloatMap<K>) obj, f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default boolean replace(Object obj, Float f, Float f2) {
        return replace((Object2FloatMap<K>) obj, f, f2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Float putIfAbsent(Object obj, Float f) {
        return putIfAbsent((Object2FloatMap<K>) obj, f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatMap$FastEntrySet.class */
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
    default ObjectSet<Map.Entry<K, Float>> entrySet() {
        return object2FloatEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
    @Deprecated
    default Float put(K key, Float value) {
        return put((Object2FloatMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        return remove(key);
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
    default void forEach(BiConsumer<? super K, ? super Float> consumer) {
        ObjectSet<Entry<K>> entrySet = object2FloatEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Float.valueOf(entry.getFloatValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
    default float getOrDefault(Object key, float defaultValue) {
        float v = getFloat(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
    @Deprecated
    default Float getOrDefault(Object key, Float defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default float putIfAbsent(K key, float value) {
        float v = getFloat(key);
        float drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Object2FloatMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, float value) {
        float curValue = getFloat(key);
        if (Float.floatToIntBits(curValue) != Float.floatToIntBits(value)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeFloat(key);
        return true;
    }

    default boolean replace(K key, float oldValue, float newValue) {
        float curValue = getFloat(key);
        if (Float.floatToIntBits(curValue) != Float.floatToIntBits(oldValue)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Object2FloatMap<K>) key, newValue);
        return true;
    }

    default float replace(K key, float value) {
        return containsKey(key) ? put((Object2FloatMap<K>) key, value) : defaultReturnValue();
    }

    default float computeIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        float v = getFloat(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        float newValue = SafeMath.safeDoubleToFloat(mappingFunction.applyAsDouble(key));
        put((Object2FloatMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default float computeFloatIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
        return computeIfAbsent((Object2FloatMap<K>) key, (ToDoubleFunction<? super Object2FloatMap<K>>) mappingFunction);
    }

    default float computeIfAbsent(K key, Object2FloatFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        float v = getFloat(key);
        float drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        float newValue = mappingFunction.getFloat(key);
        put((Object2FloatMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default float computeFloatIfAbsentPartial(K key, Object2FloatFunction<? super K> mappingFunction) {
        return computeIfAbsent((Object2FloatMap<K>) key, (Object2FloatFunction<? super Object2FloatMap<K>>) mappingFunction);
    }

    default float computeFloatIfPresent(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = getFloat(key);
        float drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Float newValue = (Float) remappingFunction.apply(key, Float.valueOf(oldValue));
        if (newValue == null) {
            removeFloat(key);
            return drv;
        }
        float newVal = newValue.floatValue();
        put((Object2FloatMap<K>) key, newVal);
        return newVal;
    }

    default float computeFloat(K key, BiFunction<? super K, ? super Float, ? extends Float> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = getFloat(key);
        float drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Float newValue = (Float) remappingFunction.apply(key, contained ? Float.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeFloat(key);
            }
            return drv;
        }
        float newVal = newValue.floatValue();
        put((Object2FloatMap<K>) key, newVal);
        return newVal;
    }

    default float merge(K key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
        float newValue;
        Objects.requireNonNull(remappingFunction);
        float oldValue = getFloat(key);
        float drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Float mergedValue = (Float) remappingFunction.apply(Float.valueOf(oldValue), Float.valueOf(value));
            if (mergedValue == null) {
                removeFloat(key);
                return drv;
            }
            newValue = mergedValue.floatValue();
        } else {
            newValue = value;
        }
        put((Object2FloatMap<K>) key, newValue);
        return newValue;
    }

    default float mergeFloat(K key, float value, FloatBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        float oldValue = getFloat(key);
        float newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put((Object2FloatMap<K>) key, newValue);
        return newValue;
    }

    default float mergeFloat(K key, float value, DoubleBinaryOperator remappingFunction) {
        return mergeFloat((Object2FloatMap<K>) key, value, remappingFunction instanceof FloatBinaryOperator ? (FloatBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeDoubleToFloat(remappingFunction.applyAsDouble((double) x, (double) y));
        });
    }

    @Deprecated
    default float mergeFloat(K key, float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
        return merge((Object2FloatMap<K>) key, value, remappingFunction);
    }

    @Deprecated
    default Float putIfAbsent(K key, Float value) {
        return putIfAbsent((Object2FloatMap<K>) key, (K) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(K key, Float oldValue, Float newValue) {
        return replace((Object2FloatMap<K>) key, oldValue, newValue);
    }

    @Deprecated
    default Float replace(K key, Float value) {
        return replace((Object2FloatMap<K>) key, (K) value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.function.BiFunction<? super java.lang.Float, ? super java.lang.Float, ? extends java.lang.Float> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    default Float merge(K key, Float value, BiFunction<? super Float, ? super Float, ? extends Float> remappingFunction) {
        return merge((Object2FloatMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Float> {
        float getFloatValue();

        float setValue(float f);

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
