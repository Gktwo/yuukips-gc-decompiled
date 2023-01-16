package p014it.unimi.dsi.fastutil.floats;

import java.util.function.DoubleUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.Float2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2FloatFunction.class */
public interface Float2FloatFunction extends Function<Float, Float>, DoubleUnaryOperator {
    float get(float f);

    @Override // java.util.function.DoubleUnaryOperator
    @Deprecated
    default double applyAsDouble(double operand) {
        return (double) get(SafeMath.safeDoubleToFloat(operand));
    }

    default float put(float key, float value) {
        throw new UnsupportedOperationException();
    }

    default float getOrDefault(float key, float defaultValue) {
        float v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default float remove(float key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Float put(Float key, Float value) {
        float k = key.floatValue();
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
        float k = ((Float) key).floatValue();
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
        float k = ((Float) key).floatValue();
        float v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Float.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        if (key == null) {
            return null;
        }
        float k = ((Float) key).floatValue();
        if (containsKey(k)) {
            return Float.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2FloatMap
    default boolean containsKey(float key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Float) key).floatValue());
    }

    default void defaultReturnValue(float rv) {
        throw new UnsupportedOperationException();
    }

    default float defaultReturnValue() {
        return 0.0f;
    }

    static Float2FloatFunction identity() {
        return k -> {
            return k;
        };
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Float> compose(java.util.function.Function<? super T, ? extends Float> before) {
        return (java.util.function.Function<T, Float>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Float, T> andThen(java.util.function.Function<? super Float, ? extends T> after) {
        return (java.util.function.Function<Float, T>) andThen(after);
    }

    default Float2ByteFunction andThenByte(Float2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2FloatFunction composeByte(Byte2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2ShortFunction andThenShort(Float2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2FloatFunction composeShort(Short2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2IntFunction andThenInt(Float2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2FloatFunction composeInt(Int2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2LongFunction andThenLong(Float2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2FloatFunction composeLong(Long2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2CharFunction andThenChar(Float2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2FloatFunction composeChar(Char2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2FloatFunction andThenFloat(Float2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2FloatFunction composeFloat(Float2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2DoubleFunction andThenDouble(Float2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2FloatFunction composeDouble(Double2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Float2ObjectFunction<T> andThenObject(Float2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2FloatFunction<T> composeObject(Object2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }

    default <T> Float2ReferenceFunction<T> andThenReference(Float2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2FloatFunction<T> composeReference(Reference2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }
}
