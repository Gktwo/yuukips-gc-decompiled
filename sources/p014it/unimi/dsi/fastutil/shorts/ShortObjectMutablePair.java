package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortObjectMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortObjectMutablePair.class */
public class ShortObjectMutablePair<V> implements ShortObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected short left;
    protected V right;

    public ShortObjectMutablePair(short left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> ShortObjectMutablePair<V> m404of(short left, V right) {
        return new ShortObjectMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortObjectPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortObjectPair
    public ShortObjectMutablePair<V> left(short l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ShortObjectMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortObjectPair ? this.left == ((ShortObjectPair) other).leftShort() && Objects.equals(this.right, ((ShortObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + right() + ">";
    }
}
