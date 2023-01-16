package p014it.unimi.dsi.fastutil.ints;

import java.util.function.IntPredicate;
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
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanFunction.class */
public interface Int2BooleanFunction extends Function<Integer, Boolean>, IntPredicate {
    boolean get(int i);

    @Override // java.util.function.IntPredicate
    default boolean test(int operand) {
        return get(operand);
    }

    default boolean put(int key, boolean value) {
        throw new UnsupportedOperationException();
    }

    default boolean getOrDefault(int key, boolean defaultValue) {
        boolean v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default boolean remove(int key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Boolean put(Integer key, Boolean value) {
        int k = key.intValue();
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
        int k = ((Integer) key).intValue();
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
        int k = ((Integer) key).intValue();
        boolean v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Boolean.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        if (key == null) {
            return null;
        }
        int k = ((Integer) key).intValue();
        if (containsKey(k)) {
            return Boolean.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
    default boolean containsKey(int key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Integer) key).intValue());
    }

    default void defaultReturnValue(boolean rv) {
        throw new UnsupportedOperationException();
    }

    default boolean defaultReturnValue() {
        return false;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Boolean> compose(java.util.function.Function<? super T, ? extends Integer> before) {
        return (java.util.function.Function<T, Boolean>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Integer, T> andThen(java.util.function.Function<? super Boolean, ? extends T> after) {
        return (java.util.function.Function<Integer, T>) andThen(after);
    }

    default Int2ByteFunction andThenByte(Boolean2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2BooleanFunction composeByte(Byte2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2ShortFunction andThenShort(Boolean2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2BooleanFunction composeShort(Short2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2IntFunction andThenInt(Boolean2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2BooleanFunction composeInt(Int2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2LongFunction andThenLong(Boolean2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2BooleanFunction composeLong(Long2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2CharFunction andThenChar(Boolean2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2BooleanFunction composeChar(Char2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2FloatFunction andThenFloat(Boolean2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2BooleanFunction composeFloat(Float2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2DoubleFunction andThenDouble(Boolean2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2BooleanFunction composeDouble(Double2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Int2ObjectFunction<T> andThenObject(Boolean2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2BooleanFunction<T> composeObject(Object2IntFunction<? super T> before) {
        return k -> {
            return get(before.getInt(before));
        };
    }

    default <T> Int2ReferenceFunction<T> andThenReference(Boolean2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2BooleanFunction<T> composeReference(Reference2IntFunction<? super T> before) {
        return k -> {
            return get(before.getInt(before));
        };
    }
}
