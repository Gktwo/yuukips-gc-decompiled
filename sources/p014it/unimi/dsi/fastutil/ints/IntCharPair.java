package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCharPair.class */
public interface IntCharPair extends Pair<Integer, Character> {
    int leftInt();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntCharPair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntCharPair left(Integer l) {
        return left(l.intValue());
    }

    default int firstInt() {
        return leftInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer first() {
        return Integer.valueOf(firstInt());
    }

    default IntCharPair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntCharPair first(Integer l) {
        return first(l.intValue());
    }

    default int keyInt() {
        return firstInt();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer key() {
        return Integer.valueOf(keyInt());
    }

    default IntCharPair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntCharPair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default IntCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntCharPair right(Character l) {
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

    default IntCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default IntCharPair second(Character l) {
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

    default IntCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default IntCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static IntCharPair m740of(int left, char right) {
        return new IntCharImmutablePair(left, right);
    }

    static Comparator<IntCharPair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
