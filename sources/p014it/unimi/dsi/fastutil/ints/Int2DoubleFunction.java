package p014it.unimi.dsi.fastutil.ints;

import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleFunction.class */
public interface Int2DoubleFunction extends Function<Integer, Double>, IntToDoubleFunction {
    double get(int i);

    @Override // java.util.function.IntToDoubleFunction
    default double applyAsDouble(int operand) {
        return get(operand);
    }

    default double put(int key, double value) {
        throw new UnsupportedOperationException();
    }

    default double getOrDefault(int key, double defaultValue) {
        double v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default double remove(int key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Double put(Integer key, Double value) {
        int k = key.intValue();
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
        int k = ((Integer) key).intValue();
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
        int k = ((Integer) key).intValue();
        double v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Double.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        if (key == null) {
            return null;
        }
        int k = ((Integer) key).intValue();
        if (containsKey(k)) {
            return Double.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
    default boolean containsKey(int key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Integer) key).intValue());
    }

    default void defaultReturnValue(double rv) {
        throw new UnsupportedOperationException();
    }

    default double defaultReturnValue() {
        return 0.0d;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Double> compose(java.util.function.Function<? super T, ? extends Integer> before) {
        return (java.util.function.Function<T, Double>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Integer, T> andThen(java.util.function.Function<? super Double, ? extends T> after) {
        return (java.util.function.Function<Integer, T>) andThen(after);
    }

    default Int2ByteFunction andThenByte(Double2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2DoubleFunction composeByte(Byte2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2ShortFunction andThenShort(Double2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2DoubleFunction composeShort(Short2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2IntFunction andThenInt(Double2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2DoubleFunction composeInt(Int2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2LongFunction andThenLong(Double2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2DoubleFunction composeLong(Long2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2CharFunction andThenChar(Double2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2DoubleFunction composeChar(Char2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2FloatFunction andThenFloat(Double2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2DoubleFunction composeFloat(Float2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2DoubleFunction andThenDouble(Double2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2DoubleFunction composeDouble(Double2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Int2ObjectFunction<T> andThenObject(Double2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2DoubleFunction<T> composeObject(Object2IntFunction<? super T> before) {
        return k -> {
            return get(before.getInt(before));
        };
    }

    default <T> Int2ReferenceFunction<T> andThenReference(Double2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2DoubleFunction<T> composeReference(Reference2IntFunction<? super T> before) {
        return k -> {
            return get(before.getInt(before));
        };
    }
}
