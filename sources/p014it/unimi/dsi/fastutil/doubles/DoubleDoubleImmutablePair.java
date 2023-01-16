package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleDoubleImmutablePair.class */
public class DoubleDoubleImmutablePair implements DoubleDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final double left;
    protected final double right;

    public DoubleDoubleImmutablePair(double left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleDoubleImmutablePair m907of(double left, double right) {
        return new DoubleDoubleImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleDoublePair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleDoublePair ? this.left == ((DoubleDoublePair) other).leftDouble() && this.right == ((DoubleDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + rightDouble() + ">";
    }
}
