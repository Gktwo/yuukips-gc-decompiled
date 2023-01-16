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
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMap.class */
public interface Byte2IntMap extends Byte2IntFunction, Map<Byte, Integer> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
    void defaultReturnValue(int i);

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
    int defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntSortedMap
    ObjectSet<Entry> byte2IntEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // java.util.Map
    Set<Byte> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // java.util.Map
    Collection<Integer> values();

    boolean containsKey(byte b);

    boolean containsValue(int i);

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Integer>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Byte, Integer>> entrySet() {
        return byte2IntEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
    @Deprecated
    default Integer put(Byte key, Integer value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Integer) value).intValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Byte, ? super Integer> consumer) {
        ObjectSet<Entry> entrySet = byte2IntEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Byte.valueOf(entry.getByteKey()), Integer.valueOf(entry.getIntValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
    default int getOrDefault(byte key, int defaultValue) {
        int v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction
    @Deprecated
    default Integer getOrDefault(Object key, Integer defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default int putIfAbsent(byte key, int value) {
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(byte key, int value) {
        int curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(byte key, int oldValue, int newValue) {
        int curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default int replace(byte key, int value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default int computeIfAbsent(byte key, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        int newValue = mappingFunction.applyAsInt(key);
        put(key, newValue);
        return newValue;
    }

    default int computeIfAbsentNullable(byte key, IntFunction<? extends Integer> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Integer mappedValue = (Integer) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        int newValue = mappedValue.intValue();
        put(key, newValue);
        return newValue;
    }

    default int computeIfAbsent(byte key, Byte2IntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        int newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default int computeIfAbsentPartial(byte key, Byte2IntFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default int computeIfPresent(byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Integer newValue = (Integer) remappingFunction.apply(Byte.valueOf(key), Integer.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        int newVal = newValue.intValue();
        put(key, newVal);
        return newVal;
    }

    default int compute(byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Integer newValue = (Integer) remappingFunction.apply(Byte.valueOf(key), contained ? Integer.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        int newVal = newValue.intValue();
        put(key, newVal);
        return newVal;
    }

    default int merge(byte key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        int newValue;
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Integer mergedValue = (Integer) remappingFunction.apply(Integer.valueOf(oldValue), Integer.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.intValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default int mergeInt(byte key, int value, IntBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.applyAsInt(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default int mergeInt(byte key, int value, p014it.unimi.dsi.fastutil.ints.IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (IntBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Integer putIfAbsent(Byte key, Integer value) {
        return putIfAbsent((Byte2IntMap) key, (Byte) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Byte key, Integer oldValue, Integer newValue) {
        return replace((Byte2IntMap) key, oldValue, newValue);
    }

    @Deprecated
    default Integer replace(Byte key, Integer value) {
        return replace((Byte2IntMap) key, (Byte) value);
    }

    @Deprecated
    default Integer computeIfAbsent(Byte key, Function<? super Byte, ? extends Integer> mappingFunction) {
        return computeIfAbsent((Byte2IntMap) key, (Function<? super Byte2IntMap, ? extends Integer>) mappingFunction);
    }

    @Deprecated
    default Integer computeIfPresent(Byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
        return computeIfPresent((Byte2IntMap) key, (BiFunction<? super Byte2IntMap, ? super Integer, ? extends Integer>) remappingFunction);
    }

    @Deprecated
    default Integer compute(Byte key, BiFunction<? super Byte, ? super Integer, ? extends Integer> remappingFunction) {
        return compute((Byte2IntMap) key, (BiFunction<? super Byte2IntMap, ? super Integer, ? extends Integer>) remappingFunction);
    }

    @Deprecated
    default Integer merge(Byte key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        return merge((Byte2IntMap) key, (Byte) value, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2IntMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2IntMap$Entry.class */
    public interface Entry extends Map.Entry<Byte, Integer> {
        byte getByteKey();

        int getIntValue();

        int setValue(int i);

        @Override // java.util.Map.Entry
        @Deprecated
        default Byte getKey() {
            return Byte.valueOf(getByteKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getValue() {
            return Integer.valueOf(getIntValue());
        }

        @Deprecated
        default Integer setValue(Integer value) {
            return Integer.valueOf(setValue(value.intValue()));
        }
    }
}
