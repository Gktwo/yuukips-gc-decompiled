package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteByteImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteByteImmutableSortedPair.class */
public class ByteByteImmutableSortedPair extends ByteByteImmutablePair implements ByteByteSortedPair, Serializable {
    private static final long serialVersionUID = 0;

    private ByteByteImmutableSortedPair(byte left, byte right) {
        super(left, right);
    }

    /* renamed from: of */
    public static ByteByteImmutableSortedPair m1082of(byte left, byte right) {
        return left <= right ? new ByteByteImmutableSortedPair(left, right) : new ByteByteImmutableSortedPair(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteByteImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteByteSortedPair ? this.left == ((ByteByteSortedPair) other).leftByte() && this.right == ((ByteByteSortedPair) other).rightByte() : (other instanceof SortedPair) && Objects.equals(Byte.valueOf(this.left), ((SortedPair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteByteImmutablePair, java.lang.Object
    public String toString() {
        return "{" + ((int) leftByte()) + "," + ((int) rightByte()) + "}";
    }
}
