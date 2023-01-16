package p014it.unimi.dsi.fastutil.chars;

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

/* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleMap.class */
public interface Char2DoubleMap extends Char2DoubleFunction, Map<Character, Double> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction
    void defaultReturnValue(double d);

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction
    double defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap
    ObjectSet<Entry> char2DoubleEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // java.util.Map
    Set<Character> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // java.util.Map
    Collection<Double> values();

    boolean containsKey(char c);

    boolean containsValue(double d);

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Double>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Character, Double>> entrySet() {
        return char2DoubleEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction
    @Deprecated
    default Double put(Character key, Double value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Character, ? super Double> consumer) {
        ObjectSet<Entry> entrySet = char2DoubleEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Character.valueOf(entry.getCharKey()), Double.valueOf(entry.getDoubleValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction
    default double getOrDefault(char key, double defaultValue) {
        double v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction
    @Deprecated
    default Double getOrDefault(Object key, Double defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default double putIfAbsent(char key, double value) {
        double v = get(key);
        double drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(char key, double value) {
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

    default boolean replace(char key, double oldValue, double newValue) {
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

    default double replace(char key, double value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default double computeIfAbsent(char key, IntToDoubleFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        double v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        double newValue = mappingFunction.applyAsDouble(key);
        put(key, newValue);
        return newValue;
    }

    default double computeIfAbsentNullable(char key, IntFunction<? extends Double> mappingFunction) {
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

    default double computeIfAbsent(char key, Char2DoubleFunction mappingFunction) {
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
    default double computeIfAbsentPartial(char key, Char2DoubleFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default double computeIfPresent(char key, BiFunction<? super Character, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = get(key);
        double drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Double newValue = (Double) remappingFunction.apply(Character.valueOf(key), Double.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        double newVal = newValue.doubleValue();
        put(key, newVal);
        return newVal;
    }

    default double compute(char key, BiFunction<? super Character, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = get(key);
        double drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Double newValue = (Double) remappingFunction.apply(Character.valueOf(key), contained ? Double.valueOf(oldValue) : null);
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
    default double merge(char key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
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
    default double mergeDouble(char r7, double r8, java.util.function.DoubleBinaryOperator r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.Char2DoubleMap.mergeDouble(char, double, java.util.function.DoubleBinaryOperator):double");
    }

    default double mergeDouble(char key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble(key, value, (java.util.function.DoubleBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Double putIfAbsent(Character key, Double value) {
        return putIfAbsent((Char2DoubleMap) key, (Character) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Character key, Double oldValue, Double newValue) {
        return replace((Char2DoubleMap) key, oldValue, newValue);
    }

    @Deprecated
    default Double replace(Character key, Double value) {
        return replace((Char2DoubleMap) key, (Character) value);
    }

    @Deprecated
    default Double computeIfAbsent(Character key, Function<? super Character, ? extends Double> mappingFunction) {
        return computeIfAbsent((Char2DoubleMap) key, (Function<? super Char2DoubleMap, ? extends Double>) mappingFunction);
    }

    @Deprecated
    default Double computeIfPresent(Character key, BiFunction<? super Character, ? super Double, ? extends Double> remappingFunction) {
        return computeIfPresent((Char2DoubleMap) key, (BiFunction<? super Char2DoubleMap, ? super Double, ? extends Double>) remappingFunction);
    }

    @Deprecated
    default Double compute(Character key, BiFunction<? super Character, ? super Double, ? extends Double> remappingFunction) {
        return compute((Char2DoubleMap) key, (BiFunction<? super Char2DoubleMap, ? super Double, ? extends Double>) remappingFunction);
    }

    @Deprecated
    default Double merge(Character key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
        return merge((Char2DoubleMap) key, (Character) value, (BiFunction<? super Character, ? super Character, ? extends Character>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleMap$Entry.class */
    public interface Entry extends Map.Entry<Character, Double> {
        char getCharKey();

        double getDoubleValue();

        double setValue(double d);

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getKey() {
            return Character.valueOf(getCharKey());
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
