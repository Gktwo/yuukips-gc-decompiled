package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectFloatPair.class */
public interface ObjectFloatPair<K> extends Pair<K, Float> {
    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default ObjectFloatPair<K> right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectFloatPair<K> right(Float l) {
        return right(l.floatValue());
    }

    default float secondFloat() {
        return rightFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float second() {
        return Float.valueOf(secondFloat());
    }

    default ObjectFloatPair<K> second(float r) {
        return right(r);
    }

    @Deprecated
    default ObjectFloatPair<K> second(Float l) {
        return second(l.floatValue());
    }

    default float valueFloat() {
        return rightFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float value() {
        return Float.valueOf(valueFloat());
    }

    default ObjectFloatPair<K> value(float r) {
        return right(r);
    }

    @Deprecated
    default ObjectFloatPair<K> value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static <K> ObjectFloatPair<K> m564of(K left, float right) {
        return new ObjectFloatImmutablePair(left, right);
    }

    static <K> Comparator<ObjectFloatPair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
