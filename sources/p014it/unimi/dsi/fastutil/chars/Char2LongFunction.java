package p014it.unimi.dsi.fastutil.chars;

import java.util.function.IntToLongFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
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
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.Char2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2LongFunction.class */
public interface Char2LongFunction extends Function<Character, Long>, IntToLongFunction {
    long get(char c);

    @Override // java.util.function.IntToLongFunction
    @Deprecated
    default long applyAsLong(int operand) {
        return get(SafeMath.safeIntToChar(operand));
    }

    default long put(char key, long value) {
        throw new UnsupportedOperationException();
    }

    default long getOrDefault(char key, long defaultValue) {
        long v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default long remove(char key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Long put(Character key, Long value) {
        char k = key.charValue();
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
        char k = ((Character) key).charValue();
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
        char k = ((Character) key).charValue();
        long v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Long.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        if (containsKey(k)) {
            return Long.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2LongMap
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

    default void defaultReturnValue(long rv) {
        throw new UnsupportedOperationException();
    }

    default long defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Long> compose(java.util.function.Function<? super T, ? extends Character> before) {
        return (java.util.function.Function<T, Long>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Character, T> andThen(java.util.function.Function<? super Long, ? extends T> after) {
        return (java.util.function.Function<Character, T>) andThen(after);
    }

    default Char2ByteFunction andThenByte(Long2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2LongFunction composeByte(Byte2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2ShortFunction andThenShort(Long2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2LongFunction composeShort(Short2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2IntFunction andThenInt(Long2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2LongFunction composeInt(Int2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2LongFunction andThenLong(Long2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2LongFunction composeLong(Long2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2CharFunction andThenChar(Long2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2LongFunction composeChar(Char2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2FloatFunction andThenFloat(Long2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2LongFunction composeFloat(Float2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2DoubleFunction andThenDouble(Long2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2LongFunction composeDouble(Double2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Char2ObjectFunction<T> andThenObject(Long2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2LongFunction<T> composeObject(Object2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }

    default <T> Char2ReferenceFunction<T> andThenReference(Long2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2LongFunction<T> composeReference(Reference2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }
}
