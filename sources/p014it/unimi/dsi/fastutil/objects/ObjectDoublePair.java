package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectDoublePair.class */
public interface ObjectDoublePair<K> extends Pair<K, Double> {
    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default ObjectDoublePair<K> right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectDoublePair<K> right(Double l) {
        return right(l.doubleValue());
    }

    default double secondDouble() {
        return rightDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double second() {
        return Double.valueOf(secondDouble());
    }

    default ObjectDoublePair<K> second(double r) {
        return right(r);
    }

    @Deprecated
    default ObjectDoublePair<K> second(Double l) {
        return second(l.doubleValue());
    }

    default double valueDouble() {
        return rightDouble();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double value() {
        return Double.valueOf(valueDouble());
    }

    default ObjectDoublePair<K> value(double r) {
        return right(r);
    }

    @Deprecated
    default ObjectDoublePair<K> value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static <K> ObjectDoublePair<K> m567of(K left, double right) {
        return new ObjectDoubleImmutablePair(left, right);
    }

    static <K> Comparator<ObjectDoublePair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
