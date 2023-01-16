package p014it.unimi.dsi.fastutil.floats;

import java.util.function.DoubleToLongFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.longs.Long2LongFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.Float2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2LongFunction.class */
public interface Float2LongFunction extends Function<Float, Long>, DoubleToLongFunction {
    long get(float f);

    @Override // java.util.function.DoubleToLongFunction
    @Deprecated
    default long applyAsLong(double operand) {
        return get(SafeMath.safeDoubleToFloat(operand));
    }

    default long put(float key, long value) {
        throw new UnsupportedOperationException();
    }

    default long getOrDefault(float key, long defaultValue) {
        long v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default long remove(float key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Long put(Float key, Long value) {
        float k = key.floatValue();
        boolean containsKey = containsKey(k);
        long v = put(k, value.longValue());
        if (containsKey) {
            return Long.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long get(Object key) {
        if (key == null) {
            return null;
        }
        float k = ((Float) key).floatValue();
        long v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Long.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Long getOrDefault(Object key, Long defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        float k = ((Float) key).floatValue();
        long v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Long.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        if (key == null) {
            return null;
        }
        float k = ((Float) key).floatValue();
        if (containsKey(k)) {
            return Long.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2LongMap
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

    default void defaultReturnValue(long rv) {
        throw new UnsupportedOperationException();
    }

    default long defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Long> compose(java.util.function.Function<? super T, ? extends Float> before) {
        return (java.util.function.Function<T, Long>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Float, T> andThen(java.util.function.Function<? super Long, ? extends T> after) {
        return (java.util.function.Function<Float, T>) andThen(after);
    }

    default Float2ByteFunction andThenByte(Long2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2LongFunction composeByte(Byte2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2ShortFunction andThenShort(Long2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2LongFunction composeShort(Short2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2IntFunction andThenInt(Long2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2LongFunction composeInt(Int2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2LongFunction andThenLong(Long2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2LongFunction composeLong(Long2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2CharFunction andThenChar(Long2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2LongFunction composeChar(Char2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2FloatFunction andThenFloat(Long2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2LongFunction composeFloat(Float2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2DoubleFunction andThenDouble(Long2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2LongFunction composeDouble(Double2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Float2ObjectFunction<T> andThenObject(Long2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2LongFunction<T> composeObject(Object2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }

    default <T> Float2ReferenceFunction<T> andThenReference(Long2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2LongFunction<T> composeReference(Reference2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }
}
