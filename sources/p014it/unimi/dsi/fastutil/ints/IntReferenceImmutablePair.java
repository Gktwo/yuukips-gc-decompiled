package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntReferenceImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntReferenceImmutablePair.class */
public class IntReferenceImmutablePair<V> implements IntReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final int left;
    protected final V right;

    public IntReferenceImmutablePair(int left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> IntReferenceImmutablePair<V> m703of(int left, V right) {
        return new IntReferenceImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntReferencePair
    public int leftInt() {
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
