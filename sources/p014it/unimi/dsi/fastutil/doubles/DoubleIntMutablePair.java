package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIntMutablePair.class */
public class DoubleIntMutablePair implements DoubleIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected double left;
    protected int right;

    public DoubleIntMutablePair(double left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleIntMutablePair m896of(double left, int right) {
        return new DoubleIntMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIntPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIntPair
    public DoubleIntMutablePair left(double l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIntPair
    public DoubleIntMutablePair right(int r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleIntPair ? this.left == ((DoubleIntPair) other).leftDouble() && this.right == ((DoubleIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + rightInt() + ">";
    }
}
