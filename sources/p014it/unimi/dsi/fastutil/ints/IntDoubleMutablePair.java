package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntDoubleMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntDoubleMutablePair.class */
public class IntDoubleMutablePair implements IntDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected double right;

    public IntDoubleMutablePair(int left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntDoubleMutablePair m738of(int left, double right) {
        return new IntDoubleMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntDoublePair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntDoublePair
    public IntDoubleMutablePair left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntDoublePair
    public IntDoubleMutablePair right(double r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntDoublePair ? this.left == ((IntDoublePair) other).leftInt() && this.right == ((IntDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + rightDouble() + ">";
    }
}
