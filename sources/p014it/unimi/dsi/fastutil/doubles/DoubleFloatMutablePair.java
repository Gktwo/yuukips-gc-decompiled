package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleFloatMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleFloatMutablePair.class */
public class DoubleFloatMutablePair implements DoubleFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected double left;
    protected float right;

    public DoubleFloatMutablePair(double left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleFloatMutablePair m901of(double left, float right) {
        return new DoubleFloatMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleFloatPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleFloatPair
    public DoubleFloatMutablePair left(double l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleFloatPair
    public DoubleFloatMutablePair right(float r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleFloatPair ? this.left == ((DoubleFloatPair) other).leftDouble() && this.right == ((DoubleFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + rightFloat() + ">";
    }
}
