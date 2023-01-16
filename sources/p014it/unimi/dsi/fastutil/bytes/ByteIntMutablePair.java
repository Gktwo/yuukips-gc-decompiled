package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIntMutablePair.class */
public class ByteIntMutablePair implements ByteIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected byte left;
    protected int right;

    public ByteIntMutablePair(byte left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteIntMutablePair m1066of(byte left, int right) {
        return new ByteIntMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIntPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIntPair
    public ByteIntMutablePair left(byte l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIntPair
    public ByteIntMutablePair right(int r) {
        this.right = r;
        return this;
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
