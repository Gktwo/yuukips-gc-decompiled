package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortObjectPair.class */
public interface ShortObjectPair<V> extends Pair<Short, V> {
    short leftShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortObjectPair<V> left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortObjectPair<V> left(Short l) {
        return left(l.shortValue());
    }

    default short firstShort() {
        return leftShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short first() {
        return Short.valueOf(firstShort());
    }

    default ShortObjectPair<V> first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortObjectPair<V> first(Short l) {
        return first(l.shortValue());
    }

    default short keyShort() {
        return firstShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short key() {
        return Short.valueOf(keyShort());
    }

    default ShortObjectPair<V> key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortObjectPair<V> key(Short l) {
        return key(l.shortValue());
    }

    /* renamed from: of */
    static <V> ShortObjectPair<V> m403of(short left, V right) {
        return new ShortObjectImmutablePair(left, right);
    }

    static <V> Comparator<ShortObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
