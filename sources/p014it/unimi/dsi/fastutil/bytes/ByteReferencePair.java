package p014it.unimi.dsi.fastutil.bytes;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteReferencePair.class */
public interface ByteReferencePair<V> extends Pair<Byte, V> {
    byte leftByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteReferencePair<V> left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteReferencePair<V> left(Byte l) {
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

    default ByteReferencePair<V> first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteReferencePair<V> first(Byte l) {
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

    default ByteReferencePair<V> key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteReferencePair<V> key(Byte l) {
        return key(l.byteValue());
    }

    /* renamed from: of */
    static <V> ByteReferencePair<V> m1039of(byte left, V right) {
        return new ByteReferenceImmutablePair(left, right);
    }
}
