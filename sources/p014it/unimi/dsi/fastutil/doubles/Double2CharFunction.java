package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoubleToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2CharFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.Double2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2CharFunction.class */
public interface Double2CharFunction extends Function<Double, Character>, DoubleToIntFunction {
    char get(double d);

    @Override // java.util.function.DoubleToIntFunction
    default int applyAsInt(double operand) {
        return get(operand);
    }

    default char put(double key, char value) {
        throw new UnsupportedOperationException();
    }

    default char getOrDefault(double key, char defaultValue) {
        char v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default char remove(double key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Character put(Double key, Character value) {
        double k = key.doubleValue();
        boolean containsKey = containsKey(k);
        char v = put(k, value.charValue());
        if (containsKey) {
            return Character.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character get(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        char v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Character.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Character getOrDefault(Object key, Character defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        double k = ((Double) key).doubleValue();
        char v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Character.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        if (containsKey(k)) {
            return Character.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap
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

    default void defaultReturnValue(char rv) {
        throw new UnsupportedOperationException();
    }

    default char defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Character> compose(java.util.function.Function<? super T, ? extends Double> before) {
        return (java.util.function.Function<T, Character>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Double, T> andThen(java.util.function.Function<? super Character, ? extends T> after) {
        return (java.util.function.Function<Double, T>) andThen(after);
    }

    default Double2ByteFunction andThenByte(Char2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2CharFunction composeByte(Byte2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2ShortFunction andThenShort(Char2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2CharFunction composeShort(Short2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2IntFunction andThenInt(Char2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2CharFunction composeInt(Int2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2LongFunction andThenLong(Char2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2CharFunction composeLong(Long2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2CharFunction andThenChar(Char2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2CharFunction composeChar(Char2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2FloatFunction andThenFloat(Char2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2CharFunction composeFloat(Float2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2DoubleFunction andThenDouble(Char2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2CharFunction composeDouble(Double2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Double2ObjectFunction<T> andThenObject(Char2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2CharFunction<T> composeObject(Object2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }

    default <T> Double2ReferenceFunction<T> andThenReference(Char2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2CharFunction<T> composeReference(Reference2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }
}
