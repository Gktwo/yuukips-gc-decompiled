package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteCharMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCharMutablePair.class */
public class ByteCharMutablePair implements ByteCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected byte left;
    protected char right;

    public ByteCharMutablePair(byte left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteCharMutablePair m1077of(byte left, char right) {
        return new ByteCharMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCharPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCharPair
    public ByteCharMutablePair left(byte l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCharPair
    public ByteCharMutablePair right(char r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteCharPair ? this.left == ((ByteCharPair) other).leftByte() && this.right == ((ByteCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + rightChar() + ">";
    }
}
