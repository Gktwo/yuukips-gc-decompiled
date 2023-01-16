package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortObjectImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortObjectImmutablePair.class */
public class ShortObjectImmutablePair<V> implements ShortObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final short left;
    protected final V right;

    public ShortObjectImmutablePair(short left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> ShortObjectImmutablePair<V> m405of(short left, V right) {
        return new ShortObjectImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortObjectPair
    public short leftShort() {
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
