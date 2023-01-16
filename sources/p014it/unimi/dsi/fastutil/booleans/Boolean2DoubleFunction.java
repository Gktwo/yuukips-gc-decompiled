package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
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
/* renamed from: it.unimi.dsi.fastutil.booleans.Boolean2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/Boolean2DoubleFunction.class */
public interface Boolean2DoubleFunction extends Function<Boolean, Double> {
    double get(boolean z);

    default double put(boolean key, double value) {
        throw new UnsupportedOperationException();
    }

    default double getOrDefault(boolean key, double defaultValue) {
        double v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default double remove(boolean key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Double put(Boolean key, Double value) {
        boolean k = key.booleanValue();
        boolean containsKey = containsKey(k);
        double v = put(k, value.doubleValue());
        if (containsKey) {
            return Double.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double get(Object key) {
        if (key == null) {
            return null;
        }
        boolean k = ((Boolean) key).booleanValue();
        double v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Double.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Double getOrDefault(Object key, Double defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        boolean k = ((Boolean) key).booleanValue();
        double v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Double.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        if (key == null) {
            return null;
        }
        boolean k = ((Boolean) key).booleanValue();
        if (containsKey(k)) {
            return Double.valueOf(remove(k));
        }
        return null;
    }

    default boolean containsKey(boolean key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Boolean) key).booleanValue());
    }

    default void defaultReturnValue(double rv) {
        throw new UnsupportedOperationException();
    }

    default double defaultReturnValue() {
        return 0.0d;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Double> compose(java.util.function.Function<? super T, ? extends Boolean> before) {
        return (java.util.function.Function<T, Double>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Boolean, T> andThen(java.util.function.Function<? super Double, ? extends T> after) {
        return (java.util.function.Function<Boolean, T>) andThen(after);
    }

    default Boolean2ByteFunction andThenByte(Double2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2DoubleFunction composeByte(Byte2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2ShortFunction andThenShort(Double2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2DoubleFunction composeShort(Short2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2IntFunction andThenInt(Double2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2DoubleFunction composeInt(Int2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2LongFunction andThenLong(Double2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2DoubleFunction composeLong(Long2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2CharFunction andThenChar(Double2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2DoubleFunction composeChar(Char2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2FloatFunction andThenFloat(Double2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2DoubleFunction composeFloat(Float2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2DoubleFunction andThenDouble(Double2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2DoubleFunction composeDouble(Double2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Boolean2ObjectFunction<T> andThenObject(Double2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2DoubleFunction<T> composeObject(Object2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }

    default <T> Boolean2ReferenceFunction<T> andThenReference(Double2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2DoubleFunction<T> composeReference(Reference2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }
}
