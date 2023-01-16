package p014it.unimi.dsi.fastutil.ints;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import p014it.unimi.dsi.fastutil.longs.LongBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongMap.class */
public interface Int2LongMap extends Int2LongFunction, Map<Integer, Long> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    void defaultReturnValue(long j);

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    long defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongSortedMap
    ObjectSet<Entry> int2LongEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // java.util.Map
    Set<Integer> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // java.util.Map
    Collection<Long> values();

    boolean containsKey(int i);

    boolean containsValue(long j);

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Long>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Integer, Long>> entrySet() {
        return int2LongEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    @Deprecated
    default Long put(Integer key, Long value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Integer, ? super Long> consumer) {
        ObjectSet<Entry> entrySet = int2LongEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Integer.valueOf(entry.getIntKey()), Long.valueOf(entry.getLongValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    default long getOrDefault(int key, long defaultValue) {
        long v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    @Deprecated
    default Long getOrDefault(Object key, Long defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default long putIfAbsent(int key, long value) {
        long v = get(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(int key, long value) {
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

    default boolean replace(int key, long oldValue, long newValue) {
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

    default long replace(int key, long value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default long computeIfAbsent(int key, IntToLongFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        long newValue = mappingFunction.applyAsLong(key);
        put(key, newValue);
        return newValue;
    }

    default long computeIfAbsentNullable(int key, IntFunction<? extends Long> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = get(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Long mappedValue = (Long) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        long newValue = mappedValue.longValue();
        put(key, newValue);
        return newValue;
    }

    default long computeIfAbsent(int key, Int2LongFunction mappingFunction) {
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
    default long computeIfAbsentPartial(int key, Int2LongFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default long computeIfPresent(int key, BiFunction<? super Integer, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = get(key);
        long drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Long newValue = (Long) remappingFunction.apply(Integer.valueOf(key), Long.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        long newVal = newValue.longValue();
        put(key, newVal);
        return newVal;
    }

    default long compute(int key, BiFunction<? super Integer, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = get(key);
        long drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Long newValue = (Long) remappingFunction.apply(Integer.valueOf(key), contained ? Long.valueOf(oldValue) : null);
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
    default long merge(int key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
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
    default long mergeLong(int r7, long r8, java.util.function.LongBinaryOperator r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2LongMap.mergeLong(int, long, java.util.function.LongBinaryOperator):long");
    }

    default long mergeLong(int key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong(key, value, (java.util.function.LongBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Long putIfAbsent(Integer key, Long value) {
        return putIfAbsent((Int2LongMap) key, (Integer) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Integer key, Long oldValue, Long newValue) {
        return replace((Int2LongMap) key, oldValue, newValue);
    }

    @Deprecated
    default Long replace(Integer key, Long value) {
        return replace((Int2LongMap) key, (Integer) value);
    }

    @Deprecated
    default Long computeIfAbsent(Integer key, Function<? super Integer, ? extends Long> mappingFunction) {
        return computeIfAbsent((Int2LongMap) key, (Function<? super Int2LongMap, ? extends Long>) mappingFunction);
    }

    @Deprecated
    default Long computeIfPresent(Integer key, BiFunction<? super Integer, ? super Long, ? extends Long> remappingFunction) {
        return computeIfPresent((Int2LongMap) key, (BiFunction<? super Int2LongMap, ? super Long, ? extends Long>) remappingFunction);
    }

    @Deprecated
    default Long compute(Integer key, BiFunction<? super Integer, ? super Long, ? extends Long> remappingFunction) {
        return compute((Int2LongMap) key, (BiFunction<? super Int2LongMap, ? super Long, ? extends Long>) remappingFunction);
    }

    @Deprecated
    default Long merge(Integer key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return merge((Int2LongMap) key, (Integer) value, (BiFunction<? super Integer, ? super Integer, ? extends Integer>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2LongMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2LongMap$Entry.class */
    public interface Entry extends Map.Entry<Integer, Long> {
        int getIntKey();

        long getLongValue();

        long setValue(long j);

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getKey() {
            return Integer.valueOf(getIntKey());
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
