package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleByteMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleByteMutablePair.class */
public class DoubleByteMutablePair implements DoubleBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected double left;
    protected byte right;

    public DoubleByteMutablePair(double left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleByteMutablePair m912of(double left, byte right) {
        return new DoubleByteMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBytePair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBytePair
    public DoubleByteMutablePair left(double l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBytePair
    public DoubleByteMutablePair right(byte r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleBytePair ? this.left == ((DoubleBytePair) other).leftDouble() && this.right == ((DoubleBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + ((int) rightByte()) + ">";
    }
}
