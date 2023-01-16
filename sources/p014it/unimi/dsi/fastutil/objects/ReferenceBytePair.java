package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceBytePair.class */
public interface ReferenceBytePair<K> extends Pair<K, Byte> {
    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default ReferenceBytePair<K> right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ReferenceBytePair<K> right(Byte l) {
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

    default ReferenceBytePair<K> second(byte r) {
        return right(r);
    }

    @Deprecated
    default ReferenceBytePair<K> second(Byte l) {
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

    default ReferenceBytePair<K> value(byte r) {
        return right(r);
    }

    @Deprecated
    default ReferenceBytePair<K> value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static <K> ReferenceBytePair<K> m513of(K left, byte right) {
        return new ReferenceByteImmutablePair(left, right);
    }
}
