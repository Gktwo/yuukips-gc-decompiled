package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleShortImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleShortImmutablePair.class */
public class DoubleShortImmutablePair implements DoubleShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final double left;
    protected final short right;

    public DoubleShortImmutablePair(double left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleShortImmutablePair m863of(double left, short right) {
        return new DoubleShortImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleShortPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleShortPair ? this.left == ((DoubleShortPair) other).leftDouble() && this.right == ((DoubleShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + ((int) rightShort()) + ">";
    }
}
