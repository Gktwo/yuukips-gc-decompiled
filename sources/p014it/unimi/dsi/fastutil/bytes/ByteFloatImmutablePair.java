package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteFloatImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteFloatImmutablePair.class */
public class ByteFloatImmutablePair implements ByteFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final byte left;
    protected final float right;

    public ByteFloatImmutablePair(byte left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteFloatImmutablePair m1072of(byte left, float right) {
        return new ByteFloatImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteFloatPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteFloatPair ? this.left == ((ByteFloatPair) other).leftByte() && this.right == ((ByteFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + rightFloat() + ">";
    }
}
