package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.longs.Long2LongFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.Boolean2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/Boolean2LongFunction.class */
public interface Boolean2LongFunction extends Function<Boolean, Long> {
    long get(boolean z);

    default long put(boolean key, long value) {
        throw new UnsupportedOperationException();
    }

    default long getOrDefault(boolean key, long defaultValue) {
        long v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default long remove(boolean key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Long put(Boolean key, Long value) {
        boolean k = key.booleanValue();
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
        boolean k = ((Boolean) key).booleanValue();
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
        boolean k = ((Boolean) key).booleanValue();
        long v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Long.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        if (key == null) {
            return null;
        }
        boolean k = ((Boolean) key).booleanValue();
        if (containsKey(k)) {
            return Long.valueOf(remove(k));
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

    default void defaultReturnValue(long rv) {
        throw new UnsupportedOperationException();
    }

    default long defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Long> compose(java.util.function.Function<? super T, ? extends Boolean> before) {
        return (java.util.function.Function<T, Long>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Boolean, T> andThen(java.util.function.Function<? super Long, ? extends T> after) {
        return (java.util.function.Function<Boolean, T>) andThen(after);
    }

    default Boolean2ByteFunction andThenByte(Long2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2LongFunction composeByte(Byte2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2ShortFunction andThenShort(Long2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2LongFunction composeShort(Short2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2IntFunction andThenInt(Long2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2LongFunction composeInt(Int2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2LongFunction andThenLong(Long2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2LongFunction composeLong(Long2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2CharFunction andThenChar(Long2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2LongFunction composeChar(Char2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2FloatFunction andThenFloat(Long2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2LongFunction composeFloat(Float2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2DoubleFunction andThenDouble(Long2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2LongFunction composeDouble(Double2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Boolean2ObjectFunction<T> andThenObject(Long2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2LongFunction<T> composeObject(Object2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }

    default <T> Boolean2ReferenceFunction<T> andThenReference(Long2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2LongFunction<T> composeReference(Reference2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }
}
