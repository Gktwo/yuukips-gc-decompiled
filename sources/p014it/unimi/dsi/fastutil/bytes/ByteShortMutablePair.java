package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteShortMutablePair.class */
public class ByteShortMutablePair implements ByteShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected byte left;
    protected short right;

    public ByteShortMutablePair(byte left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteShortMutablePair m1031of(byte left, short right) {
        return new ByteShortMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteShortPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteShortPair
    public ByteShortMutablePair left(byte l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteShortPair
    public ByteShortMutablePair right(short r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteShortPair ? this.left == ((ByteShortPair) other).leftByte() && this.right == ((ByteShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + ((int) rightShort()) + ">";
    }
}
