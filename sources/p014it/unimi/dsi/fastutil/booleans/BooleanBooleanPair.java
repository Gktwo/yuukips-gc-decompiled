package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBooleanPair.class */
public interface BooleanBooleanPair extends Pair<Boolean, Boolean> {
    boolean leftBoolean();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanBooleanPair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanBooleanPair left(Boolean l) {
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

    default BooleanBooleanPair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanBooleanPair first(Boolean l) {
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

    default BooleanBooleanPair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanBooleanPair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default BooleanBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanBooleanPair right(Boolean l) {
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

    default BooleanBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default BooleanBooleanPair second(Boolean l) {
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

    default BooleanBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default BooleanBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static BooleanBooleanPair m1160of(boolean left, boolean right) {
        return new BooleanBooleanImmutablePair(left, right);
    }

    static Comparator<BooleanBooleanPair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
