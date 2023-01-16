package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.Function;
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
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.Boolean2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/Boolean2ShortFunction.class */
public interface Boolean2ShortFunction extends Function<Boolean, Short> {
    short get(boolean z);

    default short put(boolean key, short value) {
        throw new UnsupportedOperationException();
    }

    default short getOrDefault(boolean key, short defaultValue) {
        short v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default short remove(boolean key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Short put(Boolean key, Short value) {
        boolean k = key.booleanValue();
        boolean containsKey = containsKey(k);
        short v = put(k, value.shortValue());
        if (containsKey) {
            return Short.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        if (key == null) {
            return null;
        }
        boolean k = ((Boolean) key).booleanValue();
        short v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Short.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        boolean k = ((Boolean) key).booleanValue();
        short v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Short.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        if (key == null) {
            return null;
        }
        boolean k = ((Boolean) key).booleanValue();
        if (containsKey(k)) {
            return Short.valueOf(remove(k));
        }
        return null;
    }

    default boolean containsKey(boolean key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Boolean) key).booleanValue());
    }

    default void defaultReturnValue(short rv) {
        throw new UnsupportedOperationException();
    }

    default short defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Short> compose(java.util.function.Function<? super T, ? extends Boolean> before) {
        return (java.util.function.Function<T, Short>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Boolean, T> andThen(java.util.function.Function<? super Short, ? extends T> after) {
        return (java.util.function.Function<Boolean, T>) andThen(after);
    }

    default Boolean2ByteFunction andThenByte(Short2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2ShortFunction composeByte(Byte2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2ShortFunction andThenShort(Short2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2ShortFunction composeShort(Short2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2IntFunction andThenInt(Short2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2ShortFunction composeInt(Int2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2LongFunction andThenLong(Short2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2ShortFunction composeLong(Long2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2CharFunction andThenChar(Short2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2ShortFunction composeChar(Char2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2FloatFunction andThenFloat(Short2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2ShortFunction composeFloat(Float2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2DoubleFunction andThenDouble(Short2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2ShortFunction composeDouble(Double2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Boolean2ObjectFunction<T> andThenObject(Short2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ShortFunction<T> composeObject(Object2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }

    default <T> Boolean2ReferenceFunction<T> andThenReference(Short2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ShortFunction<T> composeReference(Reference2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }
}
