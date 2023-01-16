package p014it.unimi.dsi.fastutil.shorts;

import java.util.function.IntPredicate;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ByteFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2CharFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2DoubleFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2FloatFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2IntFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2LongFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ObjectFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ReferenceFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ShortFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.shorts.Short2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2BooleanFunction.class */
public interface Short2BooleanFunction extends Function<Short, Boolean>, IntPredicate {
    boolean get(short s);

    @Override // java.util.function.IntPredicate
    @Deprecated
    default boolean test(int operand) {
        return get(SafeMath.safeIntToShort(operand));
    }

    default boolean put(short key, boolean value) {
        throw new UnsupportedOperationException();
    }

    default boolean getOrDefault(short key, boolean defaultValue) {
        boolean v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default boolean remove(short key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Boolean put(Short key, Boolean value) {
        short k = key.shortValue();
        boolean containsKey = containsKey(k);
        boolean v = put(k, value.booleanValue());
        if (containsKey) {
            return Boolean.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean get(Object key) {
        if (key == null) {
            return null;
        }
        short k = ((Short) key).shortValue();
        boolean v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Boolean.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Boolean getOrDefault(Object key, Boolean defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        short k = ((Short) key).shortValue();
        boolean v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Boolean.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        if (key == null) {
            return null;
        }
        short k = ((Short) key).shortValue();
        if (containsKey(k)) {
            return Boolean.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap
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

    default void defaultReturnValue(boolean rv) {
        throw new UnsupportedOperationException();
    }

    default boolean defaultReturnValue() {
        return false;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Boolean> compose(java.util.function.Function<? super T, ? extends Short> before) {
        return (java.util.function.Function<T, Boolean>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Short, T> andThen(java.util.function.Function<? super Boolean, ? extends T> after) {
        return (java.util.function.Function<Short, T>) andThen(after);
    }

    default Short2ByteFunction andThenByte(Boolean2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2BooleanFunction composeByte(Byte2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2ShortFunction andThenShort(Boolean2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2BooleanFunction composeShort(Short2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2IntFunction andThenInt(Boolean2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2BooleanFunction composeInt(Int2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2LongFunction andThenLong(Boolean2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2BooleanFunction composeLong(Long2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2CharFunction andThenChar(Boolean2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2BooleanFunction composeChar(Char2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2FloatFunction andThenFloat(Boolean2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2BooleanFunction composeFloat(Float2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2DoubleFunction andThenDouble(Boolean2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2BooleanFunction composeDouble(Double2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Short2ObjectFunction<T> andThenObject(Boolean2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2BooleanFunction<T> composeObject(Object2ShortFunction<? super T> before) {
        return k -> {
            return get(before.getShort(before));
        };
    }

    default <T> Short2ReferenceFunction<T> andThenReference(Boolean2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2BooleanFunction<T> composeReference(Reference2ShortFunction<? super T> before) {
        return k -> {
            return get(before.getShort(before));
        };
    }
}
