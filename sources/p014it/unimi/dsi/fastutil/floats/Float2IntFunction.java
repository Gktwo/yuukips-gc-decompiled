package p014it.unimi.dsi.fastutil.floats;

import java.util.function.DoubleToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2IntFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.Float2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntFunction.class */
public interface Float2IntFunction extends Function<Float, Integer>, DoubleToIntFunction {
    int get(float f);

    @Override // java.util.function.DoubleToIntFunction
    @Deprecated
    default int applyAsInt(double operand) {
        return get(SafeMath.safeDoubleToFloat(operand));
    }

    default int put(float key, int value) {
        throw new UnsupportedOperationException();
    }

    default int getOrDefault(float key, int defaultValue) {
        int v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default int remove(float key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Integer put(Float key, Integer value) {
        float k = key.floatValue();
        boolean containsKey = containsKey(k);
        int v = put(k, value.intValue());
        if (containsKey) {
            return Integer.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer get(Object key) {
        if (key == null) {
            return null;
        }
        float k = ((Float) key).floatValue();
        int v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Integer.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Integer getOrDefault(Object key, Integer defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        float k = ((Float) key).floatValue();
        int v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Integer.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        if (key == null) {
            return null;
        }
        float k = ((Float) key).floatValue();
        if (containsKey(k)) {
            return Integer.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2IntMap
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

    default void defaultReturnValue(int rv) {
        throw new UnsupportedOperationException();
    }

    default int defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Integer> compose(java.util.function.Function<? super T, ? extends Float> before) {
        return (java.util.function.Function<T, Integer>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Float, T> andThen(java.util.function.Function<? super Integer, ? extends T> after) {
        return (java.util.function.Function<Float, T>) andThen(after);
    }

    default Float2ByteFunction andThenByte(Int2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2IntFunction composeByte(Byte2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2ShortFunction andThenShort(Int2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2IntFunction composeShort(Short2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2IntFunction andThenInt(Int2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2IntFunction composeInt(Int2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2LongFunction andThenLong(Int2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2IntFunction composeLong(Long2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2CharFunction andThenChar(Int2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2IntFunction composeChar(Char2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2FloatFunction andThenFloat(Int2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2IntFunction composeFloat(Float2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2DoubleFunction andThenDouble(Int2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2IntFunction composeDouble(Double2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Float2ObjectFunction<T> andThenObject(Int2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2IntFunction<T> composeObject(Object2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }

    default <T> Float2ReferenceFunction<T> andThenReference(Int2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2IntFunction<T> composeReference(Reference2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }
}
