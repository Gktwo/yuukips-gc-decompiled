package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBooleanPair.class */
public interface ObjectBooleanPair<K> extends Pair<K, Boolean> {
    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default ObjectBooleanPair<K> right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectBooleanPair<K> right(Boolean l) {
        return right(l.booleanValue());
    }

    default boolean secondBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean second() {
        return Boolean.valueOf(secondBoolean());
    }

    default ObjectBooleanPair<K> second(boolean r) {
        return right(r);
    }

    @Deprecated
    default ObjectBooleanPair<K> second(Boolean l) {
        return second(l.booleanValue());
    }

    default boolean valueBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean value() {
        return Boolean.valueOf(valueBoolean());
    }

    default ObjectBooleanPair<K> value(boolean r) {
        return right(r);
    }

    @Deprecated
    default ObjectBooleanPair<K> value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static <K> ObjectBooleanPair<K> m576of(K left, boolean right) {
        return new ObjectBooleanImmutablePair(left, right);
    }

    static <K> Comparator<ObjectBooleanPair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
