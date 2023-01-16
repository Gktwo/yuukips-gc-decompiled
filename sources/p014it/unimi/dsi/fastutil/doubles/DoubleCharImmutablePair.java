package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleCharImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleCharImmutablePair.class */
public class DoubleCharImmutablePair implements DoubleCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final double left;
    protected final char right;

    public DoubleCharImmutablePair(double left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleCharImmutablePair m910of(double left, char right) {
        return new DoubleCharImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCharPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleCharPair ? this.left == ((DoubleCharPair) other).leftDouble() && this.right == ((DoubleCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + rightChar() + ">";
    }
}
