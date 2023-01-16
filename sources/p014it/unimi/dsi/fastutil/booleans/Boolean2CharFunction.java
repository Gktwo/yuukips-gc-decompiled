package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2CharFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.Boolean2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/Boolean2CharFunction.class */
public interface Boolean2CharFunction extends Function<Boolean, Character> {
    char get(boolean z);

    default char put(boolean key, char value) {
        throw new UnsupportedOperationException();
    }

    default char getOrDefault(boolean key, char defaultValue) {
        char v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default char remove(boolean key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Character put(Boolean key, Character value) {
        boolean k = key.booleanValue();
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
        boolean k = ((Boolean) key).booleanValue();
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
        boolean k = ((Boolean) key).booleanValue();
        char v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Character.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        if (key == null) {
            return null;
        }
        boolean k = ((Boolean) key).booleanValue();
        if (containsKey(k)) {
            return Character.valueOf(remove(k));
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

    default void defaultReturnValue(char rv) {
        throw new UnsupportedOperationException();
    }

    default char defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Character> compose(java.util.function.Function<? super T, ? extends Boolean> before) {
        return (java.util.function.Function<T, Character>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Boolean, T> andThen(java.util.function.Function<? super Character, ? extends T> after) {
        return (java.util.function.Function<Boolean, T>) andThen(after);
    }

    default Boolean2ByteFunction andThenByte(Char2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2CharFunction composeByte(Byte2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2ShortFunction andThenShort(Char2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2CharFunction composeShort(Short2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2IntFunction andThenInt(Char2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2CharFunction composeInt(Int2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2LongFunction andThenLong(Char2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2CharFunction composeLong(Long2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2CharFunction andThenChar(Char2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2CharFunction composeChar(Char2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2FloatFunction andThenFloat(Char2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2CharFunction composeFloat(Float2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Boolean2DoubleFunction andThenDouble(Char2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2CharFunction composeDouble(Double2BooleanFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Boolean2ObjectFunction<T> andThenObject(Char2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2CharFunction<T> composeObject(Object2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }

    default <T> Boolean2ReferenceFunction<T> andThenReference(Char2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2CharFunction<T> composeReference(Reference2BooleanFunction<? super T> before) {
        return k -> {
            return get(before.getBoolean(before));
        };
    }
}
