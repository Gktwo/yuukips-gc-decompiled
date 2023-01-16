package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongFloatPair.class */
public interface LongFloatPair extends Pair<Long, Float> {
    long leftLong();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongFloatPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongFloatPair left(Long l) {
        return left(l.longValue());
    }

    default long firstLong() {
        return leftLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long first() {
        return Long.valueOf(firstLong());
    }

    default LongFloatPair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongFloatPair first(Long l) {
        return first(l.longValue());
    }

    default long keyLong() {
        return firstLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long key() {
        return Long.valueOf(keyLong());
    }

    default LongFloatPair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongFloatPair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default LongFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongFloatPair right(Float l) {
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

    default LongFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default LongFloatPair second(Float l) {
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

    default LongFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default LongFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static LongFloatPair m649of(long left, float right) {
        return new LongFloatImmutablePair(left, right);
    }

    static Comparator<LongFloatPair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
