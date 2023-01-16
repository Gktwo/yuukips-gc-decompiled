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
import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.DoubleBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleMap.class */
public interface Int2DoubleMap extends Int2DoubleFunction, Map<Integer, Double> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    void defaultReturnValue(double d);

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    double defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    ObjectSet<Entry> int2DoubleEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // java.util.Map
    Set<Integer> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // java.util.Map
    Collection<Double> values();

    boolean containsKey(int i);

    boolean containsValue(double d);

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Double>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Integer, Double>> entrySet() {
        return int2DoubleEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    @Deprecated
    default Double put(Integer key, Double value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Double) value).doubleValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Integer, ? super Double> consumer) {
        ObjectSet<Entry> entrySet = int2DoubleEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Integer.valueOf(entry.getIntKey()), Double.valueOf(entry.getDoubleValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    default double getOrDefault(int key, double defaultValue) {
        double v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    @Deprecated
    default Double getOrDefault(Object key, Double defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default double putIfAbsent(int key, double value) {
        double v = get(key);
        double drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(int key, double value) {
        double curValue = get(key);
        if (Double.doubleToLongBits(curValue) != Double.doubleToLongBits(value)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(int key, double oldValue, double newValue) {
        double curValue = get(key);
        if (Double.doubleToLongBits(curValue) != Double.doubleToLongBits(oldValue)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default double replace(int key, double value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default double computeIfAbsent(int key, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        double v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        double newValue = mappingFunction.applyAsDouble(key);
        put(key, newValue);
        return newValue;
    }

    default double computeIfAbsentNullable(int key, IntFunction<? extends Double> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        double v = get(key);
        double drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Double mappedValue = (Double) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        double newValue = mappedValue.doubleValue();
        put(key, newValue);
        return newValue;
    }

    default double computeIfAbsent(int key, Int2DoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        double v = get(key);
        double drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        double newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default double computeIfAbsentPartial(int key, Int2DoubleFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default double computeIfPresent(int key, BiFunction<? super Integer, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = get(key);
        double drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Double newValue = (Double) remappingFunction.apply(Integer.valueOf(key), Double.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        double newVal = newValue.doubleValue();
        put(key, newVal);
        return newVal;
    }

    default double compute(int key, BiFunction<? super Integer, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = get(key);
        double drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Double newValue = (Double) remappingFunction.apply(Integer.valueOf(key), contained ? Double.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        double newVal = newValue.doubleValue();
        put(key, newVal);
        return newVal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: double */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [double] */
    default double merge(int key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
        char c;
        Objects.requireNonNull(remappingFunction);
        double oldValue = get(key);
        double drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Double mergedValue = (Double) remappingFunction.apply(Double.valueOf(oldValue), Double.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            c = mergedValue.doubleValue();
        } else {
            c = value;
        }
        put(key, c);
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [double] */
    /* JADX WARN: Type inference failed for: r0v8, types: [double] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default double mergeDouble(int r7, double r8, java.util.function.DoubleBinaryOperator r10) {
        /*
            r6 = this;
            r0 = r10
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r0 = r6
            r1 = r7
            double r0 = r0.get(r1)
            r11 = r0
            r0 = r6
            double r0 = r0.defaultReturnValue()
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
            double r0 = r0.applyAsDouble(r1, r2)
            goto L_0x0037
        L_0x0036:
            r0 = r8
        L_0x0037:
            r15 = r0
            r0 = r6
            r1 = r7
            r2 = r15
            double r0 = r0.put(r1, r2)
            r0 = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2DoubleMap.mergeDouble(int, double, java.util.function.DoubleBinaryOperator):double");
    }

    default double mergeDouble(int key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble(key, value, (java.util.function.DoubleBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Double putIfAbsent(Integer key, Double value) {
        return putIfAbsent((Int2DoubleMap) key, (Integer) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Integer key, Double oldValue, Double newValue) {
        return replace((Int2DoubleMap) key, oldValue, newValue);
    }

    @Deprecated
    default Double replace(Integer key, Double value) {
        return replace((Int2DoubleMap) key, (Integer) value);
    }

    @Deprecated
    default Double computeIfAbsent(Integer key, Function<? super Integer, ? extends Double> mappingFunction) {
        return computeIfAbsent((Int2DoubleMap) key, (Function<? super Int2DoubleMap, ? extends Double>) mappingFunction);
    }

    @Deprecated
    default Double computeIfPresent(Integer key, BiFunction<? super Integer, ? super Double, ? extends Double> remappingFunction) {
        return computeIfPresent((Int2DoubleMap) key, (BiFunction<? super Int2DoubleMap, ? super Double, ? extends Double>) remappingFunction);
    }

    @Deprecated
    default Double compute(Integer key, BiFunction<? super Integer, ? super Double, ? extends Double> remappingFunction) {
        return compute((Int2DoubleMap) key, (BiFunction<? super Int2DoubleMap, ? super Double, ? extends Double>) remappingFunction);
    }

    @Deprecated
    default Double merge(Integer key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
        return merge((Int2DoubleMap) key, (Integer) value, (BiFunction<? super Integer, ? super Integer, ? extends Integer>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleMap$Entry.class */
    public interface Entry extends Map.Entry<Integer, Double> {
        int getIntKey();

        double getDoubleValue();

        double setValue(double d);

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getKey() {
            return Integer.valueOf(getIntKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Double getValue() {
            return Double.valueOf(getDoubleValue());
        }

        @Deprecated
        default Double setValue(Double value) {
            return Double.valueOf(setValue(value.doubleValue()));
        }
    }
}
