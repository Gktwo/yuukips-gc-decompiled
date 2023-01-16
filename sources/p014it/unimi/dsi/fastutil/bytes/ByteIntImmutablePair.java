package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIntImmutablePair.class */
public class ByteIntImmutablePair implements ByteIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final byte left;
    protected final int right;

    public ByteIntImmutablePair(byte left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteIntImmutablePair m1067of(byte left, int right) {
        return new ByteIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIntPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteIntPair ? this.left == ((ByteIntPair) other).leftByte() && this.right == ((ByteIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + rightInt() + ">";
    }
}
