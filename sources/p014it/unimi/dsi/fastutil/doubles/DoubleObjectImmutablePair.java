package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleObjectImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleObjectImmutablePair.class */
public class DoubleObjectImmutablePair<V> implements DoubleObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final double left;
    protected final V right;

    public DoubleObjectImmutablePair(double left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> DoubleObjectImmutablePair<V> m881of(double left, V right) {
        return new DoubleObjectImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleObjectPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
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
