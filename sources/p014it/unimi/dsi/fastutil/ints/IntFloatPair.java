package p014it.unimi.dsi.fastutil.ints;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntFloatPair.class */
public interface IntFloatPair extends Pair<Integer, Float> {
    int leftInt();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Integer left() {
        return Integer.valueOf(leftInt());
    }

    default IntFloatPair left(int l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntFloatPair left(Integer l) {
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

    default IntFloatPair first(int l) {
        return left(l);
    }

    @Deprecated
    default IntFloatPair first(Integer l) {
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

    default IntFloatPair key(int l) {
        return left(l);
    }

    @Deprecated
    default IntFloatPair key(Integer l) {
        return key(l.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default IntFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default IntFloatPair right(Float l) {
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

    default IntFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default IntFloatPair second(Float l) {
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

    default IntFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default IntFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static IntFloatPair m734of(int left, float right) {
        return new IntFloatImmutablePair(left, right);
    }

    static Comparator<IntFloatPair> lexComparator() {
        return x, y -> {
            int t = Integer.compare(x.leftInt(), y.leftInt());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
