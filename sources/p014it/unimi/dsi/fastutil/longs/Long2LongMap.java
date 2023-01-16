package p014it.unimi.dsi.fastutil.longs;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongMap.class */
public interface Long2LongMap extends Long2LongFunction, Map<Long, Long> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    void defaultReturnValue(long j);

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    long defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    ObjectSet<Entry> long2LongEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // java.util.Map
    Set<Long> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // java.util.Map
    Collection<Long> values();

    boolean containsKey(long j);

    boolean containsValue(long j);

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Long, java.lang.Long>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Long, Long>> entrySet() {
        return long2LongEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    @Deprecated
    default Long put(Long key, Long value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Long, ? super Long> consumer) {
        ObjectSet<Entry> entrySet = long2LongEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Long.valueOf(entry.getLongKey()), Long.valueOf(entry.getLongValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    default long getOrDefault(long key, long defaultValue) {
        long v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    @Deprecated
    default Long getOrDefault(Object key, Long defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default long putIfAbsent(long key, long value) {
        long v = get(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(long key, long value) {
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

    default boolean replace(long key, long oldValue, long newValue) {
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

    default long replace(long key, long value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default long computeIfAbsent(long key, LongUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        long newValue = mappingFunction.applyAsLong(key);
        put(key, newValue);
        return newValue;
    }

    default long computeIfAbsentNullable(long key, LongFunction<? extends Long> mappingFunction) {
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

    default long computeIfAbsent(long key, Long2LongFunction mappingFunction) {
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
    default long computeIfAbsentPartial(long key, Long2LongFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default long computeIfPresent(long key, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = get(key);
        long drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Long newValue = (Long) remappingFunction.apply(Long.valueOf(key), Long.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        long newVal = newValue.longValue();
        put(key, newVal);
        return newVal;
    }

    default long compute(long key, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = get(key);
        long drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Long newValue = (Long) remappingFunction.apply(Long.valueOf(key), contained ? Long.valueOf(oldValue) : null);
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

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    default long merge(long key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
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
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default long mergeLong(long r7, long r9, java.util.function.LongBinaryOperator r11) {
        /*
            r6 = this;
            r0 = r11
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r0 = r6
            r1 = r7
            long r0 = r0.get(r1)
            r12 = r0
            r0 = r6
            long r0 = r0.defaultReturnValue()
            r14 = r0
            r0 = r12
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0029
            r0 = r6
            r1 = r7
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0036
        L_0x0029:
            r0 = r11
            r1 = r12
            r2 = r9
            long r0 = r0.applyAsLong(r1, r2)
            goto L_0x0037
        L_0x0036:
            r0 = r9
        L_0x0037:
            r16 = r0
            r0 = r6
            r1 = r7
            r2 = r16
            long r0 = r0.put(r1, r2)
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2LongMap.mergeLong(long, long, java.util.function.LongBinaryOperator):long");
    }

    default long mergeLong(long key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong(key, value, (LongBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Long putIfAbsent(Long key, Long value) {
        return putIfAbsent((Long2LongMap) key, value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Long key, Long oldValue, Long newValue) {
        return replace((Long2LongMap) key, oldValue, newValue);
    }

    @Deprecated
    default Long replace(Long key, Long value) {
        return replace((Long2LongMap) key, value);
    }

    @Deprecated
    default Long computeIfAbsent(Long key, Function<? super Long, ? extends Long> mappingFunction) {
        return computeIfAbsent((Long2LongMap) key, (Function<? super Long2LongMap, ? extends Long>) mappingFunction);
    }

    @Deprecated
    default Long computeIfPresent(Long key, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return computeIfPresent((Long2LongMap) key, (BiFunction<? super Long2LongMap, ? super Long, ? extends Long>) remappingFunction);
    }

    @Deprecated
    default Long compute(Long key, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return compute((Long2LongMap) key, (BiFunction<? super Long2LongMap, ? super Long, ? extends Long>) remappingFunction);
    }

    @Deprecated
    default Long merge(Long key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return merge((Long2LongMap) key, value, remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongMap$Entry.class */
    public interface Entry extends Map.Entry<Long, Long> {
        long getLongKey();

        long getLongValue();

        long setValue(long j);

        @Override // java.util.Map.Entry
        @Deprecated
        default Long getKey() {
            return Long.valueOf(getLongKey());
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
