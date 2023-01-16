package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoubleUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.Double2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2FloatFunction.class */
public interface Double2FloatFunction extends Function<Double, Float>, DoubleUnaryOperator {
    float get(double d);

    @Override // java.util.function.DoubleUnaryOperator
    default double applyAsDouble(double operand) {
        return (double) get(operand);
    }

    default float put(double key, float value) {
        throw new UnsupportedOperationException();
    }

    default float getOrDefault(double key, float defaultValue) {
        float v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default float remove(double key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Float put(Double key, Float value) {
        double k = key.doubleValue();
        boolean containsKey = containsKey(k);
        float v = put(k, value.floatValue());
        if (containsKey) {
            return Float.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float get(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        float v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Float.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Float getOrDefault(Object key, Float defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        double k = ((Double) key).doubleValue();
        float v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Float.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        if (containsKey(k)) {
            return Float.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatMap
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

    default void defaultReturnValue(float rv) {
        throw new UnsupportedOperationException();
    }

    default float defaultReturnValue() {
        return 0.0f;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Float> compose(java.util.function.Function<? super T, ? extends Double> before) {
        return (java.util.function.Function<T, Float>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Double, T> andThen(java.util.function.Function<? super Float, ? extends T> after) {
        return (java.util.function.Function<Double, T>) andThen(after);
    }

    default Double2ByteFunction andThenByte(Float2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2FloatFunction composeByte(Byte2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2ShortFunction andThenShort(Float2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2FloatFunction composeShort(Short2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2IntFunction andThenInt(Float2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2FloatFunction composeInt(Int2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2LongFunction andThenLong(Float2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2FloatFunction composeLong(Long2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2CharFunction andThenChar(Float2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2FloatFunction composeChar(Char2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2FloatFunction andThenFloat(Float2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2FloatFunction composeFloat(Float2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2DoubleFunction andThenDouble(Float2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2FloatFunction composeDouble(Double2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Double2ObjectFunction<T> andThenObject(Float2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2FloatFunction<T> composeObject(Object2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }

    default <T> Double2ReferenceFunction<T> andThenReference(Float2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2FloatFunction<T> composeReference(Reference2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }
}
