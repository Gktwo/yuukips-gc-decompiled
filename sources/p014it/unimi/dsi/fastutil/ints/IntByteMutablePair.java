package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntByteMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntByteMutablePair.class */
public class IntByteMutablePair implements IntBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected byte right;

    public IntByteMutablePair(int left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntByteMutablePair m744of(int left, byte right) {
        return new IntByteMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBytePair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBytePair
    public IntByteMutablePair left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBytePair
    public IntByteMutablePair right(byte r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntBytePair ? this.left == ((IntBytePair) other).leftInt() && this.right == ((IntBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + ((int) rightByte()) + ">";
    }
}
