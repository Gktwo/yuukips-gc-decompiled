package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntReferenceMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntReferenceMutablePair.class */
public class IntReferenceMutablePair<V> implements IntReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected V right;

    public IntReferenceMutablePair(int left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> IntReferenceMutablePair<V> m702of(int left, V right) {
        return new IntReferenceMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntReferencePair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntReferencePair
    public IntReferenceMutablePair<V> left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public IntReferenceMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntReferencePair ? this.left == ((IntReferencePair) other).leftInt() && this.right == ((IntReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + right() + ">";
    }
}
