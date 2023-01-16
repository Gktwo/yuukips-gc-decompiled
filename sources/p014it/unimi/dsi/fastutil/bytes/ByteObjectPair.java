package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteObjectPair.class */
public interface ByteObjectPair<V> extends Pair<Byte, V> {
    byte leftByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteObjectPair<V> left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteObjectPair<V> left(Byte l) {
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

    default ByteObjectPair<V> first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteObjectPair<V> first(Byte l) {
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

    default ByteObjectPair<V> key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteObjectPair<V> key(Byte l) {
        return key(l.byteValue());
    }

    /* renamed from: of */
    static <V> ByteObjectPair<V> m1049of(byte left, V right) {
        return new ByteObjectImmutablePair(left, right);
    }

    static <V> Comparator<ByteObjectPair<V>> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : ((Comparable) x.right()).compareTo(y.right());
        };
    }
}
