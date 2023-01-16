package p014it.unimi.dsi.fastutil.bytes;

import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2CharFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharFunction.class */
public interface Byte2CharFunction extends Function<Byte, Character>, IntUnaryOperator {
    char get(byte b);

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int operand) {
        return get(SafeMath.safeIntToByte(operand));
    }

    default char put(byte key, char value) {
        throw new UnsupportedOperationException();
    }

    default char getOrDefault(byte key, char defaultValue) {
        char v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default char remove(byte key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Character put(Byte key, Character value) {
        byte k = key.byteValue();
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
        byte k = ((Byte) key).byteValue();
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
        byte k = ((Byte) key).byteValue();
        char v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Character.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        if (key == null) {
            return null;
        }
        byte k = ((Byte) key).byteValue();
        if (containsKey(k)) {
            return Character.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
    default boolean containsKey(byte key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Byte) key).byteValue());
    }

    default void defaultReturnValue(char rv) {
        throw new UnsupportedOperationException();
    }

    default char defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Character> compose(java.util.function.Function<? super T, ? extends Byte> before) {
        return (java.util.function.Function<T, Character>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Byte, T> andThen(java.util.function.Function<? super Character, ? extends T> after) {
        return (java.util.function.Function<Byte, T>) andThen(after);
    }

    default Byte2ByteFunction andThenByte(Char2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2CharFunction composeByte(Byte2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2ShortFunction andThenShort(Char2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2CharFunction composeShort(Short2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2IntFunction andThenInt(Char2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2CharFunction composeInt(Int2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2LongFunction andThenLong(Char2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2CharFunction composeLong(Long2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2CharFunction andThenChar(Char2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2CharFunction composeChar(Char2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2FloatFunction andThenFloat(Char2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2CharFunction composeFloat(Float2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2DoubleFunction andThenDouble(Char2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2CharFunction composeDouble(Double2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Byte2ObjectFunction<T> andThenObject(Char2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2CharFunction<T> composeObject(Object2ByteFunction<? super T> before) {
        return k -> {
            return get(before.getByte(before));
        };
    }

    default <T> Byte2ReferenceFunction<T> andThenReference(Char2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2CharFunction<T> composeReference(Reference2ByteFunction<? super T> before) {
        return k -> {
            return get(before.getByte(before));
        };
    }
}
