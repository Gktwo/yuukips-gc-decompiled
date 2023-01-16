package p014it.unimi.dsi.fastutil.floats;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import p014it.unimi.dsi.fastutil.longs.LongBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMap.class */
public interface Float2LongMap extends Float2LongFunction, Map<Float, Long> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    void defaultReturnValue(long j);

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    long defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongSortedMap
    ObjectSet<Entry> float2LongEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // java.util.Map
    Set<Float> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // java.util.Map
    Collection<Long> values();

    boolean containsKey(float f);

    boolean containsValue(long j);

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Float, java.lang.Long>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Float, Long>> entrySet() {
        return float2LongEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    @Deprecated
    default Long put(Float key, Long value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Long) value).longValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Float, ? super Long> consumer) {
        ObjectSet<Entry> entrySet = float2LongEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Float.valueOf(entry.getFloatKey()), Long.valueOf(entry.getLongValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    default long getOrDefault(float key, long defaultValue) {
        long v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongFunction
    @Deprecated
    default Long getOrDefault(Object key, Long defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default long putIfAbsent(float key, long value) {
        long v = get(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(float key, long value) {
        long curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(float key, long oldValue, long newValue) {
        long curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default long replace(float key, long value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default long computeIfAbsent(float key, DoubleToLongFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        long newValue = mappingFunction.applyAsLong((double) key);
        put(key, newValue);
        return newValue;
    }

    default long computeIfAbsentNullable(float key, DoubleFunction<? extends Long> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = get(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Long mappedValue = (Long) mappingFunction.apply((double) key);
        if (mappedValue == null) {
            return drv;
        }
        long newValue = mappedValue.longValue();
        put(key, newValue);
        return newValue;
    }

    default long computeIfAbsent(float key, Float2LongFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = get(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        long newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default long computeIfAbsentPartial(float key, Float2LongFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default long computeIfPresent(float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = get(key);
        long drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Long newValue = (Long) remappingFunction.apply(Float.valueOf(key), Long.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        long newVal = newValue.longValue();
        put(key, newVal);
        return newVal;
    }

    default long compute(float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = get(key);
        long drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Long newValue = (Long) remappingFunction.apply(Float.valueOf(key), contained ? Long.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        long newVal = newValue.longValue();
        put(key, newVal);
        return newVal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    default long merge(float key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        char c;
        Objects.requireNonNull(remappingFunction);
        long oldValue = get(key);
        long drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Long mergedValue = (Long) remappingFunction.apply(Long.valueOf(oldValue), Long.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            c = mergedValue.longValue();
        } else {
            c = value;
        }
        put(key, c);
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default long mergeLong(float r7, long r8, java.util.function.LongBinaryOperator r10) {
        /*
            r6 = this;
            r0 = r10
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r0 = r6
            r1 = r7
            long r0 = r0.get(r1)
            r11 = r0
            r0 = r6
            long r0 = r0.defaultReturnValue()
            r13 = r0
            r0 = r11
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0029
            r0 = r6
            r1 = r7
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0036
        L_0x0029:
            r0 = r10
            r1 = r11
            r2 = r8
            long r0 = r0.applyAsLong(r1, r2)
            goto L_0x0037
        L_0x0036:
            r0 = r8
        L_0x0037:
            r15 = r0
            r0 = r6
            r1 = r7
            r2 = r15
            long r0 = r0.put(r1, r2)
            r0 = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2LongMap.mergeLong(float, long, java.util.function.LongBinaryOperator):long");
    }

    default long mergeLong(float key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong(key, value, (java.util.function.LongBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Long putIfAbsent(Float key, Long value) {
        return putIfAbsent((Float2LongMap) key, (Float) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Float key, Long oldValue, Long newValue) {
        return replace((Float2LongMap) key, oldValue, newValue);
    }

    @Deprecated
    default Long replace(Float key, Long value) {
        return replace((Float2LongMap) key, (Float) value);
    }

    @Deprecated
    default Long computeIfAbsent(Float key, Function<? super Float, ? extends Long> mappingFunction) {
        return computeIfAbsent((Float2LongMap) key, (Function<? super Float2LongMap, ? extends Long>) mappingFunction);
    }

    @Deprecated
    default Long computeIfPresent(Float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
        return computeIfPresent((Float2LongMap) key, (BiFunction<? super Float2LongMap, ? super Long, ? extends Long>) remappingFunction);
    }

    @Deprecated
    default Long compute(Float key, BiFunction<? super Float, ? super Long, ? extends Long> remappingFunction) {
        return compute((Float2LongMap) key, (BiFunction<? super Float2LongMap, ? super Long, ? extends Long>) remappingFunction);
    }

    @Deprecated
    default Long merge(Float key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return merge((Float2LongMap) key, (Float) value, (BiFunction<? super Float, ? super Float, ? extends Float>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2LongMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongMap$Entry.class */
    public interface Entry extends Map.Entry<Float, Long> {
        float getFloatKey();

        long getLongValue();

        long setValue(long j);

        @Override // java.util.Map.Entry
        @Deprecated
        default Float getKey() {
            return Float.valueOf(getFloatKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Long getValue() {
            return Long.valueOf(getLongValue());
        }

        @Deprecated
        default Long setValue(Long value) {
            return Long.valueOf(setValue(value.longValue()));
        }
    }
}
