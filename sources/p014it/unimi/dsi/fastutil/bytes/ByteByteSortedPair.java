package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteByteSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteByteSortedPair.class */
public interface ByteByteSortedPair extends ByteBytePair, SortedPair<Byte>, Serializable {
    /* renamed from: of */
    static ByteByteSortedPair m1079of(byte left, byte right) {
        return ByteByteImmutableSortedPair.m1082of(left, right);
    }

    default boolean contains(byte e) {
        return e == leftByte() || e == rightByte();
    }

    @Override // p014it.unimi.dsi.fastutil.SortedPair
    @Deprecated
    default boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        return contains(((Byte) o).byteValue());
    }
}
