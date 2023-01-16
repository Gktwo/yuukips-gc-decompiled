package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanObjectPair.class */
public interface BooleanObjectPair<V> extends Pair<Boolean, V> {
    boolean leftBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanObjectPair<V> left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanObjectPair<V> left(Boolean l) {
        return left(l.booleanValue());
    }

    default boolean firstBoolean() {
        return leftBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean first() {
        return Boolean.valueOf(firstBoolean());
    }

    default BooleanObjectPair<V> first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanObjectPair<V> first(Boolean l) {
        return first(l.booleanValue());
    }

    default boolean keyBoolean() {
        return firstBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean key() {
        return Boolean.valueOf(keyBoolean());
    }

    default BooleanObjectPair<V> key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanObjectPair<V> key(Boolean l) {
        return key(l.booleanValue());
    }

    /* renamed from: of */
    static <V> BooleanObjectPair<V> m1132of(boolean left, V right) {
        return new BooleanObjectImmutablePair(left, right);
    }

    static <V> Comparator<BooleanObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
