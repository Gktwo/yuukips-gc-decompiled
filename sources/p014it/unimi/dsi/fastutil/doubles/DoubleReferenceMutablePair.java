package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleReferenceMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleReferenceMutablePair.class */
public class DoubleReferenceMutablePair<V> implements DoubleReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected double left;
    protected V right;

    public DoubleReferenceMutablePair(double left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> DoubleReferenceMutablePair<V> m870of(double left, V right) {
        return new DoubleReferenceMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleReferencePair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleReferencePair
    public DoubleReferenceMutablePair<V> left(double l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public DoubleReferenceMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleReferencePair ? this.left == ((DoubleReferencePair) other).leftDouble() && this.right == ((DoubleReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + right() + ">";
    }
}
