package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntObjectPair.class */
public interface IntObjectPair<V> extends Pair<Integer, V> {
    int leftInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntObjectPair<V> left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntObjectPair<V> left(Integer l) {
        return left(l.intValue());
    }

    default int firstInt() {
        return leftInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer first() {
        return Integer.valueOf(firstInt());
    }

    default IntObjectPair<V> first(int l) {
        return left(l);
    }

    @Deprecated
    default IntObjectPair<V> first(Integer l) {
        return first(l.intValue());
    }

    default int keyInt() {
        return firstInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer key() {
        return Integer.valueOf(keyInt());
    }

    default IntObjectPair<V> key(int l) {
        return left(l);
    }

    @Deprecated
    default IntObjectPair<V> key(Integer l) {
        return key(l.intValue());
    }

    /* renamed from: of */
    static <V> IntObjectPair<V> m711of(int left, V right) {
        return new IntObjectImmutablePair(left, right);
    }

    static <V> Comparator<IntObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
