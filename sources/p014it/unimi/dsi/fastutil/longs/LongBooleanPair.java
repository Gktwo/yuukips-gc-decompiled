package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBooleanPair.class */
public interface LongBooleanPair extends Pair<Long, Boolean> {
    long leftLong();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongBooleanPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongBooleanPair left(Long l) {
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

    default LongBooleanPair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongBooleanPair first(Long l) {
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

    default LongBooleanPair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongBooleanPair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default LongBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongBooleanPair right(Boolean l) {
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

    default LongBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default LongBooleanPair second(Boolean l) {
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

    default LongBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default LongBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static LongBooleanPair m661of(long left, boolean right) {
        return new LongBooleanImmutablePair(left, right);
    }

    static Comparator<LongBooleanPair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
