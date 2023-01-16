package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteFloatPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteFloatPair.class */
public interface ByteFloatPair extends Pair<Byte, Float> {
    byte leftByte();

    float rightFloat();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteFloatPair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteFloatPair left(Byte l) {
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

    default ByteFloatPair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteFloatPair first(Byte l) {
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

    default ByteFloatPair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteFloatPair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Float right() {
        return Float.valueOf(rightFloat());
    }

    default ByteFloatPair right(float r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteFloatPair right(Float l) {
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

    default ByteFloatPair second(float r) {
        return right(r);
    }

    @Deprecated
    default ByteFloatPair second(Float l) {
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

    default ByteFloatPair value(float r) {
        return right(r);
    }

    @Deprecated
    default ByteFloatPair value(Float l) {
        return value(l.floatValue());
    }

    /* renamed from: of */
    static ByteFloatPair m1070of(byte left, float right) {
        return new ByteFloatImmutablePair(left, right);
    }

    static Comparator<ByteFloatPair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Float.compare(x.rightFloat(), y.rightFloat());
        };
    }
}
