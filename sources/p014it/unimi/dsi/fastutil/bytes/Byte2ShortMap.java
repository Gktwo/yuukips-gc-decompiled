package p014it.unimi.dsi.fastutil.bytes;

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
import p014it.unimi.dsi.fastutil.shorts.ShortBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMap.class */
public interface Byte2ShortMap extends Byte2ShortFunction, Map<Byte, Short> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    void defaultReturnValue(short s);

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    short defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
    ObjectSet<Entry> byte2ShortEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // java.util.Map
    Set<Byte> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // java.util.Map
    Collection<Short> values();

    boolean containsKey(byte b);

    boolean containsValue(short s);

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Short>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Byte, Short>> entrySet() {
        return byte2ShortEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    @Deprecated
    default Short put(Byte key, Short value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Byte, ? super Short> consumer) {
        ObjectSet<Entry> entrySet = byte2ShortEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Byte.valueOf(entry.getByteKey()), Short.valueOf(entry.getShortValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    default short getOrDefault(byte key, short defaultValue) {
        short v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default short putIfAbsent(byte key, short value) {
        short v = get(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(byte key, short value) {
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

    default boolean replace(byte key, short oldValue, short newValue) {
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

    default short replace(byte key, short value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default short computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default short computeIfAbsentNullable(byte key, IntFunction<? extends Short> mappingFunction) {
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

    default short computeIfAbsent(byte key, Byte2ShortFunction mappingFunction) {
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
    default short computeIfAbsentPartial(byte key, Byte2ShortFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default short computeIfPresent(byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Short newValue = (Short) remappingFunction.apply(Byte.valueOf(key), Short.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        short newVal = newValue.shortValue();
        put(key, newVal);
        return newVal;
    }

    default short compute(byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Short newValue = (Short) remappingFunction.apply(Byte.valueOf(key), contained ? Short.valueOf(oldValue) : null);
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

    default short merge(byte key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
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

    default short mergeShort(byte key, short value, ShortBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = get(key);
        short newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default short mergeShort(byte key, short value, IntBinaryOperator remappingFunction) {
        return mergeShort(key, value, remappingFunction instanceof ShortBinaryOperator ? (ShortBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToShort(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Short putIfAbsent(Byte key, Short value) {
        return putIfAbsent((Byte2ShortMap) key, (Byte) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Byte key, Short oldValue, Short newValue) {
        return replace((Byte2ShortMap) key, oldValue, newValue);
    }

    @Deprecated
    default Short replace(Byte key, Short value) {
        return replace((Byte2ShortMap) key, (Byte) value);
    }

    @Deprecated
    default Short computeIfAbsent(Byte key, Function<? super Byte, ? extends Short> mappingFunction) {
        return computeIfAbsent((Byte2ShortMap) key, (Function<? super Byte2ShortMap, ? extends Short>) mappingFunction);
    }

    @Deprecated
    default Short computeIfPresent(Byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
        return computeIfPresent((Byte2ShortMap) key, (BiFunction<? super Byte2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short compute(Byte key, BiFunction<? super Byte, ? super Short, ? extends Short> remappingFunction) {
        return compute((Byte2ShortMap) key, (BiFunction<? super Byte2ShortMap, ? super Short, ? extends Short>) remappingFunction);
    }

    @Deprecated
    default Short merge(Byte key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return merge((Byte2ShortMap) key, (Byte) value, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortMap$Entry.class */
    public interface Entry extends Map.Entry<Byte, Short> {
        byte getByteKey();

        short getShortValue();

        short setValue(short s);

        @Override // java.util.Map.Entry
        @Deprecated
        default Byte getKey() {
            return Byte.valueOf(getByteKey());
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
