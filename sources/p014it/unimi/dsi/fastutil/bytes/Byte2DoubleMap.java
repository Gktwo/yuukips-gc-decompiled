package p014it.unimi.dsi.fastutil.bytes;

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

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleMap.class */
public interface Byte2DoubleMap extends Byte2DoubleFunction, Map<Byte, Double> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction
    void defaultReturnValue(double d);

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction
    double defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleSortedMap
    ObjectSet<Entry> byte2DoubleEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // java.util.Map
    Set<Byte> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // java.util.Map
    Collection<Double> values();

    boolean containsKey(byte b);

    boolean containsValue(double d);

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Byte, java.lang.Double>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Byte, Double>> entrySet() {
        return byte2DoubleEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction
    @Deprecated
    default Double put(Byte key, Double value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Byte, ? super Double> consumer) {
        ObjectSet<Entry> entrySet = byte2DoubleEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Byte.valueOf(entry.getByteKey()), Double.valueOf(entry.getDoubleValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction
    default double getOrDefault(byte key, double defaultValue) {
        double v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction
    @Deprecated
    default Double getOrDefault(Object key, Double defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default double putIfAbsent(byte key, double value) {
        double v = get(key);
        double drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(byte key, double value) {
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

    default boolean replace(byte key, double oldValue, double newValue) {
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

    default double replace(byte key, double value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default double computeIfAbsent(byte key, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        double v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        double newValue = mappingFunction.applyAsDouble(key);
        put(key, newValue);
        return newValue;
    }

    default double computeIfAbsentNullable(byte key, IntFunction<? extends Double> mappingFunction) {
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

    default double computeIfAbsent(byte key, Byte2DoubleFunction mappingFunction) {
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
    default double computeIfAbsentPartial(byte key, Byte2DoubleFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default double computeIfPresent(byte key, BiFunction<? super Byte, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = get(key);
        double drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Double newValue = (Double) remappingFunction.apply(Byte.valueOf(key), Double.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        double newVal = newValue.doubleValue();
        put(key, newVal);
        return newVal;
    }

    default double compute(byte key, BiFunction<? super Byte, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = get(key);
        double drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Double newValue = (Double) remappingFunction.apply(Byte.valueOf(key), contained ? Double.valueOf(oldValue) : null);
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
    default double merge(byte key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
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
    default double mergeDouble(byte r7, double r8, java.util.function.DoubleBinaryOperator r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap.mergeDouble(byte, double, java.util.function.DoubleBinaryOperator):double");
    }

    default double mergeDouble(byte key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble(key, value, (java.util.function.DoubleBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Double putIfAbsent(Byte key, Double value) {
        return putIfAbsent((Byte2DoubleMap) key, (Byte) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Byte key, Double oldValue, Double newValue) {
        return replace((Byte2DoubleMap) key, oldValue, newValue);
    }

    @Deprecated
    default Double replace(Byte key, Double value) {
        return replace((Byte2DoubleMap) key, (Byte) value);
    }

    @Deprecated
    default Double computeIfAbsent(Byte key, Function<? super Byte, ? extends Double> mappingFunction) {
        return computeIfAbsent((Byte2DoubleMap) key, (Function<? super Byte2DoubleMap, ? extends Double>) mappingFunction);
    }

    @Deprecated
    default Double computeIfPresent(Byte key, BiFunction<? super Byte, ? super Double, ? extends Double> remappingFunction) {
        return computeIfPresent((Byte2DoubleMap) key, (BiFunction<? super Byte2DoubleMap, ? super Double, ? extends Double>) remappingFunction);
    }

    @Deprecated
    default Double compute(Byte key, BiFunction<? super Byte, ? super Double, ? extends Double> remappingFunction) {
        return compute((Byte2DoubleMap) key, (BiFunction<? super Byte2DoubleMap, ? super Double, ? extends Double>) remappingFunction);
    }

    @Deprecated
    default Double merge(Byte key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
        return merge((Byte2DoubleMap) key, (Byte) value, (BiFunction<? super Byte, ? super Byte, ? extends Byte>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleMap$Entry.class */
    public interface Entry extends Map.Entry<Byte, Double> {
        byte getByteKey();

        double getDoubleValue();

        double setValue(double d);

        @Override // java.util.Map.Entry
        @Deprecated
        default Byte getKey() {
            return Byte.valueOf(getByteKey());
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
