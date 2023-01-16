package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntShortPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntShortPair.class */
public interface IntShortPair extends Pair<Integer, Short> {
    int leftInt();

    short rightShort();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntShortPair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntShortPair left(Integer l) {
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

    default IntShortPair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntShortPair first(Integer l) {
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

    default IntShortPair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntShortPair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Short right() {
        return Short.valueOf(rightShort());
    }

    default IntShortPair right(short r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntShortPair right(Short l) {
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

    default IntShortPair second(short r) {
        return right(r);
    }

    @Deprecated
    default IntShortPair second(Short l) {
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

    default IntShortPair value(short r) {
        return right(r);
    }

    @Deprecated
    default IntShortPair value(Short l) {
        return value(l.shortValue());
    }

    /* renamed from: of */
    static IntShortPair m692of(int left, short right) {
        return new IntShortImmutablePair(left, right);
    }

    static Comparator<IntShortPair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Short.compare(x.rightShort(), y.rightShort());
        };
    }
}
