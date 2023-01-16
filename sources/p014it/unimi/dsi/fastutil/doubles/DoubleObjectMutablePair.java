package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleObjectMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleObjectMutablePair.class */
public class DoubleObjectMutablePair<V> implements DoubleObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected double left;
    protected V right;

    public DoubleObjectMutablePair(double left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> DoubleObjectMutablePair<V> m880of(double left, V right) {
        return new DoubleObjectMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleObjectPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleObjectPair
    public DoubleObjectMutablePair<V> left(double l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public DoubleObjectMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleObjectPair ? this.left == ((DoubleObjectPair) other).leftDouble() && Objects.equals(this.right, ((DoubleObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + right() + ">";
    }
}
