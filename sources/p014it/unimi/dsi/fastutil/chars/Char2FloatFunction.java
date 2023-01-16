package p014it.unimi.dsi.fastutil.chars;

import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatFunction.class */
public interface Char2FloatFunction extends Function<Character, Float>, IntToDoubleFunction {
    float get(char c);

    @Override // java.util.function.IntToDoubleFunction
    @Deprecated
    default double applyAsDouble(int operand) {
        return (double) get(SafeMath.safeIntToChar(operand));
    }

    default float put(char key, float value) {
        throw new UnsupportedOperationException();
    }

    default float getOrDefault(char key, float defaultValue) {
        float v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default float remove(char key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Float put(Character key, Float value) {
        char k = key.charValue();
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
        char k = ((Character) key).charValue();
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
        char k = ((Character) key).charValue();
        float v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Float.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        if (containsKey(k)) {
            return Float.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap
    default boolean containsKey(char key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Character) key).charValue());
    }

    default void defaultReturnValue(float rv) {
        throw new UnsupportedOperationException();
    }

    default float defaultReturnValue() {
        return 0.0f;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Float> compose(java.util.function.Function<? super T, ? extends Character> before) {
        return (java.util.function.Function<T, Float>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Character, T> andThen(java.util.function.Function<? super Float, ? extends T> after) {
        return (java.util.function.Function<Character, T>) andThen(after);
    }

    default Char2ByteFunction andThenByte(Float2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2FloatFunction composeByte(Byte2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2ShortFunction andThenShort(Float2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2FloatFunction composeShort(Short2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2IntFunction andThenInt(Float2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2FloatFunction composeInt(Int2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2LongFunction andThenLong(Float2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2FloatFunction composeLong(Long2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2CharFunction andThenChar(Float2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2FloatFunction composeChar(Char2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2FloatFunction andThenFloat(Float2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2FloatFunction composeFloat(Float2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2DoubleFunction andThenDouble(Float2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2FloatFunction composeDouble(Double2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Char2ObjectFunction<T> andThenObject(Float2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2FloatFunction<T> composeObject(Object2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }

    default <T> Char2ReferenceFunction<T> andThenReference(Float2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2FloatFunction<T> composeReference(Reference2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }
}
