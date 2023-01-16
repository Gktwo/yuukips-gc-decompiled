package p014it.unimi.dsi.fastutil.ints;

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
import p014it.unimi.dsi.fastutil.bytes.ByteBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteMap.class */
public interface Int2ByteMap extends Int2ByteFunction, Map<Integer, Byte> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    void defaultReturnValue(byte b);

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    byte defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteSortedMap
    ObjectSet<Entry> int2ByteEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // java.util.Map
    Set<Integer> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // java.util.Map
    Collection<Byte> values();

    boolean containsKey(int i);

    boolean containsValue(byte b);

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Byte>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Integer, Byte>> entrySet() {
        return int2ByteEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    @Deprecated
    default Byte put(Integer key, Byte value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Integer, ? super Byte> consumer) {
        ObjectSet<Entry> entrySet = int2ByteEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Integer.valueOf(entry.getIntKey()), Byte.valueOf(entry.getByteValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    default byte getOrDefault(int key, byte defaultValue) {
        byte v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    @Deprecated
    default Byte getOrDefault(Object key, Byte defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default byte putIfAbsent(int key, byte value) {
        byte v = get(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(int key, byte value) {
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

    default boolean replace(int key, byte oldValue, byte newValue) {
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

    default byte replace(int key, byte value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default byte computeIfAbsent(int key, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default byte computeIfAbsentNullable(int key, IntFunction<? extends Byte> mappingFunction) {
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

    default byte computeIfAbsent(int key, Int2ByteFunction mappingFunction) {
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
    default byte computeIfAbsentPartial(int key, Int2ByteFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default byte computeIfPresent(int key, BiFunction<? super Integer, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Byte newValue = (Byte) remappingFunction.apply(Integer.valueOf(key), Byte.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        byte newVal = newValue.byteValue();
        put(key, newVal);
        return newVal;
    }

    default byte compute(int key, BiFunction<? super Integer, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Byte newValue = (Byte) remappingFunction.apply(Integer.valueOf(key), contained ? Byte.valueOf(oldValue) : null);
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

    default byte merge(int key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
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

    default byte mergeByte(int key, byte value, ByteBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default byte mergeByte(int key, byte value, IntBinaryOperator remappingFunction) {
        return mergeByte(key, value, remappingFunction instanceof ByteBinaryOperator ? (ByteBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToByte(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Byte putIfAbsent(Integer key, Byte value) {
        return putIfAbsent((Int2ByteMap) key, (Integer) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Integer key, Byte oldValue, Byte newValue) {
        return replace((Int2ByteMap) key, oldValue, newValue);
    }

    @Deprecated
    default Byte replace(Integer key, Byte value) {
        return replace((Int2ByteMap) key, (Integer) value);
    }

    @Deprecated
    default Byte computeIfAbsent(Integer key, Function<? super Integer, ? extends Byte> mappingFunction) {
        return computeIfAbsent((Int2ByteMap) key, (Function<? super Int2ByteMap, ? extends Byte>) mappingFunction);
    }

    @Deprecated
    default Byte computeIfPresent(Integer key, BiFunction<? super Integer, ? super Byte, ? extends Byte> remappingFunction) {
        return computeIfPresent((Int2ByteMap) key, (BiFunction<? super Int2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte compute(Integer key, BiFunction<? super Integer, ? super Byte, ? extends Byte> remappingFunction) {
        return compute((Int2ByteMap) key, (BiFunction<? super Int2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte merge(Integer key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        return merge((Int2ByteMap) key, (Integer) value, (BiFunction<? super Integer, ? super Integer, ? extends Integer>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2ByteMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2ByteMap$Entry.class */
    public interface Entry extends Map.Entry<Integer, Byte> {
        int getIntKey();

        byte getByteValue();

        byte setValue(byte b);

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getKey() {
            return Integer.valueOf(getIntKey());
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
