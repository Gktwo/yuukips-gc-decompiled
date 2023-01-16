package p014it.unimi.dsi.fastutil.booleans;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBytePair.class */
public interface BooleanBytePair extends Pair<Boolean, Byte> {
    boolean leftBoolean();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean left() {
        return Boolean.valueOf(leftBoolean());
    }

    default BooleanBytePair left(boolean l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanBytePair left(Boolean l) {
        return left(l.booleanValue());
    }

    default boolean firstBoolean() {
        return leftBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean first() {
        return Boolean.valueOf(firstBoolean());
    }

    default BooleanBytePair first(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanBytePair first(Boolean l) {
        return first(l.booleanValue());
    }

    default boolean keyBoolean() {
        return firstBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean key() {
        return Boolean.valueOf(keyBoolean());
    }

    default BooleanBytePair key(boolean l) {
        return left(l);
    }

    @Deprecated
    default BooleanBytePair key(Boolean l) {
        return key(l.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default BooleanBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default BooleanBytePair right(Byte l) {
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

    default BooleanBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default BooleanBytePair second(Byte l) {
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

    default BooleanBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default BooleanBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static BooleanBytePair m1157of(boolean left, byte right) {
        return new BooleanByteImmutablePair(left, right);
    }

    static Comparator<BooleanBytePair> lexComparator() {
        return x, y -> {
            int t = Boolean.compare(x.leftBoolean(), y.leftBoolean());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
