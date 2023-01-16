package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectIntPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIntPair.class */
public interface ObjectIntPair<K> extends Pair<K, Integer> {
    int rightInt();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer right() {
        return Integer.valueOf(rightInt());
    }

    default ObjectIntPair<K> right(int r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectIntPair<K> right(Integer l) {
        return right(l.intValue());
    }

    default int secondInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer second() {
        return Integer.valueOf(secondInt());
    }

    default ObjectIntPair<K> second(int r) {
        return right(r);
    }

    @Deprecated
    default ObjectIntPair<K> second(Integer l) {
        return second(l.intValue());
    }

    default int valueInt() {
        return rightInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer value() {
        return Integer.valueOf(valueInt());
    }

    default ObjectIntPair<K> value(int r) {
        return right(r);
    }

    @Deprecated
    default ObjectIntPair<K> value(Integer l) {
        return value(l.intValue());
    }

    /* renamed from: of */
    static <K> ObjectIntPair<K> m559of(K left, int right) {
        return new ObjectIntImmutablePair(left, right);
    }

    static <K> Comparator<ObjectIntPair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Integer.compare(x.rightInt(), y.rightInt());
        };
    }
}
