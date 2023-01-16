package p014it.unimi.dsi.fastutil.longs;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteMap.class */
public interface Long2ByteMap extends Long2ByteFunction, Map<Long, Byte> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction
    void defaultReturnValue(byte b);

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction
    byte defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteSortedMap
    ObjectSet<Entry> long2ByteEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // java.util.Map
    Set<Long> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // java.util.Map
    Collection<Byte> values();

    boolean containsKey(long j);

    boolean containsValue(byte b);

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Byte>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Long, Byte>> entrySet() {
        return long2ByteEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction
    @Deprecated
    default Byte put(Long key, Byte value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Long, ? super Byte> consumer) {
        ObjectSet<Entry> entrySet = long2ByteEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Long.valueOf(entry.getLongKey()), Byte.valueOf(entry.getByteValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction
    default byte getOrDefault(long key, byte defaultValue) {
        byte v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ByteFunction
    @Deprecated
    default Byte getOrDefault(Object key, Byte defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default byte putIfAbsent(long key, byte value) {
        byte v = get(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(long key, byte value) {
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

    default boolean replace(long key, byte oldValue, byte newValue) {
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

    default byte replace(long key, byte value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default byte computeIfAbsent(long key, LongToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default byte computeIfAbsentNullable(long key, LongFunction<? extends Byte> mappingFunction) {
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

    default byte computeIfAbsent(long key, Long2ByteFunction mappingFunction) {
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
    default byte computeIfAbsentPartial(long key, Long2ByteFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default byte computeIfPresent(long key, BiFunction<? super Long, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Byte newValue = (Byte) remappingFunction.apply(Long.valueOf(key), Byte.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        byte newVal = newValue.byteValue();
        put(key, newVal);
        return newVal;
    }

    default byte compute(long key, BiFunction<? super Long, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Byte newValue = (Byte) remappingFunction.apply(Long.valueOf(key), contained ? Byte.valueOf(oldValue) : null);
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

    default byte merge(long key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
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

    default byte mergeByte(long key, byte value, ByteBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = get(key);
        byte newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default byte mergeByte(long key, byte value, IntBinaryOperator remappingFunction) {
        return mergeByte(key, value, remappingFunction instanceof ByteBinaryOperator ? (ByteBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToByte(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Byte putIfAbsent(Long key, Byte value) {
        return putIfAbsent((Long2ByteMap) key, (Long) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Long key, Byte oldValue, Byte newValue) {
        return replace((Long2ByteMap) key, oldValue, newValue);
    }

    @Deprecated
    default Byte replace(Long key, Byte value) {
        return replace((Long2ByteMap) key, (Long) value);
    }

    @Deprecated
    default Byte computeIfAbsent(Long key, Function<? super Long, ? extends Byte> mappingFunction) {
        return computeIfAbsent((Long2ByteMap) key, (Function<? super Long2ByteMap, ? extends Byte>) mappingFunction);
    }

    @Deprecated
    default Byte computeIfPresent(Long key, BiFunction<? super Long, ? super Byte, ? extends Byte> remappingFunction) {
        return computeIfPresent((Long2ByteMap) key, (BiFunction<? super Long2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte compute(Long key, BiFunction<? super Long, ? super Byte, ? extends Byte> remappingFunction) {
        return compute((Long2ByteMap) key, (BiFunction<? super Long2ByteMap, ? super Byte, ? extends Byte>) remappingFunction);
    }

    @Deprecated
    default Byte merge(Long key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        return merge((Long2ByteMap) key, (Long) value, (BiFunction<? super Long, ? super Long, ? extends Long>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ByteMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ByteMap$Entry.class */
    public interface Entry extends Map.Entry<Long, Byte> {
        long getLongKey();

        byte getByteValue();

        byte setValue(byte b);

        @Override // java.util.Map.Entry
        @Deprecated
        default Long getKey() {
            return Long.valueOf(getLongKey());
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
