package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBytePair.class */
public interface LongBytePair extends Pair<Long, Byte> {
    long leftLong();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Long left() {
        return Long.valueOf(leftLong());
    }

    default LongBytePair left(long l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongBytePair left(Long l) {
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

    default LongBytePair first(long l) {
        return left(l);
    }

    @Deprecated
    default LongBytePair first(Long l) {
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

    default LongBytePair key(long l) {
        return left(l);
    }

    @Deprecated
    default LongBytePair key(Long l) {
        return key(l.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default LongBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default LongBytePair right(Byte l) {
        return right(l.byteValue());
    }

    default byte secondByte() {
        return rightByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte second() {
        return Byte.valueOf(secondByte());
    }

    default LongBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default LongBytePair second(Byte l) {
        return second(l.byteValue());
    }

    default byte valueByte() {
        return rightByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte value() {
        return Byte.valueOf(valueByte());
    }

    default LongBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default LongBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static LongBytePair m658of(long left, byte right) {
        return new LongByteImmutablePair(left, right);
    }

    static Comparator<LongBytePair> lexComparator() {
        return x, y -> {
            int t = Long.compare(x.leftLong(), y.leftLong());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
