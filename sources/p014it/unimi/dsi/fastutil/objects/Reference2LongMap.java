package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.ToLongFunction;
import p014it.unimi.dsi.fastutil.longs.LongBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongMap.class */
public interface Reference2LongMap<K> extends Reference2LongFunction<K>, Map<K, Long> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    void defaultReturnValue(long j);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    long defaultReturnValue();

    ObjectSet<Entry<K>> reference2LongEntrySet();

    @Override // java.util.Map
    ReferenceSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // java.util.Map
    Collection<Long> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(long j);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Long put(Object obj, Long l) {
        return put((Reference2LongMap<K>) obj, l);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Long merge(Object obj, Long l, BiFunction<? super Long, ? super Long, ? extends Long> biFunction) {
        return merge((Reference2LongMap<K>) obj, l, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Long replace(Object obj, Long l) {
        return replace((Reference2LongMap<K>) obj, l);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default boolean replace(Object obj, Long l, Long l2) {
        return replace((Reference2LongMap<K>) obj, l, l2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Long putIfAbsent(Object obj, Long l) {
        return putIfAbsent((Reference2LongMap<K>) obj, l);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongMap$FastEntrySet.class */
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
    default ObjectSet<Map.Entry<K, Long>> entrySet() {
        return reference2LongEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    @Deprecated
    default Long put(K key, Long value) {
        return put((Reference2LongMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        return remove(key);
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
    default void forEach(BiConsumer<? super K, ? super Long> consumer) {
        ObjectSet<Entry<K>> entrySet = reference2LongEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Long.valueOf(entry.getLongValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    default long getOrDefault(Object key, long defaultValue) {
        long v = getLong(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    @Deprecated
    default Long getOrDefault(Object key, Long defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default long putIfAbsent(K key, long value) {
        long v = getLong(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Reference2LongMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, long value) {
        long curValue = getLong(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeLong(key);
        return true;
    }

    default boolean replace(K key, long oldValue, long newValue) {
        long curValue = getLong(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Reference2LongMap<K>) key, newValue);
        return true;
    }

    default long replace(K key, long value) {
        return containsKey(key) ? put((Reference2LongMap<K>) key, value) : defaultReturnValue();
    }

    default long computeIfAbsent(K key, ToLongFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = getLong(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        long newValue = mappingFunction.applyAsLong(key);
        put((Reference2LongMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default long computeLongIfAbsent(K key, ToLongFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2LongMap<K>) key, (ToLongFunction<? super Reference2LongMap<K>>) mappingFunction);
    }

    default long computeIfAbsent(K key, Reference2LongFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        long v = getLong(key);
        long drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        long newValue = mappingFunction.getLong(key);
        put((Reference2LongMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default long computeLongIfAbsentPartial(K key, Reference2LongFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2LongMap<K>) key, (Reference2LongFunction<? super Reference2LongMap<K>>) mappingFunction);
    }

    default long computeLongIfPresent(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = getLong(key);
        long drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Long newValue = (Long) remappingFunction.apply(key, Long.valueOf(oldValue));
        if (newValue == null) {
            removeLong(key);
            return drv;
        }
        long newVal = newValue.longValue();
        put((Reference2LongMap<K>) key, newVal);
        return newVal;
    }

    default long computeLong(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        long oldValue = getLong(key);
        long drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Long newValue = (Long) remappingFunction.apply(key, contained ? Long.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeLong(key);
            }
            return drv;
        }
        long newVal = newValue.longValue();
        put((Reference2LongMap<K>) key, newVal);
        return newVal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    default long merge(K key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        char c;
        Objects.requireNonNull(remappingFunction);
        long oldValue = getLong(key);
        long drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Long mergedValue = (Long) remappingFunction.apply(Long.valueOf(oldValue), Long.valueOf(value));
            if (mergedValue == null) {
                removeLong(key);
                return drv;
            }
            c = mergedValue.longValue();
        } else {
            c = value;
        }
        put((Reference2LongMap<K>) key, c);
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default long mergeLong(K r7, long r8, java.util.function.LongBinaryOperator r10) {
        /*
            r6 = this;
            r0 = r10
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r0 = r6
            r1 = r7
            long r0 = r0.getLong(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Reference2LongMap.mergeLong(java.lang.Object, long, java.util.function.LongBinaryOperator):long");
    }

    default long mergeLong(K key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong((Reference2LongMap<K>) key, value, (java.util.function.LongBinaryOperator) remappingFunction);
    }

    @Deprecated
    default long mergeLong(K key, long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return merge((Reference2LongMap<K>) key, value, remappingFunction);
    }

    @Deprecated
    default Long putIfAbsent(K key, Long value) {
        return putIfAbsent((Reference2LongMap<K>) key, (K) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(K key, Long oldValue, Long newValue) {
        return replace((Reference2LongMap<K>) key, oldValue, newValue);
    }

    @Deprecated
    default Long replace(K key, Long value) {
        return replace((Reference2LongMap<K>) key, (K) value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.function.BiFunction<? super java.lang.Long, ? super java.lang.Long, ? extends java.lang.Long> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    default Long merge(K key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return merge((Reference2LongMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Long> {
        long getLongValue();

        long setValue(long j);

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
