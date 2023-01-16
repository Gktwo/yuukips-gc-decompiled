package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteLongPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLongPair.class */
public interface ByteLongPair extends Pair<Byte, Long> {
    byte leftByte();

    long rightLong();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteLongPair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteLongPair left(Byte l) {
        return left(l.byteValue());
    }

    default byte firstByte() {
        return leftByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte first() {
        return Byte.valueOf(firstByte());
    }

    default ByteLongPair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteLongPair first(Byte l) {
        return first(l.byteValue());
    }

    default byte keyByte() {
        return firstByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte key() {
        return Byte.valueOf(keyByte());
    }

    default ByteLongPair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteLongPair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long right() {
        return Long.valueOf(rightLong());
    }

    default ByteLongPair right(long r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteLongPair right(Long l) {
        return right(l.longValue());
    }

    default long secondLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long second() {
        return Long.valueOf(secondLong());
    }

    default ByteLongPair second(long r) {
        return right(r);
    }

    @Deprecated
    default ByteLongPair second(Long l) {
        return second(l.longValue());
    }

    default long valueLong() {
        return rightLong();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long value() {
        return Long.valueOf(valueLong());
    }

    default ByteLongPair value(long r) {
        return right(r);
    }

    @Deprecated
    default ByteLongPair value(Long l) {
        return value(l.longValue());
    }

    /* renamed from: of */
    static ByteLongPair m1052of(byte left, long right) {
        return new ByteLongImmutablePair(left, right);
    }

    static Comparator<ByteLongPair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Long.compare(x.rightLong(), y.rightLong());
        };
    }
}
