package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIntImmutablePair.class */
public class DoubleIntImmutablePair implements DoubleIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final double left;
    protected final int right;

    public DoubleIntImmutablePair(double left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleIntImmutablePair m897of(double left, int right) {
        return new DoubleIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIntPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIntPair
    public int rightInt() {
        return this.right;
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
