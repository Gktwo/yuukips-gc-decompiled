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
import p014it.unimi.dsi.fastutil.bytes.ByteBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMap.class */
public interface Float2ByteMap extends Float2ByteFunction, Map<Float, Byte> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
    void defaultReturnValue(byte b);

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
    byte defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteSortedMap
    ObjectSet<Entry> float2ByteEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // java.util.Map
    Set<Float> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // java.util.Map
    Collection<Byte> values();

    boolean containsKey(float f);

    boolean containsValue(byte b);

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Byte>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Float, Byte>> entrySet() {
        return float2ByteEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
    @Deprecated
    default Byte put(Float key, Byte value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Byte) value).byteValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Float, ? super Byte> consumer) {
        ObjectSet<Entry> entrySet = float2ByteEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Float.valueOf(entry.getFloatKey()), Byte.valueOf(entry.getByteValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
    default byte getOrDefault(float key, byte defaultValue) {
        byte v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
    @Deprecated
    default Byte getOrDefault(Object key, Byte defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default byte putIfAbsent(float key, byte value) {
        byte v = get(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(float key, byte value) {
        byte curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(float key, byte oldValue, byte newValue) {
        byte curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default byte replace(float key, byte value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default byte computeIfAbsent(float key, DoubleToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt((double) key));
        put(key, newValue);
        return newValue;
    }

    default byte computeIfAbsentNullable(float key, DoubleFunction<? extends Byte> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = get(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Byte mappedValue = (Byte) mappingFunction.apply((double) key);
        if (mappedValue == null) {
            return drv;
        }
        byte newValue = mappedValue.byteValue();
        put(key, newValue);
        return newValue;
    }

    default byte computeIfAbsent(float key, Float2ByteFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = get(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        byte newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default byte computeIfAbsentPartial(float key, Float2ByteFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default byte computeIfPresent(float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Byte newValue = (Byte) remappingFunction.apply(Float.valueOf(key), Byte.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        byte newVal = newValue.byteValue();
        put(key, newVal);
        return newVal;
    }

    default byte compute(float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Byte newValue = (Byte) remappingFunction.apply(Float.valueOf(key), contained ? Byte.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        byte newVal = newValue.byteValue();
        put(key, newVal);
        return newVal;
    }

    default byte merge(float key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        byte newValue;
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Byte mergedValue = (Byte) remappingFunction.apply(Byte.valueOf(oldValue), Byte.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.byteValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default byte mergeByte(float key, byte value, ByteBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default byte mergeByte(float key, byte value, IntBinaryOperator remappingFunction) {
        return mergeByte(key, value, remappingFunction instanceof ByteBinaryOperator ? (ByteBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToByte(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Byte putIfAbsent(Float key, Byte value) {
        return putIfAbsent((Float2ByteMap) key, (Float) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Float key, Byte oldValue, Byte newValue) {
        return replace((Float2ByteMap) key, oldValue, newValue);
    }

    @Deprecated
    default Byte replace(Float key, Byte value) {
        return replace((Float2ByteMap) key, (Float) value);
    }

    @Deprecated
    default Byte computeIfAbsent(Float key, Function<? super Float, ? extends Byte> mappingFunction) {
        return computeIfAbsent((Float2ByteMap) key, (Function<? super Float2ByteMap, ? extends Byte>) mappingFunction);
    }

    @Deprecated
    default Byte computeIfPresent(Float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
        return computeIfPresent((Float2ByteMap) key, (BiFunction<? super Float2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte compute(Float key, BiFunction<? super Float, ? super Byte, ? extends Byte> remappingFunction) {
        return compute((Float2ByteMap) key, (BiFunction<? super Float2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte merge(Float key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        return merge((Float2ByteMap) key, (Float) value, (BiFunction<? super Float, ? super Float, ? extends Float>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteMap$Entry.class */
    public interface Entry extends Map.Entry<Float, Byte> {
        float getFloatKey();

        byte getByteValue();

        byte setValue(byte b);

        @Override // java.util.Map.Entry
        @Deprecated
        default Float getKey() {
            return Float.valueOf(getFloatKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Byte getValue() {
            return Byte.valueOf(getByteValue());
        }

        @Deprecated
        default Byte setValue(Byte value) {
            return Byte.valueOf(setValue(value.byteValue()));
        }
    }
}
