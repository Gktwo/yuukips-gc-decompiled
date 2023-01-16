package p014it.unimi.dsi.fastutil.longs;

import java.util.function.LongPredicate;
import p014it.unimi.dsi.fastutil.Function;
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
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.Long2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2BooleanFunction.class */
public interface Long2BooleanFunction extends Function<Long, Boolean>, LongPredicate {
    boolean get(long j);

    @Override // java.util.function.LongPredicate
    default boolean test(long operand) {
        return get(operand);
    }

    default boolean put(long key, boolean value) {
        throw new UnsupportedOperationException();
    }

    default boolean getOrDefault(long key, boolean defaultValue) {
        boolean v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default boolean remove(long key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Boolean put(Long key, Boolean value) {
        long k = key.longValue();
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
        long k = ((Long) key).longValue();
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
        long k = ((Long) key).longValue();
        boolean v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Boolean.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        if (key == null) {
            return null;
        }
        long k = ((Long) key).longValue();
        if (containsKey(k)) {
            return Boolean.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap
    default boolean containsKey(long key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Long) key).longValue());
    }

    default void defaultReturnValue(boolean rv) {
        throw new UnsupportedOperationException();
    }

    default boolean defaultReturnValue() {
        return false;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Boolean> compose(java.util.function.Function<? super T, ? extends Long> before) {
        return (java.util.function.Function<T, Boolean>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Long, T> andThen(java.util.function.Function<? super Boolean, ? extends T> after) {
        return (java.util.function.Function<Long, T>) andThen(after);
    }

    default Long2ByteFunction andThenByte(Boolean2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2BooleanFunction composeByte(Byte2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2ShortFunction andThenShort(Boolean2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2BooleanFunction composeShort(Short2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2IntFunction andThenInt(Boolean2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2BooleanFunction composeInt(Int2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2LongFunction andThenLong(Boolean2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2BooleanFunction composeLong(Long2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2CharFunction andThenChar(Boolean2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2BooleanFunction composeChar(Char2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2FloatFunction andThenFloat(Boolean2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2BooleanFunction composeFloat(Float2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2DoubleFunction andThenDouble(Boolean2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2BooleanFunction composeDouble(Double2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Long2ObjectFunction<T> andThenObject(Boolean2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2BooleanFunction<T> composeObject(Object2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }

    default <T> Long2ReferenceFunction<T> andThenReference(Boolean2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2BooleanFunction<T> composeReference(Reference2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }
}
