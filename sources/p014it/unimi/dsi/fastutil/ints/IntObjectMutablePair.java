package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntObjectMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntObjectMutablePair.class */
public class IntObjectMutablePair<V> implements IntObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected V right;

    public IntObjectMutablePair(int left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> IntObjectMutablePair<V> m712of(int left, V right) {
        return new IntObjectMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntObjectPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntObjectPair
    public IntObjectMutablePair<V> left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public IntObjectMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntObjectPair ? this.left == ((IntObjectPair) other).leftInt() && Objects.equals(this.right, ((IntObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + right() + ">";
    }
}
