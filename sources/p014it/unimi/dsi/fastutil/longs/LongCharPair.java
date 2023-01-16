package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongCharPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCharPair.class */
public interface LongCharPair extends Pair<Long, Character> {
    long leftLong();

    char rightChar();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongCharPair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongCharPair left(Long l) {
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

    default LongCharPair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongCharPair first(Long l) {
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

    default LongCharPair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongCharPair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Character right() {
        return Character.valueOf(rightChar());
    }

    default LongCharPair right(char r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongCharPair right(Character l) {
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

    default LongCharPair second(char r) {
        return right(r);
    }

    @Deprecated
    default LongCharPair second(Character l) {
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

    default LongCharPair value(char r) {
        return right(r);
    }

    @Deprecated
    default LongCharPair value(Character l) {
        return value(l.charValue());
    }

    /* renamed from: of */
    static LongCharPair m655of(long left, char right) {
        return new LongCharImmutablePair(left, right);
    }

    static Comparator<LongCharPair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Character.compare(x.rightChar(), y.rightChar());
        };
    }
}
