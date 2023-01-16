package p014it.unimi.dsi.fastutil.longs;

import java.util.function.LongToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2CharFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.Long2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharFunction.class */
public interface Long2CharFunction extends Function<Long, Character>, LongToIntFunction {
    char get(long j);

    @Override // java.util.function.LongToIntFunction
    default int applyAsInt(long operand) {
        return get(operand);
    }

    default char put(long key, char value) {
        throw new UnsupportedOperationException();
    }

    default char getOrDefault(long key, char defaultValue) {
        char v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default char remove(long key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Character put(Long key, Character value) {
        long k = key.longValue();
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
        long k = ((Long) key).longValue();
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
        long k = ((Long) key).longValue();
        char v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Character.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        if (key == null) {
            return null;
        }
        long k = ((Long) key).longValue();
        if (containsKey(k)) {
            return Character.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap
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

    default void defaultReturnValue(char rv) {
        throw new UnsupportedOperationException();
    }

    default char defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Character> compose(java.util.function.Function<? super T, ? extends Long> before) {
        return (java.util.function.Function<T, Character>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Long, T> andThen(java.util.function.Function<? super Character, ? extends T> after) {
        return (java.util.function.Function<Long, T>) andThen(after);
    }

    default Long2ByteFunction andThenByte(Char2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2CharFunction composeByte(Byte2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2ShortFunction andThenShort(Char2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2CharFunction composeShort(Short2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2IntFunction andThenInt(Char2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2CharFunction composeInt(Int2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2LongFunction andThenLong(Char2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2CharFunction composeLong(Long2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2CharFunction andThenChar(Char2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2CharFunction composeChar(Char2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2FloatFunction andThenFloat(Char2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2CharFunction composeFloat(Float2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2DoubleFunction andThenDouble(Char2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2CharFunction composeDouble(Double2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Long2ObjectFunction<T> andThenObject(Char2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2CharFunction<T> composeObject(Object2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }

    default <T> Long2ReferenceFunction<T> andThenReference(Char2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2CharFunction<T> composeReference(Reference2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }
}
