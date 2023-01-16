package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBytePair.class */
public interface FloatBytePair extends Pair<Float, Byte> {
    float leftFloat();

    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float left() {
        return Float.valueOf(leftFloat());
    }

    default FloatBytePair left(float l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatBytePair left(Float l) {
        return left(l.floatValue());
    }

    default float firstFloat() {
        return leftFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float first() {
        return Float.valueOf(firstFloat());
    }

    default FloatBytePair first(float l) {
        return left(l);
    }

    @Deprecated
    default FloatBytePair first(Float l) {
        return first(l.floatValue());
    }

    default float keyFloat() {
        return firstFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float key() {
        return Float.valueOf(keyFloat());
    }

    default FloatBytePair key(float l) {
        return left(l);
    }

    @Deprecated
    default FloatBytePair key(Float l) {
        return key(l.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default FloatBytePair right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default FloatBytePair right(Byte l) {
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

    default FloatBytePair second(byte r) {
        return right(r);
    }

    @Deprecated
    default FloatBytePair second(Byte l) {
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

    default FloatBytePair value(byte r) {
        return right(r);
    }

    @Deprecated
    default FloatBytePair value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static FloatBytePair m827of(float left, byte right) {
        return new FloatByteImmutablePair(left, right);
    }

    static Comparator<FloatBytePair> lexComparator() {
        return x, y -> {
            int t = Float.compare(x.leftFloat(), y.leftFloat());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
