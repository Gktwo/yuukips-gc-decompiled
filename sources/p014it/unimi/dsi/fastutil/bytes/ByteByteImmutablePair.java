package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteByteImmutablePair.class */
public class ByteByteImmutablePair implements ByteBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final byte left;
    protected final byte right;

    public ByteByteImmutablePair(byte left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteByteImmutablePair m1083of(byte left, byte right) {
        return new ByteByteImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBytePair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteBytePair ? this.left == ((ByteBytePair) other).leftByte() && this.right == ((ByteBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + ((int) rightByte()) + ">";
    }
}
