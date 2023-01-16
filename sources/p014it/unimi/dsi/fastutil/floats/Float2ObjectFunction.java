package p014it.unimi.dsi.fastutil.floats;

import java.util.function.DoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.Float2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ObjectFunction.class */
public interface Float2ObjectFunction<V> extends Function<Float, V>, DoubleFunction<V> {
    V get(float f);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Object put(Float f, Object obj) {
        return put(f, (Float) obj);
    }

    @Override // java.util.function.DoubleFunction
    @Deprecated
    default V apply(double operand) {
        return get(SafeMath.safeDoubleToFloat(operand));
    }

    default V put(float key, V value) {
        throw new UnsupportedOperationException();
    }

    default V getOrDefault(float key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default V remove(float key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default V put(Float key, V value) {
        float k = key.floatValue();
        boolean containsKey = containsKey(k);
        V v = put(k, (float) value);
        if (containsKey) {
            return v;
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V get(Object key) {
        if (key == null) {
            return null;
        }
        float k = ((Float) key).floatValue();
        V v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return v;
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V getOrDefault(Object key, V defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        float k = ((Float) key).floatValue();
        V v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V remove(Object key) {
        if (key == null) {
            return null;
        }
        float k = ((Float) key).floatValue();
        if (containsKey(k)) {
            return remove(k);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
    default boolean containsKey(float key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Float) key).floatValue());
    }

    default void defaultReturnValue(V rv) {
        throw new UnsupportedOperationException();
    }

    default V defaultReturnValue() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super T, ? extends java.lang.Float> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.function.Function<V, V>, java.util.function.Function<T, V> */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, V> compose(java.util.function.Function<? super T, ? extends Float> before) {
        return (java.util.function.Function<V, V>) compose(before);
    }

    default Float2ByteFunction andThenByte(Object2ByteFunction<V> after) {
        return k -> {
            return after.getByte(get(after));
        };
    }

    default Byte2ObjectFunction<V> composeByte(Byte2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2ShortFunction andThenShort(Object2ShortFunction<V> after) {
        return k -> {
            return after.getShort(get(after));
        };
    }

    default Short2ObjectFunction<V> composeShort(Short2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2IntFunction andThenInt(Object2IntFunction<V> after) {
        return k -> {
            return after.getInt(get(after));
        };
    }

    default Int2ObjectFunction<V> composeInt(Int2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2LongFunction andThenLong(Object2LongFunction<V> after) {
        return k -> {
            return after.getLong(get(after));
        };
    }

    default Long2ObjectFunction<V> composeLong(Long2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2CharFunction andThenChar(Object2CharFunction<V> after) {
        return k -> {
            return after.getChar(get(after));
        };
    }

    default Char2ObjectFunction<V> composeChar(Char2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2FloatFunction andThenFloat(Object2FloatFunction<V> after) {
        return k -> {
            return after.getFloat(get(after));
        };
    }

    default Float2ObjectFunction<V> composeFloat(Float2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Float2DoubleFunction andThenDouble(Object2DoubleFunction<V> after) {
        return k -> {
            return after.getDouble(get(after));
        };
    }

    default Double2ObjectFunction<V> composeDouble(Double2FloatFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Float2ObjectFunction<T> andThenObject(Object2ObjectFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ObjectFunction<T, V> composeObject(Object2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }

    default <T> Float2ReferenceFunction<T> andThenReference(Object2ReferenceFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ObjectFunction<T, V> composeReference(Reference2FloatFunction<? super T> before) {
        return k -> {
            return get(before.getFloat(before));
        };
    }
}
