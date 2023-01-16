package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.DoubleBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleMap.class */
public interface Object2DoubleMap<K> extends Object2DoubleFunction<K>, Map<K, Double> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
    void defaultReturnValue(double d);

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
    double defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleSortedMap
    ObjectSet<Entry<K>> object2DoubleEntrySet();

    @Override // java.util.Map
    ObjectSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // java.util.Map
    Collection<Double> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(double d);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Double put(Object obj, Double d) {
        return put((Object2DoubleMap<K>) obj, d);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Double merge(Object obj, Double d, BiFunction<? super Double, ? super Double, ? extends Double> biFunction) {
        return merge((Object2DoubleMap<K>) obj, d, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Double replace(Object obj, Double d) {
        return replace((Object2DoubleMap<K>) obj, d);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default boolean replace(Object obj, Double d, Double d2) {
        return replace((Object2DoubleMap<K>) obj, d, d2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Double putIfAbsent(Object obj, Double d) {
        return putIfAbsent((Object2DoubleMap<K>) obj, d);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleMap$FastEntrySet.class */
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
    default ObjectSet<Map.Entry<K, Double>> entrySet() {
        return object2DoubleEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
    @Deprecated
    default Double put(K key, Double value) {
        return put((Object2DoubleMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        return remove(key);
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
    default void forEach(BiConsumer<? super K, ? super Double> consumer) {
        ObjectSet<Entry<K>> entrySet = object2DoubleEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Double.valueOf(entry.getDoubleValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
    default double getOrDefault(Object key, double defaultValue) {
        double v = getDouble(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
    @Deprecated
    default Double getOrDefault(Object key, Double defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default double putIfAbsent(K key, double value) {
        double v = getDouble(key);
        double drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Object2DoubleMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, double value) {
        double curValue = getDouble(key);
        if (Double.doubleToLongBits(curValue) != Double.doubleToLongBits(value)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeDouble(key);
        return true;
    }

    default boolean replace(K key, double oldValue, double newValue) {
        double curValue = getDouble(key);
        if (Double.doubleToLongBits(curValue) != Double.doubleToLongBits(oldValue)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Object2DoubleMap<K>) key, newValue);
        return true;
    }

    default double replace(K key, double value) {
        return containsKey(key) ? put((Object2DoubleMap<K>) key, value) : defaultReturnValue();
    }

    default double computeIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        double v = getDouble(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        double newValue = mappingFunction.applyAsDouble(key);
        put((Object2DoubleMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default double computeDoubleIfAbsent(K key, ToDoubleFunction<? super K> mappingFunction) {
        return computeIfAbsent((Object2DoubleMap<K>) key, (ToDoubleFunction<? super Object2DoubleMap<K>>) mappingFunction);
    }

    default double computeIfAbsent(K key, Object2DoubleFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        double v = getDouble(key);
        double drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        double newValue = mappingFunction.getDouble(key);
        put((Object2DoubleMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default double computeDoubleIfAbsentPartial(K key, Object2DoubleFunction<? super K> mappingFunction) {
        return computeIfAbsent((Object2DoubleMap<K>) key, (Object2DoubleFunction<? super Object2DoubleMap<K>>) mappingFunction);
    }

    default double computeDoubleIfPresent(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = getDouble(key);
        double drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Double newValue = (Double) remappingFunction.apply(key, Double.valueOf(oldValue));
        if (newValue == null) {
            removeDouble(key);
            return drv;
        }
        double newVal = newValue.doubleValue();
        put((Object2DoubleMap<K>) key, newVal);
        return newVal;
    }

    default double computeDouble(K key, BiFunction<? super K, ? super Double, ? extends Double> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        double oldValue = getDouble(key);
        double drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Double newValue = (Double) remappingFunction.apply(key, contained ? Double.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeDouble(key);
            }
            return drv;
        }
        double newVal = newValue.doubleValue();
        put((Object2DoubleMap<K>) key, newVal);
        return newVal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: double */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [double] */
    default double merge(K key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
        char c;
        Objects.requireNonNull(remappingFunction);
        double oldValue = getDouble(key);
        double drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Double mergedValue = (Double) remappingFunction.apply(Double.valueOf(oldValue), Double.valueOf(value));
            if (mergedValue == null) {
                removeDouble(key);
                return drv;
            }
            c = mergedValue.doubleValue();
        } else {
            c = value;
        }
        put((Object2DoubleMap<K>) key, c);
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [double] */
    /* JADX WARN: Type inference failed for: r0v8, types: [double] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default double mergeDouble(K r7, double r8, java.util.function.DoubleBinaryOperator r10) {
        /*
            r6 = this;
            r0 = r10
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r0 = r6
            r1 = r7
            double r0 = r0.getDouble(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2DoubleMap.mergeDouble(java.lang.Object, double, java.util.function.DoubleBinaryOperator):double");
    }

    default double mergeDouble(K key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble((Object2DoubleMap<K>) key, value, (java.util.function.DoubleBinaryOperator) remappingFunction);
    }

    @Deprecated
    default double mergeDouble(K key, double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
        return merge((Object2DoubleMap<K>) key, value, remappingFunction);
    }

    @Deprecated
    default Double putIfAbsent(K key, Double value) {
        return putIfAbsent((Object2DoubleMap<K>) key, (K) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(K key, Double oldValue, Double newValue) {
        return replace((Object2DoubleMap<K>) key, oldValue, newValue);
    }

    @Deprecated
    default Double replace(K key, Double value) {
        return replace((Object2DoubleMap<K>) key, (K) value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.function.BiFunction<? super java.lang.Double, ? super java.lang.Double, ? extends java.lang.Double> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    default Double merge(K key, Double value, BiFunction<? super Double, ? super Double, ? extends Double> remappingFunction) {
        return merge((Object2DoubleMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Double> {
        double getDoubleValue();

        double setValue(double d);

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
