package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatCharPair.class */
public interface FloatCharPair extends Pair<Float, Character> {
    float leftFloat();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatCharPair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatCharPair left(Float l) {
        return left(l.floatValue());
    }

    default float firstFloat() {
        return leftFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float first() {
        return Float.valueOf(firstFloat());
    }

    default FloatCharPair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatCharPair first(Float l) {
        return first(l.floatValue());
    }

    default float keyFloat() {
        return firstFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float key() {
        return Float.valueOf(keyFloat());
    }

    default FloatCharPair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatCharPair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default FloatCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatCharPair right(Character l) {
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

    default FloatCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default FloatCharPair second(Character l) {
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

    default FloatCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default FloatCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static FloatCharPair m824of(float left, char right) {
        return new FloatCharImmutablePair(left, right);
    }

    static Comparator<FloatCharPair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
