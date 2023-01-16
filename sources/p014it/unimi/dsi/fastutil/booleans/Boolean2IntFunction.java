package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2IntFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.Boolean2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/Boolean2IntFunction.class */
public interface Boolean2IntFunction extends Function<Boolean, Integer> {
    int get(boolean z);

    default int put(boolean key, int value) {
        throw new UnsupportedOperationException();
    }

    default int getOrDefault(boolean key, int defaultValue) {
        int v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default int remove(boolean key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Integer put(Boolean key, Integer value) {
        boolean k = key.booleanValue();
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
        boolean k = ((Boolean) key).booleanValue();
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
        boolean k = ((Boolean) key).booleanValue();
        int v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Integer.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        if (key == null) {
            return null;
        }
        boolean k = ((Boolean) key).booleanValue();
        if (containsKey(k)) {
            return Integer.valueOf(remove(k));
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

    default void defaultReturnValue(int rv) {
        throw new UnsupportedOperationException();
    }

    default int defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Integer> compose(java.util.function.Function<? super T, ? extends Boolean> before) {
        return (java.util.function.Function<T, Integer>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Boolean, T> andThen(java.util.function.Function<? super Integer, ? extends T> after) {
        return (java.util.function.Function<Boolean, T>) andThen(after);
    }

    default Boolean2ByteFunction andThenByte(Int2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2IntFunction composeByte(Byte2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2ShortFunction andThenShort(Int2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2IntFunction composeShort(Short2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2IntFunction andThenInt(Int2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2IntFunction composeInt(Int2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2LongFunction andThenLong(Int2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2IntFunction composeLong(Long2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2CharFunction andThenChar(Int2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2IntFunction composeChar(Char2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2FloatFunction andThenFloat(Int2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2IntFunction composeFloat(Float2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2DoubleFunction andThenDouble(Int2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2IntFunction composeDouble(Double2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Boolean2ObjectFunction<T> andThenObject(Int2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2IntFunction<T> composeObject(Object2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }

    default <T> Boolean2ReferenceFunction<T> andThenReference(Int2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2IntFunction<T> composeReference(Reference2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }
}
