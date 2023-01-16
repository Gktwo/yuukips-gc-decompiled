package p014it.unimi.dsi.fastutil.shorts;

import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.shorts.Short2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2FloatFunction.class */
public interface Short2FloatFunction extends Function<Short, Float>, IntToDoubleFunction {
    float get(short s);

    @Override // java.util.function.IntToDoubleFunction
    @Deprecated
    default double applyAsDouble(int operand) {
        return (double) get(SafeMath.safeIntToShort(operand));
    }

    default float put(short key, float value) {
        throw new UnsupportedOperationException();
    }

    default float getOrDefault(short key, float defaultValue) {
        float v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default float remove(short key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Float put(Short key, Float value) {
        short k = key.shortValue();
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
        short k = ((Short) key).shortValue();
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
        short k = ((Short) key).shortValue();
        float v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Float.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        if (key == null) {
            return null;
        }
        short k = ((Short) key).shortValue();
        if (containsKey(k)) {
            return Float.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatMap
    default boolean containsKey(short key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Short) key).shortValue());
    }

    default void defaultReturnValue(float rv) {
        throw new UnsupportedOperationException();
    }

    default float defaultReturnValue() {
        return 0.0f;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Float> compose(java.util.function.Function<? super T, ? extends Short> before) {
        return (java.util.function.Function<T, Float>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Short, T> andThen(java.util.function.Function<? super Float, ? extends T> after) {
        return (java.util.function.Function<Short, T>) andThen(after);
    }

    default Short2ByteFunction andThenByte(Float2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2FloatFunction composeByte(Byte2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2ShortFunction andThenShort(Float2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2FloatFunction composeShort(Short2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2IntFunction andThenInt(Float2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2FloatFunction composeInt(Int2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2LongFunction andThenLong(Float2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2FloatFunction composeLong(Long2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2CharFunction andThenChar(Float2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2FloatFunction composeChar(Char2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2FloatFunction andThenFloat(Float2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2FloatFunction composeFloat(Float2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2DoubleFunction andThenDouble(Float2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2FloatFunction composeDouble(Double2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Short2ObjectFunction<T> andThenObject(Float2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2FloatFunction<T> composeObject(Object2ShortFunction<? super T> before) {
        return k -> {
            return get(before.getShort(before));
        };
    }

    default <T> Short2ReferenceFunction<T> andThenReference(Float2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2FloatFunction<T> composeReference(Reference2ShortFunction<? super T> before) {
        return k -> {
            return get(before.getShort(before));
        };
    }
}
