package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCharPair.class */
public interface ShortCharPair extends Pair<Short, Character> {
    short leftShort();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short left() {
        return Short.valueOf(leftShort());
    }

    default ShortCharPair left(short l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortCharPair left(Short l) {
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

    default ShortCharPair first(short l) {
        return left(l);
    }

    @Deprecated
    default ShortCharPair first(Short l) {
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

    default ShortCharPair key(short l) {
        return left(l);
    }

    @Deprecated
    default ShortCharPair key(Short l) {
        return key(l.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default ShortCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ShortCharPair right(Character l) {
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

    default ShortCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default ShortCharPair second(Character l) {
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

    default ShortCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default ShortCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static ShortCharPair m430of(short left, char right) {
        return new ShortCharImmutablePair(left, right);
    }

    static Comparator<ShortCharPair> lexComparator() {
        return x, y -> {
            int t = Short.compare(x.leftShort(), y.leftShort());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
