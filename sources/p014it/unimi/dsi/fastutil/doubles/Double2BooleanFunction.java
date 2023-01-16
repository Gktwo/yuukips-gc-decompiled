package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoublePredicate;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ByteFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2CharFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2DoubleFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2FloatFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2IntFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2LongFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ObjectFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ReferenceFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ShortFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.Double2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2BooleanFunction.class */
public interface Double2BooleanFunction extends Function<Double, Boolean>, DoublePredicate {
    boolean get(double d);

    @Override // java.util.function.DoublePredicate
    default boolean test(double operand) {
        return get(operand);
    }

    default boolean put(double key, boolean value) {
        throw new UnsupportedOperationException();
    }

    default boolean getOrDefault(double key, boolean defaultValue) {
        boolean v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default boolean remove(double key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Boolean put(Double key, Boolean value) {
        double k = key.doubleValue();
        boolean containsKey = containsKey(k);
        boolean v = put(k, value.booleanValue());
        if (containsKey) {
            return Boolean.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean get(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        boolean v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Boolean.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Boolean getOrDefault(Object key, Boolean defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        double k = ((Double) key).doubleValue();
        boolean v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Boolean.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        if (containsKey(k)) {
            return Boolean.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap
    default boolean containsKey(double key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Double) key).doubleValue());
    }

    default void defaultReturnValue(boolean rv) {
        throw new UnsupportedOperationException();
    }

    default boolean defaultReturnValue() {
        return false;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Boolean> compose(java.util.function.Function<? super T, ? extends Double> before) {
        return (java.util.function.Function<T, Boolean>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Double, T> andThen(java.util.function.Function<? super Boolean, ? extends T> after) {
        return (java.util.function.Function<Double, T>) andThen(after);
    }

    default Double2ByteFunction andThenByte(Boolean2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2BooleanFunction composeByte(Byte2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2ShortFunction andThenShort(Boolean2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2BooleanFunction composeShort(Short2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2IntFunction andThenInt(Boolean2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2BooleanFunction composeInt(Int2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2LongFunction andThenLong(Boolean2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2BooleanFunction composeLong(Long2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2CharFunction andThenChar(Boolean2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2BooleanFunction composeChar(Char2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2FloatFunction andThenFloat(Boolean2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2BooleanFunction composeFloat(Float2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2DoubleFunction andThenDouble(Boolean2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2BooleanFunction composeDouble(Double2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Double2ObjectFunction<T> andThenObject(Boolean2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2BooleanFunction<T> composeObject(Object2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }

    default <T> Double2ReferenceFunction<T> andThenReference(Boolean2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2BooleanFunction<T> composeReference(Reference2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }
}
