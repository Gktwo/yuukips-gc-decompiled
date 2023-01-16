package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteDoubleImmutablePair.class */
public class ByteDoubleImmutablePair implements ByteDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final byte left;
    protected final double right;

    public ByteDoubleImmutablePair(byte left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteDoubleImmutablePair m1075of(byte left, double right) {
        return new ByteDoubleImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteDoublePair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteDoublePair ? this.left == ((ByteDoublePair) other).leftByte() && this.right == ((ByteDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + rightDouble() + ">";
    }
}
