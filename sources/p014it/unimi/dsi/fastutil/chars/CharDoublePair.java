package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharDoublePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharDoublePair.class */
public interface CharDoublePair extends Pair<Character, Double> {
    char leftChar();

    double rightDouble();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character left() {
        return Character.valueOf(leftChar());
    }

    default CharDoublePair left(char l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharDoublePair left(Character l) {
        return left(l.charValue());
    }

    default char firstChar() {
        return leftChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character first() {
        return Character.valueOf(firstChar());
    }

    default CharDoublePair first(char l) {
        return left(l);
    }

    @Deprecated
    default CharDoublePair first(Character l) {
        return first(l.charValue());
    }

    default char keyChar() {
        return firstChar();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character key() {
        return Character.valueOf(keyChar());
    }

    default CharDoublePair key(char l) {
        return left(l);
    }

    @Deprecated
    default CharDoublePair key(Character l) {
        return key(l.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Double right() {
        return Double.valueOf(rightDouble());
    }

    default CharDoublePair right(double r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default CharDoublePair right(Double l) {
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

    default CharDoublePair second(double r) {
        return right(r);
    }

    @Deprecated
    default CharDoublePair second(Double l) {
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

    default CharDoublePair value(double r) {
        return right(r);
    }

    @Deprecated
    default CharDoublePair value(Double l) {
        return value(l.doubleValue());
    }

    /* renamed from: of */
    static CharDoublePair m988of(char left, double right) {
        return new CharDoubleImmutablePair(left, right);
    }

    static Comparator<CharDoublePair> lexComparator() {
        return x, y -> {
            int t = Character.compare(x.leftChar(), y.leftChar());
            return t != 0 ? t : Double.compare(x.rightDouble(), y.rightDouble());
        };
    }
}
