package p014it.unimi.dsi.fastutil.doubles;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.CharBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharMap.class */
public interface Double2CharMap extends Double2CharFunction, Map<Double, Character> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction
    void defaultReturnValue(char c);

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction
    char defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharSortedMap
    ObjectSet<Entry> double2CharEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // java.util.Map
    Set<Double> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // java.util.Map
    Collection<Character> values();

    boolean containsKey(double d);

    boolean containsValue(char c);

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Double, java.lang.Character>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Double, Character>> entrySet() {
        return double2CharEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction
    @Deprecated
    default Character put(Double key, Character value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Character) value).charValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Double, ? super Character> consumer) {
        ObjectSet<Entry> entrySet = double2CharEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Double.valueOf(entry.getDoubleKey()), Character.valueOf(entry.getCharValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction
    default char getOrDefault(double key, char defaultValue) {
        char v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction
    @Deprecated
    default Character getOrDefault(Object key, Character defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default char putIfAbsent(double key, char value) {
        char v = get(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(double key, char value) {
        char curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(double key, char oldValue, char newValue) {
        char curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default char replace(double key, char value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default char computeIfAbsent(double key, DoubleToIntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default char computeIfAbsentNullable(double key, DoubleFunction<? extends Character> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = get(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Character mappedValue = (Character) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        char newValue = mappedValue.charValue();
        put(key, newValue);
        return newValue;
    }

    default char computeIfAbsent(double key, Double2CharFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = get(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        char newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default char computeIfAbsentPartial(double key, Double2CharFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default char computeIfPresent(double key, BiFunction<? super Double, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Character newValue = (Character) remappingFunction.apply(Double.valueOf(key), Character.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        char newVal = newValue.charValue();
        put(key, newVal);
        return newVal;
    }

    default char compute(double key, BiFunction<? super Double, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Character newValue = (Character) remappingFunction.apply(Double.valueOf(key), contained ? Character.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        char newVal = newValue.charValue();
        put(key, newVal);
        return newVal;
    }

    default char merge(double key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        char newValue;
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Character mergedValue = (Character) remappingFunction.apply(Character.valueOf(oldValue), Character.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.charValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default char mergeChar(double key, char value, CharBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default char mergeChar(double key, char value, IntBinaryOperator remappingFunction) {
        return mergeChar(key, value, remappingFunction instanceof CharBinaryOperator ? (CharBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToChar(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Character putIfAbsent(Double key, Character value) {
        return putIfAbsent((Double2CharMap) key, (Double) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Double key, Character oldValue, Character newValue) {
        return replace((Double2CharMap) key, oldValue, newValue);
    }

    @Deprecated
    default Character replace(Double key, Character value) {
        return replace((Double2CharMap) key, (Double) value);
    }

    @Deprecated
    default Character computeIfAbsent(Double key, Function<? super Double, ? extends Character> mappingFunction) {
        return computeIfAbsent((Double2CharMap) key, (Function<? super Double2CharMap, ? extends Character>) mappingFunction);
    }

    @Deprecated
    default Character computeIfPresent(Double key, BiFunction<? super Double, ? super Character, ? extends Character> remappingFunction) {
        return computeIfPresent((Double2CharMap) key, (BiFunction<? super Double2CharMap, ? super Character, ? extends Character>) remappingFunction);
    }

    @Deprecated
    default Character compute(Double key, BiFunction<? super Double, ? super Character, ? extends Character> remappingFunction) {
        return compute((Double2CharMap) key, (BiFunction<? super Double2CharMap, ? super Character, ? extends Character>) remappingFunction);
    }

    @Deprecated
    default Character merge(Double key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        return merge((Double2CharMap) key, (Double) value, (BiFunction<? super Double, ? super Double, ? extends Double>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharMap$Entry.class */
    public interface Entry extends Map.Entry<Double, Character> {
        double getDoubleKey();

        char getCharValue();

        char setValue(char c);

        @Override // java.util.Map.Entry
        @Deprecated
        default Double getKey() {
            return Double.valueOf(getDoubleKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getValue() {
            return Character.valueOf(getCharValue());
        }

        @Deprecated
        default Character setValue(Character value) {
            return Character.valueOf(setValue(value.charValue()));
        }
    }
}
