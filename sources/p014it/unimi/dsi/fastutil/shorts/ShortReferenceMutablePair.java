package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortReferenceMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortReferenceMutablePair.class */
public class ShortReferenceMutablePair<V> implements ShortReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected short left;
    protected V right;

    public ShortReferenceMutablePair(short left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> ShortReferenceMutablePair<V> m394of(short left, V right) {
        return new ShortReferenceMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortReferencePair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortReferencePair
    public ShortReferenceMutablePair<V> left(short l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ShortReferenceMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortReferencePair ? this.left == ((ShortReferencePair) other).leftShort() && this.right == ((ShortReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + right() + ">";
    }
}
