package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntDoubleImmutablePair.class */
public class IntDoubleImmutablePair implements IntDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final int left;
    protected final double right;

    public IntDoubleImmutablePair(int left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntDoubleImmutablePair m739of(int left, double right) {
        return new IntDoubleImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntDoublePair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntDoublePair
    public double rightDouble() {
        return this.right;
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
