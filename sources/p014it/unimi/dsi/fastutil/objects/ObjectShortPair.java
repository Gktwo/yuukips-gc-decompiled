package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectShortPair.class */
public interface ObjectShortPair<K> extends Pair<K, Short> {
    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default ObjectShortPair<K> right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectShortPair<K> right(Short l) {
        return right(l.shortValue());
    }

    default short secondShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short second() {
        return Short.valueOf(secondShort());
    }

    default ObjectShortPair<K> second(short r) {
        return right(r);
    }

    @Deprecated
    default ObjectShortPair<K> second(Short l) {
        return second(l.shortValue());
    }

    default short valueShort() {
        return rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short value() {
        return Short.valueOf(valueShort());
    }

    default ObjectShortPair<K> value(short r) {
        return right(r);
    }

    @Deprecated
    default ObjectShortPair<K> value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static <K> ObjectShortPair<K> m526of(K left, short right) {
        return new ObjectShortImmutablePair(left, right);
    }

    static <K> Comparator<ObjectShortPair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
