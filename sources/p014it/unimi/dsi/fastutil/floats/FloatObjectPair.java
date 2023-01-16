package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatObjectPair.class */
public interface FloatObjectPair<V> extends Pair<Float, V> {
    float leftFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatObjectPair<V> left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatObjectPair<V> left(Float l) {
        return left(l.floatValue());
    }

    default float firstFloat() {
        return leftFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float first() {
        return Float.valueOf(firstFloat());
    }

    default FloatObjectPair<V> first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatObjectPair<V> first(Float l) {
        return first(l.floatValue());
    }

    default float keyFloat() {
        return firstFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float key() {
        return Float.valueOf(keyFloat());
    }

    default FloatObjectPair<V> key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatObjectPair<V> key(Float l) {
        return key(l.floatValue());
    }

    /* renamed from: of */
    static <V> FloatObjectPair<V> m795of(float left, V right) {
        return new FloatObjectImmutablePair(left, right);
    }

    static <V> Comparator<FloatObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
