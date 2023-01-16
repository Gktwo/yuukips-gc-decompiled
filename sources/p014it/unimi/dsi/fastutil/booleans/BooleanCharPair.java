package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanCharPair.class */
public interface BooleanCharPair extends Pair<Boolean, Character> {
    boolean leftBoolean();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanCharPair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanCharPair left(Boolean l) {
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

    default BooleanCharPair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanCharPair first(Boolean l) {
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

    default BooleanCharPair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanCharPair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default BooleanCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanCharPair right(Character l) {
        return right(l.charValue());
    }

    default char secondChar() {
        return rightChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character second() {
        return Character.valueOf(secondChar());
    }

    default BooleanCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default BooleanCharPair second(Character l) {
        return second(l.charValue());
    }

    default char valueChar() {
        return rightChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character value() {
        return Character.valueOf(valueChar());
    }

    default BooleanCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default BooleanCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static BooleanCharPair m1154of(boolean left, char right) {
        return new BooleanCharImmutablePair(left, right);
    }

    static Comparator<BooleanCharPair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
