package p014it.unimi.dsi.fastutil.doubles;

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

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteMap.class */
public interface Double2ByteMap extends Double2ByteFunction, Map<Double, Byte> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    void defaultReturnValue(byte b);

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    byte defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteSortedMap
    ObjectSet<Entry> double2ByteEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // java.util.Map
    Set<Double> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // java.util.Map
    Collection<Byte> values();

    boolean containsKey(double d);

    boolean containsValue(byte b);

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Double, java.lang.Byte>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Double, Byte>> entrySet() {
        return double2ByteEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    @Deprecated
    default Byte put(Double key, Byte value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Double, ? super Byte> consumer) {
        ObjectSet<Entry> entrySet = double2ByteEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Double.valueOf(entry.getDoubleKey()), Byte.valueOf(entry.getByteValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    default byte getOrDefault(double key, byte defaultValue) {
        byte v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction
    @Deprecated
    default Byte getOrDefault(Object key, Byte defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default byte putIfAbsent(double key, byte value) {
        byte v = get(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(double key, byte value) {
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

    default boolean replace(double key, byte oldValue, byte newValue) {
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

    default byte replace(double key, byte value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default byte computeIfAbsent(double key, DoubleToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default byte computeIfAbsentNullable(double key, DoubleFunction<? extends Byte> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = get(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Byte mappedValue = (Byte) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        byte newValue = mappedValue.byteValue();
        put(key, newValue);
        return newValue;
    }

    default byte computeIfAbsent(double key, Double2ByteFunction mappingFunction) {
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
    default byte computeIfAbsentPartial(double key, Double2ByteFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default byte computeIfPresent(double key, BiFunction<? super Double, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Byte newValue = (Byte) remappingFunction.apply(Double.valueOf(key), Byte.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        byte newVal = newValue.byteValue();
        put(key, newVal);
        return newVal;
    }

    default byte compute(double key, BiFunction<? super Double, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Byte newValue = (Byte) remappingFunction.apply(Double.valueOf(key), contained ? Byte.valueOf(oldValue) : null);
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

    default byte merge(double key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
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

    default byte mergeByte(double key, byte value, ByteBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default byte mergeByte(double key, byte value, IntBinaryOperator remappingFunction) {
        return mergeByte(key, value, remappingFunction instanceof ByteBinaryOperator ? (ByteBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToByte(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Byte putIfAbsent(Double key, Byte value) {
        return putIfAbsent((Double2ByteMap) key, (Double) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Double key, Byte oldValue, Byte newValue) {
        return replace((Double2ByteMap) key, oldValue, newValue);
    }

    @Deprecated
    default Byte replace(Double key, Byte value) {
        return replace((Double2ByteMap) key, (Double) value);
    }

    @Deprecated
    default Byte computeIfAbsent(Double key, Function<? super Double, ? extends Byte> mappingFunction) {
        return computeIfAbsent((Double2ByteMap) key, (Function<? super Double2ByteMap, ? extends Byte>) mappingFunction);
    }

    @Deprecated
    default Byte computeIfPresent(Double key, BiFunction<? super Double, ? super Byte, ? extends Byte> remappingFunction) {
        return computeIfPresent((Double2ByteMap) key, (BiFunction<? super Double2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte compute(Double key, BiFunction<? super Double, ? super Byte, ? extends Byte> remappingFunction) {
        return compute((Double2ByteMap) key, (BiFunction<? super Double2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte merge(Double key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        return merge((Double2ByteMap) key, (Double) value, (BiFunction<? super Double, ? super Double, ? extends Double>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteMap$Entry.class */
    public interface Entry extends Map.Entry<Double, Byte> {
        double getDoubleKey();

        byte getByteValue();

        byte setValue(byte b);

        @Override // java.util.Map.Entry
        @Deprecated
        default Double getKey() {
            return Double.valueOf(getDoubleKey());
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
